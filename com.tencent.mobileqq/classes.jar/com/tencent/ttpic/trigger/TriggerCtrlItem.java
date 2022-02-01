package com.tencent.ttpic.trigger;

import android.graphics.PointF;
import android.util.Log;
import android.util.Pair;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.HotAreaActionCounter;
import com.tencent.aekit.plugin.core.IAIDataClassifier;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.audio.AudioDataManager;
import com.tencent.ttpic.audio.MicAudioAdjustManager;
import com.tencent.ttpic.fabby.FabbyUtil;
import com.tencent.ttpic.logic.watermark.FFTData;
import com.tencent.ttpic.model.AgeRange;
import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.model.CpRange;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.GenderRange;
import com.tencent.ttpic.model.PopularRange;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.manager.TouchTriggerManager;
import com.tencent.ttpic.openapi.manager.TriggerStateManager;
import com.tencent.ttpic.openapi.model.AnimationItem;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.FaceStyleItem;
import com.tencent.ttpic.openapi.model.GLBItemJava;
import com.tencent.ttpic.openapi.model.NodeItemJava;
import com.tencent.ttpic.openapi.model.NumberRollEffectParams;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.StickerItem.ValueRange;
import com.tencent.ttpic.openapi.model.TriggerStateItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunItem;
import com.tencent.ttpic.openapi.ttpicmodule.AETriggerAnalyzer;
import com.tencent.ttpic.openapi.util.FramePositionsBean;
import com.tencent.ttpic.openapi.util.TriggerUtil;
import com.tencent.ttpic.util.StickerTriggerStatusUtil;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TriggerCtrlItem
  implements AETriggerI
{
  private static final double MAX_AUDIO_FACTOR = 0.6D;
  private static int MAX_DB_RANGE = 120;
  private static final double MIN_AUDIO_FACTOR = 0.08D;
  private static int MIN_DB_RANGE = 0;
  private static final long ONE_CLOCK_TIME_STAMP_MS = 50L;
  private static final long ONE_FRAME_TIME_STAMP_MS = 33L;
  private AgeRange ageRange;
  private AIAttr aiAttr;
  private double audioScaleFactor = 1.0D;
  private long bgmStartTime;
  private List<PointF> bodyPositionRecord;
  private int bodyPositionRecordMinNum;
  private CharmRange charmRange;
  private long clearTime;
  protected TriggerConfig config;
  private CpRange cpRange;
  protected PTDetectInfo detectInfo;
  private float fingerMusicClockTime;
  private long firstFingerTimeStamp;
  private long firstTriggerInStateTime;
  private double frameDuration;
  private int frameIndex;
  private int frameIndexElapse;
  private long frameStartTime;
  private int frames;
  private GenderRange genderRange;
  private String id;
  private long initFrameStartTime;
  private boolean isInState;
  private boolean isInited;
  private boolean isItemTriggerCountOnce;
  private boolean isSaveNoImadiateTrigger;
  private boolean lastTriggered;
  private int mRandomGroupValue;
  protected StickerItem mStickerItem;
  private String name;
  private boolean needUpateFirstStateTime;
  private int playBPM;
  protected int playCount;
  private int playMode;
  private PopularRange popularRange;
  private int renderID;
  protected TRIGGERED_STATUS status = TRIGGERED_STATUS.NOT_TRIGGERED;
  protected long triggerDurationTimestamp;
  private int triggerFingerIndex;
  private boolean triggerForceInteger;
  private int triggerMode;
  private long triggerStartTimestamp;
  private ArrayList<String> triggerState;
  public StickerItem.ValueRange triggerStateRange;
  private TriggerTimeUpdater triggerTimeUpdater;
  
  public TriggerCtrlItem()
  {
    this.bodyPositionRecordMinNum = 2;
    this.isInited = false;
    this.renderID = 0;
    this.isItemTriggerCountOnce = false;
    this.triggerMode = 0;
    this.playMode = 0;
    this.isInState = false;
    this.needUpateFirstStateTime = true;
    this.lastTriggered = false;
    this.firstFingerTimeStamp = 0L;
    this.fingerMusicClockTime = 0.5F;
    this.isSaveNoImadiateTrigger = false;
    this.bgmStartTime = 0L;
    this.clearTime = 0L;
    this.playBPM = 0;
    this.config = new TriggerConfig();
    this.bodyPositionRecord = new ArrayList();
  }
  
  public TriggerCtrlItem(FaceMeshItem paramFaceMeshItem)
  {
    this.bodyPositionRecordMinNum = 2;
    this.isInited = false;
    this.renderID = 0;
    this.isItemTriggerCountOnce = false;
    this.triggerMode = 0;
    this.playMode = 0;
    this.isInState = false;
    this.needUpateFirstStateTime = true;
    this.lastTriggered = false;
    this.firstFingerTimeStamp = 0L;
    this.fingerMusicClockTime = 0.5F;
    this.isSaveNoImadiateTrigger = false;
    this.bgmStartTime = 0L;
    this.clearTime = 0L;
    this.playBPM = 0;
    this.id = paramFaceMeshItem.id;
    this.config = new TriggerConfig(paramFaceMeshItem);
    this.charmRange = paramFaceMeshItem.charmRange;
    this.frames = paramFaceMeshItem.frames;
    this.frameDuration = paramFaceMeshItem.frameDuration;
    this.triggerState = paramFaceMeshItem.triggerState;
  }
  
  public TriggerCtrlItem(AnimationItem paramAnimationItem)
  {
    this(paramAnimationItem);
  }
  
  public TriggerCtrlItem(FaceItem paramFaceItem)
  {
    this.bodyPositionRecordMinNum = 2;
    this.isInited = false;
    this.renderID = 0;
    this.isItemTriggerCountOnce = false;
    this.triggerMode = 0;
    this.playMode = 0;
    this.isInState = false;
    this.needUpateFirstStateTime = true;
    this.lastTriggered = false;
    this.firstFingerTimeStamp = 0L;
    this.fingerMusicClockTime = 0.5F;
    this.isSaveNoImadiateTrigger = false;
    this.bgmStartTime = 0L;
    this.clearTime = 0L;
    this.playBPM = 0;
    this.id = paramFaceItem.id;
    this.config = new TriggerConfig(paramFaceItem);
    this.charmRange = paramFaceItem.charmRange;
    this.frames = paramFaceItem.frames;
    this.triggerState = paramFaceItem.triggerState;
    this.frameDuration = paramFaceItem.frameDuration;
  }
  
  public TriggerCtrlItem(FaceStyleItem paramFaceStyleItem)
  {
    this.bodyPositionRecordMinNum = 2;
    this.isInited = false;
    this.renderID = 0;
    this.isItemTriggerCountOnce = false;
    this.triggerMode = 0;
    this.playMode = 0;
    this.isInState = false;
    this.needUpateFirstStateTime = true;
    this.lastTriggered = false;
    this.firstFingerTimeStamp = 0L;
    this.fingerMusicClockTime = 0.5F;
    this.isSaveNoImadiateTrigger = false;
    this.bgmStartTime = 0L;
    this.clearTime = 0L;
    this.playBPM = 0;
    this.id = paramFaceStyleItem.id;
    this.config = new TriggerConfig(paramFaceStyleItem);
    this.triggerState = paramFaceStyleItem.triggerState;
  }
  
  public TriggerCtrlItem(GLBItemJava paramGLBItemJava)
  {
    this.bodyPositionRecordMinNum = 2;
    this.isInited = false;
    this.renderID = 0;
    this.isItemTriggerCountOnce = false;
    this.triggerMode = 0;
    this.playMode = 0;
    this.isInState = false;
    this.needUpateFirstStateTime = true;
    this.lastTriggered = false;
    this.firstFingerTimeStamp = 0L;
    this.fingerMusicClockTime = 0.5F;
    this.isSaveNoImadiateTrigger = false;
    this.bgmStartTime = 0L;
    this.clearTime = 0L;
    this.playBPM = 0;
    this.config = paramGLBItemJava.triggerConfig;
    this.triggerState = paramGLBItemJava.triggerState;
    this.charmRange = paramGLBItemJava.charmRange;
  }
  
  public TriggerCtrlItem(NodeItemJava paramNodeItemJava)
  {
    this.bodyPositionRecordMinNum = 2;
    this.isInited = false;
    this.renderID = 0;
    this.isItemTriggerCountOnce = false;
    this.triggerMode = 0;
    this.playMode = 0;
    this.isInState = false;
    this.needUpateFirstStateTime = true;
    this.lastTriggered = false;
    this.firstFingerTimeStamp = 0L;
    this.fingerMusicClockTime = 0.5F;
    this.isSaveNoImadiateTrigger = false;
    this.bgmStartTime = 0L;
    this.clearTime = 0L;
    this.playBPM = 0;
    this.id = paramNodeItemJava.modelId;
    this.config = new TriggerConfig(paramNodeItemJava);
    this.frames = paramNodeItemJava.frames;
    this.triggerState = paramNodeItemJava.triggerState;
    this.frameDuration = paramNodeItemJava.frameDuration;
    this.triggerForceInteger = true;
  }
  
  public TriggerCtrlItem(NumberRollEffectParams paramNumberRollEffectParams)
  {
    this.bodyPositionRecordMinNum = 2;
    this.isInited = false;
    this.renderID = 0;
    this.isItemTriggerCountOnce = false;
    this.triggerMode = 0;
    this.playMode = 0;
    this.isInState = false;
    this.needUpateFirstStateTime = true;
    this.lastTriggered = false;
    this.firstFingerTimeStamp = 0L;
    this.fingerMusicClockTime = 0.5F;
    this.isSaveNoImadiateTrigger = false;
    this.bgmStartTime = 0L;
    this.clearTime = 0L;
    this.playBPM = 0;
    this.id = paramNumberRollEffectParams.id;
    this.config = new TriggerConfig(paramNumberRollEffectParams);
    this.triggerState = paramNumberRollEffectParams.triggerState;
  }
  
  public TriggerCtrlItem(StickerItem paramStickerItem)
  {
    int i = 2;
    this.bodyPositionRecordMinNum = 2;
    this.isInited = false;
    this.renderID = 0;
    this.isItemTriggerCountOnce = false;
    this.triggerMode = 0;
    this.playMode = 0;
    this.isInState = false;
    this.needUpateFirstStateTime = true;
    this.lastTriggered = false;
    this.firstFingerTimeStamp = 0L;
    this.fingerMusicClockTime = 0.5F;
    this.isSaveNoImadiateTrigger = false;
    this.bgmStartTime = 0L;
    this.clearTime = 0L;
    this.playBPM = 0;
    this.id = paramStickerItem.id;
    this.name = paramStickerItem.name;
    this.config = new TriggerConfig(paramStickerItem);
    this.charmRange = paramStickerItem.charmRange;
    this.ageRange = paramStickerItem.ageRange;
    this.genderRange = paramStickerItem.genderRange;
    this.popularRange = paramStickerItem.popularRange;
    this.cpRange = paramStickerItem.cpRange;
    this.frames = paramStickerItem.frames;
    this.frameDuration = paramStickerItem.frameDuration;
    this.triggerState = paramStickerItem.triggerState;
    this.triggerMode = paramStickerItem.triggerMode;
    this.playMode = paramStickerItem.playMode;
    this.triggerFingerIndex = paramStickerItem.triggerFingerIndex;
    if (TouchTriggerManager.getInstance().getBgmClockTime() > 0.0F) {
      this.fingerMusicClockTime = (60.0F / TouchTriggerManager.getInstance().getBgmClockTime());
    }
    this.playBPM = paramStickerItem.playBPM;
    this.renderID = paramStickerItem.renderId;
    this.triggerStateRange = paramStickerItem.triggerStateRange;
    double d1 = this.config.triggerFrameStartTime;
    double d2 = this.frameDuration;
    Double.isNaN(d1);
    this.triggerStartTimestamp = ((d1 * d2));
    this.triggerTimeUpdater = paramStickerItem.triggerTimeUpdater;
    d1 = this.config.triggerFrameDurationTime;
    d2 = this.frameDuration;
    Double.isNaN(d1);
    this.triggerDurationTimestamp = ((d1 * d2));
    this.bodyPositionRecord = new ArrayList();
    if (Math.ceil(this.config.bodyTriggerTimeGap * 1000.0D / this.frameDuration) >= 1.0D) {
      i = (int)Math.ceil(this.config.bodyTriggerTimeGap * 1000.0D / this.frameDuration) + 1;
    }
    this.bodyPositionRecordMinNum = i;
    this.mStickerItem = paramStickerItem;
  }
  
  public TriggerCtrlItem(CosFun.CosFunItem paramCosFunItem)
  {
    this.bodyPositionRecordMinNum = 2;
    this.isInited = false;
    this.renderID = 0;
    this.isItemTriggerCountOnce = false;
    this.triggerMode = 0;
    this.playMode = 0;
    this.isInState = false;
    this.needUpateFirstStateTime = true;
    this.lastTriggered = false;
    this.firstFingerTimeStamp = 0L;
    this.fingerMusicClockTime = 0.5F;
    this.isSaveNoImadiateTrigger = false;
    this.bgmStartTime = 0L;
    this.clearTime = 0L;
    this.playBPM = 0;
    this.id = paramCosFunItem.getId();
    this.config = new TriggerConfig(paramCosFunItem);
  }
  
  private int calPointsAngle(PointF paramPointF1, PointF paramPointF2)
  {
    float f2 = (float)Math.toDegrees(Math.atan2(paramPointF2.y - paramPointF1.y, paramPointF2.x - paramPointF1.x));
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = f2 + 360.0F;
    }
    return (int)f1;
  }
  
  private int calPointsDistance(PointF paramPointF1, PointF paramPointF2)
  {
    return (int)Math.sqrt(Math.pow(paramPointF2.x - paramPointF1.x, 2.0D) + Math.pow(paramPointF2.y - paramPointF1.y, 2.0D));
  }
  
  private void clearDelayState()
  {
    this.isSaveNoImadiateTrigger = false;
    this.clearTime = System.currentTimeMillis();
  }
  
  private double getAudioFreqScale(FFTData paramFFTData, double paramDouble1, double paramDouble2)
  {
    double d2 = getConfigAudioFactor();
    double d1 = 0.0D;
    if (d2 == 0.0D) {
      return d2;
    }
    if ((paramFFTData != null) && (paramFFTData.mFFTSum != 0))
    {
      int j = Math.min(paramFFTData.mFFTBuffer.length, paramFFTData.mFFTSize);
      int i = (int)paramDouble1 * j / paramFFTData.mFFTFreqMax;
      int k = (int)paramDouble2 * j / paramFFTData.mFFTFreqMax;
      paramDouble1 = d1;
      while ((i <= k) && (i < j))
      {
        paramDouble2 = paramFFTData.mFFTBuffer[i];
        Double.isNaN(paramDouble2);
        paramDouble1 += paramDouble2;
        i += 1;
      }
      paramDouble2 = paramFFTData.mFFTSum;
      Double.isNaN(paramDouble2);
      return getAudioValidScale(paramDouble1 / paramDouble2 * d2);
    }
    return 0.08D;
  }
  
  private double getAudioScale(int paramInt)
  {
    return FabbyUtil.getRangeValue(0, paramInt, this.config.audioScaleFactorMap, 1.0D);
  }
  
  private double getAudioValidScale(double paramDouble)
  {
    if (paramDouble < 0.08D) {
      return paramDouble + 0.08D;
    }
    if (paramDouble > 0.6D) {
      return 0.6D;
    }
    return paramDouble;
  }
  
  private double getConfigAudioFactor()
  {
    int i = 0;
    while (i < this.config.audioScaleFactorMap.size())
    {
      if (((Float)((Pair)this.config.audioScaleFactorMap.get(i)).first).floatValue() == 0.0F) {
        return ((Double)((Pair)this.config.audioScaleFactorMap.get(i)).second).doubleValue();
      }
      i += 1;
    }
    return 0.08D;
  }
  
  private boolean hitExternalTriggerWords(AIAttr paramAIAttr)
  {
    if (paramAIAttr == null) {
      return false;
    }
    paramAIAttr = (List)paramAIAttr.getRealtimeData(AEDetectorType.VOICE_RECOGNIZE.value);
    if ((paramAIAttr != null) && (paramAIAttr.contains(this.config.externalTriggerWords)))
    {
      paramAIAttr = new StringBuilder();
      paramAIAttr.append(AEDetectorType.VOICE_RECOGNIZE);
      paramAIAttr.append(this.config.externalTriggerWords);
      AIActionCounter.updateAction(paramAIAttr.toString());
      return true;
    }
    return false;
  }
  
  private boolean inClockTime()
  {
    float f = this.fingerMusicClockTime;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (f > 0.0F)
    {
      bool1 = bool2;
      if ((float)(System.currentTimeMillis() - this.bgmStartTime) % (this.fingerMusicClockTime * 1000.0F) < 50.0F) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isAudioTriggered()
  {
    if (this.config.audioTriggerType == 0) {
      return true;
    }
    if (this.config.audioTriggerType == 2)
    {
      FFTData localFFTData = AudioDataManager.getInstance().getFFTResult();
      if (localFFTData == null) {
        return true;
      }
      this.audioScaleFactor = getAudioFreqScale(localFFTData, this.config.audioValueRange.min, this.config.audioValueRange.max);
      return true;
    }
    int j = AudioDataManager.getInstance().getDecibel();
    int i = j;
    if (this.config.audioNeedAdjust)
    {
      i = j;
      if (!AudioDataManager.getInstance().isUsePcmDecibel()) {
        i = MicAudioAdjustManager.getInstance().adjustDecibel(j);
      }
    }
    j = MIN_DB_RANGE;
    if (i < j)
    {
      i = j;
    }
    else
    {
      j = MAX_DB_RANGE;
      if (i > j) {
        i = j;
      }
    }
    this.audioScaleFactor = getAudioScale(i);
    return isInRange(i, this.config.audioValueRange.min, this.config.audioValueRange.max);
  }
  
  private boolean isInRange(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return (paramDouble1 >= paramDouble2) && (paramDouble1 <= paramDouble3);
  }
  
  private boolean isNormalTriggered(PTDetectInfo paramPTDetectInfo)
  {
    Set localSet = paramPTDetectInfo.triggeredExpression;
    Map localMap1 = paramPTDetectInfo.faceActionCounter;
    Map localMap2 = paramPTDetectInfo.handActionCounter;
    List localList = paramPTDetectInfo.bodyPoints;
    Object localObject1 = paramPTDetectInfo.aiAttr;
    Object localObject3 = null;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = (PTHandAttr)paramPTDetectInfo.aiAttr.getAvailableData(AEDetectorType.HAND.value);
    } else {
      localObject1 = null;
    }
    this.isInState = false;
    ArrayList localArrayList = this.triggerState;
    if ((localArrayList != null) && (localArrayList.size() > 0) && (this.triggerMode == 0))
    {
      this.isInState = isStateTriggered(paramPTDetectInfo);
      return this.isInState;
    }
    int j;
    int i;
    int k;
    if (this.config.activateTriggerTotalCount != 0)
    {
      if ((this.config.preTriggerType != PTFaceAttr.PTExpression.ALWAYS.value) && (!VideoMaterial.isFaceTriggerType(this.config.preTriggerType)) && (!VideoMaterial.isCatTriggerType(this.config.preTriggerType)))
      {
        if (VideoMaterial.isExternalWordsTriggerType(this.config.getTriggerTypeInt()))
        {
          bool1 = hitExternalTriggerWords(paramPTDetectInfo.aiAttr);
        }
        else if (paramPTDetectInfo.isFreezeInfo)
        {
          if (paramPTDetectInfo.gestureTrigger == this.config.preTriggerType) {
            bool1 = true;
          } else {
            bool1 = false;
          }
        }
        else
        {
          j = this.config.preTriggerType;
          if (this.config.getStickerItem() != null) {
            i = this.config.getStickerItem().triggerHandPoint;
          } else {
            i = 0;
          }
          k = this.triggerFingerIndex;
          if (this.config.getStickerItem() != null) {
            localObject2 = this.config.getStickerItem().triggerArea;
          }
          bool1 = TriggerUtil.isGestureTriggered((PTHandAttr)localObject1, j, i, k, (ArrayList)localObject2, paramPTDetectInfo.aiAttr);
        }
      }
      else {
        bool1 = localSet.contains(Integer.valueOf(this.config.preTriggerType));
      }
      if ((localObject1 == null) || (((PTHandAttr)localObject1).getHandType() != this.config.countTriggerType)) {
        AIActionCounter.clearAction(AEDetectorType.HAND);
      }
      if (!bool1) {
        break label1642;
      }
      bool1 = VideoMaterial.isFaceTriggerType(this.config.countTriggerType);
      bool2 = VideoMaterial.isHotAreaTriggerItem(this.config.getStickerItem());
      boolean bool3 = VideoMaterial.isExternalWordsTriggerType(this.config.countTriggerType);
      boolean bool4 = VideoMaterial.isTouchTriggerType(this.config.countTriggerType);
      if (localMap1 == null) {
        return false;
      }
      if (bool1)
      {
        if ((localMap1 == null) || (!localMap1.containsKey(Integer.valueOf(this.config.countTriggerType)))) {
          return false;
        }
      }
      else if (bool3)
      {
        if (AIActionCounter.getCommonActions(AEDetectorType.VOICE_RECOGNIZE).size() == 0) {
          return false;
        }
      }
      else if (!bool4)
      {
        if (localMap2 == null) {
          break label822;
        }
        if (!localMap2.containsKey(Integer.valueOf(this.config.countTriggerType))) {
          return false;
        }
      }
      if (bool1)
      {
        localObject2 = (FaceActionCounter)localMap1.get(Integer.valueOf(this.config.countTriggerType));
        if (localObject2 != null)
        {
          i = ((FaceActionCounter)localObject2).count;
          break label659;
        }
      }
      else
      {
        if (bool2)
        {
          i = HotAreaActionCounter.getCount();
          break label659;
        }
        if (bool3)
        {
          localObject2 = AIActionCounter.getCommonActions(AEDetectorType.VOICE_RECOGNIZE);
          if (((Map)localObject2).containsKey(this.config.countExternalTriggerWords))
          {
            i = ((Integer)((Map)localObject2).get(this.config.countExternalTriggerWords)).intValue();
            break label659;
          }
        }
        else
        {
          if (bool4)
          {
            i = TouchTriggerManager.getInstance().getTouchCount();
            break label659;
          }
          localObject2 = (Integer)localMap2.get(Integer.valueOf(this.config.countTriggerType));
          if (localObject2 != null)
          {
            i = ((Integer)localObject2).intValue();
            break label659;
          }
        }
      }
      i = 0;
      label659:
      if (i % this.config.activateTriggerTotalCount != this.config.activateTriggerCount) {
        break label1642;
      }
      if (bool2)
      {
        j = this.config.preTriggerType;
        if (this.config.getStickerItem() != null) {
          i = this.config.getStickerItem().triggerHandPoint;
        } else {
          i = 0;
        }
        bool2 = TriggerUtil.isGestureTriggered((PTHandAttr)localObject1, j, i, this.triggerFingerIndex, this.config.getStickerItem().triggerArea, paramPTDetectInfo.aiAttr);
        bool1 = bool2;
        if (this.config.activateTriggerCountOnce != 1) {
          break label1645;
        }
        bool1 = bool2;
        if (this.isItemTriggerCountOnce) {
          break label1645;
        }
        HotAreaActionCounter.updateCount();
        this.isItemTriggerCountOnce = true;
        bool1 = bool2;
        break label1645;
      }
      if ((this.config.playCount != 0) && (this.playCount >= this.config.playCount))
      {
        if (this.config.lockTriggerCountUntilFail == 0) {
          break label1642;
        }
        break label997;
        label822:
        return false;
      }
    }
    else if ((!this.triggerForceInteger) && (!this.config.isTypeInteger()))
    {
      if (VideoMaterial.isCatTriggerType(this.config.getTriggerTypeInt()))
      {
        bool1 = localSet.contains(Integer.valueOf(this.config.getTriggerTypeInt()));
        break label1645;
      }
      if (this.config.getTriggerTypeString() == null) {
        break label1642;
      }
      localObject1 = this.config.getTriggerTypeString().split("-");
      if (localObject1.length != 2) {
        break label1642;
      }
      localObject2 = localObject1[0];
    }
    try
    {
      i = Integer.parseInt(localObject1[1]);
      localObject1 = AETriggerAnalyzer.getInstance().getClassifier((String)localObject2);
      if (localObject1 != null)
      {
        j = ((IAIDataClassifier)localObject1).classifyData2Type(paramPTDetectInfo.aiAttr);
        bool1 = ((IAIDataClassifier)localObject1).getClassifierTypeMap().containsValue(Integer.valueOf(j));
        if ((bool1) && (i == j))
        {
          break label997;
          if (this.config.getTriggerTypeInt() == PTFaceAttr.PTExpression.ALWAYS.value) {}
          for (;;)
          {
            label997:
            bool1 = true;
            break label1645;
            if (VideoMaterial.isFaceTriggerType(this.config.getTriggerTypeInt()))
            {
              if (localSet == null) {
                break label1642;
              }
              bool1 = localSet.contains(Integer.valueOf(this.config.getTriggerTypeInt()));
              break label1645;
            }
            if (VideoMaterial.isGestureTriggerType(this.config.getTriggerTypeInt()))
            {
              if (paramPTDetectInfo.isFreezeInfo)
              {
                if (paramPTDetectInfo.gestureTrigger != this.config.getTriggerTypeInt()) {
                  break label1642;
                }
              }
              else
              {
                j = this.config.getTriggerTypeInt();
                if (this.config.getStickerItem() != null) {
                  i = this.config.getStickerItem().triggerHandPoint;
                } else {
                  i = 0;
                }
                k = this.triggerFingerIndex;
                localObject2 = localObject3;
                if (this.config.getStickerItem() != null) {
                  localObject2 = this.config.getStickerItem().triggerArea;
                }
                bool1 = TriggerUtil.isGestureTriggered((PTHandAttr)localObject1, j, i, k, (ArrayList)localObject2, paramPTDetectInfo.aiAttr);
                break label1645;
              }
            }
            else
            {
              if (VideoMaterial.isAudioTextTriggerType(this.config.getTriggerTypeInt())) {
                break label1642;
              }
              if (VideoMaterial.isAllFreezeFrameTriggerType(this.config.getTriggerTypeInt()))
              {
                bool1 = localSet.contains(Integer.valueOf(this.config.getTriggerTypeInt()));
                break label1645;
              }
              if (VideoMaterial.isTouchTriggerType(this.config.getTriggerTypeInt()))
              {
                if (this.config.triggerArea != null)
                {
                  localObject1 = TouchTriggerManager.getInstance().getCurTouchPosition();
                  bool2 = TriggerUtil.isTouchAreaTriggered(this.config.triggerArea, (PointF)localObject1);
                }
                else
                {
                  bool2 = localSet.contains(Integer.valueOf(this.config.getTriggerTypeInt()));
                }
                localObject1 = this.mStickerItem;
                bool1 = bool2;
                if (localObject1 == null) {
                  break label1645;
                }
                bool1 = bool2;
                if (((StickerItem)localObject1).stickerType != VideoFilterFactory.STICKER_TYPE.WATERMARK.type) {
                  break label1645;
                }
                if (bool2)
                {
                  Log.i("TriggerCtrlItem", "water mark is clicked, TouchTriggered");
                  bool1 = bool2;
                  break label1645;
                }
              }
              else if (VideoMaterial.isBodyDetectType(this.config.getTriggerTypeInt()))
              {
                if ((localList == null) || (localList.isEmpty())) {
                  break label1642;
                }
              }
              else
              {
                if (!VideoMaterial.isBodyTriggerType(this.config.getTriggerTypeInt())) {
                  break;
                }
                if ((localList == null) || (localList.isEmpty())) {
                  break label1642;
                }
                if (this.bodyPositionRecord.size() == this.bodyPositionRecordMinNum) {
                  this.bodyPositionRecord.remove(0);
                }
                this.bodyPositionRecord.add(localList.get(this.config.bodyTriggerPoint));
                if (this.bodyPositionRecord.size() <= 1) {
                  break label1642;
                }
                localObject1 = (PointF)localList.get(this.config.bodyTriggerPoint);
                localObject2 = (PointF)this.bodyPositionRecord.get(0);
                i = calPointsDistance((PointF)localObject2, (PointF)localObject1);
                j = calPointsAngle((PointF)localObject2, (PointF)localObject1);
                if (i < this.config.bodyTriggerDistance) {
                  break label1642;
                }
                i = Math.abs(j - this.config.getBodyTriggerAngle());
                this.config.getClass();
                if (i > 15) {
                  break label1642;
                }
              }
            }
          }
          if (VideoMaterial.isCatTriggerType(this.config.getTriggerTypeInt())) {
            bool1 = localSet.contains(Integer.valueOf(this.config.getTriggerTypeInt()));
          } else if (VideoMaterial.isExternalWordsTriggerType(this.config.getTriggerTypeInt())) {
            bool1 = hitExternalTriggerWords(paramPTDetectInfo.aiAttr);
          } else if (VideoMaterial.isTimeTriggerType(this.config.getTriggerTypeInt())) {
            bool1 = isTimeTriggered(paramPTDetectInfo);
          }
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label1642:
      break label1642;
    }
    boolean bool1 = false;
    label1645:
    localObject1 = this.triggerState;
    boolean bool2 = bool1;
    if (localObject1 != null)
    {
      bool2 = bool1;
      if (((ArrayList)localObject1).size() > 0)
      {
        bool2 = bool1;
        if (this.triggerMode == 1)
        {
          this.isInState = isStateTriggered(paramPTDetectInfo);
          if ((bool1) && (this.isInState)) {
            bool2 = true;
          } else {
            bool2 = false;
          }
        }
      }
    }
    if (!this.isInState) {
      this.needUpateFirstStateTime = true;
    }
    return bool2;
  }
  
  private boolean isRandomGroupValueHit()
  {
    if (this.config.randomGroupNum == 0) {
      return true;
    }
    return this.mRandomGroupValue == this.config.randomGroupNum;
  }
  
  private boolean isRangeValueHit()
  {
    Object localObject = this.charmRange;
    if ((localObject == null) || (((CharmRange)localObject).isHit()))
    {
      localObject = this.ageRange;
      if ((localObject == null) || (((AgeRange)localObject).isHit()))
      {
        localObject = this.genderRange;
        if ((localObject == null) || (((GenderRange)localObject).isHit()))
        {
          localObject = this.popularRange;
          if ((localObject == null) || (((PopularRange)localObject).isHit())) {
            localObject = this.cpRange;
          }
        }
      }
    }
    return (localObject == null) || (((CpRange)localObject).isHit());
  }
  
  private boolean isStateTriggered(PTDetectInfo paramPTDetectInfo)
  {
    Object localObject = paramPTDetectInfo.bodyPoints;
    paramPTDetectInfo = TriggerStateManager.getInstance().getTriggerStateItem(this.renderID);
    if (paramPTDetectInfo != null)
    {
      boolean bool1 = paramPTDetectInfo.isTriggerState(this.triggerState);
      boolean bool2 = bool1;
      if (bool1)
      {
        int i = paramPTDetectInfo.getTriggetType();
        if ((!VideoMaterial.isAudioTextTriggerType(i)) && (VideoMaterial.isBodyTriggerType(i)))
        {
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            if (this.bodyPositionRecord.size() == this.bodyPositionRecordMinNum) {
              this.bodyPositionRecord.remove(0);
            }
            this.bodyPositionRecord.add(((List)localObject).get(this.config.bodyTriggerPoint));
            if (this.bodyPositionRecord.size() > 1)
            {
              localObject = (PointF)((List)localObject).get(this.config.bodyTriggerPoint);
              PointF localPointF = (PointF)this.bodyPositionRecord.get(0);
              i = calPointsDistance(localPointF, (PointF)localObject);
              int j = calPointsAngle(localPointF, (PointF)localObject);
              if (i >= this.config.bodyTriggerDistance)
              {
                i = Math.abs(j - this.config.getBodyTriggerAngle());
                this.config.getClass();
                if (i <= 15)
                {
                  bool1 = true;
                  break label249;
                }
              }
            }
          }
          bool1 = false;
        }
        label249:
        bool2 = bool1;
        if (bool1)
        {
          localObject = this.triggerStateRange;
          bool2 = bool1;
          if (localObject != null)
          {
            bool2 = bool1;
            if (((StickerItem.ValueRange)localObject).min < this.triggerStateRange.max)
            {
              double d = paramPTDetectInfo.getRandomValue();
              if ((d >= this.triggerStateRange.min) && (d < this.triggerStateRange.max)) {
                return true;
              }
              bool2 = false;
            }
          }
        }
      }
      return bool2;
    }
    return false;
  }
  
  private boolean needDelayInClockTime(boolean paramBoolean)
  {
    if (this.fingerMusicClockTime > 0.0F)
    {
      boolean bool = this.isSaveNoImadiateTrigger;
      if (bool) {
        return bool;
      }
      if ((paramBoolean) && (!this.lastTriggered))
      {
        this.isSaveNoImadiateTrigger = true;
        if (inClockTime()) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean updateTriggeredStatus(PTDetectInfo paramPTDetectInfo)
  {
    boolean bool1 = isNormalTriggered(paramPTDetectInfo);
    boolean bool2 = true;
    int i;
    if ((bool1) && (isRangeValueHit()) && (isRandomGroupValueHit()) && (isAudioTriggered())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (!this.config.renderForBitmap)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (isTimeTriggered(paramPTDetectInfo)) {
      bool1 = true;
    }
    if ((bool1) && (!this.lastTriggered) && (this.playBPM > 0))
    {
      TouchTriggerManager.getInstance().setBgmTriggerTime(System.currentTimeMillis());
      TouchTriggerManager.getInstance().setBgmClockTime(this.playBPM);
    }
    if ((this.config.getTriggerTypeInt() == 220) && (!this.config.alwaysTriggered) && (this.playMode == 0))
    {
      if (TouchTriggerManager.getInstance().getBgmClockTime() > 0.0F) {
        this.fingerMusicClockTime = (60.0F / TouchTriggerManager.getInstance().getBgmClockTime());
      }
      if (this.fingerMusicClockTime > 0.0F)
      {
        this.bgmStartTime = TouchTriggerManager.getInstance().getBgmTriggerTime();
        if ((needDelayInClockTime(bool1)) && (inClockTime()) && (System.currentTimeMillis() - this.clearTime > 33L))
        {
          this.frameStartTime = paramPTDetectInfo.timestamp;
          this.status = TRIGGERED_STATUS.FIRST_TRIGGERED;
          this.firstFingerTimeStamp = System.currentTimeMillis();
          this.playCount = 0;
          clearDelayState();
        }
        else if ((!this.config.alwaysTriggered) && (this.playCount < this.config.playCount) && (this.isInState))
        {
          if ((this.status == TRIGGERED_STATUS.FIRST_TRIGGERED) && (System.currentTimeMillis() - this.firstFingerTimeStamp > 33L)) {
            this.status = TRIGGERED_STATUS.TRIGGERED;
          }
        }
        else
        {
          this.status = TRIGGERED_STATUS.NOT_TRIGGERED;
        }
      }
      else if ((bool1) && (!this.lastTriggered) && (System.currentTimeMillis() - this.clearTime > 33L))
      {
        this.frameStartTime = paramPTDetectInfo.timestamp;
        this.status = TRIGGERED_STATUS.FIRST_TRIGGERED;
        this.firstFingerTimeStamp = System.currentTimeMillis();
        this.playCount = 0;
      }
      else if ((!this.config.alwaysTriggered) && (this.playCount < this.config.playCount) && (this.isInState))
      {
        if ((this.status == TRIGGERED_STATUS.FIRST_TRIGGERED) && (System.currentTimeMillis() - this.firstFingerTimeStamp > 33L)) {
          this.status = TRIGGERED_STATUS.TRIGGERED;
        }
      }
      else
      {
        this.status = TRIGGERED_STATUS.NOT_TRIGGERED;
      }
    }
    else if (bool1)
    {
      if (this.status == TRIGGERED_STATUS.NOT_TRIGGERED)
      {
        this.frameStartTime = paramPTDetectInfo.timestamp;
        this.status = TRIGGERED_STATUS.FIRST_TRIGGERED;
        if ((this.needUpateFirstStateTime) && (this.triggerMode == 1) && (this.isInState))
        {
          this.firstTriggerInStateTime = paramPTDetectInfo.timestamp;
          this.needUpateFirstStateTime = false;
        }
      }
      else
      {
        this.status = TRIGGERED_STATUS.TRIGGERED;
      }
    }
    else if ((!this.config.alwaysTriggered) && (this.playCount < this.config.playCount))
    {
      if ((this.status == TRIGGERED_STATUS.FIRST_TRIGGERED) && (System.currentTimeMillis() - this.frameStartTime > 33L)) {
        this.status = TRIGGERED_STATUS.TRIGGERED;
      }
    }
    else
    {
      this.status = TRIGGERED_STATUS.NOT_TRIGGERED;
    }
    updateTriggerTime(paramPTDetectInfo.timestamp, isTriggered());
    if (!isTriggered()) {
      this.playCount = 0;
    }
    if ((this.config.getTriggerTypeInt() == 220) && (!this.config.alwaysTriggered) && (this.playMode == 0))
    {
      if ((!bool1) || (this.lastTriggered)) {
        bool2 = false;
      }
    }
    else {
      bool2 = bool1;
    }
    this.lastTriggered = bool1;
    return bool2;
  }
  
  public void clear() {}
  
  public double getAudioScaleFactor()
  {
    return this.audioScaleFactor;
  }
  
  public long getFirstTriggerInStateTime()
  {
    return this.firstTriggerInStateTime;
  }
  
  public int getFrameIndex()
  {
    return this.frameIndex;
  }
  
  public int getFrameIndexElapse()
  {
    return this.frameIndexElapse;
  }
  
  public int getFrameIndexElapse(long paramLong1, long paramLong2)
  {
    double d1 = paramLong1 + paramLong2 / 1000000L - this.frameStartTime;
    double d2 = Math.max(this.frameDuration, 1.0D);
    Double.isNaN(d1);
    return (int)(d1 / d2) % Math.max(this.frames, 1);
  }
  
  public long getFrameStartTime()
  {
    return this.frameStartTime;
  }
  
  public ArrayList<RedPacketPosition> getHotArea()
  {
    Object localObject;
    int i;
    if (isTriggered())
    {
      localObject = this.config;
      if ((localObject != null) && (((TriggerConfig)localObject).hotArea != null) && (this.config.hotArea.length > 0) && (getFrameIndex() >= this.config.hotAreaStartFrame) && (getFrameIndex() <= this.config.hotAreaEndFrame))
      {
        int j = this.config.hotArea.length / 4;
        localObject = new ArrayList();
        i = 0;
        while (i < j)
        {
          RedPacketPosition localRedPacketPosition = new RedPacketPosition();
          double[] arrayOfDouble = this.config.hotArea;
          int k = i * 4;
          localRedPacketPosition.x = arrayOfDouble[k];
          localRedPacketPosition.y = this.config.hotArea[(k + 1)];
          localRedPacketPosition.width = this.config.hotArea[(k + 2)];
          localRedPacketPosition.height = this.config.hotArea[(k + 3)];
          ((ArrayList)localObject).add(localRedPacketPosition);
          i += 1;
        }
        return localObject;
      }
    }
    if (isTriggered())
    {
      localObject = this.config;
      if ((localObject != null) && (((TriggerConfig)localObject).hotArea != null)) {
        i = this.config.hotArea.length;
      }
    }
    return null;
  }
  
  public boolean getInState()
  {
    return this.isInState;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getPlayCount()
  {
    return this.playCount;
  }
  
  public int getPlayFristSync()
  {
    StickerItem localStickerItem = this.mStickerItem;
    if (localStickerItem != null) {
      return localStickerItem.playFirstSyncMode;
    }
    return 0;
  }
  
  public int getPlayMode()
  {
    return this.playMode;
  }
  
  public String getStickerItemID()
  {
    TriggerConfig localTriggerConfig = this.config;
    if (localTriggerConfig == null) {
      return null;
    }
    return localTriggerConfig.getStickerItemId();
  }
  
  public int getTotalPlayCount()
  {
    TriggerConfig localTriggerConfig = this.config;
    if (localTriggerConfig == null) {
      return 0;
    }
    return localTriggerConfig.playCount;
  }
  
  public int getTriggerMode()
  {
    return this.triggerMode;
  }
  
  public TRIGGERED_STATUS getTriggeredStatus(PTDetectInfo paramPTDetectInfo)
  {
    this.detectInfo = paramPTDetectInfo;
    updateFrameIndex(paramPTDetectInfo.timestamp);
    updateTriggeredStatus(paramPTDetectInfo);
    StickerTriggerStatusUtil.putTriggerStatus(this.config.getStickerItemId(), this.status);
    AIAttr localAIAttr = this.aiAttr;
    if (localAIAttr != null)
    {
      long l1 = localAIAttr.getNextSurfaceTime();
      long l2 = this.aiAttr.getSurfaceTime();
      this.frameIndexElapse = getFrameIndexElapse(paramPTDetectInfo.timestamp, l1 - l2);
    }
    return this.status;
  }
  
  public void hitCharmRange(double paramDouble)
  {
    CharmRange localCharmRange = this.charmRange;
    if (localCharmRange != null)
    {
      localCharmRange.hit(paramDouble);
      updateTriggerStatus(this.detectInfo);
    }
  }
  
  public void hitRangeGroup(int paramInt)
  {
    this.mRandomGroupValue = paramInt;
    if ((this.detectInfo != null) && (this.config.randomGroupNum != 0)) {
      updateTriggerStatus(this.detectInfo);
    }
  }
  
  public boolean isCurrentFrameTriggered(PTDetectInfo paramPTDetectInfo)
  {
    return updateTriggeredStatus(paramPTDetectInfo);
  }
  
  public boolean isFirstTriggered()
  {
    return this.status == TRIGGERED_STATUS.FIRST_TRIGGERED;
  }
  
  public boolean isRenderForBitmap()
  {
    return this.config.isRenderForBitmap();
  }
  
  public boolean isTimeTriggered(PTDetectInfo paramPTDetectInfo)
  {
    if (VideoMaterial.isTimeTriggerType(this.config.getTriggerTypeInt()))
    {
      if (!this.isInited) {
        setFrameStartTime(paramPTDetectInfo.timestamp);
      }
      if ((this.initFrameStartTime + this.triggerStartTimestamp <= paramPTDetectInfo.timestamp) && (paramPTDetectInfo.timestamp <= this.initFrameStartTime + this.triggerStartTimestamp + this.triggerDurationTimestamp)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isTriggered()
  {
    return (this.status == TRIGGERED_STATUS.FIRST_TRIGGERED) || (this.status == TRIGGERED_STATUS.TRIGGERED);
  }
  
  public void reset()
  {
    this.playCount = 0;
    this.status = TRIGGERED_STATUS.NOT_TRIGGERED;
    List localList = this.bodyPositionRecord;
    if (localList != null) {
      localList.clear();
    }
    this.isInited = false;
    this.initFrameStartTime = 0L;
    this.needUpateFirstStateTime = true;
    this.firstFingerTimeStamp = 0L;
    updateTriggerTime(-1L, false);
  }
  
  public void setAgeRangeValue(float paramFloat)
  {
    AgeRange localAgeRange = this.ageRange;
    if (localAgeRange != null) {
      localAgeRange.setValue(paramFloat);
    }
  }
  
  public void setCpRangeValue(float paramFloat)
  {
    CpRange localCpRange = this.cpRange;
    if (localCpRange != null) {
      localCpRange.setValue(paramFloat);
    }
  }
  
  public void setFrameStartTime(long paramLong)
  {
    this.frameStartTime = paramLong;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" setFrameStartTime frameStartTime = ");
    localStringBuilder.append(this.frameStartTime);
    Log.i("TriggerCtrlItem", localStringBuilder.toString());
    if (!this.isInited)
    {
      this.isInited = true;
      this.initFrameStartTime = paramLong;
    }
  }
  
  public void setGenderRangeValue(float paramFloat)
  {
    GenderRange localGenderRange = this.genderRange;
    if (localGenderRange != null) {
      localGenderRange.setValue(paramFloat);
    }
  }
  
  public void setPlayCount(int paramInt)
  {
    this.playCount = paramInt;
  }
  
  public void setPopularRangeValue(float paramFloat)
  {
    PopularRange localPopularRange = this.popularRange;
    if (localPopularRange != null) {
      localPopularRange.setValue(paramFloat);
    }
  }
  
  public void setRandomGroupValue(int paramInt)
  {
    this.mRandomGroupValue = paramInt;
  }
  
  public void setRenderForBitmap(boolean paramBoolean)
  {
    this.config.setRenderForBitmap(paramBoolean);
  }
  
  public void setTriggerWords(String paramString)
  {
    this.config.setTriggerWords(paramString);
  }
  
  public void updateFrameIndex(long paramLong)
  {
    if (!this.isInited)
    {
      this.isInited = true;
      this.initFrameStartTime = paramLong;
    }
    if (!isTriggered())
    {
      this.frameStartTime = paramLong;
      if ((this.triggerMode == 1) && (!this.isInState)) {
        this.firstTriggerInStateTime = paramLong;
      }
    }
    long l = paramLong - this.frameStartTime;
    if (this.playMode == 1) {
      l = paramLong - this.firstTriggerInStateTime;
    }
    double d1 = l;
    double d2 = Math.max(this.frameDuration, 1.0D);
    Double.isNaN(d1);
    this.frameIndex = ((int)(d1 / d2));
    int i = this.frameIndex;
    int j = this.frames;
    int k = this.playCount;
    if (i >= j * (k + 1)) {
      this.playCount = (k + 1);
    }
    this.frameIndex %= Math.max(this.frames, 1);
    StickerItem localStickerItem = this.mStickerItem;
    if ((localStickerItem != null) && (localStickerItem.framePositionsBean != null)) {
      this.mStickerItem.framePositionsBean.updateFramePosition(this.frameIndex, this.mStickerItem);
    }
  }
  
  public void updateTriggerStatus(PTDetectInfo paramPTDetectInfo)
  {
    this.detectInfo = paramPTDetectInfo;
    getTriggeredStatus(paramPTDetectInfo);
  }
  
  public void updateTriggerTime(long paramLong, boolean paramBoolean)
  {
    TriggerTimeUpdater localTriggerTimeUpdater = this.triggerTimeUpdater;
    if (localTriggerTimeUpdater != null) {
      this.triggerStartTimestamp = localTriggerTimeUpdater.updateCurTriggerTime(paramLong - this.initFrameStartTime, this.triggerStartTimestamp, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.trigger.TriggerCtrlItem
 * JD-Core Version:    0.7.0.1
 */
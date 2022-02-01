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
  private long bgmStartTime = 0L;
  private List<PointF> bodyPositionRecord;
  private int bodyPositionRecordMinNum = 2;
  private CharmRange charmRange;
  private long clearTime = 0L;
  protected TriggerConfig config;
  private CpRange cpRange;
  protected PTDetectInfo detectInfo;
  private float fingerMusicClockTime = 0.5F;
  private long firstFingerTimeStamp = 0L;
  private long firstTriggerInStateTime;
  private double frameDuration;
  private int frameIndex;
  private int frameIndexElapse;
  private long frameStartTime;
  private int frames;
  private GenderRange genderRange;
  private String id;
  private long initFrameStartTime;
  private boolean isInState = false;
  private boolean isInited = false;
  private boolean isItemTriggerCountOnce = false;
  private boolean isSaveNoImadiateTrigger = false;
  private boolean lastTriggered = false;
  private int mRandomGroupValue;
  protected StickerItem mStickerItem;
  private String name;
  private boolean needUpateFirstStateTime = true;
  private int playBPM = 0;
  protected int playCount;
  private int playMode = 0;
  private PopularRange popularRange;
  private int renderID = 0;
  protected TRIGGERED_STATUS status = TRIGGERED_STATUS.NOT_TRIGGERED;
  protected long triggerDurationTimestamp;
  private int triggerFingerIndex;
  private boolean triggerForceInteger;
  private int triggerMode = 0;
  private long triggerStartTimestamp;
  private ArrayList<String> triggerState;
  public StickerItem.ValueRange triggerStateRange;
  private TriggerTimeUpdater triggerTimeUpdater;
  
  public TriggerCtrlItem()
  {
    this.config = new TriggerConfig();
    this.bodyPositionRecord = new ArrayList();
  }
  
  public TriggerCtrlItem(FaceMeshItem paramFaceMeshItem)
  {
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
    this.id = paramFaceItem.id;
    this.config = new TriggerConfig(paramFaceItem);
    this.charmRange = paramFaceItem.charmRange;
    this.frames = paramFaceItem.frames;
    this.triggerState = paramFaceItem.triggerState;
    this.frameDuration = paramFaceItem.frameDuration;
  }
  
  public TriggerCtrlItem(FaceStyleItem paramFaceStyleItem)
  {
    this.id = paramFaceStyleItem.id;
    this.config = new TriggerConfig(paramFaceStyleItem);
    this.triggerState = paramFaceStyleItem.triggerState;
  }
  
  public TriggerCtrlItem(GLBItemJava paramGLBItemJava)
  {
    this.config = paramGLBItemJava.triggerConfig;
    this.triggerState = paramGLBItemJava.triggerState;
    this.charmRange = paramGLBItemJava.charmRange;
  }
  
  public TriggerCtrlItem(NodeItemJava paramNodeItemJava)
  {
    this.id = paramNodeItemJava.modelId;
    this.config = new TriggerConfig(paramNodeItemJava);
    this.frames = paramNodeItemJava.frames;
    this.triggerState = paramNodeItemJava.triggerState;
    this.frameDuration = paramNodeItemJava.frameDuration;
    this.triggerForceInteger = true;
  }
  
  public TriggerCtrlItem(NumberRollEffectParams paramNumberRollEffectParams)
  {
    this.id = paramNumberRollEffectParams.id;
    this.config = new TriggerConfig(paramNumberRollEffectParams);
    this.triggerState = paramNumberRollEffectParams.triggerState;
  }
  
  public TriggerCtrlItem(StickerItem paramStickerItem)
  {
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
    this.triggerStartTimestamp = ((this.config.triggerFrameStartTime * this.frameDuration));
    this.triggerTimeUpdater = paramStickerItem.triggerTimeUpdater;
    this.triggerDurationTimestamp = ((this.config.triggerFrameDurationTime * this.frameDuration));
    this.bodyPositionRecord = new ArrayList();
    if (Math.ceil(this.config.bodyTriggerTimeGap * 1000.0D / this.frameDuration) >= 1.0D) {
      i = (int)Math.ceil(this.config.bodyTriggerTimeGap * 1000.0D / this.frameDuration) + 1;
    }
    this.bodyPositionRecordMinNum = i;
    this.mStickerItem = paramStickerItem;
  }
  
  public TriggerCtrlItem(CosFun.CosFunItem paramCosFunItem)
  {
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
    double d1 = 0.0D;
    double d2 = getConfigAudioFactor();
    if (d2 == 0.0D) {
      return d2;
    }
    if ((paramFFTData == null) || (paramFFTData.mFFTSum == 0)) {
      return 0.08D;
    }
    int j = Math.min(paramFFTData.mFFTBuffer.length, paramFFTData.mFFTSize);
    int i = (int)paramDouble1 * j / paramFFTData.mFFTFreqMax;
    int k = (int)paramDouble2 * j / paramFFTData.mFFTFreqMax;
    paramDouble1 = d1;
    while ((i <= k) && (i < j))
    {
      paramDouble1 += paramFFTData.mFFTBuffer[i];
      i += 1;
    }
    return getAudioValidScale(d2 * (paramDouble1 / paramFFTData.mFFTSum));
  }
  
  private double getAudioScale(int paramInt)
  {
    return FabbyUtil.getRangeValue(0, paramInt, this.config.audioScaleFactorMap, 1.0D);
  }
  
  private double getAudioValidScale(double paramDouble)
  {
    double d;
    if (paramDouble < 0.08D) {
      d = paramDouble + 0.08D;
    }
    do
    {
      return d;
      d = paramDouble;
    } while (paramDouble <= 0.6D);
    return 0.6D;
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
      AIActionCounter.updateAction(AEDetectorType.VOICE_RECOGNIZE + this.config.externalTriggerWords);
      return true;
    }
    return false;
  }
  
  private boolean inClockTime()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.fingerMusicClockTime > 0.0F)
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
    if (i < MIN_DB_RANGE) {
      j = MIN_DB_RANGE;
    }
    for (;;)
    {
      this.audioScaleFactor = getAudioScale(j);
      return isInRange(j, this.config.audioValueRange.min, this.config.audioValueRange.max);
      j = i;
      if (i > MAX_DB_RANGE) {
        j = MAX_DB_RANGE;
      }
    }
  }
  
  private boolean isInRange(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return (paramDouble1 >= paramDouble2) && (paramDouble1 <= paramDouble3);
  }
  
  private boolean isNormalTriggered(PTDetectInfo paramPTDetectInfo)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    Set localSet = paramPTDetectInfo.triggeredExpression;
    Map localMap1 = paramPTDetectInfo.faceActionCounter;
    Map localMap2 = paramPTDetectInfo.handActionCounter;
    List localList = paramPTDetectInfo.bodyPoints;
    if (paramPTDetectInfo.aiAttr != null) {}
    label179:
    label343:
    label1768:
    label1774:
    Object localObject2;
    for (Object localObject1 = (PTHandAttr)paramPTDetectInfo.aiAttr.getAvailableData(AEDetectorType.HAND.value);; localObject2 = null)
    {
      this.isInState = false;
      boolean bool1;
      if ((this.triggerState != null) && (this.triggerState.size() > 0) && (this.triggerMode == 0))
      {
        this.isInState = isStateTriggered(paramPTDetectInfo);
        bool1 = this.isInState;
      }
      boolean bool4;
      boolean bool5;
      boolean bool6;
      boolean bool7;
      do
      {
        do
        {
          do
          {
            return bool1;
            if (this.config.activateTriggerTotalCount == 0) {
              break label911;
            }
            if ((this.config.preTriggerType != PTFaceAttr.PTExpression.ALWAYS.value) && (!VideoMaterial.isFaceTriggerType(this.config.preTriggerType)) && (!VideoMaterial.isCatTriggerType(this.config.preTriggerType))) {
              break;
            }
            bool1 = localSet.contains(Integer.valueOf(this.config.preTriggerType));
            if ((localObject1 == null) || (((PTHandAttr)localObject1).getHandType() != this.config.countTriggerType)) {
              AIActionCounter.clearAction(AEDetectorType.HAND);
            }
            if (!bool1) {
              break label1768;
            }
            bool4 = VideoMaterial.isFaceTriggerType(this.config.countTriggerType);
            bool5 = VideoMaterial.isHotAreaTriggerItem(this.config.getStickerItem());
            bool6 = VideoMaterial.isExternalWordsTriggerType(this.config.countTriggerType);
            bool7 = VideoMaterial.isTouchTriggerType(this.config.countTriggerType);
            bool1 = bool2;
          } while (localMap1 == null);
          if (!bool4) {
            break label686;
          }
          bool1 = bool2;
        } while (localMap1 == null);
        bool1 = bool2;
      } while (!localMap1.containsKey(Integer.valueOf(this.config.countTriggerType)));
      label305:
      int i;
      if (bool4)
      {
        localObject3 = (FaceActionCounter)localMap1.get(Integer.valueOf(this.config.countTriggerType));
        if (localObject3 == null) {
          break label1774;
        }
        i = ((FaceActionCounter)localObject3).count;
      }
      for (;;)
      {
        int j;
        if (i % this.config.activateTriggerTotalCount == this.config.activateTriggerCount) {
          if (bool5)
          {
            j = this.config.preTriggerType;
            if (this.config.getStickerItem() != null)
            {
              i = this.config.getStickerItem().triggerHandPoint;
              label396:
              bool2 = TriggerUtil.isGestureTriggered((PTHandAttr)localObject1, j, i, this.triggerFingerIndex, this.config.getStickerItem().triggerArea, paramPTDetectInfo.aiAttr);
              bool1 = bool2;
              if (this.config.activateTriggerCountOnce == 1)
              {
                bool1 = bool2;
                if (!this.isItemTriggerCountOnce)
                {
                  HotAreaActionCounter.updateCount();
                  this.isItemTriggerCountOnce = true;
                  bool1 = bool2;
                }
              }
            }
          }
        }
        for (;;)
        {
          bool2 = bool1;
          if (this.triggerState != null)
          {
            bool2 = bool1;
            if (this.triggerState.size() > 0)
            {
              bool2 = bool1;
              if (this.triggerMode == 1)
              {
                this.isInState = isStateTriggered(paramPTDetectInfo);
                bool2 = bool3;
                if (bool1)
                {
                  bool2 = bool3;
                  if (this.isInState) {
                    bool2 = true;
                  }
                }
              }
            }
          }
          if (!this.isInState) {
            this.needUpateFirstStateTime = true;
          }
          return bool2;
          if (VideoMaterial.isExternalWordsTriggerType(this.config.getTriggerTypeInt()))
          {
            bool1 = hitExternalTriggerWords(paramPTDetectInfo.aiAttr);
            break label179;
          }
          if (paramPTDetectInfo.isFreezeInfo)
          {
            if (paramPTDetectInfo.gestureTrigger == this.config.preTriggerType)
            {
              bool1 = true;
              break label179;
            }
            bool1 = false;
            break label179;
          }
          j = this.config.preTriggerType;
          if (this.config.getStickerItem() != null) {}
          int k;
          for (i = this.config.getStickerItem().triggerHandPoint;; i = 0)
          {
            k = this.triggerFingerIndex;
            if (this.config.getStickerItem() != null) {
              localObject3 = this.config.getStickerItem().triggerArea;
            }
            bool1 = TriggerUtil.isGestureTriggered((PTHandAttr)localObject1, j, i, k, (ArrayList)localObject3, paramPTDetectInfo.aiAttr);
            break;
          }
          label686:
          if (bool6)
          {
            if (AIActionCounter.getCommonActions(AEDetectorType.VOICE_RECOGNIZE).size() != 0) {
              break label305;
            }
            return false;
          }
          if (bool7) {
            break label305;
          }
          bool1 = bool2;
          if (localMap2 == null) {
            break;
          }
          if (localMap2.containsKey(Integer.valueOf(this.config.countTriggerType))) {
            break label305;
          }
          return false;
          if (bool5)
          {
            i = HotAreaActionCounter.getCount();
            break label343;
          }
          if (bool6)
          {
            localObject3 = AIActionCounter.getCommonActions(AEDetectorType.VOICE_RECOGNIZE);
            if (!((Map)localObject3).containsKey(this.config.countExternalTriggerWords)) {
              break label1774;
            }
            i = ((Integer)((Map)localObject3).get(this.config.countExternalTriggerWords)).intValue();
            break label343;
          }
          if (bool7)
          {
            i = TouchTriggerManager.getInstance().getTouchCount();
            break label343;
          }
          localObject3 = (Integer)localMap2.get(Integer.valueOf(this.config.countTriggerType));
          if (localObject3 == null) {
            break label1774;
          }
          i = ((Integer)localObject3).intValue();
          break label343;
          i = 0;
          break label396;
          if ((this.config.playCount == 0) || (this.playCount < this.config.playCount) || (this.config.lockTriggerCountUntilFail != 0))
          {
            bool1 = true;
          }
          else
          {
            bool1 = false;
            continue;
            label911:
            if ((this.triggerForceInteger) || (this.config.isTypeInteger()))
            {
              if (this.config.getTriggerTypeInt() == PTFaceAttr.PTExpression.ALWAYS.value)
              {
                bool1 = true;
                continue;
              }
              if (VideoMaterial.isFaceTriggerType(this.config.getTriggerTypeInt()))
              {
                if (localSet != null) {
                  bool1 = localSet.contains(Integer.valueOf(this.config.getTriggerTypeInt()));
                }
              }
              else
              {
                if (VideoMaterial.isGestureTriggerType(this.config.getTriggerTypeInt()))
                {
                  if (paramPTDetectInfo.isFreezeInfo)
                  {
                    if (paramPTDetectInfo.gestureTrigger == this.config.getTriggerTypeInt())
                    {
                      bool1 = true;
                      continue;
                    }
                    bool1 = false;
                    continue;
                  }
                  j = this.config.getTriggerTypeInt();
                  if (this.config.getStickerItem() != null) {}
                  for (i = this.config.getStickerItem().triggerHandPoint;; i = 0)
                  {
                    k = this.triggerFingerIndex;
                    localObject3 = localObject4;
                    if (this.config.getStickerItem() != null) {
                      localObject3 = this.config.getStickerItem().triggerArea;
                    }
                    bool1 = TriggerUtil.isGestureTriggered((PTHandAttr)localObject1, j, i, k, (ArrayList)localObject3, paramPTDetectInfo.aiAttr);
                    break;
                  }
                }
                if (VideoMaterial.isAudioTextTriggerType(this.config.getTriggerTypeInt()))
                {
                  bool1 = false;
                  continue;
                }
                if (VideoMaterial.isAllFreezeFrameTriggerType(this.config.getTriggerTypeInt()))
                {
                  bool1 = localSet.contains(Integer.valueOf(this.config.getTriggerTypeInt()));
                  continue;
                }
                if (VideoMaterial.isTouchTriggerType(this.config.getTriggerTypeInt()))
                {
                  if (this.config.triggerArea != null) {
                    localObject1 = TouchTriggerManager.getInstance().getCurTouchPosition();
                  }
                  for (bool2 = TriggerUtil.isTouchAreaTriggered(this.config.triggerArea, (PointF)localObject1);; bool2 = localSet.contains(Integer.valueOf(this.config.getTriggerTypeInt())))
                  {
                    bool1 = bool2;
                    if (this.mStickerItem == null) {
                      break;
                    }
                    bool1 = bool2;
                    if (this.mStickerItem.stickerType != VideoFilterFactory.STICKER_TYPE.WATERMARK.type) {
                      break;
                    }
                    if (bool2) {
                      break label1285;
                    }
                    bool1 = true;
                    break;
                  }
                  Log.i("TriggerCtrlItem", "water mark is clicked, TouchTriggered");
                  bool1 = bool2;
                  continue;
                }
                if (VideoMaterial.isBodyDetectType(this.config.getTriggerTypeInt()))
                {
                  if ((localList != null) && (!localList.isEmpty()))
                  {
                    bool1 = true;
                    continue;
                  }
                  bool1 = false;
                  continue;
                }
                if (VideoMaterial.isBodyTriggerType(this.config.getTriggerTypeInt()))
                {
                  if ((localList != null) && (!localList.isEmpty()))
                  {
                    if (this.bodyPositionRecord.size() == this.bodyPositionRecordMinNum) {
                      this.bodyPositionRecord.remove(0);
                    }
                    this.bodyPositionRecord.add(localList.get(this.config.bodyTriggerPoint));
                    if (this.bodyPositionRecord.size() > 1)
                    {
                      localObject1 = (PointF)localList.get(this.config.bodyTriggerPoint);
                      localObject3 = (PointF)this.bodyPositionRecord.get(0);
                      i = calPointsDistance((PointF)localObject3, (PointF)localObject1);
                      j = calPointsAngle((PointF)localObject3, (PointF)localObject1);
                      if (i >= this.config.bodyTriggerDistance)
                      {
                        i = Math.abs(j - this.config.getBodyTriggerAngle());
                        this.config.getClass();
                        if (i <= 15) {
                          bool1 = true;
                        }
                      }
                    }
                  }
                }
                else
                {
                  if (VideoMaterial.isCatTriggerType(this.config.getTriggerTypeInt()))
                  {
                    bool1 = localSet.contains(Integer.valueOf(this.config.getTriggerTypeInt()));
                    continue;
                  }
                  if (VideoMaterial.isExternalWordsTriggerType(this.config.getTriggerTypeInt()))
                  {
                    bool1 = hitExternalTriggerWords(paramPTDetectInfo.aiAttr);
                    continue;
                  }
                  if (VideoMaterial.isTimeTriggerType(this.config.getTriggerTypeInt())) {
                    bool1 = isTimeTriggered(paramPTDetectInfo);
                  }
                }
              }
            }
            else
            {
              if (VideoMaterial.isCatTriggerType(this.config.getTriggerTypeInt()))
              {
                bool1 = localSet.contains(Integer.valueOf(this.config.getTriggerTypeInt()));
                continue;
              }
              if (this.config.getTriggerTypeString() != null)
              {
                localObject1 = this.config.getTriggerTypeString().split("-");
                if (localObject1.length == 2)
                {
                  localObject3 = localObject1[0];
                  try
                  {
                    i = Integer.parseInt(localObject1[1]);
                    localObject1 = AETriggerAnalyzer.getInstance().getClassifier((String)localObject3);
                    if (localObject1 == null) {
                      break label1768;
                    }
                    j = ((IAIDataClassifier)localObject1).classifyData2Type(paramPTDetectInfo.aiAttr);
                    bool1 = ((IAIDataClassifier)localObject1).getClassifierTypeMap().containsValue(Integer.valueOf(j));
                    if ((bool1) && (i == j))
                    {
                      bool1 = true;
                      continue;
                    }
                    bool1 = false;
                  }
                  catch (NumberFormatException localNumberFormatException)
                  {
                    bool1 = false;
                  }
                  continue;
                }
              }
            }
            label1285:
            bool1 = false;
          }
        }
        i = 0;
      }
    }
  }
  
  private boolean isRandomGroupValueHit()
  {
    if (this.config.randomGroupNum == 0) {}
    while (this.mRandomGroupValue == this.config.randomGroupNum) {
      return true;
    }
    return false;
  }
  
  private boolean isRangeValueHit()
  {
    return ((this.charmRange == null) || (this.charmRange.isHit())) && ((this.ageRange == null) || (this.ageRange.isHit())) && ((this.genderRange == null) || (this.genderRange.isHit())) && ((this.popularRange == null) || (this.popularRange.isHit())) && ((this.cpRange == null) || (this.cpRange.isHit()));
  }
  
  private boolean isStateTriggered(PTDetectInfo paramPTDetectInfo)
  {
    Object localObject = paramPTDetectInfo.bodyPoints;
    paramPTDetectInfo = TriggerStateManager.getInstance().getTriggerStateItem(this.renderID);
    boolean bool1;
    boolean bool2;
    int i;
    if (paramPTDetectInfo != null)
    {
      bool1 = paramPTDetectInfo.isTriggerState(this.triggerState);
      bool2 = bool1;
      if (bool1)
      {
        i = paramPTDetectInfo.getTriggetType();
        if (!VideoMaterial.isAudioTextTriggerType(i)) {
          break label131;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (this.triggerStateRange != null)
        {
          bool2 = bool1;
          if (this.triggerStateRange.min < this.triggerStateRange.max)
          {
            double d = paramPTDetectInfo.getRandomValue();
            if ((d < this.triggerStateRange.min) || (d >= this.triggerStateRange.max)) {
              break label320;
            }
            bool2 = true;
          }
        }
      }
      return bool2;
      label131:
      if (VideoMaterial.isBodyTriggerType(i))
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
                continue;
                label320:
                return false;
                return false;
              }
            }
          }
        }
        bool1 = false;
      }
    }
  }
  
  private boolean needDelayInClockTime(boolean paramBoolean)
  {
    boolean bool = true;
    if (this.fingerMusicClockTime > 0.0F)
    {
      if (this.isSaveNoImadiateTrigger) {
        paramBoolean = this.isSaveNoImadiateTrigger;
      }
      do
      {
        return paramBoolean;
        if ((!paramBoolean) || (this.lastTriggered)) {
          break;
        }
        this.isSaveNoImadiateTrigger = true;
        paramBoolean = bool;
      } while (inClockTime());
    }
    return false;
  }
  
  private boolean updateTriggeredStatus(PTDetectInfo paramPTDetectInfo)
  {
    boolean bool2 = true;
    int i;
    boolean bool1;
    if ((isNormalTriggered(paramPTDetectInfo)) && (isRangeValueHit()) && (isRandomGroupValueHit()) && (isAudioTriggered()))
    {
      i = 1;
      if ((i == 0) && (!this.config.renderForBitmap)) {
        break label311;
      }
      bool1 = true;
      label50:
      if (isTimeTriggered(paramPTDetectInfo)) {
        bool1 = true;
      }
      if ((bool1) && (!this.lastTriggered) && (this.playBPM > 0))
      {
        TouchTriggerManager.getInstance().setBgmTriggerTime(System.currentTimeMillis());
        TouchTriggerManager.getInstance().setBgmClockTime(this.playBPM);
      }
      if ((this.config.getTriggerTypeInt() != 220) || (this.config.alwaysTriggered) || (this.playMode != 0)) {
        break label524;
      }
      if (TouchTriggerManager.getInstance().getBgmClockTime() > 0.0F) {
        this.fingerMusicClockTime = (60.0F / TouchTriggerManager.getInstance().getBgmClockTime());
      }
      if (this.fingerMusicClockTime <= 0.0F) {
        break label392;
      }
      this.bgmStartTime = TouchTriggerManager.getInstance().getBgmTriggerTime();
      if ((!needDelayInClockTime(bool1)) || (!inClockTime()) || (System.currentTimeMillis() - this.clearTime <= 33L)) {
        break label316;
      }
      this.frameStartTime = paramPTDetectInfo.timestamp;
      this.status = TRIGGERED_STATUS.FIRST_TRIGGERED;
      this.firstFingerTimeStamp = System.currentTimeMillis();
      this.playCount = 0;
      clearDelayState();
      label233:
      updateTriggerTime(paramPTDetectInfo.timestamp, isTriggered());
      if (!isTriggered()) {
        this.playCount = 0;
      }
      if ((this.config.getTriggerTypeInt() != 220) || (this.config.alwaysTriggered) || (this.playMode != 0)) {
        break label676;
      }
      if ((!bool1) || (this.lastTriggered)) {
        break label670;
      }
    }
    for (;;)
    {
      this.lastTriggered = bool1;
      return bool2;
      i = 0;
      break;
      label311:
      bool1 = false;
      break label50;
      label316:
      if ((this.config.alwaysTriggered) || (this.playCount >= this.config.playCount) || (!this.isInState))
      {
        this.status = TRIGGERED_STATUS.NOT_TRIGGERED;
        break label233;
      }
      if ((this.status != TRIGGERED_STATUS.FIRST_TRIGGERED) || (System.currentTimeMillis() - this.firstFingerTimeStamp <= 33L)) {
        break label233;
      }
      this.status = TRIGGERED_STATUS.TRIGGERED;
      break label233;
      label392:
      if ((bool1) && (!this.lastTriggered) && (System.currentTimeMillis() - this.clearTime > 33L))
      {
        this.frameStartTime = paramPTDetectInfo.timestamp;
        this.status = TRIGGERED_STATUS.FIRST_TRIGGERED;
        this.firstFingerTimeStamp = System.currentTimeMillis();
        this.playCount = 0;
        break label233;
      }
      if ((this.config.alwaysTriggered) || (this.playCount >= this.config.playCount) || (!this.isInState))
      {
        this.status = TRIGGERED_STATUS.NOT_TRIGGERED;
        break label233;
      }
      if ((this.status != TRIGGERED_STATUS.FIRST_TRIGGERED) || (System.currentTimeMillis() - this.firstFingerTimeStamp <= 33L)) {
        break label233;
      }
      this.status = TRIGGERED_STATUS.TRIGGERED;
      break label233;
      label524:
      if (bool1)
      {
        if (this.status == TRIGGERED_STATUS.NOT_TRIGGERED)
        {
          this.frameStartTime = paramPTDetectInfo.timestamp;
          this.status = TRIGGERED_STATUS.FIRST_TRIGGERED;
          if ((!this.needUpateFirstStateTime) || (this.triggerMode != 1) || (!this.isInState)) {
            break label233;
          }
          this.firstTriggerInStateTime = paramPTDetectInfo.timestamp;
          this.needUpateFirstStateTime = false;
          break label233;
        }
        this.status = TRIGGERED_STATUS.TRIGGERED;
        break label233;
      }
      if ((this.config.alwaysTriggered) || (this.playCount >= this.config.playCount))
      {
        this.status = TRIGGERED_STATUS.NOT_TRIGGERED;
        break label233;
      }
      if ((this.status != TRIGGERED_STATUS.FIRST_TRIGGERED) || (System.currentTimeMillis() - this.frameStartTime <= 33L)) {
        break label233;
      }
      this.status = TRIGGERED_STATUS.TRIGGERED;
      break label233;
      label670:
      bool2 = false;
      continue;
      label676:
      bool2 = bool1;
    }
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
    return (int)((paramLong2 / 1000000L + paramLong1 - this.frameStartTime) / Math.max(this.frameDuration, 1.0D)) % Math.max(this.frames, 1);
  }
  
  public long getFrameStartTime()
  {
    return this.frameStartTime;
  }
  
  public ArrayList<RedPacketPosition> getHotArea()
  {
    if ((isTriggered()) && (this.config != null) && (this.config.hotArea != null) && (this.config.hotArea.length > 0) && (getFrameIndex() >= this.config.hotAreaStartFrame) && (getFrameIndex() <= this.config.hotAreaEndFrame))
    {
      int j = this.config.hotArea.length / 4;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localObject = new RedPacketPosition();
        ((RedPacketPosition)localObject).x = this.config.hotArea[(i * 4)];
        ((RedPacketPosition)localObject).y = this.config.hotArea[(i * 4 + 1)];
        ((RedPacketPosition)localObject).width = this.config.hotArea[(i * 4 + 2)];
        ((RedPacketPosition)localObject).height = this.config.hotArea[(i * 4 + 3)];
        localArrayList.add(localObject);
        i += 1;
      }
    }
    if ((isTriggered()) && (this.config != null) && (this.config.hotArea != null) && (this.config.hotArea.length > 0)) {}
    Object localObject = null;
    return localObject;
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
    if (this.mStickerItem != null) {
      return this.mStickerItem.playFirstSyncMode;
    }
    return 0;
  }
  
  public int getPlayMode()
  {
    return this.playMode;
  }
  
  public String getStickerItemID()
  {
    if (this.config == null) {
      return null;
    }
    return this.config.getStickerItemId();
  }
  
  public int getTotalPlayCount()
  {
    if (this.config == null) {
      return 0;
    }
    return this.config.playCount;
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
    if (this.aiAttr != null)
    {
      long l1 = this.aiAttr.getNextSurfaceTime();
      long l2 = this.aiAttr.getSurfaceTime();
      this.frameIndexElapse = getFrameIndexElapse(paramPTDetectInfo.timestamp, l1 - l2);
    }
    return this.status;
  }
  
  public void hitCharmRange(double paramDouble)
  {
    if (this.charmRange != null)
    {
      this.charmRange.hit(paramDouble);
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
    if (this.bodyPositionRecord != null) {
      this.bodyPositionRecord.clear();
    }
    this.isInited = false;
    this.initFrameStartTime = 0L;
    this.needUpateFirstStateTime = true;
    this.firstFingerTimeStamp = 0L;
    updateTriggerTime(-1L, false);
  }
  
  public void setAgeRangeValue(float paramFloat)
  {
    if (this.ageRange != null) {
      this.ageRange.setValue(paramFloat);
    }
  }
  
  public void setCpRangeValue(float paramFloat)
  {
    if (this.cpRange != null) {
      this.cpRange.setValue(paramFloat);
    }
  }
  
  public void setFrameStartTime(long paramLong)
  {
    this.frameStartTime = paramLong;
    Log.i("TriggerCtrlItem", " setFrameStartTime frameStartTime = " + this.frameStartTime);
    if (!this.isInited)
    {
      this.isInited = true;
      this.initFrameStartTime = paramLong;
    }
  }
  
  public void setGenderRangeValue(float paramFloat)
  {
    if (this.genderRange != null) {
      this.genderRange.setValue(paramFloat);
    }
  }
  
  public void setPlayCount(int paramInt)
  {
    this.playCount = paramInt;
  }
  
  public void setPopularRangeValue(float paramFloat)
  {
    if (this.popularRange != null) {
      this.popularRange.setValue(paramFloat);
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
    this.frameIndex = ((int)(l / Math.max(this.frameDuration, 1.0D)));
    if (this.frameIndex >= this.frames * (this.playCount + 1)) {
      this.playCount += 1;
    }
    this.frameIndex %= Math.max(this.frames, 1);
    if ((this.mStickerItem != null) && (this.mStickerItem.framePositionsBean != null)) {
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
    if (this.triggerTimeUpdater != null) {
      this.triggerStartTimestamp = this.triggerTimeUpdater.updateCurTriggerTime(paramLong - this.initFrameStartTime, this.triggerStartTimestamp, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.trigger.TriggerCtrlItem
 * JD-Core Version:    0.7.0.1
 */
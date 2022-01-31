package com.tencent.ttpic.model;

import android.graphics.PointF;
import android.util.Log;
import android.util.Pair;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIActionCounter.AI_TYPE;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.IAIDataClassifier;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.audio.AudioDataManager;
import com.tencent.ttpic.audio.MicAudioAdjustManager;
import com.tencent.ttpic.fabby.FabbyUtil;
import com.tencent.ttpic.facedetect.FaceActionCounterListener;
import com.tencent.ttpic.logic.watermark.FFTData;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.filter.VideoFilterList;
import com.tencent.ttpic.openapi.manager.TriggerStateManager;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.FaceStyleItem;
import com.tencent.ttpic.openapi.model.NodeItemJava;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.StickerItem.ValueRange;
import com.tencent.ttpic.openapi.model.TriggerStateItem;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunItem;
import com.tencent.ttpic.openapi.ttpicmodule.AETriggerAnalyzer;
import com.tencent.ttpic.openapi.util.TriggerUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import com.tencent.ttpic.util.StickerTriggerStatusUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TriggerCtrlItem
{
  private static final double MAX_AUDIO_FACTOR = 0.6D;
  private static int MAX_DB_RANGE = 120;
  private static final double MIN_AUDIO_FACTOR = 0.08D;
  private static int MIN_DB_RANGE = 0;
  private AgeRange ageRange;
  private AIAttr aiAttr;
  private double audioScaleFactor = 1.0D;
  private List<PointF> bodyPositionRecord;
  private int bodyPositionRecordMinNum = 2;
  private CharmRange charmRange;
  private TriggerConfig config;
  private CpRange cpRange;
  private double frameDuration;
  private int frameIndex;
  private long frameStartTime;
  private int frames;
  private GenderRange genderRange;
  private long initFrameStartTime;
  private boolean isInited = false;
  private int mRandomGroupValue;
  private int playCount;
  private PopularRange popularRange;
  private int renderID = 0;
  private TRIGGERED_STATUS status = TRIGGERED_STATUS.NOT_TRIGGERED;
  private long triggerDurationTimestamp;
  private boolean triggerForceInteger;
  private long triggerStartTimestamp;
  private String triggerState;
  public StickerItem.ValueRange triggerStateRange;
  private TriggerTimeUpdater triggerTimeUpdater;
  
  public TriggerCtrlItem()
  {
    this.config = new TriggerConfig();
    this.bodyPositionRecord = new ArrayList();
  }
  
  public TriggerCtrlItem(FaceMeshItem paramFaceMeshItem)
  {
    this.config = new TriggerConfig(paramFaceMeshItem);
    this.charmRange = paramFaceMeshItem.charmRange;
    this.frames = paramFaceMeshItem.frames;
    this.frameDuration = paramFaceMeshItem.frameDuration;
  }
  
  public TriggerCtrlItem(FaceItem paramFaceItem)
  {
    this.config = new TriggerConfig(paramFaceItem);
    this.charmRange = paramFaceItem.charmRange;
    this.frames = paramFaceItem.frames;
    this.frameDuration = paramFaceItem.frameDuration;
  }
  
  public TriggerCtrlItem(FaceStyleItem paramFaceStyleItem)
  {
    this.config = new TriggerConfig(paramFaceStyleItem);
    this.triggerState = paramFaceStyleItem.triggerState;
  }
  
  public TriggerCtrlItem(NodeItemJava paramNodeItemJava)
  {
    this.config = new TriggerConfig(paramNodeItemJava);
    this.frames = paramNodeItemJava.frames;
    this.frameDuration = paramNodeItemJava.frameDuration;
    this.triggerForceInteger = true;
  }
  
  public TriggerCtrlItem(StickerItem paramStickerItem)
  {
    this.config = new TriggerConfig(paramStickerItem);
    this.charmRange = paramStickerItem.charmRange;
    this.ageRange = paramStickerItem.ageRange;
    this.genderRange = paramStickerItem.genderRange;
    this.popularRange = paramStickerItem.popularRange;
    this.cpRange = paramStickerItem.cpRange;
    this.frames = paramStickerItem.frames;
    this.frameDuration = paramStickerItem.frameDuration;
    this.triggerState = paramStickerItem.triggerState;
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
  }
  
  public TriggerCtrlItem(CosFun.CosFunItem paramCosFunItem)
  {
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
    boolean bool5 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool4 = false;
    boolean bool6 = false;
    boolean bool2 = false;
    Object localObject2 = paramPTDetectInfo.triggeredExpression;
    Object localObject1 = paramPTDetectInfo.faceActionCounter;
    Map localMap = paramPTDetectInfo.handActionCounter;
    List localList = paramPTDetectInfo.bodyPoints;
    if (paramPTDetectInfo.aiAttr != null) {}
    for (PTHandAttr localPTHandAttr = (PTHandAttr)paramPTDetectInfo.aiAttr.getAvailableData(AEDetectorType.HAND.value);; localPTHandAttr = null)
    {
      label94:
      int i;
      if ((this.triggerState != null) && (!this.triggerState.equals("")))
      {
        bool1 = isStateTriggered(paramPTDetectInfo);
      }
      else
      {
        label156:
        label222:
        label240:
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                if (this.config.activateTriggerTotalCount == 0) {
                  break label612;
                }
                if (this.config.preTriggerType != PTFaceAttr.PTExpression.ALWAYS.value)
                {
                  if (!VideoMaterialUtil.isFaceTriggerType(this.config.preTriggerType)) {
                    break;
                  }
                  if (!((Set)localObject2).contains(Integer.valueOf(this.config.preTriggerType))) {
                    break label449;
                  }
                }
                i = 1;
                if ((localPTHandAttr == null) || (localPTHandAttr.getHandType() != this.config.countTriggerType)) {
                  AIActionCounter.clearAction(AIActionCounter.AI_TYPE.HAND);
                }
                bool1 = bool2;
              } while (i == 0);
              bool3 = VideoMaterialUtil.isFaceTriggerType(this.config.countTriggerType);
              bool1 = bool2;
            } while (localObject1 == null);
            if (!bool3) {
              break label472;
            }
            localObject2 = localObject1;
            bool1 = bool2;
          } while (localObject2 == null);
          if (!bool3) {
            break label479;
          }
          localObject2 = localObject1;
          bool1 = bool2;
        } while (!((Map)localObject2).containsKey(Integer.valueOf(this.config.countTriggerType)));
        if (bool3)
        {
          localObject1 = (FaceActionCounter)((Map)localObject1).get(Integer.valueOf(this.config.countTriggerType));
          if (localObject1 == null) {
            break label1230;
          }
          i = ((FaceActionCounter)localObject1).count;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        if (i % this.config.activateTriggerTotalCount != this.config.activateTriggerCount) {
          break label94;
        }
        if ((this.config.playCount != 0) && (this.playCount >= this.config.playCount))
        {
          bool2 = bool4;
          if (this.config.lockTriggerCountUntilFail == 0) {}
        }
        else
        {
          bool2 = true;
        }
        bool1 = bool2;
        if (VideoFilterList.sIsUseFreezeFrame) {
          break label94;
        }
        if ((this.playCount < this.config.playCount) || (this.config.lockTriggerCountUntilFail != 0))
        {
          if (bool3)
          {
            bool1 = bool2;
            if (paramPTDetectInfo.faceDetector == null) {
              break label94;
            }
            paramPTDetectInfo.faceDetector.lockActionCounter();
            return bool2;
            if (paramPTDetectInfo.isFreezeInfo) {
              if (paramPTDetectInfo.gestureTrigger == this.config.preTriggerType) {
                break label156;
              }
            }
            label449:
            while (!TriggerUtil.isGestureTriggered(localPTHandAttr, this.config.preTriggerType))
            {
              i = 0;
              break;
            }
            break label156;
            label472:
            localObject2 = localMap;
            break label222;
            label479:
            localObject2 = localMap;
            break label240;
            localObject1 = (Integer)localMap.get(Integer.valueOf(this.config.countTriggerType));
            if (localObject1 == null) {
              break label1230;
            }
            i = ((Integer)localObject1).intValue();
            continue;
          }
          AIActionCounter.lockAction(AIActionCounter.AI_TYPE.HAND);
          if (localPTHandAttr != null)
          {
            bool1 = bool2;
            if (localPTHandAttr.getHandType() == this.config.countTriggerType) {
              break label94;
            }
          }
          AIActionCounter.clearAction(AIActionCounter.AI_TYPE.HAND);
          return bool2;
        }
        bool1 = bool2;
        if (this.config.playCount <= 0) {
          break label94;
        }
        if (bool3)
        {
          bool1 = bool2;
          if (paramPTDetectInfo.faceDetector == null) {
            break label94;
          }
          paramPTDetectInfo.faceDetector.clearActionCounter();
          return bool2;
        }
        AIActionCounter.clearAction(AIActionCounter.AI_TYPE.HAND);
        return bool2;
        label612:
        int j;
        if ((this.triggerForceInteger) || (AETriggerAnalyzer.getInstance().isInteger(this.config.getTriggerTypeString())))
        {
          if (VideoMaterialUtil.isFaceTriggerType(this.config.getTriggerTypeInt()))
          {
            bool1 = bool2;
            if (localObject2 == null) {
              break label94;
            }
            return ((Set)localObject2).contains(Integer.valueOf(this.config.getTriggerTypeInt()));
          }
          if (VideoMaterialUtil.isGestureTriggerType(this.config.getTriggerTypeInt()))
          {
            if (paramPTDetectInfo.isFreezeInfo) {
              if (paramPTDetectInfo.gestureTrigger != this.config.getTriggerTypeInt()) {}
            }
            for (;;)
            {
              return bool1;
              bool1 = false;
              continue;
              bool1 = TriggerUtil.isGestureTriggered(localPTHandAttr, this.config.getTriggerTypeInt());
            }
          }
          if (VideoMaterialUtil.isAudioTextTriggerType(this.config.getTriggerTypeInt()))
          {
            paramPTDetectInfo = LogicDataManager.getInstance().getCurTextList().iterator();
            bool1 = bool6;
            if (!paramPTDetectInfo.hasNext()) {
              break label94;
            }
            localObject1 = (String)paramPTDetectInfo.next();
            bool2 = this.config.isSentenceTriggered((String)localObject1);
            bool1 = bool2;
            if (!bool2) {
              break;
            }
            return bool2;
          }
          if (VideoMaterialUtil.isAllFreezeFrameTriggerType(this.config.getTriggerTypeInt())) {
            return ((Set)localObject2).contains(Integer.valueOf(this.config.getTriggerTypeInt()));
          }
          if (VideoMaterialUtil.isTouchTriggerType(this.config.getTriggerTypeInt())) {
            return ((Set)localObject2).contains(Integer.valueOf(this.config.getTriggerTypeInt()));
          }
          if (VideoMaterialUtil.isBodyDetectType(this.config.getTriggerTypeInt()))
          {
            if ((localList != null) && (!localList.isEmpty())) {}
            for (bool1 = bool5;; bool1 = false) {
              return bool1;
            }
          }
          bool1 = bool2;
          if (!VideoMaterialUtil.isBodyTriggerType(this.config.getTriggerTypeInt())) {
            break label94;
          }
          bool1 = bool2;
          if (localList == null) {
            break label94;
          }
          bool1 = bool2;
          if (localList.isEmpty()) {
            break label94;
          }
          if (this.bodyPositionRecord.size() == this.bodyPositionRecordMinNum) {
            this.bodyPositionRecord.remove(0);
          }
          this.bodyPositionRecord.add(localList.get(this.config.bodyTriggerPoint));
          bool1 = bool2;
          if (this.bodyPositionRecord.size() <= 1) {
            break label94;
          }
          paramPTDetectInfo = (PointF)localList.get(this.config.bodyTriggerPoint);
          localObject1 = (PointF)this.bodyPositionRecord.get(0);
          i = calPointsDistance((PointF)localObject1, paramPTDetectInfo);
          j = calPointsAngle((PointF)localObject1, paramPTDetectInfo);
          bool1 = bool2;
          if (i < this.config.bodyTriggerDistance) {
            break label94;
          }
          i = Math.abs(j - this.config.getBodyTriggerAngle());
          this.config.getClass();
          bool1 = bool2;
          if (i > 15) {
            break label94;
          }
          return true;
        }
        localObject1 = this.config.getTriggerTypeString().split("-");
        bool1 = bool2;
        if (localObject1.length != 2) {
          break label94;
        }
        localMap = localObject1[0];
        for (;;)
        {
          try
          {
            i = Integer.parseInt(localObject1[1]);
            localObject1 = AETriggerAnalyzer.getInstance().getClassifier(localMap);
            if (localObject1 != null)
            {
              j = ((IAIDataClassifier)localObject1).classifyData2Type(paramPTDetectInfo.aiAttr);
              bool1 = ((IAIDataClassifier)localObject1).getClassifierTypeMap().containsValue(Integer.valueOf(j));
              if ((bool1) && (i == j))
              {
                bool1 = bool3;
                return bool1;
              }
              bool1 = false;
              continue;
            }
            bool1 = false;
          }
          catch (NumberFormatException paramPTDetectInfo)
          {
            return false;
          }
        }
        label1230:
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
    Object localObject1 = paramPTDetectInfo.bodyPoints;
    paramPTDetectInfo = TriggerStateManager.getInstance().getTriggerStateItem(this.renderID);
    boolean bool1;
    boolean bool2;
    int i;
    Object localObject2;
    if (paramPTDetectInfo != null)
    {
      bool1 = paramPTDetectInfo.isTriggerState(this.triggerState);
      bool2 = bool1;
      if (bool1)
      {
        i = paramPTDetectInfo.getTriggetType();
        if (!VideoMaterialUtil.isAudioTextTriggerType(i)) {
          break label190;
        }
        localObject1 = LogicDataManager.getInstance().getCurTextList().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          bool2 = this.config.isSentenceTriggered((String)localObject2);
          bool1 = bool2;
          if (bool2) {
            bool1 = bool2;
          }
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
              break label379;
            }
            bool2 = true;
          }
        }
      }
      return bool2;
      label190:
      if (VideoMaterialUtil.isBodyTriggerType(i))
      {
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          if (this.bodyPositionRecord.size() == this.bodyPositionRecordMinNum) {
            this.bodyPositionRecord.remove(0);
          }
          this.bodyPositionRecord.add(((List)localObject1).get(this.config.bodyTriggerPoint));
          if (this.bodyPositionRecord.size() > 1)
          {
            localObject1 = (PointF)((List)localObject1).get(this.config.bodyTriggerPoint);
            localObject2 = (PointF)this.bodyPositionRecord.get(0);
            i = calPointsDistance((PointF)localObject2, (PointF)localObject1);
            int j = calPointsAngle((PointF)localObject2, (PointF)localObject1);
            if (i >= this.config.bodyTriggerDistance)
            {
              i = Math.abs(j - this.config.getBodyTriggerAngle());
              this.config.getClass();
              if (i <= 15)
              {
                bool1 = true;
                continue;
                label379:
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
  
  private boolean updateTriggeredStatus(PTDetectInfo paramPTDetectInfo)
  {
    boolean bool2 = true;
    int i;
    boolean bool1;
    if ((isNormalTriggered(paramPTDetectInfo)) && (isRangeValueHit()) && (isRandomGroupValueHit()) && (isAudioTriggered()))
    {
      i = 1;
      if ((i == 0) && (!this.config.renderForBitmap)) {
        break label161;
      }
      bool1 = true;
      label50:
      if (!isTimeTriggered(paramPTDetectInfo)) {
        break label210;
      }
      bool1 = bool2;
    }
    label161:
    label210:
    for (;;)
    {
      if (bool1) {
        if (this.status == TRIGGERED_STATUS.NOT_TRIGGERED)
        {
          this.frameStartTime = paramPTDetectInfo.timestamp;
          Log.i("TriggerCtrlItem", " updateTriggeredStatus triggered = " + bool1 + "frameStartTime = " + this.frameStartTime);
          this.status = TRIGGERED_STATUS.FIRST_TRIGGERED;
        }
      }
      for (;;)
      {
        updateTriggerTime(paramPTDetectInfo.timestamp, isTriggered());
        if (!isTriggered()) {
          this.playCount = 0;
        }
        return bool1;
        i = 0;
        break;
        bool1 = false;
        break label50;
        this.status = TRIGGERED_STATUS.TRIGGERED;
        continue;
        if ((this.config.alwaysTriggered) || (this.playCount >= this.config.playCount)) {
          this.status = TRIGGERED_STATUS.NOT_TRIGGERED;
        }
      }
    }
  }
  
  public double getAudioScaleFactor()
  {
    return this.audioScaleFactor;
  }
  
  public int getFrameIndex()
  {
    return this.frameIndex;
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
      while (i < j)
      {
        RedPacketPosition localRedPacketPosition = new RedPacketPosition();
        localRedPacketPosition.x = this.config.hotArea[(i * 4)];
        localRedPacketPosition.y = this.config.hotArea[(i * 4 + 1)];
        localRedPacketPosition.width = this.config.hotArea[(i * 4 + 2)];
        localRedPacketPosition.height = this.config.hotArea[(i * 4 + 3)];
        localArrayList.add(localRedPacketPosition);
        i += 1;
      }
      Log.e("yk", "has Area frameindex::" + getFrameIndex());
      return localArrayList;
    }
    if ((isTriggered()) && (this.config != null) && (this.config.hotArea != null) && (this.config.hotArea.length > 0)) {
      Log.e("yk", "no area frameindex::" + getFrameIndex());
    }
    return null;
  }
  
  public int getPlayCount()
  {
    return this.playCount;
  }
  
  public String getStickerItemID()
  {
    if (this.config == null) {
      return null;
    }
    return this.config.getStickerItemId();
  }
  
  public TRIGGERED_STATUS getTriggeredStatus(PTDetectInfo paramPTDetectInfo)
  {
    updateFrameIndex(paramPTDetectInfo.timestamp);
    updateTriggeredStatus(paramPTDetectInfo);
    StickerTriggerStatusUtil.putTriggerStatus(this.config.getStickerItemId(), this.status);
    return this.status;
  }
  
  public boolean isCurrentFrameTriggered(PTDetectInfo paramPTDetectInfo)
  {
    return updateTriggeredStatus(paramPTDetectInfo);
  }
  
  public boolean isRenderForBitmap()
  {
    return this.config.isRenderForBitmap();
  }
  
  public boolean isTimeTriggered(PTDetectInfo paramPTDetectInfo)
  {
    return (VideoMaterialUtil.isTimeTriggerType(this.config.getTriggerTypeInt())) && (this.initFrameStartTime + this.triggerStartTimestamp <= paramPTDetectInfo.timestamp) && (paramPTDetectInfo.timestamp <= this.initFrameStartTime + this.triggerStartTimestamp + this.triggerDurationTimestamp);
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
    updateTriggerTime(-1L, false);
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
  
  public void setPlayCount(int paramInt)
  {
    this.playCount = paramInt;
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
    if (!isTriggered()) {
      this.frameStartTime = paramLong;
    }
    this.frameIndex = ((int)((paramLong - this.frameStartTime) / Math.max(this.frameDuration, 1.0D)));
    if (this.frameIndex >= this.frames * (this.playCount + 1)) {
      this.playCount += 1;
    }
    this.frameIndex %= Math.max(this.frames, 1);
  }
  
  public void updateTriggerTime(long paramLong, boolean paramBoolean)
  {
    if (this.triggerTimeUpdater != null) {
      this.triggerStartTimestamp = this.triggerTimeUpdater.updateCurTriggerTime(paramLong - this.initFrameStartTime, this.triggerStartTimestamp, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.model.TriggerCtrlItem
 * JD-Core Version:    0.7.0.1
 */
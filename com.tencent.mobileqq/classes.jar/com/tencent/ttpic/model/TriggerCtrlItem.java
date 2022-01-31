package com.tencent.ttpic.model;

import android.graphics.PointF;
import android.util.Log;
import android.util.Pair;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIActionCounter.AI_TYPE;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.HotAreaActionCounter;
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
  private boolean isItemTriggerCountOnce = false;
  private int mRandomGroupValue;
  private int playCount;
  private PopularRange popularRange;
  private int renderID = 0;
  private TRIGGERED_STATUS status = TRIGGERED_STATUS.NOT_TRIGGERED;
  private long triggerDurationTimestamp;
  private boolean triggerForceInteger;
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
    Object localObject3 = null;
    Object localObject4 = null;
    boolean bool5 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    int j = 0;
    boolean bool3 = false;
    int i = 0;
    boolean bool6 = false;
    boolean bool2 = false;
    Set localSet = paramPTDetectInfo.triggeredExpression;
    Object localObject2 = paramPTDetectInfo.faceActionCounter;
    Map localMap = paramPTDetectInfo.handActionCounter;
    List localList = paramPTDetectInfo.bodyPoints;
    if (paramPTDetectInfo.aiAttr != null) {}
    for (Object localObject1 = (PTHandAttr)paramPTDetectInfo.aiAttr.getAvailableData(AEDetectorType.HAND.value);; localObject1 = null)
    {
      label259:
      if ((this.triggerState != null) && (this.triggerState.size() > 0))
      {
        bool1 = isStateTriggered(paramPTDetectInfo);
      }
      else
      {
        label101:
        label241:
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
                  break label850;
                }
                if (this.config.preTriggerType != PTFaceAttr.PTExpression.ALWAYS.value)
                {
                  if (!VideoMaterialUtil.isFaceTriggerType(this.config.preTriggerType)) {
                    break;
                  }
                  if (!localSet.contains(Integer.valueOf(this.config.preTriggerType))) {
                    break label544;
                  }
                }
                i = 1;
                if ((localObject1 == null) || (((PTHandAttr)localObject1).getHandType() != this.config.countTriggerType)) {
                  AIActionCounter.clearAction(AIActionCounter.AI_TYPE.HAND);
                }
                bool1 = bool2;
              } while (i == 0);
              bool4 = VideoMaterialUtil.isFaceTriggerType(this.config.countTriggerType);
              bool5 = VideoMaterialUtil.isHotAreaTriggerItem(this.config.getStickerItem());
              bool1 = bool2;
            } while (localObject2 == null);
            if (!bool4) {
              break label632;
            }
            localObject3 = localObject2;
            bool1 = bool2;
          } while (localObject3 == null);
          if (!bool4) {
            break label639;
          }
          localObject3 = localObject2;
          bool1 = bool2;
        } while (!((Map)localObject3).containsKey(Integer.valueOf(this.config.countTriggerType)));
        label163:
        label165:
        if (bool4)
        {
          localObject2 = (FaceActionCounter)((Map)localObject2).get(Integer.valueOf(this.config.countTriggerType));
          if (localObject2 == null) {
            break label1524;
          }
          i = ((FaceActionCounter)localObject2).count;
        }
      }
      for (;;)
      {
        label321:
        bool1 = bool2;
        if (i % this.config.activateTriggerTotalCount != this.config.activateTriggerCount) {
          break label101;
        }
        int k;
        if (bool5)
        {
          k = this.config.preTriggerType;
          i = j;
          if (this.config.getStickerItem() != null) {
            i = this.config.getStickerItem().triggerHandPoint;
          }
          localObject2 = localObject4;
          if (this.config.getStickerItem() != null) {
            localObject2 = this.config.getStickerItem().triggerArea;
          }
          bool1 = TriggerUtil.isGestureTriggered((PTHandAttr)localObject1, k, i, (ArrayList)localObject2, paramPTDetectInfo.aiAttr);
          bool2 = bool1;
          if (this.config.activateTriggerCountOnce == 1)
          {
            bool2 = bool1;
            if (!this.isItemTriggerCountOnce)
            {
              HotAreaActionCounter.updateCount();
              this.isItemTriggerCountOnce = true;
              bool2 = bool1;
            }
          }
        }
        for (;;)
        {
          bool1 = bool2;
          if (VideoFilterList.sIsUseFreezeFrame) {
            break;
          }
          if ((this.playCount >= this.config.playCount) && (this.config.lockTriggerCountUntilFail == 0)) {
            break label788;
          }
          if (!bool4) {
            break label738;
          }
          bool1 = bool2;
          if (paramPTDetectInfo.faceDetector == null) {
            break;
          }
          paramPTDetectInfo.faceDetector.lockActionCounter();
          return bool2;
          if (paramPTDetectInfo.isFreezeInfo) {
            if (paramPTDetectInfo.gestureTrigger == this.config.preTriggerType) {
              break label163;
            }
          }
          label544:
          label579:
          label626:
          label630:
          for (;;)
          {
            i = 0;
            break label165;
            k = this.config.preTriggerType;
            if (this.config.getStickerItem() != null)
            {
              i = this.config.getStickerItem().triggerHandPoint;
              if (this.config.getStickerItem() == null) {
                break label626;
              }
            }
            for (localObject3 = this.config.getStickerItem().triggerArea;; localObject3 = null)
            {
              if (!TriggerUtil.isGestureTriggered((PTHandAttr)localObject1, k, i, (ArrayList)localObject3, paramPTDetectInfo.aiAttr)) {
                break label630;
              }
              break;
              i = 0;
              break label579;
            }
          }
          label632:
          localObject3 = localMap;
          break label241;
          label639:
          localObject3 = localMap;
          break label259;
          if (bool5)
          {
            i = HotAreaActionCounter.getCount();
            break label321;
          }
          localObject2 = (Integer)localMap.get(Integer.valueOf(this.config.countTriggerType));
          if (localObject2 == null) {
            break label1524;
          }
          i = ((Integer)localObject2).intValue();
          break label321;
          if ((this.config.playCount != 0) && (this.playCount >= this.config.playCount))
          {
            bool2 = bool3;
            if (this.config.lockTriggerCountUntilFail == 0) {}
          }
          else
          {
            bool2 = true;
          }
        }
        label738:
        if (bool5)
        {
          HotAreaActionCounter.lockUpdate();
          return bool2;
        }
        AIActionCounter.lockAction(AIActionCounter.AI_TYPE.HAND);
        if (localObject1 != null)
        {
          bool1 = bool2;
          if (((PTHandAttr)localObject1).getHandType() == this.config.countTriggerType) {
            break label101;
          }
        }
        AIActionCounter.clearAction(AIActionCounter.AI_TYPE.HAND);
        return bool2;
        label788:
        bool1 = bool2;
        if (this.config.playCount <= 0) {
          break label101;
        }
        if (bool4)
        {
          bool1 = bool2;
          if (paramPTDetectInfo.faceDetector == null) {
            break label101;
          }
          paramPTDetectInfo.faceDetector.clearActionCounter();
          return bool2;
        }
        if (bool5)
        {
          HotAreaActionCounter.lockUpdate();
          return bool2;
        }
        AIActionCounter.clearAction(AIActionCounter.AI_TYPE.HAND);
        return bool2;
        label850:
        if ((this.triggerForceInteger) || (AETriggerAnalyzer.getInstance().isInteger(this.config.getTriggerTypeString())))
        {
          if (VideoMaterialUtil.isFaceTriggerType(this.config.getTriggerTypeInt()))
          {
            bool1 = bool2;
            if (localSet == null) {
              break label101;
            }
            return localSet.contains(Integer.valueOf(this.config.getTriggerTypeInt()));
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
              j = this.config.getTriggerTypeInt();
              if (this.config.getStickerItem() != null) {
                i = this.config.getStickerItem().triggerHandPoint;
              }
              localObject2 = localObject3;
              if (this.config.getStickerItem() != null) {
                localObject2 = this.config.getStickerItem().triggerArea;
              }
              bool1 = TriggerUtil.isGestureTriggered((PTHandAttr)localObject1, j, i, (ArrayList)localObject2, paramPTDetectInfo.aiAttr);
            }
          }
          if (VideoMaterialUtil.isAudioTextTriggerType(this.config.getTriggerTypeInt()))
          {
            paramPTDetectInfo = LogicDataManager.getInstance().getCurTextList().iterator();
            bool1 = bool6;
            if (!paramPTDetectInfo.hasNext()) {
              break label101;
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
            return localSet.contains(Integer.valueOf(this.config.getTriggerTypeInt()));
          }
          if (VideoMaterialUtil.isTouchTriggerType(this.config.getTriggerTypeInt())) {
            return localSet.contains(Integer.valueOf(this.config.getTriggerTypeInt()));
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
            break label101;
          }
          bool1 = bool2;
          if (localList == null) {
            break label101;
          }
          bool1 = bool2;
          if (localList.isEmpty()) {
            break label101;
          }
          if (this.bodyPositionRecord.size() == this.bodyPositionRecordMinNum) {
            this.bodyPositionRecord.remove(0);
          }
          this.bodyPositionRecord.add(localList.get(this.config.bodyTriggerPoint));
          bool1 = bool2;
          if (this.bodyPositionRecord.size() <= 1) {
            break label101;
          }
          paramPTDetectInfo = (PointF)localList.get(this.config.bodyTriggerPoint);
          localObject1 = (PointF)this.bodyPositionRecord.get(0);
          i = calPointsDistance((PointF)localObject1, paramPTDetectInfo);
          j = calPointsAngle((PointF)localObject1, paramPTDetectInfo);
          bool1 = bool2;
          if (i < this.config.bodyTriggerDistance) {
            break label101;
          }
          i = Math.abs(j - this.config.getBodyTriggerAngle());
          this.config.getClass();
          bool1 = bool2;
          if (i > 15) {
            break label101;
          }
          return true;
        }
        localObject1 = this.config.getTriggerTypeString().split("-");
        bool1 = bool2;
        if (localObject1.length != 2) {
          break label101;
        }
        localObject2 = localObject1[0];
        for (;;)
        {
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
                bool1 = bool4;
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
        label1524:
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
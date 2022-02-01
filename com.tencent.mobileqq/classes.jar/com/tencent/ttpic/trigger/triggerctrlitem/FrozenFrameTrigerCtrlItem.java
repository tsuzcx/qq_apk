package com.tencent.ttpic.trigger.triggerctrlitem;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.Builder;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.trigger.TRIGGERED_STATUS;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FrozenFrameTrigerCtrlItem
  extends TriggerCtrlItem
{
  private Set<Integer> mCameraTriggerSets;
  private PTFaceAttr mFaceAttr;
  private Frame mFreezeFrame;
  private int mGestuereTrigger = -1;
  private Map<Integer, Integer> mHandActionCounter = new HashMap();
  private PTSegAttr mSegAttr;
  
  public FrozenFrameTrigerCtrlItem(StickerItem paramStickerItem)
  {
    super(paramStickerItem);
    if (paramStickerItem.playCount > 0) {
      this.triggerDurationTimestamp *= paramStickerItem.playCount;
    }
  }
  
  public void addAllFreezeTrigger()
  {
    if (this.mFaceAttr != null)
    {
      Set localSet = this.mFaceAttr.getTriggeredExpression();
      if (localSet != null) {
        localSet.add(Integer.valueOf(PTFaceAttr.PTExpression.ALL_VIEWER_ITEM_FRAME_FROZEN.value));
      }
    }
  }
  
  public void clear()
  {
    if (this.mFreezeFrame != null)
    {
      this.mFreezeFrame.setCanUnlock(true);
      this.mFreezeFrame.unlock();
      this.mFreezeFrame.clear();
      this.mFreezeFrame = null;
    }
    if (this.mFaceAttr != null)
    {
      this.mFaceAttr.setData(null);
      this.mFaceAttr = null;
    }
    if (this.mSegAttr != null)
    {
      Frame localFrame = this.mSegAttr.getMaskFrame();
      if (localFrame != null)
      {
        localFrame.setCanUnlock(true);
        localFrame.unlock();
        localFrame.clear();
        this.mSegAttr.setMaskFrame(null);
      }
      this.mSegAttr = null;
    }
    if (this.mHandActionCounter != null) {
      this.mHandActionCounter.clear();
    }
    this.mGestuereTrigger = -1;
  }
  
  public Set<Integer> getCameraTriggerSets()
  {
    return this.mCameraTriggerSets;
  }
  
  public int getGestureTrigger()
  {
    return this.mGestuereTrigger;
  }
  
  public Map<Integer, Integer> getHandActionCounter()
  {
    return this.mHandActionCounter;
  }
  
  public Frame getInputFrameSnapshot()
  {
    return this.mFreezeFrame;
  }
  
  public PTFaceAttr getPTFaceSnapshot()
  {
    return this.mFaceAttr;
  }
  
  public PTSegAttr getPTSegSnapshot()
  {
    return this.mSegAttr;
  }
  
  public Frame getSegMaskSnapshot()
  {
    if (this.mSegAttr != null) {
      return this.mSegAttr.getMaskFrame();
    }
    return null;
  }
  
  public void removeAllFreezeTrigger()
  {
    if (this.mFaceAttr != null)
    {
      Set localSet = this.mFaceAttr.getTriggeredExpression();
      if (localSet != null) {
        localSet.remove(Integer.valueOf(PTFaceAttr.PTExpression.ALL_VIEWER_ITEM_FRAME_FROZEN.value));
      }
    }
  }
  
  public void reset()
  {
    super.reset();
    clear();
  }
  
  public void setHandActionCounter(Map<Integer, Integer> paramMap)
  {
    if (this.mHandActionCounter != null) {
      this.mHandActionCounter.clear();
    }
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      Integer localInteger = (Integer)paramMap.get(Integer.valueOf(i));
      if (localInteger != null) {
        this.mHandActionCounter.put(Integer.valueOf(i), localInteger);
      }
    }
  }
  
  public void updateCameraTriggerAction(Set<Integer> paramSet)
  {
    this.mCameraTriggerSets = paramSet;
  }
  
  public PTFaceAttr updateFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    if ((paramPTFaceAttr != null) && (paramPTFaceAttr.getData() != null))
    {
      if (this.mFaceAttr != null) {
        break label191;
      }
      byte[] arrayOfByte = new byte[paramPTFaceAttr.getData().length];
      System.arraycopy(paramPTFaceAttr.getData(), 0, arrayOfByte, 0, arrayOfByte.length);
      this.mFaceAttr = new PTFaceAttr(new PTFaceAttr.Builder().facePoints(paramPTFaceAttr.getAllFacePoints()).faceDetectScale(paramPTFaceAttr.getFaceDetectScale()).timeStamp(paramPTFaceAttr.getTimeStamp()).faceAngles(paramPTFaceAttr.getAllFaceAngles()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).rotation(paramPTFaceAttr.getRotation()).faceStatusList(paramPTFaceAttr.getFaceStatusList()).data(arrayOfByte).bodyPoints(paramPTFaceAttr.getBodyPoints()).faceKitVerticesArray(paramPTFaceAttr.getFaceKitVerticesArray()).featureIndicesArray(paramPTFaceAttr.getFeatureIndicesArray()).facePiont2DCenter(paramPTFaceAttr.getFacePiont2DCenter()).pointsVis(paramPTFaceAttr.getPointsVis()).recordFaceInfo(paramPTFaceAttr.getRecordFaceInfo()).faceDetector(paramPTFaceAttr.getFaceDetector()).faceDetWidth(paramPTFaceAttr.getFaceDetWidth()).faceDetHeight(paramPTFaceAttr.getFaceDetHeight()).faceInfoList(paramPTFaceAttr.getFaceInfoList()));
    }
    for (;;)
    {
      return this.mFaceAttr;
      label191:
      this.mFaceAttr.setTimeStamp(paramPTFaceAttr.getTimeStamp());
    }
  }
  
  public int updateGestuereTrigger(AIAttr paramAIAttr)
  {
    if (paramAIAttr != null)
    {
      paramAIAttr = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
      if (paramAIAttr != null)
      {
        setHandActionCounter(AIActionCounter.getActions(AEDetectorType.HAND));
        this.mGestuereTrigger = paramAIAttr.getHandType();
      }
    }
    return this.mGestuereTrigger;
  }
  
  public Frame updateInputFrame(Frame paramFrame1, Frame paramFrame2, BaseFilter paramBaseFilter)
  {
    if ((paramFrame1 != null) && (this.mFreezeFrame == null))
    {
      if (paramBaseFilter == null) {
        return paramFrame1;
      }
      this.mFreezeFrame = FrameBufferCache.getInstance().get(paramFrame1.width, paramFrame1.height);
      paramBaseFilter.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, -1, 0.0D, this.mFreezeFrame);
      this.mFreezeFrame.setCanUnlock(false);
      paramBaseFilter.RenderProcess(this.mFreezeFrame.getTextureId(), this.mFreezeFrame.width, this.mFreezeFrame.height, paramFrame2.width, paramFrame2.height, -1, 0.0D, paramFrame2);
    }
    for (;;)
    {
      return paramFrame2;
      if (this.mFreezeFrame != null) {
        paramBaseFilter.RenderProcess(this.mFreezeFrame.getTextureId(), this.mFreezeFrame.width, this.mFreezeFrame.height, paramFrame2.width, paramFrame2.height, -1, 0.0D, paramFrame2);
      }
    }
  }
  
  public Frame updateInputFrame(Frame paramFrame, BaseFilter paramBaseFilter)
  {
    return updateInputFrame(paramFrame, paramFrame, paramBaseFilter);
  }
  
  public PTSegAttr updatePTSegAttr(PTSegAttr paramPTSegAttr, BaseFilter paramBaseFilter)
  {
    if ((paramPTSegAttr != null) && (this.mSegAttr == null))
    {
      this.mSegAttr = new PTSegAttr();
      paramPTSegAttr = paramPTSegAttr.getMaskFrame();
      if ((paramPTSegAttr != null) && (paramBaseFilter != null))
      {
        Frame localFrame = FrameBufferCache.getInstance().get(paramPTSegAttr.width, paramPTSegAttr.height);
        paramBaseFilter.RenderProcess(paramPTSegAttr.getTextureId(), paramPTSegAttr.width, paramPTSegAttr.height, -1, 0.0D, localFrame);
        this.mSegAttr.setMaskFrame(localFrame);
        localFrame.setCanUnlock(false);
      }
    }
    return this.mSegAttr;
  }
  
  public void updateTimeStamp(long paramLong)
  {
    this.mFaceAttr.setTimeStamp(paramLong);
  }
  
  public void updateTriggerStatus(PTDetectInfo paramPTDetectInfo)
  {
    super.updateTriggerStatus(paramPTDetectInfo);
    if (this.status == TRIGGERED_STATUS.NOT_TRIGGERED) {
      clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.trigger.triggerctrlitem.FrozenFrameTrigerCtrlItem
 * JD-Core Version:    0.7.0.1
 */
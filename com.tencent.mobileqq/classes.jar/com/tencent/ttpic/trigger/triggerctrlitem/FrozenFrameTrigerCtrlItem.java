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
    Object localObject = this.mFaceAttr;
    if (localObject != null)
    {
      localObject = ((PTFaceAttr)localObject).getTriggeredExpression();
      if (localObject != null) {
        ((Set)localObject).add(Integer.valueOf(PTFaceAttr.PTExpression.ALL_VIEWER_ITEM_FRAME_FROZEN.value));
      }
    }
  }
  
  public void clear()
  {
    Object localObject = this.mFreezeFrame;
    if (localObject != null)
    {
      ((Frame)localObject).setCanUnlock(true);
      this.mFreezeFrame.unlock();
      this.mFreezeFrame.clear();
      this.mFreezeFrame = null;
    }
    localObject = this.mFaceAttr;
    if (localObject != null)
    {
      ((PTFaceAttr)localObject).setData(null);
      this.mFaceAttr = null;
    }
    localObject = this.mSegAttr;
    if (localObject != null)
    {
      localObject = ((PTSegAttr)localObject).getMaskFrame();
      if (localObject != null)
      {
        ((Frame)localObject).setCanUnlock(true);
        ((Frame)localObject).unlock();
        ((Frame)localObject).clear();
        this.mSegAttr.setMaskFrame(null);
      }
      this.mSegAttr = null;
    }
    localObject = this.mHandActionCounter;
    if (localObject != null) {
      ((Map)localObject).clear();
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
    PTSegAttr localPTSegAttr = this.mSegAttr;
    if (localPTSegAttr != null) {
      return localPTSegAttr.getMaskFrame();
    }
    return null;
  }
  
  public void removeAllFreezeTrigger()
  {
    Object localObject = this.mFaceAttr;
    if (localObject != null)
    {
      localObject = ((PTFaceAttr)localObject).getTriggeredExpression();
      if (localObject != null) {
        ((Set)localObject).remove(Integer.valueOf(PTFaceAttr.PTExpression.ALL_VIEWER_ITEM_FRAME_FROZEN.value));
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
    Object localObject = this.mHandActionCounter;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    localObject = paramMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      int i = ((Integer)((Iterator)localObject).next()).intValue();
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
    if (paramPTFaceAttr != null)
    {
      Object localObject = this.mFaceAttr;
      if (localObject == null)
      {
        localObject = new byte[paramPTFaceAttr.getData().length];
        System.arraycopy(paramPTFaceAttr.getData(), 0, localObject, 0, localObject.length);
        this.mFaceAttr = new PTFaceAttr(new PTFaceAttr.Builder().facePoints(paramPTFaceAttr.getAllFacePoints()).faceDetectScale(paramPTFaceAttr.getFaceDetectScale()).timeStamp(paramPTFaceAttr.getTimeStamp()).faceAngles(paramPTFaceAttr.getAllFaceAngles()).triggeredExpression(paramPTFaceAttr.getTriggeredExpression()).faceActionCounter(paramPTFaceAttr.getFaceActionCounter()).rotation(paramPTFaceAttr.getRotation()).faceStatusList(paramPTFaceAttr.getFaceStatusList()).data((byte[])localObject).bodyPoints(paramPTFaceAttr.getBodyPoints()).faceKitVerticesArray(paramPTFaceAttr.getFaceKitVerticesArray()).featureIndicesArray(paramPTFaceAttr.getFeatureIndicesArray()).facePiont2DCenter(paramPTFaceAttr.getFacePiont2DCenter()).pointsVis(paramPTFaceAttr.getPointsVis()).recordFaceInfo(paramPTFaceAttr.getRecordFaceInfo()).faceDetector(paramPTFaceAttr.getFaceDetector()).faceDetWidth(paramPTFaceAttr.getFaceDetWidth()).faceDetHeight(paramPTFaceAttr.getFaceDetHeight()).faceInfoList(paramPTFaceAttr.getFaceInfoList()));
      }
      else
      {
        ((PTFaceAttr)localObject).setTimeStamp(paramPTFaceAttr.getTimeStamp());
      }
    }
    return this.mFaceAttr;
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
      return paramFrame2;
    }
    paramFrame1 = this.mFreezeFrame;
    if (paramFrame1 != null) {
      paramBaseFilter.RenderProcess(paramFrame1.getTextureId(), this.mFreezeFrame.width, this.mFreezeFrame.height, paramFrame2.width, paramFrame2.height, -1, 0.0D, paramFrame2);
    }
    return paramFrame2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.trigger.triggerctrlitem.FrozenFrameTrigerCtrlItem
 * JD-Core Version:    0.7.0.1
 */
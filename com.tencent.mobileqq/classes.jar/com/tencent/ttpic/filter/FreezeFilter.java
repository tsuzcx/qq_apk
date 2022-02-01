package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.model.cosfun.CosFun.CosFunItem;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.trigger.TriggerManager;

public class FreezeFilter
{
  private VideoFilterBase copyFilter = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame copyFrame;
  private final int duration;
  private int freezeFaceCount;
  private final int startTime;
  private TriggerCtrlItem triggerCtrlItem;
  private boolean triggered;
  private long triggeredStartTime;
  
  public FreezeFilter(CosFun.CosFunItem paramCosFunItem, TriggerManager paramTriggerManager)
  {
    this.startTime = paramCosFunItem.getFreezeStart();
    this.duration = paramCosFunItem.getFreezeDuration();
    if (paramTriggerManager != null)
    {
      this.triggerCtrlItem = new TriggerCtrlItem(paramCosFunItem);
      paramTriggerManager.addTriggers(this.triggerCtrlItem);
    }
  }
  
  private boolean inRange(long paramLong)
  {
    return (paramLong >= this.startTime) && (paramLong <= this.startTime + this.duration);
  }
  
  public void destroy()
  {
    this.copyFilter.clearGLSLSelf();
    if (this.copyFrame != null)
    {
      this.copyFrame.clear();
      this.copyFrame = null;
    }
  }
  
  public Frame getFreezeFrame(Frame paramFrame)
  {
    if (this.copyFrame == null)
    {
      this.copyFrame = new Frame();
      this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.copyFrame);
    }
    return this.copyFrame;
  }
  
  public long getUpdateTimeStamp(long paramLong)
  {
    if (!this.triggered) {
      return 0L;
    }
    return paramLong - this.triggeredStartTime;
  }
  
  public boolean hasFreezeFace()
  {
    return this.freezeFaceCount > 0;
  }
  
  public void init()
  {
    this.copyFilter.ApplyGLSLFilter();
  }
  
  public boolean isTriggered()
  {
    return this.triggered;
  }
  
  public void setFreezeCount(PTFaceAttr paramPTFaceAttr)
  {
    this.freezeFaceCount = paramPTFaceAttr.getFaceCount();
  }
  
  public long updateActionTriggered(PTFaceAttr paramPTFaceAttr)
  {
    if (this.triggered) {
      return this.triggeredStartTime;
    }
    if (this.triggerCtrlItem != null) {
      this.triggered = this.triggerCtrlItem.isTriggered();
    }
    this.triggeredStartTime = paramPTFaceAttr.getTimeStamp();
    return this.triggeredStartTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.FreezeFilter
 * JD-Core Version:    0.7.0.1
 */
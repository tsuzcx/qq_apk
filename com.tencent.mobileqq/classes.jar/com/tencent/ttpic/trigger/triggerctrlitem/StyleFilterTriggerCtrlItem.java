package com.tencent.ttpic.trigger.triggerctrlitem;

import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.trigger.TRIGGERED_STATUS;
import com.tencent.ttpic.trigger.TriggerCtrlItem;

public class StyleFilterTriggerCtrlItem
  extends TriggerCtrlItem
{
  private float mDenoiseValue = 0.0F;
  
  public StyleFilterTriggerCtrlItem(float paramFloat)
  {
    this.mDenoiseValue = paramFloat;
    this.status = TRIGGERED_STATUS.TRIGGERED;
  }
  
  public StyleFilterTriggerCtrlItem(StickerItem paramStickerItem, float paramFloat)
  {
    super(paramStickerItem);
    this.mDenoiseValue = paramFloat;
  }
  
  public boolean isDenoise()
  {
    return this.mDenoiseValue > 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.trigger.triggerctrlitem.StyleFilterTriggerCtrlItem
 * JD-Core Version:    0.7.0.1
 */
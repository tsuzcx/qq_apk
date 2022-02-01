package com.tencent.mobileqq.wink.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/event/ImageChangePageEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "position", "", "(I)V", "getPosition", "()I", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ImageChangePageEvent
  extends SimpleBaseEvent
{
  private final int position;
  
  public ImageChangePageEvent(int paramInt)
  {
    this.position = paramInt;
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.event.ImageChangePageEvent
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelScrollEvent;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEvent;", "data", "", "isOutCalled", "", "(JZ)V", "getData", "()J", "()Z", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public class PanelScrollEvent
  extends PanelEvent
{
  private final long a;
  private final boolean b;
  
  public PanelScrollEvent(long paramLong, boolean paramBoolean)
  {
    this.a = paramLong;
    this.b = paramBoolean;
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelScrollEvent
 * JD-Core Version:    0.7.0.1
 */
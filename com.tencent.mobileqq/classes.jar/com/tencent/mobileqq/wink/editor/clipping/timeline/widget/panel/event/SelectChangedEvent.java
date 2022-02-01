package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/SelectChangedEvent;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEvent;", "id", "", "selected", "", "(Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "getSelected", "()Z", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public class SelectChangedEvent
  extends PanelEvent
{
  @NotNull
  private final String a;
  private final boolean b;
  
  public SelectChangedEvent(@NotNull String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.SelectChangedEvent
 * JD-Core Version:    0.7.0.1
 */
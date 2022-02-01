package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController$ScrollRunnable;", "Ljava/lang/Runnable;", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;)V", "value", "", "distance", "getDistance", "()I", "setDistance", "(I)V", "scrollXPerFrame", "postScrollRunnableUnnecessary", "", "run", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TimelinePanelViewController$ScrollRunnable
  implements Runnable
{
  private int a;
  private int b;
  
  private final boolean a()
  {
    return (this.a != 0) && (this.b == 0);
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
    this.b = (paramInt / 2);
  }
  
  public void run()
  {
    if (a())
    {
      localTimelinePanelViewController = this.this$0;
      localTimelinePanelViewController.a(TimelinePanelViewController.a(localTimelinePanelViewController) + this.a);
      return;
    }
    TimelinePanelViewController localTimelinePanelViewController = this.this$0;
    localTimelinePanelViewController.a(TimelinePanelViewController.a(localTimelinePanelViewController) + this.b);
    if (TimelinePanelViewController.a(this.this$0) > TimelinePanelViewController.b(this.this$0))
    {
      localTimelinePanelViewController = this.this$0;
      TimelinePanelViewController.a(localTimelinePanelViewController, TimelinePanelViewController.b(localTimelinePanelViewController));
      return;
    }
    if (TimelinePanelViewController.a(this.this$0) < TimelinePanelViewController.b(this.this$0)) {
      TimelinePanelViewController.b(this.this$0, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController.ScrollRunnable
 * JD-Core Version:    0.7.0.1
 */
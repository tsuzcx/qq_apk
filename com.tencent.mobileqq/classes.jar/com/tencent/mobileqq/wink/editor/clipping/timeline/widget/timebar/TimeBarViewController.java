package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar;

import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.BaseTimelineViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.CommonConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.LayoutConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/TimeBarViewController;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/BaseTimelineViewController;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/TimeBarView;", "()V", "getAttractPointSet", "", "", "getMinViewWidth", "notifyScroll", "", "position", "onViewScale", "refreshWidth", "minWidth", "scrollTo", "setAttractPointSet", "set", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TimeBarViewController
  extends BaseTimelineViewController<TimeBarView>
{
  public void a(int paramInt)
  {
    TimeBarView localTimeBarView = (TimeBarView)d();
    if (localTimeBarView != null) {
      localTimeBarView.scrollTo(paramInt, localTimeBarView.getScrollY());
    }
  }
  
  public void a(@NotNull Set<Integer> paramSet)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "set");
  }
  
  public final void b(int paramInt)
  {
    e().a(paramInt, null);
  }
  
  public void c(int paramInt) {}
  
  public void j()
  {
    TimeBarView localTimeBarView = (TimeBarView)d();
    if (localTimeBarView != null) {
      localTimeBarView.invalidate();
    }
  }
  
  public int k()
  {
    return a().d() + (e().g().b().a() << 1);
  }
  
  @NotNull
  public Set<Integer> l()
  {
    return SetsKt.emptySet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.TimeBarViewController
 * JD-Core Version:    0.7.0.1
 */
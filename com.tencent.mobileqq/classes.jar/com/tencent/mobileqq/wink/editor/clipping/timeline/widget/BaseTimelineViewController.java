package com.tencent.mobileqq.wink.editor.clipping.timeline.widget;

import android.view.View;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.CommonConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.IAttractPointProvider;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.IWidthChangeListener;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.IScaleListener;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.IScrollListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/BaseTimelineViewController;", "V", "Landroid/view/View;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/ITimelineView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/IScaleListener;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/IScrollListener;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IAttractPointProvider;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/IWidthChangeListener;", "()V", "config", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/CommonConfig;", "getConfig", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/CommonConfig;", "flingHelper", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper;", "getFlingHelper", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper;", "minWidth", "", "getMinWidth", "()I", "panelEventHandler", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEventHandler;", "getPanelEventHandler", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEventHandler;", "panelViewController", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "getPanelViewController", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "setPanelViewController", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;)V", "scaleCalculator", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator;", "getScaleCalculator", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator;", "view", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "Landroid/view/View;", "bindView", "", "v", "refreshView", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract class BaseTimelineViewController<V extends View,  extends ITimelineView>
  implements IAttractPointProvider, IWidthChangeListener, IScaleListener, IScrollListener
{
  @Nullable
  private V a;
  @NotNull
  private TimelinePanelViewController b = new TimelinePanelViewController();
  
  @NotNull
  public final ScaleCalculator a()
  {
    return this.b.a();
  }
  
  public void a(@NotNull V paramV)
  {
    Intrinsics.checkParameterIsNotNull(paramV, "v");
    this.a = paramV;
    ((ITimelineView)paramV).a(this);
    this.b.b(this);
  }
  
  public final void a(@NotNull TimelinePanelViewController paramTimelinePanelViewController)
  {
    Intrinsics.checkParameterIsNotNull(paramTimelinePanelViewController, "<set-?>");
    this.b = paramTimelinePanelViewController;
  }
  
  @NotNull
  public final CommonConfig b()
  {
    return this.b.g();
  }
  
  @NotNull
  public final PanelEventHandler c()
  {
    return this.b.i();
  }
  
  @Nullable
  public final V d()
  {
    return this.a;
  }
  
  @NotNull
  public final TimelinePanelViewController e()
  {
    return this.b;
  }
  
  @NotNull
  public final FlingHelper f()
  {
    return this.b.h();
  }
  
  public final int g()
  {
    return this.b.d();
  }
  
  public void h()
  {
    View localView = this.a;
    if (localView != null) {
      localView.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.BaseTimelineViewController
 * JD-Core Version:    0.7.0.1
 */
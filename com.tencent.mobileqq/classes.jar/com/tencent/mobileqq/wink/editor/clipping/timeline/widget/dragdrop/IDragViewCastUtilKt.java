package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"asIDragView", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragView;", "Landroid/view/View;", "asView", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class IDragViewCastUtilKt
{
  @Nullable
  public static final View a(@NotNull IDragView paramIDragView)
  {
    Intrinsics.checkParameterIsNotNull(paramIDragView, "$this$asView");
    IDragView localIDragView = paramIDragView;
    if (!(paramIDragView instanceof View)) {
      localIDragView = null;
    }
    return (View)localIDragView;
  }
  
  @Nullable
  public static final IDragView a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$asIDragView");
    View localView = paramView;
    if (!(paramView instanceof IDragView)) {
      localView = null;
    }
    return (IDragView)localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.IDragViewCastUtilKt
 * JD-Core Version:    0.7.0.1
 */
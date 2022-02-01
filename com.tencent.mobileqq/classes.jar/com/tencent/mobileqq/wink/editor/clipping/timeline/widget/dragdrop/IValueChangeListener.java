package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.view.View;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IValueChangeListener;", "", "getAdjustedEndPosition", "", "dragView", "Landroid/view/View;", "rawEndPosition", "offsetX", "getAdjustedStartPosition", "Lkotlin/Pair;", "", "rawStartPosition", "isScrollingLeft", "isScrollingRight", "onMoveEnd", "", "positionOffset", "isUp", "view", "isLeft", "onSelectStateChanged", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragView;", "isSelected", "onSliderDown", "requestLayout", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IValueChangeListener
{
  @NotNull
  public abstract Pair<Boolean, Integer> a(@NotNull View paramView, int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt, boolean paramBoolean1, @NotNull View paramView, boolean paramBoolean2);
  
  public abstract void a(@NotNull IDragView paramIDragView);
  
  public abstract void a(@Nullable IDragView paramIDragView, boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract int b(@NotNull View paramView, int paramInt1, int paramInt2);
  
  public abstract boolean b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.IValueChangeListener
 * JD-Core Version:    0.7.0.1
 */
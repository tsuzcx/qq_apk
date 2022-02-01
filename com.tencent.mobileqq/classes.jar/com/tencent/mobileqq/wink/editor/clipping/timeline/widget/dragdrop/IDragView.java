package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.graphics.PointF;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragView;", "", "dragViewModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragViewModel;", "getDragViewModel", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragViewModel;", "setDragViewModel", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragViewModel;)V", "isDragging", "", "()Z", "startTouchPoint", "Landroid/graphics/PointF;", "getStartTouchPoint", "()Landroid/graphics/PointF;", "allowOverLap", "bottomSpace", "", "canEndPositionOverMaxSpace", "getEndPosition", "getLength", "getMaxEndPosition", "getMaxEndPositionForDrag", "getMinDistance", "getMinStartPosition", "getStartPosition", "getTrackType", "horizontalScrollOffset", "leftSpace", "needChangePositionOnDrop", "onPositionChanged", "", "onScrollStopped", "rightSpace", "setScaleCalculator", "scaleCalculator", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator;", "setValueChangeListener", "valueChangeListener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IValueChangeListener;", "topSpace", "updateDragModel", "dragModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragModel;", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IDragView
{
  public static final IDragView.Companion b = IDragView.Companion.a;
  
  public abstract int a();
  
  public abstract int b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract boolean e();
  
  public abstract boolean f();
  
  public abstract int g();
  
  @NotNull
  public abstract DragViewModel getDragViewModel();
  
  public abstract int getEndPosition();
  
  public abstract int getLength();
  
  public abstract int getMaxEndPosition();
  
  public abstract int getMaxEndPositionForDrag();
  
  public abstract int getMinDistance();
  
  public abstract int getMinStartPosition();
  
  public abstract int getStartPosition();
  
  @Nullable
  public abstract PointF getStartTouchPoint();
  
  public abstract int getTrackType();
  
  public abstract void setDragViewModel(@NotNull DragViewModel paramDragViewModel);
  
  public abstract void setValueChangeListener(@Nullable IValueChangeListener paramIValueChangeListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.IDragView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class IDragView$DefaultImpls
{
  public static int a(IDragView paramIDragView)
  {
    return 0;
  }
  
  public static void a(IDragView paramIDragView, @NotNull DragModel paramDragModel)
  {
    Intrinsics.checkParameterIsNotNull(paramDragModel, "dragModel");
    paramIDragView.getDragViewModel().a(paramDragModel);
  }
  
  public static int b(IDragView paramIDragView)
  {
    return paramIDragView.getEndPosition() - paramIDragView.getStartPosition();
  }
  
  public static int c(IDragView paramIDragView)
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.IDragView.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "model1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragViewModel;", "kotlin.jvm.PlatformType", "model2", "compare"}, k=3, mv={1, 1, 16})
final class PositionChangedHandler$getSameTrackMaxEnd$blocks$1<T>
  implements Comparator<DragViewModel>
{
  public static final 1 a = new 1();
  
  public final int a(DragViewModel paramDragViewModel1, DragViewModel paramDragViewModel2)
  {
    return Intrinsics.compare(paramDragViewModel1.b(), paramDragViewModel2.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.PositionChangedHandler.getSameTrackMaxEnd.blocks.1
 * JD-Core Version:    0.7.0.1
 */
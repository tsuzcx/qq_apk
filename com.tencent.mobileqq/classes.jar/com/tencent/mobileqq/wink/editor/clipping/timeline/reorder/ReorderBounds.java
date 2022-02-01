package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderBounds;", "", "()V", "PROPNAME_BOUNDS", "", "PROPNAME_WINDOW_X", "PROPNAME_WINDOW_Y", "clipBoundsProperty", "Landroid/util/Property;", "Landroid/view/View;", "Landroid/graphics/Rect;", "getClipBoundsProperty", "()Landroid/util/Property;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ReorderBounds
{
  public static final ReorderBounds a = new ReorderBounds();
  @NotNull
  private static final Property<View, Rect> b = (Property)new ReorderBounds.clipBoundsProperty.1(Rect.class, "clipBounds");
  
  @NotNull
  public final Property<View, Rect> a()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderBounds
 * JD-Core Version:    0.7.0.1
 */
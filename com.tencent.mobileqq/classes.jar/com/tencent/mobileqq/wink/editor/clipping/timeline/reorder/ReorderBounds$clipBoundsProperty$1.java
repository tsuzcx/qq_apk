package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderBounds$clipBoundsProperty$1", "Landroid/util/Property;", "Landroid/view/View;", "Landroid/graphics/Rect;", "get", "view", "set", "", "value", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ReorderBounds$clipBoundsProperty$1
  extends Property<View, Rect>
{
  ReorderBounds$clipBoundsProperty$1(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  @RequiresApi(18)
  @Nullable
  public Rect a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    return paramView.getClipBounds();
  }
  
  @RequiresApi(18)
  public void a(@NotNull View paramView, @NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramRect, "value");
    paramView.setClipBounds(paramRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderBounds.clipBoundsProperty.1
 * JD-Core Version:    0.7.0.1
 */
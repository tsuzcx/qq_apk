package com.tencent.mobileqq.vas.ui;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/VasNinePathBitmap$Companion;", "", "()V", "calculateScale", "Lkotlin/Triple;", "", "", "width", "", "height", "canvasRect", "Landroid/graphics/Rect;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasNinePathBitmap$Companion
{
  @JvmStatic
  @NotNull
  public final Triple<Boolean, Boolean, Float> a(int paramInt1, int paramInt2, @NotNull Rect paramRect)
  {
    boolean bool2 = false;
    Intrinsics.checkParameterIsNotNull(paramRect, "canvasRect");
    if (paramRect.width() < paramInt1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramRect.height() < paramInt2) {
        bool2 = true;
      }
      if ((!bool1) && (!bool2)) {
        break;
      }
      return new Triple(Boolean.valueOf(bool1), Boolean.valueOf(bool2), Float.valueOf(Math.max(paramInt2 / paramRect.height(), paramInt1 / paramRect.width())));
    }
    return new Triple(Boolean.valueOf(bool1), Boolean.valueOf(bool2), Float.valueOf(1.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VasNinePathBitmap.Companion
 * JD-Core Version:    0.7.0.1
 */
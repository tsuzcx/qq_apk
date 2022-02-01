package com.tencent.mobileqq.vas.ui;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/VasNinePathBitmap$Companion;", "", "()V", "calculateScale", "Lkotlin/Triple;", "", "", "width", "", "height", "canvasRect", "Landroid/graphics/Rect;", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public final class VasNinePathBitmap$Companion
{
  @JvmStatic
  @NotNull
  public final Triple<Boolean, Boolean, Float> a(int paramInt1, int paramInt2, @NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "canvasRect");
    int i = paramRect.width();
    boolean bool2 = true;
    boolean bool1;
    if (i < paramInt1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (paramRect.height() >= paramInt2) {
      bool2 = false;
    }
    if ((!bool1) && (!bool2)) {
      return new Triple(Boolean.valueOf(bool1), Boolean.valueOf(bool2), Float.valueOf(1.0F));
    }
    return new Triple(Boolean.valueOf(bool1), Boolean.valueOf(bool2), Float.valueOf(Math.max(paramInt2 / paramRect.height(), paramInt1 / paramRect.width())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VasNinePathBitmap.Companion
 * JD-Core Version:    0.7.0.1
 */
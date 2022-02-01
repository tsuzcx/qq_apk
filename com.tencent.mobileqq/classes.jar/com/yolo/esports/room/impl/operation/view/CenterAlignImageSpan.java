package com.yolo.esports.room.impl.operation.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/yolo/esports/room/impl/operation/view/CenterAlignImageSpan;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class CenterAlignImageSpan
  extends ImageSpan
{
  public void draw(@NotNull Canvas paramCanvas, @Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NotNull Paint paramPaint)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Intrinsics.checkParameterIsNotNull(paramPaint, "paint");
    paramCharSequence = paramPaint.getFontMetricsInt();
    paramInt1 = (paramCharSequence.descent + paramInt4 + paramInt4 + paramCharSequence.ascent) / 2;
    paramCharSequence = getDrawable();
    Intrinsics.checkExpressionValueIsNotNull(paramCharSequence, "drawable");
    paramInt2 = paramCharSequence.getBounds().bottom / 2;
    paramCanvas.save();
    paramCanvas.translate(paramFloat, paramInt1 - paramInt2);
    getDrawable().draw(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.room.impl.operation.view.CenterAlignImageSpan
 * JD-Core Version:    0.7.0.1
 */
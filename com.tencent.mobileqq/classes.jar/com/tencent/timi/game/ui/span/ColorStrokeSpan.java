package com.tencent.timi.game.ui.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/span/ColorStrokeSpan;", "Landroid/text/style/ReplacementSpan;", "outlineColor", "", "strokeWidth", "", "(IF)V", "outlineStrokePaint", "Landroid/graphics/Paint;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "top", "y", "bottom", "paint", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ColorStrokeSpan
  extends ReplacementSpan
{
  public static final ColorStrokeSpan.Companion a = new ColorStrokeSpan.Companion(null);
  private final Paint b;
  private final int c;
  private final float d;
  
  public void draw(@NotNull Canvas paramCanvas, @Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NotNull Paint paramPaint)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Intrinsics.checkParameterIsNotNull(paramPaint, "paint");
    this.b.set(paramPaint);
    this.b.setStrokeWidth(this.d);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setColor(this.c);
    this.b.setAntiAlias(true);
    this.b.setDither(true);
    if (paramCharSequence != null)
    {
      float f = paramInt4;
      paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat, f, this.b);
      Paint.Style localStyle = paramPaint.getStyle();
      paramPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat, f, paramPaint);
      paramPaint.setStyle(localStyle);
    }
  }
  
  public int getSize(@NotNull Paint paramPaint, @Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    Intrinsics.checkParameterIsNotNull(paramPaint, "paint");
    Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.top = localFontMetricsInt.top;
      paramFontMetricsInt.ascent = localFontMetricsInt.ascent;
      paramFontMetricsInt.descent = localFontMetricsInt.descent;
      paramFontMetricsInt.bottom = localFontMetricsInt.bottom;
    }
    return (int)paramPaint.measureText(paramCharSequence, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.span.ColorStrokeSpan
 * JD-Core Version:    0.7.0.1
 */
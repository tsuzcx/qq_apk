package com.tencent.timi.game.liveroom.impl.view.message;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/message/RadiusBackgroundSpan;", "Landroid/text/style/ReplacementSpan;", "bgColor", "", "textColor", "radius", "(III)V", "mBgColor", "mRadius", "mSize", "mTextColor", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class RadiusBackgroundSpan
  extends ReplacementSpan
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public RadiusBackgroundSpan(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
  }
  
  public void draw(@NotNull Canvas paramCanvas, @Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NotNull Paint paramPaint)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Intrinsics.checkParameterIsNotNull(paramPaint, "paint");
    paramInt3 = paramPaint.getColor();
    paramPaint.setColor(this.b);
    paramPaint.setAntiAlias(true);
    float f = paramInt4;
    RectF localRectF = new RectF(paramFloat, paramPaint.ascent() + f, this.a + paramFloat, paramPaint.descent() + f);
    paramInt4 = this.d;
    paramCanvas.drawRoundRect(localRectF, paramInt4, paramInt4, paramPaint);
    paramPaint.setColor(this.c);
    paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat + this.d, f, paramPaint);
    paramPaint.setColor(paramInt3);
  }
  
  public int getSize(@NotNull Paint paramPaint, @Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    Intrinsics.checkParameterIsNotNull(paramPaint, "paint");
    this.a = ((int)(paramPaint.measureText(paramCharSequence, paramInt1, paramInt2) + this.d * 2));
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.message.RadiusBackgroundSpan
 * JD-Core Version:    0.7.0.1
 */
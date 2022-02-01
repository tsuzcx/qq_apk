package com.tencent.timi.game.liveroom.impl.view.message;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/message/CenterAlignSizeImageSpan;", "Landroid/text/style/ReplacementSpan;", "bitmap", "Landroid/graphics/Bitmap;", "leftMargin", "", "rightMargin", "(Landroid/graphics/Bitmap;II)V", "bitmapRectF", "Landroid/graphics/RectF;", "getLeftMargin", "()I", "getRightMargin", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public class CenterAlignSizeImageSpan
  extends ReplacementSpan
{
  public static final CenterAlignSizeImageSpan.Companion a = new CenterAlignSizeImageSpan.Companion(null);
  private final RectF b;
  private final Bitmap c;
  private final int d;
  private final int e;
  
  public CenterAlignSizeImageSpan(@NotNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.c = paramBitmap;
    this.d = paramInt1;
    this.e = paramInt2;
    this.b = new RectF();
  }
  
  public void draw(@NotNull Canvas paramCanvas, @Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NotNull Paint paramPaint)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Intrinsics.checkParameterIsNotNull(paramPaint, "paint");
    paramCharSequence = paramPaint.getFontMetricsInt();
    paramInt1 = (paramCharSequence.descent + paramInt4 + paramInt4 + paramCharSequence.ascent) / 2;
    paramInt2 = this.c.getHeight() / 2;
    paramCanvas.save();
    paramCanvas.translate(paramFloat, paramInt1 - paramInt2);
    paramCharSequence = this.c;
    RectF localRectF = this.b;
    localRectF.set(this.d, 0.0F, paramCharSequence.getWidth(), this.c.getHeight());
    paramCanvas.drawBitmap(paramCharSequence, null, localRectF, paramPaint);
    paramCanvas.restore();
  }
  
  public int getSize(@NotNull Paint paramPaint, @Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    Intrinsics.checkParameterIsNotNull(paramPaint, "paint");
    return this.c.getWidth() + this.d + this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.message.CenterAlignSizeImageSpan
 * JD-Core Version:    0.7.0.1
 */
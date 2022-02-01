package com.tencent.timi.game.liveroom.impl.view.message;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/message/SizeReplacementSpan;", "Landroid/text/style/ReplacementSpan;", "size", "", "(I)V", "getSize", "()I", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SizeReplacementSpan
  extends ReplacementSpan
{
  private final int a;
  
  public void draw(@NotNull Canvas paramCanvas, @Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NotNull Paint paramPaint)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Intrinsics.checkParameterIsNotNull(paramPaint, "paint");
  }
  
  public int getSize(@NotNull Paint paramPaint, @Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    Intrinsics.checkParameterIsNotNull(paramPaint, "paint");
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.message.SizeReplacementSpan
 * JD-Core Version:    0.7.0.1
 */
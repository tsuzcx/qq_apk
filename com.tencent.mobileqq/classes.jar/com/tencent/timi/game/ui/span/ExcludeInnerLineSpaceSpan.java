package com.tencent.timi.game.ui.span;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;
import kotlin.Metadata;
import kotlin.math.MathKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/span/ExcludeInnerLineSpaceSpan;", "Landroid/text/style/LineHeightSpan;", "height", "", "(I)V", "chooseHeight", "", "text", "", "start", "end", "spanstartv", "lineHeight", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExcludeInnerLineSpaceSpan
  implements LineHeightSpan
{
  private final int a;
  
  public ExcludeInnerLineSpaceSpan(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void chooseHeight(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt != null)
    {
      paramInt1 = paramFontMetricsInt.descent - paramFontMetricsInt.ascent;
      if (paramInt1 < 0) {
        return;
      }
      float f = this.a / paramInt1;
      paramFontMetricsInt.descent = MathKt.roundToInt(paramFontMetricsInt.descent * f);
      paramFontMetricsInt.ascent = (paramFontMetricsInt.descent - this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.span.ExcludeInnerLineSpaceSpan
 * JD-Core Version:    0.7.0.1
 */
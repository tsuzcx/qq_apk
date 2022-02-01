package com.tencent.timi.game.liveroom.impl.live.widget;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/live/widget/HorInputBoxView$layoutInflated$4", "Landroid/text/InputFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class HorInputBoxView$layoutInflated$4
  implements InputFilter
{
  @Nullable
  public CharSequence filter(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (paramCharSequence != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if (paramCharSequence != null)
      {
        paramCharSequence = StringsKt.replace$default(paramCharSequence, "\n", "", false, 4, null);
        break label30;
      }
    }
    paramCharSequence = null;
    label30:
    return (CharSequence)paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.HorInputBoxView.layoutInflated.4
 * JD-Core Version:    0.7.0.1
 */
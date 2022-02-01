package com.tencent.timi.game.liveroom.impl.widget;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/widget/AnchorInputBoxView$layoutInflated$3", "Landroid/text/InputFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorInputBoxView$layoutInflated$3
  implements InputFilter
{
  @Nullable
  public CharSequence filter(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    Object localObject = null;
    paramSpanned = localObject;
    if (paramCharSequence != null)
    {
      paramSpanned = localObject;
      if (StringsKt.contains$default(paramCharSequence, (CharSequence)"\n", false, 2, null) == true) {
        paramSpanned = (CharSequence)StringsKt.replace$default(paramCharSequence.toString(), "\n", "", false, 4, null);
      }
    }
    return paramSpanned;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AnchorInputBoxView.layoutInflated.3
 * JD-Core Version:    0.7.0.1
 */
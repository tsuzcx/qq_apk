package com.tencent.timi.game.liveroom.impl.live.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/live/widget/HorInputBoxView$layoutInflated$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class HorInputBoxView$layoutInflated$2
  implements TextWatcher
{
  public void afterTextChanged(@Nullable Editable paramEditable)
  {
    TextView localTextView = HorInputBoxView.b(this.a);
    if (localTextView != null)
    {
      paramEditable = (CharSequence)paramEditable;
      int j = 0;
      int i;
      if ((paramEditable != null) && (paramEditable.length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        j = 8;
      }
      localTextView.setVisibility(j);
    }
  }
  
  public void beforeTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.HorInputBoxView.layoutInflated.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.liveroom.impl.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/widget/AnchorInputBoxView$layoutInflated$4", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorInputBoxView$layoutInflated$4
  implements TextWatcher
{
  public void afterTextChanged(@Nullable Editable paramEditable)
  {
    View localView = AnchorInputBoxView.e(this.a);
    if (localView != null)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramEditable != null)
      {
        int i;
        if (((CharSequence)paramEditable).length() > 0) {
          i = 1;
        } else {
          i = 0;
        }
        bool1 = bool2;
        if (i == 1) {
          bool1 = true;
        }
      }
      localView.setEnabled(bool1);
    }
  }
  
  public void beforeTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AnchorInputBoxView.layoutInflated.4
 * JD-Core Version:    0.7.0.1
 */
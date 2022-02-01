package com.tencent.timi.game.team.impl.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.timi.game.component.chat.input.KeyboardUtils;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/chat/TeamInputView$layoutInflated$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamInputView$layoutInflated$1
  implements TextWatcher
{
  public void afterTextChanged(@Nullable Editable paramEditable)
  {
    boolean bool = false;
    if (paramEditable == null)
    {
      paramEditable = TeamInputView.b(this.a);
      if (paramEditable != null) {
        paramEditable.setEnabled(false);
      }
      return;
    }
    View localView = TeamInputView.b(this.a);
    if (localView != null)
    {
      if (((CharSequence)paramEditable).length() > 0) {
        bool = true;
      }
      localView.setEnabled(bool);
    }
  }
  
  public void beforeTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence != null)
    {
      int i;
      if (paramCharSequence.length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return;
      }
    }
    if ((paramInt2 == 0) && (paramInt3 == 1))
    {
      if (paramCharSequence != null) {
        paramCharSequence = Character.valueOf(paramCharSequence.charAt(paramInt1));
      } else {
        paramCharSequence = null;
      }
      Logger.b("TeamInputView", String.valueOf(paramCharSequence));
      if ((String.valueOf(paramCharSequence).equals("@")) && (TeamAtListView.a()))
      {
        paramCharSequence = TeamInputView.a(this.a);
        if (paramCharSequence == null) {
          Intrinsics.throwNpe();
        }
        KeyboardUtils.b((View)paramCharSequence);
        TeamAtListView.a((TeamAtListView.AtStateChangeListener)new TeamInputView.layoutInflated.1.onTextChanged.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamInputView.layoutInflated.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.team.impl.main;

import android.text.InputFilter;
import android.text.Spanned;

final class TeamConfigDialog$3
  implements InputFilter
{
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (paramCharSequence.equals(" ")) {
      return "";
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.main.TeamConfigDialog.3
 * JD-Core Version:    0.7.0.1
 */
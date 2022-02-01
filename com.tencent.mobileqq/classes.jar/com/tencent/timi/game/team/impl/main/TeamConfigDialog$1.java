package com.tencent.timi.game.team.impl.main;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class TeamConfigDialog$1
  implements TextWatcher
{
  TeamConfigDialog$1(TeamConfigDialog paramTeamConfigDialog) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = this.a;
    TeamConfigDialog.a(paramCharSequence, TeamConfigDialog.a(paramCharSequence).getText().length());
    TeamConfigDialog.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.main.TeamConfigDialog.1
 * JD-Core Version:    0.7.0.1
 */
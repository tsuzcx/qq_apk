package com.tencent.mobileqq.teamworkforgroup;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.util.InputMethodUtil;

class TroopTeamWorkFileSearchDialog$5
  implements TextView.OnEditorActionListener
{
  TroopTeamWorkFileSearchDialog$5(TroopTeamWorkFileSearchDialog paramTroopTeamWorkFileSearchDialog) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 3) && ((paramKeyEvent == null) || (paramKeyEvent.getKeyCode() != 66))) {
      return false;
    }
    InputMethodUtil.b(this.a.a);
    this.a.d();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.5
 * JD-Core Version:    0.7.0.1
 */
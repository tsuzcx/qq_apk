package com.tencent.mobileqq.teamworkforgroup;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;

class TroopTeamWorkFileSearchDialog$5
  implements TextView.OnEditorActionListener
{
  TroopTeamWorkFileSearchDialog$5(TroopTeamWorkFileSearchDialog paramTroopTeamWorkFileSearchDialog) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((paramInt != 3) && ((paramKeyEvent == null) || (paramKeyEvent.getKeyCode() != 66)))
    {
      bool = false;
    }
    else
    {
      InputMethodUtil.b(this.a.h);
      this.a.e();
      bool = true;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.5
 * JD-Core Version:    0.7.0.1
 */
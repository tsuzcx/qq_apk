package com.tencent.mobileqq.teamworkforgroup;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.util.InputMethodUtil;

class TroopTeamWorkFileSearchDialog$3
  implements View.OnTouchListener
{
  TroopTeamWorkFileSearchDialog$3(TroopTeamWorkFileSearchDialog paramTroopTeamWorkFileSearchDialog) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      InputMethodUtil.b(paramView);
      this.a.d();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.3
 * JD-Core Version:    0.7.0.1
 */
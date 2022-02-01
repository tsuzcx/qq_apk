package com.tencent.mobileqq.teamworkforgroup;

import android.widget.EditText;

class TroopTeamWorkFileSearchDialog$6$1
  implements Runnable
{
  TroopTeamWorkFileSearchDialog$6$1(TroopTeamWorkFileSearchDialog.6 param6) {}
  
  public void run()
  {
    if (this.a.a.r)
    {
      this.a.a.n = null;
      return;
    }
    if (this.a.a.u > 0)
    {
      this.a.a.n = null;
      return;
    }
    this.a.a.t = this.a.a.h.getText().toString().trim().toLowerCase();
    this.a.a.w = 0;
    this.a.a.q = true;
    this.a.a.a(this.a.a.t);
    this.a.a.n = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.6.1
 * JD-Core Version:    0.7.0.1
 */
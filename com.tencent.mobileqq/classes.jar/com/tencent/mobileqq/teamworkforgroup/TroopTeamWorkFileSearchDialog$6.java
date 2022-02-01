package com.tencent.mobileqq.teamworkforgroup;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.rely.CountdownTimeTask;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class TroopTeamWorkFileSearchDialog$6
  implements TextWatcher
{
  TroopTeamWorkFileSearchDialog$6(TroopTeamWorkFileSearchDialog paramTroopTeamWorkFileSearchDialog) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.a.s)
    {
      this.a.s = false;
      return;
    }
    if (paramEditable == null) {
      paramEditable = "";
    } else {
      paramEditable = paramEditable.toString();
    }
    if (paramEditable.trim().equals(""))
    {
      this.a.d();
      return;
    }
    this.a.g.setVisibility(0);
    if (!NetworkUtil.isNetworkAvailable(this.a.l))
    {
      if (this.a.n != null)
      {
        this.a.n.b();
        this.a.n = null;
      }
      this.a.b();
      return;
    }
    paramEditable = this.a;
    paramEditable.r = false;
    if (paramEditable.n == null)
    {
      this.a.n = new CountdownTimeTask(new TroopTeamWorkFileSearchDialog.6.1(this), 800);
      ThreadManager.post(this.a.n, 5, null, true);
      return;
    }
    if (this.a.n.c() > 0L)
    {
      this.a.n.a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopTeamWorkFileSearchDialog", 2, "!!!!!! 这是个什么情况,逻辑出错了 !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.a.s) && ((!this.a.s) || (this.a.w > 0)))
    {
      this.a.e.setVisibility(0);
      return;
    }
    this.a.e.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.6
 * JD-Core Version:    0.7.0.1
 */
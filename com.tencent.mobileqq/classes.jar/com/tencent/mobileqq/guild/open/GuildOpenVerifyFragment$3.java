package com.tencent.mobileqq.guild.open;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressDialog.Callback;
import com.tencent.qphone.base.util.QLog;

class GuildOpenVerifyFragment$3
  implements QQProgressDialog.Callback
{
  GuildOpenVerifyFragment$3(GuildOpenVerifyFragment paramGuildOpenVerifyFragment) {}
  
  public void a()
  {
    QLog.d("QQGuildOpenVerifyFragment", 1, "onBackPressed");
    QBaseActivity localQBaseActivity = this.a.getQBaseActivity();
    if (localQBaseActivity != null) {
      localQBaseActivity.doOnBackPressed();
    }
    this.a.c.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.open.GuildOpenVerifyFragment.3
 * JD-Core Version:    0.7.0.1
 */
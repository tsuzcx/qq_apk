package com.tencent.open.agent;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressDialog.Callback;
import com.tencent.qphone.base.util.QLog;

class AuthorityControlAppDetailsFragment$10
  implements QQProgressDialog.Callback
{
  AuthorityControlAppDetailsFragment$10(AuthorityControlAppDetailsFragment paramAuthorityControlAppDetailsFragment) {}
  
  public void a()
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, "onBackPressed");
    BaseActivity localBaseActivity = this.a.getBaseActivity();
    if (localBaseActivity != null) {
      localBaseActivity.doOnBackPressed();
    }
    AuthorityControlAppDetailsFragment.a(this.a).a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment.10
 * JD-Core Version:    0.7.0.1
 */
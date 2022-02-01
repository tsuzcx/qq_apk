package com.tencent.open.agent;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressDialog.Callback;
import com.tencent.qphone.base.util.QLog;

class AuthorityControlAppDetailsFragment$6
  implements QQProgressDialog.Callback
{
  AuthorityControlAppDetailsFragment$6(AuthorityControlAppDetailsFragment paramAuthorityControlAppDetailsFragment) {}
  
  public void a()
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, "onBackPressed");
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.doOnBackPressed();
    }
    AuthorityControlAppDetailsFragment.a(this.a).a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment.6
 * JD-Core Version:    0.7.0.1
 */
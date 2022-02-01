package com.tencent.open.agent;

import android.app.Activity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.model.AppInfo;
import com.tencent.open.sdk.checker.BaseAccountChecker.DefaultAccountNotify;
import com.tencent.open.sdk.checker.BaseAccountChecker.IAccountCheckCallback;
import com.tencent.qphone.base.util.QLog;

class AuthorityControlAppDetailsFragment$4
  implements BaseAccountChecker.IAccountCheckCallback
{
  AuthorityControlAppDetailsFragment$4(AuthorityControlAppDetailsFragment paramAuthorityControlAppDetailsFragment, AppInfo paramAppInfo) {}
  
  public void a(int paramInt, String paramString)
  {
    if (AuthorityControlAppDetailsFragment.c(this.b) != null)
    {
      if (AuthorityControlAppDetailsFragment.c(this.b).isFinishing()) {
        return;
      }
      if (AuthorityControlAppDetailsFragment.d(this.b))
      {
        QLog.e("AuthorityControlAppDetailsActivity", 1, "checkAccount: timeout");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAccount: onError ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      QLog.e("AuthorityControlAppDetailsActivity", 1, localStringBuilder.toString());
      QQToast.makeText(AuthorityControlAppDetailsFragment.c(this.b), HardCodeUtil.a(2131892333), 0).show();
      AuthorityControlAppDetailsFragment.c(this.b).finish();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (AuthorityControlAppDetailsFragment.c(this.b) != null)
    {
      if (AuthorityControlAppDetailsFragment.c(this.b).isFinishing()) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAccount: onSuccess same=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("AuthorityControlAppDetailsActivity", 1, ((StringBuilder)localObject).toString());
      if (AuthorityControlAppDetailsFragment.d(this.b))
      {
        QLog.e("AuthorityControlAppDetailsActivity", 1, "checkAccount: timeout");
        return;
      }
      if (paramBoolean)
      {
        AuthorityControlAppDetailsFragment.e(this.b).runOnUiThread(new AuthorityControlAppDetailsFragment.4.1(this));
        return;
      }
      localObject = AuthorityControlAppDetailsFragment.c(this.b).getString(2131887120);
      new BaseAccountChecker.DefaultAccountNotify(AuthorityControlAppDetailsFragment.c(this.b), String.format((String)localObject, new Object[] { this.a.c() }), 1).a(new AuthorityControlAppDetailsFragment.4.2(this));
      int i = this.a.a();
      localObject = this.a.c();
      AuthorityUtil.a(AuthorityControlAppDetailsFragment.e(this.b), "0X800BAE1", 0, AuthorityControlAppDetailsFragment.g(this.b), new String[] { String.valueOf(i), "", localObject, "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment.4
 * JD-Core Version:    0.7.0.1
 */
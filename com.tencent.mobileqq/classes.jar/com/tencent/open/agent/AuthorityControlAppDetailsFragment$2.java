package com.tencent.open.agent;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.sdk.data.BasicSdkJumpInfo;
import com.tencent.qphone.base.util.QLog;

class AuthorityControlAppDetailsFragment$2
  implements AuthorityControlAppDetailsFragment.IGetAppInfoCallback
{
  AuthorityControlAppDetailsFragment$2(AuthorityControlAppDetailsFragment paramAuthorityControlAppDetailsFragment, BasicSdkJumpInfo paramBasicSdkJumpInfo) {}
  
  public void a(int paramInt, String paramString)
  {
    if (AuthorityControlAppDetailsFragment.c(this.b) != null)
    {
      if (AuthorityControlAppDetailsFragment.c(this.b).isFinishing()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAppInfo: error code=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString);
      QLog.e("AuthorityControlAppDetailsActivity", 1, localStringBuilder.toString());
      if (AuthorityControlAppDetailsFragment.d(this.b))
      {
        QLog.e("AuthorityControlAppDetailsActivity", 1, "getAppInfo: timeout");
        return;
      }
      AuthorityControlAppDetailsFragment.a(this.b, 0);
      QQToast.makeText(AuthorityControlAppDetailsFragment.c(this.b), 2131887122, 0).show();
      AuthorityControlAppDetailsFragment.c(this.b).finish();
    }
  }
  
  public void a(com.tencent.mobileqq.forward.AppInfo paramAppInfo)
  {
    if (AuthorityControlAppDetailsFragment.c(this.b) != null)
    {
      if (AuthorityControlAppDetailsFragment.c(this.b).isFinishing()) {
        return;
      }
      QLog.i("AuthorityControlAppDetailsActivity", 1, "getAppInfo: success");
      if (AuthorityControlAppDetailsFragment.d(this.b))
      {
        QLog.e("AuthorityControlAppDetailsActivity", 1, "getAppInfo: timeout");
        return;
      }
      paramAppInfo = new com.tencent.open.model.AppInfo((int)this.a.a(), paramAppInfo.d(), paramAppInfo.b());
      AuthorityControlAppDetailsFragment.e(this.b).runOnUiThread(new AuthorityControlAppDetailsFragment.2.1(this, paramAppInfo));
      AuthorityControlAppDetailsFragment.a(this.b, paramAppInfo.a(), paramAppInfo.c());
      AuthorityControlAppDetailsFragment.a(this.b, paramAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment.2
 * JD-Core Version:    0.7.0.1
 */
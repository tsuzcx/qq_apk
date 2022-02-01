package com.tencent.open.agent;

import android.os.Bundle;
import com.tencent.mobileqq.forward.AppInfo;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;

class AuthorityControlAppDetailsFragment$3
  implements OpensdkBusinessObserver
{
  AuthorityControlAppDetailsFragment$3(AuthorityControlAppDetailsFragment paramAuthorityControlAppDetailsFragment, AuthorityControlAppDetailsFragment.IGetAppInfoCallback paramIGetAppInfoCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("AuthorityControlAppDetailsActivity", 1, new Object[] { "onReceive: isSuccess = ", Boolean.valueOf(paramBoolean) });
    Object localObject;
    if (!paramBoolean)
    {
      paramInt = paramBundle.getInt("code", -1);
      paramBundle = paramBundle.getString("errorMsg", "");
      this.a.a(paramInt, paramBundle);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive: errorCode=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" errorMsg=");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("AuthorityControlAppDetailsActivity", 1, ((StringBuilder)localObject).toString());
      return;
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        localObject = new GetAppInfoProto.GetAppinfoResponse();
        ((GetAppInfoProto.GetAppinfoResponse)localObject).mergeFrom(paramBundle);
        paramBundle = AppInfo.a((GetAppInfoProto.GetAppinfoResponse)localObject);
        this.a.a(paramBundle);
        return;
      }
      QLog.e("AuthorityControlAppDetailsActivity", 1, "onReceive: data=null");
      this.a.a(-1, "data is null!");
      return;
    }
    catch (Exception paramBundle)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive: ");
      ((StringBuilder)localObject).append(paramBundle.getMessage());
      QLog.e("AuthorityControlAppDetailsActivity", 1, ((StringBuilder)localObject).toString());
      this.a.a(-1, paramBundle.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment.3
 * JD-Core Version:    0.7.0.1
 */
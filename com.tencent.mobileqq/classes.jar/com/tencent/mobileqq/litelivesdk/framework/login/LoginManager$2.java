package com.tencent.mobileqq.litelivesdk.framework.login;

import android.os.Bundle;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginRequest;
import com.tencent.falco.base.libapi.login.LoginType;
import com.tencent.livesdk.accountengine.SdkLoginCallback;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.api.login.ILiveLoginTicketListener;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.utils.AegisHelper;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class LoginManager$2
  implements SdkLoginCallback
{
  LoginManager$2(LoginManager paramLoginManager, LoginRequest paramLoginRequest) {}
  
  public void onFail(int paramInt, String paramString)
  {
    LoginManager.a(this.b, LoginStatus.NoLogin);
    AegisHelper.a(String.format("livesdk 登录失败 errcode = %d, errMsg =%s, appid = %s, id = %s, token = %s, loginType = %d", new Object[] { Integer.valueOf(paramInt), paramString, this.a.appid, this.a.id, this.a.token, Integer.valueOf(this.a.loginType.ordinal()) }), "LoginManager");
    LogFactory.a().e("LoginManager", String.format("loginToLiveSDK----livesdk 登录失败 errcode = %d, errMsg =%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    if (paramInt == 1007)
    {
      localObject = this.b;
      int i = ((LoginManager)localObject).a + 1;
      ((LoginManager)localObject).a = i;
      if (i > 2)
      {
        AegisHelper.a("登录重试超过2次后停止重试", "LoginManager");
        localObject = (List)this.b.b.get(BusinessManager.a.b().a);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            ((ILiveLoginTicketListener)((Iterator)localObject).next()).a(paramInt, paramString);
          }
        }
        if (LoginManager.a(this.b))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("Key_ErrCode", paramInt);
          ((Bundle)localObject).putString("Key_ErrMsg", paramString);
          QIPCClientHelper.getInstance().getClient().callServer("LiteSDKServerModuleName", "Action_Server_OnLoginFailed", (Bundle)localObject);
        }
        return;
      }
      this.b.a();
      return;
    }
    Object localObject = (List)this.b.b.get(BusinessManager.a.b().a);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ILiveLoginTicketListener)((Iterator)localObject).next()).a(paramInt, paramString);
      }
    }
    if (LoginManager.a(this.b))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("Key_ErrCode", paramInt);
      ((Bundle)localObject).putString("Key_ErrMsg", paramString);
      QIPCClientHelper.getInstance().getClient().callServer("LiteSDKServerModuleName", "Action_Server_OnLoginFailed", (Bundle)localObject);
    }
  }
  
  public void onSucceed(LoginInfo paramLoginInfo)
  {
    LoginManager.a(this.b, LoginStatus.Logined);
    if (this.b.a != 0) {
      this.b.a = 0;
    }
    LogInterface localLogInterface = LogFactory.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loginToLiveSDK onSucceed --loginInfo=");
    localStringBuilder.append(paramLoginInfo);
    localLogInterface.c("LoginManager", localStringBuilder.toString());
    paramLoginInfo = LoginManager.a(this.b, paramLoginInfo);
    LoginManager.a(this.b, paramLoginInfo);
    LoginManager.b(this.b, paramLoginInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.framework.login.LoginManager.2
 * JD-Core Version:    0.7.0.1
 */
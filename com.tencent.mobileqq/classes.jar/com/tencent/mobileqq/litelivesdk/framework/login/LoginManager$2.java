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
    LoginManager.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginManager, LoginStatus.NoLogin);
    AegisHelper.a(String.format("livesdk 登录失败 errcode = %d, errMsg =%s, appid = %s, id = %s, token = %s, loginType = %d", new Object[] { Integer.valueOf(paramInt), paramString, this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginRequest.appid, this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginRequest.id, this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginRequest.token, Integer.valueOf(this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginRequest.loginType.ordinal()) }), "LoginManager");
    LogFactory.a().e("LoginManager", String.format("loginToLiveSDK----livesdk 登录失败 errcode = %d, errMsg =%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    if (paramInt == 1007)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginManager;
      int i = ((LoginManager)localObject).jdField_a_of_type_Int + 1;
      ((LoginManager)localObject).jdField_a_of_type_Int = i;
      if (i > 2)
      {
        AegisHelper.a("登录重试超过2次后停止重试", "LoginManager");
        localObject = (List)this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginManager.jdField_a_of_type_JavaUtilMap.get(BusinessManager.a.a().a);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            ((ILiveLoginTicketListener)((Iterator)localObject).next()).a(paramInt, paramString);
          }
        }
        if (LoginManager.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginManager))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("Key_ErrCode", paramInt);
          ((Bundle)localObject).putString("Key_ErrMsg", paramString);
          QIPCClientHelper.getInstance().getClient().callServer("LiteSDKServerModuleName", "Action_Server_OnLoginFailed", (Bundle)localObject);
        }
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginManager.a();
      return;
      localObject = (List)this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginManager.jdField_a_of_type_JavaUtilMap.get(BusinessManager.a.a().a);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ILiveLoginTicketListener)((Iterator)localObject).next()).a(paramInt, paramString);
        }
      }
    } while (!LoginManager.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginManager));
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("Key_ErrCode", paramInt);
    ((Bundle)localObject).putString("Key_ErrMsg", paramString);
    QIPCClientHelper.getInstance().getClient().callServer("LiteSDKServerModuleName", "Action_Server_OnLoginFailed", (Bundle)localObject);
  }
  
  public void onSucceed(LoginInfo paramLoginInfo)
  {
    LoginManager.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginManager, LoginStatus.Logined);
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginManager.jdField_a_of_type_Int != 0) {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginManager.jdField_a_of_type_Int = 0;
    }
    LogFactory.a().c("LoginManager", "loginToLiveSDK onSucceed --loginInfo=" + paramLoginInfo);
    paramLoginInfo = LoginManager.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginManager, paramLoginInfo);
    LoginManager.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginManager, paramLoginInfo);
    LoginManager.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginManager, paramLoginInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.framework.login.LoginManager.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.litelivesdk.framework.login;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginRequest;
import com.tencent.falco.base.libapi.login.LoginType;
import com.tencent.ilive.LiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest;
import com.tencent.mobileqq.litelivesdk.api.login.ILiveLoginTicketListener;
import com.tencent.mobileqq.litelivesdk.api.login.LoginResult;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.utils.HexUtil;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LoginManager
{
  public static LoginManager a;
  int jdField_a_of_type_Int = 0;
  private LoginRequest jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginRequest;
  private LoginResult jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginLoginResult;
  private LoginStatus jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginStatus = LoginStatus.NoLogin;
  Map<String, List<ILiveLoginTicketListener>> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginManager = new LoginManager();
  }
  
  public static LoginRequest a(BizLoginRequest paramBizLoginRequest)
  {
    LoginRequest localLoginRequest = new LoginRequest();
    String str1 = paramBizLoginRequest.g;
    String str2 = paramBizLoginRequest.f;
    localLoginRequest.id = str1;
    localLoginRequest.token = str2;
    localLoginRequest.appid = String.valueOf(paramBizLoginRequest.b);
    switch (paramBizLoginRequest.jdField_a_of_type_Int)
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      LogFactory.a().b("LoginManager", "do NowLive login, type is unknow:" + paramBizLoginRequest.jdField_a_of_type_Int);
    }
    for (;;)
    {
      localLoginRequest.initOpenSDK = false;
      return localLoginRequest;
      LogFactory.a().b("LoginManager", "do NowLive login, type is wt");
      localLoginRequest.loginType = LoginType.QQ;
      localLoginRequest.id = paramBizLoginRequest.c;
      localLoginRequest.token = paramBizLoginRequest.d;
      localLoginRequest.customExtData = "0";
      continue;
      LogFactory.a().b("LoginManager", "do NowLive login, type is qq_connect");
      localLoginRequest.loginType = LoginType.QQ;
      localLoginRequest.customExtData = "18";
      continue;
      LogFactory.a().b("LoginManager", "do NowLive login, type is wx");
      localLoginRequest.loginType = LoginType.WX;
      localLoginRequest.customExtData = "9";
      continue;
      localLoginRequest.loginType = LoginType.GUEST;
      localLoginRequest.customExtData = "2";
    }
  }
  
  private LoginResult a(LoginInfo paramLoginInfo)
  {
    LoginResult localLoginResult = new LoginResult();
    localLoginResult.c = BusinessManager.a.a().jdField_a_of_type_JavaLangString;
    localLoginResult.d = Integer.toString(BusinessManager.a.a().d);
    localLoginResult.e = HexUtil.a(paramLoginInfo.a2);
    localLoginResult.f = Long.toString(paramLoginInfo.tinyid);
    localLoginResult.jdField_a_of_type_Long = paramLoginInfo.uid;
    localLoginResult.jdField_a_of_type_Int = paramLoginInfo.loginType.ordinal();
    localLoginResult.jdField_a_of_type_JavaLangString = paramLoginInfo.openId;
    localLoginResult.b = paramLoginInfo.access_token;
    return localLoginResult;
  }
  
  private void a(LoginResult paramLoginResult)
  {
    Object localObject = (List)this.jdField_a_of_type_JavaUtilMap.get(BusinessManager.a.a().jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ILiveLoginTicketListener)((Iterator)localObject).next()).a(paramLoginResult);
      }
    }
    if (a())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("Key_BizLoginRequest", paramLoginResult);
      QIPCClientHelper.getInstance().getClient().callServer("LiteSDKServerModuleName", "Action_Server_OnLoginSuccess", (Bundle)localObject);
    }
  }
  
  private boolean a()
  {
    return BaseApplicationImpl.getApplication().getQQProcessName().equals("com.tencent.mobileqq:tool");
  }
  
  public LoginRequest a()
  {
    return this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginRequest;
  }
  
  public LoginResult a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginLoginResult;
  }
  
  public void a()
  {
    LogFactory.a().e("LoginManager", "notifyHostRefreshTicket----will refresh Login Token!");
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginStatus = LoginStatus.NoLogin;
    Object localObject = (List)this.jdField_a_of_type_JavaUtilMap.get(BusinessManager.a.a().jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ILiveLoginTicketListener localILiveLoginTicketListener = (ILiveLoginTicketListener)((Iterator)localObject).next();
        localILiveLoginTicketListener.a(2, new LoginManager.1(this, localILiveLoginTicketListener));
      }
    }
    if (a()) {
      QIPCClientHelper.getInstance().getClient().callServer("LiteSDKServerModuleName", "Action_Server_OnRefreshToken", null);
    }
  }
  
  public void a(LoginRequest paramLoginRequest)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginStatus == LoginStatus.Logined) || (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginStatus == LoginStatus.Logining))
    {
      LogFactory.a().e("LoginManager", "loginToLiveSDK-----already logined or Logining, will Return");
      a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginLoginResult);
      return;
    }
    LogFactory.a().e("LoginManager", "loginToLiveSDK-----Start Login");
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginRequest = paramLoginRequest;
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginStatus = LoginStatus.Logining;
    LiveSDK.login(paramLoginRequest, new LoginManager.2(this, paramLoginRequest));
  }
  
  public void a(String paramString, ILiveLoginTicketListener paramILiveLoginTicketListener)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    }
    ((List)localObject).clear();
    ((List)localObject).add(paramILiveLoginTicketListener);
  }
  
  public void b()
  {
    LogFactory.a().e("LoginManager", "clear-----will clear LoginInfo");
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginLoginResult = null;
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginRequest = null;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginStatus = LoginStatus.NoLogin;
  }
  
  public void c()
  {
    LogFactory.a().e("LoginManager", "logout-----will logout");
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginLoginResult = null;
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginRequest = null;
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkLoginLoginStatus = LoginStatus.NoLogin;
    this.jdField_a_of_type_JavaUtilMap.remove(BusinessManager.a.a().jdField_a_of_type_JavaLangString);
    LiveSDK.logout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.framework.login.LoginManager
 * JD-Core Version:    0.7.0.1
 */
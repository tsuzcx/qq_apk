package com.tencent.mobileqq.qroute.route.generated;

import com.tencent.mobileqq.qroute.route.BaseRouteInitializer;

public class DefaultRouteInitializer
  extends BaseRouteInitializer
{
  public void init()
  {
    register("com.tencent.mobileqq.activity.AboutActivity$RouteInit");
    register("/pubaccount/detail", "com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl");
    register("/pubaccount/browser", "com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl");
    register("/base/login", "com.tencent.mobileqq.activity.LoginActivity");
    register("/base/safe/loginInfo", "com.tencent.mobileqq.activity.LoginInfoActivity");
    register("/base/safe/authDevUgActivity", "com.tencent.mobileqq.activity.AuthDevUgActivity");
    register("/base/payBridge", "com.tencent.mobileqq.activity.PayBridgeActivity");
    register("/cmshow/store/guestStateActivity", "com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity");
    register("/base/login/authDevVerifyCodeOpenSdk", "com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2");
    register("/base/safe/loginPhoneNumActivity", "com.tencent.mobileqq.activity.LoginPhoneNumActivity");
    register("/base/browser", "com.tencent.mobileqq.activity.QQBrowserActivity");
    register("/base/notification", "com.tencent.mobileqq.activity.NotificationActivity");
    register("/base/start/splash", "com.tencent.mobileqq.activity.SplashActivity");
    register("/base/safe/authDevActivity", "com.tencent.mobileqq.activity.AuthDevActivity");
    register("/qwallet/redpacket/sendhb", "com.tencent.mobileqq.activity.qwallet.SendHbActivity");
    register("/base/login/authDevVerifyCode", "com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity");
    register("/qwallet/redpacket/QrcodeHbGuider", "com.tencent.mobileqq.activity.qwallet.QrcodeHbGuiderActivity");
    register("/base/safe/registerByNickAndPwd", "com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity");
    register("/cmshow/store/floatActivity", "com.tencent.mobileqq.apollo.store.ApolloFloatActivity");
    register("/base/register/registerPhoneNumber", "com.tencent.mobileqq.activity.RegisterPhoneNumActivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.generated.DefaultRouteInitializer
 * JD-Core Version:    0.7.0.1
 */
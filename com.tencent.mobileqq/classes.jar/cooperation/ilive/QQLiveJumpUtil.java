package cooperation.ilive;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig.Builder;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig;
import com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig.Builder;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.timi.game.api.ITimiGameApi;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class QQLiveJumpUtil
{
  public static void a()
  {
    IQQLiveSDK localIQQLiveSDK = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1037");
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    localIQQLiveSDK.init(localAppRuntime, QQLiveSDKConfig.createBuilder().build());
    ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(10001).a(localAppRuntime, QQGiftSDKConfig.a().a(10001).a("2ba343368f5483089089ae290adf298f").a());
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).initLiveModule(MobileQQ.context);
  }
  
  public static void a(Context paramContext, boolean paramBoolean, Intent paramIntent)
  {
    ((IQQLiveUtil)QRoute.api(IQQLiveUtil.class)).enterAnchorPrepareFragment(paramContext, paramBoolean, paramIntent);
  }
  
  public static void b()
  {
    IQQLiveSDK localIQQLiveSDK = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1037");
    LoginRequest localLoginRequest = new LoginRequest();
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    localLoginRequest.uin = localAppRuntime.getCurrentUin();
    localLoginRequest.qqA2 = ((TicketManager)localAppRuntime.getManager(2)).getA2(localLoginRequest.uin);
    localIQQLiveSDK.getLoginModule().login(localLoginRequest, new QQLiveJumpUtil.1());
  }
  
  public static void c()
  {
    ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1037").getLoginModule().logOut();
  }
  
  public static void d()
  {
    ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).destroySDKImpl("1037");
    ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).destroySDKImpl(10001);
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).destroyLiveModule();
  }
  
  public static boolean e()
  {
    IQQLiveSDK localIQQLiveSDK = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1037");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localIQQLiveSDK != null)
    {
      bool1 = bool2;
      if (localIQQLiveSDK.getCurRoomInfo() != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean f()
  {
    Object localObject = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1037");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((IQQLiveSDK)localObject).getCurRoomInfo();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((QQLiveCurRoomInfo)localObject).roomType == 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.QQLiveJumpUtil
 * JD-Core Version:    0.7.0.1
 */
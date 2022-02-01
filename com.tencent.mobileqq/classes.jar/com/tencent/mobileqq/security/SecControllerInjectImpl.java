package com.tencent.mobileqq.security;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.nearby.gameroom.IGameRoomAVControllerDelegate;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qqsec.api.ISecControllerInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.ReportLog;
import cooperation.qwallet.plugin.PatternLockUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class SecControllerInjectImpl
  implements ISecControllerInterface
{
  public ArrayList<String> a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    paramBaseQQAppInterface = (ISubAccountService)paramBaseQQAppInterface.getRuntimeService(ISubAccountService.class, "");
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.getAllSubUin();
    }
    return null;
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    MyAppApi.a().a(paramString, new SecControllerInjectImpl.1(this, paramActivity), paramActivity);
  }
  
  public void a(Activity paramActivity, JSONObject paramJSONObject)
  {
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramJSONObject.toString());
    localBundle.putString("callbackSn", "lhPaySn");
    localIntent.putExtras(localBundle);
    localIntent.putExtra("payparmas_from_is_login_state", false);
    localIntent.putExtra("pay_requestcode", 4);
    paramActivity.startActivityForResult(localIntent, 1);
  }
  
  public void a(Context paramContext, String paramString)
  {
    PatternLockUtils.setFirstEnterAfterLoginState(paramContext, paramString, true);
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QQPlayerService.a()) {
        paramContext.sendBroadcast(new Intent("qqplayer_exit_action"));
      }
    }
    else {
      paramContext.sendBroadcast(new Intent("qqplayer_exit_action"));
    }
    if (paramBoolean2) {
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).hideFloatView();
    }
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    paramBaseQQAppInterface = (ConfigHandler)paramBaseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
    if (paramBaseQQAppInterface != null) {
      paramBaseQQAppInterface.b();
    }
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, ProgressDialog paramProgressDialog)
  {
    ReportLog.a(paramBaseQQAppInterface.getAccount());
    ((QQAppInterface)paramBaseQQAppInterface).getServerConfigValue(ServerConfigManager.ConfigType.app, "log_upload");
    Object localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject2 != null)
    {
      Object localObject1 = (TicketManager)((AppRuntime)localObject2).getManager(2);
      localObject2 = ((AppRuntime)localObject2).getAccount();
      if (localObject1 != null) {
        localObject1 = ((TicketManager)localObject1).getSkey((String)localObject2);
      } else {
        localObject1 = "";
      }
      if (QLog.isColorLevel()) {
        QLog.d("SecControllerInjectImpl", 2, new Object[] { " NotificationActivity crash uin=", localObject2, ",skey=", localObject1 });
      }
      ReportLog.a((HttpCommunicator)((IHttpEngineService)paramBaseQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator(), paramBaseQQAppInterface.getApp(), paramProgressDialog, (String)localObject2, (String)localObject1);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    ((QQAppInterface)paramQBaseActivity.getAppRuntime()).startSecurityScan();
  }
  
  public void a(QBaseActivity paramQBaseActivity, boolean paramBoolean, String paramString)
  {
    Intent localIntent = new Intent(paramQBaseActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramQBaseActivity.startActivity(localIntent);
    if ((paramBoolean) && (((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).isBlockNotifyActivity(paramQBaseActivity)) && (!paramQBaseActivity.isFinishing()))
    {
      ((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).enableJumpLoginFromFund(paramQBaseActivity);
      return;
    }
    paramQBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.security.SecControllerInjectImpl
 * JD-Core Version:    0.7.0.1
 */
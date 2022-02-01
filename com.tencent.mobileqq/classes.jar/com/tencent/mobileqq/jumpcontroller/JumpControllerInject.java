package com.tencent.mobileqq.jumpcontroller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.av.utils.GVideoGrayConfig;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataMigrationService;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.parser.JumpActivityHelper;
import com.tencent.mobileqq.app.parser.jumpcontroller.IJumpControllerInterface;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.haoliyou.JumpForwardSecurityCheck;
import com.tencent.mobileqq.haoliyou.UriParserPathHelper;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.pushnotice.ThirdPushNotifyManager;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantConf;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qassistant.config.QAssistantConfigItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.data.InviteToGroupInfo;
import com.tencent.mobileqq.troop.data.JoinGroupInfo;
import com.tencent.mobileqq.troop.utils.NearbyVideoChatManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mqp.app.sec.SecShareInfoUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.LoginHelper;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.troop.NearbyVideoChatProxyActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class JumpControllerInject
  implements IJumpControllerInterface
{
  public Boolean a(JumpActivity paramJumpActivity, Uri paramUri)
  {
    if (paramUri != null) {
      try
      {
        boolean bool2 = UriParserPathHelper.a(paramUri, paramJumpActivity);
        boolean bool1 = false;
        QLog.d("JumpControllerInject", 1, new Object[] { "system share.doShareCheckNeedSDPermission() canReadFromUri=", Boolean.valueOf(bool2) });
        if (!bool2) {
          bool1 = true;
        }
        return Boolean.valueOf(bool1);
      }
      catch (Exception paramJumpActivity)
      {
        paramUri = new StringBuilder();
        paramUri.append("injectCheckSDPermissionWithFP error: ");
        paramUri.append(paramJumpActivity);
        QLog.e("JumpControllerInject", 1, paramUri.toString());
      }
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    QQProxyForQlink.a(paramContext, 7, null);
  }
  
  public void a(Intent paramIntent, JumpActivity paramJumpActivity)
  {
    ForwardBaseOption.a(paramJumpActivity, paramIntent);
  }
  
  public void a(JumpActivity paramJumpActivity)
  {
    SecShareInfoUtil.a().a(paramJumpActivity, null);
  }
  
  public void a(JumpActivity paramJumpActivity, long paramLong, String paramString)
  {
    Intent localIntent = new Intent(paramJumpActivity, ((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).getReadInJoyDeliverVideoActivityClazz());
    localIntent.putExtra("arg_is_from_wang_zhe", true);
    localIntent.putExtra("arg_wang_zhe_app_id", paramLong);
    paramJumpActivity.startActivity(localIntent);
    if (!TextUtils.isEmpty(paramString)) {
      ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(paramString, paramJumpActivity.getAppRuntime().getCurrentUin());
    }
  }
  
  public void a(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    GVideoGrayConfig.a((QQAppInterface)paramJumpActivity.getAppRuntime(), paramJumpActivity, paramIntent, 1);
  }
  
  public void a(JumpActivity paramJumpActivity, Intent paramIntent, int paramInt)
  {
    JumpForwardSecurityCheck localJumpForwardSecurityCheck = new JumpForwardSecurityCheck(paramJumpActivity, paramJumpActivity);
    paramJumpActivity.showDialog();
    paramJumpActivity.mBgHandler.post(new JumpControllerInject.1(this, localJumpForwardSecurityCheck, paramIntent, paramInt, paramJumpActivity));
  }
  
  public void a(JumpActivity paramJumpActivity, Intent paramIntent, Uri paramUri)
  {
    if (paramUri != null)
    {
      Object localObject2 = paramUri.getQueryParameter("jumpaction");
      QLog.d("JumpControllerInject", 1, String.format("mqqaudioassistant Jump args host = %s, \nPath = %s, \ntype = %s \nEXTRA_TEXT = %s", new Object[] { paramUri.getHost(), paramUri.getPath(), paramUri.getQueryParameter("type"), paramIntent.getStringExtra("android.intent.extra.TEXT") }));
      Object localObject1 = (IVoiceAssistantConf)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IVoiceAssistantConf.class, "");
      paramUri = paramUri.getHost();
      if (((IVoiceAssistantConf)localObject1).checkHostIsSupport(paramUri))
      {
        localObject1 = ((IVoiceAssistantConf)localObject1).findItemByOpenJumpAction((String)localObject2, paramUri);
        if (localObject1 != null)
        {
          if (((QAssistantConfigItem)localObject1).i.size() > 0)
          {
            localObject2 = ((QAssistantConfigItem)localObject1).i.keySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str1 = (String)((Iterator)localObject2).next();
              if (paramIntent.hasExtra(str1))
              {
                String str2 = paramIntent.getStringExtra(str1);
                if (!StringUtil.isEmpty(str2)) {
                  ((QAssistantConfigItem)localObject1).i.put(str1, str2);
                }
              }
            }
          }
          ((QAssistantConfigItem)localObject1).h = paramUri;
          ((QAssistantConfigItem)localObject1).a(paramJumpActivity);
          return;
        }
        ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).reportQAssistantJumpMonitor(paramUri, (String)localObject2, 2);
        QLog.d("JumpControllerInject", 1, "mqqaudioassistant Jump item = null");
        return;
      }
      ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).reportQAssistantJumpMonitor(paramUri, "", 1);
      return;
    }
    ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).reportQAssistantJumpMonitor("", "", 101);
  }
  
  public void a(JumpActivity paramJumpActivity, String paramString1, String paramString2)
  {
    if ("9971".equals(paramString1))
    {
      SmartDeviceUtil.a((QQAppInterface)paramJumpActivity.getAppRuntime(), paramJumpActivity, null, "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html?from=2", null);
      return;
    }
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)((QQAppInterface)paramJumpActivity.getAppRuntime()).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = localSmartDeviceProxyMgr.g(Long.parseLong(paramString1));
    if ((localDeviceInfo != null) && (paramString1.equals(String.valueOf(localDeviceInfo.din))))
    {
      localSmartDeviceProxyMgr.a(paramJumpActivity, localDeviceInfo, false, null);
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = new Intent();
      paramString1.setClass(paramJumpActivity, QQBrowserActivity.class);
      paramString1.putExtra("url", paramString2);
      paramString1.putExtra("title", HardCodeUtil.a(2131903849));
      paramString1.putExtra("webStyle", "noBottomBar");
      paramString1.putExtra("hide_more_button", true);
      paramString1.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
      paramString1.putExtra("leftViewText", HardCodeUtil.a(2131901576));
      paramJumpActivity.startActivity(paramString1);
      return;
    }
    ToastUtil.a().a(HardCodeUtil.a(2131903854));
  }
  
  public void a(JumpActivity paramJumpActivity, DevlockInfo paramDevlockInfo)
  {
    DevlockPhoneStatus localDevlockPhoneStatus = DevlockPhoneStatus.a();
    if ((localDevlockPhoneStatus != null) && (localDevlockPhoneStatus.b() == DevlockPhoneStatus.d))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("mqq.intent.action.DEVLOCK_ROAM");
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramDevlockInfo != null)
      {
        bool1 = bool2;
        if (paramDevlockInfo.DevSetup == 1) {
          bool1 = true;
        }
      }
      localIntent.putExtra("auth_dev_open", bool1);
      localIntent.putExtra("guardphone_state", localDevlockPhoneStatus.b());
      if (paramDevlockInfo != null) {
        paramDevlockInfo = paramDevlockInfo.Mobile;
      } else {
        paramDevlockInfo = "";
      }
      localIntent.putExtra("guardphone_mask", paramDevlockInfo);
      paramJumpActivity.sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    JumpActivityHelper.b(paramJumpActivity, paramDevlockInfo);
  }
  
  public void a(JumpActivity paramJumpActivity, boolean paramBoolean)
  {
    PermissionUtils.requestStorePermission(paramJumpActivity, 3, new JumpControllerInject.2(this, paramJumpActivity, paramBoolean));
  }
  
  public void a(JumpActivity paramJumpActivity, boolean paramBoolean, Intent paramIntent)
  {
    Object localObject = paramJumpActivity.getIntent();
    if (localObject == null) {
      return;
    }
    int i;
    int j;
    try
    {
      i = ((Intent)localObject).getIntExtra("busi_type", -1);
      j = ((Intent)localObject).getIntExtra("verify_type", -1);
    }
    catch (Exception localException)
    {
      QLog.d("JumpControllerInject", 1, "onWebSecVerifyResult", localException);
      i = -1;
      j = -1;
    }
    String str = null;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("ticket");
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.security_verify", 2, String.format("onWebSecVerifyResult, isSuc: %s, busiType: %s, verifyType: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j) }));
    }
    paramIntent = ((Intent)localObject).getParcelableExtra("extra_data");
    if (i != 0)
    {
      if ((i == 1) && ((paramIntent instanceof InviteToGroupInfo)))
      {
        paramIntent = (InviteToGroupInfo)paramIntent;
        localObject = (ITroopMngHandler)((AppInterface)paramJumpActivity.getAppRuntime()).getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
        if ((paramBoolean) && (paramIntent != null) && (!TextUtils.isEmpty(str)))
        {
          paramIntent.d = j;
          paramIntent.e = str;
          ((ITroopMngHandler)localObject).a(paramIntent);
        }
        else
        {
          ((ITroopMngHandler)localObject).a(TroopMngObserver.d, false, new Object[] { Integer.valueOf(8), Integer.valueOf(-1) });
        }
      }
    }
    else if ((paramIntent instanceof JoinGroupInfo))
    {
      paramIntent = (JoinGroupInfo)paramIntent;
      localObject = (ITroopMngHandler)((AppInterface)paramJumpActivity.getAppRuntime()).getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
      if ((paramBoolean) && (paramIntent != null) && (!TextUtils.isEmpty(str)))
      {
        paramIntent.h = j;
        paramIntent.i = str;
        ((ITroopMngHandler)localObject).a(paramIntent);
      }
      else
      {
        ((ITroopMngHandler)localObject).a(TroopMngObserver.d, false, new Object[] { Integer.valueOf(1), Integer.valueOf(-1) });
      }
    }
    paramJumpActivity.finish();
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    LoginHelper.a(paramQBaseActivity.getAppRuntime());
  }
  
  public boolean a(JumpActivity paramJumpActivity, String paramString)
  {
    return (GesturePWDUtils.getJumpLock(paramJumpActivity, paramJumpActivity.getAppRuntime().getCurrentAccountUin())) && (!BaseGesturePWDUtil.getAppForground(paramJumpActivity)) && (!PatternLockUtils.isOpenQWalletLockWhenJumpToQWallet(paramJumpActivity, (QQAppInterface)paramJumpActivity.getAppRuntime(), paramString));
  }
  
  public void b(Context paramContext)
  {
    ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).startFM(paramContext);
    FileManagerReporter.a("0X8005533");
  }
  
  public void b(JumpActivity paramJumpActivity, long paramLong, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("is_from_king_moment", true);
    localIntent.putExtra("king_moment_cover_url", paramString);
    localIntent.putExtra("arg_wang_zhe_app_id", paramLong);
    RouteUtils.a(paramJumpActivity, localIntent, "/base/login");
  }
  
  public void b(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    paramIntent.addFlags(524288);
    paramIntent.addFlags(134217728);
    paramIntent.putExtra("url", "https://sqimg.qq.com/qq_product_operations/kan/violaLibs/bundle_feeds.js");
    paramIntent.putExtra("title_name", "QQ看点");
    QPublicFragmentActivity.start(paramJumpActivity.getActivity(), paramIntent, ViolaFragment.class);
    paramJumpActivity.getActivity().overridePendingTransition(2130772014, 0);
    paramJumpActivity.finish();
  }
  
  public String c(Context paramContext)
  {
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = ((BaseActivity)paramContext).getSupportFragmentManager().getFragments();
      if (paramContext != null)
      {
        if (paramContext.size() <= 0) {
          return "";
        }
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          Object localObject2 = (Fragment)paramContext.next();
          if (((Fragment)localObject2).isVisible())
          {
            Object localObject1 = localObject2.getClass().getName();
            paramContext = (Context)localObject1;
            if ((localObject2 instanceof MainFragment))
            {
              paramContext = (MainFragment)localObject2;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append("$");
              localStringBuilder.append(paramContext.g());
              paramContext = localStringBuilder.toString();
            }
            localObject1 = paramContext;
            if ((localObject2 instanceof ChatFragment))
            {
              localObject2 = (ChatFragment)localObject2;
              localObject1 = paramContext;
              if (((ChatFragment)localObject2).c != null)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramContext);
                ((StringBuilder)localObject1).append("$");
                ((StringBuilder)localObject1).append(((ChatFragment)localObject2).c.F());
                localObject1 = ((StringBuilder)localObject1).toString();
              }
            }
            return localObject1;
          }
        }
      }
    }
    return "";
  }
  
  public boolean c(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    if (!ThridAppShareHelper.a().a(String.valueOf(Long.valueOf(paramIntent.getLongExtra("req_share_id", 0L)))))
    {
      paramJumpActivity.finish();
      return false;
    }
    Intent localIntent = new Intent(paramJumpActivity, SplashActivity.class);
    localIntent.putExtras(paramIntent.getExtras());
    paramJumpActivity.startActivity(AIOUtils.a(localIntent, null));
    return false;
  }
  
  public void d(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramJumpActivity, DataMigrationService.class);
    localIntent.setAction("com.tencent.mobileqq.action.MIGRATION_DATA");
    localIntent.putExtras(paramIntent);
    try
    {
      paramJumpActivity.startService(localIntent);
    }
    catch (Throwable paramIntent)
    {
      QLog.e("JumpControllerInject", 1, "mqqdatamigration", paramIntent);
    }
    paramJumpActivity.finish();
  }
  
  public void e(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    NearbyVideoChatManager localNearbyVideoChatManager = (NearbyVideoChatManager)paramJumpActivity.getAppRuntime().getManager(QQManagerFactory.NEARBY_VIDEO_CHAT);
    NearbyVideoChatProxyActivity.a((QQAppInterface)paramJumpActivity.getAppRuntime(), paramJumpActivity, paramIntent, localNearbyVideoChatManager.a(), null, 123987);
  }
  
  public boolean f(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    return ThirdPushNotifyManager.a().a(paramJumpActivity, paramIntent, paramJumpActivity.getAppRuntime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jumpcontroller.JumpControllerInject
 * JD-Core Version:    0.7.0.1
 */
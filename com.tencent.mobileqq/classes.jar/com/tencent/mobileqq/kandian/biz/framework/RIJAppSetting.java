package com.tencent.mobileqq.kandian.biz.framework;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyStringUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyPageItemCache;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyFragment;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class RIJAppSetting
{
  public static int a;
  public static volatile boolean b;
  public static Map<String, MessageForStructing> c;
  public static Object d;
  public static int e = -1;
  public static TabChannelCoverInfo f = RIJXTabConfigHandler.INSTANCE.getDefaultEnterTabInfo();
  private static volatile boolean g;
  private static long h;
  
  static
  {
    int i;
    if (RIJShowKanDianTabSp.c()) {
      i = 3;
    } else {
      i = 1;
    }
    a = i;
    b = false;
    c = new HashMap();
    d = new Object();
    g = true;
  }
  
  public static int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 70) {
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  public static SystemBarCompact a(Activity paramActivity)
  {
    return new SystemBarCompact(paramActivity, true, -1);
  }
  
  public static String a()
  {
    return a(-1L);
  }
  
  public static String a(long paramLong)
  {
    boolean bool;
    if (b() == 6) {
      bool = true;
    } else {
      bool = false;
    }
    int i;
    if (paramLong == 1004L)
    {
      if (bool) {
        i = ReadInJoyHelper.e(BaseApplicationImpl.getApplication().getRuntime(), 0);
      } else {
        i = ReadInJoyHelper.c(BaseApplicationImpl.getApplication().getRuntime(), 0);
      }
    }
    else if (bool) {
      i = ReadInJoyHelper.i(BaseApplicationImpl.getApplication().getRuntime());
    } else {
      i = ReadInJoyHelper.h(BaseApplicationImpl.getApplication().getRuntime());
    }
    String str = "1";
    if (i == 0) {
      str = "2";
    } else if ((i != 1) && (i == 2)) {
      str = "0";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getVideoAutoPlaySetting(),isVideoFlowEnter = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(",localSettingDefaultValue=");
      localStringBuilder.append(str);
      localStringBuilder.append(", remoteSettingDefaultValue=");
      localStringBuilder.append(i);
      localStringBuilder.append(" channelFrom:");
      localStringBuilder.append(paramLong);
      QLog.d("RIJAppSetting", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  public static void a(Activity paramActivity, Frame paramFrame, boolean paramBoolean, View paramView, int paramInt)
  {
    if ((ThemeUtil.isDefaultOrDIYTheme(false)) && (paramBoolean))
    {
      boolean bool = ImmersiveUtils.supportStatusBarDarkMode();
      int i = 9216;
      if (bool)
      {
        ImmersiveUtils.setStatusBarDarkMode(paramActivity.getWindow(), true);
        if ((VersionUtils.k()) && (SystemUtil.d()))
        {
          if (!paramBoolean) {
            i = 1280;
          }
          paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
        }
        paramView.setBackgroundColor(-1);
      }
      else if ((VersionUtils.k()) && (!SystemUtil.d()) && (!SystemUtil.g()))
      {
        paramActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        paramView.setBackgroundColor(-1);
      }
      else
      {
        paramView.setBackgroundColor(-16777216);
      }
      if (paramInt == 1) {
        paramFrame.a(paramView, true);
      }
    }
    else
    {
      if ((ImmersiveUtils.supportStatusBarDarkMode()) && ((!VersionUtils.k()) || (!SystemUtil.d()))) {
        ImmersiveUtils.setStatusBarDarkMode(paramActivity.getWindow(), false);
      }
      paramFrame.a(paramView, false);
    }
  }
  
  public static void a(Activity paramActivity, Frame paramFrame, boolean paramBoolean, ImmersiveTitleBar2 paramImmersiveTitleBar2, int paramInt)
  {
    a(paramActivity, paramFrame, paramBoolean, paramImmersiveTitleBar2, paramInt);
    SimpleUIUtil.a(paramImmersiveTitleBar2, paramActivity.getWindow());
  }
  
  public static void a(Activity paramActivity, ImmersiveTitleBar2 paramImmersiveTitleBar2)
  {
    if (VersionUtils.k()) {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
    }
    SimpleUIUtil.a(paramImmersiveTitleBar2, paramActivity.getWindow());
  }
  
  @TargetApi(23)
  public static void a(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, SystemBarCompact paramSystemBarCompact)
  {
    if (paramActivity != null)
    {
      if (paramSystemBarCompact == null) {
        return;
      }
      if ((paramBoolean) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        paramActivity.getWindow().addFlags(67108864);
        paramSystemBarCompact.init();
        if (ThemeUtil.isNowThemeIsNight(RIJQQAppInterfaceUtil.e(), false, null))
        {
          if ((!SystemUtil.d()) && (!SystemUtil.g()))
          {
            paramSystemBarCompact.setStatusBarColor(-7829368);
            return;
          }
          paramSystemBarCompact.setStatusBarColor(-7829368);
          paramSystemBarCompact.setStatusBarDarkMode(true);
          return;
        }
        if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
        {
          a(paramActivity, true);
          paramSystemBarCompact.setStatusBarColor(-1);
          return;
        }
        if (!SystemUtil.g())
        {
          paramSystemBarCompact.setStatusBarColor(-2368549);
          return;
        }
        paramSystemBarCompact.setStatusBarColor(-1);
        paramSystemBarCompact.setStatusBarDarkMode(true);
      }
    }
  }
  
  public static void a(View paramView)
  {
    if (paramView != null)
    {
      paramView.setBackgroundResource(0);
      if (ThemeUtil.isNowThemeIsNight(RIJQQAppInterfaceUtil.e(), false, null))
      {
        paramView.setBackgroundColor(Color.parseColor("#888888"));
        return;
      }
      paramView.setBackgroundColor(-1);
    }
  }
  
  public static void a(QBaseActivity paramQBaseActivity)
  {
    a(paramQBaseActivity, -1);
  }
  
  public static void a(QBaseActivity paramQBaseActivity, int paramInt)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramQBaseActivity.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(paramQBaseActivity.getWindow(), true);
      if (paramQBaseActivity.mSystemBarComp == null) {
        paramQBaseActivity.mSystemBarComp = new SystemBarCompact(paramQBaseActivity, true, -1);
      }
      paramQBaseActivity.mSystemBarComp.init();
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
      {
        paramQBaseActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        if (ThemeUtil.isInNightMode(RIJQQAppInterfaceUtil.e()))
        {
          paramQBaseActivity.mSystemBarComp.setStatusBarColor(1996488704);
          return;
        }
        paramQBaseActivity.mSystemBarComp.setStatusBarColor(paramInt);
        return;
      }
      if (!SystemUtil.g())
      {
        paramQBaseActivity.mSystemBarComp.setStatusBarColor(-2368549);
        return;
      }
      paramQBaseActivity.mSystemBarComp.setStatusBarColor(paramInt);
      paramQBaseActivity.mSystemBarComp.setStatusBarDarkMode(true);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new RIJAppSetting.1(paramQQAppInterface), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentUin(), null, "qqsetting_kandian_key", paramBoolean ^ true);
  }
  
  public static void a(String paramString)
  {
    Object localObject = RIJSPUtils.a(RIJQQAppInterfaceUtil.e(), true, false);
    if (localObject == null)
    {
      QLog.d("RIJAppSetting", 1, "updateVideoAutoPlaySetting failed to get sp");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (b() == 6) {
      ((SharedPreferences.Editor)localObject).putString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_VIDEO_FLOW_SETTING", paramString);
    } else {
      ((SharedPreferences.Editor)localObject).putString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_SETTING", paramString);
    }
    RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(paramString1, paramInt, paramString2);
    if (ReadInJoyHelper.h() != -1L) {
      System.currentTimeMillis();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return (GuardManager.sInstance != null) && (GuardManager.sInstance.isApplicationForeground());
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    boolean bool = SettingCloneUtil.readValue(paramAppInterface.getApplication(), paramAppInterface.getCurrentUin(), null, "qqsetting_kandian_key", true) ^ true;
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("isDeleteNewKandian, flag = ");
      paramAppInterface.append(bool);
      QLog.d("RIJAppSetting", 2, paramAppInterface.toString());
    }
    return bool;
  }
  
  public static int b()
  {
    return a;
  }
  
  public static MessageForStructing b(QQAppInterface paramQQAppInterface)
  {
    synchronized (d)
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)c.get(paramQQAppInterface.getCurrentAccountUin());
      c.remove(paramQQAppInterface.getCurrentAccountUin());
      return localMessageForStructing;
    }
  }
  
  public static String b(String paramString)
  {
    return ReadInJoyStringUtils.b(paramString);
  }
  
  public static void b(Activity paramActivity, boolean paramBoolean)
  {
    if ((paramActivity instanceof BaseActivity))
    {
      paramActivity = ((BaseActivity)paramActivity).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if ((paramActivity instanceof MainFragment))
      {
        if (paramBoolean)
        {
          ((MainFragment)paramActivity).B();
          return;
        }
        ((MainFragment)paramActivity).A();
      }
    }
  }
  
  public static boolean b(int paramInt)
  {
    return (e()) && (paramInt == e);
  }
  
  public static boolean b(long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = System.currentTimeMillis();
    }
    paramLong = l - ReadInJoyHelper.c((QQAppInterface)RIJQQAppInterfaceUtil.e());
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (paramLong < ReadInJoyPageItemCache.a) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("RIJAppSetting", 2, new Object[] { "isNeedToRememberHistoryPos, timeInterval = ", Long.valueOf(paramLong), " , isNeedToRemember = ", Boolean.valueOf(bool) });
    }
    return paramLong < ReadInJoyPageItemCache.a;
  }
  
  public static void c()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      if (!((QQAppInterface)localAppRuntime).mAutomator.g())
      {
        ReadinjoySPEventReport.c(false);
        return;
      }
      ThreadManager.getSubThreadHandler().postDelayed(new RIJAppSetting.2(), 500L);
    }
  }
  
  public static void c(int paramInt)
  {
    a = paramInt;
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    MessageForStructing localMessageForStructing = b(paramQQAppInterface);
    if (a(paramQQAppInterface)) {
      return;
    }
    if (localMessageForStructing != null)
    {
      QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
      if (localQQMessageFacade != null)
      {
        localMessageForStructing.time = NetConnInfoCenter.getServerTime();
        MessageRecord localMessageRecord = ((KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(localMessageForStructing);
        if (localMessageRecord != null) {
          localQQMessageFacade.a(localMessageRecord, paramQQAppInterface.getCurrentUin());
        }
        localQQMessageFacade.a(localMessageForStructing, paramQQAppInterface.getCurrentUin());
        if (QLog.isColorLevel()) {
          QLog.d("RIJAppSetting", 2, "notifyXinKandianMsg");
        }
      }
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    if (g)
    {
      g = false;
      c();
    }
    if (ReadInJoyHelper.w())
    {
      ReadInJoyLogicEngine.a().f(0);
      ReadInJoyLogicEngine.a().f(56);
      ReadInJoyLogicEngine.a().g(40677);
      if (DailyModeConfigHandler.b(DailyModeConfigHandler.j())) {
        ReadInJoyLogicEngine.a().f(DailyModeConfigHandler.j());
      }
    }
    b = true;
    ThreadManager.post(new RIJAppSetting.3(paramQQAppInterface), 8, null, false);
  }
  
  public static boolean d()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    return (localBaseActivity != null) && (((localBaseActivity instanceof ReadInJoyNewFeedsActivity)) || (localBaseActivity.getClass().getSimpleName().toLowerCase().contains("kandian")) || (localBaseActivity.getClass().getSimpleName().toLowerCase().contains("readinjoy")));
  }
  
  public static void e(QQAppInterface paramQQAppInterface)
  {
    b = false;
  }
  
  public static boolean e()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    boolean bool2 = localBaseActivity instanceof SplashActivity;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (((SplashActivity)localBaseActivity).getCurrentTab() == FrameControllerUtil.g) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean f()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (!(localBaseActivity instanceof PublicFragmentActivity)) {
      return false;
    }
    return ((PublicFragmentActivity)localBaseActivity).a() instanceof ReadInJoyDailyFragment;
  }
  
  public static boolean f(QQAppInterface paramQQAppInterface)
  {
    KeyguardManager localKeyguardManager = (KeyguardManager)BaseApplicationImpl.getContext().getApplicationContext().getSystemService("keyguard");
    return (paramQQAppInterface.isBackgroundPause) || (paramQQAppInterface.isBackgroundStop) || (localKeyguardManager.inKeyguardRestrictedInputMode());
  }
  
  public static boolean g()
  {
    return (d()) || (e());
  }
  
  public static boolean h()
  {
    long l = System.currentTimeMillis();
    if (l - h <= 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJAppSetting", 2, "click too fast");
      }
      h = l;
      return true;
    }
    h = l;
    return false;
  }
  
  public static boolean i()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public static boolean j()
  {
    return QLog.isColorLevel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting
 * JD-Core Version:    0.7.0.1
 */
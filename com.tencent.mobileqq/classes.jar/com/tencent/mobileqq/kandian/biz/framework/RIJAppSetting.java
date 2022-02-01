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
  private static long a;
  public static Object a;
  public static Map<String, MessageForStructing> a;
  public static volatile boolean a;
  public static int b;
  private static volatile boolean b;
  
  static
  {
    int i;
    if (RIJShowKanDianTabSp.c()) {
      i = 3;
    } else {
      i = 1;
    }
    jdField_a_of_type_Int = i;
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_Boolean = true;
    jdField_b_of_type_Int = -1;
  }
  
  public static int a()
  {
    return jdField_a_of_type_Int;
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
  
  public static MessageForStructing a(QQAppInterface paramQQAppInterface)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)jdField_a_of_type_JavaUtilMap.get(paramQQAppInterface.getCurrentAccountUin());
      jdField_a_of_type_JavaUtilMap.remove(paramQQAppInterface.getCurrentAccountUin());
      return localMessageForStructing;
    }
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
    if (a() == 6) {
      bool = true;
    } else {
      bool = false;
    }
    int i;
    if (paramLong == 1004L)
    {
      if (bool) {
        i = ReadInJoyHelper.b(BaseApplicationImpl.getApplication().getRuntime(), 0);
      } else {
        i = ReadInJoyHelper.a(BaseApplicationImpl.getApplication().getRuntime(), 0);
      }
    }
    else if (bool) {
      i = ReadInJoyHelper.c(BaseApplicationImpl.getApplication().getRuntime());
    } else {
      i = ReadInJoyHelper.b(BaseApplicationImpl.getApplication().getRuntime());
    }
    String str = "1";
    if (i == 0) {
      str = "2";
    } else if ((i != 1) && (i == 2)) {
      str = "0";
    }
    Object localObject = RIJSPUtils.a(RIJQQAppInterfaceUtil.a(), true, false);
    if (localObject == null)
    {
      QLog.d("RIJAppSetting", 1, "getVideoAutoPlaySetting failed to get sp");
      return str;
    }
    if (bool) {
      localObject = ((SharedPreferences)localObject).getString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_VIDEO_FLOW_SETTING", str);
    } else {
      localObject = ((SharedPreferences)localObject).getString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_SETTING", str);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getVideoAutoPlaySetting(),isVideoFlowEnter = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", autoSetting = ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(",localSettingDefaultValue=");
      localStringBuilder.append(str);
      localStringBuilder.append(", remoteSettingDefaultValue=");
      localStringBuilder.append(i);
      localStringBuilder.append(" channelFrom:");
      localStringBuilder.append(paramLong);
      QLog.d("RIJAppSetting", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    return ReadInJoyStringUtils.b(paramString);
  }
  
  public static void a()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.a();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      if (!((QQAppInterface)localAppRuntime).mAutomator.b())
      {
        ReadinjoySPEventReport.f();
        return;
      }
      ThreadManager.getSubThreadHandler().postDelayed(new RIJAppSetting.2(), 500L);
    }
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
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
        if ((VersionUtils.k()) && (SystemUtil.b()))
        {
          if (!paramBoolean) {
            i = 1280;
          }
          paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
        }
        paramView.setBackgroundColor(-1);
      }
      else if ((VersionUtils.k()) && (!SystemUtil.b()) && (!SystemUtil.d()))
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
      if ((ImmersiveUtils.supportStatusBarDarkMode()) && ((!VersionUtils.k()) || (!SystemUtil.b()))) {
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
        if (ThemeUtil.isNowThemeIsNight(RIJQQAppInterfaceUtil.a(), false, null))
        {
          if ((!SystemUtil.b()) && (!SystemUtil.d()))
          {
            paramSystemBarCompact.setStatusBarColor(-7829368);
            return;
          }
          paramSystemBarCompact.setStatusBarColor(-7829368);
          paramSystemBarCompact.setStatusBarDarkMode(true);
          return;
        }
        if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
        {
          a(paramActivity, true);
          paramSystemBarCompact.setStatusBarColor(-1);
          return;
        }
        if (!SystemUtil.d())
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
      if (ThemeUtil.isNowThemeIsNight(RIJQQAppInterfaceUtil.a(), false, null))
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
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        paramQBaseActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        if (ThemeUtil.isInNightMode(RIJQQAppInterfaceUtil.a()))
        {
          paramQBaseActivity.mSystemBarComp.setStatusBarColor(1996488704);
          return;
        }
        paramQBaseActivity.mSystemBarComp.setStatusBarColor(paramInt);
        return;
      }
      if (!SystemUtil.d())
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
    Object localObject = RIJSPUtils.a(RIJQQAppInterfaceUtil.a(), true, false);
    if (localObject == null)
    {
      QLog.d("RIJAppSetting", 1, "updateVideoAutoPlaySetting failed to get sp");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (a() == 6) {
      ((SharedPreferences.Editor)localObject).putString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_VIDEO_FLOW_SETTING", paramString);
    } else {
      ((SharedPreferences.Editor)localObject).putString("SP_VIDEO_CHANNEL_AUTO_PLAY_SWITCH_SETTING", paramString);
    }
    RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(paramString1, paramInt, paramString2);
    if (ReadInJoyHelper.a() != -1L) {
      System.currentTimeMillis();
    }
  }
  
  public static boolean a()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    return (localBaseActivity != null) && (((localBaseActivity instanceof ReadInJoyNewFeedsActivity)) || (localBaseActivity.getClass().getSimpleName().toLowerCase().contains("kandian")) || (localBaseActivity.getClass().getSimpleName().toLowerCase().contains("readinjoy")));
  }
  
  public static boolean a(int paramInt)
  {
    return (b()) && (paramInt == jdField_b_of_type_Int);
  }
  
  public static boolean a(long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = System.currentTimeMillis();
    }
    paramLong = l - ReadInJoyHelper.a((QQAppInterface)RIJQQAppInterfaceUtil.a());
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (paramLong < ReadInJoyPageItemCache.jdField_a_of_type_Int) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("RIJAppSetting", 2, new Object[] { "isNeedToRememberHistoryPos, timeInterval = ", Long.valueOf(paramLong), " , isNeedToRemember = ", Boolean.valueOf(bool) });
    }
    return paramLong < ReadInJoyPageItemCache.jdField_a_of_type_Int;
  }
  
  public static boolean a(Context paramContext)
  {
    return (GuardManager.a != null) && (GuardManager.a.a());
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
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    KeyguardManager localKeyguardManager = (KeyguardManager)BaseApplicationImpl.getContext().getApplicationContext().getSystemService("keyguard");
    return (paramQQAppInterface.isBackgroundPause) || (paramQQAppInterface.isBackgroundStop) || (localKeyguardManager.inKeyguardRestrictedInputMode());
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
          ((MainFragment)paramActivity).s();
          return;
        }
        ((MainFragment)paramActivity).r();
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    MessageForStructing localMessageForStructing = a(paramQQAppInterface);
    if (a(paramQQAppInterface)) {
      return;
    }
    if (localMessageForStructing != null)
    {
      QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
      if (localQQMessageFacade != null)
      {
        localMessageForStructing.time = NetConnInfoCenter.getServerTime();
        MessageRecord localMessageRecord = ((KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(localMessageForStructing);
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
  
  public static boolean b()
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
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (jdField_b_of_type_Boolean)
    {
      jdField_b_of_type_Boolean = false;
      a();
    }
    if (ReadInJoyHelper.m())
    {
      ReadInJoyLogicEngine.a().d(0);
      ReadInJoyLogicEngine.a().d(56);
      ReadInJoyLogicEngine.a().e(40677);
      if (DailyModeConfigHandler.b(DailyModeConfigHandler.b())) {
        ReadInJoyLogicEngine.a().d(DailyModeConfigHandler.b());
      }
    }
    jdField_a_of_type_Boolean = true;
    ThreadManager.post(new RIJAppSetting.3(paramQQAppInterface), 8, null, false);
  }
  
  public static boolean c()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (!(localBaseActivity instanceof PublicFragmentActivity)) {
      return false;
    }
    return ((PublicFragmentActivity)localBaseActivity).a() instanceof ReadInJoyDailyFragment;
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static boolean d()
  {
    return (a()) || (b());
  }
  
  public static boolean e()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long <= 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJAppSetting", 2, "click too fast");
      }
      jdField_a_of_type_Long = l;
      return true;
    }
    jdField_a_of_type_Long = l;
    return false;
  }
  
  public static boolean f()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public static boolean g()
  {
    return QLog.isColorLevel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting
 * JD-Core Version:    0.7.0.1
 */
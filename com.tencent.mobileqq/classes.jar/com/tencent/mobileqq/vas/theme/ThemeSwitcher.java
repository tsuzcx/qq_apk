package com.tencent.mobileqq.vas.theme;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateCallback;
import com.tencent.mobileqq.vas.theme.api.ISimpleUIHandler;
import com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.mobileqq.vas.util.VasTextUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.util.StringBuilderUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ThemeSwitcher
  implements Handler.Callback, QueryItemCallback
{
  public static ThemeSwitcher a;
  public static final HashSet<String> a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static ThemeSwitcher jdField_b_of_type_ComTencentMobileqqVasThemeThemeSwitcher;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  public ThemeSwitcher.DownloadListenser a;
  private IThemeSwitchCallback jdField_a_of_type_ComTencentMobileqqVasThemeApiIThemeSwitchCallback;
  private ThemeLocator jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator = new ThemeLocator();
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("204");
    localHashSet.add("203");
    localHashSet.add("206");
    localHashSet.add("212");
    jdField_a_of_type_JavaUtilHashSet = localHashSet;
  }
  
  private ThemeSwitcher(AppRuntime paramAppRuntime, IThemeSwitchCallback paramIThemeSwitchCallback, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasThemeApiIThemeSwitchCallback = paramIThemeSwitchCallback;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.a(paramString1);
    this.jdField_a_of_type_JavaLangString = new SimpleDateFormat("MM-dd HH:mm:ss").format(new Date());
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    if (localBaseApplication == null)
    {
      QLog.e("ThemeSwitcher", 1, "unzipTheme: context == null");
      return null;
    }
    String str3 = ThemeUtil.getIDFromSCID(paramString);
    Object localObject2 = new ThemeLocator().a(str3).a(localBaseApplication, paramString, "");
    if (!((ThemeLocator)localObject2).a())
    {
      QLog.e("ThemeSwitcher", 1, "unzipTheme: zip file missing");
      return null;
    }
    String str4 = ((ThemeLocator)localObject2).c();
    String str2 = FileUtils.encryptFile(str4, "MD5");
    if (TextUtils.isEmpty(str2))
    {
      QLog.e("ThemeSwitcher", 1, "unzipTheme: fail to get md5");
      return null;
    }
    ((ThemeLocator)localObject2).a(localBaseApplication, paramString, str2);
    String str1 = ((ThemeLocator)localObject2).d();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("unzipTheme to ");
    ((StringBuilder)localObject3).append(str1);
    QLog.e("ThemeSwitcher", 1, ((StringBuilder)localObject3).toString());
    localObject3 = new File(str1);
    boolean bool;
    if ((!paramBoolean) && (((File)localObject3).exists()))
    {
      if (a(localBaseApplication, (ThemeLocator)localObject2))
      {
        QLog.e("ThemeSwitcher", 1, "unzipTheme unzipDir exists");
        return str2;
      }
      bool = VasUpdateUtil.a((File)localObject3, "theme_move_") ^ true;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("unzipTheme remove oldUnzip needMove: ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(" unzip exists: ");
      ((StringBuilder)localObject2).append(((File)localObject3).exists());
      QLog.e("ThemeSwitcher", 1, ((StringBuilder)localObject2).toString());
    }
    else
    {
      bool = paramBoolean;
    }
    if (bool)
    {
      a(localBaseApplication, (File)localObject3);
      VasMonitorDT.a("individual_v2_theme_setup_err", "need_move");
    }
    int i;
    try
    {
      FileUtils.uncompressZip(str4, str1, false);
      if (((File)localObject3).exists()) {
        i = ThemeUtil.getFileNumInFile((File)localObject3);
      }
    }
    catch (IOException localIOException)
    {
      QLog.e("ThemeSwitcher", 1, "unzipTheme failed", localIOException);
      i = 0;
    }
    if (i == 0)
    {
      if (paramBoolean)
      {
        QLog.e("ThemeSwitcher", 1, "unzipTheme unzip failed twice");
        return null;
      }
      return a(paramString, true);
    }
    Object localObject1 = ThemeUtil.getThemeInfo(localBaseApplication, str3);
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      paramString = new StringBuilder();
      paramString.append("unzipTheme no ThemeInfo ");
      paramString.append(str3);
      QLog.e("ThemeSwitcher", 1, paramString.toString());
      paramString = new ThemeUtil.ThemeInfo();
      paramString.themeId = str3;
      paramString.version = "20000000";
      paramString.zipVer = 20000000;
      paramString.isVoiceTheme = false;
    }
    paramString.status = "5";
    paramString.fileNum = i;
    long l = new File(str4).length();
    paramString.size = l;
    paramString.downsize = l;
    ThemeUtil.setThemeInfo(localBaseApplication, paramString);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("unzipTheme success: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("ThemeSwitcher", 2, ((StringBuilder)localObject1).toString());
    }
    return str2;
  }
  
  private void a()
  {
    ThreadManagerV2.excute(new ThemeSwitcher.1(this), 64, null, true);
  }
  
  private void a(int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.a();
    int i = SimpleUIUtil.b(str);
    Object localObject;
    if ((paramInt == 0) && (ThemeUtil.getCreateAppRuntime() != null) && (SimpleUIUtil.a(i)))
    {
      boolean bool = SimpleUIUtil.a();
      localObject = (ISimpleUIHandler)QRoute.api(ISimpleUIHandler.class);
      ((ISimpleUIHandler)localObject).setReqTs(((ISimpleUIHandler)localObject).sendSwitchAndSetSimpleUI(bool, i, false));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NightModeLogic.postSwitch, bSwitch = ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("; bPref = ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("; themeId = ");
        ((StringBuilder)localObject).append(str);
        QLog.d("SimpleUIHandler", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("NightModeLogic.postSwitch error, mBPref = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("; themeId = ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("; code = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SimpleUIHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    ??? = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
    boolean bool2 = false;
    if (((AtomicBoolean)???).compareAndSet(false, true))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onEndSwitch: ");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(",");
      ((StringBuilder)???).append(paramBoolean);
      ((StringBuilder)???).append(" ");
      ((StringBuilder)???).append(this);
      QLog.e("ThemeSwitcher", 1, ((StringBuilder)???).toString());
      synchronized (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        if (jdField_a_of_type_ComTencentMobileqqVasThemeThemeSwitcher == this)
        {
          jdField_a_of_type_ComTencentMobileqqVasThemeThemeSwitcher = null;
          jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        }
        boolean bool1 = bool2;
        if (!paramBoolean)
        {
          ??? = this.jdField_a_of_type_ComTencentMobileqqVasThemeApiIThemeSwitchCallback;
          bool1 = bool2;
          if (??? != null) {
            bool1 = ((IThemeSwitchCallback)???).postSwitch(paramInt);
          }
        }
        if ((!bool1) && (("211".equals(this.jdField_b_of_type_JavaLangString)) || ("212".equals(this.jdField_b_of_type_JavaLangString)) || ("202".equals(this.jdField_b_of_type_JavaLangString))))
        {
          a(paramInt);
          return;
        }
      }
    }
  }
  
  public static void a(String paramString, long paramLong1, long paramLong2)
  {
    Object localObject = jdField_a_of_type_ComTencentMobileqqVasThemeThemeSwitcher;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((ThemeSwitcher)localObject).jdField_a_of_type_ComTencentMobileqqVasThemeThemeSwitcher$DownloadListenser;
    }
    if (localObject != null) {
      ((ThemeSwitcher.DownloadListenser)localObject).a(paramString, paramLong1, paramLong2);
    }
  }
  
  private void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    String str1 = this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.a();
    String str2 = VasTextUtil.a(paramAppRuntime.getAccount(), 2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2);
    localStringBuilder.append(" startSwitch: ");
    localStringBuilder.append(str1);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    QLog.e("ThemeSwitcher", 1, localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
    if ("1000".equals(str1))
    {
      b();
      return;
    }
    if ("999".equals(str1))
    {
      a();
      return;
    }
    if ("900".equals(str1))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.b();
      b();
      return;
    }
    b(paramAppRuntime);
  }
  
  private void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasThemeThemeSwitcher$DownloadListenser = new ThemeSwitcher.DownloadListenser(this, paramBoolean);
    ThemeUpdateCallback.sInstance.download(this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.b());
    ThemeReporter.a(paramAppRuntime, "theme_detail", this.jdField_b_of_type_JavaLangString, 153, -1, 7, this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.a(), "20000000", ThemeReporter.jdField_a_of_type_JavaLangString, "");
  }
  
  public static boolean a()
  {
    boolean bool = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSwitching: ");
    localStringBuilder.append(bool);
    localStringBuilder.append(",");
    localStringBuilder.append(jdField_a_of_type_ComTencentMobileqqVasThemeThemeSwitcher);
    QLog.e("ThemeSwitcher", 1, localStringBuilder.toString());
    return bool;
  }
  
  private static boolean a(Context paramContext, ThemeLocator paramThemeLocator)
  {
    File localFile = new File(paramThemeLocator.d());
    return (ThemeUtil.getThemeInfo(paramContext, paramThemeLocator.a()) != null) && (localFile.exists());
  }
  
  private static boolean a(Context paramContext, File paramFile)
  {
    boolean bool = false;
    paramContext = paramContext.getDir("theme_810", 0).getParentFile();
    while ((!bool) && (!paramFile.equals(paramContext)))
    {
      Object localObject = paramFile.getParent();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("theme_move_");
      localStringBuilder.append(Long.toString(System.currentTimeMillis()));
      localObject = new File((String)localObject, localStringBuilder.toString());
      bool = paramFile.renameTo((File)localObject);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("unzipTheme rename ");
      localStringBuilder.append(paramFile);
      localStringBuilder.append(" success: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", dest=");
      localStringBuilder.append(localObject);
      QLog.e("ThemeSwitcher", 1, localStringBuilder.toString());
      paramFile = paramFile.getParentFile();
    }
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    ThemeSwitcher localThemeSwitcher = jdField_a_of_type_ComTencentMobileqqVasThemeThemeSwitcher;
    return (localThemeSwitcher != null) && (localThemeSwitcher.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.a().equals(paramString));
  }
  
  public static boolean a(String paramString1, String paramString2, IThemeSwitchCallback paramIThemeSwitchCallback)
  {
    return a(ThemeUtil.getCreateAppRuntime(), paramString1, paramString2, paramIThemeSwitchCallback);
  }
  
  private boolean a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("beforeSwitch: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("=>");
    ((StringBuilder)localObject).append(paramString2);
    QLog.e("ThemeSwitcher", 1, ((StringBuilder)localObject).toString());
    QQTheme.a(paramString1);
    localObject = ThemeBackground.a(paramAppRuntime.getApplication(), paramAppRuntime.getAccount(), 0);
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals(paramString1)))
    {
      if ((!jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_b_of_type_JavaLangString)) && (!"200".equals(this.jdField_b_of_type_JavaLangString)) && ("1103".equals(paramString1)) && ("null".equals(ChatBackgroundUtil.a(MobileQQ.getContext(), paramAppRuntime.getAccount(), null))) && (((SharedPreferences)localObject).contains("theme_bg_record_for_night_mode")))
      {
        String str = ((SharedPreferences)localObject).getString("theme_bg_record_for_night_mode", "null");
        ChatBackgroundUtil.a(MobileQQ.getContext(), paramAppRuntime.getAccount(), null, str, -1);
        ((SharedPreferences)localObject).edit().remove("theme_bg_record_for_night_mode").apply();
      }
      if (!ThemeUtil.isFixTheme(paramString2)) {
        ThemeSwitchUtil.a(paramAppRuntime, paramString2, "20000000");
      } else if ((!ThemeUtil.isFixTheme(paramString1)) && (!"206".equals(this.jdField_b_of_type_JavaLangString)) && (!paramString1.equals("1000"))) {
        ThemeSwitchUtil.a(paramAppRuntime, paramString1, "20000000");
      }
      if (!ThemeUtil.isFixTheme(paramString2)) {
        ThemeCleaner.a(paramString1);
      }
    }
    paramAppRuntime = this.jdField_a_of_type_ComTencentMobileqqVasThemeApiIThemeSwitchCallback;
    if (paramAppRuntime != null) {
      return paramAppRuntime.beforeSwitch(this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator);
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String arg1, String paramString2, IThemeSwitchCallback paramIThemeSwitchCallback)
  {
    if ((!TextUtils.isEmpty(???)) && (VasTextUtil.a(???)))
    {
      if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set ");
        localStringBuilder.append(???);
        localStringBuilder.append(" when NOT_FINISH ");
        localStringBuilder.append(jdField_a_of_type_ComTencentMobileqqVasThemeThemeSwitcher);
        QLog.e("ThemeSwitcher", 1, localStringBuilder.toString());
      }
      jdField_b_of_type_ComTencentMobileqqVasThemeThemeSwitcher = null;
      paramString2 = new ThemeSwitcher(paramAppRuntime, paramIThemeSwitchCallback, ???, paramString2);
      synchronized (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        paramIThemeSwitchCallback = jdField_a_of_type_ComTencentMobileqqVasThemeThemeSwitcher;
        jdField_a_of_type_ComTencentMobileqqVasThemeThemeSwitcher = paramString2;
        if (paramIThemeSwitchCallback != null) {
          paramIThemeSwitchCallback.a(2, false);
        }
        paramString2.a(paramAppRuntime);
        return true;
      }
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("error themeId: ");
    paramAppRuntime.append(???);
    QLog.e("ThemeSwitcher", 1, paramAppRuntime.toString());
    if (paramIThemeSwitchCallback != null) {
      paramIThemeSwitchCallback.postSwitch(1);
    }
    VasMonitorDT.a("individual_v2_theme_setup_err", "wrong_id");
    return false;
  }
  
  private void b()
  {
    long l2 = this.jdField_a_of_type_Long + 1500L - SystemClock.uptimeMillis();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    localHandler.sendMessageDelayed(localHandler.obtainMessage(1001), l1);
  }
  
  private void b(AppRuntime paramAppRuntime)
  {
    ((IVasQuickUpdateService)paramAppRuntime.getRuntimeService(IVasQuickUpdateService.class, "")).queryItemVersion(3, this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.b(), true, true, 0L, this);
  }
  
  private boolean b()
  {
    if (jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_b_of_type_JavaLangString))
    {
      Object localObject = SkinEngine.getInstances().getSkinRootPath();
      String str = this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.d();
      if ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty((CharSequence)localObject)))
      {
        QLog.e("ThemeSwitcher", 1, "needSwitch: normal not changed");
        return false;
      }
      if ((!TextUtils.isEmpty(str)) && (str.equals(localObject)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("needSwitch: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.a());
        ((StringBuilder)localObject).append(" not changed");
        QLog.e("ThemeSwitcher", 1, ((StringBuilder)localObject).toString());
        return false;
      }
    }
    return true;
  }
  
  AppRuntime a()
  {
    Object localObject = ThemeUtil.getCreateAppRuntime();
    if ((localObject != null) && (((AppRuntime)localObject).isLogin()))
    {
      if (jdField_a_of_type_ComTencentMobileqqVasThemeThemeSwitcher != this)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("newSwitcher: ");
        ((StringBuilder)localObject).append(jdField_a_of_type_ComTencentMobileqqVasThemeThemeSwitcher);
        ((StringBuilder)localObject).append(" old is:");
        ((StringBuilder)localObject).append(this);
        QLog.e("ThemeSwitcher", 1, ((StringBuilder)localObject).toString());
        return null;
      }
      return localObject;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("app is destroy: ");
    localStringBuilder.append(localObject);
    localStringBuilder.append(" switcher: ");
    localStringBuilder.append(this);
    QLog.e("ThemeSwitcher", 1, localStringBuilder.toString());
    a(2, true);
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1 = a();
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("app null when handleMessage: ");
      ((StringBuilder)localObject1).append(paramMessage.what);
      QLog.e("ThemeSwitcher", 1, ((StringBuilder)localObject1).toString());
      return true;
    }
    if (paramMessage.what == 1000)
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqVasThemeApiIThemeSwitchCallback;
      if (paramMessage != null)
      {
        paramMessage.beginSwitch();
        return true;
      }
    }
    else
    {
      int j = paramMessage.what;
      int i = 0;
      boolean bool1 = false;
      if (j == 1001)
      {
        paramMessage = ThemeUtil.getCurrentThemeId();
        String str = this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.a();
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.d();
        ThemeBackground.c = false;
        if (!a((AppRuntime)localObject1, paramMessage, str))
        {
          if (b())
          {
            if (SkinEngine.getInstances().mResources == null)
            {
              bool1 = true;
            }
            else
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("setSkinRoot: ");
              localStringBuilder.append((String)localObject2);
              QLog.e("ThemeSwitcher", 1, localStringBuilder.toString());
              bool2 = SkinEngine.getInstances().setSkinRootPath(((AppRuntime)localObject1).getApp(), (String)localObject2);
              bool1 = false;
              break label220;
            }
          }
          else {
            bool1 = false;
          }
          boolean bool2 = true;
          label220:
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("needRetry: ");
          ((StringBuilder)localObject2).append(bool1);
          ((StringBuilder)localObject2).append(" switchSuccess: ");
          ((StringBuilder)localObject2).append(bool2);
          QLog.e("ThemeSwitcher", 1, ((StringBuilder)localObject2).toString());
          ThemeUtil.setCurrentThemeIdVersion((AppRuntime)localObject1, this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.a(), "20000000");
          if (bool2)
          {
            a(0, false);
          }
          else
          {
            QLog.e("ThemeSwitcher", 1, "engine is doing a switch, retry later");
            localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1002, 0, 0);
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, 1000L);
          }
        }
        else
        {
          a(0, true);
        }
        ThemeReporter.a(null, "theme_detail", this.jdField_b_of_type_JavaLangString, 155, NetworkUtil.getSystemNetwork(null), 23, str, "20000000", paramMessage, "");
        paramMessage = new StringBuilder();
        paramMessage.append("needRetry: ");
        paramMessage.append(bool1);
        paramMessage.append(" sIsSwitching: ");
        paramMessage.append(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
        QLog.e("ThemeSwitcher", 1, paramMessage.toString());
        if (bool1)
        {
          paramMessage = new StringBuilder();
          paramMessage.append("engine not ready, start retry: ");
          paramMessage.append(this);
          QLog.e("ThemeSwitcher", 1, paramMessage.toString());
          this.jdField_b_of_type_Long = (SystemClock.uptimeMillis() + 60000L);
          jdField_b_of_type_ComTencentMobileqqVasThemeThemeSwitcher = this;
          paramMessage = this.jdField_a_of_type_AndroidOsHandler;
          paramMessage.sendMessageDelayed(paramMessage.obtainMessage(1003), 2000L);
          this.jdField_a_of_type_ComTencentMobileqqVasThemeApiIThemeSwitchCallback = null;
          return true;
        }
      }
      else
      {
        if (paramMessage.what == 1002)
        {
          i = paramMessage.arg1;
          if (i < 10)
          {
            paramMessage = this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.d();
            if (!SkinEngine.getInstances().setSkinRootPath(((AppRuntime)localObject1).getApp(), paramMessage))
            {
              paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1002, i + 1, 0);
              this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 1000L);
              return true;
            }
            paramMessage = new StringBuilder();
            paramMessage.append("retry switchSuccess: ");
            paramMessage.append(this);
            QLog.e("ThemeSwitcher", 1, paramMessage.toString());
          }
          paramMessage = new StringBuilder();
          paramMessage.append("retryCount: ");
          paramMessage.append(i);
          QLog.e("ThemeSwitcher", 1, paramMessage.toString());
          a(0, false);
          return true;
        }
        if (paramMessage.what == 1003)
        {
          if (jdField_b_of_type_ComTencentMobileqqVasThemeThemeSwitcher != this)
          {
            paramMessage = new StringBuilder();
            paramMessage.append("sRetry reset, stop retry: ");
            paramMessage.append(this);
            QLog.e("ThemeSwitcher", 1, paramMessage.toString());
            i = 1;
          }
          if (SystemClock.uptimeMillis() > this.jdField_b_of_type_Long)
          {
            paramMessage = new StringBuilder();
            paramMessage.append("meet deadLine, stop retry ");
            paramMessage.append(this);
            QLog.e("ThemeSwitcher", 1, paramMessage.toString());
            VasMonitorDT.a("individual_v2_theme_setup_err", "engine_timeout");
            i = 1;
          }
          if (i != 0)
          {
            jdField_b_of_type_ComTencentMobileqqVasThemeThemeSwitcher = null;
            return true;
          }
          if (SkinEngine.getInstances().mResources == null)
          {
            paramMessage = this.jdField_a_of_type_AndroidOsHandler;
            paramMessage.sendMessageDelayed(paramMessage.obtainMessage(1003), 2000L);
            return true;
          }
          paramMessage = new StringBuilder();
          paramMessage.append("engine ready, retry: ");
          paramMessage.append(this);
          QLog.e("ThemeSwitcher", 1, paramMessage.toString());
          jdField_b_of_type_ComTencentMobileqqVasThemeThemeSwitcher = null;
          a((AppRuntime)localObject1, this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.a(), this.jdField_b_of_type_JavaLangString, null);
        }
      }
    }
    return true;
  }
  
  public void onQueryItemVer(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onQueryItemVer: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramString2);
    QLog.e("ThemeSwitcher", 1, ((StringBuilder)localObject).toString());
    localObject = a();
    if (localObject == null) {
      return;
    }
    if (paramInt == 2)
    {
      a(2, false);
      paramString1 = StringBuilderUtils.a();
      paramString2 = new StringBuilder();
      paramString2.append("os.arch: ");
      paramString2.append(System.getProperty("os.arch"));
      paramString1.append(paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(" DeviceInfoUtil#getCpuType: ");
      paramString2.append(DeviceInfoUtil.g());
      paramString1.append(paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(" Build.CPU_ABI: ");
      paramString2.append(Build.CPU_ABI);
      paramString1.append(paramString2.toString());
      paramString2 = new StringBuilder();
      paramString2.append(" Build.CPU_ABI2: ");
      paramString2.append(Build.CPU_ABI2);
      paramString1.append(paramString2.toString());
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramString2 = new StringBuilder();
        paramString2.append(" Build.SUPPORTED_ABIS: ");
        paramString2.append(Arrays.toString(Build.SUPPORTED_ABIS));
        paramString1.append(paramString2.toString());
      }
      VasMonitorDT.a("individual_v2_theme_setup_err", "query_timeout");
      return;
    }
    if (paramInt == 1)
    {
      a((AppRuntime)localObject, false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.a(((AppRuntime)localObject).getApp(), paramString1, paramString2);
    if (a(((AppRuntime)localObject).getApp(), this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator))
    {
      paramString1 = ThemeUtil.getCurrentThemeId();
      if ((!jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_b_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.a().equals(paramString1)))
      {
        a((AppRuntime)localObject, true);
        return;
      }
      b();
      return;
    }
    QLog.e("ThemeSwitcher", 1, "unZip dir not exist, download again");
    this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.c();
    a((AppRuntime)localObject, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.a());
    localStringBuilder.append(" start ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" ,");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.ThemeSwitcher
 * JD-Core Version:    0.7.0.1
 */
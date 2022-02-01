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
import com.tencent.mobileqq.vas.VasStatisticCollector;
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
import kotlin.Pair;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ThemeSwitcher
  implements Handler.Callback, QueryItemCallback
{
  public static final HashSet<String> a;
  public static ThemeSwitcher b;
  private static AtomicBoolean d = new AtomicBoolean(false);
  private static ThemeSwitcher m;
  public ThemeSwitcher.DownloadListenser c;
  private long e;
  private String f;
  private String g;
  private IThemeSwitchCallback h;
  private Handler i;
  private AtomicBoolean j = new AtomicBoolean(false);
  private ThemeLocator k = new ThemeLocator();
  private long l;
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("204");
    localHashSet.add("203");
    localHashSet.add("206");
    localHashSet.add("212");
    a = localHashSet;
  }
  
  public ThemeSwitcher()
  {
    this.i = new Handler(Looper.getMainLooper(), null);
  }
  
  private ThemeSwitcher(AppRuntime paramAppRuntime, IThemeSwitchCallback paramIThemeSwitchCallback, String paramString1, String paramString2)
  {
    this.i = new Handler(Looper.getMainLooper(), this);
    this.h = paramIThemeSwitchCallback;
    this.g = paramString2;
    this.k.a(paramString1);
    this.f = new SimpleDateFormat("MM-dd HH:mm:ss").format(new Date());
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
    if (!((ThemeLocator)localObject2).h())
    {
      QLog.e("ThemeSwitcher", 1, "unzipTheme: zip file missing");
      return null;
    }
    String str4 = ((ThemeLocator)localObject2).f();
    String str2 = FileUtils.encryptFile(str4, "MD5");
    if (TextUtils.isEmpty(str2))
    {
      QLog.e("ThemeSwitcher", 1, "unzipTheme: fail to get md5");
      return null;
    }
    ((ThemeLocator)localObject2).a(localBaseApplication, paramString, str2);
    String str1 = ((ThemeLocator)localObject2).g();
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
      bool = VasUpdateUtil.b((File)localObject3, "theme_move_") ^ true;
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
    int n;
    try
    {
      FileUtils.uncompressZip(str4, str1, false);
      if (((File)localObject3).exists()) {
        n = ThemeUtil.getFileNumInFile((File)localObject3);
      }
    }
    catch (IOException localIOException)
    {
      QLog.e("ThemeSwitcher", 1, "unzipTheme failed", localIOException);
      n = 0;
    }
    if (n == 0)
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
    paramString.fileNum = n;
    long l1 = new File(str4).length();
    paramString.size = l1;
    paramString.downsize = l1;
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
  
  private void a(int paramInt)
  {
    String str = this.k.d();
    int n = SimpleUIUtil.b(str);
    Object localObject;
    if ((paramInt == 0) && (ThemeUtil.getCreateAppRuntime() != null) && (SimpleUIUtil.g(n)))
    {
      boolean bool = SimpleUIUtil.e();
      localObject = (ISimpleUIHandler)QRoute.api(ISimpleUIHandler.class);
      ((ISimpleUIHandler)localObject).setReqTs(((ISimpleUIHandler)localObject).sendSwitchAndSetSimpleUI(bool, n, false));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NightModeLogic.postSwitch, bSwitch = ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("; bPref = ");
        ((StringBuilder)localObject).append(n);
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
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append("; themeId = ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("; code = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SimpleUIHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    ??? = this.j;
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
      VasStatisticCollector.b("theme_finish", new Pair[] { new Pair("themeId", this.k.d()), new Pair("errorCode", String.valueOf(paramInt)), new Pair("from", this.g) });
      synchronized (d)
      {
        if (b == this)
        {
          b = null;
          d.set(false);
        }
        boolean bool1 = bool2;
        if (!paramBoolean)
        {
          ??? = this.h;
          bool1 = bool2;
          if (??? != null) {
            bool1 = ((IThemeSwitchCallback)???).postSwitch(paramInt);
          }
        }
        if ((!bool1) && (("211".equals(this.g)) || ("212".equals(this.g)) || ("202".equals(this.g))))
        {
          a(paramInt);
          return;
        }
      }
    }
  }
  
  public static void a(String paramString, long paramLong1, long paramLong2)
  {
    Object localObject = b;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((ThemeSwitcher)localObject).c;
    }
    if (localObject != null) {
      ((ThemeSwitcher.DownloadListenser)localObject).a(paramString, paramLong1, paramLong2);
    }
  }
  
  private static boolean a(Context paramContext, ThemeLocator paramThemeLocator)
  {
    File localFile = new File(paramThemeLocator.g());
    return (ThemeUtil.getThemeInfo(paramContext, paramThemeLocator.d()) != null) && (localFile.exists());
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
    ThemeSwitcher localThemeSwitcher = b;
    return (localThemeSwitcher != null) && (localThemeSwitcher.k.d().equals(paramString));
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
    VasStatisticCollector.b("theme_beforeSwitch", new Pair[] { new Pair("from", paramString1), new Pair("themeId", paramString2) });
    QQTheme.storeLastThemeId(paramString1);
    localObject = ThemeBackground.a(paramAppRuntime.getApplication(), paramAppRuntime.getAccount(), 0);
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals(paramString1)))
    {
      if ((!a.contains(this.g)) && (!"200".equals(this.g)) && ("1103".equals(paramString1)) && ("null".equals(ChatBackgroundUtil.a(MobileQQ.getContext(), paramAppRuntime.getAccount(), null))) && (((SharedPreferences)localObject).contains("theme_bg_record_for_night_mode")))
      {
        String str = ((SharedPreferences)localObject).getString("theme_bg_record_for_night_mode", "null");
        ChatBackgroundUtil.a(MobileQQ.getContext(), paramAppRuntime.getAccount(), null, str, -1);
        ((SharedPreferences)localObject).edit().remove("theme_bg_record_for_night_mode").apply();
      }
      if (!ThemeUtil.isFixTheme(paramString2)) {
        ThemeSwitchUtil.a(paramAppRuntime, paramString2, "20000000");
      } else if ((!ThemeUtil.isFixTheme(paramString1)) && (!"206".equals(this.g)) && (!paramString1.equals("1000"))) {
        ThemeSwitchUtil.a(paramAppRuntime, paramString1, "20000000");
      }
      if (!ThemeUtil.isFixTheme(paramString2)) {
        ThemeCleaner.a(paramString1);
      }
    }
    paramAppRuntime = this.h;
    if (paramAppRuntime != null) {
      return paramAppRuntime.beforeSwitch(this.k);
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String arg1, String paramString2, IThemeSwitchCallback paramIThemeSwitchCallback)
  {
    if ((!TextUtils.isEmpty(???)) && (VasTextUtil.a(???)))
    {
      if (!d.compareAndSet(false, true))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set ");
        localStringBuilder.append(???);
        localStringBuilder.append(" when NOT_FINISH ");
        localStringBuilder.append(b);
        QLog.e("ThemeSwitcher", 1, localStringBuilder.toString());
      }
      m = null;
      paramString2 = new ThemeSwitcher(paramAppRuntime, paramIThemeSwitchCallback, ???, paramString2);
      synchronized (d)
      {
        paramIThemeSwitchCallback = b;
        b = paramString2;
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
  
  private void b(AppRuntime paramAppRuntime)
  {
    String str1 = ThemeUtil.getCurrentThemeId();
    String str2 = this.k.d();
    Object localObject = this.k.g();
    ThemeBackground.f = false;
    boolean bool1;
    if (!a(paramAppRuntime, str1, str2))
    {
      if ((!c()) && (!QQTheme.isThemeSimpleUI(str2))) {}
      for (bool1 = false;; bool1 = true)
      {
        bool2 = true;
        break label93;
        if (SkinEngine.getInstances().mResources != null) {
          break;
        }
      }
      boolean bool2 = a(paramAppRuntime.getApp(), str2, (String)localObject);
      bool1 = false;
      label93:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("needRetry: ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" switchSuccess: ");
      ((StringBuilder)localObject).append(bool2);
      QLog.e("ThemeSwitcher", 1, ((StringBuilder)localObject).toString());
      VasStatisticCollector.b("theme_skin_engine", new Pair[] { new Pair("themeId", str2), new Pair("switchSuccess", String.valueOf(bool2)), new Pair("needRetry", String.valueOf(bool1)) });
      ThemeUtil.setCurrentThemeIdVersion(paramAppRuntime, this.k.d(), "20000000");
      if (bool2)
      {
        a(0, false);
      }
      else
      {
        QLog.e("ThemeSwitcher", 1, "engine is doing a switch, retry later");
        paramAppRuntime = this.i.obtainMessage(1002, 0, 0);
        this.i.sendMessageDelayed(paramAppRuntime, 1000L);
      }
    }
    else
    {
      a(0, true);
      bool1 = false;
    }
    ThemeReporter.a(null, "theme_detail", this.g, 155, NetworkUtil.getSystemNetwork(null), 23, str2, "20000000", str1, "");
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("needRetry: ");
    paramAppRuntime.append(bool1);
    paramAppRuntime.append(" sIsSwitching: ");
    paramAppRuntime.append(d.get());
    QLog.e("ThemeSwitcher", 1, paramAppRuntime.toString());
    if (bool1)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("engine not ready, start retry: ");
      paramAppRuntime.append(this);
      QLog.e("ThemeSwitcher", 1, paramAppRuntime.toString());
      this.l = (SystemClock.uptimeMillis() + 60000L);
      m = this;
      paramAppRuntime = this.i;
      paramAppRuntime.sendMessageDelayed(paramAppRuntime.obtainMessage(1003), 2000L);
      this.h = null;
    }
  }
  
  public static boolean b()
  {
    boolean bool = d.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSwitching: ");
    localStringBuilder.append(bool);
    localStringBuilder.append(",");
    localStringBuilder.append(b);
    QLog.e("ThemeSwitcher", 1, localStringBuilder.toString());
    return bool;
  }
  
  private void c(AppRuntime paramAppRuntime)
  {
    ((IVasQuickUpdateService)paramAppRuntime.getRuntimeService(IVasQuickUpdateService.class, "")).queryItemVersion(3, this.k.e(), true, true, 0L, this);
  }
  
  private boolean c()
  {
    if (a.contains(this.g))
    {
      Object localObject = SkinEngine.getInstances().getSkinRootPath();
      String str = this.k.g();
      if ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty((CharSequence)localObject)))
      {
        QLog.e("ThemeSwitcher", 1, "needSwitch: normal not changed");
        return false;
      }
      if ((!TextUtils.isEmpty(str)) && (str.equals(localObject)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("needSwitch: ");
        ((StringBuilder)localObject).append(this.k.d());
        ((StringBuilder)localObject).append(" not changed");
        QLog.e("ThemeSwitcher", 1, ((StringBuilder)localObject).toString());
        return false;
      }
    }
    return true;
  }
  
  private void d()
  {
    ThreadManagerV2.excute(new ThemeSwitcher.1(this), 64, null, true);
  }
  
  private void e()
  {
    long l2 = this.e + 1500L - SystemClock.uptimeMillis();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    Handler localHandler = this.i;
    localHandler.sendMessageDelayed(localHandler.obtainMessage(1001), l1);
  }
  
  AppRuntime a()
  {
    Object localObject = ThemeUtil.getCreateAppRuntime();
    if ((localObject != null) && (((AppRuntime)localObject).isLogin()))
    {
      if (b != this)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("newSwitcher: ");
        ((StringBuilder)localObject).append(b);
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
  
  protected void a(AppRuntime paramAppRuntime)
  {
    this.e = SystemClock.uptimeMillis();
    String str1 = this.k.d();
    String str2 = VasTextUtil.a(paramAppRuntime.getAccount(), 2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2);
    localStringBuilder.append(" startSwitch: ");
    localStringBuilder.append(str1);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.g);
    QLog.e("ThemeSwitcher", 1, localStringBuilder.toString());
    VasStatisticCollector.b("theme_startSwitch", new Pair[] { new Pair("themeId", str1), new Pair("from", this.g) });
    this.i.sendEmptyMessage(1000);
    if ("1000".equals(str1))
    {
      e();
      return;
    }
    if ("999".equals(str1))
    {
      d();
      return;
    }
    if ("900".equals(str1))
    {
      this.k.b();
      e();
      return;
    }
    if (QQTheme.isThemeSimpleUI(str1))
    {
      e();
      return;
    }
    c(paramAppRuntime);
  }
  
  protected void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    this.c = new ThemeSwitcher.DownloadListenser(this, paramBoolean);
    ThemeUpdateCallback.sInstance.download(this.k.e());
    VasStatisticCollector.b("theme_start_download", new Pair[] { new Pair("themeId", this.k.d()) });
    ThemeReporter.a(paramAppRuntime, "theme_detail", this.g, 153, -1, 7, this.k.d(), "20000000", ThemeReporter.a, "");
  }
  
  protected boolean a(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSkinRoot: ");
    localStringBuilder.append(paramString2);
    QLog.e("ThemeSwitcher", 1, localStringBuilder.toString());
    if (QQTheme.isThemeSimpleUI(paramString1))
    {
      paramString2 = SimpleTintManager.instance();
      paramString2.setThemeId(paramString1);
      SkinEngine.getInstances().setSkinTint(paramString2);
      boolean bool = SimpleUIManager.c(paramContext);
      QQTheme.setNewSimpleThemeId(paramString1);
      return bool;
    }
    QQTheme.setNewSimpleThemeId("");
    SkinEngine.getInstances().setSkinTint(TintManager.a());
    return SkinEngine.getInstances().setSkinRootPath(paramContext, paramString2);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    AppRuntime localAppRuntime = a();
    boolean bool = false;
    int n = 0;
    if ((localAppRuntime != null) && (localAppRuntime.getApp() != null))
    {
      if (paramMessage.what == 1000)
      {
        paramMessage = this.h;
        if (paramMessage != null)
        {
          paramMessage.beginSwitch();
          return true;
        }
      }
      else
      {
        if (paramMessage.what == 1001)
        {
          b(localAppRuntime);
          return true;
        }
        if (paramMessage.what == 1002)
        {
          n = paramMessage.arg1;
          if (n < 10)
          {
            paramMessage = this.k.g();
            if (!SkinEngine.getInstances().setSkinRootPath(localAppRuntime.getApp(), paramMessage))
            {
              paramMessage = this.i.obtainMessage(1002, n + 1, 0);
              this.i.sendMessageDelayed(paramMessage, 1000L);
              return true;
            }
            paramMessage = new StringBuilder();
            paramMessage.append("retry switchSuccess: ");
            paramMessage.append(this);
            QLog.e("ThemeSwitcher", 1, paramMessage.toString());
          }
          paramMessage = new StringBuilder();
          paramMessage.append("retryCount: ");
          paramMessage.append(n);
          QLog.e("ThemeSwitcher", 1, paramMessage.toString());
          a(0, false);
          return true;
        }
        if (paramMessage.what == 1003)
        {
          if (m != this)
          {
            paramMessage = new StringBuilder();
            paramMessage.append("sRetry reset, stop retry: ");
            paramMessage.append(this);
            QLog.e("ThemeSwitcher", 1, paramMessage.toString());
            n = 1;
          }
          if (SystemClock.uptimeMillis() > this.l)
          {
            paramMessage = new StringBuilder();
            paramMessage.append("meet deadLine, stop retry ");
            paramMessage.append(this);
            QLog.e("ThemeSwitcher", 1, paramMessage.toString());
            VasMonitorDT.a("individual_v2_theme_setup_err", "engine_timeout");
            n = 1;
          }
          if (n != 0)
          {
            m = null;
            return true;
          }
          if (SkinEngine.getInstances().mResources == null)
          {
            paramMessage = this.i;
            paramMessage.sendMessageDelayed(paramMessage.obtainMessage(1003), 2000L);
            return true;
          }
          paramMessage = new StringBuilder();
          paramMessage.append("engine ready, retry: ");
          paramMessage.append(this);
          QLog.e("ThemeSwitcher", 1, paramMessage.toString());
          m = null;
          a(localAppRuntime, this.k.d(), this.g, null);
        }
      }
      return true;
    }
    n = paramMessage.what;
    if (localAppRuntime == null) {
      bool = true;
    }
    QLog.e("ThemeSwitcher", 1, new Object[] { "app null or app.getApp is null when handleMessage: ", Integer.valueOf(n), " [app null] : ", Boolean.valueOf(bool) });
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
      paramString2.append(DeviceInfoUtil.m());
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
    this.k.a(((AppRuntime)localObject).getApp(), paramString1, paramString2);
    if (a(((AppRuntime)localObject).getApp(), this.k))
    {
      paramString1 = ThemeUtil.getCurrentThemeId();
      if ((!a.contains(this.g)) && (!this.k.d().equals(paramString1)))
      {
        a((AppRuntime)localObject, true);
        return;
      }
      e();
      return;
    }
    QLog.e("ThemeSwitcher", 1, "unZip dir not exist, download again");
    this.k.c();
    a((AppRuntime)localObject, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.k.d());
    localStringBuilder.append(" start ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" ,");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.ThemeSwitcher
 * JD-Core Version:    0.7.0.1
 */
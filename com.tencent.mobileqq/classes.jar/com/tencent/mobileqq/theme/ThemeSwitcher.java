package com.tencent.mobileqq.theme;

import agej;
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
import asfa;
import bdfv;
import bdgb;
import bduy;
import behh;
import beio;
import beip;
import beis;
import beit;
import bhlo;
import bhmi;
import bhnv;
import bhyv;
import bhzz;
import biaa;
import bicq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import llk;
import mqq.app.AppRuntime;

public class ThemeSwitcher
  implements Handler.Callback, bhyv
{
  private static ThemeSwitcher jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher;
  public static final HashSet<String> a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static ThemeSwitcher jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private beio jdField_a_of_type_Beio = new beio();
  private beit jdField_a_of_type_Beit;
  private ThemeSwitcher.DownloadListenser jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher$DownloadListenser;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
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
  
  private ThemeSwitcher(QQAppInterface paramQQAppInterface, beit parambeit, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Beit = parambeit;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Beio.a(paramString1);
    this.jdField_a_of_type_JavaLangString = new SimpleDateFormat("MM-dd HH:mm:ss").format(new Date());
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (localBaseApplication == null)
    {
      QLog.e("ThemeSwitcher", 1, "unzipTheme: context == null");
      return null;
    }
    String str1 = ThemeUtil.getIDFromSCID(paramString);
    Object localObject = new beio().a(str1).a(localBaseApplication, paramString, "");
    if (!((beio)localObject).a())
    {
      QLog.e("ThemeSwitcher", 1, "unzipTheme: zip file missing");
      return null;
    }
    String str2 = ((beio)localObject).c();
    String str3 = bhmi.b(str2, "MD5");
    if (TextUtils.isEmpty(str3))
    {
      QLog.e("ThemeSwitcher", 1, "unzipTheme: fail to get md5");
      return null;
    }
    ((beio)localObject).a(localBaseApplication, paramString, str3);
    String str4 = ((beio)localObject).d();
    QLog.e("ThemeSwitcher", 1, "unzipTheme to " + str4);
    File localFile = new File(str4);
    boolean bool;
    if ((!paramBoolean) && (localFile.exists()))
    {
      if (a(localBaseApplication, (beio)localObject))
      {
        QLog.e("ThemeSwitcher", 1, "unzipTheme unzipDir exists");
        return str3;
      }
      if (!VasQuickUpdateEngine.safeDeleteFile(localFile, "theme_move_"))
      {
        bool = true;
        QLog.e("ThemeSwitcher", 1, "unzipTheme remove oldUnzip needMove: " + bool + " unzip exists: " + localFile.exists());
      }
    }
    for (;;)
    {
      if (bool) {
        if (!a(localBaseApplication, localFile)) {
          break label329;
        }
      }
      int i;
      label329:
      for (localObject = "1";; localObject = "0")
      {
        biaa.a(null, "individual_v2_theme_setup_err", "need_move", paramString, (String)localObject, Build.MODEL, Build.VERSION.RELEASE, 0.0F, 0.0F);
        bhzz.a("individual_v2_theme_setup_err", "need_move");
        i = 0;
        try
        {
          bhmi.a(str2, str4, false);
          if (localFile.exists()) {
            i = ThemeUtil.getFileNumInFile(localFile);
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            QLog.e("ThemeSwitcher", 1, "unzipTheme failed", localIOException);
            i = 0;
          }
        }
        if (i != 0) {
          break label359;
        }
        if (!paramBoolean) {
          break label353;
        }
        QLog.e("ThemeSwitcher", 1, "unzipTheme unzip failed twice");
        return null;
        bool = false;
        break;
      }
      label353:
      return a(paramString, true);
      label359:
      ThemeUtil.ThemeInfo localThemeInfo = ThemeUtil.getThemeInfo(localBaseApplication, str1);
      paramString = localThemeInfo;
      if (localThemeInfo == null)
      {
        QLog.e("ThemeSwitcher", 1, "unzipTheme no ThemeInfo " + str1);
        paramString = new ThemeUtil.ThemeInfo();
        paramString.themeId = str1;
        paramString.version = "20000000";
        paramString.zipVer = 20000000;
        paramString.isVoiceTheme = false;
      }
      paramString.status = "5";
      paramString.fileNum = i;
      long l = new File(str2).length();
      paramString.size = l;
      paramString.downsize = l;
      ThemeUtil.setThemeInfo(localBaseApplication, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitcher", 2, "unzipTheme success: " + paramString);
      }
      return str3;
      bool = paramBoolean;
    }
  }
  
  private void a()
  {
    ThreadManagerV2.excute(new ThemeSwitcher.1(this), 64, null, true);
  }
  
  private void a(int paramInt)
  {
    String str = this.jdField_a_of_type_Beio.a();
    int i = bdgb.b(str);
    if ((paramInt != 0) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (!bdgb.a(i))) {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleUILog.SimpleUIHandler", 2, "NightModeLogic.postSwitch error, mBPref = " + i + "; themeId = " + str + "; code = " + paramInt);
      }
    }
    boolean bool;
    do
    {
      return;
      bdfv localbdfv = (bdfv)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(154);
      bool = bdgb.b();
      localbdfv.a(localbdfv.a(bool, i, false, bduy.a()));
    } while (!QLog.isColorLevel());
    QLog.d("SimpleUILog.SimpleUIHandler", 2, "NightModeLogic.postSwitch, bSwitch = " + bool + "; bPref = " + i + "; themeId = " + str);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      QLog.e("ThemeSwitcher", 1, "onEndSwitch: " + paramInt + "," + paramBoolean + " " + this);
    }
    synchronized (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      if (jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher == this)
      {
        jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher = null;
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      boolean bool1 = bool2;
      if (!paramBoolean)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Beit != null) {
          bool1 = this.jdField_a_of_type_Beit.a(paramInt);
        }
      }
      if ((!bool1) && (("211".equals(this.jdField_b_of_type_JavaLangString)) || ("212".equals(this.jdField_b_of_type_JavaLangString)) || ("202".equals(this.jdField_b_of_type_JavaLangString)))) {
        a(paramInt);
      }
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    String str1 = this.jdField_a_of_type_Beio.a();
    String str2 = behh.a(paramQQAppInterface.getAccount(), 2);
    QLog.e("ThemeSwitcher", 1, str2 + " startSwitch: " + str1 + ", " + this.jdField_b_of_type_JavaLangString);
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
      this.jdField_a_of_type_Beio.b();
      b();
      return;
    }
    b(paramQQAppInterface);
  }
  
  private void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher$DownloadListenser = new ThemeSwitcher.DownloadListenser(this, paramBoolean);
    bicq.jdField_a_of_type_Bicq.download(paramQQAppInterface, this.jdField_a_of_type_Beio.b());
    beip.a(paramQQAppInterface, "theme_detail", this.jdField_b_of_type_JavaLangString, 153, -1, 7, this.jdField_a_of_type_Beio.a(), "20000000", beip.jdField_a_of_type_JavaLangString, "");
  }
  
  public static void a(String paramString, int paramInt)
  {
    QLog.e("ThemeSwitcher", 1, "onComplete: " + paramString + "," + paramInt);
    String str;
    if ((paramInt == 0) && (paramString.startsWith(bicq.jdField_a_of_type_JavaLangString)))
    {
      str = a(paramString, false);
      if (TextUtils.isEmpty(str))
      {
        biaa.a(null, "individual_v2_theme_setup_err", "unzip_fail", paramString, Build.MODEL, Build.VERSION.RELEASE, "", 0.0F, 0.0F);
        bhzz.a("individual_v2_theme_setup_err", "unzip_fail");
      }
    }
    for (;;)
    {
      if (a())
      {
        localObject = jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher;
        if (localObject != null)
        {
          localObject = ((ThemeSwitcher)localObject).jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher$DownloadListenser;
          if (localObject != null) {
            ((ThemeSwitcher.DownloadListenser)localObject).a(paramString, str, paramInt);
          }
        }
      }
      while ((paramInt != 0) || (!paramString.startsWith(bicq.jdField_a_of_type_JavaLangString)))
      {
        Object localObject;
        return;
      }
      paramString = ThemeUtil.getIDFromSCID(paramString);
      str = ThemeUtil.getCurrentThemeId();
      QLog.e("ThemeSwitcher", 1, "theme update: " + paramString + " engineId: " + str);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(str))) {
        a(paramString, "208", null);
      }
      beip.a(null, "theme_detail", "208", 153, 1, 35, paramString, "20000000", beip.jdField_a_of_type_JavaLangString, "");
      return;
      str = null;
    }
  }
  
  public static void a(String paramString, long paramLong1, long paramLong2)
  {
    Object localObject = jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((ThemeSwitcher)localObject).jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher$DownloadListenser)
    {
      if (localObject != null) {
        ((ThemeSwitcher.DownloadListenser)localObject).a(paramString, paramLong1, paramLong2);
      }
      return;
    }
  }
  
  public static boolean a()
  {
    boolean bool = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    QLog.e("ThemeSwitcher", 1, "isSwitching: " + bool + "," + jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher);
    return bool;
  }
  
  private static boolean a(Context paramContext, beio parambeio)
  {
    File localFile = new File(parambeio.d());
    paramContext = ThemeUtil.getThemeInfo(paramContext, parambeio.a());
    return (paramContext != null) && (paramContext.fileNum > 0) && (localFile.exists()) && (paramContext.fileNum == ThemeUtil.getFileNumInFile(localFile));
  }
  
  private static boolean a(Context paramContext, File paramFile)
  {
    boolean bool = false;
    paramContext = paramContext.getDir("theme_810", 0).getParentFile();
    while ((!bool) && (!paramFile.equals(paramContext)))
    {
      File localFile = new File(paramFile.getParent(), "theme_move_" + Long.toString(System.currentTimeMillis()));
      bool = paramFile.renameTo(localFile);
      QLog.e("ThemeSwitcher", 1, "unzipTheme rename " + paramFile + " success: " + bool + ", dest=" + localFile);
      paramFile = paramFile.getParentFile();
    }
    return bool;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    QLog.e("ThemeSwitcher", 1, "beforeSwitch: " + paramString1 + "=>" + paramString2);
    ThemeUtil.storeLastThemeId(paramString1);
    ChatBackgroundManager localChatBackgroundManager = (ChatBackgroundManager)paramQQAppInterface.getManager(63);
    SharedPreferences localSharedPreferences = ThemeBackground.getSharedPreferences(paramQQAppInterface.getApplication(), paramQQAppInterface.getAccount(), 0);
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals(paramString1)))
    {
      if ((!jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_b_of_type_JavaLangString)) && (!"200".equals(this.jdField_b_of_type_JavaLangString)) && ("1103".equals(paramString1)) && ("null".equals(localChatBackgroundManager.b(null))) && (localSharedPreferences.contains("theme_bg_record_for_night_mode")))
      {
        String str = localSharedPreferences.getString("theme_bg_record_for_night_mode", "null");
        localChatBackgroundManager.a(paramQQAppInterface.getAccount(), null, str, -1);
        localSharedPreferences.edit().remove("theme_bg_record_for_night_mode").apply();
      }
      if (ThemeUtil.isFixTheme(paramString2)) {
        break label238;
      }
      beis.a(paramQQAppInterface, paramString2, "20000000");
    }
    for (;;)
    {
      if (!ThemeUtil.isFixTheme(paramString2)) {
        ThemeCleaner.a(paramString1);
      }
      if (this.jdField_a_of_type_Beit == null) {
        break;
      }
      return this.jdField_a_of_type_Beit.a(this.jdField_a_of_type_Beio);
      label238:
      if ((!ThemeUtil.isFixTheme(paramString1)) && (!"206".equals(this.jdField_b_of_type_JavaLangString)) && (!paramString1.equals("1000"))) {
        beis.a(paramQQAppInterface, paramString1, "20000000");
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String arg1, String paramString2, beit parambeit)
  {
    if ((TextUtils.isEmpty(???)) || (!asfa.a(???)))
    {
      QLog.e("ThemeSwitcher", 1, "error themeId: " + ???);
      if (parambeit != null) {
        parambeit.a(1);
      }
      biaa.a(null, "individual_v2_theme_setup_err", "wrong_id", ???, ???, 0.0F);
      bhzz.a("individual_v2_theme_setup_err", "wrong_id");
      return false;
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      QLog.e("ThemeSwitcher", 1, "set " + ??? + " when NOT_FINISH " + jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher);
    }
    jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher = null;
    paramString2 = new ThemeSwitcher(paramQQAppInterface, parambeit, ???, paramString2);
    synchronized (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      parambeit = jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher;
      jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher = paramString2;
      if (parambeit != null) {
        parambeit.a(2, false);
      }
      paramString2.a(paramQQAppInterface);
      return true;
    }
  }
  
  public static boolean a(String paramString)
  {
    ThemeSwitcher localThemeSwitcher = jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher;
    return (localThemeSwitcher != null) && (localThemeSwitcher.jdField_a_of_type_Beio.a().equals(paramString));
  }
  
  public static boolean a(String paramString1, String paramString2, beit parambeit)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return a((QQAppInterface)localAppRuntime, paramString1, paramString2, parambeit);
    }
    QLog.e("ThemeSwitcher", 1, "wrong app: " + localAppRuntime);
    if (parambeit != null) {
      parambeit.a(1);
    }
    biaa.a(null, "individual_v2_theme_setup_err", "wrong_app", String.valueOf(localAppRuntime), paramString1, 0.0F);
    bhzz.a("individual_v2_theme_setup_err", "wrong_app");
    return false;
  }
  
  private void b()
  {
    long l1 = 0L;
    long l2 = this.jdField_a_of_type_Long + 1500L - SystemClock.uptimeMillis();
    if (l2 < 0L) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001), l1);
      return;
      l1 = l2;
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).queryItemVersion(3, this.jdField_a_of_type_Beio.b(), true, true, 0L, this);
  }
  
  private boolean b()
  {
    if (jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_b_of_type_JavaLangString))
    {
      String str1 = SkinEngine.getInstances().getSkinRootPath();
      String str2 = this.jdField_a_of_type_Beio.d();
      if ((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str1)))
      {
        QLog.e("ThemeSwitcher", 1, "needSwitch: normal not changed");
        return false;
      }
      if ((!TextUtils.isEmpty(str2)) && (str2.equals(str1)))
      {
        QLog.e("ThemeSwitcher", 1, "needSwitch: " + this.jdField_a_of_type_Beio.a() + " not changed");
        return false;
      }
    }
    return true;
  }
  
  QQAppInterface a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localQQAppInterface == null) || (!localQQAppInterface.isLogin()))
    {
      QLog.e("ThemeSwitcher", 1, "app is destroy: " + localQQAppInterface + " switcher: " + this);
      a(2, true);
      localQQAppInterface = null;
    }
    while (jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher == this) {
      return localQQAppInterface;
    }
    QLog.e("ThemeSwitcher", 1, "newSwitcher: " + jdField_a_of_type_ComTencentMobileqqThemeThemeSwitcher + " old is:" + this);
    return null;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    QLog.e("ThemeSwitcher", 1, "onQueryItemVer: " + paramInt + "," + paramString1 + "," + paramString2);
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    if (paramInt == 2)
    {
      a(2, false);
      paramString1 = agej.a().append("os.arch: " + System.getProperty("os.arch")).append(" DeviceInfoUtil#getCpuType: " + bhlo.g()).append(" Build.CPU_ABI: " + Build.CPU_ABI).append(" Build.CPU_ABI2: " + Build.CPU_ABI2).append(" chip:" + llk.f());
      if (Build.VERSION.SDK_INT >= 21) {
        paramString1.append(" Build.SUPPORTED_ABIS: " + Arrays.toString(Build.SUPPORTED_ABIS));
      }
      biaa.a(null, "individual_v2_theme_setup_err", "query_timeout", paramString1.toString(), toString(), 0.0F);
      bhzz.a("individual_v2_theme_setup_err", "query_timeout");
      return;
    }
    if (paramInt == 1)
    {
      a(localQQAppInterface, false);
      return;
    }
    this.jdField_a_of_type_Beio.a(localQQAppInterface.getApp(), paramString1, paramString2);
    if (a(localQQAppInterface.getApp(), this.jdField_a_of_type_Beio))
    {
      paramString1 = ThemeUtil.getCurrentThemeId();
      if ((!jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_b_of_type_JavaLangString)) && (!this.jdField_a_of_type_Beio.a().equals(paramString1)))
      {
        a(localQQAppInterface, true);
        return;
      }
      b();
      return;
    }
    QLog.e("ThemeSwitcher", 1, "unZip dir not exist, download again");
    this.jdField_a_of_type_Beio.c();
    a(localQQAppInterface, false);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    Object localObject = a();
    if (localObject == null) {
      QLog.e("ThemeSwitcher", 1, "app null when handleMessage: " + paramMessage.what);
    }
    do
    {
      return true;
      if (paramMessage.what != 1000) {
        break;
      }
    } while (this.jdField_a_of_type_Beit == null);
    this.jdField_a_of_type_Beit.a();
    return true;
    String str1;
    String str2;
    boolean bool2;
    boolean bool1;
    if (paramMessage.what == 1001)
    {
      paramMessage = ThemeUtil.getCurrentThemeId();
      str1 = this.jdField_a_of_type_Beio.a();
      str2 = this.jdField_a_of_type_Beio.d();
      ThemeBackground.needUpdateThemeForBg = false;
      if (!a((QQAppInterface)localObject, paramMessage, str1))
      {
        if (!b()) {
          break label780;
        }
        if (SkinEngine.getInstances().mResources == null)
        {
          bool2 = true;
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      label139:
      QLog.e("ThemeSwitcher", 1, "needRetry: " + bool1 + " switchSuccess: " + bool2);
      ThemeUtil.setCurrentThemeIdVersion((AppRuntime)localObject, this.jdField_a_of_type_Beio.a(), "20000000");
      if (bool2) {
        a(0, false);
      }
      for (;;)
      {
        beip.a(null, "theme_detail", this.jdField_b_of_type_JavaLangString, 155, bhnv.a(null), 23, str1, "20000000", paramMessage, "");
        QLog.e("ThemeSwitcher", 1, "needRetry: " + bool1 + " sIsSwitching: " + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
        if (!bool1) {
          break;
        }
        QLog.e("ThemeSwitcher", 1, "engine not ready, start retry: " + this);
        this.jdField_b_of_type_Long = (SystemClock.uptimeMillis() + 60000L);
        jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher = this;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1003), 2000L);
        this.jdField_a_of_type_Beit = null;
        return true;
        QLog.e("ThemeSwitcher", 1, "setSkinRoot: " + str2);
        bool2 = SkinEngine.getInstances().setSkinRootPath(((QQAppInterface)localObject).getApp(), str2);
        bool1 = false;
        break label139;
        QLog.e("ThemeSwitcher", 1, "engine is doing a switch, retry later");
        localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1002, 0, 0);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 1000L);
        continue;
        a(0, true);
        bool1 = false;
      }
      if (paramMessage.what == 1002)
      {
        i = paramMessage.arg1;
        if (i < 10)
        {
          paramMessage = this.jdField_a_of_type_Beio.d();
          if (!SkinEngine.getInstances().setSkinRootPath(((QQAppInterface)localObject).getApp(), paramMessage))
          {
            paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1002, i + 1, 0);
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 1000L);
            return true;
          }
          QLog.e("ThemeSwitcher", 1, "retry switchSuccess: " + this);
        }
        QLog.e("ThemeSwitcher", 1, "retryCount: " + i);
        a(0, false);
        return true;
      }
      if (paramMessage.what != 1003) {
        break;
      }
      if (jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher != this)
      {
        QLog.e("ThemeSwitcher", 1, "sRetry reset, stop retry: " + this);
        i = 1;
      }
      if (SystemClock.uptimeMillis() > this.jdField_b_of_type_Long)
      {
        QLog.e("ThemeSwitcher", 1, "meet deadLine, stop retry " + this);
        biaa.a(null, "individual_v2_theme_setup_err", "engine_timeout", toString(), this.jdField_a_of_type_Beio.a(), 0.0F);
        bhzz.a("individual_v2_theme_setup_err", "engine_timeout");
        i = 1;
      }
      if (i != 0)
      {
        jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher = null;
        return true;
      }
      if (SkinEngine.getInstances().mResources == null)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1003), 2000L);
        return true;
      }
      QLog.e("ThemeSwitcher", 1, "engine ready, retry: " + this);
      jdField_b_of_type_ComTencentMobileqqThemeThemeSwitcher = null;
      a((QQAppInterface)localObject, this.jdField_a_of_type_Beio.a(), this.jdField_b_of_type_JavaLangString, null);
      return true;
      label780:
      bool2 = true;
      bool1 = false;
    }
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_Beio.a() + " start " + this.jdField_a_of_type_JavaLangString + " ," + this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitcher
 * JD-Core Version:    0.7.0.1
 */
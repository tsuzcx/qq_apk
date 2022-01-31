package com.tencent.mobileqq.theme;

import aitg;
import aith;
import aiti;
import aitj;
import aitk;
import aitl;
import aitm;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.StringToIntParser;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic.StyleCallBack;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ThemeSwitchManager
  implements Manager
{
  public int a;
  public Bitmap a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public AppInterface a;
  ThemeDownloader.ThemeDownloadListener jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener = new aitj(this);
  public ThemeDownloader.ThemeUnzipListener a;
  ThemeDownloader jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader;
  public ThemeUtil.ThemeInfo a;
  public ThemeDiyStyleLogic.StyleCallBack a;
  public QQProgressDialog a;
  public Object a;
  public String a;
  public WeakReference a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public AtomicBoolean a;
  public JSONArray a;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  ThemeDiyStyleLogic.StyleCallBack jdField_b_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack = new aitg(this);
  public String b;
  public WeakReference b;
  ArrayList jdField_b_of_type_JavaUtilArrayList;
  public AtomicBoolean b;
  public boolean b;
  public String c;
  public String d;
  
  public ThemeSwitchManager(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_AndroidOsHandler = new aiti(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener = new aitk(this);
    if ((paramAppRuntime instanceof AppInterface)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)paramAppRuntime);
    }
  }
  
  public static boolean a(Bundle paramBundle)
  {
    boolean bool3 = false;
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.theme_profile.name(), "1|1|1");
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitchManager", 2, "getIsEnableAnimate profileStr:" + str);
    }
    if (!TextUtils.isEmpty(str))
    {
      Integer[] arrayOfInteger = new Integer[3];
      arrayOfInteger[0] = Integer.valueOf(0);
      arrayOfInteger[1] = Integer.valueOf(0);
      arrayOfInteger[2] = Integer.valueOf(0);
      int i = DeviceProfileManager.a(str, arrayOfInteger, new DeviceProfileManager.StringToIntParser());
      if (QLog.isColorLevel()) {
        QLog.i("ThemeSwitchManager", 2, "getIsEnableAnimate size:" + i + ", params:" + arrayOfInteger);
      }
      if (i >= 3)
      {
        boolean bool1;
        if (arrayOfInteger[0].intValue() == 1)
        {
          bool1 = true;
          if (arrayOfInteger[1].intValue() != 1) {
            break label223;
          }
        }
        label223:
        for (boolean bool2 = true;; bool2 = false)
        {
          if (arrayOfInteger[2].intValue() == 1) {
            bool3 = true;
          }
          if (paramBundle != null)
          {
            paramBundle.putBoolean("dynamic_switch", bool1);
            paramBundle.putBoolean("dynamic_enable", bool2);
            paramBundle.putBoolean("dynamic_webview_enable", bool3);
          }
          return true;
          bool1 = false;
          break;
        }
      }
    }
    return false;
  }
  
  public int a(AppInterface paramAppInterface, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ThemeSwitchManager", 1, "setSkinTheme param error, themeid=" + paramString1);
      return -1;
    }
    if (paramAppInterface == null) {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        paramAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      }
    }
    for (;;)
    {
      Object localObject1;
      if (paramAppInterface == null)
      {
        QLog.e("ThemeSwitchManager", 1, "setSkinTheme app == null");
        return -1;
        localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        if ((localObject1 instanceof AppInterface)) {
          paramAppInterface = (AppInterface)localObject1;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeSwitchManager", 2, "setSkinTheme start0 themeid:" + paramString1 + ",version:" + paramString2);
        }
        MobileQQ localMobileQQ = paramAppInterface.getApplication();
        Object localObject3 = ThemeUtil.getThemeInfo(localMobileQQ, paramString1);
        if (localObject3 == null)
        {
          localObject3 = new ThemeUtil.ThemeInfo();
          ((ThemeUtil.ThemeInfo)localObject3).themeId = paramString1;
        }
        while (paramBundle.getBoolean("skipEngineChange", false))
        {
          localObject1 = paramBundle.getString("oldEnginePath", null);
          localObject2 = SkinEngine.getInstances().getSkinRootPath();
          String str1 = ThemeUtil.getUinThemePreferences(paramAppInterface).getString("currentThemeId_6.3.5", null);
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!"999".equals(str1))) {
            break;
          }
          QLog.e("ThemeSwitchManager", 1, "setSkinTheme skipped because engine is initialized between ThemeAuth request and response.");
          return 0;
          paramString2 = ((ThemeUtil.ThemeInfo)localObject3).version;
          paramBundle.putString("version", paramString2);
        }
        Object localObject2 = ThemeUtil.getCurrentThemeInfo();
        localObject1 = ((Bundle)localObject2).getString("themeId");
        localObject2 = ((Bundle)localObject2).getString("version");
        int k = 1;
        if (QLog.isColorLevel()) {
          QLog.d("ThemeSwitchManager", 2, "setSkinTheme start engineThemeId:" + (String)localObject1 + ", engineVersion:" + (String)localObject2 + ", themeid:" + paramString1 + ",version:" + paramString2);
        }
        boolean bool4 = "1000".equals(paramString1);
        boolean bool1;
        boolean bool3;
        if (!paramString1.equals(localObject1))
        {
          bool1 = true;
          bool3 = false;
          bool2 = false;
          if (bool4) {
            break label2265;
          }
          if (20000000 <= ((ThemeUtil.ThemeInfo)localObject3).zipVer) {
            break label818;
          }
        }
        int i;
        boolean bool5;
        label818:
        for (boolean bool2 = true;; bool2 = false)
        {
          bool4 = ThemeDownloader.a(localMobileQQ, paramString1, paramString2, ((ThemeUtil.ThemeInfo)localObject3).fileNum, "207");
          if ("999".equals(paramString1)) {
            break label2258;
          }
          i = ((ThemeUtil.ThemeInfo)localObject3).zipVer;
          try
          {
            j = Integer.parseInt(paramString2);
            i = j;
            int m = Integer.parseInt((String)localObject2);
            if (j <= m) {
              break label2255;
            }
            i = j;
            if (QLog.isColorLevel())
            {
              i = j;
              QLog.d("ThemeSwitchManager", 2, "setSkinTheme versionInt > engineVerionInt engineVerionInt:" + m + ", versionInt:" + j + ", themeid:" + paramString1);
            }
            bool1 = true;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.d("ThemeSwitchManager", 2, "setSkinTheme versionInt err:" + (String)localObject1 + ", engineVersion:" + (String)localObject2 + ", themeid:" + paramString1 + ",version:" + paramString2);
              int j = i;
            }
            paramBundle.putBoolean("server_with_unzip", true);
            a(paramAppInterface, paramString1, String.valueOf(((ThemeUtil.ThemeInfo)localObject3).zipVer), paramBundle);
            return 0;
          }
          bool3 = bool1;
          if (paramBundle.getBoolean("server_with_unzip", false)) {
            break label1005;
          }
          if (bool4)
          {
            bool3 = bool1;
            if (j >= ((ThemeUtil.ThemeInfo)localObject3).zipVer) {
              break label1005;
            }
          }
          bool5 = ThemeDownloader.a(localMobileQQ, paramString1, "20000000", ((ThemeUtil.ThemeInfo)localObject3).size, "207");
          if (!bool5) {
            break label918;
          }
          localObject3 = new ThemeDownloader(paramAppInterface, "207");
          bool3 = ((ThemeDownloader)localObject3).a(localMobileQQ, paramBundle, null);
          ((ThemeDownloader)localObject3).a();
          if (!bool3) {
            break label918;
          }
          localObject3 = ThemeUtil.getThemeInfo(localMobileQQ, paramString1);
          if (localObject3 == null) {
            break label918;
          }
          bool3 = ThemeDownloader.a(localMobileQQ, paramString1, ((ThemeUtil.ThemeInfo)localObject3).version, ((ThemeUtil.ThemeInfo)localObject3).fileNum, "207");
          if ((QLog.isColorLevel()) || (!bool3)) {
            QLog.d("ThemeSwitchManager", 2, "setSkinTheme re setSkinTheme eid:" + (String)localObject1 + ", engineVersion:" + (String)localObject2 + ", themeid:" + paramString1 + ",version:" + paramString2 + ", unZipVer:" + ((ThemeUtil.ThemeInfo)localObject3).version + ", isNewFileExists=" + bool3);
          }
          if (!bool3) {
            break label918;
          }
          if ((!paramString1.equals(localObject1)) || (bool4)) {
            break label890;
          }
          paramAppInterface = ThemeUtil.getThemeResourcePath(localMobileQQ, paramString1, paramString2);
          SkinEngine.getInstances().setSkinRootPath(localMobileQQ, paramAppInterface);
          if (QLog.isColorLevel()) {
            QLog.i("ThemeSwitchManager", 2, "setSkinTheme setSkinRootPath themeResPath=" + paramAppInterface);
          }
          return 0;
          bool1 = false;
          break;
        }
        label890:
        if (!QLog.isColorLevel())
        {
          bool3 = bool1;
          if (!bool5) {}
        }
        else
        {
          QLog.d("ThemeSwitchManager", 2, "setSkinTheme update setSkinTheme eid:" + (String)localObject1 + ", engineVersion:" + (String)localObject2 + ", themeid:" + paramString1 + ",version:" + paramString2 + ", isZipExist=" + bool5);
          bool3 = bool1;
        }
        label918:
        label1005:
        if ((bool3) && (bool4))
        {
          bool1 = true;
          QLog.d("ThemeSwitchManager", 2, "setSkinTheme !isDefaultTheme version:" + paramString2 + ",themeInfo.version:" + paramString2 + ",needDownload:" + bool2 + ",isFileExists:" + bool4 + ",isChangeTheme:" + bool1);
          bool3 = bool2;
          bool2 = bool4;
        }
        label1837:
        label1985:
        label2255:
        label2258:
        label2265:
        for (;;)
        {
          bool4 = bool1;
          if (bool1)
          {
            bool4 = bool1;
            if (paramBundle != null)
            {
              bool4 = bool1;
              if (paramBundle.getInt("themeType") == 1)
              {
                bool4 = bool1;
                if ("1103".equals(localObject1))
                {
                  if (!"1103".equals(paramString1))
                  {
                    bool4 = false;
                    ThemeSwitchUtil.a(paramAppInterface, paramString1, paramString2);
                    bool1 = bool4;
                    if (ThemeUtil.getIsDIYTheme(paramString1))
                    {
                      localObject3 = localMobileQQ.getSharedPreferences("theme_background_path_" + paramAppInterface.getAccount(), 0);
                      String str2 = ((SharedPreferences)localObject3).getString("theme_bg_aio_path", "null");
                      bool1 = bool4;
                      if (!TextUtils.isEmpty(str2))
                      {
                        bool1 = bool4;
                        if (!"null".equals(str2))
                        {
                          ((SharedPreferences)localObject3).edit().putString("theme_bg_record_for_night_mode", str2).commit();
                          bool1 = bool4;
                        }
                      }
                    }
                  }
                  bool4 = bool1;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("ThemeSwitchManager", 2, "setSkinTheme, THEME_ID_NIGHTMODE. if update Night:" + "1103".equals(paramString1));
                    bool4 = bool1;
                  }
                }
              }
            }
          }
          if (bool4)
          {
            if (ThemeUtil.getIsDIYTheme(paramString1))
            {
              localObject1 = localMobileQQ.getSharedPreferences("theme_background_path_" + paramAppInterface.getAccount(), 0).getString("theme_bg_aio_path", "null");
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"null".equals(localObject1))) {
                ChatBackground.a(localMobileQQ, paramAppInterface.getAccount(), null, (String)localObject1);
              }
            }
            localObject1 = ThemeUtil.getThemeResourcePath(localMobileQQ, paramString1, paramString2);
            SkinEngine.getInstances().setSkinRootPath(localMobileQQ, (String)localObject1);
            if (QLog.isColorLevel()) {
              QLog.i("ThemeSwitchManager", 2, "setSkinTheme setSkinRootPath themeResPath=" + (String)localObject1);
            }
            ThemeUtil.setCurrentThemeIdVersion(paramAppInterface, paramString1, paramString2);
            if ((paramBundle != null) && (paramAppInterface != null) && ((paramAppInterface instanceof QQAppInterface)) && (((QQAppInterface)paramAppInterface).isAppOnForeground(localMobileQQ)) && (paramBundle.getInt("themeType") == 1))
            {
              ThreadManager.getUIHandler().post(new aitl(this, localMobileQQ, paramString1));
              if (bool3) {
                VasQuickUpdateManager.a(paramAppInterface, 3L, ThemeUtil.getThemeConfigID(paramString1), ThemeUtil.getThemeDownloadFilePath(localMobileQQ, paramString1, "20000000") + "_no", true, null);
              }
            }
            paramBundle = paramString2;
            localObject1 = paramString1;
            i = k;
            if (QLog.isColorLevel()) {
              QLog.d("ThemeSwitchManager", 2, "setSkinTheme end stId:" + (String)localObject1 + ", stVersion:" + paramBundle + ", id:" + paramString1 + ",version:" + paramString2 + ", status:" + 0);
            }
            if (paramString1.equals(localObject1)) {
              break label2166;
            }
            QLog.e("ThemeSwitchManager", 1, "setSkinTheme id error, stId:" + (String)localObject1 + ", stVersion:" + paramBundle + ", id:" + paramString1 + ",version:" + paramString2 + ", status:" + 0);
          }
          for (;;)
          {
            if (i != 0) {
              ((ThemeHandler)paramAppInterface.getBusinessHandler(14)).a(null, null, true);
            }
            com.tencent.mobileqq.theme.diy.ThemeBackground.needUpdateThemeForBg = false;
            return 0;
            bool1 = false;
            break;
            if ((bool3) || (!bool2))
            {
              if ((paramBundle != null) && (!paramBundle.getBoolean("server_after_download", false)))
              {
                i = NetworkUtil.a(null);
                bool1 = "999".equals(paramString1);
                if (bool1) {
                  paramBundle.putInt("net_type", 1);
                }
                if ((i == 1) || (i == 4) || (bool1))
                {
                  bool1 = true;
                  bool2 = false;
                  if (!bool1) {
                    bool2 = ThemeDownloader.a(localMobileQQ, paramString1, "20000000", paramBundle.getLong("size", 0L), "207");
                  }
                  if ((!bool1) && (bool2)) {
                    break label1985;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ThemeSwitchManager", 2, "setSkinTheme go to download theme, id:" + paramString1 + ",version:" + paramString2 + ", netType:" + i + ", isZipExist=" + bool2 + ", canDown=" + bool1);
                  }
                  ThreadManager.post(new aitm(this, paramBundle), 8, null, true);
                }
                for (i = 0;; i = 1)
                {
                  paramBundle = (Bundle)localObject2;
                  break;
                  bool1 = false;
                  break label1837;
                  QLog.e("ThemeSwitchManager", 1, "setSkinTheme not to download theme, id:" + paramString1 + ",version:" + paramString2 + ", netType:" + i + ", isZipExist=" + bool2 + ", canDown=" + bool1);
                }
              }
              localObject3 = new StringBuilder().append("setSkinTheme file not exists error, id:").append(paramString1).append(",version:").append(paramString2).append(",status:").append(0).append(", tInfo:");
              if (paramBundle != null) {
                break label2160;
              }
            }
            label2160:
            for (bool1 = true;; bool1 = false)
            {
              QLog.e("ThemeSwitchManager", 1, bool1 + ", needDownload=" + bool3 + ", isFileExists=" + bool2);
              paramBundle = (Bundle)localObject2;
              i = k;
              break;
            }
            label2166:
            if ((!"1000".equals(paramString1)) && (!paramString2.equals(paramBundle))) {
              QLog.e("ThemeSwitchManager", 1, "setSkinTheme version error, stId:" + (String)localObject1 + ", stVersion:" + paramBundle + ", id:" + paramString1 + ",version:" + paramString2 + ", status:" + 0);
            }
          }
          break;
          bool3 = bool1;
          break label1005;
        }
      }
    }
  }
  
  public void a()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
      {
        QLog.e("ThemeSwitchManager", 1, "doScreenShot, currActivityRef is null");
        return;
      }
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        localObject = localActivity.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null) {
            this.jdField_a_of_type_AndroidViewView = ((View)localObject).getRootView();
          }
        }
      }
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ThemeSwitchManager", 2, "doScreenShot, rootView is null");
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      QLog.e("ThemeSwitchManager", 1, "doScreenShot oom, no animation", localThrowable);
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getParent() != null)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidWidgetImageView.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetImageView);
      }
      this.jdField_a_of_type_AndroidWidgetImageView = null;
      while (QLog.isColorLevel())
      {
        QLog.d("ThemeSwitchManager", 2, "drawingCache is:" + this.jdField_a_of_type_AndroidGraphicsBitmap);
        return;
        boolean bool1 = this.jdField_a_of_type_AndroidViewView.isDrawingCacheEnabled();
        boolean bool2 = this.jdField_a_of_type_AndroidViewView.willNotCacheDrawing();
        this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(true);
        this.jdField_a_of_type_AndroidViewView.setWillNotCacheDrawing(false);
        localObject = this.jdField_a_of_type_AndroidViewView.getDrawingCache();
        if (localObject != null)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((Bitmap)localObject);
          this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(localThrowable);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          if ((localThrowable instanceof QQBrowserActivity))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(220);
            if (QLog.isColorLevel()) {
              QLog.d("ThemeSwitchManager", 2, "doScreenShot, refActivity is QQBrowserActivity");
            }
          }
          ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewView;
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          localViewGroup.addView(this.jdField_a_of_type_AndroidWidgetImageView);
        }
        this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(bool1);
        this.jdField_a_of_type_AndroidViewView.setWillNotCacheDrawing(bool2);
      }
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (paramInt1 < 0) {
      QLog.e("ThemeSwitchManager", 1, "dispatchEvent Err stateCode:" + paramInt1 + ", step:" + paramInt2 + ", themeId:" + paramString1 + ", from:" + this.c);
    }
    for (;;)
    {
      if (-3 != paramInt1) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        ((ThemeSwitchManager.ThemeSwitchListener)localIterator.next()).onSwitchCallback(paramInt1, paramString1, paramString2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 2, "dispatchEvent stateCode:" + paramInt1 + ", step:" + paramInt2 + ", themeId:" + paramString1 + ", from:" + this.c);
      }
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    String str2 = ThemeUtil.getIDFromSCID(paramString1);
    String str1 = ThemeUtil.getCurrentThemeId();
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitchManager", 2, "themeUpdate bid = " + paramLong + ", cfgScid=" + paramString2 + ",scid = " + paramString1 + " from = " + paramString3 + " errorCode = " + paramInt1 + ", httpCode=" + paramInt2 + ", themeid=" + str2 + ", engineId=" + str1);
    }
    if ((!TextUtils.isEmpty(str1)) && (str1.equals(str2)))
    {
      paramString1 = new Bundle();
      paramString1.putBoolean("server_after_download", true);
      paramString1.putString("themeId", str1);
      paramString1.putString("version", String.valueOf(200));
      a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, str1, String.valueOf(200), paramString1);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramBundle == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeSwitchManager", 2, "7day theme preDownload loadIndex:" + this.jdField_b_of_type_Int);
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder().append("7day theme preDownload end: downloadingArr :");
            if (this.jdField_a_of_type_JavaUtilArrayList != null) {
              break label262;
            }
            bool = true;
            QLog.d("ThemeSwitchManager", 2, bool);
          }
          return;
        }
        paramBundle = (Bundle)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int);
        this.jdField_b_of_type_Int += 1;
        if (paramBundle == null)
        {
          QLog.e("ThemeSwitchManager", 2, "7day theme preDownload error themeInfo==null loadIndex:" + this.jdField_b_of_type_Int);
          a(null);
          return;
        }
      }
      finally {}
      for (String str = "203";; str = "207")
      {
        if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader = new ThemeDownloader(this.jdField_a_of_type_ComTencentCommonAppAppInterface, str);
          this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), paramBundle, this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener);
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ThemeSwitchManager", 2, "preDownload from server theme");
        }
      }
      label262:
      boolean bool = false;
    }
  }
  
  public void a(ThemeSwitchManager.ThemeSwitchListener paramThemeSwitchListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if ((paramBoolean1) && (paramThemeSwitchListener != null)) {}
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramThemeSwitchListener)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramThemeSwitchListener);
      }
      if ((paramBoolean2) && (paramThemeSwitchListener != null)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramThemeSwitchListener);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (paramBoolean1)
      {
        if (this.jdField_b_of_type_JavaUtilArrayList == null) {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        }
        if (this.jdField_b_of_type_JavaUtilArrayList.indexOf(paramString) < 0) {
          this.jdField_b_of_type_JavaUtilArrayList.add(paramString);
        }
      }
      if ((paramBoolean2) && (this.jdField_b_of_type_JavaUtilArrayList != null)) {
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramString);
      }
      return;
    }
  }
  
  public void a(JSONArray paramJSONArray, int paramInt1, String arg3, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) || (this.jdField_a_of_type_OrgJsonJSONArray == null) || (this.jdField_a_of_type_OrgJsonJSONArray.length() <= this.jdField_a_of_type_Int)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitchManager", 2, "preDownloadWeekTheme nIndex:" + paramInt1 + ", from:" + ??? + ",loadType:" + paramInt2);
    }
    if (paramInt2 == 0)
    {
      this.jdField_a_of_type_OrgJsonJSONArray = paramJSONArray;
      this.jdField_a_of_type_Int = paramInt1;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), null, null);
    }
    label519:
    for (;;)
    {
      ArrayList localArrayList;
      Object localObject;
      try
      {
        if ((this.jdField_a_of_type_OrgJsonJSONArray == null) || (this.jdField_a_of_type_OrgJsonJSONArray.length() <= this.jdField_a_of_type_Int)) {
          break;
        }
        paramJSONArray = new ArrayList();
        localArrayList = new ArrayList();
        paramInt1 = 0;
        if (paramInt1 >= this.jdField_a_of_type_OrgJsonJSONArray.length()) {
          break label475;
        }
        localObject = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(paramInt1);
        if (localObject == null) {
          break label519;
        }
        String str1 = ((JSONObject)localObject).getString("url");
        String str2 = ((JSONObject)localObject).getString("id");
        String str3 = ((JSONObject)localObject).getString("version");
        long l = ((JSONObject)localObject).getInt("size");
        if (((JSONObject)localObject).has("isSound"))
        {
          paramInt2 = ((JSONObject)localObject).getInt("isSound");
          if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (l <= 0L)) {
            break label519;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("url", str1);
          ((Bundle)localObject).putString("themeId", str2);
          ((Bundle)localObject).putString("version", str3);
          ((Bundle)localObject).putLong("size", l);
          if (paramInt2 != 1) {
            break label427;
          }
          bool = true;
          ((Bundle)localObject).putBoolean("isVoiceTheme", bool);
          if (!"203".equals(???)) {
            break label433;
          }
          ((Bundle)localObject).putInt("net_type", 1);
          if (paramInt1 >= this.jdField_a_of_type_Int) {
            break label465;
          }
          localArrayList.add(localObject);
        }
      }
      catch (Exception paramJSONArray)
      {
        QLog.e("ThemeSwitchManager", 1, "preDownloadWeekTheme error:" + paramJSONArray.getMessage());
        return;
      }
      paramInt2 = 0;
      continue;
      label427:
      boolean bool = false;
      continue;
      label433:
      if (paramInt1 != this.jdField_a_of_type_Int)
      {
        ((Bundle)localObject).putInt("net_type", 3);
      }
      else
      {
        ((Bundle)localObject).putInt("themeType", 1);
        continue;
        label465:
        paramJSONArray.add(localObject);
        break label519;
        label475:
        paramJSONArray.addAll(localArrayList);
        if (paramJSONArray.size() <= 0) {
          break;
        }
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilArrayList = paramJSONArray;
          this.jdField_b_of_type_Int = 0;
          a(null);
          return;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime, Activity paramActivity, ThemeUtil.ThemeInfo paramThemeInfo, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((paramAppRuntime == null) || (paramActivity == null) || (paramThemeInfo == null) || (TextUtils.isEmpty(paramThemeInfo.themeId)))
    {
      QLog.e("ThemeSwitchManager", 2, "setup param Error ,runtime=" + paramAppRuntime + ",activity=" + paramActivity + ",themeInfo=" + paramThemeInfo);
      a(-1, "-1", "-1", 10);
      return false;
    }
    String str = paramThemeInfo.themeId;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      a(-1, str, this.jdField_b_of_type_JavaLangString, 12);
      return false;
    }
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramAppRuntime);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo = paramThemeInfo;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.c = paramString;
    this.jdField_b_of_type_JavaLangString = paramThemeInfo.version;
    this.jdField_a_of_type_JavaLangString = str;
    this.d = ThemeReporter.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitchManager", 2, "setup,themeId=" + str + ",version=" + this.jdField_b_of_type_JavaLangString + ",isSound=" + paramThemeInfo.isVoiceTheme);
    }
    paramThemeInfo = ThemeUtil.getCurrentThemeInfo();
    paramActivity = paramThemeInfo.getString("themeId");
    paramThemeInfo = paramThemeInfo.getString("version");
    if ((str.equals(paramActivity)) && (this.jdField_b_of_type_JavaLangString.equals(paramThemeInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeSwitchManager", 2, "setup the same theme,themeId=" + str + ",version=" + this.jdField_b_of_type_JavaLangString);
      }
      ThemeUtil.setCurrentThemeIdVersion(paramAppRuntime, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      a(1, str, this.jdField_b_of_type_JavaLangString, 11);
      return true;
    }
    com.tencent.mobileqq.theme.diy.ThemeBackground.needUpdateThemeForBg = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_Boolean) {
      if ((paramAppRuntime != null) && ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof QQAppInterface)))
      {
        paramAppRuntime = new Bundle();
        ((ThemeHandler)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(14)).a(str, this.jdField_b_of_type_JavaLangString, null, paramAppRuntime, this.jdField_b_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack);
      }
    }
    for (;;)
    {
      return true;
      a(-1, str, this.jdField_b_of_type_JavaLangString, 12);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return false;
      this.jdField_b_of_type_ComTencentMobileqqThemeDiyThemeDiyStyleLogic$StyleCallBack.callback(0, 4, null, null);
    }
  }
  
  public boolean a(AppRuntime arg1, String paramString)
  {
    boolean bool2 = false;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (TextUtils.isEmpty(paramString)) {
          return false;
        }
        if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.indexOf(paramString) >= 0))
        {
          bool1 = true;
          if (bool1) {
            break label85;
          }
          int i = NetworkUtil.a(null);
          if (i == 1) {
            break label88;
          }
          bool1 = bool2;
          if (i == 4) {
            break label88;
          }
          return bool1;
        }
      }
      boolean bool1 = false;
      continue;
      label85:
      continue;
      label88:
      bool1 = true;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 2, "onPostThemeChanged rootView is null");
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      if ((!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.1F);
        localAlphaAnimation.setDuration(501L);
        localAlphaAnimation.setInterpolator(new LinearInterpolator());
        localAlphaAnimation.setFillAfter(true);
        this.jdField_a_of_type_AndroidWidgetImageView.setAnimation(localAlphaAnimation);
        this.jdField_a_of_type_AndroidViewView.postDelayed(new aith(this), 601L);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = null;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 2, "onPostThemeChanged drawingCache is null");
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader.a();
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchManager
 * JD-Core Version:    0.7.0.1
 */
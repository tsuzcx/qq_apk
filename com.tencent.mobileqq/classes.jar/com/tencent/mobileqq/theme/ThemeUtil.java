package com.tencent.mobileqq.theme;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.IndividuationConfigInfo;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class ThemeUtil
{
  public static final int ANIMATE_BG_AIO = 3;
  public static final int ANIMATE_BG_CONVERSATION = 2;
  public static final int ANIMATE_BG_DRAWER = 1;
  public static final int ANIMATE_TAB_CALL = 13;
  public static final int ANIMATE_TAB_CONTACTS = 12;
  public static final int ANIMATE_TAB_CONVERSATION = 11;
  public static final int ANIMATE_TAB_LEBA = 14;
  public static final int ANIMATE_TAB_NOW = 15;
  public static final int ANIMATE_TAB_SEE = 16;
  public static final String DEFAULT_THEME_ID = "1000";
  public static final int DIY_STYLE_START = 5000;
  public static final String DIY_THEME_ID = "999";
  public static final String DIY_THEME_VERSION = "20000000";
  public static final String OLD_ENGINE_PATH = "oldEnginePath";
  public static final String PKG_SUFFIX = ".zip";
  public static final String SKIP_ENGINE_CHANGE = "skipEngineChange";
  public static final String SP_KEY_AUTH_TIME = "authTime";
  public static final String TAG = "Theme.ThemeUtil";
  public static final String THEME_DEBUG_KEY = "ThemeDebugKeyLog:";
  public static final String THEME_ERROR_ID_LIST = "listOfErrorThemeSrc";
  public static final String THEME_ID = "themeId";
  public static final String THEME_ID_NIGHTMODE = "1103";
  public static final String THEME_ISVOICE = "isVoiceTheme";
  public static final String THEME_KEY_CURRENT_THEME_ID = "currentThemeId_6.3.5";
  public static final String THEME_KEY_CURRENT_THEME_VERSION = "currentThemeVersion";
  public static final String THEME_KEY_USER_DOWNLOAD = "userDownloadTheme";
  public static final String THEME_KEY_USER_SWITCH_TIMES = "user_switch_theme_times";
  public static final String THEME_MSSAGE_VOICE_NAME = "message.mp3";
  public static final String THEME_PATH = "themePath";
  public static final String THEME_SET_TIME_KEY = "themeSetTimeKey";
  public static final String THEME_SHARED_PREFERENCES = "userThemeSharedPreferences";
  public static final String THEME_SIZE = "size";
  public static final String THEME_STATUS = "themeStatus";
  public static final String THEME_STATUS_COMPLETE = "5";
  public static final String THEME_STATUS_DOWNLOAD_END = "3";
  public static final String THEME_STATUS_DOWNLOAD_NONE = "1";
  public static final String THEME_STATUS_DOWNLOAD_PAUSE = "4";
  public static final String THEME_STATUS_DOWNLOAD_PROGRESS = "2";
  public static final String THEME_TYPE = "themeType";
  static final String THEME_TYPE_ANIMATE = "animation";
  public static final int THEME_TYPE_FROM_SERVER = 1;
  public static final String THEME_URL = "url";
  public static final String THEME_VERSION = "version";
  public static final String THEME_VOICE_BASE_HOME = "voice";
  public static final String THEME_VOICE_SETTING = "theme_voice_setting_";
  public static final String WEEK_KEY_INDEX = "themeIndex";
  public static final String WEEK_KEY_SERIES_ID = "seriesID";
  public static final String WEEK_KEY_THEME_ARRAY = "themeArray";
  public static final String WEEK_KEY_THEME_LENGTH = "themeLength";
  public static final String WEEK_KEY_THEME_START_TIME = "startTime";
  public static boolean isNowThemeDefaultCache = true;
  static boolean isThemeIsAnimate;
  static String mAnimateThemeId;
  static String mAnimateThemePath;
  static String uin;
  
  public static void delOldThemeResDir(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Object localObject = paramString3;
    for (;;)
    {
      int i;
      try
      {
        if (QLog.isColorLevel())
        {
          localObject = paramString3;
          QLog.e("Theme.ThemeUtil", 2, "delOldThemeResDir themeId=" + paramString1 + ", version=" + paramString2 + ", themeResPath=" + paramString3 + ",andDelZip=" + paramBoolean);
        }
        localObject = paramString3;
        if (android.text.TextUtils.isEmpty(paramString1)) {
          break label720;
        }
        localObject = paramString3;
        if ("1000".equals(paramString1)) {
          break label720;
        }
        localObject = paramString3;
        if (android.text.TextUtils.isEmpty(paramString2)) {
          break label720;
        }
        localObject = paramString3;
        if (paramString2.equals(String.valueOf(200))) {
          break label720;
        }
        localObject = paramString3;
        if (android.text.TextUtils.isEmpty(paramString3)) {
          return;
        }
        String str1 = paramString3;
        localObject = paramString3;
        if (paramString3.endsWith(File.separator))
        {
          localObject = paramString3;
          str1 = paramString3.substring(0, paramString3.length() - 1);
        }
        localObject = str1;
        i = str1.lastIndexOf(File.separator);
        if (i <= 0) {
          break label730;
        }
        localObject = str1;
        paramString3 = str1.substring(0, i);
        if (paramString3 == null) {
          break label720;
        }
        localObject = str1;
        String str3 = SkinEngine.getInstances().getSkinRootPath();
        localObject = str1;
        if (!android.text.TextUtils.isEmpty(str3))
        {
          str2 = str3;
          localObject = str1;
          if (str3.endsWith(File.separator))
          {
            localObject = str1;
            str2 = str3.substring(0, str3.length() - 1);
          }
          localObject = str1;
          i = str2.lastIndexOf(File.separator);
          localObject = str1;
          if (i < str2.length() - 1)
          {
            localObject = str1;
            str2 = str2.substring(i + 1);
            localObject = str1;
            str3 = paramString1 + "_" + paramString2;
            localObject = str1;
            String[] arrayOfString1 = new File(paramString3).list();
            localObject = str1;
            long l = Long.parseLong(paramString2);
            localObject = str1;
            i = arrayOfString1.length - 1;
            if (i < 0) {
              break label720;
            }
            String str4 = arrayOfString1[i];
            localObject = str1;
            if (QLog.isColorLevel())
            {
              localObject = str1;
              QLog.d("Theme.ThemeUtil", 2, "delOldThemeResDir test themeId=" + paramString1 + ", version=" + paramString2 + ", dirName=" + str4);
            }
            localObject = str1;
            if (android.text.TextUtils.isEmpty(str4)) {
              break label721;
            }
            localObject = str1;
            if (str4.equals(str3)) {
              break label721;
            }
            localObject = str1;
            if (str4.equals(str2)) {
              break label721;
            }
            localObject = str1;
            String[] arrayOfString2 = str4.split("_");
            localObject = str1;
            if (arrayOfString2.length != 2) {
              break label721;
            }
            localObject = str1;
            if (!paramString1.equals(arrayOfString2[0])) {
              break label721;
            }
            localObject = str1;
            if (android.text.TextUtils.isEmpty(arrayOfString2[1])) {
              break label721;
            }
            localObject = str1;
            if (l <= Long.parseLong(arrayOfString2[1])) {
              break label721;
            }
            localObject = str1;
            if (QLog.isColorLevel())
            {
              localObject = str1;
              QLog.d("Theme.ThemeUtil", 2, "delOldThemeResDir del themeId=" + paramString1 + ", version=" + paramString2 + ", dirName=" + str4);
            }
            localObject = str1;
            FileUtils.a(paramString3 + File.separator + str4);
          }
        }
      }
      catch (Exception paramString3)
      {
        QLog.e("Theme.ThemeUtil", 1, "delOldThemeResDir Exception themeId=" + paramString1 + ", version=" + paramString2 + ", themeResPath=" + (String)localObject + ",andDelZip=" + paramBoolean + ", eMsg=" + paramString3.getMessage());
        return;
      }
      String str2 = null;
      continue;
      label720:
      return;
      label721:
      i -= 1;
      continue;
      label730:
      paramString3 = null;
    }
  }
  
  public static String getAnimatePathByTag(int paramInt)
  {
    Object localObject2 = null;
    if (android.text.TextUtils.isEmpty(mAnimateThemePath))
    {
      localObject1 = getCurrentThemeInfo().getString("themePath");
      if (!((String)localObject1).endsWith(File.separator)) {
        break label184;
      }
      mAnimateThemePath = (String)localObject1;
      if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
        QLog.e("Theme.ThemeUtil", 2, "getAnimatePathByTag err ApngImage path = " + null);
      }
    }
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeUtil", 2, "getAnimatePathByTag ApngImage path = " + (String)localObject1);
      }
      return localObject1;
      label184:
      mAnimateThemePath = (String)localObject1 + File.separator;
      break;
      localObject1 = mAnimateThemePath + "raw/qvip_drawer_bg_animate.png";
      continue;
      localObject1 = mAnimateThemePath + "raw/qvip_conversation_bg_animate.png";
      continue;
      localObject1 = mAnimateThemePath + "raw/qvip_chatbackground_animate.png";
      continue;
      localObject1 = mAnimateThemePath + "raw/qvip_tab_icon_conversation_animate.png";
      continue;
      localObject1 = mAnimateThemePath + "raw/qvip_tab_icon_contact_animate.png";
      continue;
      localObject1 = mAnimateThemePath + "raw/qvip_tab_icon_call_animate.png";
      continue;
      localObject1 = mAnimateThemePath + "raw/qvip_tab_icon_plugin_animate.png";
      continue;
      localObject1 = mAnimateThemePath + "raw/qvip_tab_icon_now_animate.png";
      continue;
      localObject1 = mAnimateThemePath + "raw/qvip_tab_icon_see_animate.png";
    }
  }
  
  public static String getCurrentThemeId()
  {
    String str2 = getCurrentThemeInfo().getString("themeId");
    String str1 = str2;
    if (android.text.TextUtils.isEmpty(str2)) {
      str1 = "1000";
    }
    return str1;
  }
  
  public static Bundle getCurrentThemeInfo()
  {
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putString("themeId", "1000");
      localBundle.putString("version", "0");
      String str = SkinEngine.getInstances().getSkinRootPath();
      localBundle.putString("themePath", str);
      if ((str != null) && (str.length() > 0))
      {
        Object localObject = str;
        if (str.endsWith(File.separator)) {
          localObject = str.substring(0, str.length() - 1);
        }
        localObject = ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1);
        if (localObject != null)
        {
          localObject = ((String)localObject).split("_");
          if (localObject.length == 2)
          {
            localBundle.putString("themeId", localObject[0]);
            localBundle.putString("version", localObject[1]);
          }
        }
      }
      return localBundle;
    }
    catch (Exception localException)
    {
      QLog.e("Theme.ThemeUtil", 1, "getCurrentThemeInfo, exception:", localException);
    }
    return localBundle;
  }
  
  public static int getErrorThemeId(Context paramContext, String paramString)
  {
    int j = 0;
    paramContext = getThemePreferences(paramContext).getString("listOfErrorThemeSrc", "");
    int i = j;
    if (paramContext != null)
    {
      i = j;
      if (paramContext.length() <= 0) {}
    }
    try
    {
      paramContext = new JSONObject(paramContext);
      i = j;
      if (paramContext.has(paramString)) {
        i = paramContext.getInt(paramString);
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        i = j;
      } while (!QLog.isColorLevel());
      QLog.d("Theme.ThemeUtil", 2, "getErrorThemeId error:" + paramContext.getMessage());
    }
    return i;
    return 0;
  }
  
  public static int getFileNumInFile(File paramFile)
  {
    if (paramFile != null) {}
    for (;;)
    {
      int k;
      try
      {
        if (!paramFile.exists()) {
          return 0;
        }
        if (!paramFile.isDirectory()) {
          return 1;
        }
        paramFile = paramFile.listFiles();
        int i;
        int j;
        if ((paramFile != null) && (paramFile.length > 0))
        {
          i = paramFile.length;
          k = i - 1;
          i = 0;
          j = i;
          if ((k >= 0) && (paramFile[k] == null)) {}
        }
        else
        {
          String[] arrayOfString;
          return 0;
        }
      }
      catch (Exception paramFile)
      {
        try
        {
          if (paramFile[k].isDirectory())
          {
            arrayOfString = paramFile[k].list();
            if (arrayOfString != null)
            {
              j = arrayOfString.length;
              i = j + i;
            }
            else
            {
              j = 0;
              continue;
            }
          }
          else
          {
            i += 1;
          }
        }
        catch (OutOfMemoryError paramFile)
        {
          continue;
        }
        catch (Exception paramFile)
        {
          continue;
        }
        paramFile = paramFile;
        i = 0;
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.e("Theme.ThemeUtil", 2, "ThemeJsHandler getFileNumInFile, error:" + paramFile.getMessage());
          j = i;
        }
        return j;
      }
      catch (OutOfMemoryError paramFile)
      {
        i = 0;
        j = i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Theme.ThemeUtil", 2, "ThemeJsHandler getFileNumInFile, OOM:" + paramFile.getMessage());
        j = i;
        continue;
      }
      k -= 1;
    }
  }
  
  public static String getIDFromSCID(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (android.text.TextUtils.isEmpty(paramString))
    {
      QLog.e("Theme.ThemeUtil", 1, "getIDFromSCID error null: zipName=" + paramString);
      localObject2 = localObject1;
      return localObject2;
    }
    int j = 0;
    String[] arrayOfString = paramString.split("\\.");
    int i;
    if ((paramString.startsWith("theme.android.")) && (arrayOfString.length > 3))
    {
      localObject1 = arrayOfString[2];
      i = j;
    }
    for (;;)
    {
      if (!QLog.isColorLevel())
      {
        localObject2 = localObject1;
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
      }
      QLog.d("Theme.ThemeUtil", 2, "getIDFromSCID ok, zipName = " + paramString + ", themeid=" + (String)localObject1 + ", idType=" + i);
      return localObject1;
      i = j;
      localObject1 = localObject2;
      if (paramString.startsWith("theme."))
      {
        i = j;
        localObject1 = localObject2;
        if (arrayOfString.length > 1)
        {
          localObject1 = arrayOfString[1];
          i = 2;
        }
      }
    }
  }
  
  public static boolean getIsDIYTheme(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = getCurrentThemeId();
    }
    boolean bool2 = "999".equals(str);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (str == null) {}
    }
    try
    {
      int i = Integer.parseInt(str);
      if (i >= 5000)
      {
        bool1 = true;
        return bool1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      QLog.d("Theme.ThemeUtil", 2, "getIsDIYTheme err" + paramString.getMessage());
    }
    return bool2;
  }
  
  public static String getThemeConfigID(String paramString)
  {
    return "theme." + paramString + ".cfg";
  }
  
  public static String getThemeDensity(Context paramContext)
  {
    if (paramContext == null) {
      return "xh";
    }
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (paramContext.densityDpi <= 160) {
      return "m";
    }
    if ((paramContext.densityDpi > 160) && (paramContext.densityDpi < 320)) {
      return "h";
    }
    return "xh";
  }
  
  public static String getThemeDownloadFilePath(Context paramContext, String paramString1, String paramString2)
  {
    if (android.text.TextUtils.isEmpty(paramString1)) {
      QLog.e("Theme.ThemeUtil", 1, "getThemeDownloadFilePath null themeId:" + paramString1);
    }
    if (android.text.TextUtils.isEmpty(paramString1)) {
      paramString2 = "20000000";
    }
    paramContext = AppConstants.bT;
    return paramContext + paramString1 + "_" + paramString2 + ".zip";
  }
  
  public static int getThemeDownloadNum(Context paramContext)
  {
    int m = 0;
    int n = 0;
    int i = 0;
    paramContext = getThemePreferences(paramContext).getString("userDownloadTheme", "");
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeUtil", 2, "getThemeDownloadNum, userThemeStr = " + paramContext);
    }
    k = n;
    if (paramContext != null)
    {
      int j = m;
      k = n;
      try
      {
        if (paramContext.length() > 0)
        {
          j = m;
          paramContext = new JSONObject(paramContext);
          j = m;
          Iterator localIterator = paramContext.keys();
          for (;;)
          {
            j = i;
            k = i;
            if (!localIterator.hasNext()) {
              break;
            }
            j = i;
            String str = paramContext.getJSONObject(String.valueOf(localIterator.next())).getString("status");
            j = i;
            if (!str.equals("5"))
            {
              j = i;
              boolean bool = str.equals("3");
              if (!bool) {}
            }
            else
            {
              i += 1;
            }
          }
        }
        return k;
      }
      catch (Exception paramContext)
      {
        k = j;
        if (QLog.isColorLevel())
        {
          QLog.d("Theme.ThemeUtil", 2, "getThemeDownloadNum error:" + paramContext.getMessage());
          k = j;
        }
      }
    }
  }
  
  public static ThemeUtil.ThemeInfo getThemeInfo(Context paramContext, String paramString)
  {
    ThemeUtil.ThemeInfo localThemeInfo = null;
    if ((paramContext == null) || (android.text.TextUtils.isEmpty(paramString)))
    {
      QLog.e("Theme.ThemeUtil", 1, "getThemeInfoFromSp error, themeId:" + paramString + ", context:" + paramContext);
      paramContext = localThemeInfo;
    }
    do
    {
      do
      {
        return paramContext;
        str = getThemePreferences(paramContext).getString(paramString, "");
        if (!android.text.TextUtils.isEmpty(str)) {
          break;
        }
        paramContext = localThemeInfo;
      } while (!QLog.isColorLevel());
      QLog.d("Theme.ThemeUtil", 2, "getThemeInfoFromSp null, themeId:" + paramString);
      return null;
      paramContext = str.split(",");
      if (paramContext.length < 5)
      {
        QLog.e("Theme.ThemeUtil", 1, "getThemeInfoFromSp error length: userThemeStr=" + str);
        return null;
      }
      localThemeInfo = new ThemeUtil.ThemeInfo();
      try
      {
        localThemeInfo.themeId = paramString;
        if (!android.text.TextUtils.isEmpty(paramContext[0])) {
          localThemeInfo.zipVer = Integer.parseInt(paramContext[0]);
        }
        if (!android.text.TextUtils.isEmpty(paramContext[1])) {
          localThemeInfo.version = paramContext[1];
        }
        if (!android.text.TextUtils.isEmpty(paramContext[2])) {
          localThemeInfo.fileNum = Integer.parseInt(paramContext[2]);
        }
        localThemeInfo.isVoiceTheme = "1".equals(paramContext[3]);
        if (!android.text.TextUtils.isEmpty(paramContext[4])) {
          localThemeInfo.size = Long.parseLong(paramContext[4]);
        }
        if (!android.text.TextUtils.isEmpty(paramContext[5])) {
          localThemeInfo.downsize = Long.parseLong(paramContext[5]);
        }
        if (!android.text.TextUtils.isEmpty(paramContext[6])) {
          localThemeInfo.status = paramContext[6];
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          QLog.e("Theme.ThemeUtil", 1, "getThemeInfoFromSp error: userThemeStr=" + str + ", msg:" + paramContext.getMessage());
        }
      }
      paramContext = localThemeInfo;
    } while (!QLog.isColorLevel());
    QLog.d("Theme.ThemeUtil", 2, "getThemeInfoFromSp end, themeId:" + paramString + ", userThemeStr=" + str);
    return localThemeInfo;
  }
  
  public static SharedPreferences getThemePreferences(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null)
    {
      paramContext = BaseApplicationImpl.sApplication.getApplicationContext();
      localContext = paramContext;
      if (QLog.isColorLevel())
      {
        QLog.d("Theme.ThemeUtil", 2, "getThemePreferences null == context");
        localContext = paramContext;
      }
    }
    return localContext.getSharedPreferences("userThemeSharedPreferences", 4);
  }
  
  public static String getThemeResourcePath(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (!android.text.TextUtils.isEmpty(paramString1))
    {
      localObject1 = localObject3;
      if (!android.text.TextUtils.isEmpty(paramString2))
      {
        localObject1 = localObject3;
        if (android.text.TextUtils.equals(paramString1, "1000")) {}
      }
    }
    for (;;)
    {
      try
      {
        if (Utils.b()) {
          paramContext = AppConstants.bN + "using_theme_res";
        }
      }
      catch (Exception paramString1)
      {
        paramContext = localObject2;
      }
      try
      {
        localObject1 = paramContext + File.separator + paramString1 + "_" + paramString2;
        return localObject1;
      }
      catch (Exception paramString1)
      {
        label122:
        break label122;
      }
      if (paramContext == null)
      {
        QLog.e("Theme.ThemeUtil", 1, "getThemeResourcePath Error null == context");
        return null;
        QLog.e("Theme.ThemeUtil", 1, "getThemeResourcePath error:" + paramString1.getMessage());
        return paramContext;
      }
      paramContext = paramContext.getDir("mobileqq_theme", 0).getAbsolutePath();
    }
  }
  
  public static int getThemeSwitchTimes(QQAppInterface paramQQAppInterface)
  {
    int j = getUinThemePreferences(paramQQAppInterface).getInt("user_switch_theme_times", -1);
    int i = j;
    if (-1 == j) {
      i = paramQQAppInterface.getPreferences().getInt("user_switch_theme_times", 0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "getThemeSwitchTimes userSwitchThemeTimes=" + i);
    }
    return i;
  }
  
  public static String getThemeVoiceRootPath()
  {
    Object localObject = SkinEngine.getInstances().getSkinRootPath();
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new File((String)localObject + File.separatorChar + "voice");
      if (((File)localObject).exists()) {
        return ((File)localObject).getAbsolutePath();
      }
    }
    return null;
  }
  
  public static SharedPreferences getUinThemePreferences(AppRuntime paramAppRuntime)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null)
    {
      paramAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
      localAppRuntime = paramAppRuntime;
      if (QLog.isColorLevel())
      {
        QLog.d("Theme.ThemeUtil", 2, "getUinThemePreferences null == application");
        localAppRuntime = paramAppRuntime;
      }
    }
    String str = localAppRuntime.getAccount();
    paramAppRuntime = str;
    if (str == null)
    {
      str = "noLogin";
      paramAppRuntime = str;
      if (QLog.isColorLevel())
      {
        QLog.d("Theme.ThemeUtil", 2, "getUinThemePreferences,uin=noLogin");
        paramAppRuntime = str;
      }
    }
    return localAppRuntime.getApplication().getSharedPreferences(paramAppRuntime + "_theme", 4);
  }
  
  public static String getUserCurrentThemeId(AppRuntime paramAppRuntime)
  {
    Object localObject1 = paramAppRuntime;
    Object localObject2;
    if (paramAppRuntime == null)
    {
      paramAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeId,application == null");
      }
      localObject1 = paramAppRuntime;
      if (paramAppRuntime == null)
      {
        QLog.e("Theme.ThemeUtil", 1, "getUserCurrentThemeId Error,application == null");
        localObject2 = "1000";
      }
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return localObject2;
      localSharedPreferences = getUinThemePreferences((AppRuntime)localObject1);
      localObject2 = localSharedPreferences.getString("currentThemeId_6.3.5", null);
      paramAppRuntime = ((AppRuntime)localObject1).getAccount();
      localObject1 = paramAppRuntime;
      if (paramAppRuntime == null)
      {
        localObject1 = "noLogin";
        QLog.e("Theme.ThemeUtil", 1, "getUserCurrentThemeId Error, uin=noLogin");
      }
      paramAppRuntime = (AppRuntime)localObject2;
      if (android.text.TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeVersion,null == currentThemeId, currentThemeId= ThemeUtil.DEFAULT_THEME_ID");
        }
        paramAppRuntime = "1000";
      }
      localObject2 = paramAppRuntime;
    } while (!QLog.isColorLevel());
    long l = localSharedPreferences.getLong("themeSetTimeKey", 0L);
    QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeId,uin=" + com.tencent.mobileqq.text.TextUtils.a((String)localObject1, 2) + ",currentThemeId=" + paramAppRuntime + ", oldTime=" + l);
    return paramAppRuntime;
  }
  
  public static String getUserCurrentThemeVersion(AppInterface paramAppInterface)
  {
    Object localObject1;
    Object localObject2;
    if (paramAppInterface == null)
    {
      localObject1 = (AppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeVersion,application == null");
      }
      paramAppInterface = (AppInterface)localObject1;
      if (localObject1 == null)
      {
        QLog.e("Theme.ThemeUtil", 1, "getUserCurrentThemeVersion Error,application == null");
        localObject2 = "0";
      }
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return localObject2;
      localSharedPreferences = getUinThemePreferences(paramAppInterface);
      paramAppInterface = paramAppInterface.getAccount();
      localObject1 = paramAppInterface;
      if (paramAppInterface == null)
      {
        localObject1 = "noLogin";
        QLog.e("Theme.ThemeUtil", 1, "getUserCurrentThemeVersion Error, uin=noLogin");
      }
      localObject2 = localSharedPreferences.getString("currentThemeVersion", null);
      paramAppInterface = (AppInterface)localObject2;
      if (android.text.TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = "0";
        paramAppInterface = (AppInterface)localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeVersion,currentThemeVersion == null, currentThemeVersion=" + "0");
          paramAppInterface = (AppInterface)localObject2;
        }
      }
      localObject2 = paramAppInterface;
    } while (!QLog.isColorLevel());
    long l = localSharedPreferences.getLong("themeSetTimeKey", 0L);
    QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeVersion,uin=" + com.tencent.mobileqq.text.TextUtils.a((String)localObject1, 2) + ",currentThemeVersion=" + paramAppInterface + ", oldTime=" + l);
    return paramAppInterface;
  }
  
  private static String getUserThemeIDForReset(AppInterface paramAppInterface)
  {
    Object localObject2 = getUinThemePreferences(paramAppInterface);
    if (((SharedPreferences)localObject2).contains("currentThemeId_6.3.5"))
    {
      localObject1 = ((SharedPreferences)localObject2).getString("currentThemeId_6.3.5", "1000");
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeUtil", 2, "initTheme current qq already set theme:" + (String)localObject1);
      }
      if ("1103".equals(localObject1)) {}
      for (paramAppInterface = null; !android.text.TextUtils.isEmpty(paramAppInterface); paramAppInterface = getWeekLoopTheme(paramAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "initTheme current qq already set weekThemeId:" + paramAppInterface);
        }
        return paramAppInterface;
      }
    }
    QLog.d("Theme.ThemeUtil", 1, "getUserThemeIDForReset sp.THEME_KEY_CURRENT_THEME_ID == null");
    Object localObject3 = new ArrayList();
    Object localObject1 = ((SharedPreferences)localObject2).getAll();
    if (localObject1 == null) {
      localObject1 = new HashMap();
    }
    for (;;)
    {
      Object localObject4 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Map.Entry)((Iterator)localObject4).next()).getKey();
        if (str.startsWith("currentThemeId_")) {
          ((List)localObject3).add(str);
        }
      }
      if (((List)localObject3).isEmpty())
      {
        QLog.d("Theme.ThemeUtil", 1, "initTheme list.isEmpty()");
        setCurrentThemeIdVersion(paramAppInterface, "1000", "0");
        return "1000";
      }
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeUtil", 2, "set previous theme!");
      }
      Collections.sort((List)localObject3);
      localObject4 = (String)((List)localObject3).get(((List)localObject3).size() - 1);
      localObject3 = ((SharedPreferences)localObject2).getString("currentThemeVersion", "0");
      if (IndividuationConfigInfo.a("6.0", "7.6.0"))
      {
        localObject2 = (String)((Map)localObject1).get(localObject4);
        localObject1 = localObject2;
        if (!"1000".equals(localObject2))
        {
          localObject1 = localObject2;
          if ((paramAppInterface instanceof QQAppInterface)) {
            ((ThemeHandler)((QQAppInterface)paramAppInterface).a(14)).a((String)localObject2, (String)localObject3, false);
          }
        }
      }
      for (localObject1 = localObject2;; localObject1 = "1000")
      {
        setCurrentThemeIdVersion(paramAppInterface, (String)localObject1, (String)localObject3);
        return localObject1;
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeUtil", 2, "old version or app == null.");
        }
      }
    }
    return localObject1;
  }
  
  public static String getWeekLoopTheme(AppInterface paramAppInterface)
  {
    SharedPreferences localSharedPreferences = getUinThemePreferences(paramAppInterface);
    for (;;)
    {
      int j;
      try
      {
        str = localSharedPreferences.getString("themeArray", null);
        if ((!android.text.TextUtils.isEmpty(localSharedPreferences.getString("seriesID", null))) && (!android.text.TextUtils.isEmpty(str)))
        {
          i = localSharedPreferences.getInt("themeLength", 7);
          j = localSharedPreferences.getInt("themeIndex", 0);
          long l = localSharedPreferences.getLong("startTime", -28800L);
          int k = TimeZone.getTimeZone("GMT+8").getRawOffset();
          if (System.currentTimeMillis() <= l) {
            break label520;
          }
          i = ((int)Math.ceil((System.currentTimeMillis() + k) / 86400000L) - (int)Math.ceil((l + k) / 86400000L)) % i;
          if (QLog.isColorLevel()) {
            QLog.d("Theme.ThemeUtil", 2, "getWeekLoopTheme nIndex:" + j + ", tIndex:" + i);
          }
          if (j != i)
          {
            localJSONArray = new JSONArray(str);
            if (localJSONArray.length() > 0)
            {
              if (i < localJSONArray.length()) {
                break label517;
              }
              i = 0;
              localObject2 = localJSONArray.getJSONObject(i);
              if (localObject2 != null)
              {
                str = ((JSONObject)localObject2).getString("id");
                if (localObject2 == null) {
                  continue;
                }
                localObject2 = ((JSONObject)localObject2).getString("version");
                if ((android.text.TextUtils.isEmpty(str)) || (android.text.TextUtils.isEmpty((CharSequence)localObject2))) {
                  continue;
                }
                ThemeUtil.ThemeInfo localThemeInfo = getThemeInfo(paramAppInterface.getApp(), str);
                if ((localThemeInfo == null) || (!((String)localObject2).equals(localThemeInfo.version))) {
                  continue;
                }
                boolean bool = "5".equals(localThemeInfo.status);
                if (!bool) {
                  continue;
                }
              }
            }
          }
        }
      }
      catch (Exception localException1)
      {
        String str;
        JSONArray localJSONArray;
        Object localObject2;
        paramAppInterface = null;
        QLog.e("Theme.ThemeUtil", 1, "getWeekLoopTheme error:" + localException1.getMessage());
        return paramAppInterface;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "getWeekLoopTheme ok: sThemeId = " + str);
        }
        setCurrentThemeIdVersion(paramAppInterface, str, (String)localObject2);
        paramAppInterface = localSharedPreferences.edit();
        paramAppInterface.putInt("themeIndex", i);
        paramAppInterface.commit();
        paramAppInterface = str;
      }
      catch (Exception localException3)
      {
        paramAppInterface = localException1;
        Object localObject1 = localException3;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "getWeekLoopTheme seriesID || themeArray = null");
        }
        return paramAppInterface;
      }
      catch (Exception localException2)
      {
        continue;
      }
      str = null;
      continue;
      localObject2 = null;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeUtil", 2, "getWeekLoopTheme waitting: sThemeId = " + str);
      }
      ((ThemeSwitchManager)paramAppInterface.getManager(184)).a(localJSONArray, i, "206", 0);
      paramAppInterface = null;
      continue;
      label517:
      continue;
      label520:
      int i = j;
    }
  }
  
  @TargetApi(9)
  public static void initTheme(QQAppInterface paramQQAppInterface)
  {
    if ((!paramQQAppInterface.isLogin()) || ((!android.text.TextUtils.isEmpty(uin)) && (uin.equals(paramQQAppInterface.getCurrentAccountUin())))) {
      return;
    }
    uin = paramQQAppInterface.getCurrentAccountUin();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    Object localObject1 = getCurrentThemeInfo();
    String str2 = ((Bundle)localObject1).getString("themeId");
    String str3 = getUserThemeIDForReset(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeUtil", 2, "initTheme,userThemeId=" + str3 + ",engine currentThemeId=" + str2 + ", enginePath=" + ((Bundle)localObject1).getString("themePath"));
    }
    if (!str2.equals(str3)) {
      if (str3.equals("1000"))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeUtil", 1, "initTheme reset user to default theme, currentThemeId:" + str2);
        }
        SkinEngine.getInstances().setSkinRootPath(localBaseApplicationImpl, null);
      }
    }
    for (;;)
    {
      isNowThemeIsAnimate();
      localObject1 = (VasMonitorHandler)paramQQAppInterface.a(103);
      if (((VasMonitorHandler)localObject1).b.get()) {
        break;
      }
      ((VasMonitorHandler)localObject1).a(paramQQAppInterface, true);
      return;
      localObject1 = getThemeInfo(localBaseApplicationImpl, str3);
      String str1;
      label231:
      int i;
      label267:
      Object localObject2;
      if (localObject1 != null)
      {
        str1 = ((ThemeUtil.ThemeInfo)localObject1).version;
        i = 0;
        if (android.text.TextUtils.isEmpty(str1)) {
          break label507;
        }
        localObject1 = getThemeResourcePath(localBaseApplicationImpl, str3, str1);
        if (!new File((String)localObject1).exists()) {
          break label470;
        }
        i = 1;
        j = i;
        localObject2 = localObject1;
        if (android.text.TextUtils.isEmpty((CharSequence)localObject1))
        {
          String str4 = getUserCurrentThemeVersion(paramQQAppInterface);
          j = i;
          localObject2 = localObject1;
          if (!android.text.TextUtils.isEmpty(str4))
          {
            j = i;
            localObject2 = localObject1;
            if (!str4.equals(str1))
            {
              localObject2 = getThemeResourcePath(localBaseApplicationImpl, str3, str4);
              if (!new File((String)localObject2).exists()) {
                break label512;
              }
            }
          }
        }
      }
      for (int j = i + 10;; j = i)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "initTheme reset theme all themePath=" + (String)localObject2 + ", step=" + j + ", currentThemeId:" + str2);
        }
        if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
          break label557;
        }
        SkinEngine.getInstances().setSkinRootPath(localBaseApplicationImpl, (String)localObject2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Theme.ThemeUtil", 1, "initTheme set theme: themePath:" + (String)localObject2 + ", currentThemeId:" + str2);
        break;
        str1 = null;
        break label231;
        label470:
        QLog.d("Theme.ThemeUtil", 1, "initTheme set sp theme Error themePath:" + null + ", currentThemeId:" + str2);
        label507:
        localObject1 = null;
        break label267;
        label512:
        QLog.d("Theme.ThemeUtil", 1, "initTheme set user theme Error themePath:" + null + ", currentThemeId:" + str2);
        localObject2 = null;
      }
      label557:
      QLog.e("Theme.ThemeUtil", 2, "initTheme reset theme all Error themePath=" + (String)localObject2 + ", step=" + j + ", currentThemeId:" + str2);
      SkinEngine.getInstances().setSkinRootPath(localBaseApplicationImpl, null);
      setCurrentThemeIdVersion(paramQQAppInterface, "1000", "0");
      continue;
      localObject1 = SkinEngine.getInstances().getSkinRootPath();
      if ((localObject1 != null) && (((String)localObject1).length() > 0) && (str2.equals("1000")))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeUtil", 2, "initTheme reset user to default theme for old version,currentThemeResPath=" + (String)localObject1);
        }
        SkinEngine.getInstances().setSkinRootPath(localBaseApplicationImpl, null);
      }
      QLog.i("Theme.ThemeUtil", 1, "initTheme theme currentThemeResPath:" + (String)localObject1);
    }
  }
  
  @Deprecated
  public static boolean isDefaultOrDIYTheme()
  {
    String str = getUserCurrentThemeId(null);
    return ("1000".equals(str)) || ("999".equals(str));
  }
  
  public static boolean isDefaultOrDIYTheme(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = getUserCurrentThemeId(null); ("1000".equals(str)) || ("999".equals(str)); str = getCurrentThemeId()) {
      return true;
    }
    return false;
  }
  
  public static boolean isDefaultTheme()
  {
    return "1000".equals(getUserCurrentThemeId(null));
  }
  
  @Deprecated
  public static boolean isInNightMode(AppRuntime paramAppRuntime)
  {
    return "1103".equals(getUserCurrentThemeId(paramAppRuntime));
  }
  
  public static boolean isNeedUpdataById(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!android.text.TextUtils.isEmpty(paramString))
    {
      bool1 = true;
      if (!bool1) {
        break label92;
      }
      bool1 = bool2;
      if (!"1000".equals(paramString))
      {
        bool1 = bool2;
        if (!"999".equals(paramString)) {
          bool1 = true;
        }
      }
    }
    label92:
    for (;;)
    {
      if ((!bool1) || (QLog.isColorLevel())) {
        QLog.d("Theme.ThemeUtil", 1, "isNeedUpdataById error null: themeId=" + paramString + ", isUpdate=" + bool1);
      }
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public static boolean isNowThemeIsAnimate()
  {
    Object localObject3 = null;
    boolean bool2 = false;
    boolean bool3 = false;
    String str;
    boolean bool1;
    try
    {
      Bundle localBundle = getCurrentThemeInfo();
      str = localBundle.getString("themeId");
      if (str.equals(mAnimateThemeId)) {
        bool1 = isThemeIsAnimate;
      }
      for (;;)
      {
        return bool1;
        mAnimateThemePath = null;
        isThemeIsAnimate = false;
        if ((android.text.TextUtils.isEmpty(str)) || ("1000".equals(str)) || ("999".equals(str)))
        {
          mAnimateThemeId = str;
          bool1 = bool3;
        }
        else
        {
          try
          {
            if (Integer.parseInt(str) >= 5000)
            {
              mAnimateThemeId = str;
              bool1 = bool3;
            }
          }
          catch (Exception localException)
          {
            QLog.d("Theme.ThemeUtil", 2, "isNowThemeIsAnimate err" + localException.getMessage());
            localObject2 = localObject1.getString("themePath");
            if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
              break label516;
            }
          }
        }
      }
    }
    finally {}
    Object localObject2;
    label193:
    Object localObject5;
    if (((String)localObject2).endsWith(File.separator))
    {
      localObject3 = (String)localObject2 + "config.json";
      localObject5 = new File((String)localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeUtil", 2, "isNowThemeIsAnimate ApngImage path = " + (String)localObject3 + ", exists:" + ((File)localObject5).exists());
      }
      bool1 = ((File)localObject5).exists();
      localObject3 = localObject2;
      if (!bool1) {
        break label516;
      }
    }
    for (;;)
    {
      Object localObject4;
      try
      {
        localObject3 = FileUtils.a((File)localObject5, -1);
        bool1 = bool3;
        if (localObject3 == null) {
          break;
        }
        bool1 = bool3;
        if (((String)localObject3).length() < 2) {
          break;
        }
        localObject3 = new JSONObject((String)localObject3).optString("type");
        if (QLog.isColorLevel()) {
          QLog.w("Theme.ThemeUtil", 2, "isNowThemeIsAnimate theme Type:" + (String)localObject3);
        }
        bool1 = "animation".equals(localObject3);
        if (bool1)
        {
          isThemeIsAnimate = true;
          mAnimateThemePath = (String)localObject2;
        }
        if (isThemeIsAnimate)
        {
          localObject2 = new Bundle();
          if (ThemeSwitchManager.a((Bundle)localObject2))
          {
            bool1 = bool2;
            if (((Bundle)localObject2).getBoolean("dynamic_switch", true))
            {
              bool1 = bool2;
              if (((Bundle)localObject2).getBoolean("dynamic_enable", true)) {
                bool1 = true;
              }
            }
            isThemeIsAnimate = bool1;
          }
        }
        mAnimateThemeId = str;
        bool1 = isThemeIsAnimate;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Theme.ThemeUtil", 1, "isNowThemeIsAnimate err , msg:" + localThrowable.getMessage());
        localObject4 = localObject2;
      }
      localObject5 = (String)localObject2 + File.separator;
      localObject3 = (String)localObject2 + File.separator + "config.json";
      localObject2 = localObject5;
      break label193;
      label516:
      bool1 = false;
      localObject2 = localObject4;
    }
  }
  
  public static boolean isNowThemeIsDIY()
  {
    String str = getCurrentThemeId();
    boolean bool2 = "999".equals(str);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (str == null) {}
    }
    try
    {
      int i = Integer.parseInt(str);
      if (i >= 5000)
      {
        bool1 = true;
        return bool1;
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.d("Theme.ThemeUtil", 2, "getIsDIYTheme err" + localException.getMessage());
    }
    return bool2;
  }
  
  public static boolean isNowThemeIsDefault(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (android.text.TextUtils.isEmpty(paramString)) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (str = getUserCurrentThemeId(paramAppRuntime);; str = getCurrentThemeId()) {
      return "1000".equals(str);
    }
  }
  
  public static boolean isNowThemeIsDefaultCache(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (paramBoolean) {
      isNowThemeDefaultCache = isNowThemeIsDefault(paramAppRuntime, false, null);
    }
    return isNowThemeDefaultCache;
  }
  
  public static boolean isNowThemeIsNight(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (android.text.TextUtils.isEmpty(paramString)) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (str = getUserCurrentThemeId(paramAppRuntime);; str = getCurrentThemeId()) {
      return "1103".equals(str);
    }
  }
  
  public static void resetThemeSwitchTimes(QQAppInterface paramQQAppInterface)
  {
    getUinThemePreferences(paramQQAppInterface).edit().putInt("user_switch_theme_times", 0).commit();
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("user_switch_theme_times", 0);
    paramQQAppInterface.commit();
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "resetThemeSwitchTimes");
    }
  }
  
  public static Boolean setCurrentThemeIdVersion(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if (paramAppRuntime == null)
    {
      localObject1 = (AppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (QLog.isColorLevel()) {
        QLog.e("Theme.ThemeUtil", 1, "setCurrentThemeIdVersion,application == null");
      }
      paramAppRuntime = (AppRuntime)localObject1;
      if (localObject1 == null)
      {
        QLog.e("Theme.ThemeUtil", 1, "setCurrentThemeIdVersion Error,application == null");
        return Boolean.valueOf(false);
      }
    }
    if ((android.text.TextUtils.isEmpty(paramString1)) || (android.text.TextUtils.isEmpty(paramString2)))
    {
      QLog.e("Theme.ThemeUtil", 1, "setCurrentThemeIdVersion Error,themeId or version == null, themeId:" + paramString1 + "version:" + paramString2);
      return Boolean.valueOf(false);
    }
    long l1 = System.currentTimeMillis();
    Object localObject2 = getUinThemePreferences(paramAppRuntime);
    String str = paramAppRuntime.getAccount();
    Object localObject1 = str;
    if (str == null)
    {
      localObject1 = "noLogin";
      QLog.e("Theme.ThemeUtil", 1, "setCurrentThemeIdVersion Error,uin=noLogin");
    }
    str = ((SharedPreferences)localObject2).getString("currentThemeId_6.3.5", "1000");
    int i = ((SharedPreferences)localObject2).getInt("user_switch_theme_times", 0);
    long l2 = ((SharedPreferences)localObject2).getLong("themeSetTimeKey", 0L);
    i += 1;
    localObject2 = ((SharedPreferences)localObject2).edit();
    ((SharedPreferences.Editor)localObject2).putString("currentThemeId_6.3.5", paramString1);
    ((SharedPreferences.Editor)localObject2).putString("currentThemeVersion", paramString2);
    ((SharedPreferences.Editor)localObject2).putInt("user_switch_theme_times", i);
    ((SharedPreferences.Editor)localObject2).putLong("themeSetTimeKey", l1);
    boolean bool1 = ((SharedPreferences.Editor)localObject2).commit();
    localObject2 = paramAppRuntime.getApplication().getSharedPreferences((String)localObject1, 4).edit();
    ((SharedPreferences.Editor)localObject2).putString("currentThemeId_6.3.5", paramString1);
    ((SharedPreferences.Editor)localObject2).putString("currentThemeVersion", paramString2);
    ((SharedPreferences.Editor)localObject2).putInt("user_switch_theme_times", i);
    boolean bool2 = ((SharedPreferences.Editor)localObject2).commit();
    QLog.d("Theme.ThemeUtil", 1, "setCurrentThemeIdVersion,uin=" + com.tencent.mobileqq.text.TextUtils.a((String)localObject1, 2) + ",oldUsrThemeId=" + str + ",set new themeId=" + paramString1 + ",set new version=" + paramString2 + ", userSwitchThemeTimes=" + i + ",commitSuss=" + bool1 + ", oldTime=" + l2 + ", commitSussOld:" + bool2);
    try
    {
      paramString2 = new HashMap();
      paramString2.put("param_themeId", paramString1);
      paramString2.put("param_singleSp", String.valueOf(bool1));
      StatisticCollector.a(paramAppRuntime.getApplication().getApplicationContext()).a((String)localObject1, "VipSetCurrentThemeIdVersion", bool1, 1L, 0L, paramString2, "", false);
      label471:
      return Boolean.valueOf(bool1);
    }
    catch (Exception paramAppRuntime)
    {
      break label471;
    }
  }
  
  public static void setErrorThemeId(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = getThemePreferences(paramContext);
    SharedPreferences.Editor localEditor = paramContext.edit();
    paramContext = paramContext.getString("listOfErrorThemeSrc", "");
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "setErrorThemeID themeId=" + paramString);
    }
    label178:
    label195:
    label196:
    label199:
    for (;;)
    {
      int i;
      try
      {
        if (android.text.TextUtils.isEmpty(paramContext))
        {
          paramContext = new JSONObject();
          if (!paramContext.has(paramString)) {
            break label196;
          }
          i = paramContext.getInt(paramString);
          break label178;
          paramContext.put(paramString, i);
          localEditor.putString("listOfErrorThemeSrc", paramContext.toString()).commit();
          return;
        }
        paramContext = new JSONObject(paramContext);
        continue;
        i = i % 100000 + 300001;
        continue;
        QLog.d("Theme.ThemeUtil", 2, "setErrorThemeId error:" + paramContext.getMessage());
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label195;
        }
      }
      return;
      for (;;)
      {
        if (!paramBoolean) {
          break label199;
        }
        i = i % 100000 + 500000;
        break;
        return;
        i = 0;
      }
    }
  }
  
  public static Boolean setThemeInfo(Context paramContext, ThemeUtil.ThemeInfo paramThemeInfo)
  {
    if ((paramContext == null) || (paramThemeInfo == null))
    {
      QLog.e("Theme.ThemeUtil", 1, "setThemeInfoToSp error, themeInfo:" + paramThemeInfo + ", context:" + paramContext);
      return Boolean.valueOf(false);
    }
    SharedPreferences.Editor localEditor = getThemePreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThemeInfo.zipVer);
    localStringBuilder.append(",");
    localStringBuilder.append(paramThemeInfo.version);
    localStringBuilder.append(",");
    localStringBuilder.append(paramThemeInfo.fileNum);
    localStringBuilder.append(",");
    if (paramThemeInfo.isVoiceTheme) {}
    for (paramContext = "1";; paramContext = "0")
    {
      localStringBuilder.append(paramContext);
      localStringBuilder.append(",");
      localStringBuilder.append(paramThemeInfo.size);
      localStringBuilder.append(",");
      localStringBuilder.append(paramThemeInfo.downsize);
      localStringBuilder.append(",");
      localStringBuilder.append(paramThemeInfo.status);
      paramContext = localStringBuilder.toString();
      boolean bool = localEditor.putString(paramThemeInfo.themeId, paramContext).commit();
      if ((!bool) || (QLog.isColorLevel())) {
        QLog.d("Theme.ThemeUtil", 2, "setThemeInfoToSp sp comit ret=" + bool + ", themeStr=" + paramContext + " themeInfo = " + paramThemeInfo);
      }
      return Boolean.valueOf(bool);
    }
  }
  
  public static boolean setWeekLoopTheme(AppRuntime paramAppRuntime, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "setWeekLoopTheme, seriesID=" + paramString1 + ", themeArray=" + paramString2 + ", startTime=" + paramLong);
    }
    SharedPreferences localSharedPreferences = getUinThemePreferences(paramAppRuntime);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    boolean bool2;
    if (android.text.TextUtils.isEmpty(paramString1))
    {
      if (!android.text.TextUtils.isEmpty(localSharedPreferences.getString("seriesID", null)))
      {
        localEditor.putString("seriesID", "");
        localEditor.putString("themeArray", "");
        bool2 = localEditor.commit();
        return bool2;
      }
    }
    else
    {
      try
      {
        localEditor.putString("seriesID", paramString1);
        localEditor.putString("themeArray", paramString2);
        if (android.text.TextUtils.isEmpty(paramString2)) {
          break label321;
        }
        j = new JSONArray(paramString2).length();
        if (j <= 0)
        {
          QLog.e("Theme.ThemeUtil", 2, "setWeekLoopTheme themeJsonArr Error:0 == length");
          return false;
        }
        i = TimeZone.getTimeZone("GMT+8").getRawOffset();
        if (System.currentTimeMillis() <= paramLong) {
          break label433;
        }
        i = ((int)Math.ceil((System.currentTimeMillis() + i) / 86400000L) - (int)Math.ceil((i + paramLong) / 86400000L)) % j;
      }
      catch (Exception paramAppRuntime)
      {
        for (;;)
        {
          int j;
          label288:
          label321:
          boolean bool1 = true;
          label408:
          continue;
          int i = 0;
        }
      }
      localEditor.putInt("themeLength", j);
      localEditor.putInt("themeIndex", i);
      localEditor.putLong("startTime", paramLong);
      if ((paramAppRuntime instanceof QQAppInterface))
      {
        paramAppRuntime = (QQAppInterface)paramAppRuntime;
        if (paramAppRuntime == null) {
          break label408;
        }
        ((ThemeSwitchManager)paramAppRuntime.getManager(184)).a(new JSONArray(paramString2), i + 1, "203", 2);
      }
      for (;;)
      {
        for (;;)
        {
          bool1 = localEditor.commit();
          bool2 = bool1;
          try
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Theme.ThemeUtil", 2, "setWeekLoopTheme , setWeekLoopTheme is ok:" + bool1);
            return bool1;
          }
          catch (Exception paramAppRuntime) {}
        }
        QLog.e("Theme.ThemeUtil", 2, "setWeekLoopTheme json Error:" + paramAppRuntime.getMessage());
        return bool1;
        paramAppRuntime = null;
        break label288;
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "setWeekLoopTheme , goto download null != qapp");
        }
      }
    }
    label433:
    return true;
  }
  
  public static void validLocalTheme(Context paramContext, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeUtil
 * JD-Core Version:    0.7.0.1
 */
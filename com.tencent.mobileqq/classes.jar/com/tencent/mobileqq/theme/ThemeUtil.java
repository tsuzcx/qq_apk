package com.tencent.mobileqq.theme;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.IndividuationConfigInfo;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import com.tencent.mobileqq.vas.quickupdate.MusicPlayerCallback;
import com.tencent.mobileqq.vas.quickupdate.MusicThemeCallback;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
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
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
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
  public static final int ANIMATE_TAB_QCIRCLE = 17;
  public static final int ANIMATE_TAB_SEE = 16;
  public static final String DEFAULT_THEME_ID = "1000";
  public static final String DIY_ASSETS_NAME = "999_540";
  public static final int DIY_STYLE_END = 1000000;
  public static final int DIY_STYLE_START = 5000;
  public static final String DIY_THEME_ID = "999";
  public static final String DIY_THEME_VERSION = "20000000";
  public static final String LOCAL_THEME_ID = "900";
  public static ColorFilter NIGHTMODE_COLORFILTER;
  public static final int NIGHTMODE_MASKCOLOR;
  public static final String OLD_ENGINE_PATH = "oldEnginePath";
  public static final String PKG_SUFFIX = ".zip";
  public static final String SP_KEY_AUTH_TIME = "authTime";
  public static final String SP_KEY_CLEAN_LIST = "cleanList";
  public static final String TAG = "Theme.ThemeUtil";
  public static final String THEME_ANIMATION_AIO_VIDEO = "qq_skin_aio.mp4";
  public static final String THEME_ANIMATION_CONVERSATION_VIDEO = "qq_skin_conversation.mp4";
  public static final String THEME_ANIMATION_DRAWER_CONVERSATION_VIDEO = "qq_skin_drawer_conversation.mp4";
  public static final String THEME_ANIMATION_DRAWER_VIDEO = "qq_skin_drawer.mp4";
  public static final String THEME_DEBUG_KEY = "ThemeDebugKeyLog:";
  public static final String[] THEME_DEFAULT_IDS = { "999", "1000", "1103", "2971", "2921", "3064", "3063", "3066", "3065", "3067" };
  public static final String THEME_ERROR_ID_LIST = "listOfErrorThemeSrc";
  public static final String THEME_ID = "themeId";
  public static final String THEME_ID_DAYMODE = "xxxx";
  public static final String THEME_ID_DAYMODE_SIMPLEUI_BLUE = "3491";
  public static final String THEME_ID_DAYMODE_SIMPLEUI_GRREEN = "3063";
  public static final String THEME_ID_DAYMODE_SIMPLEUI_PURPLE = "3065";
  public static final String THEME_ID_DAYMODE_SIMPLEUI_RED = "3067";
  public static final String THEME_ID_DAYMODE_SIMPLEUI_T_RED = "3066";
  public static final String THEME_ID_DAYMODE_SIMPLEUI_YELLOW = "3064";
  public static final String THEME_ID_DAYMODE_SIMPLE_GRAY = "2921";
  public static final String THEME_ID_DAYMODE_SIMPLE_WHITE = "2971";
  public static final String THEME_ID_GOLDEN = "2101";
  public static final String THEME_ID_NIGHTMODE = "1103";
  public static final String THEME_ID_NIGHTMODE_SIMPLE = "2920";
  public static final String THEME_ID_WHITEMODE = "2105";
  public static final String THEME_ISVOICE = "isVoiceTheme";
  public static final String THEME_KEY_CURRENT_THEME_ID = "currentThemeId_6.3.5";
  public static final String THEME_KEY_CURRENT_THEME_VERSION = "currentThemeVersion";
  public static final String THEME_KEY_USER_DOWNLOAD = "userDownloadTheme";
  public static final String THEME_KEY_USER_SWITCH_TIMES = "user_switch_theme_times";
  public static final String THEME_MSSAGE_VOICE_NAME = "message.mp3";
  static final String THEME_ORIENTATION_HORIZONTAL = "horizontal";
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
  public static String curThemeId;
  public static boolean isNowThemeDefaultCache = true;
  static boolean isThemeIsAnimate;
  public static String lastThemeId;
  static String mAnimateThemeId;
  static String mAnimateThemePath;
  static BroadcastReceiver mReceiver;
  static Object refLock;
  static boolean sIsHorizontalAnimate;
  static WeakReference<QQAppInterface> weakApp;
  
  static
  {
    NIGHTMODE_MASKCOLOR = Color.parseColor("#4d000000");
    NIGHTMODE_COLORFILTER = new PorterDuffColorFilter(NIGHTMODE_MASKCOLOR, PorterDuff.Mode.SRC_ATOP);
    curThemeId = getCurrentThemeId();
    lastThemeId = "";
    refLock = new Object();
    mReceiver = new ThemeUtil.1();
  }
  
  public static void adjustThemeStatusBar(Window paramWindow)
  {
    boolean bool = true;
    if ((isCustomTheme(true)) && (ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor())) {
      if (isColorDark(paramWindow.getDecorView().getResources().getColor(2131167091))) {
        break label47;
      }
    }
    for (;;)
    {
      ImmersiveUtils.setStatusTextColor(bool, paramWindow);
      return;
      label47:
      bool = false;
    }
  }
  
  public static Drawable drawableTint(Context paramContext, int paramInt1, int paramInt2)
  {
    if (!SkinEngine.getInstances().checkResExist(paramInt1)) {
      return ImageUtil.a(paramContext.getResources().getDrawable(paramInt1), paramInt2);
    }
    return paramContext.getResources().getDrawable(paramInt1);
  }
  
  public static String getAIOSkinPath()
  {
    return "/mnt/sdcard/skin/aio/";
  }
  
  public static String getAnimatePathByTag(int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    String str;
    if (android.text.TextUtils.isEmpty(mAnimateThemePath))
    {
      localObject1 = getCurrentThemeInfo();
      str = ((Bundle)localObject1).getString("themePath");
      if (android.text.TextUtils.isEmpty(str))
      {
        localObject1 = ((Bundle)localObject1).getString("themeId");
        QLog.e("Theme.ThemeUtil", 2, "getAnimatePathByTag err ApngImage path = " + null + " id = " + (String)localObject1);
        return localObject2;
      }
      if (str.endsWith(File.separator)) {
        mAnimateThemePath = str;
      }
    }
    else
    {
      label94:
      localObject1 = localObject3;
      switch (paramInt)
      {
      default: 
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Theme.ThemeUtil", 2, "getAnimatePathByTag ApngImage path = " + (String)localObject1);
      return localObject1;
      mAnimateThemePath = str + File.separator;
      break label94;
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
      continue;
      localObject1 = mAnimateThemePath + "raw/qvip_tab_icon_qcircle_animate.png";
    }
  }
  
  public static String getCurrentThemeId()
  {
    String str2 = getCurrentThemeInfo().getString("themeId");
    String str1 = str2;
    if (android.text.TextUtils.isEmpty(str2)) {
      str1 = "1000";
    }
    curThemeId = str1;
    return str1;
  }
  
  public static Bundle getCurrentThemeInfo()
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localBundle.putString("themeId", "1000");
        localBundle.putString("version", "0");
        String str = SkinEngine.getInstances().getSkinRootPath();
        localBundle.putString("themePath", str);
        if ((str != null) && (str.length() > 0))
        {
          Object localObject1 = str;
          if (str.endsWith(File.separator)) {
            localObject1 = str.substring(0, str.length() - 1);
          }
          if (((String)localObject1).contains("theme_810"))
          {
            localObject1 = ((String)localObject1).split(File.separator);
            if (localObject1.length < 3) {
              break label201;
            }
            localObject1 = localObject1[(localObject1.length - 3)];
            if ((!android.text.TextUtils.isEmpty((CharSequence)localObject1)) && (EmosmUtils.a((String)localObject1)))
            {
              localBundle.putString("themeId", (String)localObject1);
              localBundle.putString("version", "20000000");
              return localBundle;
            }
          }
          else
          {
            localObject1 = ((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1);
            if (localObject1 != null)
            {
              localObject1 = ((String)localObject1).split("_");
              if (localObject1.length == 2)
              {
                localBundle.putString("themeId", localObject1[0]);
                localBundle.putString("version", localObject1[1]);
                return localBundle;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("Theme.ThemeUtil", 1, "getCurrentThemeInfo, exception:", localException);
      }
      return localBundle;
      label201:
      Object localObject2 = null;
    }
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
    if (android.text.TextUtils.isEmpty(paramString))
    {
      QLog.e("Theme.ThemeUtil", 1, "getIDFromSCID error null: zipName=" + paramString);
      return null;
    }
    int i = 0;
    Object localObject = paramString.split("\\.");
    if ((paramString.startsWith(ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX)) && (localObject.length > 3)) {
      localObject = localObject[2];
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) || (android.text.TextUtils.isEmpty((CharSequence)localObject))) {
        QLog.d("Theme.ThemeUtil", 1, "getIDFromSCID ok, zipName = " + paramString + ", themeid=" + (String)localObject + ", idType=" + i);
      }
      return localObject;
      if ((paramString.startsWith("theme.")) && (localObject.length > 1))
      {
        localObject = localObject[1];
        i = 2;
      }
      else
      {
        localObject = null;
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
      if (Integer.parseInt(str) >= 5000)
      {
        int i = Integer.parseInt(str);
        if (i < 1000000)
        {
          bool1 = true;
          return bool1;
        }
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
    new StringBuilder().append("theme.").append(paramString).append(".cfg").toString();
    return "theme." + paramString;
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
      curThemeId = paramAppRuntime;
      localObject2 = paramAppRuntime;
    } while (!QLog.isColorLevel());
    long l = localSharedPreferences.getLong("themeSetTimeKey", 0L);
    QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeId,uin=" + (String)localObject1 + ",currentThemeId=" + paramAppRuntime + ", oldTime=" + l);
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
    QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeVersion,uin=" + com.tencent.mobileqq.text.TextUtils.hideUinInShowString((String)localObject1, 2) + ",currentThemeVersion=" + paramAppInterface + ", oldTime=" + l);
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
      if (IndividuationConfigInfo.a("6.0", "8.5.5"))
      {
        localObject2 = (String)((Map)localObject1).get(localObject4);
        localObject1 = localObject2;
        if (!"1000".equals(localObject2))
        {
          localObject1 = localObject2;
          if ((paramAppInterface instanceof QQAppInterface)) {
            ((ThemeHandler)((QQAppInterface)paramAppInterface).getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER)).a((String)localObject2, (String)localObject3, false);
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
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      int i;
      int j;
      try
      {
        localObject2 = localSharedPreferences.getString("themeArray", null);
        if ((!android.text.TextUtils.isEmpty(localSharedPreferences.getString("seriesID", null))) && (!android.text.TextUtils.isEmpty((CharSequence)localObject2)))
        {
          i = localSharedPreferences.getInt("themeLength", 7);
          j = localSharedPreferences.getInt("themeIndex", 0);
          long l = localSharedPreferences.getLong("startTime", -28800L);
          int k = TimeZone.getTimeZone("GMT+8").getRawOffset();
          if (System.currentTimeMillis() <= l) {
            break label428;
          }
          i = ((int)Math.ceil((System.currentTimeMillis() + k) / 86400000L) - (int)Math.ceil((l + k) / 86400000L)) % i;
          if (!QLog.isColorLevel()) {
            break label433;
          }
          QLog.d("Theme.ThemeUtil", 2, "getWeekLoopTheme nIndex:" + j + ", tIndex:" + i);
          break label433;
          label182:
          localObject1 = new JSONArray((String)localObject2);
          if (((JSONArray)localObject1).length() <= 0) {
            break label414;
          }
          if (i < ((JSONArray)localObject1).length()) {
            break label420;
          }
          i = 0;
          localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          if (localObject2 != null)
          {
            localObject1 = ((JSONObject)localObject2).getString("id");
            if (localObject2 == null) {
              continue;
            }
            localObject2 = ((JSONObject)localObject2).getString("version");
            if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
              break label414;
            }
            boolean bool = android.text.TextUtils.isEmpty((CharSequence)localObject2);
            if (bool) {
              break label414;
            }
          }
        }
      }
      catch (Exception paramAppInterface)
      {
        Object localObject2;
        localObject1 = localObject3;
        QLog.e("Theme.ThemeUtil", 1, "getWeekLoopTheme error:" + paramAppInterface.getMessage());
        return localObject1;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "getWeekLoopTheme ok: sThemeId = " + (String)localObject1);
        }
        setCurrentThemeIdVersion(paramAppInterface, (String)localObject1, (String)localObject2);
        paramAppInterface = localSharedPreferences.edit();
        paramAppInterface.putInt("themeIndex", i);
        paramAppInterface.commit();
        paramAppInterface = (AppInterface)localObject1;
        return paramAppInterface;
      }
      catch (Exception paramAppInterface)
      {
        continue;
      }
      localObject1 = null;
      continue;
      localObject2 = null;
      continue;
      paramAppInterface = (AppInterface)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("Theme.ThemeUtil", 2, "getWeekLoopTheme seriesID || themeArray = null");
        return null;
        label414:
        localObject1 = null;
        continue;
        label420:
        continue;
        label428:
        label433:
        do
        {
          i = j;
          break label182;
          i = j;
          break;
        } while (j == i);
      }
    }
  }
  
  @TargetApi(9)
  public static void initTheme(QQAppInterface paramQQAppInterface)
  {
    Object localObject = refLock;
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      try
      {
        if (weakApp == null) {
          break label280;
        }
        paramQQAppInterface = (QQAppInterface)weakApp.get();
        if (paramQQAppInterface == null)
        {
          weakApp = null;
          QLog.e("Theme.ThemeUtil", 1, "initTheme null app");
          return;
        }
        localQQAppInterface = paramQQAppInterface;
        if (paramQQAppInterface.isLogin()) {
          break label89;
        }
        weakApp = null;
        QLog.e("Theme.ThemeUtil", 1, "initTheme logout app");
        return;
      }
      finally {}
      weakApp = new WeakReference(paramQQAppInterface);
      QQAppInterface localQQAppInterface = paramQQAppInterface;
      label89:
      if (!localQQAppInterface.isLogin())
      {
        QLog.e("Theme.ThemeUtil", 1, "initTheme logout appInterface");
        return;
      }
      if (SkinEngine.getInstances().mResources == null)
      {
        QLog.e("Theme.ThemeUtil", 1, "initTheme: engine is not ready");
        return;
      }
      paramQQAppInterface = (ThemeHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.b.compareAndSet(true, false)))
      {
        QLog.e("Theme.ThemeUtil", 1, "initTheme: had send auth");
        return;
      }
      paramQQAppInterface = BaseApplicationImpl.sApplication;
      paramQQAppInterface = getCurrentThemeInfo();
      localObject = paramQQAppInterface.getString("themeId");
      String str = getUserThemeIDForReset(localQQAppInterface);
      QLog.i("Theme.ThemeUtil", 1, "initTheme,userThemeId=" + str + ",engine currentThemeId=" + (String)localObject + ", enginePath=" + paramQQAppInterface.getString("themePath"));
      ThemeSwitcher.a(localQQAppInterface, str, "206", new ThemeUtil.2(localQQAppInterface));
      paramQQAppInterface = (VasMonitorHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_MONITOR_HANDLER);
      if (!paramQQAppInterface.b.get()) {
        paramQQAppInterface.a(localQQAppInterface, true);
      }
      return;
      label280:
      paramQQAppInterface = null;
    }
  }
  
  public static boolean isColorDark(int paramInt)
  {
    return 1.0D - (0.299D * Color.red(paramInt) + 0.587D * Color.green(paramInt) + 0.114D * Color.blue(paramInt)) / 255.0D >= 0.5D;
  }
  
  public static boolean isCustomTheme(boolean paramBoolean)
  {
    String str;
    String[] arrayOfString;
    int j;
    int i;
    if (paramBoolean)
    {
      str = getUserCurrentThemeId(null);
      arrayOfString = THEME_DEFAULT_IDS;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label52;
      }
      if (str.equals(arrayOfString[i]))
      {
        return false;
        str = getCurrentThemeId();
        break;
      }
      i += 1;
    }
    label52:
    return true;
  }
  
  public static boolean isDartStatusBar(Context paramContext)
  {
    if (isNowThemeIsNight(null, false, null)) {}
    float[] arrayOfFloat;
    do
    {
      return false;
      arrayOfFloat = new float[3];
      Color.colorToHSV(paramContext.getResources().getColor(2131166478), arrayOfFloat);
    } while (arrayOfFloat[2] >= 0.5F);
    return true;
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
  
  public static boolean isFixTheme(String paramString)
  {
    return ("1103".equals(paramString)) || (QQTheme.b(paramString));
  }
  
  public static boolean isGoldenTheme()
  {
    return "2101".equals(getUserCurrentThemeId(null));
  }
  
  public static boolean isHorizontalAnimate()
  {
    return sIsHorizontalAnimate;
  }
  
  public static boolean isIOSTheme(String paramString)
  {
    return paramString.startsWith("theme.ios");
  }
  
  @Deprecated
  public static boolean isInNightMode(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = getUserCurrentThemeId(paramAppRuntime);
    return ("1103".equals(paramAppRuntime)) || ("2920".equals(paramAppRuntime));
  }
  
  public static boolean isLastThemeIsNight()
  {
    return ("1103".equals(lastThemeId)) || ("2920".equals(lastThemeId));
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
        sIsHorizontalAnimate = false;
        if ((android.text.TextUtils.isEmpty(str)) || ("1000".equals(str)) || ("999".equals(str)))
        {
          mAnimateThemeId = str;
          bool1 = bool3;
        }
        else
        {
          try
          {
            if ((Integer.parseInt(str) >= 5000) && (Integer.parseInt(str) < 1000000))
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
              break label550;
            }
          }
        }
      }
    }
    finally {}
    Object localObject2;
    label207:
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
        break label550;
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
        localObject3 = new JSONObject((String)localObject3);
        localObject5 = ((JSONObject)localObject3).optString("type");
        sIsHorizontalAnimate = "horizontal".equals(((JSONObject)localObject3).optString("orientation"));
        if (QLog.isColorLevel()) {
          QLog.w("Theme.ThemeUtil", 2, "isNowThemeIsAnimate theme Type:" + (String)localObject5);
        }
        bool1 = "animation".equals(localObject5);
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
      break label207;
      label550:
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
      if (Integer.parseInt(str) >= 5000)
      {
        int i = Integer.parseInt(str);
        if (i < 1000000)
        {
          bool1 = true;
          return bool1;
        }
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
        break label38;
      }
    }
    label38:
    for (str = getUserCurrentThemeId(paramAppRuntime); ("1103".equals(str)) || ("2920".equals(str)); str = getCurrentThemeId()) {
      return true;
    }
    return false;
  }
  
  public static boolean isNowThemeIsNightForQzone()
  {
    return isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  }
  
  public static boolean isNowThemeIsSimple(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (android.text.TextUtils.isEmpty(paramString)) {
      if (!paramBoolean) {
        break label23;
      }
    }
    label23:
    for (str = getUserCurrentThemeId(paramAppRuntime);; str = getCurrentThemeId()) {
      return QQTheme.b(str);
    }
  }
  
  public static boolean isSimpleAndOtherThemeSwitch()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "isSimpleAndOtherThemeSwitch lastThemeId  = " + lastThemeId + ", curThemeId = " + curThemeId);
    }
    return ((QQTheme.b(lastThemeId)) || (QQTheme.b(curThemeId))) && (!curThemeId.equals(lastThemeId));
  }
  
  public static boolean isSimpleColrThemeStateBarUseWhite(String paramString)
  {
    return ("3064".equals(paramString)) || ("2971".equals(paramString)) || ("2921".equals(paramString));
  }
  
  public static boolean isSimpleDayTheme(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = getUserCurrentThemeId(null);; str = getCurrentThemeId()) {
      return QQTheme.c(str);
    }
  }
  
  public static boolean isSkinEngineInitial()
  {
    if (SkinEngine.getInstances().mResources == null) {}
    String str1;
    String str2;
    do
    {
      return false;
      str1 = getUserCurrentThemeId(BaseApplicationImpl.getApplication().getRuntime());
      str2 = getCurrentThemeId();
    } while (((android.text.TextUtils.isEmpty(SkinEngine.getInstances().getSkinRootPath())) || (!str2.equals(str1))) && (!"1000".equals(str1)));
    return true;
  }
  
  public static void previewAIOTheme(Context paramContext, String paramString)
  {
    Object localObject = MusicThemeCallback.sInstance;
    localObject = ((MusicThemeCallback)localObject).getDir(paramContext, ((MusicThemeCallback)localObject).getScid(99999));
    if ((android.text.TextUtils.isEmpty(paramString)) || ("clear".equals(paramString)))
    {
      AIOMusicSkin.a().b("", 0);
      return;
    }
    try
    {
      FileUtils.a(paramString, "/storage/emulated/0/tencent/skin/aioTmp", false);
      paramString = new File("/storage/emulated/0/tencent/skin/aioTmp", "theme.zip");
      if (new File(paramString.getAbsolutePath()).exists()) {
        FileUtils.a(paramString.getAbsolutePath(), "/storage/emulated/0/tencent/skin/aioTmp", false);
      }
      paramString = new File("/storage/emulated/0/tencent/skin/aioTmp", "androidXH.zip");
      if (new File(paramString.getAbsolutePath()).exists())
      {
        if (new File((String)localObject).exists()) {
          FileUtils.a((String)localObject);
        }
        FileUtils.a(paramString.getAbsolutePath(), (String)localObject, false);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("Theme.ThemeUtil", 2, paramString.getMessage());
          QQToast.a(paramContext, paramString.getMessage(), 0).a();
        }
      }
      QQToast.a(paramContext, "AIO主题文件不存在", 0).a();
    }
    if (new File((String)localObject).exists())
    {
      AIOMusicSkin.a().b((String)localObject, 99999);
      QQToast.a(paramContext, "AIO主题切换成功", 0).a();
      return;
    }
  }
  
  public static void previewPlayerSkin(Context paramContext, String paramString)
  {
    MusicPlayerCallback localMusicPlayerCallback = MusicPlayerCallback.sInstance;
    paramContext = localMusicPlayerCallback.getDir(paramContext, localMusicPlayerCallback.getScid(99999));
    if ((android.text.TextUtils.isEmpty(paramString)) || ("clear".equals(paramString)))
    {
      FloatViewSkin.a().a("", 0);
      return;
    }
    try
    {
      FileUtils.a(paramString, paramContext, false);
      FloatViewSkin.a().a(paramContext, 99999);
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static Boolean removeThemeInfo(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null))
    {
      QLog.e("Theme.ThemeUtil", 1, "removeThemeInfo error, themeId:" + paramString + ", context:" + paramContext);
      return Boolean.valueOf(false);
    }
    boolean bool = getThemePreferences(paramContext).edit().remove(paramString).commit();
    if ((!bool) || (QLog.isColorLevel())) {
      QLog.d("Theme.ThemeUtil", 2, "removeThemeInfo sp comit ret=" + bool + ", themeId=" + paramString);
    }
    return Boolean.valueOf(bool);
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
  
  public static void setColorFilterIfNeed(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    if (isNowThemeIsNightForQzone())
    {
      paramImageView.setColorFilter(1291845632);
      return;
    }
    paramImageView.setColorFilter(0);
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
    curThemeId = paramString1;
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
    QLog.d("Theme.ThemeUtil", 1, "setCurrentThemeIdVersion,uin=" + com.tencent.mobileqq.text.TextUtils.hideUinInShowString((String)localObject1, 2) + ",oldUsrThemeId=" + str + ",set new themeId=" + paramString1 + ",set new version=" + paramString2 + ", userSwitchThemeTimes=" + i + ",commitSuss=" + bool1 + ", oldTime=" + l2 + ", commitSussOld:" + bool2);
    try
    {
      paramString2 = new HashMap();
      paramString2.put("param_themeId", paramString1);
      paramString2.put("param_singleSp", String.valueOf(bool1));
      StatisticCollector.getInstance(paramAppRuntime.getApplication().getApplicationContext()).collectPerformance((String)localObject1, "VipSetCurrentThemeIdVersion", bool1, 1L, 0L, paramString2, "", false);
      label475:
      return Boolean.valueOf(bool1);
    }
    catch (Exception paramAppRuntime)
    {
      break label475;
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
  
  public static void setThemeFilter(Drawable paramDrawable, String paramString)
  {
    if (paramDrawable == null) {
      return;
    }
    if ("1103".equals(paramString))
    {
      paramDrawable.setColorFilter(NIGHTMODE_COLORFILTER);
      return;
    }
    paramDrawable.clearColorFilter();
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
    paramAppRuntime = getUinThemePreferences(paramAppRuntime);
    SharedPreferences.Editor localEditor = paramAppRuntime.edit();
    boolean bool1 = true;
    boolean bool2 = true;
    if (android.text.TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!android.text.TextUtils.isEmpty(paramAppRuntime.getString("seriesID", null)))
      {
        localEditor.putString("seriesID", "");
        localEditor.putString("themeArray", "");
        bool1 = localEditor.commit();
      }
    }
    for (;;)
    {
      return bool1;
      bool2 = bool1;
      try
      {
        localEditor.putString("seriesID", paramString1);
        bool2 = bool1;
        localEditor.putString("themeArray", paramString2);
        bool2 = bool1;
        if (!android.text.TextUtils.isEmpty(paramString2))
        {
          bool2 = bool1;
          int j = new JSONArray(paramString2).length();
          if (j <= 0)
          {
            bool2 = bool1;
            QLog.e("Theme.ThemeUtil", 2, "setWeekLoopTheme themeJsonArr Error:0 == length");
            return false;
          }
          int i = 0;
          bool2 = bool1;
          int k = TimeZone.getTimeZone("GMT+8").getRawOffset();
          bool2 = bool1;
          if (System.currentTimeMillis() > paramLong)
          {
            bool2 = bool1;
            i = ((int)Math.ceil((System.currentTimeMillis() + k) / 86400000L) - (int)Math.ceil((k + paramLong) / 86400000L)) % j;
          }
          bool2 = bool1;
          localEditor.putInt("themeLength", j);
          bool2 = bool1;
          localEditor.putInt("themeIndex", i);
          bool2 = bool1;
          localEditor.putLong("startTime", paramLong);
        }
        bool2 = bool1;
        boolean bool3 = localEditor.commit();
        bool1 = bool3;
        bool2 = bool3;
        if (QLog.isColorLevel())
        {
          bool2 = bool3;
          QLog.d("Theme.ThemeUtil", 2, "setWeekLoopTheme , setWeekLoopTheme is ok:" + bool3);
          return bool3;
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("Theme.ThemeUtil", 2, "setWeekLoopTheme json Error:" + paramAppRuntime.getMessage());
      }
    }
    return bool2;
  }
  
  public static void storeLastThemeId(String paramString)
  {
    lastThemeId = paramString;
  }
  
  public static boolean themeFont(Intent paramIntent, String paramString)
  {
    paramIntent = paramIntent.getStringExtra(paramString);
    if (android.text.TextUtils.isEmpty(paramIntent)) {
      return false;
    }
    try
    {
      ThemeFontAdapter.b(Integer.parseInt(paramIntent));
      return true;
    }
    catch (NumberFormatException paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
  }
  
  private static void validLocalBg3D(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new File("/storage/emulated/0/tencent/skin/effect");
      if (((File)localObject).exists()) {
        FileUtils.a(((File)localObject).getAbsolutePath());
      }
      localObject = "/storage/emulated/0/tencent/skin/effect" + "/" + System.currentTimeMillis();
      FileUtils.a(paramString2, (String)localObject, false);
      ChatBackground.a(paramContext, paramString1, null, (String)localObject + "/aioImage");
      paramContext = paramQQAppInterface.getHandler(ChatActivity.class);
      if (paramContext != null) {
        paramContext.sendMessage(paramContext.obtainMessage(60, new BitmapDrawable()));
      }
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void validLocalTheme(Context paramContext, String paramString) {}
  
  public static void validLocalTheme(Context paramContext, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeUtil
 * JD-Core Version:    0.7.0.1
 */
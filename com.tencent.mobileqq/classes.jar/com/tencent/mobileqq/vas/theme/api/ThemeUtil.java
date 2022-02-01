package com.tencent.mobileqq.vas.theme.api;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager;
import com.tencent.mobileqq.vas.util.VasTextUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.util.VersionUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
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
  public static int appRuntimeString;
  public static String curThemeId;
  public static boolean isNowThemeDefaultCache = true;
  static boolean isThemeIsAnimate;
  public static String lastThemeId;
  static String mAnimateThemeId;
  static String mAnimateThemePath;
  static BroadcastReceiver mReceiver;
  static Object refLock;
  static boolean sIsHorizontalAnimate;
  private static IThemeSwitchCallback sThemeSwitchCallback;
  static WeakReference<AppRuntime> weakApp;
  
  static
  {
    NIGHTMODE_MASKCOLOR = Color.parseColor("#4d000000");
    NIGHTMODE_COLORFILTER = new PorterDuffColorFilter(NIGHTMODE_MASKCOLOR, PorterDuff.Mode.SRC_ATOP);
    curThemeId = getCurrentThemeId();
    lastThemeId = "";
    refLock = new Object();
    appRuntimeString = 0;
    mReceiver = new ThemeUtil.1();
    sThemeSwitchCallback = new ThemeUtil.2();
  }
  
  public static Drawable drawableTint(Context paramContext, int paramInt1, int paramInt2)
  {
    if (!SkinEngine.getInstances().checkResExist(paramInt1)) {
      return maskDrawableByColor(paramContext.getResources().getDrawable(paramInt1), paramInt2);
    }
    return paramContext.getResources().getDrawable(paramInt1);
  }
  
  public static String getAnimatePathByTag(int paramInt)
  {
    boolean bool = TextUtils.isEmpty(mAnimateThemePath);
    Object localObject1 = null;
    Object localObject2;
    if (bool)
    {
      Object localObject3 = getCurrentThemeInfo();
      localObject2 = ((Bundle)localObject3).getString("themePath");
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = ((Bundle)localObject3).getString("themeId");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getAnimatePathByTag err ApngImage path = ");
        ((StringBuilder)localObject2).append(null);
        ((StringBuilder)localObject2).append(" id = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.e("Theme.ThemeUtil", 2, ((StringBuilder)localObject2).toString());
        return null;
      }
      if (((String)localObject2).endsWith(File.separator))
      {
        mAnimateThemePath = (String)localObject2;
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(File.separator);
        mAnimateThemePath = ((StringBuilder)localObject3).toString();
      }
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          switch (paramInt)
          {
          default: 
            break;
          case 17: 
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(mAnimateThemePath);
            ((StringBuilder)localObject1).append("raw/qvip_tab_icon_qcircle_animate.png");
            localObject1 = ((StringBuilder)localObject1).toString();
            break;
          case 16: 
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(mAnimateThemePath);
            ((StringBuilder)localObject1).append("raw/qvip_tab_icon_see_animate.png");
            localObject1 = ((StringBuilder)localObject1).toString();
            break;
          case 15: 
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(mAnimateThemePath);
            ((StringBuilder)localObject1).append("raw/qvip_tab_icon_now_animate.png");
            localObject1 = ((StringBuilder)localObject1).toString();
            break;
          case 14: 
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(mAnimateThemePath);
            ((StringBuilder)localObject1).append("raw/qvip_tab_icon_plugin_animate.png");
            localObject1 = ((StringBuilder)localObject1).toString();
            break;
          case 13: 
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(mAnimateThemePath);
            ((StringBuilder)localObject1).append("raw/qvip_tab_icon_call_animate.png");
            localObject1 = ((StringBuilder)localObject1).toString();
            break;
          case 12: 
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(mAnimateThemePath);
            ((StringBuilder)localObject1).append("raw/qvip_tab_icon_contact_animate.png");
            localObject1 = ((StringBuilder)localObject1).toString();
            break;
          case 11: 
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(mAnimateThemePath);
            ((StringBuilder)localObject1).append("raw/qvip_tab_icon_conversation_animate.png");
            localObject1 = ((StringBuilder)localObject1).toString();
            break;
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(mAnimateThemePath);
          ((StringBuilder)localObject1).append("raw/qvip_chatbackground_animate.png");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(mAnimateThemePath);
        ((StringBuilder)localObject1).append("raw/qvip_conversation_bg_animate.png");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(mAnimateThemePath);
      ((StringBuilder)localObject1).append("raw/qvip_drawer_bg_animate.png");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAnimatePathByTag ApngImage path = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("Theme.ThemeUtil", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public static AppRuntime getCreateAppRuntime()
  {
    Object localObject = weakApp;
    if (localObject != null)
    {
      localObject = (AppRuntime)((WeakReference)localObject).get();
      if (localObject != null) {
        return localObject;
      }
    }
    return VasUtil.a();
  }
  
  public static String getCurrentThemeId()
  {
    String str2 = getCurrentThemeInfo().getString("themeId");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
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
              break label204;
            }
            localObject1 = localObject1[(localObject1.length - 3)];
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (VasTextUtil.a((String)localObject1)))
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
      label204:
      Object localObject2 = null;
    }
  }
  
  public static int getErrorThemeId(Context paramContext, String paramString)
  {
    paramContext = getThemePreferences(paramContext).getString("listOfErrorThemeSrc", "");
    int i = 0;
    if ((paramContext != null) && (paramContext.length() > 0)) {
      try
      {
        paramContext = new JSONObject(paramContext);
        if (paramContext.has(paramString)) {
          i = paramContext.getInt(paramString);
        }
        return i;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("getErrorThemeId error:");
          paramString.append(paramContext.getMessage());
          QLog.d("Theme.ThemeUtil", 2, paramString.toString());
        }
      }
    }
    return 0;
  }
  
  public static int getFileNumInFile(File paramFile)
  {
    if (paramFile != null)
    {
      int j;
      try
      {
        if (!paramFile.exists()) {
          return 0;
        }
        if (!paramFile.isDirectory()) {
          return 1;
        }
        paramFile = paramFile.listFiles();
        if (paramFile != null)
        {
          if (paramFile.length <= 0) {
            return 0;
          }
          i = paramFile.length;
          int k = i - 1;
          i = 0;
          for (;;)
          {
            j = i;
            if (k < 0) {
              break label225;
            }
            if (paramFile[k] != null) {}
            try
            {
              if (paramFile[k].isDirectory())
              {
                localObject = paramFile[k].list();
                if (localObject != null) {
                  j = localObject.length;
                } else {
                  j = 0;
                }
                i += j;
              }
              else
              {
                i += 1;
              }
              k -= 1;
            }
            catch (OutOfMemoryError paramFile)
            {
              break label124;
            }
            catch (Exception paramFile)
            {
              break label176;
            }
          }
        }
        return 0;
      }
      catch (OutOfMemoryError paramFile)
      {
        i = 0;
        j = i;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ThemeJsHandler getFileNumInFile, OOM:");
          ((StringBuilder)localObject).append(paramFile.getMessage());
          QLog.e("Theme.ThemeUtil", 2, ((StringBuilder)localObject).toString());
          return i;
        }
      }
      catch (Exception paramFile)
      {
        Object localObject;
        label124:
        int i = 0;
        label176:
        j = i;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ThemeJsHandler getFileNumInFile, error:");
          ((StringBuilder)localObject).append(paramFile.getMessage());
          QLog.e("Theme.ThemeUtil", 2, ((StringBuilder)localObject).toString());
          j = i;
        }
      }
      label225:
      return j;
    }
    return 0;
  }
  
  public static String getIDFromSCID(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    StringBuilder localStringBuilder2 = null;
    StringBuilder localStringBuilder1;
    if (bool)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getIDFromSCID error null: zipName=");
      localStringBuilder1.append(paramString);
      QLog.e("Theme.ThemeUtil", 1, localStringBuilder1.toString());
      return null;
    }
    int j = 0;
    String[] arrayOfString = paramString.split("\\.");
    int i;
    if ((paramString.startsWith("theme.")) && (arrayOfString.length > 3))
    {
      localStringBuilder1 = arrayOfString[2];
      i = j;
    }
    else
    {
      i = j;
      localStringBuilder1 = localStringBuilder2;
      if (paramString.startsWith("theme."))
      {
        i = j;
        localStringBuilder1 = localStringBuilder2;
        if (arrayOfString.length > 1)
        {
          localStringBuilder1 = arrayOfString[1];
          i = 2;
        }
      }
    }
    if ((QLog.isColorLevel()) || (TextUtils.isEmpty(localStringBuilder1)))
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("getIDFromSCID ok, zipName = ");
      localStringBuilder2.append(paramString);
      localStringBuilder2.append(", themeid=");
      localStringBuilder2.append(localStringBuilder1);
      localStringBuilder2.append(", idType=");
      localStringBuilder2.append(i);
      QLog.d("Theme.ThemeUtil", 1, localStringBuilder2.toString());
    }
    return localStringBuilder1;
  }
  
  public static boolean getIsDIYTheme(String paramString)
  {
    Object localObject = paramString;
    if (paramString == null) {
      localObject = getCurrentThemeId();
    }
    boolean bool = "999".equals(localObject);
    if ((!bool) && (localObject != null)) {
      try
      {
        if (Integer.parseInt((String)localObject) >= 5000)
        {
          int i = Integer.parseInt((String)localObject);
          if (i < 1000000) {
            return true;
          }
        }
        return false;
      }
      catch (Exception paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getIsDIYTheme err");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.d("Theme.ThemeUtil", 2, ((StringBuilder)localObject).toString());
      }
    }
    return bool;
  }
  
  public static String getThemeConfigID(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("theme.");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String getThemeDensity(Context paramContext)
  {
    String str = "xh";
    if (paramContext == null) {
      return "xh";
    }
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    if (localDisplayMetrics.densityDpi <= 160) {
      return "m";
    }
    paramContext = str;
    if (localDisplayMetrics.densityDpi > 160)
    {
      paramContext = str;
      if (localDisplayMetrics.densityDpi < 320) {
        paramContext = "h";
      }
    }
    return paramContext;
  }
  
  public static int getThemeDownloadNum(Context paramContext)
  {
    paramContext = getThemePreferences(paramContext).getString("userDownloadTheme", "");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getThemeDownloadNum, userThemeStr = ");
      ((StringBuilder)localObject).append(paramContext);
      QLog.i("Theme.ThemeUtil", 2, ((StringBuilder)localObject).toString());
    }
    int m = 0;
    int n = 0;
    int i = 0;
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
          localObject = paramContext.keys();
          for (;;)
          {
            j = i;
            k = i;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            j = i;
            String str = paramContext.getJSONObject(String.valueOf(((Iterator)localObject).next())).getString("status");
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
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getThemeDownloadNum error:");
          ((StringBuilder)localObject).append(paramContext.getMessage());
          QLog.d("Theme.ThemeUtil", 2, ((StringBuilder)localObject).toString());
          k = j;
        }
      }
    }
  }
  
  public static ThemeUtil.ThemeInfo getThemeInfo(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramContext = getThemePreferences(paramContext).getString(paramString, "");
      if (TextUtils.isEmpty(paramContext))
      {
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("getThemeInfoFromSp null, themeId:");
          paramContext.append(paramString);
          QLog.d("Theme.ThemeUtil", 2, paramContext.toString());
        }
        return null;
      }
      String[] arrayOfString = paramContext.split(",");
      if (arrayOfString.length < 5)
      {
        paramString = new StringBuilder();
        paramString.append("getThemeInfoFromSp error length: userThemeStr=");
        paramString.append(paramContext);
        QLog.e("Theme.ThemeUtil", 1, paramString.toString());
        return null;
      }
      localObject = new ThemeUtil.ThemeInfo();
      try
      {
        ((ThemeUtil.ThemeInfo)localObject).themeId = paramString;
        if (!TextUtils.isEmpty(arrayOfString[0])) {
          ((ThemeUtil.ThemeInfo)localObject).zipVer = Integer.parseInt(arrayOfString[0]);
        }
        if (!TextUtils.isEmpty(arrayOfString[1])) {
          ((ThemeUtil.ThemeInfo)localObject).version = arrayOfString[1];
        }
        if (!TextUtils.isEmpty(arrayOfString[2])) {
          ((ThemeUtil.ThemeInfo)localObject).fileNum = Integer.parseInt(arrayOfString[2]);
        }
        ((ThemeUtil.ThemeInfo)localObject).isVoiceTheme = "1".equals(arrayOfString[3]);
        if (!TextUtils.isEmpty(arrayOfString[4])) {
          ((ThemeUtil.ThemeInfo)localObject).size = Long.parseLong(arrayOfString[4]);
        }
        if (!TextUtils.isEmpty(arrayOfString[5])) {
          ((ThemeUtil.ThemeInfo)localObject).downsize = Long.parseLong(arrayOfString[5]);
        }
        if (!TextUtils.isEmpty(arrayOfString[6])) {
          ((ThemeUtil.ThemeInfo)localObject).status = arrayOfString[6];
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getThemeInfoFromSp error: userThemeStr=");
        localStringBuilder2.append(paramContext);
        localStringBuilder2.append(", msg:");
        localStringBuilder2.append(localException.getMessage());
        QLog.e("Theme.ThemeUtil", 1, localStringBuilder2.toString());
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("getThemeInfoFromSp end, themeId:");
        localStringBuilder1.append(paramString);
        localStringBuilder1.append(", userThemeStr=");
        localStringBuilder1.append(paramContext);
        QLog.d("Theme.ThemeUtil", 2, localStringBuilder1.toString());
      }
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getThemeInfoFromSp error, themeId:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", context:");
    ((StringBuilder)localObject).append(paramContext);
    QLog.e("Theme.ThemeUtil", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  public static SharedPreferences getThemePreferences(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null)
    {
      paramContext = getCreateAppRuntime().getApplicationContext();
      localContext = paramContext;
      if (QLog.isColorLevel())
      {
        QLog.d("Theme.ThemeUtil", 2, "getThemePreferences null == context");
        localContext = paramContext;
      }
    }
    return localContext.getSharedPreferences("userThemeSharedPreferences", 4);
  }
  
  public static int getThemeSwitchTimes(AppRuntime paramAppRuntime)
  {
    int j = getUinThemePreferences(paramAppRuntime).getInt("user_switch_theme_times", -1);
    int i = j;
    if (-1 == j) {
      i = paramAppRuntime.getPreferences().getInt("user_switch_theme_times", 0);
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("getThemeSwitchTimes userSwitchThemeTimes=");
      paramAppRuntime.append(i);
      QLog.d("Theme.ThemeUtil", 2, paramAppRuntime.toString());
    }
    return i;
  }
  
  public static String getThemeVoiceRootPath()
  {
    Object localObject = SkinEngine.getInstances().getSkinRootPath();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(File.separatorChar);
      localStringBuilder.append("voice");
      localObject = new File(localStringBuilder.toString());
      if (((File)localObject).exists()) {
        return ((File)localObject).getAbsolutePath();
      }
    }
    return null;
  }
  
  public static SharedPreferences getUinThemePreferences(AppRuntime paramAppRuntime)
  {
    Object localObject1 = paramAppRuntime;
    if (paramAppRuntime == null)
    {
      paramAppRuntime = getCreateAppRuntime();
      localObject1 = paramAppRuntime;
      if (QLog.isColorLevel())
      {
        QLog.d("Theme.ThemeUtil", 2, "getUinThemePreferences null == application");
        localObject1 = paramAppRuntime;
      }
    }
    Object localObject2 = ((AppRuntime)localObject1).getAccount();
    paramAppRuntime = (AppRuntime)localObject2;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeUtil", 2, "getUinThemePreferences,uin=noLogin");
      }
      paramAppRuntime = "noLogin";
    }
    localObject1 = ((AppRuntime)localObject1).getApplication();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramAppRuntime);
    ((StringBuilder)localObject2).append("_theme");
    return ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
  }
  
  public static String getUserCurrentThemeId(AppRuntime paramAppRuntime)
  {
    Object localObject2 = "1000";
    Object localObject1 = paramAppRuntime;
    if (paramAppRuntime == null)
    {
      paramAppRuntime = getCreateAppRuntime();
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeId,application == null");
      }
      localObject1 = paramAppRuntime;
      if (paramAppRuntime == null)
      {
        QLog.e("Theme.ThemeUtil", 1, "getUserCurrentThemeId Error,application == null");
        return "1000";
      }
    }
    SharedPreferences localSharedPreferences = getUinThemePreferences((AppRuntime)localObject1);
    String str = localSharedPreferences.getString("currentThemeId_6.3.5", null);
    localObject1 = ((AppRuntime)localObject1).getAccount();
    paramAppRuntime = (AppRuntime)localObject1;
    if (localObject1 == null)
    {
      QLog.e("Theme.ThemeUtil", 1, "getUserCurrentThemeId Error, uin=noLogin");
      paramAppRuntime = "noLogin";
    }
    if (TextUtils.isEmpty(str))
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeVersion,null == currentThemeId, currentThemeId= ThemeUtil.DEFAULT_THEME_ID");
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = str;
    }
    curThemeId = (String)localObject1;
    if (QLog.isColorLevel())
    {
      long l = localSharedPreferences.getLong("themeSetTimeKey", 0L);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getUserCurrentThemeId,uin=");
      ((StringBuilder)localObject2).append(paramAppRuntime);
      ((StringBuilder)localObject2).append(",currentThemeId=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", oldTime=");
      ((StringBuilder)localObject2).append(l);
      QLog.d("Theme.ThemeUtil", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public static String getUserCurrentThemeVersion(AppRuntime paramAppRuntime)
  {
    Object localObject2 = "0";
    Object localObject1 = paramAppRuntime;
    if (paramAppRuntime == null)
    {
      paramAppRuntime = getCreateAppRuntime();
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeVersion,application == null");
      }
      localObject1 = paramAppRuntime;
      if (paramAppRuntime == null)
      {
        QLog.e("Theme.ThemeUtil", 1, "getUserCurrentThemeVersion Error,application == null");
        return "0";
      }
    }
    SharedPreferences localSharedPreferences = getUinThemePreferences((AppRuntime)localObject1);
    localObject1 = ((AppRuntime)localObject1).getAccount();
    paramAppRuntime = (AppRuntime)localObject1;
    if (localObject1 == null)
    {
      QLog.e("Theme.ThemeUtil", 1, "getUserCurrentThemeVersion Error, uin=noLogin");
      paramAppRuntime = "noLogin";
    }
    localObject1 = localSharedPreferences.getString("currentThemeVersion", null);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getUserCurrentThemeVersion,currentThemeVersion == null, currentThemeVersion=");
        ((StringBuilder)localObject1).append("0");
        QLog.d("Theme.ThemeUtil", 2, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    if (QLog.isColorLevel())
    {
      long l = localSharedPreferences.getLong("themeSetTimeKey", 0L);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getUserCurrentThemeVersion,uin=");
      ((StringBuilder)localObject2).append(VasTextUtil.a(paramAppRuntime, 2));
      ((StringBuilder)localObject2).append(",currentThemeVersion=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", oldTime=");
      ((StringBuilder)localObject2).append(l);
      QLog.d("Theme.ThemeUtil", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  private static String getUserThemeIDForReset(AppRuntime paramAppRuntime)
  {
    Object localObject3 = getUinThemePreferences(paramAppRuntime);
    if (((SharedPreferences)localObject3).contains("currentThemeId_6.3.5"))
    {
      localObject1 = ((SharedPreferences)localObject3).getString("currentThemeId_6.3.5", "1000");
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("initTheme current qq already set theme:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("Theme.ThemeUtil", 2, ((StringBuilder)localObject2).toString());
      }
      if ("1103".equals(localObject1)) {
        paramAppRuntime = null;
      } else {
        paramAppRuntime = getWeekLoopTheme(paramAppRuntime);
      }
      if (!TextUtils.isEmpty(paramAppRuntime))
      {
        localObject1 = paramAppRuntime;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("initTheme current qq already set weekThemeId:");
          ((StringBuilder)localObject1).append(paramAppRuntime);
          QLog.d("Theme.ThemeUtil", 2, ((StringBuilder)localObject1).toString());
          return paramAppRuntime;
        }
      }
      return localObject1;
    }
    QLog.d("Theme.ThemeUtil", 1, "getUserThemeIDForReset sp.THEME_KEY_CURRENT_THEME_ID == null");
    Object localObject4 = new ArrayList();
    Object localObject2 = ((SharedPreferences)localObject3).getAll();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new HashMap();
    }
    localObject2 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Map.Entry)((Iterator)localObject2).next()).getKey();
      if (str.startsWith("currentThemeId_")) {
        ((List)localObject4).add(str);
      }
    }
    if (((List)localObject4).isEmpty())
    {
      QLog.d("Theme.ThemeUtil", 1, "initTheme list.isEmpty()");
      setCurrentThemeIdVersion(paramAppRuntime, "1000", "0");
      return "1000";
    }
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeUtil", 2, "set previous theme!");
    }
    Collections.sort((List)localObject4);
    localObject4 = (String)((List)localObject4).get(((List)localObject4).size() - 1);
    localObject3 = ((SharedPreferences)localObject3).getString("currentThemeVersion", "0");
    if (VersionUtil.a("6.0", "8.7.0"))
    {
      localObject2 = (String)((Map)localObject1).get(localObject4);
      localObject1 = localObject2;
      if (!"1000".equals(localObject2))
      {
        localObject1 = localObject2;
        if ((paramAppRuntime instanceof AppRuntime))
        {
          ((IThemeHandler)QRoute.api(IThemeHandler.class)).sendThemeVersionCheck((String)localObject2, (String)localObject4, false);
          localObject1 = localObject2;
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeUtil", 2, "old version or app == null.");
      }
      localObject1 = "1000";
    }
    setCurrentThemeIdVersion(paramAppRuntime, (String)localObject1, (String)localObject3);
    return localObject1;
  }
  
  public static String getWeekLoopTheme(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = getUinThemePreferences(paramAppRuntime);
    for (;;)
    {
      Object localObject1;
      int j;
      Object localObject2;
      try
      {
        localObject1 = localSharedPreferences.getString("themeArray", null);
        if ((!TextUtils.isEmpty(localSharedPreferences.getString("seriesID", null))) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          i = localSharedPreferences.getInt("themeLength", 7);
          j = localSharedPreferences.getInt("themeIndex", 0);
          long l1 = localSharedPreferences.getLong("startTime", -28800L);
          int k = TimeZone.getTimeZone("GMT+8").getRawOffset();
          if (System.currentTimeMillis() > l1)
          {
            long l2 = System.currentTimeMillis();
            long l3 = k;
            i = ((int)Math.ceil((l2 + l3) / 86400000L) - (int)Math.ceil((l1 + l3) / 86400000L)) % i;
            if (!QLog.isColorLevel()) {
              break label456;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getWeekLoopTheme nIndex:");
            ((StringBuilder)localObject2).append(j);
            ((StringBuilder)localObject2).append(", tIndex:");
            ((StringBuilder)localObject2).append(i);
            QLog.d("Theme.ThemeUtil", 2, ((StringBuilder)localObject2).toString());
            break label456;
            localObject1 = new JSONArray((String)localObject1);
            if (((JSONArray)localObject1).length() > 0)
            {
              j = i;
              if (i >= ((JSONArray)localObject1).length()) {
                j = 0;
              }
              localObject2 = ((JSONArray)localObject1).getJSONObject(j);
              if (localObject2 == null) {
                break label469;
              }
              localObject1 = ((JSONObject)localObject2).getString("id");
              if (localObject2 == null) {
                break label475;
              }
              localObject2 = ((JSONObject)localObject2).getString("version");
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
                if (!bool) {
                  try
                  {
                    if (QLog.isColorLevel())
                    {
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append("getWeekLoopTheme ok: sThemeId = ");
                      localStringBuilder.append((String)localObject1);
                      QLog.d("Theme.ThemeUtil", 2, localStringBuilder.toString());
                    }
                    setCurrentThemeIdVersion(paramAppRuntime, (String)localObject1, (String)localObject2);
                    paramAppRuntime = localSharedPreferences.edit();
                    paramAppRuntime.putInt("themeIndex", j);
                    paramAppRuntime.commit();
                  }
                  catch (Exception paramAppRuntime)
                  {
                    continue;
                  }
                }
              }
            }
            localObject1 = null;
            return localObject1;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Theme.ThemeUtil", 2, "getWeekLoopTheme seriesID || themeArray = null");
          }
          return null;
        }
      }
      catch (Exception paramAppRuntime)
      {
        localObject1 = null;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getWeekLoopTheme error:");
        ((StringBuilder)localObject2).append(paramAppRuntime.getMessage());
        QLog.e("Theme.ThemeUtil", 1, ((StringBuilder)localObject2).toString());
        return localObject1;
      }
      int i = j;
      continue;
      label456:
      if (j == i)
      {
        i = j;
        continue;
        label469:
        localObject1 = null;
        continue;
        label475:
        localObject2 = null;
      }
    }
  }
  
  @TargetApi(9)
  public static void initTheme(AppRuntime paramAppRuntime)
  {
    Object localObject2 = refLock;
    if (paramAppRuntime == null) {}
    for (;;)
    {
      try
      {
        if (weakApp != null)
        {
          paramAppRuntime = (AppRuntime)weakApp.get();
          if (paramAppRuntime == null)
          {
            weakApp = null;
            QLog.e("Theme.ThemeUtil", 1, "initTheme null app");
            return;
          }
          Object localObject1 = paramAppRuntime;
          if (!paramAppRuntime.isLogin())
          {
            weakApp = null;
            QLog.e("Theme.ThemeUtil", 1, "initTheme logout app");
            return;
            weakApp = new WeakReference(paramAppRuntime);
            localObject1 = paramAppRuntime;
          }
          if (!((AppRuntime)localObject1).isLogin())
          {
            QLog.e("Theme.ThemeUtil", 1, "initTheme logout appInterface");
            return;
          }
          if (SkinEngine.getInstances().mResources == null)
          {
            QLog.e("Theme.ThemeUtil", 1, "initTheme: engine is not ready");
            return;
          }
          if ((getCreateAppRuntime() != null) && (appRuntimeString != getCreateAppRuntime().hashCode()))
          {
            appRuntimeString = getCreateAppRuntime().hashCode();
            getCreateAppRuntime().getApplicationContext();
            paramAppRuntime = getCurrentThemeInfo();
            localObject2 = paramAppRuntime.getString("themeId");
            localObject1 = getUserThemeIDForReset((AppRuntime)localObject1);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("initTheme,userThemeId=");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(",engine currentThemeId=");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(", enginePath=");
            localStringBuilder.append(paramAppRuntime.getString("themePath"));
            QLog.i("Theme.ThemeUtil", 1, localStringBuilder.toString());
            ((IThemeSwitcher)QRoute.api(IThemeSwitcher.class)).startSwitch((String)localObject1, "206", sThemeSwitchCallback);
            return;
          }
          QLog.e("Theme.ThemeUtil", 1, "initTheme: had send auth");
          return;
        }
      }
      finally {}
      paramAppRuntime = null;
    }
  }
  
  public static boolean isDartStatusBar(Context paramContext, int paramInt)
  {
    boolean bool = false;
    if (isNowThemeIsNight(null, false, null)) {
      return false;
    }
    float[] arrayOfFloat = new float[3];
    Color.colorToHSV(paramContext.getResources().getColor(paramInt), arrayOfFloat);
    if (arrayOfFloat[2] < 0.5F) {
      bool = true;
    }
    return bool;
  }
  
  @Deprecated
  public static boolean isDefaultOrDIYTheme()
  {
    String str = getUserCurrentThemeId(null);
    return ("1000".equals(str)) || ("999".equals(str));
  }
  
  public static boolean isDefaultOrDIYTheme(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = getUserCurrentThemeId(null);
    } else {
      str = getCurrentThemeId();
    }
    return ("1000".equals(str)) || ("999".equals(str));
  }
  
  public static boolean isDefaultTheme()
  {
    return "1000".equals(getUserCurrentThemeId(null));
  }
  
  public static boolean isFixTheme(String paramString)
  {
    return ("1103".equals(paramString)) || (QQTheme.c(paramString));
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
  
  public static boolean isNeedUpdataById(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString) ^ true;
    boolean bool1 = bool2;
    if (bool2) {
      if ((!"1000".equals(paramString)) && (!"999".equals(paramString))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    if ((!bool1) || (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNeedUpdataById error null: themeId=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", isUpdate=");
      localStringBuilder.append(bool1);
      QLog.d("Theme.ThemeUtil", 1, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public static boolean isNowThemeIsAnimate()
  {
    for (;;)
    {
      Object localObject5;
      try
      {
        Object localObject1 = getCurrentThemeInfo();
        String str = ((Bundle)localObject1).getString("themeId");
        if (str.equals(mAnimateThemeId))
        {
          bool1 = isThemeIsAnimate;
          return bool1;
        }
        Object localObject4 = null;
        mAnimateThemePath = null;
        boolean bool2 = false;
        isThemeIsAnimate = false;
        sIsHorizontalAnimate = false;
        if ((!TextUtils.isEmpty(str)) && (!"1000".equals(str)))
        {
          bool1 = "999".equals(str);
          if (!bool1)
          {
            StringBuilder localStringBuilder;
            try
            {
              if ((Integer.parseInt(str) >= 5000) && (Integer.parseInt(str) < 1000000))
              {
                mAnimateThemeId = str;
                return false;
              }
            }
            catch (Exception localException)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("isNowThemeIsAnimate err");
              localStringBuilder.append(localException.getMessage());
              QLog.d("Theme.ThemeUtil", 2, localStringBuilder.toString());
              localObject1 = ((Bundle)localObject1).getString("themePath");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label632;
              }
            }
            if (((String)localObject1).endsWith(File.separator))
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append((String)localObject1);
              ((StringBuilder)localObject4).append("config.json");
              localObject4 = ((StringBuilder)localObject4).toString();
            }
            else
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append((String)localObject1);
              ((StringBuilder)localObject4).append(File.separator);
              localObject4 = ((StringBuilder)localObject4).toString();
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append((String)localObject1);
              ((StringBuilder)localObject6).append(File.separator);
              ((StringBuilder)localObject6).append("config.json");
              localObject6 = ((StringBuilder)localObject6).toString();
              localObject1 = localObject4;
              localObject4 = localObject6;
            }
            Object localObject6 = new File((String)localObject4);
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("isNowThemeIsAnimate ApngImage path = ");
              localStringBuilder.append((String)localObject4);
              localStringBuilder.append(", exists:");
              localStringBuilder.append(((File)localObject6).exists());
              QLog.d("Theme.ThemeUtil", 2, localStringBuilder.toString());
            }
            bool1 = ((File)localObject6).exists();
            localObject4 = localObject1;
            if (!bool1) {
              break label632;
            }
            try
            {
              localObject4 = FileUtils.readFileToStringEx((File)localObject6, -1);
              if ((localObject4 != null) && (((String)localObject4).length() >= 2))
              {
                localObject6 = new JSONObject((String)localObject4);
                localObject4 = ((JSONObject)localObject6).optString("type");
                sIsHorizontalAnimate = "horizontal".equals(((JSONObject)localObject6).optString("orientation"));
                if (QLog.isColorLevel())
                {
                  localObject6 = new StringBuilder();
                  ((StringBuilder)localObject6).append("isNowThemeIsAnimate theme Type:");
                  ((StringBuilder)localObject6).append((String)localObject4);
                  QLog.w("Theme.ThemeUtil", 2, ((StringBuilder)localObject6).toString());
                }
                bool1 = "animation".equals(localObject4);
              }
              else
              {
                return false;
              }
            }
            catch (Throwable localThrowable)
            {
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append("isNowThemeIsAnimate err , msg:");
              ((StringBuilder)localObject6).append(localThrowable.getMessage());
              QLog.e("Theme.ThemeUtil", 1, ((StringBuilder)localObject6).toString());
              localObject5 = localObject1;
            }
            if (bool1)
            {
              isThemeIsAnimate = true;
              mAnimateThemePath = (String)localObject1;
            }
            if (isThemeIsAnimate)
            {
              localObject1 = new Bundle();
              if (VasUtil.a().getThemeSwitchManager().getIsEnableAnimate((Bundle)localObject1))
              {
                bool1 = bool2;
                if (((Bundle)localObject1).getBoolean("dynamic_switch", true))
                {
                  bool1 = bool2;
                  if (((Bundle)localObject1).getBoolean("dynamic_enable", true)) {
                    bool1 = true;
                  }
                }
                isThemeIsAnimate = bool1;
              }
            }
            mAnimateThemeId = str;
            bool1 = isThemeIsAnimate;
            return bool1;
          }
        }
        mAnimateThemeId = str;
        return false;
      }
      finally {}
      label632:
      boolean bool1 = false;
      Object localObject3 = localObject5;
    }
  }
  
  public static boolean isNowThemeIsDIY()
  {
    String str = getCurrentThemeId();
    boolean bool = "999".equals(str);
    if ((!bool) && (str != null)) {
      try
      {
        if (Integer.parseInt(str) >= 5000)
        {
          int i = Integer.parseInt(str);
          if (i < 1000000) {
            return true;
          }
        }
        return false;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getIsDIYTheme err");
        localStringBuilder.append(localException.getMessage());
        QLog.d("Theme.ThemeUtil", 2, localStringBuilder.toString());
      }
    }
    return bool;
  }
  
  public static boolean isNowThemeIsDefault(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      if (paramBoolean) {
        str = getUserCurrentThemeId(paramAppRuntime);
      } else {
        str = getCurrentThemeId();
      }
    }
    return "1000".equals(str);
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
    if (TextUtils.isEmpty(paramString)) {
      if (paramBoolean) {
        str = getUserCurrentThemeId(paramAppRuntime);
      } else {
        str = getCurrentThemeId();
      }
    }
    return ("1103".equals(str)) || ("2920".equals(str));
  }
  
  public static boolean isNowThemeIsSimple(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      if (paramBoolean) {
        str = getUserCurrentThemeId(paramAppRuntime);
      } else {
        str = getCurrentThemeId();
      }
    }
    return ((ISimpleUIUtil)QRoute.api(ISimpleUIUtil.class)).isThemeSimpleUI(str);
  }
  
  public static boolean isSimpleAndOtherThemeSwitch()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSimpleAndOtherThemeSwitch lastThemeId  = ");
      localStringBuilder.append(lastThemeId);
      localStringBuilder.append(", curThemeId = ");
      localStringBuilder.append(curThemeId);
      QLog.d("Theme.ThemeUtil", 2, localStringBuilder.toString());
    }
    return ((((ISimpleUIUtil)QRoute.api(ISimpleUIUtil.class)).isThemeSimpleUI(lastThemeId)) || (((ISimpleUIUtil)QRoute.api(ISimpleUIUtil.class)).isThemeSimpleUI(curThemeId))) && (!curThemeId.equals(lastThemeId));
  }
  
  public static boolean isSimpleDayTheme(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = getUserCurrentThemeId(null);
    } else {
      str = getCurrentThemeId();
    }
    return ((ISimpleUIUtil)QRoute.api(ISimpleUIUtil.class)).isThemeSimpleDayUI(str);
  }
  
  public static boolean isSkinEngineInitial()
  {
    Object localObject = SkinEngine.getInstances().mResources;
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    localObject = getUserCurrentThemeId(getCreateAppRuntime());
    String str = getCurrentThemeId();
    if (((!TextUtils.isEmpty(SkinEngine.getInstances().getSkinRootPath())) && (str.equals(localObject))) || ("1000".equals(localObject))) {
      bool = true;
    }
    return bool;
  }
  
  public static Drawable maskDrawableByColor(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof SkinnableBitmapDrawable)) {
      paramDrawable = ((SkinnableBitmapDrawable)paramDrawable).mutate2();
    } else {
      paramDrawable = paramDrawable.getConstantState().newDrawable().mutate();
    }
    paramDrawable.setColorFilter(new LightingColorFilter(0, paramInt));
    return paramDrawable;
  }
  
  public static void previewAIOTheme(Context paramContext, String paramString) {}
  
  public static void previewPlayerSkin(Context paramContext, String paramString) {}
  
  public static Boolean removeThemeInfo(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null))
    {
      boolean bool = getThemePreferences(paramContext).edit().remove(paramString).commit();
      if ((!bool) || (QLog.isColorLevel()))
      {
        paramContext = new StringBuilder();
        paramContext.append("removeThemeInfo sp comit ret=");
        paramContext.append(bool);
        paramContext.append(", themeId=");
        paramContext.append(paramString);
        QLog.d("Theme.ThemeUtil", 2, paramContext.toString());
      }
      return Boolean.valueOf(bool);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeThemeInfo error, themeId:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", context:");
    localStringBuilder.append(paramContext);
    QLog.e("Theme.ThemeUtil", 1, localStringBuilder.toString());
    return Boolean.valueOf(false);
  }
  
  public static void resetThemeSwitchTimes(AppRuntime paramAppRuntime)
  {
    getUinThemePreferences(paramAppRuntime).edit().putInt("user_switch_theme_times", 0).commit();
    paramAppRuntime = paramAppRuntime.getPreferences().edit();
    paramAppRuntime.putInt("user_switch_theme_times", 0);
    paramAppRuntime.commit();
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeUtil", 2, "resetThemeSwitchTimes");
    }
  }
  
  public static void setColorFilterIfNeed(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    if (QQTheme.d())
    {
      paramImageView.setColorFilter(1291845632);
      return;
    }
    paramImageView.setColorFilter(0);
  }
  
  public static Boolean setCurrentThemeIdVersion(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    Object localObject2 = Boolean.valueOf(false);
    Object localObject1;
    if (paramAppRuntime == null)
    {
      localObject1 = getCreateAppRuntime();
      if (QLog.isColorLevel()) {
        QLog.e("Theme.ThemeUtil", 1, "setCurrentThemeIdVersion,application == null");
      }
      paramAppRuntime = (AppRuntime)localObject1;
      if (localObject1 == null)
      {
        QLog.e("Theme.ThemeUtil", 1, "setCurrentThemeIdVersion Error,application == null");
        return localObject2;
      }
    }
    boolean bool1;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      long l1 = System.currentTimeMillis();
      Object localObject3 = getUinThemePreferences(paramAppRuntime);
      localObject2 = paramAppRuntime.getAccount();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        QLog.e("Theme.ThemeUtil", 1, "setCurrentThemeIdVersion Error,uin=noLogin");
        localObject1 = "noLogin";
      }
      curThemeId = paramString1;
      localObject2 = ((SharedPreferences)localObject3).getString("currentThemeId_6.3.5", "1000");
      int i = ((SharedPreferences)localObject3).getInt("user_switch_theme_times", 0);
      long l2 = ((SharedPreferences)localObject3).getLong("themeSetTimeKey", 0L);
      i += 1;
      localObject3 = ((SharedPreferences)localObject3).edit();
      ((SharedPreferences.Editor)localObject3).putString("currentThemeId_6.3.5", paramString1);
      ((SharedPreferences.Editor)localObject3).putString("currentThemeVersion", paramString2);
      ((SharedPreferences.Editor)localObject3).putInt("user_switch_theme_times", i);
      ((SharedPreferences.Editor)localObject3).putLong("themeSetTimeKey", l1);
      bool1 = ((SharedPreferences.Editor)localObject3).commit();
      localObject3 = paramAppRuntime.getApplication().getSharedPreferences((String)localObject1, 4).edit();
      ((SharedPreferences.Editor)localObject3).putString("currentThemeId_6.3.5", paramString1);
      ((SharedPreferences.Editor)localObject3).putString("currentThemeVersion", paramString2);
      ((SharedPreferences.Editor)localObject3).putInt("user_switch_theme_times", i);
      boolean bool2 = ((SharedPreferences.Editor)localObject3).commit();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("setCurrentThemeIdVersion,uin=");
      ((StringBuilder)localObject3).append(VasTextUtil.a((String)localObject1, 2));
      ((StringBuilder)localObject3).append(",oldUsrThemeId=");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(",set new themeId=");
      ((StringBuilder)localObject3).append(paramString1);
      ((StringBuilder)localObject3).append(",set new version=");
      ((StringBuilder)localObject3).append(paramString2);
      ((StringBuilder)localObject3).append(", userSwitchThemeTimes=");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(",commitSuss=");
      ((StringBuilder)localObject3).append(bool1);
      ((StringBuilder)localObject3).append(", oldTime=");
      ((StringBuilder)localObject3).append(l2);
      ((StringBuilder)localObject3).append(", commitSussOld:");
      ((StringBuilder)localObject3).append(bool2);
      QLog.d("Theme.ThemeUtil", 1, ((StringBuilder)localObject3).toString());
    }
    try
    {
      paramString2 = new HashMap();
      paramString2.put("param_themeId", paramString1);
      paramString2.put("param_singleSp", String.valueOf(bool1));
      StatisticCollector.getInstance(paramAppRuntime.getApplication().getApplicationContext()).collectPerformance((String)localObject1, "VipSetCurrentThemeIdVersion", bool1, 1L, 0L, paramString2, "", false);
      label487:
      return Boolean.valueOf(bool1);
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("setCurrentThemeIdVersion Error,themeId or version == null, themeId:");
      paramAppRuntime.append(paramString1);
      paramAppRuntime.append("version:");
      paramAppRuntime.append(paramString2);
      QLog.e("Theme.ThemeUtil", 1, paramAppRuntime.toString());
      return localObject2;
    }
    catch (Exception paramAppRuntime)
    {
      break label487;
    }
  }
  
  public static void setErrorThemeId(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = getThemePreferences(paramContext);
    SharedPreferences.Editor localEditor = paramContext.edit();
    paramContext = paramContext.getString("listOfErrorThemeSrc", "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setErrorThemeID themeId=");
      localStringBuilder.append(paramString);
      QLog.d("Theme.ThemeUtil", 2, localStringBuilder.toString());
    }
    int j;
    try
    {
      if (TextUtils.isEmpty(paramContext)) {
        paramContext = new JSONObject();
      } else {
        paramContext = new JSONObject(paramContext);
      }
      if (!paramContext.has(paramString)) {
        break label184;
      }
      i = paramContext.getInt(paramString);
    }
    catch (Exception paramContext)
    {
      if (!QLog.isColorLevel()) {
        break label183;
      }
      paramString = new StringBuilder();
      paramString.append("setErrorThemeId error:");
      paramString.append(paramContext.getMessage());
      QLog.d("Theme.ThemeUtil", 2, paramString.toString());
      label183:
      return;
    }
    paramContext.put(paramString, i + j);
    localEditor.putString("listOfErrorThemeSrc", paramContext.toString()).commit();
    return;
    label184:
    int i = 0;
    if (paramBoolean)
    {
      j = 500000;
      i %= 100000;
    }
    for (;;)
    {
      break;
      j = 300001;
      i %= 100000;
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
    if ((paramContext != null) && (paramThemeInfo != null))
    {
      localObject = getThemePreferences(paramContext).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramThemeInfo.zipVer);
      localStringBuilder.append(",");
      localStringBuilder.append(paramThemeInfo.version);
      localStringBuilder.append(",");
      localStringBuilder.append(paramThemeInfo.fileNum);
      localStringBuilder.append(",");
      if (paramThemeInfo.isVoiceTheme) {
        paramContext = "1";
      } else {
        paramContext = "0";
      }
      localStringBuilder.append(paramContext);
      localStringBuilder.append(",");
      localStringBuilder.append(paramThemeInfo.size);
      localStringBuilder.append(",");
      localStringBuilder.append(paramThemeInfo.downsize);
      localStringBuilder.append(",");
      localStringBuilder.append(paramThemeInfo.status);
      paramContext = localStringBuilder.toString();
      boolean bool = ((SharedPreferences.Editor)localObject).putString(paramThemeInfo.themeId, paramContext).commit();
      if ((!bool) || (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setThemeInfoToSp sp comit ret=");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", themeStr=");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append(" themeInfo = ");
        ((StringBuilder)localObject).append(paramThemeInfo);
        QLog.d("Theme.ThemeUtil", 2, ((StringBuilder)localObject).toString());
      }
      return Boolean.valueOf(bool);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setThemeInfoToSp error, themeInfo:");
    ((StringBuilder)localObject).append(paramThemeInfo);
    ((StringBuilder)localObject).append(", context:");
    ((StringBuilder)localObject).append(paramContext);
    QLog.e("Theme.ThemeUtil", 1, ((StringBuilder)localObject).toString());
    return Boolean.valueOf(false);
  }
  
  public static boolean setWeekLoopTheme(AppRuntime paramAppRuntime, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setWeekLoopTheme, seriesID=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", themeArray=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", startTime=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("Theme.ThemeUtil", 2, ((StringBuilder)localObject).toString());
    }
    paramAppRuntime = getUinThemePreferences(paramAppRuntime);
    Object localObject = paramAppRuntime.edit();
    boolean bool1 = true;
    boolean bool2 = true;
    if (TextUtils.isEmpty(paramString1))
    {
      bool2 = bool1;
      if (!TextUtils.isEmpty(paramAppRuntime.getString("seriesID", null)))
      {
        ((SharedPreferences.Editor)localObject).putString("seriesID", "");
        ((SharedPreferences.Editor)localObject).putString("themeArray", "");
        return ((SharedPreferences.Editor)localObject).commit();
      }
    }
    else
    {
      bool1 = bool2;
      try
      {
        ((SharedPreferences.Editor)localObject).putString("seriesID", paramString1);
        bool1 = bool2;
        ((SharedPreferences.Editor)localObject).putString("themeArray", paramString2);
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString2))
        {
          bool1 = bool2;
          int j = new JSONArray(paramString2).length();
          int i = 0;
          if (j <= 0)
          {
            bool1 = bool2;
            QLog.e("Theme.ThemeUtil", 2, "setWeekLoopTheme themeJsonArr Error:0 == length");
            return false;
          }
          bool1 = bool2;
          int k = TimeZone.getTimeZone("GMT+8").getRawOffset();
          bool1 = bool2;
          if (System.currentTimeMillis() > paramLong)
          {
            bool1 = bool2;
            long l1 = System.currentTimeMillis();
            long l2 = k;
            bool1 = bool2;
            i = ((int)Math.ceil((l1 + l2) / 86400000L) - (int)Math.ceil((l2 + paramLong) / 86400000L)) % j;
          }
          bool1 = bool2;
          ((SharedPreferences.Editor)localObject).putInt("themeLength", j);
          bool1 = bool2;
          ((SharedPreferences.Editor)localObject).putInt("themeIndex", i);
          bool1 = bool2;
          ((SharedPreferences.Editor)localObject).putLong("startTime", paramLong);
        }
        bool1 = bool2;
        boolean bool3 = ((SharedPreferences.Editor)localObject).commit();
        bool1 = bool3;
        bool2 = bool3;
        if (QLog.isColorLevel())
        {
          bool1 = bool3;
          paramAppRuntime = new StringBuilder();
          bool1 = bool3;
          paramAppRuntime.append("setWeekLoopTheme , setWeekLoopTheme is ok:");
          bool1 = bool3;
          paramAppRuntime.append(bool3);
          bool1 = bool3;
          QLog.d("Theme.ThemeUtil", 2, paramAppRuntime.toString());
          return bool3;
        }
      }
      catch (Exception paramAppRuntime)
      {
        paramString1 = new StringBuilder();
        paramString1.append("setWeekLoopTheme json Error:");
        paramString1.append(paramAppRuntime.getMessage());
        QLog.e("Theme.ThemeUtil", 2, paramString1.toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public static boolean themeFont(Intent paramIntent, String paramString)
  {
    paramIntent = paramIntent.getStringExtra(paramString);
    if (TextUtils.isEmpty(paramIntent)) {
      return false;
    }
    try
    {
      ((IThemeFontAdapter)QRoute.api(IThemeFontAdapter.class)).switchFont(Integer.parseInt(paramIntent));
    }
    catch (NumberFormatException paramIntent)
    {
      paramIntent.printStackTrace();
    }
    return true;
  }
  
  private static void validLocalBg3D(Context paramContext, AppRuntime paramAppRuntime, String paramString1, String paramString2) {}
  
  public static void validLocalTheme(Context paramContext, String paramString) {}
  
  public static void validLocalTheme(Context paramContext, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.ThemeUtil
 * JD-Core Version:    0.7.0.1
 */
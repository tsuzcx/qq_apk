package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class QQTheme
{
  public static final String DEFAULT_THEME_ID = "1000";
  public static final String DIY_THEME_ID = "999";
  public static final String INTERNAL_THEME_DIR_810 = "theme_810";
  public static final String KEY_SIMPLE_THEME_ID = "simple_theme_id";
  public static final String KEY_THEME = "theme_root";
  public static final ColorFilter NIGHTMODE_COLORFILTER = new PorterDuffColorFilter(NIGHTMODE_MASKCOLOR, PorterDuff.Mode.SRC_ATOP);
  public static final int NIGHTMODE_MASKCOLOR;
  public static final String PREFERENCE_NAME = "theme";
  private static final String TAG = "QQTheme";
  public static final String[] THEME_DEFAULT_IDS = { "999", "1000", "1103", "2971", "2921", "3064", "3063", "3066", "3065", "3067", "3491", "2920" };
  public static final String THEME_ID = "themeId";
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
  public static final String THEME_KEY_CURRENT_THEME_ID = "currentThemeId_6.3.5";
  public static final String THEME_VERSION = "version";
  public static String lastThemeId = "";
  public static List<String> themeIds = new ArrayList();
  
  static
  {
    NIGHTMODE_MASKCOLOR = Color.parseColor("#4d000000");
  }
  
  public static String getCurrentThemeId()
  {
    if (BaseApplication.getContext() == null) {
      return "1000";
    }
    Object localObject1 = BaseApplication.getContext().getSharedPreferences("theme", 4);
    if (localObject1 == null) {
      return "1000";
    }
    String str = getNewSimpleThemeId();
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    str = null;
    Object localObject2 = ((SharedPreferences)localObject1).getString("theme_root", null);
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return "1000";
    }
    localObject1 = localObject2;
    if (((String)localObject2).endsWith(File.separator)) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    if (((String)localObject1).contains("theme_810"))
    {
      localObject2 = ((String)localObject1).split(File.separator);
      localObject1 = str;
      if (localObject2.length >= 3) {
        localObject1 = localObject2[(localObject2.length - 3)];
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        return localObject1;
      }
    }
    else
    {
      localObject1 = ((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split("_");
        if (localObject1.length == 2) {
          return localObject1[0];
        }
      }
    }
    return "1000";
  }
  
  public static String getNewSimpleThemeId()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("theme", 4);
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("simple_theme_id", null);
  }
  
  public static SharedPreferences getUinThemePreferences(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "noLogin";
    }
    paramString = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_theme");
    return paramString.getSharedPreferences(localStringBuilder.toString(), 4);
  }
  
  public static String getUserCurrentThemeId(String paramString)
  {
    String str = getUinThemePreferences(paramString).getString("currentThemeId_6.3.5", null);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "1000";
    }
    return paramString;
  }
  
  public static boolean isColorDark(int paramInt)
  {
    double d1 = Color.red(paramInt);
    Double.isNaN(d1);
    double d2 = Color.green(paramInt);
    Double.isNaN(d2);
    double d3 = Color.blue(paramInt);
    Double.isNaN(d3);
    return 1.0D - (d1 * 0.299D + d2 * 0.587D + d3 * 0.114D) / 255.0D >= 0.5D;
  }
  
  public static boolean isCustomTheme(String paramString)
  {
    String[] arrayOfString = THEME_DEFAULT_IDS;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(arrayOfString[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isCustomTheme(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramString = getUserCurrentThemeId(paramString);
    } else {
      paramString = getCurrentThemeId();
    }
    return isCustomTheme(paramString);
  }
  
  public static boolean isDefaultOrDIYTheme()
  {
    String str = getCurrentThemeId();
    return ("1000".equals(str)) || ("999".equals(str));
  }
  
  public static boolean isDefaultTheme()
  {
    return "1000".equals(getCurrentThemeId());
  }
  
  public static boolean isLastThemeIsNight()
  {
    return ("1103".equals(lastThemeId)) || ("2920".equals(lastThemeId));
  }
  
  public static boolean isNowSimpleUI()
  {
    return isThemeSimpleUI(getCurrentThemeId());
  }
  
  public static boolean isNowThemeIsNight()
  {
    String str = getCurrentThemeId();
    return ("1103".equals(str)) || ("2920".equals(str));
  }
  
  public static boolean isNowThemeIsNightForQzone()
  {
    return isNowThemeIsNight();
  }
  
  public static boolean isNowThemeSimpleNight()
  {
    return "2920".equals(getCurrentThemeId());
  }
  
  public static boolean isSimpleColrThemeStateBarUseWhite(String paramString)
  {
    return ("3064".equals(paramString)) || ("2971".equals(paramString)) || ("2921".equals(paramString));
  }
  
  public static boolean isSimpleWhite()
  {
    return "2971".equals(getCurrentThemeId());
  }
  
  public static boolean isThemeSimpleDayUI(String paramString)
  {
    boolean bool2 = "2920".equals(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (("2971".equals(paramString)) || ("2921".equals(paramString)) || ("3064".equals(paramString)) || ("3063".equals(paramString)) || ("3066".equals(paramString)) || ("3065".equals(paramString)) || ("3067".equals(paramString)) || ("3491".equals(paramString)) || ("1001".equals(paramString)) || (themeIds.contains(paramString))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static final boolean isThemeSimpleUI(String paramString)
  {
    return ("2920".equals(paramString)) || (isThemeSimpleDayUI(paramString));
  }
  
  public static void setNewSimpleThemeId(String paramString)
  {
    BaseApplication.getContext().getSharedPreferences("theme", 4).edit().putString("simple_theme_id", paramString).apply();
  }
  
  public static void setNightFilter(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (isNowThemeIsNight())
      {
        paramDrawable.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
        return;
      }
      paramDrawable.clearColorFilter();
    }
  }
  
  public static void storeLastThemeId(String paramString)
  {
    lastThemeId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQTheme
 * JD-Core Version:    0.7.0.1
 */
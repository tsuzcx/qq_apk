package com.tencent.mobileqq.vas.theme.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.util.VasTextUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ThemeUtil
{
  public static final int a;
  static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public static ColorFilter a;
  private static IThemeSwitchCallback jdField_a_of_type_ComTencentMobileqqVasThemeApiIThemeSwitchCallback;
  static Object jdField_a_of_type_JavaLangObject;
  public static String a;
  static WeakReference<AppRuntime> jdField_a_of_type_JavaLangRefWeakReference;
  public static boolean a;
  public static final String[] a;
  public static String b;
  static boolean b;
  static String jdField_c_of_type_JavaLangString;
  static boolean jdField_c_of_type_Boolean;
  static String d;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "999", "1000", "1103", "2971", "2921", "3064", "3063", "3066", "3065", "3067" };
    jdField_a_of_type_Int = Color.parseColor("#4d000000");
    jdField_a_of_type_AndroidGraphicsColorFilter = new PorterDuffColorFilter(jdField_a_of_type_Int, PorterDuff.Mode.SRC_ATOP);
    jdField_a_of_type_JavaLangString = a();
    jdField_b_of_type_JavaLangString = "";
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_AndroidContentBroadcastReceiver = new ThemeUtil.1();
    jdField_a_of_type_ComTencentMobileqqVasThemeApiIThemeSwitchCallback = new ThemeUtil.2();
    jdField_a_of_type_Boolean = true;
  }
  
  public static SharedPreferences a(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null)
    {
      paramContext = a().getApplicationContext();
      localContext = paramContext;
      if (QLog.isColorLevel())
      {
        QLog.d("Theme.ThemeUtil", 2, "getThemePreferences null == context");
        localContext = paramContext;
      }
    }
    return localContext.getSharedPreferences("userThemeSharedPreferences", 4);
  }
  
  public static SharedPreferences a(AppRuntime paramAppRuntime)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null)
    {
      paramAppRuntime = a();
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
  
  public static Bundle a()
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
              break label196;
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
      label196:
      Object localObject2 = null;
    }
  }
  
  public static ThemeUtil.ThemeInfo a(Context paramContext, String paramString)
  {
    ThemeUtil.ThemeInfo localThemeInfo = null;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("Theme.ThemeUtil", 1, "getThemeInfoFromSp error, themeId:" + paramString + ", context:" + paramContext);
      paramContext = localThemeInfo;
    }
    do
    {
      do
      {
        return paramContext;
        str = a(paramContext).getString(paramString, "");
        if (!TextUtils.isEmpty(str)) {
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
        if (!TextUtils.isEmpty(paramContext[0])) {
          localThemeInfo.zipVer = Integer.parseInt(paramContext[0]);
        }
        if (!TextUtils.isEmpty(paramContext[1])) {
          localThemeInfo.version = paramContext[1];
        }
        if (!TextUtils.isEmpty(paramContext[2])) {
          localThemeInfo.fileNum = Integer.parseInt(paramContext[2]);
        }
        localThemeInfo.isVoiceTheme = "1".equals(paramContext[3]);
        if (!TextUtils.isEmpty(paramContext[4])) {
          localThemeInfo.size = Long.parseLong(paramContext[4]);
        }
        if (!TextUtils.isEmpty(paramContext[5])) {
          localThemeInfo.downsize = Long.parseLong(paramContext[5]);
        }
        if (!TextUtils.isEmpty(paramContext[6])) {
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
  
  public static String a()
  {
    String str2 = a().getString("themeId");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "1000";
    }
    jdField_a_of_type_JavaLangString = str1;
    return str1;
  }
  
  public static String a(int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    String str;
    if (TextUtils.isEmpty(d))
    {
      localObject1 = a();
      str = ((Bundle)localObject1).getString("themePath");
      if (TextUtils.isEmpty(str))
      {
        localObject1 = ((Bundle)localObject1).getString("themeId");
        QLog.e("Theme.ThemeUtil", 2, "getAnimatePathByTag err ApngImage path = " + null + " id = " + (String)localObject1);
        return localObject2;
      }
      if (str.endsWith(File.separator)) {
        d = str;
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
      d = str + File.separator;
      break label94;
      localObject1 = d + "raw/qvip_drawer_bg_animate.png";
      continue;
      localObject1 = d + "raw/qvip_conversation_bg_animate.png";
      continue;
      localObject1 = d + "raw/qvip_chatbackground_animate.png";
      continue;
      localObject1 = d + "raw/qvip_tab_icon_conversation_animate.png";
      continue;
      localObject1 = d + "raw/qvip_tab_icon_contact_animate.png";
      continue;
      localObject1 = d + "raw/qvip_tab_icon_call_animate.png";
      continue;
      localObject1 = d + "raw/qvip_tab_icon_plugin_animate.png";
      continue;
      localObject1 = d + "raw/qvip_tab_icon_now_animate.png";
      continue;
      localObject1 = d + "raw/qvip_tab_icon_see_animate.png";
      continue;
      localObject1 = d + "raw/qvip_tab_icon_qcircle_animate.png";
    }
  }
  
  public static String a(String paramString)
  {
    return "theme." + paramString;
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    Object localObject1 = paramAppRuntime;
    Object localObject2;
    if (paramAppRuntime == null)
    {
      paramAppRuntime = a();
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
      localSharedPreferences = a((AppRuntime)localObject1);
      localObject2 = localSharedPreferences.getString("currentThemeId_6.3.5", null);
      paramAppRuntime = ((AppRuntime)localObject1).getAccount();
      localObject1 = paramAppRuntime;
      if (paramAppRuntime == null)
      {
        localObject1 = "noLogin";
        QLog.e("Theme.ThemeUtil", 1, "getUserCurrentThemeId Error, uin=noLogin");
      }
      paramAppRuntime = (AppRuntime)localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeVersion,null == currentThemeId, currentThemeId= ThemeUtil.DEFAULT_THEME_ID");
        }
        paramAppRuntime = "1000";
      }
      jdField_a_of_type_JavaLangString = paramAppRuntime;
      localObject2 = paramAppRuntime;
    } while (!QLog.isColorLevel());
    long l = localSharedPreferences.getLong("themeSetTimeKey", 0L);
    QLog.d("Theme.ThemeUtil", 2, "getUserCurrentThemeId,uin=" + (String)localObject1 + ",currentThemeId=" + paramAppRuntime + ", oldTime=" + l);
    return paramAppRuntime;
  }
  
  private static AppRuntime a()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static void a(Context paramContext, String paramString) {}
  
  public static void a(Context paramContext, String paramString1, String paramString2) {}
  
  public static void a(Drawable paramDrawable, String paramString)
  {
    if (paramDrawable == null) {
      return;
    }
    if ("1103".equals(paramString))
    {
      paramDrawable.setColorFilter(jdField_a_of_type_AndroidGraphicsColorFilter);
      return;
    }
    paramDrawable.clearColorFilter();
  }
  
  public static boolean a()
  {
    return "1000".equals(a(null));
  }
  
  public static boolean a(Intent paramIntent, String paramString)
  {
    paramIntent = paramIntent.getStringExtra(paramString);
    if (TextUtils.isEmpty(paramIntent)) {
      return false;
    }
    try
    {
      ((IThemeFontAdapter)QRoute.api(IThemeFontAdapter.class)).switchFont(Integer.parseInt(paramIntent));
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
  
  public static boolean a(String paramString)
  {
    return paramString.startsWith("theme.ios");
  }
  
  @Deprecated
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime);
    return ("1103".equals(paramAppRuntime)) || ("2920".equals(paramAppRuntime));
  }
  
  public static boolean a(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      if (!paramBoolean) {
        break label39;
      }
    }
    label39:
    for (str = a(paramAppRuntime); ("1103".equals(str)) || ("2920".equals(str)); str = a()) {
      return true;
    }
    return false;
  }
  
  public static boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = a(null); ("1000".equals(str)) || ("999".equals(str)); str = a()) {
      return true;
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("Theme.ThemeUtil", 1, "getIDFromSCID error null: zipName=" + paramString);
      return null;
    }
    int i = 0;
    Object localObject = paramString.split("\\.");
    if ((paramString.startsWith("theme.")) && (localObject.length > 3)) {
      localObject = localObject[2];
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) || (TextUtils.isEmpty((CharSequence)localObject))) {
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
  
  public static void b(Context paramContext, String paramString) {}
  
  private static void b(Context paramContext, AppRuntime paramAppRuntime, String paramString1, String paramString2) {}
  
  public static boolean b()
  {
    return "2101".equals(a(null));
  }
  
  public static boolean b(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (str = a(paramAppRuntime);; str = a()) {
      return ((ISimpleUIUtil)QRoute.api(ISimpleUIUtil.class)).isThemeSimpleUI(str);
    }
  }
  
  public static boolean b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = a(null);; str = a()) {
      return ((ISimpleUIUtil)QRoute.api(ISimpleUIUtil.class)).isThemeSimpleDayUI(str);
    }
  }
  
  /* Error */
  public static boolean c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: ldc 2
    //   7: monitorenter
    //   8: invokestatic 315	com/tencent/mobileqq/vas/theme/api/ThemeUtil:a	()Landroid/os/Bundle;
    //   11: astore_3
    //   12: aload_3
    //   13: ldc 162
    //   15: invokevirtual 318	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 6
    //   20: aload 6
    //   22: getstatic 463	com/tencent/mobileqq/vas/theme/api/ThemeUtil:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   25: invokevirtual 283	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: ifeq +12 -> 40
    //   31: getstatic 465	com/tencent/mobileqq/vas/theme/api/ThemeUtil:jdField_b_of_type_Boolean	Z
    //   34: istore_1
    //   35: ldc 2
    //   37: monitorexit
    //   38: iload_1
    //   39: ireturn
    //   40: aconst_null
    //   41: putstatic 320	com/tencent/mobileqq/vas/theme/api/ThemeUtil:d	Ljava/lang/String;
    //   44: iconst_0
    //   45: putstatic 465	com/tencent/mobileqq/vas/theme/api/ThemeUtil:jdField_b_of_type_Boolean	Z
    //   48: iconst_0
    //   49: putstatic 467	com/tencent/mobileqq/vas/theme/api/ThemeUtil:jdField_c_of_type_Boolean	Z
    //   52: aload 6
    //   54: invokestatic 213	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +23 -> 80
    //   60: ldc 26
    //   62: aload 6
    //   64: invokevirtual 283	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifne +13 -> 80
    //   70: ldc 24
    //   72: aload 6
    //   74: invokevirtual 283	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifeq +13 -> 90
    //   80: aload 6
    //   82: putstatic 463	com/tencent/mobileqq/vas/theme/api/ThemeUtil:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   85: iconst_0
    //   86: istore_1
    //   87: goto -52 -> 35
    //   90: aload 6
    //   92: invokestatic 269	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   95: sipush 5000
    //   98: if_icmplt +56 -> 154
    //   101: aload 6
    //   103: invokestatic 269	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   106: ldc_w 468
    //   109: if_icmpge +45 -> 154
    //   112: aload 6
    //   114: putstatic 463	com/tencent/mobileqq/vas/theme/api/ThemeUtil:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   117: iconst_0
    //   118: istore_1
    //   119: goto -84 -> 35
    //   122: astore 5
    //   124: ldc 112
    //   126: iconst_2
    //   127: new 141	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 470
    //   137: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 5
    //   142: invokevirtual 313	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   145: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_3
    //   155: ldc 181
    //   157: invokevirtual 318	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   160: astore_3
    //   161: aload_3
    //   162: invokestatic 213	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   165: ifne +394 -> 559
    //   168: aload_3
    //   169: getstatic 190	java/io/File:separator	Ljava/lang/String;
    //   172: invokevirtual 194	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   175: ifeq +125 -> 300
    //   178: new 141	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   185: aload_3
    //   186: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc_w 472
    //   192: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: astore 4
    //   200: new 187	java/io/File
    //   203: dup
    //   204: aload 4
    //   206: invokespecial 475	java/io/File:<init>	(Ljava/lang/String;)V
    //   209: astore 5
    //   211: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +44 -> 258
    //   217: ldc 112
    //   219: iconst_2
    //   220: new 141	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 477
    //   230: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload 4
    //   235: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc_w 479
    //   241: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 5
    //   246: invokevirtual 482	java/io/File:exists	()Z
    //   249: invokevirtual 485	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   252: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: aload 5
    //   260: invokevirtual 482	java/io/File:exists	()Z
    //   263: istore_1
    //   264: aload_3
    //   265: astore 4
    //   267: iload_1
    //   268: ifeq +291 -> 559
    //   271: aload 5
    //   273: iconst_m1
    //   274: invokestatic 490	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;I)Ljava/lang/String;
    //   277: astore 4
    //   279: aload 4
    //   281: ifnull +14 -> 295
    //   284: aload 4
    //   286: invokevirtual 185	java/lang/String:length	()I
    //   289: istore_0
    //   290: iload_0
    //   291: iconst_2
    //   292: if_icmpge +64 -> 356
    //   295: iconst_0
    //   296: istore_1
    //   297: goto -262 -> 35
    //   300: new 141	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   307: aload_3
    //   308: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: getstatic 190	java/io/File:separator	Ljava/lang/String;
    //   314: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: astore 5
    //   322: new 141	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   329: aload_3
    //   330: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: getstatic 190	java/io/File:separator	Ljava/lang/String;
    //   336: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: ldc_w 472
    //   342: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: astore 4
    //   350: aload 5
    //   352: astore_3
    //   353: goto -153 -> 200
    //   356: new 492	org/json/JSONObject
    //   359: dup
    //   360: aload 4
    //   362: invokespecial 493	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   365: astore 4
    //   367: aload 4
    //   369: ldc_w 495
    //   372: invokevirtual 498	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   375: astore 5
    //   377: ldc_w 500
    //   380: aload 4
    //   382: ldc_w 502
    //   385: invokevirtual 498	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   388: invokevirtual 283	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   391: putstatic 467	com/tencent/mobileqq/vas/theme/api/ThemeUtil:jdField_c_of_type_Boolean	Z
    //   394: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +30 -> 427
    //   400: ldc 112
    //   402: iconst_2
    //   403: new 141	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   410: ldc_w 504
    //   413: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload 5
    //   418: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 507	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: ldc_w 509
    //   430: aload 5
    //   432: invokevirtual 283	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   435: istore_1
    //   436: iload_1
    //   437: ifeq +11 -> 448
    //   440: iconst_1
    //   441: putstatic 465	com/tencent/mobileqq/vas/theme/api/ThemeUtil:jdField_b_of_type_Boolean	Z
    //   444: aload_3
    //   445: putstatic 320	com/tencent/mobileqq/vas/theme/api/ThemeUtil:d	Ljava/lang/String;
    //   448: getstatic 465	com/tencent/mobileqq/vas/theme/api/ThemeUtil:jdField_b_of_type_Boolean	Z
    //   451: ifeq +61 -> 512
    //   454: new 159	android/os/Bundle
    //   457: dup
    //   458: invokespecial 160	android/os/Bundle:<init>	()V
    //   461: astore_3
    //   462: ldc_w 511
    //   465: invokestatic 417	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   468: checkcast 511	com/tencent/mobileqq/vas/theme/api/IThemeSwitcher
    //   471: aload_3
    //   472: invokeinterface 515 2 0
    //   477: ifeq +35 -> 512
    //   480: iload_2
    //   481: istore_1
    //   482: aload_3
    //   483: ldc_w 517
    //   486: iconst_1
    //   487: invokevirtual 521	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   490: ifeq +18 -> 508
    //   493: iload_2
    //   494: istore_1
    //   495: aload_3
    //   496: ldc_w 523
    //   499: iconst_1
    //   500: invokevirtual 521	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   503: ifeq +5 -> 508
    //   506: iconst_1
    //   507: istore_1
    //   508: iload_1
    //   509: putstatic 465	com/tencent/mobileqq/vas/theme/api/ThemeUtil:jdField_b_of_type_Boolean	Z
    //   512: aload 6
    //   514: putstatic 463	com/tencent/mobileqq/vas/theme/api/ThemeUtil:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   517: getstatic 465	com/tencent/mobileqq/vas/theme/api/ThemeUtil:jdField_b_of_type_Boolean	Z
    //   520: istore_1
    //   521: goto -486 -> 35
    //   524: astore 4
    //   526: ldc 112
    //   528: iconst_1
    //   529: new 141	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 525
    //   539: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload 4
    //   544: invokevirtual 526	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   547: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   556: aload_3
    //   557: astore 4
    //   559: iconst_0
    //   560: istore_1
    //   561: aload 4
    //   563: astore_3
    //   564: goto -128 -> 436
    //   567: astore_3
    //   568: ldc 2
    //   570: monitorexit
    //   571: aload_3
    //   572: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   289	4	0	i	int
    //   34	527	1	bool1	boolean
    //   4	490	2	bool2	boolean
    //   11	553	3	localObject1	Object
    //   567	5	3	localObject2	Object
    //   1	380	4	localObject3	Object
    //   524	19	4	localThrowable	java.lang.Throwable
    //   557	5	4	localObject4	Object
    //   122	19	5	localException	Exception
    //   209	222	5	localObject5	Object
    //   18	495	6	str	String
    // Exception table:
    //   from	to	target	type
    //   90	117	122	java/lang/Exception
    //   271	279	524	java/lang/Throwable
    //   284	290	524	java/lang/Throwable
    //   356	427	524	java/lang/Throwable
    //   427	436	524	java/lang/Throwable
    //   8	35	567	finally
    //   40	80	567	finally
    //   80	85	567	finally
    //   90	117	567	finally
    //   124	154	567	finally
    //   154	161	567	finally
    //   161	200	567	finally
    //   200	258	567	finally
    //   258	264	567	finally
    //   271	279	567	finally
    //   284	290	567	finally
    //   300	350	567	finally
    //   356	427	567	finally
    //   427	436	567	finally
    //   440	448	567	finally
    //   448	480	567	finally
    //   482	493	567	finally
    //   495	506	567	finally
    //   508	512	567	finally
    //   512	521	567	finally
    //   526	556	567	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.ThemeUtil
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.sdk.ui.dialog.d;
import com.tencent.smtt.sdk.ui.dialog.e;
import com.tencent.smtt.utils.FileProvider;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.i;
import com.tencent.smtt.utils.l;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"NewApi"})
public class QbSdk
{
  private static String A;
  private static boolean B = false;
  private static boolean C = true;
  private static TbsListener D = null;
  private static TbsListener E = null;
  public static final int EXTENSION_INIT_FAILURE = -99999;
  private static boolean F = false;
  public static final String FILERADER_MENUDATA = "menuData";
  private static boolean G = false;
  public static final String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
  public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
  public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
  public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
  public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
  public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
  public static final int QBMODE = 2;
  public static final String SHARE_PREFERENCES_NAME = "tbs_file_open_dialog_config";
  public static final String SVNVERSION = "jnizz";
  public static final int TBSMODE = 1;
  public static final String TID_QQNumber_Prefix = "QQ:";
  public static final int VERSION = 1;
  static boolean a = false;
  static boolean b = false;
  static boolean c = true;
  static String d;
  static boolean e = false;
  static long f = 0L;
  static long g = 0L;
  static Object h = new Object();
  static boolean i = false;
  public static boolean isDefaultDialog = false;
  static boolean j = false;
  static boolean k = false;
  static volatile boolean l = false;
  static TbsListener m = new QbSdk.5();
  public static boolean mDisableUseHostBackupCore = false;
  static Map<String, Object> n = null;
  private static int o = 0;
  private static String p = "";
  private static Class<?> q;
  private static Object r;
  private static boolean s = false;
  public static boolean sIsVersionPrinted = false;
  private static String[] t;
  private static String u = "NULL";
  private static String v = "UNKNOWN";
  private static boolean w = false;
  private static int x;
  private static int y;
  private static String z;
  
  static
  {
    i = true;
    j = true;
    k = false;
    x = 0;
    y = 170;
    z = null;
    A = null;
    l = a;
    mDisableUseHostBackupCore = false;
  }
  
  static Bundle a(Context paramContext, Bundle paramBundle)
  {
    if (!a(paramContext)) {
      paramContext = TbsLogReport.getInstance(paramContext);
    }
    for (paramBundle = "initForPatch return false!";; paramBundle = "incrUpdate return null!")
    {
      paramContext.setInstallErrorCode(216, paramBundle);
      return null;
      paramBundle = i.a(r, "incrUpdate", new Class[] { Context.class, Bundle.class }, new Object[] { paramContext, paramBundle });
      if (paramBundle != null) {
        return (Bundle)paramBundle;
      }
      paramContext = TbsLogReport.getInstance(paramContext);
    }
  }
  
  /* Error */
  private static Bundle a(Context paramContext, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 177	android/os/Bundle
    //   9: dup
    //   10: invokespecial 188	android/os/Bundle:<init>	()V
    //   13: astore 5
    //   15: aload_1
    //   16: ldc 190
    //   18: invokeinterface 196 2 0
    //   23: ifnonnull +10 -> 33
    //   26: ldc 198
    //   28: astore 4
    //   30: goto +16 -> 46
    //   33: aload_1
    //   34: ldc 190
    //   36: invokeinterface 196 2 0
    //   41: checkcast 200	java/lang/String
    //   44: astore 4
    //   46: aload 5
    //   48: ldc 190
    //   50: aload 4
    //   52: invokevirtual 204	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload 5
    //   57: ldc 206
    //   59: aload_1
    //   60: ldc 206
    //   62: invokeinterface 196 2 0
    //   67: checkcast 200	java/lang/String
    //   70: invokestatic 212	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   73: invokevirtual 216	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   76: aload_1
    //   77: ifnull +143 -> 220
    //   80: aload_1
    //   81: ldc 23
    //   83: invokeinterface 220 2 0
    //   88: ifeq +132 -> 220
    //   91: new 222	org/json/JSONObject
    //   94: dup
    //   95: aload_1
    //   96: ldc 23
    //   98: invokeinterface 196 2 0
    //   103: checkcast 200	java/lang/String
    //   106: invokespecial 225	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   109: astore_1
    //   110: aload_1
    //   111: ldc 227
    //   113: invokevirtual 231	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   116: astore 4
    //   118: aload 4
    //   120: ifnull +89 -> 209
    //   123: new 233	java/util/ArrayList
    //   126: dup
    //   127: invokespecial 234	java/util/ArrayList:<init>	()V
    //   130: astore 6
    //   132: iconst_0
    //   133: istore_2
    //   134: aload 4
    //   136: invokevirtual 240	org/json/JSONArray:length	()I
    //   139: istore_3
    //   140: iload_2
    //   141: iload_3
    //   142: if_icmpge +57 -> 199
    //   145: iload_2
    //   146: iconst_5
    //   147: if_icmpge +52 -> 199
    //   150: aload 4
    //   152: iload_2
    //   153: invokevirtual 243	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   156: checkcast 222	org/json/JSONObject
    //   159: astore 7
    //   161: aload 7
    //   163: ldc 245
    //   165: invokevirtual 248	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   168: istore_3
    //   169: aload 6
    //   171: iload_2
    //   172: aload_0
    //   173: invokevirtual 252	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   176: iload_3
    //   177: invokestatic 258	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   180: invokevirtual 262	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   183: aload 7
    //   185: ldc 245
    //   187: iload_2
    //   188: invokevirtual 266	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   191: pop
    //   192: iload_2
    //   193: iconst_1
    //   194: iadd
    //   195: istore_2
    //   196: goto -62 -> 134
    //   199: aload 5
    //   201: ldc_w 268
    //   204: aload 6
    //   206: invokevirtual 272	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   209: aload 5
    //   211: ldc 23
    //   213: aload_1
    //   214: invokevirtual 276	org/json/JSONObject:toString	()Ljava/lang/String;
    //   217: invokevirtual 204	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload 5
    //   222: areturn
    //   223: astore_0
    //   224: aload_0
    //   225: invokevirtual 279	java/lang/Exception:printStackTrace	()V
    //   228: aconst_null
    //   229: areturn
    //   230: astore 4
    //   232: goto -156 -> 76
    //   235: astore 7
    //   237: goto -45 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramContext	Context
    //   0	240	1	paramMap	Map<String, String>
    //   133	63	2	i1	int
    //   139	38	3	i2	int
    //   28	123	4	localObject	Object
    //   230	1	4	localException1	Exception
    //   13	208	5	localBundle	Bundle
    //   130	75	6	localArrayList	java.util.ArrayList
    //   159	25	7	localJSONObject	org.json.JSONObject
    //   235	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	26	223	java/lang/Exception
    //   33	46	223	java/lang/Exception
    //   46	55	223	java/lang/Exception
    //   80	118	223	java/lang/Exception
    //   123	132	223	java/lang/Exception
    //   134	140	223	java/lang/Exception
    //   199	209	223	java/lang/Exception
    //   209	220	223	java/lang/Exception
    //   55	76	230	java/lang/Exception
    //   150	192	235	java/lang/Exception
  }
  
  static Object a(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (!a(paramContext)) {
      return Integer.valueOf(-99999);
    }
    paramContext = i.a(r, "miscCall", new Class[] { String.class, Bundle.class }, new Object[] { paramString, paramBundle });
    if (paramContext != null) {
      return paramContext;
    }
    return null;
  }
  
  static String a()
  {
    return p;
  }
  
  static void a(Context paramContext, Integer paramInteger, Map<Integer, String> paramMap)
  {
    if (!a(paramContext)) {
      return;
    }
    i.a(r, "dispatchEmergencyCommand", new Class[] { Integer.class, Map.class }, new Object[] { paramInteger, paramMap });
  }
  
  static void a(Context paramContext, String paramString)
  {
    try
    {
      boolean bool = a;
      if (bool) {
        return;
      }
      a = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("forceSysWebViewInner: ");
      localStringBuilder.append(paramString);
      v = localStringBuilder.toString();
      paramString = new StringBuilder();
      paramString.append("QbSdk.SysWebViewForcedInner...");
      paramString.append(v);
      TbsLog.e("QbSdk", paramString.toString());
      TbsCoreLoadStat.getInstance().a(paramContext, 401, new Throwable(v));
      return;
    }
    finally {}
  }
  
  static boolean a(Context paramContext)
  {
    try
    {
      if (q != null) {
        return true;
      }
      Object localObject3 = p.a().q(paramContext);
      if (localObject3 == null)
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
        return false;
      }
      localObject1 = new File((File)localObject3, "tbs_sdk_extension_dex.jar");
      if (!((File)localObject1).exists())
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
        return false;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("new DexLoader #3 dexFile is ");
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      TbsLog.i("QbSdk", ((StringBuilder)localObject2).toString());
      x.a().a(paramContext);
      l.a(paramContext);
      localObject2 = ((File)localObject1).getParent();
      String str = ((File)localObject1).getAbsolutePath();
      localObject3 = ((File)localObject3).getAbsolutePath();
      Map localMap = getSettings();
      q = new DexLoader((String)localObject2, paramContext, new String[] { str }, (String)localObject3, localMap).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      loadTBSSDKExtension(paramContext, ((File)localObject1).getParent());
      return true;
    }
    catch (Throwable paramContext)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initExtension sys WebView: ");
      ((StringBuilder)localObject1).append(Log.getStackTraceString(paramContext));
      TbsLog.e("QbSdk", ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  static boolean a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, 20000);
  }
  
  static boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject = n;
    if ((localObject != null) && (((Map)localObject).containsKey("SET_SENDREQUEST_AND_UPLOAD")) && (n.get("SET_SENDREQUEST_AND_UPLOAD").equals("false")))
    {
      TbsLog.i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
      return true;
    }
    localObject = p.a();
    boolean bool;
    if (f.a == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((p)localObject).b(paramContext, bool);
    if (!c(paramContext)) {
      return true;
    }
    paramContext = i.a(r, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(43973), Integer.valueOf(paramInt2) });
    if (paramContext != null) {}
    do
    {
      return ((Boolean)paramContext).booleanValue();
      paramContext = i.a(r, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(43973) });
    } while (paramContext != null);
    return true;
  }
  
  private static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return isSuportOpenFile(paramString2, 2);
  }
  
  @SuppressLint({"NewApi"})
  private static boolean a(Context paramContext, boolean paramBoolean)
  {
    TbsLog.initIfNeed(paramContext);
    if (!sIsVersionPrinted)
    {
      TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43973; SDK_VERSION_NAME: 4.3.0.73");
      sIsVersionPrinted = true;
    }
    Object localObject1;
    if ((a) && (!paramBoolean))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QbSdk init: ");
      ((StringBuilder)localObject1).append(v);
      TbsLog.e("QbSdk", ((StringBuilder)localObject1).toString(), false);
      TbsCoreLoadStat.getInstance().a(paramContext, 414, new Throwable(v));
      return false;
    }
    if (b)
    {
      TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().a(paramContext, 402, new Throwable(u));
      return false;
    }
    if (!C) {
      d(paramContext);
    }
    for (;;)
    {
      try
      {
        localObject3 = p.a().q(paramContext);
        if (localObject3 == null)
        {
          TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
          TbsCoreLoadStat.getInstance().a(paramContext, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
          return false;
        }
        paramBoolean = TbsShareManager.isThirdPartyApp(paramContext);
        int i2;
        if (paramBoolean)
        {
          if ((o != 0) && (o != TbsShareManager.d(paramContext)))
          {
            q = null;
            r = null;
            TbsLog.e("QbSdk", "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
            localObject1 = TbsCoreLoadStat.getInstance();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("sTbsVersion: ");
            ((StringBuilder)localObject3).append(o);
            ((StringBuilder)localObject3).append("; AvailableTbsCoreVersion: ");
            ((StringBuilder)localObject3).append(TbsShareManager.d(paramContext));
            ((TbsCoreLoadStat)localObject1).a(paramContext, 302, new Throwable(((StringBuilder)localObject3).toString()));
            return false;
          }
          i1 = TbsShareManager.d(paramContext);
          o = i1;
        }
        else
        {
          if (o == 0) {
            break label1264;
          }
          i2 = p.a().a(true, paramContext);
          i1 = i2;
          if (o == i2) {
            continue;
          }
          q = null;
          r = null;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=");
          ((StringBuilder)localObject1).append(i2);
          TbsLog.e("QbSdk", ((StringBuilder)localObject1).toString(), true);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("QbSdk init (false) not isThirdPartyApp sTbsVersion=");
          ((StringBuilder)localObject1).append(o);
          TbsLog.e("QbSdk", ((StringBuilder)localObject1).toString(), true);
          localObject1 = TbsCoreLoadStat.getInstance();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("sTbsVersion: ");
          ((StringBuilder)localObject3).append(o);
          ((StringBuilder)localObject3).append("; tbsCoreInstalledVer: ");
          ((StringBuilder)localObject3).append(i2);
          ((TbsCoreLoadStat)localObject1).a(paramContext, 303, new Throwable(((StringBuilder)localObject3).toString()));
          return false;
        }
        if (TbsDownloader.a(paramContext, o))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("version ");
          ((StringBuilder)localObject1).append(o);
          ((StringBuilder)localObject1).append(" is in blacklist,can not load! return");
          TbsLog.i("QbSdk", ((StringBuilder)localObject1).toString());
          return false;
        }
        if ((q != null) && (r != null)) {
          return true;
        }
        paramBoolean = TbsShareManager.isThirdPartyApp(paramContext);
        if (paramBoolean)
        {
          if (TbsShareManager.j(paramContext))
          {
            localObject1 = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar");
          }
          else
          {
            TbsCoreLoadStat.getInstance().a(paramContext, 304, new Throwable("isShareTbsCoreAvailable false!"));
            return false;
          }
        }
        else {
          localObject1 = new File(p.a().q(paramContext), "tbs_sdk_extension_dex.jar");
        }
        paramBoolean = ((File)localObject1).exists();
        if (!paramBoolean)
        {
          try
          {
            TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
            i2 = p.a().i(paramContext);
            paramBoolean = new File(((File)localObject1).getParentFile(), "tbs_jars_fusion_dex.jar").exists();
            if (paramBoolean)
            {
              if (i2 > 0)
              {
                localObject1 = TbsCoreLoadStat.getInstance();
                i1 = 4131;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("tbs_sdk_extension_dex not exist(with fusion dex)!");
                ((StringBuilder)localObject3).append(i2);
                localObject3 = new Exception(((StringBuilder)localObject3).toString());
                ((TbsCoreLoadStat)localObject1).a(paramContext, i1, (Throwable)localObject3);
                return false;
              }
              localObject1 = TbsCoreLoadStat.getInstance();
              i1 = 4132;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("tbs_sdk_extension_dex not exist(with fusion dex)!");
              ((StringBuilder)localObject3).append(i2);
              localObject3 = new Exception(((StringBuilder)localObject3).toString());
              continue;
            }
            if (i2 > 0)
            {
              localObject1 = TbsCoreLoadStat.getInstance();
              i1 = 4121;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("tbs_sdk_extension_dex not exist(without fusion dex)!");
              ((StringBuilder)localObject3).append(i2);
              localObject3 = new Exception(((StringBuilder)localObject3).toString());
              continue;
            }
            localObject1 = TbsCoreLoadStat.getInstance();
            i1 = 4122;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("tbs_sdk_extension_dex not exist(without fusion dex)!");
            ((StringBuilder)localObject3).append(i2);
            localObject3 = new Exception(((StringBuilder)localObject3).toString());
            continue;
            if (TbsShareManager.getHostCorePathAppDefined() == null) {
              continue;
            }
          }
          catch (Throwable localThrowable1)
          {
            localThrowable1.printStackTrace();
            return false;
          }
        }
        else
        {
          localObject3 = TbsShareManager.getHostCorePathAppDefined();
          continue;
        }
        localObject3 = ((File)localObject3).getAbsolutePath();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("QbSdk init optDirExtension #1 is ");
        ((StringBuilder)localObject4).append((String)localObject3);
        TbsLog.i("QbSdk", ((StringBuilder)localObject4).toString());
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("new DexLoader #1 dexFile is ");
        ((StringBuilder)localObject4).append(localThrowable1.getAbsolutePath());
        TbsLog.i("QbSdk", ((StringBuilder)localObject4).toString());
        x.a().a(paramContext);
        l.a(paramContext);
        localObject4 = localThrowable1.getParent();
        String str = localThrowable1.getAbsolutePath();
        Object localObject5 = getSettings();
        q = new DexLoader((String)localObject4, paramContext, new String[] { str }, (String)localObject3, (Map)localObject5).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        loadTBSSDKExtension(paramContext, localThrowable1.getParent());
        Object localObject2 = r;
        localObject3 = b.a;
        localObject4 = b.b;
        str = b.c;
        localObject5 = b.d;
        i.a(localObject2, "putInfo", new Class[] { String.class, String.class, String.class, String.class }, new Object[] { localObject3, localObject4, str, localObject5 });
        i.a(r, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
        return true;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("QbSdk init Throwable: ");
        ((StringBuilder)localObject3).append(Log.getStackTraceString(localThrowable2));
        TbsLog.e("QbSdk", ((StringBuilder)localObject3).toString());
        TbsCoreLoadStat.getInstance().a(paramContext, 306, localThrowable2);
        return false;
      }
      label1264:
      int i1 = 0;
    }
  }
  
  /* Error */
  static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 555	com/tencent/smtt/sdk/TbsPVConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsPVConfig;
    //   4: invokevirtual 558	com/tencent/smtt/sdk/TbsPVConfig:getDisabledCoreVersion	()I
    //   7: istore_3
    //   8: iconst_0
    //   9: istore 7
    //   11: iload_3
    //   12: ifeq +25 -> 37
    //   15: iload_3
    //   16: invokestatic 335	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   19: aload_0
    //   20: invokevirtual 511	com/tencent/smtt/sdk/p:i	(Landroid/content/Context;)I
    //   23: if_icmpne +14 -> 37
    //   26: ldc_w 313
    //   29: ldc_w 560
    //   32: invokestatic 317	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_0
    //   38: invokestatic 467	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   41: ifeq +22 -> 63
    //   44: aload_0
    //   45: invokestatic 562	com/tencent/smtt/sdk/TbsShareManager:i	(Landroid/content/Context;)Z
    //   48: ifne +15 -> 63
    //   51: invokestatic 322	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   54: aload_0
    //   55: sipush 302
    //   58: invokevirtual 565	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;I)V
    //   61: iconst_0
    //   62: ireturn
    //   63: aload_0
    //   64: iload_1
    //   65: invokestatic 567	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Z)Z
    //   68: ifne +14 -> 82
    //   71: ldc_w 313
    //   74: ldc_w 569
    //   77: invokestatic 317	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: iconst_0
    //   81: ireturn
    //   82: getstatic 169	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   85: astore 8
    //   87: iconst_1
    //   88: istore_2
    //   89: iconst_1
    //   90: istore 5
    //   92: aload 8
    //   94: ldc_w 571
    //   97: iconst_1
    //   98: anewarray 173	java/lang/Class
    //   101: dup
    //   102: iconst_0
    //   103: getstatic 428	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   106: aastore
    //   107: iconst_1
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: ldc_w 429
    //   116: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: aastore
    //   120: invokestatic 182	com/tencent/smtt/utils/i:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   123: astore 9
    //   125: aload 9
    //   127: ifnull +1063 -> 1190
    //   130: aload 9
    //   132: instanceof 200
    //   135: ifeq +19 -> 154
    //   138: aload 9
    //   140: checkcast 200	java/lang/String
    //   143: ldc_w 573
    //   146: invokevirtual 577	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   149: ifeq +5 -> 154
    //   152: iconst_0
    //   153: ireturn
    //   154: aload 9
    //   156: instanceof 177
    //   159: ifne +65 -> 224
    //   162: invokestatic 322	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   165: astore 8
    //   167: new 299	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   174: astore 10
    //   176: aload 10
    //   178: ldc 82
    //   180: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 10
    //   186: aload 9
    //   188: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 8
    //   194: aload_0
    //   195: sipush 330
    //   198: new 324	java/lang/Throwable
    //   201: dup
    //   202: aload 10
    //   204: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokespecial 325	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   210: invokevirtual 328	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   213: ldc_w 582
    //   216: ldc_w 584
    //   219: invokestatic 317	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: iconst_0
    //   223: ireturn
    //   224: aload 9
    //   226: checkcast 177	android/os/Bundle
    //   229: astore 8
    //   231: aload 8
    //   233: invokevirtual 587	android/os/Bundle:isEmpty	()Z
    //   236: ifeq +65 -> 301
    //   239: invokestatic 322	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   242: astore 8
    //   244: new 299	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   251: astore 10
    //   253: aload 10
    //   255: ldc 82
    //   257: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 10
    //   263: aload 9
    //   265: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 8
    //   271: aload_0
    //   272: sipush 331
    //   275: new 324	java/lang/Throwable
    //   278: dup
    //   279: aload 10
    //   281: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokespecial 325	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   287: invokevirtual 328	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   290: ldc_w 582
    //   293: ldc_w 589
    //   296: invokestatic 317	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: iconst_0
    //   300: ireturn
    //   301: aload 8
    //   303: ldc_w 591
    //   306: iconst_m1
    //   307: invokevirtual 594	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   310: istore_3
    //   311: goto +47 -> 358
    //   314: astore 9
    //   316: new 299	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   323: astore 10
    //   325: aload 10
    //   327: ldc_w 596
    //   330: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 10
    //   336: aload 9
    //   338: invokevirtual 597	java/lang/Exception:toString	()Ljava/lang/String;
    //   341: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: ldc_w 313
    //   348: aload 10
    //   350: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 317	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: iconst_m1
    //   357: istore_3
    //   358: iload_3
    //   359: ifne +8 -> 367
    //   362: iconst_1
    //   363: istore_1
    //   364: goto +5 -> 369
    //   367: iconst_0
    //   368: istore_1
    //   369: aload_0
    //   370: invokestatic 467	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   373: ifeq +83 -> 456
    //   376: aload_0
    //   377: invokestatic 472	com/tencent/smtt/sdk/TbsShareManager:d	(Landroid/content/Context;)I
    //   380: invokestatic 600	com/tencent/smtt/sdk/f:a	(I)V
    //   383: aload_0
    //   384: invokestatic 472	com/tencent/smtt/sdk/TbsShareManager:d	(Landroid/content/Context;)I
    //   387: invokestatic 603	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   390: putstatic 292	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   393: getstatic 292	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   396: invokevirtual 604	java/lang/String:length	()I
    //   399: iconst_5
    //   400: if_icmpne +37 -> 437
    //   403: new 299	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   410: astore 9
    //   412: aload 9
    //   414: ldc 198
    //   416: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload 9
    //   422: getstatic 292	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   425: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 9
    //   431: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: putstatic 292	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   437: getstatic 292	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   440: invokevirtual 604	java/lang/String:length	()I
    //   443: bipush 6
    //   445: if_icmpeq +267 -> 712
    //   448: ldc 82
    //   450: putstatic 292	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   453: goto +259 -> 712
    //   456: getstatic 609	android/os/Build$VERSION:SDK_INT	I
    //   459: istore 4
    //   461: iload 4
    //   463: bipush 12
    //   465: if_icmplt +19 -> 484
    //   468: aload 8
    //   470: ldc_w 611
    //   473: ldc 198
    //   475: invokevirtual 615	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   478: putstatic 292	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   481: goto +33 -> 514
    //   484: aload 8
    //   486: ldc_w 611
    //   489: invokevirtual 618	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   492: putstatic 292	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   495: getstatic 292	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   498: ifnonnull +16 -> 514
    //   501: ldc 198
    //   503: putstatic 292	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   506: goto +8 -> 514
    //   509: ldc 198
    //   511: putstatic 292	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   514: getstatic 292	com/tencent/smtt/sdk/QbSdk:p	Ljava/lang/String;
    //   517: invokestatic 621	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   520: putstatic 469	com/tencent/smtt/sdk/QbSdk:o	I
    //   523: goto +7 -> 530
    //   526: iconst_0
    //   527: putstatic 469	com/tencent/smtt/sdk/QbSdk:o	I
    //   530: getstatic 469	com/tencent/smtt/sdk/QbSdk:o	I
    //   533: invokestatic 600	com/tencent/smtt/sdk/f:a	(I)V
    //   536: getstatic 469	com/tencent/smtt/sdk/QbSdk:o	I
    //   539: istore 6
    //   541: iload 6
    //   543: ifne +25 -> 568
    //   546: invokestatic 322	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   549: aload_0
    //   550: sipush 307
    //   553: new 324	java/lang/Throwable
    //   556: dup
    //   557: ldc_w 623
    //   560: invokespecial 325	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   563: invokevirtual 328	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   566: iconst_0
    //   567: ireturn
    //   568: iload 6
    //   570: ifle +15 -> 585
    //   573: iload 5
    //   575: istore 4
    //   577: iload 6
    //   579: sipush 25442
    //   582: if_icmple +22 -> 604
    //   585: getstatic 469	com/tencent/smtt/sdk/QbSdk:o	I
    //   588: sipush 25472
    //   591: if_icmpne +10 -> 601
    //   594: iload 5
    //   596: istore 4
    //   598: goto +6 -> 604
    //   601: iconst_0
    //   602: istore 4
    //   604: iload 4
    //   606: ifeq +106 -> 712
    //   609: new 299	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   616: astore 8
    //   618: aload 8
    //   620: ldc_w 625
    //   623: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: pop
    //   627: aload 8
    //   629: getstatic 469	com/tencent/smtt/sdk/QbSdk:o	I
    //   632: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: ldc_w 627
    //   639: aload 8
    //   641: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 317	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: invokestatic 335	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   650: aload_0
    //   651: invokevirtual 338	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   654: invokestatic 632	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   657: invokestatic 322	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   660: astore 8
    //   662: new 299	java/lang/StringBuilder
    //   665: dup
    //   666: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   669: astore 9
    //   671: aload 9
    //   673: ldc_w 625
    //   676: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload 9
    //   682: getstatic 469	com/tencent/smtt/sdk/QbSdk:o	I
    //   685: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload 8
    //   691: aload_0
    //   692: sipush 307
    //   695: new 324	java/lang/Throwable
    //   698: dup
    //   699: aload 9
    //   701: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokespecial 325	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   707: invokevirtual 328	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   710: iconst_0
    //   711: ireturn
    //   712: aload 8
    //   714: ldc_w 634
    //   717: invokevirtual 638	android/os/Bundle:getStringArray	(Ljava/lang/String;)[Ljava/lang/String;
    //   720: putstatic 640	com/tencent/smtt/sdk/QbSdk:t	[Ljava/lang/String;
    //   723: getstatic 640	com/tencent/smtt/sdk/QbSdk:t	[Ljava/lang/String;
    //   726: instanceof 641
    //   729: ifne +58 -> 787
    //   732: invokestatic 322	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   735: astore 8
    //   737: new 299	java/lang/StringBuilder
    //   740: dup
    //   741: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   744: astore 9
    //   746: aload 9
    //   748: ldc_w 643
    //   751: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: aload 9
    //   757: getstatic 640	com/tencent/smtt/sdk/QbSdk:t	[Ljava/lang/String;
    //   760: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   763: pop
    //   764: aload 8
    //   766: aload_0
    //   767: sipush 307
    //   770: new 324	java/lang/Throwable
    //   773: dup
    //   774: aload 9
    //   776: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokespecial 325	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   782: invokevirtual 328	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   785: iconst_0
    //   786: ireturn
    //   787: aload 8
    //   789: ldc_w 645
    //   792: invokevirtual 618	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   795: putstatic 646	com/tencent/smtt/sdk/QbSdk:d	Ljava/lang/String;
    //   798: aconst_null
    //   799: astore 9
    //   801: aload 9
    //   803: astore 8
    //   805: iload_3
    //   806: ifeq +36 -> 842
    //   809: getstatic 169	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   812: ldc_w 648
    //   815: iconst_0
    //   816: anewarray 173	java/lang/Class
    //   819: iconst_0
    //   820: anewarray 4	java/lang/Object
    //   823: invokestatic 182	com/tencent/smtt/utils/i:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   826: astore 8
    //   828: goto +14 -> 842
    //   831: astore 8
    //   833: aload 8
    //   835: invokevirtual 279	java/lang/Exception:printStackTrace	()V
    //   838: aload 9
    //   840: astore 8
    //   842: iload_3
    //   843: bipush 254
    //   845: if_icmpeq +203 -> 1048
    //   848: iload_3
    //   849: iconst_m1
    //   850: if_icmpeq +78 -> 928
    //   853: iload_3
    //   854: ifeq +317 -> 1171
    //   857: invokestatic 322	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   860: astore 9
    //   862: new 299	java/lang/StringBuilder
    //   865: dup
    //   866: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   869: astore 10
    //   871: aload 10
    //   873: ldc_w 650
    //   876: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: pop
    //   880: aload 10
    //   882: aload 8
    //   884: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   887: pop
    //   888: aload 10
    //   890: ldc_w 652
    //   893: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload 10
    //   899: iload_3
    //   900: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   903: pop
    //   904: aload 9
    //   906: aload_0
    //   907: sipush 415
    //   910: new 324	java/lang/Throwable
    //   913: dup
    //   914: aload 10
    //   916: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   919: invokespecial 325	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   922: invokevirtual 328	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   925: goto +246 -> 1171
    //   928: aload 8
    //   930: instanceof 284
    //   933: ifeq +60 -> 993
    //   936: invokestatic 322	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   939: astore 9
    //   941: aload 8
    //   943: checkcast 284	java/lang/Integer
    //   946: invokevirtual 655	java/lang/Integer:intValue	()I
    //   949: istore_3
    //   950: new 299	java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   957: astore 10
    //   959: aload 10
    //   961: ldc_w 650
    //   964: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: pop
    //   968: aload 10
    //   970: aload 8
    //   972: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   975: pop
    //   976: new 324	java/lang/Throwable
    //   979: dup
    //   980: aload 10
    //   982: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   985: invokespecial 325	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   988: astore 8
    //   990: goto +172 -> 1162
    //   993: invokestatic 322	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   996: astore 9
    //   998: new 299	java/lang/StringBuilder
    //   1001: dup
    //   1002: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   1005: astore 10
    //   1007: aload 10
    //   1009: ldc_w 650
    //   1012: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: pop
    //   1016: aload 10
    //   1018: aload 8
    //   1020: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1023: pop
    //   1024: aload 9
    //   1026: aload_0
    //   1027: sipush 307
    //   1030: new 324	java/lang/Throwable
    //   1033: dup
    //   1034: aload 10
    //   1036: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1039: invokespecial 325	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   1042: invokevirtual 328	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   1045: goto +126 -> 1171
    //   1048: aload 8
    //   1050: instanceof 284
    //   1053: ifeq +60 -> 1113
    //   1056: invokestatic 322	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   1059: astore 9
    //   1061: aload 8
    //   1063: checkcast 284	java/lang/Integer
    //   1066: invokevirtual 655	java/lang/Integer:intValue	()I
    //   1069: istore_3
    //   1070: new 299	java/lang/StringBuilder
    //   1073: dup
    //   1074: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   1077: astore 10
    //   1079: aload 10
    //   1081: ldc_w 650
    //   1084: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: pop
    //   1088: aload 10
    //   1090: aload 8
    //   1092: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1095: pop
    //   1096: new 324	java/lang/Throwable
    //   1099: dup
    //   1100: aload 10
    //   1102: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1105: invokespecial 325	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   1108: astore 8
    //   1110: goto +52 -> 1162
    //   1113: invokestatic 322	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   1116: astore 9
    //   1118: sipush 404
    //   1121: istore_3
    //   1122: new 299	java/lang/StringBuilder
    //   1125: dup
    //   1126: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   1129: astore 10
    //   1131: aload 10
    //   1133: ldc_w 650
    //   1136: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1139: pop
    //   1140: aload 10
    //   1142: aload 8
    //   1144: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1147: pop
    //   1148: new 324	java/lang/Throwable
    //   1151: dup
    //   1152: aload 10
    //   1154: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1157: invokespecial 325	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   1160: astore 8
    //   1162: aload 9
    //   1164: aload_0
    //   1165: iload_3
    //   1166: aload 8
    //   1168: invokevirtual 328	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   1171: goto +244 -> 1415
    //   1174: astore 8
    //   1176: invokestatic 322	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   1179: aload_0
    //   1180: sipush 329
    //   1183: aload 8
    //   1185: invokevirtual 328	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   1188: iconst_0
    //   1189: ireturn
    //   1190: getstatic 169	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   1193: astore 8
    //   1195: getstatic 428	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   1198: astore 9
    //   1200: invokestatic 659	com/tencent/smtt/sdk/a:a	()I
    //   1203: istore_3
    //   1204: aload 8
    //   1206: ldc_w 661
    //   1209: iconst_1
    //   1210: anewarray 173	java/lang/Class
    //   1213: dup
    //   1214: iconst_0
    //   1215: aload 9
    //   1217: aastore
    //   1218: iconst_1
    //   1219: anewarray 4	java/lang/Object
    //   1222: dup
    //   1223: iconst_0
    //   1224: iload_3
    //   1225: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1228: aastore
    //   1229: invokestatic 182	com/tencent/smtt/utils/i:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1232: astore 8
    //   1234: aload 8
    //   1236: ifnull +166 -> 1402
    //   1239: aload 8
    //   1241: instanceof 200
    //   1244: ifeq +19 -> 1263
    //   1247: aload 8
    //   1249: checkcast 200	java/lang/String
    //   1252: ldc_w 573
    //   1255: invokevirtual 577	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1258: ifeq +5 -> 1263
    //   1261: iconst_0
    //   1262: ireturn
    //   1263: iload 7
    //   1265: istore_1
    //   1266: aload 8
    //   1268: instanceof 431
    //   1271: ifeq +144 -> 1415
    //   1274: invokestatic 663	com/tencent/smtt/sdk/f:c	()I
    //   1277: putstatic 469	com/tencent/smtt/sdk/QbSdk:o	I
    //   1280: aload_0
    //   1281: invokestatic 663	com/tencent/smtt/sdk/f:c	()I
    //   1284: invokestatic 664	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;I)Z
    //   1287: istore 7
    //   1289: aload 8
    //   1291: checkcast 431	java/lang/Boolean
    //   1294: astore_0
    //   1295: aload_0
    //   1296: invokevirtual 434	java/lang/Boolean:booleanValue	()Z
    //   1299: ifeq +13 -> 1312
    //   1302: iload 7
    //   1304: ifne +8 -> 1312
    //   1307: iload_2
    //   1308: istore_1
    //   1309: goto +5 -> 1314
    //   1312: iconst_0
    //   1313: istore_1
    //   1314: iload_1
    //   1315: ifne +85 -> 1400
    //   1318: ldc_w 582
    //   1321: ldc_w 666
    //   1324: invokestatic 317	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1327: new 299	java/lang/StringBuilder
    //   1330: dup
    //   1331: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   1334: astore 8
    //   1336: aload 8
    //   1338: ldc_w 668
    //   1341: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: pop
    //   1345: aload 8
    //   1347: iload 7
    //   1349: invokevirtual 671	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1352: pop
    //   1353: ldc_w 582
    //   1356: aload 8
    //   1358: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1361: invokestatic 673	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1364: new 299	java/lang/StringBuilder
    //   1367: dup
    //   1368: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   1371: astore 8
    //   1373: aload 8
    //   1375: ldc_w 675
    //   1378: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: pop
    //   1382: aload 8
    //   1384: aload_0
    //   1385: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1388: pop
    //   1389: ldc_w 582
    //   1392: aload 8
    //   1394: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1397: invokestatic 673	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1400: iload_1
    //   1401: ireturn
    //   1402: invokestatic 322	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   1405: aload_0
    //   1406: sipush 308
    //   1409: invokevirtual 565	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;I)V
    //   1412: iload 7
    //   1414: istore_1
    //   1415: iload_1
    //   1416: ifne +12 -> 1428
    //   1419: ldc_w 582
    //   1422: ldc_w 677
    //   1425: invokestatic 317	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1428: iload_1
    //   1429: ireturn
    //   1430: astore 9
    //   1432: goto -923 -> 509
    //   1435: astore 9
    //   1437: goto -911 -> 526
    //   1440: astore_0
    //   1441: iconst_0
    //   1442: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1443	0	paramContext	Context
    //   0	1443	1	paramBoolean1	boolean
    //   0	1443	2	paramBoolean2	boolean
    //   7	1218	3	i1	int
    //   459	146	4	i2	int
    //   90	505	5	i3	int
    //   539	44	6	i4	int
    //   9	1404	7	bool	boolean
    //   85	742	8	localObject1	Object
    //   831	3	8	localException1	Exception
    //   840	327	8	localObject2	Object
    //   1174	10	8	localThrowable	Throwable
    //   1193	200	8	localObject3	Object
    //   123	141	9	localObject4	Object
    //   314	23	9	localException2	Exception
    //   410	806	9	localObject5	Object
    //   1430	1	9	localException3	Exception
    //   1435	1	9	localNumberFormatException	java.lang.NumberFormatException
    //   174	979	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   301	311	314	java/lang/Exception
    //   809	828	831	java/lang/Exception
    //   712	723	1174	java/lang/Throwable
    //   456	461	1430	java/lang/Exception
    //   468	481	1430	java/lang/Exception
    //   484	506	1430	java/lang/Exception
    //   514	523	1435	java/lang/NumberFormatException
    //   787	798	1440	java/lang/Exception
  }
  
  protected static String b()
  {
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b()))
    {
      localObject = ((x)localObject).c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
      if ((localObject != null) && ((localObject instanceof String))) {
        return (String)localObject;
      }
    }
    return null;
  }
  
  static boolean b(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      if (paramContext.getApplicationInfo().packageName.contains("com.tencent.portfolio"))
      {
        TbsLog.i("QbSdk", "clearPluginConfigFile #1");
        localObject = TbsDownloadConfig.getInstance(paramContext).mPreferences.getString("app_versionname", null);
        String str = paramContext.getPackageManager().getPackageInfo("com.tencent.portfolio", 0).versionName;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearPluginConfigFile oldAppVersionName is ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" newAppVersionName is ");
        localStringBuilder.append(str);
        TbsLog.i("QbSdk", localStringBuilder.toString());
        if ((localObject != null) && (!((String)localObject).contains(str)))
        {
          paramContext = paramContext.getSharedPreferences("plugin_setting", 0);
          if (paramContext != null)
          {
            paramContext = paramContext.edit();
            paramContext.clear();
            paramContext.commit();
            TbsLog.i("QbSdk", "clearPluginConfigFile done");
          }
        }
      }
      return true;
    }
    catch (Throwable paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearPluginConfigFile error is ");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      TbsLog.i("QbSdk", ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  private static boolean c(Context paramContext)
  {
    try
    {
      if (q != null) {
        return true;
      }
      Object localObject2 = p.a().q(paramContext);
      if (localObject2 == null)
      {
        TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
        return false;
      }
      boolean bool = TbsShareManager.isThirdPartyApp(paramContext);
      if (bool)
      {
        if (TbsShareManager.j(paramContext))
        {
          localObject1 = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar");
        }
        else
        {
          TbsCoreLoadStat.getInstance().a(paramContext, 304);
          return false;
        }
      }
      else {
        localObject1 = new File(p.a().q(paramContext), "tbs_sdk_extension_dex.jar");
      }
      if (!((File)localObject1).exists())
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
        return false;
      }
      if (TbsShareManager.getHostCorePathAppDefined() != null) {
        localObject2 = TbsShareManager.getHostCorePathAppDefined();
      } else {
        localObject2 = ((File)localObject2).getAbsolutePath();
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("QbSdk init optDirExtension #3 is ");
      ((StringBuilder)localObject3).append((String)localObject2);
      TbsLog.i("QbSdk", ((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("new DexLoader #4 dexFile is ");
      ((StringBuilder)localObject3).append(((File)localObject1).getAbsolutePath());
      TbsLog.i("QbSdk", ((StringBuilder)localObject3).toString());
      x.a().a(paramContext);
      l.a(paramContext);
      localObject3 = ((File)localObject1).getParent();
      String str = ((File)localObject1).getAbsolutePath();
      Map localMap = getSettings();
      q = new DexLoader((String)localObject3, paramContext, new String[] { str }, (String)localObject2, localMap).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      loadTBSSDKExtension(paramContext, ((File)localObject1).getParent());
      paramContext = r;
      localObject1 = b.a;
      localObject2 = b.b;
      localObject3 = b.c;
      str = b.d;
      i.a(paramContext, "putInfo", new Class[] { String.class, String.class, String.class, String.class }, new Object[] { localObject1, localObject2, localObject3, str });
      i.a(r, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
      return true;
    }
    catch (Throwable paramContext)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initForX5DisableConfig sys WebView: ");
      ((StringBuilder)localObject1).append(Log.getStackTraceString(paramContext));
      TbsLog.e("QbSdk", ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  public static boolean canLoadVideo(Context paramContext)
  {
    Object localObject = i.a(r, "canLoadVideo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) });
    TbsCoreLoadStat localTbsCoreLoadStat;
    int i1;
    if (localObject != null)
    {
      if (((Boolean)localObject).booleanValue()) {
        break label70;
      }
      localTbsCoreLoadStat = TbsCoreLoadStat.getInstance();
      i1 = 313;
    }
    else
    {
      localTbsCoreLoadStat = TbsCoreLoadStat.getInstance();
      i1 = 314;
    }
    localTbsCoreLoadStat.a(paramContext, i1);
    label70:
    if (localObject == null) {
      return false;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public static boolean canLoadX5(Context paramContext)
  {
    return a(paramContext, false, false);
  }
  
  public static boolean canLoadX5FirstTimeThirdApp(Context paramContext)
  {
    try
    {
      if ((paramContext.getApplicationInfo().packageName.contains("com.moji.mjweather")) && (Build.VERSION.SDK_INT == 19)) {
        return true;
      }
      if (q == null)
      {
        localObject1 = p.a().q(paramContext);
        if (localObject1 == null)
        {
          TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
          return false;
        }
        File localFile = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar");
        if (!localFile.exists())
        {
          TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
          return false;
        }
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
          localObject1 = TbsShareManager.getHostCorePathAppDefined();
        } else {
          localObject1 = ((File)localObject1).getAbsolutePath();
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("QbSdk init optDirExtension #2 is ");
        ((StringBuilder)localObject2).append((String)localObject1);
        TbsLog.i("QbSdk", ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("new DexLoader #2 dexFile is ");
        ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
        TbsLog.i("QbSdk", ((StringBuilder)localObject2).toString());
        x.a().a(paramContext);
        l.a(paramContext);
        localObject2 = localFile.getParent();
        String str = localFile.getAbsolutePath();
        Map localMap = getSettings();
        q = new DexLoader((String)localObject2, paramContext, new String[] { str }, (String)localObject1, localMap).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        if (r == null)
        {
          if ((TbsShareManager.e(paramContext) == null) && (TbsShareManager.getHostCorePathAppDefined() == null))
          {
            TbsLogReport.getInstance(paramContext.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
            return false;
          }
          loadTBSSDKExtension(paramContext, localFile.getParent());
        }
      }
      paramContext = i.a(r, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
      if ((paramContext != null) && ((paramContext instanceof Boolean)))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("canLoadX5FirstTimeThirdApp sys WebView: ");
      ((StringBuilder)localObject1).append(Log.getStackTraceString(paramContext));
      TbsLog.e("QbSdk", ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  /* Error */
  public static boolean canOpenWebPlus(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 119	com/tencent/smtt/sdk/QbSdk:x	I
    //   3: ifne +9 -> 12
    //   6: invokestatic 659	com/tencent/smtt/sdk/a:a	()I
    //   9: putstatic 119	com/tencent/smtt/sdk/QbSdk:x	I
    //   12: new 299	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   19: astore 7
    //   21: aload 7
    //   23: ldc_w 816
    //   26: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 7
    //   32: getstatic 119	com/tencent/smtt/sdk/QbSdk:x	I
    //   35: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc_w 313
    //   42: aload 7
    //   44: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 363	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: getstatic 609	android/os/Build$VERSION:SDK_INT	I
    //   53: istore_1
    //   54: iconst_0
    //   55: istore_2
    //   56: iload_1
    //   57: bipush 7
    //   59: if_icmplt +492 -> 551
    //   62: getstatic 119	com/tencent/smtt/sdk/QbSdk:x	I
    //   65: getstatic 121	com/tencent/smtt/sdk/QbSdk:y	I
    //   68: if_icmpge +5 -> 73
    //   71: iconst_0
    //   72: ireturn
    //   73: aload_0
    //   74: ifnonnull +5 -> 79
    //   77: iconst_0
    //   78: ireturn
    //   79: aconst_null
    //   80: astore 9
    //   82: aconst_null
    //   83: astore 7
    //   85: aconst_null
    //   86: astore 11
    //   88: aconst_null
    //   89: astore 10
    //   91: new 818	java/io/BufferedInputStream
    //   94: dup
    //   95: new 820	java/io/FileInputStream
    //   98: dup
    //   99: new 342	java/io/File
    //   102: dup
    //   103: invokestatic 335	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   106: aload_0
    //   107: invokevirtual 338	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   110: ldc_w 822
    //   113: invokespecial 347	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   116: invokespecial 824	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   119: invokespecial 827	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   122: astore 8
    //   124: new 829	java/util/Properties
    //   127: dup
    //   128: invokespecial 830	java/util/Properties:<init>	()V
    //   131: astore 7
    //   133: aload 7
    //   135: aload 8
    //   137: invokevirtual 833	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   140: aload 7
    //   142: ldc_w 835
    //   145: invokevirtual 838	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore 11
    //   150: aload 7
    //   152: ldc_w 840
    //   155: invokevirtual 838	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 12
    //   160: aload 11
    //   162: invokestatic 621	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   165: istore_1
    //   166: aload 12
    //   168: invokestatic 621	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   171: istore_3
    //   172: getstatic 843	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   175: invokestatic 621	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   178: istore 4
    //   180: iload 4
    //   182: iload_1
    //   183: if_icmpgt +257 -> 440
    //   186: iload 4
    //   188: iload_3
    //   189: if_icmpge +6 -> 195
    //   192: goto +248 -> 440
    //   195: aload 7
    //   197: ldc_w 611
    //   200: invokevirtual 838	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   203: invokestatic 621	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   206: istore_3
    //   207: aload 8
    //   209: invokevirtual 846	java/io/BufferedInputStream:close	()V
    //   212: aload 10
    //   214: astore 7
    //   216: new 820	java/io/FileInputStream
    //   219: dup
    //   220: new 342	java/io/File
    //   223: dup
    //   224: aload_0
    //   225: invokestatic 848	com/tencent/smtt/sdk/p:s	(Landroid/content/Context;)Ljava/io/File;
    //   228: ldc_w 850
    //   231: invokespecial 347	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   234: invokespecial 824	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   237: astore 8
    //   239: new 829	java/util/Properties
    //   242: dup
    //   243: invokespecial 830	java/util/Properties:<init>	()V
    //   246: astore 7
    //   248: aload 7
    //   250: aload 8
    //   252: invokevirtual 833	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   255: aload 7
    //   257: ldc_w 852
    //   260: invokevirtual 838	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   263: invokestatic 621	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   266: istore 4
    //   268: aload 7
    //   270: ldc_w 854
    //   273: invokevirtual 838	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   276: invokestatic 621	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   279: istore 5
    //   281: iload_2
    //   282: istore_1
    //   283: iload_3
    //   284: ldc_w 855
    //   287: if_icmpeq +89 -> 376
    //   290: iload 4
    //   292: ldc_w 855
    //   295: if_icmpne +298 -> 593
    //   298: iload_2
    //   299: istore_1
    //   300: goto +76 -> 376
    //   303: iload_2
    //   304: istore_1
    //   305: iload_3
    //   306: iload 4
    //   308: if_icmpne +68 -> 376
    //   311: iload 5
    //   313: ifle +17 -> 330
    //   316: iload 5
    //   318: aload_0
    //   319: invokestatic 856	com/tencent/smtt/utils/b:d	(Landroid/content/Context;)I
    //   322: if_icmpeq +8 -> 330
    //   325: iload_2
    //   326: istore_1
    //   327: goto +49 -> 376
    //   330: iload_2
    //   331: istore_1
    //   332: aload 7
    //   334: ldc_w 858
    //   337: invokevirtual 838	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   340: invokestatic 861	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   343: ifeq +33 -> 376
    //   346: aload_0
    //   347: invokevirtual 804	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   350: invokestatic 718	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   353: getfield 722	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   356: ldc_w 863
    //   359: iconst_0
    //   360: invokeinterface 867 3 0
    //   365: istore 6
    //   367: iload_2
    //   368: istore_1
    //   369: iload 6
    //   371: ifne +5 -> 376
    //   374: iconst_1
    //   375: istore_1
    //   376: aload 8
    //   378: invokevirtual 870	java/io/InputStream:close	()V
    //   381: goto +43 -> 424
    //   384: astore_0
    //   385: goto +43 -> 428
    //   388: aload 8
    //   390: astore_0
    //   391: goto +11 -> 402
    //   394: astore_0
    //   395: aload 7
    //   397: astore 8
    //   399: goto +29 -> 428
    //   402: aload_0
    //   403: astore 7
    //   405: ldc_w 313
    //   408: ldc_w 872
    //   411: invokestatic 363	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   414: aload_0
    //   415: ifnull +7 -> 422
    //   418: aload_0
    //   419: invokevirtual 870	java/io/InputStream:close	()V
    //   422: iconst_1
    //   423: istore_1
    //   424: iload_1
    //   425: iconst_1
    //   426: ixor
    //   427: ireturn
    //   428: aload 8
    //   430: ifnull +8 -> 438
    //   433: aload 8
    //   435: invokevirtual 870	java/io/InputStream:close	()V
    //   438: aload_0
    //   439: athrow
    //   440: new 299	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   447: astore_0
    //   448: aload_0
    //   449: ldc_w 874
    //   452: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload_0
    //   457: iload 4
    //   459: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: ldc_w 313
    //   466: aload_0
    //   467: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 363	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   473: aload 8
    //   475: invokevirtual 846	java/io/BufferedInputStream:close	()V
    //   478: iconst_0
    //   479: ireturn
    //   480: astore_0
    //   481: goto +58 -> 539
    //   484: astore 7
    //   486: aload 8
    //   488: astore_0
    //   489: aload 7
    //   491: astore 8
    //   493: goto +16 -> 509
    //   496: astore_0
    //   497: aload 7
    //   499: astore 8
    //   501: goto +38 -> 539
    //   504: astore 8
    //   506: aload 11
    //   508: astore_0
    //   509: aload_0
    //   510: astore 7
    //   512: aload 8
    //   514: invokevirtual 523	java/lang/Throwable:printStackTrace	()V
    //   517: aload_0
    //   518: astore 7
    //   520: ldc_w 313
    //   523: ldc_w 876
    //   526: invokestatic 363	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   529: aload_0
    //   530: ifnull +7 -> 537
    //   533: aload_0
    //   534: invokevirtual 846	java/io/BufferedInputStream:close	()V
    //   537: iconst_0
    //   538: ireturn
    //   539: aload 8
    //   541: ifnull +8 -> 549
    //   544: aload 8
    //   546: invokevirtual 846	java/io/BufferedInputStream:close	()V
    //   549: aload_0
    //   550: athrow
    //   551: iconst_0
    //   552: ireturn
    //   553: astore 7
    //   555: goto -343 -> 212
    //   558: astore_0
    //   559: aload 9
    //   561: astore_0
    //   562: goto -160 -> 402
    //   565: astore_0
    //   566: goto -178 -> 388
    //   569: astore_0
    //   570: goto -146 -> 424
    //   573: astore_0
    //   574: goto -152 -> 422
    //   577: astore 7
    //   579: goto -141 -> 438
    //   582: astore_0
    //   583: iconst_0
    //   584: ireturn
    //   585: astore_0
    //   586: iconst_0
    //   587: ireturn
    //   588: astore 7
    //   590: goto -41 -> 549
    //   593: iload_3
    //   594: iload 4
    //   596: if_icmple -293 -> 303
    //   599: iload_2
    //   600: istore_1
    //   601: goto -225 -> 376
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	604	0	paramContext	Context
    //   53	548	1	i1	int
    //   55	545	2	i2	int
    //   171	426	3	i3	int
    //   178	419	4	i4	int
    //   279	44	5	i5	int
    //   365	5	6	bool	boolean
    //   19	385	7	localObject1	Object
    //   484	14	7	localThrowable1	Throwable
    //   510	9	7	localContext	Context
    //   553	1	7	localException1	Exception
    //   577	1	7	localException2	Exception
    //   588	1	7	localException3	Exception
    //   122	378	8	localObject2	Object
    //   504	41	8	localThrowable2	Throwable
    //   80	480	9	localObject3	Object
    //   89	124	10	localObject4	Object
    //   86	421	11	str1	String
    //   158	9	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   239	281	384	finally
    //   316	325	384	finally
    //   332	367	384	finally
    //   216	239	394	finally
    //   405	414	394	finally
    //   124	180	480	finally
    //   195	207	480	finally
    //   440	473	480	finally
    //   124	180	484	java/lang/Throwable
    //   195	207	484	java/lang/Throwable
    //   440	473	484	java/lang/Throwable
    //   91	124	496	finally
    //   512	517	496	finally
    //   520	529	496	finally
    //   91	124	504	java/lang/Throwable
    //   207	212	553	java/lang/Exception
    //   216	239	558	java/lang/Throwable
    //   239	281	565	java/lang/Throwable
    //   316	325	565	java/lang/Throwable
    //   332	367	565	java/lang/Throwable
    //   376	381	569	java/lang/Exception
    //   418	422	573	java/lang/Exception
    //   433	438	577	java/lang/Exception
    //   473	478	582	java/lang/Exception
    //   533	537	585	java/lang/Exception
    //   544	549	588	java/lang/Exception
  }
  
  public static boolean canUseVideoFeatrue(Context paramContext, int paramInt)
  {
    paramContext = r;
    Class localClass = Integer.TYPE;
    boolean bool2 = false;
    paramContext = i.a(paramContext, "canUseVideoFeatrue", new Class[] { localClass }, new Object[] { Integer.valueOf(paramInt) });
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if ((paramContext instanceof Boolean)) {
        bool1 = ((Boolean)paramContext).booleanValue();
      }
    }
    return bool1;
  }
  
  public static boolean checkApkExist(Context paramContext, String paramString)
  {
    if (paramString != null) {
      if ("".equals(paramString)) {
        return false;
      }
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
    return false;
  }
  
  public static boolean checkContentProviderPrivilage(Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.getApplicationInfo().targetSdkVersion >= 24)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 24)
        {
          bool1 = bool2;
          if (!"com.tencent.mobileqq".equals(paramContext.getApplicationInfo().packageName)) {
            try
            {
              ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), "android.support.v4.content.FileProvider");
              bool1 = TextUtils.isEmpty(paramContext.getPackageManager().getProviderInfo(localComponentName, 0).authority);
              if (!bool1) {
                return true;
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              PackageManager localPackageManager = paramContext.getPackageManager();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramContext.getApplicationInfo().packageName);
              localStringBuilder.append(".provider");
              paramContext = localPackageManager.resolveContentProvider(localStringBuilder.toString(), 128);
              if (paramContext == null) {
                Log.e("QbSdk", "Must declare com.tencent.smtt.utils.FileProvider in AndroidManifest above Android 7.0,please view document in x5.tencent.com");
              }
              if (paramContext != null) {
                return true;
              }
              bool1 = false;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static void checkTbsValidity(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    if (!l.b(paramContext))
    {
      TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedBy checkTbsValidity");
      TbsCoreLoadStat.getInstance().a(paramContext, 419);
      forceSysWebView();
    }
  }
  
  public static void clear(Context paramContext) {}
  
  public static void clearAllDefaultBrowser(Context paramContext)
  {
    paramContext.getSharedPreferences("tbs_file_open_dialog_config", 0).edit().clear().commit();
  }
  
  public static void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("clearAllWebViewCache(");
    ((StringBuilder)localObject1).append(paramContext);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(")");
    TbsLog.i("QbSdk", ((StringBuilder)localObject1).toString());
    int i1 = 0;
    try
    {
      localObject1 = new DtX5WebView(paramContext).getWebViewClientExtension();
      if (localObject1 == null) {
        break label149;
      }
      try
      {
        localObject1 = x.a();
        if ((localObject1 != null) && (((x)localObject1).b())) {
          ((x)localObject1).c().a(paramContext, paramBoolean);
        }
        i1 = 1;
      }
      catch (Throwable localThrowable1)
      {
        i1 = 1;
      }
      localStringBuilder = new StringBuilder();
    }
    catch (Throwable localThrowable2)
    {
      i1 = 0;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("clearAllWebViewCache exception 2 -- ");
    localStringBuilder.append(Log.getStackTraceString(localThrowable2));
    TbsLog.e("QbSdk", localStringBuilder.toString());
    label149:
    if (i1 != 0)
    {
      TbsLog.i("QbSdk", "is_in_x5_mode --> no need to clear system webview!");
      return;
    }
    try
    {
      localObject2 = new DtWebView(paramContext);
      if (Build.VERSION.SDK_INT >= 11)
      {
        ((android.webkit.WebView)localObject2).removeJavascriptInterface("searchBoxJavaBridge_");
        ((android.webkit.WebView)localObject2).removeJavascriptInterface("accessibility");
        ((android.webkit.WebView)localObject2).removeJavascriptInterface("accessibilityTraversal");
      }
      ((android.webkit.WebView)localObject2).clearCache(true);
      if (paramBoolean)
      {
        CookieSyncManager.createInstance(paramContext);
        CookieManager.getInstance().removeAllCookie();
      }
      WebViewDatabase.getInstance(paramContext).clearUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearHttpAuthUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearFormData();
      WebStorage.getInstance().deleteAllData();
      WebIconDatabase.getInstance().removeAllIcons();
      return;
    }
    catch (Throwable paramContext)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("clearAllWebViewCache exception 1 -- ");
      ((StringBuilder)localObject2).append(Log.getStackTraceString(paramContext));
      TbsLog.e("QbSdk", ((StringBuilder)localObject2).toString());
    }
  }
  
  public static void clearDefaultBrowser(Context paramContext, String paramString)
  {
    Object localObject = paramContext.getSharedPreferences("tbs_file_open_dialog_config", 0);
    paramString = e.d(paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "*/*";
    }
    paramString = ((SharedPreferences)localObject).edit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_tbs_picked_default_browser_");
    ((StringBuilder)localObject).append(paramContext);
    paramString.remove(((StringBuilder)localObject).toString()).commit();
  }
  
  public static String closeNetLogAndSavaToLocal()
  {
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b())) {
      localObject = ((x)localObject).c().b();
    }
    try
    {
      localObject = ((DexLoader)localObject).invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "closeNetLogAndSavaToLocal", new Class[0], new Object[0]);
      if ((localObject != null) && ((localObject instanceof String)))
      {
        localObject = (String)localObject;
        return localObject;
      }
      return "";
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static void continueLoadSo(Context paramContext)
  {
    if (("com.tencent.mm".equals(getCurrentProcessName(paramContext))) && (WebView.mWebViewCreated)) {
      i.a(r, "continueLoadSo", new Class[0], new Object[0]);
    }
  }
  
  public static boolean createMiniQBShortCut(Context paramContext, String paramString1, String paramString2, Drawable paramDrawable)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    if (isMiniQBShortCutExist(paramContext, paramString1, paramString2) == true) {
      return false;
    }
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      Bitmap localBitmap = null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      }
      paramDrawable = localx.c().b();
      TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
      paramContext = paramDrawable.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[] { Context.class, String.class, String.class, Bitmap.class }, new Object[] { paramContext, paramString1, paramString2, localBitmap });
      paramString1 = new StringBuilder();
      paramString1.append("qbsdk after createMiniQBShortCut ret: ");
      paramString1.append(paramContext);
      TbsLog.e("QbSdk", paramString1.toString());
      if (paramContext != null) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private static void d(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: putstatic 135	com/tencent/smtt/sdk/QbSdk:C	Z
    //   4: iconst_0
    //   5: istore 5
    //   7: getstatic 609	android/os/Build$VERSION:SDK_INT	I
    //   10: istore_1
    //   11: iload_1
    //   12: bipush 11
    //   14: if_icmplt +16 -> 30
    //   17: aload_0
    //   18: ldc_w 1070
    //   21: iconst_4
    //   22: invokevirtual 752	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   25: astore 7
    //   27: goto +13 -> 40
    //   30: aload_0
    //   31: ldc_w 1070
    //   34: iconst_0
    //   35: invokevirtual 752	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   38: astore 7
    //   40: aload 7
    //   42: ldc_w 1072
    //   45: iconst_m1
    //   46: invokeinterface 1073 3 0
    //   51: istore_3
    //   52: iload_3
    //   53: iflt +18 -> 71
    //   56: iload_3
    //   57: iconst_1
    //   58: iadd
    //   59: istore_3
    //   60: iload_3
    //   61: iconst_4
    //   62: if_icmple +4 -> 66
    //   65: return
    //   66: iload_3
    //   67: istore_1
    //   68: goto +5 -> 73
    //   71: iconst_m1
    //   72: istore_1
    //   73: invokestatic 335	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   76: aload_0
    //   77: invokevirtual 511	com/tencent/smtt/sdk/p:i	(Landroid/content/Context;)I
    //   80: istore_2
    //   81: iload_2
    //   82: ifgt +4 -> 86
    //   85: return
    //   86: iload_3
    //   87: iconst_4
    //   88: if_icmpgt +28 -> 116
    //   91: aload 7
    //   93: invokeinterface 756 1 0
    //   98: ldc_w 1072
    //   101: iload_3
    //   102: invokeinterface 1076 3 0
    //   107: invokeinterface 764 1 0
    //   112: pop
    //   113: goto +3 -> 116
    //   116: aload 7
    //   118: ldc_w 1078
    //   121: iconst_m1
    //   122: invokeinterface 1073 3 0
    //   127: istore 6
    //   129: aload 7
    //   131: astore 8
    //   133: iload_1
    //   134: istore_3
    //   135: iload_2
    //   136: istore 4
    //   138: iload 6
    //   140: iflt +105 -> 245
    //   143: aload 7
    //   145: invokeinterface 756 1 0
    //   150: astore 8
    //   152: iload 6
    //   154: iconst_1
    //   155: iadd
    //   156: istore_3
    //   157: aload 8
    //   159: ldc_w 1078
    //   162: iload_3
    //   163: invokeinterface 1076 3 0
    //   168: invokeinterface 764 1 0
    //   173: pop
    //   174: goto +86 -> 260
    //   177: astore 8
    //   179: goto +15 -> 194
    //   182: astore 8
    //   184: goto +8 -> 192
    //   187: astore 8
    //   189: aconst_null
    //   190: astore 7
    //   192: iconst_m1
    //   193: istore_1
    //   194: iconst_m1
    //   195: istore_2
    //   196: new 299	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   203: astore 9
    //   205: aload 9
    //   207: ldc_w 1080
    //   210: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 9
    //   216: aload 8
    //   218: invokestatic 403	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   221: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: ldc_w 313
    //   228: aload 9
    //   230: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 317	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: iload_2
    //   237: istore 4
    //   239: iload_1
    //   240: istore_3
    //   241: aload 7
    //   243: astore 8
    //   245: iconst_m1
    //   246: istore 6
    //   248: iload 4
    //   250: istore_2
    //   251: iload_3
    //   252: istore_1
    //   253: aload 8
    //   255: astore 7
    //   257: iload 6
    //   259: istore_3
    //   260: iload_3
    //   261: iconst_3
    //   262: if_icmple +208 -> 470
    //   265: aload 7
    //   267: ldc_w 1082
    //   270: iconst_m1
    //   271: invokeinterface 1073 3 0
    //   276: istore_1
    //   277: aload 7
    //   279: invokeinterface 756 1 0
    //   284: astore 7
    //   286: iload_1
    //   287: iload_2
    //   288: if_icmpne +76 -> 364
    //   291: invokestatic 335	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   294: aload_0
    //   295: invokevirtual 338	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   298: iconst_0
    //   299: invokestatic 1085	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   302: aload_0
    //   303: invokestatic 1090	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   306: invokevirtual 1092	com/tencent/smtt/sdk/m:a	()Ljava/io/File;
    //   309: astore_0
    //   310: aload_0
    //   311: ifnull +8 -> 319
    //   314: aload_0
    //   315: iconst_0
    //   316: invokestatic 1085	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   319: new 299	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   326: astore_0
    //   327: aload_0
    //   328: ldc_w 1094
    //   331: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_0
    //   336: iload_2
    //   337: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_0
    //   342: ldc_w 1096
    //   345: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload_0
    //   350: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: astore_0
    //   354: ldc_w 313
    //   357: aload_0
    //   358: invokestatic 317	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: goto +47 -> 408
    //   364: new 299	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   371: astore_0
    //   372: aload_0
    //   373: ldc_w 1098
    //   376: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_0
    //   381: iload_2
    //   382: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload_0
    //   387: ldc_w 1100
    //   390: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload_0
    //   395: iload_1
    //   396: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload_0
    //   401: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: astore_0
    //   405: goto -51 -> 354
    //   408: aload 7
    //   410: ldc_w 1102
    //   413: iload_1
    //   414: invokeinterface 1076 3 0
    //   419: pop
    //   420: aload 7
    //   422: invokeinterface 764 1 0
    //   427: pop
    //   428: return
    //   429: astore_0
    //   430: new 299	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   437: astore 7
    //   439: aload 7
    //   441: ldc_w 1104
    //   444: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload 7
    //   450: aload_0
    //   451: invokestatic 403	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   454: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: ldc_w 313
    //   461: aload 7
    //   463: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 317	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: return
    //   470: iload_1
    //   471: ifle +40 -> 511
    //   474: iload_1
    //   475: iconst_3
    //   476: if_icmpgt +35 -> 511
    //   479: ldc_w 313
    //   482: ldc_w 1106
    //   485: invokestatic 363	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   488: invokestatic 368	com/tencent/smtt/sdk/x:a	()Lcom/tencent/smtt/sdk/x;
    //   491: aload_0
    //   492: aconst_null
    //   493: invokevirtual 1109	com/tencent/smtt/sdk/x:a	(Landroid/content/Context;Lcom/tencent/smtt/sdk/o;)V
    //   496: ldc_w 313
    //   499: ldc_w 1111
    //   502: invokestatic 363	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   505: iload 5
    //   507: istore_1
    //   508: goto +5 -> 513
    //   511: iconst_m1
    //   512: istore_1
    //   513: aload 7
    //   515: ldc_w 1078
    //   518: iconst_m1
    //   519: invokeinterface 1073 3 0
    //   524: istore_2
    //   525: iload_2
    //   526: ifle +70 -> 596
    //   529: aload 7
    //   531: invokeinterface 756 1 0
    //   536: ldc_w 1078
    //   539: iload_2
    //   540: iconst_1
    //   541: isub
    //   542: invokeinterface 1076 3 0
    //   547: invokeinterface 764 1 0
    //   552: pop
    //   553: goto +43 -> 596
    //   556: astore_0
    //   557: new 299	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   564: astore 7
    //   566: aload 7
    //   568: ldc_w 1113
    //   571: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload 7
    //   577: aload_0
    //   578: invokestatic 403	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   581: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: ldc_w 313
    //   588: aload 7
    //   590: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 317	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   596: new 299	java/lang/StringBuilder
    //   599: dup
    //   600: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   603: astore_0
    //   604: aload_0
    //   605: ldc_w 1115
    //   608: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload_0
    //   613: iload_1
    //   614: invokevirtual 479	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: ldc_w 313
    //   621: aload_0
    //   622: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 363	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: return
    //   629: astore 8
    //   631: goto -435 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	634	0	paramContext	Context
    //   10	604	1	i1	int
    //   80	462	2	i2	int
    //   51	212	3	i3	int
    //   136	113	4	i4	int
    //   5	501	5	i5	int
    //   127	131	6	i6	int
    //   25	564	7	localObject1	Object
    //   131	27	8	localObject2	Object
    //   177	1	8	localThrowable1	Throwable
    //   182	1	8	localThrowable2	Throwable
    //   187	30	8	localThrowable3	Throwable
    //   243	11	8	localObject3	Object
    //   629	1	8	localThrowable4	Throwable
    //   203	26	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   73	81	177	java/lang/Throwable
    //   40	52	182	java/lang/Throwable
    //   7	11	187	java/lang/Throwable
    //   17	27	187	java/lang/Throwable
    //   30	40	187	java/lang/Throwable
    //   265	286	429	java/lang/Throwable
    //   291	310	429	java/lang/Throwable
    //   314	319	429	java/lang/Throwable
    //   319	354	429	java/lang/Throwable
    //   354	361	429	java/lang/Throwable
    //   364	405	429	java/lang/Throwable
    //   408	428	429	java/lang/Throwable
    //   513	525	556	java/lang/Throwable
    //   529	553	556	java/lang/Throwable
    //   91	113	629	java/lang/Throwable
    //   116	129	629	java/lang/Throwable
    //   143	152	629	java/lang/Throwable
    //   157	174	629	java/lang/Throwable
  }
  
  public static boolean deleteMiniQBShortCut(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      if (localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 }) != null) {
        return true;
      }
    }
    return false;
  }
  
  public static void disAllowThirdAppDownload()
  {
    c = false;
  }
  
  public static void disableAutoCreateX5Webview()
  {
    j = false;
  }
  
  public static void fileInfoDetect(Context paramContext, String paramString, android.webkit.ValueCallback<String> paramValueCallback)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      try
      {
        localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[] { Context.class, String.class, android.webkit.ValueCallback.class }, new Object[] { paramContext, paramString, paramValueCallback });
        return;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static void forceSysWebView()
  {
    b = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SysWebViewForcedByOuter: ");
    localStringBuilder.append(Log.getStackTraceString(new Throwable()));
    u = localStringBuilder.toString();
    TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
  }
  
  public static long getApkFileSize(Context paramContext)
  {
    long l1 = 0L;
    if (paramContext != null) {
      l1 = TbsDownloadConfig.getInstance(paramContext.getApplicationContext()).mPreferences.getLong("tbs_apkfilesize", 0L);
    }
    return l1;
  }
  
  /* Error */
  public static String getCurrentProcessName(Context paramContext)
  {
    // Byte code:
    //   0: new 820	java/io/FileInputStream
    //   3: dup
    //   4: ldc_w 1144
    //   7: invokespecial 1145	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: aload_3
    //   12: astore_0
    //   13: sipush 256
    //   16: newarray byte
    //   18: astore 4
    //   20: iconst_0
    //   21: istore_1
    //   22: aload_3
    //   23: astore_0
    //   24: aload_3
    //   25: invokevirtual 1148	java/io/FileInputStream:read	()I
    //   28: istore_2
    //   29: iload_2
    //   30: ifle +25 -> 55
    //   33: aload_3
    //   34: astore_0
    //   35: iload_1
    //   36: aload 4
    //   38: arraylength
    //   39: if_icmpge +16 -> 55
    //   42: aload 4
    //   44: iload_1
    //   45: iload_2
    //   46: i2b
    //   47: bastore
    //   48: iload_1
    //   49: iconst_1
    //   50: iadd
    //   51: istore_1
    //   52: goto -30 -> 22
    //   55: iload_1
    //   56: ifle +36 -> 92
    //   59: aload_3
    //   60: astore_0
    //   61: new 200	java/lang/String
    //   64: dup
    //   65: aload 4
    //   67: iconst_0
    //   68: iload_1
    //   69: ldc_w 1150
    //   72: invokespecial 1153	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   75: astore 4
    //   77: aload_3
    //   78: invokevirtual 1154	java/io/FileInputStream:close	()V
    //   81: aload 4
    //   83: areturn
    //   84: astore_0
    //   85: aload_0
    //   86: invokevirtual 1155	java/io/IOException:printStackTrace	()V
    //   89: aload 4
    //   91: areturn
    //   92: aload_3
    //   93: invokevirtual 1154	java/io/FileInputStream:close	()V
    //   96: aconst_null
    //   97: areturn
    //   98: astore 4
    //   100: goto +13 -> 113
    //   103: astore_3
    //   104: aconst_null
    //   105: astore_0
    //   106: goto +32 -> 138
    //   109: astore 4
    //   111: aconst_null
    //   112: astore_3
    //   113: aload_3
    //   114: astore_0
    //   115: aload 4
    //   117: invokevirtual 523	java/lang/Throwable:printStackTrace	()V
    //   120: aload_3
    //   121: ifnull +14 -> 135
    //   124: aload_3
    //   125: invokevirtual 1154	java/io/FileInputStream:close	()V
    //   128: aconst_null
    //   129: areturn
    //   130: astore_0
    //   131: aload_0
    //   132: invokevirtual 1155	java/io/IOException:printStackTrace	()V
    //   135: aconst_null
    //   136: areturn
    //   137: astore_3
    //   138: aload_0
    //   139: ifnull +15 -> 154
    //   142: aload_0
    //   143: invokevirtual 1154	java/io/FileInputStream:close	()V
    //   146: goto +8 -> 154
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 1155	java/io/IOException:printStackTrace	()V
    //   154: goto +5 -> 159
    //   157: aload_3
    //   158: athrow
    //   159: goto -2 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramContext	Context
    //   21	48	1	i1	int
    //   28	18	2	i2	int
    //   10	83	3	localFileInputStream	java.io.FileInputStream
    //   103	1	3	localObject1	Object
    //   112	13	3	localObject2	Object
    //   137	21	3	localObject3	Object
    //   18	72	4	localObject4	Object
    //   98	1	4	localThrowable1	Throwable
    //   109	7	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   77	81	84	java/io/IOException
    //   13	20	98	java/lang/Throwable
    //   24	29	98	java/lang/Throwable
    //   35	42	98	java/lang/Throwable
    //   61	77	98	java/lang/Throwable
    //   0	11	103	finally
    //   0	11	109	java/lang/Throwable
    //   92	96	130	java/io/IOException
    //   124	128	130	java/io/IOException
    //   13	20	137	finally
    //   24	29	137	finally
    //   35	42	137	finally
    //   61	77	137	finally
    //   115	120	137	finally
    //   142	146	149	java/io/IOException
  }
  
  public static String[] getDexLoaderFileList(Context paramContext1, Context paramContext2, String paramString)
  {
    String[] arrayOfString = t;
    boolean bool = arrayOfString instanceof String[];
    int i1 = 0;
    if (bool)
    {
      int i2 = arrayOfString.length;
      paramContext1 = new String[i2];
      while (i1 < i2)
      {
        paramContext2 = new StringBuilder();
        paramContext2.append(paramString);
        paramContext2.append(t[i1]);
        paramContext1[i1] = paramContext2.toString();
        i1 += 1;
      }
      return paramContext1;
    }
    paramContext1 = i.a(r, "getJarFiles", new Class[] { Context.class, Context.class, String.class }, new Object[] { paramContext1, paramContext2, paramString });
    if (!(paramContext1 instanceof String[]))
    {
      paramContext1 = new String[1];
      paramContext1[0] = "";
    }
    return (String[])paramContext1;
  }
  
  public static boolean getDownloadWithoutWifi()
  {
    return F;
  }
  
  public static boolean getIsSysWebViewForcedByOuter()
  {
    return b;
  }
  
  public static boolean getJarFilesAndLibraryPath(Context paramContext)
  {
    Object localObject = r;
    if (localObject == null) {}
    for (paramContext = "getJarFilesAndLibraryPath sExtensionObj is null";; paramContext = ((StringBuilder)localObject).toString())
    {
      TbsLog.i("QbSdk", paramContext);
      return false;
      localObject = (Bundle)i.a(localObject, "canLoadX5CoreAndNotLoadSo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(43973) });
      if (localObject != null) {
        break;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getJarFilesAndLibraryPath bundle is null and coreverison is ");
      ((StringBuilder)localObject).append(p.a().a(true, paramContext));
    }
    t = ((Bundle)localObject).getStringArray("tbs_jarfiles");
    d = ((Bundle)localObject).getString("tbs_librarypath");
    return true;
  }
  
  public static String getMiniQBVersion(Context paramContext)
  {
    x localx = x.a();
    localx.a(paramContext, null);
    if ((localx != null) && (localx.b())) {
      return localx.c().f();
    }
    return null;
  }
  
  public static boolean getOnlyDownload()
  {
    return k;
  }
  
  public static String getQQBuildNumber()
  {
    return A;
  }
  
  public static Map<String, Object> getSettings()
  {
    return n;
  }
  
  public static boolean getTBSInstalling()
  {
    return G;
  }
  
  public static String getTID()
  {
    return z;
  }
  
  public static File getTbsFolderDir(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      if (b.d())
      {
        File localFile = paramContext.getDir("tbs_64", 0);
        return localFile;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramContext.getDir("tbs", 0);
  }
  
  public static String getTbsResourcesPath(Context paramContext)
  {
    return TbsShareManager.g(paramContext);
  }
  
  public static int getTbsSdkVersion()
  {
    return 43973;
  }
  
  public static int getTbsVersion(Context paramContext)
  {
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      return TbsShareManager.a(paramContext, false);
    }
    return p.a().i(paramContext);
  }
  
  public static int getTbsVersionForCrash(Context paramContext)
  {
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      return TbsShareManager.a(paramContext, false);
    }
    int i1 = p.a().j(paramContext);
    if ((i1 == 0) && (m.a(paramContext).c() == 3)) {
      reset(paramContext);
    }
    return i1;
  }
  
  public static int getTmpDirTbsVersion(Context paramContext)
  {
    if (m.a(paramContext).c() == 2) {
      return p.a().e(paramContext, 0);
    }
    if (m.a(paramContext).b("copy_status") == 1) {
      return p.a().e(paramContext, 1);
    }
    return 0;
  }
  
  public static void initBuglyAsync(boolean paramBoolean)
  {
    i = paramBoolean;
  }
  
  public static void initForinitAndNotLoadSo(Context paramContext)
  {
    if (q == null)
    {
      Object localObject1 = p.a().q(paramContext);
      if (localObject1 == null) {}
      for (paramContext = "QbSdk initForinitAndNotLoadSo optDir == null";; paramContext = "QbSdk initForinitAndNotLoadSo dexFile.exists()=false")
      {
        Log.e("QbSdk", paramContext);
        return;
        localObject2 = new File((File)localObject1, "tbs_sdk_extension_dex.jar");
        if (((File)localObject2).exists()) {
          break;
        }
      }
      localObject1 = ((File)localObject1).getAbsolutePath();
      x.a().a(paramContext);
      l.a(paramContext);
      String str = ((File)localObject2).getParent();
      Object localObject2 = ((File)localObject2).getAbsolutePath();
      Map localMap = getSettings();
      q = new DexLoader(str, paramContext, new String[] { localObject2 }, (String)localObject1, localMap).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
    }
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    Map localMap = n;
    if (localMap == null)
    {
      n = paramMap;
      return;
    }
    try
    {
      localMap.putAll(paramMap);
      return;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public static void initX5Environment(Context paramContext, QbSdk.PreInitCallback paramPreInitCallback)
  {
    TbsLog.initIfNeed(paramContext);
    if (paramContext == null)
    {
      TbsLog.e("QbSdk", "initX5Environment,context=null");
      return;
    }
    b(paramContext);
    E = new QbSdk.3(paramContext, paramPreInitCallback);
    if (TbsShareManager.isThirdPartyApp(paramContext))
    {
      p localp = p.a();
      boolean bool;
      if (f.a == 0) {
        bool = true;
      } else {
        bool = false;
      }
      localp.b(paramContext, bool);
    }
    TbsDownloader.needDownload(paramContext, false, false, true, new QbSdk.4(paramContext, paramPreInitCallback));
  }
  
  public static boolean installLocalQbApk(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    f localf = f.a(true);
    localf.a(paramContext, false, false, null);
    if ((localf != null) && (localf.b())) {
      return localf.a().a(paramContext, paramString1, paramString2, paramBundle);
    }
    return false;
  }
  
  public static boolean intentDispatch(WebView paramWebView, Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramWebView == null) {
      return false;
    }
    Object localObject = paramString1;
    if (paramString1.startsWith("mttbrowser://miniqb/ch=icon?"))
    {
      Context localContext = paramWebView.getContext();
      int i1 = paramString1.indexOf("url=");
      if (i1 > 0) {
        paramIntent = paramString1.substring(i1 + 4);
      } else {
        paramIntent = null;
      }
      localObject = new HashMap();
      try
      {
        paramString1 = localContext.getApplicationInfo().packageName;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = "unknown";
      }
      ((HashMap)localObject).put("ChannelID", paramString1);
      ((HashMap)localObject).put("PosID", "14004");
      if ("miniqb://home".equals(paramIntent)) {
        paramString1 = "qb://navicard/addCard?cardId=168&cardName=168";
      } else {
        paramString1 = paramIntent;
      }
      if (MttLoader.loadUrl(localContext, paramString1, (HashMap)localObject, "QbSdk.startMiniQBToLoadUrl", null) == 0) {
        break label185;
      }
      paramString1 = x.a();
      localObject = paramIntent;
      if (paramString1 != null)
      {
        localObject = paramIntent;
        if (paramString1.b())
        {
          localObject = paramIntent;
          if (paramString1.c().a(localContext, paramIntent, null, paramString2, null) == 0) {
            return true;
          }
        }
      }
    }
    paramWebView.loadUrl((String)localObject);
    label185:
    return false;
  }
  
  public static boolean isInDefaultBrowser(Context paramContext, String paramString)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("tbs_file_open_dialog_config", 0);
    paramString = e.d(paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "*/*";
    }
    paramString = new StringBuilder();
    paramString.append("key_tbs_picked_default_browser_");
    paramString.append(paramContext);
    return localSharedPreferences.contains(paramString.toString());
  }
  
  public static boolean isMiniQBShortCutExist(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    paramString2 = x.a();
    if ((paramString2 != null) && (paramString2.b()))
    {
      paramString1 = paramString2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString1 });
      if (paramString1 != null)
      {
        paramContext = Boolean.valueOf(false);
        if ((paramString1 instanceof Boolean)) {
          paramContext = (Boolean)paramString1;
        }
        return paramContext.booleanValue();
      }
    }
    return false;
  }
  
  public static boolean isNeedInitX5FirstTime()
  {
    return w;
  }
  
  public static boolean isSuportOpenFile(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramInt != 1) {
      if (paramInt != 2) {
        return false;
      }
    }
    for (List localList = Arrays.asList(new String[] { "rar", "zip", "tar", "bz2", "gz", "7z", "doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub", "chm", "html", "htm", "xml", "mht", "url", "ini", "log", "bat", "php", "js", "lrc", "jpg", "jpeg", "png", "gif", "bmp", "tiff", "webp", "mp3", "m4a", "aac", "amr", "wav", "ogg", "mid", "ra", "wma", "mpga", "ape", "flac", "RTSP", "RTP", "SDP", "RTMP", "mp4", "flv", "avi", "3gp", "3gpp", "webm", "ts", "ogv", "m3u8", "asf", "wmv", "rmvb", "rm", "f4v", "dat", "mov", "mpg", "mkv", "mpeg", "mpeg1", "mpeg2", "xvid", "dvd", "vcd", "vob", "divx" });; localList = Arrays.asList(new String[] { "doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub" })) {
      return localList.contains(paramString.toLowerCase());
    }
  }
  
  public static boolean isTbsCoreInited()
  {
    boolean bool2 = false;
    f localf = f.a(false);
    boolean bool1 = bool2;
    if (localf != null)
    {
      bool1 = bool2;
      if (localf.f()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isX5DisabledSync(Context paramContext)
  {
    if (m.a(paramContext).c() == 2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      return false;
    }
    if (!c(paramContext)) {
      return true;
    }
    int i1 = p.a().i(paramContext);
    paramContext = i.a(r, "isX5DisabledSync", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(i1), Integer.valueOf(43973) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    return true;
  }
  
  public static void loadTBSSDKExtension(Context paramContext, String paramString)
  {
    if (r != null) {
      return;
    }
    try
    {
      if (r != null) {
        return;
      }
      if (q == null) {
        TbsLog.i("QbSdk", "QbSdk loadTBSSDKExtension sExtensionClass is null");
      }
    }
    finally
    {
      Constructor localConstructor;
      int i1;
      for (;;)
      {
        label76:
        label376:
        throw paramContext;
      }
    }
    try
    {
      localConstructor = q.getConstructor(new Class[] { Context.class, Context.class, String.class, String.class, String.class });
      i1 = 1;
    }
    catch (Throwable localThrowable)
    {
      break label76;
      localObject = null;
      break label376;
    }
    localConstructor = null;
    i1 = 0;
    try
    {
      Context localContext;
      if (TbsShareManager.isThirdPartyApp(paramContext))
      {
        localContext = TbsShareManager.e(paramContext);
        if ((localContext == null) && (TbsShareManager.getHostCorePathAppDefined() == null))
        {
          TbsLogReport.getInstance(paramContext.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
          return;
        }
        localObject = paramContext;
        if (paramContext.getApplicationContext() != null) {
          localObject = paramContext.getApplicationContext();
        }
        if (i1 == 0) {
          if (localContext == null) {
            paramContext = q.getConstructor(new Class[] { Context.class, Context.class, String.class }).newInstance(new Object[] { localObject, localContext, TbsShareManager.getHostCorePathAppDefined(), paramString, null });
          }
        }
      }
      for (;;)
      {
        r = paramContext;
        break;
        paramContext = q.getConstructor(new Class[] { Context.class, Context.class }).newInstance(new Object[] { localObject, localContext });
        continue;
        paramContext = localConstructor.newInstance(new Object[] { localObject, localContext, TbsShareManager.getHostCorePathAppDefined(), paramString, null });
        continue;
        if (i1 == 0)
        {
          localConstructor = q.getConstructor(new Class[] { Context.class, Context.class });
          paramString = paramContext;
          if (paramContext.getApplicationContext() != null) {
            paramString = paramContext.getApplicationContext();
          }
          paramContext = localConstructor.newInstance(new Object[] { paramString, paramString });
        }
        else
        {
          if ((!"com.tencent.mm".equals(getCurrentProcessName(paramContext))) || (WebView.mWebViewCreated)) {
            break label483;
          }
          localObject = "notLoadSo";
          localContext = paramContext;
          if (paramContext.getApplicationContext() != null) {
            localContext = paramContext.getApplicationContext();
          }
          paramContext = localConstructor.newInstance(new Object[] { localContext, localContext, null, paramString, localObject });
        }
      }
      paramContext = finally;
    }
    catch (Throwable paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("throwable");
      paramString.append(Log.getStackTraceString(paramContext));
      TbsLog.e("QbSdk", paramString.toString());
      return;
    }
  }
  
  public static void openBrowserList(Context paramContext, String paramString, Bundle paramBundle, ValueCallback<String> paramValueCallback)
  {
    if (paramContext == null) {
      return;
    }
    String str;
    if (paramBundle != null) {
      str = paramBundle.getString("ChannelId");
    } else {
      str = "";
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setData(Uri.parse(paramString));
    paramString = e.d(paramString);
    isDefaultDialog = false;
    paramBundle = new d(paramContext, "选择其它应用打开", localIntent, paramBundle, paramValueCallback, paramString, str);
    paramString = paramBundle.a();
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ("com.tencent.mtt".equals(paramString))
      {
        localIntent.putExtra("ChannelID", paramContext.getApplicationContext().getPackageName());
        localIntent.putExtra("PosID", "4");
      }
      localIntent.setPackage(paramString);
      localIntent.putExtra("big_brother_source_key", str);
      paramContext.startActivity(localIntent);
      if (paramValueCallback == null) {
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append("default browser:");
      paramContext.append(paramString);
      paramContext = paramContext.toString();
    }
    else
    {
      if (!isDefaultDialog) {
        break label253;
      }
      new AlertDialog.Builder(paramContext).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new QbSdk.8()).show();
      if (paramValueCallback == null) {
        return;
      }
      paramContext = "can not open";
    }
    paramValueCallback.onReceiveValue(paramContext);
    return;
    label253:
    paramBundle.show();
    paramBundle.setOnDismissListener(new QbSdk.9(paramValueCallback));
  }
  
  public static void openBrowserList(Context paramContext, String paramString, ValueCallback<String> paramValueCallback)
  {
    openBrowserList(paramContext, paramString, null, paramValueCallback);
  }
  
  public static int openFileReader(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    TbsCoreLoadStat.getInstance().a(paramContext, 505);
    if (!checkContentProviderPrivilage(paramContext)) {
      return -5;
    }
    if (paramString != null)
    {
      String str = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length());
      Object localObject = str;
      if (str != null) {
        localObject = str.toLowerCase();
      }
      if ("apk".equalsIgnoreCase((String)localObject))
      {
        paramHashMap = new Intent("android.intent.action.VIEW");
        if ((paramContext != null) && (paramContext.getApplicationInfo().targetSdkVersion >= 24) && (Build.VERSION.SDK_INT >= 24)) {
          paramHashMap.addFlags(1);
        }
        paramString = FileProvider.a(paramContext, paramString);
        if (paramString == null)
        {
          paramValueCallback.onReceiveValue("uri failed");
          return -6;
        }
        paramHashMap.setDataAndType(paramString, "application/vnd.android.package-archive");
        paramContext.startActivity(paramHashMap);
        TbsCoreLoadStat.getInstance().a(paramContext, 506);
        Log.e("QbSdk", "open openFileReader ret = 4");
        return 4;
      }
      if (MttLoader.isBrowserInstalled(paramContext))
      {
        if (!a(paramContext, paramString, (String)localObject))
        {
          Log.e("QbSdk", "openFileReader open in QB isQBSupport: false  ret = 3");
          openFileReaderListWithQBDownload(paramContext, paramString, paramValueCallback);
          TbsCoreLoadStat.getInstance().a(paramContext, 507);
          return 3;
        }
        if (startQBForDoc(paramContext, paramString, 4, 0, (String)localObject, a(paramContext, paramHashMap)))
        {
          if (paramValueCallback != null) {
            paramValueCallback.onReceiveValue("open QB");
          }
          TbsCoreLoadStat.getInstance().a(paramContext, 507);
          Log.e("QbSdk", "open openFileReader open QB ret = 1");
          return 1;
        }
        localObject = "openFileReader startQBForDoc return false";
      }
      else
      {
        localObject = "openFileReader QQ browser not installed";
      }
      Log.d("QbSdk", (String)localObject);
      localObject = paramHashMap;
      if (paramHashMap == null) {
        localObject = new HashMap();
      }
      ((HashMap)localObject).put("local", "true");
      TbsLog.setWriteLogJIT(true);
      int i1 = startMiniQBToLoadUrl(paramContext, paramString, (HashMap)localObject, paramValueCallback);
      if (i1 != 0)
      {
        openFileReaderListWithQBDownload(paramContext, paramString, paramValueCallback);
        paramContext = TbsLogReport.getInstance(paramContext);
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(i1);
        paramContext.setLoadErrorCode(511, paramString.toString());
        return 3;
      }
      TbsCoreLoadStat.getInstance().a(paramContext, 510);
      return 2;
    }
    if (paramValueCallback != null) {
      paramValueCallback.onReceiveValue("filepath error");
    }
    TbsCoreLoadStat.getInstance().a(paramContext, 509);
    Log.e("QbSdk", "open openFileReader filepath error ret -1");
    return -1;
  }
  
  public static void openFileReaderListWithQBDownload(Context paramContext, String paramString, Bundle paramBundle, ValueCallback<String> paramValueCallback)
  {
    if ((paramContext != null) && (!paramContext.getApplicationInfo().packageName.equals("com.tencent.qim")))
    {
      if (paramContext.getApplicationInfo().packageName.equals("com.tencent.androidqqmail")) {
        return;
      }
      String str;
      if (paramBundle != null) {
        str = paramBundle.getString("ChannelId");
      } else {
        str = "";
      }
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addCategory("android.intent.category.DEFAULT");
      Object localObject = e.d(paramString);
      if ((paramContext != null) && (paramContext.getApplicationInfo().targetSdkVersion >= 24) && (Build.VERSION.SDK_INT >= 24)) {
        localIntent.addFlags(1);
      }
      Uri localUri = FileProvider.a(paramContext, paramString);
      if (localUri == null)
      {
        TbsLog.i("QbSdk", "openFileReaderListWithQBDownload,uri failed");
        paramValueCallback.onReceiveValue("uri failed");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openFileReaderListWithQBDownload,fileUri:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",mimeType:");
      localStringBuilder.append((String)localObject);
      TbsLog.i("QbSdk", localStringBuilder.toString());
      localIntent.setDataAndType(localUri, (String)localObject);
      isDefaultDialog = false;
      paramBundle = new d(paramContext, "选择其它应用打开", localIntent, paramBundle, paramValueCallback, (String)localObject, str);
      paramString = paramBundle.a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openFileReaderListWithQBDownload,defaultBrowser:");
      ((StringBuilder)localObject).append(paramString);
      TbsLog.i("QbSdk", ((StringBuilder)localObject).toString());
      if ((paramString != null) && (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("extraMenuEvent:")))
      {
        TbsLog.i("QbSdk", "openFileReaderListWithQBDownload, is default extra menu action");
        paramValueCallback.onReceiveValue(paramString);
        return;
      }
      if ((paramString != null) && (!TextUtils.isEmpty(paramString)) && (checkApkExist(paramContext, paramString)))
      {
        TbsLog.i("QbSdk", "openFileReaderListWithQBDownload, is default normal menu action");
        if ("com.tencent.mtt".equals(paramString))
        {
          localIntent.putExtra("ChannelID", paramContext.getApplicationContext().getPackageName());
          localIntent.putExtra("PosID", "4");
        }
        if (!TextUtils.isEmpty(str)) {
          localIntent.putExtra("big_brother_source_key", str);
        }
        localIntent.setPackage(paramString);
        paramContext.startActivity(localIntent);
        if (paramValueCallback != null)
        {
          paramContext = new StringBuilder();
          paramContext.append("default browser:");
          paramContext.append(paramString);
          paramValueCallback.onReceiveValue(paramContext.toString());
        }
      }
      else
      {
        if (("com.tencent.rtxlite".equalsIgnoreCase(paramContext.getApplicationContext().getPackageName())) && (isDefaultDialog))
        {
          new AlertDialog.Builder(paramContext).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new QbSdk.6()).show();
          return;
        }
        if (isDefaultDialog)
        {
          TbsLog.i("QbSdk", "isDefaultDialog=true");
          if (paramValueCallback != null)
          {
            TbsLog.i("QbSdk", "isDefaultDialog=true, can not open");
            paramContext = "can not open";
          }
        }
        else
        {
          for (;;)
          {
            paramValueCallback.onReceiveValue(paramContext);
            break;
            try
            {
              TbsLog.i("QbSdk", "isDefaultDialog=false,try to open dialog");
              paramBundle.show();
              paramBundle.setOnDismissListener(new QbSdk.7(paramValueCallback));
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
              TbsLog.i("QbSdk", "isDefaultDialog=false,try to open dialog, but failed");
              paramContext = "TbsReaderDialogClosed";
            }
          }
        }
        TbsLog.i("QbSdk", "unexpected return, dialogBuilder not show!");
      }
    }
  }
  
  public static void openFileReaderListWithQBDownload(Context paramContext, String paramString, ValueCallback<String> paramValueCallback)
  {
    openFileReaderListWithQBDownload(paramContext, paramString, null, paramValueCallback);
  }
  
  public static int openFileWithQB(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("open openFileReader startMiniQBToLoadUrl filepath = ");
    ((StringBuilder)localObject).append(paramString1);
    TbsLog.i("QbSdk", ((StringBuilder)localObject).toString());
    if (!checkContentProviderPrivilage(paramContext)) {
      return -1;
    }
    if (paramString1 != null)
    {
      localObject = paramString1.substring(paramString1.lastIndexOf(".") + 1).toLowerCase();
      if (MttLoader.isBrowserInstalled(paramContext))
      {
        if (!a(paramContext, paramString1, (String)localObject))
        {
          TbsLog.i("QbSdk", "openFileReader open in QB isQBSupport: false");
          return -2;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("ChannelID", paramContext.getApplicationContext().getApplicationInfo().processName);
        localHashMap.put("PosID", Integer.toString(4));
        if (MttLoader.openDocWithQb(paramContext, paramString1, 0, (String)localObject, paramString2, localHashMap, null)) {
          return 0;
        }
        TbsLog.i("QbSdk", "openFileReader startQBForDoc return false");
        return -3;
      }
      TbsLog.i("QbSdk", "openFileReader QQ browser not installed");
      return -4;
    }
    TbsLog.i("QbSdk", "open openFileReader filepath error");
    return -5;
  }
  
  public static void openNetLog(String paramString)
  {
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b())) {
      localObject = ((x)localObject).c().b();
    }
    try
    {
      ((DexLoader)localObject).invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "openNetLog", new Class[] { String.class }, new Object[] { paramString });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void preInit(Context paramContext)
  {
    try
    {
      preInit(paramContext, null);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void preInit(Context paramContext, QbSdk.PreInitCallback paramPreInitCallback)
  {
    try
    {
      TbsLog.initIfNeed(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preInit -- processName: ");
      localStringBuilder.append(getCurrentProcessName(paramContext));
      TbsLog.i("QbSdk", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("preInit -- stack: ");
      localStringBuilder.append(Log.getStackTraceString(new Throwable("#")));
      TbsLog.i("QbSdk", localStringBuilder.toString());
      l = a;
      if (!s)
      {
        paramContext = new QbSdk.2(paramContext, new QbSdk.1(Looper.getMainLooper(), paramPreInitCallback, paramContext));
        paramContext.setName("tbs_preinit");
        paramContext.setPriority(10);
        paramContext.start();
        s = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void reset(Context paramContext)
  {
    reset(paramContext, false);
  }
  
  public static void reset(Context paramContext, boolean paramBoolean)
  {
    TbsLog.e("QbSdk", "QbSdk reset!", true);
    for (;;)
    {
      try
      {
        TbsDownloader.stopDownload();
        if ((!paramBoolean) || (TbsShareManager.isThirdPartyApp(paramContext))) {
          break label194;
        }
        i1 = p.a().h(paramContext);
        int i2 = p.a().i(paramContext);
        if ((i1 <= 43300) || (i1 == i2)) {
          break label194;
        }
        i1 = 1;
        TbsDownloader.c(paramContext);
        FileUtil.a(getTbsFolderDir(paramContext), false, "core_share_decouple");
        TbsLog.i("QbSdk", "delete downloaded apk success", true);
        p.a.set(Integer.valueOf(0));
        localObject = new File(paramContext.getFilesDir(), "bugly_switch.txt");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        if (i1 != 0)
        {
          FileUtil.b(p.a().p(paramContext), p.a().f(paramContext, 0));
          p.a().b(paramContext);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QbSdk reset exception:");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramContext));
        TbsLog.e("QbSdk", ((StringBuilder)localObject).toString());
      }
      return;
      label194:
      int i1 = 0;
    }
  }
  
  public static void resetDecoupleCore(Context paramContext)
  {
    TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
    try
    {
      FileUtil.b(p.a().p(paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QbSdk resetDecoupleCore exception:");
      localStringBuilder.append(Log.getStackTraceString(paramContext));
      TbsLog.e("QbSdk", localStringBuilder.toString());
    }
  }
  
  public static void setCurrentID(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.startsWith("QQ:"))
    {
      paramString = paramString.substring(3);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0000000000000000".substring(paramString.length()));
      localStringBuilder.append(paramString);
      z = localStringBuilder.toString();
    }
  }
  
  public static void setDeviceInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    b.a = paramString1;
    b.b = paramString2;
    b.c = paramString3;
    b.d = paramString4;
  }
  
  public static void setDisableUnpreinitBySwitch(boolean paramBoolean)
  {
    B = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDisableUnpreinitBySwitch -- mDisableUnpreinitBySwitch is ");
    localStringBuilder.append(B);
    TbsLog.i("QbSdk", localStringBuilder.toString());
  }
  
  public static void setDisableUseHostBackupCoreBySwitch(boolean paramBoolean)
  {
    mDisableUseHostBackupCore = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is ");
    localStringBuilder.append(mDisableUseHostBackupCore);
    TbsLog.i("QbSdk", localStringBuilder.toString());
  }
  
  public static void setDownloadWithoutWifi(boolean paramBoolean)
  {
    F = paramBoolean;
  }
  
  public static void setNeedInitX5FirstTime(boolean paramBoolean)
  {
    w = paramBoolean;
  }
  
  public static void setNetLogEncryptionKey(String paramString)
  {
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b())) {
      localObject = ((x)localObject).c().b();
    }
    try
    {
      ((DexLoader)localObject).invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "setNetLogEncryptionKey", new Class[] { String.class }, new Object[] { paramString });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void setNewDnsHostList(String paramString)
  {
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b())) {
      localObject = ((x)localObject).c().b();
    }
    try
    {
      ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setNewDnsHostList", new Class[] { String.class }, new Object[] { paramString });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void setOnlyDownload(boolean paramBoolean)
  {
    k = paramBoolean;
  }
  
  public static void setQQBuildNumber(String paramString)
  {
    A = paramString;
  }
  
  public static void setTBSInstallingStatus(boolean paramBoolean)
  {
    G = paramBoolean;
  }
  
  public static void setTbsListener(TbsListener paramTbsListener)
  {
    D = paramTbsListener;
  }
  
  public static void setTbsLogClient(TbsLogClient paramTbsLogClient)
  {
    TbsLog.setTbsLogClient(paramTbsLogClient);
  }
  
  public static void setUploadCode(Context paramContext, int paramInt)
  {
    TbsDownloadUpload localTbsDownloadUpload;
    Integer localInteger;
    if ((paramInt >= 130) && (paramInt <= 139))
    {
      localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
      paramContext = localTbsDownloadUpload.a;
      localInteger = Integer.valueOf(paramInt);
    }
    for (String str = "tbs_needdownload_code";; str = "tbs_startdownload_code")
    {
      paramContext.put(str, localInteger);
      localTbsDownloadUpload.commit();
      return;
      if ((paramInt < 150) || (paramInt > 159)) {
        break;
      }
      localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
      paramContext = localTbsDownloadUpload.a;
      localInteger = Integer.valueOf(paramInt);
    }
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, android.webkit.ValueCallback<String> paramValueCallback)
  {
    TbsCoreLoadStat.getInstance().a(paramContext, 501);
    if (paramContext == null) {
      return -100;
    }
    x localx = x.a();
    localx.a(paramContext, null);
    if (localx.b())
    {
      if ((paramContext != null) && (paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) && (getTbsVersion(paramContext) < 25487)) {
        return -101;
      }
      int i1 = localx.c().a(paramContext, paramString, paramHashMap, null, paramValueCallback);
      if (i1 == 0)
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 503);
      }
      else
      {
        paramContext = TbsLogReport.getInstance(paramContext);
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(i1);
        paramContext.setLoadErrorCode(504, paramString.toString());
      }
      paramContext = new StringBuilder();
      paramContext.append("startMiniQBToLoadUrl  ret = ");
      paramContext.append(i1);
      Log.e("QbSdk", paramContext.toString());
      return i1;
    }
    TbsCoreLoadStat.getInstance().a(paramContext, 502);
    Log.e("QbSdk", "startMiniQBToLoadUrl  ret = -102");
    return -102;
  }
  
  public static boolean startQBForDoc(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationContext().getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt1));
    return MttLoader.openDocWithQb(paramContext, paramString1, paramInt2, paramString2, localHashMap, paramBundle);
  }
  
  public static boolean startQBForVideo(Context paramContext, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    return MttLoader.openVideoWithQb(paramContext, paramString, localHashMap);
  }
  
  public static boolean startQBToLoadurl(Context paramContext, String paramString, int paramInt, WebView paramWebView)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    boolean bool = false;
    WebView localWebView1 = paramWebView;
    if (paramWebView == null) {}
    try
    {
      Object localObject = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      if (localObject != "com.tencent.mm")
      {
        localWebView1 = paramWebView;
        if (localObject != "com.tencent.mobileqq") {}
      }
      else
      {
        localObject = x.a();
        localWebView1 = paramWebView;
        if (localObject != null)
        {
          localWebView1 = paramWebView;
          if (((x)localObject).b())
          {
            localObject = ((x)localObject).c().b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
            localWebView1 = paramWebView;
            if (localObject != null)
            {
              localObject = (IX5WebViewBase)localObject;
              localWebView1 = paramWebView;
              if (localObject != null) {
                localWebView1 = (WebView)((IX5WebViewBase)localObject).getView().getParent();
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        WebView localWebView2 = paramWebView;
      }
    }
    if (MttLoader.loadUrl(paramContext, paramString, localHashMap, "QbSdk.startQBToLoadurl", localWebView1) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean startQBWithBrowserlist(Context paramContext, String paramString, int paramInt)
  {
    boolean bool = startQBToLoadurl(paramContext, paramString, paramInt, null);
    if (!bool) {
      openBrowserList(paramContext, paramString, null);
    }
    return bool;
  }
  
  public static boolean startQbOrMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    if (paramContext == null) {
      return false;
    }
    x localx = x.a();
    localx.a(paramContext, null);
    if ((paramHashMap != null) && ("5".equals(paramHashMap.get("PosID"))) && (localx.b())) {
      Bundle localBundle = (Bundle)localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
    }
    if (MttLoader.loadUrl(paramContext, paramString, paramHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0)
    {
      if (localx.b())
      {
        if ((paramContext != null) && (paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) && (getTbsVersion(paramContext) < 25487)) {
          return false;
        }
        if (localx.c().a(paramContext, paramString, paramHashMap, null, paramValueCallback) == 0) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public static void unForceSysWebView()
  {
    b = false;
    TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
  }
  
  public static boolean unPreInit(Context paramContext)
  {
    return true;
  }
  
  public static void uploadNetLog(String paramString)
  {
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b())) {
      localObject = ((x)localObject).c().b();
    }
    try
    {
      ((DexLoader)localObject).invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "uploadNetLog", new Class[] { String.class }, new Object[] { paramString });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static boolean useSoftWare()
  {
    Object localObject1 = r;
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = i.a(localObject1, "useSoftWare", new Class[0], new Object[0]);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = r;
      localObject2 = Integer.TYPE;
      int i1 = a.a();
      localObject1 = i.a(localObject1, "useSoftWare", new Class[] { localObject2 }, new Object[] { Integer.valueOf(i1) });
    }
    if (localObject1 == null) {
      return false;
    }
    return ((Boolean)localObject1).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk
 * JD-Core Version:    0.7.0.1
 */
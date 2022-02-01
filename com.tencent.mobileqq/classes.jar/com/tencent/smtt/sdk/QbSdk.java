package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
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
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.sdk.ui.dialog.e;
import com.tencent.smtt.utils.FileProvider;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.i;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"NewApi"})
public class QbSdk
{
  private static String A;
  private static boolean B = false;
  private static boolean C = false;
  private static TbsListener D;
  private static TbsListener E;
  public static final int EXTENSION_INIT_FAILURE = -99999;
  private static boolean F = false;
  public static final String FILERADER_MENUDATA = "menuData";
  private static boolean G = false;
  public static String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
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
  static boolean a;
  static boolean b;
  static boolean c;
  static String d;
  static boolean e;
  static long f;
  static long g;
  static Object h;
  static boolean i;
  public static boolean isDefaultDialog;
  static boolean j;
  static boolean k;
  static volatile boolean l;
  static TbsListener m;
  public static boolean mDisableUseHostBackupCore;
  static Map<String, Object> n = null;
  private static int o;
  private static String p;
  private static Class<?> q;
  private static Object r;
  private static boolean s;
  public static boolean sIsVersionPrinted = false;
  private static String[] t;
  private static String u;
  private static String v;
  private static boolean w;
  private static int x;
  private static int y;
  private static String z;
  
  static
  {
    o = 0;
    p = "";
    q = null;
    r = null;
    a = false;
    b = false;
    c = true;
    s = false;
    u = "NULL";
    v = "UNKNOWN";
    e = false;
    f = 0L;
    g = 0L;
    h = new Object();
    isDefaultDialog = false;
    w = false;
    i = true;
    j = true;
    k = false;
    x = 0;
    y = 170;
    z = null;
    A = null;
    l = a;
    mDisableUseHostBackupCore = false;
    B = false;
    C = true;
    D = null;
    E = null;
    F = false;
    G = false;
    m = new QbSdk.5();
  }
  
  static Bundle a(Context paramContext, Bundle paramBundle)
  {
    if (!a(paramContext))
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(216, "initForPatch return false!");
      return null;
    }
    paramBundle = i.a(r, "incrUpdate", new Class[] { Context.class, Bundle.class }, new Object[] { paramContext, paramBundle });
    if (paramBundle != null) {
      return (Bundle)paramBundle;
    }
    TbsLogReport.getInstance(paramContext).setInstallErrorCode(216, "incrUpdate return null!");
    return null;
  }
  
  /* Error */
  private static Bundle a(Context paramContext, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 201	android/os/Bundle
    //   9: dup
    //   10: invokespecial 212	android/os/Bundle:<init>	()V
    //   13: astore 5
    //   15: aload_1
    //   16: ldc 214
    //   18: invokeinterface 220 2 0
    //   23: ifnonnull +162 -> 185
    //   26: ldc 222
    //   28: astore 4
    //   30: aload 5
    //   32: ldc 214
    //   34: aload 4
    //   36: invokevirtual 226	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload 5
    //   41: ldc 228
    //   43: aload_1
    //   44: ldc 228
    //   46: invokeinterface 220 2 0
    //   51: checkcast 230	java/lang/String
    //   54: invokestatic 236	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   57: invokevirtual 240	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   60: aload_1
    //   61: ifnull +161 -> 222
    //   64: aload_1
    //   65: ldc 23
    //   67: invokeinterface 244 2 0
    //   72: ifeq +150 -> 222
    //   75: new 246	org/json/JSONObject
    //   78: dup
    //   79: aload_1
    //   80: ldc 23
    //   82: invokeinterface 220 2 0
    //   87: checkcast 230	java/lang/String
    //   90: invokespecial 249	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   93: astore_1
    //   94: aload_1
    //   95: ldc 251
    //   97: invokevirtual 255	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   100: astore 4
    //   102: aload 4
    //   104: ifnull +107 -> 211
    //   107: new 257	java/util/ArrayList
    //   110: dup
    //   111: invokespecial 258	java/util/ArrayList:<init>	()V
    //   114: astore 6
    //   116: iconst_0
    //   117: istore_2
    //   118: aload 4
    //   120: invokevirtual 264	org/json/JSONArray:length	()I
    //   123: istore_3
    //   124: iload_2
    //   125: iload_3
    //   126: if_icmpge +75 -> 201
    //   129: iload_2
    //   130: iconst_5
    //   131: if_icmpge +70 -> 201
    //   134: aload 4
    //   136: iload_2
    //   137: invokevirtual 267	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   140: checkcast 246	org/json/JSONObject
    //   143: astore 7
    //   145: aload 7
    //   147: ldc_w 269
    //   150: invokevirtual 272	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   153: istore_3
    //   154: aload 6
    //   156: iload_2
    //   157: aload_0
    //   158: invokevirtual 276	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   161: iload_3
    //   162: invokestatic 282	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   165: invokevirtual 286	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   168: aload 7
    //   170: ldc_w 269
    //   173: iload_2
    //   174: invokevirtual 290	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   177: pop
    //   178: iload_2
    //   179: iconst_1
    //   180: iadd
    //   181: istore_2
    //   182: goto -64 -> 118
    //   185: aload_1
    //   186: ldc 214
    //   188: invokeinterface 220 2 0
    //   193: checkcast 230	java/lang/String
    //   196: astore 4
    //   198: goto -168 -> 30
    //   201: aload 5
    //   203: ldc_w 292
    //   206: aload 6
    //   208: invokevirtual 296	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   211: aload 5
    //   213: ldc 23
    //   215: aload_1
    //   216: invokevirtual 300	org/json/JSONObject:toString	()Ljava/lang/String;
    //   219: invokevirtual 226	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload 5
    //   224: areturn
    //   225: astore_0
    //   226: aload_0
    //   227: invokevirtual 303	java/lang/Exception:printStackTrace	()V
    //   230: aconst_null
    //   231: areturn
    //   232: astore 7
    //   234: goto -56 -> 178
    //   237: astore 4
    //   239: goto -179 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramContext	Context
    //   0	242	1	paramMap	Map<String, String>
    //   117	65	2	i1	int
    //   123	39	3	i2	int
    //   28	169	4	localObject	Object
    //   237	1	4	localException1	Exception
    //   13	210	5	localBundle	Bundle
    //   114	93	6	localArrayList	java.util.ArrayList
    //   143	26	7	localJSONObject	org.json.JSONObject
    //   232	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	26	225	java/lang/Exception
    //   30	39	225	java/lang/Exception
    //   64	102	225	java/lang/Exception
    //   107	116	225	java/lang/Exception
    //   118	124	225	java/lang/Exception
    //   185	198	225	java/lang/Exception
    //   201	211	225	java/lang/Exception
    //   211	222	225	java/lang/Exception
    //   134	178	232	java/lang/Exception
    //   39	60	237	java/lang/Exception
  }
  
  static Object a(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (!a(paramContext)) {
      paramContext = Integer.valueOf(-99999);
    }
    do
    {
      return paramContext;
      paramString = i.a(r, "miscCall", new Class[] { String.class, Bundle.class }, new Object[] { paramString, paramBundle });
      paramContext = paramString;
    } while (paramString != null);
    return null;
  }
  
  static String a()
  {
    return p;
  }
  
  /* Error */
  static void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 106	com/tencent/smtt/sdk/QbSdk:a	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 106	com/tencent/smtt/sdk/QbSdk:a	Z
    //   19: new 317	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 320
    //   29: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: putstatic 120	com/tencent/smtt/sdk/QbSdk:v	Ljava/lang/String;
    //   42: ldc_w 327
    //   45: new 317	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 329
    //   55: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: getstatic 120	com/tencent/smtt/sdk/QbSdk:v	Ljava/lang/String;
    //   61: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 333	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: invokestatic 338	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   73: aload_0
    //   74: sipush 401
    //   77: new 340	java/lang/Throwable
    //   80: dup
    //   81: getstatic 120	com/tencent/smtt/sdk/QbSdk:v	Ljava/lang/String;
    //   84: invokespecial 341	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   87: invokevirtual 344	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   90: goto -79 -> 11
    //   93: astore_0
    //   94: ldc 2
    //   96: monitorexit
    //   97: aload_0
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramContext	Context
    //   0	99	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	93	finally
    //   15	90	93	finally
  }
  
  static boolean a(Context paramContext)
  {
    try
    {
      if (q != null) {
        return true;
      }
      Object localObject = n.a().q(paramContext);
      if (localObject == null)
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
        return false;
      }
      File localFile = new File((File)localObject, "tbs_sdk_extension_dex.jar");
      if (!localFile.exists())
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
        return false;
      }
      TbsLog.i("QbSdk", "new DexLoader #3 dexFile is " + localFile.getAbsolutePath());
      v.a().a(paramContext);
      com.tencent.smtt.utils.k.a(paramContext);
      String str1 = localFile.getParent();
      String str2 = localFile.getAbsolutePath();
      localObject = ((File)localObject).getAbsolutePath();
      Map localMap = getSettings();
      q = new DexLoader(str1, paramContext, new String[] { str2 }, (String)localObject, localMap).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      loadTBSSDKExtension(paramContext, localFile.getParent());
      return true;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(paramContext));
    }
    return false;
  }
  
  static boolean a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, 20000);
  }
  
  static boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((n != null) && (n.containsKey(KEY_SET_SENDREQUEST_AND_UPLOAD)) && (n.get(KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false"))) {
      TbsLog.i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
    }
    label154:
    do
    {
      return true;
      n localn = n.a();
      if (d.a == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localn.b(paramContext, bool);
        if (!c(paramContext)) {
          break;
        }
        paramContext = i.a(r, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(43936), Integer.valueOf(paramInt2) });
        if (paramContext == null) {
          break label154;
        }
        return ((Boolean)paramContext).booleanValue();
      }
      paramContext = i.a(r, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(43936) });
    } while (paramContext == null);
    return ((Boolean)paramContext).booleanValue();
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
      TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43936; SDK_VERSION_NAME: 4.3.0.36");
      sIsVersionPrinted = true;
    }
    if ((a) && (!paramBoolean))
    {
      TbsLog.e("QbSdk", "QbSdk init: " + v, false);
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
        localObject2 = n.a().q(paramContext);
        if (localObject2 == null)
        {
          TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
          TbsCoreLoadStat.getInstance().a(paramContext, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
          return false;
        }
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          if ((o != 0) && (o != TbsShareManager.d(paramContext)))
          {
            q = null;
            r = null;
            TbsLog.e("QbSdk", "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
            TbsCoreLoadStat.getInstance().a(paramContext, 302, new Throwable("sTbsVersion: " + o + "; AvailableTbsCoreVersion: " + TbsShareManager.d(paramContext)));
            return false;
          }
          o = TbsShareManager.d(paramContext);
          if (TbsDownloader.a(paramContext, o))
          {
            TbsLog.i("QbSdk", "version " + o + " is in blacklist,can not load! return");
            return false;
          }
        }
        else
        {
          if (o == 0) {
            break label1095;
          }
          int i2 = n.a().a(true, paramContext);
          i1 = i2;
          if (o != i2)
          {
            q = null;
            r = null;
            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i2, true);
            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + o, true);
            TbsCoreLoadStat.getInstance().a(paramContext, 303, new Throwable("sTbsVersion: " + o + "; tbsCoreInstalledVer: " + i2));
            return false;
          }
          o = i1;
          continue;
        }
        if (q == null) {
          break label530;
        }
      }
      catch (Throwable localThrowable1)
      {
        TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(localThrowable1));
        TbsCoreLoadStat.getInstance().a(paramContext, 306, localThrowable1);
        return false;
      }
      if (r != null) {
        return true;
      }
      label530:
      File localFile;
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        if (TbsShareManager.j(paramContext))
        {
          localFile = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar");
          paramBoolean = localFile.exists();
          if (paramBoolean) {
            break label829;
          }
        }
      }
      for (;;)
      {
        try
        {
          TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
          i1 = n.a().i(paramContext);
          if (!new File(localFile.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
            continue;
          }
          if (i1 <= 0) {
            continue;
          }
          TbsCoreLoadStat.getInstance().a(paramContext, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i1));
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
          continue;
          if (i1 <= 0) {
            continue;
          }
          TbsCoreLoadStat.getInstance().a(paramContext, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i1));
          continue;
          TbsCoreLoadStat.getInstance().a(paramContext, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i1));
          continue;
        }
        return false;
        TbsCoreLoadStat.getInstance().a(paramContext, 304, new Throwable("isShareTbsCoreAvailable false!"));
        return false;
        localFile = new File(n.a().q(paramContext), "tbs_sdk_extension_dex.jar");
        break;
        TbsCoreLoadStat.getInstance().a(paramContext, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i1));
      }
      label829:
      if (TbsShareManager.getHostCorePathAppDefined() != null) {}
      for (Object localObject2 = TbsShareManager.getHostCorePathAppDefined();; localObject2 = ((File)localObject2).getAbsolutePath())
      {
        TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is " + (String)localObject2);
        TbsLog.i("QbSdk", "new DexLoader #1 dexFile is " + localThrowable2.getAbsolutePath());
        v.a().a(paramContext);
        com.tencent.smtt.utils.k.a(paramContext);
        String str1 = localThrowable2.getParent();
        String str2 = localThrowable2.getAbsolutePath();
        Object localObject3 = getSettings();
        q = new DexLoader(str1, paramContext, new String[] { str2 }, (String)localObject2, (Map)localObject3).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        loadTBSSDKExtension(paramContext, localThrowable2.getParent());
        Object localObject1 = r;
        localObject2 = b.a;
        str1 = b.b;
        str2 = b.c;
        localObject3 = b.d;
        i.a(localObject1, "putInfo", new Class[] { String.class, String.class, String.class, String.class }, new Object[] { localObject2, str1, str2, localObject3 });
        i.a(r, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
        return true;
      }
      label1095:
      int i1 = 0;
    }
  }
  
  static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i3 = 1;
    paramBoolean2 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    int i1 = TbsPVConfig.getInstance(paramContext).getDisabledCoreVersion();
    if ((i1 != 0) && (i1 == n.a().i(paramContext)))
    {
      TbsLog.e("QbSdk", "force use sys by remote switch");
      paramBoolean1 = bool2;
    }
    for (;;)
    {
      label46:
      return paramBoolean1;
      if ((TbsShareManager.isThirdPartyApp(paramContext)) && (!TbsShareManager.i(paramContext)))
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 302);
        return false;
      }
      if (!a(paramContext, paramBoolean1))
      {
        TbsLog.e("QbSdk", "QbSdk.init failure!");
        return false;
      }
      Object localObject3 = i.a(r, "canLoadX5Core", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(43936) });
      if (localObject3 != null)
      {
        if ((localObject3 instanceof String))
        {
          paramBoolean1 = bool2;
          if (((String)localObject3).equalsIgnoreCase("AuthenticationFail")) {
            continue;
          }
        }
        if (!(localObject3 instanceof Bundle))
        {
          TbsCoreLoadStat.getInstance().a(paramContext, 330, new Throwable("" + localObject3));
          TbsLog.e("loaderror", "ret not instance of bundle");
          return false;
        }
        Bundle localBundle = (Bundle)localObject3;
        if (localBundle.isEmpty())
        {
          TbsCoreLoadStat.getInstance().a(paramContext, 331, new Throwable("" + localObject3));
          TbsLog.e("loaderror", "empty bundle");
          return false;
        }
        try
        {
          i1 = localBundle.getInt("result_code", -1);
          if (i1 == 0)
          {
            paramBoolean1 = true;
            if (!TbsShareManager.isThirdPartyApp(paramContext)) {
              break label469;
            }
            d.a(TbsShareManager.d(paramContext));
            p = String.valueOf(TbsShareManager.d(paramContext));
            if (p.length() == 5) {
              p = "0" + p;
            }
            if (p.length() != 6) {
              p = "";
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            try
            {
              t = localBundle.getStringArray("tbs_jarfiles");
              if ((t instanceof String[])) {
                break label715;
              }
              TbsCoreLoadStat.getInstance().a(paramContext, 307, new Throwable("sJarFiles not instanceof String[]: " + t));
              return false;
            }
            catch (Throwable localThrowable)
            {
              label469:
              TbsCoreLoadStat.getInstance().a(paramContext, 329, localThrowable);
              return false;
            }
            localException2 = localException2;
            TbsLog.e("QbSdk", "bundle.getInt(KEY_RESULT_CODE) error : " + localException2.toString());
            i1 = -1;
            continue;
            paramBoolean1 = false;
            continue;
            try
            {
              if (Build.VERSION.SDK_INT >= 12) {
                p = localBundle.getString("tbs_core_version", "0");
              }
            }
            catch (Exception localException3)
            {
              try
              {
                o = Integer.parseInt(p);
                d.a(o);
                if (o == 0)
                {
                  TbsCoreLoadStat.getInstance().a(paramContext, 307, new Throwable("sTbsVersion is 0"));
                  return false;
                  p = localBundle.getString("tbs_core_version");
                  if (p != null) {
                    continue;
                  }
                  p = "0";
                  continue;
                  localException3 = localException3;
                  p = "0";
                }
              }
              catch (NumberFormatException localNumberFormatException)
              {
                o = 0;
                continue;
                int i2;
                if (o > 0)
                {
                  i2 = i3;
                  if (o <= 25442) {}
                }
                else
                {
                  if (o != 25472) {
                    continue;
                  }
                  i2 = i3;
                }
                if (i2 != 0)
                {
                  TbsLog.e("TbsDownload", "is_obsolete --> delete old core:" + o);
                  FileUtil.b(n.a().q(paramContext));
                  TbsCoreLoadStat.getInstance().a(paramContext, 307, new Throwable("is_obsolete --> delete old core:" + o));
                  return false;
                  i2 = 0;
                }
              }
            }
          }
        }
      }
      try
      {
        label715:
        d = localThrowable.getString("tbs_librarypath");
        Class localClass = null;
        Object localObject1 = localClass;
        if (i1 != 0) {}
        for (;;)
        {
          try
          {
            localObject1 = i.a(r, "getErrorCodeForLogReport", new Class[0], new Object[0]);
            switch (i1)
            {
            default: 
              TbsCoreLoadStat.getInstance().a(paramContext, 415, new Throwable("detail: " + localObject1 + "errcode" + i1));
            case 0: 
              paramBoolean2 = paramBoolean1;
              paramBoolean1 = paramBoolean2;
              if (paramBoolean2) {
                break label46;
              }
              TbsLog.e("loaderror", "319");
              return paramBoolean2;
            }
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            localObject2 = localClass;
            continue;
            if ((localObject2 instanceof Integer))
            {
              TbsCoreLoadStat.getInstance().a(paramContext, ((Integer)localObject2).intValue(), new Throwable("detail: " + localObject2));
              continue;
            }
            TbsCoreLoadStat.getInstance().a(paramContext, 307, new Throwable("detail: " + localObject2));
            continue;
            if ((localObject2 instanceof Integer))
            {
              TbsCoreLoadStat.getInstance().a(paramContext, ((Integer)localObject2).intValue(), new Throwable("detail: " + localObject2));
              continue;
            }
            TbsCoreLoadStat.getInstance().a(paramContext, 404, new Throwable("detail: " + localObject2));
            continue;
          }
          Object localObject2 = r;
          localClass = Integer.TYPE;
          i1 = a.a();
          localObject2 = i.a(localObject2, "canLoadX5", new Class[] { localClass }, new Object[] { Integer.valueOf(i1) });
          if (localObject2 != null)
          {
            if ((localObject2 instanceof String))
            {
              paramBoolean1 = bool2;
              if (((String)localObject2).equalsIgnoreCase("AuthenticationFail")) {
                break;
              }
            }
            if (!(localObject2 instanceof Boolean)) {
              continue;
            }
            o = d.c();
            bool2 = a(paramContext, d.c());
            paramBoolean2 = bool1;
            if (((Boolean)localObject2).booleanValue())
            {
              paramBoolean2 = bool1;
              if (!bool2) {
                paramBoolean2 = true;
              }
            }
            paramBoolean1 = paramBoolean2;
            if (paramBoolean2) {
              break;
            }
            TbsLog.e("loaderror", "318");
            TbsLog.w("loaderror", "isX5Disable:" + bool2);
            TbsLog.w("loaderror", "(Boolean) ret:" + (Boolean)localObject2);
            return paramBoolean2;
          }
          TbsCoreLoadStat.getInstance().a(paramContext, 308);
        }
        return false;
      }
      catch (Exception paramContext) {}
    }
  }
  
  protected static String b()
  {
    Object localObject = v.a();
    if ((localObject != null) && (((v)localObject).b()))
    {
      localObject = ((v)localObject).c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
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
        String str1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getString("app_versionname", null);
        String str2 = paramContext.getPackageManager().getPackageInfo("com.tencent.portfolio", 0).versionName;
        TbsLog.i("QbSdk", "clearPluginConfigFile oldAppVersionName is " + str1 + " newAppVersionName is " + str2);
        if ((str1 != null) && (!str1.contains(str2)))
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
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("QbSdk", "clearPluginConfigFile error is " + paramContext.getMessage());
      return false;
    }
    return true;
  }
  
  private static boolean c(Context paramContext)
  {
    try
    {
      if (q != null) {
        return true;
      }
      Object localObject2 = n.a().q(paramContext);
      if (localObject2 == null)
      {
        TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
        return false;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        if (!TbsShareManager.j(paramContext)) {}
      }
      for (Object localObject1 = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar"); !((File)localObject1).exists(); localObject1 = new File(n.a().q(paramContext), "tbs_sdk_extension_dex.jar"))
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
        return false;
        TbsCoreLoadStat.getInstance().a(paramContext, 304);
        return false;
      }
      if (TbsShareManager.getHostCorePathAppDefined() != null) {}
      for (localObject2 = TbsShareManager.getHostCorePathAppDefined();; localObject2 = ((File)localObject2).getAbsolutePath())
      {
        TbsLog.i("QbSdk", "QbSdk init optDirExtension #3 is " + (String)localObject2);
        TbsLog.i("QbSdk", "new DexLoader #4 dexFile is " + ((File)localObject1).getAbsolutePath());
        v.a().a(paramContext);
        com.tencent.smtt.utils.k.a(paramContext);
        String str1 = ((File)localObject1).getParent();
        String str2 = ((File)localObject1).getAbsolutePath();
        Map localMap = getSettings();
        q = new DexLoader(str1, paramContext, new String[] { str2 }, (String)localObject2, localMap).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        loadTBSSDKExtension(paramContext, ((File)localObject1).getParent());
        paramContext = r;
        localObject1 = b.a;
        localObject2 = b.b;
        str1 = b.c;
        str2 = b.d;
        i.a(paramContext, "putInfo", new Class[] { String.class, String.class, String.class, String.class }, new Object[] { localObject1, localObject2, str1, str2 });
        i.a(r, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(paramContext));
    }
  }
  
  public static boolean canLoadVideo(Context paramContext)
  {
    Object localObject = i.a(r, "canLoadVideo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) });
    if (localObject != null) {
      if (!((Boolean)localObject).booleanValue()) {
        TbsCoreLoadStat.getInstance().a(paramContext, 313);
      }
    }
    while (localObject == null)
    {
      return false;
      TbsCoreLoadStat.getInstance().a(paramContext, 314);
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
        Object localObject = n.a().q(paramContext);
        if (localObject == null)
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
        if (TbsShareManager.getHostCorePathAppDefined() != null) {}
        for (localObject = TbsShareManager.getHostCorePathAppDefined();; localObject = ((File)localObject).getAbsolutePath())
        {
          TbsLog.i("QbSdk", "QbSdk init optDirExtension #2 is " + (String)localObject);
          TbsLog.i("QbSdk", "new DexLoader #2 dexFile is " + localFile.getAbsolutePath());
          v.a().a(paramContext);
          com.tencent.smtt.utils.k.a(paramContext);
          String str1 = localFile.getParent();
          String str2 = localFile.getAbsolutePath();
          Map localMap = getSettings();
          q = new DexLoader(str1, paramContext, new String[] { str2 }, (String)localObject, localMap).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
          if (r != null) {
            break label268;
          }
          if ((TbsShareManager.e(paramContext) != null) || (TbsShareManager.getHostCorePathAppDefined() != null)) {
            break;
          }
          TbsLogReport.getInstance(paramContext.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
          return false;
        }
        loadTBSSDKExtension(paramContext, localFile.getParent());
      }
      label268:
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
      TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(paramContext));
    }
    return false;
  }
  
  /* Error */
  public static boolean canOpenWebPlus(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_1
    //   4: istore 4
    //   6: getstatic 143	com/tencent/smtt/sdk/QbSdk:x	I
    //   9: ifne +9 -> 18
    //   12: invokestatic 667	com/tencent/smtt/sdk/a:a	()I
    //   15: putstatic 143	com/tencent/smtt/sdk/QbSdk:x	I
    //   18: ldc_w 327
    //   21: new 317	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 822
    //   31: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: getstatic 143	com/tencent/smtt/sdk/QbSdk:x	I
    //   37: invokevirtual 485	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: getstatic 626	android/os/Build$VERSION:SDK_INT	I
    //   49: bipush 7
    //   51: if_icmplt +12 -> 63
    //   54: getstatic 143	com/tencent/smtt/sdk/QbSdk:x	I
    //   57: getstatic 145	com/tencent/smtt/sdk/QbSdk:y	I
    //   60: if_icmpge +5 -> 65
    //   63: iconst_0
    //   64: ireturn
    //   65: aload_0
    //   66: ifnull -3 -> 63
    //   69: new 824	java/io/BufferedInputStream
    //   72: dup
    //   73: new 826	java/io/FileInputStream
    //   76: dup
    //   77: new 356	java/io/File
    //   80: dup
    //   81: invokestatic 349	com/tencent/smtt/sdk/n:a	()Lcom/tencent/smtt/sdk/n;
    //   84: aload_0
    //   85: invokevirtual 352	com/tencent/smtt/sdk/n:q	(Landroid/content/Context;)Ljava/io/File;
    //   88: ldc_w 828
    //   91: invokespecial 361	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   94: invokespecial 830	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   97: invokespecial 833	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   100: astore 6
    //   102: new 835	java/util/Properties
    //   105: dup
    //   106: invokespecial 836	java/util/Properties:<init>	()V
    //   109: astore 8
    //   111: aload 8
    //   113: aload 6
    //   115: invokevirtual 839	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   118: aload 8
    //   120: ldc_w 841
    //   123: invokevirtual 844	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore 9
    //   128: aload 8
    //   130: ldc_w 846
    //   133: invokevirtual 844	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   136: astore 10
    //   138: aload 9
    //   140: invokestatic 635	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   143: istore_1
    //   144: aload 10
    //   146: invokestatic 635	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   149: istore_2
    //   150: getstatic 849	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   153: invokestatic 635	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   156: istore_3
    //   157: iload_3
    //   158: iload_1
    //   159: if_icmpgt +8 -> 167
    //   162: iload_3
    //   163: iload_2
    //   164: if_icmpge +44 -> 208
    //   167: ldc_w 327
    //   170: new 317	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 851
    //   180: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: iload_3
    //   184: invokevirtual 485	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload 6
    //   195: ifnull -132 -> 63
    //   198: aload 6
    //   200: invokevirtual 854	java/io/BufferedInputStream:close	()V
    //   203: iconst_0
    //   204: ireturn
    //   205: astore_0
    //   206: iconst_0
    //   207: ireturn
    //   208: aload 8
    //   210: ldc_w 628
    //   213: invokevirtual 844	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   216: invokestatic 635	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   219: istore_1
    //   220: aload 6
    //   222: ifnull +8 -> 230
    //   225: aload 6
    //   227: invokevirtual 854	java/io/BufferedInputStream:close	()V
    //   230: new 826	java/io/FileInputStream
    //   233: dup
    //   234: new 356	java/io/File
    //   237: dup
    //   238: aload_0
    //   239: invokestatic 856	com/tencent/smtt/sdk/n:s	(Landroid/content/Context;)Ljava/io/File;
    //   242: ldc_w 858
    //   245: invokespecial 361	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   248: invokespecial 830	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   251: astore 6
    //   253: new 835	java/util/Properties
    //   256: dup
    //   257: invokespecial 836	java/util/Properties:<init>	()V
    //   260: astore 7
    //   262: aload 7
    //   264: aload 6
    //   266: invokevirtual 839	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   269: aload 7
    //   271: ldc_w 860
    //   274: invokevirtual 844	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   277: invokestatic 635	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   280: istore_2
    //   281: aload 7
    //   283: ldc_w 862
    //   286: invokevirtual 844	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   289: invokestatic 635	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   292: istore_3
    //   293: iload_1
    //   294: ldc_w 863
    //   297: if_icmpeq +10 -> 307
    //   300: iload_2
    //   301: ldc_w 863
    //   304: if_icmpne +73 -> 377
    //   307: iconst_0
    //   308: istore_1
    //   309: iload_1
    //   310: istore_2
    //   311: aload 6
    //   313: ifnull +10 -> 323
    //   316: aload 6
    //   318: invokevirtual 866	java/io/InputStream:close	()V
    //   321: iload_1
    //   322: istore_2
    //   323: iload_2
    //   324: ifne +183 -> 507
    //   327: iload 4
    //   329: ireturn
    //   330: astore 6
    //   332: aconst_null
    //   333: astore_0
    //   334: aload 6
    //   336: invokevirtual 529	java/lang/Throwable:printStackTrace	()V
    //   339: ldc_w 327
    //   342: ldc_w 868
    //   345: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: aload_0
    //   349: ifnull -286 -> 63
    //   352: aload_0
    //   353: invokevirtual 854	java/io/BufferedInputStream:close	()V
    //   356: iconst_0
    //   357: ireturn
    //   358: astore_0
    //   359: iconst_0
    //   360: ireturn
    //   361: astore_0
    //   362: aconst_null
    //   363: astore 6
    //   365: aload 6
    //   367: ifnull +8 -> 375
    //   370: aload 6
    //   372: invokevirtual 854	java/io/BufferedInputStream:close	()V
    //   375: aload_0
    //   376: athrow
    //   377: iload_1
    //   378: iload_2
    //   379: if_icmple +8 -> 387
    //   382: iconst_0
    //   383: istore_1
    //   384: goto -75 -> 309
    //   387: iload_1
    //   388: iload_2
    //   389: if_icmpne +194 -> 583
    //   392: iload_3
    //   393: ifle +16 -> 409
    //   396: iload_3
    //   397: aload_0
    //   398: invokestatic 870	com/tencent/smtt/utils/b:b	(Landroid/content/Context;)I
    //   401: if_icmpeq +8 -> 409
    //   404: iconst_0
    //   405: istore_1
    //   406: goto -97 -> 309
    //   409: aload 7
    //   411: ldc_w 872
    //   414: invokevirtual 844	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   417: invokestatic 875	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   420: ifeq +34 -> 454
    //   423: aload_0
    //   424: invokevirtual 810	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   427: invokestatic 724	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   430: getfield 728	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   433: ldc_w 877
    //   436: iconst_0
    //   437: invokeinterface 881 3 0
    //   442: istore 5
    //   444: iload 5
    //   446: ifne +8 -> 454
    //   449: iconst_1
    //   450: istore_1
    //   451: goto -142 -> 309
    //   454: iconst_0
    //   455: istore_1
    //   456: goto -147 -> 309
    //   459: astore_0
    //   460: aload 7
    //   462: astore_0
    //   463: ldc_w 327
    //   466: ldc_w 883
    //   469: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   472: aload_0
    //   473: ifnull +7 -> 480
    //   476: aload_0
    //   477: invokevirtual 866	java/io/InputStream:close	()V
    //   480: iconst_1
    //   481: istore_2
    //   482: goto -159 -> 323
    //   485: astore_0
    //   486: iconst_1
    //   487: istore_2
    //   488: goto -165 -> 323
    //   491: astore_0
    //   492: aconst_null
    //   493: astore 6
    //   495: aload 6
    //   497: ifnull +8 -> 505
    //   500: aload 6
    //   502: invokevirtual 866	java/io/InputStream:close	()V
    //   505: aload_0
    //   506: athrow
    //   507: iconst_0
    //   508: istore 4
    //   510: goto -183 -> 327
    //   513: astore 6
    //   515: goto -285 -> 230
    //   518: astore 6
    //   520: goto -145 -> 375
    //   523: astore_0
    //   524: iload_1
    //   525: istore_2
    //   526: goto -203 -> 323
    //   529: astore 6
    //   531: goto -26 -> 505
    //   534: astore_0
    //   535: goto -40 -> 495
    //   538: astore 7
    //   540: aload_0
    //   541: astore 6
    //   543: aload 7
    //   545: astore_0
    //   546: goto -51 -> 495
    //   549: astore_0
    //   550: aload 6
    //   552: astore_0
    //   553: goto -90 -> 463
    //   556: astore_0
    //   557: goto -192 -> 365
    //   560: astore 7
    //   562: aload_0
    //   563: astore 6
    //   565: aload 7
    //   567: astore_0
    //   568: goto -203 -> 365
    //   571: astore 7
    //   573: aload 6
    //   575: astore_0
    //   576: aload 7
    //   578: astore 6
    //   580: goto -246 -> 334
    //   583: iconst_0
    //   584: istore_1
    //   585: goto -276 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	paramContext	Context
    //   143	442	1	i1	int
    //   149	377	2	i2	int
    //   156	246	3	i3	int
    //   4	505	4	bool1	boolean
    //   442	3	5	bool2	boolean
    //   100	217	6	localObject1	Object
    //   330	5	6	localThrowable1	Throwable
    //   363	138	6	localObject2	Object
    //   513	1	6	localException1	Exception
    //   518	1	6	localException2	Exception
    //   529	1	6	localException3	Exception
    //   541	38	6	localObject3	Object
    //   1	460	7	localProperties1	java.util.Properties
    //   538	6	7	localObject4	Object
    //   560	6	7	localObject5	Object
    //   571	6	7	localThrowable2	Throwable
    //   109	100	8	localProperties2	java.util.Properties
    //   126	13	9	str1	String
    //   136	9	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   198	203	205	java/lang/Exception
    //   69	102	330	java/lang/Throwable
    //   352	356	358	java/lang/Exception
    //   69	102	361	finally
    //   230	253	459	java/lang/Throwable
    //   476	480	485	java/lang/Exception
    //   230	253	491	finally
    //   225	230	513	java/lang/Exception
    //   370	375	518	java/lang/Exception
    //   316	321	523	java/lang/Exception
    //   500	505	529	java/lang/Exception
    //   253	293	534	finally
    //   396	404	534	finally
    //   409	444	534	finally
    //   463	472	538	finally
    //   253	293	549	java/lang/Throwable
    //   396	404	549	java/lang/Throwable
    //   409	444	549	java/lang/Throwable
    //   102	157	556	finally
    //   167	193	556	finally
    //   208	220	556	finally
    //   334	348	560	finally
    //   102	157	571	java/lang/Throwable
    //   167	193	571	java/lang/Throwable
    //   208	220	571	java/lang/Throwable
  }
  
  public static boolean canUseVideoFeatrue(Context paramContext, int paramInt)
  {
    paramContext = i.a(r, "canUseVideoFeatrue", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    if ((paramContext != null) && ((paramContext instanceof Boolean))) {
      return ((Boolean)paramContext).booleanValue();
    }
    return false;
  }
  
  public static boolean checkApkExist(Context paramContext, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return false;
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean checkContentProviderPrivilage(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getApplicationInfo().targetSdkVersion >= 24) && (Build.VERSION.SDK_INT >= 24) && (!"com.tencent.mobileqq".equals(paramContext.getApplicationInfo().packageName))) {}
    try
    {
      ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), "android.support.v4.content.FileProvider");
      boolean bool = TextUtils.isEmpty(paramContext.getPackageManager().getProviderInfo(localComponentName, 0).authority);
      if (bool) {
        break label82;
      }
    }
    catch (Exception localException)
    {
      label82:
      do
      {
        localException.printStackTrace();
        paramContext = paramContext.getPackageManager().resolveContentProvider(paramContext.getApplicationInfo().packageName + ".provider", 128);
        if (paramContext == null) {
          Log.e("QbSdk", "Must declare com.tencent.smtt.utils.FileProvider in AndroidManifest above Android 7.0,please view document in x5.tencent.com");
        }
      } while (paramContext != null);
    }
    return true;
    return false;
  }
  
  public static void checkTbsValidity(Context paramContext)
  {
    if (paramContext == null) {}
    while (com.tencent.smtt.utils.k.b(paramContext)) {
      return;
    }
    TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedBy checkTbsValidity");
    TbsCoreLoadStat.getInstance().a(paramContext, 419);
    forceSysWebView();
  }
  
  public static void clear(Context paramContext) {}
  
  public static void clearAllDefaultBrowser(Context paramContext)
  {
    paramContext.getSharedPreferences("tbs_file_open_dialog_config", 0).edit().clear().commit();
  }
  
  public static void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    int i2 = 1;
    TbsLog.i("QbSdk", "clearAllWebViewCache(" + paramContext + ", " + paramBoolean + ")");
    int i3 = 0;
    i1 = 0;
    for (;;)
    {
      try
      {
        Object localObject = new WebView(paramContext).getWebViewClientExtension();
        i1 = i3;
        if (localObject != null) {
          TbsLog.e("QbSdk", "clearAllWebViewCache exception 2 -- " + Log.getStackTraceString(localThrowable1));
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localObject = v.a();
          i1 = i2;
          if (localObject != null)
          {
            i1 = i2;
            if (((v)localObject).b())
            {
              ((v)localObject).c().a(paramContext, paramBoolean);
              i1 = i2;
            }
          }
          if (i1 == 0) {
            break;
          }
          TbsLog.i("QbSdk", "is_in_x5_mode --> no need to clear system webview!");
          return;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            android.webkit.WebView localWebView;
            i1 = 1;
          }
        }
        localThrowable1 = localThrowable1;
      }
    }
    try
    {
      localWebView = new android.webkit.WebView(paramContext);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        localWebView.removeJavascriptInterface("accessibility");
        localWebView.removeJavascriptInterface("accessibilityTraversal");
      }
      localWebView.clearCache(true);
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
      TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(paramContext));
      return;
    }
  }
  
  public static void clearDefaultBrowser(Context paramContext, String paramString)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("tbs_file_open_dialog_config", 0);
    paramString = e.d(paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "*/*";
    }
    localSharedPreferences.edit().remove("key_tbs_picked_default_browser_" + paramContext).commit();
  }
  
  public static String closeNetLogAndSavaToLocal()
  {
    Object localObject = v.a();
    if ((localObject != null) && (((v)localObject).b()))
    {
      localObject = ((v)localObject).c().b();
      try
      {
        localObject = ((DexLoader)localObject).invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "closeNetLogAndSavaToLocal", new Class[0], new Object[0]);
        if ((localObject != null) && ((localObject instanceof String)))
        {
          localObject = (String)localObject;
          return localObject;
        }
      }
      catch (Exception localException) {}
      return "";
    }
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
    v localv = v.a();
    if ((localv != null) && (localv.b()))
    {
      Bitmap localBitmap = null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      }
      paramDrawable = localv.c().b();
      TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
      paramContext = paramDrawable.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[] { Context.class, String.class, String.class, Bitmap.class }, new Object[] { paramContext, paramString1, paramString2, localBitmap });
      TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + paramContext);
      return paramContext != null;
    }
    return false;
  }
  
  private static void d(Context paramContext)
  {
    int i6 = -1;
    C = true;
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          i3 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_recorder", -1);
          if (i3 < 0) {
            continue;
          }
          i1 = i3 + 1;
          if (i1 > 4)
          {
            return;
            localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            continue;
          }
          i3 = i1;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject1;
          int i2;
          int i5;
          Object localObject2;
          int i4;
          Object localObject3;
          int i3 = -1;
          int i1 = -1;
          continue;
          i1 = -1;
          continue;
        }
        try
        {
          i2 = n.a().i(paramContext);
          if (i2 <= 0) {
            continue;
          }
          if (i3 > 4) {}
        }
        catch (Throwable localThrowable3)
        {
          i2 = -1;
          i3 = i1;
          i1 = i2;
          continue;
        }
        try
        {
          ((SharedPreferences)localObject1).edit().putInt("tbs_preload_x5_recorder", i3).commit();
          i5 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_counter", -1);
          i3 = i1;
          localObject2 = localObject1;
          i4 = i2;
          if (i5 < 0) {
            continue;
          }
          localObject2 = ((SharedPreferences)localObject1).edit();
          i5 += 1;
          ((SharedPreferences.Editor)localObject2).putInt("tbs_preload_x5_counter", i5).commit();
          if (i5 <= 3) {
            continue;
          }
          try
          {
            i1 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_version", -1);
            localObject1 = ((SharedPreferences)localObject1).edit();
            if (i1 != i2) {
              continue;
            }
            FileUtil.a(n.a().q(paramContext), false);
            paramContext = k.a(paramContext).a();
            if (paramContext != null) {
              FileUtil.a(paramContext, false);
            }
            TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i2 + " is deleted!");
            ((SharedPreferences.Editor)localObject1).putInt("tbs_precheck_disable_version", i1);
            ((SharedPreferences.Editor)localObject1).commit();
            return;
          }
          catch (Throwable paramContext)
          {
            TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(paramContext));
            return;
          }
          localThrowable1 = localThrowable1;
          i3 = -1;
          localObject1 = null;
          i1 = -1;
        }
        catch (Throwable localThrowable4)
        {
          i3 = i1;
          i1 = i2;
          continue;
        }
        TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(localThrowable1));
        i4 = i1;
        localObject3 = localObject1;
        i5 = -1;
        i1 = i3;
        localObject1 = localObject3;
        i2 = i4;
        continue;
        TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i2 + "; value:" + i1);
      }
      i2 = i6;
      if (i1 > 0)
      {
        i2 = i6;
        if (i1 <= 3)
        {
          TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
          v.a().a(paramContext, null);
          TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
          i2 = 0;
        }
      }
      try
      {
        i1 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_counter", -1);
        if (i1 > 0) {
          ((SharedPreferences)localObject1).edit().putInt("tbs_preload_x5_counter", i1 - 1).commit();
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(paramContext));
        }
      }
      TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
      return;
    }
  }
  
  public static boolean deleteMiniQBShortCut(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {}
    v localv;
    do
    {
      do
      {
        do
        {
          return false;
        } while (TbsDownloader.getOverSea(paramContext));
        localv = v.a();
      } while ((localv == null) || (!localv.b()));
    } while (localv.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 }) == null);
    return true;
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
    v localv = v.a();
    if ((localv != null) && (localv.b())) {}
    try
    {
      localv.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[] { Context.class, String.class, android.webkit.ValueCallback.class }, new Object[] { paramContext, paramString, paramValueCallback });
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void forceSysWebView()
  {
    b = true;
    u = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
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
  
  public static String getCurrentProcessName(Context paramContext)
  {
    for (;;)
    {
      try
      {
        int i1 = Process.myPid();
        Object localObject = "";
        Iterator localIterator = ((ActivityManager)paramContext.getApplicationContext().getSystemService("activity")).getRunningAppProcesses().iterator();
        paramContext = (Context)localObject;
        localObject = paramContext;
        if (localIterator.hasNext())
        {
          localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
          if (((ActivityManager.RunningAppProcessInfo)localObject).pid == i1) {
            paramContext = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
          }
        }
        else
        {
          return localObject;
        }
      }
      catch (Throwable paramContext)
      {
        localObject = "";
      }
    }
  }
  
  public static String[] getDexLoaderFileList(Context paramContext1, Context paramContext2, String paramString)
  {
    int i1 = 0;
    if ((t instanceof String[]))
    {
      int i2 = t.length;
      paramContext2 = new String[i2];
      for (;;)
      {
        paramContext1 = paramContext2;
        if (i1 >= i2) {
          break;
        }
        paramContext2[i1] = (paramString + t[i1]);
        i1 += 1;
      }
    }
    paramContext1 = i.a(r, "getJarFiles", new Class[] { Context.class, Context.class, String.class }, new Object[] { paramContext1, paramContext2, paramString });
    if ((paramContext1 instanceof String[])) {}
    for (;;)
    {
      paramContext1 = (String[])paramContext1;
      return paramContext1;
      paramContext1 = new String[1];
      paramContext1[0] = "";
    }
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
    if (r == null)
    {
      TbsLog.i("QbSdk", "getJarFilesAndLibraryPath sExtensionObj is null");
      return false;
    }
    Bundle localBundle = (Bundle)i.a(r, "canLoadX5CoreAndNotLoadSo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(43936) });
    if (localBundle == null)
    {
      TbsLog.i("QbSdk", "getJarFilesAndLibraryPath bundle is null and coreverison is " + n.a().a(true, paramContext));
      return false;
    }
    t = localBundle.getStringArray("tbs_jarfiles");
    d = localBundle.getString("tbs_librarypath");
    return true;
  }
  
  public static String getMiniQBVersion(Context paramContext)
  {
    Object localObject = null;
    v localv = v.a();
    localv.a(paramContext, null);
    paramContext = localObject;
    if (localv != null)
    {
      paramContext = localObject;
      if (localv.b()) {
        paramContext = localv.c().f();
      }
    }
    return paramContext;
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
      if (b.c())
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
    return 43936;
  }
  
  public static int getTbsVersion(Context paramContext)
  {
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      return TbsShareManager.a(paramContext, false);
    }
    return n.a().i(paramContext);
  }
  
  public static int getTbsVersionForCrash(Context paramContext)
  {
    int i1;
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      i1 = TbsShareManager.a(paramContext, false);
    }
    int i2;
    do
    {
      do
      {
        return i1;
        i2 = n.a().j(paramContext);
        i1 = i2;
      } while (i2 != 0);
      i1 = i2;
    } while (k.a(paramContext).c() != 3);
    reset(paramContext);
    return i2;
  }
  
  public static int getTmpDirTbsVersion(Context paramContext)
  {
    int i1 = 0;
    if (k.a(paramContext).c() == 2) {
      i1 = n.a().e(paramContext, 0);
    }
    while (k.a(paramContext).b("copy_status") != 1) {
      return i1;
    }
    return n.a().e(paramContext, 1);
  }
  
  public static void initBuglyAsync(boolean paramBoolean)
  {
    i = paramBoolean;
  }
  
  public static void initForinitAndNotLoadSo(Context paramContext)
  {
    if (q == null)
    {
      localObject1 = n.a().q(paramContext);
      if (localObject1 == null) {
        Log.e("QbSdk", "QbSdk initForinitAndNotLoadSo optDir == null");
      }
    }
    else
    {
      return;
    }
    Object localObject2 = new File((File)localObject1, "tbs_sdk_extension_dex.jar");
    if (!((File)localObject2).exists())
    {
      Log.e("QbSdk", "QbSdk initForinitAndNotLoadSo dexFile.exists()=false");
      return;
    }
    Object localObject1 = ((File)localObject1).getAbsolutePath();
    v.a().a(paramContext);
    com.tencent.smtt.utils.k.a(paramContext);
    String str = ((File)localObject2).getParent();
    localObject2 = ((File)localObject2).getAbsolutePath();
    Map localMap = getSettings();
    q = new DexLoader(str, paramContext, new String[] { localObject2 }, (String)localObject1, localMap).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    if (n == null)
    {
      n = paramMap;
      return;
    }
    try
    {
      n.putAll(paramMap);
      return;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public static void initX5Environment(Context paramContext, QbSdk.PreInitCallback paramPreInitCallback)
  {
    if (paramContext == null)
    {
      TbsLog.e("QbSdk", "initX5Environment,context=null");
      return;
    }
    b(paramContext);
    E = new QbSdk.3(paramContext, paramPreInitCallback);
    n localn;
    if (TbsShareManager.isThirdPartyApp(paramContext))
    {
      localn = n.a();
      if (d.a != 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localn.b(paramContext, bool);
      TbsDownloader.needDownload(paramContext, false, false, true, new QbSdk.4(paramContext, paramPreInitCallback));
      return;
    }
  }
  
  public static boolean installLocalQbApk(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    boolean bool2 = false;
    d locald = d.a(true);
    locald.a(paramContext, false, false, null);
    boolean bool1 = bool2;
    if (locald != null)
    {
      bool1 = bool2;
      if (locald.b()) {
        bool1 = locald.a().a(paramContext, paramString1, paramString2, paramBundle);
      }
    }
    return bool1;
  }
  
  public static boolean intentDispatch(WebView paramWebView, Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramWebView == null) {
      return false;
    }
    Context localContext;
    int i1;
    if (paramString1.startsWith("mttbrowser://miniqb/ch=icon?"))
    {
      localContext = paramWebView.getContext();
      i1 = paramString1.indexOf("url=");
      if (i1 <= 0) {
        break label183;
      }
    }
    label183:
    for (paramIntent = paramString1.substring(i1 + 4);; paramIntent = null)
    {
      HashMap localHashMap = new HashMap();
      paramString1 = "unknown";
      try
      {
        String str = localContext.getApplicationInfo().packageName;
        paramString1 = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        paramWebView.loadUrl(paramIntent);
      }
      localHashMap.put("ChannelID", paramString1);
      localHashMap.put("PosID", "14004");
      if ("miniqb://home".equals(paramIntent)) {}
      for (paramString1 = "qb://navicard/addCard?cardId=168&cardName=168";; paramString1 = paramIntent)
      {
        if (MttLoader.loadUrl(localContext, paramString1, localHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0)
        {
          paramString1 = v.a();
          if ((paramString1 != null) && (paramString1.b()) && (paramString1.c().a(localContext, paramIntent, null, paramString2, null) == 0)) {
            return true;
          }
        }
        for (;;)
        {
          return false;
          paramWebView.loadUrl(paramString1);
        }
      }
    }
  }
  
  public static boolean isInDefaultBrowser(Context paramContext, String paramString)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("tbs_file_open_dialog_config", 0);
    paramString = e.d(paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "*/*";
    }
    return localSharedPreferences.contains("key_tbs_picked_default_browser_" + paramContext);
  }
  
  public static boolean isMiniQBShortCutExist(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    paramString2 = v.a();
    if ((paramString2 != null) && (paramString2.b()))
    {
      paramContext = paramString2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString1 });
      if (paramContext != null) {
        if (!(paramContext instanceof Boolean)) {
          break label98;
        }
      }
    }
    label98:
    for (paramContext = (Boolean)paramContext;; paramContext = Boolean.valueOf(false))
    {
      return paramContext.booleanValue();
      return false;
      return false;
    }
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
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      return Arrays.asList(new String[] { "doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub" }).contains(paramString.toLowerCase());
    }
    return Arrays.asList(new String[] { "rar", "zip", "tar", "bz2", "gz", "7z", "doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub", "chm", "html", "htm", "xml", "mht", "url", "ini", "log", "bat", "php", "js", "lrc", "jpg", "jpeg", "png", "gif", "bmp", "tiff", "webp", "mp3", "m4a", "aac", "amr", "wav", "ogg", "mid", "ra", "wma", "mpga", "ape", "flac", "RTSP", "RTP", "SDP", "RTMP", "mp4", "flv", "avi", "3gp", "3gpp", "webm", "ts", "ogv", "m3u8", "asf", "wmv", "rmvb", "rm", "f4v", "dat", "mov", "mpg", "mkv", "mpeg", "mpeg1", "mpeg2", "xvid", "dvd", "vcd", "vob", "divx" }).contains(paramString.toLowerCase());
  }
  
  public static boolean isTbsCoreInited()
  {
    boolean bool2 = false;
    d locald = d.a(false);
    boolean bool1 = bool2;
    if (locald != null)
    {
      bool1 = bool2;
      if (locald.f()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isX5DisabledSync(Context paramContext)
  {
    if (k.a(paramContext).c() == 2) {}
    for (int i1 = 1; i1 != 0; i1 = 0) {
      return false;
    }
    if (!c(paramContext)) {
      return true;
    }
    i1 = n.a().i(paramContext);
    paramContext = i.a(r, "isX5DisabledSync", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(i1), Integer.valueOf(43936) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    return true;
  }
  
  /* Error */
  public static void loadTBSSDKExtension(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_1
    //   4: istore_2
    //   5: getstatic 104	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   8: ifnull +4 -> 12
    //   11: return
    //   12: ldc 2
    //   14: monitorenter
    //   15: getstatic 104	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   18: ifnull +13 -> 31
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: astore_0
    //   26: ldc 2
    //   28: monitorexit
    //   29: aload_0
    //   30: athrow
    //   31: getstatic 102	com/tencent/smtt/sdk/QbSdk:q	Ljava/lang/Class;
    //   34: ifnonnull +12 -> 46
    //   37: ldc_w 327
    //   40: ldc_w 1503
    //   43: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: getstatic 102	com/tencent/smtt/sdk/QbSdk:q	Ljava/lang/Class;
    //   49: iconst_5
    //   50: anewarray 197	java/lang/Class
    //   53: dup
    //   54: iconst_0
    //   55: ldc 199
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: ldc 199
    //   62: aastore
    //   63: dup
    //   64: iconst_2
    //   65: ldc 230
    //   67: aastore
    //   68: dup
    //   69: iconst_3
    //   70: ldc 230
    //   72: aastore
    //   73: dup
    //   74: iconst_4
    //   75: ldc 230
    //   77: aastore
    //   78: invokevirtual 1507	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   81: astore_3
    //   82: aload_0
    //   83: invokestatic 475	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   86: ifeq +231 -> 317
    //   89: aload_0
    //   90: invokestatic 806	com/tencent/smtt/sdk/TbsShareManager:e	(Landroid/content/Context;)Landroid/content/Context;
    //   93: astore 4
    //   95: aload 4
    //   97: ifnonnull +37 -> 134
    //   100: invokestatic 534	com/tencent/smtt/sdk/TbsShareManager:getHostCorePathAppDefined	()Ljava/lang/String;
    //   103: ifnonnull +31 -> 134
    //   106: aload_0
    //   107: invokevirtual 810	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   110: invokestatic 187	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   113: sipush 227
    //   116: ldc_w 812
    //   119: invokevirtual 815	com/tencent/smtt/sdk/TbsLogReport:setLoadErrorCode	(ILjava/lang/String;)V
    //   122: ldc 2
    //   124: monitorexit
    //   125: return
    //   126: astore_3
    //   127: iconst_0
    //   128: istore_2
    //   129: aconst_null
    //   130: astore_3
    //   131: goto -49 -> 82
    //   134: iload_2
    //   135: ifne +145 -> 280
    //   138: aload 4
    //   140: ifnonnull +65 -> 205
    //   143: getstatic 102	com/tencent/smtt/sdk/QbSdk:q	Ljava/lang/Class;
    //   146: iconst_3
    //   147: anewarray 197	java/lang/Class
    //   150: dup
    //   151: iconst_0
    //   152: ldc 199
    //   154: aastore
    //   155: dup
    //   156: iconst_1
    //   157: ldc 199
    //   159: aastore
    //   160: dup
    //   161: iconst_2
    //   162: ldc 230
    //   164: aastore
    //   165: invokevirtual 1507	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   168: iconst_5
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_0
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: aload 4
    //   180: aastore
    //   181: dup
    //   182: iconst_2
    //   183: invokestatic 534	com/tencent/smtt/sdk/TbsShareManager:getHostCorePathAppDefined	()Ljava/lang/String;
    //   186: aastore
    //   187: dup
    //   188: iconst_3
    //   189: aload_1
    //   190: aastore
    //   191: dup
    //   192: iconst_4
    //   193: aconst_null
    //   194: aastore
    //   195: invokevirtual 1513	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   198: putstatic 104	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   201: ldc 2
    //   203: monitorexit
    //   204: return
    //   205: getstatic 102	com/tencent/smtt/sdk/QbSdk:q	Ljava/lang/Class;
    //   208: iconst_2
    //   209: anewarray 197	java/lang/Class
    //   212: dup
    //   213: iconst_0
    //   214: ldc 199
    //   216: aastore
    //   217: dup
    //   218: iconst_1
    //   219: ldc 199
    //   221: aastore
    //   222: invokevirtual 1507	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   225: iconst_2
    //   226: anewarray 4	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload_0
    //   232: aastore
    //   233: dup
    //   234: iconst_1
    //   235: aload 4
    //   237: aastore
    //   238: invokevirtual 1513	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   241: putstatic 104	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   244: goto -43 -> 201
    //   247: astore_0
    //   248: ldc_w 327
    //   251: new 317	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 318	java/lang/StringBuilder:<init>	()V
    //   258: ldc_w 1515
    //   261: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_0
    //   265: invokestatic 417	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   268: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 333	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: goto -76 -> 201
    //   280: aload_3
    //   281: iconst_5
    //   282: anewarray 4	java/lang/Object
    //   285: dup
    //   286: iconst_0
    //   287: aload_0
    //   288: aastore
    //   289: dup
    //   290: iconst_1
    //   291: aload 4
    //   293: aastore
    //   294: dup
    //   295: iconst_2
    //   296: invokestatic 534	com/tencent/smtt/sdk/TbsShareManager:getHostCorePathAppDefined	()Ljava/lang/String;
    //   299: aastore
    //   300: dup
    //   301: iconst_3
    //   302: aload_1
    //   303: aastore
    //   304: dup
    //   305: iconst_4
    //   306: aconst_null
    //   307: aastore
    //   308: invokevirtual 1513	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   311: putstatic 104	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   314: goto -113 -> 201
    //   317: iload_2
    //   318: ifne +60 -> 378
    //   321: getstatic 102	com/tencent/smtt/sdk/QbSdk:q	Ljava/lang/Class;
    //   324: iconst_2
    //   325: anewarray 197	java/lang/Class
    //   328: dup
    //   329: iconst_0
    //   330: ldc 199
    //   332: aastore
    //   333: dup
    //   334: iconst_1
    //   335: ldc 199
    //   337: aastore
    //   338: invokevirtual 1507	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   341: astore_3
    //   342: aload_0
    //   343: astore_1
    //   344: aload_0
    //   345: invokevirtual 810	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   348: ifnull +8 -> 356
    //   351: aload_0
    //   352: invokevirtual 810	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   355: astore_1
    //   356: aload_3
    //   357: iconst_2
    //   358: anewarray 4	java/lang/Object
    //   361: dup
    //   362: iconst_0
    //   363: aload_1
    //   364: aastore
    //   365: dup
    //   366: iconst_1
    //   367: aload_1
    //   368: aastore
    //   369: invokevirtual 1513	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   372: putstatic 104	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   375: goto -174 -> 201
    //   378: aload 5
    //   380: astore 4
    //   382: ldc_w 1043
    //   385: aload_0
    //   386: invokestatic 1046	com/tencent/smtt/sdk/QbSdk:getCurrentProcessName	(Landroid/content/Context;)Ljava/lang/String;
    //   389: invokevirtual 890	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   392: ifeq +18 -> 410
    //   395: aload 5
    //   397: astore 4
    //   399: getstatic 1049	com/tencent/smtt/sdk/WebView:mWebViewCreated	Z
    //   402: ifne +8 -> 410
    //   405: ldc_w 1517
    //   408: astore 4
    //   410: aload_0
    //   411: astore 5
    //   413: aload_0
    //   414: invokevirtual 810	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   417: ifnull +9 -> 426
    //   420: aload_0
    //   421: invokevirtual 810	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   424: astore 5
    //   426: aload_3
    //   427: iconst_5
    //   428: anewarray 4	java/lang/Object
    //   431: dup
    //   432: iconst_0
    //   433: aload 5
    //   435: aastore
    //   436: dup
    //   437: iconst_1
    //   438: aload 5
    //   440: aastore
    //   441: dup
    //   442: iconst_2
    //   443: aconst_null
    //   444: aastore
    //   445: dup
    //   446: iconst_3
    //   447: aload_1
    //   448: aastore
    //   449: dup
    //   450: iconst_4
    //   451: aload 4
    //   453: aastore
    //   454: invokevirtual 1513	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   457: putstatic 104	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Object;
    //   460: goto -259 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	463	0	paramContext	Context
    //   0	463	1	paramString	String
    //   4	314	2	i1	int
    //   81	1	3	localConstructor1	java.lang.reflect.Constructor
    //   126	1	3	localThrowable	Throwable
    //   130	297	3	localConstructor2	java.lang.reflect.Constructor
    //   93	359	4	localObject	Object
    //   1	438	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   15	24	25	finally
    //   26	29	25	finally
    //   31	46	25	finally
    //   46	82	25	finally
    //   82	95	25	finally
    //   100	122	25	finally
    //   122	125	25	finally
    //   143	201	25	finally
    //   201	204	25	finally
    //   205	244	25	finally
    //   248	277	25	finally
    //   280	314	25	finally
    //   321	342	25	finally
    //   344	356	25	finally
    //   356	375	25	finally
    //   382	395	25	finally
    //   399	405	25	finally
    //   413	426	25	finally
    //   426	460	25	finally
    //   46	82	126	java/lang/Throwable
    //   82	95	247	java/lang/Throwable
    //   100	122	247	java/lang/Throwable
    //   143	201	247	java/lang/Throwable
    //   205	244	247	java/lang/Throwable
    //   280	314	247	java/lang/Throwable
    //   321	342	247	java/lang/Throwable
    //   344	356	247	java/lang/Throwable
    //   356	375	247	java/lang/Throwable
    //   382	395	247	java/lang/Throwable
    //   399	405	247	java/lang/Throwable
    //   413	426	247	java/lang/Throwable
    //   426	460	247	java/lang/Throwable
  }
  
  public static void openBrowserList(Context paramContext, String paramString, Bundle paramBundle, ValueCallback<String> paramValueCallback)
  {
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
        String str = "";
        if (paramBundle != null) {
          str = paramBundle.getString("ChannelId");
        }
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.addCategory("android.intent.category.DEFAULT");
        localIntent.setData(Uri.parse(paramString));
        paramString = e.d(paramString);
        isDefaultDialog = false;
        paramString = new com.tencent.smtt.sdk.ui.dialog.d(paramContext, "选择其它应用打开", localIntent, paramBundle, paramValueCallback, paramString, str);
        paramBundle = paramString.a();
        if ((paramBundle == null) || (TextUtils.isEmpty(paramBundle))) {
          break;
        }
        if ("com.tencent.mtt".equals(paramBundle))
        {
          localIntent.putExtra("ChannelID", paramContext.getApplicationContext().getPackageName());
          localIntent.putExtra("PosID", "4");
        }
        localIntent.setPackage(paramBundle);
        localIntent.putExtra("big_brother_source_key", str);
        paramContext.startActivity(localIntent);
      } while (paramValueCallback == null);
      paramValueCallback.onReceiveValue("default browser:" + paramBundle);
      return;
      if (!isDefaultDialog) {
        break;
      }
      new AlertDialog.Builder(paramContext).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new QbSdk.8()).show();
    } while (paramValueCallback == null);
    paramValueCallback.onReceiveValue("can not open");
    return;
    paramString.show();
    paramString.setOnDismissListener(new QbSdk.9(paramValueCallback));
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
        Log.d("QbSdk", "openFileReader startQBForDoc return false");
      }
      for (;;)
      {
        localObject = paramHashMap;
        if (paramHashMap == null) {
          localObject = new HashMap();
        }
        ((HashMap)localObject).put("local", "true");
        TbsLog.setWriteLogJIT(true);
        int i1 = startMiniQBToLoadUrl(paramContext, paramString, (HashMap)localObject, paramValueCallback);
        if (i1 == 0) {
          break;
        }
        openFileReaderListWithQBDownload(paramContext, paramString, paramValueCallback);
        TbsLogReport.getInstance(paramContext).setLoadErrorCode(511, "" + i1);
        return 3;
        Log.d("QbSdk", "openFileReader QQ browser not installed");
      }
    }
    if (paramValueCallback != null) {
      paramValueCallback.onReceiveValue("filepath error");
    }
    TbsCoreLoadStat.getInstance().a(paramContext, 509);
    Log.e("QbSdk", "open openFileReader filepath error ret -1");
    return -1;
    TbsCoreLoadStat.getInstance().a(paramContext, 510);
    return 2;
  }
  
  public static void openFileReaderListWithQBDownload(Context paramContext, String paramString, Bundle paramBundle, ValueCallback<String> paramValueCallback)
  {
    if ((paramContext == null) || (paramContext.getApplicationInfo().packageName.equals("com.tencent.qim")) || (paramContext.getApplicationInfo().packageName.equals("com.tencent.tim")) || (paramContext.getApplicationInfo().packageName.equals("com.tencent.androidqqmail"))) {}
    do
    {
      return;
      String str1 = "";
      if (paramBundle != null) {
        str1 = paramBundle.getString("ChannelId");
      }
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addCategory("android.intent.category.DEFAULT");
      String str2 = e.d(paramString);
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
      TbsLog.i("QbSdk", "openFileReaderListWithQBDownload,fileUri:" + paramString + ",mimeType:" + str2);
      localIntent.setDataAndType(localUri, str2);
      isDefaultDialog = false;
      paramString = new com.tencent.smtt.sdk.ui.dialog.d(paramContext, "选择其它应用打开", localIntent, paramBundle, paramValueCallback, str2, str1);
      paramBundle = paramString.a();
      TbsLog.i("QbSdk", "openFileReaderListWithQBDownload,defaultBrowser:" + paramBundle);
      if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle)) && (paramBundle.startsWith("extraMenuEvent:")))
      {
        TbsLog.i("QbSdk", "openFileReaderListWithQBDownload, is default extra menu action");
        paramValueCallback.onReceiveValue(paramBundle);
        return;
      }
      if ((paramBundle == null) || (TextUtils.isEmpty(paramBundle)) || (!checkApkExist(paramContext, paramBundle))) {
        break;
      }
      TbsLog.i("QbSdk", "openFileReaderListWithQBDownload, is default normal menu action");
      if ("com.tencent.mtt".equals(paramBundle))
      {
        localIntent.putExtra("ChannelID", paramContext.getApplicationContext().getPackageName());
        localIntent.putExtra("PosID", "4");
      }
      if (!TextUtils.isEmpty(str1)) {
        localIntent.putExtra("big_brother_source_key", str1);
      }
      localIntent.setPackage(paramBundle);
      paramContext.startActivity(localIntent);
    } while (paramValueCallback == null);
    paramValueCallback.onReceiveValue("default browser:" + paramBundle);
    return;
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
        paramValueCallback.onReceiveValue("can not open");
      }
    }
    for (;;)
    {
      TbsLog.i("QbSdk", "unexpected return, dialogBuilder not show!");
      return;
      try
      {
        TbsLog.i("QbSdk", "isDefaultDialog=false,try to open dialog");
        paramString.show();
        paramString.setOnDismissListener(new QbSdk.7(paramValueCallback));
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        TbsLog.i("QbSdk", "isDefaultDialog=false,try to open dialog, but failed");
        paramValueCallback.onReceiveValue("TbsReaderDialogClosed");
      }
    }
  }
  
  public static void openFileReaderListWithQBDownload(Context paramContext, String paramString, ValueCallback<String> paramValueCallback)
  {
    openFileReaderListWithQBDownload(paramContext, paramString, null, paramValueCallback);
  }
  
  public static int openFileWithQB(Context paramContext, String paramString1, String paramString2)
  {
    int i1 = 0;
    TbsLog.i("QbSdk", "open openFileReader startMiniQBToLoadUrl filepath = " + paramString1);
    if (!checkContentProviderPrivilage(paramContext)) {
      i1 = -1;
    }
    String str;
    HashMap localHashMap;
    do
    {
      return i1;
      if (paramString1 == null) {
        break label168;
      }
      str = paramString1.substring(paramString1.lastIndexOf(".") + 1).toLowerCase();
      if (!MttLoader.isBrowserInstalled(paramContext)) {
        break;
      }
      if (!a(paramContext, paramString1, str))
      {
        TbsLog.i("QbSdk", "openFileReader open in QB isQBSupport: false");
        return -2;
      }
      localHashMap = new HashMap();
      localHashMap.put("ChannelID", paramContext.getApplicationContext().getApplicationInfo().processName);
      localHashMap.put("PosID", Integer.toString(4));
    } while (MttLoader.openDocWithQb(paramContext, paramString1, 0, str, paramString2, localHashMap, null));
    TbsLog.i("QbSdk", "openFileReader startQBForDoc return false");
    return -3;
    TbsLog.i("QbSdk", "openFileReader QQ browser not installed");
    return -4;
    label168:
    TbsLog.i("QbSdk", "open openFileReader filepath error");
    return -5;
  }
  
  public static void openNetLog(String paramString)
  {
    Object localObject = v.a();
    if ((localObject != null) && (((v)localObject).b())) {
      localObject = ((v)localObject).c().b();
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
      TbsLog.i("QbSdk", "preInit -- processName: " + getCurrentProcessName(paramContext));
      TbsLog.i("QbSdk", "preInit -- stack: " + Log.getStackTraceString(new Throwable("#")));
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
    int i1 = 1;
    TbsLog.e("QbSdk", "QbSdk reset!", true);
    for (;;)
    {
      try
      {
        TbsDownloader.stopDownload();
        if ((paramBoolean) && (!TbsShareManager.isThirdPartyApp(paramContext)))
        {
          int i2 = n.a().h(paramContext);
          int i3 = n.a().i(paramContext);
          if ((i2 > 43300) && (i2 != i3))
          {
            TbsDownloader.c(paramContext);
            FileUtil.a(getTbsFolderDir(paramContext), false, "core_share_decouple");
            TbsLog.i("QbSdk", "delete downloaded apk success", true);
            n.a.set(Integer.valueOf(0));
            File localFile = new File(paramContext.getFilesDir(), "bugly_switch.txt");
            if ((localFile != null) && (localFile.exists())) {
              localFile.delete();
            }
            if (i1 != 0)
            {
              FileUtil.b(n.a().p(paramContext), n.a().f(paramContext, 0));
              n.a().b(paramContext);
            }
            return;
          }
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(paramContext));
        return;
      }
      i1 = 0;
    }
  }
  
  public static void resetDecoupleCore(Context paramContext)
  {
    TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
    try
    {
      FileUtil.b(n.a().p(paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(paramContext));
    }
  }
  
  public static void setCurrentID(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.startsWith("QQ:")) {
      return;
    }
    paramString = paramString.substring("QQ:".length());
    z = "0000000000000000".substring(paramString.length()) + paramString;
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
    TbsLog.i("QbSdk", "setDisableUnpreinitBySwitch -- mDisableUnpreinitBySwitch is " + B);
  }
  
  public static void setDisableUseHostBackupCoreBySwitch(boolean paramBoolean)
  {
    mDisableUseHostBackupCore = paramBoolean;
    TbsLog.i("QbSdk", "setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is " + mDisableUseHostBackupCore);
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
    Object localObject = v.a();
    if ((localObject != null) && (((v)localObject).b())) {
      localObject = ((v)localObject).c().b();
    }
    try
    {
      ((DexLoader)localObject).invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "setNetLogEncryptionKey", new Class[] { String.class }, new Object[] { paramString });
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
    if ((paramInt >= 130) && (paramInt <= 139))
    {
      paramContext = TbsDownloadUpload.getInstance(paramContext);
      paramContext.a.put("tbs_needdownload_code", Integer.valueOf(paramInt));
      paramContext.commit();
    }
    while ((paramInt < 150) || (paramInt > 159)) {
      return;
    }
    paramContext = TbsDownloadUpload.getInstance(paramContext);
    paramContext.a.put("tbs_startdownload_code", Integer.valueOf(paramInt));
    paramContext.commit();
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, android.webkit.ValueCallback<String> paramValueCallback)
  {
    TbsCoreLoadStat.getInstance().a(paramContext, 501);
    if (paramContext == null) {
      return -100;
    }
    v localv = v.a();
    localv.a(paramContext, null);
    if (localv.b())
    {
      int i1;
      if ((paramContext == null) || (!paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) || (getTbsVersion(paramContext) >= 25487))
      {
        i1 = localv.c().a(paramContext, paramString, paramHashMap, null, paramValueCallback);
        if (i1 != 0) {
          break label131;
        }
        TbsCoreLoadStat.getInstance().a(paramContext, 503);
      }
      for (;;)
      {
        Log.e("QbSdk", "startMiniQBToLoadUrl  ret = " + i1);
        return i1;
        return -101;
        label131:
        TbsLogReport.getInstance(paramContext).setLoadErrorCode(504, "" + i1);
      }
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
        localObject = v.a();
        localWebView1 = paramWebView;
        if (localObject != null)
        {
          localWebView1 = paramWebView;
          if (((v)localObject).b())
          {
            localObject = ((v)localObject).c().b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
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
    return MttLoader.loadUrl(paramContext, paramString, localHashMap, "QbSdk.startQBToLoadurl", localWebView1) == 0;
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
    v localv = v.a();
    localv.a(paramContext, null);
    if (((paramHashMap == null) || (!"5".equals(paramHashMap.get("PosID"))) || (!localv.b()) || ((Bundle)localv.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]) == null)) || (MttLoader.loadUrl(paramContext, paramString, paramHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0))
    {
      if (localv.b()) {
        if ((paramContext == null) || (!paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) || (getTbsVersion(paramContext) >= 25487))
        {
          if (localv.c().a(paramContext, paramString, paramHashMap, null, paramValueCallback) == 0) {
            return true;
          }
        }
        else {
          return false;
        }
      }
    }
    else {
      return true;
    }
    return false;
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
    Object localObject = v.a();
    if ((localObject != null) && (((v)localObject).b())) {
      localObject = ((v)localObject).c().b();
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
    if (r == null) {
      return false;
    }
    Object localObject2 = i.a(r, "useSoftWare", new Class[0], new Object[0]);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = r;
      localObject2 = Integer.TYPE;
      int i1 = a.a();
      localObject1 = i.a(localObject1, "useSoftWare", new Class[] { localObject2 }, new Object[] { Integer.valueOf(i1) });
    }
    if (localObject1 == null) {}
    for (boolean bool = false;; bool = ((Boolean)localObject1).booleanValue()) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk
 * JD-Core Version:    0.7.0.1
 */
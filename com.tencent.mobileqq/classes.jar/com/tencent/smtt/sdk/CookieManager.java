package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.ReflectionUtils;
import com.tencent.smtt.utils.TbsLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class CookieManager
{
  private static final int FUNCTION_SET_COOKIE_WITHOUT_CALLBACK = 2;
  private static final int FUNCTION_SET_COOKIE_WITH_CALLBACK = 1;
  public static String LOGTAG = "CookieManager";
  private static final String SP_COOKIEINFO = "cookiedb_info";
  private static final String SP_KEY_COOKIEDB_VERSION = "db_version";
  private static final String SP_KEY_COOKIES = "key_cookie";
  private static CookieManager mInstance;
  CopyOnWriteArrayList<CookieManager.CookieInstance> cookieInstances;
  private boolean isCompatiableed = false;
  CookieManager.COOKIE_MODE mCookueMode = CookieManager.COOKIE_MODE.MODE_NONE;
  String mTargetKey;
  private boolean mbWebviewExist = false;
  
  public static CookieManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new CookieManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  public static int getROMCookieDBVersion(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = paramContext.getSharedPreferences("cookiedb_info", 4);; paramContext = paramContext.getSharedPreferences("cookiedb_info", 0)) {
      return paramContext.getInt("db_version", -1);
    }
  }
  
  public static void setROMCookieDBVersion(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = paramContext.getSharedPreferences("cookiedb_info", 4);; paramContext = paramContext.getSharedPreferences("cookiedb_info", 0))
    {
      paramContext = paramContext.edit();
      paramContext.putInt("db_version", paramInt);
      paramContext.commit();
      return;
    }
  }
  
  public boolean acceptCookie()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().cookieManager_acceptCookie();
    }
    return android.webkit.CookieManager.getInstance().acceptCookie();
  }
  
  /* Error */
  public boolean acceptThirdPartyCookies(WebView paramWebView)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 98	com/tencent/smtt/sdk/X5CoreEngine:getInstance	()Lcom/tencent/smtt/sdk/X5CoreEngine;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnull +70 -> 77
    //   10: aload_3
    //   11: invokevirtual 101	com/tencent/smtt/sdk/X5CoreEngine:isX5Core	()Z
    //   14: ifeq +63 -> 77
    //   17: aload_3
    //   18: invokevirtual 105	com/tencent/smtt/sdk/X5CoreEngine:wizard	()Lcom/tencent/smtt/sdk/X5CoreWizard;
    //   21: invokevirtual 123	com/tencent/smtt/sdk/X5CoreWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   24: astore_3
    //   25: aload_1
    //   26: invokevirtual 129	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   29: astore_1
    //   30: aload_3
    //   31: ldc 131
    //   33: ldc 133
    //   35: iconst_1
    //   36: anewarray 135	java/lang/Class
    //   39: dup
    //   40: iconst_0
    //   41: ldc 4
    //   43: aastore
    //   44: iconst_1
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_1
    //   51: aastore
    //   52: invokevirtual 141	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull +15 -> 72
    //   60: aload_1
    //   61: checkcast 143	java/lang/Boolean
    //   64: invokevirtual 146	java/lang/Boolean:booleanValue	()Z
    //   67: istore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: iload_2
    //   71: ireturn
    //   72: iconst_1
    //   73: istore_2
    //   74: goto -6 -> 68
    //   77: getstatic 64	android/os/Build$VERSION:SDK_INT	I
    //   80: bipush 21
    //   82: if_icmpge +8 -> 90
    //   85: iconst_1
    //   86: istore_2
    //   87: goto -19 -> 68
    //   90: invokestatic 115	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   93: astore_3
    //   94: aload_1
    //   95: invokevirtual 129	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   98: astore_1
    //   99: aload_3
    //   100: ldc 147
    //   102: iconst_1
    //   103: anewarray 135	java/lang/Class
    //   106: dup
    //   107: iconst_0
    //   108: ldc 149
    //   110: aastore
    //   111: iconst_1
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload_1
    //   118: aastore
    //   119: invokestatic 155	com/tencent/smtt/utils/ReflectionUtils:invokeInstance	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +14 -> 138
    //   127: aload_1
    //   128: checkcast 143	java/lang/Boolean
    //   131: invokevirtual 146	java/lang/Boolean:booleanValue	()Z
    //   134: istore_2
    //   135: goto -67 -> 68
    //   138: iconst_0
    //   139: istore_2
    //   140: goto -72 -> 68
    //   143: astore_1
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	CookieManager
    //   0	148	1	paramWebView	WebView
    //   67	73	2	bool	boolean
    //   5	95	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	143	finally
    //   10	56	143	finally
    //   60	68	143	finally
    //   77	85	143	finally
    //   90	123	143	finally
    //   127	135	143	finally
  }
  
  protected void compatiableCookieDatabaseIfNeed(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 0;
    int j = 0;
    for (;;)
    {
      boolean bool;
      long l2;
      long l1;
      label121:
      TbsLogReport.TbsLogInfo localTbsLogInfo;
      label261:
      try
      {
        if ((this.mCookueMode != CookieManager.COOKIE_MODE.MODE_NONE) && (paramContext != null) && (TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "cookie_switch.txt")))
        {
          bool = this.isCompatiableed;
          if (!bool) {}
        }
        else
        {
          return;
        }
        l2 = System.currentTimeMillis();
        l1 = 0L;
        TbsLog.i(LOGTAG, "compatiableCookieDatabaseIfNeed,isX5Inited:" + paramBoolean1 + ",useX5:" + paramBoolean2);
        if ((!paramBoolean1) && (!QbSdk.getIsSysWebViewForcedByOuter()) && (!QbSdk.mIsSysWebViewForced)) {
          break label477;
        }
        if ((QbSdk.getIsSysWebViewForcedByOuter()) || (QbSdk.mIsSysWebViewForced)) {
          break label506;
        }
        bool = TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "usex5.txt");
        TbsLog.i(LOGTAG, "usex5 : mUseX5LastProcess->" + bool + ",useX5:" + paramBoolean2);
        TbsExtensionFunctionManager.getInstance().setFunctionEnable(paramContext, "usex5.txt", paramBoolean2);
        if (bool == paramBoolean2) {
          continue;
        }
        localTbsLogInfo = TbsLogReport.getInstance(paramContext).tbsLogInfo();
        if (TextUtils.isEmpty(this.mTargetKey)) {
          break label463;
        }
        if ((TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext) > 0) && (TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext) < 36001)) {
          continue;
        }
        if (!bool) {
          break label348;
        }
        i = SqliteDataManager.getCookieDBVersion(paramContext);
        j = i;
        if (i <= 0) {
          break label488;
        }
        j = getROMCookieDBVersion(paramContext);
        if (j > 0) {
          break label501;
        }
        paramBoolean1 = true;
      }
      finally {}
      localTbsLogInfo.setErrorCode(702);
      label269:
      localTbsLogInfo.setFailDetail("x5->sys:" + bool + " from:" + i + " to:" + j + ",timeused:" + l1);
      TbsLogReport.getInstance(paramContext).eventReport(TbsLogReport.EventType.TYPE_COOKIE_DB_SWITCH, localTbsLogInfo);
      continue;
      label348:
      int i = SqliteDataManager.getCookieDBVersion(paramContext);
      j = i;
      if (i > 0)
      {
        String str = TbsInstaller.getInstance().getConfileFileProperty(paramContext, "cookies_database_version");
        paramBoolean1 = TextUtils.isEmpty(str);
        j = i;
        if (!paramBoolean1) {
          try
          {
            j = Integer.parseInt(str);
            paramBoolean1 = false;
          }
          catch (Exception localException)
          {
            paramBoolean1 = false;
            j = k;
          }
        }
      }
      label463:
      label477:
      label488:
      label501:
      label506:
      do
      {
        do
        {
          if (j >= i)
          {
            localTbsLogInfo.setErrorCode(703);
            break label269;
          }
          SqliteDataManager.transformCookies(paramContext, this.mCookueMode, this.mTargetKey, paramBoolean1, paramBoolean2);
          localTbsLogInfo.setErrorCode(704);
          l1 = System.currentTimeMillis() - l2;
          break label269;
          localTbsLogInfo.setErrorCode(701);
          i = 0;
          break label269;
          X5CoreEngine.getInstance().init(paramContext, null);
          break;
          i = j;
          paramBoolean1 = false;
          j = k;
          continue;
          paramBoolean1 = false;
          continue;
          paramBoolean2 = false;
          break label121;
        } while (paramBoolean1);
        if (i <= 0) {
          break label261;
        }
      } while (j > 0);
    }
  }
  
  public void flush()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    ReflectionUtils.invokeInstance(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
  }
  
  public String getCookie(String paramString)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().getCookie(paramString);
    }
    try
    {
      paramString = android.webkit.CookieManager.getInstance().getCookie(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public boolean hasCookies()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().cookieManager_hasCookies();
    }
    return android.webkit.CookieManager.getInstance().hasCookies();
  }
  
  public void removeAllCookie()
  {
    if (this.cookieInstances != null) {
      this.cookieInstances.clear();
    }
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().cookieManager_removeAllCookie();
      return;
    }
    android.webkit.CookieManager.getInstance().removeAllCookie();
  }
  
  public void removeAllCookies(ValueCallback<Boolean> paramValueCallback)
  {
    if (this.cookieInstances != null) {
      this.cookieInstances.clear();
    }
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    ReflectionUtils.invokeInstance(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  public void removeExpiredCookie()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
      return;
    }
    android.webkit.CookieManager.getInstance().removeExpiredCookie();
  }
  
  public void removeSessionCookie()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
      return;
    }
    android.webkit.CookieManager.getInstance().removeSessionCookie();
  }
  
  public void removeSessionCookies(ValueCallback<Boolean> paramValueCallback)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    ReflectionUtils.invokeInstance(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  /* Error */
  public void setAcceptCookie(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 98	com/tencent/smtt/sdk/X5CoreEngine:getInstance	()Lcom/tencent/smtt/sdk/X5CoreEngine;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnull +50 -> 57
    //   10: aload_2
    //   11: invokevirtual 101	com/tencent/smtt/sdk/X5CoreEngine:isX5Core	()Z
    //   14: ifeq +43 -> 57
    //   17: aload_2
    //   18: invokevirtual 105	com/tencent/smtt/sdk/X5CoreEngine:wizard	()Lcom/tencent/smtt/sdk/X5CoreWizard;
    //   21: invokevirtual 123	com/tencent/smtt/sdk/X5CoreWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   24: ldc 131
    //   26: ldc_w 363
    //   29: iconst_1
    //   30: anewarray 135	java/lang/Class
    //   33: dup
    //   34: iconst_0
    //   35: getstatic 367	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   38: aastore
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: iload_1
    //   46: invokestatic 371	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   49: aastore
    //   50: invokevirtual 141	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   53: pop
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: invokestatic 115	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   60: iload_1
    //   61: invokevirtual 373	android/webkit/CookieManager:setAcceptCookie	(Z)V
    //   64: goto -10 -> 54
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 317	java/lang/Throwable:printStackTrace	()V
    //   72: goto -18 -> 54
    //   75: astore_2
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_2
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	CookieManager
    //   0	80	1	paramBoolean	boolean
    //   5	13	2	localX5CoreEngine	X5CoreEngine
    //   67	2	2	localThrowable	Throwable
    //   75	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   57	64	67	java/lang/Throwable
    //   2	6	75	finally
    //   10	54	75	finally
    //   57	64	75	finally
    //   68	72	75	finally
  }
  
  /* Error */
  public void setAcceptThirdPartyCookies(WebView paramWebView, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 98	com/tencent/smtt/sdk/X5CoreEngine:getInstance	()Lcom/tencent/smtt/sdk/X5CoreEngine;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnull +70 -> 77
    //   10: aload_3
    //   11: invokevirtual 101	com/tencent/smtt/sdk/X5CoreEngine:isX5Core	()Z
    //   14: ifeq +63 -> 77
    //   17: aload_3
    //   18: invokevirtual 105	com/tencent/smtt/sdk/X5CoreEngine:wizard	()Lcom/tencent/smtt/sdk/X5CoreWizard;
    //   21: invokevirtual 123	com/tencent/smtt/sdk/X5CoreWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   24: astore_3
    //   25: getstatic 367	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   28: astore 4
    //   30: aload_1
    //   31: invokevirtual 129	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   34: astore_1
    //   35: aload_3
    //   36: ldc 131
    //   38: ldc_w 377
    //   41: iconst_2
    //   42: anewarray 135	java/lang/Class
    //   45: dup
    //   46: iconst_0
    //   47: ldc 4
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: aload 4
    //   54: aastore
    //   55: iconst_2
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_1
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: iload_2
    //   66: invokestatic 371	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   69: aastore
    //   70: invokevirtual 141	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   73: pop
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: getstatic 64	android/os/Build$VERSION:SDK_INT	I
    //   80: bipush 21
    //   82: if_icmplt -8 -> 74
    //   85: invokestatic 115	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   88: astore_3
    //   89: getstatic 367	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   92: astore 4
    //   94: aload_1
    //   95: invokevirtual 129	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   98: astore_1
    //   99: aload_3
    //   100: ldc_w 378
    //   103: iconst_2
    //   104: anewarray 135	java/lang/Class
    //   107: dup
    //   108: iconst_0
    //   109: ldc 149
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: aload 4
    //   116: aastore
    //   117: iconst_2
    //   118: anewarray 4	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_1
    //   124: aastore
    //   125: dup
    //   126: iconst_1
    //   127: iload_2
    //   128: invokestatic 371	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   131: aastore
    //   132: invokestatic 155	com/tencent/smtt/utils/ReflectionUtils:invokeInstance	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   135: pop
    //   136: goto -62 -> 74
    //   139: astore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_1
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	CookieManager
    //   0	144	1	paramWebView	WebView
    //   0	144	2	paramBoolean	boolean
    //   5	95	3	localObject	Object
    //   28	87	4	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   2	6	139	finally
    //   10	74	139	finally
    //   77	136	139	finally
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    try
    {
      setCookie(paramString1, paramString2, false);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public void setCookie(String paramString1, String paramString2, ValueCallback<Boolean> paramValueCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 98	com/tencent/smtt/sdk/X5CoreEngine:getInstance	()Lcom/tencent/smtt/sdk/X5CoreEngine;
    //   5: astore 4
    //   7: aload 4
    //   9: ifnull +69 -> 78
    //   12: aload 4
    //   14: invokevirtual 101	com/tencent/smtt/sdk/X5CoreEngine:isX5Core	()Z
    //   17: ifeq +61 -> 78
    //   20: aload 4
    //   22: invokevirtual 105	com/tencent/smtt/sdk/X5CoreEngine:wizard	()Lcom/tencent/smtt/sdk/X5CoreWizard;
    //   25: invokevirtual 123	com/tencent/smtt/sdk/X5CoreWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   28: ldc 131
    //   30: ldc_w 385
    //   33: iconst_3
    //   34: anewarray 135	java/lang/Class
    //   37: dup
    //   38: iconst_0
    //   39: ldc_w 387
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: ldc_w 387
    //   48: aastore
    //   49: dup
    //   50: iconst_2
    //   51: ldc_w 342
    //   54: aastore
    //   55: iconst_3
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_1
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: aload_2
    //   66: aastore
    //   67: dup
    //   68: iconst_2
    //   69: aload_3
    //   70: aastore
    //   71: invokevirtual 141	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: invokestatic 98	com/tencent/smtt/sdk/X5CoreEngine:getInstance	()Lcom/tencent/smtt/sdk/X5CoreEngine;
    //   81: invokevirtual 390	com/tencent/smtt/sdk/X5CoreEngine:isInited	()Z
    //   84: ifne +65 -> 149
    //   87: new 392	com/tencent/smtt/sdk/CookieManager$CookieInstance
    //   90: dup
    //   91: aload_0
    //   92: invokespecial 395	com/tencent/smtt/sdk/CookieManager$CookieInstance:<init>	(Lcom/tencent/smtt/sdk/CookieManager;)V
    //   95: astore 4
    //   97: aload 4
    //   99: iconst_1
    //   100: putfield 398	com/tencent/smtt/sdk/CookieManager$CookieInstance:function	I
    //   103: aload 4
    //   105: aload_1
    //   106: putfield 401	com/tencent/smtt/sdk/CookieManager$CookieInstance:url	Ljava/lang/String;
    //   109: aload 4
    //   111: aload_2
    //   112: putfield 404	com/tencent/smtt/sdk/CookieManager$CookieInstance:value	Ljava/lang/String;
    //   115: aload 4
    //   117: aload_3
    //   118: putfield 408	com/tencent/smtt/sdk/CookieManager$CookieInstance:valueCallback	Lcom/tencent/smtt/sdk/ValueCallback;
    //   121: aload_0
    //   122: getfield 326	com/tencent/smtt/sdk/CookieManager:cookieInstances	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   125: ifnonnull +14 -> 139
    //   128: aload_0
    //   129: new 328	java/util/concurrent/CopyOnWriteArrayList
    //   132: dup
    //   133: invokespecial 409	java/util/concurrent/CopyOnWriteArrayList:<init>	()V
    //   136: putfield 326	com/tencent/smtt/sdk/CookieManager:cookieInstances	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   139: aload_0
    //   140: getfield 326	com/tencent/smtt/sdk/CookieManager:cookieInstances	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   143: aload 4
    //   145: invokevirtual 413	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   148: pop
    //   149: aload_0
    //   150: getfield 52	com/tencent/smtt/sdk/CookieManager:mbWebviewExist	Z
    //   153: ifeq -78 -> 75
    //   156: getstatic 64	android/os/Build$VERSION:SDK_INT	I
    //   159: bipush 21
    //   161: if_icmplt -86 -> 75
    //   164: invokestatic 115	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   167: ldc_w 414
    //   170: iconst_3
    //   171: anewarray 135	java/lang/Class
    //   174: dup
    //   175: iconst_0
    //   176: ldc_w 387
    //   179: aastore
    //   180: dup
    //   181: iconst_1
    //   182: ldc_w 387
    //   185: aastore
    //   186: dup
    //   187: iconst_2
    //   188: ldc_w 342
    //   191: aastore
    //   192: iconst_3
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload_1
    //   199: aastore
    //   200: dup
    //   201: iconst_1
    //   202: aload_2
    //   203: aastore
    //   204: dup
    //   205: iconst_2
    //   206: aload_3
    //   207: aastore
    //   208: invokestatic 155	com/tencent/smtt/utils/ReflectionUtils:invokeInstance	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   211: pop
    //   212: goto -137 -> 75
    //   215: astore_1
    //   216: aload_0
    //   217: monitorexit
    //   218: aload_1
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	CookieManager
    //   0	220	1	paramString1	String
    //   0	220	2	paramString2	String
    //   0	220	3	paramValueCallback	ValueCallback<Boolean>
    //   5	139	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	215	finally
    //   12	75	215	finally
    //   78	139	215	finally
    //   139	149	215	finally
    //   149	212	215	finally
  }
  
  /* Error */
  public void setCookie(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 98	com/tencent/smtt/sdk/X5CoreEngine:getInstance	()Lcom/tencent/smtt/sdk/X5CoreEngine;
    //   5: astore 4
    //   7: aload 4
    //   9: ifnull +59 -> 68
    //   12: aload 4
    //   14: invokevirtual 101	com/tencent/smtt/sdk/X5CoreEngine:isX5Core	()Z
    //   17: ifeq +51 -> 68
    //   20: aload 4
    //   22: invokevirtual 105	com/tencent/smtt/sdk/X5CoreEngine:wizard	()Lcom/tencent/smtt/sdk/X5CoreWizard;
    //   25: invokevirtual 123	com/tencent/smtt/sdk/X5CoreWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   28: ldc 131
    //   30: ldc_w 385
    //   33: iconst_2
    //   34: anewarray 135	java/lang/Class
    //   37: dup
    //   38: iconst_0
    //   39: ldc_w 387
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: ldc_w 387
    //   48: aastore
    //   49: iconst_2
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_1
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: aload_2
    //   60: aastore
    //   61: invokevirtual 141	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   64: pop
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload_0
    //   69: getfield 52	com/tencent/smtt/sdk/CookieManager:mbWebviewExist	Z
    //   72: ifne +7 -> 79
    //   75: iload_3
    //   76: ifeq +11 -> 87
    //   79: invokestatic 115	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   82: aload_1
    //   83: aload_2
    //   84: invokevirtual 417	android/webkit/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: invokestatic 98	com/tencent/smtt/sdk/X5CoreEngine:getInstance	()Lcom/tencent/smtt/sdk/X5CoreEngine;
    //   90: invokevirtual 390	com/tencent/smtt/sdk/X5CoreEngine:isInited	()Z
    //   93: ifne -28 -> 65
    //   96: new 392	com/tencent/smtt/sdk/CookieManager$CookieInstance
    //   99: dup
    //   100: aload_0
    //   101: invokespecial 395	com/tencent/smtt/sdk/CookieManager$CookieInstance:<init>	(Lcom/tencent/smtt/sdk/CookieManager;)V
    //   104: astore 4
    //   106: aload 4
    //   108: iconst_2
    //   109: putfield 398	com/tencent/smtt/sdk/CookieManager$CookieInstance:function	I
    //   112: aload 4
    //   114: aload_1
    //   115: putfield 401	com/tencent/smtt/sdk/CookieManager$CookieInstance:url	Ljava/lang/String;
    //   118: aload 4
    //   120: aload_2
    //   121: putfield 404	com/tencent/smtt/sdk/CookieManager$CookieInstance:value	Ljava/lang/String;
    //   124: aload 4
    //   126: aconst_null
    //   127: putfield 408	com/tencent/smtt/sdk/CookieManager$CookieInstance:valueCallback	Lcom/tencent/smtt/sdk/ValueCallback;
    //   130: aload_0
    //   131: getfield 326	com/tencent/smtt/sdk/CookieManager:cookieInstances	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   134: ifnonnull +14 -> 148
    //   137: aload_0
    //   138: new 328	java/util/concurrent/CopyOnWriteArrayList
    //   141: dup
    //   142: invokespecial 409	java/util/concurrent/CopyOnWriteArrayList:<init>	()V
    //   145: putfield 326	com/tencent/smtt/sdk/CookieManager:cookieInstances	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   148: aload_0
    //   149: getfield 326	com/tencent/smtt/sdk/CookieManager:cookieInstances	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   152: aload 4
    //   154: invokevirtual 413	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   157: pop
    //   158: goto -93 -> 65
    //   161: astore_1
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	CookieManager
    //   0	166	1	paramString1	String
    //   0	166	2	paramString2	String
    //   0	166	3	paramBoolean	boolean
    //   5	148	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	161	finally
    //   12	65	161	finally
    //   68	75	161	finally
    //   79	87	161	finally
    //   87	148	161	finally
    //   148	158	161	finally
  }
  
  public boolean setCookieCompatialbeMode(Context paramContext, CookieManager.COOKIE_MODE paramCOOKIE_MODE, String paramString, boolean paramBoolean)
  {
    System.currentTimeMillis();
    if ((paramContext == null) || (!TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "cookie_switch.txt"))) {
      return false;
    }
    this.mCookueMode = paramCOOKIE_MODE;
    if (paramString != null) {
      this.mTargetKey = paramString;
    }
    if ((this.mCookueMode != CookieManager.COOKIE_MODE.MODE_NONE) && (paramBoolean) && (!X5CoreEngine.getInstance().isInited())) {
      X5CoreEngine.getInstance().init(paramContext, null);
    }
    return true;
  }
  
  public void setCookies(Map<String, String[]> paramMap)
  {
    Object localObject = X5CoreEngine.getInstance();
    if ((localObject != null) && (((X5CoreEngine)localObject).isX5Core())) {}
    for (boolean bool = ((X5CoreEngine)localObject).wizard().cookieManager_setCookies(paramMap);; bool = false)
    {
      if (!bool)
      {
        localObject = paramMap.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          String[] arrayOfString = (String[])paramMap.get(str);
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            setCookie(str, arrayOfString[i]);
            i += 1;
          }
        }
      }
      return;
    }
  }
  
  void syncCookies()
  {
    label26:
    label52:
    Object localObject3;
    for (;;)
    {
      try
      {
        this.mbWebviewExist = true;
        if (this.cookieInstances != null)
        {
          int i = this.cookieInstances.size();
          if (i != 0) {}
        }
        else
        {
          return;
        }
        Object localObject1 = X5CoreEngine.getInstance();
        if ((localObject1 == null) || (!((X5CoreEngine)localObject1).isX5Core())) {
          break;
        }
        localObject1 = this.cookieInstances.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label296;
        }
        localObject3 = (CookieManager.CookieInstance)((Iterator)localObject1).next();
        switch (((CookieManager.CookieInstance)localObject3).function)
        {
        case 1: 
          setCookie(((CookieManager.CookieInstance)localObject3).url, ((CookieManager.CookieInstance)localObject3).value, ((CookieManager.CookieInstance)localObject3).valueCallback);
          break;
        case 2: 
          setCookie(((CookieManager.CookieInstance)localObject3).url, ((CookieManager.CookieInstance)localObject3).value);
        }
      }
      finally {}
    }
    Iterator localIterator = this.cookieInstances.iterator();
    for (;;)
    {
      Object localObject4;
      if (localIterator.hasNext()) {
        localObject4 = (CookieManager.CookieInstance)localIterator.next();
      }
      switch (((CookieManager.CookieInstance)localObject4).function)
      {
      case 1: 
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject3 = android.webkit.CookieManager.getInstance();
          String str1 = ((CookieManager.CookieInstance)localObject4).url;
          String str2 = ((CookieManager.CookieInstance)localObject4).value;
          localObject4 = ((CookieManager.CookieInstance)localObject4).valueCallback;
          ReflectionUtils.invokeInstance(localObject3, "setCookie", new Class[] { String.class, String.class, android.webkit.ValueCallback.class }, new Object[] { str1, str2, localObject4 });
        }
        break;
      case 2: 
        android.webkit.CookieManager.getInstance().setCookie(((CookieManager.CookieInstance)localObject4).url, ((CookieManager.CookieInstance)localObject4).value);
        continue;
        label296:
        this.cookieInstances.clear();
        break label26;
        break label52;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.CookieManager
 * JD-Core Version:    0.7.0.1
 */
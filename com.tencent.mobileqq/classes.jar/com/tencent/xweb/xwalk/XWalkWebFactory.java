package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.xweb.JsRuntime.JsRuntimeType;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.ad;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import com.tencent.xweb.internal.IJsRuntime;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.p;
import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.XWebCoreScheduler;
import com.tencent.xweb.xwalk.updater.a.b;
import java.lang.reflect.Method;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkViewDatabase;
import org.xwalk.core.resource.XWalkContextWrapper;

public class XWalkWebFactory
  implements l.a
{
  private static final String TAG = "XWalkWebFactory";
  static XWalkWebFactory sInstance;
  private boolean mIsDebugMode = false;
  private boolean mIsDebugModeReplase = false;
  
  private XWalkWebFactory()
  {
    p.a(new XWalkWebFactory.a(null));
  }
  
  public static XWalkWebFactory getInstance()
  {
    if (sInstance == null)
    {
      ad.b();
      sInstance = new XWalkWebFactory();
    }
    return sInstance;
  }
  
  /* Error */
  public static boolean tryLoadLocalAssetRuntime(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 57	org/xwalk/core/XWalkEnvironment:init	(Landroid/content/Context;)V
    //   7: iload_1
    //   8: ifeq +17 -> 25
    //   11: invokestatic 61	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   14: ldc 62
    //   16: if_icmpne +9 -> 25
    //   19: ldc 62
    //   21: invokestatic 66	org/xwalk/core/XWalkEnvironment:delApiVersion	(I)Z
    //   24: pop
    //   25: invokestatic 61	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   28: istore_2
    //   29: iload_2
    //   30: iconst_m1
    //   31: if_icmpeq +7 -> 38
    //   34: iload_1
    //   35: ifeq +202 -> 237
    //   38: aconst_null
    //   39: astore 5
    //   41: aconst_null
    //   42: astore 4
    //   44: aload_0
    //   45: invokevirtual 72	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   48: ldc 74
    //   50: invokevirtual 80	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   53: astore_3
    //   54: new 82	java/io/File
    //   57: dup
    //   58: ldc 62
    //   60: invokestatic 86	org/xwalk/core/XWalkEnvironment:getDownloadZipDir	(I)Ljava/lang/String;
    //   63: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: astore 4
    //   68: aload 4
    //   70: invokevirtual 93	java/io/File:exists	()Z
    //   73: ifeq +9 -> 82
    //   76: aload 4
    //   78: invokevirtual 96	java/io/File:delete	()Z
    //   81: pop
    //   82: new 98	java/io/FileOutputStream
    //   85: dup
    //   86: aload 4
    //   88: invokespecial 101	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   91: astore 4
    //   93: ldc 102
    //   95: newarray byte
    //   97: astore 5
    //   99: aload_3
    //   100: aload 5
    //   102: invokevirtual 108	java/io/InputStream:read	([B)I
    //   105: istore_2
    //   106: iload_2
    //   107: iconst_m1
    //   108: if_icmpeq +15 -> 123
    //   111: aload 4
    //   113: aload 5
    //   115: iconst_0
    //   116: iload_2
    //   117: invokevirtual 112	java/io/FileOutputStream:write	([BII)V
    //   120: goto -21 -> 99
    //   123: aload 4
    //   125: invokevirtual 115	java/io/FileOutputStream:flush	()V
    //   128: invokestatic 120	org/xwalk/core/XWalkUpdater:updateLocalXWalkRuntime	()V
    //   131: invokestatic 123	org/xwalk/core/XWalkEnvironment:resetForDebug	()V
    //   134: aload_0
    //   135: invokestatic 57	org/xwalk/core/XWalkEnvironment:init	(Landroid/content/Context;)V
    //   138: aload_3
    //   139: ifnull +7 -> 146
    //   142: aload_3
    //   143: invokevirtual 126	java/io/InputStream:close	()V
    //   146: aload 4
    //   148: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   151: ldc 2
    //   153: monitorexit
    //   154: iconst_1
    //   155: ireturn
    //   156: astore 5
    //   158: aload 4
    //   160: astore_0
    //   161: aload 5
    //   163: astore 4
    //   165: goto +79 -> 244
    //   168: astore 5
    //   170: aload 4
    //   172: astore_0
    //   173: aload 5
    //   175: astore 4
    //   177: goto +15 -> 192
    //   180: astore 4
    //   182: aload 5
    //   184: astore_0
    //   185: goto +59 -> 244
    //   188: astore 4
    //   190: aconst_null
    //   191: astore_0
    //   192: goto +24 -> 216
    //   195: astore 4
    //   197: aconst_null
    //   198: astore_3
    //   199: aload 5
    //   201: astore_0
    //   202: goto +42 -> 244
    //   205: astore 5
    //   207: aconst_null
    //   208: astore_0
    //   209: aload 4
    //   211: astore_3
    //   212: aload 5
    //   214: astore 4
    //   216: aload 4
    //   218: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   221: aload_3
    //   222: ifnull +7 -> 229
    //   225: aload_3
    //   226: invokevirtual 126	java/io/InputStream:close	()V
    //   229: aload_0
    //   230: ifnull +7 -> 237
    //   233: aload_0
    //   234: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   237: ldc 2
    //   239: monitorexit
    //   240: iconst_0
    //   241: ireturn
    //   242: astore 4
    //   244: aload_3
    //   245: ifnull +7 -> 252
    //   248: aload_3
    //   249: invokevirtual 126	java/io/InputStream:close	()V
    //   252: aload_0
    //   253: ifnull +7 -> 260
    //   256: aload_0
    //   257: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   260: aload 4
    //   262: athrow
    //   263: astore_0
    //   264: ldc 2
    //   266: monitorexit
    //   267: goto +5 -> 272
    //   270: aload_0
    //   271: athrow
    //   272: goto -2 -> 270
    //   275: astore_0
    //   276: goto -130 -> 146
    //   279: astore_0
    //   280: goto -129 -> 151
    //   283: astore_3
    //   284: goto -55 -> 229
    //   287: astore_0
    //   288: goto -51 -> 237
    //   291: astore_3
    //   292: goto -40 -> 252
    //   295: astore_0
    //   296: goto -36 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramContext	Context
    //   0	299	1	paramBoolean	boolean
    //   28	89	2	i	int
    //   53	196	3	localObject1	Object
    //   283	1	3	localException1	Exception
    //   291	1	3	localException2	Exception
    //   42	134	4	localObject2	Object
    //   180	1	4	localObject3	Object
    //   188	1	4	localIOException1	java.io.IOException
    //   195	15	4	localObject4	Object
    //   214	3	4	localIOException2	java.io.IOException
    //   242	19	4	localObject5	Object
    //   39	75	5	arrayOfByte	byte[]
    //   156	6	5	localObject6	Object
    //   168	32	5	localIOException3	java.io.IOException
    //   205	8	5	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   93	99	156	finally
    //   99	106	156	finally
    //   111	120	156	finally
    //   123	138	156	finally
    //   93	99	168	java/io/IOException
    //   99	106	168	java/io/IOException
    //   111	120	168	java/io/IOException
    //   123	138	168	java/io/IOException
    //   54	82	180	finally
    //   82	93	180	finally
    //   54	82	188	java/io/IOException
    //   82	93	188	java/io/IOException
    //   44	54	195	finally
    //   44	54	205	java/io/IOException
    //   216	221	242	finally
    //   3	7	263	finally
    //   11	25	263	finally
    //   25	29	263	finally
    //   142	146	263	finally
    //   146	151	263	finally
    //   225	229	263	finally
    //   233	237	263	finally
    //   248	252	263	finally
    //   256	260	263	finally
    //   260	263	263	finally
    //   142	146	275	java/lang/Exception
    //   146	151	279	java/lang/Exception
    //   225	229	283	java/lang/Exception
    //   233	237	287	java/lang/Exception
    //   248	252	291	java/lang/Exception
    //   256	260	295	java/lang/Exception
  }
  
  public void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    if (WebView.getCurWebType() != WebView.c.b) {
      return;
    }
    try
    {
      if (XWalkEnvironment.getAvailableVersion() <= 0) {
        return;
      }
      paramContext = new XWalkView(new XWalkContextWrapper(XWalkEnvironment.getApplicationContext(), XWalkEnvironment.getAvailableVersion()));
      paramContext.removeJavascriptInterface("searchBoxJavaBridge_");
      paramContext.removeJavascriptInterface("accessibility");
      paramContext.removeJavascriptInterface("accessibilityTraversal");
      paramContext.clearCache(true);
      XWalkViewDatabase.clearFormData();
      if (paramBoolean)
      {
        paramContext = getCookieManager();
        if (paramContext != null)
        {
          paramContext.a();
          return;
        }
      }
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearAllWebViewCache exception 1 -- ");
      localStringBuilder.append(paramContext.getMessage());
      org.xwalk.core.Log.e("XWalkWebFactory", localStringBuilder.toString());
    }
  }
  
  public IWebView createWebView(WebView paramWebView)
  {
    try
    {
      if (k.a(paramWebView.getContext()))
      {
        WebViewExtension.updateExtension(false);
        paramWebView = new k(paramWebView);
        return paramWebView;
      }
    }
    catch (Exception paramWebView)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init xwalk crashed:");
      localStringBuilder.append(paramWebView.getMessage());
      localStringBuilder.append(",stacktrace:");
      localStringBuilder.append(android.util.Log.getStackTraceString(paramWebView));
      paramWebView = localStringBuilder.toString();
      org.xwalk.core.Log.e("XWalkWebFactory", paramWebView);
      XWalkInitializer.addXWalkInitializeLog(paramWebView);
    }
    return null;
  }
  
  public IWebStorage createWebviewStorage()
  {
    return new j();
  }
  
  public Object excute(String paramString, Object[] paramArrayOfObject)
  {
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return null;
      }
      if (paramString.equals("STR_CMD_INVOKE_TO_RUNTIME"))
      {
        if (paramArrayOfObject != null)
        {
          if (paramArrayOfObject.length < 2) {
            return null;
          }
          try
          {
            if (XWalkCoreWrapper.getInstance() == null) {
              break label722;
            }
            paramString = XWalkCoreWrapper.invokeRuntimeChannel(((Integer)paramArrayOfObject[0]).intValue(), (Object[])paramArrayOfObject[1]);
            return paramString;
          }
          catch (Exception paramString)
          {
            paramArrayOfObject = new StringBuilder();
            paramArrayOfObject.append("STR_CMD_INVOKE_TO_RUNTIME failed , err = ");
            paramArrayOfObject.append(paramString.getMessage());
            org.xwalk.core.Log.e("XWalkWebFactory", paramArrayOfObject.toString());
            return null;
          }
        }
        else
        {
          return null;
        }
      }
      else
      {
        if (paramString.equals("STR_CMD_EXXCUTE_CMD_FROM_CONFIG"))
        {
          if (paramArrayOfObject != null)
          {
            if (paramArrayOfObject.length < 1) {
              return null;
            }
            return a.a(paramArrayOfObject[0]);
          }
          return null;
        }
        if (paramString.equals("STR_CMD_GET_DEBUG_VIEW")) {
          return new d((WebView)paramArrayOfObject[0]);
        }
        if (paramString.equals("STR_CMD_GET_UPDATER")) {
          return new p.a();
        }
        if (paramString.equals("STR_CMD_GET_PLUGIN_UPDATER")) {
          return new com.tencent.luggage.wxa.su.k();
        }
        if (paramString.equals("STR_CMD_CLEAR_SCHEDULER"))
        {
          Scheduler.b(false).e();
          Scheduler.b(true).e();
          return null;
        }
        if (paramString.equals("STR_CMD_SET_DEBUG_MODE_REPLACE"))
        {
          this.mIsDebugMode = true;
          this.mIsDebugModeReplase = true;
          return null;
        }
        if (paramString.equals("STR_CMD_SET_DEBUG_MODE_NO_REPLACE"))
        {
          this.mIsDebugMode = true;
          this.mIsDebugModeReplase = false;
          return null;
        }
        if (paramString.equals("STR_CMD_SET_RECHECK_COMMAND")) {
          try
          {
            paramString = com.tencent.xweb.xwalk.updater.a.a(XWalkEnvironment.getUpdateConfigFullPath());
            if (paramString == null)
            {
              XWalkEnvironment.addXWalkInitializeLog("recheck cmds ConfigParser failed ");
              return null;
            }
            com.tencent.xweb.a.a(paramString.e, paramString.c, true);
            h.a(68L, 1);
            return null;
          }
          catch (Exception paramString)
          {
            paramArrayOfObject = new StringBuilder();
            paramArrayOfObject.append("recheck cmds failed , ");
            paramArrayOfObject.append(paramString.getMessage());
            XWalkEnvironment.addXWalkInitializeLog(paramArrayOfObject.toString());
            return null;
          }
        }
        if (paramString.equals("STR_CMD_SET_DEBUG_MODE_REPLACE_NOW"))
        {
          tryLoadLocalAssetRuntime((Context)paramArrayOfObject[0], true);
          d.b((Context)paramArrayOfObject[0]);
          return null;
        }
        if (paramString.equals("BASE_CONTEXT_CHANGED"))
        {
          if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 1) && ((paramArrayOfObject[0] instanceof k))) {
            paramString = (k)paramArrayOfObject[0];
          } else {
            paramString = null;
          }
          if ((paramString != null) && (XWalkCoreWrapper.getInstance() != null))
          {
            paramString = paramString.c();
            XWalkCoreWrapper.getInstance();
            XWalkCoreWrapper.invokeRuntimeChannel(80001, new Object[] { paramString });
            return null;
          }
        }
        else
        {
          if (paramString.equals("STR_CMD_FEATURE_SUPPORT")) {
            return Boolean.valueOf(XWalkCoreWrapper.hasFeatureStatic(((Integer)paramArrayOfObject[0]).intValue()));
          }
          if (paramString.equals("STR_CMD_NATIVE_TRANS_INIT"))
          {
            if (paramArrayOfObject.length != 1) {
              return null;
            }
            XWalkCoreWrapper.bindNativeTrans(((Long)paramArrayOfObject[0]).longValue());
            return null;
          }
          if (paramString.equals("STR_CMD_FORCE_DARK_MODE_COMMAND")) {
            try
            {
              if (XWalkCoreWrapper.getInstance() == null) {
                break label722;
              }
              XWalkCoreWrapper.getInstance().getBridgeClass("XWalkSettingsInternal").getDeclaredMethod("setWeChatDefaultForceDarkMode", new Class[] { Boolean.TYPE }).invoke(null, new Object[] { Boolean.valueOf(((Boolean)paramArrayOfObject[0]).booleanValue()) });
              return null;
            }
            catch (Exception paramString)
            {
              paramArrayOfObject = new StringBuilder();
              paramArrayOfObject.append("XWalkSettingsInternal setWeChatDefaultForceDarkMode error:");
              paramArrayOfObject.append(paramString.getMessage());
              org.xwalk.core.Log.e("XWalkWebFactory", paramArrayOfObject.toString());
              return null;
            }
          } else if (paramString.equals("STR_CMD_FORCE_DARK_MODE_BEHAVIOR_COMMAND")) {
            try
            {
              if (XWalkCoreWrapper.getInstance() != null)
              {
                XWalkCoreWrapper.getInstance().getBridgeClass("XWalkSettingsInternal").getDeclaredMethod("setWeChatDefaultForceDarkBehavior", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(((Integer)paramArrayOfObject[0]).intValue()) });
                return null;
              }
            }
            catch (Exception paramString)
            {
              paramArrayOfObject = new StringBuilder();
              paramArrayOfObject.append("XWalkSettingsInternal setWeChatDefaultForceDarkBehavior error:");
              paramArrayOfObject.append(paramString.getMessage());
              org.xwalk.core.Log.e("XWalkWebFactory", paramArrayOfObject.toString());
            }
          }
        }
      }
    }
    label722:
    return null;
  }
  
  public CookieInternal.ICookieManagerInternal getCookieManager()
  {
    return new e();
  }
  
  public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager()
  {
    return new f();
  }
  
  public IJsRuntime getJsCore(JsRuntime.JsRuntimeType paramJsRuntimeType, Context paramContext)
  {
    Object localObject = null;
    initWebviewCore(paramContext, null);
    int i = XWalkWebFactory.1.a[paramJsRuntimeType.ordinal()];
    if ((i != 1) && (i != 2)) {
      return null;
    }
    paramContext = localObject;
    if (com.tencent.xweb.xwalk.updater.f.c())
    {
      if (paramJsRuntimeType == JsRuntime.JsRuntimeType.g)
      {
        paramJsRuntimeType = new i();
        paramJsRuntimeType.a(0);
        return paramJsRuntimeType;
      }
      paramContext = localObject;
      if (paramJsRuntimeType == JsRuntime.JsRuntimeType.h)
      {
        paramContext = new i();
        paramContext.a(1);
      }
    }
    return paramContext;
  }
  
  public IWebViewDatabase getWebViewDatabase()
  {
    return new t();
  }
  
  public boolean hasInited()
  {
    return XWalkWebFactory.b.a();
  }
  
  public boolean hasInitedCallback()
  {
    return XWalkWebFactory.b.b();
  }
  
  public void initCallback(WebViewExtensionListener paramWebViewExtensionListener)
  {
    XWalkWebFactory.b.a(paramWebViewExtensionListener);
  }
  
  public void initEnviroment(Context paramContext)
  {
    if (this.mIsDebugMode) {
      tryLoadLocalAssetRuntime(paramContext, this.mIsDebugModeReplase);
    }
  }
  
  public void initInterface()
  {
    com.tencent.xweb.internal.k.a(WebView.c.b, new n());
  }
  
  public boolean initWebviewCore(Context paramContext, WebView.PreInitCallback paramPreInitCallback)
  {
    boolean bool = XWalkWebFactory.b.a(paramContext);
    if (paramPreInitCallback != null)
    {
      if (bool)
      {
        paramPreInitCallback.a();
        return bool;
      }
      paramPreInitCallback.b();
    }
    return bool;
  }
  
  public boolean isCoreReady()
  {
    return XWalkWebFactory.b.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.XWalkWebFactory
 * JD-Core Version:    0.7.0.1
 */
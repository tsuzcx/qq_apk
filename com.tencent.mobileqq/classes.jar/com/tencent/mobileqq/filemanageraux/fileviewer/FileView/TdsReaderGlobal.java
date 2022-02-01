package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kwstudio.office.base.IGlobal;
import com.tencent.kwstudio.office.base.ILog;
import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.preview.IHostInterface;
import com.tencent.kwstudio.office.preview.IHostInterface.IDownloadListener;
import com.tencent.kwstudio.office.preview.IHostInterface.IHttpListener;
import com.tencent.kwstudio.office.preview.IHostInterface.IPreferencesCallback;
import com.tencent.kwstudio.office.preview.IHostInterface.IWebClient;
import com.tencent.kwstudio.office.preview.TdsReaderView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.TimeoutParam;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ProtectedWebView;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public final class TdsReaderGlobal
  implements IHostInterface
{
  private static final TimeoutParam a = new TimeoutParam();
  private static volatile boolean b;
  private static volatile boolean c;
  private static volatile boolean d;
  private static final Map<String, String> e = new HashMap();
  private final BaseApplicationImpl f;
  private volatile Executor g;
  private volatile Executor h;
  private volatile IHttpEngineService i;
  
  static
  {
    TimeoutParam localTimeoutParam = a;
    localTimeoutParam.connectTimeoutFor2G /= 2;
    localTimeoutParam = a;
    localTimeoutParam.connectTimeoutFor3G /= 2;
    localTimeoutParam = a;
    localTimeoutParam.connectTimeoutForWifi /= 2;
  }
  
  private TdsReaderGlobal(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.f = paramBaseApplicationImpl;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    try
    {
      if (!b)
      {
        b = true;
        ThreadManager.getFileThreadHandler().post(new TdsReaderGlobal.RunnableImpl(null, 1, new Object[0], null));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    c = paramBoolean;
    for (;;)
    {
      synchronized (e)
      {
        if (e.size() > 0)
        {
          j = 1;
          if ((paramBoolean) && (!d) && (j != 0))
          {
            TdsReaderView.init(new TdsReaderGlobal(BaseApplicationImpl.getApplication()));
            d = true;
          }
          return;
        }
      }
      int j = 0;
    }
  }
  
  /* Error */
  public static void a(boolean paramBoolean, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: ifnonnull +7 -> 11
    //   7: ldc 2
    //   9: monitorexit
    //   10: return
    //   11: iload_0
    //   12: ifeq +28 -> 40
    //   15: getstatic 46	com/tencent/mobileqq/filemanageraux/fileviewer/FileView/TdsReaderGlobal:e	Ljava/util/Map;
    //   18: astore_2
    //   19: aload_2
    //   20: monitorenter
    //   21: getstatic 46	com/tencent/mobileqq/filemanageraux/fileviewer/FileView/TdsReaderGlobal:e	Ljava/util/Map;
    //   24: aload_1
    //   25: invokeinterface 117 2 0
    //   30: aload_2
    //   31: monitorexit
    //   32: goto +33 -> 65
    //   35: astore_1
    //   36: aload_2
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    //   40: getstatic 46	com/tencent/mobileqq/filemanageraux/fileviewer/FileView/TdsReaderGlobal:e	Ljava/util/Map;
    //   43: astore_2
    //   44: aload_2
    //   45: monitorenter
    //   46: getstatic 46	com/tencent/mobileqq/filemanageraux/fileviewer/FileView/TdsReaderGlobal:e	Ljava/util/Map;
    //   49: invokeinterface 120 1 0
    //   54: getstatic 46	com/tencent/mobileqq/filemanageraux/fileviewer/FileView/TdsReaderGlobal:e	Ljava/util/Map;
    //   57: aload_1
    //   58: invokeinterface 117 2 0
    //   63: aload_2
    //   64: monitorexit
    //   65: ldc 2
    //   67: monitorexit
    //   68: return
    //   69: astore_1
    //   70: aload_2
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    //   74: astore_1
    //   75: ldc 2
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramBoolean	boolean
    //   0	80	1	paramMap	Map<String, String>
    // Exception table:
    //   from	to	target	type
    //   21	32	35	finally
    //   36	38	35	finally
    //   46	65	69	finally
    //   70	72	69	finally
    //   15	21	74	finally
    //   38	40	74	finally
    //   40	46	74	finally
    //   72	74	74	finally
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null)
    {
      if (paramArrayOfObject.length < 4) {
        return;
      }
      String str = (String)paramArrayOfObject[0];
      boolean bool1 = ((Boolean)paramArrayOfObject[1]).booleanValue();
      boolean bool2 = ((Boolean)paramArrayOfObject[2]).booleanValue();
      IHostInterface.IPreferencesCallback localIPreferencesCallback = (IHostInterface.IPreferencesCallback)paramArrayOfObject[3];
      SharedPreferences localSharedPreferences = this.f.getSharedPreferences("tencentdoc_olc_pref", 4);
      paramArrayOfObject = str;
      if (bool2) {
        paramArrayOfObject = a(getUserId(), str);
      }
      bool1 = localSharedPreferences.getBoolean(paramArrayOfObject, bool1);
      if (localIPreferencesCallback != null) {
        localIPreferencesCallback.onResult(bool1);
      }
    }
  }
  
  public static void b()
  {
    try
    {
      b = false;
      c = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private Executor c()
  {
    try
    {
      if (this.g == null) {
        this.g = ThreadManagerExecutor.getExecutorService(64);
      }
      Executor localExecutor = this.g;
      return localExecutor;
    }
    finally {}
  }
  
  private void c(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null)
    {
      if (paramArrayOfObject.length < 4) {
        return;
      }
      String str1 = (String)paramArrayOfObject[0];
      String str2 = (String)paramArrayOfObject[1];
      String str3 = (String)paramArrayOfObject[2];
      paramArrayOfObject = (IHostInterface.IDownloadListener)paramArrayOfObject[3];
      if (!NetworkUtil.isNetworkAvailable(this.f))
      {
        if (paramArrayOfObject != null) {
          paramArrayOfObject.onDownloadFinished(str1, false, 9004);
        }
      }
      else
      {
        HttpNetReq localHttpNetReq = new HttpNetReq();
        localHttpNetReq.mReqUrl = str2;
        localHttpNetReq.mOutPath = str3;
        localHttpNetReq.mHttpMethod = 0;
        localHttpNetReq.mPrioty = 1;
        localHttpNetReq.mUseByteArrayPool = true;
        localHttpNetReq.mTimeoutParam = a.clone();
        localHttpNetReq.mSupportBreakResume = true;
        localHttpNetReq.mCallback = new TdsReaderGlobal.NetEngineListener4Download(str1, paramArrayOfObject, null);
        e().sendReq(localHttpNetReq);
      }
    }
  }
  
  private Executor d()
  {
    try
    {
      if (this.h == null) {
        this.h = ThreadManagerExecutor.getExecutorService(128);
      }
      Executor localExecutor = this.h;
      return localExecutor;
    }
    finally {}
  }
  
  private IHttpEngineService e()
  {
    try
    {
      if (this.i == null)
      {
        localObject1 = new HttpCommunicator(128);
        ((HttpCommunicator)localObject1).start();
        this.i = new HttpEngineServiceImpl((HttpCommunicator)localObject1, true);
      }
      Object localObject1 = this.i;
      return localObject1;
    }
    finally {}
  }
  
  public void commitPreferences(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    SharedPreferences.Editor localEditor = this.f.getSharedPreferences("tencentdoc_olc_pref", 4).edit();
    String str = paramString;
    if (paramBoolean2) {
      str = a(getUserId(), paramString);
    }
    localEditor.putBoolean(str, paramBoolean1).apply();
  }
  
  public IGlobal createGlobal()
  {
    return new TdsReaderGlobal.GlobalImpl(this, null);
  }
  
  public ILog createLog()
  {
    return new TdsReaderGlobal.LogImpl(null);
  }
  
  public Object createRecyclerView(Context paramContext)
  {
    return new RecyclerViewCompat(paramContext);
  }
  
  public Object createWebView(Context paramContext, IHostInterface.IWebClient paramIWebClient)
  {
    Object localObject;
    if (paramContext == null) {
      localObject = this.f;
    } else {
      localObject = paramContext;
    }
    ProtectedWebView localProtectedWebView = new ProtectedWebView((Context)localObject);
    if (paramIWebClient != null)
    {
      localProtectedWebView.setWebChromeClient(new TdsReaderGlobal.WebChromeClientImpl(paramIWebClient, null));
      localObject = paramContext;
      if (paramContext == null) {
        localObject = this.f;
      }
      localProtectedWebView.setWebViewClient(new TdsReaderGlobal.WebViewClientImpl((Context)localObject, paramIWebClient, null));
    }
    paramContext = localProtectedWebView.getX5WebViewExtension();
    if (paramContext != null)
    {
      paramContext.setHorizontalScrollBarEnabled(false);
      paramContext.setVerticalScrollBarEnabled(false);
      paramContext.setScrollBarFadingEnabled(false);
    }
    return localProtectedWebView;
  }
  
  public void downloadResource(String paramString1, String paramString2, String paramString3, IHostInterface.IDownloadListener paramIDownloadListener)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("http")))
    {
      d().execute(new TdsReaderGlobal.RunnableImpl(this, 4, new Object[] { paramString1, paramString2, paramString3, paramIDownloadListener }, null));
      return;
    }
    paramString3 = new StringBuilder();
    paramString3.append("not supported url:");
    paramString3.append(paramString2);
    Log.e("TdsReaderView_", paramString3.toString());
    if (paramIDownloadListener != null) {
      paramIDownloadListener.onDownloadFinished(paramString1, false, -1);
    }
  }
  
  public String getAppId()
  {
    return "1001";
  }
  
  public String getConfig(String paramString)
  {
    synchronized (e)
    {
      paramString = (String)e.get(paramString);
      return paramString;
    }
  }
  
  public String getUserId()
  {
    return Long.toString(this.f.getRuntime().getLongAccountUin());
  }
  
  public void queryPreferences(String paramString, boolean paramBoolean1, boolean paramBoolean2, IHostInterface.IPreferencesCallback paramIPreferencesCallback)
  {
    c().execute(new TdsReaderGlobal.RunnableImpl(this, 2, new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramIPreferencesCallback }, null));
  }
  
  public void reportEvent(String paramString1, int paramInt, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, paramInt, 0, "", "", str, "");
  }
  
  public void sendHttpRequest(String paramString1, boolean paramBoolean, String paramString2, IHostInterface.IHttpListener paramIHttpListener)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.startsWith("http")))
    {
      d().execute(new TdsReaderGlobal.RunnableImpl(this, 3, new Object[] { paramString1, Boolean.valueOf(paramBoolean), paramString2, paramIHttpListener }, null));
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("invalid url:");
    paramString2.append(paramString1);
    Log.e("TdsReaderView_", paramString2.toString());
    if (paramIHttpListener != null) {
      paramIHttpListener.onResponse(-1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal
 * JD-Core Version:    0.7.0.1
 */
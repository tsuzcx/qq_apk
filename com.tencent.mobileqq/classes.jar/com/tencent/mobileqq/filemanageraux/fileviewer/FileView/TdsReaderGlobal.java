package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import atfg;
import atfh;
import atfi;
import atfj;
import atfk;
import atfl;
import atfm;
import atfn;
import bcef;
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
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.OldHttpEngine;
import com.tencent.mobileqq.transfile.RichMediaStrategy.OldEngineDPCProfile.TimeoutParam;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ProtectedWebView;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import mqq.app.AppRuntime;
import mqq.app.TicketManagerImpl;
import mqq.os.MqqHandler;

public final class TdsReaderGlobal
  implements IHostInterface
{
  private static final RichMediaStrategy.OldEngineDPCProfile.TimeoutParam jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam = new RichMediaStrategy.OldEngineDPCProfile.TimeoutParam();
  private static final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static volatile boolean jdField_a_of_type_Boolean;
  private static volatile boolean jdField_b_of_type_Boolean;
  private static volatile boolean c;
  private final BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  private volatile INetEngine.IBreakDownFix jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
  private volatile INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private volatile Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private volatile Executor jdField_b_of_type_JavaUtilConcurrentExecutor;
  
  static
  {
    RichMediaStrategy.OldEngineDPCProfile.TimeoutParam localTimeoutParam = jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam;
    localTimeoutParam.connectTimeoutFor2G /= 2;
    localTimeoutParam = jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam;
    localTimeoutParam.connectTimeoutFor3G /= 2;
    localTimeoutParam = jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam;
    localTimeoutParam.connectTimeoutForWifi /= 2;
  }
  
  private TdsReaderGlobal(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
  }
  
  private INetEngine.IBreakDownFix a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix == null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new atfg(null);
      }
      INetEngine.IBreakDownFix localIBreakDownFix = this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
      return localIBreakDownFix;
    }
    finally {}
  }
  
  private INetEngine a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null)
      {
        localObject1 = new HttpCommunicator(new atfi(null), 128);
        ((HttpCommunicator)localObject1).start();
        this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = new OldHttpEngine((HttpCommunicator)localObject1, true);
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
      return localObject1;
    }
    finally {}
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + paramString2;
  }
  
  private Executor a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentExecutor == null) {
        this.jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManagerExecutor.getExecutorService(64);
      }
      Executor localExecutor = this.jdField_a_of_type_JavaUtilConcurrentExecutor;
      return localExecutor;
    }
    finally {}
  }
  
  public static void a()
  {
    try
    {
      if (!jdField_a_of_type_Boolean)
      {
        jdField_a_of_type_Boolean = true;
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
    jdField_b_of_type_Boolean = paramBoolean;
    synchronized (jdField_a_of_type_JavaUtilMap)
    {
      if (jdField_a_of_type_JavaUtilMap.size() > 0)
      {
        i = 1;
        if ((paramBoolean) && (!c) && (i != 0))
        {
          TdsReaderView.init(new TdsReaderGlobal(BaseApplicationImpl.getApplication()));
          c = true;
        }
        return;
      }
      int i = 0;
    }
  }
  
  public static void a(boolean paramBoolean, Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    if (paramBoolean) {
      try
      {
        for (;;)
        {
          synchronized (jdField_a_of_type_JavaUtilMap)
          {
            jdField_a_of_type_JavaUtilMap.putAll(paramMap);
          }
          synchronized (jdField_a_of_type_JavaUtilMap)
          {
            jdField_a_of_type_JavaUtilMap.clear();
            jdField_a_of_type_JavaUtilMap.putAll(paramMap);
          }
        }
      }
      finally {}
    }
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 4)) {}
    boolean bool1;
    IHostInterface.IPreferencesCallback localIPreferencesCallback;
    do
    {
      return;
      String str = (String)paramArrayOfObject[0];
      bool1 = ((Boolean)paramArrayOfObject[1]).booleanValue();
      boolean bool2 = ((Boolean)paramArrayOfObject[2]).booleanValue();
      localIPreferencesCallback = (IHostInterface.IPreferencesCallback)paramArrayOfObject[3];
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("tencentdoc_olc_pref", 4);
      paramArrayOfObject = str;
      if (bool2) {
        paramArrayOfObject = a(getUserId(), str);
      }
      bool1 = localSharedPreferences.getBoolean(paramArrayOfObject, bool1);
    } while (localIPreferencesCallback == null);
    localIPreferencesCallback.onResult(bool1);
  }
  
  public static boolean a()
  {
    return (c) && (jdField_b_of_type_Boolean);
  }
  
  private Executor b()
  {
    try
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentExecutor == null) {
        this.jdField_b_of_type_JavaUtilConcurrentExecutor = ThreadManagerExecutor.getExecutorService(128);
      }
      Executor localExecutor = this.jdField_b_of_type_JavaUtilConcurrentExecutor;
      return localExecutor;
    }
    finally {}
  }
  
  public static void b()
  {
    try
    {
      jdField_a_of_type_Boolean = false;
      jdField_b_of_type_Boolean = false;
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
    int i = 0;
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 4)) {}
    String str1;
    boolean bool;
    String str2;
    do
    {
      return;
      str1 = (String)paramArrayOfObject[0];
      bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
      str2 = (String)paramArrayOfObject[2];
      localObject = (IHostInterface.IHttpListener)paramArrayOfObject[3];
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl)) {
        break;
      }
    } while (localObject == null);
    ((IHostInterface.IHttpListener)localObject).onResponse(9004, null);
    return;
    paramArrayOfObject = new HttpNetReq();
    paramArrayOfObject.mReqUrl = str1;
    if (bool) {
      i = 1;
    }
    paramArrayOfObject.mHttpMethod = i;
    paramArrayOfObject.mPrioty = 1;
    paramArrayOfObject.mUseByteArrayPool = true;
    paramArrayOfObject.mExcuteTimeLimit = 5000L;
    paramArrayOfObject.mCallback = new atfl(str1, (IHostInterface.IHttpListener)localObject, null);
    Object localObject = getUserId();
    String str3 = ((TicketManagerImpl)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime().getManager(2)).getSkey((String)localObject);
    localObject = "uin=" + (String)localObject + ";skey=" + str3;
    if (bool) {
      paramArrayOfObject.mSendData = str2.getBytes();
    }
    paramArrayOfObject.mReqProperties = new HashMap();
    paramArrayOfObject.mReqProperties.put("Cookie", localObject);
    Log.i("TdsReaderView_", "sendReq url:" + str1);
    a().sendReq(paramArrayOfObject);
  }
  
  private void c(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 4)) {}
    String str1;
    String str2;
    String str3;
    do
    {
      return;
      str1 = (String)paramArrayOfObject[0];
      str2 = (String)paramArrayOfObject[1];
      str3 = (String)paramArrayOfObject[2];
      paramArrayOfObject = (IHostInterface.IDownloadListener)paramArrayOfObject[3];
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl)) {
        break;
      }
    } while (paramArrayOfObject == null);
    paramArrayOfObject.onDownloadFinished(str1, false, 9004);
    return;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = str2;
    localHttpNetReq.mOutPath = str3;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.mUseByteArrayPool = true;
    localHttpNetReq.mTimeoutParam = jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam.clone();
    localHttpNetReq.mBreakDownFix = a();
    localHttpNetReq.mCallback = new atfk(str1, paramArrayOfObject, null);
    a().sendReq(localHttpNetReq);
  }
  
  public void commitPreferences(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("tencentdoc_olc_pref", 4).edit();
    String str = paramString;
    if (paramBoolean2) {
      str = a(getUserId(), paramString);
    }
    localEditor.putBoolean(str, paramBoolean1).apply();
  }
  
  public IGlobal createGlobal()
  {
    return new atfh(this, null);
  }
  
  public ILog createLog()
  {
    return new atfj(null);
  }
  
  public Object createRecyclerView(Context paramContext)
  {
    return new RecyclerViewCompat(paramContext);
  }
  
  public Object createWebView(Context paramContext, IHostInterface.IWebClient paramIWebClient)
  {
    if (paramContext == null) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;; localObject = paramContext)
    {
      ProtectedWebView localProtectedWebView = new ProtectedWebView((Context)localObject);
      if (paramIWebClient != null)
      {
        localProtectedWebView.setWebChromeClient(new atfm(paramIWebClient, null));
        localObject = paramContext;
        if (paramContext == null) {
          localObject = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
        }
        localProtectedWebView.setWebViewClient(new atfn((Context)localObject, paramIWebClient, null));
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
  }
  
  public void downloadResource(String paramString1, String paramString2, String paramString3, IHostInterface.IDownloadListener paramIDownloadListener)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("http"))) {
      b().execute(new TdsReaderGlobal.RunnableImpl(this, 4, new Object[] { paramString1, paramString2, paramString3, paramIDownloadListener }, null));
    }
    do
    {
      return;
      Log.e("TdsReaderView_", "not supported url:" + paramString2);
    } while (paramIDownloadListener == null);
    paramIDownloadListener.onDownloadFinished(paramString1, false, -1);
  }
  
  public String getAppId()
  {
    return "1001";
  }
  
  public String getConfig(String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilMap)
    {
      paramString = (String)jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  public String getUserId()
  {
    return Long.toString(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime().getLongAccountUin());
  }
  
  public void queryPreferences(String paramString, boolean paramBoolean1, boolean paramBoolean2, IHostInterface.IPreferencesCallback paramIPreferencesCallback)
  {
    a().execute(new TdsReaderGlobal.RunnableImpl(this, 2, new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramIPreferencesCallback }, null));
  }
  
  public void reportEvent(String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 == null) {
      paramString2 = "";
    }
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", paramString1, paramString1, paramInt, 0, "", "", paramString2, "");
      return;
    }
  }
  
  public void sendHttpRequest(String paramString1, boolean paramBoolean, String paramString2, IHostInterface.IHttpListener paramIHttpListener)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.startsWith("http"))) {
      b().execute(new TdsReaderGlobal.RunnableImpl(this, 3, new Object[] { paramString1, Boolean.valueOf(paramBoolean), paramString2, paramIHttpListener }, null));
    }
    do
    {
      return;
      Log.e("TdsReaderView_", "invalid url:" + paramString1);
    } while (paramIHttpListener == null);
    paramIHttpListener.onResponse(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal
 * JD-Core Version:    0.7.0.1
 */
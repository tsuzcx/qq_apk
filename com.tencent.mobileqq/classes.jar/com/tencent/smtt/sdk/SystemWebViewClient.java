package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.smtt.utils.ReflectionUtils;
import com.tencent.smtt.utils.TbsConfigFile;
import com.tencent.smtt.utils.TbsLog;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

@SuppressLint({"NewApi", "Override"})
class SystemWebViewClient
  extends android.webkit.WebViewClient
{
  private static String result_configForceSyswebview = null;
  private WebViewClient mClient;
  private WebView mWebView;
  
  SystemWebViewClient(WebView paramWebView, WebViewClient paramWebViewClient)
  {
    this.mWebView = paramWebView;
    this.mClient = paramWebViewClient;
  }
  
  public void doUpdateVisitedHistory(android.webkit.WebView paramWebView, String paramString, boolean paramBoolean)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.doUpdateVisitedHistory(this.mWebView, paramString, paramBoolean);
  }
  
  public void onFormResubmission(android.webkit.WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onFormResubmission(this.mWebView, paramMessage1, paramMessage2);
  }
  
  public void onLoadResource(android.webkit.WebView paramWebView, String paramString)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onLoadResource(this.mWebView, paramString);
  }
  
  public void onPageFinished(android.webkit.WebView paramWebView, String paramString)
  {
    if (result_configForceSyswebview == null)
    {
      localObject = TbsConfigFile.getInstance();
      if (localObject != null)
      {
        ((TbsConfigFile)localObject).setForceUseSystemWebview(true);
        result_configForceSyswebview = Boolean.toString(true);
      }
    }
    this.mWebView.setSysWebView(paramWebView);
    Object localObject = this.mWebView;
    ((WebView)localObject).mPv += 1;
    this.mClient.onPageFinished(this.mWebView, paramString);
    if ("com.qzone".equals(paramWebView.getContext().getApplicationInfo().packageName)) {
      this.mWebView.writetbscorepvfile(paramWebView.getContext());
    }
    TbsLog.app_extra("SystemWebViewClient", paramWebView.getContext());
    WebView.updateRebootStatus();
    if ((!TbsShareManager.mHasQueryed) && (this.mWebView.getContext() != null) && (TbsShareManager.isThirdPartyApp(this.mWebView.getContext())))
    {
      TbsShareManager.mHasQueryed = true;
      new Thread(new Runnable()
      {
        public void run()
        {
          if ((!TbsShareManager.forceLoadX5FromTBSDemo(SystemWebViewClient.this.mWebView.getContext())) && (TbsDownloader.needDownload(SystemWebViewClient.this.mWebView.getContext(), false))) {
            TbsDownloader.startDownload(SystemWebViewClient.this.mWebView.getContext());
          }
        }
      }).start();
    }
    if ((this.mWebView.getContext() != null) && (!TbsLogReport.getInstance(this.mWebView.getContext()).getShouldUploadEventReport()))
    {
      TbsLogReport.getInstance(this.mWebView.getContext()).setShouldUploadEventReport(true);
      TbsLogReport.getInstance(this.mWebView.getContext()).dailyReport();
    }
  }
  
  public void onPageStarted(android.webkit.WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onPageStarted(this.mWebView, paramString, paramBitmap);
  }
  
  public void onReceivedClientCertRequest(android.webkit.WebView paramWebView, android.webkit.ClientCertRequest paramClientCertRequest)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.mWebView.setSysWebView(paramWebView);
      paramWebView = new ClientCertRequestImpl(paramClientCertRequest);
      this.mClient.onReceivedClientCertRequest(this.mWebView, paramWebView);
    }
  }
  
  public void onReceivedError(android.webkit.WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onReceivedError(this.mWebView, paramInt, paramString1, paramString2);
  }
  
  public void onReceivedError(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest, final android.webkit.WebResourceError paramWebResourceError)
  {
    Object localObject = null;
    this.mWebView.setSysWebView(paramWebView);
    if (paramWebResourceRequest != null) {}
    for (paramWebView = new WebResourceRequestImpl2(paramWebResourceRequest);; paramWebView = null)
    {
      paramWebResourceRequest = localObject;
      if (paramWebResourceError != null) {
        paramWebResourceRequest = new com.tencent.smtt.export.external.interfaces.WebResourceError()
        {
          public CharSequence getDescription()
          {
            return paramWebResourceError.getDescription();
          }
          
          public int getErrorCode()
          {
            return paramWebResourceError.getErrorCode();
          }
        };
      }
      this.mClient.onReceivedError(this.mWebView, paramWebView, paramWebResourceRequest);
      return;
    }
  }
  
  public void onReceivedHttpAuthRequest(android.webkit.WebView paramWebView, android.webkit.HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onReceivedHttpAuthRequest(this.mWebView, new HttpAuthHandlerImpl(paramHttpAuthHandler), paramString1, paramString2);
  }
  
  public void onReceivedHttpError(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest, android.webkit.WebResourceResponse paramWebResourceResponse)
  {
    this.mWebView.setSysWebView(paramWebView);
    paramWebView = new WebResourceRequestImpl2(paramWebResourceRequest);
    paramWebResourceRequest = new WebResourceResponseImpl2(paramWebResourceResponse);
    this.mClient.onReceivedHttpError(this.mWebView, paramWebView, paramWebResourceRequest);
  }
  
  @TargetApi(12)
  public void onReceivedLoginRequest(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      this.mWebView.setSysWebView(paramWebView);
      this.mClient.onReceivedLoginRequest(this.mWebView, paramString1, paramString2, paramString3);
    }
  }
  
  @TargetApi(8)
  public void onReceivedSslError(android.webkit.WebView paramWebView, android.webkit.SslErrorHandler paramSslErrorHandler, android.net.http.SslError paramSslError)
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      this.mWebView.setSysWebView(paramWebView);
      this.mClient.onReceivedSslError(this.mWebView, new SslErrorHandlerImpl(paramSslErrorHandler), new SslErrorImpl(paramSslError));
    }
  }
  
  public void onScaleChanged(android.webkit.WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onScaleChanged(this.mWebView, paramFloat1, paramFloat2);
  }
  
  public void onTooManyRedirects(android.webkit.WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onTooManyRedirects(this.mWebView, paramMessage1, paramMessage2);
  }
  
  public void onUnhandledKeyEvent(android.webkit.WebView paramWebView, KeyEvent paramKeyEvent)
  {
    this.mWebView.setSysWebView(paramWebView);
    this.mClient.onUnhandledKeyEvent(this.mWebView, paramKeyEvent);
  }
  
  public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramWebView = null;
    }
    int i;
    String str;
    do
    {
      do
      {
        return paramWebView;
        if (paramWebResourceRequest == null) {
          return null;
        }
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 24)
        {
          paramWebView = ReflectionUtils.invokeInstance(paramWebResourceRequest, "isRedirect");
          bool1 = bool2;
          if ((paramWebView instanceof Boolean)) {
            bool1 = ((Boolean)paramWebView).booleanValue();
          }
        }
        paramWebView = new WebResourceRequestImpl(paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.isForMainFrame(), bool1, paramWebResourceRequest.hasGesture(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.getRequestHeaders());
        paramWebView = this.mClient.shouldInterceptRequest(this.mWebView, paramWebView);
        if (paramWebView == null) {
          return null;
        }
        paramWebResourceRequest = new android.webkit.WebResourceResponse(paramWebView.getMimeType(), paramWebView.getEncoding(), paramWebView.getData());
        paramWebResourceRequest.setResponseHeaders(paramWebView.getResponseHeaders());
        i = paramWebView.getStatusCode();
        str = paramWebView.getReasonPhrase();
        if (i != paramWebResourceRequest.getStatusCode()) {
          break;
        }
        paramWebView = paramWebResourceRequest;
      } while (str == null);
      paramWebView = paramWebResourceRequest;
    } while (str.equals(paramWebResourceRequest.getReasonPhrase()));
    paramWebResourceRequest.setStatusCodeAndReasonPhrase(i, str);
    return paramWebResourceRequest;
  }
  
  @TargetApi(11)
  public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, String paramString)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return null;
      paramWebView = this.mClient.shouldInterceptRequest(this.mWebView, paramString);
    } while (paramWebView == null);
    return new android.webkit.WebResourceResponse(paramWebView.getMimeType(), paramWebView.getEncoding(), paramWebView.getData());
  }
  
  public boolean shouldOverrideKeyEvent(android.webkit.WebView paramWebView, KeyEvent paramKeyEvent)
  {
    this.mWebView.setSysWebView(paramWebView);
    return this.mClient.shouldOverrideKeyEvent(this.mWebView, paramKeyEvent);
  }
  
  public boolean shouldOverrideUrlLoading(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramWebResourceRequest != null)
    {
      localObject1 = localObject2;
      if (paramWebResourceRequest.getUrl() != null) {
        localObject1 = paramWebResourceRequest.getUrl().toString();
      }
    }
    if ((localObject1 == null) || (this.mWebView.showDebugView((String)localObject1))) {
      return true;
    }
    this.mWebView.setSysWebView(paramWebView);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramWebView = ReflectionUtils.invokeInstance(paramWebResourceRequest, "isRedirect");
      bool1 = bool2;
      if ((paramWebView instanceof Boolean)) {
        bool1 = ((Boolean)paramWebView).booleanValue();
      }
    }
    paramWebView = new WebResourceRequestImpl(paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.isForMainFrame(), bool1, paramWebResourceRequest.hasGesture(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.getRequestHeaders());
    return this.mClient.shouldOverrideUrlLoading(this.mWebView, paramWebView);
  }
  
  public boolean shouldOverrideUrlLoading(android.webkit.WebView paramWebView, String paramString)
  {
    if ((paramString == null) || (this.mWebView.showDebugView(paramString))) {
      return true;
    }
    this.mWebView.setSysWebView(paramWebView);
    return this.mClient.shouldOverrideUrlLoading(this.mWebView, paramString);
  }
  
  private static class ClientCertRequestImpl
    extends com.tencent.smtt.export.external.interfaces.ClientCertRequest
  {
    private android.webkit.ClientCertRequest mClientCertRequest;
    
    public ClientCertRequestImpl(android.webkit.ClientCertRequest paramClientCertRequest)
    {
      this.mClientCertRequest = paramClientCertRequest;
    }
    
    public void cancel()
    {
      this.mClientCertRequest.cancel();
    }
    
    public String getHost()
    {
      return this.mClientCertRequest.getHost();
    }
    
    public String[] getKeyTypes()
    {
      return this.mClientCertRequest.getKeyTypes();
    }
    
    public int getPort()
    {
      return this.mClientCertRequest.getPort();
    }
    
    public Principal[] getPrincipals()
    {
      return this.mClientCertRequest.getPrincipals();
    }
    
    public void ignore()
    {
      this.mClientCertRequest.ignore();
    }
    
    public void proceed(PrivateKey paramPrivateKey, X509Certificate[] paramArrayOfX509Certificate)
    {
      this.mClientCertRequest.proceed(paramPrivateKey, paramArrayOfX509Certificate);
    }
  }
  
  private static class HttpAuthHandlerImpl
    implements com.tencent.smtt.export.external.interfaces.HttpAuthHandler
  {
    private android.webkit.HttpAuthHandler mHandler;
    
    HttpAuthHandlerImpl(android.webkit.HttpAuthHandler paramHttpAuthHandler)
    {
      this.mHandler = paramHttpAuthHandler;
    }
    
    public void cancel()
    {
      this.mHandler.cancel();
    }
    
    public void proceed(String paramString1, String paramString2)
    {
      this.mHandler.proceed(paramString1, paramString2);
    }
    
    public boolean useHttpAuthUsernamePassword()
    {
      return this.mHandler.useHttpAuthUsernamePassword();
    }
  }
  
  private static class SslErrorHandlerImpl
    implements com.tencent.smtt.export.external.interfaces.SslErrorHandler
  {
    android.webkit.SslErrorHandler mSslErrorHandler;
    
    SslErrorHandlerImpl(android.webkit.SslErrorHandler paramSslErrorHandler)
    {
      this.mSslErrorHandler = paramSslErrorHandler;
    }
    
    public void cancel()
    {
      this.mSslErrorHandler.cancel();
    }
    
    public void proceed()
    {
      this.mSslErrorHandler.proceed();
    }
  }
  
  private static class SslErrorImpl
    implements com.tencent.smtt.export.external.interfaces.SslError
  {
    android.net.http.SslError mSslError;
    
    SslErrorImpl(android.net.http.SslError paramSslError)
    {
      this.mSslError = paramSslError;
    }
    
    public boolean addError(int paramInt)
    {
      return this.mSslError.addError(paramInt);
    }
    
    public SslCertificate getCertificate()
    {
      return this.mSslError.getCertificate();
    }
    
    public int getPrimaryError()
    {
      return this.mSslError.getPrimaryError();
    }
    
    public boolean hasError(int paramInt)
    {
      return this.mSslError.hasError(paramInt);
    }
  }
  
  private class WebResourceRequestImpl
    implements com.tencent.smtt.export.external.interfaces.WebResourceRequest
  {
    private boolean hasUserGesture;
    private boolean isMainFrame;
    private boolean isRedirect;
    private String method;
    private Map<String, String> requestHeaders;
    private String url;
    
    public WebResourceRequestImpl(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Map<String, String> paramMap)
    {
      this.url = paramBoolean1;
      this.isMainFrame = paramBoolean2;
      this.isRedirect = paramBoolean3;
      this.hasUserGesture = paramString;
      this.method = paramMap;
      Object localObject;
      this.requestHeaders = localObject;
    }
    
    public String getMethod()
    {
      return this.method;
    }
    
    public Map<String, String> getRequestHeaders()
    {
      return this.requestHeaders;
    }
    
    public Uri getUrl()
    {
      return Uri.parse(this.url);
    }
    
    public boolean hasGesture()
    {
      return this.hasUserGesture;
    }
    
    public boolean isForMainFrame()
    {
      return this.isMainFrame;
    }
    
    public boolean isRedirect()
    {
      return this.isRedirect;
    }
  }
  
  private static class WebResourceRequestImpl2
    implements com.tencent.smtt.export.external.interfaces.WebResourceRequest
  {
    android.webkit.WebResourceRequest mWebResourceRequest;
    
    WebResourceRequestImpl2(android.webkit.WebResourceRequest paramWebResourceRequest)
    {
      this.mWebResourceRequest = paramWebResourceRequest;
    }
    
    public String getMethod()
    {
      return this.mWebResourceRequest.getMethod();
    }
    
    public Map<String, String> getRequestHeaders()
    {
      return this.mWebResourceRequest.getRequestHeaders();
    }
    
    public Uri getUrl()
    {
      return this.mWebResourceRequest.getUrl();
    }
    
    public boolean hasGesture()
    {
      return this.mWebResourceRequest.hasGesture();
    }
    
    public boolean isForMainFrame()
    {
      return this.mWebResourceRequest.isForMainFrame();
    }
    
    public boolean isRedirect()
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        Object localObject = ReflectionUtils.invokeInstance(this.mWebResourceRequest, "isRedirect");
        if ((localObject instanceof Boolean)) {
          return ((Boolean)localObject).booleanValue();
        }
      }
      return false;
    }
  }
  
  private static class WebResourceResponseImpl2
    extends com.tencent.smtt.export.external.interfaces.WebResourceResponse
  {
    android.webkit.WebResourceResponse mWebResourceResponse;
    
    public WebResourceResponseImpl2(android.webkit.WebResourceResponse paramWebResourceResponse)
    {
      this.mWebResourceResponse = paramWebResourceResponse;
    }
    
    public InputStream getData()
    {
      return this.mWebResourceResponse.getData();
    }
    
    public String getEncoding()
    {
      return this.mWebResourceResponse.getEncoding();
    }
    
    public String getMimeType()
    {
      return this.mWebResourceResponse.getMimeType();
    }
    
    public String getReasonPhrase()
    {
      return this.mWebResourceResponse.getReasonPhrase();
    }
    
    public Map<String, String> getResponseHeaders()
    {
      return this.mWebResourceResponse.getResponseHeaders();
    }
    
    public int getStatusCode()
    {
      return this.mWebResourceResponse.getStatusCode();
    }
    
    public void setData(InputStream paramInputStream)
    {
      this.mWebResourceResponse.setData(paramInputStream);
    }
    
    public void setEncoding(String paramString)
    {
      this.mWebResourceResponse.setEncoding(paramString);
    }
    
    public void setMimeType(String paramString)
    {
      this.mWebResourceResponse.setMimeType(paramString);
    }
    
    public void setResponseHeaders(Map<String, String> paramMap)
    {
      this.mWebResourceResponse.setResponseHeaders(paramMap);
    }
    
    public void setStatusCodeAndReasonPhrase(int paramInt, String paramString)
    {
      this.mWebResourceResponse.setStatusCodeAndReasonPhrase(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient
 * JD-Core Version:    0.7.0.1
 */
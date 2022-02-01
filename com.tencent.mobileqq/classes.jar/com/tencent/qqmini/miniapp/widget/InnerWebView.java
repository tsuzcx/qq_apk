package com.tencent.qqmini.miniapp.widget;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.ValueCallback;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView;
import com.tencent.qqmini.miniapp.util.FileChooserHelper;
import com.tencent.qqmini.miniapp.util.IPV6OnlyUtils;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl.BaselibProvider;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.core.utils.ShortVideoUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData.Builder;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.utils.DomainUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class InnerWebView
  extends DtX5WebView
  implements IJsService
{
  public static final String API_BATCH_CARD = "batchAddCard";
  public static final String API_CHECK_JS_API = "checkJsApi";
  public static final String API_CHOOSE_CARD = "chooseCard";
  public static final String API_CLOSE_WINDOW = "closeWindow";
  public static final String API_DOWNLOAD_IMAGE = "downloadImage";
  public static final String API_DOWNLOAD_VOICE = "downloadVoice";
  public static final String API_GET_BRAND_WCPAY_REQUEST = "getBrandWCPayRequest";
  public static final String API_GET_LOCAL_IMGDATA = "getLocalImgData";
  public static final String API_HIDE_ALL_NONBASE_MENU_ITEM = "hideAllNonBaseMenuItem";
  public static final String API_HIDE_MENU_ITEMS = "hideMenuItems";
  public static final String API_HIDE_OPTION_MENU = "hideOptionMenu";
  public static final String API_OPEN_CARD = "openCard";
  public static final String API_OPEN_PPRODUCT_VIEW_WITH_PID = "openProductViewWithPid";
  public static final String API_SCAN_QRCODE = "scanQRCode";
  public static final String API_SHOW_ALL_NONBASE_MENU_ITEM = "showAllNonBaseMenuItem";
  public static final String API_SHOW_MENU_ITEMS = "showMenuItems";
  public static final String API_SHOW_OPTION_MENU = "showOptionMenu";
  public static final String API_TRANSLATE_VOICE = "translateVoice";
  public static final String API_UPLOAD_IMAGE = "uploadImage";
  public static final String API_UPLOAD_VOICE = "uploadVoice";
  public static final int REQUEST_CODE = 2019;
  private static final String TAG = "InnerWebView";
  private static final String TAG_JS = "InnerWebView_js";
  private static final String WEB_BASE64_PREFIX_JPEG = "data:image/jpeg;base64,";
  private static final String WEB_BASE64_PREFIX_JPG = "data:image/jpg;base64,";
  private static final String WEB_BASE64_PREFIX_PNG = "data:image/png;base64,";
  public int htmlId;
  private Activity mActivity;
  private FileChooserHelper mFileChooserHelper;
  private IMiniAppContext mMiniAppContext;
  private String miniAppWebviewStr;
  private Set<String> supportApiMap;
  private WebView webView;
  
  public InnerWebView(Activity paramActivity)
  {
    super(paramActivity);
    this.mActivity = paramActivity;
    WebSettings localWebSettings = getSettings();
    Object localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    paramActivity = this.mMiniAppContext;
    if ((paramActivity != null) && (paramActivity.getMiniAppInfo() != null)) {
      paramActivity = this.mMiniAppContext.getMiniAppInfo().appId;
    } else {
      paramActivity = "";
    }
    if ((localObject != null) && (((ChannelProxy)localObject).isGooglePlayVersion()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localWebSettings.getUserAgentString());
      ((StringBuilder)localObject).append(" QQ/");
      ((StringBuilder)localObject).append(QUAUtil.getPlatformVersionString());
      ((StringBuilder)localObject).append("_GM ");
      ((StringBuilder)localObject).append(QUAUtil.getPlatformQUA());
      ((StringBuilder)localObject).append(" miniProgram miniprogramhtmlwebview QMA/");
      ((StringBuilder)localObject).append(paramActivity);
      paramActivity = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localWebSettings.getUserAgentString());
      ((StringBuilder)localObject).append(" QQ/");
      ((StringBuilder)localObject).append(QUAUtil.getPlatformVersionString());
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(QUAUtil.getPlatformQUA());
      ((StringBuilder)localObject).append(" miniProgram miniprogramhtmlwebview QMA/");
      ((StringBuilder)localObject).append(paramActivity);
      paramActivity = ((StringBuilder)localObject).toString();
    }
    localWebSettings.setUserAgent(paramActivity);
    localWebSettings.setSavePassword(false);
    localWebSettings.setSaveFormData(false);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setPluginState(WebSettings.PluginState.ON);
    localWebSettings.setPluginsEnabled(true);
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setSupportZoom(false);
    localWebSettings.setCacheMode(-1);
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
    if (Build.VERSION.SDK_INT >= 21) {
      localWebSettings.setMixedContentMode(0);
    }
    localWebSettings.setAllowContentAccess(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setMediaPlaybackRequiresUserGesture(false);
    if (Build.VERSION.SDK_INT >= 21) {
      localWebSettings.setMixedContentMode(0);
    }
    try
    {
      requestFocus();
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  private boolean checkEnableIPV6Only()
  {
    boolean bool = false;
    if (WnsConfig.getConfig("qqminiapp", "ipv6_proxy_enable", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  private WebResourceResponse doIPV6OnlyRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    paramWebView = paramWebResourceRequest.getUrl().toString();
    Object localObject1 = WnsConfig.getConfig("qqminiapp", "ipv6_http_proxy_url", "https://proxy.gtimg.cn/tx_tls_gate=");
    try
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramWebView);
      localObject1 = ((StringBuilder)localObject2).toString();
      paramWebView = new StringBuilder();
      paramWebView.append("shouldInterceptRequest url = ");
      paramWebView.append((String)localObject1);
      QMLog.e("InnerWebView", paramWebView.toString());
      localObject2 = (HttpURLConnection)new URL((String)localObject1).openConnection();
      ((HttpURLConnection)localObject2).setRequestMethod(paramWebResourceRequest.getMethod());
      if (paramWebResourceRequest.getRequestHeaders() != null)
      {
        paramWebView = paramWebResourceRequest.getRequestHeaders().entrySet().iterator();
        while (paramWebView.hasNext())
        {
          paramWebResourceRequest = (Map.Entry)paramWebView.next();
          ((HttpURLConnection)localObject2).setRequestProperty((String)paramWebResourceRequest.getKey(), (String)paramWebResourceRequest.getValue());
        }
      }
      ((HttpURLConnection)localObject2).setConnectTimeout(6000);
      ((HttpURLConnection)localObject2).setReadTimeout(6000);
      paramWebResourceRequest = "";
      paramWebView = paramWebResourceRequest;
      if (((HttpURLConnection)localObject2).getHeaderFields() != null)
      {
        paramWebView = paramWebResourceRequest;
        if (((HttpURLConnection)localObject2).getHeaderFields().containsKey("Content-Type")) {
          paramWebView = (String)((List)((HttpURLConnection)localObject2).getHeaderFields().get("Content-Type")).get(0);
        }
      }
      paramWebResourceRequest = IPV6OnlyUtils.getMimeType(paramWebView);
      paramWebView = IPV6OnlyUtils.getEncoding(paramWebView);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ipv6 code:");
      localStringBuilder.append(((HttpURLConnection)localObject2).getResponseCode());
      localStringBuilder.append("  url:");
      localStringBuilder.append((String)localObject1);
      QMLog.e("InnerWebView", localStringBuilder.toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ipv6 mimeType = ");
      ((StringBuilder)localObject1).append(paramWebResourceRequest);
      ((StringBuilder)localObject1).append("encoding:");
      ((StringBuilder)localObject1).append(paramWebView);
      QMLog.e("InnerWebView", ((StringBuilder)localObject1).toString());
      paramWebView = new WebResourceResponse(paramWebResourceRequest, paramWebView, ((HttpURLConnection)localObject2).getInputStream());
      return paramWebView;
    }
    catch (Exception paramWebView)
    {
      QMLog.e("InnerWebView", "shouldInterceptRequest: failed ", paramWebView);
    }
    return null;
  }
  
  private String getImageFileType(String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      paramString = ImageUtil.getType(localOptions);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QMLog.e("InnerWebView", "decodeFile error", paramString);
    }
    return "";
  }
  
  private void handleCallbackFail(String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt)
  {
    paramString1 = ApiUtil.wrapCallbackFail(paramString1, null, paramString2);
    if (paramString1 != null) {
      paramString1 = paramString1.toString();
    } else {
      paramString1 = "";
    }
    webViewEvaluteJs(paramString1, paramInt);
  }
  
  private void handleCallbackOK(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    paramString = ApiUtil.wrapCallbackOk(paramString, paramJSONObject);
    if (paramString != null) {
      paramString = paramString.toString();
    } else {
      paramString = "";
    }
    webViewEvaluteJs(paramString, paramInt);
  }
  
  private void handleProgressChanged(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onProgressChanged : ");
    ((StringBuilder)localObject).append(paramInt);
    QMLog.d("InnerWebView", ((StringBuilder)localObject).toString());
    localObject = this.mMiniAppContext;
    if (localObject != null) {
      ((IMiniAppContext)localObject).performAction(new InnerWebView.4(this, paramInt));
    }
  }
  
  private void handleReceivedTitle(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceivedTitle title : ");
    localStringBuilder.append(paramString);
    QMLog.d("InnerWebView", localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("about:blank"))) {
      AppBrandTask.runTaskOnUiThread(new InnerWebView.3(this, paramString));
    }
  }
  
  private void handleSaveWithBase64(String paramString)
  {
    Object localObject = this.mMiniAppContext;
    String str;
    if (localObject != null) {
      str = ((MiniAppFileManager)((IMiniAppContext)localObject).getManager(MiniAppFileManager.class)).getTmpPathByUrl(paramString);
    } else {
      str = "";
    }
    if (paramString.startsWith("data:image/jpg;base64,"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(".jpg");
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (paramString.startsWith("data:image/png;base64,"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = str;
      if (paramString.startsWith("data:image/jpeg;base64,"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(".jpeg");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    if (savaBase64DataToLocalPath(paramString, (String)localObject))
    {
      saveImageToAlbum((String)localObject);
      return;
    }
    QMLog.e("InnerWebView", "saveImageToAlbum savaBase64DataToLocalPath failed.");
  }
  
  private void handleSaveWithNetworkUrl(String paramString)
  {
    Object localObject = this.mMiniAppContext;
    if (localObject != null) {
      localObject = ((MiniAppFileManager)((IMiniAppContext)localObject).getManager(MiniAppFileManager.class)).getTmpPathByUrl(paramString);
    } else {
      localObject = "";
    }
    DownloaderProxy localDownloaderProxy = (DownloaderProxy)ProxyManager.get(DownloaderProxy.class);
    if (localDownloaderProxy == null)
    {
      QMLog.e("InnerWebView", "savaPicToAlbum proxy is null");
      return;
    }
    localDownloaderProxy.download(paramString, null, (String)localObject, 60, new InnerWebView.9(this, (String)localObject));
  }
  
  private void handleShareBase64Image(String paramString)
  {
    Object localObject = this.mMiniAppContext;
    String str;
    if (localObject != null) {
      str = ((MiniAppFileManager)((IMiniAppContext)localObject).getManager(MiniAppFileManager.class)).getTmpPathByUrl(paramString);
    } else {
      str = "";
    }
    if (paramString.startsWith("data:image/jpg;base64,"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(".jpg");
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (paramString.startsWith("data:image/png;base64,"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = str;
      if (paramString.startsWith("data:image/jpeg;base64,"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(".jpeg");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    if (savaBase64DataToLocalPath(paramString, (String)localObject))
    {
      realSharePicToQQ((String)localObject);
      return;
    }
    QMLog.e("InnerWebView", "startSharePicToQQ savaBase64DataToLocalPath failed.");
  }
  
  private void handleShareWebImage(String paramString)
  {
    Object localObject = this.mMiniAppContext;
    if (localObject != null) {
      localObject = ((MiniAppFileManager)((IMiniAppContext)localObject).getManager(MiniAppFileManager.class)).getTmpPathByUrl(paramString);
    } else {
      localObject = "";
    }
    DownloaderProxy localDownloaderProxy = (DownloaderProxy)ProxyManager.get(DownloaderProxy.class);
    if (localDownloaderProxy == null)
    {
      QMLog.e("InnerWebView", "savaPicToAlbum proxy is null");
      return;
    }
    localDownloaderProxy.download(paramString, null, (String)localObject, 60, new InnerWebView.10(this, (String)localObject));
  }
  
  private void initWebChromeClient()
  {
    setWebChromeClient(new InnerWebView.2(this));
  }
  
  private void initWebviewClient()
  {
    setWebViewClient(new InnerWebView.5(this));
  }
  
  private boolean isBase64(String paramString)
  {
    return (paramString.startsWith("data:image/jpg;base64,")) || (paramString.startsWith("data:image/png;base64,")) || (paramString.startsWith("data:image/jpeg;base64,"));
  }
  
  private boolean isNetworkUrl(String paramString)
  {
    return (paramString.toLowerCase().startsWith("http://")) || (paramString.toLowerCase().startsWith("https://"));
  }
  
  private void onWebviewPageError(String paramString)
  {
    if ((this.mMiniAppContext != null) && (paramString != null) && (!paramString.equals("about:blank"))) {
      this.mMiniAppContext.performAction(new InnerWebView.7(this, paramString));
    }
  }
  
  private void onWebviewPageFinished(String paramString)
  {
    if ((this.mMiniAppContext != null) && (paramString != null) && (!paramString.equals("about:blank"))) {
      this.mMiniAppContext.performAction(new InnerWebView.6(this, paramString));
    }
  }
  
  private void realSharePicToQQ(String paramString)
  {
    Object localObject = this.mMiniAppContext;
    if ((localObject != null) && (((IMiniAppContext)localObject).getAttachedActivity() != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = new InnerShareData.Builder().setShareTarget(0).setSharePicPath(paramString).build();
      localObject = (ShareProxy)ProxyManager.get(ShareProxy.class);
      if (localObject != null)
      {
        ((ShareProxy)localObject).sharePic(this.mMiniAppContext.getAttachedActivity(), paramString);
        return;
      }
      QMLog.i("InnerWebView", "proxy null");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("param error,");
    ((StringBuilder)localObject).append(paramString);
    QMLog.e("InnerWebView", ((StringBuilder)localObject).toString());
  }
  
  private boolean savaBase64DataToLocalPath(String paramString1, String paramString2)
  {
    paramString1 = paramString1.replace("data:image/jpg;base64,", "").replace("data:image/jpeg;base64,", "").replace("data:image/png;base64,", "");
    if (TextUtils.isEmpty(paramString2))
    {
      QMLog.e("InnerWebView", "getTempFilePath return null !");
      return false;
    }
    try
    {
      boolean bool = saveByteBufferToLocalFile(Base64.decode(paramString1.getBytes(), 2), paramString2);
      paramString1 = new StringBuilder();
      paramString1.append("saveByteBufferToLocalFile ret:");
      paramString1.append(bool);
      QMLog.d("InnerWebView", paramString1.toString());
      return bool;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("Base64.decode Exception: ");
      paramString2.append(paramString1.toString());
      QMLog.d("InnerWebView", paramString2.toString());
    }
    return false;
  }
  
  private void savaPicToAlbum(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("savaPicToAlbum : ");
    ((StringBuilder)localObject).append(paramString);
    QMLog.d("InnerWebView", ((StringBuilder)localObject).toString());
    localObject = this.mActivity;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (TextUtils.isEmpty(paramString))
      {
        QMLog.e("InnerWebView", "savaPicToAlbum failed, because of sourceUrl is empty");
        MiniToast.makeText(this.mActivity, 1, "保存失败", 0).show();
        return;
      }
      if (isNetworkUrl(paramString))
      {
        handleSaveWithNetworkUrl(paramString);
        return;
      }
      if (isBase64(paramString))
      {
        handleSaveWithBase64(paramString);
        return;
      }
      saveImageToAlbum(paramString);
      return;
    }
    QMLog.e("InnerWebView", "savaPicToAlbum failed, because of mActivity is empty");
    MiniToast.makeText(this.mActivity, 1, "保存失败", 0).show();
  }
  
  /* Error */
  protected static boolean saveByteBufferToLocalFile(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 546	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_3
    //   5: iconst_0
    //   6: istore_2
    //   7: iload_3
    //   8: ifeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aconst_null
    //   14: astore 5
    //   16: aconst_null
    //   17: astore 6
    //   19: aload 6
    //   21: astore 4
    //   23: new 732	java/io/File
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 733	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: aload 6
    //   34: astore 4
    //   36: aload_1
    //   37: invokevirtual 736	java/io/File:exists	()Z
    //   40: ifne +12 -> 52
    //   43: aload 6
    //   45: astore 4
    //   47: aload_1
    //   48: invokevirtual 739	java/io/File:createNewFile	()Z
    //   51: pop
    //   52: aload 6
    //   54: astore 4
    //   56: new 741	java/io/FileOutputStream
    //   59: dup
    //   60: aload_1
    //   61: invokespecial 744	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   64: astore_1
    //   65: aload_1
    //   66: aload_0
    //   67: invokevirtual 748	java/io/FileOutputStream:write	([B)V
    //   70: iconst_1
    //   71: istore_2
    //   72: aload_1
    //   73: invokevirtual 751	java/io/FileOutputStream:close	()V
    //   76: iconst_1
    //   77: ireturn
    //   78: astore_0
    //   79: new 140	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   86: astore_1
    //   87: aload_1
    //   88: ldc_w 753
    //   91: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_1
    //   96: aload_0
    //   97: invokevirtual 756	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: ldc 73
    //   103: aload_1
    //   104: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 530	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: iload_2
    //   111: ireturn
    //   112: astore_0
    //   113: aload_1
    //   114: astore 4
    //   116: goto +92 -> 208
    //   119: astore 4
    //   121: aload_1
    //   122: astore_0
    //   123: aload 4
    //   125: astore_1
    //   126: goto +11 -> 137
    //   129: astore_0
    //   130: goto +78 -> 208
    //   133: astore_1
    //   134: aload 5
    //   136: astore_0
    //   137: aload_0
    //   138: astore 4
    //   140: new 140	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   147: astore 5
    //   149: aload_0
    //   150: astore 4
    //   152: aload 5
    //   154: ldc_w 758
    //   157: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_0
    //   162: astore 4
    //   164: aload 5
    //   166: aload_1
    //   167: invokevirtual 756	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_0
    //   172: astore 4
    //   174: ldc 73
    //   176: aload 5
    //   178: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 530	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload_0
    //   185: ifnull +21 -> 206
    //   188: aload_0
    //   189: invokevirtual 751	java/io/FileOutputStream:close	()V
    //   192: iconst_0
    //   193: ireturn
    //   194: astore_0
    //   195: new 140	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   202: astore_1
    //   203: goto -116 -> 87
    //   206: iconst_0
    //   207: ireturn
    //   208: aload 4
    //   210: ifnull +47 -> 257
    //   213: aload 4
    //   215: invokevirtual 751	java/io/FileOutputStream:close	()V
    //   218: goto +39 -> 257
    //   221: astore_1
    //   222: new 140	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   229: astore 4
    //   231: aload 4
    //   233: ldc_w 753
    //   236: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 4
    //   242: aload_1
    //   243: invokevirtual 756	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: ldc 73
    //   249: aload 4
    //   251: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 530	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: goto +5 -> 262
    //   260: aload_0
    //   261: athrow
    //   262: goto -2 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramArrayOfByte	byte[]
    //   0	265	1	paramString	String
    //   6	105	2	bool1	boolean
    //   4	4	3	bool2	boolean
    //   21	94	4	localObject1	Object
    //   119	5	4	localIOException	java.io.IOException
    //   138	112	4	localObject2	Object
    //   14	163	5	localStringBuilder	StringBuilder
    //   17	36	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   72	76	78	java/lang/Exception
    //   65	70	112	finally
    //   65	70	119	java/io/IOException
    //   23	32	129	finally
    //   36	43	129	finally
    //   47	52	129	finally
    //   56	65	129	finally
    //   140	149	129	finally
    //   152	161	129	finally
    //   164	171	129	finally
    //   174	184	129	finally
    //   23	32	133	java/io/IOException
    //   36	43	133	java/io/IOException
    //   47	52	133	java/io/IOException
    //   56	65	133	java/io/IOException
    //   188	192	194	java/lang/Exception
    //   213	218	221	java/lang/Exception
  }
  
  private void saveImageToAlbum(String paramString)
  {
    Object localObject = this.mActivity;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localObject = MiniAppFileManager.getLocalPathSuffix(paramString);
      File localFile = new File(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ShortVideoUtil.getCameraPath());
      localStringBuilder.append(System.currentTimeMillis() / 1000L);
      localStringBuilder.append("_");
      localStringBuilder.append(localFile.getName());
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(".");
        ((StringBuilder)localObject).append(getImageFileType(paramString));
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = "";
      }
      localStringBuilder.append((String)localObject);
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveImageToAlbum savePath : ");
      localStringBuilder.append((String)localObject);
      QMLog.d("InnerWebView", localStringBuilder.toString());
      if (FileUtils.saveVideoToAlbum(this.mActivity, paramString, (String)localObject))
      {
        if (QMLog.isColorLevel()) {
          QMLog.d("InnerWebView", "savaPicToAlbum success.");
        }
        MiniToast.makeText(this.mActivity, 2, "保存成功", 0).show();
        return;
      }
      QMLog.e("InnerWebView", "savaPicToAlbum failed.");
      MiniToast.makeText(this.mActivity, 1, "保存失败", 0).show();
      return;
    }
    QMLog.e("InnerWebView", "savaPicToAlbum failed. activity error.");
    MiniToast.makeText(this.mActivity, 1, "保存失败", 0).show();
  }
  
  private void setLongClickLisener()
  {
    setOnLongClickListener(new InnerWebView.1(this));
  }
  
  private void sharePicToQQ(String paramString)
  {
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sharePicToQQ : ");
      localStringBuilder.append(paramString);
      QMLog.d("InnerWebView", localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString))
    {
      QMLog.e("InnerWebView", "sharePicToQQ failed, because of sourceUrl is empty");
      MiniToast.makeText(this.mActivity, 1, "分享失败", 0).show();
      return;
    }
    if (isNetworkUrl(paramString))
    {
      handleShareWebImage(paramString);
      return;
    }
    if (isBase64(paramString))
    {
      handleShareBase64Image(paramString);
      return;
    }
    realSharePicToQQ(paramString);
  }
  
  private boolean shouldOverrideUrlDomain(String paramString)
  {
    if (((this.mMiniAppContext != null) && (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https:"))) || (paramString.startsWith("http:")))
    {
      boolean bool = DomainUtil.isDomainValid(this.mMiniAppContext.getMiniAppInfo(), false, paramString, 4);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shouldOverrideUrlLoading url = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("; ret = ");
      ((StringBuilder)localObject).append(bool);
      QMLog.i("InnerWebView", ((StringBuilder)localObject).toString());
      if (!bool)
      {
        String str = WnsConfig.getConfig("qqminiapp", "https://m.q.qq.com/webview/error?url={url}&appid={appid}", "https://m.q.qq.com/webview/error?url={url}&appid={appid}");
        localObject = str;
        if (!TextUtils.isEmpty(str)) {
          localObject = str.replace("{url}", paramString).replace("{appid}", this.mMiniAppContext.getMiniAppInfo().appId);
        }
        loadUrl((String)localObject);
        return true;
      }
    }
    return false;
  }
  
  private boolean shouldOverrideUrlTel(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("tel:")))
    {
      Object localObject = this.mActivity;
      if ((localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramString.putExtra("big_brother_source_key", "biz_src_miniapp");
        try
        {
          this.mActivity.startActivity(paramString);
        }
        catch (Throwable paramString)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("error happend:");
          ((StringBuilder)localObject).append(paramString);
          QMLog.e("InnerWebView", ((StringBuilder)localObject).toString());
        }
        return true;
      }
    }
    return false;
  }
  
  private void webViewEvaluteJs(String paramString, int paramInt)
  {
    AppBrandTask.runTaskOnUiThread(new InnerWebView.8(this, String.format("__WeixinJSBridge__.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString })));
  }
  
  public int createNativeBuffer(byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    return 0;
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    webViewEvaluteJs(paramString, paramInt);
  }
  
  public void evaluateJs(String paramString, ValueCallback paramValueCallback) {}
  
  public void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("evaluateSubcribeJS : eventName ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("; data : ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("; webviweId : ");
    localStringBuilder.append(paramInt);
    QMLog.i("InnerWebView", localStringBuilder.toString());
  }
  
  public byte[] getNativeBuffer(int paramInt)
  {
    return new byte[0];
  }
  
  public void init(IMiniAppContext paramIMiniAppContext)
  {
    this.mMiniAppContext = paramIMiniAppContext;
    if (StringUtil.isEmpty(this.miniAppWebviewStr))
    {
      paramIMiniAppContext = ((BaseRuntimeImpl.BaselibProvider)paramIMiniAppContext.getManager(BaseRuntimeImpl.BaselibProvider.class)).getBaselibContent();
      if (paramIMiniAppContext != null) {
        this.miniAppWebviewStr = paramIMiniAppContext.miniappWebviewStr;
      }
    }
    this.webView = this;
    addJavascriptInterface(new InnerWebView.QQJSCoreInterface(this, null), "QQJSCore");
    initWebChromeClient();
    initWebviewClient();
    setLongClickLisener();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    FileChooserHelper localFileChooserHelper = this.mFileChooserHelper;
    if ((localFileChooserHelper != null) && (localFileChooserHelper.doOnActivityResult(paramInt1, paramInt2, paramIntent)) && (QMLog.isColorLevel())) {
      QMLog.d("InnerWebView", "Activity result handled by FileChooserHelper.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView
 * JD-Core Version:    0.7.0.1
 */
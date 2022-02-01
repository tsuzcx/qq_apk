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
  extends WebView
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
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    String str = "";
    paramActivity = str;
    if (this.mMiniAppContext != null)
    {
      paramActivity = str;
      if (this.mMiniAppContext.getMiniAppInfo() != null) {
        paramActivity = this.mMiniAppContext.getMiniAppInfo().appId;
      }
    }
    if ((localChannelProxy != null) && (localChannelProxy.isGooglePlayVersion())) {}
    for (paramActivity = localWebSettings.getUserAgentString() + " QQ/" + QUAUtil.getPlatformVersionString() + "_GM " + QUAUtil.getPlatformQUA() + " miniProgram miniprogramhtmlwebview QMA/" + paramActivity;; paramActivity = localWebSettings.getUserAgentString() + " QQ/" + QUAUtil.getPlatformVersionString() + " " + QUAUtil.getPlatformQUA() + " miniProgram miniprogramhtmlwebview QMA/" + paramActivity)
    {
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
  }
  
  private boolean checkEnableIPV6Only()
  {
    return WnsConfig.getConfig("qqminiapp", "ipv6_proxy_enable", 0) == 1;
  }
  
  private WebResourceResponse doIPV6OnlyRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    paramWebView = paramWebResourceRequest.getUrl().toString();
    String str = WnsConfig.getConfig("qqminiapp", "ipv6_http_proxy_url", "https://proxy.gtimg.cn/tx_tls_gate=");
    HttpURLConnection localHttpURLConnection;
    try
    {
      str = str + paramWebView;
      QMLog.e("InnerWebView", "shouldInterceptRequest url = " + str);
      localHttpURLConnection = (HttpURLConnection)new URL(str).openConnection();
      localHttpURLConnection.setRequestMethod(paramWebResourceRequest.getMethod());
      if (paramWebResourceRequest.getRequestHeaders() != null)
      {
        paramWebView = paramWebResourceRequest.getRequestHeaders().entrySet().iterator();
        while (paramWebView.hasNext())
        {
          paramWebResourceRequest = (Map.Entry)paramWebView.next();
          localHttpURLConnection.setRequestProperty((String)paramWebResourceRequest.getKey(), (String)paramWebResourceRequest.getValue());
        }
      }
      localHttpURLConnection.setConnectTimeout(6000);
    }
    catch (Exception paramWebView)
    {
      QMLog.e("InnerWebView", "shouldInterceptRequest: failed ", paramWebView);
      return null;
    }
    localHttpURLConnection.setReadTimeout(6000);
    paramWebResourceRequest = "";
    paramWebView = paramWebResourceRequest;
    if (localHttpURLConnection.getHeaderFields() != null)
    {
      paramWebView = paramWebResourceRequest;
      if (localHttpURLConnection.getHeaderFields().containsKey("Content-Type")) {
        paramWebView = (String)((List)localHttpURLConnection.getHeaderFields().get("Content-Type")).get(0);
      }
    }
    paramWebResourceRequest = IPV6OnlyUtils.getMimeType(paramWebView);
    paramWebView = IPV6OnlyUtils.getEncoding(paramWebView);
    QMLog.e("InnerWebView", "ipv6 code:" + localHttpURLConnection.getResponseCode() + "  url:" + str);
    QMLog.e("InnerWebView", "ipv6 mimeType = " + paramWebResourceRequest + "encoding:" + paramWebView);
    paramWebView = new WebResourceResponse(paramWebResourceRequest, paramWebView, localHttpURLConnection.getInputStream());
    return paramWebView;
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
    if (paramString1 != null) {}
    for (paramString1 = paramString1.toString();; paramString1 = "")
    {
      webViewEvaluteJs(paramString1, paramInt);
      return;
    }
  }
  
  private void handleCallbackOK(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    paramString = ApiUtil.wrapCallbackOk(paramString, paramJSONObject);
    if (paramString != null) {}
    for (paramString = paramString.toString();; paramString = "")
    {
      webViewEvaluteJs(paramString, paramInt);
      return;
    }
  }
  
  private void handleProgressChanged(int paramInt)
  {
    QMLog.d("InnerWebView", "onProgressChanged : " + paramInt);
    if (this.mMiniAppContext != null) {
      this.mMiniAppContext.performAction(new InnerWebView.4(this, paramInt));
    }
  }
  
  private void handleReceivedTitle(String paramString)
  {
    QMLog.d("InnerWebView", "onReceivedTitle title : " + paramString);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("about:blank"))) {
      AppBrandTask.runTaskOnUiThread(new InnerWebView.3(this, paramString));
    }
  }
  
  private void handleSaveWithBase64(String paramString)
  {
    String str2;
    String str1;
    if (this.mMiniAppContext != null)
    {
      str2 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPathByUrl(paramString);
      if (!paramString.startsWith("data:image/jpg;base64,")) {
        break label78;
      }
      str1 = str2 + ".jpg";
    }
    for (;;)
    {
      if (!savaBase64DataToLocalPath(paramString, str1)) {
        break label146;
      }
      saveImageToAlbum(str1);
      return;
      str2 = "";
      break;
      label78:
      if (paramString.startsWith("data:image/png;base64,"))
      {
        str1 = str2 + ".png";
      }
      else
      {
        str1 = str2;
        if (paramString.startsWith("data:image/jpeg;base64,")) {
          str1 = str2 + ".jpeg";
        }
      }
    }
    label146:
    QMLog.e("InnerWebView", "saveImageToAlbum savaBase64DataToLocalPath failed.");
  }
  
  private void handleSaveWithNetworkUrl(String paramString)
  {
    if (this.mMiniAppContext != null) {}
    DownloaderProxy localDownloaderProxy;
    for (String str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPathByUrl(paramString);; str = "")
    {
      localDownloaderProxy = (DownloaderProxy)ProxyManager.get(DownloaderProxy.class);
      if (localDownloaderProxy != null) {
        break;
      }
      QMLog.e("InnerWebView", "savaPicToAlbum proxy is null");
      return;
    }
    localDownloaderProxy.download(paramString, null, str, 60, new InnerWebView.9(this, str));
  }
  
  private void handleShareBase64Image(String paramString)
  {
    String str2;
    String str1;
    if (this.mMiniAppContext != null)
    {
      str2 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPathByUrl(paramString);
      if (!paramString.startsWith("data:image/jpg;base64,")) {
        break label78;
      }
      str1 = str2 + ".jpg";
    }
    for (;;)
    {
      if (!savaBase64DataToLocalPath(paramString, str1)) {
        break label146;
      }
      realSharePicToQQ(str1);
      return;
      str2 = "";
      break;
      label78:
      if (paramString.startsWith("data:image/png;base64,"))
      {
        str1 = str2 + ".png";
      }
      else
      {
        str1 = str2;
        if (paramString.startsWith("data:image/jpeg;base64,")) {
          str1 = str2 + ".jpeg";
        }
      }
    }
    label146:
    QMLog.e("InnerWebView", "startSharePicToQQ savaBase64DataToLocalPath failed.");
  }
  
  private void handleShareWebImage(String paramString)
  {
    if (this.mMiniAppContext != null) {}
    DownloaderProxy localDownloaderProxy;
    for (String str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPathByUrl(paramString);; str = "")
    {
      localDownloaderProxy = (DownloaderProxy)ProxyManager.get(DownloaderProxy.class);
      if (localDownloaderProxy != null) {
        break;
      }
      QMLog.e("InnerWebView", "savaPicToAlbum proxy is null");
      return;
    }
    localDownloaderProxy.download(paramString, null, str, 60, new InnerWebView.10(this, str));
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
    if ((this.mMiniAppContext == null) || (this.mMiniAppContext.getAttachedActivity() == null) || (TextUtils.isEmpty(paramString)))
    {
      QMLog.e("InnerWebView", "param error," + paramString);
      return;
    }
    paramString = new InnerShareData.Builder().setShareTarget(0).setSharePicPath(paramString).build();
    ShareProxy localShareProxy = (ShareProxy)ProxyManager.get(ShareProxy.class);
    if (localShareProxy != null)
    {
      localShareProxy.sharePic(this.mMiniAppContext.getAttachedActivity(), paramString);
      return;
    }
    QMLog.i("InnerWebView", "proxy null");
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
      QMLog.d("InnerWebView", "saveByteBufferToLocalFile ret:" + bool);
      return bool;
    }
    catch (Exception paramString1)
    {
      QMLog.d("InnerWebView", "Base64.decode Exception: " + paramString1.toString());
    }
    return false;
  }
  
  private void savaPicToAlbum(String paramString)
  {
    QMLog.d("InnerWebView", "savaPicToAlbum : " + paramString);
    if ((this.mActivity == null) || (this.mActivity.isFinishing()))
    {
      QMLog.e("InnerWebView", "savaPicToAlbum failed, because of mActivity is empty");
      MiniToast.makeText(this.mActivity, 1, "保存失败", 0).show();
      return;
    }
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
  }
  
  /* Error */
  protected static boolean saveByteBufferToLocalFile(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: invokestatic 546	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: iload_2
    //   10: ireturn
    //   11: aconst_null
    //   12: astore 5
    //   14: aconst_null
    //   15: astore 4
    //   17: aload 5
    //   19: astore_3
    //   20: new 732	java/io/File
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 733	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_1
    //   29: aload 5
    //   31: astore_3
    //   32: aload_1
    //   33: invokevirtual 736	java/io/File:exists	()Z
    //   36: ifne +11 -> 47
    //   39: aload 5
    //   41: astore_3
    //   42: aload_1
    //   43: invokevirtual 739	java/io/File:createNewFile	()Z
    //   46: pop
    //   47: aload 5
    //   49: astore_3
    //   50: new 741	java/io/FileOutputStream
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 744	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   58: astore_1
    //   59: aload_1
    //   60: aload_0
    //   61: invokevirtual 748	java/io/FileOutputStream:write	([B)V
    //   64: iconst_1
    //   65: istore_2
    //   66: aload_1
    //   67: ifnull -58 -> 9
    //   70: aload_1
    //   71: invokevirtual 751	java/io/FileOutputStream:close	()V
    //   74: iconst_1
    //   75: ireturn
    //   76: astore_0
    //   77: ldc 73
    //   79: new 140	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 753
    //   89: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: invokevirtual 756	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 530	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: iconst_1
    //   103: ireturn
    //   104: astore_1
    //   105: aload 4
    //   107: astore_0
    //   108: aload_0
    //   109: astore_3
    //   110: ldc 73
    //   112: new 140	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 758
    //   122: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_1
    //   126: invokevirtual 756	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 530	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: ifnull -127 -> 9
    //   139: aload_0
    //   140: invokevirtual 751	java/io/FileOutputStream:close	()V
    //   143: iconst_0
    //   144: ireturn
    //   145: astore_0
    //   146: ldc 73
    //   148: new 140	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 753
    //   158: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: invokevirtual 756	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 530	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: iconst_0
    //   172: ireturn
    //   173: astore_0
    //   174: aload_3
    //   175: ifnull +7 -> 182
    //   178: aload_3
    //   179: invokevirtual 751	java/io/FileOutputStream:close	()V
    //   182: aload_0
    //   183: athrow
    //   184: astore_1
    //   185: ldc 73
    //   187: new 140	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 753
    //   197: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_1
    //   201: invokevirtual 756	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 530	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: goto -28 -> 182
    //   213: astore_0
    //   214: aload_1
    //   215: astore_3
    //   216: goto -42 -> 174
    //   219: astore_3
    //   220: aload_1
    //   221: astore_0
    //   222: aload_3
    //   223: astore_1
    //   224: goto -116 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramArrayOfByte	byte[]
    //   0	227	1	paramString	String
    //   1	65	2	bool	boolean
    //   19	197	3	localObject1	Object
    //   219	4	3	localIOException	java.io.IOException
    //   15	91	4	localObject2	Object
    //   12	36	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   70	74	76	java/lang/Exception
    //   20	29	104	java/io/IOException
    //   32	39	104	java/io/IOException
    //   42	47	104	java/io/IOException
    //   50	59	104	java/io/IOException
    //   139	143	145	java/lang/Exception
    //   20	29	173	finally
    //   32	39	173	finally
    //   42	47	173	finally
    //   50	59	173	finally
    //   110	135	173	finally
    //   178	182	184	java/lang/Exception
    //   59	64	213	finally
    //   59	64	219	java/io/IOException
  }
  
  private void saveImageToAlbum(String paramString)
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      String str = MiniAppFileManager.getLocalPathSuffix(paramString);
      Object localObject = new File(paramString);
      localObject = new StringBuilder().append(ShortVideoUtil.getCameraPath()).append(System.currentTimeMillis() / 1000L).append("_").append(((File)localObject).getName());
      if (TextUtils.isEmpty(str)) {}
      for (str = "." + getImageFileType(paramString);; str = "")
      {
        str = str;
        QMLog.d("InnerWebView", "saveImageToAlbum savePath : " + str);
        if (!FileUtils.saveVideoToAlbum(this.mActivity, paramString, str)) {
          break;
        }
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
    if (QMLog.isColorLevel()) {
      QMLog.d("InnerWebView", "sharePicToQQ : " + paramString);
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
    boolean bool2 = false;
    boolean bool1;
    if ((this.mMiniAppContext == null) || (TextUtils.isEmpty(paramString)) || (!paramString.startsWith("https:")))
    {
      bool1 = bool2;
      if (!paramString.startsWith("http:")) {}
    }
    else
    {
      boolean bool3 = DomainUtil.isDomainValid(this.mMiniAppContext.getMiniAppInfo(), false, paramString, 4);
      QMLog.i("InnerWebView", "shouldOverrideUrlLoading url = " + paramString + "; ret = " + bool3);
      bool1 = bool2;
      if (!bool3)
      {
        String str2 = WnsConfig.getConfig("qqminiapp", "https://m.q.qq.com/webview/error?url={url}&appid={appid}", "https://m.q.qq.com/webview/error?url={url}&appid={appid}");
        String str1 = str2;
        if (!TextUtils.isEmpty(str2)) {
          str1 = str2.replace("{url}", paramString).replace("{appid}", this.mMiniAppContext.getMiniAppInfo().appId);
        }
        loadUrl(str1);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean shouldOverrideUrlTel(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("tel:")) && (this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.putExtra("big_brother_source_key", "biz_src_miniapp");
      try
      {
        this.mActivity.startActivity(paramString);
        return true;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          QMLog.e("InnerWebView", "error happend:" + paramString);
        }
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
    QMLog.i("InnerWebView", "evaluateSubcribeJS : eventName " + paramString1 + "; data : " + paramString2 + "; webviweId : " + paramInt);
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
    if ((this.mFileChooserHelper != null) && (this.mFileChooserHelper.doOnActivityResult(paramInt1, paramInt2, paramIntent)) && (QMLog.isColorLevel())) {
      QMLog.d("InnerWebView", "Activity result handled by FileChooserHelper.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView
 * JD-Core Version:    0.7.0.1
 */
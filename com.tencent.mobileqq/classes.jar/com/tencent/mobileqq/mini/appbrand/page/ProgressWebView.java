package com.tencent.mobileqq.mini.appbrand.page;

import alud;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import bdgk;
import bdnn;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.OnLoadServiceWebvieJsListener;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.appbrand.utils.ShareUtils;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.Set;
import ncv;
import org.json.JSONObject;
import xrg;

public class ProgressWebView
  extends WebView
  implements JsRuntime
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
  private static final String TAG = "ProgressWebView";
  private static final String TAG_JS = "ProgressWebView_js";
  private static final String WEB_BASE64_PREFIX_JPEG = "data:image/jpeg;base64,";
  private static final String WEB_BASE64_PREFIX_JPG = "data:image/jpg;base64,";
  private static final String WEB_BASE64_PREFIX_PNG = "data:image/png;base64,";
  public int htmlId;
  private Activity mActivity;
  private AppBrandRuntime mAppBrandRuntime;
  private ncv mFileChooserHelper;
  private String miniAppWebviewStr;
  private Set<String> supportApiMap;
  private WebView webView;
  
  public ProgressWebView(Activity paramActivity)
  {
    super(paramActivity);
    this.mActivity = paramActivity;
    paramActivity = getSettings();
    paramActivity.setUserAgent(paramActivity.getUserAgentString() + " QQ/" + bdgk.c() + " miniProgram miniprogramhtmlwebview");
    paramActivity.setSavePassword(false);
    paramActivity.setSaveFormData(false);
    paramActivity.setBuiltInZoomControls(true);
    paramActivity.setUseWideViewPort(true);
    paramActivity.setLoadWithOverviewMode(true);
    paramActivity.setPluginState(WebSettings.PluginState.ON);
    paramActivity.setPluginsEnabled(true);
    paramActivity.setJavaScriptCanOpenWindowsAutomatically(true);
    paramActivity.setJavaScriptEnabled(true);
    paramActivity.setSupportZoom(false);
    paramActivity.setCacheMode(-1);
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.setMixedContentMode(0);
    }
    paramActivity.setAllowContentAccess(true);
    paramActivity.setDatabaseEnabled(true);
    paramActivity.setDomStorageEnabled(true);
    paramActivity.setAppCacheEnabled(true);
    paramActivity.setMediaPlaybackRequiresUserGesture(false);
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.setMixedContentMode(0);
    }
    try
    {
      requestFocus();
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  private void WebViewEvaluteJs(String paramString, int paramInt)
  {
    paramString = String.format("__WeixinJSBridge__.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString });
    if (QLog.isColorLevel()) {
      QLog.d("ProgressWebView", 2, "[evaluateCallbackJs] callbackStr=" + paramString);
    }
    AppBrandTask.runTaskOnUiThread(new ProgressWebView.4(this, paramString));
  }
  
  private void handleCallbackFail(String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt)
  {
    paramString1 = ApiUtil.wrapCallbackFail(paramString1, null, paramString2);
    if (paramString1 != null) {}
    for (paramString1 = paramString1.toString();; paramString1 = "")
    {
      WebViewEvaluteJs(paramString1, paramInt);
      return;
    }
  }
  
  private void handleCallbackOK(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    paramString = ApiUtil.wrapCallbackOk(paramString, paramJSONObject);
    if (paramString != null) {}
    for (paramString = paramString.toString();; paramString = "")
    {
      WebViewEvaluteJs(paramString, paramInt);
      return;
    }
  }
  
  private boolean isBase64(String paramString)
  {
    return (paramString.startsWith("data:image/jpg;base64,")) || (paramString.startsWith("data:image/png;base64,")) || (paramString.startsWith("data:image/jpeg;base64,"));
  }
  
  private boolean savaBase64DataToLocalPath(String paramString1, String paramString2)
  {
    paramString1 = paramString1.replace("data:image/jpg;base64,", "").replace("data:image/jpeg;base64,", "").replace("data:image/png;base64,", "");
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("ProgressWebView", 1, "getTempFilePath return null !");
      return false;
    }
    try
    {
      boolean bool = saveByteBufferToLocalFile(Base64.decode(paramString1.getBytes(), 2), paramString2);
      QLog.d("ProgressWebView", 1, "saveByteBufferToLocalFile ret:" + bool);
      return bool;
    }
    catch (Exception paramString1)
    {
      QLog.d("ProgressWebView", 1, "Base64.decode Exception: " + paramString1.toString());
    }
    return false;
  }
  
  private void savaPicToAlbum(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProgressWebView", 2, "savaPicToAlbum : " + paramString);
    }
    if ((this.mActivity == null) || (this.mActivity.isFinishing()))
    {
      QLog.e("ProgressWebView", 1, "savaPicToAlbum failed, because of mActivity is empty");
      QQToast.a(this.mActivity, 1, alud.a(2131708904), 0).a();
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("ProgressWebView", 1, "savaPicToAlbum failed, because of sourceUrl is empty");
      QQToast.a(this.mActivity, 1, alud.a(2131708907), 0).a();
      return;
    }
    Object localObject;
    if ((paramString.toLowerCase().startsWith("http://")) || (paramString.toLowerCase().startsWith("https://")))
    {
      localObject = MiniAppFileManager.getInstance().getTmpPathByUrl(paramString);
      MiniappDownloadUtil.getInstance().download(paramString, (String)localObject, true, new ProgressWebView.5(this, (String)localObject), Downloader.DownloadMode.FastMode, null);
      return;
    }
    if (isBase64(paramString))
    {
      String str = MiniAppFileManager.getInstance().getTmpPathByUrl(paramString);
      if (paramString.startsWith("data:image/jpg;base64,")) {
        localObject = str + ".jpg";
      }
      while (savaBase64DataToLocalPath(paramString, (String)localObject))
      {
        saveImageToAlbum((String)localObject);
        return;
        if (paramString.startsWith("data:image/png;base64,"))
        {
          localObject = str + ".png";
        }
        else
        {
          localObject = str;
          if (paramString.startsWith("data:image/jpeg;base64,")) {
            localObject = str + ".jpeg";
          }
        }
      }
      QLog.e("ProgressWebView", 1, "saveImageToAlbum savaBase64DataToLocalPath failed.");
      return;
    }
    saveImageToAlbum(paramString);
  }
  
  /* Error */
  protected static boolean saveByteBufferToLocalFile(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_1
    //   3: invokestatic 339	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aconst_null
    //   12: astore 6
    //   14: aconst_null
    //   15: astore 5
    //   17: aload 6
    //   19: astore 4
    //   21: new 444	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 446	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload 6
    //   32: astore 4
    //   34: aload_1
    //   35: invokevirtual 449	java/io/File:exists	()Z
    //   38: ifne +12 -> 50
    //   41: aload 6
    //   43: astore 4
    //   45: aload_1
    //   46: invokevirtual 452	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: aload 6
    //   52: astore 4
    //   54: new 454	java/io/FileOutputStream
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 457	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_0
    //   65: invokevirtual 461	java/io/FileOutputStream:write	([B)V
    //   68: iload_3
    //   69: istore_2
    //   70: aload_1
    //   71: ifnull +9 -> 80
    //   74: aload_1
    //   75: invokevirtual 464	java/io/FileOutputStream:close	()V
    //   78: iload_3
    //   79: istore_2
    //   80: iload_2
    //   81: ireturn
    //   82: astore_0
    //   83: ldc 73
    //   85: iconst_1
    //   86: new 113	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 466
    //   96: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: iload_3
    //   110: istore_2
    //   111: goto -31 -> 80
    //   114: astore_1
    //   115: aload 5
    //   117: astore_0
    //   118: aload_0
    //   119: astore 4
    //   121: ldc 73
    //   123: iconst_1
    //   124: new 113	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 471
    //   134: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aload_0
    //   148: ifnull +104 -> 252
    //   151: aload_0
    //   152: invokevirtual 464	java/io/FileOutputStream:close	()V
    //   155: iconst_0
    //   156: istore_2
    //   157: goto -77 -> 80
    //   160: astore_0
    //   161: ldc 73
    //   163: iconst_1
    //   164: new 113	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 466
    //   174: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iconst_0
    //   188: istore_2
    //   189: goto -109 -> 80
    //   192: astore_0
    //   193: aload 4
    //   195: ifnull +8 -> 203
    //   198: aload 4
    //   200: invokevirtual 464	java/io/FileOutputStream:close	()V
    //   203: aload_0
    //   204: athrow
    //   205: astore_1
    //   206: ldc 73
    //   208: iconst_1
    //   209: new 113	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   216: ldc_w 466
    //   219: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_1
    //   223: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: goto -29 -> 203
    //   235: astore_0
    //   236: aload_1
    //   237: astore 4
    //   239: goto -46 -> 193
    //   242: astore 4
    //   244: aload_1
    //   245: astore_0
    //   246: aload 4
    //   248: astore_1
    //   249: goto -131 -> 118
    //   252: iconst_0
    //   253: istore_2
    //   254: goto -174 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramArrayOfByte	byte[]
    //   0	257	1	paramString	String
    //   69	185	2	bool1	boolean
    //   1	109	3	bool2	boolean
    //   19	219	4	localObject1	Object
    //   242	5	4	localIOException	java.io.IOException
    //   15	101	5	localObject2	Object
    //   12	39	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   74	78	82	java/lang/Exception
    //   21	30	114	java/io/IOException
    //   34	41	114	java/io/IOException
    //   45	50	114	java/io/IOException
    //   54	63	114	java/io/IOException
    //   151	155	160	java/lang/Exception
    //   21	30	192	finally
    //   34	41	192	finally
    //   45	50	192	finally
    //   54	63	192	finally
    //   121	147	192	finally
    //   198	203	205	java/lang/Exception
    //   63	68	235	finally
    //   63	68	242	java/io/IOException
  }
  
  private void saveImageToAlbum(String paramString)
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      Object localObject = new File(paramString);
      localObject = ShortVideoUtils.d() + System.currentTimeMillis() / 1000L + "_" + ((File)localObject).getName();
      if (xrg.a(this.mActivity, paramString, (String)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProgressWebView", 2, "savaPicToAlbum success.");
        }
        QQToast.a(this.mActivity, 2, alud.a(2131708894), 0).a();
        return;
      }
      QLog.e("ProgressWebView", 1, "savaPicToAlbum failed.");
      QQToast.a(this.mActivity, 1, alud.a(2131708897), 0).a();
      return;
    }
    QLog.e("ProgressWebView", 1, "savaPicToAlbum failed. activity error.");
    QQToast.a(this.mActivity, 1, alud.a(2131708901), 0).a();
  }
  
  private void sharePicToQQ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProgressWebView", 2, "sharePicToQQ : " + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("ProgressWebView", 1, "sharePicToQQ failed, because of sourceUrl is empty");
      QQToast.a(this.mActivity, 1, alud.a(2131708905), 0).a();
      return;
    }
    Object localObject;
    if ((paramString.toLowerCase().startsWith("http://")) || (paramString.toLowerCase().startsWith("https://")))
    {
      localObject = MiniAppFileManager.getInstance().getTmpPathByUrl(paramString);
      MiniappDownloadUtil.getInstance().download(paramString, (String)localObject, true, new ProgressWebView.6(this, (String)localObject), Downloader.DownloadMode.FastMode, null);
      return;
    }
    if (isBase64(paramString))
    {
      String str = MiniAppFileManager.getInstance().getTmpPathByUrl(paramString);
      if (paramString.startsWith("data:image/jpg;base64,")) {
        localObject = str + ".jpg";
      }
      while (savaBase64DataToLocalPath(paramString, (String)localObject))
      {
        ShareUtils.startSharePicToQQ(this.mActivity, (String)localObject);
        return;
        if (paramString.startsWith("data:image/png;base64,"))
        {
          localObject = str + ".png";
        }
        else
        {
          localObject = str;
          if (paramString.startsWith("data:image/jpeg;base64,")) {
            localObject = str + ".jpeg";
          }
        }
      }
      QLog.e("ProgressWebView", 1, "startSharePicToQQ savaBase64DataToLocalPath failed.");
      return;
    }
    ShareUtils.startSharePicToQQ(this.mActivity, paramString);
  }
  
  public void clearUp() {}
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    QLog.i("ProgressWebView", 1, "evaluateCallbackJs 1 callbackId : " + paramInt + "; result : " + paramString);
    WebViewEvaluteJs(paramString, paramInt);
  }
  
  public void evaluateSubcribeJS(String paramString1, String paramString2, int paramInt)
  {
    QLog.i("ProgressWebView", 1, "evaluateSubcribeJS : eventName " + paramString1 + "; data : " + paramString2 + "; webviweId : " + paramInt);
  }
  
  public ApkgInfo getApkgInfo()
  {
    return null;
  }
  
  public Context getContextEx()
  {
    return null;
  }
  
  public int getPageWebViewId()
  {
    return 0;
  }
  
  public void init(AppBrandRuntime paramAppBrandRuntime)
  {
    this.mAppBrandRuntime = paramAppBrandRuntime;
    if (bdnn.a(this.miniAppWebviewStr)) {
      this.miniAppWebviewStr = AppLoaderFactory.getAppLoaderManager().getMiniAppWebviewStr();
    }
    this.webView = this;
    addJavascriptInterface(new ProgressWebView.QQJSCoreInterface(this, null), "QQJSCore");
    setWebChromeClient(new ProgressWebView.1(this));
    setWebViewClient(new ProgressWebView.2(this));
    setOnLongClickListener(new ProgressWebView.3(this));
  }
  
  public void initService(ApkgInfo paramApkgInfo, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener) {}
  
  public void initService(ApkgInfo paramApkgInfo, String paramString, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener) {}
  
  public void initWAServiceJS(String paramString) {}
  
  public boolean isDestroyed()
  {
    return false;
  }
  
  public void loadAppServiceJs(String paramString) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.mFileChooserHelper != null) && (this.mFileChooserHelper.a(paramInt1, paramInt2, paramIntent)) && (QLog.isColorLevel())) {
      QLog.d("ProgressWebView", 2, "Activity result handled by FileChooserHelper.");
    }
  }
  
  public void postMessageToMainThread(String paramString) {}
  
  public void setApkgInfo(ApkgInfo paramApkgInfo) {}
  
  public void setAppBrandEventInterface(AppBrandServiceEventInterface paramAppBrandServiceEventInterface) {}
  
  public void setAppServiceJsCallback(ValueCallback paramValueCallback) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView
 * JD-Core Version:    0.7.0.1
 */
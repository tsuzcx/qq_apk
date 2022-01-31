package com.tencent.qqmini.sdk.runtime.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.ValueCallback;
import bglu;
import bglv;
import bgnt;
import bgor;
import bgpc;
import bgps;
import bgpv;
import bgrm;
import bhje;
import bhjl;
import bhjq;
import bhjs;
import bhjt;
import bhju;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import java.io.File;

public class InnerWebView
  extends WebView
  implements bglu
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bglv jdField_a_of_type_Bglv;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private String jdField_a_of_type_JavaLangString;
  
  public InnerWebView(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    WebSettings localWebSettings = getSettings();
    paramActivity = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if ((paramActivity != null) && (paramActivity.isGooglePlayVersion())) {}
    for (paramActivity = localWebSettings.getUserAgentString() + " QQ/" + DeviceInfoUtil.getSDKVersion() + "_GM miniProgram miniprogramhtmlwebview";; paramActivity = localWebSettings.getUserAgentString() + " QQ/" + DeviceInfoUtil.getSDKVersion() + " miniProgram miniprogramhtmlwebview")
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
  
  private void a(String paramString)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("ProgressWebView", "savaPicToAlbum : " + paramString);
    }
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      QMLog.e("ProgressWebView", "savaPicToAlbum failed, because of mActivity is empty");
      bgrm.a(this.jdField_a_of_type_AndroidAppActivity, 1, "保存失败", 0).a();
    }
    if (TextUtils.isEmpty(paramString))
    {
      QMLog.e("ProgressWebView", "savaPicToAlbum failed, because of sourceUrl is empty");
      bgrm.a(this.jdField_a_of_type_AndroidAppActivity, 1, "保存失败", 0).a();
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramString.toLowerCase().startsWith("http://")) || (paramString.toLowerCase().startsWith("https://")))
    {
      localObject1 = bgnt.a().g(paramString);
      localObject2 = (DownloaderProxy)ProxyManager.get(DownloaderProxy.class);
      if (localObject2 == null)
      {
        QMLog.e("ProgressWebView", "savaPicToAlbum proxy is null");
        return;
      }
      ((DownloaderProxy)localObject2).download(paramString, null, (String)localObject1, 60, new bhjs(this, (String)localObject1));
      return;
    }
    if (a(paramString))
    {
      localObject2 = bgnt.a().g(paramString);
      if (paramString.startsWith("data:image/jpg;base64,")) {
        localObject1 = (String)localObject2 + ".jpg";
      }
      while (a(paramString, (String)localObject1))
      {
        c((String)localObject1);
        return;
        if (paramString.startsWith("data:image/png;base64,"))
        {
          localObject1 = (String)localObject2 + ".png";
        }
        else
        {
          localObject1 = localObject2;
          if (paramString.startsWith("data:image/jpeg;base64,")) {
            localObject1 = (String)localObject2 + ".jpeg";
          }
        }
      }
      QMLog.e("ProgressWebView", "saveImageToAlbum savaBase64DataToLocalPath failed.");
      return;
    }
    c(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    paramString = String.format("__WeixinJSBridge__.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString });
    if (QMLog.isColorLevel()) {
      QMLog.d("ProgressWebView", "[evaluateCallbackJs] callbackStr=" + paramString);
    }
    bgor.a(new InnerWebView.4(this, paramString));
  }
  
  private boolean a(String paramString)
  {
    return (paramString.startsWith("data:image/jpg;base64,")) || (paramString.startsWith("data:image/png;base64,")) || (paramString.startsWith("data:image/jpeg;base64,"));
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    paramString1 = paramString1.replace("data:image/jpg;base64,", "").replace("data:image/jpeg;base64,", "").replace("data:image/png;base64,", "");
    if (TextUtils.isEmpty(paramString2))
    {
      QMLog.e("ProgressWebView", "getTempFilePath return null !");
      return false;
    }
    try
    {
      boolean bool = a(Base64.decode(paramString1.getBytes(), 2), paramString2);
      QMLog.d("ProgressWebView", "saveByteBufferToLocalFile ret:" + bool);
      return bool;
    }
    catch (Exception paramString1)
    {
      QMLog.d("ProgressWebView", "Base64.decode Exception: " + paramString1.toString());
    }
    return false;
  }
  
  /* Error */
  protected static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: iload_2
    //   10: ireturn
    //   11: aconst_null
    //   12: astore 5
    //   14: aconst_null
    //   15: astore 4
    //   17: aload 5
    //   19: astore_3
    //   20: new 317	java/io/File
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 319	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_1
    //   29: aload 5
    //   31: astore_3
    //   32: aload_1
    //   33: invokevirtual 322	java/io/File:exists	()Z
    //   36: ifne +11 -> 47
    //   39: aload 5
    //   41: astore_3
    //   42: aload_1
    //   43: invokevirtual 325	java/io/File:createNewFile	()Z
    //   46: pop
    //   47: aload 5
    //   49: astore_3
    //   50: new 327	java/io/FileOutputStream
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 330	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   58: astore_1
    //   59: aload_1
    //   60: aload_0
    //   61: invokevirtual 334	java/io/FileOutputStream:write	([B)V
    //   64: iconst_1
    //   65: istore_2
    //   66: aload_1
    //   67: ifnull -58 -> 9
    //   70: aload_1
    //   71: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   74: iconst_1
    //   75: ireturn
    //   76: astore_0
    //   77: ldc 169
    //   79: new 39	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 339
    //   89: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 175	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: iconst_1
    //   103: ireturn
    //   104: astore_1
    //   105: aload 4
    //   107: astore_0
    //   108: aload_0
    //   109: astore_3
    //   110: ldc 169
    //   112: new 39	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 344
    //   122: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_1
    //   126: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 175	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: ifnull -127 -> 9
    //   139: aload_0
    //   140: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   143: iconst_0
    //   144: ireturn
    //   145: astore_0
    //   146: ldc 169
    //   148: new 39	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 339
    //   158: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 175	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: iconst_0
    //   172: ireturn
    //   173: astore_0
    //   174: aload_3
    //   175: ifnull +7 -> 182
    //   178: aload_3
    //   179: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   182: aload_0
    //   183: athrow
    //   184: astore_1
    //   185: ldc 169
    //   187: new 39	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 339
    //   197: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_1
    //   201: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 175	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  private void b(String paramString)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("ProgressWebView", "sharePicToQQ : " + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      QMLog.e("ProgressWebView", "sharePicToQQ failed, because of sourceUrl is empty");
      bgrm.a(this.jdField_a_of_type_AndroidAppActivity, 1, "分享失败", 0).a();
    }
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if ((paramString.toLowerCase().startsWith("http://")) || (paramString.toLowerCase().startsWith("https://")))
      {
        localObject1 = bgnt.a().g(paramString);
        localObject2 = (DownloaderProxy)ProxyManager.get(DownloaderProxy.class);
        if (localObject2 == null)
        {
          QMLog.e("ProgressWebView", "savaPicToAlbum proxy is null");
          return;
        }
        ((DownloaderProxy)localObject2).download(paramString, null, (String)localObject1, 60, new bhjt(this, (String)localObject1));
        return;
      }
      if (a(paramString))
      {
        localObject2 = bgnt.a().g(paramString);
        if (paramString.startsWith("data:image/jpg;base64,")) {
          localObject1 = (String)localObject2 + ".jpg";
        }
        while (!a(paramString, (String)localObject1))
        {
          QMLog.e("ProgressWebView", "startSharePicToQQ savaBase64DataToLocalPath failed.");
          return;
          if (paramString.startsWith("data:image/png;base64,"))
          {
            localObject1 = (String)localObject2 + ".png";
          }
          else
          {
            localObject1 = localObject2;
            if (paramString.startsWith("data:image/jpeg;base64,")) {
              localObject1 = (String)localObject2 + ".jpeg";
            }
          }
        }
      }
    }
  }
  
  private void c(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      Object localObject = new File(paramString);
      localObject = bgps.a() + System.currentTimeMillis() / 1000L + "_" + ((File)localObject).getName();
      if (bgpc.a(this.jdField_a_of_type_AndroidAppActivity, paramString, (String)localObject))
      {
        if (QMLog.isColorLevel()) {
          QMLog.d("ProgressWebView", "savaPicToAlbum success.");
        }
        bgrm.a(this.jdField_a_of_type_AndroidAppActivity, 2, "保存成功", 0).a();
        return;
      }
      QMLog.e("ProgressWebView", "savaPicToAlbum failed.");
      bgrm.a(this.jdField_a_of_type_AndroidAppActivity, 1, "保存失败", 0).a();
      return;
    }
    QMLog.e("ProgressWebView", "savaPicToAlbum failed. activity error.");
    bgrm.a(this.jdField_a_of_type_AndroidAppActivity, 1, "保存失败", 0).a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, String paramString)
  {
    QMLog.i("ProgressWebView", "evaluateCallbackJs 1 callbackId : " + paramInt + "; result : " + paramString);
    a(paramString, paramInt);
  }
  
  public void a(bglv parambglv)
  {
    this.jdField_a_of_type_Bglv = parambglv;
    if (bgpv.a(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = AppLoaderFactory.g().getMiniAppEnv().getBaselibLoader().getBaselib().miniappWebviewStr;
    }
    this.jdField_a_of_type_ComTencentSmttSdkWebView = this;
    addJavascriptInterface(new bhju(this, null), "QQJSCore");
    setWebChromeClient(new bhje(this));
    setWebViewClient(new bhjl(this));
    setOnLongClickListener(new bhjq(this));
  }
  
  public void a(String paramString, ValueCallback paramValueCallback)
  {
    QMLog.i("ProgressWebView", "evaluateJs :  " + paramString);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    QMLog.i("ProgressWebView", "evaluateSubcribeJS : eventName " + paramString1 + "; data : " + paramString2 + "; webviweId : " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.InnerWebView
 * JD-Core Version:    0.7.0.1
 */
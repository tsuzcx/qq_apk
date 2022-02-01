package cooperation.qzone.webviewplugin;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IDataUtils;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import common.config.service.QzoneConfig;
import cooperation.qzone.font.FontManager;
import cooperation.qzone.util.QzoneBanApkDownloadHelper;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

public class QzoneOfflinePluginJsForQQ
  extends QzoneInternalWebViewPlugin
{
  public static final boolean DEBUG_OFFLINE = false;
  private static final int INPUTSTREAM_BUFFER_SIZE = QzoneConfig.getInstance().getConfig("QzUrlCache", "OfflineCacheBufferSize", 16384);
  public static final int MIN_VERSON_SUPPORT_SHARPP = 36521;
  private static final String SECONDARY_KEY_OFFLINE_CACHE_EXT_LIST_DEFAULT = "{'html':'text/html','css':'text/css','js':'application/javascript','jpg':'image/jpeg','jpeg':'image/jpeg','png':'image/png','bmp':'image/bmp','image':'image','webp':'image/webp'}";
  private static final int SECONDARY_KEY_OFFLINE_CACHE_SUPPORT_GZIP_DEFAULT = 1;
  private static final int SECONDARY_KEY_OFFLINE_CACHE_SUPPORT_WEBP_AND_SHARPP_DEFAULT = 1;
  private static final String SECONDARY_KEY_OFFLINE_CACHE_WHITELIST_DEFAULT = ".qzonestyle.gtimg.cn,qzonestyle.gtimg.cn,qzs.qzone.qq.com,imgcache.qq.com,p.qpic.cn,imgcache.gtimg.cn,.qq.com,.myqcloud.com,.qqopenapp.com,.qzoneapp.com,.twsapp.com,7.url.cn,8.url.cn,9.url.cn,i.gtimg.cn";
  private static final String TAG = "QzoneOfflinePluginJsForQQ";
  private static final boolean gEnalbeQzoneOffline;
  private static String gOfflineDomainWhiteList = QzoneConfig.getInstance().getConfig("QzUrlCache", "OfflineCacheWhiteList", ".qzonestyle.gtimg.cn,qzonestyle.gtimg.cn,qzs.qzone.qq.com,imgcache.qq.com,p.qpic.cn,imgcache.gtimg.cn,.qq.com,.myqcloud.com,.qqopenapp.com,.qzoneapp.com,.twsapp.com,7.url.cn,8.url.cn,9.url.cn,i.gtimg.cn");
  public static WeakReference<Activity> mActivity;
  public static WeakReference<CustomWebView> mWebView;
  
  static
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = true;
    if (1 != localQzoneConfig.getConfig("QzUrlCache", "OfflineCacheEnable", 1)) {
      bool = false;
    }
    gEnalbeQzoneOffline = bool;
  }
  
  public static boolean checkDownloadFont(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ((!paramString.contains("?_offline=1")) && (!paramString.contains("&_offline=1"))) {
        return false;
      }
      return (paramString.contains("&fontId=")) || (paramString.contains("?fontId="));
    }
    return false;
  }
  
  public static boolean checkOfflineUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((!paramString.contains("?_offline=1")) && (!paramString.contains("&_offline=1"))) {
      return false;
    }
    if (checkDownloadFont(paramString)) {
      return false;
    }
    if (!gEnalbeQzoneOffline) {
      return false;
    }
    if ((paramString.contains("_proxy=")) && ((paramString.contains("?_proxy=1")) || (paramString.contains("&_proxy=1")) || (paramString.contains("?_proxy=true")) || (paramString.contains("&_proxy=true")))) {
      return false;
    }
    boolean bool = isDomainInWhiteList(getDomain(paramString));
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("走offline url=");
      localStringBuilder.append(paramString);
      detaillog(localStringBuilder.toString());
    }
    return bool;
  }
  
  public static void detaillog(String paramString) {}
  
  private static void devlog(String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      QLog.i("QzoneOfflinePluginJsForQQ", 4, paramString);
    }
  }
  
  public static HashMap<String, String> getCacheHeadersOfFile(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile.getPath());
    localStringBuilder.append(".headers");
    paramFile = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("> getCacheHeadersOfFile: ");
    localStringBuilder.append(paramFile);
    detaillog(localStringBuilder.toString());
    paramFile = new File(paramFile);
    if (paramFile.exists()) {
      try
      {
        paramFile = jsonString2Map(readFile(paramFile));
        return paramFile;
      }
      catch (IOException paramFile)
      {
        paramFile.printStackTrace();
      }
    }
    detaillog("> getCacheHeadersOfFile: return null");
    return null;
  }
  
  private static HashMap<String, String> getConfigExtMap()
  {
    return jsonString2Map(QzoneConfig.getInstance().getConfig("QzUrlCache", "OfflineCacheExt2MimeType", "{'html':'text/html','css':'text/css','js':'application/javascript','jpg':'image/jpeg','jpeg':'image/jpeg','png':'image/png','bmp':'image/bmp','image':'image','webp':'image/webp'}"));
  }
  
  public static String getDomain(String paramString)
  {
    try
    {
      paramString = new URL(paramString).getHost();
      return paramString;
    }
    catch (Throwable paramString)
    {
      label14:
      break label14;
    }
    return null;
  }
  
  public static String getFileExt(String paramString)
  {
    try
    {
      paramString = new URL(paramString);
      localObject1 = paramString.getQuery();
      if (localObject1 == null) {
        break label98;
      }
      localObject1 = ((String)localObject1).split("&");
      if (localObject1 == null) {
        break label98;
      }
      j = localObject1.length;
      i = 0;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        Object localObject1;
        int j;
        int i;
        Object localObject2;
        int k;
        label98:
        continue;
        i += 1;
      }
    }
    if (i < j)
    {
      localObject2 = localObject1[i];
      k = localObject2.indexOf('=');
      if ((k > 0) && (k < localObject2.length() - 1) && ("_fileExt".equalsIgnoreCase(localObject2.substring(0, k)))) {
        return localObject2.substring(k + 1);
      }
    }
    else
    {
      paramString = paramString.getPath();
      if (paramString != null)
      {
        i = paramString.lastIndexOf(".");
        if ((i >= 0) && (i < paramString.length() - 1))
        {
          paramString = paramString.substring(i + 1);
          return paramString;
        }
      }
      return null;
    }
  }
  
  private static int getFontIdByUrl(String paramString)
  {
    try
    {
      paramString = new URL(paramString).getQuery();
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        int k = localObject.indexOf('=');
        if ((k > 0) && (k < localObject.length() - 1) && ("fontId".equalsIgnoreCase(localObject.substring(0, k))))
        {
          i = Integer.parseInt(localObject.substring(k + 1));
          return i;
        }
        i += 1;
      }
      return 0;
    }
    catch (Exception paramString)
    {
      QLog.e("QzoneOfflinePluginJsForQQ", 1, paramString.getMessage());
    }
  }
  
  public static String getMimeTypeFromUrl(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 1;
    int i;
    if (paramInt > 36521) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramInt > 0) {
      paramInt = j;
    } else {
      paramInt = 0;
    }
    boolean bool = isSupportWebpAndSharpp();
    if (checkOfflineUrl(paramString))
    {
      HashMap localHashMap = getConfigExtMap();
      paramString = getFileExt(paramString);
      if ((localHashMap != null) && (localHashMap.containsKey(paramString))) {
        localStringBuilder.append((String)localHashMap.get(paramString));
      }
    }
    else if (checkDownloadFont(paramString))
    {
      localStringBuilder.append("application/octet-stream");
    }
    paramString = localStringBuilder.toString();
    if ((paramString != null) && (paramString.startsWith("image")))
    {
      if ((bool) && (paramInt != 0) && (!paramString.contains("webp")))
      {
        localStringBuilder.append(",");
        localStringBuilder.append("image/webp");
      }
      if ((bool) && (i != 0) && (!paramString.contains("sharpp")))
      {
        localStringBuilder.append(",");
        localStringBuilder.append("image/sharpp");
      }
      localStringBuilder.append(",");
      localStringBuilder.append("image/*");
      localStringBuilder.append(",");
      localStringBuilder.append("*/*");
    }
    return localStringBuilder.toString();
  }
  
  private static Object interceptDownloadFontRequest(String paramString)
  {
    int i = getFontIdByUrl(paramString);
    if (i > 0)
    {
      Object localObject1 = FontManager.getInstance().getTrueTypeFont(i, paramString, null, true, null);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject2 = new File((String)localObject1);
        if (!((File)localObject2).exists())
        {
          paramString = new StringBuilder();
          paramString.append("getResponse local file not exists :");
          paramString.append((String)localObject1);
          QLog.e("QzoneOfflinePluginJsForQQ", 1, paramString.toString());
          return null;
        }
        try
        {
          localObject1 = new WebResourceResponse("application/octet-stream", "utf-8", new FileInputStream((String)localObject1));
          if (QLog.isColorLevel()) {
            QLog.i("QzoneOfflinePluginJsForQQ", 2, String.format("[SUCC] get offline cache,url : %s,mineType : %s", new Object[] { paramString, "application/octet-stream" }));
          }
          localObject2 = getCacheHeadersOfFile((File)localObject2);
          if (localObject2 != null) {
            ((WebResourceResponse)localObject1).setResponseHeaders((Map)localObject2);
          }
          return localObject1;
        }
        catch (Exception localException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("interceptDownloadFontRequest Exception: ");
          ((StringBuilder)localObject2).append(localException);
          QLog.e("QzoneOfflinePluginJsForQQ", 1, ((StringBuilder)localObject2).toString());
        }
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[FAIL] interceptDownloadFontRequest fontId: +");
    localStringBuilder.append(i);
    localStringBuilder.append(",url : ");
    localStringBuilder.append(paramString);
    QLog.e("QzoneOfflinePluginJsForQQ", 1, localStringBuilder.toString());
    return null;
  }
  
  public static boolean isDomainInWhiteList(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      Object localObject = gOfflineDomainWhiteList;
      if (localObject != null)
      {
        if (((String)localObject).length() == 0) {
          return false;
        }
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          String str = localObject[i];
          if (str != null)
          {
            str = str.trim();
            if (str.startsWith("."))
            {
              if (paramString.endsWith(str)) {
                return true;
              }
            }
            else if (paramString.equals(str)) {
              return true;
            }
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  public static boolean isSupportGZIP()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "OfflineCacheSupportGZip", 1) > 0;
  }
  
  public static boolean isSupportWebpAndSharpp()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "OfflineCacheSupportWebpAndSharppImage", 1) > 0;
  }
  
  private static HashMap<String, String> jsonString2Map(String paramString)
  {
    if (paramString != null) {
      if (paramString.length() == 0) {
        return null;
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        Iterator localIterator = localJSONObject.keys();
        if (localIterator != null)
        {
          if (!localIterator.hasNext())
          {
            return null;
            if (localIterator.hasNext())
            {
              String str1 = (String)localIterator.next();
              if (str1 == null) {
                continue;
              }
              String str2 = localJSONObject.optString(str1);
              if (str2 == null) {
                continue;
              }
              Object localObject = paramString;
              if (paramString == null) {
                localObject = new HashMap();
              }
              ((HashMap)localObject).put(str1, str2);
              paramString = (String)localObject;
              continue;
            }
            return paramString;
          }
        }
        else {
          return null;
        }
      }
      catch (Throwable paramString)
      {
        return null;
      }
      paramString = null;
    }
  }
  
  /* Error */
  public static String readFile(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: new 295	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 372	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: astore_0
    //   13: aload_0
    //   14: invokevirtual 375	java/io/FileInputStream:available	()I
    //   17: iconst_1
    //   18: iadd
    //   19: newarray byte
    //   21: astore_1
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 379	java/io/FileInputStream:read	([B)I
    //   27: pop
    //   28: new 76	java/lang/String
    //   31: dup
    //   32: aload_1
    //   33: ldc_w 381
    //   36: invokespecial 384	java/lang/String:<init>	([BLjava/lang/String;)V
    //   39: astore_1
    //   40: aload_0
    //   41: invokevirtual 387	java/io/FileInputStream:close	()V
    //   44: aload_1
    //   45: areturn
    //   46: goto +33 -> 79
    //   49: astore_2
    //   50: goto +11 -> 61
    //   53: aload_1
    //   54: astore_0
    //   55: goto +24 -> 79
    //   58: astore_2
    //   59: aload_3
    //   60: astore_0
    //   61: aload_0
    //   62: astore_1
    //   63: aload_2
    //   64: invokevirtual 388	java/lang/Exception:printStackTrace	()V
    //   67: aload_0
    //   68: ifnull +7 -> 75
    //   71: aload_0
    //   72: invokevirtual 387	java/io/FileInputStream:close	()V
    //   75: ldc_w 390
    //   78: areturn
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 387	java/io/FileInputStream:close	()V
    //   87: ldc_w 390
    //   90: areturn
    //   91: astore_0
    //   92: goto -39 -> 53
    //   95: astore_1
    //   96: goto -50 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramFile	File
    //   1	62	1	localObject1	Object
    //   95	1	1	localObject2	Object
    //   49	1	2	localException1	Exception
    //   58	6	2	localException2	Exception
    //   3	57	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   13	40	49	java/lang/Exception
    //   4	13	58	java/lang/Exception
    //   4	13	91	finally
    //   63	67	91	finally
    //   13	40	95	finally
  }
  
  @TargetApi(11)
  public static Object shouldInterceptRequest(AppInterface paramAppInterface, WebView paramWebView, String paramString1, String paramString2)
  {
    Object localObject1;
    if ((paramWebView != null) && (WebSoPlugin.a(paramWebView)) && (WebSoUtils.b(paramString1)) && (!checkOfflineUrl(paramString1)) && (!checkDownloadFont(paramString1)))
    {
      Object localObject2 = paramWebView.getTag(2131374373);
      localObject1 = paramWebView.getTag(2131374374);
      if ((localObject2 instanceof String))
      {
        localObject2 = (String)localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          try
          {
            paramAppInterface = new BufferedInputStream(new ByteArrayInputStream(((String)localObject2).getBytes("UTF-8")), INPUTSTREAM_BUFFER_SIZE);
            paramWebView.setTag(2131374373, null);
            paramWebView.setTag(2131374374, null);
            paramAppInterface = new WebResourceResponse("text/html", "UTF-8", paramAppInterface);
            if (QLog.isColorLevel())
            {
              long l2 = 0L;
              long l1 = l2;
              if (localObject1 != null)
              {
                l1 = l2;
                if ((localObject1 instanceof Long)) {
                  l1 = ((Long)localObject1).longValue();
                }
              }
              l2 = System.currentTimeMillis();
              paramWebView = new StringBuilder();
              paramWebView.append("webview use WebSo! url: ");
              paramWebView.append(paramString1);
              paramWebView.append(" , time cost=");
              paramWebView.append(l2 - l1);
              QLog.i("WebSo", 2, paramWebView.toString());
            }
            return paramAppInterface;
          }
          catch (Exception paramAppInterface)
          {
            QLog.w("QzoneOfflinePluginJsForQQ", 1, "get buffer input stream fail", paramAppInterface);
            return null;
          }
        }
      }
    }
    if (checkOfflineUrl(paramString1))
    {
      paramWebView = getConfigExtMap();
      localObject1 = getFileExt(paramString1);
      if ((paramWebView != null) && (paramWebView.containsKey(localObject1))) {
        paramWebView = (String)paramWebView.get(localObject1);
      } else {
        paramWebView = null;
      }
      if ((paramWebView != null) && (paramWebView.length() != 0))
      {
        if (QzoneZipCacheHelper.checkDownloadZip(paramString1)) {
          paramString2 = QzoneZipCacheHelper.getFileIfExists(paramAppInterface, paramString1);
        } else {
          paramString2 = QzoneOfflineCacheHelper.downLoadFileIfNeeded(paramAppInterface, paramString1, null, true, paramString2);
        }
        if ((paramString2 != null) && (paramString2.exists()))
        {
          localObject1 = getCacheHeadersOfFile(paramString2);
          paramAppInterface = paramWebView;
          if (localObject1 != null)
          {
            paramAppInterface = paramWebView;
            if (((HashMap)localObject1).get("Content-Type") != null)
            {
              paramAppInterface = (String)((HashMap)localObject1).get("Content-Type");
              paramWebView = new StringBuilder();
              paramWebView.append("Use real Content-Type header as MIME type: ");
              paramWebView.append(paramAppInterface);
              detaillog(paramWebView.toString());
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramWebView = new BufferedInputStream(new FileInputStream(paramString2), INPUTSTREAM_BUFFER_SIZE);
        if ((localObject1 == null) || (!"gzip".equalsIgnoreCase((String)((HashMap)localObject1).get("Content-Encoding")))) {
          break label723;
        }
        if (!isSupportGZIP())
        {
          ((IDataUtils)QRoute.api(IDataUtils.class)).closeDataObject(paramWebView);
          return null;
        }
        ((HashMap)localObject1).remove("Content-Encoding");
        detaillog("make gzip inputstream");
        i = 1;
        if (i != 0) {
          paramWebView = new WebResourceResponse(paramAppInterface, "utf-8", new GZIPInputStream(paramWebView));
        } else {
          paramWebView = new WebResourceResponse(paramAppInterface, "utf-8", paramWebView);
        }
        detaillog(String.format("[SUCC] get offline cache,url:%s ,minetype:%s", new Object[] { paramString1, paramAppInterface }));
        if (localObject1 != null) {
          paramWebView.setResponseHeaders((Map)localObject1);
        }
        return paramWebView;
      }
      catch (Exception paramAppInterface)
      {
        paramWebView = new StringBuilder();
        paramWebView.append("shouldInterceptRequest Exception: ");
        paramWebView.append(paramAppInterface);
        QLog.e("QzoneOfflinePluginJsForQQ", 1, paramWebView.toString());
        return null;
      }
      devlog(String.format("not get offline cache,start download,url:%s ,minetype:%s", new Object[] { paramString1, paramWebView }));
      return null;
      devlog(String.format("not support this ext,url:%s ,minetype:%s", new Object[] { paramString1, paramWebView }));
      return null;
      if (checkDownloadFont(paramString1)) {
        return interceptDownloadFontRequest(paramString1);
      }
      if ((QzoneBanApkDownloadHelper.isDomainInBlackList(paramString2)) && (QzoneBanApkDownloadHelper.isUrlMatchQzoneCallAppUrlList(paramString1))) {
        return new WebResourceResponse("text/javascript", "utf-8", new ByteArrayInputStream("if(1===1){};".getBytes()));
      }
      detaillog(String.format("not get offline cache,not offline,url:%s", new Object[] { paramString1 }));
      return null;
      label723:
      int i = 0;
    }
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    CustomWebView localCustomWebView = null;
    if (paramLong == 8L)
    {
      AppInterface localAppInterface;
      if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null))
      {
        localAppInterface = this.parentPlugin.mRuntime.a();
        mWebView = new WeakReference(this.parentPlugin.mRuntime.a());
        mActivity = new WeakReference(this.parentPlugin.mRuntime.a());
      }
      else
      {
        localAppInterface = null;
      }
      Object localObject;
      if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null)) {
        localObject = this.parentPlugin.mRuntime.a();
      } else {
        localObject = null;
      }
      if (localObject != null) {
        localObject = ((Activity)localObject).getIntent();
      } else {
        localObject = null;
      }
      if (localObject != null) {
        localObject = ((Intent)localObject).getStringExtra("url");
      } else {
        localObject = null;
      }
      WeakReference localWeakReference = mWebView;
      if (localWeakReference != null) {
        localCustomWebView = (CustomWebView)localWeakReference.get();
      }
      return shouldInterceptRequest(localAppInterface, localCustomWebView, paramString, (String)localObject);
    }
    return null;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneOfflinePluginJsForQQ
 * JD-Core Version:    0.7.0.1
 */
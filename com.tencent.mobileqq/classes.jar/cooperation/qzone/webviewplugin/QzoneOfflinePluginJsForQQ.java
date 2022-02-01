package cooperation.qzone.webviewplugin;

import aadt;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import bgve;
import bgzd;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import common.config.service.QzoneConfig;
import cooperation.qzone.font.FontInterface;
import cooperation.qzone.util.DataUtils;
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
  private static final int INPUTSTREAM_BUFFER_SIZE;
  public static final int MIN_VERSON_SUPPORT_SHARPP = 36521;
  private static final String SECONDARY_KEY_OFFLINE_CACHE_EXT_LIST_DEFAULT = "{'html':'text/html','css':'text/css','js':'application/javascript','jpg':'image/jpeg','jpeg':'image/jpeg','png':'image/png','bmp':'image/bmp','image':'image','webp':'image/webp'}";
  private static final int SECONDARY_KEY_OFFLINE_CACHE_SUPPORT_GZIP_DEFAULT = 1;
  private static final int SECONDARY_KEY_OFFLINE_CACHE_SUPPORT_WEBP_AND_SHARPP_DEFAULT = 1;
  private static final String SECONDARY_KEY_OFFLINE_CACHE_WHITELIST_DEFAULT = ".qzonestyle.gtimg.cn,qzonestyle.gtimg.cn,qzs.qzone.qq.com,imgcache.qq.com,p.qpic.cn,imgcache.gtimg.cn,.qq.com,.myqcloud.com,.qqopenapp.com,.qzoneapp.com,.twsapp.com,7.url.cn,8.url.cn,9.url.cn,i.gtimg.cn";
  private static final String TAG = "QzoneOfflinePluginJsForQQ";
  private static final boolean gEnalbeQzoneOffline;
  private static String gOfflineDomainWhiteList;
  public static WeakReference<Activity> mActivity;
  public static WeakReference<CustomWebView> mWebView;
  
  static
  {
    boolean bool = true;
    if (1 == QzoneConfig.getInstance().getConfig("QzUrlCache", "OfflineCacheEnable", 1)) {}
    for (;;)
    {
      gEnalbeQzoneOffline = bool;
      INPUTSTREAM_BUFFER_SIZE = QzoneConfig.getInstance().getConfig("QzUrlCache", "OfflineCacheBufferSize", 16384);
      gOfflineDomainWhiteList = QzoneConfig.getInstance().getConfig("QzUrlCache", "OfflineCacheWhiteList", ".qzonestyle.gtimg.cn,qzonestyle.gtimg.cn,qzs.qzone.qq.com,imgcache.qq.com,p.qpic.cn,imgcache.gtimg.cn,.qq.com,.myqcloud.com,.qqopenapp.com,.qzoneapp.com,.twsapp.com,7.url.cn,8.url.cn,9.url.cn,i.gtimg.cn");
      return;
      bool = false;
    }
  }
  
  public static boolean checkDownloadFont(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.contains("?_offline=1")) && (!paramString.contains("&_offline=1")))) {}
    while ((!paramString.contains("&fontId=")) && (!paramString.contains("?fontId="))) {
      return false;
    }
    return true;
  }
  
  public static boolean checkOfflineUrl(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = bool2;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return bool1;
                    if (paramString.contains("?_offline=1")) {
                      break;
                    }
                    bool1 = bool2;
                  } while (!paramString.contains("&_offline=1"));
                  bool1 = bool2;
                } while (checkDownloadFont(paramString));
                bool1 = bool2;
              } while (!gEnalbeQzoneOffline);
              if (!paramString.contains("_proxy=")) {
                break;
              }
              bool1 = bool2;
            } while (paramString.contains("?_proxy=1"));
            bool1 = bool2;
          } while (paramString.contains("&_proxy=1"));
          bool1 = bool2;
        } while (paramString.contains("?_proxy=true"));
        bool1 = bool2;
      } while (paramString.contains("&_proxy=true"));
      bool2 = isDomainInWhiteList(getDomain(paramString));
      bool1 = bool2;
    } while (!bool2);
    detaillog("走offline url=" + paramString);
    return bool2;
  }
  
  public static void detaillog(String paramString) {}
  
  private static void devlog(String paramString)
  {
    if ((!QLog.isDevelopLevel()) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    QLog.i("QzoneOfflinePluginJsForQQ", 4, paramString);
  }
  
  public static HashMap<String, String> getCacheHeadersOfFile(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = paramFile.getPath() + ".headers";
    detaillog("> getCacheHeadersOfFile: " + paramFile);
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
    catch (Throwable paramString) {}
    return null;
  }
  
  public static String getFileExt(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramString = new URL(paramString);
        Object localObject1 = paramString.getQuery();
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).split("&");
          if (localObject1 != null)
          {
            int j = localObject1.length;
            if (i < j)
            {
              Object localObject2 = localObject1[i];
              int k = localObject2.indexOf('=');
              if ((k <= 0) || (k >= localObject2.length() - 1) || (!"_fileExt".equalsIgnoreCase(localObject2.substring(0, k)))) {
                break label141;
              }
              return localObject2.substring(k + 1);
            }
          }
        }
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
      }
      catch (Throwable paramString) {}
      return null;
      label141:
      i += 1;
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
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    boolean bool;
    if (paramInt > 36521)
    {
      i = 1;
      if (paramInt > 0) {
        j = 1;
      }
      bool = isSupportWebpAndSharpp();
      if (!checkOfflineUrl(paramString)) {
        break label201;
      }
      HashMap localHashMap = getConfigExtMap();
      paramString = getFileExt(paramString);
      if ((localHashMap != null) && (localHashMap.containsKey(paramString))) {
        localStringBuilder.append((String)localHashMap.get(paramString));
      }
    }
    for (;;)
    {
      paramString = localStringBuilder.toString();
      if ((paramString != null) && (paramString.startsWith("image")))
      {
        if ((bool) && (j != 0) && (!paramString.contains("webp"))) {
          localStringBuilder.append(",").append("image/webp");
        }
        if ((bool) && (i != 0) && (!paramString.contains("sharpp"))) {
          localStringBuilder.append(",").append("image/sharpp");
        }
        localStringBuilder.append(",").append("image/*").append(",").append("*/*");
      }
      return localStringBuilder.toString();
      i = 0;
      break;
      label201:
      if (checkDownloadFont(paramString)) {
        localStringBuilder.append("application/octet-stream");
      }
    }
  }
  
  private static Object interceptDownloadFontRequest(String paramString)
  {
    int i = getFontIdByUrl(paramString);
    if (i > 0)
    {
      Object localObject2 = FontInterface.getTrueTypeFont(i, paramString, null, null);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        Object localObject1 = new File((String)localObject2);
        if (!((File)localObject1).exists())
        {
          QLog.e("QzoneOfflinePluginJsForQQ", 1, "getResponse local file not exists :" + (String)localObject2);
          return null;
        }
        try
        {
          localObject2 = new WebResourceResponse("application/octet-stream", "utf-8", new FileInputStream((String)localObject2));
          if (QLog.isColorLevel()) {
            QLog.i("QzoneOfflinePluginJsForQQ", 2, String.format("[SUCC] get offline cache,url : %s,mineType : %s", new Object[] { paramString, "application/octet-stream" }));
          }
          localObject1 = getCacheHeadersOfFile((File)localObject1);
          if (localObject1 != null) {
            ((WebResourceResponse)localObject2).setResponseHeaders((Map)localObject1);
          }
          return localObject2;
        }
        catch (Exception localException)
        {
          QLog.e("QzoneOfflinePluginJsForQQ", 1, "interceptDownloadFontRequest Exception: " + localException);
        }
      }
    }
    QLog.e("QzoneOfflinePluginJsForQQ", 1, "[FAIL] interceptDownloadFontRequest fontId: +" + i + ",url : " + paramString);
    return null;
  }
  
  public static boolean isDomainInWhiteList(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    Object localObject = gOfflineDomainWhiteList;
    if ((localObject == null) || (((String)localObject).length() == 0)) {
      return false;
    }
    localObject = ((String)localObject).split(",");
    int j = localObject.length;
    int i = 0;
    if (i < j)
    {
      String str = localObject[i];
      if (str == null) {}
      label93:
      do
      {
        do
        {
          i += 1;
          break;
          str = str.trim();
          if (!str.startsWith(".")) {
            break label93;
          }
        } while (!paramString.endsWith(str));
        return true;
      } while (!paramString.equals(str));
      return true;
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
    Object localObject;
    if ((paramString == null) || (paramString.length() == 0))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        localIterator = localJSONObject.keys();
        if (localIterator == null) {
          break label125;
        }
        if (localIterator.hasNext()) {
          break label120;
        }
      }
      catch (Throwable paramString)
      {
        JSONObject localJSONObject;
        Iterator localIterator;
        String str1;
        String str2;
        return null;
      }
      localObject = paramString;
      if (!localIterator.hasNext()) {
        break;
      }
      str1 = (String)localIterator.next();
      localObject = paramString;
      if (str1 != null)
      {
        str2 = localJSONObject.optString(str1);
        localObject = paramString;
        if (str2 != null)
        {
          localObject = paramString;
          if (paramString == null) {
            localObject = new HashMap();
          }
          ((HashMap)localObject).put(str1, str2);
        }
      }
      paramString = (String)localObject;
      continue;
      label120:
      paramString = null;
    }
    label125:
    return null;
  }
  
  /* Error */
  public static String readFile(File paramFile)
  {
    // Byte code:
    //   0: new 292	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 369	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokevirtual 372	java/io/FileInputStream:available	()I
    //   15: iconst_1
    //   16: iadd
    //   17: newarray byte
    //   19: astore_2
    //   20: aload_1
    //   21: astore_0
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 376	java/io/FileInputStream:read	([B)I
    //   27: pop
    //   28: aload_1
    //   29: astore_0
    //   30: new 76	java/lang/String
    //   33: dup
    //   34: aload_2
    //   35: ldc_w 378
    //   38: invokespecial 381	java/lang/String:<init>	([BLjava/lang/String;)V
    //   41: astore_2
    //   42: aload_1
    //   43: ifnull +7 -> 50
    //   46: aload_1
    //   47: invokevirtual 384	java/io/FileInputStream:close	()V
    //   50: aload_2
    //   51: areturn
    //   52: astore_2
    //   53: aconst_null
    //   54: astore_1
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: invokevirtual 385	java/lang/Exception:printStackTrace	()V
    //   61: aload_1
    //   62: ifnull +7 -> 69
    //   65: aload_1
    //   66: invokevirtual 384	java/io/FileInputStream:close	()V
    //   69: ldc_w 387
    //   72: areturn
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull +7 -> 84
    //   80: aload_0
    //   81: invokevirtual 384	java/io/FileInputStream:close	()V
    //   84: ldc_w 387
    //   87: areturn
    //   88: astore_1
    //   89: goto -13 -> 76
    //   92: astore_2
    //   93: goto -38 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramFile	File
    //   8	58	1	localFileInputStream	FileInputStream
    //   88	1	1	localObject1	Object
    //   19	32	2	localObject2	Object
    //   52	6	2	localException1	Exception
    //   92	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	9	52	java/lang/Exception
    //   0	9	73	finally
    //   11	20	88	finally
    //   22	28	88	finally
    //   30	42	88	finally
    //   57	61	88	finally
    //   11	20	92	java/lang/Exception
    //   22	28	92	java/lang/Exception
    //   30	42	92	java/lang/Exception
  }
  
  @TargetApi(11)
  public static Object shouldInterceptRequest(AppInterface paramAppInterface, WebView paramWebView, String paramString1, String paramString2)
  {
    Object localObject2;
    Object localObject1;
    if ((paramWebView != null) && (aadt.a(paramWebView)) && (bgzd.b(paramString1)) && (!checkOfflineUrl(paramString1)) && (!checkDownloadFont(paramString1)))
    {
      localObject2 = paramWebView.getTag(2131374242);
      localObject1 = paramWebView.getTag(2131374243);
      if ((localObject2 instanceof String))
      {
        localObject2 = (String)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramAppInterface = new BufferedInputStream(new ByteArrayInputStream(((String)localObject2).getBytes("UTF-8")), INPUTSTREAM_BUFFER_SIZE);
        paramWebView.setTag(2131374242, null);
        paramWebView.setTag(2131374243, null);
        paramWebView = new WebResourceResponse("text/html", "UTF-8", paramAppInterface);
        if (QLog.isColorLevel())
        {
          if ((localObject1 == null) || (!(localObject1 instanceof Long))) {
            break label679;
          }
          l1 = ((Long)localObject1).longValue();
          long l2 = System.currentTimeMillis();
          QLog.i("WebSo", 2, "webview use WebSo! url: " + paramString1 + " , time cost=" + (l2 - l1));
        }
        return paramWebView;
      }
      catch (Exception paramAppInterface)
      {
        QLog.w("QzoneOfflinePluginJsForQQ", 1, "get buffer input stream fail", paramAppInterface);
        return null;
      }
      if (checkOfflineUrl(paramString1))
      {
        paramWebView = getConfigExtMap();
        localObject1 = getFileExt(paramString1);
        if ((paramWebView == null) || (!paramWebView.containsKey(localObject1))) {
          break label674;
        }
      }
      label668:
      label674:
      for (paramWebView = (String)paramWebView.get(localObject1);; paramWebView = null)
      {
        if ((paramWebView == null) || (paramWebView.length() == 0))
        {
          devlog(String.format("not support this ext,url:%s ,minetype:%s", new Object[] { paramString1, paramWebView }));
          return null;
        }
        if (QzoneZipCacheHelper.checkDownloadZip(paramString1)) {}
        for (paramAppInterface = QzoneZipCacheHelper.getFileIfExists(paramAppInterface, paramString1); (paramAppInterface == null) || (!paramAppInterface.exists()); paramAppInterface = QzoneOfflineCacheHelper.downLoadFileIfNeeded(paramAppInterface, paramString1, null, true, paramString2))
        {
          devlog(String.format("not get offline cache,start download,url:%s ,minetype:%s", new Object[] { paramString1, paramWebView }));
          return null;
        }
        localObject1 = getCacheHeadersOfFile(paramAppInterface);
        paramString2 = paramWebView;
        if (localObject1 != null)
        {
          paramString2 = paramWebView;
          if (((HashMap)localObject1).get("Content-Type") != null)
          {
            paramString2 = (String)((HashMap)localObject1).get("Content-Type");
            detaillog("Use real Content-Type header as MIME type: " + paramString2);
          }
        }
        for (;;)
        {
          try
          {
            paramAppInterface = new BufferedInputStream(new FileInputStream(paramAppInterface), INPUTSTREAM_BUFFER_SIZE);
            if ((localObject1 == null) || (!"gzip".equalsIgnoreCase((String)((HashMap)localObject1).get("Content-Encoding")))) {
              break label668;
            }
            if (!isSupportGZIP())
            {
              DataUtils.closeDataObject(paramAppInterface);
              return null;
            }
            ((HashMap)localObject1).remove("Content-Encoding");
            detaillog("make gzip inputstream");
            i = 1;
            if (i != 0)
            {
              paramAppInterface = new WebResourceResponse(paramString2, "utf-8", new GZIPInputStream(paramAppInterface));
              detaillog(String.format("[SUCC] get offline cache,url:%s ,minetype:%s", new Object[] { paramString1, paramString2 }));
              paramWebView = paramAppInterface;
              if (localObject1 == null) {
                break;
              }
              paramAppInterface.setResponseHeaders((Map)localObject1);
              return paramAppInterface;
            }
          }
          catch (Exception paramAppInterface)
          {
            QLog.e("QzoneOfflinePluginJsForQQ", 1, "shouldInterceptRequest Exception: " + paramAppInterface);
          }
          for (;;)
          {
            return null;
            paramAppInterface = new WebResourceResponse(paramString2, "utf-8", paramAppInterface);
            break;
            if (checkDownloadFont(paramString1)) {
              return interceptDownloadFontRequest(paramString1);
            }
            if ((QzoneBanApkDownloadHelper.isDomainInBlackList(paramString2)) && (QzoneBanApkDownloadHelper.isUrlMatchQzoneCallAppUrlList(paramString1))) {
              return new WebResourceResponse("text/javascript", "utf-8", new ByteArrayInputStream("if(1===1){};".getBytes()));
            }
            detaillog(String.format("not get offline cache,not offline,url:%s", new Object[] { paramString1 }));
          }
          int i = 0;
        }
      }
      label679:
      long l1 = 0L;
    }
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    Object localObject1 = null;
    if (paramLong == 8L)
    {
      if ((this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {
        break label192;
      }
      localObject1 = this.parentPlugin.mRuntime.a();
      mWebView = new WeakReference(this.parentPlugin.mRuntime.a());
      mActivity = new WeakReference(this.parentPlugin.mRuntime.a());
    }
    for (;;)
    {
      Object localObject2;
      if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null))
      {
        localObject2 = this.parentPlugin.mRuntime.a();
        if (localObject2 == null) {
          break label174;
        }
        localObject2 = ((Activity)localObject2).getIntent();
        label121:
        if (localObject2 == null) {
          break label180;
        }
        localObject2 = ((Intent)localObject2).getStringExtra("url");
        label136:
        if (mWebView == null) {
          break label186;
        }
      }
      label174:
      label180:
      label186:
      for (CustomWebView localCustomWebView = (CustomWebView)mWebView.get();; localCustomWebView = null)
      {
        localObject1 = shouldInterceptRequest((AppInterface)localObject1, localCustomWebView, paramString, (String)localObject2);
        return localObject1;
        localObject2 = null;
        break;
        localObject2 = null;
        break label121;
        localObject2 = null;
        break label136;
      }
      label192:
      localObject1 = null;
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneOfflinePluginJsForQQ
 * JD-Core Version:    0.7.0.1
 */
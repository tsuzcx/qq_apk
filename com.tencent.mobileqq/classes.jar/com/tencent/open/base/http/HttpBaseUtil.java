package com.tencent.open.base.http;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.rookery.asyncHttpClient.CustomSSLSocketFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.TlsSniSocketFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.OpenConfig;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;
import org.json.JSONObject;

@SuppressLint({"DefaultLocale"})
public class HttpBaseUtil
{
  protected static final String a = "com.tencent.open.base.http.HttpBaseUtil";
  protected static boolean b = true;
  public static HashMap<String, String> c = new HashMap(64);
  
  public static HttpBaseUtil.HttpResponseBean a(String paramString1, String paramString2, Bundle paramBundle, HttpContext paramHttpContext)
  {
    if (AppNetConnInfo.isNetSupport()) {}
    for (;;)
    {
      Object localObject1;
      int j;
      try
      {
        localObject1 = paramBundle.getString("needhttpcache");
        String str1 = paramBundle.getString("LastModifyUseString");
        paramBundle.remove("needhttpcache");
        paramBundle.remove("LastModifyUseString");
        localObject2 = paramBundle.getString("appid_for_getting_config");
        paramBundle.remove("appid_for_getting_config");
        localObject2 = a((String)localObject2, paramString1);
        j = paramString1.length();
        boolean bool1 = paramString2.equals("GET");
        Object localObject3;
        Object localObject4;
        if (bool1)
        {
          localObject3 = a(paramBundle);
          i = ((String)localObject3).length();
          if (paramString1.indexOf("?") == -1)
          {
            paramString2 = new StringBuilder();
            paramString2.append(paramString1);
            paramString2.append("?");
            paramString2 = paramString2.toString();
          }
          else
          {
            if ((paramString1.endsWith("&")) || (TextUtils.isEmpty((CharSequence)localObject3))) {
              break label1137;
            }
            paramString2 = new StringBuilder();
            paramString2.append(paramString1);
            paramString2.append("&");
            paramString2 = paramString2.toString();
          }
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramString2);
          ((StringBuilder)localObject4).append((String)localObject3);
          localObject4 = ((StringBuilder)localObject4).toString();
          paramString2 = new StringBuilder();
          paramString2.append(paramString1);
          paramString2.append((String)localObject3);
          paramString2 = paramString2.toString();
          paramString1 = new HttpGet((String)localObject4);
          paramString1.addHeader("Accept-Encoding", "gzip");
          if (paramBundle.containsKey("Referer")) {
            paramString1.addHeader("Referer", paramBundle.getString("Referer"));
          }
          if (paramBundle.containsKey("Cookie")) {
            paramString1.addHeader("Cookie", paramBundle.getString("Cookie"));
          }
          paramString1.addHeader("Content-Type", "application/x-www-form-urlencoded");
          if (localObject1 == null) {
            break label1142;
          }
          paramString1.addHeader("If-None-Match", HttpCacheService.a().a(paramString2));
          if (str1 != null)
          {
            paramBundle = new StringBuilder();
            paramBundle.append("\"");
            paramBundle.append(HttpCacheService.a().c(paramString2));
            paramBundle.append("\"");
            paramString1.addHeader("If-Modified-Since", paramBundle.toString());
            break label1142;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("\"");
          paramBundle.append(HttpCacheService.a().b(paramString2));
          paramBundle.append("\"");
          paramString1.addHeader("If-Modified-Since", paramBundle.toString());
          paramBundle = a;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("add header. If-None-Match:");
          ((StringBuilder)localObject1).append(HttpCacheService.a().a(paramString2));
          ((StringBuilder)localObject1).append("; If-Modified-Since:");
          ((StringBuilder)localObject1).append(HttpCacheService.a().b(paramString2));
          LogUtility.c(paramBundle, ((StringBuilder)localObject1).toString());
          break label1142;
        }
        if (!paramString2.equals("POST")) {
          break label1171;
        }
        localObject1 = new HttpPost(paramString1);
        ((HttpPost)localObject1).addHeader("Accept-Encoding", "gzip");
        ((HttpPost)localObject1).addHeader("Content-Type", "application/x-www-form-urlencoded");
        bool1 = paramBundle.getBoolean("doAuthorize", false);
        paramBundle.remove("doAuthorize");
        paramString1 = paramBundle.getString("cmshow_download_key");
        boolean bool2 = TextUtils.isEmpty(paramString1);
        if ((!bool2) && (paramString1.equals("cmshow_downLoad")))
        {
          if (paramBundle.containsKey("Referer")) {
            ((HttpPost)localObject1).addHeader("Referer", paramBundle.getString("Referer"));
          }
          if (paramBundle.containsKey("Cookie")) {
            ((HttpPost)localObject1).addHeader("Cookie", paramBundle.getString("Cookie"));
          }
          if ((paramBundle.containsKey("Postbody")) && (paramBundle.containsKey("needBodyCompatible")) && (paramBundle.getBoolean("needBodyCompatible"))) {
            ((HttpPost)localObject1).addHeader("Postbody", paramBundle.getString("Postbody"));
          }
        }
        if (bool1)
        {
          localObject3 = new ArrayList();
          localObject4 = paramBundle.keySet().iterator();
          if (((Iterator)localObject4).hasNext())
          {
            String str2 = (String)((Iterator)localObject4).next();
            if ((paramBundle.get(str2) instanceof String))
            {
              ((List)localObject3).add(new BasicNameValuePair(str2, (String)paramBundle.get(str2)));
              continue;
            }
            if (!(paramBundle.get(str2) instanceof String[])) {
              continue;
            }
            String[] arrayOfString = (String[])paramBundle.get(str2);
            int k = arrayOfString.length;
            i = 0;
            paramString1 = null;
            if (i < k)
            {
              str1 = arrayOfString[i];
              if (TextUtils.isEmpty(paramString1))
              {
                paramString1 = str1;
                break label1152;
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramString1);
              localStringBuilder.append(",");
              localStringBuilder.append(str1);
              paramString1 = localStringBuilder.toString();
              break label1152;
            }
            ((List)localObject3).add(new BasicNameValuePair(str2, paramString1));
            continue;
          }
          if (!paramBundle.containsKey("method")) {
            ((List)localObject3).add(new BasicNameValuePair("method", paramString2));
          }
          ((HttpPost)localObject1).setEntity(new UrlEncodedFormEntity((List)localObject3, "UTF-8"));
          break label1161;
        }
        if ((paramBundle.containsKey("Postbody")) && ((!paramBundle.containsKey("needBodyCompatible")) || (!paramBundle.getBoolean("needBodyCompatible")))) {
          ((HttpPost)localObject1).setEntity(new ByteArrayEntity(paramBundle.getString("Postbody").getBytes()));
        } else {
          ((HttpPost)localObject1).setEntity(new ByteArrayEntity(a(paramBundle).getBytes()));
        }
      }
      catch (UnsatisfiedLinkError paramString1)
      {
        Object localObject2;
        break label1077;
      }
      catch (OutOfMemoryError paramString1)
      {
        break label1086;
      }
      catch (Exception paramString1)
      {
        break label1095;
      }
      catch (IOException paramString1)
      {
        break label1104;
      }
      catch (MalformedURLException paramString1)
      {
        break label1106;
      }
      if ((paramString1 != null) && (!paramString1.containsHeader("Cookie"))) {
        paramString1.setHeader("Cookie", c());
      }
      if (paramHttpContext == null) {
        paramString1 = ((HttpClient)localObject2).execute(paramString1);
      } else {
        paramString1 = ((HttpClient)localObject2).execute(paramString1, paramHttpContext);
      }
      c(paramString1);
      paramString1 = new HttpBaseUtil.HttpResponseBean(paramString1, i);
      return paramString1;
      label1077:
      throw new Exception(paramString1);
      label1086:
      throw new Exception(paramString1);
      label1095:
      throw new Exception(paramString1);
      label1104:
      throw paramString1;
      label1106:
      throw new MalformedURLException(paramString1.getMessage());
      paramString1 = new HttpBaseUtil.NetworkUnavailableException("network unavailable");
      for (;;)
      {
        throw paramString1;
      }
      label1137:
      paramString2 = paramString1;
      continue;
      label1142:
      int i = j + i;
      continue;
      label1152:
      i += 1;
      continue;
      label1161:
      paramString1 = (String)localObject1;
      i = j;
      continue;
      label1171:
      paramString1 = null;
      i = j;
    }
  }
  
  protected static HttpBaseUtil.NetworkProxy a(Context paramContext)
  {
    Object localObject2 = null;
    if (paramContext == null) {
      return null;
    }
    Object localObject1 = localObject2;
    if (NetworkUtil.getNetworkType(paramContext) == 0)
    {
      paramContext = a();
      int i = b();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramContext))
      {
        localObject1 = localObject2;
        if (i >= 0) {
          localObject1 = new HttpBaseUtil.NetworkProxy(paramContext, i);
        }
      }
    }
    return localObject1;
  }
  
  public static HttpBaseUtil.Statistic a(String paramString1, String paramString2, Bundle paramBundle)
  {
    return a(paramString1, paramString2, paramBundle, 0);
  }
  
  protected static HttpBaseUtil.Statistic a(String paramString1, String paramString2, Bundle paramBundle, int paramInt)
  {
    String str5 = paramBundle.getString("needhttpcache");
    String str2 = paramBundle.getString("LastModifyUseString");
    String str4 = MsfSdkUtils.insertMtype("yingyongbao", paramString1);
    String str6 = paramBundle.getString("downloadfile");
    paramBundle.remove("downloadfile");
    String str3 = paramBundle.getString("cmshow_download_key");
    paramString1 = b(str4, paramString2, paramBundle);
    paramBundle.remove("needhttpcache");
    paramBundle.remove("LastModifyUseString");
    HttpResponse localHttpResponse = paramString1.a;
    int i = paramString1.b;
    int j = localHttpResponse.getStatusLine().getStatusCode();
    String str1;
    if (localHttpResponse.containsHeader("Etag")) {
      str1 = localHttpResponse.getFirstHeader("Etag").getValue();
    } else {
      str1 = null;
    }
    if (localHttpResponse.containsHeader("Last-Modified"))
    {
      paramString1 = localHttpResponse.getFirstHeader("Last-Modified");
      if (str2 != null) {
        paramString1 = paramString1.getValue();
      } else {
        try
        {
          l = Long.parseLong(paramString1.getValue());
          localObject = "";
        }
        catch (NumberFormatException paramString1)
        {
          str2 = a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" Parse Last-Modified to Long Exception: ");
          ((StringBuilder)localObject).append(paramString1.getMessage());
          LogUtility.c(str2, ((StringBuilder)localObject).toString());
        }
      }
    }
    else
    {
      paramString1 = "";
    }
    long l = 0L;
    Object localObject = paramString1;
    if ("GET".equals(paramString2))
    {
      str2 = a(str4, paramBundle);
      paramString1 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url2=");
      localStringBuilder.append(str2);
      LogUtility.c(paramString1, localStringBuilder.toString());
    }
    else
    {
      str2 = null;
    }
    if (j == 200)
    {
      if (str6 != null)
      {
        if ((!TextUtils.isEmpty(str3)) && (str3.equals("cmshow_downLoad")) && (a(localHttpResponse).booleanValue())) {
          paramString1 = b(localHttpResponse);
        } else {
          paramString1 = "";
        }
      }
      else {
        paramString1 = b(localHttpResponse);
      }
      if ((str5 != null) && ("GET".equals(paramString2))) {
        HttpCacheService.a().a(str2, str1, l, paramString1, (String)localObject);
      }
      paramInt = 1;
    }
    else
    {
      if ((j != 304) || (str1 == null)) {
        break label591;
      }
      if (str2 != null) {
        paramString1 = HttpCacheService.a().d(str2);
      } else {
        paramString1 = "";
      }
      if ((paramString1 == null) || ("".equals(paramString1)))
      {
        str1 = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Get response from cache error. remove cache and retry. retryCount=");
        ((StringBuilder)localObject).append(paramInt);
        LogUtility.e(str1, ((StringBuilder)localObject).toString());
        if (str2 != null) {
          HttpCacheService.a().e(str2);
        }
        paramBundle.putString("needhttpcache", "nothing");
        if (paramInt < 1) {
          a(str4, paramString2, paramBundle, paramInt);
        }
      }
      paramInt = 0;
    }
    paramString1 = new HttpBaseUtil.Statistic(paramString1, i, paramInt);
    if ((!TextUtils.isEmpty(str3)) && (str3.equals("cmshow_downLoad")) && (!a(localHttpResponse).booleanValue())) {
      paramString1.e = localHttpResponse.getEntity().getContent();
    }
    return paramString1;
    label591:
    paramString1 = a;
    paramString2 = new StringBuilder();
    paramString2.append("request");
    paramString2.append(str4);
    paramString2.append("http server return error, statuscode:");
    paramString2.append(j);
    LogUtility.e(paramString1, paramString2.toString());
    paramString1 = new StringBuilder();
    paramString1.append("http status code error:");
    paramString1.append(j);
    throw new HttpBaseUtil.HttpStatusException(paramString1.toString());
  }
  
  protected static Boolean a(HttpResponse paramHttpResponse)
  {
    paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Encoding");
    if ((paramHttpResponse != null) && (paramHttpResponse.getValue().toLowerCase().indexOf("gzip") > -1)) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  protected static String a()
  {
    String str1;
    if (Build.VERSION.SDK_INT < 11)
    {
      if (CommonDataAdapter.a().b() != null)
      {
        String str2 = Proxy.getHost(CommonDataAdapter.a().b());
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          return Proxy.getDefaultHost();
        }
      }
      else
      {
        return Proxy.getDefaultHost();
      }
    }
    else {
      str1 = System.getProperty("http.proxyHost");
    }
    return str1;
  }
  
  public static String a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramBundle.get((String)localObject1);
      if (((localObject2 instanceof String)) || ((localObject2 instanceof String[])))
      {
        boolean bool = localObject2 instanceof String[];
        int k = 0;
        if (bool)
        {
          int j;
          if (i != 0)
          {
            j = 0;
          }
          else
          {
            localStringBuilder.append("&");
            j = i;
          }
          localStringBuilder.append(URLEncoder.encode((String)localObject1));
          localStringBuilder.append("=");
          localObject1 = (String[])paramBundle.getStringArray((String)localObject1);
          for (;;)
          {
            i = j;
            if (k >= localObject1.length) {
              break;
            }
            if (k == 0)
            {
              localStringBuilder.append(URLEncoder.encode(localObject1[k]));
            }
            else
            {
              localStringBuilder.append(",");
              localStringBuilder.append(URLEncoder.encode(localObject1[k]));
            }
            k += 1;
          }
        }
        if (i != 0) {
          i = 0;
        } else {
          localStringBuilder.append("&");
        }
        localStringBuilder.append(URLEncoder.encode((String)localObject1));
        localStringBuilder.append("=");
        localStringBuilder.append(URLEncoder.encode(paramBundle.getString((String)localObject1)));
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(InputStream paramInputStream)
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuilder.append(str);
    }
    paramInputStream.close();
    return localStringBuilder.toString();
  }
  
  protected static String a(String paramString, Bundle paramBundle)
  {
    String str = a(paramBundle);
    if (paramString.indexOf("?") == -1)
    {
      paramBundle = new StringBuilder();
      paramBundle.append(paramString);
      paramBundle.append("?");
      paramBundle = paramBundle.toString();
    }
    else
    {
      paramBundle = paramString;
      if (!paramString.endsWith("&"))
      {
        paramBundle = paramString;
        if (!TextUtils.isEmpty(str))
        {
          paramBundle = new StringBuilder();
          paramBundle.append(paramString);
          paramBundle.append("&");
          paramBundle = paramBundle.toString();
        }
      }
    }
    paramString = new StringBuilder();
    paramString.append(paramBundle);
    paramString.append(str);
    return paramString.toString();
  }
  
  public static HttpClient a(String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    try
    {
      localObject1 = KeyStore.getInstance(KeyStore.getDefaultType());
      ((KeyStore)localObject1).load(null, null);
      localObject1 = new CustomSSLSocketFactory((KeyStore)localObject1);
      ((CustomSSLSocketFactory)localObject1).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }
    catch (Exception localException)
    {
      Object localObject1;
      label45:
      Object localObject2;
      int j;
      StringBuilder localStringBuilder;
      int i;
      break label45;
    }
    localObject1 = SSLSocketFactory.getSocketFactory();
    break label58;
    localObject1 = SSLSocketFactory.getSocketFactory();
    label58:
    localObject2 = localObject1;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject2 = localObject1;
      if (paramString2.contains("https"))
      {
        localObject2 = localObject1;
        if (Build.VERSION.SDK_INT < 23) {
          localObject2 = new TlsSniSocketFactory(HttpBaseUtil.class.getSimpleName());
        }
      }
    }
    localObject1 = new BasicHttpParams();
    j = OpenConfig.a(CommonDataAdapter.a().b(), paramString1).d("Common_HttpConnectionTimeout");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("config 3:Common_HttpConnectionTimeout     config_value:");
    localStringBuilder.append(j);
    localStringBuilder.append("   appid:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("     url:");
    localStringBuilder.append(paramString2);
    LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
    i = j;
    if (j == 0) {
      i = 15000;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("config 3:Common_HttpConnectionTimeout     result_value:");
    localStringBuilder.append(i);
    localStringBuilder.append("   appid:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("     url:");
    localStringBuilder.append(paramString2);
    LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject1, i);
    j = OpenConfig.a(CommonDataAdapter.a().b(), paramString1).d("Common_SocketConnectionTimeout");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("config 4:Common_SocketConnectionTimeout   config_value:");
    localStringBuilder.append(j);
    localStringBuilder.append("   appid:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("     url:");
    localStringBuilder.append(paramString2);
    LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
    i = j;
    if (j == 0) {
      i = 30000;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("config 4:Common_SocketConnectionTimeout   result_value:");
    localStringBuilder.append(i);
    localStringBuilder.append("   appid:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("     url:");
    localStringBuilder.append(paramString2);
    LogUtility.c("OpenConfig_agent", localStringBuilder.toString());
    HttpConnectionParams.setSoTimeout((HttpParams)localObject1, i);
    HttpProtocolParams.setVersion((HttpParams)localObject1, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset((HttpParams)localObject1, "UTF-8");
    paramString1 = new StringBuilder();
    paramString1.append("AndroidSDK_");
    paramString1.append(Build.VERSION.SDK);
    paramString1.append("_");
    paramString1.append(Build.DEVICE);
    paramString1.append("_");
    paramString1.append(Build.VERSION.RELEASE);
    HttpProtocolParams.setUserAgent((HttpParams)localObject1, paramString1.toString());
    paramString1 = new SchemeRegistry();
    paramString1.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    paramString1.register(new Scheme("https", (SocketFactory)localObject2, 443));
    paramString1 = new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams)localObject1, paramString1), (HttpParams)localObject1);
    paramString2 = a(CommonDataAdapter.a().b());
    if (paramString2 != null)
    {
      paramString2 = new HttpHost(paramString2.a, paramString2.b);
      paramString1.getParams().setParameter("http.route.default-proxy", paramString2);
    }
    return paramString1;
  }
  
  public static JSONObject a(String paramString)
  {
    String str = paramString;
    if (paramString.equals("false")) {
      str = "{value : false}";
    }
    paramString = str;
    if (str.equals("true")) {
      paramString = "{value : true}";
    }
    str = paramString;
    if (paramString.contains("allback(")) {
      str = paramString.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
    }
    return new JSONObject(str);
  }
  
  protected static int b()
  {
    String str;
    if (Build.VERSION.SDK_INT < 11)
    {
      if (CommonDataAdapter.a().b() != null)
      {
        int j = Proxy.getPort(CommonDataAdapter.a().b());
        i = j;
        if (j < 0) {
          return Proxy.getDefaultPort();
        }
      }
      else
      {
        return Proxy.getDefaultPort();
      }
    }
    else
    {
      str = System.getProperty("http.proxyPort");
      if (TextUtils.isEmpty(str)) {}
    }
    try
    {
      i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label62:
      break label62;
    }
    int i = -1;
    return i;
  }
  
  protected static HttpBaseUtil.HttpResponseBean b(String paramString1, String paramString2, Bundle paramBundle)
  {
    return a(paramString1, paramString2, paramBundle, null);
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString.equals("false")) {
      str = "{value : false}";
    }
    paramString = str;
    if (str.equals("true")) {
      paramString = "{value : true}";
    }
    str = paramString;
    if (paramString.contains("allback(")) {
      str = paramString.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
    }
    return str;
  }
  
  /* Error */
  @SuppressLint({"DefaultLocale"})
  public static String b(HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 408 1 0
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 6
    //   11: aconst_null
    //   12: astore 7
    //   14: aload_0
    //   15: ldc_w 697
    //   18: invokeinterface 341 2 0
    //   23: ifeq +61 -> 84
    //   26: aload_0
    //   27: ldc_w 697
    //   30: invokeinterface 345 2 0
    //   35: invokeinterface 350 1 0
    //   40: invokestatic 357	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   43: lstore_3
    //   44: getstatic 158	com/tencent/open/base/http/HttpBaseUtil:a	Ljava/lang/String;
    //   47: astore 8
    //   49: new 89	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   56: astore 9
    //   58: aload 9
    //   60: ldc_w 699
    //   63: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 9
    //   69: lload_3
    //   70: invokevirtual 156	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 8
    //   76: aload 9
    //   78: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 166	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload 5
    //   86: invokeinterface 414 1 0
    //   91: astore 5
    //   93: aload_0
    //   94: ldc_w 428
    //   97: invokeinterface 345 2 0
    //   102: astore 6
    //   104: aload 6
    //   106: ifnull +67 -> 173
    //   109: aload 6
    //   111: invokeinterface 350 1 0
    //   116: invokevirtual 431	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   119: ldc 118
    //   121: invokevirtual 87	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   124: iconst_m1
    //   125: if_icmple +48 -> 173
    //   128: new 701	java/util/zip/GZIPInputStream
    //   131: dup
    //   132: aload 5
    //   134: invokespecial 702	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   137: astore 6
    //   139: aload 6
    //   141: invokestatic 704	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   144: astore 7
    //   146: aload 7
    //   148: astore_0
    //   149: goto +41 -> 190
    //   152: astore_0
    //   153: goto +82 -> 235
    //   156: astore 7
    //   158: aload 5
    //   160: astore 8
    //   162: aload 6
    //   164: astore 5
    //   166: aload 8
    //   168: astore 6
    //   170: goto +112 -> 282
    //   173: aload 5
    //   175: invokestatic 704	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   178: astore 6
    //   180: aconst_null
    //   181: astore 7
    //   183: aload 6
    //   185: astore_0
    //   186: aload 7
    //   188: astore 6
    //   190: aload 5
    //   192: ifnull +11 -> 203
    //   195: aload 5
    //   197: invokevirtual 707	java/io/InputStream:close	()V
    //   200: goto +3 -> 203
    //   203: aload_0
    //   204: astore 5
    //   206: aload 6
    //   208: ifnull +258 -> 466
    //   211: aload 6
    //   213: invokevirtual 707	java/io/InputStream:close	()V
    //   216: aload_0
    //   217: areturn
    //   218: getstatic 158	com/tencent/open/base/http/HttpBaseUtil:a	Ljava/lang/String;
    //   221: ldc_w 709
    //   224: aload 5
    //   226: invokestatic 712	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   229: aload_0
    //   230: areturn
    //   231: astore_0
    //   232: aconst_null
    //   233: astore 6
    //   235: aload 5
    //   237: astore 7
    //   239: aload 6
    //   241: astore 5
    //   243: aload 7
    //   245: astore 6
    //   247: goto +223 -> 470
    //   250: astore 7
    //   252: aload 5
    //   254: astore 6
    //   256: aconst_null
    //   257: astore 5
    //   259: goto +23 -> 282
    //   262: astore_0
    //   263: aconst_null
    //   264: astore 5
    //   266: goto +204 -> 470
    //   269: astore 8
    //   271: aconst_null
    //   272: astore 5
    //   274: aload 7
    //   276: astore 6
    //   278: aload 8
    //   280: astore 7
    //   282: getstatic 158	com/tencent/open/base/http/HttpBaseUtil:a	Ljava/lang/String;
    //   285: astore 8
    //   287: new 89	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   294: astore 9
    //   296: aload 9
    //   298: ldc_w 714
    //   301: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 9
    //   307: aload 7
    //   309: invokevirtual 715	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   312: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload 8
    //   318: aload 9
    //   320: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: aload 7
    //   325: invokestatic 712	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   328: aload_0
    //   329: invokeinterface 719 1 0
    //   334: astore_0
    //   335: aload_0
    //   336: arraylength
    //   337: istore_2
    //   338: iconst_0
    //   339: istore_1
    //   340: iload_1
    //   341: iload_2
    //   342: if_icmpge +83 -> 425
    //   345: aload_0
    //   346: iload_1
    //   347: aaload
    //   348: astore 7
    //   350: getstatic 158	com/tencent/open/base/http/HttpBaseUtil:a	Ljava/lang/String;
    //   353: astore 8
    //   355: new 89	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   362: astore 9
    //   364: aload 9
    //   366: ldc_w 721
    //   369: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload 9
    //   375: aload 7
    //   377: invokeinterface 724 1 0
    //   382: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 9
    //   388: ldc_w 726
    //   391: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload 9
    //   397: aload 7
    //   399: invokeinterface 350 1 0
    //   404: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 8
    //   410: aload 9
    //   412: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 392	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   418: iload_1
    //   419: iconst_1
    //   420: iadd
    //   421: istore_1
    //   422: goto -82 -> 340
    //   425: aload 6
    //   427: ifnull +11 -> 438
    //   430: aload 6
    //   432: invokevirtual 707	java/io/InputStream:close	()V
    //   435: goto +3 -> 438
    //   438: aload 5
    //   440: ifnull +21 -> 461
    //   443: aload 5
    //   445: invokevirtual 707	java/io/InputStream:close	()V
    //   448: goto +13 -> 461
    //   451: getstatic 158	com/tencent/open/base/http/HttpBaseUtil:a	Ljava/lang/String;
    //   454: ldc_w 709
    //   457: aload_0
    //   458: invokestatic 712	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   461: ldc_w 359
    //   464: astore 5
    //   466: aload 5
    //   468: areturn
    //   469: astore_0
    //   470: aload 6
    //   472: ifnull +11 -> 483
    //   475: aload 6
    //   477: invokevirtual 707	java/io/InputStream:close	()V
    //   480: goto +3 -> 483
    //   483: aload 5
    //   485: ifnull +22 -> 507
    //   488: aload 5
    //   490: invokevirtual 707	java/io/InputStream:close	()V
    //   493: goto +14 -> 507
    //   496: getstatic 158	com/tencent/open/base/http/HttpBaseUtil:a	Ljava/lang/String;
    //   499: ldc_w 709
    //   502: aload 5
    //   504: invokestatic 712	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   507: goto +5 -> 512
    //   510: aload_0
    //   511: athrow
    //   512: goto -2 -> 510
    //   515: astore 5
    //   517: goto -299 -> 218
    //   520: astore_0
    //   521: goto -70 -> 451
    //   524: astore 5
    //   526: goto -30 -> 496
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	529	0	paramHttpResponse	HttpResponse
    //   339	83	1	i	int
    //   337	6	2	j	int
    //   43	27	3	l	long
    //   6	497	5	localObject1	Object
    //   515	1	5	localException1	Exception
    //   524	1	5	localException2	Exception
    //   9	467	6	localObject2	Object
    //   12	135	7	str1	String
    //   156	1	7	localException3	Exception
    //   181	63	7	localObject3	Object
    //   250	25	7	localException4	Exception
    //   280	118	7	localObject4	Object
    //   47	120	8	localObject5	Object
    //   269	10	8	localException5	Exception
    //   285	124	8	str2	String
    //   56	355	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   139	146	152	finally
    //   139	146	156	java/lang/Exception
    //   93	104	231	finally
    //   109	139	231	finally
    //   173	180	231	finally
    //   93	104	250	java/lang/Exception
    //   109	139	250	java/lang/Exception
    //   173	180	250	java/lang/Exception
    //   14	84	262	finally
    //   84	93	262	finally
    //   14	84	269	java/lang/Exception
    //   84	93	269	java/lang/Exception
    //   282	338	469	finally
    //   350	418	469	finally
    //   195	200	515	java/lang/Exception
    //   211	216	515	java/lang/Exception
    //   430	435	520	java/lang/Exception
    //   443	448	520	java/lang/Exception
    //   475	480	524	java/lang/Exception
    //   488	493	524	java/lang/Exception
  }
  
  public static String c()
  {
    c.put("uin", c(String.valueOf(CommonDataAdapter.a().c())));
    c.put("skey", CommonDataAdapter.a().e());
    c.put("qua", CommonDataAdapter.a().l());
    Iterator localIterator = c.keySet().iterator();
    StringBuilder localStringBuilder;
    for (String str1 = ""; localIterator.hasNext(); str1 = localStringBuilder.toString())
    {
      String str2 = (String)localIterator.next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localStringBuilder.append("=");
      localStringBuilder.append((String)c.get(str2));
      localStringBuilder.append("; ");
    }
    return str1;
  }
  
  public static String c(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() < 10)
      {
        localObject = new StringBuilder("o");
        int i = paramString.length();
        while (i < 10)
        {
          ((StringBuilder)localObject).append("0");
          i += 1;
        }
        ((StringBuilder)localObject).append(paramString);
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("o");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static void c(HttpResponse paramHttpResponse)
  {
    LogUtility.c(a, "----setCookie");
    Object localObject1;
    if (paramHttpResponse != null) {
      localObject1 = paramHttpResponse.getHeaders("Set-Cookie");
    } else {
      localObject1 = null;
    }
    if ((localObject1 != null) && (localObject1.length != 0))
    {
      paramHttpResponse = "";
      int i = 0;
      Object localObject2;
      while (i < localObject1.length)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramHttpResponse);
        ((StringBuilder)localObject2).append(localObject1[i].getValue());
        localObject2 = ((StringBuilder)localObject2).toString();
        paramHttpResponse = (HttpResponse)localObject2;
        if (i != localObject1.length - 1)
        {
          paramHttpResponse = new StringBuilder();
          paramHttpResponse.append((String)localObject2);
          paramHttpResponse.append("; ");
          paramHttpResponse = paramHttpResponse.toString();
        }
        i += 1;
      }
      localObject1 = paramHttpResponse.split("; ");
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        paramHttpResponse = localObject1[i].trim();
        if (c.containsKey(paramHttpResponse.split("=")[0])) {
          c.remove(paramHttpResponse.split("=")[0]);
        }
        localObject2 = c;
        String str = paramHttpResponse.split("=")[0];
        if (paramHttpResponse.split("=").length == 1) {
          paramHttpResponse = "";
        } else if (paramHttpResponse.split("=").length == 2) {
          paramHttpResponse = paramHttpResponse.split("=")[1];
        } else {
          paramHttpResponse = paramHttpResponse.split("=", 2)[1];
        }
        ((HashMap)localObject2).put(str, paramHttpResponse);
        i += 1;
      }
      return;
    }
    LogUtility.c(a, "----there are no cookies");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.http.HttpBaseUtil
 * JD-Core Version:    0.7.0.1
 */
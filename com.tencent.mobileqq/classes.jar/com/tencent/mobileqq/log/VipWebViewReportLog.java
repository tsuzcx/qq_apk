package com.tencent.mobileqq.log;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class VipWebViewReportLog
{
  public static int a = 0;
  private static Context jdField_a_of_type_AndroidContentContext;
  public static final String a = "VipWebViewReportLog";
  static Thread jdField_a_of_type_JavaLangThread = null;
  static Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  static boolean jdField_a_of_type_Boolean = false;
  private static int jdField_b_of_type_Int;
  public static final String b;
  static boolean jdField_b_of_type_Boolean = false;
  private static int c;
  public static final String c;
  private static int d;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  
  static
  {
    jdField_a_of_type_AndroidContentContext = null;
    jdField_a_of_type_MqqAppAppRuntime = null;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_a_of_type_Int = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("WebViewCheck");
    localStringBuilder.append(File.separator);
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebViewCheck");
    localStringBuilder.append(File.separator);
    jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    jdField_d_of_type_JavaLangString = null;
    e = "null";
    f = "null";
    g = "null";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public static void a()
  {
    Object localObject = jdField_a_of_type_JavaLangThread;
    if ((localObject == null) || (!((Thread)localObject).isAlive()))
    {
      jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(new VipWebViewReportLog.LoadConfigRbl(), "WebviewLoadConfig", 8);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ready to load config at:");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("WebCoreDump", 1, ((StringBuilder)localObject).toString());
      }
      jdField_a_of_type_JavaLangThread.start();
    }
  }
  
  public static void a(Context paramContext, AppRuntime paramAppRuntime)
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VipWebViewReportLog init by context=");
        localStringBuilder.append(paramContext);
        localStringBuilder.append(", AppInterface=");
        localStringBuilder.append(paramAppRuntime);
        QLog.d("WebCoreDump", 2, localStringBuilder.toString());
      }
      jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
      jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
      jdField_d_of_type_Int = jdField_b_of_type_Int;
      a();
    }
  }
  
  private static void a(TelephonyManager paramTelephonyManager)
  {
    if (paramTelephonyManager == null) {
      return;
    }
    e = "null";
    f = "null";
    g = "null";
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
    {
      int i = localNetworkInfo.getType();
      if (i != 9)
      {
        switch (i)
        {
        default: 
          f = "unknown";
          g = "unknown";
          return;
        case 1: 
        case 6: 
          f = "WIFI";
          return;
        }
        e = paramTelephonyManager.getNetworkOperatorName();
        switch (paramTelephonyManager.getNetworkType())
        {
        default: 
          f = "2G";
          g = "unknown";
          return;
        case 15: 
          f = "3G";
          g = "HSPAP";
          return;
        case 14: 
          f = "3G";
          g = "EHRPD";
          return;
        case 13: 
          f = "4G";
          g = "LTE";
          return;
        case 12: 
          f = "3G";
          g = "EVDO_B";
          return;
        case 11: 
          f = "2G";
          g = "IDEN";
          return;
        case 10: 
          f = "3G";
          g = "HSPA";
          return;
        case 9: 
          f = "3G";
          g = "HSUPA";
          return;
        case 8: 
          f = "3G";
          g = "SDPA";
          return;
        case 7: 
          f = "2G";
          g = "1xRTT";
          return;
        case 6: 
          f = "3G";
          g = "EVDO_A";
          return;
        case 5: 
          f = "3G";
          g = "EVDO_0";
          return;
        case 4: 
          f = "2G";
          g = "CDMA";
          return;
        case 3: 
          f = "3G";
          g = "UMTS";
          return;
        case 2: 
          f = "2G";
          g = "EDGE";
          return;
        case 1: 
          f = "2G";
          g = "GPRS";
          return;
        }
        f = "2G";
        g = "unknown";
        return;
      }
      f = "cable";
    }
  }
  
  public static void a(ConsoleMessage paramConsoleMessage)
  {
    try
    {
      if (jdField_a_of_type_MqqAppAppRuntime == null) {
        return;
      }
      if (!QLog.isColorLevel())
      {
        if ((jdField_d_of_type_Int == jdField_c_of_type_Int) && (!jdField_a_of_type_Boolean)) {
          return;
        }
        if (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
          return;
        }
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append("protocol_ver=1");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&client_plat_id=109");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&client_ver=8.7.0");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&os_ver=");
      ((StringBuilder)localObject2).append(Build.VERSION.SDK);
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = jdField_a_of_type_MqqAppAppRuntime.getAccount();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append((String)localObject1);
      localStringBuilder2.append("&uin=");
      localStringBuilder2.append((String)localObject2);
      localObject1 = localStringBuilder2.toString();
      if (paramConsoleMessage.sourceId() != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&err_file=");
        ((StringBuilder)localObject2).append(URLEncoder.encode(paramConsoleMessage.sourceId()));
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&err_file=null");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&err_line=");
      ((StringBuilder)localObject2).append(String.valueOf(paramConsoleMessage.lineNumber()));
      localObject1 = ((StringBuilder)localObject2).toString();
      if (paramConsoleMessage.message() != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&err_message=");
        ((StringBuilder)localObject2).append(URLEncoder.encode(paramConsoleMessage.message()));
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&err_message=null");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&err_timestamp=");
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      localObject1 = ((StringBuilder)localObject2).toString();
      if (jdField_d_of_type_JavaLangString != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&err_page_url=");
        ((StringBuilder)localObject2).append(URLEncoder.encode(jdField_d_of_type_JavaLangString));
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&err_page_url=null");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      if (paramConsoleMessage.messageLevel() != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&err_level=");
        ((StringBuilder)localObject2).append(paramConsoleMessage.messageLevel().toString());
        paramConsoleMessage = ((StringBuilder)localObject2).toString();
      }
      else
      {
        paramConsoleMessage = new StringBuilder();
        paramConsoleMessage.append((String)localObject1);
        paramConsoleMessage.append("&err_level=null");
        paramConsoleMessage = paramConsoleMessage.toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramConsoleMessage);
      ((StringBuilder)localObject1).append("&phone_model=");
      ((StringBuilder)localObject1).append(Build.MODEL);
      paramConsoleMessage = ((StringBuilder)localObject1).toString();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramConsoleMessage);
        ((StringBuilder)localObject1).append("&user_status=COLORUSER");
        paramConsoleMessage = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramConsoleMessage);
        ((StringBuilder)localObject1).append("&user_status=COMMONUSER");
        paramConsoleMessage = ((StringBuilder)localObject1).toString();
      }
      try
      {
        a((TelephonyManager)jdField_a_of_type_AndroidContentContext.getSystemService("phone"));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(paramConsoleMessage);
      localStringBuilder1.append("&networkOperator=");
      localStringBuilder1.append(e);
      paramConsoleMessage = localStringBuilder1.toString();
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(paramConsoleMessage);
      localStringBuilder1.append("&mNetworkType=");
      localStringBuilder1.append(f);
      paramConsoleMessage = localStringBuilder1.toString();
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(paramConsoleMessage);
      localStringBuilder1.append("&mobileType=");
      localStringBuilder1.append(g);
      paramConsoleMessage = localStringBuilder1.toString();
      QLog.d(jdField_a_of_type_JavaLangString, 1, paramConsoleMessage);
      return;
    }
    catch (Exception paramConsoleMessage)
    {
      paramConsoleMessage.printStackTrace();
    }
  }
  
  public static void a(JSONObject paramJSONObject, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(4096);
    if ("null".equals(f)) {
      try
      {
        a((TelephonyManager)jdField_a_of_type_AndroidContentContext.getSystemService("phone"));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    localStringBuilder1.append("==> SUMMARY INFO <==\nNET_TYPE:");
    localStringBuilder1.append(f);
    localStringBuilder1.append("\n");
    localStringBuilder1.append("ERROR_CODE:");
    localStringBuilder1.append(paramInt);
    localStringBuilder1.append("\n");
    Object localObject;
    if (paramJSONObject != null)
    {
      long l2 = paramJSONObject.optLong("dns_start");
      long l8 = paramJSONObject.optLong("dns_end");
      long l3 = paramJSONObject.optLong("connect_start");
      long l9 = paramJSONObject.optLong("connect_end");
      long l4 = paramJSONObject.optLong("ssl_handshake_start");
      long l10 = paramJSONObject.optLong("ssl_handshake_end");
      long l5 = paramJSONObject.optLong("send_start");
      long l11 = paramJSONObject.optLong("send_end");
      long l6 = paramJSONObject.optLong("recv_start");
      long l7 = paramJSONObject.optLong("recv_end");
      long l1;
      if (0L != l2) {
        l1 = l2;
      } else if (0L != l3) {
        l1 = l3;
      } else if (0L != l4) {
        l1 = l4;
      } else if (0L != l5) {
        l1 = l5;
      } else if (0L != l6) {
        l1 = l6;
      } else {
        l1 = l7;
      }
      localStringBuilder1.append("DNS cost=");
      localStringBuilder1.append(l8 - l2);
      localObject = "\n";
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append("Create connect cost=");
      localStringBuilder1.append(l9 - l3);
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append("SSL handshake cost=");
      localStringBuilder1.append(l10 - l4);
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append("Send cost=");
      localStringBuilder1.append(l11 - l5);
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append("Receive cost=");
      localStringBuilder1.append(l7 - l6);
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append("Total Duration=");
      localStringBuilder1.append(l7 - l1);
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append("Original Data:\n");
      localStringBuilder1.append(paramJSONObject);
    }
    QLog.d("WebCoreDump", 1, localStringBuilder1.toString());
    if (paramWebResourceRequest != null)
    {
      localStringBuilder1.setLength(0);
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("HAS_GESTURE:");
      paramJSONObject.append(paramWebResourceRequest.hasGesture());
      paramJSONObject.append("\n");
      localStringBuilder1.append(paramJSONObject.toString());
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("IS_FOR_MAINFRAME:");
      paramJSONObject.append(paramWebResourceRequest.isForMainFrame());
      paramJSONObject.append("\n");
      localStringBuilder1.append(paramJSONObject.toString());
      localStringBuilder1.append(paramWebResourceRequest.getMethod());
      localStringBuilder1.append(" ");
      localStringBuilder1.append(paramWebResourceRequest.getUrl());
      localStringBuilder1.append("\n");
      paramJSONObject = paramWebResourceRequest.getRequestHeaders();
      if ((paramJSONObject != null) && (paramJSONObject.size() > 0))
      {
        paramWebResourceRequest = paramJSONObject.keySet().iterator();
        while (paramWebResourceRequest.hasNext())
        {
          localObject = (String)paramWebResourceRequest.next();
          StringBuilder localStringBuilder2;
          if (((String)localObject).equalsIgnoreCase("cookie"))
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append((String)localObject);
            localStringBuilder2.append(":");
            localStringBuilder2.append(Util.c((String)paramJSONObject.get(localObject), new String[0]));
            localStringBuilder2.append("\n");
            localStringBuilder1.append(localStringBuilder2.toString());
          }
          else
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append((String)localObject);
            localStringBuilder2.append(":");
            localStringBuilder2.append((String)paramJSONObject.get(localObject));
            localStringBuilder2.append("\n");
            localStringBuilder1.append(localStringBuilder2.toString());
          }
        }
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("-->HTTP REQUEST\n");
      paramJSONObject.append(localStringBuilder1.toString());
      QLog.d("WebCoreDump", 1, paramJSONObject.toString());
    }
    if (paramWebResourceResponse != null)
    {
      localStringBuilder1.setLength(0);
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("STATUS_CODE:");
      paramJSONObject.append(paramWebResourceResponse.getStatusCode());
      paramJSONObject.append("\n");
      localStringBuilder1.append(paramJSONObject.toString());
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("CONTENT_ENCODING:");
      paramJSONObject.append(paramWebResourceResponse.getEncoding());
      paramJSONObject.append("\n");
      localStringBuilder1.append(paramJSONObject.toString());
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("MIME_TYPE:");
      paramJSONObject.append(paramWebResourceResponse.getMimeType());
      paramJSONObject.append("\n");
      localStringBuilder1.append(paramJSONObject.toString());
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("REASON_PHRASE:");
      paramJSONObject.append(paramWebResourceResponse.getReasonPhrase());
      paramJSONObject.append("\n");
      localStringBuilder1.append(paramJSONObject.toString());
      paramJSONObject = paramWebResourceResponse.getResponseHeaders();
      if ((paramJSONObject != null) && (paramJSONObject.size() > 0))
      {
        paramWebResourceRequest = paramJSONObject.keySet().iterator();
        while (paramWebResourceRequest.hasNext())
        {
          paramWebResourceResponse = (String)paramWebResourceRequest.next();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramWebResourceResponse);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append((String)paramJSONObject.get(paramWebResourceResponse));
          ((StringBuilder)localObject).append("\n");
          localStringBuilder1.append(((StringBuilder)localObject).toString());
        }
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("<--HTTP RESPONSE\n");
      paramJSONObject.append(localStringBuilder1.toString());
      QLog.d("WebCoreDump", 1, paramJSONObject.toString());
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0;
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = jdField_a_of_type_JavaUtilSet.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(str)) && (paramString.contains(str)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("-->url:");
          ((StringBuilder)localObject).append(Util.b(paramString, new String[0]));
          ((StringBuilder)localObject).append(" is in white list");
          QLog.d("WebCoreDump", 1, ((StringBuilder)localObject).toString());
          return true;
        }
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->url:");
    ((StringBuilder)localObject).append(Util.b(paramString, new String[0]));
    ((StringBuilder)localObject).append(" is not in white list");
    QLog.d("WebCoreDump", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  public static void b()
  {
    if (jdField_d_of_type_Int == jdField_b_of_type_Int) {}
  }
  
  public static boolean b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->uin in white list:");
    localStringBuilder.append(jdField_b_of_type_Boolean);
    QLog.d("WebCoreDump", 1, localStringBuilder.toString());
    return jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.log.VipWebViewReportLog
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebviewReportSpeedInterface;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class VasWebReport
  extends WebViewPlugin
{
  private static final int HTTP_CAPTURE_TO_QLOG = 1;
  private static final int PERFORMANCE_TO_QLOG = 2;
  public static final String PLUGIN_NAMESPACE = "debug";
  static final String TAG = "VasWebReport";
  public static final String WEB_CORE_DATA_FLAGS = "filterType";
  public static final int WEB_CORE_DUMP_ERROR = 4;
  public static final int WEB_CORE_HTTP_CAPTURE = 2;
  public static final int WEB_CORE_PERFORMANCE_DATA = 1;
  private Map<String, Integer> errorMap = new HashMap();
  private JSONObject mFirstScreenPerformanceObject = null;
  private JSONObject mIndexPerformanceObject = null;
  URLInterceptManager mURLInterceptManager;
  private int mWebCoreDumpFlags;
  private int mWebCoreDumpHandlePolicy;
  private Map<String, Long> startTimeMap = new HashMap();
  
  public VasWebReport()
  {
    this.mPluginNameSpace = "debug";
  }
  
  private void handleNewPerformanceData(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (!paramJSONObject.has("infotype")) {
        return;
      }
      try
      {
        int i = paramJSONObject.optInt("infotype");
        if ((i == 2) && (paramJSONObject.has("first_screen")))
        {
          this.mFirstScreenPerformanceObject = paramJSONObject;
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("X5 mFirstScreenPerformanceObject: ");
            paramString.append(paramJSONObject.toString());
            QLog.i("Web_X5_Performance", 2, paramString.toString());
          }
        }
        else if ((i == 1) && (paramJSONObject.has("recv_start")))
        {
          String str2 = paramJSONObject.optString("url");
          if (TextUtils.isEmpty(str2)) {
            return;
          }
          i = str2.indexOf("?");
          String str1 = str2;
          if (i != -1) {
            str1 = str2.substring(0, i);
          }
          i = paramString.indexOf("?");
          str2 = paramString;
          if (i != -1) {
            str2 = paramString.substring(0, i);
          }
          if (str2.equalsIgnoreCase(str1))
          {
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("X5 index onResourcesPerformance: ");
              paramString.append(paramJSONObject.toString());
              QLog.i("Web_X5_Performance", 2, paramString.toString());
            }
            this.mIndexPerformanceObject = paramJSONObject;
          }
        }
        if ((this.mIndexPerformanceObject != null) && (this.mFirstScreenPerformanceObject != null))
        {
          paramString = this.mIndexPerformanceObject;
          paramString.put("first_screen", this.mFirstScreenPerformanceObject.optLong("first_screen"));
          long l1 = paramString.optLong("dns_start");
          paramString.optLong("dns_end");
          long l2 = paramString.optLong("connect_start");
          paramString.optLong("connect_end");
          long l3 = paramString.optLong("send_start");
          paramString.optLong("send_end");
          long l4 = paramString.optLong("recv_start");
          long l5 = paramString.optLong("recv_end");
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("Web_X5_Load_Index, dns start: ");
          paramJSONObject.append(l1);
          paramJSONObject.append(", connect start: ");
          paramJSONObject.append(l2);
          paramJSONObject.append(", send start: ");
          paramJSONObject.append(l3);
          paramJSONObject.append(", receive first packet start: ");
          paramJSONObject.append(l4);
          paramJSONObject.append(", receive last packet end: ");
          paramJSONObject.append(l5);
          QLog.d("Web_X5_Performance", 1, paramJSONObject.toString());
          paramJSONObject = this.mRuntime.a(this.mRuntime.d());
          if ((paramJSONObject != null) && ((paramJSONObject instanceof WebUiUtils.WebviewReportSpeedInterface)))
          {
            ((WebUiUtils.WebviewReportSpeedInterface)paramJSONObject).setX5Performance(paramString);
            this.mIndexPerformanceObject = null;
            this.mFirstScreenPerformanceObject = null;
            return;
          }
          if ((this.mRuntime.d() instanceof SwiftWebViewFragmentSupporter))
          {
            paramJSONObject = (SwiftBrowserStatistics)super.getBrowserComponent(-2);
            if (paramJSONObject != null)
            {
              paramJSONObject.aI = paramString;
              this.mIndexPerformanceObject = null;
              this.mFirstScreenPerformanceObject = null;
              return;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void handlePerformanceData(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        long l1 = paramJSONObject.optLong("first_word");
        long l2 = paramJSONObject.optLong("first_screen");
        long l3 = paramJSONObject.optLong("page_finish");
        boolean bool = QLog.isColorLevel();
        if (bool)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("X5 onResourcesPerformance, first_word: ");
          ((StringBuilder)localObject1).append(l1);
          ((StringBuilder)localObject1).append(", first_screen:");
          ((StringBuilder)localObject1).append(l2);
          ((StringBuilder)localObject1).append(", page_finish:");
          ((StringBuilder)localObject1).append(l3);
          QLog.i("Web_X5_Performance", 2, ((StringBuilder)localObject1).toString());
        }
        paramJSONObject = paramJSONObject.getJSONArray("resources");
        if ((paramJSONObject == null) || (paramJSONObject.length() <= 0)) {
          break label347;
        }
        localObject1 = paramJSONObject.getJSONObject(0);
        bool = QLog.isColorLevel();
        if (bool)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("X5 onResourcesPerformance: ");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.i("Web_X5_Performance", 2, ((StringBuilder)localObject2).toString());
        }
        ((JSONObject)localObject1).put("first_screen", l2);
        ((JSONObject)localObject1).optLong("dns_start");
        ((JSONObject)localObject1).optLong("dns_end");
        ((JSONObject)localObject1).optLong("connect_start");
        ((JSONObject)localObject1).optLong("connect_end");
        ((JSONObject)localObject1).optLong("recv_start");
        ((JSONObject)localObject1).optLong("recv_end");
        localObject2 = this.mRuntime.a(this.mRuntime.d());
        if ((localObject2 == null) || (!(localObject2 instanceof WebUiUtils.WebviewReportSpeedInterface))) {
          break label348;
        }
        ((WebUiUtils.WebviewReportSpeedInterface)localObject2).setX5Performance((JSONObject)localObject1);
      }
      catch (Exception paramJSONObject)
      {
        Object localObject1;
        Object localObject2;
        paramJSONObject.printStackTrace();
      }
      if (i < paramJSONObject.length())
      {
        localObject1 = paramJSONObject.getJSONObject(i);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("X5 onResourcesPerformance: ");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.i("Web_X5_Performance", 2, ((StringBuilder)localObject2).toString());
        }
        i += 1;
      }
      else
      {
        label347:
        return;
        label348:
        i = 1;
      }
    }
  }
  
  private void handlePublicAccountReport(String paramString, JSONObject paramJSONObject)
  {
    String str2 = paramString;
    if ((paramJSONObject != null) && (paramJSONObject.has("infotype"))) {}
    label560:
    label562:
    label568:
    label571:
    for (;;)
    {
      String str3;
      try
      {
        if (paramJSONObject.optInt("infotype") == 1)
        {
          str3 = paramJSONObject.optString("url");
          if (TextUtils.isEmpty(str3)) {
            return;
          }
          int i = str3.indexOf("?");
          if (i == -1) {
            break label562;
          }
          paramString = str3.substring(0, i);
          i = str2.indexOf("?");
          String str1 = str2;
          if (i != -1) {
            str1 = str2.substring(0, i);
          }
          long l1 = paramJSONObject.optLong("dns_start");
          long l2 = paramJSONObject.optLong("dns_end");
          long l3 = paramJSONObject.optLong("connect_start");
          long l4 = paramJSONObject.optLong("connect_end");
          long l5 = paramJSONObject.optLong("recv_start");
          long l6 = paramJSONObject.optLong("recv_end");
          Object localObject = new URL(str3);
          str2 = ((URL)localObject).getHost();
          localObject = ((URL)localObject).getPath();
          boolean bool = "qqpublic.qpic.cn".equalsIgnoreCase(str2);
          if (!bool) {
            break label571;
          }
          try
          {
            if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).startsWith("/qq_public"))) {
              break label571;
            }
            i = (int)(l2 - l1);
            int j = (int)(l4 - l3);
            int k = (int)(l6 - l5);
            int m = paramJSONObject.optInt("errorcode");
            localObject = paramJSONObject.optString("website_address");
            int n = NetUtil.a(null);
            if (!QLog.isColorLevel()) {
              break label568;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("urlStr: ");
            localStringBuilder.append(str3);
            localStringBuilder.append(",errorcode:");
            localStringBuilder.append(m);
            localStringBuilder.append(",netType:");
            localStringBuilder.append(n);
            localStringBuilder.append(",DNSCost");
            localStringBuilder.append(i);
            localStringBuilder.append(",connectCost:");
            localStringBuilder.append(j);
            localStringBuilder.append(",receiveCost:");
            localStringBuilder.append(k);
            localStringBuilder.append(",website_address:");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(",AppSetting.subVersion:");
            localStringBuilder.append("8.8.17,3,5770");
            QLog.i("PublicAccountWebReport", 2, localStringBuilder.toString());
            if ((str1.equalsIgnoreCase(paramString)) && ("post.mp.qq.com".equalsIgnoreCase(str2)))
            {
              i = (int)(l2 - l1);
              j = (int)(l4 - l3);
              k = (int)(l6 - l5);
              m = paramJSONObject.optInt("errorcode");
              paramString = paramJSONObject.optString("website_address");
              try
              {
                PublicAccountWebReport.reportPublicAccountNetInfoRequest(this.mRuntime.b(), j, i, m, k, str3, paramString);
                l2 = this.mFirstScreenPerformanceObject.optLong("first_screen");
                if (!QLog.isColorLevel()) {
                  break label560;
                }
                paramString = new StringBuilder();
                paramString.append("first_screen: ");
                paramString.append(l2 - l1);
                QLog.i("PublicAccountWebReport", 2, paramString.toString());
                return;
              }
              catch (Exception paramString) {}
            }
            return;
          }
          catch (Exception paramString) {}
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return;
      return;
      paramString = str3;
    }
  }
  
  private void startActivity(Intent paramIntent)
  {
    if (this.mRuntime == null) {
      return;
    }
    if (this.mRuntime.d() != null)
    {
      this.mRuntime.d().startActivity(paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VasWebReport", 2, "Activity is null");
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 96L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    boolean bool2 = true;
    Object localObject1;
    int i;
    boolean bool1;
    if (paramLong == 32L)
    {
      if ((paramString.startsWith("http")) || (paramString.startsWith("https")))
      {
        paramMap = this.mRuntime.a();
        if (paramMap != null)
        {
          if (paramMap.getX5WebViewExtension() == null) {
            return false;
          }
          localObject1 = WebAccelerateHelper.getInstance().getWebViewFeatureParams();
          if (localObject1 != null) {
            i = localObject1[6].intValue();
          } else {
            i = 65535;
          }
          this.mWebCoreDumpHandlePolicy |= 0x1;
          if (BaseApplicationImpl.sProcessId == 2)
          {
            this.mWebCoreDumpFlags = 0;
            if (QLog.isColorLevel()) {
              QLog.d("WebCoreDump", 2, "disable for qzone");
            }
          }
          else
          {
            if ((VipWebViewReportLog.a(paramString)) && (VipWebViewReportLog.b())) {
              this.mWebCoreDumpFlags |= 0x3;
            }
            if (paramMap.getContext().getSharedPreferences("WebView_X5_Report", 4).getBoolean("enableX5Report", true))
            {
              this.mWebCoreDumpFlags |= 0x1;
              this.mWebCoreDumpHandlePolicy |= 0x2;
            }
          }
          this.mWebCoreDumpFlags &= i;
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("Data Filter Mask=0x");
            paramString.append(Integer.toHexString(i));
            paramString.append(". setDataFilterForRequestInfo=");
            paramString.append(this.mWebCoreDumpFlags);
            paramString.append(". WebCoreDumpPolicy=");
            paramString.append(this.mWebCoreDumpHandlePolicy);
            QLog.d("WebCoreDump", 2, paramString.toString());
          }
          if (this.mWebCoreDumpFlags != 0)
          {
            paramString = new Bundle();
            paramString.putInt("filterType", this.mWebCoreDumpFlags);
            paramMap.getX5WebViewExtension().invokeMiscMethod("setDataFilterForRequestInfo", paramString);
            if ((this.mWebCoreDumpFlags & 0x2) != 0) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            paramMap.recordHttpStream(bool1);
            paramString = new Bundle();
            if ((this.mWebCoreDumpFlags & 0x1) != 0) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
            paramString.putBoolean("enabled", bool1);
            paramMap.getX5WebViewExtension().invokeMiscMethod("webPerformanceRecordingEnabled", paramString);
            return false;
          }
        }
        else
        {
          return false;
        }
      }
    }
    else
    {
      Object localObject3;
      Object localObject2;
      if (paramLong == 64L)
      {
        if (this.mWebCoreDumpFlags != 0)
        {
          Integer localInteger = Integer.valueOf(0);
          localObject1 = paramMap.get("performanceData");
          bool1 = localObject1 instanceof JSONObject;
          localObject3 = null;
          if (bool1) {
            localObject1 = (JSONObject)localObject1;
          } else {
            localObject1 = null;
          }
          localObject2 = paramMap.get("requestData");
          if ((localObject2 instanceof WebResourceRequest)) {
            localObject2 = (WebResourceRequest)localObject2;
          } else {
            localObject2 = null;
          }
          Object localObject4 = paramMap.get("responseData");
          if ((localObject4 instanceof WebResourceResponse)) {
            localObject3 = (WebResourceResponse)localObject4;
          }
          localObject4 = paramMap.get("errorCode");
          paramMap = localInteger;
          if ((localObject4 instanceof Integer)) {
            paramMap = (Integer)localObject4;
          }
          if (((this.mWebCoreDumpHandlePolicy & 0x1) != 0) && (localObject2 != null)) {
            VipWebViewReportLog.a((JSONObject)localObject1, (WebResourceRequest)localObject2, (WebResourceResponse)localObject3, paramMap.intValue());
          }
          if (((this.mWebCoreDumpHandlePolicy & 0x2) != 0) && (localObject1 != null))
          {
            if (((JSONObject)localObject1).has("infotype"))
            {
              handleNewPerformanceData(paramString, (JSONObject)localObject1);
              handlePublicAccountReport(paramString, (JSONObject)localObject1);
              return true;
            }
            handlePerformanceData((JSONObject)localObject1);
            return true;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("VasWebReport", 2, "WebView core dump received but no policy can handle it");
        }
        return true;
      }
      if (paramLong == 8589934593L)
      {
        this.startTimeMap.remove(paramString);
        this.startTimeMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
        if (QLog.isColorLevel())
        {
          QLog.d("VasWebReport", 2, "VasWebReport:EVENT_LOAD_START");
          return false;
        }
      }
      else if (paramLong == 8589934594L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasWebReport", 2, "VasWebReport:EVENT_LOAD_FINISH");
        }
        if ((paramString.contains("vip.qq.com")) || (paramString.contains("vaswebreport=1")))
        {
          if (this.mRuntime == null) {
            break label1266;
          }
          if (this.mRuntime.d() == null) {
            return false;
          }
          paramMap = this.mRuntime.d().getApplicationContext();
          if (2 == NetworkUtil.getSystemNetwork(paramMap)) {
            paramMap = "2G";
          }
          for (;;)
          {
            break;
            if (3 == NetworkUtil.getSystemNetwork(paramMap)) {
              paramMap = "3G";
            } else if (4 == NetworkUtil.getSystemNetwork(paramMap)) {
              paramMap = "4G";
            } else if (1 == NetworkUtil.getSystemNetwork(paramMap)) {
              paramMap = "WIFI";
            } else {
              paramMap = "XG";
            }
          }
          if (this.errorMap.containsKey(paramString))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("errocode:");
            ((StringBuilder)localObject1).append(this.errorMap.get(paramString));
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject2 = Util.b(paramString, new String[0]);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("8.8.17--android--");
            ((StringBuilder)localObject3).append(Build.VERSION.SDK_INT);
            ReportController.a(null, "P_CliOper", "vasweb", "", "load", "finish", 0, 1, (String)localObject1, paramMap, (String)localObject2, ((StringBuilder)localObject3).toString());
            this.errorMap.remove(paramString);
          }
          else
          {
            long l = -1L;
            if (this.startTimeMap.containsKey(paramString))
            {
              paramLong = System.currentTimeMillis() - ((Long)this.startTimeMap.get(paramString)).longValue();
            }
            else
            {
              paramLong = l;
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("VasWebReport--EVENT_LOAD_FINISH:report erro,there is not starttime for ");
                ((StringBuilder)localObject1).append(paramString);
                QLog.e("VasWebReport", 2, ((StringBuilder)localObject1).toString());
                paramLong = l;
              }
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(paramLong);
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject2 = Util.b(paramString, new String[0]);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("8.8.17--android--");
            ((StringBuilder)localObject3).append(Build.VERSION.SDK_INT);
            ReportController.a(null, "P_CliOper", "vasweb", "", "load", "finish", 0, 0, (String)localObject1, paramMap, (String)localObject2, ((StringBuilder)localObject3).toString());
          }
        }
        this.startTimeMap.remove(paramString);
        paramString = this.mRuntime.d();
        if ((this.mRuntime.f() != null) && (this.mRuntime.f().getAppRuntime() != null))
        {
          paramMap = (URLInterceptManager)this.mRuntime.f().getAppRuntime().getManager(QQManagerFactory.URL_INTECEPT_MANAGER);
          if ((paramMap != null) && (!paramMap.a()))
          {
            paramMap.a(paramString);
            return false;
            label1266:
            return false;
          }
        }
      }
      else if (paramLong == 8589934595L)
      {
        i = ((Integer)paramMap.get("errorCode")).intValue();
        this.errorMap.put(paramString, Integer.valueOf(i));
        if (QLog.isColorLevel()) {
          QLog.e("VasWebReport", 2, "VasWebReport:EVENT_LOAD_ERROR");
        }
      }
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("debug".equalsIgnoreCase(paramString2)) && ("log".equalsIgnoreCase(paramString3)))
    {
      paramJsBridgeListener = (SwiftBrowserStatistics)super.getBrowserComponent(-2);
      if (paramJsBridgeListener != null)
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("try report web status, onNetworkCost,  step: 11, asyncMode: ");
          paramString2.append(paramJsBridgeListener.ar);
          paramString2.append(", from loadUrl: ");
          paramString2.append(System.currentTimeMillis() - paramJsBridgeListener.u);
          paramString2.append(", stepTime: ");
          paramString2.append(System.currentTimeMillis() - paramJsBridgeListener.c);
          paramString2.append(", totalTime: ");
          paramString2.append(System.currentTimeMillis() - paramJsBridgeListener.c);
          paramString2.append(", \n ");
          paramString2.append(paramString1);
          QLog.d("QQBrowser_report", 2, paramString2.toString());
        }
        return true;
      }
    }
    return false;
  }
  
  protected void onDestroy()
  {
    this.startTimeMap.clear();
    this.startTimeMap = null;
    this.errorMap.clear();
    this.errorMap = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebReport
 * JD-Core Version:    0.7.0.1
 */
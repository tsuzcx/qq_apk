package com.tencent.mobileqq.kandian.glue.viola.adapter;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJNetworkUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.commons.IReportDelegate;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.utils.ViolaUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public class ViolaReportDelegate
  implements IReportDelegate
{
  public static String a = "ViolaReportDelegate";
  public HashMap<String, String> b = new HashMap();
  
  private JSONObject a(String paramString)
  {
    Object localObject = new JSONObject();
    String str1 = Uri.parse(paramString).getQueryParameter("v_bid");
    try
    {
      ((JSONObject)localObject).put(ViolaEnvironment.COMMON_UIN, RIJQQAppInterfaceUtil.d());
      ((JSONObject)localObject).put(ViolaEnvironment.COMMON_NET, Integer.toString(RIJNetworkUtils.d(BaseApplication.getContext())));
      ((JSONObject)localObject).put(ViolaEnvironment.COMMON_OPERATION_VERSION, DeviceInfoUtil.g());
      ((JSONObject)localObject).put(ViolaEnvironment.COMMON_QQ_VERSION, "8.8.17");
      ((JSONObject)localObject).put(ViolaEnvironment.COMMON_PHONE_TYPE, Build.MODEL);
      String str2 = ViolaEnvironment.COMMON_BIZ;
      if (TextUtils.isEmpty(str1))
      {
        str1 = paramString;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("&offlineVersion=");
        localStringBuilder.append(HtmlOffline.d(str1));
        str1 = localStringBuilder.toString();
      }
      ((JSONObject)localObject).put(str2, URLEncoder.encode(str1));
      ((JSONObject)localObject).put(ViolaEnvironment.COMMON_PLATFORM, "0");
      ((JSONObject)localObject).put(ViolaEnvironment.COMMON_OPEN_COUNT, Integer.toString(ViolaAccessHelper.a));
      if (!TextUtils.isEmpty(paramString)) {
        ((JSONObject)localObject).put(ViolaEnvironment.COMMON_PAGE_NAME, ViolaUtils.getPageName(paramString));
      }
      ((JSONObject)localObject).put(ViolaEnvironment.COMMON_RELEASE, "1");
      return localObject;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        str1 = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initCommonDataJson Exception:");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.e(str1, 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public void a()
  {
    ThreadManager.post(new ViolaReportDelegate.2(this), 8, null, true);
  }
  
  public void a(int paramInt, String paramString)
  {
    ThreadManager.post(new ViolaReportDelegate.1(this, paramString, paramInt), 8, null, true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.b.containsKey(paramString1)) && (paramString2.equals(this.b.get(paramString1)))) {
      this.b.remove(paramString1);
    }
  }
  
  public void addReportData(String paramString1, String paramString2)
  {
    if ((ViolaEnvironment.KEY_SO.equals(paramString1)) && (ViolaEnvironment.SO_START.equals(paramString2)))
    {
      if (this.b.size() >= 2)
      {
        this.b.clear();
        this.b.put(paramString1, paramString2);
        return;
      }
      this.b.put(paramString1, paramString2);
      return;
    }
    this.b.put(paramString1, paramString2);
  }
  
  public void dropFrameMonitor(int paramInt, String paramString) {}
  
  public HashMap<String, String> getBaseReportData(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString))
    {
      String str1 = Uri.parse(paramString).getQueryParameter("v_bid");
      String str2 = ViolaEnvironment.COMMON_BIZ;
      if (TextUtils.isEmpty(str1))
      {
        str1 = paramString;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("&offlineVersion=");
        localStringBuilder.append(HtmlOffline.d(str1));
        str1 = localStringBuilder.toString();
      }
      localHashMap.put(str2, URLEncoder.encode(str1));
      localHashMap.put(ViolaEnvironment.COMMON_PAGE_NAME, ViolaUtils.getPageName(paramString));
    }
    localHashMap.put(ViolaEnvironment.COMMON_UIN, RIJQQAppInterfaceUtil.d());
    localHashMap.put(ViolaEnvironment.COMMON_NET, Integer.toString(RIJNetworkUtils.d(BaseApplication.getContext())));
    localHashMap.put(ViolaEnvironment.COMMON_OPERATION_VERSION, DeviceInfoUtil.g());
    localHashMap.put(ViolaEnvironment.COMMON_QQ_VERSION, "8.8.17");
    localHashMap.put(ViolaEnvironment.COMMON_PHONE_TYPE, Build.MODEL);
    localHashMap.put(ViolaEnvironment.COMMON_PLATFORM, "0");
    localHashMap.put(ViolaEnvironment.COMMON_OPEN_COUNT, Integer.toString(ViolaAccessHelper.a));
    localHashMap.put(ViolaEnvironment.COMMON_RELEASE, "1");
    localHashMap.put(ViolaEnvironment.COMMON_APPLICATION, "1");
    return localHashMap;
  }
  
  public void reportData(String paramString)
  {
    if (!this.b.isEmpty())
    {
      if (!this.b.containsKey(ViolaEnvironment.COMMON_UIN)) {
        this.b.putAll(getBaseReportData(paramString));
      }
      paramString = ViolaUtils.copyMap(this.b);
      if (!paramString.isEmpty()) {
        RIJStatisticCollectorReport.a(ReadInJoyUtils.b(), true, paramString);
      }
      this.b.clear();
    }
  }
  
  public void reportHttpData(HashMap<String, String> paramHashMap, String paramString)
  {
    paramHashMap.putAll(getBaseReportData(paramString));
    RIJStatisticCollectorReport.b(ReadInJoyUtils.b(), true, paramHashMap);
  }
  
  public void reportJsError(boolean paramBoolean, int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("error_code", paramInt);
      localJSONObject.put("error_msg", paramString);
      localJSONObject.put("is_renderJs", paramBoolean);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    PublicAccountReportUtils.a(null, null, "0X800AC69", "0X800AC69", 0, 0, "", "", "", localJSONObject.toString(), false);
  }
  
  public void reportNVProcess(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString3 = a(paramString3);
      if (paramString3 != null)
      {
        paramString3.put(paramString1, paramString2);
        RIJStatisticCollectorReport.a(ReadInJoyUtils.b(), true, paramString3);
        return;
      }
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = a;
        paramString3 = new StringBuilder();
        paramString3.append("reportPageProcessNew Exception:");
        paramString3.append(paramString1.getMessage());
        QLog.e(paramString2, 2, paramString3.toString());
      }
    }
  }
  
  public void reportNativeVueError(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("error", paramString1);
      localJSONObject.put("url", paramString2);
    }
    catch (Exception paramString1)
    {
      paramString2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportNativeVueError: ");
      localStringBuilder.append(paramString1.getMessage());
      QLog.e(paramString2, 1, localStringBuilder.toString());
    }
    PublicAccountReportUtils.a(null, null, "0X800B08D", "0X800B08D", 0, 0, "", "", "", localJSONObject.toString(), false);
  }
  
  public void reportPageProcess(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString3 = a(paramString3);
      if (paramString3 != null)
      {
        paramString3.put(paramString1, paramString2);
        RIJStatisticCollectorReport.a(ReadInJoyUtils.b(), true, paramString3);
        a();
        return;
      }
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = a;
        paramString3 = new StringBuilder();
        paramString3.append("reportPageProcessNew Exception:");
        paramString3.append(paramString1.getMessage());
        QLog.e(paramString2, 2, paramString3.toString());
      }
    }
  }
  
  public void reportRunningData(HashMap<String, String> paramHashMap, String paramString)
  {
    paramHashMap.putAll(getBaseReportData(paramString));
    RIJStatisticCollectorReport.c(ReadInJoyUtils.b(), true, paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaReportDelegate
 * JD-Core Version:    0.7.0.1
 */
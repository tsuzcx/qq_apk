package com.tencent.mobileqq.mini.network;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.utils.IPV6OnlyUtils;
import com.tencent.mobileqq.mini.util.JSONObjectFix;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Map;
import org.json.JSONObject;

public class RequestStrategy
{
  static final String TAG = "MiniAppInterface";
  private static int forceIpv6Switch = -1;
  public static RequestStrategy g;
  private boolean mIPv6Only = false;
  
  static
  {
    if (g == null) {
      g = new RequestStrategy();
    }
  }
  
  private RequestStrategy()
  {
    updateIPv6Status();
  }
  
  private boolean checkEnable()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("qqminiapp", "ipv6_proxy_enable", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  private String getUrlPrefix(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("MiniAppInterface", 2, "getUrlPrefix fail ! originUrl is empty.");
      return "";
    }
    Object localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "ipv6_http_proxy_url", "https://proxy.gtimg.cn/tx_tls_gate=");
    String str = QzoneConfig.getInstance().getConfig("qqminiapp", "ipv6_websocket_proxy_url", "wss://proxy.gtimg.cn/tx_tls_gate=");
    if (paramString.startsWith("wss://")) {
      localObject = str;
    }
    return localObject;
  }
  
  private boolean isForceIpv6()
  {
    return false;
  }
  
  private void updateIPv6Status()
  {
    ThreadManagerV2.executeOnFileThread(new RequestStrategy.1(this));
  }
  
  public String addHttpForwardingInfo(String paramString, Map<String, String> paramMap)
  {
    boolean bool = isForceIpv6();
    if ((!bool) && (!checkEnable())) {
      return paramString;
    }
    if (!IPV6OnlyUtils.isUrlAllowedProxy(paramString)) {
      return paramString;
    }
    String str1;
    String str2;
    if (!this.mIPv6Only)
    {
      str1 = paramString;
      if (!bool) {}
    }
    else
    {
      str2 = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppIPv6OnlyForwardingReferer", "https://appservice.qq.com");
      str1 = paramString;
      if (!paramString.isEmpty()) {
        str1 = paramString;
      }
    }
    try
    {
      String str3 = getUrlPrefix(paramString);
      str1 = paramString;
      StringBuilder localStringBuilder = new StringBuilder();
      str1 = paramString;
      localStringBuilder.append(str3);
      str1 = paramString;
      localStringBuilder.append(paramString);
      str1 = paramString;
      paramString = localStringBuilder.toString();
      str1 = paramString;
      if (paramMap != null)
      {
        str1 = paramString;
        paramMap.put("Referer", str2);
        str1 = paramString;
      }
      return str1;
    }
    catch (Throwable paramString) {}
    return str1;
  }
  
  public boolean addHttpForwardingInfo(JSONObject paramJSONObject)
  {
    boolean bool = isForceIpv6();
    if ((!bool) && (!checkEnable())) {
      return false;
    }
    String str1;
    if ((this.mIPv6Only) || (bool))
    {
      str1 = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppIPv6OnlyForwardingReferer", "https://appservice.qq.com");
      if (!paramJSONObject.has("url")) {}
    }
    try
    {
      Object localObject = paramJSONObject.optString("url");
      if (!IPV6OnlyUtils.isUrlAllowedProxy((String)localObject)) {
        return false;
      }
      String str2 = getUrlPrefix((String)localObject);
      paramJSONObject.put("origin_url", localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append((String)localObject);
      paramJSONObject.put("url", localStringBuilder.toString());
      if (paramJSONObject.has("header")) {
        localObject = paramJSONObject.optJSONObject("header");
      } else {
        localObject = new JSONObjectFix();
      }
      ((JSONObject)localObject).put("Referer", str1);
      paramJSONObject.put("header", localObject);
      return true;
    }
    catch (Throwable paramJSONObject) {}
    return false;
    return false;
  }
  
  public boolean isIPv6Only()
  {
    return this.mIPv6Only;
  }
  
  public void notifyNetWorkStatusChange()
  {
    updateIPv6Status();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.RequestStrategy
 * JD-Core Version:    0.7.0.1
 */
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
  public static RequestStrategy g = null;
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
    return QzoneConfig.getInstance().getConfig("qqminiapp", "ipv6_proxy_enable", 0) == 1;
  }
  
  private String getUrlPrefix(String paramString)
  {
    String str1;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("MiniAppInterface", 2, "getUrlPrefix fail ! originUrl is empty.");
      str1 = "";
    }
    String str2;
    do
    {
      return str1;
      str2 = QzoneConfig.getInstance().getConfig("qqminiapp", "ipv6_http_proxy_url", "https://proxy.gtimg.cn/tx_tls_gate=");
      str1 = QzoneConfig.getInstance().getConfig("qqminiapp", "ipv6_websocket_proxy_url", "wss://proxy.gtimg.cn/tx_tls_gate=");
    } while (paramString.startsWith("wss://"));
    return str2;
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
    String str1;
    if ((!bool) && (!checkEnable())) {
      str1 = paramString;
    }
    for (;;)
    {
      return str1;
      str1 = paramString;
      if (IPV6OnlyUtils.isUrlAllowedProxy(paramString)) {
        if (!this.mIPv6Only)
        {
          str1 = paramString;
          if (!bool) {}
        }
        else
        {
          String str2 = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppIPv6OnlyForwardingReferer", "https://appservice.qq.com");
          str1 = paramString;
          if (!paramString.isEmpty())
          {
            str1 = paramString;
            try
            {
              String str3 = getUrlPrefix(paramString);
              str1 = paramString;
              paramString = str3 + paramString;
              str1 = paramString;
              if (paramMap != null)
              {
                str1 = paramString;
                paramMap.put("Referer", str2);
                return paramString;
              }
            }
            catch (Throwable paramString) {}
          }
        }
      }
    }
    return str1;
  }
  
  public boolean addHttpForwardingInfo(JSONObject paramJSONObject)
  {
    boolean bool = isForceIpv6();
    if ((!bool) && (!checkEnable())) {}
    for (;;)
    {
      return false;
      if ((!this.mIPv6Only) && (!bool)) {
        continue;
      }
      String str1 = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppIPv6OnlyForwardingReferer", "https://appservice.qq.com");
      if (!paramJSONObject.has("url")) {
        continue;
      }
      try
      {
        Object localObject = paramJSONObject.optString("url");
        if (!IPV6OnlyUtils.isUrlAllowedProxy((String)localObject)) {
          continue;
        }
        String str2 = getUrlPrefix((String)localObject);
        paramJSONObject.put("origin_url", localObject);
        paramJSONObject.put("url", str2 + (String)localObject);
        if (paramJSONObject.has("header")) {}
        for (localObject = paramJSONObject.optJSONObject("header");; localObject = new JSONObjectFix())
        {
          ((JSONObject)localObject).put("Referer", str1);
          paramJSONObject.put("header", localObject);
          return true;
        }
        return false;
      }
      catch (Throwable paramJSONObject) {}
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.RequestStrategy
 * JD-Core Version:    0.7.0.1
 */
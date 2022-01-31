package com.tencent.qapmsdk.dns;

import android.content.Context;
import com.tencent.qapmsdk.dns.logic.LocalDnsManager;
import com.tencent.qapmsdk.dns.network.NetworkReceiver;
import com.tencent.qapmsdk.dns.network.NetworkUtils;
import com.tencent.qapmsdk.dns.policy.IpPolicy;
import com.tencent.qapmsdk.dns.utils.HookUtils;
import com.tencent.qapmsdk.dns.utils.Utils;
import java.util.List;
import java.util.Map;

public class HttpDns
{
  private static final String TAG = "QAPM_HttpDns";
  
  public static void install(Context paramContext)
  {
    NetworkReceiver.register(paramContext);
    NetworkUtils.init(paramContext);
    setCallback(new HttpDns.1());
    HookUtils.hook();
  }
  
  public static void setCallback(HttpDns.Callback paramCallback)
  {
    Utils.setCallback(paramCallback);
  }
  
  public static void setIpPolicy(IpPolicy paramIpPolicy)
  {
    IpPolicy.setIpPolicy(paramIpPolicy);
  }
  
  public static void setLocalDns(Map<String, List<String>> paramMap)
  {
    LocalDnsManager.getInstance().setLocalDnsMap(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.HttpDns
 * JD-Core Version:    0.7.0.1
 */
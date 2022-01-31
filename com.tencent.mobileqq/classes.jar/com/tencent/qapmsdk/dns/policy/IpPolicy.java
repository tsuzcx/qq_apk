package com.tencent.qapmsdk.dns.policy;

import android.support.annotation.NonNull;
import java.util.List;

public abstract class IpPolicy
{
  public static final IpPolicy EMPTY = new IpPolicy.IpPolicyDefault(null);
  public static final IpPolicy PRIORITY = new IpPolicy.IpPolicyPriority(null);
  public static final IpPolicy RANDOM = new IpPolicy.IpPolicyRandom(null);
  private static final String TAG = "QAM_DNS_IpPolicy";
  private static IpPolicy sPolicy = RANDOM;
  
  @NonNull
  public static IpPolicy getPolicy()
  {
    return sPolicy;
  }
  
  public static void setIpPolicy(IpPolicy paramIpPolicy)
  {
    IpPolicy localIpPolicy = paramIpPolicy;
    if (paramIpPolicy == null) {
      localIpPolicy = EMPTY;
    }
    sPolicy = localIpPolicy;
  }
  
  public abstract List<String> sort(String paramString, List<String> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.policy.IpPolicy
 * JD-Core Version:    0.7.0.1
 */
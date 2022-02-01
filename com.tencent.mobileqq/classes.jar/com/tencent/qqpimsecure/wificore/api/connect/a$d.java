package com.tencent.qqpimsecure.wificore.api.connect;

import java.util.HashMap;
import java.util.Map;

public enum a$d
{
  static String[] dC = { "路由异常", "路由异常", "密码错误", "获取IP失败", "弱信号", "Portal鉴权失败", "其他" };
  static Map<String, d> dX;
  static Map<Integer, d> dY;
  int dD;
  
  static
  {
    dX = new HashMap();
    dX.put("IDLE", dQ);
    dX.put("CONNECTING", dR);
    dX.put("AUTHENTICATING", dS);
    dX.put("OBTAINING_IPADDR", dT);
    dX.put("VERIFYING_POOR_LINK", dU);
    dX.put("CAPTIVE_PORTAL_CHECK", dV);
    dY = new HashMap();
    dY.put(Integer.valueOf(0), dQ);
    dY.put(Integer.valueOf(2), dR);
    dY.put(Integer.valueOf(3), dS);
    dY.put(Integer.valueOf(4), dT);
    dY.put(Integer.valueOf(12), dU);
    dY.put(Integer.valueOf(11), dV);
  }
  
  private a$d(int paramInt)
  {
    this.dD = paramInt;
  }
  
  public static d l(int paramInt)
  {
    try
    {
      d[] arrayOfd = values();
      int j = arrayOfd.length;
      int i = 0;
      while (i < j)
      {
        d locald = arrayOfd[i];
        int k = locald.f();
        if (k == paramInt) {
          return locald;
        }
        i += 1;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public int f()
  {
    return this.dD;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(dC[ordinal()]);
    localStringBuilder.append(",");
    localStringBuilder.append(this.dD);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.connect.a.d
 * JD-Core Version:    0.7.0.1
 */
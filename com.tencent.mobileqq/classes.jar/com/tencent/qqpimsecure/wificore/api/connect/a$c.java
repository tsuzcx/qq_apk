package com.tencent.qqpimsecure.wificore.api.connect;

public enum a$c
{
  static String[] dC = { "停用WiFi_未知", "停用WiFi_DNS出错", "停用WiFi_DHCP出错", "停用WiFi_密码错误", "停用WiFi_连接被拒绝" };
  int dD;
  
  private a$c(int paramInt)
  {
    this.dD = paramInt;
  }
  
  public static c k(int paramInt)
  {
    try
    {
      c[] arrayOfc = values();
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        c localc = arrayOfc[i];
        int k = localc.f();
        if (k == paramInt) {
          return localc;
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
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.connect.a.c
 * JD-Core Version:    0.7.0.1
 */
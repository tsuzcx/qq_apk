package com.tencent.qqpimsecure.wificore.api.connect;

public enum a$a
{
  static String[] dC = { "系统连接其他WiFi事件导致的取消", "手动在手管点击连接其他WiFi导致的取消", "手动断开/忘记WiFi导致的取消", "检测发现当前WiFi发生改变导致的取消", "连接过程中关闭WiFi开关导致的取消", "刷新WiFi列表时发现WiFi消失导致的取消", "未知的取消（连接过程中收到了未知原因的事件）" };
  int dD;
  
  static
  {
    dA = new a("CANCEL_BY_REFRESH_AP_GONE", 5, 6);
    dB = new a("CANCEL_BY_UNKNOWN", 6, 10);
    dE = new a[] { dv, dw, dx, dy, dz, dA, dB };
  }
  
  private a$a(int paramInt)
  {
    this.dD = paramInt;
  }
  
  public static a j(int paramInt)
  {
    try
    {
      a[] arrayOfa = values();
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        int k = locala.f();
        if (k == paramInt) {
          return locala;
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
    return "[" + dC[ordinal()] + "," + this.dD + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.connect.a.a
 * JD-Core Version:    0.7.0.1
 */
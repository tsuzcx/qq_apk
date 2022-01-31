package com.tencent.qqpimsecure.wificore.api.connect;

public enum a$b
{
  static String[] dC = { "连接成功", "断开中止", "连接失败", "取消连接" };
  int dD;
  
  private a$b(int paramInt)
  {
    this.dD = paramInt;
  }
  
  public String toString()
  {
    return "[" + dC[ordinal()] + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.connect.a.b
 * JD-Core Version:    0.7.0.1
 */
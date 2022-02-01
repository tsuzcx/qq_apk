package com.tencent.mobileqq.filemanager.core;

public class FileIPv6StrateyController$IPInfo
{
  public String a;
  public int b = 0;
  
  public FileIPv6StrateyController$IPInfo(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public String a()
  {
    String str = this.a;
    if ((str != null) && (str.startsWith("[")) && (this.a.endsWith("]")))
    {
      str = this.a;
      return str.substring(1, str.length() - 1);
    }
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.a);
    localStringBuilder.append(":");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPInfo
 * JD-Core Version:    0.7.0.1
 */
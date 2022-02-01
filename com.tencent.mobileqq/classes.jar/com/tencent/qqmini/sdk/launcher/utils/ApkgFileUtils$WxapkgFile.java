package com.tencent.qqmini.sdk.launcher.utils;

public class ApkgFileUtils$WxapkgFile
{
  public int length;
  public String name;
  public int start;
  
  public ApkgFileUtils$WxapkgFile(String paramString, int paramInt1, int paramInt2)
  {
    this.name = paramString;
    this.start = paramInt1;
    this.length = paramInt2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WxapkgFile{name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", start=");
    localStringBuilder.append(this.start);
    localStringBuilder.append(", length=");
    localStringBuilder.append(this.length);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.ApkgFileUtils.WxapkgFile
 * JD-Core Version:    0.7.0.1
 */
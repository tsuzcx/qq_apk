package com.tencent.qqmini.sdk.core.manager;

class WxapkgUnpacker$WxapkgFile
{
  int length;
  String name;
  int start;
  
  public WxapkgUnpacker$WxapkgFile(String paramString, int paramInt1, int paramInt2)
  {
    this.name = paramString;
    this.start = paramInt1;
    this.length = paramInt2;
  }
  
  public String toString()
  {
    return "WxapkgFile{name='" + this.name + '\'' + ", start=" + this.start + ", length=" + this.length + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker.WxapkgFile
 * JD-Core Version:    0.7.0.1
 */
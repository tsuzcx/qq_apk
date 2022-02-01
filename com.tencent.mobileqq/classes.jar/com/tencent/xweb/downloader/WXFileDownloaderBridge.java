package com.tencent.xweb.downloader;

public class WXFileDownloaderBridge
  implements b
{
  private static a a;
  private c b = null;
  
  public int a(String paramString1, String paramString2, int paramInt)
  {
    a locala = a;
    if (locala != null) {
      return locala.a(paramString1, paramString2, paramInt, this);
    }
    return -1;
  }
  
  public void a(c paramc)
  {
    this.b = paramc;
  }
  
  public boolean a()
  {
    return a != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.downloader.WXFileDownloaderBridge
 * JD-Core Version:    0.7.0.1
 */
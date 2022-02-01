package com.tencent.sonic.sdk;

final class SonicUtils$1
  implements Runnable
{
  SonicUtils$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = SonicFileUtils.getSonicHtmlPath(this.val$sessionId) + ".tmp";
    SonicFileUtils.writeFile(this.val$htmlString, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicUtils.1
 * JD-Core Version:    0.7.0.1
 */
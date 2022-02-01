package com.tencent.sonic.sdk;

final class SonicUtils$1
  implements Runnable
{
  SonicUtils$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(SonicFileUtils.getSonicHtmlPath(this.val$sessionId));
    ((StringBuilder)localObject).append(".tmp");
    localObject = ((StringBuilder)localObject).toString();
    SonicFileUtils.writeFile(this.val$htmlString, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicUtils.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.mini.appbrand.utils;

import com.tencent.mobileqq.mini.http.MiniappHttpUtil;

final class MiniLogManager$7
  implements Runnable
{
  MiniLogManager$7(String paramString1, String paramString2) {}
  
  public void run()
  {
    MiniappHttpUtil.httpUpload("PUT", this.val$targetUrl, this.val$filePath, null, null, null, null, new MiniLogManager.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.7
 * JD-Core Version:    0.7.0.1
 */
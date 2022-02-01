package com.tencent.mobileqq.flashshow.utils.download;

import com.tencent.biz.richframework.download.RFWDownloadStrategy;

public class FSDownloadConfig
{
  private static FSDownloadStrategy a;
  
  public static RFWDownloadStrategy a()
  {
    if (a == null) {
      a = new FSDownloadStrategy();
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.download.FSDownloadConfig
 * JD-Core Version:    0.7.0.1
 */
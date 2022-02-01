package com.tencent.qcircle.cooperation.config.download;

import com.tencent.biz.richframework.download.RFWDownloadStrategy;

public class QCircleDownloadConfig
{
  private static QCircleDownloadStrategy a;
  
  public static RFWDownloadStrategy a()
  {
    if (a == null) {
      a = new QCircleDownloadStrategy();
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qcircle.cooperation.config.download.QCircleDownloadConfig
 * JD-Core Version:    0.7.0.1
 */
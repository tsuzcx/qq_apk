package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f.a;

class TbsLogReport$2
  implements f.a
{
  TbsLogReport$2(TbsLogReport paramTbsLogReport) {}
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[TbsApkDownloadStat.reportTbsLog] httpResponseCode=");
    localStringBuilder.append(paramInt);
    TbsLog.i("TbsDownload", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport.2
 * JD-Core Version:    0.7.0.1
 */
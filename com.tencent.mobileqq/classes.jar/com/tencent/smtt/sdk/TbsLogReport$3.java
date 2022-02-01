package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f.a;

class TbsLogReport$3
  implements f.a
{
  TbsLogReport$3(TbsLogReport paramTbsLogReport) {}
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:");
    localStringBuilder.append(paramInt);
    TbsLog.i("TbsDownload", localStringBuilder.toString());
    if (paramInt < 300) {
      TbsLogReport.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class ShortVideoUploadProcessor$3
  implements ITransCallbackForReport
{
  ShortVideoUploadProcessor$3(ShortVideoUploadProcessor paramShortVideoUploadProcessor) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    ShortVideoUploadProcessor localShortVideoUploadProcessor = this.this$0;
    String str2 = this.this$0.mFileName;
    if (this.this$0.mResid == null) {}
    for (String str1 = this.this$0.mUuid;; str1 = this.this$0.mResid)
    {
      localShortVideoUploadProcessor.reportForServerMonitor("actRichMediaNetMonitor_videoUp", false, paramInt, paramString1, paramString2, str2, str1, this.this$0.mReportBusiType + "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.3
 * JD-Core Version:    0.7.0.1
 */
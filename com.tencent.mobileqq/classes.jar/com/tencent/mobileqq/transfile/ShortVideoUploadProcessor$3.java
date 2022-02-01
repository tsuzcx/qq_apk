package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class ShortVideoUploadProcessor$3
  implements ITransCallbackForReport
{
  ShortVideoUploadProcessor$3(ShortVideoUploadProcessor paramShortVideoUploadProcessor) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    ShortVideoUploadProcessor localShortVideoUploadProcessor = this.this$0;
    String str2 = localShortVideoUploadProcessor.mFileName;
    String str1;
    if (this.this$0.mResid == null) {
      str1 = this.this$0.mUuid;
    } else {
      str1 = this.this$0.mResid;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.mReportBusiType);
    localStringBuilder.append("");
    localShortVideoUploadProcessor.reportForServerMonitor("actRichMediaNetMonitor_videoUp", false, paramInt, paramString1, paramString2, str2, str1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.3
 * JD-Core Version:    0.7.0.1
 */
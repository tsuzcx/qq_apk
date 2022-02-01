package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class C2CPttUploadProcessor$2
  implements ITransCallbackForReport
{
  C2CPttUploadProcessor$2(C2CPttUploadProcessor paramC2CPttUploadProcessor) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    C2CPttUploadProcessor localC2CPttUploadProcessor = this.this$0;
    String str2 = localC2CPttUploadProcessor.mMd5Str;
    String str1;
    if (this.this$0.mResid == null) {
      str1 = this.this$0.mUuid;
    } else {
      str1 = this.this$0.mResid;
    }
    localC2CPttUploadProcessor.reportForServerMonitor("actRichMediaNetMonitor_pttUp", false, paramInt, paramString1, paramString2, str2, str1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttUploadProcessor.2
 * JD-Core Version:    0.7.0.1
 */
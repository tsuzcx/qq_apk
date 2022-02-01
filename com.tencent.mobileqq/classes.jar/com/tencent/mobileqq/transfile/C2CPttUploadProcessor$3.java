package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class C2CPttUploadProcessor$3
  implements ITransCallbackForReport
{
  C2CPttUploadProcessor$3(C2CPttUploadProcessor paramC2CPttUploadProcessor) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    C2CPttUploadProcessor localC2CPttUploadProcessor = this.this$0;
    String str2 = this.this$0.mMd5Str;
    if (this.this$0.mResid == null) {}
    for (String str1 = this.this$0.mUuid;; str1 = this.this$0.mResid)
    {
      localC2CPttUploadProcessor.reportForServerMonitor("actRichMediaNetMonitor_pttUp", false, paramInt, paramString1, paramString2, str2, str1, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttUploadProcessor.3
 * JD-Core Version:    0.7.0.1
 */
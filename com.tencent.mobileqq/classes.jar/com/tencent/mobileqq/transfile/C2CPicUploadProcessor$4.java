package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class C2CPicUploadProcessor$4
  implements ITransCallbackForReport
{
  C2CPicUploadProcessor$4(C2CPicUploadProcessor paramC2CPicUploadProcessor) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    this.this$0.reportForServerMonitor(false, paramInt, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPicUploadProcessor.4
 * JD-Core Version:    0.7.0.1
 */
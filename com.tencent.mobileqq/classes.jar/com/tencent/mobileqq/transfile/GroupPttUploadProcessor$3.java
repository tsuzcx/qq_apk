package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class GroupPttUploadProcessor$3
  implements ITransCallbackForReport
{
  GroupPttUploadProcessor$3(GroupPttUploadProcessor paramGroupPttUploadProcessor) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    this.this$0.reportForServerMonitor("actRichMediaNetMonitor_pttUp", false, paramInt, paramString1, paramString2, this.this$0.mMd5Str, this.this$0.mUuid, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttUploadProcessor.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class GroupPttUploadProcessor$2
  implements ITransCallbackForReport
{
  GroupPttUploadProcessor$2(GroupPttUploadProcessor paramGroupPttUploadProcessor) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    GroupPttUploadProcessor localGroupPttUploadProcessor = this.this$0;
    localGroupPttUploadProcessor.reportForServerMonitor("actRichMediaNetMonitor_pttUp", false, paramInt, paramString1, paramString2, localGroupPttUploadProcessor.mMd5Str, this.this$0.mUuid, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttUploadProcessor.2
 * JD-Core Version:    0.7.0.1
 */
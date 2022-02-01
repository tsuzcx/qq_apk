package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class GuildPicUploadProcessor$2
  implements ITransCallbackForReport
{
  GuildPicUploadProcessor$2(GuildPicUploadProcessor paramGuildPicUploadProcessor) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    this.this$0.reportForServerMonitor(false, paramInt, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GuildPicUploadProcessor.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class ShortVideoForwardProcessor$3
  implements ITransCallbackForReport
{
  ShortVideoForwardProcessor$3(ShortVideoForwardProcessor paramShortVideoForwardProcessor) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    this.this$0.reportForServerMonitor(false, paramInt, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.3
 * JD-Core Version:    0.7.0.1
 */
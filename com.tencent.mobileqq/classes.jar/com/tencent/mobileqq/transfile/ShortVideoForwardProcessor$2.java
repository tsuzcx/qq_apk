package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import java.util.HashMap;

class ShortVideoForwardProcessor$2
  implements ITransactionCallback
{
  ShortVideoForwardProcessor$2(ShortVideoForwardProcessor paramShortVideoForwardProcessor, String paramString, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.this$0.doOnSendFailed(paramInt, paramHashMap, this.val$startTime);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.this$0.doOnSendSucess(paramArrayOfByte, paramHashMap, this.val$combinePath, this.val$startTime);
  }
  
  public void onSwitch2BackupChannel()
  {
    long l = SystemClock.uptimeMillis();
    this.this$0.log("<BDH_LOG> onSwitch2BackupChannel()");
    this.this$0.mProcessorReport.mReportInfo.put("param_switchChannel", String.valueOf(l - this.val$startTime));
  }
  
  public void onTransStart()
  {
    this.this$0.log("<BDH_LOG> onTransStart()");
    this.this$0.mProcessorReport.mStepTrans.startTime = 0L;
    this.this$0.mProcessorReport.mStepTrans.logStartTime();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    ShortVideoForwardProcessor localShortVideoForwardProcessor = this.this$0;
    FileMsg localFileMsg = localShortVideoForwardProcessor.file;
    long l = paramInt;
    localFileMsg.transferedSize = l;
    localShortVideoForwardProcessor.mTransferedSize = l;
    if ((l < this.this$0.mFileSize) && (!this.this$0.mIsCancel) && (!this.this$0.mIsPause))
    {
      this.this$0.sendProgressMessage();
      if (this.this$0.isStoryVideo)
      {
        localShortVideoForwardProcessor = this.this$0;
        localShortVideoForwardProcessor.updateVideoAndPicStatus(localShortVideoForwardProcessor.msg, 1002, this.this$0.getProgress());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import dov.com.qq.im.editipc.PeakIpcController;
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
    this.this$0.mReportInfo.put("param_switchChannel", String.valueOf(l - this.val$startTime));
  }
  
  public void onTransStart()
  {
    this.this$0.log("<BDH_LOG> onTransStart()");
    this.this$0.mStepTrans.startTime = 0L;
    this.this$0.mStepTrans.logStartTime();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    ShortVideoForwardProcessor localShortVideoForwardProcessor = this.this$0;
    FileMsg localFileMsg = this.this$0.file;
    long l = paramInt;
    localFileMsg.transferedSize = l;
    localShortVideoForwardProcessor.mTransferedSize = l;
    if ((paramInt < this.this$0.mFileSize) && (!this.this$0.mIsCancel) && (!this.this$0.mIsPause))
    {
      this.this$0.sendProgressMessage();
      if (this.this$0.isStoryVideo) {
        PeakIpcController.a(this.this$0.msg, 1002, this.this$0.getProgress());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.2
 * JD-Core Version:    0.7.0.1
 */
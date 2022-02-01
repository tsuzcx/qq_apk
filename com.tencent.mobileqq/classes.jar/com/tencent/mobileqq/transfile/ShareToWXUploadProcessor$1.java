package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ShareToWXUploadProcessor$1
  implements ITransactionCallback
{
  ShareToWXUploadProcessor$1(ShareToWXUploadProcessor paramShareToWXUploadProcessor, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("<BDH_LOG> Transaction End : Failed. New : SendTotalCost:");
      paramArrayOfByte.append(l - this.val$startTime);
      paramArrayOfByte.append("ms");
      QLog.d("ShareToWXUploadProcessor", 2, paramArrayOfByte.toString());
    }
    this.this$0.mProcessorReport.setError(paramInt, "OnFailed.", "", this.this$0.mProcessorReport.mStepTrans);
    this.this$0.onError();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("<BDH_LOG> Transaction End : Success. New : SendTotalCost:");
      paramHashMap.append(l - this.val$startTime);
      QLog.d("ShareToWXUploadProcessor", 2, paramHashMap.toString());
    }
    this.this$0.mProcessorReport.mStepTrans.logFinishTime();
    this.this$0.mProcessorReport.mStepTrans.result = 1;
    paramHashMap = this.this$0;
    paramHashMap.mTransferedSize = paramHashMap.mFileSize;
    this.this$0.file.bdhExtendInfo = paramArrayOfByte;
    this.this$0.onSuccess();
    this.this$0.file.closeInputStream();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.this$0.mProcessorReport.mStepTrans.logStartTime();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    ShareToWXUploadProcessor localShareToWXUploadProcessor = this.this$0;
    FileMsg localFileMsg = localShareToWXUploadProcessor.file;
    long l = paramInt;
    localFileMsg.transferedSize = l;
    localShareToWXUploadProcessor.mTransferedSize = l;
    if ((l < this.this$0.mFileSize) && (!this.this$0.mIsCancel) && (!this.this$0.mIsPause)) {
      this.this$0.sendProgressMessage();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShareToWXUploadProcessor.1
 * JD-Core Version:    0.7.0.1
 */
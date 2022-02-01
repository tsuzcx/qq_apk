package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

class PttSliceUploadProcessor$1
  implements ITransactionCallback
{
  PttSliceUploadProcessor$1(PttSliceUploadProcessor paramPttSliceUploadProcessor, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("<BDH_LOG> Transaction End : Failed. New : SendTotalCost:");
      paramHashMap.append(l - this.val$startTime);
      paramHashMap.append("ms retCode=");
      paramHashMap.append(paramInt);
      QLog.d("PttSliceUploadProcessor", 2, paramHashMap.toString());
    }
    if ((PttSliceUploadProcessor.access$000(this.this$0) != null) && (PttSliceUploadProcessor.access$000(this.this$0).filePath != null)) {
      new File(PttSliceUploadProcessor.access$000(this.this$0).filePath).delete();
    }
    this.this$0.sendMessageToUpdate(2005);
    this.this$0.file.bdhExtendInfo = paramArrayOfByte;
    this.this$0.mProcessorReport.setError(paramInt, "OnFailed.", "", this.this$0.mProcessorReport.mStepTrans);
    this.this$0.onError();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("onSuccess SendTotalCost:");
      paramHashMap.append(l - this.val$startTime);
      paramHashMap.append("ms");
      QLog.d("PttSliceUploadProcessor", 2, paramHashMap.toString());
    }
    if ((PttSliceUploadProcessor.access$000(this.this$0) != null) && (PttSliceUploadProcessor.access$000(this.this$0).filePath != null)) {
      new File(PttSliceUploadProcessor.access$000(this.this$0).filePath).delete();
    }
    PttSliceUploadProcessor.access$100(this.this$0, paramArrayOfByte);
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.this$0.mProcessorReport.mStepTrans.logStartTime();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateProgress transferedSize:");
      localStringBuilder.append(paramInt);
      QLog.d("PttSliceUploadProcessor", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PttSliceUploadProcessor.1
 * JD-Core Version:    0.7.0.1
 */
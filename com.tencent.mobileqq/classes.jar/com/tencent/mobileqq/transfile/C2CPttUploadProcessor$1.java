package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class C2CPttUploadProcessor$1
  implements ITransactionCallback
{
  C2CPttUploadProcessor$1(C2CPttUploadProcessor paramC2CPttUploadProcessor, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("<BDH_LOG> Transaction End : Failed. New : SendTotalCost:");
      paramArrayOfByte.append(l - this.val$startTime);
      paramArrayOfByte.append("ms");
      QLog.d("C2CPicUploadProcessor", 2, paramArrayOfByte.toString());
    }
    this.this$0.addBDHReportInfo(paramHashMap);
    this.this$0.onError();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.this$0.doOnSendSuc(paramArrayOfByte, paramHashMap, this.val$startTime);
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
    C2CPttUploadProcessor localC2CPttUploadProcessor = this.this$0;
    FileMsg localFileMsg = localC2CPttUploadProcessor.file;
    long l = paramInt;
    localFileMsg.transferedSize = l;
    localC2CPttUploadProcessor.mTransferedSize = l;
    if ((l < this.this$0.mFileSize) && (!this.this$0.mIsCancel) && (!this.this$0.mIsPause)) {
      this.this$0.sendProgressMessage();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttUploadProcessor.1
 * JD-Core Version:    0.7.0.1
 */
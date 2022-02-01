package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcController;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class C2CPicUploadProcessor$3
  implements ITransactionCallback
{
  C2CPicUploadProcessor$3(C2CPicUploadProcessor paramC2CPicUploadProcessor, long paramLong) {}
  
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
    paramArrayOfByte = this.this$0;
    paramArrayOfByte.setError(paramInt, "OnFailed.", "", paramArrayOfByte.mProcessorReport.mStepTrans);
    this.this$0.onError();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<BDH_LOG> Transaction End : Success. New : SendTotalCost:");
      ((StringBuilder)localObject).append(l - this.val$startTime);
      ((StringBuilder)localObject).append("ms ,fileSize:");
      ((StringBuilder)localObject).append(this.this$0.file.fileSize);
      ((StringBuilder)localObject).append(" transInfo:");
      ((StringBuilder)localObject).append((String)paramHashMap.get("rep_bdhTrans"));
      QLog.d("C2CPicUploadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    this.this$0.addBDHReportInfo(paramHashMap);
    this.this$0.mProcessorReport.mStepTrans.logFinishTime();
    this.this$0.mProcessorReport.mStepTrans.result = 1;
    C2CPicUploadProcessor.access$400(this.this$0).logFinishTime();
    C2CPicUploadProcessor.access$400(this.this$0).result = 1;
    Object localObject = this.this$0;
    ((C2CPicUploadProcessor)localObject).mTransferedSize = ((C2CPicUploadProcessor)localObject).mFileSize;
    localObject = this.this$0;
    ((C2CPicUploadProcessor)localObject).uploadSuccess = true;
    if (((C2CPicUploadProcessor)localObject).mIsOpenUpEnable) {
      C2CPicUploadProcessor.access$500(this.this$0, paramArrayOfByte);
    }
    this.this$0.sendMsg();
    this.this$0.file.closeInputStream();
    paramArrayOfByte = (String)paramHashMap.get("ip");
    paramHashMap = (String)paramHashMap.get("port");
    this.this$0.reportForServerMonitor(true, 0, paramArrayOfByte, paramHashMap);
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
    C2CPicUploadProcessor localC2CPicUploadProcessor = this.this$0;
    FileMsg localFileMsg = localC2CPicUploadProcessor.file;
    long l = paramInt;
    localFileMsg.transferedSize = l;
    localC2CPicUploadProcessor.mTransferedSize = l;
    if ((l < this.this$0.mFileSize) && (!this.this$0.mIsCancel) && (!this.this$0.mIsPause))
    {
      if ((this.this$0.mIsOpenUpEnable) && (paramInt >= C2CPicUploadProcessor.access$000(this.this$0) * 8192))
      {
        C2CPicUploadProcessor.access$100(this.this$0).logFinishTime();
        C2CPicUploadProcessor.access$100(this.this$0).result = 1;
      }
      this.this$0.sendProgressMessage();
      if (C2CPicUploadProcessor.access$200(this.this$0)) {
        ((IPeakIpcController)QRoute.api(IPeakIpcController.class)).updatePeakVideoAndPicStatus(C2CPicUploadProcessor.access$300(this.this$0), 1002, this.this$0.getProgress());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPicUploadProcessor.3
 * JD-Core Version:    0.7.0.1
 */
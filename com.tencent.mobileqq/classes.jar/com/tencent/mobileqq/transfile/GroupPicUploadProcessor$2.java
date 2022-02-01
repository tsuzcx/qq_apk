package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcController;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class GroupPicUploadProcessor$2
  implements ITransactionCallback
{
  GroupPicUploadProcessor$2(GroupPicUploadProcessor paramGroupPicUploadProcessor) {}
  
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
      paramArrayOfByte.append(l - this.this$0.startTime);
      paramArrayOfByte.append("ms");
      QLog.d("GroupPicUploadProcessor", 2, paramArrayOfByte.toString());
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
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("<BDH_LOG> Transaction End : Success. New : SendTotalCost:");
      paramArrayOfByte.append(l - this.this$0.startTime);
      paramArrayOfByte.append("ms ,fileSize:");
      paramArrayOfByte.append(this.this$0.file.fileSize);
      paramArrayOfByte.append(" transInfo:");
      paramArrayOfByte.append((String)paramHashMap.get("rep_bdhTrans"));
      QLog.d("GroupPicUploadProcessor", 2, paramArrayOfByte.toString());
    }
    this.this$0.addBDHReportInfo(paramHashMap);
    this.this$0.mProcessorReport.mStepTrans.logFinishTime();
    this.this$0.mProcessorReport.mStepTrans.result = 1;
    paramArrayOfByte = this.this$0;
    paramArrayOfByte.mTransferedSize = paramArrayOfByte.mFileSize;
    paramArrayOfByte = this.this$0;
    paramArrayOfByte.uploadSuccess = true;
    paramArrayOfByte.sendMsg();
    this.this$0.file.closeInputStream();
    paramArrayOfByte = (String)paramHashMap.get("ip");
    paramHashMap = (String)paramHashMap.get("port");
    this.this$0.reportForServerMonitor(true, 0, paramArrayOfByte, paramHashMap);
  }
  
  public void onSwitch2BackupChannel()
  {
    long l = SystemClock.uptimeMillis();
    this.this$0.log("<BDH_LOG> onSwitch2BackupChannel() switch to HTTP channel");
    this.this$0.mProcessorReport.mReportInfo.put("param_switchChannel", String.valueOf(l - this.this$0.startTime));
  }
  
  public void onTransStart()
  {
    this.this$0.mProcessorReport.mStepTrans.logStartTime();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    GroupPicUploadProcessor localGroupPicUploadProcessor = this.this$0;
    FileMsg localFileMsg = localGroupPicUploadProcessor.file;
    long l = paramInt;
    localFileMsg.transferedSize = l;
    localGroupPicUploadProcessor.mTransferedSize = l;
    if ((l < this.this$0.mFileSize) && (!this.this$0.mIsCancel) && (!this.this$0.mIsPause))
    {
      this.this$0.sendProgressMessage();
      if (this.this$0.isStoryPhoto) {
        ((IPeakIpcController)QRoute.api(IPeakIpcController.class)).updatePeakVideoAndPicStatus(this.this$0.picMsg, 1002, this.this$0.getProgress());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPicUploadProcessor.2
 * JD-Core Version:    0.7.0.1
 */
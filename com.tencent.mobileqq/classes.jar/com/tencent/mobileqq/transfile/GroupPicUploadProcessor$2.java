package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.editipc.PeakIpcController;
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
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - GroupPicUploadProcessor.access$200(this.this$0)) + "ms");
    }
    this.this$0.addBDHReportInfo(paramHashMap);
    this.this$0.setError(paramInt, "OnFailed.", "", this.this$0.mStepTrans);
    this.this$0.onError();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - GroupPicUploadProcessor.access$200(this.this$0)) + "ms ,fileSize:" + this.this$0.file.fileSize + " transInfo:" + (String)paramHashMap.get("rep_bdhTrans"));
    }
    this.this$0.addBDHReportInfo(paramHashMap);
    this.this$0.mStepTrans.logFinishTime();
    this.this$0.mStepTrans.result = 1;
    this.this$0.mTransferedSize = this.this$0.mFileSize;
    this.this$0.uploadSuccess = true;
    this.this$0.sendMsg();
    this.this$0.file.closeInputStream();
    paramArrayOfByte = (String)paramHashMap.get("ip");
    paramHashMap = (String)paramHashMap.get("port");
    this.this$0.reportForServerMonitor(true, 0, paramArrayOfByte, paramHashMap);
  }
  
  public void onSwitch2BackupChannel()
  {
    long l = SystemClock.uptimeMillis();
    this.this$0.log("<BDH_LOG> onSwitch2BackupChannel() switch to HTTP channel");
    this.this$0.mReportInfo.put("param_switchChannel", String.valueOf(l - GroupPicUploadProcessor.access$200(this.this$0)));
  }
  
  public void onTransStart()
  {
    this.this$0.mStepTrans.logStartTime();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    GroupPicUploadProcessor localGroupPicUploadProcessor = this.this$0;
    FileMsg localFileMsg = this.this$0.file;
    long l = paramInt;
    localFileMsg.transferedSize = l;
    localGroupPicUploadProcessor.mTransferedSize = l;
    if ((paramInt < this.this$0.mFileSize) && (!this.this$0.mIsCancel) && (!this.this$0.mIsPause))
    {
      this.this$0.sendProgressMessage();
      if (GroupPicUploadProcessor.access$000(this.this$0)) {
        PeakIpcController.a(GroupPicUploadProcessor.access$100(this.this$0), 1002, this.this$0.getProgress());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPicUploadProcessor.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class GroupPttUploadProcessor$1
  implements ITransactionCallback
{
  GroupPttUploadProcessor$1(GroupPttUploadProcessor paramGroupPttUploadProcessor, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("GroupPttUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.val$startTime) + "ms");
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
    GroupPttUploadProcessor localGroupPttUploadProcessor = this.this$0;
    FileMsg localFileMsg = this.this$0.file;
    long l = paramInt;
    localFileMsg.transferedSize = l;
    localGroupPttUploadProcessor.mTransferedSize = l;
    if ((paramInt < this.this$0.mFileSize) && (!this.this$0.mIsCancel) && (!this.this$0.mIsPause)) {
      this.this$0.sendProgressMessage();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttUploadProcessor.1
 * JD-Core Version:    0.7.0.1
 */
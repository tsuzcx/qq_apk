package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class NearbyPeoplePhotoUploadProcessor$1
  implements ITransactionCallback
{
  NearbyPeoplePhotoUploadProcessor$1(NearbyPeoplePhotoUploadProcessor paramNearbyPeoplePhotoUploadProcessor, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<BDH_LOG> Transaction End : Failed. New : SendTotalCost:");
      localStringBuilder.append(l - this.val$startTime);
      localStringBuilder.append("ms");
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, localStringBuilder.toString());
    }
    this.this$0.mProcessorReport.mReportInfo.put("X-piccachetime", paramArrayOfByte);
    this.this$0.mProcessorReport.mReportInfo.put("param_BdhTrans", str1);
    this.this$0.mProcessorReport.mReportInfo.put("param_segspercnt", str2);
    this.this$0.mProcessorReport.mReportInfo.put("param_conf_segSize", str3);
    this.this$0.mProcessorReport.mReportInfo.put("param_conf_segNum", str4);
    this.this$0.mProcessorReport.mReportInfo.put("param_conf_connNum", paramHashMap);
    this.this$0.mProcessorReport.setError(paramInt, "OnFailed.", "", this.this$0.mProcessorReport.mStepTrans);
    this.this$0.onError();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    String str1 = (String)paramHashMap.get("tc_p:");
    String str2 = (String)paramHashMap.get("rep_bdhTrans");
    String str3 = (String)paramHashMap.get("segspercnt");
    String str4 = (String)paramHashMap.get("param_conf_segSize");
    String str5 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<BDH_LOG> Transaction End : Success. New : SendTotalCost:");
      localStringBuilder.append(l - this.val$startTime);
      localStringBuilder.append("ms ,fileSize:");
      localStringBuilder.append(this.this$0.file.fileSize);
      localStringBuilder.append(" transInfo:");
      localStringBuilder.append(str2);
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, localStringBuilder.toString());
    }
    this.this$0.mProcessorReport.mReportInfo.put("X-piccachetime", str1);
    this.this$0.mProcessorReport.mReportInfo.put("param_BdhTrans", str2);
    this.this$0.mProcessorReport.mReportInfo.put("param_segspercnt", str3);
    this.this$0.mProcessorReport.mReportInfo.put("param_conf_segSize", str4);
    this.this$0.mProcessorReport.mReportInfo.put("param_conf_segNum", str5);
    this.this$0.mProcessorReport.mReportInfo.put("param_conf_connNum", paramHashMap);
    this.this$0.mProcessorReport.mStepTrans.logFinishTime();
    this.this$0.mProcessorReport.mStepTrans.result = 1;
    paramHashMap = this.this$0;
    paramHashMap.mTransferedSize = paramHashMap.mFileSize;
    if ((this.this$0.file.fileType != 50) && (this.this$0.file.fileType != 51))
    {
      if ((this.this$0.file.fileType != 23) && (this.this$0.file.fileType != 67) && (this.this$0.file.fileType != 68))
      {
        if (this.this$0.file.fileType == 22) {
          NearbyPeoplePhotoUploadProcessor.access$200(this.this$0, paramArrayOfByte);
        } else if (this.this$0.file.fileType == 48) {
          NearbyPeoplePhotoUploadProcessor.access$300(this.this$0, paramArrayOfByte);
        } else if (this.this$0.file.fileType == 35) {
          NearbyPeoplePhotoUploadProcessor.access$400(this.this$0, paramArrayOfByte);
        } else {
          NearbyPeoplePhotoUploadProcessor.access$500(this.this$0, paramArrayOfByte);
        }
      }
      else {
        NearbyPeoplePhotoUploadProcessor.access$100(this.this$0, paramArrayOfByte);
      }
    }
    else {
      NearbyPeoplePhotoUploadProcessor.access$000(this.this$0, paramArrayOfByte);
    }
    this.this$0.file.closeInputStream();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    this.this$0.log("<BDH_LOG> onTransStart()");
    this.this$0.mProcessorReport.mStepTrans.logStartTime();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    NearbyPeoplePhotoUploadProcessor localNearbyPeoplePhotoUploadProcessor = this.this$0;
    FileMsg localFileMsg = localNearbyPeoplePhotoUploadProcessor.file;
    long l = paramInt;
    localFileMsg.transferedSize = l;
    localNearbyPeoplePhotoUploadProcessor.mTransferedSize = l;
    if ((l <= this.this$0.mFileSize) && (!this.this$0.mIsCancel) && (!this.this$0.mIsPause)) {
      this.this$0.sendProgressMessage();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor.1
 * JD-Core Version:    0.7.0.1
 */
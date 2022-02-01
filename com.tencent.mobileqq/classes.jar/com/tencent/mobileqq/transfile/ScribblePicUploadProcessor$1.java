package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ScribblePicUploadProcessor$1
  implements ITransactionCallback
{
  ScribblePicUploadProcessor$1(ScribblePicUploadProcessor paramScribblePicUploadProcessor, long paramLong) {}
  
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
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.val$startTime) + "ms");
    }
    this.this$0.mReportInfo.put("X-piccachetime", paramArrayOfByte);
    this.this$0.mReportInfo.put("param_BdhTrans", str1);
    this.this$0.mReportInfo.put("param_segspercnt", str2);
    this.this$0.mReportInfo.put("param_conf_segSize", str3);
    this.this$0.mReportInfo.put("param_conf_segNum", str4);
    this.this$0.mReportInfo.put("param_conf_connNum", paramHashMap);
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
    String str1 = (String)paramHashMap.get("tc_p:");
    String str2 = (String)paramHashMap.get("rep_bdhTrans");
    String str3 = (String)paramHashMap.get("segspercnt");
    String str4 = (String)paramHashMap.get("param_conf_segSize");
    String str5 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.val$startTime) + "ms ,fileSize:" + this.this$0.file.fileSize + " transInfo:" + str2);
    }
    this.this$0.mReportInfo.put("X-piccachetime", str1);
    this.this$0.mReportInfo.put("param_BdhTrans", str2);
    this.this$0.mReportInfo.put("param_segspercnt", str3);
    this.this$0.mReportInfo.put("param_conf_segSize", str4);
    this.this$0.mReportInfo.put("param_conf_segNum", str5);
    this.this$0.mReportInfo.put("param_conf_connNum", paramHashMap);
    this.this$0.mStepTrans.logFinishTime();
    this.this$0.mStepTrans.result = 1;
    this.this$0.mTransferedSize = this.this$0.mFileSize;
    paramHashMap = new Bdh_extinfo.UploadPicExtInfo();
    try
    {
      paramHashMap.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
      ScribblePicUploadProcessor.access$002(this.this$0, paramHashMap.bytes_download_url.get().toStringUtf8());
      if (ScribblePicUploadProcessor.access$000(this.this$0) == null)
      {
        this.this$0.setError(-1, "URL IS NULL", "", this.this$0.mStepTrans);
        this.this$0.onError();
        this.this$0.file.closeInputStream();
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        continue;
        ScribblePicUploadProcessor.access$100(this.this$0);
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    this.this$0.log("<BDH_LOG> onTransStart()");
    this.this$0.mStepTrans.logStartTime();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    ScribblePicUploadProcessor localScribblePicUploadProcessor = this.this$0;
    FileMsg localFileMsg = this.this$0.file;
    long l = paramInt;
    localFileMsg.transferedSize = l;
    localScribblePicUploadProcessor.mTransferedSize = l;
    if ((paramInt <= this.this$0.mFileSize) && (!this.this$0.mIsCancel) && (!this.this$0.mIsPause)) {
      this.this$0.sendProgressMessage();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ScribblePicUploadProcessor.1
 * JD-Core Version:    0.7.0.1
 */
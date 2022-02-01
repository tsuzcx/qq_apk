package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

class PtvGuideUploader$1
  implements ITransactionCallback
{
  PtvGuideUploader$1(PtvGuideUploader paramPtvGuideUploader, String paramString) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    String str5 = (String)paramHashMap.get("param_conf_connNum");
    String str6 = (String)paramHashMap.get("param_fin_lost");
    if (QLog.isColorLevel()) {
      QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - PtvGuideUploader.access$300(this.this$0)) + "ms");
    }
    PtvGuideUploader.access$400(this.this$0).put("serverip", paramHashMap.get("ip"));
    PtvGuideUploader.access$400(this.this$0).put("param_bdhSrv", paramHashMap.get("ip"));
    PtvGuideUploader.access$400(this.this$0).put("param_bdhPort", paramHashMap.get("port"));
    PtvGuideUploader.access$400(this.this$0).put("X-piccachetime", paramArrayOfByte);
    PtvGuideUploader.access$400(this.this$0).put("param_BdhTrans", str1);
    PtvGuideUploader.access$400(this.this$0).put("param_segspercnt", str2);
    PtvGuideUploader.access$400(this.this$0).put("param_conf_segSize", str3);
    PtvGuideUploader.access$400(this.this$0).put("param_conf_segNum", str4);
    PtvGuideUploader.access$400(this.this$0).put("param_conf_connNum", str5);
    PtvGuideUploader.access$400(this.this$0).put("param_fin_lost", str6);
    PtvGuideUploader.access$400(this.this$0).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    PtvGuideUploader.access$400(this.this$0).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    PtvGuideUploader.access$400(this.this$0).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    PtvGuideUploader.access$400(this.this$0).put("param_retry_code", paramHashMap.get("param_retry_code"));
    PtvGuideUploader.access$400(this.this$0).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    PtvGuideUploader.access$400(this.this$0).put("param_ip_index", paramHashMap.get("param_ip_index"));
    PtvGuideUploader.access$400(this.this$0).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      PtvGuideUploader.access$602(this.this$0, true);
    }
    PtvGuideUploader.access$802(this.this$0, paramInt);
    PtvGuideUploader.access$902(this.this$0, "sessionKey or sigSession is null");
    PtvGuideUploader.access$100(this.this$0).onFailed(paramInt, PtvGuideUploader.access$900(this.this$0));
    PtvGuideUploader.access$700(this.this$0, false);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    try
    {
      paramArrayOfByte = (PttShortVideo.PttShortVideoUploadResp)new PttShortVideo.PttShortVideoUploadResp().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte.str_fileid.has())
      {
        paramArrayOfByte = paramArrayOfByte.str_fileid.get();
        if (paramArrayOfByte.length() > 0)
        {
          PtvGuideUploader.access$002(this.this$0, paramArrayOfByte);
          PtvGuideUploader.access$100(this.this$0).onSuccess(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("PtvGuideUploader", 2, "set uuid from BDH ");
          }
        }
      }
      PtvGuideUploader.access$202(this.this$0, (String)paramHashMap.get("rep_bdhTrans"));
      paramArrayOfByte = (String)paramHashMap.get("segspercnt");
      String str1 = (String)paramHashMap.get("param_conf_segSize");
      String str2 = (String)paramHashMap.get("param_conf_segNum");
      String str3 = (String)paramHashMap.get("param_conf_connNum");
      String str4 = (String)paramHashMap.get("param_fin_lost");
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - PtvGuideUploader.access$300(this.this$0)) + "ms transInfo:" + PtvGuideUploader.access$200(this.this$0));
      }
      PtvGuideUploader.access$400(this.this$0).put("serverip", paramHashMap.get("ip"));
      PtvGuideUploader.access$400(this.this$0).put("param_bdhSrv", paramHashMap.get("ip"));
      PtvGuideUploader.access$400(this.this$0).put("param_bdhPort", paramHashMap.get("port"));
      PtvGuideUploader.access$400(this.this$0).put("X-piccachetime", String.valueOf(PtvGuideUploader.access$500(this.this$0).mTransReport.timeCost_Cache));
      PtvGuideUploader.access$400(this.this$0).put("param_BdhTrans", PtvGuideUploader.access$200(this.this$0));
      PtvGuideUploader.access$400(this.this$0).put("param_segspercnt", paramArrayOfByte);
      PtvGuideUploader.access$400(this.this$0).put("param_conf_segSize", str1);
      PtvGuideUploader.access$400(this.this$0).put("param_conf_segNum", str2);
      PtvGuideUploader.access$400(this.this$0).put("param_conf_connNum", str3);
      PtvGuideUploader.access$400(this.this$0).put("param_fin_lost", str4);
      PtvGuideUploader.access$400(this.this$0).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
      PtvGuideUploader.access$400(this.this$0).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
      PtvGuideUploader.access$400(this.this$0).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
      PtvGuideUploader.access$400(this.this$0).put("param_retry_code", paramHashMap.get("param_retry_code"));
      PtvGuideUploader.access$400(this.this$0).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
      PtvGuideUploader.access$400(this.this$0).put("param_ip_index", paramHashMap.get("param_ip_index"));
      PtvGuideUploader.access$400(this.this$0).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
        PtvGuideUploader.access$602(this.this$0, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      FileUtils.deleteFile(this.val$combinePath);
      PtvGuideUploader.access$700(this.this$0, true);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("PtvGuideUploader", 2, "get uuid from BDH error", paramArrayOfByte);
        }
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvGuideUploader", 2, "<BDH_LOG> onTransStart()");
    }
  }
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PtvGuideUploader.1
 * JD-Core Version:    0.7.0.1
 */
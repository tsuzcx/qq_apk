package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;
import tencent.im.qim.trans.QIMVideoUpload.QIMVideoUpload.ErrorInfo;
import tencent.im.qim.trans.QIMVideoUpload.QIMVideoUpload.RspBody;

class QIMWebVideoUploaderFirstFrame$1
  implements ITransactionCallback
{
  QIMWebVideoUploaderFirstFrame$1(QIMWebVideoUploaderFirstFrame paramQIMWebVideoUploaderFirstFrame) {}
  
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
      QLog.d("QIMWebVideoUploaderFirstFrame", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - QIMWebVideoUploaderFirstFrame.access$200(this.this$0)) + "ms");
    }
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("serverip", paramHashMap.get("ip"));
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_bdhSrv", paramHashMap.get("ip"));
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_bdhPort", paramHashMap.get("port"));
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("X-piccachetime", paramArrayOfByte);
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_BdhTrans", str1);
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_segspercnt", str2);
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_conf_segSize", str3);
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_conf_segNum", str4);
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_conf_connNum", str5);
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_fin_lost", str6);
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_retry_code", paramHashMap.get("param_retry_code"));
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_ip_index", paramHashMap.get("param_ip_index"));
    QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      QIMWebVideoUploaderFirstFrame.access$502(this.this$0, true);
    }
    QIMWebVideoUploaderFirstFrame.access$602(this.this$0, paramInt);
    QIMWebVideoUploaderFirstFrame.access$702(this.this$0, "sessionKey or sigSession is null");
    QIMWebVideoUploaderFirstFrame.access$000(this.this$0).onPicUploadFailed(paramInt, QIMWebVideoUploaderFirstFrame.access$700(this.this$0));
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l3 = SystemClock.uptimeMillis();
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    int i = paramArrayOfByte.get();
    if (QLog.isColorLevel()) {
      QLog.d("QIMWebVideoUploaderFirstFrame", 2, "Callback.onSuccess,ret=" + i);
    }
    int j;
    Object localObject;
    if (i == 0)
    {
      j = 0x0 | paramArrayOfByte.get() | (paramArrayOfByte.get() & 0xFF) << 8 | (paramArrayOfByte.get() & 0xFF) << 16 | (paramArrayOfByte.get() & 0xFF) << 24;
      localObject = new byte[j];
      paramArrayOfByte.get((byte[])localObject);
      if (QLog.isColorLevel()) {
        QLog.d("QIMWebVideoUploaderFirstFrame", 2, "TransactionCallback|data= " + HexUtil.bytes2HexStr((byte[])localObject) + ",len=" + j);
      }
    }
    for (;;)
    {
      try
      {
        localObject = (QIMVideoUpload.RspBody)new QIMVideoUpload.RspBody().mergeFrom((byte[])localObject);
        if (!((QIMVideoUpload.RspBody)localObject).uint64_uin.has()) {
          continue;
        }
        l1 = ((QIMVideoUpload.RspBody)localObject).uint64_uin.get();
        if (!((QIMVideoUpload.RspBody)localObject).uint64_service_type.has()) {
          continue;
        }
        l2 = ((QIMVideoUpload.RspBody)localObject).uint64_service_type.get();
        if (!((QIMVideoUpload.RspBody)localObject).str_uuid.has()) {
          continue;
        }
        paramArrayOfByte = ((QIMVideoUpload.RspBody)localObject).str_uuid.get();
        if (QLog.isColorLevel()) {
          QLog.d("QIMWebVideoUploaderFirstFrame", 2, "TransactionCallback|uin=" + l1 + ",type=" + l2 + ",uuid= " + paramArrayOfByte);
        }
        paramArrayOfByte = (QIMVideoUpload.ErrorInfo)((QIMVideoUpload.RspBody)localObject).msg_err.get();
        if (paramArrayOfByte != null)
        {
          l1 = paramArrayOfByte.uint64_err_code.get();
          paramArrayOfByte = paramArrayOfByte.bytes_err_info.get().toStringUtf8();
          if (QLog.isColorLevel()) {
            QLog.d("QIMWebVideoUploaderFirstFrame", 2, "TransactionCallback|errorCode= " + l1 + ",errorInfo=" + paramArrayOfByte);
          }
        }
        QIMWebVideoUploaderFirstFrame.access$000(this.this$0).onPicUploadSuccess();
        if (QLog.isColorLevel()) {
          QLog.d("QIMWebVideoUploaderFirstFrame", 2, "set uuid from BDH ");
        }
      }
      catch (Exception paramArrayOfByte)
      {
        long l1;
        long l2;
        String str1;
        String str2;
        String str3;
        QIMWebVideoUploaderFirstFrame.access$000(this.this$0).onPicUploadFailed(i, "mergeFrom respData Exception");
        paramArrayOfByte.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QIMWebVideoUploaderFirstFrame", 2, "get uuid from BDH Exception", paramArrayOfByte);
        continue;
      }
      QIMWebVideoUploaderFirstFrame.access$102(this.this$0, (String)paramHashMap.get("rep_bdhTrans"));
      paramArrayOfByte = (String)paramHashMap.get("segspercnt");
      localObject = (String)paramHashMap.get("param_conf_segSize");
      str1 = (String)paramHashMap.get("param_conf_segNum");
      str2 = (String)paramHashMap.get("param_conf_connNum");
      str3 = (String)paramHashMap.get("param_fin_lost");
      if (QLog.isColorLevel()) {
        QLog.d("QIMWebVideoUploaderFirstFrame", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l3 - QIMWebVideoUploaderFirstFrame.access$200(this.this$0)) + "ms transInfo:" + QIMWebVideoUploaderFirstFrame.access$100(this.this$0));
      }
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("serverip", paramHashMap.get("ip"));
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_bdhSrv", paramHashMap.get("ip"));
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_bdhPort", paramHashMap.get("port"));
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("X-piccachetime", String.valueOf(QIMWebVideoUploaderFirstFrame.access$400(this.this$0).mTransReport.timeCost_Cache));
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_BdhTrans", QIMWebVideoUploaderFirstFrame.access$100(this.this$0));
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_segspercnt", paramArrayOfByte);
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_conf_segSize", localObject);
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_conf_segNum", str1);
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_conf_connNum", str2);
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_fin_lost", str3);
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_retry_code", paramHashMap.get("param_retry_code"));
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_ip_index", paramHashMap.get("param_ip_index"));
      QIMWebVideoUploaderFirstFrame.access$300(this.this$0).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
        QIMWebVideoUploaderFirstFrame.access$502(this.this$0, true);
      }
      return;
      l1 = 0L;
      continue;
      l2 = 0L;
      continue;
      paramArrayOfByte = null;
      continue;
      i = 0x0 | paramArrayOfByte.get() | (paramArrayOfByte.get() & 0xFF) << 8 | (paramArrayOfByte.get() & 0xFF) << 16 | (paramArrayOfByte.get() & 0xFF) << 24;
      j = paramArrayOfByte.getShort();
      localObject = new byte[j];
      paramArrayOfByte.get((byte[])localObject);
      paramArrayOfByte = new String((byte[])localObject);
      if (QLog.isColorLevel()) {
        QLog.d("QIMWebVideoUploaderFirstFrame", 2, "dwErrNo= " + i + ",len=" + j + ",errMsg=" + paramArrayOfByte);
      }
      QIMWebVideoUploaderFirstFrame.access$000(this.this$0).onPicUploadFailed(i, paramArrayOfByte);
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMWebVideoUploaderFirstFrame", 2, "<BDH_LOG> onTransStart()");
    }
  }
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.QIMWebVideoUploaderFirstFrame.1
 * JD-Core Version:    0.7.0.1
 */
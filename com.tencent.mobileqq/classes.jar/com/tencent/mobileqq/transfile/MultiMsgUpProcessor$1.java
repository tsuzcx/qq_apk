package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import tencent.im.longconn.multimsg.UpFileRspExtInfo;

class MultiMsgUpProcessor$1
  implements ITransactionCallback
{
  MultiMsgUpProcessor$1(MultiMsgUpProcessor paramMultiMsgUpProcessor) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("BDH.Upload fail  : result:");
      paramArrayOfByte.append(paramInt);
      QLog.i("MultiMsg_TAG", 2, paramArrayOfByte.toString());
    }
    this.this$0.onError();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiMsg_TAG", 2, "Multimsg upload file by BDH and onSuccess  ");
    }
    paramHashMap = new UpFileRspExtInfo();
    try
    {
      paramHashMap.mergeFrom(paramArrayOfByte);
      MultiMsgUpProcessor.access$002(this.this$0, paramHashMap.bytes_msg_res_id.get().toByteArray());
      if (QLog.isDevelopLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("Multimsg upload file by BDH and onSuccess  ");
        paramArrayOfByte.append(new String(MultiMsgUpProcessor.access$000(this.this$0), "utf-8"));
        QLog.i("MultiMsg_TAG_opt", 2, paramArrayOfByte.toString());
      }
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        paramHashMap = new StringBuilder();
        paramHashMap.append("Multimsg upload file by BDH and onSuccess but exception + ");
        paramHashMap.append(paramArrayOfByte);
        QLog.i("MultiMsg_TAG_opt", 2, paramHashMap.toString());
      }
      paramArrayOfByte.printStackTrace();
    }
    paramArrayOfByte = new File(AbsDownloader.getFilePath(MultiMsgUpProcessor.access$100(this.this$0)));
    if (paramArrayOfByte.exists()) {
      paramArrayOfByte.delete();
    }
    this.this$0.onSuccess();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.MultiMsgUpProcessor.1
 * JD-Core Version:    0.7.0.1
 */
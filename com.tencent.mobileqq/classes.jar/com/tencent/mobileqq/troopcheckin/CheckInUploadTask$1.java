package com.tencent.mobileqq.troopcheckin;

import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class CheckInUploadTask$1
  implements ITransactionCallback
{
  CheckInUploadTask$1(CheckInUploadTask paramCheckInUploadTask) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = this.a.b;
      paramHashMap = new StringBuilder();
      paramHashMap.append("upload onFailed errn:");
      paramHashMap.append(paramInt);
      QLog.d(paramArrayOfByte, 2, paramHashMap.toString());
    }
    this.a.e();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "upload onSuccess");
    }
    paramHashMap = new Bdh_extinfo.CommFileExtRsp();
    try
    {
      paramHashMap.mergeFrom(paramArrayOfByte);
      this.a.d = paramHashMap.bytes_download_url.get().toStringUtf8();
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    paramArrayOfByte = this.a;
    paramArrayOfByte.e = true;
    paramArrayOfByte.b();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopcheckin.CheckInUploadTask.1
 * JD-Core Version:    0.7.0.1
 */
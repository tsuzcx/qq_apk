package com.tencent.mobileqq.troopcheckin;

import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

class CheckInUploadVideoTask$1
  implements ITransactionCallback
{
  CheckInUploadVideoTask$1(CheckInUploadVideoTask paramCheckInUploadVideoTask) {}
  
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
    paramHashMap = new PttShortVideo.PttShortVideoUploadResp();
    try
    {
      paramArrayOfByte = (PttShortVideo.PttShortVideoUploadResp)paramHashMap.mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte.str_fileid.has()) {
        this.a.h = paramArrayOfByte.str_fileid.get();
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    paramArrayOfByte = this.a;
    paramArrayOfByte.i = true;
    paramArrayOfByte.b();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopcheckin.CheckInUploadVideoTask.1
 * JD-Core Version:    0.7.0.1
 */
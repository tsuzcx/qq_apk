package com.tencent.mobileqq.nearby.business;

import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.protocol.CsTask.Callback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.nearby.nearby_ice_break.IceRsp;

class NearbyCardHandler$4
  implements CsTask.Callback
{
  NearbyCardHandler$4(NearbyCardHandler paramNearbyCardHandler) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new nearby_ice_break.IceRsp();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if (paramBundle.result.has())
      {
        if (paramBundle.result.get() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("NearbyCardHandler", 2, "sendPoBingMsg. success");
          }
        }
        else
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("sendPoBingMsg. result=");
          paramArrayOfByte.append(paramBundle.result.get());
          paramArrayOfByte.append(" errorMsg=");
          paramArrayOfByte.append(paramBundle.err_msg.get());
          QLog.e("NearbyCardHandler", 1, paramArrayOfByte.toString());
        }
      }
      else
      {
        QLog.e("NearbyCardHandler", 1, "sendPoBingMsg. no result");
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("sendPoBingMsg. error=");
      paramBundle.append(QLog.getStackTraceString(paramArrayOfByte));
      QLog.e("NearbyCardHandler", 1, paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.business.NearbyCardHandler.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.studymode.proto.KidModePassword.VerifyPasswdRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

class KidModeServlet$VerifyPasswordHandler
  implements KidModeServlet.ResponseHandler
{
  static KidModeObserver.VerifyPasswordResult decodeVerifyPassword(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      Object localObject = new KidModePassword.VerifyPasswdRsp();
      try
      {
        ((KidModePassword.VerifyPasswdRsp)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = new KidModeObserver.VerifyPasswordResult();
        if (((KidModePassword.VerifyPasswdRsp)localObject).err_code.get() != 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodeVerifyPassword fail, err=");
          localStringBuilder.append(((KidModePassword.VerifyPasswdRsp)localObject).err_code.get());
          localStringBuilder.append(", ");
          localStringBuilder.append(((KidModePassword.VerifyPasswdRsp)localObject).err_msg.get());
          QLog.w("KidModeServlet", 1, localStringBuilder.toString());
          paramArrayOfByte.errCode = ((KidModePassword.VerifyPasswdRsp)localObject).err_code.get();
          paramArrayOfByte.errMessage = ((KidModePassword.VerifyPasswdRsp)localObject).err_msg.get();
          return paramArrayOfByte;
        }
        paramArrayOfByte.token = ((KidModePassword.VerifyPasswdRsp)localObject).signature.get();
        return paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decodeVerifyPassword fail, ");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.e("KidModeServlet", 1, ((StringBuilder)localObject).toString());
        return null;
      }
    }
    QLog.w("KidModeServlet", 1, "decodeVerifyPassword fail, data is null");
    return null;
  }
  
  public void handle(KidModeServlet paramKidModeServlet, Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    paramBundle.putSerializable("NOTIFY_RESULT_OBJECT", decodeVerifyPassword(KidModeServlet.a(paramFromServiceMsg)));
    paramKidModeServlet.notifyObserver(paramIntent, 10, true, paramBundle, KidModeObserver.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeServlet.VerifyPasswordHandler
 * JD-Core Version:    0.7.0.1
 */
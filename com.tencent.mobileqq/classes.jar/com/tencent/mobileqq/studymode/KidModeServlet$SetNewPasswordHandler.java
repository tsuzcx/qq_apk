package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.studymode.proto.KidModePassword.SetPasswdRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

class KidModeServlet$SetNewPasswordHandler
  implements KidModeServlet.ResponseHandler
{
  static KidModeObserver.SetNewPasswordResult decodeSetNewPassword(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      Object localObject = new KidModePassword.SetPasswdRsp();
      try
      {
        ((KidModePassword.SetPasswdRsp)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = new KidModeObserver.SetNewPasswordResult();
        if (((KidModePassword.SetPasswdRsp)localObject).err_code.get() != 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodeSetNewPassword fail, err=");
          localStringBuilder.append(((KidModePassword.SetPasswdRsp)localObject).err_code.get());
          localStringBuilder.append(", ");
          localStringBuilder.append(((KidModePassword.SetPasswdRsp)localObject).err_msg.get());
          QLog.w("KidModeServlet", 1, localStringBuilder.toString());
          paramArrayOfByte.errCode = ((KidModePassword.SetPasswdRsp)localObject).err_code.get();
          paramArrayOfByte.errMessage = ((KidModePassword.SetPasswdRsp)localObject).err_msg.get();
          return paramArrayOfByte;
        }
        paramArrayOfByte.token = ((KidModePassword.SetPasswdRsp)localObject).signature.get();
        return paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decodeSetNewPassword fail, ");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.e("KidModeServlet", 1, ((StringBuilder)localObject).toString());
        return null;
      }
    }
    QLog.e("KidModeServlet", 1, "decodeSetNewPassword fail, data is empty");
    return null;
  }
  
  public void handle(KidModeServlet paramKidModeServlet, Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    paramFromServiceMsg = decodeSetNewPassword(KidModeServlet.a(paramFromServiceMsg));
    paramBundle.putSerializable("NOTIFY_RESULT_OBJECT", paramFromServiceMsg);
    boolean bool;
    if (paramFromServiceMsg != null) {
      bool = true;
    } else {
      bool = false;
    }
    paramKidModeServlet.notifyObserver(paramIntent, 9, bool, paramBundle, KidModeObserver.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeServlet.SetNewPasswordHandler
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.studymode.proto.KidModePassword.ClearPasswdRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

class KidModeServlet$ClearPasswordHandler
  implements KidModeServlet.ResponseHandler
{
  static KidModeObserver.ClearPasswordResult decodeClearPassword(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      Object localObject = new KidModePassword.ClearPasswdRsp();
      try
      {
        ((KidModePassword.ClearPasswdRsp)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = new KidModeObserver.ClearPasswordResult();
        if (((KidModePassword.ClearPasswdRsp)localObject).err_code.get() != 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodeClearPassword, err=");
          localStringBuilder.append(((KidModePassword.ClearPasswdRsp)localObject).err_code.get());
          localStringBuilder.append(", ");
          localStringBuilder.append(((KidModePassword.ClearPasswdRsp)localObject).err_msg.get());
          QLog.i("KidModeServlet", 1, localStringBuilder.toString());
          paramArrayOfByte.errCode = ((KidModePassword.ClearPasswdRsp)localObject).err_code.get();
          paramArrayOfByte.errMessage = ((KidModePassword.ClearPasswdRsp)localObject).err_msg.get();
        }
        return paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decodeClearPassword, ");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.w("KidModeServlet", 1, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public void handle(KidModeServlet paramKidModeServlet, Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    paramFromServiceMsg = decodeClearPassword(KidModeServlet.a(paramFromServiceMsg));
    paramBundle.putSerializable("NOTIFY_RESULT_OBJECT", paramFromServiceMsg);
    if ((paramIntent != null) && (paramFromServiceMsg.errCode == 0)) {
      StudyModeManager.b(3);
    }
    paramKidModeServlet.notifyObserver(paramIntent, 11, true, paramBundle, KidModeObserver.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeServlet.ClearPasswordHandler
 * JD-Core Version:    0.7.0.1
 */
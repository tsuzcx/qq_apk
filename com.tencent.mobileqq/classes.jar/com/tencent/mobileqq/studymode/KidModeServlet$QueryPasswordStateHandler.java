package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.studymode.proto.KidModePassword.QueryPasswdStateRsp;
import com.tencent.mobileqq.studymode.proto.KidModePassword.SHA256Rounds2Params;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

class KidModeServlet$QueryPasswordStateHandler
  implements KidModeServlet.ResponseHandler
{
  static KidModeObserver.QueryPasswordStateResult decodeQueryPasswordState(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      Object localObject = new KidModePassword.QueryPasswdStateRsp();
      try
      {
        ((KidModePassword.QueryPasswdStateRsp)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = new KidModeObserver.QueryPasswordStateResult();
        if (((KidModePassword.QueryPasswdStateRsp)localObject).err_code.get() != 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodeQueryPasswordState, server return error, err=");
          localStringBuilder.append(((KidModePassword.QueryPasswdStateRsp)localObject).err_code.get());
          localStringBuilder.append(" ,");
          localStringBuilder.append(((KidModePassword.QueryPasswdStateRsp)localObject).err_msg.get());
          QLog.w("KidModeServlet", 1, localStringBuilder.toString());
          paramArrayOfByte.errCode = ((KidModePassword.QueryPasswdStateRsp)localObject).err_code.get();
          paramArrayOfByte.errMessage = ((KidModePassword.QueryPasswdStateRsp)localObject).err_msg.get();
          return paramArrayOfByte;
        }
        paramArrayOfByte.passwordState = ((KidModePassword.QueryPasswdStateRsp)localObject).state.get();
        paramArrayOfByte.salt = ((KidModePassword.QueryPasswdStateRsp)localObject).sha256_rounds2_params.salt.get();
        return paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decodeQueryPasswordState fail, ");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.e("KidModeServlet", 1, ((StringBuilder)localObject).toString());
        return null;
      }
    }
    QLog.w("KidModeServlet", 1, "decodeQueryPasswordState fail, data is null");
    return null;
  }
  
  public void handle(KidModeServlet paramKidModeServlet, Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    paramBundle.putSerializable("NOTIFY_RESULT_OBJECT", decodeQueryPasswordState(KidModeServlet.a(paramFromServiceMsg)));
    paramKidModeServlet.notifyObserver(paramIntent, 8, true, paramBundle, KidModeObserver.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeServlet.QueryPasswordStateHandler
 * JD-Core Version:    0.7.0.1
 */
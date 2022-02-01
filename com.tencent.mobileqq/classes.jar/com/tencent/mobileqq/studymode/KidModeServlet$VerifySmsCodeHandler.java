package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0x87c.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class KidModeServlet$VerifySmsCodeHandler
  implements KidModeServlet.ResponseHandler
{
  public void handle(KidModeServlet paramKidModeServlet, Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        Object localObject = KidModeServlet.b(paramFromServiceMsg);
        if ((paramFromServiceMsg.isSuccess()) && (localObject != null))
        {
          int i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
          if (i == 0)
          {
            try
            {
              paramFromServiceMsg = new oidb_0x87c.RspBody();
              paramFromServiceMsg.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
              localObject = paramFromServiceMsg.bytes_key.get().toByteArray();
              i = paramFromServiceMsg.uint32_key_type.get();
              paramBundle.putByteArray("SMS_TOKEN", (byte[])localObject);
              paramBundle.putInt("SMS_TOKEN_TYPE", i);
              bool1 = true;
            }
            catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
            {
              bool1 = true;
              continue;
            }
          }
          else
          {
            QLog.d("KidModeServlet", 1, new Object[] { "respVerifySmsCode fail, pkg result: ", Integer.valueOf(i) });
            bool1 = bool3;
            break label219;
          }
        }
        else
        {
          boolean bool4 = paramFromServiceMsg.isSuccess();
          if (localObject != null) {
            break label232;
          }
          bool1 = true;
          QLog.d("KidModeServlet", 1, new Object[] { "respVerifySmsCode fail, response isSuccess: ", Boolean.valueOf(bool4), "pkg isNull: ", Boolean.valueOf(bool1) });
          bool1 = bool3;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        bool1 = bool2;
        QLog.e("KidModeServlet", 1, "respVerifySmsCode get a error: ", paramFromServiceMsg);
      }
      label219:
      paramKidModeServlet.notifyObserver(paramIntent, 5, bool1, paramBundle, KidModeObserver.class);
      return;
      label232:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeServlet.VerifySmsCodeHandler
 * JD-Core Version:    0.7.0.1
 */
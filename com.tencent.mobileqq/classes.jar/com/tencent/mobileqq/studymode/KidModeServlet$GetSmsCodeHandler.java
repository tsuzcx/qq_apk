package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class KidModeServlet$GetSmsCodeHandler
  implements KidModeServlet.ResponseHandler
{
  public void handle(KidModeServlet paramKidModeServlet, Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = KidModeServlet.b(paramFromServiceMsg);
        if ((paramFromServiceMsg.isSuccess()) && (localOIDBSSOPkg != null))
        {
          int i = localOIDBSSOPkg.uint32_result.get();
          paramBundle.putInt("REQ_RESULT", i);
          paramFromServiceMsg = new oidb_0x87a.RspBody();
          paramFromServiceMsg.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
          paramBundle.putInt("RESENT_INTERVAL_TIMEOUT", paramFromServiceMsg.uint32_resend_interval.get());
          if (i == 0)
          {
            bool1 = true;
          }
          else
          {
            if (localOIDBSSOPkg.str_error_msg.has()) {
              paramBundle.putString("REQ_RESULT_MSG", localOIDBSSOPkg.str_error_msg.get());
            }
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("KidModeServlet", 1, new Object[] { "respGetSmsCode fail, result: ", Integer.valueOf(i) });
              bool1 = bool2;
            }
          }
        }
        else
        {
          boolean bool3 = paramFromServiceMsg.isSuccess();
          if (localOIDBSSOPkg != null) {
            break label241;
          }
          bool1 = true;
          QLog.d("KidModeServlet", 1, new Object[] { "respVerifySmsCode fail, response isSuccess: ", Boolean.valueOf(bool3), "pkg isNull: ", Boolean.valueOf(bool1) });
          bool1 = bool2;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        QLog.e("KidModeServlet", 1, "respGetSmsCode get a error: ", paramFromServiceMsg);
        bool1 = false;
      }
      paramKidModeServlet.notifyObserver(paramIntent, 4, bool1, paramBundle, KidModeObserver.class);
      return;
      label241:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeServlet.GetSmsCodeHandler
 * JD-Core Version:    0.7.0.1
 */
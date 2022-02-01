package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xed2.oidb_0xed2.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class KidModeServlet$SendSmsTokenHandler
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
          if (i == 0)
          {
            paramFromServiceMsg = new oidb_0xed2.RspBody();
            paramFromServiceMsg.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
            i = paramFromServiceMsg.uint32_result.get();
            if (i == 0)
            {
              bool1 = true;
            }
            else
            {
              QLog.d("KidModeServlet", 1, new Object[] { "respSendSmsToken fail, uint32_result result: ", Integer.valueOf(i) });
              bool1 = bool2;
            }
          }
          else
          {
            QLog.d("KidModeServlet", 1, new Object[] { "respSendSmsToken fail, pkg header result: ", Integer.valueOf(i) });
            bool1 = bool2;
          }
        }
        else
        {
          boolean bool3 = paramFromServiceMsg.isSuccess();
          if (localOIDBSSOPkg != null) {
            break label226;
          }
          bool1 = true;
          QLog.d("KidModeServlet", 1, new Object[] { "respSendSmsToken fail, response isSuccess: ", Boolean.valueOf(bool3), "pkg isNull: ", Boolean.valueOf(bool1) });
          bool1 = bool2;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        QLog.e("KidModeServlet", 1, "respVerifySmsCode get a error: ", paramFromServiceMsg);
        bool1 = false;
      }
      paramKidModeServlet.notifyObserver(paramIntent, 2, bool1, paramBundle, KidModeObserver.class);
      return;
      label226:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeServlet.SendSmsTokenHandler
 * JD-Core Version:    0.7.0.1
 */
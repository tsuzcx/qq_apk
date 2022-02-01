package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class KidModeServlet$GetPhoneVerifyStatusHandler
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
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = KidModeServlet.b(paramFromServiceMsg);
        boolean bool4;
        if ((paramFromServiceMsg.isSuccess()) && (localOIDBSSOPkg != null))
        {
          int i = ((oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.get()).uint32_result.get();
          if (i == 0)
          {
            paramFromServiceMsg = new oidb_0x5eb.RspBody();
            paramFromServiceMsg.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
            bool4 = paramFromServiceMsg.rpt_msg_uin_data.has();
            bool1 = bool3;
            if (!bool4) {
              break label237;
            }
            try
            {
              i = ((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0)).uint32_flag_kid_mode_need_phone_verify.get();
              paramBundle.putInt("KID_MODE_NEED_VERIFY", i);
              StudyModeManager.a(i);
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
            QLog.d("KidModeServlet", 1, new Object[] { "respGetKidModeStatus fail, result: ", Integer.valueOf(i) });
            bool1 = bool3;
            break label237;
          }
        }
        else
        {
          bool4 = paramFromServiceMsg.isSuccess();
          if (localOIDBSSOPkg != null) {
            break label251;
          }
          bool1 = true;
          QLog.d("KidModeServlet", 1, new Object[] { "respGetKidModeStatus fail, response isSuccess: ", Boolean.valueOf(bool4), "pkg isNull: ", Boolean.valueOf(bool1) });
          bool1 = bool3;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        bool1 = bool2;
        QLog.e("KidModeServlet", 1, "respGetKidModeStatus get a error: ", paramFromServiceMsg);
      }
      label237:
      paramKidModeServlet.notifyObserver(paramIntent, 6, bool1, paramBundle, KidModeObserver.class);
      return;
      label251:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeServlet.GetPhoneVerifyStatusHandler
 * JD-Core Version:    0.7.0.1
 */
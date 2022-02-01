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

class KidModeServlet$GetKidModeStatusHandler
  implements KidModeServlet.ResponseHandler
{
  public void handle(KidModeServlet paramKidModeServlet, Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = KidModeServlet.b(paramFromServiceMsg);
        if ((paramFromServiceMsg.isSuccess()) && (localOIDBSSOPkg != null))
        {
          int i = ((oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.get()).uint32_result.get();
          if (i == 0)
          {
            paramFromServiceMsg = new oidb_0x5eb.RspBody();
            paramFromServiceMsg.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
            bool1 = paramFromServiceMsg.rpt_msg_uin_data.has();
            if (bool1)
            {
              try
              {
                paramFromServiceMsg = (oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0);
                i = paramFromServiceMsg.uint32_flag_study_mode_switch.get();
                int j = paramFromServiceMsg.uint32_flag_kid_mode_switch.get();
                int k = paramFromServiceMsg.uint32_flag_kid_mode_need_phone_verify.get();
                int m = paramFromServiceMsg.uint32_flag_kid_mode_can_search_friends.get();
                int n = paramFromServiceMsg.uint32_flag_kid_mode_can_pull_group.get();
                int i1 = paramFromServiceMsg.uint32_flag_kid_mode_can_search_by_strangers.get();
                paramBundle.putInt("SIMPLE_MODE_SWITCH", i);
                paramBundle.putInt("KID_MODE_SWITCH", j);
                paramBundle.putInt("KID_MODE_NEED_VERIFY", k);
                paramBundle.putInt("KID_MODE_PULL_GROUP", n);
                paramBundle.putInt("KID_MODE_SEARCH_FRIENDS", m);
                paramBundle.putInt("KID_MODE_SEARCH_BY_STRANGERS", i1);
                if (i1 != 0) {
                  break label411;
                }
                bool1 = true;
                StudyModeManager.a(16, bool1);
                if (m != 0) {
                  break label417;
                }
                bool1 = true;
                StudyModeManager.a(8, bool1);
                bool1 = bool2;
                if (n == 0) {
                  bool1 = true;
                }
                StudyModeManager.a(32, bool1);
                StudyModeManager.a(k);
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
              QLog.d("KidModeServlet", 1, "respGetKidModeStatus fail, udc is null");
              bool1 = bool4;
              break label398;
            }
          }
          else
          {
            QLog.d("KidModeServlet", 1, new Object[] { "respGetKidModeStatus fail, result: ", Integer.valueOf(i) });
            bool1 = bool4;
            break label398;
          }
        }
        else
        {
          bool2 = paramFromServiceMsg.isSuccess();
          if (localOIDBSSOPkg != null) {
            break label423;
          }
          bool1 = true;
          QLog.d("KidModeServlet", 1, new Object[] { "respGetKidModeStatus fail, response isSuccess: ", Boolean.valueOf(bool2), "pkg isNull: ", Boolean.valueOf(bool1) });
          bool1 = bool4;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        bool1 = bool3;
        QLog.e("KidModeServlet", 1, "respGetKidModeStatus get a error: ", paramFromServiceMsg);
      }
      label398:
      paramKidModeServlet.notifyObserver(paramIntent, 3, bool1, paramBundle, KidModeObserver.class);
      return;
      label411:
      boolean bool1 = false;
      continue;
      label417:
      bool1 = false;
      continue;
      label423:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeServlet.GetKidModeStatusHandler
 * JD-Core Version:    0.7.0.1
 */
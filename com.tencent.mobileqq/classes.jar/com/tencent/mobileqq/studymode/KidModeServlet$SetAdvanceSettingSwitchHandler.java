package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class KidModeServlet$SetAdvanceSettingSwitchHandler
  implements KidModeServlet.ResponseHandler
{
  public void handle(KidModeServlet paramKidModeServlet, Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    boolean bool3 = paramFromServiceMsg.isSuccess();
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3)
    {
      paramFromServiceMsg = KidModeServlet.b(paramFromServiceMsg);
      if (paramFromServiceMsg != null)
      {
        int i = paramFromServiceMsg.uint32_result.get();
        if (i == 0)
        {
          i = paramBundle.getInt("advance_setting_field");
          int j = paramBundle.getInt("advance_setting_value");
          if ((i == 8) || (i == 16) || (i == 32))
          {
            if (j == 0) {
              bool1 = true;
            }
            StudyModeManager.a(i, bool1);
          }
          bool1 = true;
        }
        else
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("respSendSetKidMode, oidb result: ");
          paramFromServiceMsg.append(i);
          QLog.d("KidModeServlet", 1, paramFromServiceMsg.toString());
          bool1 = bool2;
        }
      }
      else
      {
        QLog.d("KidModeServlet", 1, "ssoPkg == null");
        bool1 = bool2;
      }
    }
    else
    {
      QLog.d("KidModeServlet", 1, "respSendSetKidMode fail");
      bool1 = false;
    }
    paramKidModeServlet.notifyObserver(paramIntent, 1, bool1, paramBundle, KidModeObserver.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeServlet.SetAdvanceSettingSwitchHandler
 * JD-Core Version:    0.7.0.1
 */
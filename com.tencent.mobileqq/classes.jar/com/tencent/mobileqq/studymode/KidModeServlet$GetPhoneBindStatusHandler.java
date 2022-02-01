package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8.PhoneInfo;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class KidModeServlet$GetPhoneBindStatusHandler
  implements KidModeServlet.ResponseHandler
{
  public void handle(KidModeServlet paramKidModeServlet, Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    int i = 0;
    for (;;)
    {
      Object localObject4;
      try
      {
        Object localObject3 = KidModeServlet.b(paramFromServiceMsg);
        bool1 = bool3;
        Object localObject1 = paramBundle;
        if (localObject3 == null) {
          break label594;
        }
        bool1 = bool3;
        localObject1 = paramBundle;
        if (!paramFromServiceMsg.isSuccess()) {
          break label594;
        }
        bool1 = bool3;
        localObject1 = paramBundle;
        if (((oidb_sso.OIDBSSOPkg)localObject3).uint32_result.get() != 0) {
          break label594;
        }
        bool1 = bool3;
        localObject1 = paramBundle;
        if (!((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.has()) {
          break label594;
        }
        localObject4 = new oidb_0xeb8.RspBody();
        ((oidb_0xeb8.RspBody)localObject4).mergeFrom(((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.get().toByteArray());
        int j = ((oidb_0xeb8.RspBody)localObject4).uint32_check_result.get();
        bool1 = bool3;
        localObject1 = paramBundle;
        if (j <= 0) {
          break label594;
        }
        try
        {
          paramFromServiceMsg = new Bundle();
          try
          {
            if (((oidb_0xeb8.RspBody)localObject4).str_mibao_change_url.has()) {
              paramFromServiceMsg.putString("mibao_change_url", ((oidb_0xeb8.RspBody)localObject4).str_mibao_change_url.get());
            }
            if (((oidb_0xeb8.RspBody)localObject4).str_mibao_set_url.has()) {
              paramFromServiceMsg.putString("mibao_set_url", ((oidb_0xeb8.RspBody)localObject4).str_mibao_set_url.get());
            }
            if (((oidb_0xeb8.RspBody)localObject4).str_mibao_verify_url.has()) {
              paramFromServiceMsg.putString("mibao_verify_url", ((oidb_0xeb8.RspBody)localObject4).str_mibao_verify_url.get());
            }
            if (((oidb_0xeb8.RspBody)localObject4).rpt_phone_info.has())
            {
              paramBundle = ((oidb_0xeb8.RspBody)localObject4).rpt_phone_info.get();
              localObject1 = new Bundle[paramBundle.size()];
              if (i < paramBundle.size())
              {
                localObject3 = (oidb_0xeb8.PhoneInfo)paramBundle.get(i);
                if (localObject3 == null) {
                  break label615;
                }
                localObject4 = new Bundle();
                j = -1;
                if (((oidb_0xeb8.PhoneInfo)localObject3).uint32_phone_type.has())
                {
                  ((Bundle)localObject4).putInt("phone_type", ((oidb_0xeb8.PhoneInfo)localObject3).uint32_phone_type.get());
                  j = ((oidb_0xeb8.PhoneInfo)localObject3).uint32_phone_type.get();
                }
                if (((oidb_0xeb8.PhoneInfo)localObject3).str_country_code.has())
                {
                  ((Bundle)localObject4).putString("country_code", ((oidb_0xeb8.PhoneInfo)localObject3).str_country_code.get());
                  if (j == 1) {
                    paramFromServiceMsg.putString("country_code", ((oidb_0xeb8.PhoneInfo)localObject3).str_country_code.get());
                  }
                }
                if (((oidb_0xeb8.PhoneInfo)localObject3).str_phone.has())
                {
                  ((Bundle)localObject4).putString("phone", ((oidb_0xeb8.PhoneInfo)localObject3).str_phone.get());
                  if (j == 1) {
                    paramFromServiceMsg.putString("phone", ((oidb_0xeb8.PhoneInfo)localObject3).str_phone.get());
                  }
                }
                if (((oidb_0xeb8.PhoneInfo)localObject3).uint32_phone_status.has())
                {
                  ((Bundle)localObject4).putInt("status", ((oidb_0xeb8.PhoneInfo)localObject3).uint32_phone_status.get());
                  if (j == 1) {
                    paramFromServiceMsg.putInt("status", ((oidb_0xeb8.PhoneInfo)localObject3).uint32_phone_status.get());
                  }
                }
                if (!((oidb_0xeb8.PhoneInfo)localObject3).bytes_vas_phone.has()) {
                  break label608;
                }
                ((Bundle)localObject4).putByteArray("vaskey", ((oidb_0xeb8.PhoneInfo)localObject3).bytes_vas_phone.get().toByteArray());
                break label608;
              }
              paramFromServiceMsg.putParcelableArray("phone_info", (Parcelable[])localObject1);
            }
            bool1 = true;
            localObject1 = paramFromServiceMsg;
          }
          catch (Exception localException)
          {
            paramBundle = paramFromServiceMsg;
            paramFromServiceMsg = localException;
          }
          bool2 = true;
        }
        catch (Exception paramFromServiceMsg) {}
      }
      catch (Exception paramFromServiceMsg) {}
      boolean bool1 = bool2;
      Object localObject2 = paramBundle;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onGetPhoneBindInfo error:");
        ((StringBuilder)localObject2).append(paramFromServiceMsg.getMessage());
        QLog.d("KidModeServlet", 1, ((StringBuilder)localObject2).toString());
        localObject2 = paramBundle;
        bool1 = bool2;
      }
      label594:
      paramKidModeServlet.notifyObserver(paramIntent, 7, bool1, (Bundle)localObject2, KidModeObserver.class);
      return;
      label608:
      localObject2[i] = localObject4;
      label615:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeServlet.GetPhoneBindStatusHandler
 * JD-Core Version:    0.7.0.1
 */
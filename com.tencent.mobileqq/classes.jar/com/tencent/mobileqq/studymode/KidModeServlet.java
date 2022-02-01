package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8.PhoneInfo;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8.ReqBody;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8.RspBody;
import tencent.im.oidb.cmd0xed1.oidb_0xed1.ReqBody;
import tencent.im.oidb.cmd0xed2.oidb_0xed2.ReqBody;
import tencent.im.oidb.cmd0xed2.oidb_0xed2.RspBody;
import tencent.im.oidb.oidb_0x87a.ReqBody;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.ReqBody;
import tencent.im.oidb.oidb_0x87c.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class KidModeServlet
  extends MSFServlet
{
  private oidb_sso.OIDBSSOPkg a(FromServiceMsg paramFromServiceMsg)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
    byte[] arrayOfByte = new byte[paramFromServiceMsg.getInt() - 4];
    paramFromServiceMsg.get(arrayOfByte);
    try
    {
      localOIDBSSOPkg.mergeFrom(arrayOfByte);
      return localOIDBSSOPkg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KidModeServlet", 2, "respGetBirthday|oidb_sso parseFrom byte", paramFromServiceMsg);
      }
    }
    return null;
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    boolean bool3 = paramFromServiceMsg.isSuccess();
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3)
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
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
    notifyObserver(paramIntent, 1, bool1, paramBundle, KidModeObserver.class);
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        if ((paramFromServiceMsg.isSuccess()) && (paramOIDBSSOPkg != null))
        {
          int i = ((oidb_sso.OIDBSSOPkg)paramOIDBSSOPkg.get()).uint32_result.get();
          if (i == 0)
          {
            paramFromServiceMsg = new oidb_0x5eb.RspBody();
            paramFromServiceMsg.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
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
                  break label398;
                }
                bool1 = true;
                StudyModeManager.a(16, bool1);
                if (m != 0) {
                  break label404;
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
              break label386;
            }
          }
          else
          {
            QLog.d("KidModeServlet", 1, new Object[] { "respGetKidModeStatus fail, result: ", Integer.valueOf(i) });
            bool1 = bool4;
            break label386;
          }
        }
        else
        {
          bool2 = paramFromServiceMsg.isSuccess();
          if (paramOIDBSSOPkg != null) {
            break label410;
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
      label386:
      notifyObserver(paramIntent, 3, bool1, paramBundle, KidModeObserver.class);
      return;
      label398:
      boolean bool1 = false;
      continue;
      label404:
      bool1 = false;
      continue;
      label410:
      bool1 = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    long l = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
    localReqBody.rpt_uint64_uins.add(Long.valueOf(l));
    localReqBody.uint32_flag_study_mode_switch.set(1);
    localReqBody.uint32_flag_kid_mode_switch.set(1);
    localReqBody.uint32_flag_kid_mode_can_pull_group.set(1);
    localReqBody.uint32_flag_kid_mode_can_search_by_strangers.set(1);
    localReqBody.uint32_flag_kid_mode_need_phone_verify.set(1);
    localReqBody.uint32_flag_kid_mode_can_search_friends.set(1);
    a(paramQQAppInterface, 1515, "OidbSvc.0x5eb_kidmode", 22, localReqBody.toByteArray(), null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    oidb_0xeb8.ReqBody localReqBody = new oidb_0xeb8.ReqBody();
    localReqBody.uint32_src.set(paramInt);
    a(paramQQAppInterface, 3768, "OidbSvc.0xeb9_bindPhone", 1, localReqBody.toByteArray(), null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setAdvanceSettingSwitch mask: ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", value: ");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("KidModeServlet", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramQQAppInterface == null)
    {
      QLog.d("KidModeServlet", 2, "sendSetKidModeRequest, app == null");
      return;
    }
    Object localObject1 = new oidb_0xed1.ReqBody();
    if (paramInt1 != 4)
    {
      if (paramInt1 != 8)
      {
        if (paramInt1 != 16)
        {
          if (paramInt1 == 32) {
            ((oidb_0xed1.ReqBody)localObject1).uint32_can_join_group.set(paramInt2);
          }
        }
        else {
          ((oidb_0xed1.ReqBody)localObject1).uint32_other_can_search.set(paramInt2);
        }
      }
      else {
        ((oidb_0xed1.ReqBody)localObject1).uint32_can_search.set(paramInt2);
      }
    }
    else {
      ((oidb_0xed1.ReqBody)localObject1).uint32_need_verify.set(paramInt2);
    }
    Object localObject2 = ((oidb_0xed1.ReqBody)localObject1).toByteArray();
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(3793);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject2));
    localObject2 = new NewIntent(paramQQAppInterface.getApp(), KidModeServlet.class);
    ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0xed1_1");
    ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((NewIntent)localObject2).putExtra("advance_setting_field", paramInt1);
    ((NewIntent)localObject2).putExtra("advance_setting_value", paramInt2);
    paramQQAppInterface.startServlet((NewIntent)localObject2);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("sendRequest QQAppInterface is null, command is ");
      paramQQAppInterface.append(paramString);
      QLog.e("KidModeServlet", 1, paramQQAppInterface.toString());
      return;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramArrayOfByte = new NewIntent(paramQQAppInterface.getApp(), KidModeServlet.class);
    paramArrayOfByte.putExtra("cmd", paramString);
    paramArrayOfByte.putExtra("data", localOIDBSSOPkg.toByteArray());
    paramArrayOfByte.putExtra("extensionField", paramBundle);
    paramQQAppInterface.startServlet(paramArrayOfByte);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    oidb_0x87a.ReqBody localReqBody = new oidb_0x87a.ReqBody();
    localReqBody.enum_butype.set(1);
    a(paramQQAppInterface, 2170, "OidbSvc.0x87a_115", 108, localReqBody.toByteArray(), paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    oidb_0x87c.ReqBody localReqBody = new oidb_0x87c.ReqBody();
    localReqBody.str_sms_code.set(paramString);
    localReqBody.enum_butype.set(1);
    a(paramQQAppInterface, 2172, "OidbSvc.0x87c_115", 108, localReqBody.toByteArray(), null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      oidb_0xed2.ReqBody localReqBody = new oidb_0xed2.ReqBody();
      localReqBody.str_country.set(paramString1);
      localReqBody.str_telephone.set(paramString2);
      localReqBody.uint32_key_type.set(paramInt);
      if (paramArrayOfByte != null) {
        localReqBody.bytes_key.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      localReqBody.enum_reqphonetype.set(1);
      a(paramQQAppInterface, 3794, "OidbSvc.0xed2_1", 1, localReqBody.toByteArray(), null);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("KidModeServlet", 1, new Object[] { "sendSmsTokenRequest Error", paramQQAppInterface.getMessage() });
    }
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        if ((paramFromServiceMsg.isSuccess()) && (paramOIDBSSOPkg != null))
        {
          int i = paramOIDBSSOPkg.uint32_result.get();
          paramBundle.putInt("REQ_RESULT", i);
          paramFromServiceMsg = new oidb_0x87a.RspBody();
          paramFromServiceMsg.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
          paramBundle.putInt("RESENT_INTERVAL_TIMEOUT", paramFromServiceMsg.uint32_resend_interval.get());
          if (i == 0)
          {
            bool1 = true;
          }
          else
          {
            if (paramOIDBSSOPkg.str_error_msg.has()) {
              paramBundle.putString("REQ_RESULT_MSG", paramOIDBSSOPkg.str_error_msg.get());
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
          if (paramOIDBSSOPkg != null) {
            break label237;
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
      notifyObserver(paramIntent, 4, bool1, paramBundle, KidModeObserver.class);
      return;
      label237:
      boolean bool1 = false;
    }
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        if ((paramFromServiceMsg.isSuccess()) && (paramOIDBSSOPkg != null))
        {
          int i = paramOIDBSSOPkg.uint32_result.get();
          if (i == 0)
          {
            try
            {
              paramFromServiceMsg = new oidb_0x87c.RspBody();
              paramFromServiceMsg.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
              paramOIDBSSOPkg = paramFromServiceMsg.bytes_key.get().toByteArray();
              i = paramFromServiceMsg.uint32_key_type.get();
              paramBundle.putByteArray("SMS_TOKEN", paramOIDBSSOPkg);
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
            break label216;
          }
        }
        else
        {
          boolean bool4 = paramFromServiceMsg.isSuccess();
          if (paramOIDBSSOPkg != null) {
            break label228;
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
      label216:
      notifyObserver(paramIntent, 5, bool1, paramBundle, KidModeObserver.class);
      return;
      label228:
      boolean bool1 = false;
    }
  }
  
  private void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        if ((paramFromServiceMsg.isSuccess()) && (paramOIDBSSOPkg != null))
        {
          int i = paramOIDBSSOPkg.uint32_result.get();
          if (i == 0)
          {
            paramFromServiceMsg = new oidb_0xed2.RspBody();
            paramFromServiceMsg.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
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
          if (paramOIDBSSOPkg != null) {
            break label223;
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
      notifyObserver(paramIntent, 2, bool1, paramBundle, KidModeObserver.class);
      return;
      label223:
      boolean bool1 = false;
    }
  }
  
  private void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        boolean bool4;
        if ((paramFromServiceMsg.isSuccess()) && (paramOIDBSSOPkg != null))
        {
          int i = ((oidb_sso.OIDBSSOPkg)paramOIDBSSOPkg.get()).uint32_result.get();
          if (i == 0)
          {
            paramFromServiceMsg = new oidb_0x5eb.RspBody();
            paramFromServiceMsg.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
            bool4 = paramFromServiceMsg.rpt_msg_uin_data.has();
            bool1 = bool3;
            if (!bool4) {
              break label230;
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
            break label230;
          }
        }
        else
        {
          bool4 = paramFromServiceMsg.isSuccess();
          if (paramOIDBSSOPkg != null) {
            break label243;
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
      label230:
      notifyObserver(paramIntent, 6, bool1, paramBundle, KidModeObserver.class);
      return;
      label243:
      boolean bool1 = false;
    }
  }
  
  private void f(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    int i = 0;
    if (paramOIDBSSOPkg != null) {}
    for (;;)
    {
      Bundle localBundle;
      try
      {
        if ((!paramFromServiceMsg.isSuccess()) || (paramOIDBSSOPkg.uint32_result.get() != 0) || (!paramOIDBSSOPkg.bytes_bodybuffer.has())) {
          break label557;
        }
        Object localObject = new oidb_0xeb8.RspBody();
        ((oidb_0xeb8.RspBody)localObject).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        int j = ((oidb_0xeb8.RspBody)localObject).uint32_check_result.get();
        if (j <= 0) {
          break label557;
        }
        try
        {
          paramFromServiceMsg = new Bundle();
          try
          {
            if (((oidb_0xeb8.RspBody)localObject).str_mibao_change_url.has()) {
              paramFromServiceMsg.putString("mibao_change_url", ((oidb_0xeb8.RspBody)localObject).str_mibao_change_url.get());
            }
            if (((oidb_0xeb8.RspBody)localObject).str_mibao_set_url.has()) {
              paramFromServiceMsg.putString("mibao_set_url", ((oidb_0xeb8.RspBody)localObject).str_mibao_set_url.get());
            }
            if (((oidb_0xeb8.RspBody)localObject).str_mibao_verify_url.has()) {
              paramFromServiceMsg.putString("mibao_verify_url", ((oidb_0xeb8.RspBody)localObject).str_mibao_verify_url.get());
            }
            if (((oidb_0xeb8.RspBody)localObject).rpt_phone_info.has())
            {
              paramBundle = ((oidb_0xeb8.RspBody)localObject).rpt_phone_info.get();
              paramOIDBSSOPkg = new Bundle[paramBundle.size()];
              if (i < paramBundle.size())
              {
                localObject = (oidb_0xeb8.PhoneInfo)paramBundle.get(i);
                if (localObject == null) {
                  break label577;
                }
                localBundle = new Bundle();
                j = -1;
                if (((oidb_0xeb8.PhoneInfo)localObject).uint32_phone_type.has())
                {
                  localBundle.putInt("phone_type", ((oidb_0xeb8.PhoneInfo)localObject).uint32_phone_type.get());
                  j = ((oidb_0xeb8.PhoneInfo)localObject).uint32_phone_type.get();
                }
                if (((oidb_0xeb8.PhoneInfo)localObject).str_country_code.has())
                {
                  localBundle.putString("country_code", ((oidb_0xeb8.PhoneInfo)localObject).str_country_code.get());
                  if (j == 1) {
                    paramFromServiceMsg.putString("country_code", ((oidb_0xeb8.PhoneInfo)localObject).str_country_code.get());
                  }
                }
                if (((oidb_0xeb8.PhoneInfo)localObject).str_phone.has())
                {
                  localBundle.putString("phone", ((oidb_0xeb8.PhoneInfo)localObject).str_phone.get());
                  if (j == 1) {
                    paramFromServiceMsg.putString("phone", ((oidb_0xeb8.PhoneInfo)localObject).str_phone.get());
                  }
                }
                if (((oidb_0xeb8.PhoneInfo)localObject).uint32_phone_status.has())
                {
                  localBundle.putInt("status", ((oidb_0xeb8.PhoneInfo)localObject).uint32_phone_status.get());
                  if (j == 1) {
                    paramFromServiceMsg.putInt("status", ((oidb_0xeb8.PhoneInfo)localObject).uint32_phone_status.get());
                  }
                }
                if (!((oidb_0xeb8.PhoneInfo)localObject).bytes_vas_phone.has()) {
                  break label570;
                }
                localBundle.putByteArray("vaskey", ((oidb_0xeb8.PhoneInfo)localObject).bytes_vas_phone.get().toByteArray());
                break label570;
              }
              paramFromServiceMsg.putParcelableArray("phone_info", paramOIDBSSOPkg);
            }
            bool2 = true;
            paramBundle = paramFromServiceMsg;
          }
          catch (Exception paramBundle) {}
          bool1 = true;
        }
        catch (Exception paramOIDBSSOPkg)
        {
          paramFromServiceMsg = paramBundle;
          paramBundle = paramOIDBSSOPkg;
        }
        paramOIDBSSOPkg = paramBundle;
      }
      catch (Exception paramOIDBSSOPkg)
      {
        paramFromServiceMsg = paramBundle;
      }
      bool2 = bool1;
      paramBundle = paramFromServiceMsg;
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onGetPhoneBindInfo error:");
        paramBundle.append(paramOIDBSSOPkg.getMessage());
        QLog.d("KidModeServlet", 1, paramBundle.toString());
        bool2 = bool1;
        paramBundle = paramFromServiceMsg;
      }
      label557:
      notifyObserver(paramIntent, 7, bool2, paramBundle, KidModeObserver.class);
      return;
      label570:
      paramOIDBSSOPkg[i] = localBundle;
      label577:
      i += 1;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("KidModeServlet", 2, "onReceive");
    }
    if (paramIntent != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      String str = paramFromServiceMsg.getServiceCmd();
      Object localObject2 = paramIntent.getExtras();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      localObject2 = a(paramFromServiceMsg);
      if ("OidbSvc.0xed1_1".equals(str))
      {
        a(paramIntent, paramFromServiceMsg, (Bundle)localObject1);
        return;
      }
      if ("OidbSvc.0xed2_1".equals(str))
      {
        d(paramIntent, paramFromServiceMsg, (Bundle)localObject1, (oidb_sso.OIDBSSOPkg)localObject2);
        return;
      }
      if ("OidbSvc.0x87c_115".equals(str))
      {
        c(paramIntent, paramFromServiceMsg, (Bundle)localObject1, (oidb_sso.OIDBSSOPkg)localObject2);
        return;
      }
      if ("OidbSvc.0x5eb_kidmode".equals(str))
      {
        a(paramIntent, paramFromServiceMsg, (Bundle)localObject1, (oidb_sso.OIDBSSOPkg)localObject2);
        return;
      }
      if ("OidbSvc.0x87a_115".equals(str))
      {
        b(paramIntent, paramFromServiceMsg, (Bundle)localObject1, (oidb_sso.OIDBSSOPkg)localObject2);
        return;
      }
      if ("OidbSvc.0x5eb_needVerify".equals(str))
      {
        e(paramIntent, paramFromServiceMsg, (Bundle)localObject1, (oidb_sso.OIDBSSOPkg)localObject2);
        return;
      }
      if ("OidbSvc.0xeb9_bindPhone".equals(str))
      {
        f(paramIntent, paramFromServiceMsg, (Bundle)localObject1, (oidb_sso.OIDBSSOPkg)localObject2);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("KidModeServlet", 1, new Object[] { "KidModeServlet unknown cmd: ", str });
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    String str = paramIntent.getStringExtra("cmd");
    long l = paramIntent.getLongExtra("timeout", 30000L);
    paramIntent = new StringBuilder();
    paramIntent.append("onSend, cmd is ");
    paramIntent.append(str);
    QLog.i("KidModeServlet", 1, paramIntent.toString());
    paramPacket.setSSOCommand(str);
    paramPacket.putSendData(WupUtil.a(arrayOfByte));
    if (l > 0L) {
      paramPacket.setTimeout(l);
    }
    if (QLog.isColorLevel()) {
      QLog.i("KidModeServlet", 2, "onSend exit");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeServlet
 * JD-Core Version:    0.7.0.1
 */
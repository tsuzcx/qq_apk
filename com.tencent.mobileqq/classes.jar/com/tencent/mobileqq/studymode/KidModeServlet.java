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
    boolean bool2 = false;
    boolean bool1 = false;
    int i;
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      if (paramFromServiceMsg != null)
      {
        i = paramFromServiceMsg.uint32_result.get();
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
      }
    }
    for (;;)
    {
      notifyObserver(paramIntent, 1, bool1, paramBundle, KidModeObserver.class);
      return;
      QLog.d("KidModeServlet", 1, "respSendSetKidMode, oidb result: " + i);
      bool1 = bool2;
      continue;
      QLog.d("KidModeServlet", 1, "ssoPkg == null");
      bool1 = bool2;
      continue;
      QLog.d("KidModeServlet", 1, "respSendSetKidMode fail");
      bool1 = false;
    }
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        if ((paramFromServiceMsg.isSuccess()) && (paramOIDBSSOPkg != null))
        {
          i = ((oidb_sso.OIDBSSOPkg)paramOIDBSSOPkg.get()).uint32_result.get();
          if (i == 0)
          {
            paramFromServiceMsg = new oidb_0x5eb.RspBody();
            paramFromServiceMsg.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
            bool1 = paramFromServiceMsg.rpt_msg_uin_data.has();
            if (!bool1) {}
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        int i;
        int j;
        int k;
        int m;
        int n;
        int i1;
        bool1 = bool3;
      }
      try
      {
        paramFromServiceMsg = (oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0);
        i = paramFromServiceMsg.uint32_flag_study_mode_switch.get();
        j = paramFromServiceMsg.uint32_flag_kid_mode_switch.get();
        k = paramFromServiceMsg.uint32_flag_kid_mode_need_phone_verify.get();
        m = paramFromServiceMsg.uint32_flag_kid_mode_can_search_friends.get();
        n = paramFromServiceMsg.uint32_flag_kid_mode_can_pull_group.get();
        i1 = paramFromServiceMsg.uint32_flag_kid_mode_can_search_by_strangers.get();
        paramBundle.putInt("SIMPLE_MODE_SWITCH", i);
        paramBundle.putInt("KID_MODE_SWITCH", j);
        paramBundle.putInt("KID_MODE_NEED_VERIFY", k);
        paramBundle.putInt("KID_MODE_PULL_GROUP", n);
        paramBundle.putInt("KID_MODE_SEARCH_FRIENDS", m);
        paramBundle.putInt("KID_MODE_SEARCH_BY_STRANGERS", i1);
        if (i1 != 0) {
          continue;
        }
        bool1 = true;
        StudyModeManager.a(16, bool1);
        if (m != 0) {
          continue;
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
        for (;;)
        {
          bool1 = true;
        }
        bool1 = false;
        continue;
      }
      notifyObserver(paramIntent, 3, bool1, paramBundle, KidModeObserver.class);
      return;
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      QLog.d("KidModeServlet", 1, "respGetKidModeStatus fail, udc is null");
      break label392;
      QLog.d("KidModeServlet", 1, new Object[] { "respGetKidModeStatus fail, result: ", Integer.valueOf(i) });
      break label392;
      QLog.e("KidModeServlet", 1, "respGetKidModeStatus get a error: ", paramFromServiceMsg);
    }
    bool2 = paramFromServiceMsg.isSuccess();
    if (paramOIDBSSOPkg == null) {}
    for (bool1 = true;; bool1 = false)
    {
      QLog.d("KidModeServlet", 1, new Object[] { "respGetKidModeStatus fail, response isSuccess: ", Boolean.valueOf(bool2), "pkg isNull: ", Boolean.valueOf(bool1) });
      break;
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
    if (QLog.isColorLevel()) {
      QLog.d("KidModeServlet", 2, "setAdvanceSettingSwitch mask: " + paramInt1 + ", value: " + paramInt2);
    }
    if (paramQQAppInterface == null)
    {
      QLog.d("KidModeServlet", 2, "sendSetKidModeRequest, app == null");
      return;
    }
    Object localObject1 = new oidb_0xed1.ReqBody();
    switch (paramInt1)
    {
    }
    for (;;)
    {
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
      return;
      ((oidb_0xed1.ReqBody)localObject1).uint32_need_verify.set(paramInt2);
      continue;
      ((oidb_0xed1.ReqBody)localObject1).uint32_can_join_group.set(paramInt2);
      continue;
      ((oidb_0xed1.ReqBody)localObject1).uint32_other_can_search.set(paramInt2);
      continue;
      ((oidb_0xed1.ReqBody)localObject1).uint32_can_search.set(paramInt2);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("KidModeServlet", 1, "sendRequest QQAppInterface is null, command is " + paramString);
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
    for (boolean bool1 = true;; bool1 = false)
    {
      try
      {
        if ((!paramFromServiceMsg.isSuccess()) || (paramOIDBSSOPkg == null)) {
          break label148;
        }
        i = paramOIDBSSOPkg.uint32_result.get();
        paramBundle.putInt("REQ_RESULT", i);
        paramFromServiceMsg = new oidb_0x87a.RspBody();
        paramFromServiceMsg.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        paramBundle.putInt("RESENT_INTERVAL_TIMEOUT", paramFromServiceMsg.uint32_resend_interval.get());
        if (i != 0) {
          break label89;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          int i;
          label89:
          boolean bool2;
          label148:
          QLog.e("KidModeServlet", 1, "respGetSmsCode get a error: ", paramFromServiceMsg);
          bool1 = false;
          continue;
          bool1 = false;
        }
      }
      notifyObserver(paramIntent, 4, bool1, paramBundle, KidModeObserver.class);
      return;
      if (paramOIDBSSOPkg.str_error_msg.has()) {
        paramBundle.putString("REQ_RESULT_MSG", paramOIDBSSOPkg.str_error_msg.get());
      }
      if (QLog.isColorLevel())
      {
        QLog.d("KidModeServlet", 1, new Object[] { "respGetSmsCode fail, result: ", Integer.valueOf(i) });
        continue;
        bool2 = paramFromServiceMsg.isSuccess();
        if (paramOIDBSSOPkg == null)
        {
          bool1 = true;
          QLog.d("KidModeServlet", 1, new Object[] { "respVerifySmsCode fail, response isSuccess: ", Boolean.valueOf(bool2), "pkg isNull: ", Boolean.valueOf(bool1) });
        }
      }
    }
  }
  
  /* Error */
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_2
    //   4: invokevirtual 57	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +125 -> 132
    //   10: aload 4
    //   12: ifnull +120 -> 132
    //   15: aload 4
    //   17: getfield 63	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   20: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   23: istore 5
    //   25: iload 5
    //   27: ifne +78 -> 105
    //   30: new 435	tencent/im/oidb/oidb_0x87c$RspBody
    //   33: dup
    //   34: invokespecial 436	tencent/im/oidb/oidb_0x87c$RspBody:<init>	()V
    //   37: astore_2
    //   38: aload_2
    //   39: aload 4
    //   41: getfield 121	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   44: invokevirtual 126	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   47: invokevirtual 131	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   50: invokevirtual 437	tencent/im/oidb/oidb_0x87c$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   53: pop
    //   54: aload_2
    //   55: getfield 438	tencent/im/oidb/oidb_0x87c$RspBody:bytes_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   58: invokevirtual 126	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   61: invokevirtual 131	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   64: astore 4
    //   66: aload_2
    //   67: getfield 439	tencent/im/oidb/oidb_0x87c$RspBody:uint32_key_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   70: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   73: istore 5
    //   75: aload_3
    //   76: ldc_w 441
    //   79: aload 4
    //   81: invokevirtual 445	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   84: aload_3
    //   85: ldc_w 447
    //   88: iload 5
    //   90: invokevirtual 170	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   93: aload_0
    //   94: aload_1
    //   95: iconst_5
    //   96: iload 6
    //   98: aload_3
    //   99: ldc 83
    //   101: invokevirtual 87	com/tencent/mobileqq/studymode/KidModeServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   104: return
    //   105: ldc 47
    //   107: iconst_1
    //   108: iconst_2
    //   109: anewarray 187	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: ldc_w 449
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: iload 5
    //   122: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: aastore
    //   126: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   129: goto +87 -> 216
    //   132: aload_2
    //   133: invokevirtual 57	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   136: istore 7
    //   138: aload 4
    //   140: ifnonnull +63 -> 203
    //   143: iconst_1
    //   144: istore 6
    //   146: ldc 47
    //   148: iconst_1
    //   149: iconst_4
    //   150: anewarray 187	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: ldc_w 430
    //   158: aastore
    //   159: dup
    //   160: iconst_1
    //   161: iload 7
    //   163: invokestatic 210	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   166: aastore
    //   167: dup
    //   168: iconst_2
    //   169: ldc 212
    //   171: aastore
    //   172: dup
    //   173: iconst_3
    //   174: iload 6
    //   176: invokestatic 210	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   179: aastore
    //   180: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   183: goto +33 -> 216
    //   186: astore_2
    //   187: iconst_0
    //   188: istore 6
    //   190: ldc 47
    //   192: iconst_1
    //   193: ldc_w 451
    //   196: aload_2
    //   197: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   200: goto -107 -> 93
    //   203: iconst_0
    //   204: istore 6
    //   206: goto -60 -> 146
    //   209: astore_2
    //   210: iconst_1
    //   211: istore 6
    //   213: goto -23 -> 190
    //   216: iconst_0
    //   217: istore 6
    //   219: goto -126 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	KidModeServlet
    //   0	222	1	paramIntent	Intent
    //   0	222	2	paramFromServiceMsg	FromServiceMsg
    //   0	222	3	paramBundle	Bundle
    //   0	222	4	paramOIDBSSOPkg	oidb_sso.OIDBSSOPkg
    //   23	98	5	i	int
    //   1	217	6	bool1	boolean
    //   136	26	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   3	10	186	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   15	25	186	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   105	129	186	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   132	138	186	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   146	183	186	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   30	93	209	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    for (boolean bool1 = true;; bool1 = false)
    {
      label80:
      label107:
      boolean bool2;
      try
      {
        if ((!paramFromServiceMsg.isSuccess()) || (paramOIDBSSOPkg == null)) {
          break label151;
        }
        i = paramOIDBSSOPkg.uint32_result.get();
        if (i != 0) {
          break label107;
        }
        paramFromServiceMsg = new oidb_0xed2.RspBody();
        paramFromServiceMsg.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        i = paramFromServiceMsg.uint32_result.get();
        if (i != 0) {
          break label80;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          int i;
          QLog.e("KidModeServlet", 1, "respVerifySmsCode get a error: ", paramFromServiceMsg);
          bool1 = false;
        }
        bool2 = paramFromServiceMsg.isSuccess();
        if (paramOIDBSSOPkg != null) {
          break label205;
        }
      }
      notifyObserver(paramIntent, 2, bool1, paramBundle, KidModeObserver.class);
      return;
      QLog.d("KidModeServlet", 1, new Object[] { "respSendSmsToken fail, uint32_result result: ", Integer.valueOf(i) });
      continue;
      QLog.d("KidModeServlet", 1, new Object[] { "respSendSmsToken fail, pkg header result: ", Integer.valueOf(i) });
      continue;
      label151:
      label205:
      for (bool1 = true;; bool1 = false)
      {
        QLog.d("KidModeServlet", 1, new Object[] { "respSendSmsToken fail, response isSuccess: ", Boolean.valueOf(bool2), "pkg isNull: ", Boolean.valueOf(bool1) });
        break;
      }
    }
  }
  
  private void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    for (;;)
    {
      try
      {
        if ((paramFromServiceMsg.isSuccess()) && (paramOIDBSSOPkg != null))
        {
          i = ((oidb_sso.OIDBSSOPkg)paramOIDBSSOPkg.get()).uint32_result.get();
          if (i == 0)
          {
            paramFromServiceMsg = new oidb_0x5eb.RspBody();
            paramFromServiceMsg.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
            bool1 = paramFromServiceMsg.rpt_msg_uin_data.has();
            if (!bool1) {
              break label227;
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        int i;
        boolean bool2;
        bool1 = false;
      }
      try
      {
        i = ((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0)).uint32_flag_kid_mode_need_phone_verify.get();
        paramBundle.putInt("KID_MODE_NEED_VERIFY", i);
        StudyModeManager.a(i);
        bool1 = true;
        notifyObserver(paramIntent, 6, bool1, paramBundle, KidModeObserver.class);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          bool1 = true;
        }
      }
      QLog.d("KidModeServlet", 1, new Object[] { "respGetKidModeStatus fail, result: ", Integer.valueOf(i) });
      break label227;
      bool2 = paramFromServiceMsg.isSuccess();
      if (paramOIDBSSOPkg == null)
      {
        bool1 = true;
        QLog.d("KidModeServlet", 1, new Object[] { "respGetKidModeStatus fail, response isSuccess: ", Boolean.valueOf(bool2), "pkg isNull: ", Boolean.valueOf(bool1) });
        break label227;
        QLog.e("KidModeServlet", 1, "respGetKidModeStatus get a error: ", paramFromServiceMsg);
      }
      else
      {
        bool1 = false;
        continue;
      }
      label227:
      boolean bool1 = false;
    }
  }
  
  private void f(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    boolean bool2 = false;
    bool1 = bool2;
    Object localObject1 = paramBundle;
    if (paramOIDBSSOPkg != null)
    {
      bool1 = bool2;
      localObject1 = paramBundle;
      for (;;)
      {
        try
        {
          if (paramFromServiceMsg.isSuccess())
          {
            bool1 = bool2;
            localObject1 = paramBundle;
            if (paramOIDBSSOPkg.uint32_result.get() == 0)
            {
              bool1 = bool2;
              localObject1 = paramBundle;
              if (paramOIDBSSOPkg.bytes_bodybuffer.has())
              {
                localObject2 = new oidb_0xeb8.RspBody();
                ((oidb_0xeb8.RspBody)localObject2).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
                i = ((oidb_0xeb8.RspBody)localObject2).uint32_check_result.get();
                bool1 = bool2;
                localObject1 = paramBundle;
                if (i <= 0) {}
              }
            }
          }
        }
        catch (Exception paramOIDBSSOPkg)
        {
          Object localObject2;
          int j;
          bool1 = false;
          paramFromServiceMsg = paramBundle;
          paramBundle = paramOIDBSSOPkg;
          continue;
        }
        try
        {
          paramFromServiceMsg = new Bundle();
        }
        catch (Exception paramOIDBSSOPkg)
        {
          bool1 = true;
          paramFromServiceMsg = paramBundle;
          paramBundle = paramOIDBSSOPkg;
          continue;
          i += 1;
          continue;
        }
        try
        {
          if (((oidb_0xeb8.RspBody)localObject2).str_mibao_change_url.has()) {
            paramFromServiceMsg.putString("mibao_change_url", ((oidb_0xeb8.RspBody)localObject2).str_mibao_change_url.get());
          }
          if (((oidb_0xeb8.RspBody)localObject2).str_mibao_set_url.has()) {
            paramFromServiceMsg.putString("mibao_set_url", ((oidb_0xeb8.RspBody)localObject2).str_mibao_set_url.get());
          }
          if (((oidb_0xeb8.RspBody)localObject2).str_mibao_verify_url.has()) {
            paramFromServiceMsg.putString("mibao_verify_url", ((oidb_0xeb8.RspBody)localObject2).str_mibao_verify_url.get());
          }
          if (!((oidb_0xeb8.RspBody)localObject2).rpt_phone_info.has()) {
            continue;
          }
          paramBundle = ((oidb_0xeb8.RspBody)localObject2).rpt_phone_info.get();
          paramOIDBSSOPkg = new Bundle[paramBundle.size()];
          i = 0;
          if (i >= paramBundle.size()) {
            continue;
          }
          localObject1 = (oidb_0xeb8.PhoneInfo)paramBundle.get(i);
          if (localObject1 == null) {
            break label617;
          }
          localObject2 = new Bundle();
          j = -1;
          if (((oidb_0xeb8.PhoneInfo)localObject1).uint32_phone_type.has())
          {
            ((Bundle)localObject2).putInt("phone_type", ((oidb_0xeb8.PhoneInfo)localObject1).uint32_phone_type.get());
            j = ((oidb_0xeb8.PhoneInfo)localObject1).uint32_phone_type.get();
          }
          if (((oidb_0xeb8.PhoneInfo)localObject1).str_country_code.has())
          {
            ((Bundle)localObject2).putString("country_code", ((oidb_0xeb8.PhoneInfo)localObject1).str_country_code.get());
            if (j == 1) {
              paramFromServiceMsg.putString("country_code", ((oidb_0xeb8.PhoneInfo)localObject1).str_country_code.get());
            }
          }
          if (((oidb_0xeb8.PhoneInfo)localObject1).str_phone.has())
          {
            ((Bundle)localObject2).putString("phone", ((oidb_0xeb8.PhoneInfo)localObject1).str_phone.get());
            if (j == 1) {
              paramFromServiceMsg.putString("phone", ((oidb_0xeb8.PhoneInfo)localObject1).str_phone.get());
            }
          }
          if (((oidb_0xeb8.PhoneInfo)localObject1).uint32_phone_status.has())
          {
            ((Bundle)localObject2).putInt("status", ((oidb_0xeb8.PhoneInfo)localObject1).uint32_phone_status.get());
            if (j == 1) {
              paramFromServiceMsg.putInt("status", ((oidb_0xeb8.PhoneInfo)localObject1).uint32_phone_status.get());
            }
          }
          if (((oidb_0xeb8.PhoneInfo)localObject1).bytes_vas_phone.has()) {
            ((Bundle)localObject2).putByteArray("vaskey", ((oidb_0xeb8.PhoneInfo)localObject1).bytes_vas_phone.get().toByteArray());
          }
          paramOIDBSSOPkg[i] = localObject2;
        }
        catch (Exception paramBundle)
        {
          bool1 = true;
        }
      }
      bool2 = bool1;
      paramOIDBSSOPkg = paramFromServiceMsg;
      if (QLog.isColorLevel())
      {
        QLog.d("KidModeServlet", 1, "onGetPhoneBindInfo error:" + paramBundle.getMessage());
        paramOIDBSSOPkg = paramFromServiceMsg;
      }
    }
    for (bool2 = bool1;; bool2 = bool1)
    {
      notifyObserver(paramIntent, 7, bool2, paramOIDBSSOPkg, KidModeObserver.class);
      return;
      paramFromServiceMsg.putParcelableArray("phone_info", paramOIDBSSOPkg);
      bool1 = true;
      localObject1 = paramFromServiceMsg;
      paramOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)localObject1;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("KidModeServlet", 2, "onReceive");
    }
    if ((paramIntent == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      return;
      str = paramFromServiceMsg.getServiceCmd();
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
    } while (!QLog.isColorLevel());
    QLog.d("KidModeServlet", 1, new Object[] { "KidModeServlet unknown cmd: ", str });
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    String str = paramIntent.getStringExtra("cmd");
    long l = paramIntent.getLongExtra("timeout", 30000L);
    QLog.i("KidModeServlet", 1, "onSend, cmd is " + str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeServlet
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.studymode.proto.KidModePassword.ClearPasswdReq;
import com.tencent.mobileqq.studymode.proto.KidModePassword.FaceKey;
import com.tencent.mobileqq.studymode.proto.KidModePassword.QueryPasswdStateReq;
import com.tencent.mobileqq.studymode.proto.KidModePassword.SHA256Rounds2Params;
import com.tencent.mobileqq.studymode.proto.KidModePassword.SetPasswdReq;
import com.tencent.mobileqq.studymode.proto.KidModePassword.VerifyPasswdReq;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Random;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8.ReqBody;
import tencent.im.oidb.cmd0xed1.oidb_0xed1.ReqBody;
import tencent.im.oidb.cmd0xed2.oidb_0xed2.ReqBody;
import tencent.im.oidb.oidb_0x87a.ReqBody;
import tencent.im.oidb.oidb_0x87c.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class KidModeServlet
  extends MSFServlet
{
  static KidModeServlet.RequestHandler a = new KidModeServlet.DefaultRequestHandler();
  
  static long a()
  {
    return new Random().nextLong();
  }
  
  static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString1);
    paramString1 = a(localStringBuilder.toString().getBytes());
    if (paramString1 == null) {
      return "";
    }
    paramString1 = a(paramString1);
    if (paramString1 == null) {
      return "";
    }
    return HexUtil.bytes2HexStr(paramString1);
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
    a(paramQQAppInterface, 1515, "OidbSvc.0x5eb_kidmode", 22, localReqBody.toByteArray(), null, new KidModeServlet.GetKidModeStatusHandler());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    oidb_0xeb8.ReqBody localReqBody = new oidb_0xeb8.ReqBody();
    localReqBody.uint32_src.set(paramInt);
    a(paramQQAppInterface, 3768, "OidbSvc.0xeb9_bindPhone", 1, localReqBody.toByteArray(), null, new KidModeServlet.GetPhoneBindStatusHandler());
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
    ((NewIntent)localObject2).putExtra("responseHandler", new KidModeServlet.SetAdvanceSettingSwitchHandler());
    paramQQAppInterface.startServlet((NewIntent)localObject2);
  }
  
  static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte, Bundle paramBundle, KidModeServlet.ResponseHandler paramResponseHandler)
  {
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("sendRequest QQAppInterface is null, command is ");
      paramQQAppInterface.append(paramString);
      QLog.e("KidModeServlet", 1, paramQQAppInterface.toString());
      return;
    }
    KidModeServlet.RequestHandler localRequestHandler = a;
    if (localRequestHandler == null)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("sendRequest, handler is null, command is ");
      paramQQAppInterface.append(paramString);
      QLog.e("KidModeServlet", 1, paramQQAppInterface.toString());
      return;
    }
    localRequestHandler.a(paramQQAppInterface, paramInt1, paramString, paramInt2, paramArrayOfByte, paramBundle, paramResponseHandler);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    oidb_0x87a.ReqBody localReqBody = new oidb_0x87a.ReqBody();
    localReqBody.enum_butype.set(1);
    a(paramQQAppInterface, 2170, "OidbSvc.0x87a_115", 108, localReqBody.toByteArray(), paramBundle, new KidModeServlet.GetSmsCodeHandler());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    oidb_0x87c.ReqBody localReqBody = new oidb_0x87c.ReqBody();
    localReqBody.str_sms_code.set(paramString);
    localReqBody.enum_butype.set(1);
    a(paramQQAppInterface, 2172, "OidbSvc.0x87c_115", 108, localReqBody.toByteArray(), null, new KidModeServlet.VerifySmsCodeHandler());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0))
    {
      KidModePassword.SetPasswdReq localSetPasswdReq = new KidModePassword.SetPasswdReq();
      localSetPasswdReq.scene_id.set(1);
      localSetPasswdReq.hash_method.set(1);
      localSetPasswdReq.passwd_hash.set(a(paramString1, paramString2));
      localSetPasswdReq.nonce.set(a());
      localSetPasswdReq.timestamp.set(b());
      localSetPasswdReq.sha256_rounds2_params.setHasFlag(true);
      localSetPasswdReq.sha256_rounds2_params.salt.set(paramString2);
      a(paramQQAppInterface, "trpc.passwd.manager.PasswdManager.SetPasswd", localSetPasswdReq.toByteArray(), new KidModeServlet.SetNewPasswordHandler());
      return;
    }
    QLog.w("KidModeServlet", 1, "setNewPassword, empty password");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    oidb_0xed2.ReqBody localReqBody = new oidb_0xed2.ReqBody();
    localReqBody.str_country.set(paramString1);
    localReqBody.str_telephone.set(paramString2);
    localReqBody.uint32_key_type.set(paramInt);
    if (paramArrayOfByte != null) {
      localReqBody.bytes_key.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    localReqBody.enum_reqphonetype.set(1);
    a(paramQQAppInterface, 3794, "OidbSvc.0xed2_1", 1, localReqBody.toByteArray(), null, new KidModeServlet.SendSmsTokenHandler());
  }
  
  static void a(QQAppInterface paramQQAppInterface, String paramString, byte[] paramArrayOfByte, KidModeServlet.ResponseHandler paramResponseHandler)
  {
    a(paramQQAppInterface, 0, paramString, 0, paramArrayOfByte, null, paramResponseHandler);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    oidb_0xed2.ReqBody localReqBody = new oidb_0xed2.ReqBody();
    if (paramArrayOfByte != null) {
      localReqBody.bytes_signature.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    a(paramQQAppInterface, 3794, "OidbSvc.0xed2_1", 1, localReqBody.toByteArray(), null, new KidModeServlet.SendSmsTokenHandler());
  }
  
  static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = MessageDigest.getInstance("SHA-256").digest(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hash password fail, ");
      localStringBuilder.append(paramArrayOfByte);
      QLog.i("KidModeServlet", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  static long b()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  private static NewIntent b(QQAppInterface paramQQAppInterface, String paramString, byte[] paramArrayOfByte, Bundle paramBundle, KidModeServlet.ResponseHandler paramResponseHandler)
  {
    paramQQAppInterface = new NewIntent(paramQQAppInterface.getApp(), KidModeServlet.class);
    paramQQAppInterface.putExtra("cmd", paramString);
    paramQQAppInterface.putExtra("data", paramArrayOfByte);
    paramQQAppInterface.putExtra("extensionField", paramBundle);
    paramQQAppInterface.putExtra("responseHandler", paramResponseHandler);
    return paramQQAppInterface;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    KidModePassword.QueryPasswdStateReq localQueryPasswdStateReq = new KidModePassword.QueryPasswdStateReq();
    localQueryPasswdStateReq.scene_id.set(1);
    a(paramQQAppInterface, "trpc.passwd.manager.PasswdManager.QueryPasswdState", localQueryPasswdStateReq.toByteArray(), new KidModeServlet.QueryPasswordStateHandler());
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0))
    {
      KidModePassword.VerifyPasswdReq localVerifyPasswdReq = new KidModePassword.VerifyPasswdReq();
      localVerifyPasswdReq.scene_id.set(1);
      localVerifyPasswdReq.passwd_hash.set(a(paramString1, paramString2));
      localVerifyPasswdReq.nonce.set(a());
      localVerifyPasswdReq.timestamp.set(b());
      a(paramQQAppInterface, "trpc.passwd.manager.PasswdManager.VerifyPasswd", localVerifyPasswdReq.toByteArray(), new KidModeServlet.VerifyPasswordHandler());
      return;
    }
    QLog.w("KidModeServlet", 1, "verifyPassword, empty password");
  }
  
  private static oidb_sso.OIDBSSOPkg c(FromServiceMsg paramFromServiceMsg)
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
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null) && (paramString2.length() != 0))
    {
      KidModePassword.ClearPasswdReq localClearPasswdReq = new KidModePassword.ClearPasswdReq();
      localClearPasswdReq.scene_id.set(1);
      localClearPasswdReq.auth_method.set(1);
      localClearPasswdReq.face_key.setHasFlag(true);
      localClearPasswdReq.face_key.nonce.set(paramString1);
      localClearPasswdReq.face_key.id_key.set(paramString2);
      localClearPasswdReq.nonce.set(a());
      localClearPasswdReq.timestamp.set(b());
      a(paramQQAppInterface, "trpc.passwd.manager.PasswdManager.ClearPasswd", localClearPasswdReq.toByteArray(), new KidModeServlet.ClearPasswordHandler());
      return;
    }
    QLog.w("KidModeServlet", 1, "clearPassword, invalid arguments");
  }
  
  private static byte[] d(FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      byte[] arrayOfByte = new byte[i];
      PkgTools.copyData(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
      return arrayOfByte;
    }
    return null;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("KidModeServlet", 2, "onReceive");
    }
    if ((paramIntent != null) && (paramFromServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      Object localObject2 = paramIntent.getExtras();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      localObject2 = (KidModeServlet.ResponseHandler)paramIntent.getSerializableExtra("responseHandler");
      if (localObject2 != null)
      {
        ((KidModeServlet.ResponseHandler)localObject2).handle(this, paramIntent, paramFromServiceMsg, (Bundle)localObject1);
        return;
      }
      paramIntent = new StringBuilder();
      paramIntent.append("KidModeServlet unknown cmd: ");
      paramIntent.append(str);
      QLog.w("KidModeServlet", 1, paramIntent.toString());
      return;
    }
    QLog.i("KidModeServlet", 1, "onReceive, request or response is null");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeServlet
 * JD-Core Version:    0.7.0.1
 */
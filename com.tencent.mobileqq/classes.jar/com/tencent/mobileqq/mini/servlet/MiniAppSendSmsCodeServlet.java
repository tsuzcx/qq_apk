package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import android.os.Bundle;
import bcvh;
import bhjl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_0x87a.ReqBody;
import tencent.im.oidb.oidb_0x87c.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class MiniAppSendSmsCodeServlet
  extends MSFServlet
{
  public static final String CMD_GET_SMS_CODE = "OidbSvc.0x87a_112";
  public static final String CMD_VERIFY_SMS_CODE = "OidbSvc.0x87c_112";
  public static final String EXTRA_CMD = "cmd";
  public static final String EXTRA_DATA = "data";
  public static final String EXTRA_DATA_ERROR_CODE = "dataErrorCode";
  public static final String EXTRA_DATA_ERROR_MSG = "dataErrorMsg";
  public static final String KEY_PHONE_NUMBER = "phoneNumber";
  public static final int SERVICE_TYPE_GET_SMS_CODE = 112;
  public static final String TAG = "MiniAppSendSmsCodeServlet";
  
  private static void sendRequest(int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    if (BaseApplicationImpl.getApplication() == null)
    {
      QLog.e("MiniAppSendSmsCodeServlet", 1, "sendRequest getApplication is null, command is " + paramString);
      return;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localOIDBSSOPkg.str_client_version.set(AppSetting.f());
    paramArrayOfByte = new NewIntent(BaseApplicationImpl.getApplication(), bcvh.class);
    paramArrayOfByte.setObserver(paramBusinessObserver);
    paramArrayOfByte.putExtra("cmd", paramString);
    paramArrayOfByte.putExtra("data", localOIDBSSOPkg.toByteArray());
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramArrayOfByte);
  }
  
  public static void sendSmsCodeRequest(String paramString1, String paramString2, BusinessObserver paramBusinessObserver)
  {
    oidb_0x87a.ReqBody localReqBody = new oidb_0x87a.ReqBody();
    localReqBody.str_country.set(paramString2);
    localReqBody.str_telephone.set(paramString1);
    sendRequest(2170, "OidbSvc.0x87a_112", 112, localReqBody.toByteArray(), paramBusinessObserver);
  }
  
  public static void sendVerifySmsCodeRequest(String paramString1, String paramString2, String paramString3, BusinessObserver paramBusinessObserver)
  {
    oidb_0x87c.ReqBody localReqBody = new oidb_0x87c.ReqBody();
    localReqBody.str_sms_code.set(paramString1);
    localReqBody.str_country.set(paramString3);
    localReqBody.str_telephone.set(paramString2);
    sendRequest(2172, "OidbSvc.0x87c_112", 112, localReqBody.toByteArray(), paramBusinessObserver);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppSendSmsCodeServlet", 2, "onReceive");
    }
    if (paramIntent == null) {
      return;
    }
    Object localObject2 = paramIntent.getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (localObject2 = bhjl.b(paramFromServiceMsg.getWupBuffer());; localObject2 = null)
    {
      ((Bundle)localObject1).putByteArray("data", (byte[])localObject2);
      notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("MiniAppSendSmsCodeServlet", 2, "onReceive exit");
      return;
      ((Bundle)localObject1).putString("dataErrorMsg", paramFromServiceMsg.getBusinessFailMsg());
      ((Bundle)localObject1).putInt("dataErrorCode", paramFromServiceMsg.getBusinessFailCode());
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramIntent = paramIntent.getStringExtra("cmd");
    QLog.i("MiniAppSendSmsCodeServlet", 1, "onSend, cmd is " + paramIntent);
    paramPacket.setSSOCommand(paramIntent);
    paramPacket.putSendData(bhjl.a(arrayOfByte));
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppSendSmsCodeServlet", 2, "onSend exit");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet
 * JD-Core Version:    0.7.0.1
 */
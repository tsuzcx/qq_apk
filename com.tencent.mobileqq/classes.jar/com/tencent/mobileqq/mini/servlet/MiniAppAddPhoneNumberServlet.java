package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StAddPhoneNumberRsp;
import android.content.Intent;
import android.os.Bundle;
import bhuf;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppAddPhoneNumberServlet
  extends MiniAppAbstractServlet
{
  private static final String CMD_STRING = "LightAppSvc.mini_user_info.AddPhoneNumber";
  public static final String KEY_COUNTRY_CODE = "countryCode";
  public static final String KEY_IS_SAVE = "isSave";
  public static final String KEY_PURE_PHONE_NUMBER = "purePhoneNumber";
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StAddPhoneNumberRsp localStAddPhoneNumberRsp = new INTERFACE.StAddPhoneNumberRsp();
    long l = paramBundle.getLong("retCode");
    String str = paramBundle.getString("errMsg");
    if ((localStAddPhoneNumberRsp != null) && (l == 0L))
    {
      localStAddPhoneNumberRsp.mergeFrom(paramArrayOfByte);
      paramBundle.putString("encryptedData", localStAddPhoneNumberRsp.encryptedData.get());
      paramBundle.putString("iv", localStAddPhoneNumberRsp.iv.get());
      notifyObserver(paramIntent, 1073, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1073, false, paramBundle, MiniAppObserver.class);
    QLog.e("MiniAppAbstractServlet", 1, "MiniAppAddPhoneNumberServlet retCode : " + l + "; errMsg : " + str);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    this.observerId = 1073;
    Object localObject1 = paramIntent.getStringExtra("key_appid");
    Object localObject2 = paramIntent.getStringExtra("purePhoneNumber");
    String str = paramIntent.getStringExtra("countryCode");
    int i = paramIntent.getIntExtra("isSave", 0);
    int j = paramIntent.getIntExtra("key_index", -1);
    localObject2 = new MiniAppAddPhoneNumberServlet.1(this, (String)localObject1, (String)localObject2, str, i).encode(paramIntent, j, getTraceId());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_user_info.AddPhoneNumber");
    paramPacket.putSendData(bhuf.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppAddPhoneNumberServlet
 * JD-Core Version:    0.7.0.1
 */
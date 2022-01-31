package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StAddressInfo;
import NS_MINI_INTERFACE.INTERFACE.StApiUserInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetProfileRsp;
import android.content.Intent;
import android.os.Bundle;
import bdpd;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppGetProfileServlet
  extends MiniAppAbstractServlet
{
  public static final String TAG = "MiniAppGetProfileServlet";
  private String appId;
  
  public MiniAppGetProfileServlet()
  {
    this.observerId = 1001;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StGetProfileRsp localStGetProfileRsp = new INTERFACE.StGetProfileRsp();
    localStGetProfileRsp.mergeFrom(paramArrayOfByte);
    if (localStGetProfileRsp.user != null)
    {
      paramBundle.putString("nick", localStGetProfileRsp.user.nick.get());
      paramBundle.putString("avatar", localStGetProfileRsp.user.avatar.get());
      paramBundle.putInt("gender", localStGetProfileRsp.user.gender.get());
      paramBundle.putString("country", localStGetProfileRsp.user.address.country.get());
      paramBundle.putString("province", localStGetProfileRsp.user.address.province.get());
      paramBundle.putString("city", localStGetProfileRsp.user.address.city.get());
      paramBundle.putString("language", localStGetProfileRsp.user.language.get());
      paramBundle.putString("rawData", localStGetProfileRsp.rawData.get());
      paramBundle.putString("signature", localStGetProfileRsp.signature.get());
      paramBundle.putString("encryptedData", localStGetProfileRsp.encryptedData.get());
      paramBundle.putString("iv", localStGetProfileRsp.iv.get());
      paramBundle.putString("key_appid", this.appId);
      notifyObserver(paramIntent, 1001, true, paramBundle, MiniAppObserver.class);
      return;
    }
    QLog.e("MiniAppGetProfileServlet", 2, "inform MiniAppGetProfileServlet result.user == null");
    notifyObserver(paramIntent, 1001, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    this.appId = paramIntent.getStringExtra("key_appid");
    paramIntent.getLongExtra("key_uin", 0L);
    int i = paramIntent.getIntExtra("key_index", -1);
    boolean bool = paramIntent.getBooleanExtra("key_with_credential", false);
    Object localObject = paramIntent.getStringExtra("key_lang");
    byte[] arrayOfByte = new GetProfileRequest(this.appId, bool, (String)localObject).encode(paramIntent, i, getTraceId());
    localObject = arrayOfByte;
    if (arrayOfByte == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_user_info.GetProfile");
    paramPacket.putSendData(bdpd.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetProfileServlet
 * JD-Core Version:    0.7.0.1
 */
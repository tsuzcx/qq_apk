package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bakc;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import mqq.app.Packet;

public class MiniAppGetUserSettingServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APP_ID = "KEY_APP_ID";
  public static final String KEY_OPEN_ID = "KEY_OPEN_ID";
  public static final String KEY_SETTING_ITEM = "KEY_SETTING_ITEM";
  public static final String TAG = "MiniAppGetUserSettingServlet";
  
  public MiniAppGetUserSettingServlet()
  {
    this.observerId = 1039;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StGetUserSettingRsp localStGetUserSettingRsp = new INTERFACE.StGetUserSettingRsp();
    localStGetUserSettingRsp.mergeFrom(paramArrayOfByte);
    paramArrayOfByte = localStGetUserSettingRsp.setting.settingItem.get();
    String str = localStGetUserSettingRsp.setting.desc.get();
    int i = localStGetUserSettingRsp.setting.authState.get();
    paramBundle.putString("settingItem", paramArrayOfByte);
    paramBundle.putString("desc", str);
    paramBundle.putInt("authState", i);
    notifyObserver(paramIntent, 1051, true, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject1 = paramIntent.getStringExtra("KEY_APP_ID");
    Object localObject2 = paramIntent.getStringExtra("KEY_OPEN_ID");
    String str = paramIntent.getStringExtra("KEY_SETTING_ITEM");
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      localObject2 = new GetUserSettingRequest((String)localObject1, (String)localObject2, str).encode(paramIntent, i, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_user_info.GetUserSetting");
      paramPacket.putSendData(bakc.a((byte[])localObject1));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    }
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetUserSettingServlet
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bgau;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import mqq.app.Packet;

public class MiniAppGetUserSettingServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APP_ID = "KEY_APP_ID";
  public static final String KEY_OPEN_ID = "KEY_OPEN_ID";
  public static final String KEY_SETTING_ITEM = "KEY_SETTING_ITEM";
  public static final String KEY_TEMPLATE_IDS = "KEY_TEMPLATE_IDS";
  public static final String TAG = "MiniAppGetUserSettingServlet";
  
  public MiniAppGetUserSettingServlet()
  {
    this.observerId = 1051;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StGetUserSettingRsp localStGetUserSettingRsp = new INTERFACE.StGetUserSettingRsp();
    localStGetUserSettingRsp.mergeFrom(paramArrayOfByte);
    String str1 = localStGetUserSettingRsp.setting.settingItem.get();
    String str2 = localStGetUserSettingRsp.setting.desc.get();
    int i = localStGetUserSettingRsp.setting.authState.get();
    paramBundle.putString("settingItem", str1);
    paramBundle.putString("desc", str2);
    paramBundle.putInt("authState", i);
    paramBundle.putByteArray("originalData", paramArrayOfByte);
    notifyObserver(paramIntent, 1051, true, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject1 = paramIntent.getStringExtra("KEY_APP_ID");
    Object localObject2 = paramIntent.getStringExtra("KEY_OPEN_ID");
    String str = paramIntent.getStringExtra("KEY_SETTING_ITEM");
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("KEY_TEMPLATE_IDS");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new GetUserSettingRequest((String)localObject1, (String)localObject2, str, localArrayList).encode(paramIntent, i, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_user_info.GetUserSetting");
      paramPacket.putSendData(bgau.a((byte[])localObject1));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    }
    for (;;)
    {
      super.onSend(paramIntent, paramPacket);
      return;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_index", i);
      ((Bundle)localObject1).putString("errMsg", "openId is null, request failed!");
      notifyObserver(paramIntent, 1051, false, (Bundle)localObject1, MiniAppObserver.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetUserSettingServlet
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAvatarRsp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class PersonalizeSetAvatarServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APP_BUSIINFO = "mini_app_busi_info";
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_APP_ITEMID = "mini_app_itemid";
  public static final String KEY_APP_SET_TYPE = "mini_app_settype";
  public static final String KEY_APP_UIN = "key_app_uin";
  public static final String KEY_EXT = "key_ext";
  public static final String TAG = "PersonalizeSetAvatarServlet";
  
  public PersonalizeSetAvatarServlet()
  {
    this.observerId = 1034;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    new INTERFACE.StSetUserAvatarRsp().mergeFrom(paramArrayOfByte);
    if (paramBundle.getLong("retCode") == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      notifyObserver(paramIntent, 1034, bool, paramBundle, MiniAppObserver.class);
      return;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    String str1 = paramIntent.getStringExtra("key_app_id");
    Object localObject2 = paramIntent.getStringExtra("key_app_uin");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "self";
    }
    int i = paramIntent.getIntExtra("mini_app_settype", 0);
    String str2 = paramIntent.getStringExtra("mini_app_itemid");
    paramIntent.getStringExtra("key_app_id");
    String str3 = paramIntent.getStringExtra("mini_app_busi_info");
    int j = paramIntent.getIntExtra("key_index", -1);
    localObject2 = null;
    if (arrayOfByte != null) {
      localObject2 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject2).mergeFrom(arrayOfByte);
      localObject2 = new SetAvatarRequest((COMM.StCommonExt)localObject2, str1, (String)localObject1, i, str2, str3).encode(paramIntent, j, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_userapp.SetUserAvatar");
      paramPacket.putSendData(WupUtil.a((byte[])localObject1));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PersonalizeSetAvatarServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.PersonalizeSetAvatarServlet
 * JD-Core Version:    0.7.0.1
 */
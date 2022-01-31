package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetNAppForJumpRsp;
import android.content.Intent;
import android.os.Bundle;
import bblm;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppGetNativeAppInfoServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_APP_NAME = "key_app_id";
  public static final String KEY_DOWNLOAD_URL = "key_download_url";
  public static final String KEY_ERR_MSG = "err_msg";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_NATIVE_APP_ID = "key_native_app_id";
  public static final String KEY_ONLY_OPEN = "key_only_open";
  public static final String KEY_PACKAGE_NAME = "key_package_name";
  public static final String KEY_RET_CODE = "ret_code";
  public static final String KEY_SCENE = "key_scene";
  public static final String TAG = "MiniAppGetAppInfoByIdServlet";
  
  public MiniAppGetNativeAppInfoServlet()
  {
    this.observerId = 1030;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StGetNAppForJumpRsp localStGetNAppForJumpRsp = new INTERFACE.StGetNAppForJumpRsp();
    localStGetNAppForJumpRsp.mergeFrom(paramArrayOfByte);
    if ((localStGetNAppForJumpRsp.appName != null) && (localStGetNAppForJumpRsp.native_appid != null) && (localStGetNAppForJumpRsp.android_pkg != null))
    {
      paramBundle.putString("key_package_name", localStGetNAppForJumpRsp.android_pkg.get());
      paramBundle.putString("key_app_id", localStGetNAppForJumpRsp.appName.get());
      paramBundle.putString("key_native_app_id", localStGetNAppForJumpRsp.native_appid.get());
      paramBundle.putInt("key_only_open", localStGetNAppForJumpRsp.onlyOpen.get());
      paramBundle.putString("key_download_url", localStGetNAppForJumpRsp.android_donwload_url.get());
      notifyObserver(paramIntent, 1030, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1030, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    Object localObject2 = paramIntent.getStringExtra("key_app_id");
    String str1 = paramIntent.getStringExtra("key_native_app_id");
    String str2 = paramIntent.getStringExtra("key_package_name");
    int i = paramIntent.getIntExtra("key_scene", -1);
    int j = paramIntent.getIntExtra("key_index", -1);
    Object localObject1 = null;
    if (arrayOfByte != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      localObject2 = new GetNativeAppInfoRequest((COMM.StCommonExt)localObject1, (String)localObject2, str1, str2, i).encode(paramIntent, j, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_info.GetNAppForJump");
      paramPacket.putSendData(bblm.a((byte[])localObject1));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppGetAppInfoByIdServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetNativeAppInfoServlet
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdRsp;
import android.content.Intent;
import android.os.Bundle;
import bbma;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppGetAppInfoByIdServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_APP_INFO_DATA = "mini_app_info_data";
  public static final String KEY_ENV_VERSION = "key_env_version";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_FIRST_PATH = "key_first_path";
  public static final int NO_REQUIRED = 0;
  public static final int REQUIRED = 1;
  public static final String TAG = "MiniAppGetAppInfoByIdServlet";
  
  public MiniAppGetAppInfoByIdServlet()
  {
    this.observerId = 1024;
  }
  
  private void savaMiniAppInfo(Intent paramIntent, INTERFACE.StGetAppInfoByIdRsp paramStGetAppInfoByIdRsp)
  {
    ThreadManagerV2.excute(new MiniAppGetAppInfoByIdServlet.1(this, paramIntent, paramStGetAppInfoByIdRsp), 32, null, true);
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StGetAppInfoByIdRsp localStGetAppInfoByIdRsp = new INTERFACE.StGetAppInfoByIdRsp();
    localStGetAppInfoByIdRsp.mergeFrom(paramArrayOfByte);
    if (localStGetAppInfoByIdRsp.appInfo != null)
    {
      if (localStGetAppInfoByIdRsp.appInfo.type.get() == 3) {
        savaMiniAppInfo(paramIntent, localStGetAppInfoByIdRsp);
      }
      paramBundle.putSerializable("mini_app_info_data", MiniAppInfo.from(localStGetAppInfoByIdRsp.appInfo));
      notifyObserver(paramIntent, 1024, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1024, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    String str = paramIntent.getStringExtra("key_app_id");
    Object localObject2 = paramIntent.getStringExtra("key_first_path");
    Object localObject3 = paramIntent.getStringExtra("key_env_version");
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    localObject3 = null;
    if (arrayOfByte != null) {
      localObject3 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject3).mergeFrom(arrayOfByte);
      localObject2 = new GetAppInfoByIdRequest((COMM.StCommonExt)localObject3, str, 1, 0, (String)localObject1, (String)localObject2).encode(paramIntent, i, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_info.GetAppInfoById");
      paramPacket.putSendData(bbma.a((byte[])localObject1));
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetAppInfoByIdServlet
 * JD-Core Version:    0.7.0.1
 */
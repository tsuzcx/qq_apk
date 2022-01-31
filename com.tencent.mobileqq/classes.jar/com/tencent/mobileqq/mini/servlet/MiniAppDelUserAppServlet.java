package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StDelUserAppRsp;
import android.content.Intent;
import android.os.Bundle;
import bdku;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppDelUserAppServlet
  extends MiniAppAbstractServlet
{
  public static final String KET_IS_RECOMMEND = "key_is_recommend";
  public static final String KET_NOT_DELTOP = "key_NoDelTop";
  public static final String KET_SOURCE_TYPE = "key_source_type";
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_EXTENDINFO = "key_extendinfo";
  public static final String KEY_VERSION_TYPE = "key_version_type";
  public static final String TAG = "MiniAppDelUserAppServlet";
  
  public MiniAppDelUserAppServlet()
  {
    this.observerId = 1006;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StDelUserAppRsp localStDelUserAppRsp = new INTERFACE.StDelUserAppRsp();
    localStDelUserAppRsp.mergeFrom(paramArrayOfByte);
    if (localStDelUserAppRsp.extInfo != null)
    {
      paramBundle.putByteArray("key_extendinfo", localStDelUserAppRsp.extInfo.toByteArray());
      notifyObserver(paramIntent, 1006, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1006, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getStringExtra("key_appid");
    int i = paramIntent.getIntExtra("key_version_type", 3);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    int j = paramIntent.getIntExtra("key_is_recommend", 0);
    int k = paramIntent.getIntExtra("key_source_type", 1);
    int m = paramIntent.getIntExtra("key_index", -1);
    int n = paramIntent.getIntExtra("key_NoDelTop", 0);
    Object localObject1 = null;
    if (arrayOfByte != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      localObject2 = new DelUserAppRequest((COMM.StCommonExt)localObject1, (String)localObject2, i, j, k, n).encode(paramIntent, m, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_userapp.DelUserApp");
      paramPacket.putSendData(bdku.a((byte[])localObject1));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppDelUserAppServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppDelUserAppServlet
 * JD-Core Version:    0.7.0.1
 */
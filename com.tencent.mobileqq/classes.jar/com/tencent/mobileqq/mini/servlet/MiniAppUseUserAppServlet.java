package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StUseUserAppRsp;
import android.content.Intent;
import android.os.Bundle;
import bdku;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppUseUserAppServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_REFER = "key_refer";
  public static final String KEY_SOURCE = "key_source";
  public static final String KEY_VERSION_TYPE = "key_version_type";
  public static final String KEY_VIA = "key_via";
  public static final String TAG = "MiniAppSetUserAppTopServlet";
  
  public MiniAppUseUserAppServlet()
  {
    this.observerId = 1014;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StUseUserAppRsp localStUseUserAppRsp = new INTERFACE.StUseUserAppRsp();
    localStUseUserAppRsp.mergeFrom(paramArrayOfByte);
    if (localStUseUserAppRsp.extInfo != null)
    {
      paramBundle.putByteArray("key_ext", localStUseUserAppRsp.extInfo.toByteArray());
      notifyObserver(paramIntent, 1014, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1014, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getStringExtra("key_appid");
    int i = paramIntent.getIntExtra("key_version_type", 3);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    int j = paramIntent.getIntExtra("key_source", 1);
    String str1 = paramIntent.getStringExtra("key_refer");
    String str2 = paramIntent.getStringExtra("key_via");
    int k = paramIntent.getIntExtra("key_index", -1);
    Object localObject1 = null;
    if (arrayOfByte != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      localObject2 = new UseUserAppRequest((COMM.StCommonExt)localObject1, (String)localObject2, i, j, str1, str2).encode(paramIntent, k, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_userapp.UseUserApp");
      paramPacket.putSendData(bdku.a((byte[])localObject1));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppSetUserAppTopServlet", 2, "onSend. intent: " + paramIntent.toString());
      }
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppSetUserAppTopServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppUseUserAppServlet
 * JD-Core Version:    0.7.0.1
 */
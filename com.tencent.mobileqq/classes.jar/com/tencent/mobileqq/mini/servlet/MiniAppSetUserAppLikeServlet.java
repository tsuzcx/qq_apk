package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAppLikeRsp;
import android.content.Intent;
import android.os.Bundle;
import bhuf;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppSetUserAppLikeServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_DO_LIKE = "do_like";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_EXTENDINFO = "key_extendinfo";
  public static final String KEY_MINI_APPID = "key_mini_appid";
  public static final String TAG = "MiniAppSetUserAppLikeServlet";
  
  public MiniAppSetUserAppLikeServlet()
  {
    this.observerId = 1009;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StSetUserAppLikeRsp localStSetUserAppLikeRsp = new INTERFACE.StSetUserAppLikeRsp();
    localStSetUserAppLikeRsp.mergeFrom(paramArrayOfByte);
    if (localStSetUserAppLikeRsp.extInfo != null)
    {
      paramBundle.putByteArray("key_extendinfo", localStSetUserAppLikeRsp.extInfo.toByteArray());
      notifyObserver(paramIntent, 1009, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1009, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getStringExtra("key_mini_appid");
    int i = paramIntent.getIntExtra("do_like", 0);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    int j = paramIntent.getIntExtra("key_index", -1);
    Object localObject1 = null;
    if (arrayOfByte != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      localObject2 = new SetUserAppLikeRequest((COMM.StCommonExt)localObject1, (String)localObject2, i).encode(paramIntent, j, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_userapp.SetUserAppLike");
      paramPacket.putSendData(bhuf.a((byte[])localObject1));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppSetUserAppLikeServlet", 2, "onSend. intent: " + paramIntent.toString());
      }
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppSetUserAppLikeServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppSetUserAppLikeServlet
 * JD-Core Version:    0.7.0.1
 */
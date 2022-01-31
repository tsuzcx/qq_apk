package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetUserInfoExtraRsp;
import android.content.Intent;
import android.os.Bundle;
import bbma;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppGetUserInfoExtraServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_ERR_MSG = "err_msg";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_RET_CODE = "ret_code";
  public static final String KEY_RET_ENCRYPT_DATA = "ret_encrypt_data";
  public static final String KEY_RET_IV = "ret_iv";
  public static final String TAG = "MiniAppGetUserInfoExtraServlet";
  
  public MiniAppGetUserInfoExtraServlet()
  {
    this.observerId = 1032;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StGetUserInfoExtraRsp localStGetUserInfoExtraRsp = new INTERFACE.StGetUserInfoExtraRsp();
    localStGetUserInfoExtraRsp.mergeFrom(paramArrayOfByte);
    if (localStGetUserInfoExtraRsp.encryptedData != null)
    {
      paramBundle.putString("ret_encrypt_data", localStGetUserInfoExtraRsp.encryptedData.get());
      paramBundle.putString("ret_iv", localStGetUserInfoExtraRsp.iv.get());
      notifyObserver(paramIntent, 1032, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1032, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    Object localObject2 = paramIntent.getStringExtra("key_appid");
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject1 = null;
    if (arrayOfByte != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      localObject2 = new GetUserInfoExtraRequest((COMM.StCommonExt)localObject1, (String)localObject2).encode(paramIntent, i, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_user_info.GetUserInfoExtra");
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
          QLog.e("MiniAppGetUserInfoExtraServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetUserInfoExtraServlet
 * JD-Core Version:    0.7.0.1
 */
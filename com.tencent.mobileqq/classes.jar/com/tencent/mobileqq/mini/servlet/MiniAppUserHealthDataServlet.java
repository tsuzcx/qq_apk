package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetUserHealthDataRsp;
import android.content.Intent;
import android.os.Bundle;
import bakc;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppUserHealthDataServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_CLOID_ID = "key_clouldId";
  public static final String KEY_ENCRYPTED_DATA = "key_encrypted_data";
  public static final String KEY_EXT_INFO = "key_ext_info";
  public static final String KEY_RET_IV = "key_ret_iv";
  public static final String TAG = "MiniAppUserHealthDataServlet";
  
  public MiniAppUserHealthDataServlet()
  {
    this.observerId = 1041;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StGetUserHealthDataRsp localStGetUserHealthDataRsp = new INTERFACE.StGetUserHealthDataRsp();
    localStGetUserHealthDataRsp.mergeFrom(paramArrayOfByte);
    if (localStGetUserHealthDataRsp.encryptedData != null)
    {
      paramBundle.putString("key_app_id", localStGetUserHealthDataRsp.appid.get());
      paramBundle.putByteArray("key_ext_info", localStGetUserHealthDataRsp.extInfo.toByteArray());
      paramBundle.putString("key_encrypted_data", localStGetUserHealthDataRsp.encryptedData.get());
      paramBundle.putString("key_ret_iv", localStGetUserHealthDataRsp.iv.get());
      paramBundle.putString("key_clouldId", localStGetUserHealthDataRsp.cloudID.get());
      notifyObserver(paramIntent, 1041, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1041, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getStringExtra("key_app_id");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext_info");
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject1 = null;
    if (arrayOfByte != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      localObject2 = new GetUserHealthDataRequest((COMM.StCommonExt)localObject1, (String)localObject2).encode(paramIntent, i, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_user_info.GetUserHealthData");
      paramPacket.putSendData(bakc.a((byte[])localObject1));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppUserHealthDataServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppUserHealthDataServlet
 * JD-Core Version:    0.7.0.1
 */
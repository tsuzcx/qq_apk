package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StUpdateUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import bgau;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppUpdateUserSettingServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_SETTING_INFO = "key_setting_info";
  public static final String TAG = "MiniAppUpdateUserSettingServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess())) {
          continue;
        }
        PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(bgau.b(paramFromServiceMsg.getWupBuffer()));
        new INTERFACE.StUpdateUserSettingRsp().mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppUpdateUserSettingServlet", 2, "onReceive. inform MiniAppUpdateUserSettingServlet resultcode success.");
        }
        notifyObserver(paramIntent, 1052, true, localBundle, MiniAppObserver.class);
      }
      catch (Throwable localThrowable)
      {
        notifyObserver(paramIntent, 1052, true, localBundle, MiniAppObserver.class);
        QLog.e("MiniAppUpdateUserSettingServlet", 1, localThrowable + "onReceive error");
        continue;
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppUpdateUserSettingServlet", 2, "onReceive. inform MiniAppUpdateUserSettingServlet resultcode fail.");
      }
      notifyObserver(paramIntent, 1052, false, localBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = null;
    String str = paramIntent.getStringExtra("key_appid");
    byte[] arrayOfByte2 = paramIntent.getByteArrayExtra("key_ext");
    byte[] arrayOfByte1 = paramIntent.getByteArrayExtra("key_setting_info");
    int i = paramIntent.getIntExtra("key_index", -1);
    if (arrayOfByte2 != null) {}
    for (Object localObject1 = new COMM.StCommonExt();; localObject1 = null) {
      try
      {
        ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte2);
        if (arrayOfByte1 != null) {
          localObject2 = new INTERFACE.StUserSettingInfo();
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        try
        {
          ((INTERFACE.StUserSettingInfo)localObject2).mergeFrom(arrayOfByte1);
          localObject2 = new UpdateUserSettingRequest((COMM.StCommonExt)localObject1, str, (INTERFACE.StUserSettingInfo)localObject2).encode(paramIntent, i, getTraceId());
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new byte[4];
          }
          paramPacket.setSSOCommand("LightAppSvc.mini_user_info.UpdateUserSetting");
          paramPacket.putSendData(bgau.a((byte[])localObject1));
          paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
          super.onSend(paramIntent, paramPacket);
          return;
          localInvalidProtocolBufferMicroException2 = localInvalidProtocolBufferMicroException2;
          if (QLog.isColorLevel()) {
            QLog.e("MiniAppUpdateUserSettingServlet", 2, "onSend. mergeFrom extData exception!");
          }
          localInvalidProtocolBufferMicroException2.printStackTrace();
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MiniAppUpdateUserSettingServlet", 2, "onSend. mergeFrom authData exception!");
            }
            localInvalidProtocolBufferMicroException1.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppUpdateUserSettingServlet
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import bhjl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppSendArkMsgServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_API_NAME = "key_api_name";
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_ARK_JSON = "key_ark_json";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_OPENID = "key_openid";
  public static final String TAG = "MiniAppSendArkMsgServlet";
  private int index;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppSendArkMsgServlet", 2, "onReceive.");
    }
    localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
        if (paramFromServiceMsg == null) {
          continue;
        }
        localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(bhjl.b(paramFromServiceMsg.getWupBuffer()));
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        if (!paramFromServiceMsg.isSuccess()) {
          continue;
        }
        localBundle.putParcelable("sendArkMsg", paramFromServiceMsg);
        localBundle.putLong("retCode", localStQWebRsp.retCode.get());
        localBundle.putString("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        notifyObserver(paramIntent, 1061, true, localBundle, MiniAppObserver.class);
      }
      catch (Throwable localThrowable)
      {
        PROTOCAL.StQWebRsp localStQWebRsp;
        QLog.e("MiniAppSendArkMsgServlet", 1, localThrowable + "onReceive error");
        localBundle.putInt("key_index", this.index);
        notifyObserver(paramIntent, 1061, false, localBundle, MiniAppObserver.class);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MiniAppSendArkMsgServlet", 2, "onReceive. inform MiniAppSendArkMsgServlet resultcode fail.");
        notifyObserver(paramIntent, 1061, false, localBundle, MiniAppObserver.class);
        continue;
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppSendArkMsgServlet", 2, "onReceive. MiniAppSendArkMsgServlet rsp = " + localStQWebRsp);
      }
      notifyObserver(paramIntent, 1061, false, localBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    this.index = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    Object localObject2 = paramIntent.getStringExtra("key_openid");
    String str1 = paramIntent.getStringExtra("key_ark_json");
    String str2 = paramIntent.getStringExtra("key_appid");
    String str3 = paramIntent.getStringExtra("key_api_name");
    Object localObject1 = null;
    if (arrayOfByte != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      localObject2 = new MiniAppSendArkMsgRequest((COMM.StCommonExt)localObject1, str2, (String)localObject2, str1, str3).encode(paramIntent, this.index, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_share.SendArkMsg");
      paramPacket.putSendData(bhjl.a((byte[])localObject1));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppSendArkMsgServlet", 2, "onSend. mergeFrom extData exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppSendArkMsgServlet
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import bblm;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.Packet;

public class ModifyFriendInteractiveStorageServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_OPERATION = "key_operation";
  public static final String KEY_OPNUM = "key_opnum";
  public static final String KEY_SHARE_ID = "KEY_SHARE_ID";
  public static final String KEY_TO_USER = "key_to_user";
  public static final String TAG = "ModifyFriendInteractiveStorageServlet";
  private int index;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ModifyFriendInteractiveStorageServlet", 2, "onReceive.");
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
        localStQWebRsp.mergeFrom(bblm.b(paramFromServiceMsg.getWupBuffer()));
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        if (!paramFromServiceMsg.isSuccess()) {
          continue;
        }
        localBundle.putParcelable("modifyFriendInteractiveStorage", paramFromServiceMsg);
        localBundle.putLong("retCode", localStQWebRsp.retCode.get());
        localBundle.putString("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        notifyObserver(paramIntent, 1058, true, localBundle, MiniAppObserver.class);
      }
      catch (Throwable localThrowable)
      {
        PROTOCAL.StQWebRsp localStQWebRsp;
        QLog.e("ModifyFriendInteractiveStorageServlet", 1, localThrowable + "onReceive error");
        localBundle.putInt("key_index", this.index);
        notifyObserver(paramIntent, 1058, false, localBundle, MiniAppObserver.class);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ModifyFriendInteractiveStorageServlet", 2, "onReceive. inform MiniRewardedVideoAdServlet resultcode fail.");
        notifyObserver(paramIntent, 1058, false, localBundle, MiniAppObserver.class);
        continue;
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ModifyFriendInteractiveStorageServlet", 2, "onReceive. MiniRewardedVideoAdServlet rsp = " + localStQWebRsp);
      }
      notifyObserver(paramIntent, 1058, false, localBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    this.index = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    Object localObject2 = paramIntent.getStringExtra("key_to_user");
    String str1 = paramIntent.getStringExtra("KEY_SHARE_ID");
    String str2 = paramIntent.getStringExtra("key_appid");
    int i = paramIntent.getIntExtra("key_opnum", -1);
    String str3 = paramIntent.getStringExtra("key_operation");
    HashMap localHashMap = (HashMap)paramIntent.getSerializableExtra("key_data");
    Object localObject1 = null;
    if (arrayOfByte != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      localObject2 = new ModifyFriendInteractiveStorageReq((COMM.StCommonExt)localObject1, str2, (String)localObject2, str1, i, str3, localHashMap).encode(paramIntent, this.index, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_cloudstorage.ModifyFriendInteractiveStorage");
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
          QLog.e("ModifyFriendInteractiveStorageServlet", 2, "onSend. mergeFrom extData exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.ModifyFriendInteractiveStorageServlet
 * JD-Core Version:    0.7.0.1
 */
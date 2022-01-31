package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import bbma;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppGetSwitchListServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_ERR_MSG = "errMsg";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_GET_SWITCH_LIST = "getSwitchList";
  public static final String KEY_RET_CODE = "retCode";
  public static final String TAG = "MiniAppGetSwitchListServlet";
  private int index;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppGetSwitchListServlet", 2, "onReceive.");
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
        localStQWebRsp.mergeFrom(bbma.b(paramFromServiceMsg.getWupBuffer()));
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        if (!paramFromServiceMsg.isSuccess()) {
          continue;
        }
        localBundle.putParcelable("getSwitchList", paramFromServiceMsg);
        localBundle.putLong("retCode", localStQWebRsp.retCode.get());
        localBundle.putString("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        notifyObserver(paramIntent, 1049, true, localBundle, MiniAppObserver.class);
      }
      catch (Throwable localThrowable)
      {
        PROTOCAL.StQWebRsp localStQWebRsp;
        QLog.e("MiniAppGetSwitchListServlet", 1, localThrowable + "onReceive error");
        localBundle.putInt("key_index", this.index);
        notifyObserver(paramIntent, 1049, false, localBundle, MiniAppObserver.class);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MiniAppGetSwitchListServlet", 2, "onReceive. inform MiniAppGetSwitchListServlet resultcode fail.");
        notifyObserver(paramIntent, 1049, false, localBundle, MiniAppObserver.class);
        continue;
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppGetSwitchListServlet", 2, "onReceive. MiniAppGetSwitchListServlet rsp = " + localStQWebRsp);
      }
      notifyObserver(paramIntent, 1049, false, localBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    this.index = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    Object localObject = null;
    if (arrayOfByte != null) {
      localObject = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject).mergeFrom(arrayOfByte);
      arrayOfByte = new MiniAppGetSwitchListRequest((COMM.StCommonExt)localObject).encode(paramIntent, this.index, getTraceId());
      localObject = arrayOfByte;
      if (arrayOfByte == null) {
        localObject = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_user_info.GetSwitchList");
      paramPacket.putSendData(bbma.a((byte[])localObject));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppGetSwitchListServlet", 2, "onSend. mergeFrom extData exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetSwitchListServlet
 * JD-Core Version:    0.7.0.1
 */
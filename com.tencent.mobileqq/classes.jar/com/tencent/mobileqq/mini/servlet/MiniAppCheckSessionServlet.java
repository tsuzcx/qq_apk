package com.tencent.mobileqq.mini.servlet;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import bhuf;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppCheckSessionServlet
  extends MiniAppAbstractServlet
{
  public static final String TAG = "MiniAppCheckSessionServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
        if (paramFromServiceMsg == null) {
          continue;
        }
        if (!paramFromServiceMsg.isSuccess()) {
          continue;
        }
        PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(bhuf.b(paramFromServiceMsg.getWupBuffer()));
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        if ((localStQWebRsp.retCode == null) || (localStQWebRsp.errMsg == null)) {
          continue;
        }
        localBundle.putLong("ret", localStQWebRsp.retCode.get());
        localBundle.putString("errMsg", localStQWebRsp.errMsg.get().toString());
        notifyObserver(paramIntent, 1002, true, localBundle, MiniAppObserver.class);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniAppCheckSessionServlet", 1, localThrowable + "onReceive error");
        notifyObserver(paramIntent, 1002, false, localBundle, MiniAppObserver.class);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MiniAppCheckSessionServlet", 2, "inform MiniAppGetLoginCodeServlet isSuccess false");
        notifyObserver(paramIntent, 1002, false, localBundle, MiniAppObserver.class);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MiniAppCheckSessionServlet", 2, "inform QZoneGetGroupCountServlet resultcode fail.");
        notifyObserver(paramIntent, 1002, false, localBundle, MiniAppObserver.class);
        continue;
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      notifyObserver(paramIntent, 1002, false, localBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = paramIntent.getStringExtra("key_appid");
    long l = paramIntent.getLongExtra("key_uin", 0L);
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = new CheckSessionRequest(Long.valueOf(l).longValue(), (String)localObject).encode(paramIntent, i, getTraceId());
    localObject = arrayOfByte;
    if (arrayOfByte == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_program_auth.CheckSession");
    paramPacket.putSendData(bhuf.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppCheckSessionServlet
 * JD-Core Version:    0.7.0.1
 */
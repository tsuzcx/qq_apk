package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppLocalSearchDataServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_EXT = "key_ext";
  public static final String TAG = "MiniAppLocalSearchDataServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
      if (paramFromServiceMsg != null)
      {
        localObject = new PROTOCAL.StQWebRsp();
        ((PROTOCAL.StQWebRsp)localObject).mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
        localBundle.putInt("key_index", (int)((PROTOCAL.StQWebRsp)localObject).Seq.get());
        if (paramFromServiceMsg.isSuccess())
        {
          localBundle.putParcelable("localSearchData", paramFromServiceMsg);
          notifyObserver(paramIntent, 1011, true, localBundle, MiniAppObserver.class);
        }
        else
        {
          notifyObserver(paramIntent, 1011, false, localBundle, MiniAppObserver.class);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppLocalSearchDataServlet", 2, "onReceive. inform MiniAppLocalSearchDataServlet resultcode fail.");
        }
        notifyObserver(null, 1011, false, null, MiniAppObserver.class);
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localThrowable);
      ((StringBuilder)localObject).append("onReceive error");
      QLog.e("MiniAppLocalSearchDataServlet", 1, ((StringBuilder)localObject).toString());
      notifyObserver(null, 1011, false, null, MiniAppObserver.class);
    }
    doReport(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte1 = paramIntent.getByteArrayExtra("key_ext");
    if (arrayOfByte1 != null)
    {
      localObject = new COMM.StCommonExt();
      try
      {
        ((COMM.StCommonExt)localObject).mergeFrom(arrayOfByte1);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppLocalSearchDataServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    else
    {
      localObject = null;
    }
    byte[] arrayOfByte2 = new LocalSearchDataRequest((COMM.StCommonExt)localObject).encode(paramIntent, i, getTraceId());
    Object localObject = arrayOfByte2;
    if (arrayOfByte2 == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_search.LocalSearchData");
    paramPacket.putSendData(WupUtil.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppLocalSearchDataServlet
 * JD-Core Version:    0.7.0.1
 */
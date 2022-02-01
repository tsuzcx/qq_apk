package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppGetGroupShareInfoServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_EXTENDINFO = "key_extendinfo";
  public static final String KEY_SHARETICKET = "key_shareTicket";
  public static final String TAG = "MiniAppGetGroupShareInfoServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
      if (paramFromServiceMsg != null)
      {
        PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        if (paramFromServiceMsg.isSuccess())
        {
          localBundle.putParcelable("getGroupShareInfo", paramFromServiceMsg);
          localBundle.putInt("getGroupShareInfoRetCode", (int)localStQWebRsp.retCode.get());
          localBundle.putString("getGroupShareInfoErrMsg", localStQWebRsp.errMsg.get().toStringUtf8());
          notifyObserver(paramIntent, 1033, true, localBundle, MiniAppObserver.class);
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onReceive. MiniAppGetGroupShareInfoServlet rsp = ");
            localStringBuilder.append(localStQWebRsp);
            QLog.d("MiniAppGetGroupShareInfoServlet", 2, localStringBuilder.toString());
          }
          notifyObserver(null, 1033, false, localBundle, MiniAppObserver.class);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppGetGroupShareInfoServlet", 2, "onReceive. inform MiniAppGetGroupShareInfoServlet resultcode fail.");
        }
        notifyObserver(null, 1033, false, localBundle, MiniAppObserver.class);
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localThrowable);
      localStringBuilder.append("onReceive error");
      QLog.e("MiniAppGetGroupShareInfoServlet", 1, localStringBuilder.toString());
      notifyObserver(null, 1033, false, localBundle, MiniAppObserver.class);
    }
    doReport(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject2 = paramIntent.getStringExtra("key_appid");
    String str = paramIntent.getStringExtra("key_shareTicket");
    if (arrayOfByte != null)
    {
      localObject1 = new COMM.StCommonExt();
      try
      {
        ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppGetGroupShareInfoServlet", 2, "onSend. mergeFrom extData exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    else
    {
      localObject1 = null;
    }
    localObject2 = new MiniAppGetGroupShareInfoRequest((COMM.StCommonExt)localObject1, (String)localObject2, str).encode(paramIntent, i, getTraceId());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_share.GetGroupShareInfo");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetGroupShareInfoServlet
 * JD-Core Version:    0.7.0.1
 */
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

public class GetReactiveFriendListServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_EXT = "key_ext";
  public static final String TAG = "GetReactiveFriendListServlet";
  private int index;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetReactiveFriendListServlet", 2, "onReceive.");
    }
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
          localBundle.putParcelable("getReactiveFriendList", paramFromServiceMsg);
          localBundle.putLong("retCode", localStQWebRsp.retCode.get());
          localBundle.putString("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
          notifyObserver(paramIntent, 1084, true, localBundle, MiniAppObserver.class);
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onReceive. getReactiveFriendList rsp = ");
            localStringBuilder.append(localStQWebRsp);
            QLog.d("GetReactiveFriendListServlet", 2, localStringBuilder.toString());
          }
          notifyObserver(paramIntent, 1084, false, localBundle, MiniAppObserver.class);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("GetReactiveFriendListServlet", 2, "onReceive. inform getReactiveFriendList resultcode fail.");
        }
        notifyObserver(paramIntent, 1084, false, localBundle, MiniAppObserver.class);
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localThrowable);
      localStringBuilder.append("onReceive error");
      QLog.e("GetReactiveFriendListServlet", 1, localStringBuilder.toString());
      localBundle.putInt("key_index", this.index);
      notifyObserver(paramIntent, 1084, false, localBundle, MiniAppObserver.class);
    }
    doReport(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    this.index = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    Object localObject2 = paramIntent.getStringExtra("key_appid");
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
          QLog.e("GetReactiveFriendListServlet", 2, "onSend. mergeFrom extData exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    else
    {
      localObject1 = null;
    }
    localObject2 = new GetReactiveFriendListRequest((COMM.StCommonExt)localObject1, (String)localObject2).encode(paramIntent, this.index, getTraceId());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_cloudstorage.GetReactiveFriendList");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetReactiveFriendListServlet
 * JD-Core Version:    0.7.0.1
 */
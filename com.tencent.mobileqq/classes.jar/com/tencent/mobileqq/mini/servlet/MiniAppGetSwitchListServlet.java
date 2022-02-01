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
          localBundle.putParcelable("getSwitchList", paramFromServiceMsg);
          localBundle.putLong("retCode", localStQWebRsp.retCode.get());
          localBundle.putString("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
          notifyObserver(paramIntent, 1049, true, localBundle, MiniAppObserver.class);
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onReceive. MiniAppGetSwitchListServlet rsp = ");
            localStringBuilder.append(localStQWebRsp);
            QLog.d("MiniAppGetSwitchListServlet", 2, localStringBuilder.toString());
          }
          notifyObserver(paramIntent, 1049, false, localBundle, MiniAppObserver.class);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppGetSwitchListServlet", 2, "onReceive. inform MiniAppGetSwitchListServlet resultcode fail.");
        }
        notifyObserver(paramIntent, 1049, false, localBundle, MiniAppObserver.class);
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localThrowable);
      localStringBuilder.append("onReceive error");
      QLog.e("MiniAppGetSwitchListServlet", 1, localStringBuilder.toString());
      localBundle.putInt("key_index", this.index);
      notifyObserver(paramIntent, 1049, false, localBundle, MiniAppObserver.class);
    }
    doReport(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    this.index = paramIntent.getIntExtra("key_index", -1);
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
          QLog.e("MiniAppGetSwitchListServlet", 2, "onSend. mergeFrom extData exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    else
    {
      localObject = null;
    }
    byte[] arrayOfByte2 = new MiniAppGetSwitchListRequest((COMM.StCommonExt)localObject).encode(paramIntent, this.index, getTraceId());
    Object localObject = arrayOfByte2;
    if (arrayOfByte2 == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_user_info.GetSwitchList");
    paramPacket.putSendData(WupUtil.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetSwitchListServlet
 * JD-Core Version:    0.7.0.1
 */
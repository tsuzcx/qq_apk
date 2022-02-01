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
import java.util.List;
import mqq.app.Packet;

public class MiniAppBatchQueryAppInfoServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID_LIST = "key_appid_list";
  public static final String KEY_EXT = "key_ext";
  public static final String TAG = "MiniAppBatchQueryAppInfoServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
      if (paramFromServiceMsg != null)
      {
        if (paramFromServiceMsg.isSuccess())
        {
          PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
          localStQWebRsp.mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
          localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
          localBundle.putParcelable("batchQueryAppInfo", paramFromServiceMsg);
          notifyObserver(paramIntent, 1013, true, localBundle, MiniAppObserver.class);
        }
        else
        {
          localBundle.putLong("ret_code", paramFromServiceMsg.getBusinessFailCode());
          localBundle.putString("err_msg", paramFromServiceMsg.getBusinessFailMsg());
          notifyObserver(paramIntent, 1013, false, localBundle, MiniAppObserver.class);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppBatchQueryAppInfoServlet", 2, "onReceive. inform MiniAppBatchQueryAppInfoServlet resultcode fail.");
        }
        notifyObserver(paramIntent, 1013, false, localBundle, MiniAppObserver.class);
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localThrowable);
      localStringBuilder.append("onReceive error");
      QLog.e("MiniAppBatchQueryAppInfoServlet", 1, localStringBuilder.toString());
      notifyObserver(paramIntent, 1013, false, localBundle, MiniAppObserver.class);
    }
    doReport(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject2 = paramIntent.getStringArrayListExtra("key_appid_list");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
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
          QLog.e("MiniAppBatchQueryAppInfoServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    else
    {
      localObject1 = null;
    }
    localObject2 = new BatchQueryAppInfoRequest((COMM.StCommonExt)localObject1, (List)localObject2).encode(paramIntent, i, getTraceId());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_info.BatchQueryAppInfo");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppBatchQueryAppInfoServlet
 * JD-Core Version:    0.7.0.1
 */
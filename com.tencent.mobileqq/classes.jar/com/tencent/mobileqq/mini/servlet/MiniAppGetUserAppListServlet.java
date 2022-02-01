package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetUserAppListRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import bgau;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppGetUserAppListServlet
  extends MiniAppAbstractServlet
{
  public static final int GET_USER_APP_LIST = 1;
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_NUM = "key_num";
  public static final String KEY_UIN = "key_uin";
  public static final String TAG = "MiniAppGetUserAppListServlet";
  
  private void savaMiniAppInfo(INTERFACE.StGetUserAppListRsp paramStGetUserAppListRsp)
  {
    ThreadManagerV2.excute(new MiniAppGetUserAppListServlet.1(this, paramStGetUserAppListRsp), 32, null, true);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = new Bundle();
    for (;;)
    {
      try
      {
        ((Bundle)localObject).putInt("key_index", paramIntent.getIntExtra("key_index", -1));
        if (paramFromServiceMsg == null) {
          continue;
        }
        if (!paramFromServiceMsg.isSuccess()) {
          continue;
        }
        PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(bgau.b(paramFromServiceMsg.getWupBuffer()));
        ((Bundle)localObject).putInt("key_index", (int)localStQWebRsp.Seq.get());
        ((Bundle)localObject).putLong("retCode", localStQWebRsp.retCode.get());
        ((Bundle)localObject).putString("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        ((Bundle)localObject).putParcelable("getUserAppList", paramFromServiceMsg);
        notifyObserver(paramIntent, 1010, true, (Bundle)localObject, MiniAppObserver.class);
        localObject = new INTERFACE.StGetUserAppListRsp();
        ((INTERFACE.StGetUserAppListRsp)localObject).mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
        savaMiniAppInfo((INTERFACE.StGetUserAppListRsp)localObject);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniAppGetUserAppListServlet", 1, localThrowable + ", onReceive exception: " + Log.getStackTraceString(localThrowable));
        continue;
        QLog.e("MiniAppGetUserAppListServlet", 1, "onReceive. inform MiniAppGetUserAppListServlet response is null.");
        continue;
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      ((Bundle)localObject).putLong("retCode", paramFromServiceMsg.getBusinessFailCode());
      ((Bundle)localObject).putString("errMsg", paramFromServiceMsg.getBusinessFailMsg());
      notifyObserver(paramIntent, 1010, false, (Bundle)localObject, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    long l1 = paramIntent.getLongExtra("key_uin", 0L);
    long l2 = paramIntent.getLongExtra("key_num", 10L);
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    Object localObject = null;
    if (arrayOfByte != null) {
      localObject = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject).mergeFrom(arrayOfByte);
      arrayOfByte = new GetUserAppListRequest((COMM.StCommonExt)localObject, l1, l2).encode(paramIntent, i, getTraceId());
      localObject = arrayOfByte;
      if (arrayOfByte == null) {
        localObject = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_userapp.GetUserAppList");
      paramPacket.putSendData(bgau.a((byte[])localObject));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppGetUserAppListServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetUserAppListServlet
 * JD-Core Version:    0.7.0.1
 */
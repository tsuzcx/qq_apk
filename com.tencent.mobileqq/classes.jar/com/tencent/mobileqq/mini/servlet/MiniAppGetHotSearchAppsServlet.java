package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppGetHotSearchAppsServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_EXT_INFO = "key_hot_search_ext_info";
  public static final String KEY_GET_HOT_SEARCH_APPS = "getHotSearchApps";
  public static final String KEY_GET_HOT_SEARCH_APPS_RSP = "getHotSearchAppsResponse";
  public static final String TAG = "MiniAppGetHotSearchAppsServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
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
        localStQWebRsp.mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        localBundle.putLong("retCode", localStQWebRsp.retCode.get());
        localBundle.putString("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        localBundle.putParcelable("getHotSearchApps", paramFromServiceMsg);
        notifyObserver(paramIntent, 1071, true, localBundle, MiniAppObserver.class);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniAppGetHotSearchAppsServlet", 1, localThrowable + ", onReceive exception: " + Log.getStackTraceString(localThrowable));
        continue;
        QLog.e("MiniAppGetHotSearchAppsServlet", 1, "onReceive. inform MiniAppGetHotSearchAppsServlet response is null.");
        continue;
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      localBundle.putLong("retCode", paramFromServiceMsg.getBusinessFailCode());
      localBundle.putString("errMsg", paramFromServiceMsg.getBusinessFailMsg());
      notifyObserver(paramIntent, 1071, false, localBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_hot_search_ext_info");
    Object localObject = null;
    if (arrayOfByte != null) {
      localObject = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject).mergeFrom(arrayOfByte);
      arrayOfByte = new GetHotSearchAppsRequest((COMM.StCommonExt)localObject).encode(paramIntent, i, getTraceId());
      localObject = arrayOfByte;
      if (arrayOfByte == null) {
        localObject = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.store_app_search.GetHotSearchApps");
      paramPacket.putSendData(WupUtil.a((byte[])localObject));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MiniAppGetHotSearchAppsServlet", 2, "onSend. mergeFrom exception!" + Log.getStackTraceString(localException));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetHotSearchAppsServlet
 * JD-Core Version:    0.7.0.1
 */
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
    try
    {
      localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
      if (paramFromServiceMsg != null)
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        if (bool)
        {
          localObject = new PROTOCAL.StQWebRsp();
          ((PROTOCAL.StQWebRsp)localObject).mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
          localBundle.putInt("key_index", (int)((PROTOCAL.StQWebRsp)localObject).Seq.get());
          localBundle.putLong("retCode", ((PROTOCAL.StQWebRsp)localObject).retCode.get());
          localBundle.putString("errMsg", ((PROTOCAL.StQWebRsp)localObject).errMsg.get().toStringUtf8());
          localBundle.putParcelable("getHotSearchApps", paramFromServiceMsg);
          notifyObserver(paramIntent, 1071, true, localBundle, MiniAppObserver.class);
        }
        else
        {
          localBundle.putLong("retCode", paramFromServiceMsg.getBusinessFailCode());
          localBundle.putString("errMsg", paramFromServiceMsg.getBusinessFailMsg());
          notifyObserver(paramIntent, 1071, false, localBundle, MiniAppObserver.class);
        }
      }
      else
      {
        QLog.e("MiniAppGetHotSearchAppsServlet", 1, "onReceive. inform MiniAppGetHotSearchAppsServlet response is null.");
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localThrowable);
      ((StringBuilder)localObject).append(", onReceive exception: ");
      ((StringBuilder)localObject).append(Log.getStackTraceString(localThrowable));
      QLog.e("MiniAppGetHotSearchAppsServlet", 1, ((StringBuilder)localObject).toString());
    }
    doReport(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte1 = paramIntent.getByteArrayExtra("key_hot_search_ext_info");
    if (arrayOfByte1 != null)
    {
      localObject = new COMM.StCommonExt();
      try
      {
        ((COMM.StCommonExt)localObject).mergeFrom(arrayOfByte1);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSend. mergeFrom exception!");
        localStringBuilder.append(Log.getStackTraceString(localException));
        QLog.e("MiniAppGetHotSearchAppsServlet", 2, localStringBuilder.toString());
      }
    }
    else
    {
      localObject = null;
    }
    byte[] arrayOfByte2 = new GetHotSearchAppsRequest((COMM.StCommonExt)localObject).encode(paramIntent, i, getTraceId());
    Object localObject = arrayOfByte2;
    if (arrayOfByte2 == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.store_app_search.GetHotSearchApps");
    paramPacket.putSendData(WupUtil.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetHotSearchAppsServlet
 * JD-Core Version:    0.7.0.1
 */
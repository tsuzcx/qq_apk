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

public class MiniAppGuessYouLikeServlet
  extends MiniAppAbstractServlet
{
  public static final int DEFAULT_COUNT = 8;
  public static final String KEY_EXT_INFO = "key_search_guess_you_like_ext_info";
  public static final String KEY_SEARCH_GUESS_YOU_LIKE = "searchGuessYouLike";
  public static final String KEY_SEARCH_GUESS_YOU_LIKE_COUNT = "searchGuessYouLikeCount";
  public static final String KEY_SEARCH_GUESS_YOU_LIKE_RSP = "searchGuessYouLikeResponse";
  public static final String TAG = "MiniAppGuessYouLikeServlet";
  
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
          localBundle.putParcelable("searchGuessYouLike", paramFromServiceMsg);
          notifyObserver(paramIntent, 1086, true, localBundle, MiniAppObserver.class);
        }
        else
        {
          localBundle.putLong("retCode", paramFromServiceMsg.getBusinessFailCode());
          localBundle.putString("errMsg", paramFromServiceMsg.getBusinessFailMsg());
          notifyObserver(paramIntent, 1086, false, localBundle, MiniAppObserver.class);
        }
      }
      else
      {
        QLog.e("MiniAppGuessYouLikeServlet", 1, "onReceive. inform MiniAppGuessYouLikeServlet response is null.");
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localThrowable);
      ((StringBuilder)localObject).append(", onReceive exception: ");
      ((StringBuilder)localObject).append(Log.getStackTraceString(localThrowable));
      QLog.e("MiniAppGuessYouLikeServlet", 1, ((StringBuilder)localObject).toString());
    }
    doReport(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte1 = paramIntent.getByteArrayExtra("key_search_guess_you_like_ext_info");
    int j = paramIntent.getIntExtra("searchGuessYouLikeCount", 8);
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
        QLog.e("MiniAppGuessYouLikeServlet", 2, localStringBuilder.toString());
      }
    }
    else
    {
      localObject = null;
    }
    byte[] arrayOfByte2 = new GuessYouLikeRequest((COMM.StCommonExt)localObject, j).encode(paramIntent, i, getTraceId());
    Object localObject = arrayOfByte2;
    if (arrayOfByte2 == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.store_app_search.GetGuessYouLike");
    paramPacket.putSendData(WupUtil.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGuessYouLikeServlet
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import bdku;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniMidasQueryServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_EXTENDINFO = "key_extendinfo";
  public static final String KEY_PREPAY_ID = "key_prepay_id";
  public static final String KEY_SET_ENV = "key_set_env";
  public static final String KEY_STAR_CURRENCY = "key_star_currency";
  public static final String TAG = "MiniMidasQueryServlet";
  
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
        localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(bdku.b(paramFromServiceMsg.getWupBuffer()));
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        if (!paramFromServiceMsg.isSuccess()) {
          continue;
        }
        localBundle.putParcelable("getMidasQueryResult", paramFromServiceMsg);
        localBundle.putInt("getMidasQueryResultRetCode", (int)localStQWebRsp.retCode.get());
        localBundle.putString("getMidasQueryResultErrMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        notifyObserver(paramIntent, 1026, true, localBundle, MiniAppObserver.class);
      }
      catch (Throwable localThrowable)
      {
        PROTOCAL.StQWebRsp localStQWebRsp;
        QLog.e("MiniMidasQueryServlet", 1, localThrowable + "onReceive error");
        notifyObserver(paramIntent, 1025, false, localBundle, MiniAppObserver.class);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MiniMidasQueryServlet", 2, "onReceive. inform MiniAppPayServlet resultcode fail.");
        notifyObserver(paramIntent, 1025, false, localBundle, MiniAppObserver.class);
        continue;
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MiniMidasQueryServlet", 2, "onReceive. MiniAppPayServlet rsp = " + localStQWebRsp);
      }
      notifyObserver(paramIntent, 1026, false, localBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getStringExtra("key_prepay_id");
    int i = paramIntent.getIntExtra("key_star_currency", 0);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    int j = paramIntent.getIntExtra("key_index", -1);
    String str = paramIntent.getStringExtra("key_appid");
    int k = paramIntent.getIntExtra("key_set_env", 0);
    Object localObject1 = null;
    if (arrayOfByte != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      localObject2 = new QueryCurrencyRequest((COMM.StCommonExt)localObject1, str, (String)localObject2, i, k).encode(paramIntent, j, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_pay.QueryStarCurrency");
      paramPacket.putSendData(bdku.a((byte[])localObject1));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniMidasQueryServlet", 2, "onSend. mergeFrom extData exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniMidasQueryServlet
 * JD-Core Version:    0.7.0.1
 */
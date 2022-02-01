package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
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
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
      if (paramFromServiceMsg != null)
      {
        PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
        if (paramFromServiceMsg.isSuccess())
        {
          localBundle.putParcelable("getMidasQueryResult", paramFromServiceMsg);
          localBundle.putInt("getMidasQueryResultRetCode", (int)localStQWebRsp.retCode.get());
          localBundle.putString("getMidasQueryResultErrMsg", localStQWebRsp.errMsg.get().toStringUtf8());
          notifyObserver(paramIntent, 1026, true, localBundle, MiniAppObserver.class);
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onReceive. MiniAppPayServlet rsp = ");
            localStringBuilder.append(localStQWebRsp);
            QLog.d("MiniMidasQueryServlet", 2, localStringBuilder.toString());
          }
          notifyObserver(paramIntent, 1026, false, localBundle, MiniAppObserver.class);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniMidasQueryServlet", 2, "onReceive. inform MiniAppPayServlet resultcode fail.");
        }
        notifyObserver(paramIntent, 1025, false, localBundle, MiniAppObserver.class);
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localThrowable);
      localStringBuilder.append("onReceive error");
      QLog.e("MiniMidasQueryServlet", 1, localStringBuilder.toString());
      notifyObserver(paramIntent, 1025, false, localBundle, MiniAppObserver.class);
    }
    doReport(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getStringExtra("key_prepay_id");
    int i = paramIntent.getIntExtra("key_star_currency", 0);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    int j = paramIntent.getIntExtra("key_index", -1);
    String str = paramIntent.getStringExtra("key_appid");
    int k = paramIntent.getIntExtra("key_set_env", 0);
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
          QLog.e("MiniMidasQueryServlet", 2, "onSend. mergeFrom extData exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    else
    {
      localObject1 = null;
    }
    localObject2 = new QueryCurrencyRequest((COMM.StCommonExt)localObject1, str, (String)localObject2, i, k).encode(paramIntent, j, getTraceId());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_pay.QueryStarCurrency");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniMidasQueryServlet
 * JD-Core Version:    0.7.0.1
 */
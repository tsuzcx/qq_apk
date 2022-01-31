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

public class MiniMidasConsumeServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_BALANCE_AMOUNT = "key_balance_amount";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_EXTENDINFO = "key_extendinfo";
  public static final String KEY_PAY_CHANNEL = "key_pay_channel";
  public static final String KEY_PAY_ENV = "key_pay_env";
  public static final String KEY_PREPAY_ID = "key_prepay_id";
  public static final String KEY_STAR_CURRENCY = "key_star_currency";
  public static final String KEY_TOPUP_AMOUNT = "key_topup_amount";
  public static final String TAG = "MiniMidasConsumeServlet";
  
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
        localBundle.putParcelable("getMidasConsumeResult", paramFromServiceMsg);
        localBundle.putInt("getMidasConsumeResultRetCode", (int)localStQWebRsp.retCode.get());
        localBundle.putString("getMidasConsumeResultErrMsg", localStQWebRsp.errMsg.get().toStringUtf8());
        notifyObserver(paramIntent, 1025, true, localBundle, MiniAppObserver.class);
      }
      catch (Throwable localThrowable)
      {
        PROTOCAL.StQWebRsp localStQWebRsp;
        QLog.e("MiniMidasConsumeServlet", 1, localThrowable + "onReceive error");
        notifyObserver(paramIntent, 1025, false, localBundle, MiniAppObserver.class);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MiniMidasConsumeServlet", 2, "onReceive. inform MiniAppPayServlet resultcode fail.");
        notifyObserver(paramIntent, 1025, false, localBundle, MiniAppObserver.class);
        continue;
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MiniMidasConsumeServlet", 2, "onReceive. MiniAppPayServlet rsp = " + localStQWebRsp);
      }
      notifyObserver(paramIntent, 1025, false, localBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getStringExtra("key_appid");
    String str = paramIntent.getStringExtra("key_prepay_id");
    int i = paramIntent.getIntExtra("key_star_currency", 0);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    int j = paramIntent.getIntExtra("key_index", -1);
    int k = paramIntent.getIntExtra("key_balance_amount", -1);
    int m = paramIntent.getIntExtra("key_topup_amount", -1);
    int n = paramIntent.getIntExtra("key_pay_channel", -1);
    int i1 = paramIntent.getIntExtra("key_pay_env", 0);
    Object localObject1 = null;
    if (arrayOfByte != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      localObject2 = new PayRequest((String)localObject2, (COMM.StCommonExt)localObject1, str, i, k, m, n, i1).encode(paramIntent, j, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_pay.GamePay");
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
          QLog.e("MiniMidasConsumeServlet", 2, "onSend. mergeFrom extData exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniMidasConsumeServlet
 * JD-Core Version:    0.7.0.1
 */
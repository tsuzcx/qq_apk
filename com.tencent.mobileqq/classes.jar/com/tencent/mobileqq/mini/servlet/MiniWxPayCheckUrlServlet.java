package com.tencent.mobileqq.mini.servlet;

import NS_MINI_APP_PAY.MiniAppMidasPay.StWxpayCheckMWebURLRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniWxPayCheckUrlServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_URL = "key_url";
  public static final String KEY_URL_VALID = "key_url_valid";
  public static final String TAG = "MiniWxPayCheckUrlServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
      if (paramFromServiceMsg != null)
      {
        Object localObject1 = new PROTOCAL.StQWebRsp();
        localObject2 = WupUtil.b(paramFromServiceMsg.getWupBuffer());
        ((PROTOCAL.StQWebRsp)localObject1).mergeFrom((byte[])localObject2);
        if (paramFromServiceMsg.isSuccess())
        {
          localBundle.putInt("retCode", (int)((PROTOCAL.StQWebRsp)localObject1).retCode.get());
          localBundle.putString("errMsg", ((PROTOCAL.StQWebRsp)localObject1).errMsg.get().toStringUtf8());
          localObject1 = WxPayCheckUrlRequest.onResponse((byte[])localObject2);
          if (localObject1 != null) {
            localBundle.putInt("key_url_valid", ((MiniAppMidasPay.StWxpayCheckMWebURLRsp)localObject1).is_valid.get());
          }
          notifyObserver(paramIntent, 1077, true, localBundle, MiniAppObserver.class);
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onReceive. MiniWxPayCheckUrlServlet rsp = ");
            ((StringBuilder)localObject2).append(localObject1);
            QLog.d("MiniWxPayCheckUrlServlet", 2, ((StringBuilder)localObject2).toString());
          }
          notifyObserver(paramIntent, 1077, false, localBundle, MiniAppObserver.class);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniWxPayCheckUrlServlet", 2, "onReceive. inform MiniWxPayCheckUrlServlet resultcode fail.");
        }
        notifyObserver(paramIntent, 1077, false, localBundle, MiniAppObserver.class);
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localThrowable);
      ((StringBuilder)localObject2).append("onReceive error");
      QLog.e("MiniWxPayCheckUrlServlet", 1, ((StringBuilder)localObject2).toString());
      notifyObserver(paramIntent, 1077, false, localBundle, MiniAppObserver.class);
    }
    doReport(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getStringExtra("key_appid");
    Object localObject2 = paramIntent.getStringExtra("key_url");
    int i = paramIntent.getIntExtra("key_index", -1);
    localObject2 = new WxPayCheckUrlRequest((String)localObject1, (String)localObject2).encode(paramIntent, i, getTraceId());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_pay.WxpayCheckMWebURL");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniWxPayCheckUrlServlet
 * JD-Core Version:    0.7.0.1
 */
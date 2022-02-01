package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StCheckBindingStateRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class RejectFrequentlyRecommendsServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID = "key_appId";
  public static final String KEY_MSG = "key_Msg";
  public static final String KEY_STATE = "key_State";
  public static final String TAG = "RejectFrequentlyRecommendsServlet";
  
  public RejectFrequentlyRecommendsServlet()
  {
    this.observerId = 1085;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StCheckBindingStateRsp localStCheckBindingStateRsp = new INTERFACE.StCheckBindingStateRsp();
    long l = paramBundle.getLong("retCode");
    if (l == 0L)
    {
      localStCheckBindingStateRsp.mergeFrom(paramArrayOfByte);
      paramBundle.putInt("key_State", localStCheckBindingStateRsp.bindingState.get());
      paramBundle.putString("key_Msg", localStCheckBindingStateRsp.msg.get());
      notifyObserver(paramIntent, 1085, true, paramBundle, MiniAppObserver.class);
      paramIntent = localStCheckBindingStateRsp.msg.get();
      paramBundle = new StringBuilder();
      paramBundle.append("RejectFrequentlyRecommendsServlet retCode : ");
      paramBundle.append(l);
      paramBundle.append("; Msg : ");
      paramBundle.append(paramIntent);
      QLog.i("RejectFrequentlyRecommendsServlet", 1, paramBundle.toString());
      return;
    }
    notifyObserver(paramIntent, 1085, false, paramBundle, MiniAppObserver.class);
    paramIntent = new StringBuilder();
    paramIntent.append("RejectFrequentlyRecommendsServlet retCode : ");
    paramIntent.append(l);
    paramIntent.append("; errMsg : result is null");
    QLog.e("RejectFrequentlyRecommendsServlet", 1, paramIntent.toString());
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte2 = new RejectFrequentlyRecommendsReq(paramIntent.getStringExtra("key_appId")).encode(paramIntent, paramIntent.getIntExtra("key_index", -1), getTraceId());
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_userapp.RejectFrequentlyRecommends");
    paramPacket.putSendData(WupUtil.a(arrayOfByte1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.RejectFrequentlyRecommendsServlet
 * JD-Core Version:    0.7.0.1
 */
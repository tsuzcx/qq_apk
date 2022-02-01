package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StCheckBindingStateRsp;
import android.content.Intent;
import android.os.Bundle;
import bhuf;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class CheckBindingStateServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID = "key_appId";
  public static final String KEY_BINDTYPE = "key_bindType";
  public static final String KEY_CHECK_STATE = "key_check_State";
  public static final String KEY_MSG = "key_Msg";
  public static final String KEY_UID = "key_uid";
  public static final String TAG = "CheckBindingStateServlet";
  
  public CheckBindingStateServlet()
  {
    this.observerId = 1083;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StCheckBindingStateRsp localStCheckBindingStateRsp = new INTERFACE.StCheckBindingStateRsp();
    long l = paramBundle.getLong("retCode");
    if ((localStCheckBindingStateRsp != null) && (l == 0L))
    {
      localStCheckBindingStateRsp.mergeFrom(paramArrayOfByte);
      paramBundle.putInt("key_check_State", localStCheckBindingStateRsp.bindingState.get());
      paramBundle.putString("key_Msg", localStCheckBindingStateRsp.msg.get());
      notifyObserver(paramIntent, 1083, true, paramBundle, MiniAppObserver.class);
      paramIntent = localStCheckBindingStateRsp.msg.get();
      QLog.i("CheckBindingStateServlet", 1, "CheckBindingStateServlet retCode : " + l + "; Msg : " + paramIntent);
      return;
    }
    notifyObserver(paramIntent, 1083, false, paramBundle, MiniAppObserver.class);
    QLog.e("CheckBindingStateServlet", 1, "CheckBindingStateServlet retCode : " + l + "; errMsg : result is null");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte2 = new CheckBindingStateRequest(paramIntent.getStringExtra("key_appId"), paramIntent.getStringExtra("key_uid"), paramIntent.getIntExtra("key_bindType", 0)).encode(paramIntent, paramIntent.getIntExtra("key_index", -1), getTraceId());
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_info.CheckBindingState");
    paramPacket.putSendData(bhuf.a(arrayOfByte1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.CheckBindingStateServlet
 * JD-Core Version:    0.7.0.1
 */
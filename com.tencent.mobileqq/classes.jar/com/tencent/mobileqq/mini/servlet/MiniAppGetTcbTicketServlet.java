package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetTCBTicketRsp;
import android.content.Intent;
import android.os.Bundle;
import bguc;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppGetTcbTicketServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_CREATE_TIME = "key_createTime";
  public static final String KEY_ENV_ID = "key_env_id";
  public static final String KEY_EXT_INFO = "key_ext_info";
  public static final String KEY_PERIOD = "key_period";
  public static final String KEY_TICKET = "key_ticket";
  public static final String TAG = "MiniAppGetTcbTicketServlet";
  
  public MiniAppGetTcbTicketServlet()
  {
    this.observerId = 1046;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    INTERFACE.StGetTCBTicketRsp localStGetTCBTicketRsp = new INTERFACE.StGetTCBTicketRsp();
    long l = paramBundle.getLong("retCode");
    String str = paramBundle.getString("errMsg");
    if ((localStGetTCBTicketRsp != null) && (l == 0L))
    {
      localStGetTCBTicketRsp.mergeFrom(paramArrayOfByte);
      paramBundle.putByteArray("key_ext_info", localStGetTCBTicketRsp.extInfo.toByteArray());
      paramBundle.putString("key_ticket", localStGetTCBTicketRsp.ticket.get());
      paramBundle.putInt("key_createTime", localStGetTCBTicketRsp.createTime.get());
      paramBundle.putInt("key_period", localStGetTCBTicketRsp.period.get());
      notifyObserver(paramIntent, 1046, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1046, false, paramBundle, MiniAppObserver.class);
    QLog.e("MiniAppGetTcbTicketServlet", 1, "MiniAppGetTcbTicketServlet retCode : " + l + "; errMsg : " + str);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getStringExtra("key_app_id");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext_info");
    String str = paramIntent.getStringExtra("key_env_id");
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject1 = null;
    if (arrayOfByte != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      localObject2 = new GetTcbTicketRequest((COMM.StCommonExt)localObject1, (String)localObject2, str).encode(paramIntent, i, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_info.GetTCBTicket");
      paramPacket.putSendData(bguc.a((byte[])localObject1));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppGetTcbTicketServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetTcbTicketServlet
 * JD-Core Version:    0.7.0.1
 */
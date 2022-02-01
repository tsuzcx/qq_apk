package com.tencent.mobileqq.mini.servlet;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class CreateUpdatableMsgServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_FROM = "key_from";
  public static final String KEY_SCENE = "key_scene";
  public static final String KEY_SERVICE_TYPE = "key_service_type";
  public static final String KEY_SIG = "key_sig";
  public static final String KEY_SUB_SCENE = "key_sub_scene";
  public static final String KEY_TEMPLATE_ID = "key_template_id";
  public static final String KEY_UIN = "key_uin";
  public static final String TAG = "[mini] CreateUpdatableMsgServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
        if (paramFromServiceMsg != null)
        {
          bool = paramFromServiceMsg.isSuccess();
          if (bool)
          {
            Object localObject = new PROTOCAL.StQWebRsp();
            ((PROTOCAL.StQWebRsp)localObject).mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
            localBundle.putInt("key_index", (int)((PROTOCAL.StQWebRsp)localObject).Seq.get());
            long l = ((PROTOCAL.StQWebRsp)localObject).retCode.get();
            localObject = ((PROTOCAL.StQWebRsp)localObject).errMsg.get().toStringUtf8();
            localBundle.putLong("retCode", l);
            localBundle.putString("errMsg", (String)localObject);
            if (l != 0L) {
              break label272;
            }
            bool = true;
            notifyObserver(paramIntent, 1076, bool, localBundle, MiniAppObserver.class);
          }
          else
          {
            localBundle.putLong("retCode", paramFromServiceMsg.getBusinessFailCode());
            localBundle.putString("errMsg", paramFromServiceMsg.getBusinessFailMsg());
            QLog.e("[mini] CreateUpdatableMsgServlet", 2, "inform CreateUpdatableMsgServlet isSuccess false");
            notifyObserver(paramIntent, 1076, false, localBundle, MiniAppObserver.class);
          }
        }
        else
        {
          QLog.e("[mini] CreateUpdatableMsgServlet", 2, "inform CreateUpdatableMsgServlet resultcode fail.");
          notifyObserver(paramIntent, 1076, false, localBundle, MiniAppObserver.class);
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceive exception:");
        localStringBuilder.append(localThrowable);
        QLog.e("[mini] CreateUpdatableMsgServlet", 1, localStringBuilder.toString());
        notifyObserver(null, 1076, false, localBundle, MiniAppObserver.class);
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      label272:
      boolean bool = false;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte2 = new CreateUpdatableMsgRequest(paramIntent.getStringExtra("key_appid"), paramIntent.getStringExtra("key_template_id"), paramIntent.getIntExtra("key_from", -1), paramIntent.getIntExtra("key_scene", -1), paramIntent.getIntExtra("key_sub_scene", -1), paramIntent.getStringExtra("key_uin"), paramIntent.getIntExtra("key_service_type", 0), paramIntent.getByteArrayExtra("key_sig")).encode(paramIntent, paramIntent.getIntExtra("key_index", -1), getTraceId());
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_updatablemsg.CreateUpdatableMsg");
    paramPacket.putSendData(WupUtil.a(arrayOfByte1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.CreateUpdatableMsgServlet
 * JD-Core Version:    0.7.0.1
 */
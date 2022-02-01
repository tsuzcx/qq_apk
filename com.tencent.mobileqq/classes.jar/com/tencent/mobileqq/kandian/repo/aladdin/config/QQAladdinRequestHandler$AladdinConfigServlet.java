package com.tencent.mobileqq.kandian.repo.aladdin.config;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.aladdin.config.network.AladdinResponseHandler;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class QQAladdinRequestHandler$AladdinConfigServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onReceive] cmd=");
    ((StringBuilder)localObject1).append(paramFromServiceMsg.getServiceCmd());
    ((StringBuilder)localObject1).append(" appSeq=");
    ((StringBuilder)localObject1).append(paramFromServiceMsg.getAppSeq());
    ((StringBuilder)localObject1).append(" success=");
    ((StringBuilder)localObject1).append(paramFromServiceMsg.isSuccess());
    ((StringBuilder)localObject1).append(" resultCode=");
    ((StringBuilder)localObject1).append(paramFromServiceMsg.getResultCode());
    QLog.i("MSFServlet", 1, ((StringBuilder)localObject1).toString());
    if (!paramFromServiceMsg.isSuccess()) {
      return;
    }
    localObject1 = (AladdinResponseHandler)paramIntent.getParcelableExtra("key_response_handler");
    try
    {
      Object localObject2 = QQAladdinRequestHandler.a(paramFromServiceMsg.getWupBuffer());
      int i = paramFromServiceMsg.getResultCode();
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("[onReceive] msfRetCode = ");
      paramFromServiceMsg.append(i);
      QLog.i("MSFServlet", 1, paramFromServiceMsg.toString());
      if (i == 1000)
      {
        if (localObject2 != null)
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])localObject2);
          i = paramFromServiceMsg.uint32_result.get();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[onReceive] oidbResult = ");
          ((StringBuilder)localObject2).append(i);
          QLog.i("MSFServlet", 1, ((StringBuilder)localObject2).toString());
          if ((paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[onReceive] bytes length = ");
            ((StringBuilder)localObject2).append(paramFromServiceMsg.length);
            QLog.i("MSFServlet", 1, ((StringBuilder)localObject2).toString());
            if (i != 0) {
              return;
            }
            if (paramFromServiceMsg.length <= 0) {
              return;
            }
            localObject2 = (Bundle)paramIntent.getParcelableExtra("key_extra_info");
            ((AladdinResponseHandler)localObject1).onReceive(paramFromServiceMsg, (Bundle)localObject2);
            QQAladdinRequestHandler.a((Bundle)localObject2);
          }
          else
          {
            QLog.e("MSFServlet", 1, "[onReceive] oidb bytes_bodybuffer is empty");
          }
        }
        else
        {
          QLog.e("MSFServlet", 1, "[onReceive] msf data is empty");
        }
        paramIntent = paramIntent.getParcelableArrayListExtra("key_aladdin_listeners");
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          i = 0;
          while (i < paramIntent.size())
          {
            ((AladdinListener)paramIntent.get(i)).a();
            i += 1;
          }
        }
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.e("MSFServlet", 1, "[onReceive] ", paramIntent);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getByteArrayExtra("key_body_bytes");
    if (paramIntent != null)
    {
      paramIntent = ReadInJoyOidbHelper.a("OidbSvc.0xbf8", 3064, 0, paramIntent);
      paramPacket.setSSOCommand(paramIntent.getServiceCmd());
      paramPacket.putSendData(QQAladdinRequestHandler.b(paramIntent.getWupBuffer()));
      paramPacket.setAttributes(paramIntent.getAttributes());
      return;
    }
    QLog.e("MSFServlet", 1, "[onSend] bytes are null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.config.QQAladdinRequestHandler.AladdinConfigServlet
 * JD-Core Version:    0.7.0.1
 */
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aladdin.config.network.AladdinResponseHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinListener;
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

public class pky
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    QLog.i("MSFServlet", 1, "[onReceive] cmd=" + paramFromServiceMsg.getServiceCmd() + " appSeq=" + paramFromServiceMsg.getAppSeq() + " success=" + paramFromServiceMsg.isSuccess() + " resultCode=" + paramFromServiceMsg.getResultCode());
    if (!paramFromServiceMsg.isSuccess()) {
      return;
    }
    AladdinResponseHandler localAladdinResponseHandler = (AladdinResponseHandler)paramIntent.getParcelableExtra("key_response_handler");
    for (;;)
    {
      try
      {
        Object localObject = pkx.a(paramFromServiceMsg.getWupBuffer());
        int i = paramFromServiceMsg.getResultCode();
        QLog.i("MSFServlet", 1, "[onReceive] msfRetCode = " + i);
        if (i != 1000) {
          break;
        }
        if (localObject != null)
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])localObject);
          i = paramFromServiceMsg.uint32_result.get();
          QLog.i("MSFServlet", 1, "[onReceive] oidbResult = " + i);
          if ((paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            QLog.i("MSFServlet", 1, "[onReceive] bytes length = " + paramFromServiceMsg.length);
            if ((i != 0) || (paramFromServiceMsg.length <= 0)) {
              break;
            }
            localObject = (Bundle)paramIntent.getParcelableExtra("key_extra_info");
            localAladdinResponseHandler.onReceive(paramFromServiceMsg, (Bundle)localObject);
            pkx.a((Bundle)localObject);
            paramIntent = paramIntent.getParcelableArrayListExtra("key_aladdin_listeners");
            if ((paramIntent == null) || (paramIntent.size() <= 0)) {
              break;
            }
            i = 0;
            if (i >= paramIntent.size()) {
              break;
            }
            ((AladdinListener)paramIntent.get(i)).a();
            i += 1;
            continue;
          }
          QLog.e("MSFServlet", 1, "[onReceive] oidb bytes_bodybuffer is empty");
          continue;
        }
        QLog.e("MSFServlet", 1, "[onReceive] msf data is empty");
      }
      catch (Exception paramIntent)
      {
        QLog.e("MSFServlet", 1, "[onReceive] ", paramIntent);
        return;
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getByteArrayExtra("key_body_bytes");
    if (paramIntent != null)
    {
      paramIntent = qxp.a("OidbSvc.0xbf8", 3064, 0, paramIntent);
      paramPacket.setSSOCommand(paramIntent.getServiceCmd());
      paramPacket.putSendData(pkx.b(paramIntent.getWupBuffer()));
      paramPacket.setAttributes(paramIntent.getAttributes());
      return;
    }
    QLog.e("MSFServlet", 1, "[onSend] bytes are null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pky
 * JD-Core Version:    0.7.0.1
 */
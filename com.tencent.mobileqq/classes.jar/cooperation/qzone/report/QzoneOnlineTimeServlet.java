package cooperation.qzone.report;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QzoneOnlineTimeServlet
  extends MSFServlet
{
  private static final int TIMEOUT = 60000;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {
      QzoneOnlineTimeCollectRptService.getInstance().onTaskResponse(paramFromServiceMsg.getResultCode());
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QzoneOnlineTimeServlet", 2, "fromServiceMsg==msg");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getSerializableExtra("list");
    QLog.d("QzoneOnlineTimeServlet", 1, "uin:" + getAppRuntime().getLongAccountUin());
    QzoneOnlineTimeCollectReportRequest localQzoneOnlineTimeCollectReportRequest = new QzoneOnlineTimeCollectReportRequest(getAppRuntime().getLongAccountUin(), (ArrayList)paramIntent);
    byte[] arrayOfByte = localQzoneOnlineTimeCollectReportRequest.encode();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + localQzoneOnlineTimeCollectReportRequest.uniKey());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.report.QzoneOnlineTimeServlet
 * JD-Core Version:    0.7.0.1
 */
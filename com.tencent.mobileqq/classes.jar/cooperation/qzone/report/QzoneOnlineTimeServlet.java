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
    if (paramFromServiceMsg != null)
    {
      QzoneOnlineTimeCollectRptService.getInstance().onTaskResponse(paramFromServiceMsg.getResultCode());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneOnlineTimeServlet", 2, "fromServiceMsg==msg");
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getSerializableExtra("list");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uin:");
    ((StringBuilder)localObject).append(getAppRuntime().getLongAccountUin());
    QLog.d("QzoneOnlineTimeServlet", 1, ((StringBuilder)localObject).toString());
    QzoneOnlineTimeCollectReportRequest localQzoneOnlineTimeCollectReportRequest = new QzoneOnlineTimeCollectReportRequest(getAppRuntime().getLongAccountUin(), (ArrayList)paramIntent);
    localObject = localQzoneOnlineTimeCollectReportRequest.encode();
    paramIntent = (Intent)localObject;
    if (localObject == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SQQzoneSvc.");
    ((StringBuilder)localObject).append(localQzoneOnlineTimeCollectReportRequest.uniKey());
    paramPacket.setSSOCommand(((StringBuilder)localObject).toString());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.QzoneOnlineTimeServlet
 * JD-Core Version:    0.7.0.1
 */
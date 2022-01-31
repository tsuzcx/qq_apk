package cooperation.qzone.report.lp;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class LpReportServlet
  extends MSFServlet
{
  public static final String TAG = "LpReport.LpReportServlet";
  private static final int TIMEOUT = 60000;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LpReport.LpReportServlet", 4, "LpReportServlet onReceive success.");
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("LpReportServlet onReceive fail. resultCode:");
    if (paramFromServiceMsg != null) {}
    for (paramIntent = Integer.valueOf(paramFromServiceMsg.getResultCode());; paramIntent = "")
    {
      QLog.e("LpReport.LpReportServlet", 1, paramIntent);
      return;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    LpReportNewIntent localLpReportNewIntent;
    if ((paramIntent instanceof LpReportNewIntent))
    {
      localLpReportNewIntent = (LpReportNewIntent)paramIntent;
      LpReportRequest localLpReportRequest = new LpReportRequest(localLpReportNewIntent.type, localLpReportNewIntent.info, localLpReportNewIntent.extra_info, localLpReportNewIntent.multi_info);
      byte[] arrayOfByte = localLpReportRequest.encode();
      paramIntent = arrayOfByte;
      if (arrayOfByte == null) {
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(60000L);
      paramPacket.setSSOCommand("SQQzoneSvc." + localLpReportRequest.uniKey());
      paramPacket.putSendData(paramIntent);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder().append("startReport, tabletype = ").append(localLpReportNewIntent.type).append(", size = ");
        if (localLpReportNewIntent.multi_info == null) {
          break label164;
        }
      }
    }
    label164:
    for (int i = localLpReportNewIntent.multi_info.size();; i = 0)
    {
      QLog.i("LpReport.LpReportServlet", 2, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportServlet
 * JD-Core Version:    0.7.0.1
 */
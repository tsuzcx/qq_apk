package cooperation.vip.yyb;

import NS_NEW_MOBILE_REPORT.AccessRspHead;
import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class YYBInstallPackageReportServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive cmd=");
      localStringBuilder.append(paramIntent.getStringExtra("cmd"));
      localStringBuilder.append(",success=");
      localStringBuilder.append(paramFromServiceMsg.isSuccess());
      QLog.d("YYBAdvServlet", 2, localStringBuilder.toString());
    }
    if (paramIntent != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      int i = paramFromServiceMsg.getResultCode();
      if (i == 1000)
      {
        paramIntent = YYBInstallPackageReportRequest.a(paramFromServiceMsg.getWupBuffer(), new int[1]);
        if (paramIntent != null)
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handler MobileReport result , resultCode=");
          paramFromServiceMsg.append(i);
          paramFromServiceMsg.append(" error code ");
          paramFromServiceMsg.append(paramIntent.err_code);
          paramFromServiceMsg.append(" error msg ");
          paramFromServiceMsg.append(paramIntent.err_msg);
          QLog.d("YYBAdvServlet", 2, paramFromServiceMsg.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("MobileReport fail, resultCode=");
        paramIntent.append(i);
        QLog.d("YYBAdvServlet", 2, paramIntent.toString());
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("selfuin", 0L);
    paramIntent = paramIntent.getStringArrayListExtra("uninstall_app_list");
    if (QLog.isColorLevel()) {
      QLog.d("YYBAdvServlet", 2, "YYB send");
    }
    if (paramIntent != null)
    {
      YYBInstallPackageReportRequest localYYBInstallPackageReportRequest = new YYBInstallPackageReportRequest(Long.valueOf(l).longValue(), paramIntent);
      byte[] arrayOfByte = localYYBInstallPackageReportRequest.encode();
      paramIntent = arrayOfByte;
      if (arrayOfByte == null)
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onSend request encode result is null.cmd=");
        paramIntent.append(localYYBInstallPackageReportRequest.uniKey());
        QLog.e("YYBAdvServlet", 1, paramIntent.toString());
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(15000L);
      paramPacket.setSSOCommand(localYYBInstallPackageReportRequest.getCmdString());
      paramPacket.putSendData(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.yyb.YYBInstallPackageReportServlet
 * JD-Core Version:    0.7.0.1
 */
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
    if (QLog.isColorLevel()) {
      QLog.d("YYBAdvServlet", 2, "onReceive cmd=" + paramIntent.getStringExtra("cmd") + ",success=" + paramFromServiceMsg.isSuccess());
    }
    if ((paramIntent == null) || (paramFromServiceMsg == null)) {}
    int i;
    do
    {
      do
      {
        return;
        i = paramFromServiceMsg.getResultCode();
        if (i != 1000) {
          break;
        }
        paramIntent = YYBInstallPackageReportRequest.a(paramFromServiceMsg.getWupBuffer(), new int[1]);
      } while (paramIntent == null);
      QLog.d("YYBAdvServlet", 2, "handler MobileReport result , resultCode=" + i + " error code " + paramIntent.err_code + " error msg " + paramIntent.err_msg);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("YYBAdvServlet", 2, "MobileReport fail, resultCode=" + i);
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
        QLog.e("YYBAdvServlet", 1, "onSend request encode result is null.cmd=" + localYYBInstallPackageReportRequest.uniKey());
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(15000L);
      paramPacket.setSSOCommand(localYYBInstallPackageReportRequest.getCmdString());
      paramPacket.putSendData(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.yyb.YYBInstallPackageReportServlet
 * JD-Core Version:    0.7.0.1
 */
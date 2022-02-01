package cooperation.vip.tianshu;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class TianShuServlet
  extends MSFServlet
{
  public static final String CMD_TIANSHU_GETADS = "TianShu.GetAds";
  public static final String CMD_TIANSHU_REPORT = "TianShu.UserActionMultiReport";
  public static final String EXTRA_CMD = "cmd";
  public static final String EXTRA_DATA = "data";
  public static final String EXTRA_REQUEST_KEY = "requestKey";
  public static final String EXTRA_TIMEOUT = "timeout";
  private static final String TAG = "MonitorServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MonitorServlet", 2, "onReceive cmd=" + paramIntent.getStringExtra("cmd") + ",success=" + paramFromServiceMsg.isSuccess());
    }
    if ((paramIntent == null) || (paramFromServiceMsg == null)) {}
    String str2;
    label151:
    do
    {
      do
      {
        return;
        str2 = paramFromServiceMsg.getServiceCmd();
      } while (str2 == null);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        localStringBuilder = new StringBuilder().append("resp:").append(str2).append(" is ");
        if (!bool) {
          break label151;
        }
      }
      for (String str1 = "";; str1 = "not")
      {
        QLog.d("MonitorServlet", 2, str1 + " success");
        if (!str2.equals("TianShu.UserActionMultiReport")) {
          break;
        }
        TianShuManager.getInstance().onTianShuReport(paramIntent, paramFromServiceMsg);
        return;
      }
    } while (!str2.equals("TianShu.GetAds"));
    TianShuManager.getInstance().onGetTianShuAdvRsp(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    String str = paramIntent.getStringExtra("cmd");
    long l = paramIntent.getLongExtra("timeout", 10000L);
    paramPacket.setSSOCommand(str);
    paramPacket.setTimeout(l);
    paramPacket.putSendData(arrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("MonitorServlet", 2, "onSend exit cmd=" + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.tianshu.TianShuServlet
 * JD-Core Version:    0.7.0.1
 */
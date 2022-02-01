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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive cmd=");
      ((StringBuilder)localObject).append(paramIntent.getStringExtra("cmd"));
      ((StringBuilder)localObject).append(",success=");
      ((StringBuilder)localObject).append(paramFromServiceMsg.isSuccess());
      QLog.d("MonitorServlet", 2, ((StringBuilder)localObject).toString());
    }
    if (paramIntent != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      String str = paramFromServiceMsg.getServiceCmd();
      if (str == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resp:");
        localStringBuilder.append(str);
        localStringBuilder.append(" is ");
        if (bool) {
          localObject = "";
        } else {
          localObject = "not";
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" success");
        QLog.d("MonitorServlet", 2, localStringBuilder.toString());
      }
      if (str.equals("TianShu.UserActionMultiReport"))
      {
        TianShuManager.getInstance().onTianShuReport(paramIntent, paramFromServiceMsg);
        return;
      }
      if (str.equals("TianShu.GetAds")) {
        TianShuManager.getInstance().onGetTianShuAdvRsp(paramIntent, paramFromServiceMsg);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    String str = paramIntent.getStringExtra("cmd");
    long l = paramIntent.getLongExtra("timeout", 10000L);
    paramPacket.setSSOCommand(str);
    paramPacket.setTimeout(l);
    paramPacket.putSendData(arrayOfByte);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend exit cmd=");
      paramIntent.append(str);
      QLog.d("MonitorServlet", 2, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.tianshu.TianShuServlet
 * JD-Core Version:    0.7.0.1
 */
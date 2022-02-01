import android.content.Intent;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class mww
  extends MSFServlet
{
  private AVGameAppInterface a;
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush" };
  }
  
  public void onCreate()
  {
    super.onCreate();
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof AVGameAppInterface)) {
      this.a = ((AVGameAppInterface)localAppRuntime);
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent != null)
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("AVGameServlet", 4, "onReceive, cmd[" + paramFromServiceMsg.getServiceCmd() + "]");
      }
      if (this.a != null) {
        this.a.a(paramIntent, paramFromServiceMsg);
      }
      return;
      paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent != null)
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      if (paramIntent != null)
      {
        paramPacket.setSSOCommand(paramIntent.getServiceCmd());
        paramPacket.putSendData(paramIntent.getWupBuffer());
        paramPacket.setTimeout(paramIntent.getTimeout());
        paramPacket.setAttributes(paramIntent.getAttributes());
        if (!paramIntent.isNeedCallback()) {
          paramPacket.setNoResponse();
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("AVGameServlet", 4, "send, cmd[" + paramIntent.getServiceCmd() + "]");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mww
 * JD-Core Version:    0.7.0.1
 */
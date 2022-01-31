import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class pov
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent != null)
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    }
    for (;;)
    {
      sej.a(paramFromServiceMsg);
      if (getAppRuntime() != null) {
        pou.a().a(paramFromServiceMsg.isSuccess(), paramIntent, paramFromServiceMsg, null);
      }
      return;
      paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent != null)
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      sej.a(localToServiceMsg);
      if (localToServiceMsg != null)
      {
        paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
        paramPacket.putSendData(localToServiceMsg.getWupBuffer());
        paramPacket.setTimeout(localToServiceMsg.getTimeout());
        paramPacket.setAttributes(localToServiceMsg.getAttributes());
        paramPacket.setQuickSend(paramIntent.getBooleanExtra("quickSendEnable", false), paramIntent.getIntExtra("quickSendStrategy", 0));
        paramPacket.autoResend = localToServiceMsg.isFastResendEnabled();
        if (!localToServiceMsg.isNeedCallback()) {
          paramPacket.setNoResponse();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pov
 * JD-Core Version:    0.7.0.1
 */
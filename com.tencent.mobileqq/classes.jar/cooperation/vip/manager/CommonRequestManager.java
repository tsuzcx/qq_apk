package cooperation.vip.manager;

import android.content.Intent;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.QzoneExternalRequest;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.os.MqqHandler;

public abstract class CommonRequestManager
  extends MSFServlet
{
  public abstract QzoneExternalRequest a(Intent paramIntent);
  
  protected long b()
  {
    return 10000L;
  }
  
  public void b(Intent paramIntent)
  {
    ThreadManager.getSubThreadHandler().post(new CommonRequestManager.1(this, paramIntent));
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    QzoneExternalRequest localQzoneExternalRequest = a(paramIntent);
    if (localQzoneExternalRequest == null)
    {
      QLog.i("CommonRequestManager", 1, " onSend request = null");
      return;
    }
    Object localObject = localQzoneExternalRequest.encode();
    paramIntent = (Intent)localObject;
    if (localObject == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend request encode result is null.cmd=");
      paramIntent.append(localQzoneExternalRequest.uniKey());
      QLog.e("CommonRequestManager", 1, paramIntent.toString());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(b());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SQQzoneSvc.");
    ((StringBuilder)localObject).append(localQzoneExternalRequest.uniKey());
    paramPacket.setSSOCommand(((StringBuilder)localObject).toString());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.manager.CommonRequestManager
 * JD-Core Version:    0.7.0.1
 */
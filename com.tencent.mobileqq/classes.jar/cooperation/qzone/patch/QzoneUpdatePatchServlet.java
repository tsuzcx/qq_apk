package cooperation.qzone.patch;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.plugin.PluginIntent;
import cooperation.qzone.plugin.PluginIntent.OnResultListner;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QzoneUpdatePatchServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent != null) && ((paramIntent instanceof PluginIntent)))
    {
      PluginIntent.OnResultListner localOnResultListner = ((PluginIntent)paramIntent).a();
      if (localOnResultListner != null) {
        localOnResultListner.a(paramIntent, paramFromServiceMsg);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = null;
    if ((paramIntent instanceof PluginIntent))
    {
      localObject = ((PluginIntent)paramIntent).a;
      paramIntent = ((PluginIntent)paramIntent).b;
    }
    for (;;)
    {
      QZonePatchRequest localQZonePatchRequest = new QZonePatchRequest(getAppRuntime().getLongAccountUin(), (ArrayList)localObject, paramIntent);
      localObject = localQZonePatchRequest.encode();
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(60000L);
      paramPacket.setSSOCommand("SQQzoneSvc." + localQZonePatchRequest.uniKey());
      paramPacket.putSendData(paramIntent);
      return;
      localQZonePatchRequest = null;
      paramIntent = (Intent)localObject;
      localObject = localQZonePatchRequest;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.patch.QzoneUpdatePatchServlet
 * JD-Core Version:    0.7.0.1
 */
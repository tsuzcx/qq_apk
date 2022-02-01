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
  private static final String TAG = "qz_patch";
  private static final int TIMEOUT = 60000;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent != null) && ((paramIntent instanceof PluginIntent)))
    {
      PluginIntent.OnResultListner localOnResultListner = ((PluginIntent)paramIntent).getResultListner();
      if (localOnResultListner != null) {
        localOnResultListner.onRecieve(paramIntent, paramFromServiceMsg);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    boolean bool = paramIntent instanceof PluginIntent;
    QZonePatchRequest localQZonePatchRequest = null;
    if (bool)
    {
      localObject = (PluginIntent)paramIntent;
      paramIntent = ((PluginIntent)localObject).update_infos;
      localObject = ((PluginIntent)localObject).module_update_infos;
    }
    else
    {
      localObject = null;
      paramIntent = localQZonePatchRequest;
    }
    localQZonePatchRequest = new QZonePatchRequest(getAppRuntime().getLongAccountUin(), paramIntent, (ArrayList)localObject);
    Object localObject = localQZonePatchRequest.encode();
    paramIntent = (Intent)localObject;
    if (localObject == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SQQzoneSvc.");
    ((StringBuilder)localObject).append(localQZonePatchRequest.uniKey());
    paramPacket.setSSOCommand(((StringBuilder)localObject).toString());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.patch.QzoneUpdatePatchServlet
 * JD-Core Version:    0.7.0.1
 */
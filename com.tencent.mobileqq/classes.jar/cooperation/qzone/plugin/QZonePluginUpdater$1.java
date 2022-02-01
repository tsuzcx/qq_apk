package cooperation.qzone.plugin;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.networkedmodule.QzoneModuleConfigManager;
import cooperation.qzone.patch.QZonePatchRequest;

class QZonePluginUpdater$1
  implements PluginIntent.OnResultListner
{
  QZonePluginUpdater$1(QZonePluginUpdater paramQZonePluginUpdater) {}
  
  public void onRecieve(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = false;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = QZonePatchRequest.onResponse(paramFromServiceMsg.getWupBuffer());
      QZonePluginUpdater.access$000(this.this$0, paramIntent);
      QZonePluginUpdater.access$100(this.this$0, paramIntent, null);
      QzoneModuleConfigManager.getInstance().handleModuleRsp(paramIntent);
      if (this.this$0.listner != null)
      {
        paramFromServiceMsg = this.this$0.listner;
        if (paramIntent != null) {
          bool = true;
        }
        paramFromServiceMsg.onUpdatefinish(bool);
      }
    }
    do
    {
      return;
      QZonePluginUpdater.access$100(this.this$0, null, null);
    } while (this.this$0.listner == null);
    this.this$0.listner.onUpdatefinish(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginUpdater.1
 * JD-Core Version:    0.7.0.1
 */
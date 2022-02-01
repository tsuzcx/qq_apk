package cooperation.qzone.webviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class QZonePublishSecretShuoShuoH5Plugin$1
  extends BroadcastReceiver
{
  QZonePublishSecretShuoShuoH5Plugin$1(QZonePublishSecretShuoShuoH5Plugin paramQZonePublishSecretShuoShuoH5Plugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.qq.syncSecretShuoshuoMsg"))
    {
      int i = paramIntent.getIntExtra("com.tencent.qq.syncSecretShuoshuoMsgType", 0);
      QZonePublishSecretShuoShuoH5Plugin.access$000(this.this$0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZonePublishSecretShuoShuoH5Plugin.1
 * JD-Core Version:    0.7.0.1
 */
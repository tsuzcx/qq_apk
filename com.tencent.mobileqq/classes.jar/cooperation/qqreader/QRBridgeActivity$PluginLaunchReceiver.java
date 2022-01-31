package cooperation.qqreader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import befq;
import bfne;

public class QRBridgeActivity$PluginLaunchReceiver
  extends BroadcastReceiver
{
  public QRBridgeActivity$PluginLaunchReceiver(QRBridgeActivity paramQRBridgeActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    bfne.d("QRBridgeActivity", "PluginLaunchReceiver onReceive action:" + paramContext);
    if ("com.tencent.mobileqq.middlePagePreloadProcess".equals(paramContext))
    {
      if (!this.a.e)
      {
        this.a.a.removeMessages(1004);
        this.a.e = true;
        this.a.a();
      }
      bfne.d("QRBridgeActivity", "reader process has launched");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeActivity.PluginLaunchReceiver
 * JD-Core Version:    0.7.0.1
 */
package cooperation.qqreader;

import amqw;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class QRBridgeActivity$PluginLaunchReceiver
  extends BroadcastReceiver
{
  public QRBridgeActivity$PluginLaunchReceiver(QRBridgeActivity paramQRBridgeActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QRBridgeActivity", 2, "PluginLaunchReceiver onReceive action:" + paramContext);
    }
    if (paramContext.equals("com.tencent.mobileqq.closeQRBridgeActivity")) {
      if ((this.a.d) || (!this.a.e)) {
        this.a.a.postDelayed(new amqw(this), 1200L);
      }
    }
    do
    {
      do
      {
        return;
        this.a.finish();
        return;
      } while (!paramContext.equals("com.tencent.mobileqq.middlePagePreloadProcess"));
      if (!this.a.f)
      {
        this.a.a.removeMessages(1004);
        this.a.f = true;
        this.a.f();
      }
    } while (!QLog.isColorLevel());
    QLog.d("QRBridgeActivity", 2, "reader process has launched");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeActivity.PluginLaunchReceiver
 * JD-Core Version:    0.7.0.1
 */
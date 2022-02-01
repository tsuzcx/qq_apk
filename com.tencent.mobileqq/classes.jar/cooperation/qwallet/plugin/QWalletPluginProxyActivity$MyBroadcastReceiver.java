package cooperation.qwallet.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class QWalletPluginProxyActivity$MyBroadcastReceiver
  extends BroadcastReceiver
{
  private QWalletPluginProxyActivity$MyBroadcastReceiver(QWalletPluginProxyActivity paramQWalletPluginProxyActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramContext = paramIntent.getAction();
    } while ((paramContext == null) || (!paramContext.equals("pluginsdk_QWallet_PatternLock_closeAll")));
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPluginProxyActivity.MyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
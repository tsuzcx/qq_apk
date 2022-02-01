package cooperation.qwallet.plugin.impl;

import android.os.Bundle;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class QWalletHelperImpl$1
  implements Runnable
{
  QWalletHelperImpl$1(QWalletHelperImpl paramQWalletHelperImpl, WeakReference paramWeakReference, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if ((AppRuntime)this.val$weakRefApp.get() == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.val$uin);
    localBundle.putString("skey", this.val$skey);
    localBundle.putString("skey_type", "2");
    localBundle.putString("preload_from", this.val$from);
    localBundle.putInt("PayInvokerId", 21);
    QWalletPayBridge.launchBackground(MobileQQ.getContext(), localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.QWalletHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */
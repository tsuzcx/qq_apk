package cooperation.qwallet.plugin.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import java.lang.ref.WeakReference;

class QWalletHelperImpl$2
  extends ResultReceiver
{
  QWalletHelperImpl$2(QWalletHelperImpl paramQWalletHelperImpl, Handler paramHandler, WeakReference paramWeakReference)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    paramBundle = (OnQRHandleResultCallback)this.val$callbackRef.get();
    if (paramBundle != null) {
      paramBundle.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.QWalletHelperImpl.2
 * JD-Core Version:    0.7.0.1
 */
package cooperation.qwallet.plugin.impl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import java.lang.ref.WeakReference;

final class QWalletHelperImpl$2
  extends ResultReceiver
{
  QWalletHelperImpl$2(Handler paramHandler, WeakReference paramWeakReference)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    paramBundle = (Activity)this.val$activityRef.get();
    if (((paramBundle instanceof ScannerActivity)) && (!paramBundle.isFinishing())) {
      paramBundle.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.QWalletHelperImpl.2
 * JD-Core Version:    0.7.0.1
 */
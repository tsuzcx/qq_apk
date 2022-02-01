package cooperation.qwallet.plugin;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class QWalletLockScreenActivity$1
  extends Handler
{
  QWalletLockScreenActivity$1(QWalletLockScreenActivity paramQWalletLockScreenActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 2)
    {
      if (i != 9) {
        return;
      }
      QWalletLockScreenActivity.access$000(this.this$0);
      return;
    }
    this.this$0.moveTaskToBack(true);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletLockScreenActivity.1
 * JD-Core Version:    0.7.0.1
 */
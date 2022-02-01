package cooperation.qwallet.plugin.impl;

import android.app.Activity;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import java.lang.ref.WeakReference;

class QWalletHelperImpl$3
  implements Runnable
{
  QWalletHelperImpl$3(QWalletHelperImpl paramQWalletHelperImpl, String paramString1, WeakReference paramWeakReference, long paramLong, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    AnimationView.AnimationInfo localAnimationInfo = AnimationView.AnimationInfo.loadFromZip(this.val$zipFileName);
    Activity localActivity = (Activity)this.val$weakActivityRef.get();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      localActivity.runOnUiThread(new QWalletHelperImpl.3.1(this, localAnimationInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.QWalletHelperImpl.3
 * JD-Core Version:    0.7.0.1
 */
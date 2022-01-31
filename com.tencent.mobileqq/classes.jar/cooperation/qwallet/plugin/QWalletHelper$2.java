package cooperation.qwallet.plugin;

import android.app.Activity;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import java.lang.ref.WeakReference;

final class QWalletHelper$2
  implements Runnable
{
  QWalletHelper$2(String paramString1, WeakReference paramWeakReference, long paramLong, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    AnimationView.AnimationInfo localAnimationInfo = AnimationView.AnimationInfo.loadFromZip(this.val$zipFileName);
    Activity localActivity = (Activity)this.val$weakActivityRef.get();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    localActivity.runOnUiThread(new QWalletHelper.2.1(this, localAnimationInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletHelper.2
 * JD-Core Version:    0.7.0.1
 */
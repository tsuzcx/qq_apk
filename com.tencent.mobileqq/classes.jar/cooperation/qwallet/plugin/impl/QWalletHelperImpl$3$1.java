package cooperation.qwallet.plugin.impl;

import android.app.Activity;
import com.tencent.mobileqq.activity.qwallet.widget.QWalletAnimDialog;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import java.lang.ref.WeakReference;

class QWalletHelperImpl$3$1
  implements Runnable
{
  QWalletHelperImpl$3$1(QWalletHelperImpl.3 param3, AnimationView.AnimationInfo paramAnimationInfo) {}
  
  public void run()
  {
    Activity localActivity = (Activity)this.this$0.val$weakActivityRef.get();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (this.val$info != null) {
      try
      {
        QWalletAnimDialog localQWalletAnimDialog = new QWalletAnimDialog(localActivity, 2131755286, this.val$info, this.this$0.val$reportSeq);
        localQWalletAnimDialog.setF2fRedpackInfo(this.this$0.val$uin, this.this$0.val$nickName, this.this$0.val$url);
        localQWalletAnimDialog.show();
        return;
      }
      catch (Exception localException)
      {
        this.val$info.destoryBitmaps();
      }
    }
    QWalletHelperImpl.gotoF2FRedpack(this.this$0.val$uin, this.this$0.val$nickName, localActivity, this.this$0.val$url, false, this.this$0.val$reportSeq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.QWalletHelperImpl.3.1
 * JD-Core Version:    0.7.0.1
 */
package cooperation.qwallet.plugin;

import android.app.Activity;
import com.tencent.mobileqq.activity.qwallet.widget.QWalletAnimDialog;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import java.lang.ref.WeakReference;

class QWalletHelper$2$1
  implements Runnable
{
  QWalletHelper$2$1(QWalletHelper.2 param2, AnimationView.AnimationInfo paramAnimationInfo) {}
  
  public void run()
  {
    Activity localActivity = (Activity)this.this$0.val$weakActivityRef.get();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (this.val$info != null) {
      try
      {
        QWalletAnimDialog localQWalletAnimDialog = new QWalletAnimDialog(localActivity, 2131755269, this.val$info, this.this$0.val$reportSeq);
        localQWalletAnimDialog.setF2fRedpackInfo(this.this$0.val$uin, this.this$0.val$nickName, this.this$0.val$url);
        localQWalletAnimDialog.show();
        return;
      }
      catch (Exception localException)
      {
        this.val$info.destoryBitmaps();
      }
    }
    QWalletHelper.gotoF2FRedpack(this.this$0.val$uin, this.this$0.val$nickName, localActivity, this.this$0.val$url, false, this.this$0.val$reportSeq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletHelper.2.1
 * JD-Core Version:    0.7.0.1
 */
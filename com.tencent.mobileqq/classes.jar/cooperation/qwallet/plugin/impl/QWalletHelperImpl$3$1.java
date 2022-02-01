package cooperation.qwallet.plugin.impl;

import android.app.Activity;
import com.tencent.mobileqq.qqpay.ui.R.style;
import com.tencent.mobileqq.qwallet.widget.QWalletAnimDialog;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import java.lang.ref.WeakReference;

class QWalletHelperImpl$3$1
  implements Runnable
{
  QWalletHelperImpl$3$1(QWalletHelperImpl.3 param3, AnimationView.AnimationInfo paramAnimationInfo) {}
  
  public void run()
  {
    Activity localActivity = (Activity)this.this$1.val$weakActivityRef.get();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      if (this.val$info == null) {}
    }
    try
    {
      QWalletAnimDialog localQWalletAnimDialog = new QWalletAnimDialog(localActivity, R.style.c, this.val$info, this.this$1.val$reportSeq);
      localQWalletAnimDialog.a(this.this$1.val$uin, this.this$1.val$nickName, this.this$1.val$url);
      localQWalletAnimDialog.show();
      return;
    }
    catch (Exception localException)
    {
      label86:
      break label86;
    }
    this.val$info.destoryBitmaps();
    this.this$1.this$0.gotoF2FRedpack(this.this$1.val$uin, this.this$1.val$nickName, localActivity, this.this$1.val$url, false, this.this$1.val$reportSeq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.QWalletHelperImpl.3.1
 * JD-Core Version:    0.7.0.1
 */
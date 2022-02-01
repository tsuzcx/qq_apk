package dov.com.qq.im.ae.play;

import android.content.Context;
import android.widget.ProgressBar;
import com.tencent.mobileqq.widget.QQToast;

class AEPlayShowGridViewHolder$4
  implements Runnable
{
  AEPlayShowGridViewHolder$4(AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder, boolean paramBoolean) {}
  
  public void run()
  {
    AEPlayShowGridViewHolder.access$200(this.this$0).setVisibility(8);
    if (!this.val$isSuccess) {
      QQToast.a(AEPlayShowGridViewHolder.access$300(), AEPlayShowGridViewHolder.access$300().getString(2131718101), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowGridViewHolder.4
 * JD-Core Version:    0.7.0.1
 */
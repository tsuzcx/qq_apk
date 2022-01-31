package dov.com.qq.im.ae.play;

import android.content.Context;
import android.widget.ProgressBar;
import blgd;
import com.tencent.mobileqq.widget.QQToast;

public class AEPlayShowGridViewHolder$4
  implements Runnable
{
  public AEPlayShowGridViewHolder$4(blgd paramblgd, boolean paramBoolean) {}
  
  public void run()
  {
    blgd.a(this.this$0).setVisibility(8);
    if (!this.a) {
      QQToast.a(blgd.a(), blgd.a().getString(2131718756), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowGridViewHolder.4
 * JD-Core Version:    0.7.0.1
 */
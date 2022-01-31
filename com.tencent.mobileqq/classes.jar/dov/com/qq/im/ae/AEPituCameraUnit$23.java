package dov.com.qq.im.ae;

import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import bkpl;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

public class AEPituCameraUnit$23
  implements Runnable
{
  public AEPituCameraUnit$23(bkpl parambkpl, LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable) {}
  
  public void run()
  {
    if (bkpl.a(this.this$0) == null)
    {
      ViewStub localViewStub = (ViewStub)bkpl.a(this.this$0).findViewById(2131377148);
      bkpl.a(this.this$0, (ImageView)localViewStub.inflate().findViewById(2131362575));
    }
    bkpl.a(this.this$0).postDelayed(bkpl.a(this.this$0), this.a.getTotalDuration());
    bkpl.a(this.this$0).setVisibility(0);
    bkpl.a(this.this$0).setImageDrawable(this.a);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.23
 * JD-Core Version:    0.7.0.1
 */
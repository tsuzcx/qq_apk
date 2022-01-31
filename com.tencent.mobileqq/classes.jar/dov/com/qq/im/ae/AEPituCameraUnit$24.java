package dov.com.qq.im.ae;

import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import biim;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

public class AEPituCameraUnit$24
  implements Runnable
{
  public AEPituCameraUnit$24(biim parambiim, LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable) {}
  
  public void run()
  {
    if (biim.a(this.this$0) == null)
    {
      ViewStub localViewStub = (ViewStub)biim.a(this.this$0).findViewById(2131376592);
      biim.a(this.this$0, (ImageView)localViewStub.inflate().findViewById(2131362548));
    }
    biim.a(this.this$0).postDelayed(biim.a(this.this$0), this.a.getTotalDuration());
    biim.a(this.this$0).setVisibility(0);
    biim.a(this.this$0).setImageDrawable(this.a);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.24
 * JD-Core Version:    0.7.0.1
 */
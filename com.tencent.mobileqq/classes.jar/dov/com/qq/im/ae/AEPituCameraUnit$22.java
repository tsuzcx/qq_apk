package dov.com.qq.im.ae;

import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import bndy;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

public class AEPituCameraUnit$22
  implements Runnable
{
  public AEPituCameraUnit$22(bndy parambndy, LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable) {}
  
  public void run()
  {
    if (bndy.a(this.this$0) == null)
    {
      ViewStub localViewStub = (ViewStub)bndy.b(this.this$0).findViewById(2131377955);
      bndy.a(this.this$0, (ImageView)localViewStub.inflate().findViewById(2131362677));
    }
    bndy.a(this.this$0).postDelayed(bndy.a(this.this$0), this.a.getTotalDuration());
    bndy.a(this.this$0).setVisibility(0);
    bndy.a(this.this$0).setImageDrawable(this.a);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.22
 * JD-Core Version:    0.7.0.1
 */
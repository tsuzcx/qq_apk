package dov.com.qq.im.ae;

import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import bofh;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

public class AEPituCameraUnit$21
  implements Runnable
{
  public AEPituCameraUnit$21(bofh parambofh, LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable) {}
  
  public void run()
  {
    if (bofh.a(this.this$0) == null)
    {
      ViewStub localViewStub = (ViewStub)bofh.b(this.this$0).findViewById(2131378110);
      bofh.a(this.this$0, (ImageView)localViewStub.inflate().findViewById(2131362693));
    }
    bofh.a(this.this$0).postDelayed(bofh.a(this.this$0), this.a.getTotalDuration());
    bofh.a(this.this$0).setVisibility(0);
    bofh.a(this.this$0).setImageDrawable(this.a);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.21
 * JD-Core Version:    0.7.0.1
 */
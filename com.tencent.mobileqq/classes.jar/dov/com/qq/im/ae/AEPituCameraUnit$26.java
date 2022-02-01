package dov.com.qq.im.ae;

import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import bmxa;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

public class AEPituCameraUnit$26
  implements Runnable
{
  public AEPituCameraUnit$26(bmxa parambmxa, LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable) {}
  
  public void run()
  {
    if (bmxa.a(this.this$0) == null)
    {
      ViewStub localViewStub = (ViewStub)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131378167);
      bmxa.a(this.this$0, (ImageView)localViewStub.inflate().findViewById(2131362713));
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(bmxa.a(this.this$0), this.a.getTotalDuration());
    bmxa.a(this.this$0).setVisibility(0);
    bmxa.a(this.this$0).setImageDrawable(this.a);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.26
 * JD-Core Version:    0.7.0.1
 */
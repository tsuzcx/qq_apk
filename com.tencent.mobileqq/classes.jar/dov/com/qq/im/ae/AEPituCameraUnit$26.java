package dov.com.qq.im.ae;

import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

class AEPituCameraUnit$26
  implements Runnable
{
  AEPituCameraUnit$26(AEPituCameraUnit paramAEPituCameraUnit, LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable) {}
  
  public void run()
  {
    if (AEPituCameraUnit.a(this.this$0) == null)
    {
      ViewStub localViewStub = (ViewStub)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131378588);
      AEPituCameraUnit.a(this.this$0, (ImageView)localViewStub.inflate().findViewById(2131362740));
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(AEPituCameraUnit.a(this.this$0), this.a.getTotalDuration());
    AEPituCameraUnit.a(this.this$0).setVisibility(0);
    AEPituCameraUnit.a(this.this$0).setImageDrawable(this.a);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.26
 * JD-Core Version:    0.7.0.1
 */
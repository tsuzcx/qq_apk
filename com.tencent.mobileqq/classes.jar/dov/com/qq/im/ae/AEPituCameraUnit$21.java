package dov.com.qq.im.ae;

import android.os.Handler;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import bljy;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

public class AEPituCameraUnit$21
  implements Runnable
{
  public AEPituCameraUnit$21(bljy parambljy, LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable) {}
  
  public void run()
  {
    if (bljy.a(this.this$0) == null)
    {
      ViewStub localViewStub = (ViewStub)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2131377881);
      bljy.a(this.this$0, (ImageView)localViewStub.inflate().findViewById(2131362698));
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(bljy.a(this.this$0), this.a.getTotalDuration());
    bljy.a(this.this$0).setVisibility(0);
    bljy.a(this.this$0).setImageDrawable(this.a);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.21
 * JD-Core Version:    0.7.0.1
 */
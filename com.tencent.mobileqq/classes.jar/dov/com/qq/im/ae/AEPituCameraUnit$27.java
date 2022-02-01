package dov.com.qq.im.ae;

import android.widget.ImageView;
import bmxa;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

public class AEPituCameraUnit$27
  implements Runnable
{
  public AEPituCameraUnit$27(bmxa parambmxa) {}
  
  public void run()
  {
    bmxa.a(this.this$0).setVisibility(8);
    if (bmxa.a(this.this$0).getDrawable() != null)
    {
      LazyLoadAnimationDrawable localLazyLoadAnimationDrawable = (LazyLoadAnimationDrawable)bmxa.a(this.this$0).getDrawable();
      localLazyLoadAnimationDrawable.stop();
      localLazyLoadAnimationDrawable.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.27
 * JD-Core Version:    0.7.0.1
 */
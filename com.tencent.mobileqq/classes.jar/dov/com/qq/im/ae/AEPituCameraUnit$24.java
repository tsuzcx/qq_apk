package dov.com.qq.im.ae;

import android.widget.ImageView;
import bkle;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

public class AEPituCameraUnit$24
  implements Runnable
{
  public AEPituCameraUnit$24(bkle parambkle) {}
  
  public void run()
  {
    bkle.a(this.this$0).setVisibility(8);
    if (bkle.a(this.this$0).getDrawable() != null)
    {
      LazyLoadAnimationDrawable localLazyLoadAnimationDrawable = (LazyLoadAnimationDrawable)bkle.a(this.this$0).getDrawable();
      localLazyLoadAnimationDrawable.stop();
      localLazyLoadAnimationDrawable.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.24
 * JD-Core Version:    0.7.0.1
 */
package dov.com.qq.im.ae;

import android.widget.ImageView;
import bljy;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

public class AEPituCameraUnit$22
  implements Runnable
{
  public AEPituCameraUnit$22(bljy parambljy) {}
  
  public void run()
  {
    bljy.a(this.this$0).setVisibility(8);
    if (bljy.a(this.this$0).getDrawable() != null)
    {
      LazyLoadAnimationDrawable localLazyLoadAnimationDrawable = (LazyLoadAnimationDrawable)bljy.a(this.this$0).getDrawable();
      localLazyLoadAnimationDrawable.stop();
      localLazyLoadAnimationDrawable.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.22
 * JD-Core Version:    0.7.0.1
 */
package dov.com.qq.im.ae;

import android.widget.ImageView;
import bofh;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

public class AEPituCameraUnit$22
  implements Runnable
{
  public AEPituCameraUnit$22(bofh parambofh) {}
  
  public void run()
  {
    bofh.a(this.this$0).setVisibility(8);
    if (bofh.a(this.this$0).getDrawable() != null)
    {
      LazyLoadAnimationDrawable localLazyLoadAnimationDrawable = (LazyLoadAnimationDrawable)bofh.a(this.this$0).getDrawable();
      localLazyLoadAnimationDrawable.stop();
      localLazyLoadAnimationDrawable.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.22
 * JD-Core Version:    0.7.0.1
 */
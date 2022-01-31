package dov.com.qq.im.ae;

import android.widget.ImageView;
import bkpl;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

public class AEPituCameraUnit$24
  implements Runnable
{
  public AEPituCameraUnit$24(bkpl parambkpl) {}
  
  public void run()
  {
    bkpl.a(this.this$0).setVisibility(8);
    if (bkpl.a(this.this$0).getDrawable() != null)
    {
      LazyLoadAnimationDrawable localLazyLoadAnimationDrawable = (LazyLoadAnimationDrawable)bkpl.a(this.this$0).getDrawable();
      localLazyLoadAnimationDrawable.stop();
      localLazyLoadAnimationDrawable.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.24
 * JD-Core Version:    0.7.0.1
 */
package dov.com.qq.im.ae;

import android.widget.ImageView;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

class AEPituCameraUnit$27
  implements Runnable
{
  AEPituCameraUnit$27(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void run()
  {
    AEPituCameraUnit.a(this.this$0).setVisibility(8);
    if (AEPituCameraUnit.a(this.this$0).getDrawable() != null)
    {
      LazyLoadAnimationDrawable localLazyLoadAnimationDrawable = (LazyLoadAnimationDrawable)AEPituCameraUnit.a(this.this$0).getDrawable();
      localLazyLoadAnimationDrawable.stop();
      localLazyLoadAnimationDrawable.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.27
 * JD-Core Version:    0.7.0.1
 */
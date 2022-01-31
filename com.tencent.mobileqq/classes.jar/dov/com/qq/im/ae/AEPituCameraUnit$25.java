package dov.com.qq.im.ae;

import android.widget.ImageView;
import bijd;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

public class AEPituCameraUnit$25
  implements Runnable
{
  public AEPituCameraUnit$25(bijd parambijd) {}
  
  public void run()
  {
    bijd.a(this.this$0).setVisibility(8);
    if (bijd.a(this.this$0).getDrawable() != null)
    {
      LazyLoadAnimationDrawable localLazyLoadAnimationDrawable = (LazyLoadAnimationDrawable)bijd.a(this.this$0).getDrawable();
      localLazyLoadAnimationDrawable.stop();
      localLazyLoadAnimationDrawable.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.25
 * JD-Core Version:    0.7.0.1
 */
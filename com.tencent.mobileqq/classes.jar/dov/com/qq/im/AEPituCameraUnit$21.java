package dov.com.qq.im;

import android.widget.ImageView;
import bhcw;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

public class AEPituCameraUnit$21
  implements Runnable
{
  public AEPituCameraUnit$21(bhcw parambhcw) {}
  
  public void run()
  {
    bhcw.a(this.this$0).setVisibility(8);
    if (bhcw.a(this.this$0).getDrawable() != null)
    {
      LazyLoadAnimationDrawable localLazyLoadAnimationDrawable = (LazyLoadAnimationDrawable)bhcw.a(this.this$0).getDrawable();
      localLazyLoadAnimationDrawable.stop();
      localLazyLoadAnimationDrawable.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AEPituCameraUnit.21
 * JD-Core Version:    0.7.0.1
 */
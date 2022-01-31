package dov.com.qq.im;

import android.os.Handler;
import android.widget.ImageView;
import bhcw;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

public class AEPituCameraUnit$20
  implements Runnable
{
  public AEPituCameraUnit$20(bhcw parambhcw, LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable) {}
  
  public void run()
  {
    bhcw.a(this.this$0).postDelayed(bhcw.a(this.this$0), this.a.getTotalDuration());
    bhcw.a(this.this$0).setVisibility(0);
    bhcw.a(this.this$0).setImageDrawable(this.a);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AEPituCameraUnit.20
 * JD-Core Version:    0.7.0.1
 */
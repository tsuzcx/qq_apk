package cooperation.qzone.zipanimate;

import bkbb;
import bkbe;
import bkbf;
import bkbg;

public class ZipAnimationDrawable$ZipAnimationState$1$1
  implements Runnable
{
  public ZipAnimationDrawable$ZipAnimationState$1$1(bkbg parambkbg) {}
  
  public void run()
  {
    if (this.a.a.a.a != null) {
      this.a.a.a.a.onDrawableLoaded();
    }
    if (bkbb.b(this.a.a.a)) {
      this.a.a.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipAnimationDrawable.ZipAnimationState.1.1
 * JD-Core Version:    0.7.0.1
 */
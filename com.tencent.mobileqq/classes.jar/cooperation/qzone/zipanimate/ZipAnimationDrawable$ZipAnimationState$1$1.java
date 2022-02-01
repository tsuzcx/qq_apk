package cooperation.qzone.zipanimate;

import bnqp;
import bnqs;
import bnqt;
import bnqu;

public class ZipAnimationDrawable$ZipAnimationState$1$1
  implements Runnable
{
  public ZipAnimationDrawable$ZipAnimationState$1$1(bnqu parambnqu) {}
  
  public void run()
  {
    if (this.a.a.a.a != null) {
      this.a.a.a.a.onDrawableLoaded();
    }
    if (bnqp.a(this.a.a.a)) {
      this.a.a.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipAnimationDrawable.ZipAnimationState.1.1
 * JD-Core Version:    0.7.0.1
 */
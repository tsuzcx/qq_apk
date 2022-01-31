import android.os.Handler;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqstory.view.AnimationPoint;

public class opu
  implements Runnable
{
  public opu(AnimationPoint paramAnimationPoint) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      return;
    }
    if ((System.currentTimeMillis() - this.a.c < this.a.b) || (this.a.b < 0L)) {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 30L);
    }
    for (;;)
    {
      this.a.invalidate();
      return;
      if (this.a.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener != null) {
        this.a.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener.onAnimationEnd(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opu
 * JD-Core Version:    0.7.0.1
 */
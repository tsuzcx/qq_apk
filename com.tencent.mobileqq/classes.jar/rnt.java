import android.view.View;
import android.view.animation.Animation;
import com.tencent.qphone.base.util.QLog;

class rnt
  extends bhry
{
  rnt(rnr paramrnr) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsVideoUIDelegate", 2, "onVideoEndSoon disappearAnim onAnimationEnd: ");
    }
    this.a.a.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rnt
 * JD-Core Version:    0.7.0.1
 */
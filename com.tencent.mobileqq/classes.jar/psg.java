import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

class psg
  extends AnimatorListenerAdapter
{
  psg(psf parampsf) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    psf.a(this.a).setLayerType(0, null);
    psf.a(this.a).setVisibility(8);
    psf.a(this.a).setAlpha(1.0F);
    if (this.a.a() != null) {
      this.a.i();
    }
    psf.a(this.a).setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.videoanimation", 2, "trans animation end");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psg
 * JD-Core Version:    0.7.0.1
 */
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

class qdd
  extends AnimatorListenerAdapter
{
  qdd(qdc paramqdc) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    qdc.a(this.a).setLayerType(0, null);
    qdc.a(this.a).setVisibility(8);
    qdc.a(this.a).setAlpha(1.0F);
    if (this.a.a() != null) {
      this.a.i();
    }
    qdc.a(this.a).setVisibility(8);
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
 * Qualified Name:     qdd
 * JD-Core Version:    0.7.0.1
 */
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;

class tdl
  implements Animator.AnimatorListener
{
  tdl(tdi paramtdi) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    tdi.a(this.a).setVisibility(8);
    tdi.b(this.a).setVisibility(0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a();
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putLong("search_hotword_show_lasttime", System.currentTimeMillis()).commit();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdl
 * JD-Core Version:    0.7.0.1
 */
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class rtw
  extends AnimatorListenerAdapter
{
  public rtw(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    ReadInJoyListViewGroup.a(this.a).setLayerType(0, null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.videoanimation", 2, "alpha animation end");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rtw
 * JD-Core Version:    0.7.0.1
 */
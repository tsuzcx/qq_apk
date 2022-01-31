import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

public class rsv
  extends AnimatorListenerAdapter
{
  public rsv(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    ReadInJoyListViewGroup.a(this.a).setLayerType(0, null);
    ReadInJoyListViewGroup.a(this.a).setVisibility(8);
    this.a.a.setAlpha(1.0F);
    if (ReadInJoyListViewGroup.a(this.a) != null) {
      ReadInJoyListViewGroup.a(this.a).i();
    }
    ReadInJoyListViewGroup.a(this.a).setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.videoanimation", 2, "trans animation end");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rsv
 * JD-Core Version:    0.7.0.1
 */
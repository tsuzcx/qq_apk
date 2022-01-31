import android.content.res.Resources;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;

public class sov
  implements Runnable
{
  public sov(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void run()
  {
    this.a.f = false;
    if (!this.a.jdField_c_of_type_Boolean) {
      this.a.b.setVisibility(0);
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.a.getResources().getDimension(2131558775), 0.0F);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sov
 * JD-Core Version:    0.7.0.1
 */
import android.content.res.Resources;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.widget.MusicPendantView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils.AnimationAdapter;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class sve
  extends AnimateUtils.AnimationAdapter
{
  public sve(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool2 = true;
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder().append("onAnimationStart, [");
      if (paramAnimation != this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation) {
        break label106;
      }
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(",");
      if (paramAnimation != this.a.jdField_b_of_type_AndroidViewAnimationAlphaAnimation) {
        break label111;
      }
    }
    label106:
    label111:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.i("Q.profilecard.FrdProfileCard", 4, bool1 + "]");
      if (this.a.d != null) {
        break label116;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 4, "centerView is null");
      }
      return;
      bool1 = false;
      break;
    }
    label116:
    if (paramAnimation == this.a.jdField_b_of_type_AndroidViewAnimationAlphaAnimation)
    {
      this.a.d.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
      this.a.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845349);
      this.a.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131494194));
      this.a.c.setTextColor(this.a.getResources().getColor(2131494194));
      this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839170);
    }
    this.a.d.clearAnimation();
    this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.clearAnimation();
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    boolean bool;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onAnimationStart, [");
      if (paramAnimation == this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation)
      {
        bool = true;
        localStringBuilder = localStringBuilder.append(bool).append(",");
        if (paramAnimation != this.a.jdField_b_of_type_AndroidViewAnimationAlphaAnimation) {
          break label105;
        }
        bool = true;
        label56:
        QLog.i("Q.profilecard.FrdProfileCard", 4, bool + "]");
      }
    }
    else
    {
      if (this.a.d != null) {
        break label110;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 4, "centerView is null");
      }
    }
    label105:
    label110:
    do
    {
      return;
      bool = false;
      break;
      bool = false;
      break label56;
      if (paramAnimation == this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation)
      {
        this.a.d.setVisibility(0);
        this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetMusicPendantView.setVisibility(4);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetMusicPendantView.b = true;
        this.a.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130846346);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131494216));
        this.a.c.setTextColor(this.a.getResources().getColor(2131494216));
      }
    } while (paramAnimation != this.a.jdField_b_of_type_AndroidViewAnimationAlphaAnimation);
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetMusicPendantView.a) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetMusicPendantView.setVisibility(0);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetMusicPendantView.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sve
 * JD-Core Version:    0.7.0.1
 */
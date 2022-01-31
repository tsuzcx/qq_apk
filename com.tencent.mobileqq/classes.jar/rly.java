import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.AccountManageActivity;

public class rly
  implements Animation.AnimationListener
{
  int jdField_a_of_type_Int = -1;
  View jdField_a_of_type_AndroidViewView;
  
  public rly(AccountManageActivity paramAccountManageActivity, View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 0: 
      paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramAnimation.leftMargin += (int)(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a * 34.0F);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimation);
      this.jdField_a_of_type_AndroidViewView.setTag("right");
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      return;
      paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramAnimation.leftMargin -= (int)(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a * 34.0F);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimation);
      this.jdField_a_of_type_AndroidViewView.setTag("left");
      continue;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidViewView.getId() == 2131362761)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c();
        continue;
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation = (String)this.jdField_a_of_type_AndroidViewView.getTag();
    if ((this.jdField_a_of_type_Int == 1) && (paramAnimation.equals("left")))
    {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      this.jdField_a_of_type_Int = 6;
    }
    if ((this.jdField_a_of_type_Int == 0) && (paramAnimation.equals("right")))
    {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      this.jdField_a_of_type_Int = 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rly
 * JD-Core Version:    0.7.0.1
 */
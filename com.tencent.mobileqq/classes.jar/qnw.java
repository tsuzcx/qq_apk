import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.view.KandianTipFloatingWindow.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class qnw
  implements View.OnClickListener, Animation.AnimationListener
{
  private View jdField_a_of_type_AndroidViewView;
  protected Animation a;
  private qnx jdField_a_of_type_Qnx;
  
  public void a()
  {
    a(true);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Qnx == null) {
      return;
    }
    if ((this.jdField_a_of_type_Qnx.jdField_a_of_type_Int != 0) || (this.jdField_a_of_type_Qnx.jdField_a_of_type_Int == 1)) {}
    switch (paramInt)
    {
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Qnx == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("KandianTipFloatingWindow", 2, "close tip window , type : " + this.jdField_a_of_type_Qnx.jdField_a_of_type_Int + ", uin : " + this.jdField_a_of_type_Qnx.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Qnx = null;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((paramAnimation.equals(this.jdField_a_of_type_AndroidViewAnimationAnimation)) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    a(2);
    qnx localqnx = this.jdField_a_of_type_Qnx;
    if ((localqnx != null) && (localqnx.jdField_a_of_type_AndroidViewView$OnClickListener != null)) {
      ThreadManager.getUIHandler().postDelayed(new KandianTipFloatingWindow.1(this, localqnx, paramView), 250L);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qnw
 * JD-Core Version:    0.7.0.1
 */
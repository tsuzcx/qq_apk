import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qphone.base.util.QLog;

class rdc
  extends GestureDetector.SimpleOnGestureListener
{
  rdc(rdb paramrdb) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    ViewGroup.LayoutParams localLayoutParams;
    if ((paramFloat1 > 0.0F) && (Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (Math.abs(paramFloat1) > 20.0F) && (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c) && (this.a.jdField_a_of_type_AndroidViewView != null))
    {
      paramMotionEvent1 = this.a.jdField_a_of_type_AndroidViewView.findViewById(2131362723);
      if (paramMotionEvent1 != null)
      {
        if (paramMotionEvent1.getVisibility() == 0) {
          break label446;
        }
        if (AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("AccountManage", 2, "hide previous selectedAccountView");
          }
          paramMotionEvent2 = AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity, AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity));
          if ((paramMotionEvent2 instanceof ShaderAnimLayout)) {
            ((ShaderAnimLayout)paramMotionEvent2).f();
          }
          AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity).a();
          paramMotionEvent2 = AccountManageActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity, AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity));
          localLayoutParams = paramMotionEvent2.getLayoutParams();
          if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a) {
            break label395;
          }
          localLayoutParams.width = ((int)(AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) - AccountManageActivity.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) * 40.0F));
          paramMotionEvent2.setLayoutParams(localLayoutParams);
        }
        if (QLog.isColorLevel()) {
          QLog.i("AccountManage", 2, "show current selectedAccountView");
        }
        ((ShaderAnimLayout)paramMotionEvent1).b();
        AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity, (RotateSwitchImageView)this.a.jdField_a_of_type_AndroidViewView.findViewById(2131362734));
        AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity).b();
        paramMotionEvent1 = AccountManageActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity, AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity));
        paramMotionEvent2 = paramMotionEvent1.getLayoutParams();
        if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a) {
          break label414;
        }
      }
    }
    label395:
    label414:
    for (paramMotionEvent2.width = ((int)(AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) - 75.0F * AccountManageActivity.d(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity)));; paramMotionEvent2.width = ((int)(AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) - 35.0F * AccountManageActivity.e(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity))))
    {
      paramMotionEvent1.setLayoutParams(paramMotionEvent2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(true);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c = true;
      this.a.jdField_a_of_type_AndroidViewView.setPressed(false);
      return true;
      localLayoutParams.width = ((int)AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity));
      break;
    }
    label446:
    if (QLog.isColorLevel()) {
      QLog.i("AccountManage", 2, "hide current selectedAccountView");
    }
    ((ShaderAnimLayout)paramMotionEvent1).f();
    if (AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) != null)
    {
      AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity).a();
      paramMotionEvent1 = AccountManageActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity, AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity));
      paramMotionEvent2 = paramMotionEvent1.getLayoutParams();
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a) {
        break label626;
      }
    }
    label626:
    for (paramMotionEvent2.width = ((int)(AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) - AccountManageActivity.f(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) * 40.0F));; paramMotionEvent2.width = ((int)AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity)))
    {
      paramMotionEvent1.setLayoutParams(paramMotionEvent2);
      AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity, null);
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(false);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c = true;
      this.a.jdField_a_of_type_AndroidViewView.setPressed(false);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rdc
 * JD-Core Version:    0.7.0.1
 */
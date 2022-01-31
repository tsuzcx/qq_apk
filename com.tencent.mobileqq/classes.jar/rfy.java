import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.qphone.base.util.QLog;

public class rfy
  implements View.OnTouchListener
{
  private GestureDetector.SimpleOnGestureListener jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new rfz(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener);
  View jdField_a_of_type_AndroidViewView;
  
  public rfy(AccountManageActivity paramAccountManageActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("AccountManage", 2, "action = " + i);
    }
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c == true) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c = false;
      }
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    if (QLog.isColorLevel()) {
      QLog.i("AccountManage", 2, "onTouch return mHasSlide " + this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rfy
 * JD-Core Version:    0.7.0.1
 */
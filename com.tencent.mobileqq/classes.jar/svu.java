import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.troop.widget.ProfileGuideHelper;

public class svu
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public svu(FriendProfileCardActivity paramFriendProfileCardActivity, View paramView, int paramInt1, int paramInt2) {}
  
  public void onGlobalLayout()
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    int j = this.jdField_a_of_type_AndroidViewView.getHeight();
    if ((i + j <= this.jdField_a_of_type_Int - this.b) && (i != this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.k))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.a(i, j, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.k = i;
    }
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     svu
 * JD-Core Version:    0.7.0.1
 */
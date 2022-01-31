import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.ProfileCardUtil;

public class rqq
  implements View.OnClickListener
{
  public rqq(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.dismissDialog(230);
    ProfileCardUtil.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, null, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1101, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rqq
 * JD-Core Version:    0.7.0.1
 */
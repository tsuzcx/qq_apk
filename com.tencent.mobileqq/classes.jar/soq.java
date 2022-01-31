import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.utils.NetworkUtil;

class soq
  implements DialogInterface.OnClickListener
{
  soq(sop paramsop) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.g(this.a.jdField_a_of_type_Sol.a))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.c(this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_Sol.a.H();
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.j();
    this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.a.jdField_a_of_type_Sol.a.a.a.jdField_a_of_type_JavaLangString, "");
    this.a.jdField_a_of_type_Sol.a.a("请确认网络状态后重试", 0);
    this.a.jdField_a_of_type_Sol.a.G();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     soq
 * JD-Core Version:    0.7.0.1
 */
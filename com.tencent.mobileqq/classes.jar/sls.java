import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.utils.NetworkUtil;

class sls
  implements DialogInterface.OnClickListener
{
  sls(slr paramslr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.g(this.a.jdField_a_of_type_Sln.a))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.c(this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_Sln.a.I();
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.j();
    this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.a.jdField_a_of_type_Sln.a.a.a.jdField_a_of_type_JavaLangString, "");
    this.a.jdField_a_of_type_Sln.a.a("请确认网络状态后重试", 0);
    this.a.jdField_a_of_type_Sln.a.H();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sls
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class rgo
  implements Runnable
{
  public rgo(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3) {}
  
  public void run()
  {
    String str1;
    QQAppInterface localQQAppInterface;
    String str3;
    if ((this.jdField_a_of_type_Int == 3004) && (this.b == 5))
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label75;
      }
      str1 = "multiMode_send";
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app;
      str3 = this.jdField_a_of_type_JavaLangString;
      if (!this.jdField_a_of_type_Boolean) {
        break label81;
      }
    }
    label75:
    label81:
    for (String str2 = "1";; str2 = String.valueOf(this.c))
    {
      ReportController.b(localQQAppInterface, "dc00899", "Grp_addFrd", "", "frd_select", str1, 0, 0, str3, str2, "", "");
      return;
      str1 = "singleMode_send";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rgo
 * JD-Core Version:    0.7.0.1
 */
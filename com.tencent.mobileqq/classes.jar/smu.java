import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.statistics.ReportController;

public class smu
  implements Runnable
{
  public smu(Conversation paramConversation, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    long l = ServiceAccountFolderManager.a().a();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a, "dc00899", "Pb_account_lifeservice", "", "0X8006E12", "0X8006E12", 0, 0, String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     smu
 * JD-Core Version:    0.7.0.1
 */
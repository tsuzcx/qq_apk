import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import mqq.os.MqqHandler;

public class rzl
  implements Runnable
{
  public rzl(ChatHistory paramChatHistory, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = null;
    if (this.jdField_a_of_type_Boolean) {
      localStringBuilder = new StringBuilder();
    }
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager.a(MessageRecord.getTableName(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Int));
    }
    int j = ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Int, localStringBuilder);
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(this.jdField_a_of_type_Int);
    if ((localStringBuilder != null) && (localStringBuilder.length() > 0)) {
      localMessage.obj = localStringBuilder.toString();
    }
    localMessage.arg1 = j;
    localMessage.arg2 = i;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rzl
 * JD-Core Version:    0.7.0.1
 */
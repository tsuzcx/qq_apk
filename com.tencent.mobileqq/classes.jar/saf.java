import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class saf
  implements Runnable
{
  public saf(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.app.a().a((MessageRecord)this.jdField_a_of_type_JavaUtilList.get(0), false);
    }
    while ((this.b != null) && (this.b.size() > 0))
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
        localFileManagerEntity.bDelInAio = true;
        if (QLog.isDevelopLevel()) {
          QLog.d("ChatHistoryFIleActivity", 1, "ChatHistory entity[" + localFileManagerEntity.getId() + "] del File:" + localFileManagerEntity.nSessionId);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.app.a().b(localFileManagerEntity.nSessionId);
      }
      if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.app.a().a(this.jdField_a_of_type_JavaUtilList, false);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     saf
 * JD-Core Version:    0.7.0.1
 */
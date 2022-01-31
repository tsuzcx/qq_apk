import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import java.util.Iterator;
import java.util.List;

public class sad
  implements FMDialogUtil.FMDialogInterface
{
  public sad(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList, FileManagerEngine paramFileManagerEngine) {}
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine.b(localFileManagerEntity);
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sad
 * JD-Core Version:    0.7.0.1
 */
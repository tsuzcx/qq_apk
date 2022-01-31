import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.Iterator;
import java.util.List;

public class sae
  implements FMDialogUtil.FMDialogInterface
{
  public sae(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList, FileManagerEngine paramFileManagerEngine) {}
  
  public void a()
  {
    Iterator localIterator;
    if (this.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      FMToastUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.getString(2131428195));
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful())
      {
        if (FileUtils.b(localFileManagerEntity.getFilePath()))
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine.a(localFileManagerEntity.getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.app.getCurrentAccountUin(), 0, false);
          continue;
          FMToastUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.getString(2131428195));
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sae
 * JD-Core Version:    0.7.0.1
 */
package cooperation.qqdataline.ipc;

import android.content.Context;
import android.content.Intent;
import aonm;
import apck;
import bfhb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class DatalineRemoteManager$7
  implements Runnable
{
  public DatalineRemoteManager$7(bfhb parambfhb, FileManagerEntity paramFileManagerEntity, ForwardFileInfo paramForwardFileInfo) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.this$0.a.getApplication().getApplicationContext(), FileBrowserActivity.class);
    localIntent.addFlags(268435456);
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 1))
    {
      if (!apck.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath())) {
        break label163;
      }
      localObject = new FileInfo();
      ((FileInfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d());
      ((FileInfo)localObject).d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d());
      ((FileInfo)localObject).e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a());
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      aonm.a(localArrayList);
      localIntent.putExtra("clicked_file_hashcode", ((FileInfo)localObject).hashCode());
    }
    for (;;)
    {
      localIntent.putExtra("fileinfo", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo);
      this.this$0.a.getApplication().getApplicationContext().startActivity(localIntent);
      return;
      label163:
      localObject = new ArrayList();
      ((ArrayList)localObject).add(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId));
      localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineRemoteManager.7
 * JD-Core Version:    0.7.0.1
 */
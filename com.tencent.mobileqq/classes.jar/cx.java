import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.DatalineFilesAdapter.ItemHolder;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;

public class cx
  implements View.OnClickListener
{
  public cx(DatalineFilesAdapter paramDatalineFilesAdapter) {}
  
  public void onClick(View paramView)
  {
    paramView = (DatalineFilesAdapter.ItemHolder)paramView.getTag();
    if (paramView.a == null) {}
    do
    {
      return;
      int i = DataLineMsgRecord.getDevTypeBySeId(paramView.a.a);
      localObject = DatalineFilesAdapter.a(this.a).a().a(i).a(paramView.a.a);
    } while (localObject == null);
    paramView = FileManagerUtil.a((DataLineMsgRecord)localObject);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(10009);
    localForwardFileInfo.d(6);
    localForwardFileInfo.b(paramView.nSessionId);
    localForwardFileInfo.d(((DataLineMsgRecord)localObject).filename);
    localForwardFileInfo.c(((DataLineMsgRecord)localObject).sessionid);
    localForwardFileInfo.d(((DataLineMsgRecord)localObject).filesize);
    localForwardFileInfo.a(((DataLineMsgRecord)localObject).path);
    Object localObject = new Intent(DatalineFilesAdapter.a(this.a).getApplicationContext(), FileBrowserActivity.class);
    if ((paramView.nFileType == 0) || (paramView.nFileType == 1))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(String.valueOf(paramView.nSessionId));
      ((Intent)localObject).putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
    }
    ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
    DatalineFilesAdapter.a(this.a).startActivityForResult((Intent)localObject, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     cx
 * JD-Core Version:    0.7.0.1
 */
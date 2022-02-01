package cooperation.qqdataline.ipc;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import mqq.app.MobileQQ;

class DatalineRemoteManager$8
  implements Runnable
{
  DatalineRemoteManager$8(DatalineRemoteManager paramDatalineRemoteManager, FileManagerEntity paramFileManagerEntity, ForwardFileInfo paramForwardFileInfo) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.this$0.a.getApplication().getApplicationContext(), FileBrowserActivity.class);
    localIntent.addFlags(268435456);
    if ((this.a.nFileType == 0) || (this.a.nFileType == 1))
    {
      Object localObject;
      if (FileManagerUtil.n(this.a.getFilePath()))
      {
        localObject = new FileInfo();
        ((FileInfo)localObject).a(this.b.j());
        ((FileInfo)localObject).d(this.b.i());
        ((FileInfo)localObject).f(this.b.d());
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject);
        ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).addFileViewerLocalFiles(localArrayList);
        localIntent.putExtra("clicked_file_hashcode", ((FileInfo)localObject).hashCode());
      }
      else
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(String.valueOf(this.a.nSessionId));
        localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject);
      }
    }
    localIntent.putExtra("fileinfo", this.b);
    this.this$0.a.getApplication().getApplicationContext().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineRemoteManager.8
 * JD-Core Version:    0.7.0.1
 */
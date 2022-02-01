import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.util.file.DLFileInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ds
  implements View.OnClickListener
{
  ds(dr paramdr) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = (dv)paramView.getTag();
    if (((dv)localObject1).a == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = DataLineMsgRecord.getDevTypeBySeId(((dv)localObject1).a.a);
      Object localObject2 = dr.a(this.a).a().a(i).a(((dv)localObject1).a.a);
      if (localObject2 != null)
      {
        localObject1 = aunj.a((DataLineMsgRecord)localObject2);
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.b(10009);
        localForwardFileInfo.d(6);
        localForwardFileInfo.b(((FileManagerEntity)localObject1).nSessionId);
        localForwardFileInfo.d(((DataLineMsgRecord)localObject2).filename);
        localForwardFileInfo.c(((DataLineMsgRecord)localObject2).sessionid);
        localForwardFileInfo.d(((DataLineMsgRecord)localObject2).filesize);
        localForwardFileInfo.a(((DataLineMsgRecord)localObject2).path);
        localObject2 = new Intent(dr.a(this.a).getApplicationContext(), FileBrowserActivity.class);
        if ((((FileManagerEntity)localObject1).nFileType == 0) || (((FileManagerEntity)localObject1).nFileType == 1))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(String.valueOf(((FileManagerEntity)localObject1).nSessionId));
          ((Intent)localObject2).putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
        }
        ((Intent)localObject2).putExtra("fileinfo", localForwardFileInfo);
        dr.a(this.a).startActivityForResult((Intent)localObject2, 102);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ds
 * JD-Core Version:    0.7.0.1
 */
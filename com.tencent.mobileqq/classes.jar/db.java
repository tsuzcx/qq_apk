import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteMutiPicViewerActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.dataline.util.ItemHolder;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardFileOption;
import java.util.ArrayList;
import java.util.Iterator;

public class db
  implements View.OnClickListener
{
  public db(DatalineSessionAdapter paramDatalineSessionAdapter) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.a()) {}
    do
    {
      return;
      this.a.a();
      localObject1 = ((ItemHolder)paramView.getTag()).a();
      paramView = ((DataLineMsgSet)localObject1).getFirstItem();
      if (!((DataLineMsgSet)localObject1).isSingle()) {
        break;
      }
    } while (-1000 == paramView.msgtype);
    Object localObject1 = FileManagerUtil.a(paramView);
    if ((paramView.nOpType == 31) || (FileManagerUtil.d((FileManagerEntity)localObject1)))
    {
      DatalineSessionAdapter.a(this.a, paramView);
      return;
    }
    if (paramView.nOpType == 29)
    {
      DatalineSessionAdapter.b(this.a, paramView);
      return;
    }
    ForwardFileInfo localForwardFileInfo = ForwardFileOption.a((FileManagerEntity)localObject1);
    localForwardFileInfo.b(10009);
    Intent localIntent = new Intent(DatalineSessionAdapter.a(this.a).getApplicationContext(), FileBrowserActivity.class);
    localIntent.putExtra("_from_aio_", true);
    ArrayList localArrayList = new ArrayList();
    if ((((FileManagerEntity)localObject1).nFileType == 0) || (((FileManagerEntity)localObject1).nFileType == 1))
    {
      Iterator localIterator = DatalineSessionAdapter.a(this.a).iterator();
      label330:
      while (localIterator.hasNext())
      {
        Object localObject2 = (DataLineMsgSet)localIterator.next();
        if (((DataLineMsgSet)localObject2).isSingle())
        {
          localObject2 = ((DataLineMsgSet)localObject2).values().iterator();
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label330;
            }
            DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject2).next();
            int j = FileManagerUtil.a(localDataLineMsgRecord.filename);
            int i = j;
            if (j == -1)
            {
              i = j;
              if (localDataLineMsgRecord.msgtype == -2000) {
                i = 0;
              }
            }
            if (i != ((FileManagerEntity)localObject1).nFileType) {
              break;
            }
            if (localDataLineMsgRecord != paramView) {
              localArrayList.add(String.valueOf(FileManagerUtil.a(localDataLineMsgRecord).nSessionId));
            } else {
              localArrayList.add(String.valueOf(((FileManagerEntity)localObject1).nSessionId));
            }
          }
        }
      }
      if (localArrayList.size() == 0) {
        localArrayList.add(String.valueOf(((FileManagerEntity)localObject1).nSessionId));
      }
      localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
    }
    localIntent.putExtra("fileinfo", localForwardFileInfo);
    DatalineSessionAdapter.a(this.a).startActivityForResult(localIntent, 102);
    return;
    if (((DataLineMsgSet)localObject1).getGroupType() == -2000)
    {
      paramView = new Intent(DatalineSessionAdapter.a(this.a), LiteMutiPicViewerActivity.class);
      paramView.putExtra("dataline_group_id", ((DataLineMsgSet)localObject1).getGroupId());
      DatalineSessionAdapter.a(this.a).startActivity(paramView);
      return;
    }
    paramView = new Intent(DatalineSessionAdapter.a(this.a), DLFilesViewerActivity.class);
    paramView.putExtra("dl_files_groupid", ((DataLineMsgSet)localObject1).getGroupId());
    DatalineSessionAdapter.a(this.a).startActivityForResult(paramView, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     db
 * JD-Core Version:    0.7.0.1
 */
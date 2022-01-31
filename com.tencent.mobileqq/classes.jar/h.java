import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h
  implements View.OnClickListener
{
  public h(DLFilesViewerActivity paramDLFilesViewerActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = null;
    paramView = DLFilesViewerActivity.a(this.a).values().iterator();
    Object localObject2;
    do
    {
      if (!paramView.hasNext()) {
        break;
      }
      localObject2 = DatalineFilesAdapter.a((DataLineMsgRecord)paramView.next());
    } while ((((DLFileInfo)localObject2).a != 0) && (((DLFileInfo)localObject2).a != 3));
    for (int i = 1;; i = 0)
    {
      DataLineHandler localDataLineHandler = (DataLineHandler)this.a.app.a(8);
      if (i != 0)
      {
        if ((!DLFilesViewerActivity.a(this.a).isReportPause) && (DLFilesViewerActivity.a(this.a).getGroupType() == -2335))
        {
          DLFilesViewerActivity.a(this.a).isReportPause = true;
          DataLineReportUtil.m(this.a.app);
        }
        DLFilesViewerActivity.a(this.a).setPaused(true);
        if ((!DLFilesViewerActivity.a(this.a).isSingle()) && (DLFilesViewerActivity.a(this.a).getGroupType() != -2335))
        {
          localDataLineHandler.a(DLFilesViewerActivity.a(this.a).getGroupId(), 0L, false);
          DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
        }
      }
      for (;;)
      {
        DLFilesViewerActivity.a(this.a);
        return;
        paramView = DLFilesViewerActivity.a(this.a).values().iterator();
        while (paramView.hasNext())
        {
          localObject1 = (DataLineMsgRecord)paramView.next();
          localObject2 = DatalineFilesAdapter.a((DataLineMsgRecord)localObject1);
          if ((((DLFileInfo)localObject2).a == 0) || (((DLFileInfo)localObject2).a == 3)) {
            localDataLineHandler.a(((DataLineMsgRecord)localObject1).groupId, ((DataLineMsgRecord)localObject1).sessionid, false);
          }
        }
        break;
        if (NetworkUtil.d(this.a))
        {
          if ((FileManagerUtil.a()) && (DLFilesViewerActivity.a(this.a).getFileTotalSize() > 3145728L))
          {
            paramView = DLFilesViewerActivity.a(this.a).getFirstItem();
            FileManagerUtil.a(paramView.isSendFromLocal(), this.a, new i(this, paramView, localDataLineHandler));
          }
          else
          {
            paramView = DLFilesViewerActivity.a(this.a).getFirstItem();
            if ((paramView != null) && (!paramView.isSendFromLocal()) && (paramView.strMoloKey != null)) {
              localDataLineHandler.b(112);
            }
            DLFilesViewerActivity.a(this.a).setPaused(false);
            Iterator localIterator = DLFilesViewerActivity.a(this.a).values().iterator();
            paramView = null;
            if (localIterator.hasNext())
            {
              DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
              DLFileInfo localDLFileInfo = DatalineFilesAdapter.a(localDataLineMsgRecord);
              if (localDLFileInfo.a == 1)
              {
                localObject2 = localObject1;
                if (localObject1 == null) {
                  localObject2 = new ArrayList();
                }
                ((ArrayList)localObject2).add(localDataLineMsgRecord);
                localObject1 = localObject2;
              }
              for (;;)
              {
                break;
                if (localDLFileInfo.a != 4)
                {
                  localObject2 = paramView;
                  if (localDLFileInfo.a != 2) {}
                }
                else
                {
                  if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null)) {
                    DataLineReportUtil.e(this.a.app);
                  }
                  localObject2 = paramView;
                  if (paramView == null) {
                    localObject2 = new ArrayList();
                  }
                  ((List)localObject2).add(Long.valueOf(localDataLineMsgRecord.sessionid));
                  localDataLineMsgRecord.fileMsgStatus = 0L;
                  i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
                  this.a.app.a().a(i).c(localDataLineMsgRecord.msgId);
                }
                paramView = (View)localObject2;
              }
            }
            if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
              localDataLineHandler.a((ArrayList)localObject1, true);
            }
            if ((paramView != null) && (paramView.size() > 0)) {
              localDataLineHandler.a(paramView);
            }
            DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
          }
        }
        else {
          FMToastUtil.a(2131434596);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     h
 * JD-Core Version:    0.7.0.1
 */
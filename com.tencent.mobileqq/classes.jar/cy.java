import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.DatalineFilesAdapter.ItemHolder;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;

public class cy
  implements View.OnClickListener
{
  public cy(DatalineFilesAdapter paramDatalineFilesAdapter) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject = (DatalineFilesAdapter.ItemHolder)paramView.getTag();
    int i = DataLineMsgRecord.getDevTypeBySeId(((DatalineFilesAdapter.ItemHolder)localObject).a.jdField_a_of_type_Long);
    paramView = DatalineFilesAdapter.a(this.a).a().a(i).a(((DatalineFilesAdapter.ItemHolder)localObject).a.jdField_a_of_type_Long);
    if (paramView == null) {
      return;
    }
    DLFileInfo localDLFileInfo = ((DatalineFilesAdapter.ItemHolder)localObject).a;
    switch (localDLFileInfo.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
    case 3: 
      localObject = (DataLineHandler)DatalineFilesAdapter.a(this.a).a(8);
      if ((paramView.strMoloKey != null) && (!paramView.isReportPause))
      {
        paramView.isReportPause = true;
        DataLineReportUtil.m(DatalineFilesAdapter.a(this.a));
      }
      ((DataLineHandler)localObject).a(paramView.groupId, paramView.sessionid, false);
      if (paramView.isSendFromLocal())
      {
        localDLFileInfo.jdField_a_of_type_Int = 1;
        return;
      }
      break;
    case 1: 
    case 2: 
    case 4: 
      if (NetworkUtil.d(DatalineFilesAdapter.a(this.a)))
      {
        if ((FileManagerUtil.a()) && (localDLFileInfo.b > 3145728L))
        {
          if (localDLFileInfo.jdField_a_of_type_Int == 1) {}
          for (;;)
          {
            FileManagerUtil.a(bool, DatalineFilesAdapter.a(this.a), new cz(this, paramView, (DatalineFilesAdapter.ItemHolder)localObject));
            return;
            bool = false;
          }
        }
        i = DataLineMsgRecord.getDevTypeBySeId(paramView.sessionid);
        DataLineMsgSet localDataLineMsgSet = DatalineFilesAdapter.a(this.a).a(i).a(paramView.sessionid);
        if (localDataLineMsgSet != null) {
          localDataLineMsgSet.setPaused(false);
        }
        if (localDLFileInfo.jdField_a_of_type_Int != 1)
        {
          if ((paramView.fileMsgStatus == 1L) && (paramView.strMoloKey != null)) {
            DataLineReportUtil.e(DatalineFilesAdapter.a(this.a));
          }
          DatalineFilesAdapter.a(this.a, (DatalineFilesAdapter.ItemHolder)localObject, paramView);
          return;
        }
        DatalineFilesAdapter.b(this.a, (DatalineFilesAdapter.ItemHolder)localObject, paramView);
        return;
      }
      FMToastUtil.a(2131434596);
      return;
    case 5: 
      DatalineFilesAdapter.a(this.a, paramView);
      return;
    }
    localDLFileInfo.jdField_a_of_type_Int = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     cy
 * JD-Core Version:    0.7.0.1
 */
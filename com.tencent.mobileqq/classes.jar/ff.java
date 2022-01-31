import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

class ff
  implements View.OnClickListener
{
  ff(fd paramfd) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject = (fh)paramView.getTag();
    int i = DataLineMsgRecord.getDevTypeBySeId(((fh)localObject).a.jdField_a_of_type_Long);
    paramView = fd.a(this.a).a().a(i).a(((fh)localObject).a.jdField_a_of_type_Long);
    if (paramView == null) {
      return;
    }
    DLFileInfo localDLFileInfo = ((fh)localObject).a;
    switch (localDLFileInfo.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
    case 3: 
      localObject = (ajuo)fd.a(this.a).a(8);
      if ((paramView.strMoloKey != null) && (!paramView.isReportPause))
      {
        paramView.isReportPause = true;
        fc.m(fd.a(this.a));
      }
      ((ajuo)localObject).a(paramView.groupId, paramView.sessionid, false);
      if (paramView.isSendFromLocal())
      {
        localDLFileInfo.jdField_a_of_type_Int = 1;
        return;
      }
      break;
    case 1: 
    case 2: 
    case 4: 
      if (bbev.d(fd.a(this.a)))
      {
        if ((apue.a()) && (localDLFileInfo.b > 3145728L))
        {
          if (localDLFileInfo.jdField_a_of_type_Int == 1) {}
          for (;;)
          {
            apue.a(bool, fd.a(this.a), new fg(this, paramView, (fh)localObject));
            return;
            bool = false;
          }
        }
        i = DataLineMsgRecord.getDevTypeBySeId(paramView.sessionid);
        DataLineMsgSet localDataLineMsgSet = fd.a(this.a).a(i).a(paramView.sessionid);
        if (localDataLineMsgSet != null) {
          localDataLineMsgSet.setPaused(false);
        }
        if (localDLFileInfo.jdField_a_of_type_Int != 1)
        {
          if ((paramView.fileMsgStatus == 1L) && (paramView.strMoloKey != null)) {
            fc.e(fd.a(this.a));
          }
          fd.a(this.a, (fh)localObject, paramView);
          return;
        }
        fd.b(this.a, (fh)localObject, paramView);
        return;
      }
      aptv.a(2131694672);
      return;
    case 5: 
      fd.a(this.a, paramView);
      return;
    }
    localDLFileInfo.jdField_a_of_type_Int = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ff
 * JD-Core Version:    0.7.0.1
 */
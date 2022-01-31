import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.file.DLFileInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

class do
  implements View.OnClickListener
{
  do(dm paramdm) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject = (dq)paramView.getTag();
    int i = DataLineMsgRecord.getDevTypeBySeId(((dq)localObject).a.jdField_a_of_type_Long);
    paramView = dm.a(this.a).a().a(i).a(((dq)localObject).a.jdField_a_of_type_Long);
    if (paramView == null) {
      return;
    }
    DLFileInfo localDLFileInfo = ((dq)localObject).a;
    switch (localDLFileInfo.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
    case 3: 
      localObject = (alqo)dm.a(this.a).a(8);
      if ((paramView.strMoloKey != null) && (!paramView.isReportPause))
      {
        paramView.isReportPause = true;
        dl.m(dm.a(this.a));
      }
      ((alqo)localObject).a(paramView.groupId, paramView.sessionid, false);
      if (paramView.isSendFromLocal())
      {
        localDLFileInfo.jdField_a_of_type_Int = 1;
        return;
      }
      break;
    case 1: 
    case 2: 
    case 4: 
      if (bdin.d(dm.a(this.a)))
      {
        if ((arrr.a()) && (localDLFileInfo.b > 3145728L))
        {
          if (localDLFileInfo.jdField_a_of_type_Int == 1) {}
          for (;;)
          {
            arrr.a(bool, dm.a(this.a), new dp(this, paramView, (dq)localObject));
            return;
            bool = false;
          }
        }
        i = DataLineMsgRecord.getDevTypeBySeId(paramView.sessionid);
        DataLineMsgSet localDataLineMsgSet = dm.a(this.a).a(i).a(paramView.sessionid);
        if (localDataLineMsgSet != null) {
          localDataLineMsgSet.setPaused(false);
        }
        if (localDLFileInfo.jdField_a_of_type_Int != 1)
        {
          if ((paramView.fileMsgStatus == 1L) && (paramView.strMoloKey != null)) {
            dl.e(dm.a(this.a));
          }
          dm.a(this.a, (dq)localObject, paramView);
          return;
        }
        dm.b(this.a, (dq)localObject, paramView);
        return;
      }
      arri.a(2131694831);
      return;
    case 5: 
      dm.a(this.a, paramView);
      return;
    }
    localDLFileInfo.jdField_a_of_type_Int = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     do
 * JD-Core Version:    0.7.0.1
 */
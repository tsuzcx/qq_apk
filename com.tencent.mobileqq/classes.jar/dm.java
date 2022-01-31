import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

class dm
  implements View.OnClickListener
{
  dm(dk paramdk) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject = (do)paramView.getTag();
    int i = DataLineMsgRecord.getDevTypeBySeId(((do)localObject).a.jdField_a_of_type_Long);
    paramView = dk.a(this.a).a().a(i).a(((do)localObject).a.jdField_a_of_type_Long);
    if (paramView == null) {
      return;
    }
    DLFileInfo localDLFileInfo = ((do)localObject).a;
    switch (localDLFileInfo.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
    case 3: 
      localObject = (ajgm)dk.a(this.a).a(8);
      if ((paramView.strMoloKey != null) && (!paramView.isReportPause))
      {
        paramView.isReportPause = true;
        dj.m(dk.a(this.a));
      }
      ((ajgm)localObject).a(paramView.groupId, paramView.sessionid, false);
      if (paramView.isSendFromLocal())
      {
        localDLFileInfo.jdField_a_of_type_Int = 1;
        return;
      }
      break;
    case 1: 
    case 2: 
    case 4: 
      if (badq.d(dk.a(this.a)))
      {
        if ((apck.a()) && (localDLFileInfo.b > 3145728L))
        {
          if (localDLFileInfo.jdField_a_of_type_Int == 1) {}
          for (;;)
          {
            apck.a(bool, dk.a(this.a), new dn(this, paramView, (do)localObject));
            return;
            bool = false;
          }
        }
        i = DataLineMsgRecord.getDevTypeBySeId(paramView.sessionid);
        DataLineMsgSet localDataLineMsgSet = dk.a(this.a).a(i).a(paramView.sessionid);
        if (localDataLineMsgSet != null) {
          localDataLineMsgSet.setPaused(false);
        }
        if (localDLFileInfo.jdField_a_of_type_Int != 1)
        {
          if ((paramView.fileMsgStatus == 1L) && (paramView.strMoloKey != null)) {
            dj.e(dk.a(this.a));
          }
          dk.a(this.a, (do)localObject, paramView);
          return;
        }
        dk.b(this.a, (do)localObject, paramView);
        return;
      }
      apcb.a(2131629008);
      return;
    case 5: 
      dk.a(this.a, paramView);
      return;
    }
    localDLFileInfo.jdField_a_of_type_Int = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     dm
 * JD-Core Version:    0.7.0.1
 */
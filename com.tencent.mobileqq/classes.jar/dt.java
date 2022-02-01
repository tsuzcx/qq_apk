import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.file.DLFileInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class dt
  implements View.OnClickListener
{
  dt(dr paramdr) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject = (dv)paramView.getTag();
    int i = DataLineMsgRecord.getDevTypeBySeId(((dv)localObject).a.jdField_a_of_type_Long);
    DataLineMsgRecord localDataLineMsgRecord = dr.a(this.a).getMessageFacade().getDatalineMessageManager(i).a(((dv)localObject).a.jdField_a_of_type_Long);
    if (localDataLineMsgRecord == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      DLFileInfo localDLFileInfo = ((dv)localObject).a;
      switch (localDLFileInfo.jdField_a_of_type_Int)
      {
      default: 
        break;
      case 0: 
      case 3: 
        localObject = (amqd)dr.a(this.a).getBusinessHandler(8);
        if ((localDataLineMsgRecord.strMoloKey != null) && (!localDataLineMsgRecord.isReportPause))
        {
          localDataLineMsgRecord.isReportPause = true;
          dq.m(dr.a(this.a));
        }
        ((amqd)localObject).a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, false);
        if (localDataLineMsgRecord.isSendFromLocal()) {
          localDLFileInfo.jdField_a_of_type_Int = 1;
        }
        break;
      case 1: 
      case 2: 
      case 4: 
        if (NetworkUtil.isNetSupport(dr.a(this.a)))
        {
          if ((aszt.a()) && (localDLFileInfo.b > 3145728L))
          {
            if (localDLFileInfo.jdField_a_of_type_Int == 1) {}
            for (;;)
            {
              aszt.a(bool, dr.a(this.a), new du(this, localDataLineMsgRecord, (dv)localObject));
              break;
              bool = false;
            }
          }
          i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
          DataLineMsgSet localDataLineMsgSet = dr.a(this.a).getDataLineMsgProxy(i).a(localDataLineMsgRecord.sessionid);
          if (localDataLineMsgSet != null) {
            localDataLineMsgSet.setPaused(false);
          }
          if (localDLFileInfo.jdField_a_of_type_Int != 1)
          {
            if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null)) {
              dq.e(dr.a(this.a));
            }
            dr.a(this.a, (dv)localObject, localDataLineMsgRecord);
          }
          else
          {
            dr.b(this.a, (dv)localObject, localDataLineMsgRecord);
          }
        }
        else
        {
          aszk.a(2131694108);
        }
        break;
      case 5: 
        dr.a(this.a, localDataLineMsgRecord);
        continue;
        localDLFileInfo.jdField_a_of_type_Int = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dt
 * JD-Core Version:    0.7.0.1
 */
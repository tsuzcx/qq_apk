import com.dataline.activities.LiteMutiPicViewerActivity;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class eb
  implements aptw
{
  public eb(LiteMutiPicViewerActivity paramLiteMutiPicViewerActivity, ajum paramajum) {}
  
  public void a()
  {
    Object localObject1 = null;
    LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).setPaused(false);
    if ((LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).getGroupType() == -2000) && (!LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).isSingle())) {
      fc.p(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.app);
    }
    Iterator localIterator = LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity).values().iterator();
    Object localObject2 = null;
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      DLFileInfo localDLFileInfo = fd.a(localDataLineMsgRecord);
      Object localObject3;
      if (localDLFileInfo.a == 1)
      {
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = new ArrayList();
        }
        ((ArrayList)localObject3).add(localDataLineMsgRecord);
        localObject2 = localObject3;
      }
      else
      {
        if (localDLFileInfo.a != 4)
        {
          localObject3 = localObject1;
          if (localDLFileInfo.a != 2) {}
        }
        else if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null))
        {
          if (!DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
            break label269;
          }
          fc.d(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.app);
        }
        for (;;)
        {
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new ArrayList();
          }
          ((List)localObject3).add(Long.valueOf(localDataLineMsgRecord.sessionid));
          int i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
          localDataLineMsgRecord.fileMsgStatus = 0L;
          this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.app.a().a(i).c(localDataLineMsgRecord.msgId);
          localObject1 = localObject3;
          break;
          label269:
          fc.e(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity.app);
        }
      }
    }
    if ((localObject2 != null) && (localObject2.size() > 0)) {
      this.jdField_a_of_type_Ajum.a(localObject2, true);
    }
    if ((localObject1 != null) && (localObject1.size() > 0)) {
      this.jdField_a_of_type_Ajum.a(localObject1);
    }
    LiteMutiPicViewerActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     eb
 * JD-Core Version:    0.7.0.1
 */
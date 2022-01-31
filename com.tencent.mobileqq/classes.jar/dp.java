import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

class dp
  implements army
{
  dp(do paramdo, DataLineMsgRecord paramDataLineMsgRecord, dq paramdq) {}
  
  public void a()
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    DataLineMsgSet localDataLineMsgSet = dm.a(this.jdField_a_of_type_Do.a).a(i).a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    if (localDataLineMsgSet != null) {
      localDataLineMsgSet.setPaused(false);
    }
    if (this.jdField_a_of_type_Dq.a.a != 1)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.fileMsgStatus == 1L) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey != null)) {
        dl.e(dm.a(this.jdField_a_of_type_Do.a));
      }
      dm.a(this.jdField_a_of_type_Do.a, this.jdField_a_of_type_Dq, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
      return;
    }
    dm.b(this.jdField_a_of_type_Do.a, this.jdField_a_of_type_Dq, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dp
 * JD-Core Version:    0.7.0.1
 */
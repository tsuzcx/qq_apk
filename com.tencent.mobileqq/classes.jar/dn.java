import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

class dn
  implements apca
{
  dn(dm paramdm, DataLineMsgRecord paramDataLineMsgRecord, do paramdo) {}
  
  public void a()
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    DataLineMsgSet localDataLineMsgSet = dk.a(this.jdField_a_of_type_Dm.a).a(i).a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    if (localDataLineMsgSet != null) {
      localDataLineMsgSet.setPaused(false);
    }
    if (this.jdField_a_of_type_Do.a.a != 1)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.fileMsgStatus == 1L) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey != null)) {
        dj.e(dk.a(this.jdField_a_of_type_Dm.a));
      }
      dk.a(this.jdField_a_of_type_Dm.a, this.jdField_a_of_type_Do, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
      return;
    }
    dk.b(this.jdField_a_of_type_Dm.a, this.jdField_a_of_type_Do, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     dn
 * JD-Core Version:    0.7.0.1
 */
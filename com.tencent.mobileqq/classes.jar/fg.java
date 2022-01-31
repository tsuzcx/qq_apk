import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

class fg
  implements aptu
{
  fg(ff paramff, DataLineMsgRecord paramDataLineMsgRecord, fh paramfh) {}
  
  public void a()
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    DataLineMsgSet localDataLineMsgSet = fd.a(this.jdField_a_of_type_Ff.a).a(i).a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    if (localDataLineMsgSet != null) {
      localDataLineMsgSet.setPaused(false);
    }
    if (this.jdField_a_of_type_Fh.a.a != 1)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.fileMsgStatus == 1L) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey != null)) {
        fc.e(fd.a(this.jdField_a_of_type_Ff.a));
      }
      fd.a(this.jdField_a_of_type_Ff.a, this.jdField_a_of_type_Fh, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
      return;
    }
    fd.b(this.jdField_a_of_type_Ff.a, this.jdField_a_of_type_Fh, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     fg
 * JD-Core Version:    0.7.0.1
 */
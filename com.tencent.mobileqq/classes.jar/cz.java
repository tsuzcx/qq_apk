import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.DatalineFilesAdapter.ItemHolder;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

class cz
  implements FMDialogUtil.FMDialogInterface
{
  cz(cy paramcy, DataLineMsgRecord paramDataLineMsgRecord, DatalineFilesAdapter.ItemHolder paramItemHolder) {}
  
  public void a()
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    DataLineMsgSet localDataLineMsgSet = DatalineFilesAdapter.a(this.jdField_a_of_type_Cy.a).a(i).a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    if (localDataLineMsgSet != null) {
      localDataLineMsgSet.setPaused(false);
    }
    if (this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter$ItemHolder.a.a != 1)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.fileMsgStatus == 1L) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey != null)) {
        DataLineReportUtil.e(DatalineFilesAdapter.a(this.jdField_a_of_type_Cy.a));
      }
      DatalineFilesAdapter.a(this.jdField_a_of_type_Cy.a, this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter$ItemHolder, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
      return;
    }
    DatalineFilesAdapter.b(this.jdField_a_of_type_Cy.a, this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter$ItemHolder, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     cz
 * JD-Core Version:    0.7.0.1
 */
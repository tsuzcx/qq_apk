import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class cp
  implements bcwm
{
  cp(cm paramcm, DataLineMsgRecord paramDataLineMsgRecord, FileManagerEntity paramFileManagerEntity, String paramString) {}
  
  public void a(int paramInt)
  {
    paramInt = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      aptx.b(apug.d(this.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_Cm.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131692828));
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Cm.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(this.jdField_a_of_type_Cm.jdField_a_of_type_JavaLangString, null, this.jdField_a_of_type_Cm.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount(), 0, false);
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nWeiyunSessionId = localFileManagerEntity.nSessionId;
      this.jdField_a_of_type_Cm.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(paramInt).c(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgId);
      return;
    }
    aptx.b(apug.d(this.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_Cm.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131692828));
    this.jdField_a_of_type_Cm.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nWeiyunSessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     cp
 * JD-Core Version:    0.7.0.1
 */
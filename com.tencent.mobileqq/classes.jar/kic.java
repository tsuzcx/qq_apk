import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.QLog;

public final class kic
  implements Runnable
{
  public kic(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean1, String paramString1, String paramString2, int paramInt, boolean paramBoolean2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addMessage");
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isAppOnForeground(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) || (QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Boolean);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        CUOpenCardGuideMng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, "qav");
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgTools", 2, "addMessage end");
      }
      return;
      QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((localQQMessageFacade != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin))) {
        localQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kic
 * JD-Core Version:    0.7.0.1
 */
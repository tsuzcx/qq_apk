import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.qphone.base.util.QLog;

public final class rvc
  implements Runnable
{
  public rvc(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, long paramLong) {}
  
  public void run()
  {
    try
    {
      MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
      if ((localMessageRecord != null) && (localMessageRecord.isSendFromLocal())) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, localMessageRecord.uniseq));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
      localMessageRecord = MessageRecordFactory.a(localMessageRecord);
      if ((localMessageRecord != null) && (localMessageRecord.msgtype == -1051))
      {
        LongTextMsgManager localLongTextMsgManager = (LongTextMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165);
        localMessageRecord.extStr = null;
        localLongTextMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, null, true);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("ChatActivityFacade", 1, "resendTextMessage error :", localRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rvc
 * JD-Core Version:    0.7.0.1
 */
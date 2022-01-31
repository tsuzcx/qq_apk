import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

public final class sab
  implements UpCallBack
{
  public sab(MessageForArkBabyqReply paramMessageForArkBabyqReply, QQAppInterface paramQQAppInterface) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    try
    {
      if (paramSendResult.jdField_a_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityFacade", 2, "step3: sendArkBabyQReplyLongMessage pack upload mResid=" + paramSendResult.c);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkBabyqReply.resIDForLongMsg = paramSendResult.c;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkBabyqReply, null, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "sendArkBabyQReplyLongMessage upload multi msg pack failed, result.errStr=" + paramSendResult.b + ",result.errStr=" + paramSendResult.jdField_a_of_type_JavaLangString);
      }
      LongTextMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkBabyqReply);
      return;
    }
    catch (Exception paramSendResult)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "sendArkBabyQReplyLongMessage upload multi msg pack failed, catch exception", paramSendResult);
      }
      LongTextMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkBabyqReply);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sab
 * JD-Core Version:    0.7.0.1
 */
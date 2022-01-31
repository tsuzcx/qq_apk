import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class rsd
  implements Runnable
{
  public rsd(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = ChatActivityFacade.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((localMessageRecord != null) && (!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"))))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"));
      if (QLog.isColorLevel()) {
        QLog.i("BabyQReportCookie", 2, "now enter the aio!!!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rsd
 * JD-Core Version:    0.7.0.1
 */
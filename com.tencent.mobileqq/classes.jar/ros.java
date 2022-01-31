import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ros
  implements Runnable
{
  public ros(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Iterator localIterator = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ChatMessage)localIterator.next();
      if ((localObject instanceof MessageForUniteGrayTip))
      {
        localObject = (MessageForUniteGrayTip)localObject;
        if (UniteGrayTipUtil.a((MessageForUniteGrayTip)localObject, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          Message localMessage = new Message();
          Bundle localBundle = new Bundle();
          localBundle.putLong("messageUniseq", ((MessageForUniteGrayTip)localObject).uniseq);
          localMessage.setData(localBundle);
          localMessage.what = 78;
          localMessage.arg1 = 0;
          this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ros
 * JD-Core Version:    0.7.0.1
 */
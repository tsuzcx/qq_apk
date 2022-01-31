import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.lightReply.LightReplyEmojs;
import mqq.os.MqqHandler;

public class rtw
  implements Runnable
{
  public rtw(BaseChatPie paramBaseChatPie, String paramString, int paramInt1, long paramLong, Context paramContext, int paramInt2, LightReplyEmojs paramLightReplyEmojs) {}
  
  public void run()
  {
    ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a().c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    if (localChatMessage != null) {
      ThreadManager.getUIHandler().post(new rtx(this, localChatMessage));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rtw
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class sai
  implements Runnable
{
  public sai(ChatHistoryFileActivity paramChatHistoryFileActivity, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = MultiMsgManager.a().a.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if ((localChatMessage instanceof MessageForStructing)) {
        ShareMsgHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.app, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int, ((MessageForStructing)localChatMessage).structingMsg, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sai
 * JD-Core Version:    0.7.0.1
 */
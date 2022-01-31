import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class rtm
  implements Runnable
{
  public rtm(BaseChatPie paramBaseChatPie, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, false);
    Object localObject = EmojiStickerManager.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    if (localObject != null)
    {
      EmojiStickerManager.a().jdField_b_of_type_Int = 0;
      EmojiStickerManager.a().jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(localObject, Boolean.valueOf(true));
      localObject = EmojiStickerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Long localLong = (Long)((Iterator)localObject).next();
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localLong.longValue());
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_MqqOsMqqHandler.post(new rtn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rtm
 * JD-Core Version:    0.7.0.1
 */
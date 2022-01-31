import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.Conversation;

public class smq
  extends QQStoryObserver
{
  public smq(Conversation paramConversation) {}
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      SLog.b("Q.recent", "onMsgTabStoryShowChange() sendEmptyMessageDelayedToHandler MSG_INIT_MSGTAG_STORY process, send");
      this.a.a(1055, 0L, false);
      return;
    }
    Conversation.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     smq
 * JD-Core Version:    0.7.0.1
 */
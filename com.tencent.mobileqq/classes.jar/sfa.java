import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.mobileqq.activity.Conversation;

public class sfa
  extends QQStoryObserver
{
  public sfa(Conversation paramConversation) {}
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.a(1055, 0L, false);
      return;
    }
    Conversation.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sfa
 * JD-Core Version:    0.7.0.1
 */
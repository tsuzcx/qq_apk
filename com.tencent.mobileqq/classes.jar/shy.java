import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.mobileqq.activity.Conversation;

public class shy
  extends QQStoryObserver
{
  public shy(Conversation paramConversation) {}
  
  public void a()
  {
    this.a.a(1057, 0L, false);
  }
  
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
 * Qualified Name:     shy
 * JD-Core Version:    0.7.0.1
 */
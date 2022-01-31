import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.now.enter.ConversationNowController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;

public class sdu
  implements Runnable
{
  public sdu(Conversation paramConversation) {}
  
  public void run()
  {
    boolean bool;
    PullRefreshHeader localPullRefreshHeader;
    if (this.a.i)
    {
      Conversation.a(this.a, 800L);
      bool = NetworkUtil.d(BaseApplication.getContext());
      if (this.a.a != null)
      {
        localPullRefreshHeader = this.a.a;
        if (!bool) {
          break label78;
        }
      }
    }
    label78:
    for (int i = 0;; i = 2)
    {
      localPullRefreshHeader.a(i);
      if (Conversation.a(this.a) != null) {
        Conversation.a(this.a).a(bool);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sdu
 * JD-Core Version:    0.7.0.1
 */
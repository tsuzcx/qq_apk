import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.portal.PortalManager;

public class slh
  implements View.OnClickListener
{
  public slh(Conversation paramConversation) {}
  
  public void onClick(View paramView)
  {
    Conversation.a(this.a).removeView(Conversation.a(this.a));
    paramView = (PortalManager)this.a.a.getManager(78);
    if (paramView != null) {
      paramView.a(this.a.a(), false);
    }
    Conversation.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     slh
 * JD-Core Version:    0.7.0.1
 */
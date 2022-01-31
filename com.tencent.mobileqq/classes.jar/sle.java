import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.portal.PortalManager;

public class sle
  implements View.OnTouchListener
{
  public sle(Conversation paramConversation) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      Conversation.a(this.a).removeView(Conversation.a(this.a));
      paramView = (PortalManager)this.a.a.getManager(78);
      if (paramView != null) {
        paramView.a(this.a.a(), true);
      }
      Conversation.a(this.a, null);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sle
 * JD-Core Version:    0.7.0.1
 */
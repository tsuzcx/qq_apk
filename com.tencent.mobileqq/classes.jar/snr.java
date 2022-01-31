import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.FrameHelperActivity;
import java.util.List;
import mqq.os.MqqHandler;

public class snr
  implements DragFrameLayout.OnDragModeChangedListener
{
  private final int jdField_a_of_type_Int = -2147483648;
  
  private snr(Conversation paramConversation) {}
  
  public void a(int paramInt, List paramList) {}
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramDragFrameLayout.a() == -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b.sendEmptyMessage(10);
      FrameHelperActivity.b(true);
      return;
    }
    FrameHelperActivity.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     snr
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;

public class rzp
  implements View.OnClickListener
{
  public rzp(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    View localView = (View)paramView.getParent();
    new rzq(this, paramView.getTag(), localView).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rzp
 * JD-Core Version:    0.7.0.1
 */
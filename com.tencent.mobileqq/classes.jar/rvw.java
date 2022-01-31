import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.bubble.ChatXListView;

public class rvw
  implements Runnable
{
  public rvw(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    this.a.a.setSelectionFromBottom(this.a.a.getCount() - 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rvw
 * JD-Core Version:    0.7.0.1
 */
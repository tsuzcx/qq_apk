import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class rom
  implements Runnable
{
  public rom(AddRequestActivity paramAddRequestActivity) {}
  
  public void run()
  {
    Card localCard = ((FriendsManager)this.a.app.getManager(50)).a(this.a.a);
    this.a.runOnUiThread(new ron(this, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rom
 * JD-Core Version:    0.7.0.1
 */
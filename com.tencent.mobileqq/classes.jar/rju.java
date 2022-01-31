import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class rju
  implements Runnable
{
  public rju(AddRequestActivity paramAddRequestActivity) {}
  
  public void run()
  {
    Card localCard = ((FriendsManager)this.a.app.getManager(50)).a(this.a.a);
    this.a.runOnUiThread(new rjv(this, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rju
 * JD-Core Version:    0.7.0.1
 */
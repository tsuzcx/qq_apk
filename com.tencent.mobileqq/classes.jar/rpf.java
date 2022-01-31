import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

class rpf
  implements Runnable
{
  rpf(rpe paramrpe) {}
  
  public void run()
  {
    Card localCard = ((FriendsManager)this.a.a.app.getManager(50)).a(this.a.a.a);
    if (localCard != null) {
      this.a.a.runOnUiThread(new rpg(this, localCard));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rpf
 * JD-Core Version:    0.7.0.1
 */
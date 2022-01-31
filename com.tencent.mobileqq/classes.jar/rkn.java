import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

class rkn
  implements Runnable
{
  rkn(rkm paramrkm) {}
  
  public void run()
  {
    Card localCard = ((FriendsManager)this.a.a.app.getManager(50)).a(this.a.a.a);
    if (localCard != null) {
      this.a.a.runOnUiThread(new rko(this, localCard));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rkn
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class sya
  implements Runnable
{
  public sya(MainFragment paramMainFragment) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
    if (MainFragment.a(this.a) != null)
    {
      MainFragment.a(this.a).addObserver(MainFragment.a(this.a));
      ((QIMNewFriendManager)MainFragment.a(this.a).getManager(256)).a(MainFragment.a(this.a));
      MainFragment.a(this.a).registObserver(MainFragment.a(this.a));
    }
    MainFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sya
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class sod
  implements Runnable
{
  public sod(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    ThreadManager.post(new soe(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sod
 * JD-Core Version:    0.7.0.1
 */
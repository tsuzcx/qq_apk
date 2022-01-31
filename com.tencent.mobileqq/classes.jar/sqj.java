import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.vas.ClubContentJsonTask;

public class sqj
  implements Runnable
{
  public sqj(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    ClubContentJsonTask.b(this.a.app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sqj
 * JD-Core Version:    0.7.0.1
 */
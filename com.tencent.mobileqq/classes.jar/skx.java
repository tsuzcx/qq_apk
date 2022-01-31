import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class skx
  extends FriendListObserver
{
  public skx(ForwardRecentActivity paramForwardRecentActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      ForwardRecentActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     skx
 * JD-Core Version:    0.7.0.1
 */
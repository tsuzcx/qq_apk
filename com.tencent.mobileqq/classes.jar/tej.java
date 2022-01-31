import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class tej
  extends FriendListObserver
{
  public tej(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tej
 * JD-Core Version:    0.7.0.1
 */
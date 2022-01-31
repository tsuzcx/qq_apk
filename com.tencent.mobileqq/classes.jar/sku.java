import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class sku
  extends FriendListObserver
{
  public sku(DiscussionMemberActivity paramDiscussionMemberActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sku
 * JD-Core Version:    0.7.0.1
 */
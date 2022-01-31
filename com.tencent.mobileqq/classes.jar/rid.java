import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class rid
  implements Runnable
{
  public rid(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  public void run()
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a = true;
    AddFriendLogicActivity.a(this.a).hide();
    AddFriendLogicActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rid
 * JD-Core Version:    0.7.0.1
 */
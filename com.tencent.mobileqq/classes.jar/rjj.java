import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class rjj
  implements Runnable
{
  public rjj(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void run()
  {
    if (this.a.a != null) {
      if (!this.a.a.isShowing()) {
        this.a.a.show();
      }
    }
    do
    {
      return;
      this.a.a = DialogUtil.a(this.a, 230);
      this.a.a.setMessage(2131433687);
      rjk localrjk = new rjk(this);
      this.a.a.setPositiveButton(2131432417, localrjk);
    } while (this.a.a.isShowing());
    this.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rjj
 * JD-Core Version:    0.7.0.1
 */
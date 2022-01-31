import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class rgm
  implements Runnable
{
  public rgm(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
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
      this.a.a.setMessage(2131433670);
      rgn localrgn = new rgn(this);
      this.a.a.setPositiveButton(2131432400, localrgn);
    } while (this.a.a.isShowing());
    this.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rgm
 * JD-Core Version:    0.7.0.1
 */
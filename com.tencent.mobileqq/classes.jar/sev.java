import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class sev
  implements Runnable
{
  public sev(ChatSettingForTroop paramChatSettingForTroop) {}
  
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
      this.a.a.setMessage(this.a.getActivity().getResources().getString(2131433685));
      sew localsew = new sew(this);
      this.a.a.setPositiveButton(2131432417, localsew);
    } while (this.a.a.isShowing());
    this.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sev
 * JD-Core Version:    0.7.0.1
 */
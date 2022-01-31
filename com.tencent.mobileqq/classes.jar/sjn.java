import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class sjn
  implements Runnable
{
  public sjn(ChatSettingForTroop paramChatSettingForTroop) {}
  
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
      this.a.a.setMessage(this.a.getActivity().getResources().getString(2131433699));
      sjo localsjo = new sjo(this);
      this.a.a.setPositiveButton(2131432428, localsjo);
    } while (this.a.a.isShowing());
    this.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sjn
 * JD-Core Version:    0.7.0.1
 */
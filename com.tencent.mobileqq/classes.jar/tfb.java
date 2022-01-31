import android.widget.TextView;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;

public class tfb
  extends TroopObserver
{
  public tfb(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    TextView localTextView;
    if (paramBoolean1)
    {
      this.a.e.a().setChecked(paramBoolean2);
      localTextView = this.a.a;
      if (!paramBoolean2) {
        break label59;
      }
    }
    label59:
    for (int i = 2131435392;; i = 2131435393)
    {
      localTextView.setText(i);
      SharedPreUtils.j(this.a, this.a.app.getCurrentAccountUin(), paramBoolean2);
      return;
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (!paramBoolean1)
    {
      QQToast.a(this.a, 1, "设置失败", 0).a();
      Switch localSwitch = this.a.e.a();
      if (!paramBoolean2) {}
      for (paramBoolean1 = bool;; paramBoolean1 = false)
      {
        localSwitch.setChecked(paramBoolean1);
        return;
      }
    }
    SharedPreUtils.j(this.a, this.a.app.getCurrentAccountUin(), paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tfb
 * JD-Core Version:    0.7.0.1
 */
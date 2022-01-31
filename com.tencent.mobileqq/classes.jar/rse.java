import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;

public class rse
  implements CompoundButton.OnCheckedChangeListener
{
  public rse(AuthDevActivity paramAuthDevActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    paramBoolean = false;
    if (paramCompoundButton == AuthDevActivity.a(this.a).a())
    {
      AuthDevActivity.a(this.a).setOnCheckedChangeListener(null);
      paramCompoundButton = AuthDevActivity.a(this.a);
      if (AuthDevActivity.a(this.a).a())
      {
        paramBoolean = false;
        paramCompoundButton.setChecked(paramBoolean);
        AuthDevActivity.a(this.a).setOnCheckedChangeListener(AuthDevActivity.a(this.a));
        if (NetworkUtil.d(this.a)) {
          break label118;
        }
        QQToast.a(this.a, this.a.getString(2131433023), 0).b(this.a.getTitleBarHeight());
      }
    }
    label118:
    while (paramCompoundButton != AuthDevActivity.b(this.a).a())
    {
      do
      {
        for (;;)
        {
          return;
          paramBoolean = true;
        }
        paramCompoundButton = (SecSvcHandler)this.a.app.a(34);
      } while (paramCompoundButton == null);
      if (!AuthDevActivity.a(this.a).a()) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramCompoundButton.a(paramBoolean);
        return;
      }
    }
    AuthDevActivity.b(this.a).setOnCheckedChangeListener(null);
    paramCompoundButton = AuthDevActivity.b(this.a);
    if (AuthDevActivity.b(this.a).a()) {}
    for (;;)
    {
      paramCompoundButton.setChecked(paramBoolean);
      AuthDevActivity.b(this.a).setOnCheckedChangeListener(AuthDevActivity.a(this.a));
      AuthDevActivity.a(this.a);
      return;
      paramBoolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rse
 * JD-Core Version:    0.7.0.1
 */
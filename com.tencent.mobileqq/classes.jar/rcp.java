import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class rcp
  implements View.OnClickListener
{
  public rcp(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(AboutActivity.b())) {}
    for (int i = Integer.parseInt(AboutActivity.b());; i = 0)
    {
      if (i < 5)
      {
        AboutActivity.a(AboutActivity.a(this.a));
        i = Integer.parseInt(AboutActivity.b());
        if (i == 5)
        {
          ArkIDESettingFragment.a("");
          ArkIDESettingFragment.a().c();
          QQToast.a(BaseApplication.getContext(), BaseActivity.sTopActivity.getString(2131438819), 0).a();
          ArkAppCenter.b("ArkDebugSwitch", String.format("show flag=%d", new Object[] { Integer.valueOf(i) }));
        }
        return;
      }
      ArkAppCenter.b("ArkDebugSwitch", String.format("ArkDebug is open and click limit=%d", new Object[] { Integer.valueOf(i) }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rcp
 * JD-Core Version:    0.7.0.1
 */
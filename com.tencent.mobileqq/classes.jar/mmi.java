import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.BaseActivity;

public class mmi
{
  View a;
  View b;
  
  public mmi(View paramView)
  {
    this.a = paramView.findViewById(2131372877);
    this.b = paramView.getRootView().findViewById(2131372878);
  }
  
  static void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    if ((paramBaseActivity == null) || (this.a == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (ImmersiveUtils.isSupporImmersive() == 1) {
            break;
          }
          this.a.setVisibility(8);
        } while (this.b == null);
        this.b.setVisibility(8);
        return;
        int i = ImmersiveUtils.getStatusBarHeight(paramBaseActivity);
        QLog.w("QavStatusBar", 1, "adjust, height[" + i + "]");
        if (i > 0)
        {
          a(this.a, i);
          a(this.b, i);
        }
      } while (AudioHelper.a(0) != 1);
      this.a.setBackgroundColor(2140405971);
    } while (this.b == null);
    this.b.setBackgroundColor(2140405971);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a != null)
    {
      QLog.w("QavStatusBar", 1, "setBackgroundColor, bDoubleScreen[" + paramBoolean + "]");
      if (paramBoolean) {
        this.a.setBackgroundColor(-16777216);
      }
    }
    else
    {
      return;
    }
    this.a.setBackgroundColor(0);
  }
  
  public boolean a()
  {
    return (this.a != null) && (this.a.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mmi
 * JD-Core Version:    0.7.0.1
 */
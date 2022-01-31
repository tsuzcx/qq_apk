import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class rmx
  implements View.OnClickListener
{
  public rmx(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView instanceof RotateSwitchImageView)) {}
    View localView2;
    do
    {
      do
      {
        return;
        localView1 = AssociatedAccountManageActivity.a(this.a, paramView);
        localView2 = AssociatedAccountManageActivity.b(this.a, paramView);
        if (AssociatedAccountManageActivity.a(this.a) != null) {
          break;
        }
        AssociatedAccountManageActivity.a(this.a, (RotateSwitchImageView)paramView);
        AssociatedAccountManageActivity.a(this.a).b();
        if (localView2 != null)
        {
          localObject = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(AssociatedAccountManageActivity.a(this.a) * 12.0F + AssociatedAccountManageActivity.b(this.a) * 75.0F));
          localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).b();
        }
      } while (!AppSetting.b);
      paramView.setContentDescription(this.a.getString(2131437129));
      return;
      if (AssociatedAccountManageActivity.a(this.a) != paramView) {
        break;
      }
      AssociatedAccountManageActivity.a(this.a).a();
      if (localView2 != null)
      {
        localObject = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(AssociatedAccountManageActivity.c(this.a) * 12.0F));
        localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if ((localView1 instanceof ShaderAnimLayout)) {
        ((ShaderAnimLayout)localView1).f();
      }
      AssociatedAccountManageActivity.a(this.a, null);
    } while (!AppSetting.b);
    paramView.setContentDescription(this.a.getString(2131437130));
    return;
    AssociatedAccountManageActivity.a(this.a).a();
    Object localObject = AssociatedAccountManageActivity.b(this.a, AssociatedAccountManageActivity.a(this.a));
    if (localObject != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.rightMargin = ((int)(AssociatedAccountManageActivity.d(this.a) * 12.0F));
      ((View)localObject).setLayoutParams(localLayoutParams);
    }
    ((RotateSwitchImageView)paramView).b();
    if (localView2 != null)
    {
      localObject = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(AssociatedAccountManageActivity.e(this.a) * 12.0F + AssociatedAccountManageActivity.f(this.a) * 75.0F));
      localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (AppSetting.b)
    {
      paramView.setContentDescription(this.a.getString(2131437129));
      AssociatedAccountManageActivity.a(this.a).setContentDescription(this.a.getString(2131437130));
    }
    if ((localView1 instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localView1).b();
    }
    View localView1 = AssociatedAccountManageActivity.a(this.a, AssociatedAccountManageActivity.a(this.a));
    if ((localView1 instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localView1).f();
    }
    AssociatedAccountManageActivity.a(this.a, (RotateSwitchImageView)paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rmx
 * JD-Core Version:    0.7.0.1
 */
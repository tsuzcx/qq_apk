import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.nearby.NearbySPUtil;

public class sto
  implements View.OnClickListener
{
  public sto(LbsBaseActivity paramLbsBaseActivity) {}
  
  public void onClick(View paramView)
  {
    NearbySPUtil.a(this.a.getAppInterface().getAccount(), true);
    if ((LbsBaseActivity.a(this.a) != null) && (LbsBaseActivity.a(this.a).isShowing())) {
      this.a.a(LbsBaseActivity.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sto
 * JD-Core Version:    0.7.0.1
 */
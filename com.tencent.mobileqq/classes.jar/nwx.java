import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nwx
  implements View.OnClickListener
{
  public nwx(AccountSettingFragment paramAccountSettingFragment) {}
  
  public void onClick(View paramView)
  {
    AccountSettingFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nwx
 * JD-Core Version:    0.7.0.1
 */
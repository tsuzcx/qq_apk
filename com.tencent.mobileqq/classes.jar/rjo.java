import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rjo
  implements View.OnClickListener
{
  public rjo(RIJUGCAddAccountFragment paramRIJUGCAddAccountFragment) {}
  
  public void onClick(View paramView)
  {
    RIJUGCAddAccountFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rjo
 * JD-Core Version:    0.7.0.1
 */
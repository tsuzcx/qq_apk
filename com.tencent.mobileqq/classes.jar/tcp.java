import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tcp
  implements View.OnClickListener
{
  public tcp(ViolaFragment paramViolaFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.mViolaUiDelegate.d();
    this.a.reloadPage();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tcp
 * JD-Core Version:    0.7.0.1
 */
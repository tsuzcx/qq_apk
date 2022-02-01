import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.AbsPublishColumnFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rfk
  implements View.OnClickListener
{
  public rfk(AbsPublishColumnFragment paramAbsPublishColumnFragment) {}
  
  public void onClick(View paramView)
  {
    if ((AbsPublishColumnFragment.a(this.a) != null) && (AbsPublishColumnFragment.a(this.a).isShowing())) {
      AbsPublishColumnFragment.a(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rfk
 * JD-Core Version:    0.7.0.1
 */
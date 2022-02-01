import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.3.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class pmo
  implements View.OnClickListener
{
  pmo(pmm parampmm) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false);
    ThreadManager.executeOnSubThread(new FrameworkHandler.3.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmo
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qcx
  implements View.OnClickListener
{
  qcx(qcw paramqcw) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false);
    ThreadManager.executeOnSubThread(new FrameworkHandler.2.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qcx
 * JD-Core Version:    0.7.0.1
 */
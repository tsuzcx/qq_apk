import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderSubscribe;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qpz
  implements View.OnClickListener
{
  public qpz(ComponentHeaderSubscribe paramComponentHeaderSubscribe) {}
  
  public void onClick(View paramView)
  {
    ComponentHeaderSubscribe.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpz
 * JD-Core Version:    0.7.0.1
 */
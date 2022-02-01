import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mqn
  implements View.OnClickListener
{
  mqn(mqm parammqm) {}
  
  public void onClick(View paramView)
  {
    this.a.a(true, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mqn
 * JD-Core Version:    0.7.0.1
 */
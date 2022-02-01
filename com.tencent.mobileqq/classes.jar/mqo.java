import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mqo
  implements View.OnClickListener
{
  mqo(mqm parammqm) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false, 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mqo
 * JD-Core Version:    0.7.0.1
 */
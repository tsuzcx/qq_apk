import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class omc
  implements View.OnClickListener
{
  omc(omb paramomb) {}
  
  public void onClick(View paramView)
  {
    omb.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omc
 * JD-Core Version:    0.7.0.1
 */
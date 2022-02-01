import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rrh
  implements View.OnClickListener
{
  rrh(rrg paramrrg) {}
  
  public void onClick(View paramView)
  {
    rrg.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rrh
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class oig
  implements View.OnClickListener
{
  oig(oif paramoif) {}
  
  public void onClick(View paramView)
  {
    ((Activity)paramView.getContext()).onBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oig
 * JD-Core Version:    0.7.0.1
 */
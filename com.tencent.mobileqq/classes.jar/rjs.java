import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class rjs
  implements View.OnClickListener
{
  rjs(View paramView) {}
  
  public void onClick(View paramView)
  {
    this.a.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rjs
 * JD-Core Version:    0.7.0.1
 */
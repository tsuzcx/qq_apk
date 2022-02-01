import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ohq
  implements View.OnClickListener
{
  ohq(ohp paramohp) {}
  
  public void onClick(View paramView)
  {
    this.a.a.d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohq
 * JD-Core Version:    0.7.0.1
 */
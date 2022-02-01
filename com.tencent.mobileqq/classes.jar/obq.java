import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class obq
  implements View.OnClickListener
{
  obq(obm paramobm) {}
  
  public void onClick(View paramView)
  {
    this.a.a(this.a.a, this.a.a.d);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obq
 * JD-Core Version:    0.7.0.1
 */
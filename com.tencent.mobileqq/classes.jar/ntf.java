import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ntf
  implements View.OnClickListener
{
  ntf(ntc paramntc) {}
  
  public void onClick(View paramView)
  {
    this.a.a(this.a.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ntf
 * JD-Core Version:    0.7.0.1
 */
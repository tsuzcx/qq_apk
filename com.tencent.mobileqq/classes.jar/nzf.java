import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nzf
  implements View.OnClickListener
{
  nzf(nze paramnze) {}
  
  public void onClick(View paramView)
  {
    this.a.a.d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzf
 * JD-Core Version:    0.7.0.1
 */
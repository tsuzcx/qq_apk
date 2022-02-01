import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ngr
  implements View.OnClickListener
{
  ngr(ngq paramngq) {}
  
  public void onClick(View paramView)
  {
    ngq.a(this.a, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngr
 * JD-Core Version:    0.7.0.1
 */
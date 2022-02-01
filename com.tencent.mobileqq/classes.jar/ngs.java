import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ngs
  implements View.OnClickListener
{
  ngs(ngq paramngq) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngs
 * JD-Core Version:    0.7.0.1
 */
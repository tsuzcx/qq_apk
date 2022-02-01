import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class npr
  implements View.OnClickListener
{
  npr(npm paramnpm) {}
  
  public void onClick(View paramView)
  {
    this.a.d(this.a.b());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npr
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class phi
  implements View.OnClickListener
{
  phi(String paramString) {}
  
  public void onClick(View paramView)
  {
    odq.a(null, "", "0X8009BE2", "0X8009BE2", 0, 0, "", "", "", this.a, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phi
 * JD-Core Version:    0.7.0.1
 */
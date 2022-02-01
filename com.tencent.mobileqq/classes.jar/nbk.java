import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nbk
  implements View.OnClickListener
{
  public nbk(WatchTogetherOrdinaryControlView paramWatchTogetherOrdinaryControlView) {}
  
  public void onClick(View paramView)
  {
    WatchTogetherOrdinaryControlView.d(this.a);
    WatchTogetherOrdinaryControlView.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nbk
 * JD-Core Version:    0.7.0.1
 */
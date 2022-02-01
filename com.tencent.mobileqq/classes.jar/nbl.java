import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nbl
  implements View.OnClickListener
{
  public nbl(WatchTogetherOrdinaryControlView paramWatchTogetherOrdinaryControlView) {}
  
  public void onClick(View paramView)
  {
    WatchTogetherOrdinaryControlView.e(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nbl
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.wtogether.view.WatchTogetherAdminControlView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nbd
  implements View.OnClickListener
{
  public nbd(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public void onClick(View paramView)
  {
    WatchTogetherAdminControlView.a(this.a, 2, 2);
    WatchTogetherAdminControlView.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nbd
 * JD-Core Version:    0.7.0.1
 */
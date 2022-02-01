import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.wtogether.view.WatchTogetherAdminControlView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nbg
  implements View.OnClickListener
{
  public nbg(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public void onClick(View paramView)
  {
    WatchTogetherAdminControlView.a(this.a, 1, 2);
    WatchTogetherAdminControlView.c(this.a);
    if (WatchTogetherAdminControlView.a(this.a) != null) {
      WatchTogetherAdminControlView.a(this.a).b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nbg
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nvn
  implements View.OnClickListener
{
  public nvn(VideoCoverView paramVideoCoverView) {}
  
  public void onClick(View paramView)
  {
    VideoCoverView.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nvn
 * JD-Core Version:    0.7.0.1
 */
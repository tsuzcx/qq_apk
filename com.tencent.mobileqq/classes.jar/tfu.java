import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tfu
  implements View.OnClickListener
{
  public tfu(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout) {}
  
  public void onClick(View paramView)
  {
    CommonSuspensionGestureLayout.a(this.a).a(true, 0, 5);
    CommonSuspensionGestureLayout.a(this.a, 5);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tfu
 * JD-Core Version:    0.7.0.1
 */
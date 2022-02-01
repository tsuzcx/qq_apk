import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qlv
  implements View.OnClickListener
{
  public qlv(PTSFragment paramPTSFragment) {}
  
  public void onClick(View paramView)
  {
    ((Activity)paramView.getContext()).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qlv
 * JD-Core Version:    0.7.0.1
 */
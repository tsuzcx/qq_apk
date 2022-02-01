import android.view.View;
import com.tencent.pts.utils.PTSNodeVirtualUtil.INodeVirtualOnViewClick;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class qzy
  implements PTSNodeVirtualUtil.INodeVirtualOnViewClick
{
  public void onViewClicked(View paramView)
  {
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzy
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rvn
  implements View.OnClickListener
{
  public rvn(VideoFeedsUGView paramVideoFeedsUGView) {}
  
  public void onClick(View paramView)
  {
    bhsi.a("ug_prefix_ug_1get3_ug_close_time", System.currentTimeMillis());
    this.a.setVisibility(8);
    ohk.a(ohk.b(this.a.jdField_a_of_type_Odl.i, "101", this.a.jdField_a_of_type_JavaLangString));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvn
 * JD-Core Version:    0.7.0.1
 */
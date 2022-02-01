import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sov
  implements View.OnClickListener
{
  public sov(VideoFeedsUGView paramVideoFeedsUGView) {}
  
  public void onClick(View paramView)
  {
    bhhr.a("ug_prefix_ug_1get3_ug_close_time", System.currentTimeMillis());
    this.a.setVisibility(8);
    oqt.a(oqt.b(this.a.jdField_a_of_type_Omr.i, "101", this.a.jdField_a_of_type_JavaLangString));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sov
 * JD-Core Version:    0.7.0.1
 */
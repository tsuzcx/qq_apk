import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sej
  implements View.OnClickListener
{
  public sej(VideoFeedsUGView paramVideoFeedsUGView) {}
  
  public void onClick(View paramView)
  {
    bgsg.a("ug_prefix_ug_1get3_ug_close_time", System.currentTimeMillis());
    this.a.setVisibility(8);
    ogc.a(ogc.b(this.a.jdField_a_of_type_Ocb.i, "101", this.a.jdField_a_of_type_JavaLangString));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sej
 * JD-Core Version:    0.7.0.1
 */
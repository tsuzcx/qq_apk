import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class scr
  implements View.OnClickListener
{
  public scr(VideoFeedsUGView paramVideoFeedsUGView) {}
  
  public void onClick(View paramView)
  {
    bfyz.a("ug_prefix_ug_1get3_ug_close_time", System.currentTimeMillis());
    this.a.setVisibility(8);
    oix.a(oix.b(this.a.jdField_a_of_type_Oey.i, "101", this.a.jdField_a_of_type_JavaLangString));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     scr
 * JD-Core Version:    0.7.0.1
 */
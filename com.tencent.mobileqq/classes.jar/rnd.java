import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class rnd
  implements View.OnClickListener
{
  rnd(rmt paramrmt, VideoInfo paramVideoInfo, roq paramroq) {}
  
  public final void onClick(View paramView)
  {
    rmt.a(this.jdField_a_of_type_Rmt, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_Roq);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnd
 * JD-Core Version:    0.7.0.1
 */
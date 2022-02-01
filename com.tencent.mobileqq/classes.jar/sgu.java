import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class sgu
  implements View.OnClickListener
{
  sgu(sgk paramsgk, VideoInfo paramVideoInfo, swr paramswr) {}
  
  public final void onClick(View paramView)
  {
    sgk.a(this.jdField_a_of_type_Sgk, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_Swr);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgu
 * JD-Core Version:    0.7.0.1
 */
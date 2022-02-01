import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.RichTitleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class rxd
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  rxd(TextView paramTextView, VideoInfo.RichTitleInfo paramRichTitleInfo, VideoInfo paramVideoInfo) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Long == 0L) || (System.currentTimeMillis() - this.jdField_a_of_type_Long > 2000L))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      pay.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$RichTitleInfo.d);
      rzu.a.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$RichTitleInfo.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxd
 * JD-Core Version:    0.7.0.1
 */
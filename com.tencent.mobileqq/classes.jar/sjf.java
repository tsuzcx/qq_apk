import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.RichTitleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class sjf
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  sjf(TextView paramTextView, VideoInfo.RichTitleInfo paramRichTitleInfo, VideoInfo paramVideoInfo) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Long == 0L) || (System.currentTimeMillis() - this.jdField_a_of_type_Long > 2000L))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      pkh.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$RichTitleInfo.d);
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$RichTitleInfo.a != 1) {
        break label78;
      }
      sly.a.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label78:
      sly.a.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$RichTitleInfo.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sjf
 * JD-Core Version:    0.7.0.1
 */
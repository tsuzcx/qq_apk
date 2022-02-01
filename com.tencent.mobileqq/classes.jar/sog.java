import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sog
  implements View.OnClickListener
{
  sog(sof paramsof, TabChannelCoverInfo paramTabChannelCoverInfo1, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo2, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    sof.a(this.jdField_a_of_type_Sof, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo);
    if (sof.a(this.jdField_a_of_type_Sof) != null) {
      sof.a(this.jdField_a_of_type_Sof).a(this.jdField_a_of_type_Int);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.b;
    int j = opq.b;
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {}
    for (int i = 1;; i = 0)
    {
      opq.a("0X8009496", localTabChannelCoverInfo, j, i, this.jdField_a_of_type_Int);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sog
 * JD-Core Version:    0.7.0.1
 */
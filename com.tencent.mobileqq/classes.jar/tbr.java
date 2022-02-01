import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tbr
  implements View.OnClickListener
{
  tbr(tbq paramtbq, TabChannelCoverInfo paramTabChannelCoverInfo1, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo2, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    tbq.a(this.jdField_a_of_type_Tbq, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo);
    if (tbq.a(this.jdField_a_of_type_Tbq) != null) {
      tbq.a(this.jdField_a_of_type_Tbq).a(this.jdField_a_of_type_Int);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.b;
    int j = oxo.b;
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {}
    for (int i = 1;; i = 0)
    {
      oxo.a("0X8009496", localTabChannelCoverInfo, j, i, this.jdField_a_of_type_Int);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tbr
 * JD-Core Version:    0.7.0.1
 */
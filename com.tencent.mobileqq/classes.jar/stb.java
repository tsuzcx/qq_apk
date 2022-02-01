import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class stb
  implements View.OnClickListener
{
  stb(sta paramsta, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    if (sta.a(this.jdField_a_of_type_Sta) != null) {
      sta.a(this.jdField_a_of_type_Sta).a(this.jdField_a_of_type_Int);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
    int j = ovs.b;
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {}
    for (int i = 1;; i = 0)
    {
      ovs.a("0X8009496", localTabChannelCoverInfo, j, i, this.jdField_a_of_type_Int);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     stb
 * JD-Core Version:    0.7.0.1
 */
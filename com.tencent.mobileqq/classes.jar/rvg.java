import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rvg
  implements View.OnClickListener
{
  rvg(rvd paramrvd, VideoInfo paramVideoInfo) {}
  
  public void onClick(View paramView)
  {
    AdvertisementInfo localAdvertisementInfo = txa.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
    twr.a(localAdvertisementInfo, 2005, ruw.a(this.jdField_a_of_type_Rvd.a));
    ruw.a(this.jdField_a_of_type_Rvd.a, rvd.a(this.jdField_a_of_type_Rvd), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, localAdvertisementInfo, 2005);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvg
 * JD-Core Version:    0.7.0.1
 */
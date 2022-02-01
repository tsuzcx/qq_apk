import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class roe
  implements View.OnClickListener
{
  roe(rob paramrob, VideoInfo paramVideoInfo) {}
  
  public void onClick(View paramView)
  {
    AdvertisementInfo localAdvertisementInfo = tqm.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
    tqa.a(localAdvertisementInfo, 2005, rnu.a(this.jdField_a_of_type_Rob.a));
    rnu.a(this.jdField_a_of_type_Rob.a, rob.a(this.jdField_a_of_type_Rob), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, localAdvertisementInfo, 2005);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     roe
 * JD-Core Version:    0.7.0.1
 */
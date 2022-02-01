import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rxj
  implements View.OnClickListener
{
  rxj(rxg paramrxg, VideoInfo paramVideoInfo) {}
  
  public void onClick(View paramView)
  {
    AdvertisementInfo localAdvertisementInfo = oqu.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
    oqj.a(localAdvertisementInfo, 2005, rwy.a(this.jdField_a_of_type_Rxg.a));
    rwy.a(this.jdField_a_of_type_Rxg.a, rxg.a(this.jdField_a_of_type_Rxg), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, localAdvertisementInfo, 2005);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxj
 * JD-Core Version:    0.7.0.1
 */
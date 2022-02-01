import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class swg
  implements View.OnClickListener
{
  swg(swd paramswd, VideoInfo paramVideoInfo) {}
  
  public void onClick(View paramView)
  {
    AdvertisementInfo localAdvertisementInfo = ulb.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
    uks.a(localAdvertisementInfo, 2005, this.jdField_a_of_type_Swd.jdField_a_of_type_Slr.a());
    this.jdField_a_of_type_Swd.jdField_a_of_type_Shl.a(swd.a(this.jdField_a_of_type_Swd), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, localAdvertisementInfo, 2005);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swg
 * JD-Core Version:    0.7.0.1
 */
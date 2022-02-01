import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rgw
  implements View.OnClickListener
{
  rgw(rgv paramrgv, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void onClick(View paramView)
  {
    ComponentContentRecommend.a(this.jdField_a_of_type_Rgv.a, "0X80094DA", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo);
    this.jdField_a_of_type_Rgv.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rgw
 * JD-Core Version:    0.7.0.1
 */
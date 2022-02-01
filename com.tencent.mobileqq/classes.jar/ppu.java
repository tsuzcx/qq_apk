import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyUninterestComplainFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

class ppu
  implements blcw
{
  ppu(ppr paramppr, pne parampne, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJDislikeManager", 2, "onAdComplain");
    }
    if ((this.jdField_a_of_type_Pne.a().a() instanceof Activity))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_from_type", 1);
      localIntent.putExtra("key_ad_info", (AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      PublicFragmentActivity.a((Activity)this.jdField_a_of_type_Pne.a().a(), localIntent, ReadInJoyUninterestComplainFragment.class, 9999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ppu
 * JD-Core Version:    0.7.0.1
 */
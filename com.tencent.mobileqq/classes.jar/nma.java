import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyUninterestComplainFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

class nma
  implements rcf
{
  nma(nlx paramnlx, AdvertisementInfo paramAdvertisementInfo) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdDislikeHelper", 2, "onComplain");
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_type", 1);
    localIntent.putExtra("key_ad_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    PublicFragmentActivity.a(nlx.a(this.jdField_a_of_type_Nlx), localIntent, ReadInJoyUninterestComplainFragment.class, 9999);
    nlx.a(this.jdField_a_of_type_Nlx).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nma
 * JD-Core Version:    0.7.0.1
 */
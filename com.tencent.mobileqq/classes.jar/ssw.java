import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyUninterestComplainFragment;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

final class ssw
  implements blmz
{
  ssw(Context paramContext, AdData paramAdData) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAdUtils", 2, "onPopupWindowForAdComplain");
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_from_type", 3);
      localIntent.putExtra("key_ad_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
      PublicFragmentActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, ReadInJoyUninterestComplainFragment.class, 9999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ssw
 * JD-Core Version:    0.7.0.1
 */
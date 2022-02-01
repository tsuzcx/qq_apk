import android.content.Intent;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyUninterestComplainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

class smi
  implements szs
{
  smi(smg paramsmg, VideoInfo paramVideoInfo) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsShareController", 2, "onDislikeDialogViewForAdComplain");
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_type", 2);
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
      localIntent.putExtra("key_ad_info", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
    }
    PublicFragmentActivity.a(smg.a(this.jdField_a_of_type_Smg), localIntent, ReadInJoyUninterestComplainFragment.class, 9999);
    smg.a(this.jdField_a_of_type_Smg).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smi
 * JD-Core Version:    0.7.0.1
 */
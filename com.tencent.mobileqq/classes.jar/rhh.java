import android.content.Intent;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyUninterestComplainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

class rhh
  implements rsd
{
  rhh(rhf paramrhf, VideoInfo paramVideoInfo) {}
  
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
    PublicFragmentActivity.a(rhf.a(this.jdField_a_of_type_Rhf), localIntent, ReadInJoyUninterestComplainFragment.class, 9999);
    rhf.a(this.jdField_a_of_type_Rhf).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rhh
 * JD-Core Version:    0.7.0.1
 */
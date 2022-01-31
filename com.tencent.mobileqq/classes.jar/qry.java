import android.content.Intent;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyUninterestComplainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

class qry
  implements rci
{
  qry(qrw paramqrw, VideoInfo paramVideoInfo) {}
  
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
    PublicFragmentActivity.a(qrw.a(this.jdField_a_of_type_Qrw), localIntent, ReadInJoyUninterestComplainFragment.class, 9999);
    qrw.a(this.jdField_a_of_type_Qrw).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qry
 * JD-Core Version:    0.7.0.1
 */
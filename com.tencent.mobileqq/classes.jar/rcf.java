import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;

public class rcf
  implements osi
{
  public rcf(VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1 param1, VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void a(osl paramosl)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rcd.a(), 2, "UUIDToUrlCallback Callback vid=" + paramosl.jdField_b_of_type_JavaLangString + ", url=" + paramosl.jdField_a_of_type_JavaLangString + ", isH265=" + paramosl.jdField_a_of_type_Boolean + ", isHWCodec=" + paramosl.jdField_b_of_type_Boolean + ", fileBitRate=" + paramosl.c);
    }
    if ((!TextUtils.isEmpty(paramosl.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramosl.jdField_a_of_type_JavaLangString, paramosl.jdField_b_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramosl.jdField_a_of_type_JavaLangString, paramosl.jdField_b_of_type_JavaLangString, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rcf
 * JD-Core Version:    0.7.0.1
 */
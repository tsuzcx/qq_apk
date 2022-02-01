import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;

public class rph
  implements sct
{
  public rph(VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1 param1, VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void a(scv paramscv)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rpf.a(), 2, "UUIDToUrlCallback Callback vid=" + paramscv.jdField_b_of_type_JavaLangString + ", url=" + paramscv.jdField_a_of_type_JavaLangString + ", isH265=" + paramscv.jdField_a_of_type_Boolean + ", isHWCodec=" + paramscv.jdField_b_of_type_Boolean + ", fileBitRate=" + paramscv.c);
    }
    if ((!TextUtils.isEmpty(paramscv.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramscv.jdField_a_of_type_JavaLangString, paramscv.jdField_b_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramscv.jdField_a_of_type_JavaLangString, paramscv.jdField_b_of_type_JavaLangString, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rph
 * JD-Core Version:    0.7.0.1
 */
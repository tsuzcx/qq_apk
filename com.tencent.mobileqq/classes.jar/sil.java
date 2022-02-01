import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;

public class sil
  implements sxa
{
  public sil(VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1 param1, VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void a(sxc paramsxc)
  {
    if (QLog.isColorLevel()) {
      QLog.d(sij.a(), 2, "UUIDToUrlCallback Callback vid=" + paramsxc.jdField_b_of_type_JavaLangString + ", url=" + paramsxc.jdField_a_of_type_JavaLangString + ", isH265=" + paramsxc.jdField_a_of_type_Boolean + ", isHWCodec=" + paramsxc.jdField_b_of_type_Boolean + ", fileBitRate=" + paramsxc.c);
    }
    if ((!TextUtils.isEmpty(paramsxc.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramsxc.jdField_a_of_type_JavaLangString, paramsxc.jdField_b_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramsxc.jdField_a_of_type_JavaLangString, paramsxc.jdField_b_of_type_JavaLangString, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sil
 * JD-Core Version:    0.7.0.1
 */
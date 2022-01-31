import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;

public class qbg
  implements ocp
{
  public qbg(VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1 param1, VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void a(ocs paramocs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qbe.a(), 2, "UUIDToUrlCallback Callback vid=" + paramocs.jdField_b_of_type_JavaLangString + ", url=" + paramocs.jdField_a_of_type_JavaLangString + ", isH265=" + paramocs.jdField_a_of_type_Boolean + ", isHWCodec=" + paramocs.jdField_b_of_type_Boolean + ", fileBitRate=" + paramocs.c);
    }
    if ((!TextUtils.isEmpty(paramocs.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramocs.jdField_a_of_type_JavaLangString, paramocs.jdField_b_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramocs.jdField_a_of_type_JavaLangString, paramocs.jdField_b_of_type_JavaLangString, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbg
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;

public class qne
  implements ooa
{
  public qne(VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1 param1, VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void a(ood paramood)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qnc.a(), 2, "UUIDToUrlCallback Callback vid=" + paramood.jdField_b_of_type_JavaLangString + ", url=" + paramood.jdField_a_of_type_JavaLangString + ", isH265=" + paramood.jdField_a_of_type_Boolean + ", isHWCodec=" + paramood.jdField_b_of_type_Boolean + ", fileBitRate=" + paramood.c);
    }
    if ((!TextUtils.isEmpty(paramood.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramood.jdField_a_of_type_JavaLangString, paramood.jdField_b_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramood.jdField_a_of_type_JavaLangString, paramood.jdField_b_of_type_JavaLangString, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qne
 * JD-Core Version:    0.7.0.1
 */
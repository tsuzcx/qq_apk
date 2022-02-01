import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;

public class ryl
  implements slp
{
  public ryl(VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1 param1, VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void a(slr paramslr)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ryj.a(), 2, "UUIDToUrlCallback Callback vid=" + paramslr.jdField_b_of_type_JavaLangString + ", url=" + paramslr.jdField_a_of_type_JavaLangString + ", isH265=" + paramslr.jdField_a_of_type_Boolean + ", isHWCodec=" + paramslr.jdField_b_of_type_Boolean + ", fileBitRate=" + paramslr.c);
    }
    if ((!TextUtils.isEmpty(paramslr.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramslr.jdField_a_of_type_JavaLangString, paramslr.jdField_b_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramslr.jdField_a_of_type_JavaLangString, paramslr.jdField_b_of_type_JavaLangString, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryl
 * JD-Core Version:    0.7.0.1
 */
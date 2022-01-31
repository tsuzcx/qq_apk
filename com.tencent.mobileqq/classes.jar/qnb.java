import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;

public class qnb
  implements onx
{
  public qnb(VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1 param1, VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void a(ooa paramooa)
  {
    if (QLog.isColorLevel()) {
      QLog.d(qmz.a(), 2, "UUIDToUrlCallback Callback vid=" + paramooa.jdField_b_of_type_JavaLangString + ", url=" + paramooa.jdField_a_of_type_JavaLangString + ", isH265=" + paramooa.jdField_a_of_type_Boolean + ", isHWCodec=" + paramooa.jdField_b_of_type_Boolean + ", fileBitRate=" + paramooa.c);
    }
    if ((!TextUtils.isEmpty(paramooa.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramooa.jdField_a_of_type_JavaLangString, paramooa.jdField_b_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramooa.jdField_a_of_type_JavaLangString, paramooa.jdField_b_of_type_JavaLangString, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qnb
 * JD-Core Version:    0.7.0.1
 */
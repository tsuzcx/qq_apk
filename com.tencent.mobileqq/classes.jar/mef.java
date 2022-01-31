import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.MediaPlayListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;

class mef
  implements ThirdVideoManager.UUIDToUrlCallback
{
  mef(med parammed, VideoPlayerWrapper paramVideoPlayerWrapper, long paramLong, ThirdVideoManager paramThirdVideoManager) {}
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "UUIDToUrlCallback Callback vid:" + paramString2 + " url:" + paramString1);
    }
    VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam = VideoFeedsPlayManager.a(this.jdField_a_of_type_Med.a);
    if ((localVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper == VideoFeedsPlayManager.a(this.jdField_a_of_type_Med.a)) && (paramString2.equals(localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a))) {
      if (TextUtils.isEmpty(paramString1)) {
        if (VideoFeedsPlayManager.a(this.jdField_a_of_type_Med.a) != null) {
          VideoFeedsPlayManager.a(this.jdField_a_of_type_Med.a).a(null, 123, 107, 0, "UUIDToUrlCallback vid2url ERROR ", null);
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        VideoPreDownloadMgr localVideoPreDownloadMgr = VideoFeedsPlayManager.a(this.jdField_a_of_type_Med.a);
        if (localVideoPreDownloadMgr != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b = localVideoPreDownloadMgr.a(paramString1, paramString2);
          localVideoPreDownloadMgr.a(localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b);
        }
        if (paramInt == 1) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramString2, paramString1, 1, this.jdField_a_of_type_Long, 0L, localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, paramBoolean);
        }
        while (localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null)
        {
          localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVideoManager.a.longValue();
          localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Boolean = paramBoolean;
          localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_JavaLangString = paramString3;
          return;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramString2, paramString1, 2, this.jdField_a_of_type_Long, 0L, localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, paramBoolean);
        }
      }
    }
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramString2 + " url:" + paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mef
 * JD-Core Version:    0.7.0.1
 */
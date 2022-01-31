import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.MediaPlayListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoInfo;
import com.tencent.qphone.base.util.QLog;

class mod
  implements ThirdVideoManager.UUIDToUrlCallback
{
  mod(moc parammoc, VideoPlayerWrapper paramVideoPlayerWrapper, long paramLong, ThirdVideoManager paramThirdVideoManager) {}
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "UUIDToUrlCallback Callback vid:" + paramString2 + " url:" + paramString1);
    }
    FastWebVideoFeedsPlayManager.VideoPlayParam localVideoPlayParam = FastWebVideoFeedsPlayManager.a(this.jdField_a_of_type_Moc.a);
    if ((localVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (paramString2.equals(localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.a))) {
      if (TextUtils.isEmpty(paramString1)) {
        if (FastWebVideoFeedsPlayManager.a(this.jdField_a_of_type_Moc.a) != null) {
          FastWebVideoFeedsPlayManager.a(this.jdField_a_of_type_Moc.a).a(null, 123, 107, 0, "UUIDToUrlCallback vid2url ERROR ", null);
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        if (paramInt == 1) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramString2, paramString1, 1, this.jdField_a_of_type_Long, 0L, 0, paramBoolean);
        }
        while (localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null)
        {
          localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVideoManager.a.longValue();
          localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.d = paramBoolean;
          return;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramString2, paramString1, 2, this.jdField_a_of_type_Long, 0L, 0, paramBoolean);
        }
      }
    }
    QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramString2 + " url:" + paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mod
 * JD-Core Version:    0.7.0.1
 */
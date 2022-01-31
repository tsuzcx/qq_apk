import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.MediaPlayListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoInfo;
import com.tencent.qphone.base.util.QLog;

class mtb
  implements ThirdVideoManager.UUIDToUrlCallback
{
  mtb(mta parammta, VideoPlayerWrapper paramVideoPlayerWrapper, long paramLong, ThirdVideoManager paramThirdVideoManager) {}
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "UUIDToUrlCallback Callback vid:" + paramString2 + " url:" + paramString1);
    }
    paramString3 = FastWebVideoFeedsPlayManager.a(this.jdField_a_of_type_Mta.a);
    if ((paramString3 != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (paramString2.equals(paramString3.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.a))) {
      if (TextUtils.isEmpty(paramString1)) {
        if (FastWebVideoFeedsPlayManager.a(this.jdField_a_of_type_Mta.a) != null) {
          FastWebVideoFeedsPlayManager.a(this.jdField_a_of_type_Mta.a).a(null, 123, 107, 0, "UUIDToUrlCallback vid2url ERROR ", null);
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
        while (paramString3.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null)
        {
          paramString3.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVideoManager.a.longValue();
          paramString3.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.d = paramBoolean;
          return;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramString2, paramString1, 2, this.jdField_a_of_type_Long, 0L, 0, paramBoolean);
        }
      }
    }
    QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramString2 + " url:" + paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mtb
 * JD-Core Version:    0.7.0.1
 */
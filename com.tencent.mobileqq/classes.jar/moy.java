import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.MediaPlayListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoInfo;
import com.tencent.qphone.base.util.QLog;

public class moy
  extends VideoPlayerWrapper.MediaPlayListenerAdapter
{
  public moy(FastWebVideoFeedsPlayManager paramFastWebVideoFeedsPlayManager) {}
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "播放状态回调 onCompletion() vid=" + FastWebVideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.a);
    }
    FastWebVideoFeedsPlayManager.a(this.a).post(new moz(this));
    if ((FastWebVideoFeedsPlayManager.a(this.a) != null) && (FastWebVideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null))
    {
      FastWebVideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a = true;
      FastWebVideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Boolean = true;
    }
    FastWebVideoFeedsPlayManager.b(this.a, true);
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, Object paramObject)
  {
    paramVideoPlayerWrapper = FastWebVideoFeedsPlayManager.a(this.a);
    if ((paramVideoPlayerWrapper != null) && (QLog.isColorLevel())) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "播放状态回调 onVideoPrepared() vid=" + paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.a + ", mIsOpenedVideo = " + FastWebVideoFeedsPlayManager.a(this.a));
    }
    if (!FastWebVideoFeedsPlayManager.a(this.a)) {
      return;
    }
    this.a.b();
    FastWebVideoFeedsPlayManager.a(this.a);
    FastWebVideoFeedsPlayManager.a(this.a, false);
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramVideoPlayerWrapper = paramObject.toString();
      paramVideoPlayerWrapper = paramVideoPlayerWrapper;
      paramObject = FastWebVideoFeedsPlayManager.a(this.a);
      if ((paramObject != null) && (paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo != null) && (QLog.isColorLevel())) {
        QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "播放状态回调 onError() " + paramVideoPlayerWrapper + ", vid=" + paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoInfo.a);
      }
      if (paramInt1 != 123) {
        break label313;
      }
      if (paramInt2 != 103) {
        break label276;
      }
      paramVideoPlayerWrapper = "网络异常，请点击重试 (" + paramInt1 + "-" + paramInt2 + ")";
    }
    for (;;)
    {
      FastWebVideoFeedsPlayManager.a(this.a, paramVideoPlayerWrapper);
      this.a.a(2);
      if ((paramObject != null) && (paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null))
      {
        paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a = false;
        paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
        paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.c = paramString;
      }
      return false;
      paramVideoPlayerWrapper = "";
      break;
      label276:
      paramVideoPlayerWrapper = "视频加载失败，请点击重试 (" + paramInt1 + "-" + paramInt2 + ")";
      continue;
      label313:
      if (paramInt1 == 122)
      {
        if (paramInt2 == 204) {
          paramVideoPlayerWrapper = "网络异常，请点击重试 (" + paramInt1 + "-" + paramInt2 + ")";
        } else if (paramInt2 == 202) {
          paramVideoPlayerWrapper = "播放错误 (" + paramInt1 + "-" + paramInt2 + ")";
        } else {
          paramVideoPlayerWrapper = "视频加载失败，请点击重试 (" + paramInt1 + "-" + paramInt2 + ")";
        }
      }
      else if (paramInt1 == 101)
      {
        if (paramInt2 == 80) {
          paramVideoPlayerWrapper = "因版权限制、无法观看 (" + paramInt1 + "-" + paramInt2 + ")";
        } else {
          paramVideoPlayerWrapper = "视频加载失败，请点击重试 (" + paramInt1 + "-" + paramInt2 + ")";
        }
      }
      else {
        paramVideoPlayerWrapper = "视频加载失败，请点击重试 (" + paramInt1 + "-" + paramInt2 + ")";
      }
    }
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    paramVideoPlayerWrapper = FastWebVideoFeedsPlayManager.a(this.a);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
      }
      this.a.a(1);
      if ((paramVideoPlayerWrapper != null) && (paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null))
      {
        paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.d = SystemClock.uptimeMillis();
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
        }
        if ((FastWebVideoFeedsPlayManager.a(this.a) != null) && (FastWebVideoFeedsPlayManager.a(this.a).b())) {
          this.a.a(0);
        }
        while ((paramVideoPlayerWrapper != null) && (paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null))
        {
          paramObject = paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
          paramObject.e += SystemClock.uptimeMillis() - paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.d;
          paramVideoPlayerWrapper = paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
          paramVideoPlayerWrapper.jdField_b_of_type_Int += 1;
          return false;
          this.a.a(3);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     moy
 * JD-Core Version:    0.7.0.1
 */
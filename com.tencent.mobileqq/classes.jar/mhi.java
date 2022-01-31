import android.os.Handler;
import android.os.SystemClock;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.MediaPlayListenerAdapter;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.DefnInfo;
import java.util.ArrayList;
import java.util.Properties;
import org.json.JSONObject;

public class mhi
  extends VideoPlayerWrapper.MediaPlayListenerAdapter
{
  public mhi(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (VideoFeedsPlayManager.a(this.a) == null) {
        break label121;
      }
    }
    label121:
    for (paramVideoPlayerWrapper = VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a;; paramVideoPlayerWrapper = "param null")
    {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, paramVideoPlayerWrapper);
      VideoFeedsPlayManager.a(this.a).post(new mhk(this));
      paramVideoPlayerWrapper = VideoFeedsPlayManager.a(this.a);
      if ((paramVideoPlayerWrapper != null) && (paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null))
      {
        paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = true;
        paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Boolean = true;
      }
      VideoFeedsPlayManager.b(this.a, true);
      return;
    }
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, long paramLong) {}
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, Object paramObject)
  {
    paramObject = VideoFeedsPlayManager.a(this.a);
    if ((paramObject != null) && (QLog.isColorLevel())) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onVideoPrepared() vid=" + paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a + ", mIsOpenedVideo = " + VideoFeedsPlayManager.a(this.a));
    }
    if (!VideoFeedsPlayManager.a(this.a)) {}
    do
    {
      do
      {
        return;
        if (NetworkUtil.b(VideoFeedsPlayManager.a(this.a))) {
          VideoFeedsPlayManager.a(this.a).post(new mhj(this));
        }
        this.a.b();
        VideoFeedsPlayManager.b(this.a);
        VideoFeedsPlayManager.a(this.a, false);
      } while ((paramObject == null) || (paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData == null) || (paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long != 0L));
      paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long);
      ReadinjoyVideoReportData localReadinjoyVideoReportData = paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
      localReadinjoyVideoReportData.e += paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long;
      localReadinjoyVideoReportData = paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
      localReadinjoyVideoReportData.jdField_b_of_type_Int += 1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "video player ready, prepare cost : " + paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long);
      }
      paramVideoPlayerWrapper = paramVideoPlayerWrapper.a().getPlayDetailsTime();
      paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.f = Long.valueOf(paramVideoPlayerWrapper.getProperty("httpdnsMS")).longValue();
      paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.g = Long.valueOf(paramVideoPlayerWrapper.getProperty("httpredirectMS")).longValue();
      paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.h = Long.valueOf(paramVideoPlayerWrapper.getProperty("cacheframeMS")).longValue();
      if (1 == paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Int) {
        paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.i = Long.valueOf(paramVideoPlayerWrapper.getProperty("vidtourlMS")).longValue();
      }
      paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.j = Long.valueOf(paramVideoPlayerWrapper.getProperty("httpfirstrecvMS")).longValue();
      paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.k = Long.valueOf(paramVideoPlayerWrapper.getProperty("getmp4headerMS")).longValue();
      paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.l = Long.valueOf(paramVideoPlayerWrapper.getProperty("httpconnectMS")).longValue();
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "vid=" + paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a + ", 预下载命中：" + VideoFeedsPlayManager.a(this.a).jdField_b_of_type_Boolean + ", 首帧耗时：" + paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long);
  }
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (VideoFeedsPlayManager.a(this.a) == null) {
      return;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      StringBuilder localStringBuilder;
      int i;
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("cur_defn", paramTVK_NetVideoInfo.getCurDefinition().getmDefn());
        localStringBuilder = new StringBuilder();
        paramTVK_NetVideoInfo = paramTVK_NetVideoInfo.getDefinitionList();
        i = 0;
        if (i < paramTVK_NetVideoInfo.size())
        {
          TVK_NetVideoInfo.DefnInfo localDefnInfo = (TVK_NetVideoInfo.DefnInfo)paramTVK_NetVideoInfo.get(i);
          if (localDefnInfo == null) {
            break label199;
          }
          if (i == 0) {
            localStringBuilder.append(localDefnInfo.getmDefn());
          } else {
            localStringBuilder.append("_" + localDefnInfo.getmDefn());
          }
        }
      }
      catch (Exception paramTVK_NetVideoInfo)
      {
        paramTVK_NetVideoInfo.printStackTrace();
        return;
      }
      localJSONObject.put("defn_list", localStringBuilder.toString());
      PublicAccountReportUtils.a(null, "", "0X8008AEE", "0X8008AEE", 0, 0, "", "", "", VideoReporter.a(VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a, VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, 409409, localJSONObject), false);
      return;
      label199:
      i += 1;
    }
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramVideoPlayerWrapper = paramObject.toString();
      paramVideoPlayerWrapper = paramVideoPlayerWrapper;
      paramObject = VideoFeedsPlayManager.a(this.a);
      if ((paramObject != null) && (paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (QLog.isColorLevel())) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onError() " + paramVideoPlayerWrapper + ", vid=" + paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      }
      if (paramInt1 != 123) {
        break label362;
      }
      if (paramInt2 != 103) {
        break label322;
      }
      paramVideoPlayerWrapper = "网络异常，请点击重试 (" + paramInt1 + "-" + paramInt2 + ")";
    }
    for (;;)
    {
      VideoFeedsPlayManager.a(this.a, paramVideoPlayerWrapper);
      this.a.b(2);
      if ((paramObject != null) && (paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
        PublicAccountUtil.a(paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, paramObject.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a, 1, paramInt2);
      }
      if ((paramObject != null) && (paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null))
      {
        paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = false;
        paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
        paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_JavaLangString = paramString;
      }
      return false;
      paramVideoPlayerWrapper = "";
      break;
      label322:
      paramVideoPlayerWrapper = "视频加载失败，请点击重试 (" + paramInt1 + "-" + paramInt2 + ")";
      continue;
      label362:
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
    paramVideoPlayerWrapper = VideoFeedsPlayManager.a(this.a);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
      }
      this.a.b(1);
      if ((paramVideoPlayerWrapper != null) && (paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null))
      {
        paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long = SystemClock.uptimeMillis();
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
        }
        if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).b())) {
          this.a.b(0);
        }
        while ((paramVideoPlayerWrapper != null) && (paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null))
        {
          paramObject = paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
          paramObject.e += SystemClock.uptimeMillis() - paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long;
          paramVideoPlayerWrapper = paramVideoPlayerWrapper.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
          paramVideoPlayerWrapper.jdField_b_of_type_Int += 1;
          return false;
          if ((paramVideoPlayerWrapper != null) && (paramVideoPlayerWrapper.c.getVisibility() == 0)) {
            this.a.b(3);
          } else {
            this.a.b(4);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhi
 * JD-Core Version:    0.7.0.1
 */
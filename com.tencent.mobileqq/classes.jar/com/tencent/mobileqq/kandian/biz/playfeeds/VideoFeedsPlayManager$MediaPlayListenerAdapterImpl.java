package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.bandwidth.VideoBufferRangeController;
import com.tencent.mobileqq.kandian.base.video.player.ErrorCode;
import com.tencent.mobileqq.kandian.base.video.player.MediaPlayListenerAdapter;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.config.CodecReuseHelper;
import com.tencent.mobileqq.kandian.base.video.player.config.CodecReuseHelper.Companion;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.biz.ad.report.ReadinjoyAdVideoReportData;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class VideoFeedsPlayManager$MediaPlayListenerAdapterImpl
  extends MediaPlayListenerAdapter
{
  private VideoFeedsPlayManager$MediaPlayListenerAdapterImpl(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  private int a(VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam == null) {
      return 0;
    }
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData == null) {
      return 0;
    }
    return paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData.g;
  }
  
  private void a()
  {
    VideoPlayParam localVideoPlayParam = VideoFeedsPlayManager.b(this.a);
    if ((VideoFeedsPlayManager.a(this.a) != null) && (localVideoPlayParam != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("预播放任务 onDownloadFinish title = ");
        localStringBuilder.append(localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.c);
        QLog.d("VideoFeedsPlayManager.preplay", 2, localStringBuilder.toString());
      }
      int i = localVideoPlayParam.b;
      VideoFeedsPlayManager.a(this.a).a(i);
      VideoFeedsPlayManager.a(this.a, i);
    }
  }
  
  private void a(Object paramObject)
  {
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData != null)) {
      CodecReuseHelper.a.a(paramObject, VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData);
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel())
    {
      VideoPlayParam localVideoPlayParam = VideoFeedsPlayManager.b(this.a);
      StringBuilder localStringBuilder = null;
      localObject = localStringBuilder;
      if (localVideoPlayParam != null)
      {
        localObject = localStringBuilder;
        if (localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) {
          localObject = localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString;
        }
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPrePlayFinished() vid=");
      localStringBuilder.append((String)localObject);
      QLog.d("VideoFeedsPlayManager.preplay", 2, localStringBuilder.toString());
    }
    Object localObject = this.a;
    localObject = VideoFeedsPlayManager.a((VideoFeedsPlayManager)localObject, VideoFeedsPlayManager.b((VideoFeedsPlayManager)localObject));
    if (localObject != null) {
      ((VideoPlayerWrapper)localObject).j();
    }
    if (PlayerHelper.a.a()) {
      a();
    }
  }
  
  private void b(VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate != null)) {
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate.g(paramVideoPlayParam);
    }
    if ((paramVideoPlayParam != null) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      Iterator localIterator = VideoFeedsPlayManager.a(this.a).iterator();
      while (localIterator.hasNext()) {
        ((VideoFeedsPlayManager.VideoStatusListener)localIterator.next()).g(VideoFeedsPlayManager.a(this.a));
      }
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData != null)) {
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_e_of_type_Long = SystemClock.uptimeMillis();
    }
    if ((VideoFeedsPlayManager.b(this.a) != null) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean))
    {
      paramVideoPlayParam = this.a;
      paramVideoPlayParam = VideoFeedsPlayManager.a(paramVideoPlayParam, VideoFeedsPlayManager.b(paramVideoPlayParam));
      if ((paramVideoPlayParam != null) && (!paramVideoPlayParam.d())) {
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.j();
      }
    }
  }
  
  private void b(Object paramObject)
  {
    if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData != null)) {
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_v_of_type_Int = ((Long)paramObject).intValue();
    }
  }
  
  private void c(VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate != null)) {
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate.h(paramVideoPlayParam);
    }
    Object localObject;
    if ((paramVideoPlayParam != null) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      localObject = VideoFeedsPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoFeedsPlayManager.VideoStatusListener)((Iterator)localObject).next()).b(VideoFeedsPlayManager.a(this.a), this.a.f());
      }
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData != null))
    {
      localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData;
      ((AbsReadInJoyVideoReportData)localObject).f += SystemClock.uptimeMillis() - paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_e_of_type_Long;
      paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData;
      paramVideoPlayParam.jdField_d_of_type_Int += 1;
    }
    if ((VideoFeedsPlayManager.b(this.a) != null) && (VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean))
    {
      paramVideoPlayParam = this.a;
      paramVideoPlayParam = VideoFeedsPlayManager.a(paramVideoPlayParam, VideoFeedsPlayManager.b(paramVideoPlayParam));
      if ((paramVideoPlayParam != null) && (!paramVideoPlayParam.d())) {
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.k();
      }
    }
  }
  
  private void d(VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED");
      }
      IVideoUIDelegate localIVideoUIDelegate = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate;
      int i = 1;
      if (localIVideoUIDelegate != null)
      {
        localIVideoUIDelegate = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate;
        boolean bool;
        if (paramVideoPlayParam == VideoFeedsPlayManager.b(this.a)) {
          bool = true;
        } else {
          bool = false;
        }
        localIVideoUIDelegate.a(paramVideoPlayParam, bool, VideoFeedsPlayManager.d(this.a));
      }
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Long <= 0L) {
        i = 0;
      }
      if (i != 0) {
        paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_v_of_type_Long = (SystemClock.uptimeMillis() - paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Long);
      } else {
        paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_v_of_type_Long = 0L;
      }
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.w = (SystemClock.uptimeMillis() - paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.c);
    }
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (QLog.isColorLevel())
    {
      paramVideoPlayerWrapper = new StringBuilder();
      paramVideoPlayerWrapper.append("startVideoAfterPrepared(VideoPlayerWrapper player) mIsActivityOnResume=");
      paramVideoPlayerWrapper.append(VideoFeedsPlayManager.b(this.a));
      QLog.d("VideoFeedsPlayManager.preplay", 2, paramVideoPlayerWrapper.toString());
    }
    VideoFeedsPlayManager.a(this.a).removeMessages(-3);
    if (VideoFeedsPlayManager.b(this.a))
    {
      this.a.a();
      return;
    }
    VideoFeedsPlayManager.b(this.a, true);
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper)
  {
    paramIVideoPlayerWrapper = (VideoPlayerWrapper)paramIVideoPlayerWrapper;
    if (!VideoFeedsPlayManager.a(this.a, paramIVideoPlayerWrapper)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("播放状态回调 onCompletion() vid=");
      if (VideoFeedsPlayManager.a(this.a) != null) {
        paramIVideoPlayerWrapper = VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString;
      } else {
        paramIVideoPlayerWrapper = "param null";
      }
      localStringBuilder.append(paramIVideoPlayerWrapper);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, localStringBuilder.toString());
    }
    VideoFeedsPlayManager.a(this.a).post(new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.3(this));
    paramIVideoPlayerWrapper = VideoFeedsPlayManager.a(this.a);
    if ((paramIVideoPlayerWrapper != null) && (paramIVideoPlayerWrapper.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData != null))
    {
      paramIVideoPlayerWrapper.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Boolean = true;
      paramIVideoPlayerWrapper.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Boolean = true;
    }
    VideoFeedsPlayManager.c(this.a, true);
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    paramIVideoPlayerWrapper = (VideoPlayerWrapper)paramIVideoPlayerWrapper;
    if (!VideoFeedsPlayManager.a(this.a, paramIVideoPlayerWrapper))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared checkIsPlayerPlaying false");
      }
      paramObject = VideoFeedsPlayManager.b(this.a);
      if ((VideoFeedsPlayManager.a(this.a, paramObject) == paramIVideoPlayerWrapper) && (paramObject.jdField_a_of_type_Boolean)) {
        b();
      }
      return;
    }
    paramObject = VideoFeedsPlayManager.a(this.a);
    if ((paramObject != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("播放状态回调 onVideoPrepared() vid=");
      localStringBuilder.append(paramObject.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", mIsOpenedVideo = ");
      localStringBuilder.append(VideoFeedsPlayManager.a(this.a));
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, localStringBuilder.toString());
    }
    if (!VideoFeedsPlayManager.a(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "onVideoPrepared  return isOpenedVideo false");
      }
      return;
    }
    VideoFeedsPlayManager.a(this.a, false);
    a(paramObject);
    a(paramIVideoPlayerWrapper);
  }
  
  public void a(IVideoPlayerWrapper paramIVideoPlayerWrapper, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConnectQualityCallback json= ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramIVideoPlayerWrapper instanceof VideoPlayerWrapper))
    {
      VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)paramIVideoPlayerWrapper;
      boolean bool = VideoFeedsPlayManager.a(this.a, localVideoPlayerWrapper);
      localObject = null;
      paramIVideoPlayerWrapper = null;
      if (!bool)
      {
        localObject = this.a;
        if (localVideoPlayerWrapper == VideoFeedsPlayManager.a((VideoFeedsPlayManager)localObject, VideoFeedsPlayManager.b((VideoFeedsPlayManager)localObject)))
        {
          VideoFeedsPlayManager.a(this.a, paramString);
          if (VideoFeedsPlayManager.b(this.a) != null) {
            paramIVideoPlayerWrapper = VideoFeedsPlayManager.b(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
          }
          if (paramIVideoPlayerWrapper != null) {
            VideoBufferRangeController.a().a(localVideoPlayerWrapper, paramIVideoPlayerWrapper.jdField_d_of_type_Int, localVideoPlayerWrapper.d());
          }
        }
        return;
      }
      paramIVideoPlayerWrapper = (IVideoPlayerWrapper)localObject;
      if (VideoFeedsPlayManager.a(this.a) != null) {
        paramIVideoPlayerWrapper = VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      }
      if (paramIVideoPlayerWrapper != null) {
        VideoBufferRangeController.a().a(localVideoPlayerWrapper, paramIVideoPlayerWrapper.jdField_d_of_type_Int, localVideoPlayerWrapper.d());
      }
    }
    if (VideoFeedsPlayManager.a(this.a) != null)
    {
      if (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData == null) {
        return;
      }
      VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.h = paramString;
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData != null))
    {
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long != 0L) {
        return;
      }
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Long);
      Object localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData;
      ((AbsReadInJoyVideoReportData)localObject).f += paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long;
      localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData;
      ((AbsReadInJoyVideoReportData)localObject).jdField_d_of_type_Int += 1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=");
        ((StringBuilder)localObject).append(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(", 预加载状态：");
        ((StringBuilder)localObject).append(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.p);
        ((StringBuilder)localObject).append(", 预下载命中：");
        ((StringBuilder)localObject).append(VideoFeedsPlayManager.a(this.a, paramVideoPlayParam).jdField_b_of_type_Boolean);
        ((StringBuilder)localObject).append(", 首帧耗时：");
        ((StringBuilder)localObject).append(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long);
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public boolean a(IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("model : ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" what : ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" extra : ");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("detailInfo : ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" obj : ");
    if (paramObject != null) {
      paramObject = paramObject.toString();
    } else {
      paramObject = "";
    }
    ((StringBuilder)localObject).append(paramObject);
    paramObject = ((StringBuilder)localObject).toString();
    paramIVideoPlayerWrapper = (VideoPlayerWrapper)paramIVideoPlayerWrapper;
    if (!VideoFeedsPlayManager.a(this.a, paramIVideoPlayerWrapper))
    {
      paramString = this.a;
      if ((VideoFeedsPlayManager.a(paramString, VideoFeedsPlayManager.b(paramString)) == paramIVideoPlayerWrapper) && (paramIVideoPlayerWrapper != null))
      {
        paramIVideoPlayerWrapper.j();
        VideoFeedsPlayManager.b(this.a).jdField_a_of_type_Boolean = false;
      }
      return false;
    }
    paramIVideoPlayerWrapper = VideoFeedsPlayManager.a(this.a);
    if ((paramIVideoPlayerWrapper != null) && (paramIVideoPlayerWrapper.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("播放状态回调 onError() ");
      ((StringBuilder)localObject).append(paramObject);
      ((StringBuilder)localObject).append(", vid=");
      ((StringBuilder)localObject).append(paramIVideoPlayerWrapper.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
    }
    paramObject = ErrorCode.a(paramInt1, paramInt2, paramInt3);
    if ((paramIVideoPlayerWrapper != null) && (paramIVideoPlayerWrapper.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate != null)) {
      paramIVideoPlayerWrapper.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate.a(paramIVideoPlayerWrapper, paramInt1, paramInt2, paramObject);
    }
    if (VideoFeedsPlayManager.a(this.a) != null)
    {
      localObject = VideoFeedsPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoFeedsPlayManager.VideoStatusListener)((Iterator)localObject).next()).a(paramIVideoPlayerWrapper, paramInt1, paramInt2, paramObject);
      }
    }
    if ((paramIVideoPlayerWrapper != null) && (paramIVideoPlayerWrapper.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null)) {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(paramIVideoPlayerWrapper.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g, paramIVideoPlayerWrapper.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString, 1, paramInt2);
    }
    if ((paramIVideoPlayerWrapper != null) && (paramIVideoPlayerWrapper.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData != null))
    {
      paramIVideoPlayerWrapper.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Boolean = false;
      paramObject = paramIVideoPlayerWrapper.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramInt2);
      paramObject.jdField_d_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      paramIVideoPlayerWrapper.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_e_of_type_JavaLangString = paramString;
    }
    if ((VideoFeedsPlayManager.c(this.a)) && (VideoFeedsPlayManager.a(this.a) != null))
    {
      paramString = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo);
      paramObject = (IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class);
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isClickStateInVideoMode(VideoFeedsPlayManager.a(this.a))) {
        paramInt1 = 20;
      } else {
        paramInt1 = 0;
      }
      paramObject = paramObject.getVideoInfoObject(0, 0, 0, 0, paramInt1, 0, 0, 2, 2, 0, ReportConstants.VideoEndType.OTHER, true);
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(VideoFeedsPlayManager.a(this.a)).a(6).b(a(paramIVideoPlayerWrapper)).a(paramString).a(VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo).a(paramObject));
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).resetClickStateInVideoMode(VideoFeedsPlayManager.a(this.a));
    }
    return false;
  }
  
  public boolean a(IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    if ((!VideoFeedsPlayManager.a(this.a, paramInt)) && ((paramIVideoPlayerWrapper instanceof VideoPlayManager)) && (!VideoFeedsPlayManager.a(this.a, (VideoPlayerWrapper)paramIVideoPlayerWrapper))) {
      return false;
    }
    VideoPlayParam localVideoPlayParam1 = VideoFeedsPlayManager.a(this.a);
    VideoPlayParam localVideoPlayParam2 = VideoFeedsPlayManager.b(this.a);
    if ((localVideoPlayParam1 != null) && (paramIVideoPlayerWrapper == localVideoPlayParam1.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper)) {
      paramIVideoPlayerWrapper = localVideoPlayParam1;
    } else if ((localVideoPlayParam2 != null) && (paramIVideoPlayerWrapper == localVideoPlayParam2.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper)) {
      paramIVideoPlayerWrapper = localVideoPlayParam2;
    } else {
      paramIVideoPlayerWrapper = null;
    }
    if (paramInt != 105)
    {
      if (paramInt != 112)
      {
        if (paramInt != 113)
        {
          if (paramInt != 208)
          {
            if (paramInt != 209) {
              return false;
            }
            b(paramObject);
            return false;
          }
          a(paramObject);
          return false;
        }
        c(localVideoPlayParam1);
        return false;
      }
      b(localVideoPlayParam1);
      return false;
    }
    d(paramIVideoPlayerWrapper);
    return false;
  }
  
  public void b(IVideoPlayerWrapper paramIVideoPlayerWrapper)
  {
    super.b(paramIVideoPlayerWrapper);
    if ((paramIVideoPlayerWrapper instanceof VideoPlayerWrapper))
    {
      VideoFeedsPlayManager.a(this.a).removeMessages(-2);
      VideoFeedsPlayManager.a(this.a).sendEmptyMessage(-2);
      if ((VideoFeedsPlayManager.a(this.a) != null) && (VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper == paramIVideoPlayerWrapper))
      {
        VideoFeedsPlayManager.a(this.a).jdField_a_of_type_AndroidViewView = ((VideoPlayerWrapper)paramIVideoPlayerWrapper).a();
        VideoFeedsPlayManager.a(this.a).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate.b(VideoFeedsPlayManager.a(this.a), true);
      }
    }
  }
  
  public void c(IVideoPlayerWrapper paramIVideoPlayerWrapper)
  {
    VideoFeedsPlayManager.a(this.a).sendEmptyMessageDelayed(-2, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl
 * JD-Core Version:    0.7.0.1
 */
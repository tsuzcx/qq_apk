package com.tencent.mobileqq.kandian.glue.video;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.ad.api.entity.IRecommendADVideoFeedsManager;
import com.tencent.mobileqq.kandian.base.bandwidth.BandwidthPredictor;
import com.tencent.mobileqq.kandian.base.bandwidth.VideoBufferRangeController;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.VideoPlayUtils;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.base.video.player.config.CodecReuseHelper;
import com.tencent.mobileqq.kandian.base.video.player.config.CodecReuseHelper.Companion;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.plugin.OnVideoPluginInstallListener;
import com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.QualityReporter;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.api.OnPlayStateListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.BaseVideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import com.tencent.mobileqq.kandian.glue.video.report.VideoDTReport;
import com.tencent.mobileqq.kandian.glue.video.report.VideoDTReport.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.Nullable;

public class VideoPlayManager
  implements OnVideoPluginInstallListener, IVideoPlayManager
{
  public static final String a;
  protected int a;
  private volatile Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ReportConstants.VideoEndType jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = ReportConstants.VideoEndType.CLICK_PAUSE;
  private VideoPlayerWrapper jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
  private VideoPluginInstall jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall;
  private VideoAutoPlayController jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController;
  private VideoUIManager jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager;
  public VideoPlayParam a;
  private VideoPlayManager.PlayListenerAdapter jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager$PlayListenerAdapter = new VideoPlayManager.PlayListenerAdapter(this);
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr;
  private VideoRecommendManager jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager;
  private ArrayList<Pair<Integer, Bitmap>> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, VideoPlayerWrapper> jdField_a_of_type_JavaUtilHashMap;
  private Map<String, WeakReference<VideoPlayerWrapper>> jdField_a_of_type_JavaUtilMap;
  private Set<VideoPlayManager.VideoStatusListener> jdField_a_of_type_JavaUtilSet = null;
  private CopyOnWriteArrayList<OnPlayStateListener> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 1;
  private VideoPlayParam jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = null;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private VideoPlayParam jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = null;
  private boolean jdField_c_of_type_Boolean = true;
  private VideoPlayParam jdField_d_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = null;
  private volatile boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.video.");
    localStringBuilder.append(VideoPlayManager.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public VideoPlayManager(Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : create a new manager !");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall = new VideoPluginInstall();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a(this);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    VideoVolumeControl.getInstance().attachVideoManager(this);
  }
  
  private ReportConstants.VideoEndType a()
  {
    VideoPlayParam localVideoPlayParam = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if ((localVideoPlayParam != null) && ((localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo instanceof AdvertisementInfo)) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).containsAdClick((AdvertisementInfo)this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))) {
      return ReportConstants.VideoEndType.AD_AREA_CLICK;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType;
  }
  
  private void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper != null) && (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "video play completion!");
      }
      long l = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a(true);
      VideoPlayParam localVideoPlayParam = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
      this.jdField_d_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = localVideoPlayParam;
      this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = localVideoPlayParam;
      VideoRecommendManager localVideoRecommendManager = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager;
      localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Long = l;
      localVideoPlayParam.jdField_d_of_type_Long = b();
      if ((localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Long == 0L) && (localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long == 0L) && (localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Long != 0L)) {
        localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Long);
      }
      localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Float = ((float)localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Long / localVideoPlayParam.jdField_b_of_type_Int);
      localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Boolean = true;
      localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Boolean = true;
      localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_n_of_type_Long = paramVideoPlayerWrapper.c();
      localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_h_of_type_Int = paramVideoPlayerWrapper.e();
      localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.i = paramVideoPlayerWrapper.f();
      localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_c_of_type_Boolean = paramVideoPlayerWrapper.jdField_b_of_type_Boolean;
      localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_q_of_type_Long = paramVideoPlayerWrapper.jdField_b_of_type_Long;
      localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.p = paramVideoPlayerWrapper.jdField_a_of_type_Long;
      localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_r_of_type_Long = paramVideoPlayerWrapper.g();
      localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_n_of_type_Int = c();
      localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.o = d();
      if (this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam != null)
      {
        AbsReadInJoyVideoReportData localAbsReadInJoyVideoReportData = localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData;
        int i = this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_Int;
        int j = localVideoPlayParam.jdField_a_of_type_Int;
        boolean bool;
        if (localVideoPlayParam.m == 3) {
          bool = true;
        } else {
          bool = false;
        }
        localAbsReadInJoyVideoReportData.u = ReadInJoyUtils.a(i, j, bool);
      }
      else
      {
        localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.u = -1;
      }
      localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_e_of_type_Int = localVideoPlayParam.m;
      localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.l = paramVideoPlayerWrapper.p();
      a(localVideoPlayParam);
      paramVideoPlayerWrapper.a(localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.b());
      RIJStatisticCollectorReport.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), RIJQQAppInterfaceUtil.a(), true, localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.a());
      QualityReporter.a(localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData);
      RIJStatisticCollectorReport.a(true, localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Boolean, localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.i, localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Int, localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long, 56, localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_JavaLangString, localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a();
      if (localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Long > 0L) {
        ThreadManager.post(new VideoPlayManager.3(this, localVideoPlayParam, localVideoRecommendManager), 5, null, true);
      }
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800709B", "0X800709B", 0, 0, "", "", "", localVideoPlayParam.jdField_c_of_type_JavaLangString);
      a(localVideoPlayParam, l);
      a(paramVideoPlayerWrapper, localVideoPlayParam);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.4(this));
      return;
    }
    QLog.e("Q.readinjoy.video", 1, "onCompletion return for mVideoPlayerWrapper || mCurrenPlayVideoParam is null");
  }
  
  private void a(VideoPlayerWrapper paramVideoPlayerWrapper, VideoPlayParam paramVideoPlayParam)
  {
    VideoDTReport.a(paramVideoPlayerWrapper);
  }
  
  private void a(VideoPlayerWrapper paramVideoPlayerWrapper, VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    boolean bool = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    int j = 2;
    int i;
    if (bool) {
      i = 1;
    } else {
      i = 2;
    }
    paramVideoPlayParam = VideoDTReport.Builder.a(paramVideoPlayParam).a("14").b(i).a(paramVideoPlayParam.jdField_a_of_type_Int).b(paramVideoPlayerWrapper.b()).d(paramVideoPlayerWrapper.a());
    if (paramBoolean) {
      i = j;
    } else {
      i = 1;
    }
    paramVideoPlayParam = paramVideoPlayParam.c(i).d(1);
    VideoDTReport.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoPlayerWrapper, paramVideoPlayParam);
  }
  
  private void a(VideoPlayerWrapper paramVideoPlayerWrapper, Object paramObject)
  {
    paramObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onVideoPrepared() mIsOpenedVideo=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append("   mVisable:");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
      QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper == paramVideoPlayerWrapper) && (paramObject != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr.a(paramObject.jdField_a_of_type_Int, true);
      localObject = paramObject.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData;
      long l = 0L;
      if ((localObject != null) && (paramObject.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long == 0L))
      {
        paramObject.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramObject.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Long);
        localObject = paramObject.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData;
        ((AbsReadInJoyVideoReportData)localObject).f += paramObject.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long;
        localObject = paramObject.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData;
        ((AbsReadInJoyVideoReportData)localObject).jdField_d_of_type_Int += 1;
        if ((paramObject.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData != null) && (QLog.isColorLevel()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("video player ready. from open. prepare cost : ");
          ((StringBuilder)localObject).append(paramObject.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long);
          QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
        }
      }
      a(paramObject, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper, 2, null);
      if ((!VideoVolumeControl.isInCall(this.jdField_a_of_type_AndroidAppActivity)) && (GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_AndroidAppActivity)) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController != null))
      {
        paramVideoPlayerWrapper.d();
        a(paramObject, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper, 3, null);
        a(paramVideoPlayerWrapper, paramObject, false);
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onVideoPrepared start,in call stop.background:");
          ((StringBuilder)localObject).append(GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_AndroidAppActivity));
          QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.1(this));
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131716078));
      ((StringBuilder)localObject).append(paramVideoPlayerWrapper.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131716095));
      if (paramObject.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData != null) {
        l = paramObject.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long;
      }
      ((StringBuilder)localObject).append(l);
      paramVideoPlayerWrapper = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, paramVideoPlayerWrapper);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.w("Q.readinjoy.video", 2, "video player ready,but has error!");
    }
  }
  
  private void a(VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.t = BandwidthPredictor.from().getCurrentPrediction();
    paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_n_of_type_JavaLangString = VideoBufferRangeController.a().a();
  }
  
  private void a(VideoPlayParam paramVideoPlayParam, long paramLong)
  {
    Object localObject1 = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd((int)((AbsBaseArticleInfo)localObject1).mChannelID)) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject1)) && (paramVideoPlayParam.jdField_b_of_type_Boolean))
    {
      int i = (int)paramLong;
      localObject2 = (IRIJAdService)QRoute.api(IRIJAdService.class);
      localObject3 = new AdReportData().a(this.jdField_a_of_type_AndroidAppActivity).a(6).b(11);
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localObject1;
      ((IRIJAdService)localObject2).report(((AdReportData)localObject3).a(localAdvertisementInfo).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(localAdvertisementInfo.adbt, i, localAdvertisementInfo.getAdbf(), 1, localAdvertisementInfo.adpa, localAdvertisementInfo.adpb, ((AbsBaseArticleInfo)localObject1).mVideoDuration * 1000, 1, 0, localAdvertisementInfo.videoReplayCount, ReportConstants.VideoEndType.NORMAL_COMPLETE, localAdvertisementInfo.isClickReplay, false)));
      localAdvertisementInfo.isClickReplay = false;
      localAdvertisementInfo.videoReplayCount += 1;
    }
    paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.mChannelID == 56L) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramVideoPlayParam)))
    {
      localObject1 = (IRIJAdService)QRoute.api(IRIJAdService.class);
      localObject2 = new AdReportData().a(this.jdField_a_of_type_AndroidAppActivity).a(6).b(4);
      localObject3 = (AdvertisementInfo)paramVideoPlayParam;
      ((IRIJAdService)localObject1).report(((AdReportData)localObject2).a((AdvertisementInfo)localObject3).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(((AdvertisementInfo)localObject3).adbt, paramVideoPlayParam.mVideoDuration * 1000, ((AdvertisementInfo)localObject3).getAdbf(), 1, ((AdvertisementInfo)localObject3).adpa, ((AdvertisementInfo)localObject3).adpb, paramVideoPlayParam.mVideoDuration * 1000, 9, 0, ((AdvertisementInfo)localObject3).videoReplayCount, ReportConstants.VideoEndType.NORMAL_COMPLETE, ((AdvertisementInfo)localObject3).isClickReplay, false)));
      ((AdvertisementInfo)localObject3).isClickReplay = false;
      ((AdvertisementInfo)localObject3).videoReplayCount += 1;
    }
  }
  
  private void a(VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    try
    {
      int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (paramInt != i)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("changeStateAndNotify(): ");
          ((StringBuilder)localObject2).append(VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
          ((StringBuilder)localObject2).append(" ===> ");
          ((StringBuilder)localObject2).append(VideoPlayUtils.a(paramInt));
          ((StringBuilder)localObject2).append(", extra = ");
          ((StringBuilder)localObject2).append(paramObject);
          ((StringBuilder)localObject2).append(", videoPlayParam=");
          ((StringBuilder)localObject2).append(paramVideoPlayParam);
          ((StringBuilder)localObject2).append(", videoPlayWrapper=");
          ((StringBuilder)localObject2).append(paramVideoPlayerWrapper);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
        Object localObject1 = Thread.currentThread();
        Object localObject2 = Looper.getMainLooper().getThread();
        boolean bool = false;
        if (localObject1 == localObject2)
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
          {
            localObject1 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (OnPlayStateListener)((Iterator)localObject1).next();
              if (localObject2 != null) {
                ((OnPlayStateListener)localObject2).a(paramVideoPlayParam, paramVideoPlayerWrapper, i, paramInt, paramObject);
              }
            }
          }
          b(paramInt, false);
        }
        else
        {
          this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.7(this, paramVideoPlayParam, paramVideoPlayerWrapper, i, paramInt, paramObject));
        }
        if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null))
        {
          paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID;
          if (paramInt == 3) {
            bool = true;
          }
          ReadInJoyHelper.a(paramVideoPlayParam, bool, "NormalVideoPlay");
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramVideoPlayParam;
    }
  }
  
  private void a(boolean paramBoolean, Activity paramActivity, VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    IRIJAdService localIRIJAdService;
    Object localObject;
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mChannelID == 56L) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo)))
    {
      localIRIJAdService = (IRIJAdService)QRoute.api(IRIJAdService.class);
      localObject = new AdReportData().a(paramActivity).a(6).b(4);
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localAbsBaseArticleInfo;
      localIRIJAdService.report(((AdReportData)localObject).a(localAdvertisementInfo).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(localAdvertisementInfo.adbt, (int)paramVideoPlayParam.jdField_d_of_type_Long, localAdvertisementInfo.getAdbf(), 0, localAdvertisementInfo.adpa, localAdvertisementInfo.adpb, localAbsBaseArticleInfo.mVideoDuration * 1000, 9, 0, localAdvertisementInfo.videoReplayCount, a(), localAdvertisementInfo.isClickReplay, false)));
      localAdvertisementInfo.isClickReplay = false;
    }
    if ((!paramBoolean) && (localAbsBaseArticleInfo != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd((int)localAbsBaseArticleInfo.mChannelID)) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo)) && (paramVideoPlayParam.jdField_b_of_type_Boolean))
    {
      localIRIJAdService = (IRIJAdService)QRoute.api(IRIJAdService.class);
      paramActivity = new AdReportData().a(paramActivity).a(6).b(11);
      localObject = (AdvertisementInfo)localAbsBaseArticleInfo;
      localIRIJAdService.report(paramActivity.a((AdvertisementInfo)localObject).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(((AdvertisementInfo)localObject).adbt, (int)paramVideoPlayParam.jdField_d_of_type_Long, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, localAbsBaseArticleInfo.mVideoDuration * 1000, 1, 0, ((AdvertisementInfo)localObject).videoReplayCount, a(), ((AdvertisementInfo)localObject).isClickReplay, false)));
      ((AdvertisementInfo)localObject).isClickReplay = false;
    }
  }
  
  private boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
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
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("video play has error ! ");
      localStringBuilder.append(paramObject);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    paramObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = paramObject;
    if (paramObject != null) {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.j, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_c_of_type_JavaLangString, 1, paramInt2);
    }
    if (paramVideoPlayerWrapper == this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper) {
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.5(this, paramInt1, paramInt2, paramString, paramVideoPlayerWrapper));
    }
    return true;
  }
  
  private boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    StringBuilder localStringBuilder;
    if ((paramVideoPlayerWrapper == this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper) && (a() != 5))
    {
      paramVideoPlayerWrapper = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
      if ((paramVideoPlayerWrapper != null) && (paramVideoPlayerWrapper.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData != null))
      {
        paramVideoPlayerWrapper = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData;
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
                paramVideoPlayerWrapper.jdField_v_of_type_Int = ((Long)paramObject).intValue();
                return false;
              }
              CodecReuseHelper.a.a(paramObject, paramVideoPlayerWrapper);
              return false;
            }
            if (QLog.isColorLevel())
            {
              paramObject = jdField_a_of_type_JavaLangString;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onInfo(): video end buffering ! isPause=");
              localStringBuilder.append(d());
              QLog.d(paramObject, 2, localStringBuilder.toString());
            }
            if (!d()) {
              a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper, 3, null);
            }
            paramVideoPlayerWrapper.f += SystemClock.uptimeMillis() - paramVideoPlayerWrapper.jdField_e_of_type_Long;
            paramVideoPlayerWrapper.jdField_d_of_type_Int += 1;
            return false;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onInfo(): video start buffering !");
          }
          a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper, 4, null);
          paramVideoPlayerWrapper.jdField_e_of_type_Long = SystemClock.uptimeMillis();
          return false;
        }
        paramVideoPlayerWrapper.jdField_v_of_type_Long = (SystemClock.uptimeMillis() - paramVideoPlayerWrapper.jdField_b_of_type_Long);
        paramVideoPlayerWrapper.w = (SystemClock.uptimeMillis() - paramVideoPlayerWrapper.jdField_c_of_type_Long);
        this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.6(this));
        return false;
      }
    }
    if (QLog.isColorLevel())
    {
      paramVideoPlayerWrapper = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInfo(): what:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",extra:");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", getCurPlayState == paused, just ignore.");
      QLog.d(paramVideoPlayerWrapper, 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.b();
      if (localQQAppInterface != null) {
        return ((IPublicAccountDataManager)localQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).isFollowedUin(Long.valueOf(paramString));
      }
    }
    return false;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 3) && (!this.jdField_d_of_type_Boolean))
    {
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pause for not visible，isSubThread:");
        localStringBuilder.append(paramBoolean);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      a();
    }
  }
  
  private void b(VideoPlayerWrapper paramVideoPlayerWrapper, VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOpenVideo executed On SubThread, busitype:");
      ((StringBuilder)localObject).append(paramVideoPlayParam.f);
      ((StringBuilder)localObject).append(" vid:");
      ((StringBuilder)localObject).append(paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    if (localObject != null)
    {
      if (localObject != paramVideoPlayerWrapper) {
        return;
      }
      if (TextUtils.isEmpty(paramVideoPlayParam.jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager$PlayListenerAdapter.a(paramVideoPlayerWrapper, 201, 61, 0, "vid null", null);
        return;
      }
      if (paramVideoPlayParam.jdField_d_of_type_Long <= 0L) {
        paramVideoPlayParam.jdField_d_of_type_Long = VideoResumeManager.a.a(paramVideoPlayParam.j, paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      }
      if ((paramVideoPlayParam.f != 2) && (paramVideoPlayParam.f != 6))
      {
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isADVideoWithURL(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
        {
          ((AdvertisementInfo)paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).adbt = ((int)paramVideoPlayParam.jdField_d_of_type_Long);
          if (paramVideoPlayParam.jdField_d_of_type_Long == 0L)
          {
            ((AdvertisementInfo)paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).adpa = 1;
            ((AdvertisementInfo)paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).adpb = 1;
          }
          paramVideoPlayerWrapper.a("", paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoVid, 101, paramVideoPlayParam.jdField_d_of_type_Long, paramVideoPlayParam.jdField_e_of_type_Long, paramVideoPlayParam.jdField_b_of_type_Int);
        }
        else
        {
          paramVideoPlayerWrapper.a(paramVideoPlayParam.jdField_c_of_type_JavaLangString, 1, paramVideoPlayParam.jdField_d_of_type_Long);
        }
      }
      else
      {
        localObject = ThirdVideoManager.a();
        ((ThirdVideoManager)localObject).a(paramVideoPlayParam.jdField_c_of_type_JavaLangString, new VideoPlayManager.9(this, paramVideoPlayerWrapper, paramVideoPlayParam, (ThirdVideoManager)localObject));
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr;
      if (localObject != null)
      {
        paramVideoPlayerWrapper.jdField_b_of_type_Boolean = ((VideoPreDownloadMgr)localObject).a(paramVideoPlayParam.g, paramVideoPlayParam.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr.a(paramVideoPlayParam.jdField_c_of_type_JavaLangString, paramVideoPlayerWrapper.jdField_b_of_type_Boolean);
      }
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(paramVideoPlayParam.j, paramVideoPlayParam.jdField_c_of_type_JavaLangString, 0, 0);
    }
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    int i;
    if (localObject != null) {
      i = ((VideoPlayerWrapper)localObject).b();
    } else {
      i = 0;
    }
    if (i == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) {
      return i;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCurPlayState, should not happen...: mVideoPlayerWrapper.getCurrentStatus() = ");
      ((StringBuilder)localObject).append(VideoPlayUtils.a(i));
      ((StringBuilder)localObject).append(",mState.get()=");
      ((StringBuilder)localObject).append(VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
      QLog.w("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
    }
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long a()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    if (localVideoPlayerWrapper != null) {
      return localVideoPlayerWrapper.b();
    }
    return 0L;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public VideoPlayerWrapper a(VideoPlayParam paramVideoPlayParam)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return null;
    }
    VideoPlayerWrapper localVideoPlayerWrapper = new VideoPlayerWrapper(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    localVideoPlayerWrapper.e(true);
    localVideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager$PlayListenerAdapter);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "getVideoPlayer new instant!");
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramVideoPlayParam.a(), new WeakReference(localVideoPlayerWrapper));
    return localVideoPlayerWrapper;
  }
  
  public VideoPlayerWrapper a(String paramString)
  {
    paramString = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return (VideoPlayerWrapper)paramString.get();
    }
    return null;
  }
  
  public VideoUIManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager;
  }
  
  public VideoPlayParam a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
  }
  
  public String a()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    if (localVideoPlayerWrapper != null) {
      return localVideoPlayerWrapper.a();
    }
    return null;
  }
  
  public void a()
  {
    e(false);
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt, VideoPlayParam paramVideoPlayParam)
  {
    a(ReportConstants.VideoEndType.CLICK_PAUSE);
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if ((localObject != null) && ((((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo instanceof AdvertisementInfo))) {
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).removeAdVideoClick((AdvertisementInfo)this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    }
    this.jdField_d_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = null;
    StringBuilder localStringBuilder;
    if (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
      if (localObject != null)
      {
        if (((VideoPlayerWrapper)localObject).b() == 2) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.d();
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a(paramInt);
        a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper, 3, null);
        if (QLog.isColorLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("resume(): playVideo: mVideoPlayerWrapper.seekTo() position=");
          localStringBuilder.append(paramInt);
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper, paramVideoPlayParam, false);
        return;
      }
    }
    if (paramVideoPlayParam != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = paramVideoPlayParam;
      paramVideoPlayParam = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
      a(1);
      paramVideoPlayParam.jdField_d_of_type_Long = paramInt;
      a(paramVideoPlayParam);
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("resume(): mCurrenPlayVideoParam = null, playVideo: ");
        localStringBuilder.append(paramVideoPlayParam.jdField_c_of_type_JavaLangString);
        QLog.w((String)localObject, 2, localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: param = null && mVideoPlayerWrapper = null");
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper != null))
    {
      a(((VideoPlayParam)localObject).jdField_c_of_type_Long, paramInt);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
      if (localObject != null)
      {
        a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, (VideoPlayerWrapper)localObject, 0, null);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.l();
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper = null;
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = null;
      }
      else
      {
        VideoPlayParam localVideoPlayParam = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
        if (localVideoPlayParam != null)
        {
          a(localVideoPlayParam, (VideoPlayerWrapper)localObject, 0, null);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper = null;
          this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = null;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stop , from : ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("player stop [async]  stopID : ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", from : ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper != null)
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
      if ((localObject != null) && (((VideoPlayParam)localObject).jdField_c_of_type_Long == paramLong))
      {
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(false);
        a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper, 0, null);
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a(false);
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_d_of_type_Long = b();
        VideoResumeManager.a.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.j, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.b());
        if ((this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long == 0L) && (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Long != 0L)) {
          this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Long);
        }
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Float = ((float)this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Long / this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Int);
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_n_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.c();
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.e();
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.i = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.f();
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.jdField_b_of_type_Boolean;
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_q_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.jdField_b_of_type_Long;
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.p = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.jdField_a_of_type_Long;
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_r_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.g();
        if ((this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long == 0L))
        {
          this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Long);
          this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.f = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long;
        }
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_n_of_type_Int = c();
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.o = d();
        if (this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam != null)
        {
          localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData;
          int i = this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_Int;
          int j = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_Int;
          boolean bool;
          if (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.m == 3) {
            bool = true;
          } else {
            bool = false;
          }
          ((AbsReadInJoyVideoReportData)localObject).u = ReadInJoyUtils.a(i, j, bool);
        }
        else
        {
          this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.u = -1;
        }
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_e_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.m;
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.b();
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a();
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.b());
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
        ((VideoPlayerWrapper)localObject).l();
        a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam);
        RIJStatisticCollectorReport.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), RIJQQAppInterfaceUtil.a(), true, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.a());
        QualityReporter.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData);
        RIJStatisticCollectorReport.a(true, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Boolean, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.i, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Int, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_Long, 56, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_JavaLangString);
        if ((this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_d_of_type_Long > 0L) && (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Long > 0L)) {
          ThreadManager.post(new VideoPlayManager.10(this, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager, (VideoPlayerWrapper)localObject, this.jdField_b_of_type_Boolean, paramInt), 5, null, true);
        }
        this.e = false;
        this.jdField_c_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = null;
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper = null;
        return;
      }
    }
    QLog.e("Q.readinjoy.video", 1, "stop : current player is null or articleID is not equal!");
  }
  
  public void a(IRecommendADVideoFeedsManager paramIRecommendADVideoFeedsManager)
  {
    paramIRecommendADVideoFeedsManager.a(this);
  }
  
  public void a(VideoAutoPlayController paramVideoAutoPlayController)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController = paramVideoAutoPlayController;
  }
  
  public void a(VideoUIManager paramVideoUIManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager = paramVideoUIManager;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.a(this);
  }
  
  public void a(OnPlayStateListener paramOnPlayStateListener)
  {
    if (paramOnPlayStateListener != null)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
      if ((localCopyOnWriteArrayList != null) && (!localCopyOnWriteArrayList.contains(paramOnPlayStateListener))) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramOnPlayStateListener);
      }
    }
  }
  
  public void a(BaseVideoPlayParam paramBaseVideoPlayParam)
  {
    if (paramBaseVideoPlayParam != null)
    {
      if (!(paramBaseVideoPlayParam instanceof VideoPlayParam)) {
        return;
      }
      if (VideoVolumeControl.isInCall(this.jdField_a_of_type_AndroidAppActivity))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "playVideo in call return");
        }
        return;
      }
      paramBaseVideoPlayParam = (VideoPlayParam)paramBaseVideoPlayParam;
      try
      {
        this.jdField_d_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = null;
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = null;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.b(paramBaseVideoPlayParam);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "start install tencent sdk plugin");
          }
          this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = paramBaseVideoPlayParam;
          a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, null, 4, null);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a();
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("play video start ! playParams : ");
          ((StringBuilder)localObject2).append(paramBaseVideoPlayParam.toString());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        this.jdField_a_of_type_Boolean = true;
        Object localObject1 = a(paramBaseVideoPlayParam);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper = ((VideoPlayerWrapper)localObject1);
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = paramBaseVideoPlayParam;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper == null) {
          return;
        }
        a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper, 1, null);
        paramBaseVideoPlayParam.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a(paramBaseVideoPlayParam.jdField_a_of_type_AndroidViewViewGroup);
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a();
        if ((localObject2 != null) && (((IVideoView)localObject2).a() != null))
        {
          paramBaseVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView = ((IVideoView)localObject2);
          ((IVideoView)localObject2).a().setId(2131376064);
          paramBaseVideoPlayParam.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.b(this.jdField_a_of_type_Int);
          this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
          this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_c_of_type_Long = SystemClock.uptimeMillis();
          this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_q_of_type_Int = 0;
          this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_r_of_type_Int = 0;
          this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.s = 0;
          this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.g = false;
          this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_h_of_type_Boolean = false;
          ThreadManager.executeOnSubThread(new VideoPlayManager.8(this, (VideoPlayerWrapper)localObject1, paramBaseVideoPlayParam));
          return;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "playVideo failed, because get videoView == null!");
        a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, null, 6, "videoview null");
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper = null;
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = null;
        return;
      }
      catch (Exception paramBaseVideoPlayParam)
      {
        paramBaseVideoPlayParam.printStackTrace();
        QLog.e("Q.readinjoy.video", 1, "playVideo error:", paramBaseVideoPlayParam);
      }
    }
  }
  
  public void a(VideoPlayManager.VideoStatusListener paramVideoStatusListener)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramVideoStatusListener);
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(VideoRecommendManager paramVideoRecommendManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager = paramVideoRecommendManager;
  }
  
  public void a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ReportConstants.VideoEndType)) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = ((ReportConstants.VideoEndType)paramObject);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk success!");
      }
      VideoPlayParam localVideoPlayParam = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
      if (localVideoPlayParam != null) {
        a(localVideoPlayParam);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk fail!");
      }
      a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper, 6, "install failure");
      this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = null;
    }
  }
  
  public boolean a()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    return (localVideoPlayerWrapper != null) && (localVideoPlayerWrapper.f());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long b()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    if (localVideoPlayerWrapper != null) {
      return localVideoPlayerWrapper.a();
    }
    return 0L;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b()
  {
    this.jdField_d_of_type_Boolean = false;
    e(false);
  }
  
  public void b(int paramInt)
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    if (localVideoPlayerWrapper != null) {
      localVideoPlayerWrapper.a(paramInt);
    }
  }
  
  public void b(OnPlayStateListener paramOnPlayStateListener)
  {
    if (paramOnPlayStateListener != null)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
      if (localCopyOnWriteArrayList != null) {
        localCopyOnWriteArrayList.remove(paramOnPlayStateListener);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean b()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    return (localVideoPlayerWrapper != null) && (localVideoPlayerWrapper.l());
  }
  
  public int c()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    if (localVideoPlayerWrapper != null) {
      return localVideoPlayerWrapper.c();
    }
    return -1;
  }
  
  public long c()
  {
    VideoPlayParam localVideoPlayParam = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if (localVideoPlayParam == null) {
      return -1L;
    }
    return localVideoPlayParam.jdField_c_of_type_Long;
  }
  
  public void c()
  {
    f(false);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    if (localObject != null) {
      ((VideoPlayerWrapper)localObject).b(paramInt);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setXYaxis value:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    boolean bool = paramBoolean;
    if (localObject != null)
    {
      bool = paramBoolean;
      if (((VideoPlayParam)localObject).jdField_b_of_type_Boolean) {
        bool = true;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    if (localObject != null) {
      ((VideoPlayerWrapper)localObject).c(bool);
    }
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public int d()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    if (localVideoPlayerWrapper != null) {
      return localVideoPlayerWrapper.d();
    }
    return -1;
  }
  
  public long d()
  {
    VideoPlayParam localVideoPlayParam = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if (localVideoPlayParam == null) {
      return 0L;
    }
    return localVideoPlayParam.jdField_b_of_type_Long;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : destroy !");
    }
    a(ReportConstants.VideoEndType.EXIT_SCENE);
    a(7);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    if (localObject1 != null)
    {
      ((VideoPlayerWrapper)localObject1).l();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam != null) {
      this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.b();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall = null;
    try
    {
      this.jdField_a_of_type_AndroidAppActivity = null;
      VideoVolumeControl.getInstance().removeVideoManager(this);
      localObject1 = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)((WeakReference)((Iterator)localObject1).next()).get();
        if ((localVideoPlayerWrapper != null) && (!localVideoPlayerWrapper.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("VideoPlayerWrapper : ");
            localStringBuilder.append(localVideoPlayerWrapper.toString());
            localStringBuilder.append(" not release");
            QLog.d("Q.readinjoy.video", 2, localStringBuilder.toString());
          }
          localVideoPlayerWrapper.l();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager;
      if (localObject1 != null)
      {
        ((VideoUIManager)localObject1).n();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager = null;
      }
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = null;
      this.e = false;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void d(int paramInt)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      if (paramInt != 0) {
        a(ReportConstants.VideoEndType.EXIT_SCENE);
      }
      Object localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
      if ((localObject != null) && ((((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo instanceof AdvertisementInfo))) {
        ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).removeAdVideoClick((AdvertisementInfo)this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      }
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onVisiable() isPause()=");
        localStringBuilder.append(d());
        localStringBuilder.append(", mPausedByMannul:");
        localStringBuilder.append(this.e);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
      if ((localObject != null) && (((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData != null)) {
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if ((d()) && (!this.e)) {
        c();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager;
      if (localObject != null)
      {
        ((VideoUIManager)localObject).a();
        if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.a(false);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.a(true);
        }
      }
      BandwidthPredictor.from().start(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper != null)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam == null) {
        return false;
      }
      if (a() == 5)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.e()) && (QLog.isColorLevel())) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return true. getCurPlayState is PLAY_STATE_PAUSED. But mVideoPlayerWrapper.isPause() == false;");
        }
        return true;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.e()) && (QLog.isColorLevel()))
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isPause(): return false. getCurPlayState is ");
        localStringBuilder.append(VideoPlayUtils.a(a()));
        localStringBuilder.append(". But mVideoPlayerWrapper.isPause() == true;");
        QLog.w(str, 2, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  public void e()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUnVisiable() isPlaying()=");
        localStringBuilder.append(a());
        localStringBuilder.append(", isOpening()=");
        localStringBuilder.append(f());
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (a())
      {
        a();
      }
      else if (f())
      {
        a(ReportConstants.VideoEndType.EXIT_SCENE);
        a(8);
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager;
      if (localObject != null)
      {
        ((VideoUIManager)localObject).b();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager.a(false);
      }
      BandwidthPredictor.from().stop(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    if ((localObject != null) && (((VideoPlayerWrapper)localObject).f()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.f();
      this.e = paramBoolean;
      if (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.j();
      }
      a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper, 5, Boolean.valueOf(this.e));
      this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_d_of_type_Long = b();
      this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a(false);
      localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if ((localObject != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd((int)((AbsBaseArticleInfo)localObject).mChannelID)) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject)) && ((this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Boolean) || (((AbsBaseArticleInfo)localObject).mChannelID == 56L)))
      {
        int i = 11;
        int j;
        if (((AbsBaseArticleInfo)localObject).mChannelID == 56L)
        {
          i = 4;
          j = 9;
        }
        else
        {
          j = 1;
        }
        IRIJAdService localIRIJAdService = (IRIJAdService)QRoute.api(IRIJAdService.class);
        AdReportData localAdReportData = new AdReportData().a(this.jdField_a_of_type_AndroidAppActivity).a(6).b(i);
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localObject;
        localIRIJAdService.report(localAdReportData.a(localAdvertisementInfo).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(localAdvertisementInfo.adbt, (int)this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_d_of_type_Long, localAdvertisementInfo.getAdbf(), 0, localAdvertisementInfo.adpa, localAdvertisementInfo.adpb, ((AbsBaseArticleInfo)localObject).mVideoDuration * 1000, j, 0, localAdvertisementInfo.videoReplayCount, a(), localAdvertisementInfo.isClickReplay, false)));
        localAdvertisementInfo.isClickReplay = false;
        localAdvertisementInfo.adbt = ((int)this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_d_of_type_Long);
      }
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper != null) && (a() == 2);
  }
  
  void f()
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkPlayStateAfterPhoneCall isVisible() = ");
      localStringBuilder.append(g());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (!g()) {
      return;
    }
    c();
  }
  
  public void f(boolean paramBoolean)
  {
    if (d())
    {
      if (VideoVolumeControl.isInCall(this.jdField_a_of_type_AndroidAppActivity))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "VideoPlayManager resume, in call return");
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoPlayManager : resume(), mannulResume:");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(", mPausedByMannul:");
        localStringBuilder.append(this.e);
        QLog.d("Q.readinjoy.video", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.e();
      this.jdField_a_of_type_Boolean = true;
      this.e = false;
      a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper, 3, null);
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, paramBoolean);
    }
  }
  
  public boolean f()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    return (localVideoPlayerWrapper != null) && (localVideoPlayerWrapper.b());
  }
  
  public boolean g()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean h()
  {
    VideoUIManager localVideoUIManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager;
    if (localVideoUIManager != null) {
      return localVideoUIManager.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPlayManager
 * JD-Core Version:    0.7.0.1
 */
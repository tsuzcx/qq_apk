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
import com.tencent.mobileqq.kandian.base.bandwidth.BandwidthMonitor;
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
  private boolean A = false;
  private Handler B = new Handler(Looper.getMainLooper());
  private Set<VideoPlayManager.VideoStatusListener> C = null;
  private VideoAutoPlayController D;
  private VideoRecommendManager E;
  public VideoPlayParam b = null;
  protected int c;
  private AtomicInteger d = new AtomicInteger(0);
  private VideoPluginInstall e;
  private VideoPlayerWrapper f;
  private volatile Activity g;
  private VideoPlayParam h = null;
  private VideoPlayParam i = null;
  private VideoPlayParam j = null;
  private ArrayList<Pair<Integer, Bitmap>> k;
  private HashMap<Integer, VideoPlayerWrapper> l;
  private boolean m = false;
  private int n = 1;
  private boolean o;
  private boolean p = true;
  private Map<String, WeakReference<VideoPlayerWrapper>> q;
  private VideoPreDownloadMgr r;
  private CopyOnWriteArrayList<OnPlayStateListener> s;
  private VideoUIManager t;
  private volatile boolean u;
  private boolean v;
  private String w;
  private ReportConstants.VideoEndType x = ReportConstants.VideoEndType.CLICK_PAUSE;
  private VideoPlayManager.PlayListenerAdapter y = new VideoPlayManager.PlayListenerAdapter(this);
  private boolean z = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.video.");
    localStringBuilder.append(VideoPlayManager.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public VideoPlayManager(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : create a new manager !");
    }
    this.g = paramActivity;
    this.e = new VideoPluginInstall();
    this.e.a(this);
    this.l = new HashMap();
    this.k = new ArrayList();
    this.q = new HashMap();
    this.s = new CopyOnWriteArrayList();
    VideoVolumeControl.getInstance().attachVideoManager(this);
  }
  
  private ReportConstants.VideoEndType E()
  {
    VideoPlayParam localVideoPlayParam = this.h;
    if ((localVideoPlayParam != null) && ((localVideoPlayParam.D instanceof AdvertisementInfo)) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).containsAdClick((AdvertisementInfo)this.h.D))) {
      return ReportConstants.VideoEndType.AD_AREA_CLICK;
    }
    return this.x;
  }
  
  private void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if ((this.f != null) && (this.h != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "video play completion!");
      }
      long l1 = this.f.d(true);
      VideoPlayParam localVideoPlayParam = this.h;
      this.j = localVideoPlayParam;
      this.i = localVideoPlayParam;
      VideoRecommendManager localVideoRecommendManager = this.E;
      localVideoPlayParam.z.h = l1;
      localVideoPlayParam.k = f();
      if ((localVideoPlayParam.z.h == 0L) && (localVideoPlayParam.z.o == 0L) && (localVideoPlayParam.z.m != 0L)) {
        localVideoPlayParam.z.o = (SystemClock.uptimeMillis() - localVideoPlayParam.z.m);
      }
      localVideoPlayParam.z.r = ((float)localVideoPlayParam.z.h / localVideoPlayParam.l);
      localVideoPlayParam.z.j = true;
      localVideoPlayParam.z.D = true;
      localVideoPlayParam.z.E = paramVideoPlayerWrapper.J();
      localVideoPlayParam.z.F = paramVideoPlayerWrapper.K();
      localVideoPlayParam.z.G = paramVideoPlayerWrapper.L();
      localVideoPlayParam.z.H = paramVideoPlayerWrapper.g;
      localVideoPlayParam.z.M = paramVideoPlayerWrapper.e;
      localVideoPlayParam.z.L = paramVideoPlayerWrapper.c;
      localVideoPlayParam.z.N = paramVideoPlayerWrapper.P();
      localVideoPlayParam.z.R = x();
      localVideoPlayParam.z.S = y();
      if (this.i != null)
      {
        AbsReadInJoyVideoReportData localAbsReadInJoyVideoReportData = localVideoPlayParam.z;
        int i1 = this.i.e;
        int i2 = localVideoPlayParam.e;
        boolean bool;
        if (localVideoPlayParam.O == 3) {
          bool = true;
        } else {
          bool = false;
        }
        localAbsReadInJoyVideoReportData.ak = ReadInJoyUtils.a(i1, i2, bool);
      }
      else
      {
        localVideoPlayParam.z.ak = -1;
      }
      localVideoPlayParam.z.t = localVideoPlayParam.O;
      localVideoPlayParam.z.at = paramVideoPlayerWrapper.Z();
      b(localVideoPlayParam);
      paramVideoPlayerWrapper.a(localVideoPlayParam.z.b());
      RIJStatisticCollectorReport.a(this.g.getApplicationContext(), RIJQQAppInterfaceUtil.d(), true, localVideoPlayParam.z.a());
      QualityReporter.a(localVideoPlayParam.z);
      RIJStatisticCollectorReport.a(true, localVideoPlayParam.z.T, localVideoPlayParam.z.G, localVideoPlayParam.z.g, localVideoPlayParam.z.o, 56, localVideoPlayParam.z.k, localVideoPlayParam.z.e);
      this.f.I();
      this.f.H();
      if (localVideoPlayParam.z.h > 0L) {
        ThreadManager.post(new VideoPlayManager.3(this, localVideoPlayParam, localVideoRecommendManager), 5, null, true);
      }
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800709B", "0X800709B", 0, 0, "", "", "", localVideoPlayParam.d);
      a(localVideoPlayParam, l1);
      a(paramVideoPlayerWrapper, localVideoPlayParam);
      this.B.post(new VideoPlayManager.4(this));
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
    boolean bool = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramVideoPlayParam.D);
    int i2 = 2;
    int i1;
    if (bool) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    paramVideoPlayParam = VideoDTReport.Builder.a(paramVideoPlayParam).a("14").b(i1).a(paramVideoPlayParam.e).b(paramVideoPlayerWrapper.I()).d(paramVideoPlayerWrapper.H());
    if (paramBoolean) {
      i1 = i2;
    } else {
      i1 = 1;
    }
    paramVideoPlayParam = paramVideoPlayParam.c(i1).d(1);
    VideoDTReport.a(this.g, paramVideoPlayerWrapper, paramVideoPlayParam);
  }
  
  private void a(VideoPlayerWrapper paramVideoPlayerWrapper, Object paramObject)
  {
    paramObject = this.h;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onVideoPrepared() mIsOpenedVideo=");
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append("   mVisable:");
      ((StringBuilder)localObject).append(this.u);
      QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.m) {
      return;
    }
    this.m = false;
    if ((this.f == paramVideoPlayerWrapper) && (paramObject != null))
    {
      this.r.a(paramObject.e, true);
      localObject = paramObject.z;
      long l1 = 0L;
      if ((localObject != null) && (paramObject.z.o == 0L))
      {
        paramObject.z.o = (SystemClock.uptimeMillis() - paramObject.z.m);
        localObject = paramObject.z;
        ((AbsReadInJoyVideoReportData)localObject).q += paramObject.z.o;
        localObject = paramObject.z;
        ((AbsReadInJoyVideoReportData)localObject).s += 1;
        if ((paramObject.z != null) && (QLog.isColorLevel()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("video player ready. from open. prepare cost : ");
          ((StringBuilder)localObject).append(paramObject.z.o);
          QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
        }
      }
      a(paramObject, this.f, 2, null);
      if ((!VideoVolumeControl.isInCall(this.g)) && (GesturePWDUtils.isAppOnForeground(this.g)) && (this.D != null))
      {
        paramVideoPlayerWrapper.u();
        a(paramObject, this.f, 3, null);
        a(paramVideoPlayerWrapper, paramObject, false);
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onVideoPrepared start,in call stop.background:");
          ((StringBuilder)localObject).append(GesturePWDUtils.isAppOnForeground(this.g));
          QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
        }
        this.B.post(new VideoPlayManager.1(this));
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131913528));
      ((StringBuilder)localObject).append(paramVideoPlayerWrapper.g);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131913544));
      if (paramObject.z != null) {
        l1 = paramObject.z.o;
      }
      ((StringBuilder)localObject).append(l1);
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
  
  private void a(VideoPlayParam paramVideoPlayParam, long paramLong)
  {
    Object localObject1 = paramVideoPlayParam.D;
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd((int)((AbsBaseArticleInfo)localObject1).mChannelID)) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject1)) && (paramVideoPlayParam.M))
    {
      int i1 = (int)paramLong;
      localObject2 = (IRIJAdService)QRoute.api(IRIJAdService.class);
      localObject3 = new AdReportData().a(this.g).a(6).b(11);
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localObject1;
      ((IRIJAdService)localObject2).report(((AdReportData)localObject3).a(localAdvertisementInfo).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(localAdvertisementInfo.adbt, i1, localAdvertisementInfo.getAdbf(), 1, localAdvertisementInfo.adpa, localAdvertisementInfo.adpb, ((AbsBaseArticleInfo)localObject1).mVideoDuration * 1000, 1, 0, localAdvertisementInfo.videoReplayCount, ReportConstants.VideoEndType.NORMAL_COMPLETE, localAdvertisementInfo.isClickReplay, false)));
      localAdvertisementInfo.isClickReplay = false;
      localAdvertisementInfo.videoReplayCount += 1;
    }
    paramVideoPlayParam = paramVideoPlayParam.D;
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.mChannelID == 56L) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramVideoPlayParam)))
    {
      localObject1 = (IRIJAdService)QRoute.api(IRIJAdService.class);
      localObject2 = new AdReportData().a(this.g).a(6).b(4);
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
      int i1 = this.d.get();
      if (paramInt != i1)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("changeStateAndNotify(): ");
          ((StringBuilder)localObject2).append(VideoPlayUtils.a(this.d.get()));
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
        this.d.set(paramInt);
        Object localObject1 = Thread.currentThread();
        Object localObject2 = Looper.getMainLooper().getThread();
        boolean bool = false;
        if (localObject1 == localObject2)
        {
          if (this.s != null)
          {
            localObject1 = this.s.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (OnPlayStateListener)((Iterator)localObject1).next();
              if (localObject2 != null) {
                ((OnPlayStateListener)localObject2).a(paramVideoPlayParam, paramVideoPlayerWrapper, i1, paramInt, paramObject);
              }
            }
          }
          b(paramInt, false);
        }
        else
        {
          this.B.post(new VideoPlayManager.7(this, paramVideoPlayParam, paramVideoPlayerWrapper, i1, paramInt, paramObject));
        }
        if ((paramVideoPlayParam != null) && (paramVideoPlayParam.D != null))
        {
          paramVideoPlayParam = paramVideoPlayParam.D.innerUniqueID;
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
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramVideoPlayParam.D;
    IRIJAdService localIRIJAdService;
    Object localObject;
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mChannelID == 56L) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo)))
    {
      localIRIJAdService = (IRIJAdService)QRoute.api(IRIJAdService.class);
      localObject = new AdReportData().a(paramActivity).a(6).b(4);
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localAbsBaseArticleInfo;
      localIRIJAdService.report(((AdReportData)localObject).a(localAdvertisementInfo).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(localAdvertisementInfo.adbt, (int)paramVideoPlayParam.k, localAdvertisementInfo.getAdbf(), 0, localAdvertisementInfo.adpa, localAdvertisementInfo.adpb, localAbsBaseArticleInfo.mVideoDuration * 1000, 9, 0, localAdvertisementInfo.videoReplayCount, E(), localAdvertisementInfo.isClickReplay, false)));
      localAdvertisementInfo.isClickReplay = false;
    }
    if ((!paramBoolean) && (localAbsBaseArticleInfo != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd((int)localAbsBaseArticleInfo.mChannelID)) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo)) && (paramVideoPlayParam.M))
    {
      localIRIJAdService = (IRIJAdService)QRoute.api(IRIJAdService.class);
      paramActivity = new AdReportData().a(paramActivity).a(6).b(11);
      localObject = (AdvertisementInfo)localAbsBaseArticleInfo;
      localIRIJAdService.report(paramActivity.a((AdvertisementInfo)localObject).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(((AdvertisementInfo)localObject).adbt, (int)paramVideoPlayParam.k, ((AdvertisementInfo)localObject).getAdbf(), 0, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, localAbsBaseArticleInfo.mVideoDuration * 1000, 1, 0, ((AdvertisementInfo)localObject).videoReplayCount, E(), ((AdvertisementInfo)localObject).isClickReplay, false)));
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
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("video play has error ! ");
      localStringBuilder.append(paramObject);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    paramObject = this.h;
    this.b = paramObject;
    if (paramObject != null) {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(this.h.y, this.h.d, 1, paramInt2);
    }
    if (paramVideoPlayerWrapper == this.f) {
      this.B.post(new VideoPlayManager.5(this, paramInt1, paramInt2, paramString, paramVideoPlayerWrapper));
    }
    return true;
  }
  
  private boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    StringBuilder localStringBuilder;
    if ((paramVideoPlayerWrapper == this.f) && (j() != 5))
    {
      paramVideoPlayerWrapper = this.h;
      if ((paramVideoPlayerWrapper != null) && (paramVideoPlayerWrapper.z != null))
      {
        paramVideoPlayerWrapper = this.h.z;
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
                paramVideoPlayerWrapper.ay = ((Long)paramObject).intValue();
                return false;
              }
              CodecReuseHelper.a.a(paramObject, paramVideoPlayerWrapper);
              return false;
            }
            if (QLog.isColorLevel())
            {
              paramObject = a;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onInfo(): video end buffering ! isPause=");
              localStringBuilder.append(s());
              QLog.d(paramObject, 2, localStringBuilder.toString());
            }
            if (!s()) {
              a(this.h, this.f, 3, null);
            }
            paramVideoPlayerWrapper.q += SystemClock.uptimeMillis() - paramVideoPlayerWrapper.p;
            paramVideoPlayerWrapper.s += 1;
            return false;
          }
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "onInfo(): video start buffering !");
          }
          a(this.h, this.f, 4, null);
          paramVideoPlayerWrapper.p = SystemClock.uptimeMillis();
          return false;
        }
        paramVideoPlayerWrapper.au = (SystemClock.uptimeMillis() - paramVideoPlayerWrapper.m);
        paramVideoPlayerWrapper.av = (SystemClock.uptimeMillis() - paramVideoPlayerWrapper.n);
        this.B.post(new VideoPlayManager.6(this));
        return false;
      }
    }
    if (QLog.isColorLevel())
    {
      paramVideoPlayerWrapper = a;
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
    if ((paramInt == 3) && (!this.u))
    {
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pause for not visible，isSubThread:");
        localStringBuilder.append(paramBoolean);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      c();
    }
  }
  
  private void b(VideoPlayerWrapper paramVideoPlayerWrapper, VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOpenVideo executed On SubThread, busitype:");
      ((StringBuilder)localObject).append(paramVideoPlayParam.x);
      ((StringBuilder)localObject).append(" vid:");
      ((StringBuilder)localObject).append(paramVideoPlayParam.d);
      QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.f;
    if (localObject != null)
    {
      if (localObject != paramVideoPlayerWrapper) {
        return;
      }
      if (TextUtils.isEmpty(paramVideoPlayParam.d))
      {
        this.y.a(paramVideoPlayerWrapper, 201, 61, 0, "vid null", null);
        return;
      }
      if (paramVideoPlayParam.k <= 0L) {
        paramVideoPlayParam.k = VideoResumeManager.a.a(paramVideoPlayParam.y, paramVideoPlayParam.d);
      }
      if ((paramVideoPlayParam.x != 2) && (paramVideoPlayParam.x != 6))
      {
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isADVideoWithURL(paramVideoPlayParam.D))
        {
          ((AdvertisementInfo)paramVideoPlayParam.D).adbt = ((int)paramVideoPlayParam.k);
          if (paramVideoPlayParam.k == 0L)
          {
            ((AdvertisementInfo)paramVideoPlayParam.D).adpa = 1;
            ((AdvertisementInfo)paramVideoPlayParam.D).adpb = 1;
          }
          paramVideoPlayerWrapper.a("", paramVideoPlayParam.D.mVideoVid, 101, paramVideoPlayParam.k, paramVideoPlayParam.m, paramVideoPlayParam.l);
        }
        else
        {
          paramVideoPlayerWrapper.a(paramVideoPlayParam.d, 1, paramVideoPlayParam.k);
        }
      }
      else
      {
        localObject = ThirdVideoManager.a();
        ((ThirdVideoManager)localObject).a(paramVideoPlayParam.d, new VideoPlayManager.9(this, paramVideoPlayerWrapper, paramVideoPlayParam, (ThirdVideoManager)localObject));
      }
      localObject = this.r;
      if (localObject != null)
      {
        paramVideoPlayerWrapper.g = ((VideoPreDownloadMgr)localObject).a(paramVideoPlayParam.t, paramVideoPlayParam.d);
        this.r.a(paramVideoPlayParam.d, paramVideoPlayerWrapper.g);
      }
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(paramVideoPlayParam.y, paramVideoPlayParam.d, 0, 0);
    }
  }
  
  private void b(VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam.z.an = BandwidthPredictor.from().getCurrentPrediction();
    paramVideoPlayParam.z.ao = VideoBufferRangeController.a().b();
  }
  
  public boolean A()
  {
    return this.u;
  }
  
  public boolean B()
  {
    VideoUIManager localVideoUIManager = this.t;
    if (localVideoUIManager != null) {
      return localVideoUIManager.c();
    }
    return false;
  }
  
  public String C()
  {
    return this.w;
  }
  
  void D()
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkPlayStateAfterPhoneCall isVisible() = ");
      localStringBuilder.append(A());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (!A()) {
      return;
    }
    v();
  }
  
  public VideoPlayerWrapper a(VideoPlayParam paramVideoPlayParam)
  {
    if (this.g == null) {
      return null;
    }
    VideoPlayerWrapper localVideoPlayerWrapper = new VideoPlayerWrapper(this.g.getApplicationContext());
    localVideoPlayerWrapper.i(true);
    localVideoPlayerWrapper.a(this.y);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "getVideoPlayer new instant!");
    }
    this.q.put(paramVideoPlayParam.a(), new WeakReference(localVideoPlayerWrapper));
    return localVideoPlayerWrapper;
  }
  
  public VideoPlayParam a()
  {
    return this.h;
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt, VideoPlayParam paramVideoPlayParam)
  {
    a(ReportConstants.VideoEndType.CLICK_PAUSE);
    Object localObject = this.h;
    if ((localObject != null) && ((((VideoPlayParam)localObject).D instanceof AdvertisementInfo))) {
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).removeAdVideoClick((AdvertisementInfo)this.h.D);
    }
    this.j = null;
    StringBuilder localStringBuilder;
    if (this.h != null)
    {
      localObject = this.f;
      if (localObject != null)
      {
        if (((VideoPlayerWrapper)localObject).h() == 2) {
          this.f.u();
        }
        this.f.a(paramInt);
        a(this.h, this.f, 3, null);
        if (QLog.isColorLevel())
        {
          localObject = a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("resume(): playVideo: mVideoPlayerWrapper.seekTo() position=");
          localStringBuilder.append(paramInt);
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        a(this.f, paramVideoPlayParam, false);
        return;
      }
    }
    if (paramVideoPlayParam != null)
    {
      this.h = paramVideoPlayParam;
      paramVideoPlayParam = this.h;
      a(1);
      paramVideoPlayParam.k = paramInt;
      a(paramVideoPlayParam);
      if (QLog.isColorLevel())
      {
        localObject = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("resume(): mCurrenPlayVideoParam = null, playVideo: ");
        localStringBuilder.append(paramVideoPlayParam.d);
        QLog.w((String)localObject, 2, localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e(a, 2, "resume(): playVideo: param = null && mVideoPlayerWrapper = null");
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.o = paramBoolean;
    Object localObject = this.h;
    if ((localObject != null) && (this.f != null))
    {
      a(((VideoPlayParam)localObject).j, paramInt);
    }
    else
    {
      localObject = this.f;
      if (localObject != null)
      {
        a(this.h, (VideoPlayerWrapper)localObject, 0, null);
        this.f.D();
        this.f = null;
        this.h = null;
      }
      else
      {
        VideoPlayParam localVideoPlayParam = this.h;
        if (localVideoPlayParam != null)
        {
          a(localVideoPlayParam, (VideoPlayerWrapper)localObject, 0, null);
          this.f = null;
          this.h = null;
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
    if (this.f != null)
    {
      localObject = this.h;
      if ((localObject != null) && (((VideoPlayParam)localObject).j == paramLong))
      {
        this.h.g.setKeepScreenOn(false);
        a(this.h, this.f, 0, null);
        this.h.z.h = this.f.d(false);
        this.h.k = f();
        VideoResumeManager.a.a(this.h.y, this.h.d, this.h.k, this.f.I());
        if ((this.h.z.h == 0L) && (this.h.z.o == 0L) && (this.h.z.m != 0L)) {
          this.h.z.o = (SystemClock.uptimeMillis() - this.h.z.m);
        }
        this.h.z.r = ((float)this.h.z.h / this.h.l);
        this.h.z.j = true;
        this.h.z.E = this.f.J();
        this.h.z.F = this.f.K();
        this.h.z.G = this.f.L();
        this.h.z.H = this.f.g;
        this.h.z.M = this.f.e;
        this.h.z.L = this.f.c;
        this.h.z.N = this.f.P();
        if ((this.h.z.h == 0L) && (this.h.z.o == 0L))
        {
          this.h.z.o = (SystemClock.uptimeMillis() - this.h.z.m);
          this.h.z.q = this.h.z.o;
        }
        this.h.z.R = x();
        this.h.z.S = y();
        if (this.i != null)
        {
          localObject = this.h.z;
          int i1 = this.i.e;
          int i2 = this.h.e;
          boolean bool;
          if (this.h.O == 3) {
            bool = true;
          } else {
            bool = false;
          }
          ((AbsReadInJoyVideoReportData)localObject).ak = ReadInJoyUtils.a(i1, i2, bool);
        }
        else
        {
          this.h.z.ak = -1;
        }
        this.h.z.t = this.h.O;
        this.f.I();
        this.f.H();
        this.f.a(this.h.z.b());
        localObject = this.f;
        ((VideoPlayerWrapper)localObject).D();
        b(this.h);
        RIJStatisticCollectorReport.a(this.g.getApplicationContext(), RIJQQAppInterfaceUtil.d(), true, this.h.z.a());
        QualityReporter.a(this.h.z);
        RIJStatisticCollectorReport.a(true, this.h.z.T, this.h.z.G, this.h.z.g, this.h.z.o, 56, this.h.z.k, this.h.z.e);
        if ((this.h.k > 0L) && (this.h.z.h > 0L)) {
          ThreadManager.post(new VideoPlayManager.10(this, this.h, this.E, (VideoPlayerWrapper)localObject, this.o, paramInt), 5, null, true);
        }
        this.v = false;
        this.i = this.h;
        this.h = null;
        this.f = null;
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
    this.D = paramVideoAutoPlayController;
  }
  
  public void a(VideoUIManager paramVideoUIManager)
  {
    this.t = paramVideoUIManager;
    this.t.a(this);
  }
  
  public void a(OnPlayStateListener paramOnPlayStateListener)
  {
    if (paramOnPlayStateListener != null)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = this.s;
      if ((localCopyOnWriteArrayList != null) && (!localCopyOnWriteArrayList.contains(paramOnPlayStateListener))) {
        this.s.add(paramOnPlayStateListener);
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
      if (VideoVolumeControl.isInCall(this.g))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "playVideo in call return");
        }
        return;
      }
      paramBaseVideoPlayParam = (VideoPlayParam)paramBaseVideoPlayParam;
      try
      {
        this.j = null;
        this.b = null;
        if (this.t != null) {
          this.t.b(paramBaseVideoPlayParam);
        }
        if (!this.e.b())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "start install tencent sdk plugin");
          }
          this.h = paramBaseVideoPlayParam;
          a(this.h, null, 4, null);
          this.e.a();
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("play video start ! playParams : ");
          ((StringBuilder)localObject2).append(paramBaseVideoPlayParam.toString());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        this.m = true;
        Object localObject1 = a(paramBaseVideoPlayParam);
        this.f = ((VideoPlayerWrapper)localObject1);
        this.h = paramBaseVideoPlayParam;
        if (this.f == null) {
          return;
        }
        a(this.h, this.f, 1, null);
        paramBaseVideoPlayParam.g.removeAllViews();
        this.f.a(paramBaseVideoPlayParam.g);
        Object localObject2 = this.f.c();
        if ((localObject2 != null) && (((IVideoView)localObject2).a() != null))
        {
          paramBaseVideoPlayParam.i = ((IVideoView)localObject2);
          ((IVideoView)localObject2).a().setId(2131444264);
          paramBaseVideoPlayParam.g.setKeepScreenOn(true);
          this.f.b(this.c);
          this.h.z.m = SystemClock.uptimeMillis();
          this.h.z.n = SystemClock.uptimeMillis();
          this.h.z.W = 0;
          this.h.z.X = 0;
          this.h.z.Y = 0;
          this.h.z.ai = false;
          this.h.z.aj = false;
          ThreadManager.executeOnSubThread(new VideoPlayManager.8(this, (VideoPlayerWrapper)localObject1, paramBaseVideoPlayParam));
          return;
        }
        QLog.e(a, 1, "playVideo failed, because get videoView == null!");
        a(this.h, null, 6, "videoview null");
        this.f = null;
        this.h = null;
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
    if (this.C == null) {
      this.C = new HashSet();
    }
    this.C.add(paramVideoStatusListener);
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.r = paramVideoPreDownloadMgr;
  }
  
  public void a(VideoRecommendManager paramVideoRecommendManager)
  {
    this.E = paramVideoRecommendManager;
  }
  
  public void a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ReportConstants.VideoEndType)) {
      this.x = ((ReportConstants.VideoEndType)paramObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "install tencent video sdk success!");
      }
      VideoPlayParam localVideoPlayParam = this.h;
      if (localVideoPlayParam != null) {
        a(localVideoPlayParam);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "install tencent video sdk fail!");
      }
      a(this.h, this.f, 6, "install failure");
      this.h = null;
    }
  }
  
  public Activity b()
  {
    return this.g;
  }
  
  public VideoPlayerWrapper b(String paramString)
  {
    paramString = (WeakReference)this.q.get(paramString);
    if (paramString != null) {
      return (VideoPlayerWrapper)paramString.get();
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.f;
    if (localVideoPlayerWrapper != null) {
      localVideoPlayerWrapper.a(paramInt);
    }
  }
  
  public void b(OnPlayStateListener paramOnPlayStateListener)
  {
    if (paramOnPlayStateListener != null)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = this.s;
      if (localCopyOnWriteArrayList != null) {
        localCopyOnWriteArrayList.remove(paramOnPlayStateListener);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public void c()
  {
    e(false);
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
    Object localObject = this.f;
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
  
  public void c(String paramString)
  {
    this.w = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject = this.h;
    boolean bool = paramBoolean;
    if (localObject != null)
    {
      bool = paramBoolean;
      if (((VideoPlayParam)localObject).M) {
        bool = true;
      }
    }
    localObject = this.f;
    if (localObject != null) {
      ((VideoPlayerWrapper)localObject).g(bool);
    }
  }
  
  public void d(int paramInt)
  {
    if (!this.u)
    {
      this.u = true;
      if (paramInt != 0) {
        a(ReportConstants.VideoEndType.EXIT_SCENE);
      }
      Object localObject = this.h;
      if ((localObject != null) && ((((VideoPlayParam)localObject).D instanceof AdvertisementInfo))) {
        ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).removeAdVideoClick((AdvertisementInfo)this.h.D);
      }
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onVisiable() isPause()=");
        localStringBuilder.append(s());
        localStringBuilder.append(", mPausedByMannul:");
        localStringBuilder.append(this.v);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      localObject = this.h;
      if ((localObject != null) && (((VideoPlayParam)localObject).z != null)) {
        this.h.z.m = SystemClock.uptimeMillis();
      }
      if ((s()) && (!this.v)) {
        v();
      }
      localObject = this.t;
      if (localObject != null)
      {
        ((VideoUIManager)localObject).g();
        if ((this.g instanceof SplashActivity)) {
          this.t.a(false);
        } else {
          this.t.a(true);
        }
      }
      BandwidthPredictor.from().start(this.g);
      BandwidthMonitor.INSTANCE.start(this.g);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public long e()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.f;
    if (localVideoPlayerWrapper != null) {
      return localVideoPlayerWrapper.I();
    }
    return 0L;
  }
  
  public void e(boolean paramBoolean)
  {
    Object localObject = this.f;
    if ((localObject != null) && (((VideoPlayerWrapper)localObject).n()))
    {
      this.f.w();
      this.v = paramBoolean;
      if (!NetworkUtil.isWifiConnected(this.g.getApplicationContext())) {
        this.f.A();
      }
      a(this.h, this.f, 5, Boolean.valueOf(this.v));
      this.h.k = f();
      this.h.z.h = this.f.d(false);
      localObject = this.h.D;
      if ((localObject != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd((int)((AbsBaseArticleInfo)localObject).mChannelID)) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject)) && ((this.h.M) || (((AbsBaseArticleInfo)localObject).mChannelID == 56L)))
      {
        int i1 = 11;
        int i2;
        if (((AbsBaseArticleInfo)localObject).mChannelID == 56L)
        {
          i1 = 4;
          i2 = 9;
        }
        else
        {
          i2 = 1;
        }
        IRIJAdService localIRIJAdService = (IRIJAdService)QRoute.api(IRIJAdService.class);
        AdReportData localAdReportData = new AdReportData().a(this.g).a(6).b(i1);
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localObject;
        localIRIJAdService.report(localAdReportData.a(localAdvertisementInfo).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(localAdvertisementInfo.adbt, (int)this.h.k, localAdvertisementInfo.getAdbf(), 0, localAdvertisementInfo.adpa, localAdvertisementInfo.adpb, ((AbsBaseArticleInfo)localObject).mVideoDuration * 1000, i2, 0, localAdvertisementInfo.videoReplayCount, E(), localAdvertisementInfo.isClickReplay, false)));
        localAdvertisementInfo.isClickReplay = false;
        localAdvertisementInfo.adbt = ((int)this.h.k);
      }
    }
  }
  
  public long f()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.f;
    if (localVideoPlayerWrapper != null) {
      return localVideoPlayerWrapper.C();
    }
    return 0L;
  }
  
  public void f(boolean paramBoolean)
  {
    if (s())
    {
      if (VideoVolumeControl.isInCall(this.g))
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
        localStringBuilder.append(this.v);
        QLog.d("Q.readinjoy.video", 2, localStringBuilder.toString());
      }
      this.f.v();
      this.m = true;
      this.v = false;
      a(this.h, this.f, 3, null);
      a(this.f, this.h, paramBoolean);
    }
  }
  
  public boolean g()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.f;
    return (localVideoPlayerWrapper != null) && (localVideoPlayerWrapper.n());
  }
  
  public void h()
  {
    if (this.z)
    {
      c(false);
      this.z = false;
    }
  }
  
  public void i()
  {
    if (!p())
    {
      c(true);
      this.z = true;
    }
  }
  
  public int j()
  {
    Object localObject = this.f;
    int i1;
    if (localObject != null) {
      i1 = ((VideoPlayerWrapper)localObject).h();
    } else {
      i1 = 0;
    }
    if (i1 == this.d.get()) {
      return i1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCurPlayState, should not happen...: mVideoPlayerWrapper.getCurrentStatus() = ");
      ((StringBuilder)localObject).append(VideoPlayUtils.a(i1));
      ((StringBuilder)localObject).append(",mState.get()=");
      ((StringBuilder)localObject).append(VideoPlayUtils.a(this.d.get()));
      QLog.w("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
    }
    return this.d.get();
  }
  
  public VideoUIManager k()
  {
    return this.t;
  }
  
  public int l()
  {
    return this.c;
  }
  
  public String m()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.f;
    if (localVideoPlayerWrapper != null) {
      return localVideoPlayerWrapper.H();
    }
    return null;
  }
  
  public long n()
  {
    VideoPlayParam localVideoPlayParam = this.h;
    if (localVideoPlayParam == null) {
      return -1L;
    }
    return localVideoPlayParam.j;
  }
  
  public long o()
  {
    VideoPlayParam localVideoPlayParam = this.h;
    if (localVideoPlayParam == null) {
      return 0L;
    }
    return localVideoPlayParam.f;
  }
  
  public boolean p()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.f;
    return (localVideoPlayerWrapper != null) && (localVideoPlayerWrapper.Q());
  }
  
  public void q()
  {
    this.u = false;
    e(false);
  }
  
  public boolean r()
  {
    return this.v;
  }
  
  public boolean s()
  {
    if (this.f != null)
    {
      if (this.h == null) {
        return false;
      }
      if (j() == 5)
      {
        if ((!this.f.m()) && (QLog.isColorLevel())) {
          QLog.w(a, 2, "isPause(): return true. getCurPlayState is PLAY_STATE_PAUSED. But mVideoPlayerWrapper.isPause() == false;");
        }
        return true;
      }
      if ((this.f.m()) && (QLog.isColorLevel()))
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isPause(): return false. getCurPlayState is ");
        localStringBuilder.append(VideoPlayUtils.a(j()));
        localStringBuilder.append(". But mVideoPlayerWrapper.isPause() == true;");
        QLog.w(str, 2, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  public boolean t()
  {
    return (this.f != null) && (j() == 2);
  }
  
  public boolean u()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.f;
    return (localVideoPlayerWrapper != null) && (localVideoPlayerWrapper.j());
  }
  
  public void v()
  {
    f(false);
  }
  
  public void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : destroy !");
    }
    a(ReportConstants.VideoEndType.EXIT_SCENE);
    a(7);
    Object localObject1 = this.f;
    if (localObject1 != null)
    {
      ((VideoPlayerWrapper)localObject1).D();
      this.f = null;
    }
    if (this.h != null) {
      this.h = null;
    }
    this.e.c();
    this.e = null;
    try
    {
      this.g = null;
      VideoVolumeControl.getInstance().removeVideoManager(this);
      localObject1 = this.q.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)((WeakReference)((Iterator)localObject1).next()).get();
        if ((localVideoPlayerWrapper != null) && (!localVideoPlayerWrapper.a))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("VideoPlayerWrapper : ");
            localStringBuilder.append(localVideoPlayerWrapper.toString());
            localStringBuilder.append(" not release");
            QLog.d("Q.readinjoy.video", 2, localStringBuilder.toString());
          }
          localVideoPlayerWrapper.D();
        }
      }
      this.q.clear();
      localObject1 = this.t;
      if (localObject1 != null)
      {
        ((VideoUIManager)localObject1).v();
        this.t = null;
      }
      this.s.clear();
      this.s = null;
      this.v = false;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public int x()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.f;
    if (localVideoPlayerWrapper != null) {
      return localVideoPlayerWrapper.F();
    }
    return -1;
  }
  
  public int y()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.f;
    if (localVideoPlayerWrapper != null) {
      return localVideoPlayerWrapper.G();
    }
    return -1;
  }
  
  public void z()
  {
    if (this.u)
    {
      this.u = false;
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUnVisiable() isPlaying()=");
        localStringBuilder.append(g());
        localStringBuilder.append(", isOpening()=");
        localStringBuilder.append(u());
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (g())
      {
        c();
      }
      else if (u())
      {
        a(ReportConstants.VideoEndType.EXIT_SCENE);
        a(8);
      }
      Object localObject = this.t;
      if (localObject != null)
      {
        ((VideoUIManager)localObject).h();
        this.t.a(false);
      }
      BandwidthPredictor.from().stop(this.g);
      BandwidthMonitor.INSTANCE.stop(this.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPlayManager
 * JD-Core Version:    0.7.0.1
 */
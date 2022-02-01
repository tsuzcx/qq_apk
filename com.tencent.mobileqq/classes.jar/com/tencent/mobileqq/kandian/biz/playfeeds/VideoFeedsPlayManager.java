package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.bandwidth.BandwidthMonitor;
import com.tencent.mobileqq.kandian.base.bandwidth.BandwidthPredictor;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.base.video.plugin.OnVideoPluginInstallListener;
import com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.ad.report.ReadinjoyAdVideoReportData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.VideoBehaviorsReporter;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController.EventListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsPlayManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.glue.video.VideoResumeManager;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmediacodec.TCodecManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class VideoFeedsPlayManager
  implements OnVideoPluginInstallListener, IVideoVolumeController.EventListener, IVideoFeedsPlayManager
{
  private static List<VideoFeedsPlayManager> w = new ArrayList();
  private VideoPreDownloadMgr A;
  private VideoAutoPlayController B;
  private VideoFeedsPlayManager.VideoPlayProgressListener C;
  private String D;
  private VideoFeedsPlayManager.MediaPlayListenerAdapterImpl E;
  private ReportConstants.VideoEndType F;
  private boolean G;
  private Handler H;
  private ArrayList<VideoFeedsPlayManager.VideoStatusListener> I;
  private boolean J;
  private VideoFeedsRecommendManager K;
  private QQAppInterface a;
  private Context b;
  private int c;
  private VideoPluginInstall d;
  private VideoPlayParam e;
  private VideoPlayParam f;
  private boolean g;
  private volatile boolean h;
  private boolean i;
  private Set<String> j;
  private boolean k;
  private boolean l;
  private int m;
  private boolean n;
  private boolean o;
  private ConcurrentHashMap<VideoPlayerWrapper, Object> p;
  private Object q;
  private boolean r;
  private int s;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean x;
  private boolean y;
  private boolean z;
  
  public VideoFeedsPlayManager(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this(paramContext, paramQQAppInterface, 0);
  }
  
  public VideoFeedsPlayManager(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool = false;
    this.g = false;
    this.h = false;
    this.i = false;
    this.j = new HashSet();
    this.k = false;
    this.l = false;
    this.n = true;
    this.o = false;
    this.p = new ConcurrentHashMap();
    this.q = new Object();
    this.s = -1;
    this.u = false;
    this.v = false;
    this.x = false;
    this.y = false;
    this.z = false;
    this.E = new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl(this, null);
    this.G = false;
    this.H = new VideoFeedsPlayManager.1(this, Looper.getMainLooper());
    this.I = null;
    this.J = false;
    this.b = paramContext;
    this.a = paramQQAppInterface;
    this.c = paramInt;
    this.d = new VideoPluginInstall();
    this.d.a(this);
    this.I = new ArrayList();
    VideoVolumeController.getInstance().addEventListener(this);
    this.B = VideoAutoPlayController.getInstance();
    if (NetworkUtil.isWifiConnected(this.b)) {
      e(true);
    } else {
      e(false);
    }
    if ((ReadInJoyHelper.m(paramQQAppInterface)) || (PlayerHelper.a.a())) {
      bool = true;
    }
    this.r = bool;
    w.add(this);
    A();
  }
  
  private void A()
  {
    int i1 = Aladdin.getConfig(352).getIntegerFromString("play_manager_max_count", 3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("inspectPlayerMemory: size=");
      localStringBuilder.append(w.size());
      localStringBuilder.append(", maxCount=");
      localStringBuilder.append(i1);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, localStringBuilder.toString());
    }
    if (w.size() > i1)
    {
      int i2 = w.size();
      ((VideoFeedsPlayManager)w.get(i2 - i1 - 1)).z();
    }
  }
  
  private void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayerWrapper == null) {
      return;
    }
    paramVideoPlayerWrapper.T();
    if (paramVideoPlayerWrapper.r()) {
      return;
    }
    ThreadManager.excute(new VideoFeedsPlayManager.7(this, paramVideoPlayerWrapper), 16, null, true);
  }
  
  private void a(ReadInJoyVideoReportData paramReadInJoyVideoReportData)
  {
    ThreadManager.excute(new VideoFeedsPlayManager.8(this, paramReadInJoyVideoReportData), 16, null, true);
  }
  
  private void a(boolean paramBoolean, VideoPlayParam paramVideoPlayParam, ReportConstants.VideoEndType paramVideoEndType)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private VideoPlayerWrapper b(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayerWrapper == x()) {
      return paramVideoPlayerWrapper;
    }
    return null;
  }
  
  private void b(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    VideoPlayerWrapper localVideoPlayerWrapper = h(paramVideoPlayParam);
    Object localObject;
    if (localVideoPlayerWrapper != null) {
      localObject = localVideoPlayerWrapper.E();
    } else {
      localObject = null;
    }
    if ((localVideoPlayerWrapper != null) && (localObject == null) && (localVideoPlayerWrapper.r()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "createVideoPlayerAndPlay VideoFeedsPlayManager innerPlayVideo hit cache");
      }
      paramVideoPlayParam.h.a(paramVideoPlayParam.c);
      d(paramVideoPlayParam, paramBoolean);
      return;
    }
    boolean bool = paramVideoPlayParam.n;
    String str = "not null";
    StringBuilder localStringBuilder;
    if (bool)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("createVideoPlayerAndPlay: isSeamlessPlay， tag ");
        if (localObject == null) {
          str = "null";
        }
        localStringBuilder.append(str);
        QLog.d("VideoFeedsPlayManager.preplay", 2, localStringBuilder.toString());
      }
      if (localVideoPlayerWrapper != null) {
        localVideoPlayerWrapper.b(true);
      }
      paramVideoPlayParam.b = null;
      c(paramVideoPlayParam, paramBoolean);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("createVideoPlayerAndPlay: tag ");
      if (localObject == null) {
        str = "null";
      }
      localStringBuilder.append(str);
      localStringBuilder.append(", oldPlayer=");
      localStringBuilder.append(localVideoPlayerWrapper);
      QLog.d("VideoFeedsPlayManager.preplay", 2, localStringBuilder.toString());
    }
    if (localVideoPlayerWrapper != null) {
      localVideoPlayerWrapper.b(true);
    }
    paramVideoPlayParam.b = null;
    ThreadManager.post(new VideoFeedsPlayManager.2(this, paramVideoPlayParam, paramBoolean), 5, null, true);
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == 105) || (paramInt == 208);
  }
  
  private void c(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    paramVideoPlayParam.h = d(paramVideoPlayParam);
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo miss cache");
    }
    if ((paramVideoPlayParam.h != null) && (this.H != null) && (paramVideoPlayParam.c != null))
    {
      paramVideoPlayParam.h.a(paramVideoPlayParam.c);
      this.p.put((VideoPlayerWrapper)paramVideoPlayParam.h, this.q);
      this.H.post(new VideoFeedsPlayManager.3(this, paramVideoPlayParam, paramBoolean));
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createVideoPlayerAndPlay aysnc run error : playerParam.videoPlayer = ");
      localStringBuilder.append(paramVideoPlayParam.h);
      localStringBuilder.append(", mUIHandler = ");
      localStringBuilder.append(this.H);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, localStringBuilder.toString());
    }
  }
  
  private boolean c(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    return b(paramVideoPlayerWrapper) != null;
  }
  
  private VideoPlayerWrapper d(VideoPlayParam paramVideoPlayParam)
  {
    if ((this.b != null) && (!this.h))
    {
      paramVideoPlayParam = new VideoPlayerWrapper(this.b.getApplicationContext(), paramVideoPlayParam.m);
      paramVideoPlayParam.a(this.E);
      return paramVideoPlayParam;
    }
    return null;
  }
  
  private void d(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    VideoPlayerWrapper localVideoPlayerWrapper = h(paramVideoPlayParam);
    if (paramVideoPlayParam != null)
    {
      if (localVideoPlayerWrapper == null) {
        return;
      }
      paramVideoPlayParam.a.setKeepScreenOn(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "innerPlayVideo: ");
      }
      Object localObject;
      if (paramVideoPlayParam.b == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
        }
        paramVideoPlayParam.a.removeAllViews();
        localVideoPlayerWrapper.a(paramVideoPlayParam.a, paramVideoPlayParam.n, false);
        if ((paramVideoPlayParam.n) && (localVideoPlayerWrapper.d() != 0))
        {
          localVideoPlayerWrapper.x();
          paramVideoPlayParam.n = false;
          paramVideoPlayParam.o.b(paramVideoPlayParam, false);
        }
        localObject = localVideoPlayerWrapper.b();
        if (localObject == null)
        {
          if (paramVideoPlayParam.o != null) {
            paramVideoPlayParam.o.a(paramVideoPlayParam, 999, 999, null);
          }
          paramVideoPlayParam.h = null;
          return;
        }
        paramVideoPlayParam.b = ((View)localObject);
        ((View)localObject).setId(2131444264);
        if (paramVideoPlayParam.o != null) {
          paramVideoPlayParam.o.b(paramVideoPlayParam);
        }
        if ((paramVideoPlayParam.c != null) && (paramVideoPlayParam.c.c > 0) && (paramVideoPlayParam.c.d > 0) && (paramVideoPlayParam.c.d < 10000) && (paramVideoPlayParam.c.c < 10000)) {
          localVideoPlayerWrapper.c().a(paramVideoPlayParam.c.c, paramVideoPlayParam.c.d);
        }
      }
      int i1;
      if (this.g) {
        i1 = 2;
      } else {
        i1 = paramVideoPlayParam.d;
      }
      localVideoPlayerWrapper.b(i1);
      boolean bool;
      if ((!this.J) && (!this.o)) {
        bool = false;
      } else {
        bool = true;
      }
      localVideoPlayerWrapper.h(bool);
      localVideoPlayerWrapper.a(this.r);
      localVideoPlayerWrapper.i(paramVideoPlayParam.l);
      localVideoPlayerWrapper.g(this.t);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("innerPlayVideo: isMuted=");
        ((StringBuilder)localObject).append(h(paramVideoPlayParam).Q());
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
      }
      paramVideoPlayParam.b.setVisibility(0);
      if (!paramBoolean) {
        paramVideoPlayParam.e.m = SystemClock.uptimeMillis();
      }
      if (paramVideoPlayParam.e != null)
      {
        paramVideoPlayParam.e.W = 0;
        paramVideoPlayParam.e.X = 0;
        paramVideoPlayParam.e.Y = 0;
        paramVideoPlayParam.e.ai = false;
        paramVideoPlayParam.e.aj = false;
        paramVideoPlayParam.e.al = this.r;
      }
      if (!paramVideoPlayParam.n) {
        ThreadManager.excute(new VideoFeedsPlayManager.PlayStartVideoRunnable(this, paramVideoPlayParam, localVideoPlayerWrapper, paramBoolean), 16, null, true);
      }
      paramVideoPlayParam.n = false;
      paramVideoPlayParam.m = null;
    }
  }
  
  private boolean e(VideoPlayParam paramVideoPlayParam)
  {
    VideoPlayerWrapper localVideoPlayerWrapper = h(paramVideoPlayParam);
    int i1;
    if ((localVideoPlayerWrapper != null) && ((localVideoPlayerWrapper.l()) || (localVideoPlayerWrapper.m()) || (localVideoPlayerWrapper.o()))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if ((localVideoPlayerWrapper != null) && (localVideoPlayerWrapper.E() != paramVideoPlayParam.c)) {
      i2 = 0;
    } else {
      i2 = 1;
    }
    if ((i1 != 0) && (i2 != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo hasPrePlay, just go onVideoPrepared");
      }
      paramVideoPlayParam.i = false;
      paramVideoPlayParam.e.m = SystemClock.uptimeMillis();
      paramVideoPlayParam.e.V = 2;
      paramVideoPlayParam.h.B();
      paramVideoPlayParam.h.Y();
      if (!TextUtils.isEmpty(this.D)) {
        paramVideoPlayParam.e.ac = this.D;
      }
      this.E.a(paramVideoPlayParam);
      this.E.a((VideoPlayerWrapper)paramVideoPlayParam.h);
      return true;
    }
    if ((paramVideoPlayParam.i) && (i2 != 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoFeedsPlayManager playVideo prePlaying, just do nothing ");
        Integer localInteger;
        if (localVideoPlayerWrapper != null) {
          localInteger = Integer.valueOf(localVideoPlayerWrapper.h());
        } else {
          localInteger = null;
        }
        localStringBuilder.append(localInteger);
        QLog.d("VideoFeedsPlayManager.preplay", 2, localStringBuilder.toString());
      }
      if (localVideoPlayerWrapper != null)
      {
        localVideoPlayerWrapper.B();
        localVideoPlayerWrapper.Y();
      }
      paramVideoPlayParam.e.m = SystemClock.uptimeMillis();
      paramVideoPlayParam.e.V = 1;
      this.y = true;
      this.H.sendEmptyMessageDelayed(-3, 10000L);
      return true;
    }
    return false;
  }
  
  private void f(VideoPlayParam paramVideoPlayParam)
  {
    int i1;
    if (paramVideoPlayParam != null)
    {
      paramVideoPlayParam.e = new ReadInJoyVideoReportData();
      paramVideoPlayParam.e.g = paramVideoPlayParam.c.a;
      paramVideoPlayParam.e.f = paramVideoPlayParam.c.b;
      paramVideoPlayParam.e.e = paramVideoPlayParam.c.l;
      AbsReadInJoyVideoReportData localAbsReadInJoyVideoReportData = paramVideoPlayParam.e;
      if (this.c == 1) {
        i1 = 5;
      } else {
        i1 = 2;
      }
      localAbsReadInJoyVideoReportData.t = i1;
      paramVideoPlayParam.e.O = paramVideoPlayParam.c.c;
      paramVideoPlayParam.e.P = paramVideoPlayParam.c.d;
      paramVideoPlayParam.e.Q = paramVideoPlayParam.c.e;
      paramVideoPlayParam.e.j = true;
      paramVideoPlayParam.e.W = 0;
      paramVideoPlayParam.e.X = 0;
      paramVideoPlayParam.e.Y = 0;
      paramVideoPlayParam.e.aa = false;
      paramVideoPlayParam.e.ab = "";
      paramVideoPlayParam.e.ai = false;
      paramVideoPlayParam.e.aj = false;
      paramVideoPlayParam.e.J = paramVideoPlayParam.g.getInt("jump_from_scene");
      paramVideoPlayParam.e.K = paramVideoPlayParam.g.getInt("video_feeds_index");
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.c != null) && (paramVideoPlayParam.c.aq))
    {
      paramVideoPlayParam.f = new ReadinjoyAdVideoReportData();
      i1 = paramVideoPlayParam.g.getInt("ad_origin", 10);
      paramVideoPlayParam.f.j = i1;
    }
  }
  
  private void g(VideoPlayParam paramVideoPlayParam)
  {
    ThreadManager.excute(new VideoFeedsPlayManager.9(this, paramVideoPlayParam), 16, null, true);
  }
  
  private VideoPlayerWrapper h(VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam != null) {
      return (VideoPlayerWrapper)paramVideoPlayParam.h;
    }
    return null;
  }
  
  private VideoPlayParam i(VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam == this.e) {
      return paramVideoPlayParam;
    }
    return null;
  }
  
  private boolean j(VideoPlayParam paramVideoPlayParam)
  {
    return i(paramVideoPlayParam) != null;
  }
  
  private void w()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.getSubThreadHandler().postAtFrontOfQueue(new VideoFeedsPlayManager.4(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
    }
    VideoPlayerWrapper localVideoPlayerWrapper = x();
    if (localVideoPlayerWrapper != null) {
      localVideoPlayerWrapper.u();
    }
  }
  
  private VideoPlayerWrapper x()
  {
    return h(this.e);
  }
  
  private boolean y()
  {
    VideoPlayParam localVideoPlayParam = this.e;
    return (localVideoPlayParam != null) && (localVideoPlayParam.c != null) && (this.e.f != null) && (this.e.c.aq) && (this.e.c.as != null);
  }
  
  private void z()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      if ((k()) || (i())) {
        this.v = true;
      }
      a(ReportConstants.VideoEndType.EXIT_SCENE);
      ((VideoPlayParam)localObject).h = null;
      ((VideoPlayParam)localObject).b = null;
      this.e = ((VideoPlayParam)localObject);
    }
    localObject = this.f;
    if (localObject != null)
    {
      if (h((VideoPlayParam)localObject) != null) {
        h(this.f).D();
      }
      localObject = this.f;
      ((VideoPlayParam)localObject).b = null;
      ((VideoPlayParam)localObject).h = null;
      this.f = null;
    }
    localObject = this.p;
    if (localObject != null)
    {
      localObject = ((ConcurrentHashMap)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)((Iterator)localObject).next();
        if ((localVideoPlayerWrapper != null) && (!localVideoPlayerWrapper.q())) {
          localVideoPlayerWrapper.D();
        }
      }
      this.p.clear();
    }
  }
  
  public void a(float paramFloat)
  {
    if (x() != null) {
      x().a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.e != null) && (x() != null))
    {
      this.u = true;
      x().a(paramInt);
      if (paramBoolean)
      {
        Object localObject = this.e;
        if ((localObject != null) && (((VideoPlayParam)localObject).o != null))
        {
          long l1 = x().I();
          localObject = this.e.o;
          VideoPlayParam localVideoPlayParam = this.e;
          double d1 = paramInt * 100.0F / (float)l1;
          Double.isNaN(d1);
          ((IVideoUIDelegate)localObject).a(localVideoPlayParam, (int)(d1 + 0.5D), l1);
        }
      }
      this.H.removeMessages(-2);
    }
  }
  
  public void a(ReportConstants.VideoEndType paramVideoEndType)
  {
    a(true, paramVideoEndType);
  }
  
  public void a(VideoFeedsPlayManager.VideoPlayProgressListener paramVideoPlayProgressListener)
  {
    this.C = paramVideoPlayProgressListener;
  }
  
  public void a(VideoFeedsPlayManager.VideoStatusListener paramVideoStatusListener)
  {
    this.I.add(paramVideoStatusListener);
  }
  
  public void a(VideoFeedsRecommendManager paramVideoFeedsRecommendManager)
  {
    this.K = paramVideoFeedsRecommendManager;
  }
  
  public void a(VideoPlayParam paramVideoPlayParam)
  {
    this.i = false;
    this.e = paramVideoPlayParam;
    if (this.e.o != null) {
      this.e.o.a(this.e);
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo");
    }
    if (this.h)
    {
      if (QLog.isColorLevel())
      {
        paramVideoPlayParam = new StringBuilder();
        paramVideoPlayParam.append("playVideo: mHasDestory=");
        paramVideoPlayParam.append(this.h);
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, paramVideoPlayParam.toString());
      }
      return;
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.c != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("playVideo() vid=");
        ((StringBuilder)localObject).append(paramVideoPlayParam.c.b);
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
      }
      this.i = false;
      this.m = 0;
      this.k = false;
      this.l = false;
      this.u = false;
      this.e = paramVideoPlayParam;
      this.f = null;
      Object localObject = this.I;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((VideoFeedsPlayManager.VideoStatusListener)((Iterator)localObject).next()).a(this.e);
        }
      }
      if (this.e.o != null) {
        this.e.o.a(this.e, paramBoolean);
      }
      this.H.removeMessages(-3);
      if (e(paramVideoPlayParam)) {
        return;
      }
      f(this.e);
      paramVideoPlayParam.e.n = SystemClock.uptimeMillis();
      localObject = this.d;
      if ((localObject != null) && (!((VideoPluginInstall)localObject).b()))
      {
        this.d.a();
        return;
      }
      paramVideoPlayParam.e.V = 0;
      b(paramVideoPlayParam, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
    }
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.A = paramVideoPreDownloadMgr;
  }
  
  public void a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ReportConstants.VideoEndType)) {
      this.F = ((ReportConstants.VideoEndType)paramObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    VideoPlayParam localVideoPlayParam;
    if (paramBoolean)
    {
      localVideoPlayParam = this.e;
      if (localVideoPlayParam != null) {
        a(localVideoPlayParam, true);
      }
    }
    else
    {
      localVideoPlayParam = this.e;
      if ((localVideoPlayParam != null) && (localVideoPlayParam.o != null)) {
        this.e.o.a(this.e, 999, 998, null);
      }
      this.e = null;
    }
  }
  
  public void a(boolean paramBoolean, ReportConstants.VideoEndType paramVideoEndType)
  {
    VideoPlayParam localVideoPlayParam = this.e;
    if ((localVideoPlayParam != null) && (localVideoPlayParam.o != null)) {
      this.e.o.f(this.e);
    }
    localVideoPlayParam = this.e;
    if ((localVideoPlayParam != null) && (this.K != null) && (localVideoPlayParam.h != null) && ((this.e.c instanceof VideoInfo))) {
      this.K.a(1, this.e.c, this.e.h.d(this.i));
    }
    if ((this.e != null) && (x() != null))
    {
      a(paramBoolean, this.e, paramVideoEndType);
      paramVideoEndType = this.e;
      paramVideoEndType.i = false;
      paramVideoEndType.m = null;
      paramVideoEndType.n = false;
      paramVideoEndType = this.I;
      if (paramVideoEndType != null)
      {
        paramVideoEndType = paramVideoEndType.iterator();
        while (paramVideoEndType.hasNext()) {
          ((VideoFeedsPlayManager.VideoStatusListener)paramVideoEndType.next()).a(this.e, this.i);
        }
      }
      VideoResumeManager.a.a(this.e.c.l, this.e.c.b, b(), t());
      c(this.e);
    }
    if (this.e != null) {
      this.e = null;
    }
    this.m = 0;
    this.k = false;
    this.H.removeMessages(-2);
  }
  
  public boolean a()
  {
    return this.x;
  }
  
  public long b()
  {
    if ((this.e != null) && (x() != null)) {
      return x().C();
    }
    return 0L;
  }
  
  public void b(VideoPlayParam paramVideoPlayParam)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("VideoFeedsPlayManager prePlayVideo mPreplaying=");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append(", player=");
      ((StringBuilder)localObject).append(h(this.f));
      QLog.d("VideoFeedsPlayManager.preplay", 2, ((StringBuilder)localObject).toString());
    }
    if (paramVideoPlayParam != null)
    {
      if (paramVideoPlayParam == this.e) {
        return;
      }
      localObject = h(paramVideoPlayParam);
      if ((localObject != null) && (paramVideoPlayParam.i) && (((VideoPlayerWrapper)localObject).E() == paramVideoPlayParam.c)) {
        return;
      }
      if (h(this.f) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "prePlayVideo: last preplay video not stop");
        }
        h(this.f).b(true);
      }
      this.D = null;
      localObject = this.d;
      if ((localObject != null) && (((VideoPluginInstall)localObject).b()))
      {
        paramVideoPlayParam.i = true;
        this.f = paramVideoPlayParam;
        f(this.f);
        paramVideoPlayParam.e.n = SystemClock.uptimeMillis();
        b(paramVideoPlayParam, true);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public long c()
  {
    if ((this.e != null) && (x() != null)) {
      return x().d(q());
    }
    return 0L;
  }
  
  @Deprecated
  public void c(VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam != null) {
      a((VideoPlayerWrapper)paramVideoPlayParam.h);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.g != paramBoolean)
    {
      this.g = paramBoolean;
      if (x() != null)
      {
        VideoPlayParam localVideoPlayParam = this.e;
        if (localVideoPlayParam != null)
        {
          int i1;
          if (this.g) {
            i1 = 2;
          } else {
            i1 = localVideoPlayParam.d;
          }
          x().b(i1);
        }
      }
    }
  }
  
  public long d()
  {
    if ((this.e != null) && (x() != null)) {
      return x().e(q());
    }
    return 0L;
  }
  
  public void d(boolean paramBoolean)
  {
    this.t = paramBoolean;
    if (x() != null) {
      x().g(paramBoolean);
    }
    if (h(this.f) != null) {
      h(this.f).g(paramBoolean);
    }
  }
  
  public VideoInfo e()
  {
    VideoPlayParam localVideoPlayParam = this.e;
    if ((localVideoPlayParam != null) && (localVideoPlayParam.c != null)) {
      return this.e.c;
    }
    return null;
  }
  
  public void e(boolean paramBoolean)
  {
    this.B.updateNetworkChange(paramBoolean);
  }
  
  public void f()
  {
    Object localObject;
    if (x() != null)
    {
      localObject = this.I;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((VideoFeedsPlayManager.VideoStatusListener)((Iterator)localObject).next()).b(this.e);
        }
      }
      w();
    }
    this.H.removeMessages(-2);
    this.H.sendEmptyMessage(-2);
    this.H.post(new VideoFeedsPlayManager.5(this));
    if (y()) {
      try
      {
        localObject = this.e.c.as.m;
        if (!this.j.contains(localObject))
        {
          this.j.add(localObject);
          this.e.f.i = ReadinjoyAdVideoReportData.a;
          this.e.f.n = 0;
        }
        else
        {
          this.e.f.i = ReadinjoyAdVideoReportData.c;
          localObject = this.e.f;
          ((ReadinjoyAdVideoReportData)localObject).n += 1;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Q.pubaccount.video.feedsVideoFeedsPlayManager", 1, localThrowable, new Object[0]);
      }
    }
    VideoPlayerWrapper localVideoPlayerWrapper = x();
    VideoPlayParam localVideoPlayParam = this.e;
    if ((localVideoPlayParam != null) && (localVideoPlayerWrapper != null))
    {
      localVideoPlayParam.e.S = localVideoPlayerWrapper.G();
      this.e.e.R = localVideoPlayerWrapper.F();
    }
  }
  
  public void f(boolean paramBoolean)
  {
    this.o = paramBoolean;
    if (x() != null) {
      x().h(paramBoolean);
    }
    if (h(this.f) != null) {
      h(this.f).h(paramBoolean);
    }
  }
  
  public void g()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void g(boolean paramBoolean)
  {
    this.J = paramBoolean;
    VideoPlayerWrapper localVideoPlayerWrapper = x();
    boolean bool2 = false;
    if (localVideoPlayerWrapper != null)
    {
      localVideoPlayerWrapper = x();
      boolean bool1;
      if ((!paramBoolean) && (!this.o)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      localVideoPlayerWrapper.h(bool1);
    }
    if (h(this.f) != null)
    {
      localVideoPlayerWrapper = h(this.f);
      if (!paramBoolean)
      {
        paramBoolean = bool2;
        if (!this.o) {}
      }
      else
      {
        paramBoolean = true;
      }
      localVideoPlayerWrapper.h(paramBoolean);
    }
  }
  
  public void h()
  {
    this.H.post(new VideoFeedsPlayManager.6(this));
  }
  
  public boolean i()
  {
    return (x() != null) && (x().m());
  }
  
  public boolean j()
  {
    return (x() != null) && (x().Q());
  }
  
  public boolean k()
  {
    return (x() != null) && (x().n());
  }
  
  public void l()
  {
    this.F = null;
    this.n = true;
    if (this.v)
    {
      VideoPlayParam localVideoPlayParam = this.e;
      if (localVideoPlayParam != null)
      {
        a(localVideoPlayParam, false);
        break label82;
      }
    }
    if ((this.z) && (x() != null) && (x().l()))
    {
      f();
    }
    else if (this.x)
    {
      this.y = true;
      h();
    }
    label82:
    this.v = false;
    this.x = false;
    this.z = false;
    VideoBehaviorsReporter.a().b(true ^ VideoAutoPlayController.getInstance().isNeedNetWorkAlert());
    BandwidthPredictor.from().start(this.b);
    BandwidthMonitor.INSTANCE.start(this.b);
  }
  
  public void m()
  {
    this.n = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnPause() isPlaying()=");
      localStringBuilder.append(k());
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, localStringBuilder.toString());
    }
    if (k())
    {
      this.x = true;
      this.y = false;
      g();
    }
    BandwidthPredictor.from().stop(this.b);
    BandwidthMonitor.INSTANCE.stop(this.b);
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "doOnDestory: ");
    }
    w.remove(this);
    int i1 = 1;
    this.h = true;
    Object localObject = this.A;
    if (localObject != null)
    {
      ((VideoPreDownloadMgr)localObject).a();
      this.A = null;
    }
    a(ReportConstants.VideoEndType.EXIT_SCENE);
    this.H.removeCallbacksAndMessages(this.e);
    this.H.removeCallbacksAndMessages(this.f);
    if (this.e != null)
    {
      if (x() != null)
      {
        x().D();
        this.e.h = null;
      }
      this.e = null;
    }
    localObject = this.f;
    if (localObject != null)
    {
      if (h((VideoPlayParam)localObject) != null)
      {
        h(this.f).D();
        this.f.h = null;
      }
      this.f = null;
    }
    localObject = this.p;
    if (localObject != null)
    {
      localObject = ((ConcurrentHashMap)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)((Iterator)localObject).next();
        if ((localVideoPlayerWrapper != null) && (!localVideoPlayerWrapper.q())) {
          localVideoPlayerWrapper.D();
        }
      }
      this.p.clear();
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((VideoPluginInstall)localObject).c();
      this.d = null;
    }
    if (Aladdin.getConfig(490).getIntegerFromString("releaseKeepPool", 1) != 1) {
      i1 = 0;
    }
    if (i1 != 0) {
      TCodecManager.getInstance().clearAndReleaseKeepPool();
    }
    this.H.removeCallbacksAndMessages(null);
    localObject = this.I;
    if (localObject != null)
    {
      ((ArrayList)localObject).clear();
      this.I = null;
    }
    VideoVolumeController.getInstance().removeEventListener(this);
    this.C = null;
    this.K = null;
    this.a = null;
    this.b = null;
  }
  
  public boolean o()
  {
    return r() == 5;
  }
  
  public void onFocusGain()
  {
    if (this.G)
    {
      d(false);
      this.G = false;
    }
  }
  
  public void onFocusLoss()
  {
    if (!j())
    {
      d(true);
      this.G = true;
    }
  }
  
  public void onHeadsetStateChanged(boolean paramBoolean)
  {
    if (x() != null) {
      d(paramBoolean ^ true);
    }
  }
  
  public void onPhoneCome()
  {
    if (x() != null) {
      x().w();
    }
  }
  
  public void onSystemVolumeChanged(int paramInt)
  {
    if (x() != null)
    {
      boolean bool;
      if (paramInt <= 0) {
        bool = true;
      } else {
        bool = false;
      }
      d(bool);
    }
  }
  
  public boolean p()
  {
    return r() == 3;
  }
  
  public boolean q()
  {
    return r() == 7;
  }
  
  public int r()
  {
    if (x() != null) {
      return x().h();
    }
    return 0;
  }
  
  public void s()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkPlayStateAfterPhoneCall mIsActivityOnResume = ");
      localStringBuilder.append(this.n);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, localStringBuilder.toString());
    }
    if (!this.n) {
      return;
    }
    if (i())
    {
      if (!a()) {
        return;
      }
      b(false);
      h();
    }
  }
  
  public long t()
  {
    if (x() != null) {
      return x().I();
    }
    return 0L;
  }
  
  public boolean u()
  {
    return this.o;
  }
  
  public VideoPlayParam v()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager
 * JD-Core Version:    0.7.0.1
 */
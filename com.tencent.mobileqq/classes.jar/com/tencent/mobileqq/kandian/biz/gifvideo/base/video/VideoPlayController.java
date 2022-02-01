package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.base.video.player.api.IEventListener;
import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerFactory;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerVideoInfo;
import com.tencent.mobileqq.kandian.base.video.plugin.OnVideoPluginInstallListener;
import com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.statemachine.VideoState;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.statemachine.VideoState.Companion;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.IStrategy;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.IStrategy.URLCallback;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.ReadInJoyVideoStrategy;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJVideoSdkConfigSp;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.util.VersionUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;", "", "ptsVideoView", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;", "curState", "Ljava/util/concurrent/atomic/AtomicInteger;", "curAction", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "value", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "articleInfo", "getArticleInfo", "()Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "setArticleInfo", "(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)V", "getCurAction", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setCurAction", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "getCurState", "setCurState", "currentProgress", "", "getCurrentProgress", "()I", "setCurrentProgress", "(I)V", "eventListener", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IEventListener;", "getEventListener", "()Lcom/tencent/mobileqq/kandian/base/video/player/api/IEventListener;", "setEventListener", "(Lcom/tencent/mobileqq/kandian/base/video/player/api/IEventListener;)V", "", "isLoop", "()Z", "setLoop", "(Z)V", "isManualPause", "setManualPause", "isMute", "setMute", "mBusiType", "getMBusiType", "setMBusiType", "mFactory", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/IPlayerFactory;", "mVid", "getMVid", "setMVid", "mVideoPlayer", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IPlayer;", "getMVideoPlayer", "()Lcom/tencent/mobileqq/kandian/base/video/player/api/IPlayer;", "setMVideoPlayer", "(Lcom/tencent/mobileqq/kandian/base/video/player/api/IPlayer;)V", "mVideoUrl", "getMVideoUrl", "setMVideoUrl", "mVideoView", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IVideoView;", "getMVideoView", "()Lcom/tencent/mobileqq/kandian/base/video/player/api/IVideoView;", "setMVideoView", "(Lcom/tencent/mobileqq/kandian/base/video/player/api/IVideoView;)V", "needResumePlay", "getNeedResumePlay", "setNeedResumePlay", "onStateChangeListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController$OnStateChangeListener;", "playErrorCode", "getPlayErrorCode", "setPlayErrorCode", "playErrorModule", "getPlayErrorModule", "setPlayErrorModule", "playErrorType", "getPlayErrorType", "setPlayErrorType", "getPtsVideoView", "()Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;", "setPtsVideoView", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;)V", "useVid", "getUseVid", "setUseVid", "videoDtReportController", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoDtReportController;", "getVideoDtReportController", "()Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoDtReportController;", "setVideoDtReportController", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoDtReportController;)V", "videoDynamicInsertController", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoDynamicInsertController;", "getVideoDynamicInsertController", "()Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoDynamicInsertController;", "setVideoDynamicInsertController", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoDynamicInsertController;)V", "videoPlayListener", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayListener;", "getVideoPlayListener", "()Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayListener;", "setVideoPlayListener", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayListener;)V", "videoPluginInstall", "Lcom/tencent/mobileqq/kandian/base/video/plugin/VideoPluginInstall;", "videoReportController", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoReportController;", "getVideoReportController", "()Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoReportController;", "setVideoReportController", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoReportController;)V", "videoSeeLaterController", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoSeeLaterController;", "getVideoSeeLaterController", "()Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoSeeLaterController;", "setVideoSeeLaterController", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoSeeLaterController;)V", "videoStrategy", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/utils/ReadInJoyVideoStrategy;", "xyAxis", "getXyAxis", "setXyAxis", "checkVideo", "commonOptimizeConfig", "", "info", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/PlayerVideoInfo;", "commonPlayerOption", "Lcom/tencent/superplayer/api/SuperPlayerOption;", "isPrePlay", "completePlayer", "createVideoPlayer", "runnable", "Lkotlin/Function0;", "createVideoView", "destroy", "destroyPlayer", "error", "module", "errorType", "errorCode", "executeOnMainThread", "executeOnSubThread", "goToNextState", "initPlayer", "install", "videoPluginInstallListener", "Lcom/tencent/mobileqq/kandian/base/video/plugin/OnVideoPluginInstallListener;", "installVideoPlayer", "isValidBusiType", "isValidVideo", "onStateChanged", "oldState", "newState", "open", "openVideoByUrl", "videoUrl", "openVideoByVid", "vid", "pause", "pausePlayer", "play", "realPlay", "context", "Landroid/content/Context;", "videoInfo", "registerOnStateListener", "listener", "requestUrlByVid", "strategy", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/utils/IStrategy;", "callback", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/utils/IStrategy$URLCallback;", "resume", "savePlayTime", "seekToPlay", "selectUrlByVid", "setDtPgid", "dtPgid", "setDurationReportR5", "reportR5", "setResumePlay", "rowkey", "progress", "setTag", "suffix", "setTagOnVideoView", "start", "action", "startPlayer", "stop", "stopPlayer", "unRegisterOnStateListener", "updateProgress", "Companion", "OnStateChangeListener", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoPlayController
{
  private static int F;
  private static int G = 1;
  private static int H = 2;
  private static int I = G;
  public static final VideoPlayController.Companion a = new VideoPlayController.Companion(null);
  private int A;
  @NotNull
  private IEventListener B;
  @Nullable
  private VideoView C;
  @NotNull
  private AtomicInteger D;
  @NotNull
  private AtomicInteger E;
  @NotNull
  private String b;
  private int c;
  private boolean d;
  @Nullable
  private String e;
  @Nullable
  private String f;
  private boolean g;
  private boolean h;
  private int i;
  @Nullable
  private VideoPlayListener j;
  private boolean k;
  private int l;
  private int m;
  private int n;
  @Nullable
  private IPlayer o;
  @Nullable
  private IVideoView p;
  @Nullable
  private AbsBaseArticleInfo q;
  private IPlayerFactory r;
  private VideoPluginInstall s;
  private final CopyOnWriteArrayList<VideoPlayController.OnStateChangeListener> t;
  private ReadInJoyVideoStrategy u;
  @Nullable
  private VideoSeeLaterController v;
  @Nullable
  private VideoReportController w;
  @Nullable
  private VideoDtReportController x;
  @Nullable
  private VideoDynamicInsertController y;
  private boolean z;
  
  public VideoPlayController(@Nullable VideoView paramVideoView, @NotNull AtomicInteger paramAtomicInteger1, @NotNull AtomicInteger paramAtomicInteger2)
  {
    this.C = paramVideoView;
    this.D = paramAtomicInteger1;
    this.E = paramAtomicInteger2;
    this.b = "VideoPlayController";
    this.d = true;
    this.e = "";
    this.f = "";
    this.g = true;
    this.h = true;
    this.t = new CopyOnWriteArrayList();
    this.A = -1;
    this.u = new ReadInJoyVideoStrategy();
    this.v = new VideoSeeLaterController(this);
    this.w = new VideoReportController(this);
    this.x = new VideoDtReportController(this);
    this.y = new VideoDynamicInsertController(this);
    this.B = ((IEventListener)new VideoPlayController.eventListener.1(this));
  }
  
  private final void B()
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      View localView = ((IVideoView)localObject).a();
      if (localView != null)
      {
        if (!TextUtils.isEmpty((CharSequence)this.f)) {
          localObject = this.f;
        } else {
          localObject = this.e;
        }
        localView.setTag(localObject);
      }
    }
  }
  
  private final IVideoView C()
  {
    Object localObject3 = this.C;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((VideoView)localObject3).getContext();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        IPlayerFactory localIPlayerFactory = this.r;
        localObject1 = localObject2;
        if (localIPlayerFactory != null) {
          localObject1 = localIPlayerFactory.a((Context)localObject3, VersionUtils.d());
        }
      }
    }
    return localObject1;
  }
  
  private final void D()
  {
    if (E())
    {
      a((IStrategy)this.u, (IStrategy.URLCallback)new VideoPlayController.selectUrlByVid.1(this));
      return;
    }
    if (this.d)
    {
      String str = this.f;
      if (str != null) {
        c(str);
      }
    }
  }
  
  private final boolean E()
  {
    int i1 = this.c;
    return (i1 == 2) || (i1 == 6);
  }
  
  private final void F()
  {
    if (this.z)
    {
      int i1 = this.A;
      if (i1 >= 0)
      {
        d(i1);
        this.A = -1;
      }
      this.z = false;
    }
    IPlayer localIPlayer = this.o;
    if (localIPlayer != null) {
      localIPlayer.g();
    }
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.l = paramInt1;
    this.m = paramInt2;
    this.n = paramInt3;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playErrorModule:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(",playErrorType:");
    localStringBuilder.append(this.m);
    localStringBuilder.append(",playErrorCode:");
    localStringBuilder.append(this.n);
    QLog.d(str, 1, localStringBuilder.toString());
    VideoState.a.a(this.D, this.E, this.C, this).a(-1);
  }
  
  private final void a(Context paramContext, PlayerVideoInfo paramPlayerVideoInfo)
  {
    try
    {
      localObject = this.o;
      if (localObject != null) {
        ((IPlayer)localObject).i();
      }
      localObject = this.o;
      if (localObject != null)
      {
        ((IPlayer)localObject).a(paramContext, paramPlayerVideoInfo, 0L, d(false));
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramPlayerVideoInfo = this.b;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("realPlay error, msg=");
      ((StringBuilder)localObject).append(paramContext);
      QLog.d(paramPlayerVideoInfo, 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private final void a(PlayerVideoInfo paramPlayerVideoInfo)
  {
    if (paramPlayerVideoInfo != null)
    {
      paramPlayerVideoInfo.b(true);
      paramPlayerVideoInfo.a(RIJVideoSdkConfigSp.a());
    }
  }
  
  private final void b(OnVideoPluginInstallListener paramOnVideoPluginInstallListener)
  {
    if (this.s == null) {
      this.s = new VideoPluginInstall();
    }
    VideoPluginInstall localVideoPluginInstall = this.s;
    if ((localVideoPluginInstall != null) && (localVideoPluginInstall.b() == true))
    {
      if (paramOnVideoPluginInstallListener != null) {
        paramOnVideoPluginInstallListener.a(true);
      }
    }
    else
    {
      QLog.d(this.b, 1, "not installed, now install");
      if (paramOnVideoPluginInstallListener != null)
      {
        localVideoPluginInstall = this.s;
        if (localVideoPluginInstall != null) {
          localVideoPluginInstall.a(paramOnVideoPluginInstallListener);
        }
      }
      paramOnVideoPluginInstallListener = this.s;
      if (paramOnVideoPluginInstallListener != null) {
        paramOnVideoPluginInstallListener.a();
      }
    }
  }
  
  private final SuperPlayerOption d(boolean paramBoolean)
  {
    LogUtils.setLogEnable(QLog.isColorLevel());
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.isPrePlay = paramBoolean;
    Object localObject = Aladdin.getConfig(357);
    localSuperPlayerOption.bufferPacketMinTotalDurationMs = ((AladdinConfig)localObject).getIntegerFromString("bufferPacketMinTotalDurationMs", 0);
    localSuperPlayerOption.preloadPacketDurationMs = ((AladdinConfig)localObject).getIntegerFromString("preloadPacketDurationMs", 0);
    localSuperPlayerOption.minBufferingPacketDurationMs = ((AladdinConfig)localObject).getIntegerFromString("minBufferingPacketDurationMs", 0);
    if (QLog.isColorLevel())
    {
      localObject = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("commonPlayerOption: ");
      localStringBuilder.append(localSuperPlayerOption);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Intrinsics.checkExpressionValueIsNotNull(localSuperPlayerOption, "option");
    return localSuperPlayerOption;
  }
  
  private final void h(Function0<Unit> paramFunction0)
  {
    QLog.d(this.b, 1, "createVideoPlayer");
    Object localObject = this.o;
    if (localObject != null) {
      ((IPlayer)localObject).k();
    }
    this.r = PlayerHelper.a.b();
    this.p = C();
    localObject = this.C;
    if (localObject != null) {
      ((VideoView)localObject).setVideoView(this.p);
    }
    localObject = this.r;
    if (localObject != null) {
      localObject = ((IPlayerFactory)localObject).a(this.p);
    } else {
      localObject = null;
    }
    this.o = ((IPlayer)localObject);
    localObject = this.o;
    if (localObject != null) {
      ((IPlayer)localObject).a(this.p);
    }
    localObject = this.o;
    if (localObject != null) {
      ((IPlayer)localObject).a(this.h);
    }
    localObject = this.o;
    if (localObject != null) {
      ((IPlayer)localObject).b(this.g);
    }
    localObject = this.o;
    if (localObject != null) {
      ((IPlayer)localObject).a(this.B);
    }
    B();
    paramFunction0.invoke();
  }
  
  @NotNull
  public final String a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.t.iterator();
    while (localIterator.hasNext()) {
      ((VideoPlayController.OnStateChangeListener)localIterator.next()).onStateChanged(paramInt1, paramInt2);
    }
  }
  
  public final void a(@Nullable IPlayer paramIPlayer)
  {
    this.o = paramIPlayer;
  }
  
  public final void a(@Nullable OnVideoPluginInstallListener paramOnVideoPluginInstallListener)
  {
    g((Function0)new VideoPlayController.install.1(this, paramOnVideoPluginInstallListener));
  }
  
  public final void a(@NotNull VideoPlayController.OnStateChangeListener paramOnStateChangeListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnStateChangeListener, "listener");
    if (!this.t.contains(paramOnStateChangeListener)) {
      this.t.add(paramOnStateChangeListener);
    }
  }
  
  public final void a(@Nullable VideoPlayListener paramVideoPlayListener)
  {
    this.j = paramVideoPlayListener;
  }
  
  public final void a(@Nullable VideoView paramVideoView)
  {
    this.C = paramVideoView;
  }
  
  public final void a(@Nullable IStrategy paramIStrategy, @Nullable IStrategy.URLCallback paramURLCallback)
  {
    if (paramIStrategy != null) {
      paramIStrategy.a(this.f, paramURLCallback);
    }
  }
  
  public final void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.q = paramAbsBaseArticleInfo;
    paramAbsBaseArticleInfo = this.w;
    if (paramAbsBaseArticleInfo != null) {
      paramAbsBaseArticleInfo.f();
    }
  }
  
  public final void a(@Nullable String paramString)
  {
    this.e = paramString;
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    Object localObject = this.q;
    if (localObject != null) {
      localObject = ((AbsBaseArticleInfo)localObject).innerUniqueID;
    } else {
      localObject = null;
    }
    if (StringsKt.equals(paramString, (String)localObject, true))
    {
      this.z = true;
      this.A = paramInt;
    }
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    f((Function0)new VideoPlayController.initPlayer.1(this, paramFunction0));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    IPlayer localIPlayer = this.o;
    if (localIPlayer != null) {
      localIPlayer.c(this.g);
    }
  }
  
  @Nullable
  public final String b()
  {
    return this.e;
  }
  
  public final void b(int paramInt)
  {
    this.i = paramInt;
    IPlayer localIPlayer = this.o;
    if (localIPlayer != null) {
      localIPlayer.a(this.i);
    }
  }
  
  public final void b(@NotNull VideoPlayController.OnStateChangeListener paramOnStateChangeListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnStateChangeListener, "listener");
    this.t.remove(paramOnStateChangeListener);
  }
  
  public final void b(@Nullable String paramString)
  {
    this.f = paramString;
  }
  
  public final void b(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    g((Function0)new VideoPlayController.startPlayer.1(this, paramFunction0));
  }
  
  public final void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
    IPlayer localIPlayer = this.o;
    if (localIPlayer != null) {
      localIPlayer.a(this.h);
    }
  }
  
  @Nullable
  public final String c()
  {
    return this.f;
  }
  
  public final void c(int paramInt)
  {
    if (!this.k)
    {
      this.E.set(paramInt);
      s();
    }
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "vid");
    PlayerVideoInfo localPlayerVideoInfo = new PlayerVideoInfo(1, paramString);
    a(localPlayerVideoInfo);
    Object localObject = this.C;
    if (localObject != null)
    {
      localObject = ((VideoView)localObject).getContext();
      if (localObject != null)
      {
        String str = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("opening ");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
        if (q()) {
          a((Context)localObject, localPlayerVideoInfo);
        }
      }
    }
  }
  
  public final void c(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    g((Function0)new VideoPlayController.stopPlayer.1(this, paramFunction0));
  }
  
  public final void c(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public final void d(int paramInt)
  {
    IPlayer localIPlayer = this.o;
    if (localIPlayer != null) {
      localIPlayer.a(paramInt, 3);
    }
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "videoUrl");
    if ((q()) && (!TextUtils.isEmpty((CharSequence)paramString)))
    {
      Object localObject2 = ThirdVideoManager.a().c(paramString);
      Object localObject1;
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2[0])) {}
      }
      else
      {
        localObject1 = new String[1];
        localObject1[0] = paramString;
      }
      localObject2 = this.C;
      if (localObject2 != null)
      {
        localObject2 = ((VideoView)localObject2).getContext();
        if (localObject2 != null)
        {
          localObject1 = new PlayerVideoInfo(101, "", (String[])localObject1);
          a((PlayerVideoInfo)localObject1);
          String str = this.b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("opening ");
          localStringBuilder.append(paramString);
          QLog.d(str, 2, localStringBuilder.toString());
          if (q()) {
            a((Context)localObject2, (PlayerVideoInfo)localObject1);
          }
        }
      }
    }
  }
  
  public final void d(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    g((Function0)new VideoPlayController.pausePlayer.1(this, paramFunction0));
  }
  
  public final boolean d()
  {
    return this.h;
  }
  
  @Nullable
  public final VideoPlayListener e()
  {
    return this.j;
  }
  
  public final void e(int paramInt)
  {
    VideoDynamicInsertController localVideoDynamicInsertController = this.y;
    if (localVideoDynamicInsertController != null) {
      localVideoDynamicInsertController.a(paramInt);
    }
  }
  
  public final void e(@Nullable String paramString)
  {
    VideoDtReportController localVideoDtReportController = this.x;
    if (localVideoDtReportController != null) {
      localVideoDtReportController.b(paramString);
    }
  }
  
  public final void e(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    g((Function0)new VideoPlayController.destroyPlayer.1(this, paramFunction0));
  }
  
  public final int f()
  {
    return this.l;
  }
  
  public final void f(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reportR5");
  }
  
  public final void f(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    if (RIJThreadHandler.f())
    {
      paramFunction0.invoke();
      return;
    }
    ThreadManager.getUIHandler().post((Runnable)new VideoPlayController.executeOnMainThread.1(this, paramFunction0));
  }
  
  public final int g()
  {
    return this.m;
  }
  
  public final void g(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "suffix");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("VideoPlayController.");
    ((StringBuilder)localObject).append(paramString);
    this.b = ((StringBuilder)localObject).toString();
    localObject = this.x;
    StringBuilder localStringBuilder;
    if (localObject != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(VideoDtReportController.class.getSimpleName());
      localStringBuilder.append('.');
      localStringBuilder.append(paramString);
      ((VideoDtReportController)localObject).a(localStringBuilder.toString());
    }
    localObject = this.w;
    if (localObject != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(VideoReportController.class.getSimpleName());
      localStringBuilder.append('.');
      localStringBuilder.append(paramString);
      ((VideoReportController)localObject).a(localStringBuilder.toString());
    }
  }
  
  public final void g(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    ThreadManager.getFileThreadHandler().post((Runnable)new VideoPlayController.executeOnSubThread.1(this, paramFunction0));
  }
  
  public final int h()
  {
    return this.n;
  }
  
  @Nullable
  public final IPlayer i()
  {
    return this.o;
  }
  
  @Nullable
  public final IVideoView j()
  {
    return this.p;
  }
  
  @Nullable
  public final AbsBaseArticleInfo k()
  {
    return this.q;
  }
  
  public final void l()
  {
    this.E.set(6);
    s();
  }
  
  public final void m()
  {
    this.E.set(5);
    s();
  }
  
  public final void n()
  {
    this.E.set(4);
    s();
  }
  
  public final void o()
  {
    this.E.set(7);
    s();
  }
  
  public final void p()
  {
    g((Function0)new VideoPlayController.open.1(this));
  }
  
  public final boolean q()
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = ((IVideoView)localObject).a();
      if (localObject != null)
      {
        localObject = ((View)localObject).getTag();
        break label30;
      }
    }
    localObject = null;
    label30:
    localObject = (CharSequence)localObject;
    boolean bool;
    if ((!TextUtils.equals((CharSequence)this.f, (CharSequence)localObject)) && (!TextUtils.equals((CharSequence)this.e, (CharSequence)localObject))) {
      bool = false;
    } else {
      bool = true;
    }
    localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkVideo: ");
    localStringBuilder.append(bool);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    return bool;
  }
  
  public final void r()
  {
    VideoPlayListener localVideoPlayListener = this.j;
    if (localVideoPlayListener != null) {
      localVideoPlayListener.c();
    }
  }
  
  public final void s()
  {
    VideoView localVideoView = this.C;
    if (localVideoView != null) {
      try
      {
        VideoState.a.a(this.D, this.E, this.C, this).a();
        Unit localUnit = Unit.INSTANCE;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  public final void t()
  {
    Object localObject1 = this.q;
    if (localObject1 != null)
    {
      Object localObject2 = this.o;
      long l1;
      if (localObject2 != null)
      {
        l1 = ((IPlayer)localObject2).o();
        localObject2 = (Map)VideoDataManager.a.a();
        String str = ((AbsBaseArticleInfo)localObject1).innerUniqueID;
        Intrinsics.checkExpressionValueIsNotNull(str, "article.innerUniqueID");
        ((Map)localObject2).put(str, Long.valueOf(l1));
      }
      localObject2 = this.o;
      if (localObject2 != null)
      {
        l1 = ((IPlayer)localObject2).n();
        localObject2 = (Map)VideoDataManager.a.b();
        localObject1 = ((AbsBaseArticleInfo)localObject1).innerUniqueID;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "article.innerUniqueID");
        ((Map)localObject2).put(localObject1, Long.valueOf(l1));
      }
    }
  }
  
  @Nullable
  public final VideoView u()
  {
    return this.C;
  }
  
  @NotNull
  public final AtomicInteger v()
  {
    return this.D;
  }
  
  @NotNull
  public final AtomicInteger w()
  {
    return this.E;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController
 * JD-Core Version:    0.7.0.1
 */
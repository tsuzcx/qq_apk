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
  public static final VideoPlayController.Companion a;
  private static int g;
  private static int h = 1;
  private static int i = 2;
  private static int j = h;
  private int jdField_a_of_type_Int;
  @NotNull
  private IEventListener jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIEventListener;
  @Nullable
  private IPlayer jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
  @Nullable
  private IVideoView jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView;
  private IPlayerFactory jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerFactory;
  private VideoPluginInstall jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall;
  @Nullable
  private VideoDtReportController jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoDtReportController;
  @Nullable
  private VideoDynamicInsertController jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoDynamicInsertController;
  @Nullable
  private VideoPlayListener jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoPlayListener;
  @Nullable
  private VideoReportController jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoReportController;
  @Nullable
  private VideoSeeLaterController jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoSeeLaterController;
  @Nullable
  private VideoView jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
  private ReadInJoyVideoStrategy jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoUtilsReadInJoyVideoStrategy;
  @Nullable
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  private final CopyOnWriteArrayList<VideoPlayController.OnStateChangeListener> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  @NotNull
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  @Nullable
  private String jdField_b_of_type_JavaLangString;
  @NotNull
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  @Nullable
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int f;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoPlayController$Companion = new VideoPlayController.Companion(null);
  }
  
  public VideoPlayController(@Nullable VideoView paramVideoView, @NotNull AtomicInteger paramAtomicInteger1, @NotNull AtomicInteger paramAtomicInteger2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView = paramVideoView;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = paramAtomicInteger1;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = paramAtomicInteger2;
    this.jdField_a_of_type_JavaLangString = "VideoPlayController";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.f = -1;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoUtilsReadInJoyVideoStrategy = new ReadInJoyVideoStrategy();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoSeeLaterController = new VideoSeeLaterController(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoReportController = new VideoReportController(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoDtReportController = new VideoDtReportController(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoDynamicInsertController = new VideoDynamicInsertController(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIEventListener = ((IEventListener)new VideoPlayController.eventListener.1(this));
  }
  
  private final SuperPlayerOption a(boolean paramBoolean)
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
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("commonPlayerOption: ");
      localStringBuilder.append(localSuperPlayerOption);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Intrinsics.checkExpressionValueIsNotNull(localSuperPlayerOption, "option");
    return localSuperPlayerOption;
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_e_of_type_Int = paramInt3;
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playErrorModule:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(",playErrorType:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(",playErrorCode:");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    QLog.d(str, 1, localStringBuilder.toString());
    VideoState.a.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger, this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView, this).a(-1);
  }
  
  private final void a(Context paramContext, PlayerVideoInfo paramPlayerVideoInfo)
  {
    try
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
      if (localObject != null) {
        ((IPlayer)localObject).c();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
      if (localObject != null)
      {
        ((IPlayer)localObject).a(paramContext, paramPlayerVideoInfo, 0L, a(false));
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramPlayerVideoInfo = this.jdField_a_of_type_JavaLangString;
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
  
  private final IVideoView b()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((VideoView)localObject3).getContext();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        IPlayerFactory localIPlayerFactory = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerFactory;
        localObject1 = localObject2;
        if (localIPlayerFactory != null) {
          localObject1 = localIPlayerFactory.a((Context)localObject3, VersionUtils.d());
        }
      }
    }
    return localObject1;
  }
  
  private final void b(OnVideoPluginInstallListener paramOnVideoPluginInstallListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall = new VideoPluginInstall();
    }
    VideoPluginInstall localVideoPluginInstall = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall;
    if ((localVideoPluginInstall != null) && (localVideoPluginInstall.a() == true))
    {
      if (paramOnVideoPluginInstallListener != null) {
        paramOnVideoPluginInstallListener.a(true);
      }
    }
    else
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "not installed, now install");
      if (paramOnVideoPluginInstallListener != null)
      {
        localVideoPluginInstall = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall;
        if (localVideoPluginInstall != null) {
          localVideoPluginInstall.a(paramOnVideoPluginInstallListener);
        }
      }
      paramOnVideoPluginInstallListener = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall;
      if (paramOnVideoPluginInstallListener != null) {
        paramOnVideoPluginInstallListener.a();
      }
    }
  }
  
  private final boolean c()
  {
    int k = this.jdField_a_of_type_Int;
    return (k == 2) || (k == 6);
  }
  
  private final void h(Function0<Unit> paramFunction0)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "createVideoPlayer");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localObject != null) {
      ((IPlayer)localObject).d();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerFactory = PlayerHelper.a.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView = b();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
    if (localObject != null) {
      ((VideoView)localObject).setVideoView(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerFactory;
    if (localObject != null) {
      localObject = ((IPlayerFactory)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView);
    } else {
      localObject = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer = ((IPlayer)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localObject != null) {
      ((IPlayer)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localObject != null) {
      ((IPlayer)localObject).a(this.jdField_c_of_type_Boolean);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localObject != null) {
      ((IPlayer)localObject).b(this.jdField_b_of_type_Boolean);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localObject != null) {
      ((IPlayer)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIEventListener);
    }
    i();
    paramFunction0.invoke();
  }
  
  private final void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView;
    if (localObject != null)
    {
      View localView = ((IVideoView)localObject).a();
      if (localView != null)
      {
        if (!TextUtils.isEmpty((CharSequence)this.jdField_c_of_type_JavaLangString)) {
          localObject = this.jdField_c_of_type_JavaLangString;
        } else {
          localObject = this.jdField_b_of_type_JavaLangString;
        }
        localView.setTag(localObject);
      }
    }
  }
  
  private final void j()
  {
    if (c())
    {
      a((IStrategy)this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoUtilsReadInJoyVideoStrategy, (IStrategy.URLCallback)new VideoPlayController.selectUrlByVid.1(this));
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      String str = this.jdField_c_of_type_JavaLangString;
      if (str != null) {
        c(str);
      }
    }
  }
  
  private final void k()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      int k = this.f;
      if (k >= 0)
      {
        d(k);
        this.f = -1;
      }
      this.jdField_e_of_type_Boolean = false;
    }
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      localIPlayer.a();
    }
  }
  
  public final int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  @Nullable
  public final IPlayer a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
  }
  
  @Nullable
  public final IVideoView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView;
  }
  
  @Nullable
  public final VideoPlayListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoPlayListener;
  }
  
  @Nullable
  public final VideoView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
  }
  
  @Nullable
  public final AbsBaseArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final AtomicInteger a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  }
  
  public final void a()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(6);
    g();
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((VideoPlayController.OnStateChangeListener)localIterator.next()).onStateChanged(paramInt1, paramInt2);
    }
  }
  
  public final void a(@Nullable IPlayer paramIPlayer)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer = paramIPlayer;
  }
  
  public final void a(@Nullable OnVideoPluginInstallListener paramOnVideoPluginInstallListener)
  {
    g((Function0)new VideoPlayController.install.1(this, paramOnVideoPluginInstallListener));
  }
  
  public final void a(@NotNull VideoPlayController.OnStateChangeListener paramOnStateChangeListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnStateChangeListener, "listener");
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramOnStateChangeListener)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramOnStateChangeListener);
    }
  }
  
  public final void a(@Nullable VideoPlayListener paramVideoPlayListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoPlayListener = paramVideoPlayListener;
  }
  
  public final void a(@Nullable VideoView paramVideoView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView = paramVideoView;
  }
  
  public final void a(@Nullable IStrategy paramIStrategy, @Nullable IStrategy.URLCallback paramURLCallback)
  {
    if (paramIStrategy != null) {
      paramIStrategy.a(this.jdField_c_of_type_JavaLangString, paramURLCallback);
    }
  }
  
  public final void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    paramAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoReportController;
    if (paramAbsBaseArticleInfo != null) {
      paramAbsBaseArticleInfo.e();
    }
  }
  
  public final void a(@Nullable String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localObject != null) {
      localObject = ((AbsBaseArticleInfo)localObject).innerUniqueID;
    } else {
      localObject = null;
    }
    if (StringsKt.equals(paramString, (String)localObject, true))
    {
      this.jdField_e_of_type_Boolean = true;
      this.f = paramInt;
    }
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    f((Function0)new VideoPlayController.initPlayer.1(this, paramFunction0));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      localIPlayer.c(this.jdField_b_of_type_Boolean);
    }
  }
  
  public final boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public final int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  @Nullable
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  @NotNull
  public final AtomicInteger b()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  }
  
  public final void b()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
    g();
  }
  
  public final void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      localIPlayer.a(this.jdField_b_of_type_Int);
    }
  }
  
  public final void b(@NotNull VideoPlayController.OnStateChangeListener paramOnStateChangeListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnStateChangeListener, "listener");
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramOnStateChangeListener);
  }
  
  public final void b(@Nullable String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public final void b(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    g((Function0)new VideoPlayController.startPlayer.1(this, paramFunction0));
  }
  
  public final void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      localIPlayer.a(this.jdField_c_of_type_Boolean);
    }
  }
  
  public final boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView;
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
    if ((!TextUtils.equals((CharSequence)this.jdField_c_of_type_JavaLangString, (CharSequence)localObject)) && (!TextUtils.equals((CharSequence)this.jdField_b_of_type_JavaLangString, (CharSequence)localObject))) {
      bool = false;
    } else {
      bool = true;
    }
    localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkVideo: ");
    localStringBuilder.append(bool);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    return bool;
  }
  
  public final int c()
  {
    return this.jdField_e_of_type_Int;
  }
  
  @Nullable
  public final String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public final void c()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
    g();
  }
  
  public final void c(int paramInt)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
      g();
    }
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "vid");
    PlayerVideoInfo localPlayerVideoInfo = new PlayerVideoInfo(1, paramString);
    a(localPlayerVideoInfo);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
    if (localObject != null)
    {
      localObject = ((VideoView)localObject).getContext();
      if (localObject != null)
      {
        String str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("opening ");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
        if (b()) {
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
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public final void d()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(7);
    g();
  }
  
  public final void d(int paramInt)
  {
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      localIPlayer.a(paramInt, 3);
    }
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "videoUrl");
    if ((b()) && (!TextUtils.isEmpty((CharSequence)paramString)))
    {
      Object localObject2 = ThirdVideoManager.a().a(paramString);
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
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
      if (localObject2 != null)
      {
        localObject2 = ((VideoView)localObject2).getContext();
        if (localObject2 != null)
        {
          localObject1 = new PlayerVideoInfo(101, "", (String[])localObject1);
          a((PlayerVideoInfo)localObject1);
          String str = this.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("opening ");
          localStringBuilder.append(paramString);
          QLog.d(str, 2, localStringBuilder.toString());
          if (b()) {
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
  
  public final void e()
  {
    g((Function0)new VideoPlayController.open.1(this));
  }
  
  public final void e(int paramInt)
  {
    VideoDynamicInsertController localVideoDynamicInsertController = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoDynamicInsertController;
    if (localVideoDynamicInsertController != null) {
      localVideoDynamicInsertController.a(paramInt);
    }
  }
  
  public final void e(@Nullable String paramString)
  {
    VideoDtReportController localVideoDtReportController = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoDtReportController;
    if (localVideoDtReportController != null) {
      localVideoDtReportController.b(paramString);
    }
  }
  
  public final void e(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    g((Function0)new VideoPlayController.destroyPlayer.1(this, paramFunction0));
  }
  
  public final void f()
  {
    VideoPlayListener localVideoPlayListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoPlayListener;
    if (localVideoPlayListener != null) {
      localVideoPlayListener.c();
    }
  }
  
  public final void f(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reportR5");
  }
  
  public final void f(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    if (RIJThreadHandler.a())
    {
      paramFunction0.invoke();
      return;
    }
    ThreadManager.getUIHandler().post((Runnable)new VideoPlayController.executeOnMainThread.1(this, paramFunction0));
  }
  
  public final void g()
  {
    VideoView localVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
    if (localVideoView != null) {
      try
      {
        VideoState.a.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger, this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView, this).a();
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
  
  public final void g(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "suffix");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("VideoPlayController.");
    ((StringBuilder)localObject).append(paramString);
    this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoDtReportController;
    StringBuilder localStringBuilder;
    if (localObject != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(VideoDtReportController.class.getSimpleName());
      localStringBuilder.append('.');
      localStringBuilder.append(paramString);
      ((VideoDtReportController)localObject).a(localStringBuilder.toString());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoReportController;
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
  
  public final void h()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
      long l;
      if (localObject2 != null)
      {
        l = ((IPlayer)localObject2).b();
        localObject2 = (Map)VideoDataManager.a.a();
        String str = ((AbsBaseArticleInfo)localObject1).innerUniqueID;
        Intrinsics.checkExpressionValueIsNotNull(str, "article.innerUniqueID");
        ((Map)localObject2).put(str, Long.valueOf(l));
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
      if (localObject2 != null)
      {
        l = ((IPlayer)localObject2).a();
        localObject2 = (Map)VideoDataManager.a.b();
        localObject1 = ((AbsBaseArticleInfo)localObject1).innerUniqueID;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "article.innerUniqueID");
        ((Map)localObject2).put(localObject1, Long.valueOf(l));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController
 * JD-Core Version:    0.7.0.1
 */
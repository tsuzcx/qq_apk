package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdExposureManager;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.view.widget.ListEventListener;
import com.tencent.mobileqq.kandian.biz.ad.report.ReadinjoyAdVideoReportData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertConfig;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.feeds.entity.ExposureArticle;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsRecommendPresenter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsVideoUIDelegate.CallBack;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.glue.video.report.PlayInfoForReport;
import com.tencent.mobileqq.kandian.glue.video.report.VideoDTReport;
import com.tencent.mobileqq.kandian.glue.video.report.VideoDTReport.Builder;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsRecommendPresenter;", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsPlayManager$VideoStatusListener;", "Lcom/tencent/mobileqq/kandian/base/view/widget/ListEventListener;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsVideoUIDelegate$CallBack;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsRecommendPresenter;", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "playManager", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsPlayManager;", "recyclerView", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/view/VideoFeedsRecyclerView;", "isLoopPlayMode", "", "videoDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "videoFromType", "", "(Landroid/app/Activity;Landroid/os/Bundle;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsPlayManager;Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/view/VideoFeedsRecyclerView;ZLjava/util/ArrayList;I)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "adapter", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsAdapter;", "getAdapter", "()Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsAdapter;", "setAdapter", "(Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsAdapter;)V", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "setApp", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "getBundle", "()Landroid/os/Bundle;", "dynamicInsertProgress", "getDynamicInsertProgress", "()I", "firstVideoInfo", "getFirstVideoInfo", "()Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "hasRequestDynamicInsert", "getHasRequestDynamicInsert", "()Z", "setHasRequestDynamicInsert", "(Z)V", "<set-?>", "isFullScreen", "isTikTokStyle", "lastResumeTimeStamp", "", "lastStayDuration", "lastVideoItemHolder", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/BaseVideoItemHolder;", "mEventHandler", "Landroid/os/Handler;", "getMEventHandler", "()Landroid/os/Handler;", "mFirstVideoPlayerSessionId", "", "mHasJumpColumnPage", "mIsKingCardUser", "getMIsKingCardUser", "mKandianMode", "mKandianModeNew", "mPlayInfoListForReport", "Lcom/tencent/mobileqq/kandian/glue/video/report/PlayInfoForReport;", "mPlayingVideoItemHolder", "getMPlayingVideoItemHolder", "()Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/BaseVideoItemHolder;", "mRecommendManager", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsRecommendManager;", "mUpglideCount", "mVideoAdFetchManager", "Lcom/tencent/mobileqq/kandian/ad/api/entity/IVideoAdExposureManager;", "onColumnActionObserver", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "getPlayManager", "()Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsPlayManager;", "playingVideoInfo", "getPlayingVideoInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoPlayParam;", "playingVideoParams", "getPlayingVideoParams", "()Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoPlayParam;", "reporter", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsReporter;", "getReporter", "()Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsReporter;", "speedRatioIndex", "getSpeedRatioIndex", "getVideoDataList", "()Ljava/util/ArrayList;", "getVideoFromType", "afterVideoStart", "", "playParam", "beforeVideoStart", "doOnPause", "doOnResume", "doWhenJumpColumnPage", "getActionBarHeight", "getPlayingVideoItemHolder", "getVideoFeedsReporter", "", "handlePlayButtonClick", "handleSpeedRatioBtnClick", "isDynamicInsertEnable", "isKingCardUser", "onCenterViewChanged", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onCenterViewIdle", "onChangeScreenOrientation", "onCompletion", "onDestroyView", "onDianZanClick", "videoHolder", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/VideoItemHolder;", "dianZanDrawable", "onLoadMore", "onProgressChanged", "currentMillisTime", "duration", "onSeekBarDragEnd", "onVideoBufferEnd", "isPlaying", "onVideoBufferStart", "onVideoError", "model", "what", "errorMsg", "onVideoInitiate", "onVideoPause", "onVideoReplayOnLoop", "times", "onVideoRestart", "onVideoStop", "isCompleted", "recordDynamicInsertAction", "action", "Lcom/tencent/mobileqq/kandian/repo/feeds/RIJFeedsInsertAction;", "recordDynamicInsertExposuedVideo", "list", "reportDtOnVideoEnd", "isComplete", "reportDtOnVideoLoop", "reportDtOnVideoStart", "reportOnCreate", "reportUpglideCount", "reportUseDuration", "resetSpeedRatio", "resumePlayWhenBackFromColumnPage", "setRecommendManager", "recommendManager", "setVideoAdFetchManager", "videoAdExposureManager", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsRecommendPresenter
  implements ListEventListener, VideoFeedsPlayManager.VideoStatusListener, IVideoFeedsRecommendPresenter, IVideoFeedsVideoUIDelegate.CallBack
{
  @NotNull
  private static final float[] H = { 1.0F, 1.5F, 2.0F };
  @NotNull
  private static final int[] I = { 2130851664, 2130851663, 2130851665 };
  public static final VideoFeedsRecommendPresenter.Companion a = new VideoFeedsRecommendPresenter.Companion(null);
  @Nullable
  private Activity A;
  @NotNull
  private final Bundle B;
  @Nullable
  private QQAppInterface C;
  @NotNull
  private final VideoFeedsPlayManager D;
  private final boolean E;
  @NotNull
  private final ArrayList<VideoInfo> F;
  private final int G;
  private BaseVideoItemHolder b;
  @Nullable
  private BaseVideoItemHolder c;
  @Nullable
  private VideoPlayParam d;
  @Nullable
  private VideoInfo e;
  private VideoFeedsRecommendManager f;
  private String g;
  private int h;
  private int i;
  private int j;
  @NotNull
  private final VideoInfo k;
  private final ArrayList<PlayInfoForReport> l;
  @NotNull
  private final Handler m;
  private IVideoAdExposureManager n;
  private final boolean o;
  private int p;
  private boolean q;
  private long r;
  private long s;
  private boolean t;
  private final boolean u;
  @NotNull
  private final VideoFeedsReporter v;
  private final int w;
  private boolean x;
  @Nullable
  private VideoFeedsAdapter y;
  private final ReadInJoyObserver z;
  
  public VideoFeedsRecommendPresenter(@Nullable Activity paramActivity, @NotNull Bundle paramBundle, @Nullable QQAppInterface paramQQAppInterface, @NotNull VideoFeedsPlayManager paramVideoFeedsPlayManager, @NotNull VideoFeedsRecyclerView paramVideoFeedsRecyclerView, boolean paramBoolean, @NotNull ArrayList<VideoInfo> paramArrayList, int paramInt)
  {
    this.A = paramActivity;
    this.B = paramBundle;
    this.C = paramQQAppInterface;
    this.D = paramVideoFeedsPlayManager;
    this.E = paramBoolean;
    this.F = paramArrayList;
    this.G = paramInt;
    this.h = 5;
    this.l = new ArrayList();
    paramInt = CUKingCardHelper.a();
    int i1 = 0;
    if (paramInt == 1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.u = paramBoolean;
    this.z = ((ReadInJoyObserver)new VideoFeedsRecommendPresenter.onColumnActionObserver.1(this));
    this.r = System.currentTimeMillis();
    this.m = new Handler();
    w().a((VideoFeedsPlayManager.VideoStatusListener)this);
    paramVideoFeedsRecyclerView.a((ListEventListener)this);
    paramActivity = this.F.get(0);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "videoDataList[0]");
    this.k = ((VideoInfo)paramActivity);
    this.h = RIJAppSetting.b();
    this.i = VideoReporter.c();
    paramActivity = v();
    paramInt = i1;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getIntent();
      paramInt = i1;
      if (paramActivity != null) {
        paramInt = paramActivity.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
    }
    this.o = ReadInJoyHelper.b();
    if ((paramInt == 4) || (paramInt == 5) || (paramInt == 2) || (paramInt == 1)) {
      this.h = 5;
    }
    try
    {
      paramActivity = v();
      if (paramActivity != null)
      {
        paramActivity = paramActivity.getWindow();
        if (paramActivity != null) {
          paramActivity.addFlags(128);
        }
      }
    }
    catch (Exception paramActivity)
    {
      label307:
      break label307;
    }
    paramActivity = v();
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getIntent();
      if (paramActivity != null)
      {
        paramActivity = paramActivity.getStringExtra("video_player_session_id");
        break label338;
      }
    }
    paramActivity = null;
    label338:
    this.g = paramActivity;
    this.v = new VideoFeedsReporter(v(), this.B, this.k, this);
    this.w = RIJFeedsDynamicInsertConfig.a.a(6);
    ThreadManager.excute((Runnable)new VideoFeedsRecommendPresenter.1(this), 16, null, true);
  }
  
  private final void A()
  {
    Object localObject = v();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent();
      if (localObject != null)
      {
        i1 = ((Intent)localObject).getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        break label32;
      }
    }
    int i1 = 0;
    label32:
    localObject = v();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent();
      if (localObject != null)
      {
        i2 = ((Intent)localObject).getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        break label64;
      }
    }
    int i2 = 0;
    label64:
    localObject = this.k.l;
    String str = this.k.q;
    VideoR5.Builder localBuilder = new VideoR5.Builder(this.k);
    localBuilder.M(0).Y(i1).q((String)localObject);
    try
    {
      PublicAccountReportUtils.b(null, str, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(i2), "", (String)localObject, localBuilder.b().a(), false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private final void B()
  {
    if (this.r > 0L) {
      this.s += System.currentTimeMillis() - this.r;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = new VideoR5.Builder(this.e).M(0);
        Object localObject1 = this.e;
        Object localObject2 = null;
        if (localObject1 != null)
        {
          localObject1 = this.e;
          if (localObject1 != null)
          {
            localObject1 = ((VideoInfo)localObject1).ay;
            localObject3 = ((VideoR5.Builder)localObject3).b((VideoColumnInfo)localObject1).b(this.s).u(this.G);
            localObject1 = this.C;
            if (localObject1 == null) {
              break label190;
            }
            localObject1 = ((QQAppInterface)localObject1).getCurrentUin();
            localObject3 = ((VideoR5.Builder)localObject3).o((String)localObject1).b();
            AppInterface localAppInterface = (AppInterface)this.C;
            if (this.e == null) {
              break label195;
            }
            VideoInfo localVideoInfo = this.e;
            localObject1 = localObject2;
            if (localVideoInfo != null) {
              localObject1 = localVideoInfo.q;
            }
            PublicAccountReportUtils.a(localAppInterface, (String)localObject1, "0X800AF2E", "0X800AF2E", 0, 0, "", "", "", ((VideoR5)localObject3).a(), false);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        return;
      }
      String str = null;
      continue;
      label190:
      str = null;
      continue;
      label195:
      str = "";
    }
  }
  
  private final void C()
  {
    Object localObject1 = this.e;
    VideoR5.Builder localBuilder;
    if (localObject1 != null)
    {
      localBuilder = new VideoR5.Builder((VideoInfo)localObject1);
      localBuilder.Q(this.j);
    }
    for (;;)
    {
      try
      {
        AppInterface localAppInterface = (AppInterface)this.C;
        localObject1 = this.e;
        if (localObject1 == null) {
          break label89;
        }
        localObject1 = ((VideoInfo)localObject1).q;
        PublicAccountReportUtils.a(localAppInterface, (String)localObject1, "0X8009B79", "0X8009B79", 0, 0, "", "", "", localBuilder.b().a(), false);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label89:
      Object localObject2 = null;
    }
  }
  
  private final void D()
  {
    if ((this.c != null) && (this.q))
    {
      this.q = false;
      ReadInJoyLogicEngineEventDispatcher.a().b(this.z);
      VideoFeedsPlayManager localVideoFeedsPlayManager = w();
      Object localObject = this.c;
      if (localObject != null) {
        localObject = ((BaseVideoItemHolder)localObject).az;
      } else {
        localObject = null;
      }
      localVideoFeedsPlayManager.a((VideoPlayParam)localObject, false);
    }
  }
  
  private final void c(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramVideoPlayParam != null) {
      localObject1 = paramVideoPlayParam.h;
    } else {
      localObject1 = null;
    }
    if ((localObject1 instanceof VideoPlayerWrapper))
    {
      localObject1 = localObject2;
      if (paramVideoPlayParam != null) {
        localObject1 = paramVideoPlayParam.h;
      }
      if (localObject1 != null)
      {
        VideoDTReport.a((VideoPlayerWrapper)localObject1);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper");
    }
  }
  
  private final void h(VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam != null) {
      localObject1 = paramVideoPlayParam.h;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return;
    }
    Object localObject1 = paramVideoPlayParam.g;
    int i2 = 1;
    boolean bool = ((Bundle)localObject1).getBoolean("is_auto_play", true);
    if (paramVideoPlayParam.c.aq) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    localObject1 = VideoDTReport.Builder.a(paramVideoPlayParam.c).a("6").b(i1).a(paramVideoPlayParam.g.getInt("video_feeds_index", -1)).b(paramVideoPlayParam.h.I());
    Object localObject2 = paramVideoPlayParam.h;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "playParam.videoPlayer");
    localObject1 = ((VideoDTReport.Builder)localObject1).d(((IVideoPlayerWrapper)localObject2).H()).a(bool);
    int i1 = i2;
    if (this.E) {
      i1 = 2;
    }
    localObject1 = ((VideoDTReport.Builder)localObject1).d(i1);
    if ((paramVideoPlayParam.h instanceof VideoPlayerWrapper))
    {
      localObject2 = v();
      paramVideoPlayParam = paramVideoPlayParam.h;
      if (paramVideoPlayParam != null)
      {
        VideoDTReport.a(localObject2, (VideoPlayerWrapper)paramVideoPlayParam, (VideoDTReport.Builder)localObject1);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper");
    }
  }
  
  @Nullable
  public final BaseVideoItemHolder a()
  {
    return this.c;
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    if ((q()) && (!this.x) && (paramLong1 >= this.w))
    {
      RIJFeedsDynamicInsertController localRIJFeedsDynamicInsertController = RIJFeedsDynamicInsertController.INSTANCE;
      Object localObject = this.e;
      if (localObject != null) {
        localObject = ((VideoInfo)localObject).l;
      } else {
        localObject = null;
      }
      localRIJFeedsDynamicInsertController.requestInsertArticlesAndRecordAction((String)localObject, new RIJFeedsInsertAction(ActionType.ACTION_NONE, 0, 0, 0, 14, null), 6);
      this.x = true;
    }
  }
  
  public void a(@Nullable Activity paramActivity)
  {
    this.A = paramActivity;
  }
  
  public void a(@NotNull RecyclerView.ViewHolder paramViewHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
    this.b = this.c;
    boolean bool = paramViewHolder instanceof BaseVideoItemHolder;
    BaseVideoItemHolder localBaseVideoItemHolder = null;
    if (bool)
    {
      this.c = ((BaseVideoItemHolder)paramViewHolder);
      paramViewHolder = this.c;
      if (paramViewHolder != null) {
        paramViewHolder = paramViewHolder.az;
      } else {
        paramViewHolder = null;
      }
      this.d = paramViewHolder;
      VideoPlayParam localVideoPlayParam = this.d;
      paramViewHolder = localBaseVideoItemHolder;
      if (localVideoPlayParam != null) {
        paramViewHolder = localVideoPlayParam.c;
      }
      this.e = paramViewHolder;
      paramViewHolder = this.d;
      if (paramViewHolder != null)
      {
        paramViewHolder = paramViewHolder.h;
        if (paramViewHolder != null) {
          paramViewHolder.z();
        }
      }
    }
    else
    {
      this.c = ((BaseVideoItemHolder)null);
      this.d = ((VideoPlayParam)null);
      this.e = ((VideoInfo)null);
    }
    paramViewHolder = this.b;
    if (paramViewHolder != null)
    {
      localBaseVideoItemHolder = this.c;
      if ((localBaseVideoItemHolder != null) && (paramViewHolder != null) && (localBaseVideoItemHolder != null) && (paramViewHolder.Z > localBaseVideoItemHolder.Z)) {
        this.j += 1;
      }
    }
    this.v.a(this.c);
    j();
  }
  
  public void a(@NotNull RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
    this.t = paramBoolean;
  }
  
  public final void a(@Nullable IVideoAdExposureManager paramIVideoAdExposureManager)
  {
    this.n = paramIVideoAdExposureManager;
  }
  
  public final void a(@Nullable VideoFeedsAdapter paramVideoFeedsAdapter)
  {
    this.y = paramVideoFeedsAdapter;
  }
  
  public final void a(@Nullable VideoFeedsRecommendManager paramVideoFeedsRecommendManager)
  {
    this.f = paramVideoFeedsRecommendManager;
  }
  
  public void a(@Nullable VideoPlayParam paramVideoPlayParam)
  {
    this.v.a(paramVideoPlayParam);
  }
  
  public void a(@NotNull VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
    if (paramVideoPlayParam.h != null)
    {
      Object localObject = new PlayInfoForReport();
      ((PlayInfoForReport)localObject).a = paramVideoPlayParam.h.d(true);
      ((PlayInfoForReport)localObject).b = paramVideoPlayParam.h.I();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mPlayInfoListForReport add detailInfo.totalPlayTime = ");
        localStringBuilder.append(((PlayInfoForReport)localObject).a);
        localStringBuilder.append(", detailInfo.currentPlayTime = ");
        localStringBuilder.append(((PlayInfoForReport)localObject).b);
        QLog.d("VideoFeedsRecommendPresenter", 2, localStringBuilder.toString());
      }
      this.l.add(localObject);
      if ((VideoFeedsRecommendPresenter.Companion.a(a, paramVideoPlayParam)) && (this.E) && (v() != null)) {
        ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).reportVideoReplayOnLoop(paramVideoPlayParam, (Context)v(), paramVideoPlayParam.h);
      }
      localObject = this.c;
      if (localObject != null)
      {
        paramInt = ((BaseVideoItemHolder)localObject).Z;
        localObject = this.n;
        if (localObject != null) {
          ((IVideoAdExposureManager)localObject).b(paramInt, paramVideoPlayParam, this.F);
        }
      }
    }
  }
  
  public void a(@NotNull VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
  }
  
  public void a(@NotNull VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
    if (v() == null) {
      return;
    }
    VideoInfo localVideoInfo = paramVideoPlayParam.c;
    long l2 = w().t();
    Object localObject = this.b;
    int i1;
    if (localObject != null) {
      i1 = ((BaseVideoItemHolder)localObject).Z;
    } else {
      i1 = 0;
    }
    localObject = new PlayInfoForReport();
    long l1;
    if (paramBoolean) {
      l1 = paramVideoPlayParam.h.I();
    } else {
      l1 = paramVideoPlayParam.h.C();
    }
    ((PlayInfoForReport)localObject).b = l1;
    ((PlayInfoForReport)localObject).a = paramVideoPlayParam.h.d(paramBoolean);
    this.l.add(localObject);
    List localList = (List)new ArrayList((Collection)this.l);
    this.l.clear();
    BaseVideoItemHolder localBaseVideoItemHolder = this.b;
    localObject = localBaseVideoItemHolder;
    if (!(localBaseVideoItemHolder instanceof ShortVideoItemHolder)) {
      localObject = null;
    }
    localObject = (ShortVideoItemHolder)localObject;
    if (localObject != null)
    {
      localObject = ((ShortVideoItemHolder)localObject).k;
      if ((localObject != null) && (((TextView)localObject).getVisibility() == 0))
      {
        bool = true;
        break label210;
      }
    }
    boolean bool = false;
    label210:
    if (localVideoInfo != null) {
      ThreadManager.excute((Runnable)new VideoFeedsRecommendPresenter.onVideoStop..inlined.let.lambda.1(localVideoInfo, this, paramVideoPlayParam, localList, l2, i1, bool), 16, null, true);
    }
    c(paramVideoPlayParam, paramBoolean);
  }
  
  public void a(@NotNull VideoItemHolder paramVideoItemHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoItemHolder, "videoHolder");
    Object localObject1 = paramVideoItemHolder.aT;
    Object localObject2 = paramVideoItemHolder.az;
    if (localObject2 != null)
    {
      localObject2 = ((VideoPlayParam)localObject2).c;
      if (localObject2 != null)
      {
        i1 = ((VideoInfo)localObject2).an;
        break label47;
      }
    }
    int i1 = 0;
    label47:
    VideoFeedsHelper.b((TextView)localObject1, i1, "赞");
    localObject1 = this.y;
    localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((VideoFeedsAdapter)localObject1).l;
    } else {
      localObject1 = null;
    }
    VideoFeedsAdapter localVideoFeedsAdapter;
    if (localObject1 == null)
    {
      localObject1 = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject1).setDuration(200L);
      ((ScaleAnimation)localObject1).setRepeatCount(1);
      ((ScaleAnimation)localObject1).setRepeatMode(2);
      ((ScaleAnimation)localObject1).setInterpolator((Interpolator)new DecelerateInterpolator());
      localVideoFeedsAdapter = this.y;
      if (localVideoFeedsAdapter != null) {
        localVideoFeedsAdapter.l = ((Animation)localObject1);
      }
    }
    localObject1 = this.y;
    if (localObject1 != null)
    {
      localObject1 = ((VideoFeedsAdapter)localObject1).l;
      if (localObject1 != null) {
        ((Animation)localObject1).setAnimationListener((Animation.AnimationListener)new VideoFeedsRecommendPresenter.onDianZanClick.1(this, paramVideoItemHolder, paramInt));
      }
    }
    localObject1 = paramVideoItemHolder.aS;
    if (localObject1 != null)
    {
      localVideoFeedsAdapter = this.y;
      paramVideoItemHolder = (VideoItemHolder)localObject2;
      if (localVideoFeedsAdapter != null) {
        paramVideoItemHolder = localVideoFeedsAdapter.l;
      }
      ((ImageView)localObject1).startAnimation(paramVideoItemHolder);
    }
  }
  
  public final void a(@NotNull RIJFeedsInsertAction paramRIJFeedsInsertAction)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFeedsInsertAction, "action");
    if (q())
    {
      RIJFeedsDynamicInsertController localRIJFeedsDynamicInsertController = RIJFeedsDynamicInsertController.INSTANCE;
      Object localObject = this.e;
      if (localObject != null) {
        localObject = ((VideoInfo)localObject).l;
      } else {
        localObject = null;
      }
      localRIJFeedsDynamicInsertController.requestInsertArticlesAndRecordAction((String)localObject, paramRIJFeedsInsertAction, 6);
    }
  }
  
  public final void a(@NotNull ArrayList<VideoInfo> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "list");
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(new ExposureArticle(((VideoInfo)paramArrayList.next()).l, false, 2, null));
    }
    RIJFeedsDynamicInsertController.INSTANCE.deleteArticle((List)localArrayList);
  }
  
  @Nullable
  public final VideoPlayParam b()
  {
    return this.d;
  }
  
  public void b(@NotNull RecyclerView.ViewHolder paramViewHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
  }
  
  public void b(@Nullable VideoPlayParam paramVideoPlayParam)
  {
    h(paramVideoPlayParam);
  }
  
  public void b(@Nullable VideoPlayParam paramVideoPlayParam, boolean paramBoolean) {}
  
  public void c(@NotNull VideoPlayParam paramVideoPlayParam)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
    BaseVideoItemHolder localBaseVideoItemHolder = this.c;
    if (localBaseVideoItemHolder != null)
    {
      IVideoAdExposureManager localIVideoAdExposureManager = this.n;
      if ((localIVideoAdExposureManager != null) && (localIVideoAdExposureManager != null)) {
        localIVideoAdExposureManager.a(localBaseVideoItemHolder.Z, paramVideoPlayParam, this.F);
      }
    }
    try
    {
      PublicAccountReportUtils.a(null, "", "0X800AF11", "0X800AF11", 0, 0, "", "", "", String.valueOf(System.currentTimeMillis()), false);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (!TextUtils.isEmpty((CharSequence)this.g))
    {
      IVideoPlayerWrapper localIVideoPlayerWrapper = paramVideoPlayParam.h;
      if (localIVideoPlayerWrapper != null) {
        localIVideoPlayerWrapper.b(this.g);
      }
      this.g = ((String)null);
    }
    if (paramVideoPlayParam.c != null) {
      BridgeModule.addRowkeyToConsumeMap(paramVideoPlayParam.c.l);
    }
  }
  
  public final boolean c()
  {
    return this.o;
  }
  
  public final int d()
  {
    return this.p;
  }
  
  public void d(@Nullable VideoPlayParam paramVideoPlayParam) {}
  
  public void e(@NotNull VideoPlayParam paramVideoPlayParam)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
  }
  
  public boolean e()
  {
    return this.t;
  }
  
  @NotNull
  public final VideoFeedsReporter f()
  {
    return this.v;
  }
  
  public void f(@NotNull VideoPlayParam paramVideoPlayParam)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
  }
  
  @Nullable
  public final VideoFeedsAdapter g()
  {
    return this.y;
  }
  
  public void g(@Nullable VideoPlayParam paramVideoPlayParam) {}
  
  public final void h()
  {
    Object localObject1 = this.c;
    Object localObject6 = null;
    Object localObject2;
    if ((localObject1 != null) && (localObject1 != null)) {
      localObject2 = ((BaseVideoItemHolder)localObject1).az;
    } else {
      localObject2 = null;
    }
    if (localObject2 != null) {
      localObject1 = ((VideoPlayParam)localObject2).h;
    } else {
      localObject1 = null;
    }
    boolean bool = false;
    int i1;
    if (localObject1 != null)
    {
      localObject1 = ((VideoPlayParam)localObject2).h;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "playParam.videoPlayer");
      i1 = ((IVideoPlayerWrapper)localObject1).h();
    }
    else
    {
      i1 = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handlePlayButtonClick() status()=");
      ((StringBuilder)localObject1).append(i1);
      QLog.d("VideoFeedsRecommendPresenter", 2, ((StringBuilder)localObject1).toString());
    }
    String str2;
    switch (i1)
    {
    default: 
      return;
    case 6: 
      if ((VideoFeedsRecommendPresenter.Companion.a(a, (VideoPlayParam)localObject2)) && (localObject2 != null))
      {
        localObject1 = ((VideoPlayParam)localObject2).f;
        if (localObject1 != null) {
          ((ReadinjoyAdVideoReportData)localObject1).f = false;
        }
      }
      w().c((VideoPlayParam)localObject2);
      w().a((VideoPlayParam)localObject2, true);
      return;
    case 5: 
      if ((VideoFeedsRecommendPresenter.Companion.a(a, (VideoPlayParam)localObject2)) && (localObject2 != null))
      {
        localObject1 = ((VideoPlayParam)localObject2).f;
        if (localObject1 != null) {
          ((ReadinjoyAdVideoReportData)localObject1).f = false;
        }
      }
      if (localObject2 != null) {
        bool = ((VideoPlayParam)localObject2).a("continue_pause", false);
      }
      if (!bool)
      {
        w().h();
        return;
      }
      break;
    case 4: 
      w().g();
      return;
    case 3: 
      if (localObject2 != null)
      {
        localObject1 = ((VideoPlayParam)localObject2).c;
        if (localObject1 != null)
        {
          str2 = ((VideoInfo)localObject1).l();
          break label330;
        }
      }
      str2 = null;
      label330:
      if (localObject2 == null) {
        break label710;
      }
    }
    String str3;
    label384:
    label422:
    Object localObject3;
    label449:
    Object localObject4;
    try
    {
      localObject1 = ((VideoPlayParam)localObject2).c;
      if (localObject1 == null) {
        break label710;
      }
      str3 = ((VideoInfo)localObject1).q;
      if (localObject2 == null) {
        break label716;
      }
      localObject1 = ((VideoPlayParam)localObject2).c;
      if (localObject1 == null) {
        break label716;
      }
      localObject1 = ((VideoInfo)localObject1).l;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label728;
      }
      if (localObject2 == null) {
        break label722;
      }
      localObject1 = ((VideoPlayParam)localObject2).c;
      if (localObject1 == null) {
        break label722;
      }
      localObject1 = ((VideoInfo)localObject1).l;
    }
    catch (Exception localException)
    {
      label476:
      Object localObject5;
      VideoInfo localVideoInfo;
      long l1;
      label602:
      break label602;
    }
    if (localObject2 != null)
    {
      localObject3 = ((VideoPlayParam)localObject2).c;
      if (localObject3 != null)
      {
        localObject3 = ((VideoInfo)localObject3).q;
        if (localObject2 == null) {
          break label742;
        }
        localObject4 = ((VideoPlayParam)localObject2).c;
        if (localObject4 == null) {
          break label742;
        }
        localObject4 = ((VideoInfo)localObject4).b;
        localObject5 = localObject6;
        if (localObject2 != null)
        {
          localVideoInfo = ((VideoPlayParam)localObject2).c;
          localObject5 = localObject6;
          if (localVideoInfo != null) {
            localObject5 = localVideoInfo.l;
          }
        }
        l1 = w().b();
        if (localObject2 == null) {
          break label748;
        }
        localObject2 = ((VideoPlayParam)localObject2).c;
        if (localObject2 == null) {
          break label748;
        }
        i1 = ((VideoInfo)localObject2).k();
      }
    }
    for (;;)
    {
      long l2 = i1;
      PublicAccountReportUtils.a(null, str3, "0X800740D", "0X800740D", 0, 0, "", "", (String)localObject1, VideoReporter.a(str2, (String)localObject3, (String)localObject4, (String)localObject5, l1, 1000 * l2, new JSONObject().put("video_type", 0)), false);
      w().g();
      return;
      if ((VideoFeedsRecommendPresenter.Companion.a(a, (VideoPlayParam)localObject2)) && (localObject2 != null))
      {
        localObject1 = ((VideoPlayParam)localObject2).f;
        if (localObject1 != null) {
          ((ReadinjoyAdVideoReportData)localObject1).f = false;
        }
      }
      w().f();
      return;
      w().g();
      return;
      if ((VideoFeedsRecommendPresenter.Companion.a(a, (VideoPlayParam)localObject2)) && (localObject2 != null))
      {
        localObject1 = ((VideoPlayParam)localObject2).f;
        if (localObject1 != null) {
          ((ReadinjoyAdVideoReportData)localObject1).f = false;
        }
      }
      w().a((VideoPlayParam)localObject2, false);
      return;
      label710:
      str3 = null;
      break;
      label716:
      String str1 = null;
      break label384;
      label722:
      str1 = null;
      break label422;
      label728:
      str1 = "0";
      break label422;
      localObject3 = null;
      break label449;
      label742:
      localObject4 = null;
      break label476;
      label748:
      i1 = 0;
    }
  }
  
  public final void i()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.z);
    C();
    B();
    a((Activity)null);
    this.C = ((QQAppInterface)null);
  }
  
  public final void j()
  {
    this.p = 0;
    w().a(H[0]);
    Object localObject = this.c;
    if ((localObject != null) && (localObject != null))
    {
      localObject = ((BaseVideoItemHolder)localObject).aA;
      if (localObject != null) {
        ((IVideoFeedsItemUIDelegate)localObject).b(I[this.p]);
      }
    }
  }
  
  public final void k()
  {
    if (this.c != null)
    {
      int i1 = this.p;
      if (i1 >= H.length - 1) {
        i1 = 0;
      } else {
        i1 += 1;
      }
      float f1 = H[i1];
      this.p = i1;
      w().a(f1);
      Object localObject = this.c;
      if (localObject != null)
      {
        localObject = ((BaseVideoItemHolder)localObject).aA;
        if (localObject != null) {
          ((IVideoFeedsItemUIDelegate)localObject).b(I[this.p]);
        }
      }
    }
  }
  
  public final void l()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(this.z);
  }
  
  public final void m()
  {
    if (this.r > 0L) {
      this.s += System.currentTimeMillis() - this.r;
    }
    this.r = 0L;
  }
  
  public final void n()
  {
    this.r = System.currentTimeMillis();
    D();
  }
  
  public void o() {}
  
  public void p()
  {
    this.v.e();
  }
  
  public final boolean q()
  {
    BaseVideoItemHolder localBaseVideoItemHolder = this.c;
    return (localBaseVideoItemHolder != null) && (localBaseVideoItemHolder.Y == 0) && (this.G == 3);
  }
  
  public int r()
  {
    if ((v() != null) && ((v() instanceof VideoFeedsPlayActivity)))
    {
      Object localObject = v();
      if (localObject != null)
      {
        if (((VideoFeedsPlayActivity)localObject).g() != null)
        {
          localObject = v();
          if (localObject != null)
          {
            localObject = ((VideoFeedsPlayActivity)localObject).g();
            Intrinsics.checkExpressionValueIsNotNull(localObject, "(activity as VideoFeedsPlayActivity).menuLayout");
            return ((ViewGroup)localObject).getMeasuredHeight();
          }
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity");
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity");
      }
    }
    return 0;
  }
  
  @NotNull
  public Object s()
  {
    return this.v;
  }
  
  public boolean t()
  {
    return this.u;
  }
  
  @Nullable
  public BaseVideoItemHolder u()
  {
    return this.c;
  }
  
  @Nullable
  public Activity v()
  {
    return this.A;
  }
  
  @NotNull
  public VideoFeedsPlayManager w()
  {
    return this.D;
  }
  
  public final boolean y()
  {
    return this.E;
  }
  
  public final int z()
  {
    return this.G;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendPresenter
 * JD-Core Version:    0.7.0.1
 */
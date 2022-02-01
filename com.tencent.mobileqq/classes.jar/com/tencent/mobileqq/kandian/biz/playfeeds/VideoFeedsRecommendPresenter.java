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
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertConfig;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.feeds.entity.ExposureArticle;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
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
  public static final VideoFeedsRecommendPresenter.Companion a;
  @NotNull
  private static final float[] jdField_a_of_type_ArrayOfFloat = { 1.0F, 1.5F, 2.0F };
  @NotNull
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130849929, 2130849928, 2130849930 };
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  @Nullable
  private Activity jdField_a_of_type_AndroidAppActivity;
  @NotNull
  private final Bundle jdField_a_of_type_AndroidOsBundle;
  @NotNull
  private final Handler jdField_a_of_type_AndroidOsHandler;
  @Nullable
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IVideoAdExposureManager jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager;
  @Nullable
  private VideoFeedsAdapter jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
  @NotNull
  private final VideoFeedsPlayManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
  private VideoFeedsRecommendManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager;
  @NotNull
  private final VideoFeedsReporter jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter;
  @Nullable
  private VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  @Nullable
  private VideoPlayParam jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
  private BaseVideoItemHolder jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
  private final ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver;
  private String jdField_a_of_type_JavaLangString;
  private final ArrayList<PlayInfoForReport> jdField_a_of_type_JavaUtilArrayList;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  @NotNull
  private final VideoInfo jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  @Nullable
  private BaseVideoItemHolder jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
  @NotNull
  private final ArrayList<VideoInfo> jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private final boolean jdField_d_of_type_Boolean;
  private final int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private final int jdField_f_of_type_Int;
  private final boolean jdField_f_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter$Companion = new VideoFeedsRecommendPresenter.Companion(null);
  }
  
  public VideoFeedsRecommendPresenter(@Nullable Activity paramActivity, @NotNull Bundle paramBundle, @Nullable QQAppInterface paramQQAppInterface, @NotNull VideoFeedsPlayManager paramVideoFeedsPlayManager, @NotNull VideoFeedsRecyclerView paramVideoFeedsRecyclerView, boolean paramBoolean, @NotNull ArrayList<VideoInfo> paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_f_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_f_of_type_Int = paramInt;
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramInt = CUKingCardHelper.a();
    int i = 0;
    if (paramInt == 1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = ((ReadInJoyObserver)new VideoFeedsRecommendPresenter.onColumnActionObserver.1(this));
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    a().a((VideoFeedsPlayManager.VideoStatusListener)this);
    paramVideoFeedsRecyclerView.a((ListEventListener)this);
    paramActivity = this.jdField_b_of_type_JavaUtilArrayList.get(0);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "videoDataList[0]");
    this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = ((VideoInfo)paramActivity);
    this.jdField_a_of_type_Int = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getKanDianMode();
    this.jdField_b_of_type_Int = VideoReporter.a();
    paramActivity = a();
    paramInt = i;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getIntent();
      paramInt = i;
      if (paramActivity != null) {
        paramInt = paramActivity.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
    }
    this.jdField_a_of_type_Boolean = ReadInJoyHelper.b();
    if ((paramInt == 4) || (paramInt == 5) || (paramInt == 2) || (paramInt == 1)) {
      this.jdField_a_of_type_Int = 5;
    }
    try
    {
      paramActivity = a();
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
      label317:
      break label317;
    }
    paramActivity = a();
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getIntent();
      if (paramActivity != null)
      {
        paramActivity = paramActivity.getStringExtra("video_player_session_id");
        break label348;
      }
    }
    paramActivity = null;
    label348:
    this.jdField_a_of_type_JavaLangString = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter = new VideoFeedsReporter(a(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this);
    this.jdField_e_of_type_Int = RIJFeedsDynamicInsertConfig.a.a(6);
    ThreadManager.excute((Runnable)new VideoFeedsRecommendPresenter.1(this), 16, null, true);
  }
  
  private final void c(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramVideoPlayParam != null) {
      localObject1 = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    } else {
      localObject1 = null;
    }
    if ((localObject1 instanceof VideoPlayerWrapper))
    {
      localObject1 = localObject2;
      if (paramVideoPlayParam != null) {
        localObject1 = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
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
      localObject1 = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return;
    }
    Object localObject1 = paramVideoPlayParam.jdField_a_of_type_AndroidOsBundle;
    int j = 1;
    boolean bool = ((Bundle)localObject1).getBoolean("is_auto_play", true);
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.r) {
      i = 1;
    } else {
      i = 2;
    }
    localObject1 = VideoDTReport.Builder.a(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).a("6").b(i).a(paramVideoPlayParam.jdField_a_of_type_AndroidOsBundle.getInt("video_feeds_index", -1)).b(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.b());
    Object localObject2 = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "playParam.videoPlayer");
    localObject1 = ((VideoDTReport.Builder)localObject1).d(((IVideoPlayerWrapper)localObject2).a()).a(bool);
    int i = j;
    if (this.jdField_f_of_type_Boolean) {
      i = 2;
    }
    localObject1 = ((VideoDTReport.Builder)localObject1).d(i);
    if ((paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper instanceof VideoPlayerWrapper))
    {
      localObject2 = a();
      paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
      if (paramVideoPlayParam != null)
      {
        VideoDTReport.a(localObject2, (VideoPlayerWrapper)paramVideoPlayParam, (VideoDTReport.Builder)localObject1);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper");
    }
  }
  
  private final void j()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent();
      if (localObject != null)
      {
        i = ((Intent)localObject).getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        break label32;
      }
    }
    int i = 0;
    label32:
    localObject = a();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent();
      if (localObject != null)
      {
        j = ((Intent)localObject).getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        break label64;
      }
    }
    int j = 0;
    label64:
    localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g;
    String str = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.j;
    VideoR5.Builder localBuilder = new VideoR5.Builder(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
    localBuilder.M(0).X(i).p((String)localObject);
    try
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, str, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(j), "", (String)localObject, localBuilder.a().a(), false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private final void k()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      this.jdField_b_of_type_Long += System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = new VideoR5.Builder(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).M(0);
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        Object localObject2 = null;
        if (localObject1 != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
          if (localObject1 != null)
          {
            localObject1 = ((VideoInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo;
            localObject3 = ((VideoR5.Builder)localObject3).b((VideoColumnInfo)localObject1).b(this.jdField_b_of_type_Long).u(this.jdField_f_of_type_Int);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (localObject1 == null) {
              break label205;
            }
            localObject1 = ((QQAppInterface)localObject1).getCurrentUin();
            localObject3 = ((VideoR5.Builder)localObject3).n((String)localObject1).a();
            IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
            AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo == null) {
              break label210;
            }
            VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
            localObject1 = localObject2;
            if (localVideoInfo != null) {
              localObject1 = localVideoInfo.j;
            }
            localIPublicAccountReportUtils.publicAccountReportClickEvent(localAppInterface, (String)localObject1, "0X800AF2E", "0X800AF2E", 0, 0, "", "", "", ((VideoR5)localObject3).a(), false);
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
      label205:
      str = null;
      continue;
      label210:
      str = "";
    }
  }
  
  private final void l()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    VideoR5.Builder localBuilder;
    if (localObject1 != null)
    {
      localBuilder = new VideoR5.Builder((VideoInfo)localObject1);
      localBuilder.P(this.jdField_c_of_type_Int);
    }
    for (;;)
    {
      try
      {
        IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        if (localObject1 == null) {
          break label104;
        }
        localObject1 = ((VideoInfo)localObject1).j;
        localIPublicAccountReportUtils.publicAccountReportClickEvent(localAppInterface, (String)localObject1, "0X8009B79", "0X8009B79", 0, 0, "", "", "", localBuilder.a().a(), false);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label104:
      Object localObject2 = null;
    }
  }
  
  private final void m()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder != null) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = false;
      ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
      VideoFeedsPlayManager localVideoFeedsPlayManager = a();
      Object localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
      if (localObject != null) {
        localObject = ((BaseVideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      } else {
        localObject = null;
      }
      localVideoFeedsPlayManager.a((VideoPlayParam)localObject, false);
    }
  }
  
  public final int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  @Nullable
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  @Nullable
  public final VideoFeedsAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
  }
  
  @NotNull
  public VideoFeedsPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
  }
  
  @NotNull
  public final VideoFeedsReporter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter;
  }
  
  @Nullable
  public final VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
  }
  
  @Nullable
  public final BaseVideoItemHolder a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
  }
  
  @NotNull
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter;
  }
  
  public final void a()
  {
    Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    Object localObject6 = null;
    Object localObject2;
    if ((localObject1 != null) && (localObject1 != null)) {
      localObject2 = ((BaseVideoItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    } else {
      localObject2 = null;
    }
    if (localObject2 != null) {
      localObject1 = ((VideoPlayParam)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    } else {
      localObject1 = null;
    }
    boolean bool = false;
    if (localObject1 != null)
    {
      localObject1 = ((VideoPlayParam)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "playParam.videoPlayer");
      i = ((IVideoPlayerWrapper)localObject1).b();
    }
    else
    {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handlePlayButtonClick() status()=");
      ((StringBuilder)localObject1).append(i);
      QLog.d("VideoFeedsRecommendPresenter", 2, ((StringBuilder)localObject1).toString());
    }
    String str2;
    switch (i)
    {
    default: 
      return;
    case 6: 
      if ((VideoFeedsRecommendPresenter.Companion.a(jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter$Companion, (VideoPlayParam)localObject2)) && (localObject2 != null))
      {
        localObject1 = ((VideoPlayParam)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData;
        if (localObject1 != null) {
          ((ReadinjoyAdVideoReportData)localObject1).jdField_a_of_type_Boolean = false;
        }
      }
      a().c((VideoPlayParam)localObject2);
      a().a((VideoPlayParam)localObject2, true);
      return;
    case 5: 
      if ((VideoFeedsRecommendPresenter.Companion.a(jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter$Companion, (VideoPlayParam)localObject2)) && (localObject2 != null))
      {
        localObject1 = ((VideoPlayParam)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData;
        if (localObject1 != null) {
          ((ReadinjoyAdVideoReportData)localObject1).jdField_a_of_type_Boolean = false;
        }
      }
      if (localObject2 != null) {
        bool = ((VideoPlayParam)localObject2).a("continue_pause", false);
      }
      if (!bool)
      {
        a().c();
        return;
      }
      break;
    case 4: 
      a().b();
      return;
    case 3: 
      if (localObject2 != null)
      {
        localObject1 = ((VideoPlayParam)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        if (localObject1 != null)
        {
          str2 = ((VideoInfo)localObject1).d();
          break;
        }
      }
      str2 = null;
    }
    try
    {
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      if (localObject2 == null) {
        break label725;
      }
      localObject1 = ((VideoPlayParam)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (localObject1 == null) {
        break label725;
      }
      str3 = ((VideoInfo)localObject1).j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IPublicAccountReportUtils localIPublicAccountReportUtils;
        Object localObject5;
        VideoInfo localVideoInfo;
        long l1;
        long l2;
        continue;
        String str3 = null;
        continue;
        String str1 = null;
        continue;
        str1 = null;
        continue;
        str1 = "0";
        continue;
        Object localObject3 = null;
        continue;
        Object localObject4 = null;
        continue;
        i = 0;
      }
    }
    if (localObject2 != null)
    {
      localObject1 = ((VideoPlayParam)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (localObject1 != null)
      {
        localObject1 = ((VideoInfo)localObject1).g;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label743;
        }
        if (localObject2 == null) {
          break label737;
        }
        localObject1 = ((VideoPlayParam)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        if (localObject1 == null) {
          break label737;
        }
        localObject1 = ((VideoInfo)localObject1).g;
        break label748;
        if (localObject2 == null) {
          break label751;
        }
        localObject3 = ((VideoPlayParam)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        if (localObject3 == null) {
          break label751;
        }
        localObject3 = ((VideoInfo)localObject3).j;
        if (localObject2 == null) {
          break label757;
        }
        localObject4 = ((VideoPlayParam)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        if (localObject4 == null) {
          break label757;
        }
        localObject4 = ((VideoInfo)localObject4).jdField_a_of_type_JavaLangString;
        localObject5 = localObject6;
        if (localObject2 != null)
        {
          localVideoInfo = ((VideoPlayParam)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
          localObject5 = localObject6;
          if (localVideoInfo != null) {
            localObject5 = localVideoInfo.g;
          }
        }
        l1 = a().a();
        if (localObject2 == null) {
          break label763;
        }
        localObject2 = ((VideoPlayParam)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        if (localObject2 == null) {
          break label763;
        }
        i = ((VideoInfo)localObject2).c();
        l2 = i;
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str3, "0X800740D", "0X800740D", 0, 0, "", "", (String)localObject1, VideoReporter.a(str2, (String)localObject3, (String)localObject4, (String)localObject5, l1, 1000 * l2, new JSONObject().put("video_type", 0)), false);
        a().b();
        return;
        if ((VideoFeedsRecommendPresenter.Companion.a(jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter$Companion, (VideoPlayParam)localObject2)) && (localObject2 != null))
        {
          localObject1 = ((VideoPlayParam)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData;
          if (localObject1 != null) {
            ((ReadinjoyAdVideoReportData)localObject1).jdField_a_of_type_Boolean = false;
          }
        }
        a().a();
        return;
        a().b();
        return;
        if ((VideoFeedsRecommendPresenter.Companion.a(jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter$Companion, (VideoPlayParam)localObject2)) && (localObject2 != null))
        {
          localObject1 = ((VideoPlayParam)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData;
          if (localObject1 != null) {
            ((ReadinjoyAdVideoReportData)localObject1).jdField_a_of_type_Boolean = false;
          }
        }
        a().a((VideoPlayParam)localObject2, false);
        return;
      }
    }
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    if ((c()) && (!this.jdField_e_of_type_Boolean) && (paramLong1 >= this.jdField_e_of_type_Int))
    {
      RIJFeedsDynamicInsertController localRIJFeedsDynamicInsertController = RIJFeedsDynamicInsertController.INSTANCE;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (localObject != null) {
        localObject = ((VideoInfo)localObject).g;
      } else {
        localObject = null;
      }
      localRIJFeedsDynamicInsertController.requestInsertArticlesAndRecordAction((String)localObject, new RIJFeedsInsertAction(ActionType.ACTION_NONE, 0, 0, 0, 14, null), 6);
      this.jdField_e_of_type_Boolean = true;
    }
  }
  
  public void a(@Nullable Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(@NotNull RecyclerView.ViewHolder paramViewHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    boolean bool = paramViewHolder instanceof BaseVideoItemHolder;
    BaseVideoItemHolder localBaseVideoItemHolder = null;
    if (bool)
    {
      this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder = ((BaseVideoItemHolder)paramViewHolder);
      paramViewHolder = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
      if (paramViewHolder != null) {
        paramViewHolder = paramViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      } else {
        paramViewHolder = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam = paramViewHolder;
      VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      paramViewHolder = localBaseVideoItemHolder;
      if (localVideoPlayParam != null) {
        paramViewHolder = localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramViewHolder;
      paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      if (paramViewHolder != null)
      {
        paramViewHolder = paramViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
        if (paramViewHolder != null) {
          paramViewHolder.i();
        }
      }
    }
    else
    {
      this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder = ((BaseVideoItemHolder)null);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam = ((VideoPlayParam)null);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = ((VideoInfo)null);
    }
    paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    if (paramViewHolder != null)
    {
      localBaseVideoItemHolder = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
      if ((localBaseVideoItemHolder != null) && (paramViewHolder != null) && (localBaseVideoItemHolder != null) && (paramViewHolder.jdField_c_of_type_Int > localBaseVideoItemHolder.jdField_c_of_type_Int)) {
        this.jdField_c_of_type_Int += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder);
    d();
  }
  
  public void a(@NotNull RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public final void a(@Nullable IVideoAdExposureManager paramIVideoAdExposureManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager = paramIVideoAdExposureManager;
  }
  
  public final void a(@Nullable VideoFeedsAdapter paramVideoFeedsAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter = paramVideoFeedsAdapter;
  }
  
  public final void a(@Nullable VideoFeedsRecommendManager paramVideoFeedsRecommendManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager = paramVideoFeedsRecommendManager;
  }
  
  public void a(@Nullable VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter.a(paramVideoPlayParam);
  }
  
  public void a(@NotNull VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper != null)
    {
      Object localObject = new PlayInfoForReport();
      ((PlayInfoForReport)localObject).jdField_a_of_type_Long = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.a(true);
      ((PlayInfoForReport)localObject).jdField_b_of_type_Long = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.b();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mPlayInfoListForReport add detailInfo.totalPlayTime = ");
        localStringBuilder.append(((PlayInfoForReport)localObject).jdField_a_of_type_Long);
        localStringBuilder.append(", detailInfo.currentPlayTime = ");
        localStringBuilder.append(((PlayInfoForReport)localObject).jdField_b_of_type_Long);
        QLog.d("VideoFeedsRecommendPresenter", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      if ((VideoFeedsRecommendPresenter.Companion.a(jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter$Companion, paramVideoPlayParam)) && (this.jdField_f_of_type_Boolean) && (a() != null)) {
        ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).reportVideoReplayOnLoop(paramVideoPlayParam, (Context)a(), paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper);
      }
      localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
      if (localObject != null)
      {
        paramInt = ((BaseVideoItemHolder)localObject).jdField_c_of_type_Int;
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager;
        if (localObject != null) {
          ((IVideoAdExposureManager)localObject).b(paramInt, paramVideoPlayParam, this.jdField_b_of_type_JavaUtilArrayList);
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
    if (a() == null) {
      return;
    }
    VideoInfo localVideoInfo = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    long l2 = a().d();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    int i;
    if (localObject != null) {
      i = ((BaseVideoItemHolder)localObject).jdField_c_of_type_Int;
    } else {
      i = 0;
    }
    localObject = new PlayInfoForReport();
    long l1;
    if (paramBoolean) {
      l1 = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.b();
    } else {
      l1 = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.a();
    }
    ((PlayInfoForReport)localObject).jdField_b_of_type_Long = l1;
    ((PlayInfoForReport)localObject).jdField_a_of_type_Long = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.a(paramBoolean);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    List localList = (List)new ArrayList((Collection)this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    BaseVideoItemHolder localBaseVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    localObject = localBaseVideoItemHolder;
    if (!(localBaseVideoItemHolder instanceof ShortVideoItemHolder)) {
      localObject = null;
    }
    localObject = (ShortVideoItemHolder)localObject;
    if (localObject != null)
    {
      localObject = ((ShortVideoItemHolder)localObject).d;
      if ((localObject != null) && (((TextView)localObject).getVisibility() == 0))
      {
        bool = true;
        break label210;
      }
    }
    boolean bool = false;
    label210:
    if (localVideoInfo != null) {
      ThreadManager.excute((Runnable)new VideoFeedsRecommendPresenter.onVideoStop..inlined.let.lambda.1(localVideoInfo, this, paramVideoPlayParam, localList, l2, i, bool), 16, null, true);
    }
    c(paramVideoPlayParam, paramBoolean);
  }
  
  public void a(@NotNull VideoItemHolder paramVideoItemHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoItemHolder, "videoHolder");
    Object localObject1 = paramVideoItemHolder.x;
    Object localObject2 = paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if (localObject2 != null)
    {
      localObject2 = ((VideoPlayParam)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (localObject2 != null)
      {
        i = ((VideoInfo)localObject2).s;
        break label47;
      }
    }
    int i = 0;
    label47:
    VideoFeedsHelper.b((TextView)localObject1, i, "赞");
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
    localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((VideoFeedsAdapter)localObject1).a;
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
      localVideoFeedsAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
      if (localVideoFeedsAdapter != null) {
        localVideoFeedsAdapter.a = ((Animation)localObject1);
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
    if (localObject1 != null)
    {
      localObject1 = ((VideoFeedsAdapter)localObject1).a;
      if (localObject1 != null) {
        ((Animation)localObject1).setAnimationListener((Animation.AnimationListener)new VideoFeedsRecommendPresenter.onDianZanClick.1(this, paramVideoItemHolder, paramInt));
      }
    }
    localObject1 = paramVideoItemHolder.m;
    if (localObject1 != null)
    {
      localVideoFeedsAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
      paramVideoItemHolder = (VideoItemHolder)localObject2;
      if (localVideoFeedsAdapter != null) {
        paramVideoItemHolder = localVideoFeedsAdapter.a;
      }
      ((ImageView)localObject1).startAnimation(paramVideoItemHolder);
    }
  }
  
  public final void a(@NotNull RIJFeedsInsertAction paramRIJFeedsInsertAction)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFeedsInsertAction, "action");
    if (c())
    {
      RIJFeedsDynamicInsertController localRIJFeedsDynamicInsertController = RIJFeedsDynamicInsertController.INSTANCE;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (localObject != null) {
        localObject = ((VideoInfo)localObject).g;
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
      localArrayList.add(new ExposureArticle(((VideoInfo)paramArrayList.next()).g, false, 2, null));
    }
    RIJFeedsDynamicInsertController.INSTANCE.deleteArticle((List)localArrayList);
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void aC_() {}
  
  public int b()
  {
    if ((a() != null) && ((a() instanceof VideoFeedsPlayActivity)))
    {
      Object localObject = a();
      if (localObject != null)
      {
        if (((VideoFeedsPlayActivity)localObject).a() != null)
        {
          localObject = a();
          if (localObject != null)
          {
            localObject = ((VideoFeedsPlayActivity)localObject).a();
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
  
  @Nullable
  public BaseVideoItemHolder b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
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
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public final int c()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public final void c()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    l();
    k();
    a((Activity)null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)null);
  }
  
  public void c(@NotNull VideoPlayParam paramVideoPlayParam)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
    BaseVideoItemHolder localBaseVideoItemHolder = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    if (localBaseVideoItemHolder != null)
    {
      IVideoAdExposureManager localIVideoAdExposureManager = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager;
      if ((localIVideoAdExposureManager != null) && (localIVideoAdExposureManager != null)) {
        localIVideoAdExposureManager.a(localBaseVideoItemHolder.jdField_c_of_type_Int, paramVideoPlayParam, this.jdField_b_of_type_JavaUtilArrayList);
      }
    }
    try
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800AF11", "0X800AF11", 0, 0, "", "", "", String.valueOf(System.currentTimeMillis()), false);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaLangString))
    {
      IVideoPlayerWrapper localIVideoPlayerWrapper = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
      if (localIVideoPlayerWrapper != null) {
        localIVideoPlayerWrapper.b(this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_JavaLangString = ((String)null);
    }
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) {
      BridgeModule.addRowkeyToConsumeMap(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g);
    }
  }
  
  public final boolean c()
  {
    BaseVideoItemHolder localBaseVideoItemHolder = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    return (localBaseVideoItemHolder != null) && (localBaseVideoItemHolder.jdField_b_of_type_Int == 0) && (this.jdField_f_of_type_Int == 3);
  }
  
  public final void d()
  {
    this.jdField_d_of_type_Int = 0;
    a().a(jdField_a_of_type_ArrayOfFloat[0]);
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    if ((localObject != null) && (localObject != null))
    {
      localObject = ((BaseVideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate;
      if (localObject != null) {
        ((IVideoFeedsItemUIDelegate)localObject).b(jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
      }
    }
  }
  
  public void d(@Nullable VideoPlayParam paramVideoPlayParam) {}
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public final void e()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder != null)
    {
      int i = this.jdField_d_of_type_Int;
      if (i >= jdField_a_of_type_ArrayOfFloat.length - 1) {
        i = 0;
      } else {
        i += 1;
      }
      float f1 = jdField_a_of_type_ArrayOfFloat[i];
      this.jdField_d_of_type_Int = i;
      a().a(f1);
      Object localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
      if (localObject != null)
      {
        localObject = ((BaseVideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate;
        if (localObject != null) {
          ((IVideoFeedsItemUIDelegate)localObject).b(jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
        }
      }
    }
  }
  
  public void e(@NotNull VideoPlayParam paramVideoPlayParam)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
  }
  
  public final boolean e()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public final void f()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void f(@NotNull VideoPlayParam paramVideoPlayParam)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoPlayParam, "playParam");
  }
  
  public final void g()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      this.jdField_b_of_type_Long += System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void g(@Nullable VideoPlayParam paramVideoPlayParam) {}
  
  public final void h()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    m();
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendPresenter
 * JD-Core Version:    0.7.0.1
 */
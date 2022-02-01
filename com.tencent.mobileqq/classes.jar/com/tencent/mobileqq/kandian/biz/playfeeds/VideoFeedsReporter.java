package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsFollowButton;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.LocationInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.glue.video.report.PlayInfoForReport;
import com.tencent.mobileqq.kandian.glue.video.report.VideoDTReport;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.MultiVideoConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.RichTitleInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsReporter;", "", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "firstVideoInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "presenter", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsRecommendPresenter;", "(Landroid/app/Activity;Landroid/os/Bundle;Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsRecommendPresenter;)V", "autoSeekBarDragTimes", "", "exposeVidSet", "Ljava/util/HashSet;", "", "firstVideoExposureR5", "Lcom/tencent/mobileqq/kandian/glue/video/report/VideoR5$Builder;", "fromType", "isReplayFromVideoChannel", "", "isTiktokStyle", "isWeiShiMode", "kandianMode", "kandianModeNew", "pageSessionId", "kotlin.jvm.PlatformType", "playingVideoHolder", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/BaseVideoItemHolder;", "playingVideoInfo", "sessionID", "videoChannelSessionID", "doColumnBannerExposeReport", "", "videoInfo", "doLocationExposeReport", "doReportOnCenterViewChanged", "holder", "isVideoRealChanged", "doReportOnVideoInitiate", "playParam", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoPlayParam;", "doReportOnVideoStop", "reportList", "", "Lcom/tencent/mobileqq/kandian/glue/video/report/PlayInfoForReport;", "reportData", "Lcom/tencent/mobileqq/kandian/base/video/player/data/ReadInJoyVideoReportData;", "duration", "", "recommendIndex", "isShowYourFollowed", "doRichTitleExposureReport", "doSpeedRatioBtnReport", "action", "innerDoReportOnCenterViewChanged", "position", "recommendPosition", "itemType", "isLiveAvatorShow", "isFollowBtnShow", "isShareBtnShow", "innerReportVideoExposure", "r5", "innerSeekBarDrag", "way", "onAutoSeekBarDrag", "onAutoSeekBarEndTouchUp", "onAutoSeekBarTouchOn", "onCenterViewChanged", "viewHolder", "onDestory", "onFollowBtnRerport", "isClick", "isFollowed", "onLiveAvatorExposue", "onLiveAvatorReport", "onSeekBaarDragEnd", "reportRewardBtnAction", "info", "reportShareBtnEvent", "iconType", "tryReportFirstVideoExposure", "updateDtReportInfo", "videoPlayer", "Lcom/tencent/mobileqq/kandian/base/video/player/VideoPlayerWrapper;", "videoReportInfo", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsReporter
{
  public static final VideoFeedsReporter.Companion a;
  private final int jdField_a_of_type_Int;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final VideoFeedsRecommendPresenter jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter;
  private VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  private BaseVideoItemHolder jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
  private VideoR5.Builder jdField_a_of_type_ComTencentMobileqqKandianGlueVideoReportVideoR5$Builder;
  private final String jdField_a_of_type_JavaLangString;
  private final HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  private final boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  private final VideoInfo jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  private final String jdField_b_of_type_JavaLangString;
  private final boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int;
  private final String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter$Companion = new VideoFeedsReporter.Companion(null);
  }
  
  public VideoFeedsReporter(@Nullable Activity paramActivity, @NotNull Bundle paramBundle, @NotNull VideoInfo paramVideoInfo, @NotNull VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter = paramVideoFeedsRecommendPresenter;
    this.jdField_b_of_type_Int = VideoReporter.a();
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("ARGS_SESSION_ID");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("ARGS_VIDEO_CHANNEL_SESSION_ID");
    this.jdField_a_of_type_Boolean = ReadInJoyHelper.b();
    this.jdField_c_of_type_Int = paramBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("ARGS_PAGE_SESSION_ID");
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    boolean bool2 = false;
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("KEY_IS_WEISHI_MODE", false);
    paramActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getIntent();
      if (paramActivity != null)
      {
        i = paramActivity.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        break label152;
      }
    }
    int i = 0;
    label152:
    int k = 5;
    int j = k;
    if (i != 4)
    {
      j = k;
      if (i != 5)
      {
        j = k;
        if (i != 2) {
          if (i == 1) {
            j = k;
          } else {
            j = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getKanDianMode();
          }
        }
      }
    }
    this.jdField_a_of_type_Int = j;
    long l = paramBundle.getLong("VIDEO_PLAY_POSITION", 0L);
    i = this.jdField_c_of_type_Int;
    if ((i != 2) && (i != 3) && (i != 6) && (i != 7)) {
      i = 0;
    } else {
      i = 1;
    }
    boolean bool1 = bool2;
    if (l > 0L)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
    }
    this.jdField_c_of_type_Boolean = bool1;
  }
  
  private final void a(int paramInt)
  {
    Object localObject = new VideoR5.Builder(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).a("video_progress_control_way", Integer.valueOf(paramInt));
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    if (localVideoInfo != null) {
      paramInt = localVideoInfo.jdField_d_of_type_Int;
    } else {
      paramInt = 0;
    }
    localObject = ((VideoR5.Builder)localObject).i(paramInt * 1000L).M(0).a();
    try
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B3D8", "0X800B3D8", 0, 0, "", "", "", ((VideoR5)localObject).a(), false);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    String str2 = paramVideoInfo.j;
    String str1 = paramVideoInfo.jdField_a_of_type_JavaLangString;
    Object localObject4 = paramVideoInfo.g;
    Object localObject5 = paramVideoInfo.d();
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity;
    if (localObject1 != null)
    {
      localObject1 = ((Activity)localObject1).getIntent();
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = new Intent();
    }
    int i = ((Intent)localObject1).getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    int j = ((Intent)localObject1).getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
    int k = ((Intent)localObject1).getIntExtra("RETURN_SCENE", 0);
    Object localObject2 = VideoAutoPlayController.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "VideoAutoPlayController.getInstance()");
    if (((VideoAutoPlayController)localObject2).isNeedNetWorkAlert()) {
      localObject2 = "1";
    } else {
      localObject2 = "0";
    }
    localObject5 = new VideoR5.Builder((String)localObject5, str2, str1, (String)localObject4).e(paramVideoInfo.f).c(paramVideoInfo.jdField_p_of_type_Int).c(this.jdField_a_of_type_JavaLangString).d(this.jdField_b_of_type_JavaLangString).g(i).a(409409).l(paramInt2).a(Boolean.valueOf(paramVideoInfo.jdField_b_of_type_Boolean)).a(paramVideoInfo.w).e(paramVideoInfo.r).q(this.jdField_b_of_type_Int).r(this.jdField_a_of_type_Int).J(paramVideoInfo.k).K(j).n(0).j(paramVideoInfo.i).o(paramVideoInfo.t).b(this.jdField_a_of_type_Boolean).ac(k).a(this.jdField_c_of_type_Int, this.jdField_c_of_type_JavaLangString).M(0);
    if (paramBoolean3) {
      try
      {
        IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          break label902;
        }
        String str3 = ((VideoR5.Builder)localObject5).a().a();
        try
        {
          localIPublicAccountReportUtils.videoDataReportWithFansInfoInR5(null, str2, "0X8007412", "0X8007412", 0, 0, String.valueOf(i), (String)localObject2, (String)localObject4, str3, false);
        }
        catch (Throwable localThrowable2) {}
        localThrowable3.printStackTrace();
      }
      catch (Throwable localThrowable3) {}
    }
    Object localObject3 = localObject1;
    i = ((Intent)localObject3).getIntExtra("VIDEO_FROM_TYPE", -1);
    localObject1 = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g;
    j = ((Intent)localObject3).getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
    ((VideoR5.Builder)localObject5).u(i).i((String)localObject1).E(j).M(0).L(MultiVideoConfigHandler.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_b_of_type_Int, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_c_of_type_Int, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_d_of_type_Int));
    ((VideoR5.Builder)localObject5).v(((Intent)localObject3).getIntExtra("key_source", -1));
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("exposed video [video_from_type : ");
      ((StringBuilder)localObject4).append(i);
      ((StringBuilder)localObject4).append(", first_video_row_key : ");
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(", first_video_type : ");
      ((StringBuilder)localObject4).append(j);
      ((StringBuilder)localObject4).append("]");
      QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject4).toString());
    }
    if (paramVideoInfo.f()) {
      ((VideoR5.Builder)localObject5).H(((Intent)localObject3).getIntExtra("VIDEO_CHAT_TYPE", 0)).I(((Intent)localObject3).getIntExtra("VIDEO_KANDIAN_TYPE", 0)).l(((Intent)localObject3).getStringExtra("VIDEO_CHAT_UIN"));
    }
    if (!this.jdField_a_of_type_JavaUtilHashSet.contains(str1))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(str1);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramVideoInfo.w == null)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoReportVideoR5$Builder = ((VideoR5.Builder)localObject5);
      } else {
        a(paramVideoInfo, (VideoR5.Builder)localObject5);
      }
      localObject4 = paramVideoInfo;
      if ((paramInt3 == 2) && (paramVideoInfo.h()))
      {
        if (this.jdField_b_of_type_Boolean) {
          localObject1 = "0X8009489";
        } else {
          localObject1 = "0X8009484";
        }
        str1 = new VideoR5.Builder(null, ((VideoInfo)localObject4).j, ((VideoInfo)localObject4).jdField_a_of_type_JavaLangString, ((VideoInfo)localObject4).g).a(409409).a(((VideoInfo)localObject4).w).u(((Intent)localObject3).getIntExtra("VIDEO_FROM_TYPE", -1)).a().a();
      }
    }
    for (;;)
    {
      try
      {
        localObject5 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        str2 = ((VideoInfo)localObject4).j;
        if (TextUtils.isEmpty((CharSequence)((VideoInfo)localObject4).g)) {
          break label910;
        }
        localObject3 = ((VideoInfo)localObject4).g;
        ((IPublicAccountReportUtils)localObject5).publicAccountReportClickEvent(null, str2, (String)localObject1, (String)localObject1, 0, 0, "", "", (String)localObject3, str1, false);
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
      VideoInfo localVideoInfo = paramVideoInfo;
      d(paramVideoInfo);
      e(paramVideoInfo);
      if (paramBoolean1) {
        a(paramVideoInfo);
      }
      if (paramBoolean2) {
        a(localVideoInfo, "0X800B1A6", false, localVideoInfo.jdField_p_of_type_Boolean);
      }
      if (localVideoInfo.o) {
        a(localVideoInfo, "0X800B2EA");
      }
      if (paramBoolean4) {
        a(this, paramVideoInfo, "0X800B941", 0, 4, null);
      }
      return;
      label902:
      localObject4 = "0";
      break;
      label910:
      localObject3 = "0";
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, VideoR5.Builder paramBuilder)
  {
    if (paramBuilder == null) {
      return;
    }
    boolean bool = this.jdField_b_of_type_Boolean;
    String str = "0";
    Object localObject1;
    Object localObject2;
    if (bool)
    {
      localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localObject2 = paramVideoInfo.j;
      if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.g)) {
        str = paramVideoInfo.g;
      }
      ((IPublicAccountReportUtils)localObject1).videoDataReportWithFansInfoInR5(null, (String)localObject2, "0X8009298", "0X8009298", 0, 0, "0", "", str, paramBuilder.a().a(), false);
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
      localObject1 = localObject2;
      if (!(localObject2 instanceof ShortVideoItemHolder)) {
        localObject1 = null;
      }
      localObject1 = (ShortVideoItemHolder)localObject1;
      int i = 1;
      if (localObject1 != null)
      {
        localObject1 = ((ShortVideoItemHolder)localObject1).e;
        if ((localObject1 != null) && (((TextView)localObject1).getVisibility() == 0))
        {
          bool = true;
          break label158;
        }
      }
      bool = false;
      label158:
      if ((TextUtils.isEmpty((CharSequence)paramVideoInfo.u)) || (!VideoFeedsHelper.e())) {
        i = 0;
      }
      paramBuilder.S(i).a(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo).b(this.jdField_a_of_type_Boolean).a(paramVideoInfo, bool).a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo).b(paramVideoInfo.y);
      try
      {
        localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localObject2 = paramVideoInfo.j;
        if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.g)) {
          str = paramVideoInfo.g;
        }
        ((IPublicAccountReportUtils)localObject1).videoDataReportWithFansInfoInR5(null, (String)localObject2, "0X8007801", "0X8007801", 0, 0, "0", "", str, paramBuilder.a().a(), false);
      }
      catch (Throwable paramBuilder)
      {
        paramBuilder.printStackTrace();
      }
    }
    c(paramVideoInfo, "0X800AD00");
    if ((paramVideoInfo.jdField_d_of_type_JavaUtilArrayList != null) && (paramVideoInfo.jdField_d_of_type_JavaUtilArrayList.size() > 0)) {
      c(paramVideoInfo);
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, String paramString, int paramInt)
  {
    VideoR5 localVideoR5 = new VideoR5.Builder(paramVideoInfo).j(paramVideoInfo.g).b(this.jdField_a_of_type_Boolean).a("is_viola", Integer.valueOf(0)).a("icon_type", Integer.valueOf(paramInt)).a();
    try
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, paramVideoInfo.g, "", "", localVideoR5.a(), false);
      return;
    }
    catch (Throwable paramVideoInfo)
    {
      paramVideoInfo.printStackTrace();
    }
  }
  
  private final void d(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo.e == 1))
    {
      paramVideoInfo = new VideoR5.Builder(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo).M(0).a();
      try
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800AC2B", "0X800AC2B", 0, 0, "3", "", "", paramVideoInfo.a(), false);
        return;
      }
      catch (Throwable paramVideoInfo)
      {
        paramVideoInfo.printStackTrace();
      }
    }
  }
  
  private final void e(VideoInfo paramVideoInfo)
  {
    String str1;
    String str3;
    Object localObject;
    String str2;
    if (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo != null)
    {
      str1 = paramVideoInfo.j;
      str3 = paramVideoInfo.jdField_a_of_type_JavaLangString;
      localObject = paramVideoInfo.g;
      str2 = "";
      str3 = new VideoR5.Builder("", str1, str3, (String)localObject).j(paramVideoInfo.g).a().a();
    }
    for (;;)
    {
      try
      {
        localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        if (!paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo.jdField_a_of_type_Boolean) {
          break label143;
        }
        str1 = "1";
        if (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo.jdField_a_of_type_Boolean) {
          paramVideoInfo = str2;
        } else {
          paramVideoInfo = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo.jdField_a_of_type_JavaLangString;
        }
        ((IPublicAccountReportUtils)localObject).publicAccountReportClickEvent(null, "", "0X800B4CE", "0X800B4CE", 0, 0, str1, paramVideoInfo, "", str3, false);
        return;
      }
      catch (Throwable paramVideoInfo)
      {
        paramVideoInfo.printStackTrace();
      }
      return;
      label143:
      str1 = "2";
    }
  }
  
  public final void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoReportVideoR5$Builder != null) {
      ThreadManager.excute((Runnable)new VideoFeedsReporter.onDestory.1(this), 16, null, true);
    }
  }
  
  public final void a(@Nullable VideoPlayerWrapper paramVideoPlayerWrapper, @Nullable String paramString)
  {
    VideoDTReport.a(paramVideoPlayerWrapper, paramString);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    ThreadManager.excute((Runnable)new VideoFeedsReporter.onLiveAvatorExposue.1(this, paramVideoInfo), 16, null, true);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    Object localObject = new VideoR5.Builder(paramVideoInfo);
    int i = 1;
    localObject = ((VideoR5.Builder)localObject).a("video_mode", Integer.valueOf(1)).a("rowkey", paramVideoInfo.g);
    if (paramVideoInfo.n) {
      i = 3;
    }
    localObject = ((VideoR5.Builder)localObject).a("status", Integer.valueOf(i)).a();
    try
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, paramVideoInfo.g, "", "", ((VideoR5)localObject).a(), false);
      return;
    }
    catch (Throwable paramVideoInfo)
    {
      paramVideoInfo.printStackTrace();
    }
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @NotNull String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity;
    if (localObject1 != null)
    {
      localObject1 = ((Activity)localObject1).getIntent();
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = new Intent();
    }
    int i = ((Intent)localObject1).getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
    Object localObject2 = new VideoR5.Builder(paramVideoInfo).a().a("scene_type", Integer.valueOf(3)).j(paramVideoInfo.g).e(paramVideoInfo.f).c(paramVideoInfo.jdField_p_of_type_Int).K(i).i(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g);
    if (paramVideoInfo.jdField_b_of_type_Boolean) {
      localObject1 = paramVideoInfo.j;
    } else {
      localObject1 = null;
    }
    localObject2 = ((VideoR5.Builder)localObject2).a("ugcuin", localObject1);
    if (paramBoolean1) {
      localObject1 = "click_type";
    } else {
      localObject1 = "button_type";
    }
    i = 2;
    int j;
    if (paramBoolean2) {
      j = 2;
    } else {
      j = 1;
    }
    localObject1 = ((VideoR5.Builder)localObject2).a((String)localObject1, Integer.valueOf(j));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "VideoR5.Builder(videoInf…if (isFollowed) 2 else 1)");
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        i = 1;
      }
      ((VideoR5.Builder)localObject1).a("click_type", Integer.valueOf(i));
    }
    else
    {
      if (!paramBoolean2) {
        i = 1;
      }
      ((VideoR5.Builder)localObject1).a("button_type", Integer.valueOf(i));
    }
    for (;;)
    {
      try
      {
        localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        String str = paramVideoInfo.j;
        if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.g))
        {
          paramVideoInfo = paramVideoInfo.g;
          ((IPublicAccountReportUtils)localObject2).videoDataReportWithFansInfoInR5(null, str, paramString, paramString, 0, 0, "0", "", paramVideoInfo, ((VideoR5.Builder)localObject1).a().a(), false);
          return;
        }
      }
      catch (Throwable paramVideoInfo)
      {
        paramVideoInfo.printStackTrace();
        return;
      }
      paramVideoInfo = "0";
    }
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @NotNull List<? extends PlayInfoForReport> paramList, @NotNull ReadInJoyVideoReportData paramReadInJoyVideoReportData, long paramLong, int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void a(@Nullable VideoPlayParam paramVideoPlayParam)
  {
    VideoInfo localVideoInfo;
    if (paramVideoPlayParam != null) {
      localVideoInfo = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    } else {
      localVideoInfo = null;
    }
    if ((localVideoInfo != null) && (!this.jdField_b_of_type_Boolean)) {
      VideoReporter.b(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, 409409, 1, -1, null, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g);
    }
  }
  
  public final void a(@Nullable BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder = paramBaseVideoItemHolder;
    if (paramBaseVideoItemHolder != null)
    {
      paramBaseVideoItemHolder = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      if (paramBaseVideoItemHolder != null)
      {
        paramBaseVideoItemHolder = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        break label28;
      }
    }
    paramBaseVideoItemHolder = null;
    label28:
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramBaseVideoItemHolder;
  }
  
  public final void a(@NotNull BaseVideoItemHolder paramBaseVideoItemHolder, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseVideoItemHolder, "holder");
    Object localObject1 = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if (localObject1 != null) {
      localObject1 = ((VideoPlayParam)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    } else {
      localObject1 = null;
    }
    int i = paramBaseVideoItemHolder.jdField_b_of_type_Int;
    int j = paramBaseVideoItemHolder.jdField_c_of_type_Int;
    int k = paramBaseVideoItemHolder.jdField_a_of_type_Int;
    boolean bool1;
    if (((paramBaseVideoItemHolder instanceof ShortVideoItemHolder)) && (((ShortVideoItemHolder)paramBaseVideoItemHolder).a.getVisibility() == 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool3 = paramBaseVideoItemHolder instanceof VideoItemHolder;
    if (bool3)
    {
      Object localObject2 = ((VideoItemHolder)paramBaseVideoItemHolder).a;
      if (localObject2 != null)
      {
        localObject2 = ((IVideoFeedsFollowButton)localObject2).a();
        if ((localObject2 != null) && (((View)localObject2).getVisibility() == 0))
        {
          bool2 = true;
          break label133;
        }
      }
    }
    boolean bool2 = false;
    label133:
    if (bool3)
    {
      paramBaseVideoItemHolder = ((VideoItemHolder)paramBaseVideoItemHolder).q;
      if ((paramBaseVideoItemHolder != null) && (paramBaseVideoItemHolder.getVisibility() == 0))
      {
        bool3 = true;
        break label166;
      }
    }
    bool3 = false;
    label166:
    if (localObject1 != null) {
      ThreadManager.post((Runnable)new VideoFeedsReporter.doReportOnCenterViewChanged..inlined.also.lambda.1(this, (VideoInfo)localObject1, i, j, k, bool1, bool2, paramBoolean, bool3), 1, null, true);
    }
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    if (localVideoInfo != null) {
      a(localVideoInfo, paramString, paramInt);
    }
  }
  
  public final void b()
  {
    this.jdField_d_of_type_Int += 1;
  }
  
  public final void b(@Nullable VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      VideoR5.Builder localBuilder = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoReportVideoR5$Builder;
      if (localBuilder != null)
      {
        if (localBuilder != null) {
          localBuilder.a(paramVideoInfo.w);
        }
        a(paramVideoInfo, this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoReportVideoR5$Builder);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoReportVideoR5$Builder = ((VideoR5.Builder)null);
      }
    }
  }
  
  public final void b(@NotNull VideoInfo paramVideoInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    VideoR5 localVideoR5 = new VideoR5.Builder(paramVideoInfo).e(paramVideoInfo.f).j(paramVideoInfo.g).a("live_circle_from_page", Integer.valueOf(2)).a();
    for (;;)
    {
      try
      {
        IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        String str = paramVideoInfo.j;
        if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.g))
        {
          paramVideoInfo = paramVideoInfo.g;
          localIPublicAccountReportUtils.videoDataReportWithFansInfoInR5(null, str, paramString, paramString, 0, 0, "0", "", paramVideoInfo, localVideoR5.a(), false);
          return;
        }
      }
      catch (Throwable paramVideoInfo)
      {
        paramVideoInfo.printStackTrace();
        return;
      }
      paramVideoInfo = "0";
    }
  }
  
  public final void c()
  {
    this.jdField_d_of_type_Int = 0;
  }
  
  public final void c(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if ((paramVideoInfo.jdField_d_of_type_JavaUtilArrayList != null) && (paramVideoInfo.jdField_d_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = paramVideoInfo.jdField_d_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (RichTitleInfo)localIterator.next();
        if (((RichTitleInfo)localObject1).jdField_a_of_type_Int == 1)
        {
          jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter$Companion.a(paramVideoInfo);
        }
        else
        {
          Object localObject2 = ((RichTitleInfo)localObject1).jdField_b_of_type_JavaLangString;
          if (localObject2 != null)
          {
            int i;
            if (((CharSequence)localObject2).length() > 0) {
              i = 1;
            } else {
              i = 0;
            }
            if (i == 1)
            {
              localObject2 = jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsReporter$Companion;
              localObject1 = ((RichTitleInfo)localObject1).jdField_b_of_type_JavaLangString;
              Intrinsics.checkExpressionValueIsNotNull(localObject1, "info.topicId");
              ((VideoFeedsReporter.Companion)localObject2).b(paramVideoInfo, (String)localObject1);
            }
          }
        }
      }
    }
  }
  
  public final void c(@NotNull VideoInfo paramVideoInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    if (localObject != null)
    {
      localObject = ((BaseVideoItemHolder)localObject).i;
      if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
        if (localObject != null) {
          localObject = ((BaseVideoItemHolder)localObject).i;
        } else {
          localObject = null;
        }
        VideoFeedsHelper.a(localObject, paramVideoInfo, "click_speed");
        paramVideoInfo = new VideoR5.Builder(paramVideoInfo).ad(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.a()).b(this.jdField_a_of_type_Boolean).c(paramVideoInfo.jdField_d_of_type_Int).M(0).a(paramVideoInfo.w).L(MultiVideoConfigHandler.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_b_of_type_Int, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_c_of_type_Int, this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_d_of_type_Int)).a();
        try
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, "", "", "", paramVideoInfo.a(), false);
          return;
        }
        catch (Throwable paramVideoInfo)
        {
          paramVideoInfo.printStackTrace();
        }
      }
    }
  }
  
  public final void d()
  {
    int j = this.jdField_d_of_type_Int;
    int i = 3;
    if (j < 3) {
      i = 4;
    }
    a(i);
    this.jdField_d_of_type_Int = 0;
  }
  
  public final void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.b())
    {
      a(2);
      return;
    }
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsReporter
 * JD-Core Version:    0.7.0.1
 */
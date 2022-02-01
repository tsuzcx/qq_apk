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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
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
  public static final VideoFeedsReporter.Companion a = new VideoFeedsReporter.Companion(null);
  private final int b;
  private final int c;
  private final String d;
  private final String e;
  private final boolean f;
  private final int g;
  private final String h;
  private final HashSet<String> i;
  private VideoR5.Builder j;
  private final boolean k;
  private boolean l;
  private BaseVideoItemHolder m;
  private VideoInfo n;
  private int o;
  private final Activity p;
  private final VideoInfo q;
  private final VideoFeedsRecommendPresenter r;
  
  public VideoFeedsReporter(@Nullable Activity paramActivity, @NotNull Bundle paramBundle, @NotNull VideoInfo paramVideoInfo, @NotNull VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter)
  {
    this.p = paramActivity;
    this.q = paramVideoInfo;
    this.r = paramVideoFeedsRecommendPresenter;
    this.c = VideoReporter.c();
    this.d = paramBundle.getString("ARGS_SESSION_ID");
    this.e = paramBundle.getString("ARGS_VIDEO_CHANNEL_SESSION_ID");
    this.f = ReadInJoyHelper.b();
    this.g = paramBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.h = paramBundle.getString("ARGS_PAGE_SESSION_ID");
    this.i = new HashSet();
    boolean bool2 = false;
    this.k = paramBundle.getBoolean("KEY_IS_WEISHI_MODE", false);
    paramActivity = this.p;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getIntent();
      if (paramActivity != null)
      {
        i1 = paramActivity.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        break label152;
      }
    }
    int i1 = 0;
    label152:
    int i3 = 5;
    int i2 = i3;
    if (i1 != 4)
    {
      i2 = i3;
      if (i1 != 5)
      {
        i2 = i3;
        if (i1 != 2) {
          if (i1 == 1) {
            i2 = i3;
          } else {
            i2 = RIJAppSetting.b();
          }
        }
      }
    }
    this.b = i2;
    long l1 = paramBundle.getLong("VIDEO_PLAY_POSITION", 0L);
    i1 = this.g;
    if ((i1 != 2) && (i1 != 3) && (i1 != 6) && (i1 != 7)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    boolean bool1 = bool2;
    if (l1 > 0L)
    {
      bool1 = bool2;
      if (i1 != 0) {
        bool1 = true;
      }
    }
    this.l = bool1;
  }
  
  private final void a(int paramInt)
  {
    Object localObject = new VideoR5.Builder(this.n).b("video_progress_control_way", Integer.valueOf(paramInt));
    VideoInfo localVideoInfo = this.n;
    if (localVideoInfo != null) {
      paramInt = localVideoInfo.e;
    } else {
      paramInt = 0;
    }
    localObject = ((VideoR5.Builder)localObject).i(paramInt * 1000L).M(0).b();
    try
    {
      PublicAccountReportUtils.a(null, "", "0X800B3D8", "0X800B3D8", 0, 0, "", "", "", ((VideoR5)localObject).a(), false);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    String str2 = paramVideoInfo.q;
    String str1 = paramVideoInfo.b;
    Object localObject4 = paramVideoInfo.l;
    Object localObject5 = paramVideoInfo.l();
    Object localObject1 = this.p;
    if (localObject1 != null)
    {
      localObject1 = ((Activity)localObject1).getIntent();
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = new Intent();
    }
    int i1 = ((Intent)localObject1).getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    int i2 = ((Intent)localObject1).getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
    int i3 = ((Intent)localObject1).getIntExtra("RETURN_SCENE", 0);
    Object localObject2 = VideoAutoPlayController.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "VideoAutoPlayController.getInstance()");
    if (((VideoAutoPlayController)localObject2).isNeedNetWorkAlert()) {
      localObject2 = "1";
    } else {
      localObject2 = "0";
    }
    localObject5 = new VideoR5.Builder((String)localObject5, str2, str1, (String)localObject4).e(paramVideoInfo.ah).c(paramVideoInfo.ai).d(this.d).e(this.e).g(i1).a(409409).l(paramInt2).a(Boolean.valueOf(paramVideoInfo.t)).b(paramVideoInfo.ao).g(paramVideoInfo.aq).q(this.c).r(this.b).J(paramVideoInfo.O).K(i2).n(0).l(paramVideoInfo.V).p(paramVideoInfo.W).d(this.f).ad(i3).a(this.g, this.h).M(0);
    if (paramBoolean3) {
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          break label872;
        }
        String str3 = ((VideoR5.Builder)localObject5).b().a();
        try
        {
          PublicAccountReportUtils.b(null, str2, "0X8007412", "0X8007412", 0, 0, String.valueOf(i1), (String)localObject2, (String)localObject4, str3, false);
        }
        catch (Throwable localThrowable2) {}
        localThrowable3.printStackTrace();
      }
      catch (Throwable localThrowable3) {}
    }
    Object localObject3 = localObject1;
    i1 = ((Intent)localObject3).getIntExtra("VIDEO_FROM_TYPE", -1);
    localObject1 = this.q.l;
    i2 = ((Intent)localObject3).getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
    ((VideoR5.Builder)localObject5).u(i1).j((String)localObject1).E(i2).M(0).L(MultiVideoConfigHandler.b(this.q.c, this.q.d, this.q.e));
    ((VideoR5.Builder)localObject5).v(((Intent)localObject3).getIntExtra("key_source", -1));
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("exposed video [video_from_type : ");
      ((StringBuilder)localObject4).append(i1);
      ((StringBuilder)localObject4).append(", first_video_row_key : ");
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(", first_video_type : ");
      ((StringBuilder)localObject4).append(i2);
      ((StringBuilder)localObject4).append("]");
      QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject4).toString());
    }
    if (paramVideoInfo.m()) {
      ((VideoR5.Builder)localObject5).H(((Intent)localObject3).getIntExtra("VIDEO_CHAT_TYPE", 0)).I(((Intent)localObject3).getIntExtra("VIDEO_KANDIAN_TYPE", 0)).m(((Intent)localObject3).getStringExtra("VIDEO_CHAT_UIN"));
    }
    if (!this.i.contains(str1))
    {
      this.i.add(str1);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramVideoInfo.ao == null)) {
        this.j = ((VideoR5.Builder)localObject5);
      } else {
        a(paramVideoInfo, (VideoR5.Builder)localObject5);
      }
      localObject4 = paramVideoInfo;
      if ((paramInt3 == 2) && (paramVideoInfo.o()))
      {
        if (this.k) {
          localObject1 = "0X8009489";
        } else {
          localObject1 = "0X8009484";
        }
        localObject5 = new VideoR5.Builder(null, ((VideoInfo)localObject4).q, ((VideoInfo)localObject4).b, ((VideoInfo)localObject4).l).a(409409).b(((VideoInfo)localObject4).ao).u(((Intent)localObject3).getIntExtra("VIDEO_FROM_TYPE", -1)).b().a();
      }
    }
    for (;;)
    {
      try
      {
        str1 = ((VideoInfo)localObject4).q;
        if (TextUtils.isEmpty((CharSequence)((VideoInfo)localObject4).l)) {
          break label880;
        }
        localObject3 = ((VideoInfo)localObject4).l;
        PublicAccountReportUtils.a(null, str1, (String)localObject1, (String)localObject1, 0, 0, "", "", (String)localObject3, (String)localObject5, false);
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
        a(localVideoInfo, "0X800B1A6", false, localVideoInfo.al);
      }
      if (localVideoInfo.ag) {
        a(localVideoInfo, "0X800B2EA");
      }
      if (paramBoolean4) {
        a(this, paramVideoInfo, "0X800B941", 0, 4, null);
      }
      return;
      label872:
      localObject4 = "0";
      break;
      label880:
      localObject3 = "0";
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, VideoR5.Builder paramBuilder)
  {
    if (paramBuilder == null) {
      return;
    }
    boolean bool = this.k;
    String str = "0";
    Object localObject;
    if (bool)
    {
      localObject = paramVideoInfo.q;
      if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.l)) {
        str = paramVideoInfo.l;
      }
      PublicAccountReportUtils.b(null, (String)localObject, "0X8009298", "0X8009298", 0, 0, "0", "", str, paramBuilder.b().a(), false);
    }
    else
    {
      BaseVideoItemHolder localBaseVideoItemHolder = this.m;
      localObject = localBaseVideoItemHolder;
      if (!(localBaseVideoItemHolder instanceof ShortVideoItemHolder)) {
        localObject = null;
      }
      localObject = (ShortVideoItemHolder)localObject;
      int i1 = 1;
      if (localObject != null)
      {
        localObject = ((ShortVideoItemHolder)localObject).l;
        if ((localObject != null) && (((TextView)localObject).getVisibility() == 0))
        {
          bool = true;
          break label143;
        }
      }
      bool = false;
      label143:
      if ((TextUtils.isEmpty((CharSequence)paramVideoInfo.X)) || (!VideoFeedsHelper.h())) {
        i1 = 0;
      }
      paramBuilder.T(i1).a(paramVideoInfo).b(paramVideoInfo.aK).d(this.f).a(paramVideoInfo, bool).a(paramVideoInfo.ay).c(paramVideoInfo.aU);
      try
      {
        localObject = paramVideoInfo.q;
        if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.l)) {
          str = paramVideoInfo.l;
        }
        PublicAccountReportUtils.b(null, (String)localObject, "0X8007801", "0X8007801", 0, 0, "0", "", str, paramBuilder.b().a(), false);
      }
      catch (Throwable paramBuilder)
      {
        paramBuilder.printStackTrace();
      }
    }
    c(paramVideoInfo, "0X800AD00");
    if ((paramVideoInfo.aL != null) && (paramVideoInfo.aL.size() > 0)) {
      c(paramVideoInfo);
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, String paramString, int paramInt)
  {
    VideoR5 localVideoR5 = new VideoR5.Builder(paramVideoInfo).k(paramVideoInfo.l).d(this.f).b("is_viola", Integer.valueOf(0)).b("icon_type", Integer.valueOf(paramInt)).b();
    try
    {
      PublicAccountReportUtils.a(null, "", paramString, paramString, 0, 0, paramVideoInfo.l, "", "", localVideoR5.a(), false);
      return;
    }
    catch (Throwable paramVideoInfo)
    {
      paramVideoInfo.printStackTrace();
    }
  }
  
  private final void d(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.ay != null) && (paramVideoInfo.ay.u == 1))
    {
      paramVideoInfo = new VideoR5.Builder(paramVideoInfo).a(paramVideoInfo.ay).M(0).b();
      try
      {
        PublicAccountReportUtils.a(null, "", "0X800AC2B", "0X800AC2B", 0, 0, "3", "", "", paramVideoInfo.a(), false);
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
    String str2;
    if (paramVideoInfo.aN != null)
    {
      str1 = paramVideoInfo.q;
      str3 = paramVideoInfo.b;
      String str4 = paramVideoInfo.l;
      str2 = "";
      str3 = new VideoR5.Builder("", str1, str3, str4).k(paramVideoInfo.l).b().a();
    }
    for (;;)
    {
      try
      {
        if (!paramVideoInfo.aN.a) {
          break label128;
        }
        str1 = "1";
        if (paramVideoInfo.aN.a) {
          paramVideoInfo = str2;
        } else {
          paramVideoInfo = paramVideoInfo.aN.b;
        }
        PublicAccountReportUtils.a(null, "", "0X800B4CE", "0X800B4CE", 0, 0, str1, paramVideoInfo, "", str3, false);
        return;
      }
      catch (Throwable paramVideoInfo)
      {
        paramVideoInfo.printStackTrace();
      }
      return;
      label128:
      str1 = "2";
    }
  }
  
  public final void a()
  {
    if (this.j != null) {
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
    int i1 = 1;
    localObject = ((VideoR5.Builder)localObject).b("video_mode", Integer.valueOf(1)).b("rowkey", paramVideoInfo.l);
    if (paramVideoInfo.af) {
      i1 = 3;
    }
    localObject = ((VideoR5.Builder)localObject).b("status", Integer.valueOf(i1)).b();
    try
    {
      PublicAccountReportUtils.a(null, "", paramString, paramString, 0, 0, paramVideoInfo.l, "", "", ((VideoR5)localObject).a(), false);
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
    Object localObject1 = this.p;
    if (localObject1 != null)
    {
      localObject1 = ((Activity)localObject1).getIntent();
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = new Intent();
    }
    int i1 = ((Intent)localObject1).getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
    Object localObject2 = new VideoR5.Builder(paramVideoInfo).c().b("scene_type", Integer.valueOf(3)).k(paramVideoInfo.l).e(paramVideoInfo.ah).c(paramVideoInfo.ai).K(i1).j(this.q.l);
    if (paramVideoInfo.t) {
      localObject1 = paramVideoInfo.q;
    } else {
      localObject1 = null;
    }
    localObject2 = ((VideoR5.Builder)localObject2).b("ugcuin", localObject1);
    if (paramBoolean1) {
      localObject1 = "click_type";
    } else {
      localObject1 = "button_type";
    }
    i1 = 2;
    int i2;
    if (paramBoolean2) {
      i2 = 2;
    } else {
      i2 = 1;
    }
    localObject1 = ((VideoR5.Builder)localObject2).b((String)localObject1, Integer.valueOf(i2));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "VideoR5.Builder(videoInf…if (isFollowed) 2 else 1)");
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        i1 = 1;
      }
      ((VideoR5.Builder)localObject1).b("click_type", Integer.valueOf(i1));
    }
    else
    {
      if (!paramBoolean2) {
        i1 = 1;
      }
      ((VideoR5.Builder)localObject1).b("button_type", Integer.valueOf(i1));
    }
    for (;;)
    {
      try
      {
        localObject2 = paramVideoInfo.q;
        if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.l))
        {
          paramVideoInfo = paramVideoInfo.l;
          PublicAccountReportUtils.b(null, (String)localObject2, paramString, paramString, 0, 0, "0", "", paramVideoInfo, ((VideoR5.Builder)localObject1).b().a(), false);
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
      localVideoInfo = paramVideoPlayParam.c;
    } else {
      localVideoInfo = null;
    }
    if ((localVideoInfo != null) && (!this.k)) {
      VideoReporter.b(paramVideoPlayParam.c, 409409, 1, -1, null, this.q.l);
    }
  }
  
  public final void a(@Nullable BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    this.m = paramBaseVideoItemHolder;
    if (paramBaseVideoItemHolder != null)
    {
      paramBaseVideoItemHolder = paramBaseVideoItemHolder.az;
      if (paramBaseVideoItemHolder != null)
      {
        paramBaseVideoItemHolder = paramBaseVideoItemHolder.c;
        break label28;
      }
    }
    paramBaseVideoItemHolder = null;
    label28:
    this.n = paramBaseVideoItemHolder;
  }
  
  public final void a(@NotNull BaseVideoItemHolder paramBaseVideoItemHolder, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseVideoItemHolder, "holder");
    Object localObject1 = paramBaseVideoItemHolder.az;
    if (localObject1 != null) {
      localObject1 = ((VideoPlayParam)localObject1).c;
    } else {
      localObject1 = null;
    }
    int i1 = paramBaseVideoItemHolder.Y;
    int i2 = paramBaseVideoItemHolder.Z;
    int i3 = paramBaseVideoItemHolder.X;
    boolean bool1;
    if (((paramBaseVideoItemHolder instanceof ShortVideoItemHolder)) && (((ShortVideoItemHolder)paramBaseVideoItemHolder).a.getVisibility() == 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool3 = paramBaseVideoItemHolder instanceof VideoItemHolder;
    if (bool3)
    {
      Object localObject2 = ((VideoItemHolder)paramBaseVideoItemHolder).aL;
      if (localObject2 != null)
      {
        localObject2 = ((IVideoFeedsFollowButton)localObject2).getView();
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
      paramBaseVideoItemHolder = ((VideoItemHolder)paramBaseVideoItemHolder).aX;
      if ((paramBaseVideoItemHolder != null) && (paramBaseVideoItemHolder.getVisibility() == 0))
      {
        bool3 = true;
        break label166;
      }
    }
    bool3 = false;
    label166:
    if (localObject1 != null) {
      ThreadManager.post((Runnable)new VideoFeedsReporter.doReportOnCenterViewChanged..inlined.also.lambda.1(this, (VideoInfo)localObject1, i1, i2, i3, bool1, bool2, paramBoolean, bool3), 1, null, true);
    }
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    VideoInfo localVideoInfo = this.n;
    if (localVideoInfo != null) {
      a(localVideoInfo, paramString, paramInt);
    }
  }
  
  public final void b()
  {
    this.o += 1;
  }
  
  public final void b(@Nullable VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      VideoR5.Builder localBuilder = this.j;
      if (localBuilder != null)
      {
        if (localBuilder != null) {
          localBuilder.b(paramVideoInfo.ao);
        }
        a(paramVideoInfo, this.j);
        this.j = ((VideoR5.Builder)null);
      }
    }
  }
  
  public final void b(@NotNull VideoInfo paramVideoInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    VideoR5 localVideoR5 = new VideoR5.Builder(paramVideoInfo).e(paramVideoInfo.ah).k(paramVideoInfo.l).b("live_circle_from_page", Integer.valueOf(2)).b();
    for (;;)
    {
      try
      {
        String str = paramVideoInfo.q;
        if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.l))
        {
          paramVideoInfo = paramVideoInfo.l;
          PublicAccountReportUtils.b(null, str, paramString, paramString, 0, 0, "0", "", paramVideoInfo, localVideoR5.a(), false);
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
    this.o = 0;
  }
  
  public final void c(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if ((paramVideoInfo.aL != null) && (paramVideoInfo.aL.size() > 0))
    {
      Iterator localIterator = paramVideoInfo.aL.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (RichTitleInfo)localIterator.next();
        if (((RichTitleInfo)localObject1).e == 1)
        {
          a.a(paramVideoInfo);
        }
        else
        {
          Object localObject2 = ((RichTitleInfo)localObject1).b;
          if (localObject2 != null)
          {
            int i1;
            if (((CharSequence)localObject2).length() > 0) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            if (i1 == 1)
            {
              localObject2 = a;
              localObject1 = ((RichTitleInfo)localObject1).b;
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
    Object localObject = this.m;
    if (localObject != null)
    {
      localObject = ((BaseVideoItemHolder)localObject).ax;
      if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
      {
        localObject = this.m;
        if (localObject != null) {
          localObject = ((BaseVideoItemHolder)localObject).ax;
        } else {
          localObject = null;
        }
        VideoFeedsHelper.a(localObject, paramVideoInfo, "click_speed");
        paramVideoInfo = new VideoR5.Builder(paramVideoInfo).ae(this.r.d()).d(this.f).c(paramVideoInfo.e).M(0).b(paramVideoInfo.ao).L(MultiVideoConfigHandler.b(this.q.c, this.q.d, this.q.e)).b();
        try
        {
          PublicAccountReportUtils.a(null, "", paramString, paramString, 0, 0, "", "", "", paramVideoInfo.a(), false);
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
    int i2 = this.o;
    int i1 = 3;
    if (i2 < 3) {
      i1 = 4;
    }
    a(i1);
    this.o = 0;
  }
  
  public final void e()
  {
    if (this.r.e())
    {
      a(2);
      return;
    }
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsReporter
 * JD-Core Version:    0.7.0.1
 */
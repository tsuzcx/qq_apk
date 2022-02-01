import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.LocationInfo;
import com.tencent.biz.pubaccount.VideoInfo.RichTitleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsReporter.doReportOnCenterViewChanged..inlined.also.lambda.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsReporter.onDestory.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsReporter.onLiveAvatorExposue.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsReporter;", "", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "firstVideoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "presenter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;", "(Landroid/app/Activity;Landroid/os/Bundle;Lcom/tencent/biz/pubaccount/VideoInfo;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;)V", "exposeVidSet", "Ljava/util/HashSet;", "", "firstVideoExposureR5", "Lcom/tencent/biz/pubaccount/readinjoy/video/report/VideoR5$Builder;", "fromType", "", "isReplayFromVideoChannel", "", "isTiktokStyle", "isWeiShiMode", "kandianMode", "kandianModeNew", "pageSessionId", "kotlin.jvm.PlatformType", "playingVideoHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;", "playingVideoInfo", "sessionID", "videoChannelSessionID", "doColumnBannerExposeReport", "", "videoInfo", "doLocationExposeReport", "doReportOnCenterViewChanged", "holder", "isVideoRealChanged", "doReportOnVideoInitiate", "playParam", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;", "doReportOnVideoStop", "reportList", "", "Lcom/tencent/biz/pubaccount/readinjoy/video/report/PlayInfoForReport;", "reportData", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ReadinjoyVideoReportData;", "duration", "", "recommendIndex", "isShowYourFollowed", "doRichTitleExposureReport", "doSpeedRatioBtnReport", "action", "innerDoReportOnCenterViewChanged", "position", "recommendPosition", "itemType", "isLiveAvatorShow", "isFollowBtnShow", "innerReportVideoExposure", "r5", "onCenterViewChanged", "viewHolder", "onDestory", "onFollowBtnRerport", "isClick", "isFollowed", "onLiveAvatorExposue", "onLiveAvatorReport", "reportRewardBtnAction", "info", "tryReportVideoExposure", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sly
{
  public static final slz a;
  private final int jdField_a_of_type_Int;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private final String jdField_a_of_type_JavaLangString;
  private final HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  private final slr jdField_a_of_type_Slr;
  private suu jdField_a_of_type_Suu;
  private swm jdField_a_of_type_Swm;
  private final boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString;
  private final boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int;
  private final String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Slz = new slz(null);
  }
  
  public sly(@Nullable Activity paramActivity, @NotNull Bundle paramBundle, @NotNull VideoInfo paramVideoInfo, @NotNull slr paramslr)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_Slr = paramslr;
    this.jdField_b_of_type_Int = omx.a();
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("ARGS_SESSION_ID");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("ARGS_VIDEO_CHANNEL_SESSION_ID");
    this.jdField_a_of_type_Boolean = bmhv.d();
    this.jdField_c_of_type_Int = paramBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("ARGS_PAGE_SESSION_ID");
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("KEY_IS_WEISHI_MODE", false);
    paramActivity = this.jdField_a_of_type_AndroidAppActivity;
    int i;
    int j;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getIntent();
      if (paramActivity != null)
      {
        i = paramActivity.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        j = k;
        if (i != 4)
        {
          j = k;
          if (i != 5)
          {
            j = k;
            if (i != 2)
            {
              if (i != 1) {
                break label266;
              }
              j = k;
            }
          }
        }
        label186:
        this.jdField_a_of_type_Int = j;
        long l = paramBundle.getLong("VIDEO_PLAY_POSITION", 0L);
        if ((this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 3) && (this.jdField_c_of_type_Int != 6) && (this.jdField_c_of_type_Int != 7)) {
          break label274;
        }
        i = 1;
        label238:
        if ((l <= 0L) || (i == 0)) {
          break label280;
        }
      }
    }
    label266:
    label274:
    label280:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      return;
      i = 0;
      break;
      j = pkh.a();
      break label186;
      i = 0;
      break label238;
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    String str4 = paramVideoInfo.jdField_j_of_type_JavaLangString;
    String str3 = paramVideoInfo.jdField_a_of_type_JavaLangString;
    String str2 = paramVideoInfo.g;
    String str1;
    label64:
    Object localObject2;
    label118:
    suu localsuu;
    if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      str1 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      localObject1 = this.jdField_a_of_type_AndroidAppActivity;
      if (localObject1 == null) {
        break label761;
      }
      localObject1 = ((Activity)localObject1).getIntent();
      if (localObject1 == null) {
        break label761;
      }
      int i = ((Intent)localObject1).getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      int j = ((Intent)localObject1).getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      int k = ((Intent)localObject1).getIntExtra("RETURN_SCENE", 0);
      localObject2 = sge.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "VideoAutoPlayController.getInstance()");
      if (!((sge)localObject2).c()) {
        break label773;
      }
      localObject2 = "1";
      localsuu = new suu(str1, str4, str3, str2).e(paramVideoInfo.f).c(paramVideoInfo.jdField_q_of_type_Int).b(this.jdField_a_of_type_JavaLangString).c(this.jdField_b_of_type_JavaLangString).g(i).a(409409).l(paramInt2).a(Boolean.valueOf(paramVideoInfo.jdField_b_of_type_Boolean)).a(paramVideoInfo.w).e(paramVideoInfo.jdField_c_of_type_Boolean).q(this.jdField_b_of_type_Int).r(this.jdField_a_of_type_Int).J(paramVideoInfo.l).K(j).n(0).j(paramVideoInfo.jdField_j_of_type_Boolean).n(paramVideoInfo.t).b(this.jdField_a_of_type_Boolean).ab(k).a(this.jdField_c_of_type_Int, this.jdField_c_of_type_JavaLangString).M(0);
      if (paramBoolean3)
      {
        if (TextUtils.isEmpty((CharSequence)str2)) {
          break label781;
        }
        str1 = str2;
        label293:
        olh.b(null, str4, "0X8007412", "0X8007412", 0, 0, String.valueOf(i), (String)localObject2, str1, localsuu.a().a(), false);
      }
      i = ((Intent)localObject1).getIntExtra("VIDEO_FROM_TYPE", -1);
      str1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
      j = ((Intent)localObject1).getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      localsuu.u(i).h(str1).E(j).M(0).L(plw.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int));
      localsuu.v(((Intent)localObject1).getIntExtra("key_source", -1));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "exposed video [video_from_type : " + i + ", first_video_row_key : " + str1 + ", first_video_type : " + j + "]");
      }
      if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
        localsuu.H(((Intent)localObject1).getIntExtra("VIDEO_CHAT_TYPE", 0)).I(((Intent)localObject1).getIntExtra("VIDEO_KANDIAN_TYPE", 0)).k(((Intent)localObject1).getStringExtra("VIDEO_CHAT_UIN"));
      }
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(str3))
      {
        this.jdField_a_of_type_JavaUtilHashSet.add(str3);
        if ((paramInt1 != 0) || (paramInt2 != 0) || (paramVideoInfo.w != null)) {
          break label789;
        }
        this.jdField_a_of_type_Suu = localsuu;
        label576:
        if ((paramInt3 == 2) && (paramVideoInfo.a()))
        {
          if (!this.jdField_b_of_type_Boolean) {
            break label799;
          }
          str1 = "0X8009489";
          label601:
          localObject2 = new suu(null, paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g).a(409409).a(paramVideoInfo.w).u(((Intent)localObject1).getIntExtra("VIDEO_FROM_TYPE", -1)).a().a();
          str2 = paramVideoInfo.jdField_j_of_type_JavaLangString;
          if (TextUtils.isEmpty((CharSequence)paramVideoInfo.g)) {
            break label807;
          }
        }
      }
    }
    label773:
    label781:
    label789:
    label799:
    label807:
    for (Object localObject1 = paramVideoInfo.g;; localObject1 = "0")
    {
      olh.a(null, str2, str1, str1, 0, 0, "", "", (String)localObject1, (String)localObject2, false);
      d(paramVideoInfo);
      e(paramVideoInfo);
      if (paramBoolean1) {
        a(paramVideoInfo);
      }
      if (paramBoolean2) {
        a(paramVideoInfo, "0X800B1A6", false, paramVideoInfo.jdField_q_of_type_Boolean);
      }
      if (paramVideoInfo.p) {
        a(paramVideoInfo, "0X800B2EA");
      }
      return;
      str1 = null;
      break;
      label761:
      localObject1 = new Intent();
      break label64;
      localObject2 = "0";
      break label118;
      str1 = "0";
      break label293;
      a(paramVideoInfo, localsuu);
      break label576;
      str1 = "0X8009484";
      break label601;
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, suu paramsuu)
  {
    int i = 1;
    if (paramsuu == null) {
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject2 = paramVideoInfo.jdField_j_of_type_JavaLangString;
      if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.g)) {}
      for (localObject1 = paramVideoInfo.g;; localObject1 = "0")
      {
        olh.b(null, (String)localObject2, "0X8009298", "0X8009298", 0, 0, "0", "", (String)localObject1, paramsuu.a().a(), false);
        c(paramVideoInfo, "0X800AD00");
        if ((paramVideoInfo.jdField_d_of_type_JavaUtilArrayList == null) || (paramVideoInfo.jdField_d_of_type_JavaUtilArrayList.size() <= 0)) {
          break;
        }
        c(paramVideoInfo);
        return;
      }
    }
    Object localObject2 = this.jdField_a_of_type_Swm;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof swr)) {
      localObject1 = null;
    }
    localObject1 = (swr)localObject1;
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = ((swr)localObject1).d;
      if ((localObject1 != null) && (((TextView)localObject1).getVisibility() == 0))
      {
        bool = true;
        label164:
        if ((TextUtils.isEmpty((CharSequence)paramVideoInfo.u)) || (!six.e())) {
          break label284;
        }
        label183:
        paramsuu.R(i).a(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo).b(this.jdField_a_of_type_Boolean).a(paramVideoInfo, bool).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo);
        localObject2 = paramVideoInfo.jdField_j_of_type_JavaLangString;
        if (TextUtils.isEmpty((CharSequence)paramVideoInfo.g)) {
          break label289;
        }
      }
    }
    label284:
    label289:
    for (localObject1 = paramVideoInfo.g;; localObject1 = "0")
    {
      olh.b(null, (String)localObject2, "0X8007801", "0X8007801", 0, 0, "0", "", (String)localObject1, paramsuu.a().a(), false);
      break;
      bool = false;
      break label164;
      i = 0;
      break label183;
    }
  }
  
  private final void d(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.e == 1)) {
      olh.a(null, "", "0X800AC2B", "0X800AC2B", 0, 0, "3", "", "", new suu(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).M(0).a().a(), false);
    }
  }
  
  private final void e(VideoInfo paramVideoInfo)
  {
    String str2;
    String str1;
    if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo != null)
    {
      str2 = new suu("", paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g).i(paramVideoInfo.g).a().a();
      if (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo.jdField_a_of_type_Boolean) {
        break label93;
      }
      str1 = "1";
      if (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo.jdField_a_of_type_Boolean) {
        break label100;
      }
    }
    label93:
    label100:
    for (paramVideoInfo = "";; paramVideoInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo.jdField_a_of_type_JavaLangString)
    {
      olh.a(null, "", "0X800B4CE", "0X800B4CE", 0, 0, str1, paramVideoInfo, "", str2, false);
      return;
      str1 = "2";
      break;
    }
  }
  
  public final void a()
  {
    if (this.jdField_a_of_type_Suu != null) {
      ThreadManager.excute((Runnable)new VideoFeedsReporter.onDestory.1(this), 16, null, true);
    }
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    ThreadManager.excute((Runnable)new VideoFeedsReporter.onLiveAvatorExposue.1(this, paramVideoInfo), 16, null, true);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @Nullable String paramString)
  {
    int i = 1;
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    Object localObject = new suu(paramVideoInfo).a("video_mode", Integer.valueOf(1));
    if (paramVideoInfo.o) {
      i = 3;
    }
    localObject = ((suu)localObject).a("status", Integer.valueOf(i)).a();
    olh.a(null, "", paramString, paramString, 0, 0, paramVideoInfo.g, "", "", ((sut)localObject).a(), false);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @NotNull String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 2;
    int k = 1;
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    Object localObject2 = new suu(paramVideoInfo).a().a("scene_type", Integer.valueOf(3)).i(paramVideoInfo.g).e(paramVideoInfo.f).c(paramVideoInfo.jdField_q_of_type_Int);
    Object localObject1;
    label98:
    int i;
    if (paramVideoInfo.jdField_b_of_type_Boolean)
    {
      localObject1 = paramVideoInfo.jdField_j_of_type_JavaLangString;
      localObject2 = ((suu)localObject2).a("ugcuin", localObject1);
      if (!paramBoolean1) {
        break label204;
      }
      localObject1 = "click_type";
      if (!paramBoolean2) {
        break label212;
      }
      i = 2;
      label106:
      localObject1 = ((suu)localObject2).a((String)localObject1, Integer.valueOf(i));
      if (!paramBoolean1) {
        break label224;
      }
      if (!paramBoolean2) {
        break label218;
      }
      i = k;
      label133:
      ((suu)localObject1).a("click_type", Integer.valueOf(i));
      localObject2 = paramVideoInfo.jdField_j_of_type_JavaLangString;
      if (TextUtils.isEmpty((CharSequence)paramVideoInfo.g)) {
        break label256;
      }
    }
    label256:
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      olh.b(null, (String)localObject2, paramString, paramString, 0, 0, "0", "", paramVideoInfo, ((suu)localObject1).a().a(), false);
      return;
      localObject1 = null;
      break;
      label204:
      localObject1 = "button_type";
      break label98;
      label212:
      i = 1;
      break label106;
      label218:
      i = 2;
      break label133;
      label224:
      if (paramBoolean2) {}
      for (i = j;; i = 1)
      {
        ((suu)localObject1).a("button_type", Integer.valueOf(i));
        break;
      }
    }
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @NotNull List<? extends suq> paramList, @NotNull rqa paramrqa, long paramLong, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramList, "reportList");
    Intrinsics.checkParameterIsNotNull(paramrqa, "reportData");
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity;
    Object localObject2;
    String str2;
    label85:
    int n;
    int i1;
    int j;
    label115:
    int i3;
    int k;
    label206:
    int m;
    label227:
    suq localsuq;
    int i;
    label326:
    label638:
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((Activity)localObject1).getIntent();
      if (localObject2 != null)
      {
        str2 = paramVideoInfo.jdField_j_of_type_JavaLangString;
        String str3 = paramVideoInfo.jdField_a_of_type_JavaLangString;
        String str1 = paramVideoInfo.g;
        if ((paramVideoInfo.jdField_a_of_type_Int != 0) || (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
          break label961;
        }
        localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        n = ((Intent)localObject2).getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        i1 = ((Intent)localObject2).getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
        if (!this.jdField_c_of_type_Boolean) {
          break label967;
        }
        j = 1;
        this.jdField_c_of_type_Boolean = false;
        int i2 = ((Intent)localObject2).getIntExtra("key_source", -1);
        i3 = ((Intent)localObject2).getIntExtra("VIDEO_FROM_TYPE", -1);
        int i4 = ((Intent)localObject2).getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        int i5 = ((Intent)localObject2).getIntExtra("VIDEO_CHAT_TYPE", 0);
        int i6 = ((Intent)localObject2).getIntExtra("VIDEO_KANDIAN_TYPE", 0);
        String str4 = ((Intent)localObject2).getStringExtra("VIDEO_CHAT_UIN");
        if ((TextUtils.isEmpty((CharSequence)paramVideoInfo.u)) || (!six.e())) {
          break label973;
        }
        k = 1;
        int i7 = ((Intent)localObject2).getIntExtra("RETURN_SCENE", 0);
        int i8 = paramList.size();
        m = 0;
        if (m >= i8) {
          return;
        }
        localsuq = (suq)paramList.get(m);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsReporter", 2, "播放VV上报 totalPlayTime = " + localsuq.a + ", currentPlayTime = " + localsuq.b);
        }
        if ((localsuq.b != 0L) || (localsuq.a != 0L))
        {
          if (m != 0) {
            break label979;
          }
          i = 0;
          localObject2 = new suu((String)localObject1, str2, str3, str1).d(localsuq.a).a(localsuq.b).x(i).y(i8 - 1).v(i2).A(paramrqa.m).z(paramrqa.l).C(paramrqa.k).B(paramrqa.j).b(this.jdField_a_of_type_JavaLangString).c(this.jdField_b_of_type_JavaLangString).c(paramLong).l(paramInt).a(409409).a(Boolean.valueOf(paramVideoInfo.jdField_b_of_type_Boolean)).a(paramVideoInfo.w).e(paramVideoInfo.jdField_c_of_type_Boolean).q(this.jdField_b_of_type_Int).r(this.jdField_a_of_type_Int).e(paramVideoInfo.f).c(paramVideoInfo.jdField_q_of_type_Int).D(j).J(paramVideoInfo.l).E(i4).h(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g).u(i3).K(i1).i(false).n(0).j(paramVideoInfo.jdField_j_of_type_Boolean).n(paramVideoInfo.t).R(k).a(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo).h(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.f).L(plw.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int)).M(0).b(this.jdField_a_of_type_Boolean).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).ab(i7).k(stw.a.a());
          if (!paramBoolean) {
            break label1001;
          }
          i = 1;
          localObject2 = ((suu)localObject2).a("is_show_followed", Integer.valueOf(i)).a(this.jdField_c_of_type_Int, this.jdField_c_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "play video [video_from_type : " + i3 + ", first_video_row_key : " + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g + ", first_video_type : " + i4 + "]");
          }
          if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
            ((suu)localObject2).H(i5).I(i6).k(str4);
          }
          localObject3 = ((suu)localObject2).a().a();
          if (TextUtils.isEmpty((CharSequence)str1)) {
            break label1007;
          }
          localObject2 = str1;
          label788:
          if (!this.jdField_b_of_type_Boolean) {
            break label1015;
          }
          olh.b(null, str2, "0X8009297", "0X8009297", 0, 0, String.valueOf(n), String.valueOf(i1), (String)localObject2, (String)localObject3, false);
          olh.a("0X8009297", str2, String.valueOf(n), String.valueOf(i1), "", (String)localObject3);
        }
      }
    }
    for (;;)
    {
      localObject2 = new rqg();
      ((rqg)localObject2).jdField_d_of_type_Int = ((int)localsuq.b);
      ((rqg)localObject2).e = ((int)paramLong);
      ((rqg)localObject2).jdField_b_of_type_Boolean = true;
      localObject3 = sge.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "VideoAutoPlayController.getInstance()");
      ((rqg)localObject2).jdField_a_of_type_Boolean = ((sge)localObject3).c();
      ((rqg)localObject2).jdField_b_of_type_Int = n;
      ((rqg)localObject2).f = i3;
      omx.b(paramVideoInfo, i1, 12, (int)localsuq.a, (rqg)localObject2, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      m += 1;
      break label227;
      localObject2 = new Intent();
      break;
      label961:
      localObject1 = null;
      break label85;
      label967:
      j = -1;
      break label115;
      label973:
      k = 0;
      break label206;
      label979:
      if (this.jdField_a_of_type_Slr.d())
      {
        i = 2;
        break label326;
      }
      i = 1;
      break label326;
      label1001:
      i = 0;
      break label638;
      label1007:
      localObject2 = "0";
      break label788;
      label1015:
      olh.b(null, str2, "0X8007409", "0X8007409", 0, 0, String.valueOf(n), String.valueOf(i1), (String)localObject2, (String)localObject3, false);
      olh.a("0X8007409", str2, String.valueOf(n), String.valueOf(i1), "", (String)localObject3);
    }
  }
  
  public final void a(@Nullable skq paramskq)
  {
    if (paramskq != null) {}
    for (VideoInfo localVideoInfo = paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;; localVideoInfo = null)
    {
      if ((localVideoInfo != null) && (!this.jdField_b_of_type_Boolean)) {
        omx.b(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, 409409, 1, -1, null, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      }
      return;
    }
  }
  
  public final void a(@NotNull swm paramswm, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramswm, "holder");
    Object localObject = paramswm.jdField_a_of_type_Skq;
    int i;
    int j;
    int k;
    boolean bool1;
    if (localObject != null)
    {
      localObject = ((skq)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      i = paramswm.jdField_b_of_type_Int;
      j = paramswm.jdField_c_of_type_Int;
      k = paramswm.jdField_a_of_type_Int;
      if ((!(paramswm instanceof swr)) || (((swr)paramswm).a.getVisibility() != 0)) {
        break label156;
      }
      bool1 = true;
      label65:
      if ((!(paramswm instanceof swu)) || (((swu)paramswm).a == null)) {
        break label162;
      }
      paramswm = ((swu)paramswm).a;
      if (paramswm == null) {
        break label162;
      }
      paramswm = paramswm.a();
      if ((paramswm == null) || (paramswm.getVisibility() != 0)) {
        break label162;
      }
    }
    label156:
    label162:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (localObject != null) {
        ThreadManager.post((Runnable)new VideoFeedsReporter.doReportOnCenterViewChanged..inlined.also.lambda.1(this, (VideoInfo)localObject, i, j, k, bool1, bool2, paramBoolean), 1, null, true);
      }
      return;
      localObject = null;
      break;
      bool1 = false;
      break label65;
    }
  }
  
  public final void b(@Nullable VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (this.jdField_a_of_type_Suu != null))
    {
      suu localsuu = this.jdField_a_of_type_Suu;
      if (localsuu != null) {
        localsuu.a(paramVideoInfo.w);
      }
      a(paramVideoInfo, this.jdField_a_of_type_Suu);
      this.jdField_a_of_type_Suu = ((suu)null);
    }
  }
  
  public final void b(@NotNull VideoInfo paramVideoInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "action");
    sut localsut = new suu(paramVideoInfo).e(paramVideoInfo.f).i(paramVideoInfo.g).a("live_circle_from_page", Integer.valueOf(2)).a();
    String str = paramVideoInfo.jdField_j_of_type_JavaLangString;
    if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.g)) {}
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      olh.b(null, str, paramString, paramString, 0, 0, "0", "", paramVideoInfo, localsut.a(), false);
      return;
    }
  }
  
  public final void c(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if ((paramVideoInfo.jdField_d_of_type_JavaUtilArrayList != null) && (paramVideoInfo.jdField_d_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = paramVideoInfo.jdField_d_of_type_JavaUtilArrayList.iterator();
      label137:
      while (localIterator.hasNext())
      {
        Object localObject1 = (VideoInfo.RichTitleInfo)localIterator.next();
        if (((VideoInfo.RichTitleInfo)localObject1).jdField_a_of_type_Int == 1)
        {
          jdField_a_of_type_Slz.a(paramVideoInfo);
        }
        else
        {
          Object localObject2 = ((VideoInfo.RichTitleInfo)localObject1).jdField_b_of_type_JavaLangString;
          if (localObject2 != null)
          {
            if (((CharSequence)localObject2).length() > 0) {}
            for (int i = 1;; i = 0)
            {
              if (i != 1) {
                break label137;
              }
              localObject2 = jdField_a_of_type_Slz;
              localObject1 = ((VideoInfo.RichTitleInfo)localObject1).jdField_b_of_type_JavaLangString;
              Intrinsics.checkExpressionValueIsNotNull(localObject1, "info.topicId");
              ((slz)localObject2).b(paramVideoInfo, (String)localObject1);
              break;
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
    Object localObject = this.jdField_a_of_type_Swm;
    if (localObject != null)
    {
      localObject = ((swm)localObject).j;
      if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
      {
        localObject = this.jdField_a_of_type_Swm;
        if (localObject == null) {
          break label160;
        }
      }
    }
    label160:
    for (localObject = ((swm)localObject).j;; localObject = null)
    {
      six.a(localObject, paramVideoInfo, "click_speed");
      olh.a(null, "", paramString, paramString, 0, 0, "", "", "", new suu(paramVideoInfo).ac(this.jdField_a_of_type_Slr.a()).b(this.jdField_a_of_type_Boolean).c(paramVideoInfo.jdField_d_of_type_Int).M(0).a(paramVideoInfo.w).L(plw.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int)).a().a(), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sly
 * JD-Core Version:    0.7.0.1
 */
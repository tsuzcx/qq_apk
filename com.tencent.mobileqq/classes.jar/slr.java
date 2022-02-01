import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter.onVideoStop..inlined.let.lambda.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoStatusListener;", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView$ListEventListener;", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "playManager", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;", "recyclerView", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView;", "isLoopPlayMode", "", "videoDataList", "Ljava/util/ArrayList;", "Lcom/tencent/biz/pubaccount/VideoInfo;", "videoFromType", "", "(Landroid/app/Activity;Landroid/os/Bundle;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView;ZLjava/util/ArrayList;I)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "setApp", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "getBundle", "()Landroid/os/Bundle;", "firstVideoInfo", "getFirstVideoInfo", "()Lcom/tencent/biz/pubaccount/VideoInfo;", "<set-?>", "isFullScreen", "()Z", "isKingCardUser", "isTikTokStyle", "lastResumeTimeStamp", "", "lastStayDuration", "lastVideoItemHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;", "mEventHandler", "Landroid/os/Handler;", "getMEventHandler", "()Landroid/os/Handler;", "mFirstVideoPlayerSessionId", "", "mHasJumpColumnPage", "mKandianMode", "mKandianModeNew", "mPlayInfoListForReport", "Lcom/tencent/biz/pubaccount/readinjoy/video/report/PlayInfoForReport;", "mRecommendManager", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendManager;", "mUpglideCount", "mVideoAdFetchManager", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/strategy/VideoAdExposureManager;", "onColumnActionObserver", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyObserver;", "getPlayManager", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager;", "playingVideoInfo", "getPlayingVideoInfo", "playingVideoItemHolder", "getPlayingVideoItemHolder", "()Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;", "playingVideoParams", "getPlayingVideoParams", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;", "reporter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsReporter;", "getReporter", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsReporter;", "speedRatioIndex", "getSpeedRatioIndex", "()I", "getVideoDataList", "()Ljava/util/ArrayList;", "getVideoFromType", "doOnPause", "", "doOnResume", "doWhenJumpColumnPage", "handlePlayButtonClick", "handleSpeedRatioBtnClick", "onCenterViewChanged", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onCenterViewIdle", "onChangeScreenOrientation", "onCompletion", "playParam", "onDestroyView", "onLoadMore", "onVideoBufferEnd", "isPlaying", "onVideoBufferStart", "onVideoError", "model", "what", "errorMsg", "onVideoInitiate", "onVideoPause", "onVideoReplayOnLoop", "times", "onVideoRestart", "onVideoStart", "onVideoStop", "isCompleted", "reportDtOnVideoEnd", "isComplete", "reportDtOnVideoStart", "reportOnCreate", "reportUpglideCount", "reportUseDuration", "resetSpeedRatio", "resumePlayWhenBackFromColumnPage", "setRecommendManager", "recommendManager", "setVideoAdFetchManager", "videoAdExposureManager", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class slr
  implements sks, slx
{
  public static final sls a;
  @NotNull
  private static final float[] jdField_a_of_type_ArrayOfFloat = { 1.0F, 1.5F, 2.0F };
  @NotNull
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130841833, 2130841832, 2130841834 };
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  @Nullable
  private Activity jdField_a_of_type_AndroidAppActivity;
  @NotNull
  private final Bundle jdField_a_of_type_AndroidOsBundle;
  @NotNull
  private final Handler jdField_a_of_type_AndroidOsHandler;
  @Nullable
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  @NotNull
  private final VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  @Nullable
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private final ArrayList<suq> jdField_a_of_type_JavaUtilArrayList;
  private final pvq jdField_a_of_type_Pvq;
  @Nullable
  private skq jdField_a_of_type_Skq;
  private sln jdField_a_of_type_Sln;
  @NotNull
  private final sly jdField_a_of_type_Sly;
  private swm jdField_a_of_type_Swm;
  private ulq jdField_a_of_type_Ulq;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  @NotNull
  private final VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  @NotNull
  private final ArrayList<VideoInfo> jdField_b_of_type_JavaUtilArrayList;
  @Nullable
  private swm jdField_b_of_type_Swm;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private final boolean jdField_d_of_type_Boolean;
  private final int jdField_e_of_type_Int;
  private final boolean jdField_e_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Sls = new sls(null);
  }
  
  public slr(@Nullable Activity paramActivity, @NotNull Bundle paramBundle, @Nullable QQAppInterface paramQQAppInterface, @NotNull VideoFeedsPlayManager paramVideoFeedsPlayManager, @NotNull VideoFeedsRecyclerView paramVideoFeedsRecyclerView, boolean paramBoolean, @NotNull ArrayList<VideoInfo> paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_e_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_e_of_type_Int = paramInt;
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (bhyk.a() == 1)
    {
      paramBoolean = true;
      this.jdField_d_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Pvq = ((pvq)new slt(this));
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a((sks)this);
      paramVideoFeedsRecyclerView.a((slx)this);
      paramActivity = this.jdField_b_of_type_JavaUtilArrayList.get(0);
      Intrinsics.checkExpressionValueIsNotNull(paramActivity, "videoDataList[0]");
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)paramActivity);
      this.jdField_a_of_type_Int = pkh.a();
      this.jdField_b_of_type_Int = omx.a();
      paramActivity = this.jdField_a_of_type_AndroidAppActivity;
      paramInt = i;
      if (paramActivity != null)
      {
        paramActivity = paramActivity.getIntent();
        paramInt = i;
        if (paramActivity != null) {
          paramInt = paramActivity.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        }
      }
      this.jdField_a_of_type_Boolean = bmhv.d();
      if ((paramInt == 4) || (paramInt == 5) || (paramInt == 2) || (paramInt == 1)) {
        this.jdField_a_of_type_Int = 5;
      }
    }
    try
    {
      paramActivity = this.jdField_a_of_type_AndroidAppActivity;
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
      label293:
      break label293;
    }
    paramActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getIntent();
      if (paramActivity == null) {}
    }
    for (paramActivity = paramActivity.getStringExtra("video_player_session_id");; paramActivity = null)
    {
      this.jdField_a_of_type_JavaLangString = paramActivity;
      this.jdField_a_of_type_Sly = new sly(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo, this);
      ThreadManager.excute((Runnable)new VideoFeedsRecommendPresenter.1(this), 16, null, true);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private final void c(skq paramskq, boolean paramBoolean)
  {
    int i = 1;
    if ((paramskq == null) || (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) || (paramskq.jdField_a_of_type_Spn == null)) {
      return;
    }
    boolean bool = paramskq.jdField_a_of_type_AndroidOsBundle.getBoolean("is_auto_play", true);
    sus localsus = sus.a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).a("dt_vdend").b("6");
    spn localspn = paramskq.jdField_a_of_type_Spn;
    Intrinsics.checkExpressionValueIsNotNull(localspn, "playParam.videoPlayer");
    localsus = localsus.e(localspn.b());
    localspn = paramskq.jdField_a_of_type_Spn;
    Intrinsics.checkExpressionValueIsNotNull(localspn, "playParam.videoPlayer");
    paramskq = localsus.e(localspn.a()).a(bool).b(System.currentTimeMillis()).c(paramskq.jdField_a_of_type_Spn.a(paramBoolean)).c(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (this.jdField_e_of_type_Boolean) {
      i = 2;
    }
    sur.a(paramskq.b(i));
  }
  
  private final void g(skq paramskq)
  {
    int i = 1;
    if ((paramskq == null) || (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) || (paramskq.jdField_a_of_type_Spn == null)) {
      return;
    }
    boolean bool = paramskq.jdField_a_of_type_AndroidOsBundle.getBoolean("is_auto_play", true);
    sus localsus = sus.a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).a("dt_vdstart").b("6");
    spn localspn = paramskq.jdField_a_of_type_Spn;
    Intrinsics.checkExpressionValueIsNotNull(localspn, "playParam.videoPlayer");
    localsus = localsus.e(localspn.b());
    paramskq = paramskq.jdField_a_of_type_Spn;
    Intrinsics.checkExpressionValueIsNotNull(paramskq, "playParam.videoPlayer");
    paramskq = localsus.e(paramskq.a()).a(bool).a(System.currentTimeMillis());
    if (this.jdField_e_of_type_Boolean) {
      i = 2;
    }
    sur.a(paramskq.b(i).c(this.jdField_a_of_type_JavaUtilArrayList.size()));
  }
  
  private final void i()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    int i;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent();
      if (localObject != null)
      {
        i = ((Intent)localObject).getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        localObject = this.jdField_a_of_type_AndroidAppActivity;
        if (localObject == null) {
          break label136;
        }
        localObject = ((Activity)localObject).getIntent();
        if (localObject == null) {
          break label136;
        }
      }
    }
    label136:
    for (int j = ((Intent)localObject).getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);; j = 0)
    {
      localObject = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g;
      String str = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.j;
      suu localsuu = new suu(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
      localsuu.M(0).W(i).o((String)localObject);
      olh.b(null, str, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(j), "", (String)localObject, localsuu.a().a(), false);
      return;
      i = 0;
      break;
    }
  }
  
  private final void j()
  {
    Object localObject3 = null;
    if (this.jdField_a_of_type_Long > 0L) {
      this.jdField_b_of_type_Long += System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    for (;;)
    {
      try
      {
        Object localObject4 = new suu(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).M(0);
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) {
          break label183;
        }
        Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (localObject1 != null)
        {
          localObject1 = ((VideoInfo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo;
          localObject4 = ((suu)localObject4).b((VideoColumnInfo)localObject1).b(this.jdField_b_of_type_Long).u(this.jdField_e_of_type_Int);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (localObject1 == null) {
            break label188;
          }
          localObject1 = ((QQAppInterface)localObject1).getCurrentUin();
          localObject4 = ((suu)localObject4).m((String)localObject1).a();
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
          {
            VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
            localObject1 = localObject3;
            if (localVideoInfo != null) {
              localObject1 = localVideoInfo.j;
            }
            olh.a(localQQAppInterface, (String)localObject1, "0X800AF2E", "0X800AF2E", 0, 0, "", "", "", ((sut)localObject4).a(), false);
            return;
          }
          localObject1 = "";
          continue;
        }
        localObject2 = null;
      }
      catch (Exception localException)
      {
        return;
      }
      continue;
      label183:
      Object localObject2 = null;
      continue;
      label188:
      localObject2 = null;
    }
  }
  
  private final void k()
  {
    suu localsuu;
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      localsuu = new suu(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      localsuu.O(this.jdField_c_of_type_Int);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject == null) {
        break label78;
      }
    }
    label78:
    for (Object localObject = ((VideoInfo)localObject).j;; localObject = null)
    {
      olh.a(localQQAppInterface, (String)localObject, "0X8009B79", "0X8009B79", 0, 0, "", "", "", localsuu.a().a(), false);
      return;
    }
  }
  
  private final void l()
  {
    VideoFeedsPlayManager localVideoFeedsPlayManager;
    if ((this.jdField_b_of_type_Swm != null) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = false;
      pvm.a().b(this.jdField_a_of_type_Pvq);
      localVideoFeedsPlayManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
      localObject = this.jdField_b_of_type_Swm;
      if (localObject == null) {
        break label55;
      }
    }
    label55:
    for (Object localObject = ((swm)localObject).jdField_a_of_type_Skq;; localObject = null)
    {
      localVideoFeedsPlayManager.a((skq)localObject, false);
      return;
    }
  }
  
  public void A_() {}
  
  public final int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  @Nullable
  public final Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  @NotNull
  public final VideoFeedsPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  }
  
  @Nullable
  public final QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  @Nullable
  public final skq a()
  {
    return this.jdField_a_of_type_Skq;
  }
  
  @NotNull
  public final sly a()
  {
    return this.jdField_a_of_type_Sly;
  }
  
  @Nullable
  public final swm a()
  {
    return this.jdField_b_of_type_Swm;
  }
  
  public void a(@NotNull RecyclerView.ViewHolder paramViewHolder)
  {
    swm localswm = null;
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
    this.jdField_a_of_type_Swm = this.jdField_b_of_type_Swm;
    if ((paramViewHolder instanceof swm))
    {
      this.jdField_b_of_type_Swm = ((swm)paramViewHolder);
      paramViewHolder = this.jdField_b_of_type_Swm;
      if (paramViewHolder != null)
      {
        paramViewHolder = paramViewHolder.jdField_a_of_type_Skq;
        this.jdField_a_of_type_Skq = paramViewHolder;
        skq localskq = this.jdField_a_of_type_Skq;
        paramViewHolder = localswm;
        if (localskq != null) {
          paramViewHolder = localskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramViewHolder;
        paramViewHolder = this.jdField_a_of_type_Skq;
        if (paramViewHolder != null)
        {
          paramViewHolder = paramViewHolder.jdField_a_of_type_Spn;
          if (paramViewHolder != null) {
            paramViewHolder.i();
          }
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Swm != null) && (this.jdField_b_of_type_Swm != null))
      {
        paramViewHolder = this.jdField_a_of_type_Swm;
        if (paramViewHolder != null)
        {
          localswm = this.jdField_b_of_type_Swm;
          if ((localswm != null) && (paramViewHolder.jdField_c_of_type_Int > localswm.jdField_c_of_type_Int)) {
            this.jdField_c_of_type_Int += 1;
          }
        }
      }
      d();
      return;
      paramViewHolder = null;
      break;
      this.jdField_b_of_type_Swm = ((swm)null);
      this.jdField_a_of_type_Skq = ((skq)null);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)null);
    }
  }
  
  public void a(@NotNull RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(@NotNull skq paramskq)
  {
    Intrinsics.checkParameterIsNotNull(paramskq, "playParam");
  }
  
  public void a(@NotNull skq paramskq, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramskq, "playParam");
    if (paramskq.jdField_a_of_type_Spn != null)
    {
      Object localObject = new suq();
      ((suq)localObject).jdField_a_of_type_Long = paramskq.jdField_a_of_type_Spn.a(true);
      spn localspn = paramskq.jdField_a_of_type_Spn;
      Intrinsics.checkExpressionValueIsNotNull(localspn, "playParam.videoPlayer");
      ((suq)localObject).jdField_b_of_type_Long = localspn.b();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendPresenter", 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + ((suq)localObject).jdField_a_of_type_Long + ", detailInfo.currentPlayTime = " + ((suq)localObject).jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      if ((sls.a(jdField_a_of_type_Sls, paramskq)) && (this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppActivity != null)) {
        uld.a(paramskq, (Context)this.jdField_a_of_type_AndroidAppActivity, paramskq.jdField_a_of_type_Spn);
      }
      localObject = this.jdField_b_of_type_Swm;
      if (localObject != null)
      {
        paramInt = ((swm)localObject).jdField_c_of_type_Int;
        localObject = this.jdField_a_of_type_Ulq;
        if (localObject != null) {
          ((ulq)localObject).b(paramInt, paramskq, this.jdField_b_of_type_JavaUtilArrayList);
        }
      }
      c(paramskq, true);
      g(paramskq);
    }
  }
  
  public void a(@NotNull skq paramskq, int paramInt1, int paramInt2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramskq, "playParam");
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
  }
  
  public void a(@NotNull skq paramskq, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramskq, "playParam");
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    label260:
    label263:
    for (;;)
    {
      return;
      VideoInfo localVideoInfo = paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      Object localObject1 = this.jdField_a_of_type_Swm;
      int i;
      Object localObject2;
      long l1;
      label81:
      List localList;
      if (localObject1 != null)
      {
        i = ((swm)localObject1).jdField_c_of_type_Int;
        localObject1 = new suq();
        if (!paramBoolean) {
          break label236;
        }
        localObject2 = paramskq.jdField_a_of_type_Spn;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "playParam.videoPlayer");
        l1 = ((spn)localObject2).b();
        ((suq)localObject1).jdField_b_of_type_Long = l1;
        ((suq)localObject1).jdField_a_of_type_Long = paramskq.jdField_a_of_type_Spn.a(paramBoolean);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        c(paramskq, paramBoolean);
        localList = (List)new ArrayList((Collection)this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        localObject2 = this.jdField_a_of_type_Swm;
        localObject1 = localObject2;
        if (!(localObject2 instanceof swr)) {
          localObject1 = null;
        }
        localObject1 = (swr)localObject1;
        if (localObject1 == null) {
          break label260;
        }
        localObject1 = ((swr)localObject1).g();
        if ((localObject1 == null) || (((TextView)localObject1).getVisibility() != 0)) {
          break label260;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        if (localVideoInfo == null) {
          break label263;
        }
        ThreadManager.excute((Runnable)new VideoFeedsRecommendPresenter.onVideoStop..inlined.let.lambda.1(localVideoInfo, this, localList, paramskq, l2, i, paramBoolean), 16, null, true);
        return;
        i = 0;
        break;
        label236:
        localObject2 = paramskq.jdField_a_of_type_Spn;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "playParam.videoPlayer");
        l1 = ((spn)localObject2).a();
        break label81;
      }
    }
  }
  
  public final void a(@Nullable sln paramsln)
  {
    this.jdField_a_of_type_Sln = paramsln;
  }
  
  public final void a(@Nullable ulq paramulq)
  {
    this.jdField_a_of_type_Ulq = paramulq;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final int b()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public final void b()
  {
    int i = 0;
    Object localObject1;
    if (this.jdField_b_of_type_Swm != null)
    {
      localObject1 = this.jdField_b_of_type_Swm;
      if (localObject1 != null)
      {
        localObject1 = ((swm)localObject1).jdField_a_of_type_Skq;
        label27:
        if (localObject1 == null) {
          break label157;
        }
      }
    }
    label157:
    for (Object localObject2 = ((skq)localObject1).jdField_a_of_type_Spn;; localObject2 = null)
    {
      if (localObject2 != null)
      {
        localObject2 = ((skq)localObject1).jdField_a_of_type_Spn;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "playParam.videoPlayer");
        i = ((spn)localObject2).b();
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendPresenter", 2, "handlePlayButtonClick() status()=" + i);
      }
      switch (i)
      {
      default: 
        return;
        localObject1 = null;
        break label27;
        localObject1 = null;
        break label27;
      }
    }
    if ((sls.a(jdField_a_of_type_Sls, (skq)localObject1)) && (localObject1 != null))
    {
      localObject2 = ((skq)localObject1).jdField_a_of_type_Rpz;
      if (localObject2 != null) {
        ((rpz)localObject2).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a((skq)localObject1, false);
    return;
    if ((sls.a(jdField_a_of_type_Sls, (skq)localObject1)) && (localObject1 != null))
    {
      localObject2 = ((skq)localObject1).jdField_a_of_type_Rpz;
      if (localObject2 != null) {
        ((rpz)localObject2).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c((skq)localObject1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a((skq)localObject1, true);
    return;
    String str1;
    if (localObject1 != null)
    {
      localObject2 = ((skq)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((localObject2 != null) && (((VideoInfo)localObject2).jdField_a_of_type_Int == 0) && (((skq)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
      {
        str1 = ((skq)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        if (localObject1 == null) {
          break label567;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = ((skq)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (localObject2 == null) {
          continue;
        }
        str2 = ((VideoInfo)localObject2).j;
        if (localObject1 == null) {
          continue;
        }
        localObject2 = ((skq)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((VideoInfo)localObject2).g;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        if (localObject1 == null) {
          continue;
        }
        localObject2 = ((skq)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((VideoInfo)localObject2).g;
        if (localObject1 == null) {
          continue;
        }
        localObject3 = ((skq)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (localObject3 == null) {
          continue;
        }
        localObject3 = ((VideoInfo)localObject3).j;
        if (localObject1 == null) {
          continue;
        }
        localObject4 = ((skq)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (localObject4 == null) {
          continue;
        }
        localObject4 = ((VideoInfo)localObject4).jdField_a_of_type_JavaLangString;
        if (localObject1 == null) {
          continue;
        }
        localObject5 = ((skq)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (localObject5 == null) {
          continue;
        }
        localObject5 = ((VideoInfo)localObject5).g;
        long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((skq)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if (localObject1 == null) {
          continue;
        }
        i = ((VideoInfo)localObject1).a();
        olh.a(null, str2, "0X800740D", "0X800740D", 0, 0, "", "", (String)localObject2, omx.a(str1, (String)localObject3, (String)localObject4, (String)localObject5, l, i * 1000, new JSONObject().put("video_type", 0)), false);
      }
      catch (Exception localException)
      {
        String str2;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        label567:
        boolean bool;
        continue;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      return;
      str1 = null;
      break;
      str2 = null;
      continue;
      localObject2 = null;
      continue;
      localObject2 = null;
      continue;
      localObject2 = "0";
      continue;
      localObject3 = null;
      continue;
      localObject4 = null;
      continue;
      localObject5 = null;
      continue;
      i = 0;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    return;
    if ((sls.a(jdField_a_of_type_Sls, (skq)localObject1)) && (localObject1 != null))
    {
      localObject2 = ((skq)localObject1).jdField_a_of_type_Rpz;
      if (localObject2 != null) {
        ((rpz)localObject2).jdField_a_of_type_Boolean = false;
      }
    }
    if (localObject1 != null) {}
    for (bool = ((skq)localObject1).a("continue_pause", false); !bool; bool = false)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    return;
    if ((sls.a(jdField_a_of_type_Sls, (skq)localObject1)) && (localObject1 != null))
    {
      localObject1 = ((skq)localObject1).jdField_a_of_type_Rpz;
      if (localObject1 != null) {
        ((rpz)localObject1).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
  }
  
  public void b(@NotNull RecyclerView.ViewHolder paramViewHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
  }
  
  public void b(@NotNull skq paramskq)
  {
    Intrinsics.checkParameterIsNotNull(paramskq, "playParam");
  }
  
  public void b(@NotNull skq paramskq, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramskq, "playParam");
  }
  
  public final boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public final void c()
  {
    pvm.a().b(this.jdField_a_of_type_Pvq);
    k();
    j();
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)null);
  }
  
  public void c(@NotNull skq paramskq)
  {
    Intrinsics.checkParameterIsNotNull(paramskq, "playParam");
  }
  
  public final boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public final void d()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(jdField_a_of_type_ArrayOfFloat[0]);
    if (this.jdField_b_of_type_Swm != null)
    {
      Object localObject = this.jdField_b_of_type_Swm;
      if (localObject != null)
      {
        localObject = ((swm)localObject).jdField_a_of_type_Sfc;
        if (localObject != null) {
          ((sfc)localObject).b(jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
        }
      }
    }
  }
  
  public void d(@NotNull skq paramskq)
  {
    Intrinsics.checkParameterIsNotNull(paramskq, "playParam");
    Object localObject = this.jdField_b_of_type_Swm;
    if ((localObject != null) && (this.jdField_a_of_type_Ulq != null))
    {
      ulq localulq = this.jdField_a_of_type_Ulq;
      if (localulq != null) {
        localulq.a(((swm)localObject).jdField_c_of_type_Int, paramskq, this.jdField_b_of_type_JavaUtilArrayList);
      }
    }
    olh.a(null, "", "0X800AF11", "0X800AF11", 0, 0, "", "", "", String.valueOf(System.currentTimeMillis()), false);
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaLangString))
    {
      localObject = paramskq.jdField_a_of_type_Spn;
      if (localObject != null) {
        ((spn)localObject).a(this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_JavaLangString = ((String)null);
    }
    g(paramskq);
  }
  
  public final boolean d()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public final void e()
  {
    int i;
    if (this.jdField_b_of_type_Swm != null)
    {
      i = this.jdField_d_of_type_Int;
      if (i < jdField_a_of_type_ArrayOfFloat.length - 1) {
        break label76;
      }
      i = 0;
    }
    for (;;)
    {
      float f = jdField_a_of_type_ArrayOfFloat[i];
      this.jdField_d_of_type_Int = i;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(f);
      Object localObject = this.jdField_b_of_type_Swm;
      if (localObject != null)
      {
        localObject = ((swm)localObject).jdField_a_of_type_Sfc;
        if (localObject != null) {
          ((sfc)localObject).b(jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
        }
      }
      return;
      label76:
      i += 1;
    }
  }
  
  public void e(@Nullable skq paramskq)
  {
    this.jdField_a_of_type_Sly.a(paramskq);
  }
  
  public final void f()
  {
    pvm.a().a(this.jdField_a_of_type_Pvq);
  }
  
  public void f(@NotNull skq paramskq)
  {
    Intrinsics.checkParameterIsNotNull(paramskq, "playParam");
  }
  
  public final void g()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      this.jdField_b_of_type_Long += System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Long = 0L;
    c(this.jdField_a_of_type_Skq, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g());
  }
  
  public final void h()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     slr
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.video;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.ugc.managecolumn.ColumnSubscribeChangeObserver;
import com.tencent.mobileqq.kandian.biz.video.column.VideoColumnDataManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/VideoColumnBannerManager;", "", "context", "Landroid/app/Activity;", "sessionId", "", "fromType", "", "dataList", "", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsAdapter;", "columnDataManager", "Lcom/tencent/mobileqq/kandian/biz/video/column/VideoColumnDataManager;", "action", "Lcom/tencent/mobileqq/kandian/biz/video/VideoColumnBannerManager$IVideoColumnBannerAction;", "(Landroid/app/Activity;Ljava/lang/String;ILjava/util/List;Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsAdapter;Lcom/tencent/mobileqq/kandian/biz/video/column/VideoColumnDataManager;Lcom/tencent/mobileqq/kandian/biz/video/VideoColumnBannerManager$IVideoColumnBannerAction;)V", "getAction", "()Lcom/tencent/mobileqq/kandian/biz/video/VideoColumnBannerManager$IVideoColumnBannerAction;", "getAdapter", "()Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsAdapter;", "animFlagArray", "Landroid/util/SparseBooleanArray;", "animing", "", "getColumnDataManager", "()Lcom/tencent/mobileqq/kandian/biz/video/column/VideoColumnDataManager;", "getContext", "()Landroid/app/Activity;", "getDataList", "()Ljava/util/List;", "getFromType", "()I", "interval", "lightLineLottie", "Lcom/tencent/mobileqq/kandian/base/view/ReadInJoyLottieDrawable;", "onColumnSubscribeChangeObserver", "Lcom/tencent/mobileqq/kandian/biz/ugc/managecolumn/ColumnSubscribeChangeObserver;", "playingHolder", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/videofeeds/ShortVideoItemHolder;", "getSessionId", "()Ljava/lang/String;", "targetPercent", "", "getViolaTopicVideoParam", "Lorg/json/JSONObject;", "data", "videoInfo", "playingVideoHolder", "initView", "", "videoHolder", "jumpToColumnPlay", "videoFromType", "onCenterViewChanged", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/VideoItemHolder;", "onColumnClick", "onDestory", "onProgressChanged", "currentPosMs", "", "durationMs", "onSubscribeBtnClick", "performAnim", "refreshColumnBanner", "refreshColumnData", "refreshColumnIcon", "videoColumnInfo", "Lcom/tencent/mobileqq/kandian/repo/video/entity/VideoColumnInfo;", "refreshColumnText", "refreshFollowState", "updateAllSubscribeData", "columnId", "subscribed", "Companion", "IVideoColumnBannerAction", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoColumnBannerManager
{
  public static final VideoColumnBannerManager.Companion a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  @NotNull
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  private ReadInJoyLottieDrawable jdField_a_of_type_ComTencentMobileqqKandianBaseViewReadInJoyLottieDrawable;
  @NotNull
  private final VideoFeedsAdapter jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
  private ShortVideoItemHolder jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
  private final ColumnSubscribeChangeObserver jdField_a_of_type_ComTencentMobileqqKandianBizUgcManagecolumnColumnSubscribeChangeObserver;
  @Nullable
  private final VideoColumnBannerManager.IVideoColumnBannerAction jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoColumnBannerManager$IVideoColumnBannerAction;
  @NotNull
  private final VideoColumnDataManager jdField_a_of_type_ComTencentMobileqqKandianBizVideoColumnVideoColumnDataManager;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoColumnBannerManager$Companion = new VideoColumnBannerManager.Companion(null);
  }
  
  public VideoColumnBannerManager(@NotNull Activity paramActivity, @NotNull String paramString, int paramInt, @NotNull List<? extends VideoInfo> paramList, @NotNull VideoFeedsAdapter paramVideoFeedsAdapter, @NotNull VideoColumnDataManager paramVideoColumnDataManager, @Nullable VideoColumnBannerManager.IVideoColumnBannerAction paramIVideoColumnBannerAction)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter = paramVideoFeedsAdapter;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoColumnVideoColumnDataManager = paramVideoColumnDataManager;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoColumnBannerManager$IVideoColumnBannerAction = paramIVideoColumnBannerAction;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcManagecolumnColumnSubscribeChangeObserver = ((ColumnSubscribeChangeObserver)new VideoColumnBannerManager.onColumnSubscribeChangeObserver.1(this));
    this.jdField_a_of_type_Int = Aladdin.getConfig(331).getIntegerFromString("videodetail_column_animation_videocount", 5);
    this.jdField_a_of_type_Float = Aladdin.getConfig(331).getFloatFromString("videodetail_column_animation_playprogress", 0.5F);
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("interval=");
      paramActivity.append(this.jdField_a_of_type_Int);
      paramActivity.append(", targetPercent=");
      paramActivity.append(this.jdField_a_of_type_Float);
      QLog.d("VideoColumnBannerManager", 2, paramActivity.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewReadInJoyLottieDrawable = ReadInJoyLottieDrawable.a("https://kd.qpic.cn/kamlin/assets/dea93113d39b484eaa5d72605fc52344_b88d05d2.zip");
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewReadInJoyLottieDrawable;
    if (paramActivity != null) {
      paramActivity.a(false);
    }
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewReadInJoyLottieDrawable;
    if (paramActivity != null) {
      paramActivity.b(false);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a((ReadInJoyObserver)this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcManagecolumnColumnSubscribeChangeObserver);
  }
  
  private final void a(ShortVideoItemHolder paramShortVideoItemHolder)
  {
    paramShortVideoItemHolder.a().inflate();
    Object localObject1 = paramShortVideoItemHolder.p;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = (ViewGroup)((ViewGroup)localObject1).findViewById(2131380615);
    } else {
      localObject1 = null;
    }
    paramShortVideoItemHolder.a((ViewGroup)localObject1);
    ViewGroup localViewGroup = paramShortVideoItemHolder.p;
    localObject1 = localObject2;
    if (localViewGroup != null) {
      localObject1 = (KandianUrlImageView)localViewGroup.findViewById(2131380609);
    }
    paramShortVideoItemHolder.a((KandianUrlImageView)localObject1);
    localObject1 = paramShortVideoItemHolder.b();
    if (localObject1 != null)
    {
      paramShortVideoItemHolder.b((TextView)((ViewGroup)localObject1).findViewById(2131380624));
      paramShortVideoItemHolder.a((TextView)((ViewGroup)localObject1).findViewById(2131380626));
      paramShortVideoItemHolder.a((URLImageView)((ViewGroup)localObject1).findViewById(2131380607));
      paramShortVideoItemHolder.b(((ViewGroup)localObject1).findViewById(2131380631));
      paramShortVideoItemHolder.b((ViewGroup)((ViewGroup)localObject1).findViewById(2131380588));
      paramShortVideoItemHolder.a((ImageView)((ViewGroup)localObject1).findViewById(2131380604));
      paramShortVideoItemHolder.c((TextView)((ViewGroup)localObject1).findViewById(2131380623));
      paramShortVideoItemHolder.d((TextView)((ViewGroup)localObject1).findViewById(2131380625));
      paramShortVideoItemHolder.b((URLImageView)((ViewGroup)localObject1).findViewById(2131380606));
      paramShortVideoItemHolder.e((TextView)((ViewGroup)localObject1).findViewById(2131380627));
      paramShortVideoItemHolder.b((ImageView)((ViewGroup)localObject1).findViewById(2131380605));
    }
  }
  
  private final void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.a != null)
    {
      ShortVideoItemHolder localShortVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
      if (localShortVideoItemHolder != null)
      {
        int i = a(paramVideoInfo, localShortVideoItemHolder, 1, this.jdField_b_of_type_Int);
        paramVideoInfo = new VideoR5.Builder(paramVideoInfo).a(paramVideoInfo.a).j(paramVideoInfo.g).M(0).a("load_page", Integer.valueOf(i)).a();
        Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "VideoR5.Builder(videoInf…                 .build()");
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((AppInterface)RIJQQAppInterfaceUtil.a(), "", "0X800AC2C", "0X800AC2C", 0, 0, "", "", "", paramVideoInfo.a(), false);
      }
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
      if ((localVideoInfo.a != null) && (localVideoInfo.a.jdField_a_of_type_Int == paramInt))
      {
        localVideoInfo.a.jdField_a_of_type_Boolean = paramBoolean;
        VideoColumnInfo localVideoColumnInfo;
        if (paramBoolean)
        {
          localVideoColumnInfo = localVideoInfo.a;
          localVideoColumnInfo.jdField_c_of_type_Int += 1;
        }
        else
        {
          localVideoColumnInfo = localVideoInfo.a;
          localVideoColumnInfo.jdField_c_of_type_Int -= 1;
        }
        if ((Intrinsics.areEqual(paramVideoInfo, localVideoInfo) ^ true)) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(localVideoInfo);
        }
      }
    }
  }
  
  private final void a(VideoColumnInfo paramVideoColumnInfo, ShortVideoItemHolder paramShortVideoItemHolder)
  {
    paramShortVideoItemHolder = paramShortVideoItemHolder.f();
    if (paramShortVideoItemHolder != null)
    {
      if (paramVideoColumnInfo.jdField_a_of_type_Boolean)
      {
        paramShortVideoItemHolder.setTextColor(-7829368);
        paramShortVideoItemHolder.setText((CharSequence)HardCodeUtil.a(2131715970));
        paramShortVideoItemHolder.setBackgroundResource(2130843186);
        return;
      }
      paramShortVideoItemHolder.setTextColor(-1);
      paramShortVideoItemHolder.setText((CharSequence)HardCodeUtil.a(2131715992));
      paramShortVideoItemHolder.setBackgroundResource(2130843107);
    }
  }
  
  private final void b(ShortVideoItemHolder paramShortVideoItemHolder)
  {
    Object localObject = paramShortVideoItemHolder.b();
    int i;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject = paramShortVideoItemHolder.b();
      if ((localObject != null) && (((View)localObject).getVisibility() == 0))
      {
        j = 1;
        break label56;
      }
    }
    int j = 0;
    label56:
    if ((!this.jdField_a_of_type_Boolean) && (i != 0))
    {
      if (j != 0) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      localObject = ValueAnimator.ofInt(new int[] { ViewUtils.a(34.0F), ViewUtils.a(50.0F) }).setDuration(200L);
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new VideoColumnBannerManager.performAnim..inlined.apply.lambda.1(this, paramShortVideoItemHolder));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new VideoColumnBannerManager.performAnim..inlined.apply.lambda.2(this, paramShortVideoItemHolder));
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { ViewUtils.a(40.0F), ViewUtils.a(58.0F) }).setDuration(400L);
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new VideoColumnBannerManager.performAnim..inlined.apply.lambda.3(paramShortVideoItemHolder, (ValueAnimator)localObject));
      localValueAnimator.addListener((Animator.AnimatorListener)new VideoColumnBannerManager.performAnim..inlined.apply.lambda.4(paramShortVideoItemHolder, (ValueAnimator)localObject));
      localValueAnimator.start();
      VideoFeedsHelper.a((View)paramShortVideoItemHolder.b(), 8, (int)400L);
      VideoFeedsHelper.a(paramShortVideoItemHolder.b(), 0, (int)500L);
    }
  }
  
  private final void b(VideoColumnInfo paramVideoColumnInfo, ShortVideoItemHolder paramShortVideoItemHolder)
  {
    String str = paramVideoColumnInfo.jdField_c_of_type_JavaLangString;
    Intrinsics.checkExpressionValueIsNotNull(str, "videoColumnInfo.columnIconUrl");
    int i;
    if (((CharSequence)str).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = ViewUtils.a(38.0F);
      paramVideoColumnInfo = URLDrawable.getDrawable(paramVideoColumnInfo.jdField_c_of_type_JavaLangString, i, i);
      Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "drawable");
      paramVideoColumnInfo.setTag(new int[] { 0, 0, ViewUtils.a(6.0F), 0 });
      paramVideoColumnInfo.setDecodeHandler(URLDrawableDecodeHandler.j);
      paramShortVideoItemHolder = paramShortVideoItemHolder.c();
      if (paramShortVideoItemHolder != null) {
        paramShortVideoItemHolder.setImageDrawable((Drawable)paramVideoColumnInfo);
      }
    }
    else
    {
      paramVideoColumnInfo = paramShortVideoItemHolder.c();
      if (paramVideoColumnInfo != null) {
        paramVideoColumnInfo.setImageDrawable(null);
      }
    }
  }
  
  private final void c(VideoInfo paramVideoInfo, ShortVideoItemHolder paramShortVideoItemHolder)
  {
    Object localObject2 = paramVideoInfo.a;
    if (localObject2 != null)
    {
      QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
      int j = ((VideoColumnInfo)localObject2).jdField_a_of_type_Int;
      boolean bool = ((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean;
      int i = 1;
      Object localObject1 = paramVideoInfo.a;
      if (localObject1 != null)
      {
        localObject1 = ((VideoColumnInfo)localObject1).jdField_c_of_type_JavaLangString;
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      VideoFeedsHelper.a(localQQAppInterface, j, bool ^ true, (String)localObject1);
      a(paramVideoInfo, ((VideoColumnInfo)localObject2).jdField_a_of_type_Int, ((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean ^ true);
      a((VideoColumnInfo)localObject2, paramShortVideoItemHolder);
      if (!((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        i = 2;
      }
      ReadInJoyLogicEngineEventDispatcher.a().a(((VideoColumnInfo)localObject2).jdField_a_of_type_Int, i, ((VideoColumnInfo)localObject2).jdField_c_of_type_Int);
      if (((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        paramShortVideoItemHolder = "0X800A7FB";
      } else {
        paramShortVideoItemHolder = "0X800A7D3";
      }
      localObject2 = new VideoR5.Builder(paramVideoInfo);
      localObject1 = RIJQQAppInterfaceUtil.a();
      if (localObject1 != null) {
        localObject1 = ((QQAppInterface)localObject1).getCurrentUin();
      } else {
        localObject1 = null;
      }
      paramVideoInfo = ((VideoR5.Builder)localObject2).n((String)localObject1).b(paramVideoInfo.a).ab(4).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((AppInterface)RIJQQAppInterfaceUtil.a(), "", paramShortVideoItemHolder, paramShortVideoItemHolder, 0, 0, "", "", "", paramVideoInfo.a(), false);
    }
  }
  
  private final void c(VideoColumnInfo paramVideoColumnInfo, ShortVideoItemHolder paramShortVideoItemHolder)
  {
    Object localObject1 = paramShortVideoItemHolder.b();
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo.i);
    }
    localObject1 = paramShortVideoItemHolder.c();
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo.jdField_b_of_type_JavaLangString);
    }
    Object localObject2;
    if ((paramVideoColumnInfo.jdField_a_of_type_Boolean) && (paramVideoColumnInfo.f > 0))
    {
      localObject1 = paramShortVideoItemHolder.d();
      if (localObject1 != null)
      {
        localObject2 = StringCompanionObject.INSTANCE;
        localObject2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717768);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.resources.getStr…scribed_and_update_count)");
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramVideoColumnInfo.f);
        paramVideoColumnInfo = String.format((String)localObject2, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
        Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo);
      }
      paramVideoColumnInfo = paramShortVideoItemHolder.e();
      if (paramVideoColumnInfo != null) {
        paramVideoColumnInfo.setText((CharSequence)null);
      }
    }
    else if (paramVideoColumnInfo.jdField_a_of_type_Boolean)
    {
      localObject1 = paramShortVideoItemHolder.d();
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131715970));
        ((StringBuilder)localObject2).append("  ");
        ((TextView)localObject1).setText((CharSequence)((StringBuilder)localObject2).toString());
      }
      paramShortVideoItemHolder = paramShortVideoItemHolder.e();
      if (paramShortVideoItemHolder != null)
      {
        localObject1 = StringCompanionObject.INSTANCE;
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717769);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources.getStr…olumn_banner_video_count)");
        localObject2 = new Object[1];
        localObject2[0] = Integer.valueOf(paramVideoColumnInfo.jdField_b_of_type_Int);
        paramVideoColumnInfo = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
        Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
        paramShortVideoItemHolder.setText((CharSequence)paramVideoColumnInfo);
      }
    }
    else
    {
      localObject1 = paramShortVideoItemHolder.d();
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)null);
      }
      paramShortVideoItemHolder = paramShortVideoItemHolder.e();
      if (paramShortVideoItemHolder != null)
      {
        localObject1 = StringCompanionObject.INSTANCE;
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717770);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources.getStr…unt_and_subscribed_count)");
        localObject2 = new Object[2];
        localObject2[0] = Integer.valueOf(paramVideoColumnInfo.jdField_b_of_type_Int);
        localObject2[1] = VideoFeedsHelper.e(paramVideoColumnInfo.jdField_c_of_type_Int);
        paramVideoColumnInfo = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
        Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
        paramShortVideoItemHolder.setText((CharSequence)paramVideoColumnInfo);
      }
    }
  }
  
  public final int a(@NotNull VideoInfo paramVideoInfo, @NotNull ShortVideoItemHolder paramShortVideoItemHolder, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramShortVideoItemHolder, "playingVideoHolder");
    if (paramVideoInfo.a != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoColumnBannerManager$IVideoColumnBannerAction;
      if (localObject != null) {
        ((VideoColumnBannerManager.IVideoColumnBannerAction)localObject).i();
      }
      if ((PlayerHelper.a.a()) && (ReadInJoyHelper.c(paramInt2)))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoColumnVideoColumnDataManager.a(String.valueOf(paramVideoInfo.a.jdField_a_of_type_Int), (Function1)new VideoColumnBannerManager.jumpToColumnPlay.1(this, paramShortVideoItemHolder, paramVideoInfo, paramInt1, paramInt2));
        return 2;
      }
      paramShortVideoItemHolder = (Context)this.jdField_a_of_type_AndroidAppActivity;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://viola.qq.com/js/columnDetail.js?_rij_violaUrl=1&v_tid=6&v_bundleName=columnDetail&v_bid=3740&hideNav=1&statusColor=1&v_present_titleHeight=44&v_nav_immer=1&rowkey=");
      ((StringBuilder)localObject).append(paramVideoInfo.g);
      ((StringBuilder)localObject).append("&topicId=");
      ((StringBuilder)localObject).append(String.valueOf(paramVideoInfo.a.jdField_a_of_type_Int));
      ViolaAccessHelper.a(paramShortVideoItemHolder, "", ((StringBuilder)localObject).toString(), null);
    }
    return 1;
  }
  
  @NotNull
  public final Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  @NotNull
  public final JSONObject a(@NotNull String paramString, @NotNull VideoInfo paramVideoInfo, @NotNull ShortVideoItemHolder paramShortVideoItemHolder, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void a()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b((ReadInJoyObserver)this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcManagecolumnColumnSubscribeChangeObserver);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @NotNull ShortVideoItemHolder paramShortVideoItemHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramShortVideoItemHolder, "videoHolder");
    Object localObject = paramShortVideoItemHolder.b();
    int i;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = paramVideoInfo.a;
    if ((localObject != null) && (((VideoColumnInfo)localObject).e == 2) && (i == 0))
    {
      b(paramVideoInfo, paramShortVideoItemHolder);
      return;
    }
    localObject = paramVideoInfo.a;
    if ((localObject != null) && (((VideoColumnInfo)localObject).e == 2))
    {
      paramVideoInfo = paramVideoInfo.a;
      Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoInfo.videoColumnInfo");
      a(paramVideoInfo, paramShortVideoItemHolder);
    }
  }
  
  public final void a(@NotNull VideoItemHolder paramVideoItemHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoItemHolder, "videoHolder");
    VideoItemHolder localVideoItemHolder = paramVideoItemHolder;
    if (!(paramVideoItemHolder instanceof ShortVideoItemHolder)) {
      localVideoItemHolder = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder = ((ShortVideoItemHolder)localVideoItemHolder);
    paramVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
    if (paramVideoItemHolder != null)
    {
      paramVideoItemHolder = paramVideoItemHolder.a();
      if (paramVideoItemHolder != null) {
        paramVideoItemHolder.setVisibility(8);
      }
    }
    paramVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
    if (paramVideoItemHolder != null)
    {
      paramVideoItemHolder = paramVideoItemHolder.a();
      if (paramVideoItemHolder != null) {
        paramVideoItemHolder.setImageDrawable((Drawable)this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewReadInJoyLottieDrawable);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public final void a(@NotNull VideoItemHolder paramVideoItemHolder, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoItemHolder, "videoHolder");
    int i = paramVideoItemHolder.jdField_b_of_type_Int;
    if ((ReadInJoyHelper.d(this.jdField_b_of_type_Int)) && (i == 0)) {
      return;
    }
    VideoItemHolder localVideoItemHolder;
    if (!(paramVideoItemHolder instanceof ShortVideoItemHolder)) {
      localVideoItemHolder = null;
    } else {
      localVideoItemHolder = paramVideoItemHolder;
    }
    if ((ShortVideoItemHolder)localVideoItemHolder != null)
    {
      int j = this.jdField_a_of_type_Int;
      if ((j > 0) && (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i / j)) && (paramLong2 > 0L) && ((float)paramLong1 / (float)paramLong2 > this.jdField_a_of_type_Float))
      {
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray.append(i / this.jdField_a_of_type_Int, true);
        b((ShortVideoItemHolder)paramVideoItemHolder);
      }
    }
  }
  
  public final void b(@NotNull VideoInfo paramVideoInfo, @NotNull ShortVideoItemHolder paramShortVideoItemHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramShortVideoItemHolder, "videoHolder");
    Object localObject1 = paramVideoInfo.a;
    if ((localObject1 != null) && (((VideoColumnInfo)localObject1).e == 2))
    {
      if (paramShortVideoItemHolder.b() == null) {
        a(paramShortVideoItemHolder);
      }
      localObject1 = paramShortVideoItemHolder.b();
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.b();
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(0);
      }
      localObject1 = paramShortVideoItemHolder.b();
      if (localObject1 != null)
      {
        localObject1 = ((ViewGroup)localObject1).getLayoutParams();
        if (localObject1 != null) {
          ((ViewGroup.LayoutParams)localObject1).height = ViewUtils.a(40.0F);
        }
      }
      localObject1 = paramShortVideoItemHolder.b();
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)new VideoColumnBannerManager.refreshColumnBanner.1(this, paramVideoInfo));
      }
      localObject1 = paramShortVideoItemHolder.b();
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(0);
      }
      localObject1 = paramShortVideoItemHolder.f();
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.f();
      if (localObject1 != null) {
        ((TextView)localObject1).setOnClickListener((View.OnClickListener)new VideoColumnBannerManager.refreshColumnBanner.2(this, paramVideoInfo, paramShortVideoItemHolder));
      }
      localObject1 = paramShortVideoItemHolder.b();
      if (localObject1 != null) {
        ((URLImageView)localObject1).setVisibility(0);
      }
      localObject1 = paramShortVideoItemHolder.c();
      if (localObject1 != null) {
        ((URLImageView)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.b();
      if (localObject1 != null) {
        localObject1 = ((TextView)localObject1).getLayoutParams();
      } else {
        localObject1 = null;
      }
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        localObject2 = null;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
      if (localObject1 != null) {
        ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = ViewUtils.a(34.0F);
      }
      localObject1 = paramShortVideoItemHolder.d();
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.e();
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.a();
      if (localObject1 != null) {
        ((KandianUrlImageView)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.c();
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.b();
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(-1186049);
      }
      localObject1 = paramShortVideoItemHolder.c();
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(-1186049);
      }
      localObject1 = paramShortVideoItemHolder.b();
      if (localObject1 != null) {
        ((ImageView)localObject1).setImageResource(2130843219);
      }
      localObject1 = paramVideoInfo.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoInfo.videoColumnInfo");
      c((VideoColumnInfo)localObject1, paramShortVideoItemHolder);
      localObject1 = paramVideoInfo.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoInfo.videoColumnInfo");
      b((VideoColumnInfo)localObject1, paramShortVideoItemHolder);
      paramVideoInfo = paramVideoInfo.a;
      Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoInfo.videoColumnInfo");
      a(paramVideoInfo, paramShortVideoItemHolder);
      VideoFeedsHelper.a((View)paramShortVideoItemHolder.b(), 200);
      return;
    }
    if (paramShortVideoItemHolder.b() != null)
    {
      paramVideoInfo = paramShortVideoItemHolder.b();
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoColumnBannerManager
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
  public static final VideoColumnBannerManager.Companion a = new VideoColumnBannerManager.Companion(null);
  private SparseBooleanArray b;
  private boolean c;
  private int d;
  private float e;
  private ShortVideoItemHolder f;
  private ReadInJoyLottieDrawable g;
  private final ColumnSubscribeChangeObserver h;
  @NotNull
  private final Activity i;
  @NotNull
  private final String j;
  private final int k;
  @NotNull
  private final List<VideoInfo> l;
  @NotNull
  private final VideoFeedsAdapter m;
  @NotNull
  private final VideoColumnDataManager n;
  @Nullable
  private final VideoColumnBannerManager.IVideoColumnBannerAction o;
  
  public VideoColumnBannerManager(@NotNull Activity paramActivity, @NotNull String paramString, int paramInt, @NotNull List<? extends VideoInfo> paramList, @NotNull VideoFeedsAdapter paramVideoFeedsAdapter, @NotNull VideoColumnDataManager paramVideoColumnDataManager, @Nullable VideoColumnBannerManager.IVideoColumnBannerAction paramIVideoColumnBannerAction)
  {
    this.i = paramActivity;
    this.j = paramString;
    this.k = paramInt;
    this.l = paramList;
    this.m = paramVideoFeedsAdapter;
    this.n = paramVideoColumnDataManager;
    this.o = paramIVideoColumnBannerAction;
    this.b = new SparseBooleanArray();
    this.h = ((ColumnSubscribeChangeObserver)new VideoColumnBannerManager.onColumnSubscribeChangeObserver.1(this));
    this.d = Aladdin.getConfig(331).getIntegerFromString("videodetail_column_animation_videocount", 5);
    this.e = Aladdin.getConfig(331).getFloatFromString("videodetail_column_animation_playprogress", 0.5F);
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("interval=");
      paramActivity.append(this.d);
      paramActivity.append(", targetPercent=");
      paramActivity.append(this.e);
      QLog.d("VideoColumnBannerManager", 2, paramActivity.toString());
    }
    this.g = ReadInJoyLottieDrawable.a("https://kd.qpic.cn/kamlin/assets/dea93113d39b484eaa5d72605fc52344_b88d05d2.zip");
    paramActivity = this.g;
    if (paramActivity != null) {
      paramActivity.a(false);
    }
    paramActivity = this.g;
    if (paramActivity != null) {
      paramActivity.b(false);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a((ReadInJoyObserver)this.h);
  }
  
  private final void a(ShortVideoItemHolder paramShortVideoItemHolder)
  {
    paramShortVideoItemHolder.i().inflate();
    Object localObject1 = paramShortVideoItemHolder.aZ;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = (ViewGroup)((ViewGroup)localObject1).findViewById(2131449573);
    } else {
      localObject1 = null;
    }
    paramShortVideoItemHolder.a((ViewGroup)localObject1);
    ViewGroup localViewGroup = paramShortVideoItemHolder.aZ;
    localObject1 = localObject2;
    if (localViewGroup != null) {
      localObject1 = (KandianUrlImageView)localViewGroup.findViewById(2131449567);
    }
    paramShortVideoItemHolder.a((KandianUrlImageView)localObject1);
    localObject1 = paramShortVideoItemHolder.k();
    if (localObject1 != null)
    {
      paramShortVideoItemHolder.b((TextView)((ViewGroup)localObject1).findViewById(2131449582));
      paramShortVideoItemHolder.a((TextView)((ViewGroup)localObject1).findViewById(2131449584));
      paramShortVideoItemHolder.a((URLImageView)((ViewGroup)localObject1).findViewById(2131449565));
      paramShortVideoItemHolder.b(((ViewGroup)localObject1).findViewById(2131449589));
      paramShortVideoItemHolder.b((ViewGroup)((ViewGroup)localObject1).findViewById(2131449546));
      paramShortVideoItemHolder.a((ImageView)((ViewGroup)localObject1).findViewById(2131449562));
      paramShortVideoItemHolder.c((TextView)((ViewGroup)localObject1).findViewById(2131449581));
      paramShortVideoItemHolder.d((TextView)((ViewGroup)localObject1).findViewById(2131449583));
      paramShortVideoItemHolder.b((URLImageView)((ViewGroup)localObject1).findViewById(2131449564));
      paramShortVideoItemHolder.e((TextView)((ViewGroup)localObject1).findViewById(2131449585));
      paramShortVideoItemHolder.b((ImageView)((ViewGroup)localObject1).findViewById(2131449563));
    }
  }
  
  private final void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.ay != null)
    {
      ShortVideoItemHolder localShortVideoItemHolder = this.f;
      if (localShortVideoItemHolder != null)
      {
        int i1 = a(paramVideoInfo, localShortVideoItemHolder, 1, this.k);
        paramVideoInfo = new VideoR5.Builder(paramVideoInfo).a(paramVideoInfo.ay).k(paramVideoInfo.l).M(0).b("load_page", Integer.valueOf(i1)).b();
        Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "VideoR5.Builder(videoInf…                 .build()");
        PublicAccountReportUtils.a((AppInterface)RIJQQAppInterfaceUtil.a(), "", "0X800AC2C", "0X800AC2C", 0, 0, "", "", "", paramVideoInfo.a(), false);
      }
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
      if ((localVideoInfo.ay != null) && (localVideoInfo.ay.b == paramInt))
      {
        localVideoInfo.ay.h = paramBoolean;
        VideoColumnInfo localVideoColumnInfo;
        if (paramBoolean)
        {
          localVideoColumnInfo = localVideoInfo.ay;
          localVideoColumnInfo.g += 1;
        }
        else
        {
          localVideoColumnInfo = localVideoInfo.ay;
          localVideoColumnInfo.g -= 1;
        }
        if ((Intrinsics.areEqual(paramVideoInfo, localVideoInfo) ^ true)) {
          this.m.a(localVideoInfo);
        }
      }
    }
  }
  
  private final void a(VideoColumnInfo paramVideoColumnInfo, ShortVideoItemHolder paramShortVideoItemHolder)
  {
    paramShortVideoItemHolder = paramShortVideoItemHolder.s();
    if (paramShortVideoItemHolder != null)
    {
      if (paramVideoColumnInfo.h)
      {
        paramShortVideoItemHolder.setTextColor(-7829368);
        paramShortVideoItemHolder.setText((CharSequence)HardCodeUtil.a(2131913424));
        paramShortVideoItemHolder.setBackgroundResource(2130844140);
        return;
      }
      paramShortVideoItemHolder.setTextColor(-1);
      paramShortVideoItemHolder.setText((CharSequence)HardCodeUtil.a(2131913444));
      paramShortVideoItemHolder.setBackgroundResource(2130844062);
    }
  }
  
  private final void b(ShortVideoItemHolder paramShortVideoItemHolder)
  {
    Object localObject = paramShortVideoItemHolder.k();
    int i1;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      localObject = paramShortVideoItemHolder.j();
      if ((localObject != null) && (((View)localObject).getVisibility() == 0))
      {
        i2 = 1;
        break label56;
      }
    }
    int i2 = 0;
    label56:
    if ((!this.c) && (i1 != 0))
    {
      if (i2 != 0) {
        return;
      }
      this.c = true;
      localObject = ValueAnimator.ofInt(new int[] { ViewUtils.dip2px(34.0F), ViewUtils.dip2px(50.0F) }).setDuration(200L);
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new VideoColumnBannerManager.performAnim..inlined.apply.lambda.1(this, paramShortVideoItemHolder));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new VideoColumnBannerManager.performAnim..inlined.apply.lambda.2(this, paramShortVideoItemHolder));
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { ViewUtils.dip2px(40.0F), ViewUtils.dip2px(58.0F) }).setDuration(400L);
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new VideoColumnBannerManager.performAnim..inlined.apply.lambda.3(paramShortVideoItemHolder, (ValueAnimator)localObject));
      localValueAnimator.addListener((Animator.AnimatorListener)new VideoColumnBannerManager.performAnim..inlined.apply.lambda.4(paramShortVideoItemHolder, (ValueAnimator)localObject));
      localValueAnimator.start();
      VideoFeedsHelper.a((View)paramShortVideoItemHolder.p(), 8, (int)400L);
      VideoFeedsHelper.a(paramShortVideoItemHolder.j(), 0, (int)500L);
    }
  }
  
  private final void b(VideoColumnInfo paramVideoColumnInfo, ShortVideoItemHolder paramShortVideoItemHolder)
  {
    String str = paramVideoColumnInfo.d;
    Intrinsics.checkExpressionValueIsNotNull(str, "videoColumnInfo.columnIconUrl");
    int i1;
    if (((CharSequence)str).length() > 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      i1 = ViewUtils.dip2px(38.0F);
      paramVideoColumnInfo = URLDrawable.getDrawable(paramVideoColumnInfo.d, i1, i1);
      Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "drawable");
      paramVideoColumnInfo.setTag(new int[] { 0, 0, ViewUtils.dip2px(6.0F), 0 });
      paramVideoColumnInfo.setDecodeHandler(URLDrawableDecodeHandler.k);
      paramShortVideoItemHolder = paramShortVideoItemHolder.m();
      if (paramShortVideoItemHolder != null) {
        paramShortVideoItemHolder.setImageDrawable((Drawable)paramVideoColumnInfo);
      }
    }
    else
    {
      paramVideoColumnInfo = paramShortVideoItemHolder.m();
      if (paramVideoColumnInfo != null) {
        paramVideoColumnInfo.setImageDrawable(null);
      }
    }
  }
  
  private final void c(VideoInfo paramVideoInfo, ShortVideoItemHolder paramShortVideoItemHolder)
  {
    Object localObject2 = paramVideoInfo.ay;
    if (localObject2 != null)
    {
      QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
      int i2 = ((VideoColumnInfo)localObject2).b;
      boolean bool = ((VideoColumnInfo)localObject2).h;
      int i1 = 1;
      Object localObject1 = paramVideoInfo.ay;
      if (localObject1 != null)
      {
        localObject1 = ((VideoColumnInfo)localObject1).d;
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      VideoFeedsHelper.a(localQQAppInterface, i2, bool ^ true, (String)localObject1);
      a(paramVideoInfo, ((VideoColumnInfo)localObject2).b, ((VideoColumnInfo)localObject2).h ^ true);
      a((VideoColumnInfo)localObject2, paramShortVideoItemHolder);
      if (!((VideoColumnInfo)localObject2).h) {
        i1 = 2;
      }
      ReadInJoyLogicEngineEventDispatcher.a().a(((VideoColumnInfo)localObject2).b, i1, ((VideoColumnInfo)localObject2).g);
      if (((VideoColumnInfo)localObject2).h) {
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
      paramVideoInfo = ((VideoR5.Builder)localObject2).o((String)localObject1).b(paramVideoInfo.ay).ac(4).b();
      PublicAccountReportUtils.a((AppInterface)RIJQQAppInterfaceUtil.a(), "", paramShortVideoItemHolder, paramShortVideoItemHolder, 0, 0, "", "", "", paramVideoInfo.a(), false);
    }
  }
  
  private final void c(VideoColumnInfo paramVideoColumnInfo, ShortVideoItemHolder paramShortVideoItemHolder)
  {
    Object localObject1 = paramShortVideoItemHolder.n();
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo.s);
    }
    localObject1 = paramShortVideoItemHolder.o();
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo.c);
    }
    Object localObject2;
    if ((paramVideoColumnInfo.h) && (paramVideoColumnInfo.v > 0))
    {
      localObject1 = paramShortVideoItemHolder.q();
      if (localObject1 != null)
      {
        localObject2 = StringCompanionObject.INSTANCE;
        localObject2 = this.i.getResources().getString(2131915243);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.resources.getStr…scribed_and_update_count)");
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramVideoColumnInfo.v);
        paramVideoColumnInfo = String.format((String)localObject2, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
        Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo);
      }
      paramVideoColumnInfo = paramShortVideoItemHolder.r();
      if (paramVideoColumnInfo != null) {
        paramVideoColumnInfo.setText((CharSequence)null);
      }
    }
    else if (paramVideoColumnInfo.h)
    {
      localObject1 = paramShortVideoItemHolder.q();
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131913424));
        ((StringBuilder)localObject2).append("  ");
        ((TextView)localObject1).setText((CharSequence)((StringBuilder)localObject2).toString());
      }
      paramShortVideoItemHolder = paramShortVideoItemHolder.r();
      if (paramShortVideoItemHolder != null)
      {
        localObject1 = StringCompanionObject.INSTANCE;
        localObject1 = this.i.getResources().getString(2131915244);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources.getStr…olumn_banner_video_count)");
        localObject2 = new Object[1];
        localObject2[0] = Integer.valueOf(paramVideoColumnInfo.f);
        paramVideoColumnInfo = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
        Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
        paramShortVideoItemHolder.setText((CharSequence)paramVideoColumnInfo);
      }
    }
    else
    {
      localObject1 = paramShortVideoItemHolder.q();
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)null);
      }
      paramShortVideoItemHolder = paramShortVideoItemHolder.r();
      if (paramShortVideoItemHolder != null)
      {
        localObject1 = StringCompanionObject.INSTANCE;
        localObject1 = this.i.getResources().getString(2131915245);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources.getStr…unt_and_subscribed_count)");
        localObject2 = new Object[2];
        localObject2[0] = Integer.valueOf(paramVideoColumnInfo.f);
        localObject2[1] = VideoFeedsHelper.e(paramVideoColumnInfo.g);
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
    if (paramVideoInfo.ay != null)
    {
      Object localObject = this.o;
      if (localObject != null) {
        ((VideoColumnBannerManager.IVideoColumnBannerAction)localObject).v();
      }
      if ((PlayerHelper.a.a()) && (ReadInJoyHelper.m(paramInt2)))
      {
        this.n.a(String.valueOf(paramVideoInfo.ay.b), (Function1)new VideoColumnBannerManager.jumpToColumnPlay.1(this, paramShortVideoItemHolder, paramVideoInfo, paramInt1, paramInt2));
        return 2;
      }
      paramShortVideoItemHolder = (Context)this.i;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://viola.qq.com/js/columnDetail.js?_rij_violaUrl=1&v_tid=6&v_bundleName=columnDetail&v_bid=3740&hideNav=1&statusColor=1&v_present_titleHeight=44&v_nav_immer=1&rowkey=");
      ((StringBuilder)localObject).append(paramVideoInfo.l);
      ((StringBuilder)localObject).append("&topicId=");
      ((StringBuilder)localObject).append(String.valueOf(paramVideoInfo.ay.b));
      ViolaAccessHelper.a(paramShortVideoItemHolder, "", ((StringBuilder)localObject).toString(), null);
    }
    return 1;
  }
  
  @NotNull
  public final JSONObject a(@NotNull String paramString, @NotNull VideoInfo paramVideoInfo, @NotNull ShortVideoItemHolder paramShortVideoItemHolder, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void a()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b((ReadInJoyObserver)this.h);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @NotNull ShortVideoItemHolder paramShortVideoItemHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramShortVideoItemHolder, "videoHolder");
    Object localObject = paramShortVideoItemHolder.k();
    int i1;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    localObject = paramVideoInfo.ay;
    if ((localObject != null) && (((VideoColumnInfo)localObject).u == 2) && (i1 == 0))
    {
      b(paramVideoInfo, paramShortVideoItemHolder);
      return;
    }
    localObject = paramVideoInfo.ay;
    if ((localObject != null) && (((VideoColumnInfo)localObject).u == 2))
    {
      paramVideoInfo = paramVideoInfo.ay;
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
    this.f = ((ShortVideoItemHolder)localVideoItemHolder);
    paramVideoItemHolder = this.f;
    if (paramVideoItemHolder != null)
    {
      paramVideoItemHolder = paramVideoItemHolder.t();
      if (paramVideoItemHolder != null) {
        paramVideoItemHolder.setVisibility(8);
      }
    }
    paramVideoItemHolder = this.f;
    if (paramVideoItemHolder != null)
    {
      paramVideoItemHolder = paramVideoItemHolder.t();
      if (paramVideoItemHolder != null) {
        paramVideoItemHolder.setImageDrawable((Drawable)this.g);
      }
    }
    this.c = false;
  }
  
  public final void a(@NotNull VideoItemHolder paramVideoItemHolder, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoItemHolder, "videoHolder");
    int i1 = paramVideoItemHolder.Y;
    if ((ReadInJoyHelper.n(this.k)) && (i1 == 0)) {
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
      int i2 = this.d;
      if ((i2 > 0) && (!this.b.get(i1 / i2)) && (paramLong2 > 0L) && ((float)paramLong1 / (float)paramLong2 > this.e))
      {
        this.b.append(i1 / this.d, true);
        b((ShortVideoItemHolder)paramVideoItemHolder);
      }
    }
  }
  
  @NotNull
  public final Activity b()
  {
    return this.i;
  }
  
  public final void b(@NotNull VideoInfo paramVideoInfo, @NotNull ShortVideoItemHolder paramShortVideoItemHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramShortVideoItemHolder, "videoHolder");
    Object localObject1 = paramVideoInfo.ay;
    if ((localObject1 != null) && (((VideoColumnInfo)localObject1).u == 2))
    {
      if (paramShortVideoItemHolder.k() == null) {
        a(paramShortVideoItemHolder);
      }
      localObject1 = paramShortVideoItemHolder.j();
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.p();
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(0);
      }
      localObject1 = paramShortVideoItemHolder.k();
      if (localObject1 != null)
      {
        localObject1 = ((ViewGroup)localObject1).getLayoutParams();
        if (localObject1 != null) {
          ((ViewGroup.LayoutParams)localObject1).height = ViewUtils.dip2px(40.0F);
        }
      }
      localObject1 = paramShortVideoItemHolder.k();
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)new VideoColumnBannerManager.refreshColumnBanner.1(this, paramVideoInfo));
      }
      localObject1 = paramShortVideoItemHolder.k();
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(0);
      }
      localObject1 = paramShortVideoItemHolder.s();
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.s();
      if (localObject1 != null) {
        ((TextView)localObject1).setOnClickListener((View.OnClickListener)new VideoColumnBannerManager.refreshColumnBanner.2(this, paramVideoInfo, paramShortVideoItemHolder));
      }
      localObject1 = paramShortVideoItemHolder.l();
      if (localObject1 != null) {
        ((URLImageView)localObject1).setVisibility(0);
      }
      localObject1 = paramShortVideoItemHolder.m();
      if (localObject1 != null) {
        ((URLImageView)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.n();
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
        ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = ViewUtils.dip2px(34.0F);
      }
      localObject1 = paramShortVideoItemHolder.q();
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.r();
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.t();
      if (localObject1 != null) {
        ((KandianUrlImageView)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.u();
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      localObject1 = paramShortVideoItemHolder.n();
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(-1186049);
      }
      localObject1 = paramShortVideoItemHolder.o();
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(-1186049);
      }
      localObject1 = paramShortVideoItemHolder.p();
      if (localObject1 != null) {
        ((ImageView)localObject1).setImageResource(2130844173);
      }
      localObject1 = paramVideoInfo.ay;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoInfo.videoColumnInfo");
      c((VideoColumnInfo)localObject1, paramShortVideoItemHolder);
      localObject1 = paramVideoInfo.ay;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoInfo.videoColumnInfo");
      b((VideoColumnInfo)localObject1, paramShortVideoItemHolder);
      paramVideoInfo = paramVideoInfo.ay;
      Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoInfo.videoColumnInfo");
      a(paramVideoInfo, paramShortVideoItemHolder);
      VideoFeedsHelper.c((View)paramShortVideoItemHolder.k(), 200);
      return;
    }
    if (paramShortVideoItemHolder.k() != null)
    {
      paramVideoInfo = paramShortVideoItemHolder.k();
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoColumnBannerManager
 * JD-Core Version:    0.7.0.1
 */
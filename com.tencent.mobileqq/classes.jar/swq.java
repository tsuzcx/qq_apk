import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.LocationInfo;
import com.tencent.biz.pubaccount.VideoInfo.SubscriptInfo;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAioGuideView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGradientMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/ShortVideoItemDelegate;", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/CommonVideoItemDelegate;", "videoHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/ShortVideoItemHolder;", "presenter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "(Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/ShortVideoItemHolder;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;)V", "getRewardCoinIconRes", "", "info", "Lcom/tencent/biz/pubaccount/VideoInfo;", "innerAdjustLogoUI", "", "logoImageView", "Landroid/widget/ImageView;", "videoInfo", "isFullScreen", "", "innerAdjustSeekbarLayout", "isAlignBottom", "innerConfigLocationLayout", "innerConfigPlayCountTextView", "textView", "Landroid/widget/TextView;", "innerSetLogoImageView", "onCommentComponentVisiblityChanged", "visibility", "onMenuDataChanged", "onScreenOrientationChanged", "onVideoClick", "onVideoDoubleClick", "actionX", "actionY", "isZanStatusChanged", "refreshAvatorAndNickName", "refreshContentUI", "isNeedReloadTitle", "refreshMenuUI", "resetVideoAreaLayoutParams", "isCommentShowing", "setAccountVIcon", "setControllerVisibility", "updateFollowStateAndUI", "needAnim", "updateSubscript", "yourFollowTextHasShowed", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class swq
  extends swn
{
  private final swr a;
  
  public swq(@NotNull swr paramswr, @NotNull slr paramslr, @NotNull shl paramshl)
  {
    super((swu)paramswr, paramslr, paramshl);
    this.jdField_a_of_type_Swr = paramswr;
    if ((this.jdField_a_of_type_Swr.k != null) && (six.a(paramslr.a())) && (Aladdin.getConfig(324).getIntegerFromString("videodetail_videogravity_style", 0) == 1))
    {
      paramswr = this.jdField_a_of_type_Swr;
      paramslr = this.jdField_a_of_type_Swr.k;
      if (paramslr == null) {
        break label108;
      }
      paramslr = paramslr.getLayoutParams();
      if (paramslr == null) {
        break label108;
      }
    }
    label108:
    for (int i = paramslr.height;; i = 0)
    {
      paramswr.jdField_d_of_type_Int = i;
      return;
    }
  }
  
  private final void a(ImageView paramImageView, VideoInfo paramVideoInfo)
  {
    if ((paramImageView == null) || (paramVideoInfo == null)) {
      return;
    }
    if ((!six.e()) || (TextUtils.isEmpty((CharSequence)paramVideoInfo.u)))
    {
      paramImageView.setVisibility(8);
      return;
    }
    Object localObject = paramVideoInfo.u;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "videoInfo.videoLogoUrl");
    if (StringsKt.endsWith$default((String)localObject, "zip", false, 2, null))
    {
      pta localpta = pta.a(paramVideoInfo.u);
      Intrinsics.checkExpressionValueIsNotNull(localpta, "mLottieDrawable");
      localpta.setRepeatCount(0);
      paramImageView.setImageDrawable((Drawable)localpta);
      if ((paramImageView.getVisibility() == 8) && (this.jdField_a_of_type_Slr.a().d()))
      {
        localObject = this.jdField_a_of_type_Slr.a();
        if (localObject == null) {
          break label153;
        }
        localObject = ((swm)localObject).jdField_a_of_type_Skq;
        if (localObject == null) {
          break label153;
        }
        localObject = ((skq)localObject).a;
        if (localObject == paramVideoInfo) {
          localpta.playAnimation();
        }
      }
    }
    for (;;)
    {
      paramImageView.setVisibility(0);
      return;
      label153:
      localObject = null;
      break;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      paramImageView.setImageDrawable((Drawable)URLDrawable.getDrawable(paramVideoInfo.u, (URLDrawable.URLDrawableOptions)localObject));
    }
  }
  
  private final void a(ImageView paramImageView, VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Activity localActivity2 = null;
    Activity localActivity1 = null;
    int[] arrayOfInt;
    if ((paramImageView != null) && (paramImageView.getVisibility() == 0))
    {
      arrayOfInt = paramVideoInfo.a(this.jdField_a_of_type_Slr.a(), paramBoolean, this.jdField_a_of_type_Swr.jdField_d_of_type_Int);
      if ((arrayOfInt[0] >= 0) && (arrayOfInt[1] >= 0)) {}
    }
    else
    {
      return;
    }
    Object localObject = paramImageView.getLayoutParams();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject = (FrameLayout.LayoutParams)localObject;
    ((FrameLayout.LayoutParams)localObject).topMargin = arrayOfInt[0];
    ((FrameLayout.LayoutParams)localObject).rightMargin = arrayOfInt[1];
    if ((paramBoolean) || (paramVideoInfo.b(this.jdField_a_of_type_Slr.a())))
    {
      paramVideoInfo = this.jdField_a_of_type_Slr.a();
      if (paramVideoInfo != null) {}
      for (paramVideoInfo = paramVideoInfo.getResources();; paramVideoInfo = null)
      {
        ((FrameLayout.LayoutParams)localObject).width = AIOUtils.dp2px(91.0F, paramVideoInfo);
        localActivity2 = this.jdField_a_of_type_Slr.a();
        paramVideoInfo = localActivity1;
        if (localActivity2 != null) {
          paramVideoInfo = localActivity2.getResources();
        }
        ((FrameLayout.LayoutParams)localObject).height = AIOUtils.dp2px(28.0F, paramVideoInfo);
        paramImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
    }
    paramVideoInfo = this.jdField_a_of_type_Slr.a();
    if (paramVideoInfo != null) {}
    for (paramVideoInfo = paramVideoInfo.getResources();; paramVideoInfo = null)
    {
      ((FrameLayout.LayoutParams)localObject).width = AIOUtils.dp2px(78.0F, paramVideoInfo);
      localActivity1 = this.jdField_a_of_type_Slr.a();
      paramVideoInfo = localActivity2;
      if (localActivity1 != null) {
        paramVideoInfo = localActivity1.getResources();
      }
      ((FrameLayout.LayoutParams)localObject).height = AIOUtils.dp2px(24.0F, paramVideoInfo);
      break;
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    if ((paramVideoInfo.jdField_a_of_type_Int != 0) && (paramVideoInfo.jdField_a_of_type_Int != 5) && (paramVideoInfo.jdField_r_of_type_Int > 0))
    {
      paramTextView.setText((CharSequence)six.a(paramVideoInfo.jdField_r_of_type_Int));
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private final void a(VideoInfo paramVideoInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    TextView localTextView = this.jdField_a_of_type_Swr.jdField_d_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      if ((paramBoolean1) || (paramVideoInfo.q)) {
        break label117;
      }
    }
    label139:
    for (;;)
    {
      if ((i != 0) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo != null))
      {
        localTextView.setVisibility(0);
        localTextView.setText((CharSequence)paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo.jdField_a_of_type_JavaLangString);
        localTextView.setTextColor(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo.jdField_a_of_type_Int);
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SubscriptInfo.b);
        localGradientDrawable.setCornerRadius(ViewUtils.dip2px(4.0F));
        localTextView.setBackgroundDrawable((Drawable)localGradientDrawable);
      }
      for (;;)
      {
        return;
        label117:
        if ((paramBoolean1) && (!paramBoolean2)) {
          break label139;
        }
        i = 0;
        break;
        localTextView.setVisibility(8);
      }
    }
  }
  
  private final void c(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if ((paramBoolean) && (!paramVideoInfo.b(this.jdField_a_of_type_Slr.a())))
    {
      this.jdField_a_of_type_Swr.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, six.c(this.jdField_a_of_type_Slr.a()));
      this.jdField_a_of_type_Swr.a().setPadding(0, 0, 0, 0);
      return;
    }
    if ((this.jdField_a_of_type_Swr.jdField_d_of_type_Int > 0) && (paramVideoInfo.a(this.jdField_a_of_type_Slr.a(), this.jdField_a_of_type_Swr.jdField_d_of_type_Int) == 2))
    {
      this.jdField_a_of_type_Swr.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_Swr.a().setPadding(0, 0, 0, this.jdField_a_of_type_Swr.jdField_d_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Swr.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_Swr.a().setPadding(0, 0, 0, 0);
  }
  
  private final void d(VideoInfo paramVideoInfo)
  {
    Object localObject = (ReadInJoyUserInfo)null;
    if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.j))
    {
      paramVideoInfo = paramVideoInfo.j;
      Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoInfo.accountUin");
    }
    for (paramVideoInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo), null);; paramVideoInfo = (VideoInfo)localObject)
    {
      if ((paramVideoInfo != null) && (!TextUtils.isEmpty((CharSequence)paramVideoInfo.smallIconUrl)))
      {
        this.jdField_a_of_type_Swr.a().setVisibility(0);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_Swr.a().getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Swr.a().getWidth();
        paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.smallIconUrl, (URLDrawable.URLDrawableOptions)localObject);
        this.jdField_a_of_type_Swr.a().setImageDrawable((Drawable)paramVideoInfo);
        return;
      }
      this.jdField_a_of_type_Swr.a().setVisibility(8);
      return;
    }
  }
  
  private final void e(VideoInfo paramVideoInfo)
  {
    Object localObject = this.jdField_a_of_type_Swr.b;
    if (localObject != null) {
      ((ReadInJoyHeadImageView)localObject).setImagePlaceHolder(this.jdField_a_of_type_Shl.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    localObject = this.jdField_a_of_type_Swr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
    if (localObject != null)
    {
      localObject = ((ReadInJoyNickNameTextView)localObject).getPaint();
      if (localObject != null) {
        ((TextPaint)localObject).setFakeBoldText(true);
      }
    }
    localObject = this.jdField_a_of_type_Swr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
    if (localObject != null) {
      ((ReadInJoyNickNameTextView)localObject).setNickNameByUin(paramVideoInfo.j);
    }
    localObject = this.jdField_a_of_type_Swr.b;
    if (localObject != null) {
      ((ReadInJoyHeadImageView)localObject).setHeadImgByUin(paramVideoInfo.j);
    }
    VideoFeedsAccessibilityHelper.b((View)this.jdField_a_of_type_Swr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramVideoInfo.k);
    VideoFeedsAccessibilityHelper.c((View)this.jdField_a_of_type_Swr.b, paramVideoInfo.k);
    if (this.jdField_a_of_type_Shl.g) {
      this.jdField_a_of_type_Swr.a().setForeground((Drawable)null);
    }
    this.jdField_a_of_type_Swr.a().setVisibility(0);
    if (!TextUtils.isEmpty((CharSequence)paramVideoInfo.j))
    {
      if ((paramVideoInfo.jdField_a_of_type_Qgp != null) && (paramVideoInfo.jdField_a_of_type_Qgp.jdField_a_of_type_Int == 1))
      {
        if ((this.jdField_a_of_type_Swr == this.jdField_a_of_type_Slr.a()) && (this.jdField_a_of_type_Swr.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
          this.jdField_a_of_type_Slr.a().a(paramVideoInfo);
        }
        this.jdField_a_of_type_Swr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_Swr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Swr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private final void f(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo != null)
    {
      Object localObject = this.jdField_a_of_type_Swr.d();
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(0);
      }
      localObject = this.jdField_a_of_type_Swr.i();
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo.jdField_a_of_type_JavaLangString);
      }
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LocationInfo.jdField_a_of_type_Boolean)
      {
        paramVideoInfo = this.jdField_a_of_type_Swr.e();
        if (paramVideoInfo != null) {
          paramVideoInfo.setImageDrawable(this.jdField_a_of_type_Shl.a(2130841822));
        }
        paramVideoInfo = this.jdField_a_of_type_Swr.d();
        if (paramVideoInfo != null) {
          paramVideoInfo.setBackgroundResource(2130841820);
        }
        paramVideoInfo = this.jdField_a_of_type_Swr.d();
        if (paramVideoInfo != null) {
          paramVideoInfo.setTag(this.jdField_a_of_type_Swr);
        }
        paramVideoInfo = this.jdField_a_of_type_Swr.d();
        if (paramVideoInfo != null) {
          paramVideoInfo.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Shl);
        }
      }
    }
    do
    {
      return;
      paramVideoInfo = this.jdField_a_of_type_Swr.e();
      if (paramVideoInfo != null) {
        paramVideoInfo.setImageDrawable(this.jdField_a_of_type_Shl.a(2130841821));
      }
      paramVideoInfo = this.jdField_a_of_type_Swr.d();
      if (paramVideoInfo == null) {
        break;
      }
      paramVideoInfo.setBackgroundResource(0);
      break;
      paramVideoInfo = this.jdField_a_of_type_Swr.d();
    } while (paramVideoInfo == null);
    paramVideoInfo.setVisibility(8);
  }
  
  private final void m(boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramBoolean)
    {
      localObject2 = this.jdField_a_of_type_Swr.g.getLayoutParams();
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      localObject3 = this.jdField_a_of_type_Slr.a();
      if (localObject3 != null) {
        localObject1 = ((Activity)localObject3).getResources();
      }
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = AIOUtils.dp2px(0.0F, (Resources)localObject1);
      this.jdField_a_of_type_Swr.g.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      return;
    }
    localObject1 = this.jdField_a_of_type_Swr.g.getLayoutParams();
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
    Object localObject3 = (ViewGroup.MarginLayoutParams)localObject1;
    Activity localActivity = this.jdField_a_of_type_Slr.a();
    localObject1 = localObject2;
    if (localActivity != null) {
      localObject1 = localActivity.getResources();
    }
    ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin = (AIOUtils.dp2px(15.0F, (Resources)localObject1) - 20);
    this.jdField_a_of_type_Swr.g.setLayoutParams((ViewGroup.LayoutParams)localObject3);
  }
  
  protected int a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    if (paramVideoInfo.o) {
      return 2130843183;
    }
    return 2130843185;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Shl.jdField_a_of_type_Skc != null) {
      this.jdField_a_of_type_Shl.jdField_a_of_type_Skc.a(paramInt1, paramInt2);
    }
    if (paramBoolean) {
      d();
    }
  }
  
  public void a(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    super.a(paramVideoInfo, paramBoolean);
    Object localObject1;
    if (this.jdField_a_of_type_Slr.a() == this.jdField_a_of_type_Swr)
    {
      localObject1 = this.jdField_a_of_type_Shl.jdField_a_of_type_Sib;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "adapter.mCommentManager");
      if (((sib)localObject1).b())
      {
        paramBoolean = true;
        c(paramVideoInfo, paramBoolean);
        localObject1 = this.jdField_a_of_type_Swr.v;
        if (localObject1 != null)
        {
          localObject1 = ((TextView)localObject1).getPaint();
          if (localObject1 != null) {
            ((TextPaint)localObject1).setFakeBoldText(false);
          }
        }
        this.jdField_a_of_type_Swr.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
        if (!paramVideoInfo.b(this.jdField_a_of_type_Slr.a())) {
          break label423;
        }
        this.jdField_a_of_type_Swr.a().setVisibility(0);
        label122:
        m(false);
        localObject1 = this.jdField_a_of_type_Shl.jdField_a_of_type_Sib;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "adapter.mCommentManager");
        if ((((sib)localObject1).b()) && (this.jdField_a_of_type_Shl.h))
        {
          this.jdField_a_of_type_Shl.h = false;
          e(true);
        }
        if ((this.jdField_a_of_type_Swr.jdField_c_of_type_Int != 0) || (paramVideoInfo.jdField_a_of_type_Int != 0)) {
          break label438;
        }
        if (this.jdField_a_of_type_Swr.a() == null) {
          this.jdField_a_of_type_Swr.a(new VideoFeedsAioGuideView(this.jdField_a_of_type_Slr.a(), this.jdField_a_of_type_Slr.a(), this.jdField_a_of_type_Shl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView));
        }
        localObject1 = this.jdField_a_of_type_Swr.a();
        if (localObject1 != null) {
          ((VideoFeedsAioGuideView)localObject1).a(this.jdField_a_of_type_Swr);
        }
        label254:
        localObject1 = this.jdField_a_of_type_Slr.a();
        if (localObject1 == null) {
          break label478;
        }
        localObject1 = ((Activity)localObject1).getIntent();
        if (localObject1 == null) {
          break label478;
        }
        localObject1 = ((Intent)localObject1).getStringExtra("video_feeds_back_color");
        label283:
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label483;
        }
        URLImageView localURLImageView = this.jdField_a_of_type_Swr.a();
        Object localObject2 = this.jdField_a_of_type_Slr.a();
        localObject1 = localDrawable;
        if (localObject2 != null)
        {
          localObject2 = ((Activity)localObject2).getIntent();
          localObject1 = localDrawable;
          if (localObject2 != null) {
            localObject1 = ((Intent)localObject2).getStringExtra("video_feeds_back_color");
          }
        }
        localURLImageView.setImageDrawable((Drawable)new ColorDrawable(Color.parseColor((String)localObject1)));
        localObject1 = this.jdField_a_of_type_Slr.a();
        if (localObject1 != null)
        {
          localObject1 = ((Activity)localObject1).getIntent();
          if (localObject1 != null) {
            ((Intent)localObject1).removeExtra("video_feeds_back_color");
          }
        }
      }
    }
    for (;;)
    {
      a(paramVideoInfo, this.jdField_a_of_type_Swr.a());
      this.jdField_a_of_type_Shl.jdField_a_of_type_Sgk.b(paramVideoInfo, this.jdField_a_of_type_Swr);
      return;
      paramBoolean = false;
      break;
      label423:
      this.jdField_a_of_type_Swr.a().setVisibility(8);
      break label122;
      label438:
      if (this.jdField_a_of_type_Swr.a() == null) {
        break label254;
      }
      localObject1 = this.jdField_a_of_type_Swr.a();
      if (localObject1 != null) {
        ((VideoFeedsAioGuideView)localObject1).c();
      }
      this.jdField_a_of_type_Swr.a((VideoFeedsAioGuideView)null);
      break label254;
      label478:
      localObject1 = null;
      break label283;
      label483:
      if (paramVideoInfo.b(this.jdField_a_of_type_Slr.a()))
      {
        this.jdField_a_of_type_Swr.a().setImageDrawable(null);
      }
      else if (paramVideoInfo.a() != null)
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        localDrawable = (Drawable)new ColorDrawable(-16777216);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localDrawable;
        localObject1 = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setDecodeHandler(bgxc.x);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "urlDrawable");
        ((URLDrawable)localObject1).setAlpha(35);
        this.jdField_a_of_type_Swr.a().setImageDrawable((Drawable)localObject1);
      }
    }
  }
  
  public void a_(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    a(true);
    Object localObject = this.jdField_a_of_type_Swr.i;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      e(paramVideoInfo);
      d(paramVideoInfo);
      b(paramVideoInfo, false);
      localObject = this.jdField_a_of_type_Swr.i;
      if (localObject != null) {
        ((ViewGroup)localObject).setTag(this.jdField_a_of_type_Swr);
      }
      localObject = this.jdField_a_of_type_Swr.i;
      if (localObject != null) {
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Shl);
      }
      localObject = this.jdField_a_of_type_Swr.jdField_a_of_type_Sfb;
      if (localObject != null)
      {
        localObject = ((sfb)localObject).a();
        if (localObject != null) {
          ((View)localObject).setTag(this.jdField_a_of_type_Swr);
        }
      }
      localObject = this.jdField_a_of_type_Swr.jdField_a_of_type_Sfb;
      if (localObject != null)
      {
        localObject = ((sfb)localObject).a();
        if (localObject != null) {
          ((View)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Shl);
        }
      }
    }
    l(true);
    localObject = this.jdField_a_of_type_Swr.k;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      a((swu)this.jdField_a_of_type_Swr, paramVideoInfo);
      if (rjy.a())
      {
        this.jdField_a_of_type_Swr.c().setTag(this.jdField_a_of_type_Swr);
        this.jdField_a_of_type_Swr.c().setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Shl);
        this.jdField_a_of_type_Swr.c().setVisibility(0);
      }
    }
    if (paramVideoInfo.b(this.jdField_a_of_type_Slr.a())) {
      this.jdField_a_of_type_Swr.h.setVisibility(8);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Slr.a() == this.jdField_a_of_type_Swr) && (this.jdField_a_of_type_Slr.b()))
      {
        a(false);
        l(false);
      }
      if (paramVideoInfo.a())
      {
        localObject = this.jdField_a_of_type_Swr.m;
        if (localObject != null) {
          ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Shl.a(a(paramVideoInfo.jdField_r_of_type_Boolean)));
        }
      }
      VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_Swr, (View.OnClickListener)this.jdField_a_of_type_Shl);
      a(this.jdField_a_of_type_Swr.jdField_c_of_type_AndroidWidgetImageView, paramVideoInfo);
      a(this.jdField_a_of_type_Swr.jdField_c_of_type_AndroidWidgetImageView, paramVideoInfo, this.jdField_a_of_type_Slr.b());
      f(paramVideoInfo);
      return;
      this.jdField_a_of_type_Swr.h.setVisibility(0);
    }
  }
  
  public void b(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    super.b(paramVideoInfo);
    e(paramVideoInfo);
    d(paramVideoInfo);
    six.a(paramVideoInfo, this.jdField_a_of_type_Swr.v);
    six.a(paramVideoInfo, this.jdField_a_of_type_Swr.u);
    this.jdField_a_of_type_Shl.a((swu)this.jdField_a_of_type_Swr, paramVideoInfo);
    b(paramVideoInfo, true);
    a(paramVideoInfo, this.jdField_a_of_type_Swr.a());
    if (this.jdField_a_of_type_Swr.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 8)
    {
      a(this.jdField_a_of_type_Swr.jdField_c_of_type_AndroidWidgetImageView, paramVideoInfo);
      a(this.jdField_a_of_type_Swr.jdField_c_of_type_AndroidWidgetImageView, paramVideoInfo, this.jdField_a_of_type_Slr.b());
    }
    this.jdField_a_of_type_Shl.jdField_a_of_type_Sgk.a(paramVideoInfo, this.jdField_a_of_type_Swr);
    TextView localTextView;
    int i;
    if (rjy.a())
    {
      this.jdField_a_of_type_Swr.d().setImageResource(a(paramVideoInfo));
      localTextView = this.jdField_a_of_type_Swr.h();
      i = paramVideoInfo.p;
      localObject = this.jdField_a_of_type_Slr.a();
      if (localObject == null) {
        break label206;
      }
    }
    label206:
    for (Object localObject = ((Activity)localObject).getString(2131718097);; localObject = null)
    {
      six.b(localTextView, i, (String)localObject);
      f(paramVideoInfo);
      return;
    }
  }
  
  protected void b(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    if (this.jdField_a_of_type_Swr.jdField_a_of_type_Sfb == null) {
      return;
    }
    boolean bool2 = paramVideoInfo.q;
    Object localObject = this.jdField_a_of_type_Swr.g();
    boolean bool1;
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 0))
    {
      bool1 = true;
      if ((!TextUtils.isEmpty((CharSequence)paramVideoInfo.j)) && (!Intrinsics.areEqual("16888", paramVideoInfo.j)) && (!paramVideoInfo.c) && (!paramVideoInfo.a(this.jdField_a_of_type_Slr.a()))) {
        break label159;
      }
      localObject = this.jdField_a_of_type_Swr.jdField_a_of_type_Sfb;
      if (localObject != null)
      {
        localObject = ((sfb)localObject).a();
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
      }
      six.a((View)this.jdField_a_of_type_Swr.g(), 8, 0);
    }
    for (;;)
    {
      a(paramVideoInfo, paramBoolean, bool1);
      return;
      bool1 = false;
      break;
      label159:
      localObject = this.jdField_a_of_type_Swr.jdField_a_of_type_Sfb;
      if (localObject != null) {
        ((sfb)localObject).a(paramVideoInfo, paramVideoInfo.q);
      }
      if ((paramBoolean) && (this.jdField_a_of_type_Swr == this.jdField_a_of_type_Slr.a()) && (this.jdField_a_of_type_Shl.jdField_a_of_type_AndroidOsHandler != null) && (bool2))
      {
        localObject = this.jdField_a_of_type_Swr.jdField_a_of_type_Sfb;
        if (localObject != null)
        {
          localObject = ((sfb)localObject).a();
          if ((localObject != null) && (((View)localObject).getVisibility() == 0))
          {
            localObject = this.jdField_a_of_type_Swr.jdField_a_of_type_Sfb;
            if (localObject != null)
            {
              long l = ((sfb)localObject).a();
              this.jdField_a_of_type_Shl.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, l);
            }
            six.b((View)this.jdField_a_of_type_Swr.g(), 0);
            continue;
          }
        }
      }
      if (bool2)
      {
        localObject = this.jdField_a_of_type_Swr.jdField_a_of_type_Sfb;
        if (localObject != null)
        {
          localObject = ((sfb)localObject).a();
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
        six.a((View)this.jdField_a_of_type_Swr.g(), 0, 0);
      }
      else
      {
        localObject = this.jdField_a_of_type_Swr.jdField_a_of_type_Sfb;
        if (localObject != null)
        {
          localObject = ((sfb)localObject).a();
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
        six.a((View)this.jdField_a_of_type_Swr.g(), 8, 0);
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Swr.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {}
    for (boolean bool = true;; bool = false)
    {
      i(bool);
      return;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Swr.jdField_c_of_type_ComTencentImageURLImageView.clearAnimation();
    Object localObject = this.jdField_a_of_type_Swr.jdField_a_of_type_Skq;
    if (localObject != null)
    {
      localObject = ((skq)localObject).a;
      if (localObject != null) {
        c((VideoInfo)localObject, paramBoolean);
      }
    }
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_Swr.jdField_a_of_type_Skq;
      if (localObject != null)
      {
        localObject = ((skq)localObject).a;
        if ((localObject != null) && (((VideoInfo)localObject).b(this.jdField_a_of_type_Slr.a()) == true)) {}
      }
      else
      {
        m(true);
      }
      if (this.jdField_a_of_type_Swr.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        this.jdField_a_of_type_Swr.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      this.jdField_a_of_type_Swr.h.setVisibility(8);
      return;
    }
    localObject = this.jdField_a_of_type_Swr.jdField_a_of_type_Skq;
    if (localObject != null)
    {
      localObject = ((skq)localObject).a;
      if ((localObject != null) && (((VideoInfo)localObject).b(this.jdField_a_of_type_Slr.a()) == true)) {}
    }
    else
    {
      m(false);
      this.jdField_a_of_type_Swr.h.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Swr.h.setVisibility(8);
  }
  
  public void f(boolean paramBoolean)
  {
    super.f(paramBoolean);
    Object localObject = this.jdField_a_of_type_Swr.jdField_a_of_type_Skq;
    boolean bool;
    if (localObject != null)
    {
      localObject = ((skq)localObject).a;
      if (localObject != null)
      {
        if (this.jdField_a_of_type_Slr.a() != this.jdField_a_of_type_Swr) {
          break label170;
        }
        sib localsib = this.jdField_a_of_type_Shl.jdField_a_of_type_Sib;
        Intrinsics.checkExpressionValueIsNotNull(localsib, "adapter.mCommentManager");
        if (!localsib.b()) {
          break label170;
        }
        bool = true;
        c((VideoInfo)localObject, bool);
      }
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Swr.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_Shl.b);
      m(true);
      if (this.jdField_a_of_type_Swr.a() != null)
      {
        localObject = this.jdField_a_of_type_Swr.a();
        if (localObject != null) {
          ((VideoFeedsAioGuideView)localObject).b();
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Swr.jdField_a_of_type_Skq != null)
      {
        localObject = this.jdField_a_of_type_Swr.jdField_a_of_type_Skq;
        if (localObject != null)
        {
          localObject = ((skq)localObject).a;
          if (localObject != null) {
            a(this.jdField_a_of_type_Swr.jdField_c_of_type_AndroidWidgetImageView, (VideoInfo)localObject, paramBoolean);
          }
        }
      }
      return;
      label170:
      bool = false;
      break;
      this.jdField_a_of_type_Swr.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      localObject = this.jdField_a_of_type_Shl.jdField_a_of_type_Sib;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "adapter.mCommentManager");
      if (!((sib)localObject).b()) {
        m(false);
      }
      if ((this.jdField_a_of_type_Swr.a() != null) && (this.jdField_a_of_type_Swr.jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_Swr.jdField_a_of_type_Skq != null))
      {
        localObject = this.jdField_a_of_type_Swr.jdField_a_of_type_Skq;
        if (localObject != null)
        {
          localObject = ((skq)localObject).a;
          if ((localObject != null) && (((VideoInfo)localObject).jdField_a_of_type_Int == 0))
          {
            localObject = this.jdField_a_of_type_Swr.a();
            if (localObject != null) {
              ((VideoFeedsAioGuideView)localObject).a();
            }
          }
        }
      }
    }
  }
  
  protected void i(boolean paramBoolean)
  {
    super.i(paramBoolean);
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_Swr.n;
      if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
      {
        six.a((View)this.jdField_a_of_type_Swr.n, 8, 200);
        localObject = this.jdField_a_of_type_Swr.n;
        if (localObject != null)
        {
          localObject = ((ViewGroup)localObject).animate();
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).translationY(20.0F);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
              if (localObject != null) {
                ((ViewPropertyAnimator)localObject).start();
              }
            }
          }
        }
        this.jdField_a_of_type_Swr.g.animate().translationY(-20.0F).setDuration(200L).start();
      }
      if ((this.jdField_a_of_type_Swr.a() != null) && (!this.jdField_a_of_type_Slr.b()))
      {
        localObject = this.jdField_a_of_type_Swr.a();
        if (localObject != null) {
          ((VideoFeedsAioGuideView)localObject).a();
        }
      }
    }
    do
    {
      do
      {
        return;
        if (!this.jdField_a_of_type_Slr.b())
        {
          localObject = this.jdField_a_of_type_Swr.n;
          if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 8))
          {
            six.a((View)this.jdField_a_of_type_Swr.n, 0, 200);
            localObject = this.jdField_a_of_type_Swr.n;
            if (localObject != null)
            {
              localObject = ((ViewGroup)localObject).animate();
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).translationY(0.0F);
                if (localObject != null)
                {
                  localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
                  if (localObject != null) {
                    ((ViewPropertyAnimator)localObject).start();
                  }
                }
              }
            }
            this.jdField_a_of_type_Swr.g.animate().translationY(0.0F).setDuration(200L).start();
          }
        }
      } while (this.jdField_a_of_type_Swr.a() == null);
      localObject = this.jdField_a_of_type_Swr.a();
    } while (localObject == null);
    ((VideoFeedsAioGuideView)localObject).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swq
 * JD-Core Version:    0.7.0.1
 */
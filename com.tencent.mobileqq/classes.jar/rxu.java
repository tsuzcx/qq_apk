import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
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
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAioGuideView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGradientMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTopicViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;

public class rxu
  extends rxr
{
  private rxv a;
  
  public rxu(rwy paramrwy, rxv paramrxv)
  {
    super(paramrwy, paramrxv);
    this.jdField_a_of_type_Rxv = paramrxv;
    if ((paramrxv.jdField_o_of_type_AndroidViewViewGroup != null) && (ryx.a(rwy.a(paramrwy))) && (Aladdin.getConfig(324).getIntegerFromString("videodetail_videogravity_style", 0) == 1)) {
      paramrxv.jdField_d_of_type_Int = paramrxv.jdField_o_of_type_AndroidViewViewGroup.getLayoutParams().height;
    }
  }
  
  private void a(ImageView paramImageView, VideoInfo paramVideoInfo)
  {
    if ((paramImageView == null) || (paramVideoInfo == null)) {
      return;
    }
    if ((!ryx.d()) || (TextUtils.isEmpty(paramVideoInfo.u)))
    {
      paramImageView.setVisibility(8);
      return;
    }
    Object localObject;
    if (paramVideoInfo.u.endsWith("zip"))
    {
      localObject = pka.a(paramVideoInfo.u);
      ((pka)localObject).setRepeatCount(0);
      paramImageView.setImageDrawable((Drawable)localObject);
      if ((paramImageView.getVisibility() == 8) && (rwy.a(this.jdField_a_of_type_Rwy).d()) && (rwy.a(this.jdField_a_of_type_Rwy).jdField_a_of_type_Sar.a == paramVideoInfo)) {
        ((pka)localObject).playAnimation();
      }
    }
    for (;;)
    {
      paramImageView.setVisibility(0);
      return;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      paramImageView.setImageDrawable(URLDrawable.getDrawable(paramVideoInfo.u, (URLDrawable.URLDrawableOptions)localObject));
    }
  }
  
  private void a(ImageView paramImageView, VideoInfo paramVideoInfo, Boolean paramBoolean)
  {
    int[] arrayOfInt;
    if (paramImageView.getVisibility() == 0)
    {
      arrayOfInt = paramVideoInfo.a(rwy.a(this.jdField_a_of_type_Rwy), paramBoolean.booleanValue(), this.jdField_a_of_type_Rxv.jdField_d_of_type_Int);
      if ((arrayOfInt[0] >= 0) && (arrayOfInt[1] >= 0)) {}
    }
    else
    {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramImageView.getLayoutParams();
    localLayoutParams.topMargin = arrayOfInt[0];
    localLayoutParams.rightMargin = arrayOfInt[1];
    if ((paramBoolean.booleanValue()) || (paramVideoInfo.b(rwy.a(this.jdField_a_of_type_Rwy)))) {
      localLayoutParams.width = afur.a(91.0F, rwy.a(this.jdField_a_of_type_Rwy).getResources());
    }
    for (localLayoutParams.height = afur.a(28.0F, rwy.a(this.jdField_a_of_type_Rwy).getResources());; localLayoutParams.height = afur.a(24.0F, rwy.a(this.jdField_a_of_type_Rwy).getResources()))
    {
      paramImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = afur.a(78.0F, rwy.a(this.jdField_a_of_type_Rwy).getResources());
    }
  }
  
  private void a(VideoInfo paramVideoInfo, TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    if ((paramVideoInfo.jdField_a_of_type_Int != 0) && (paramVideoInfo.jdField_a_of_type_Int != 5) && (paramVideoInfo.jdField_q_of_type_Int > 0))
    {
      paramTextView.setText(ryx.a(paramVideoInfo.jdField_q_of_type_Int));
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if ((paramBoolean) && (!paramVideoInfo.b(rwy.a(this.jdField_a_of_type_Rwy))))
    {
      this.jdField_a_of_type_Rxv.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, ryx.c(rwy.a(this.jdField_a_of_type_Rwy)));
      this.jdField_a_of_type_Rxv.i.setPadding(0, 0, 0, 0);
      return;
    }
    if ((this.jdField_a_of_type_Rxv.jdField_d_of_type_Int > 0) && (paramVideoInfo.a(rwy.a(this.jdField_a_of_type_Rwy), this.jdField_a_of_type_Rxv.jdField_d_of_type_Int) == 2))
    {
      this.jdField_a_of_type_Rxv.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_Rxv.i.setPadding(0, 0, 0, this.jdField_a_of_type_Rxv.jdField_d_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Rxv.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_Rxv.i.setPadding(0, 0, 0, 0);
  }
  
  private void c(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Rxv.jdField_a_of_type_Ruq == null) {
      return;
    }
    boolean bool = paramVideoInfo.jdField_q_of_type_Boolean;
    if ((TextUtils.isEmpty(paramVideoInfo.j)) || ("16888".equals(paramVideoInfo.j)) || (paramVideoInfo.jdField_c_of_type_Boolean) || (paramVideoInfo.a(rwy.a(this.jdField_a_of_type_Rwy))))
    {
      this.jdField_a_of_type_Rxv.jdField_a_of_type_Ruq.a().setVisibility(8);
      ryx.a(this.jdField_a_of_type_Rxv.k, 8, 0);
      return;
    }
    this.jdField_a_of_type_Rxv.jdField_a_of_type_Ruq.a(paramVideoInfo, paramVideoInfo.jdField_q_of_type_Boolean);
    if ((paramBoolean) && (this.jdField_a_of_type_Rxv == rwy.a(this.jdField_a_of_type_Rwy)) && (rwy.a(this.jdField_a_of_type_Rwy) != null) && (bool) && (this.jdField_a_of_type_Rxv.jdField_a_of_type_Ruq.a().getVisibility() == 0))
    {
      rwy.a(this.jdField_a_of_type_Rwy).sendEmptyMessageDelayed(7, this.jdField_a_of_type_Rxv.jdField_a_of_type_Ruq.a());
      ryx.b(this.jdField_a_of_type_Rxv.k, 0);
      return;
    }
    if (bool)
    {
      this.jdField_a_of_type_Rxv.jdField_a_of_type_Ruq.a().setVisibility(8);
      ryx.a(this.jdField_a_of_type_Rxv.k, 0, 0);
      return;
    }
    this.jdField_a_of_type_Rxv.jdField_a_of_type_Ruq.a().setVisibility(0);
    ryx.a(this.jdField_a_of_type_Rxv.k, 8, 0);
  }
  
  private void e(VideoInfo paramVideoInfo)
  {
    if (!TextUtils.isEmpty(paramVideoInfo.v))
    {
      this.jdField_a_of_type_Rxv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_Rxv.jdField_a_of_type_AndroidWidgetImageView.getHeight();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Rxv.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.v, localURLDrawableOptions);
      this.jdField_a_of_type_Rxv.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramVideoInfo);
      return;
    }
    this.jdField_a_of_type_Rxv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void f(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Rxv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImagePlaceHolder(rwy.a(this.jdField_a_of_type_Rwy));
    this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(paramVideoInfo.j);
    this.jdField_a_of_type_Rxv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(paramVideoInfo.j);
    VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramVideoInfo.k);
    VideoFeedsAccessibilityHelper.c(this.jdField_a_of_type_Rxv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, paramVideoInfo.k);
    if (rwy.l(this.jdField_a_of_type_Rwy)) {
      this.jdField_a_of_type_Rxv.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(null);
    }
    this.jdField_a_of_type_Rxv.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    if (!TextUtils.isEmpty(paramVideoInfo.j))
    {
      ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo.j), null);
      if ((localReadInJoyUserInfo != null) && (localReadInJoyUserInfo.isLiving()))
      {
        if ((this.jdField_a_of_type_Rxv == rwy.a(this.jdField_a_of_type_Rwy)) && (this.jdField_a_of_type_Rxv.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
          rwy.c(this.jdField_a_of_type_Rwy, paramVideoInfo);
        }
        this.jdField_a_of_type_Rxv.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_Rxv.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Rxv.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void m(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Rxv.g.getLayoutParams();
      localMarginLayoutParams.bottomMargin = afur.a(0.0F, rwy.a(this.jdField_a_of_type_Rwy).getResources());
      this.jdField_a_of_type_Rxv.g.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Rxv.g.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (afur.a(15.0F, rwy.a(this.jdField_a_of_type_Rwy).getResources()) - 20);
    this.jdField_a_of_type_Rxv.g.setLayoutParams(localMarginLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (rwy.a(this.jdField_a_of_type_Rwy) != null) {
      rwy.a(this.jdField_a_of_type_Rwy).a(paramInt1, paramInt2);
    }
    if (paramBoolean) {
      d();
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    a(true);
    if (this.jdField_a_of_type_Rxv.m.getVisibility() == 0)
    {
      f(paramVideoInfo);
      e(paramVideoInfo);
      c(paramVideoInfo, false);
      this.jdField_a_of_type_Rxv.m.setTag(this.jdField_a_of_type_Rxv);
      this.jdField_a_of_type_Rxv.m.setOnClickListener(this.jdField_a_of_type_Rwy);
      this.jdField_a_of_type_Rxv.jdField_a_of_type_Ruq.a().setTag(this.jdField_a_of_type_Rxv);
      this.jdField_a_of_type_Rxv.jdField_a_of_type_Ruq.a().setOnClickListener(this.jdField_a_of_type_Rwy);
    }
    l(true);
    if (this.jdField_a_of_type_Rxv.jdField_o_of_type_AndroidViewViewGroup.getVisibility() == 0) {
      a(this.jdField_a_of_type_Rxv, paramVideoInfo);
    }
    if (paramVideoInfo.b(rwy.a(this.jdField_a_of_type_Rwy))) {
      this.jdField_a_of_type_Rxv.h.setVisibility(8);
    }
    for (;;)
    {
      if ((rwy.a(this.jdField_a_of_type_Rwy) == this.jdField_a_of_type_Rxv) && (rwy.a(this.jdField_a_of_type_Rwy)))
      {
        a(false);
        l(false);
      }
      if (paramVideoInfo.a()) {
        this.jdField_a_of_type_Rxv.jdField_o_of_type_AndroidWidgetImageView.setImageDrawable(rwy.a(this.jdField_a_of_type_Rwy, a(paramVideoInfo.r)));
      }
      VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_Rxv, this.jdField_a_of_type_Rwy);
      a(this.jdField_a_of_type_Rxv.f, paramVideoInfo);
      a(this.jdField_a_of_type_Rxv.f, paramVideoInfo, Boolean.valueOf(rwy.a(this.jdField_a_of_type_Rwy)));
      return;
      this.jdField_a_of_type_Rxv.h.setVisibility(0);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    if ((rwy.a(this.jdField_a_of_type_Rwy) == this.jdField_a_of_type_Rxv) && (rwy.a(this.jdField_a_of_type_Rwy).a()))
    {
      paramBoolean = true;
      b(paramVideoInfo, paramBoolean);
      this.jdField_a_of_type_Rxv.z.getPaint().setFakeBoldText(false);
      if (rwy.a(this.jdField_a_of_type_Rwy) != null) {
        rwy.a(this.jdField_a_of_type_Rwy).a(paramVideoInfo, this.jdField_a_of_type_Rxv, false);
      }
      if (paramVideoInfo.jdField_a_of_type_JavaUtilArrayList == null) {
        break label490;
      }
      if ((this.jdField_a_of_type_Rxv.j == null) || (this.jdField_a_of_type_Rxv.j.getVisibility() == 8)) {
        break label433;
      }
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.post(new VideoFeedsAdapter.ShortVideoItemDelegate.1(this, paramVideoInfo));
      label133:
      this.jdField_a_of_type_Rxv.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      if (!paramVideoInfo.b(rwy.a(this.jdField_a_of_type_Rwy))) {
        break label505;
      }
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(0);
      if (this.jdField_a_of_type_Rxv.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_Rxv.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      label190:
      m(false);
      if ((rwy.a(this.jdField_a_of_type_Rwy).a()) && (rwy.k(this.jdField_a_of_type_Rwy)))
      {
        rwy.h(this.jdField_a_of_type_Rwy, false);
        e(true);
      }
      if ((this.jdField_a_of_type_Rxv.c != 0) || (paramVideoInfo.jdField_a_of_type_Int != 0)) {
        break label542;
      }
      if (this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) {
        this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = new VideoFeedsAioGuideView(rwy.a(this.jdField_a_of_type_Rwy), rwy.a(this.jdField_a_of_type_Rwy), rwy.a(this.jdField_a_of_type_Rwy));
      }
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a(this.jdField_a_of_type_Rxv);
      label308:
      if ((rwy.a(this.jdField_a_of_type_Rwy).getIntent() == null) || (TextUtils.isEmpty(rwy.a(this.jdField_a_of_type_Rwy).getIntent().getStringExtra("video_feeds_back_color")))) {
        break label573;
      }
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(Color.parseColor(rwy.a(this.jdField_a_of_type_Rwy).getIntent().getStringExtra("video_feeds_back_color"))));
      rwy.a(this.jdField_a_of_type_Rwy).getIntent().removeExtra("video_feeds_back_color");
    }
    for (;;)
    {
      a(paramVideoInfo, this.jdField_a_of_type_Rxv.jdField_b_of_type_AndroidWidgetTextView);
      rwy.a(this.jdField_a_of_type_Rwy).b(paramVideoInfo, this.jdField_a_of_type_Rxv);
      d(paramVideoInfo);
      return;
      paramBoolean = false;
      break;
      label433:
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setHorizontalMargin(0);
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(0);
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setArticleInfo(rwy.a(this.jdField_a_of_type_Rwy), this.jdField_a_of_type_Rwy, paramVideoInfo, rwy.c(this.jdField_a_of_type_Rwy), rwy.a());
      break label133;
      label490:
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(8);
      break label133;
      label505:
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(8);
      if (this.jdField_a_of_type_Rxv.jdField_a_of_type_AndroidViewView == null) {
        break label190;
      }
      this.jdField_a_of_type_Rxv.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label190;
      label542:
      if (this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) {
        break label308;
      }
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.c();
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = null;
      break label308;
      label573:
      if (paramVideoInfo.b(rwy.a(this.jdField_a_of_type_Rwy)))
      {
        this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      }
      else if (paramVideoInfo.a() != null)
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        localObject = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setDecodeHandler(bgey.x);
        ((URLDrawable)localObject).setAlpha(35);
        this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    super.b(paramVideoInfo);
    f(paramVideoInfo);
    e(paramVideoInfo);
    this.jdField_a_of_type_Rxv.z.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_Rxv.y.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
    rwy.a(this.jdField_a_of_type_Rwy, this.jdField_a_of_type_Rxv, paramVideoInfo);
    c(paramVideoInfo, true);
    if ((paramVideoInfo.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.getVisibility() == 8))
    {
      if ((this.jdField_a_of_type_Rxv.j == null) || (this.jdField_a_of_type_Rxv.j.getVisibility() == 8)) {
        break label213;
      }
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.post(new VideoFeedsAdapter.ShortVideoItemDelegate.2(this, paramVideoInfo));
    }
    for (;;)
    {
      rwy.a(this.jdField_a_of_type_Rwy, paramVideoInfo);
      a(paramVideoInfo, this.jdField_a_of_type_Rxv.jdField_b_of_type_AndroidWidgetTextView);
      if (this.jdField_a_of_type_Rxv.f.getVisibility() == 8)
      {
        a(this.jdField_a_of_type_Rxv.f, paramVideoInfo);
        a(this.jdField_a_of_type_Rxv.f, paramVideoInfo, Boolean.valueOf(rwy.a(this.jdField_a_of_type_Rwy)));
      }
      rwy.a(this.jdField_a_of_type_Rwy).a(paramVideoInfo, this.jdField_a_of_type_Rxv);
      return;
      label213:
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setHorizontalMargin(0);
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(0);
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setArticleInfo(rwy.a(this.jdField_a_of_type_Rwy), this.jdField_a_of_type_Rwy, paramVideoInfo, rwy.c(this.jdField_a_of_type_Rwy), rwy.a());
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Rxv.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {}
    for (boolean bool = true;; bool = false)
    {
      i(bool);
      return;
    }
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.l) && (!TextUtils.isEmpty(paramVideoInfo.x)))
    {
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setVisibility(0);
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setText(paramVideoInfo.x);
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setTag(this.jdField_a_of_type_Rxv);
      this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setOnClickListener(this.jdField_a_of_type_Rwy);
      return;
    }
    this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setVisibility(8);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rxv.jdField_b_of_type_ComTencentImageURLImageView.clearAnimation();
    b(this.jdField_a_of_type_Rxv.jdField_a_of_type_Sar.a, paramBoolean);
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_Rxv.jdField_a_of_type_Sar.a.b(rwy.a(this.jdField_a_of_type_Rwy))) {
        m(true);
      }
      if (this.jdField_a_of_type_Rxv.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        this.jdField_a_of_type_Rxv.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      this.jdField_a_of_type_Rxv.h.setVisibility(8);
      return;
    }
    if (!this.jdField_a_of_type_Rxv.jdField_a_of_type_Sar.a.b(rwy.a(this.jdField_a_of_type_Rwy)))
    {
      m(false);
      this.jdField_a_of_type_Rxv.h.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Rxv.h.setVisibility(8);
  }
  
  public void f(boolean paramBoolean)
  {
    super.f(paramBoolean);
    VideoInfo localVideoInfo = this.jdField_a_of_type_Rxv.jdField_a_of_type_Sar.a;
    boolean bool;
    if ((rwy.a(this.jdField_a_of_type_Rwy) == this.jdField_a_of_type_Rxv) && (rwy.a(this.jdField_a_of_type_Rwy).a()))
    {
      bool = true;
      b(localVideoInfo, bool);
      if (!paramBoolean) {
        break label138;
      }
      this.jdField_a_of_type_Rxv.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(rwy.b(this.jdField_a_of_type_Rwy));
      m(true);
      if (this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) {
        this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.b();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Rxv.jdField_a_of_type_Sar != null) {
        a(this.jdField_a_of_type_Rxv.f, this.jdField_a_of_type_Rxv.jdField_a_of_type_Sar.a, Boolean.valueOf(paramBoolean));
      }
      return;
      bool = false;
      break;
      label138:
      this.jdField_a_of_type_Rxv.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      if (!rwy.a(this.jdField_a_of_type_Rwy).a()) {
        m(false);
      }
      if ((this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) && (this.jdField_a_of_type_Rxv.c == 0) && (this.jdField_a_of_type_Rxv.jdField_a_of_type_Sar != null) && (this.jdField_a_of_type_Rxv.jdField_a_of_type_Sar.a.jdField_a_of_type_Int == 0)) {
        this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a();
      }
    }
  }
  
  protected void i(boolean paramBoolean)
  {
    super.i(paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Rxv.r.getVisibility() == 0)
      {
        ryx.a(this.jdField_a_of_type_Rxv.r, 8, 200);
        this.jdField_a_of_type_Rxv.r.animate().translationY(20.0F).setDuration(200L).start();
        this.jdField_a_of_type_Rxv.g.animate().translationY(-20.0F).setDuration(200L).start();
      }
      if ((this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) && (!rwy.a(this.jdField_a_of_type_Rwy))) {
        this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a();
      }
    }
    do
    {
      return;
      if ((!rwy.a(this.jdField_a_of_type_Rwy)) && (this.jdField_a_of_type_Rxv.r.getVisibility() == 8))
      {
        ryx.a(this.jdField_a_of_type_Rxv.r, 0, 200);
        this.jdField_a_of_type_Rxv.r.animate().translationY(0.0F).setDuration(200L).start();
        this.jdField_a_of_type_Rxv.g.animate().translationY(0.0F).setDuration(200L).start();
      }
    } while (this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null);
    this.jdField_a_of_type_Rxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxu
 * JD-Core Version:    0.7.0.1
 */
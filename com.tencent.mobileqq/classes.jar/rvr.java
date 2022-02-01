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

public class rvr
  extends rvo
{
  private rvs jdField_a_of_type_Rvs;
  
  public rvr(ruw paramruw, rvs paramrvs)
  {
    super(paramruw, paramrvs);
    this.jdField_a_of_type_Rvs = paramrvs;
    if ((paramrvs.jdField_o_of_type_AndroidViewViewGroup != null) && (rwv.a(ruw.a(paramruw))) && (Aladdin.getConfig(324).getIntegerFromString("videodetail_videogravity_style", 0) == 1)) {
      paramrvs.jdField_d_of_type_Int = paramrvs.jdField_o_of_type_AndroidViewViewGroup.getLayoutParams().height;
    }
  }
  
  private void a(ImageView paramImageView, VideoInfo paramVideoInfo)
  {
    if ((paramImageView == null) || (paramVideoInfo == null)) {
      return;
    }
    if ((!rwv.e()) || (TextUtils.isEmpty(paramVideoInfo.u)))
    {
      paramImageView.setVisibility(8);
      return;
    }
    Object localObject;
    if (paramVideoInfo.u.endsWith("zip"))
    {
      localObject = pid.a(paramVideoInfo.u);
      ((pid)localObject).setRepeatCount(0);
      paramImageView.setImageDrawable((Drawable)localObject);
      if ((paramImageView.getVisibility() == 8) && (ruw.a(this.jdField_a_of_type_Ruw).d()) && (ruw.a(this.jdField_a_of_type_Ruw).jdField_a_of_type_Ryo.a == paramVideoInfo)) {
        ((pid)localObject).playAnimation();
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
      arrayOfInt = paramVideoInfo.a(ruw.a(this.jdField_a_of_type_Ruw), paramBoolean.booleanValue(), this.jdField_a_of_type_Rvs.jdField_d_of_type_Int);
      if ((arrayOfInt[0] >= 0) && (arrayOfInt[1] >= 0)) {}
    }
    else
    {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramImageView.getLayoutParams();
    localLayoutParams.topMargin = arrayOfInt[0];
    localLayoutParams.rightMargin = arrayOfInt[1];
    if ((paramBoolean.booleanValue()) || (paramVideoInfo.b(ruw.a(this.jdField_a_of_type_Ruw)))) {
      localLayoutParams.width = AIOUtils.dp2px(91.0F, ruw.a(this.jdField_a_of_type_Ruw).getResources());
    }
    for (localLayoutParams.height = AIOUtils.dp2px(28.0F, ruw.a(this.jdField_a_of_type_Ruw).getResources());; localLayoutParams.height = AIOUtils.dp2px(24.0F, ruw.a(this.jdField_a_of_type_Ruw).getResources()))
    {
      paramImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = AIOUtils.dp2px(78.0F, ruw.a(this.jdField_a_of_type_Ruw).getResources());
    }
  }
  
  private void a(VideoInfo paramVideoInfo, TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    if ((paramVideoInfo.jdField_a_of_type_Int != 0) && (paramVideoInfo.jdField_a_of_type_Int != 5) && (paramVideoInfo.jdField_r_of_type_Int > 0))
    {
      paramTextView.setText(rwv.a(paramVideoInfo.jdField_r_of_type_Int));
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void c(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if ((paramBoolean) && (!paramVideoInfo.b(ruw.a(this.jdField_a_of_type_Ruw))))
    {
      this.jdField_a_of_type_Rvs.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, rwv.c(ruw.a(this.jdField_a_of_type_Ruw)));
      this.jdField_a_of_type_Rvs.i.setPadding(0, 0, 0, 0);
      return;
    }
    if ((this.jdField_a_of_type_Rvs.jdField_d_of_type_Int > 0) && (paramVideoInfo.a(ruw.a(this.jdField_a_of_type_Ruw), this.jdField_a_of_type_Rvs.jdField_d_of_type_Int) == 2))
    {
      this.jdField_a_of_type_Rvs.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_Rvs.i.setPadding(0, 0, 0, this.jdField_a_of_type_Rvs.jdField_d_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Rvs.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_Rvs.i.setPadding(0, 0, 0, 0);
  }
  
  private void d(VideoInfo paramVideoInfo)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = null;
    if (!TextUtils.isEmpty(paramVideoInfo.j)) {
      localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo.j), null);
    }
    if ((localReadInJoyUserInfo != null) && (!TextUtils.isEmpty(localReadInJoyUserInfo.smallIconUrl)))
    {
      this.jdField_a_of_type_Rvs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramVideoInfo = URLDrawable.URLDrawableOptions.obtain();
      paramVideoInfo.mRequestHeight = this.jdField_a_of_type_Rvs.jdField_a_of_type_AndroidWidgetImageView.getHeight();
      paramVideoInfo.mRequestWidth = this.jdField_a_of_type_Rvs.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      paramVideoInfo = URLDrawable.getDrawable(localReadInJoyUserInfo.smallIconUrl, paramVideoInfo);
      this.jdField_a_of_type_Rvs.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramVideoInfo);
      return;
    }
    this.jdField_a_of_type_Rvs.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void e(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Rvs.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImagePlaceHolder(ruw.a(this.jdField_a_of_type_Ruw));
    this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(paramVideoInfo.j);
    this.jdField_a_of_type_Rvs.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(paramVideoInfo.j);
    VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramVideoInfo.k);
    VideoFeedsAccessibilityHelper.c(this.jdField_a_of_type_Rvs.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, paramVideoInfo.k);
    if (ruw.l(this.jdField_a_of_type_Ruw)) {
      this.jdField_a_of_type_Rvs.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(null);
    }
    this.jdField_a_of_type_Rvs.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    if (!TextUtils.isEmpty(paramVideoInfo.j))
    {
      if ((paramVideoInfo.jdField_a_of_type_Pvp != null) && (paramVideoInfo.jdField_a_of_type_Pvp.jdField_a_of_type_Int == 1))
      {
        if ((this.jdField_a_of_type_Rvs == ruw.a(this.jdField_a_of_type_Ruw)) && (this.jdField_a_of_type_Rvs.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
          ruw.b(this.jdField_a_of_type_Ruw, paramVideoInfo);
        }
        this.jdField_a_of_type_Rvs.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_Rvs.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Rvs.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void m(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Rvs.jdField_g_of_type_AndroidViewViewGroup.getLayoutParams();
      localMarginLayoutParams.bottomMargin = AIOUtils.dp2px(0.0F, ruw.a(this.jdField_a_of_type_Ruw).getResources());
      this.jdField_a_of_type_Rvs.jdField_g_of_type_AndroidViewViewGroup.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Rvs.jdField_g_of_type_AndroidViewViewGroup.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (AIOUtils.dp2px(15.0F, ruw.a(this.jdField_a_of_type_Ruw).getResources()) - 20);
    this.jdField_a_of_type_Rvs.jdField_g_of_type_AndroidViewViewGroup.setLayoutParams(localMarginLayoutParams);
  }
  
  protected int a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.o) {
      return 2130843147;
    }
    return 2130843149;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (ruw.a(this.jdField_a_of_type_Ruw) != null) {
      ruw.a(this.jdField_a_of_type_Ruw).a(paramInt1, paramInt2);
    }
    if (paramBoolean) {
      d();
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    a(true);
    if (this.jdField_a_of_type_Rvs.m.getVisibility() == 0)
    {
      e(paramVideoInfo);
      d(paramVideoInfo);
      b(paramVideoInfo, false);
      this.jdField_a_of_type_Rvs.m.setTag(this.jdField_a_of_type_Rvs);
      this.jdField_a_of_type_Rvs.m.setOnClickListener(this.jdField_a_of_type_Ruw);
      this.jdField_a_of_type_Rvs.jdField_a_of_type_Rsm.a().setTag(this.jdField_a_of_type_Rvs);
      this.jdField_a_of_type_Rvs.jdField_a_of_type_Rsm.a().setOnClickListener(this.jdField_a_of_type_Ruw);
    }
    l(true);
    if (this.jdField_a_of_type_Rvs.jdField_o_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      a(this.jdField_a_of_type_Rvs, paramVideoInfo);
      if (qxs.a())
      {
        this.jdField_a_of_type_Rvs.l.setTag(this.jdField_a_of_type_Rvs);
        this.jdField_a_of_type_Rvs.l.setOnClickListener(this.jdField_a_of_type_Ruw);
        this.jdField_a_of_type_Rvs.l.setVisibility(0);
      }
    }
    if (paramVideoInfo.b(ruw.a(this.jdField_a_of_type_Ruw))) {
      this.jdField_a_of_type_Rvs.h.setVisibility(8);
    }
    for (;;)
    {
      if ((ruw.a(this.jdField_a_of_type_Ruw) == this.jdField_a_of_type_Rvs) && (ruw.a(this.jdField_a_of_type_Ruw)))
      {
        a(false);
        l(false);
      }
      if (paramVideoInfo.a()) {
        this.jdField_a_of_type_Rvs.jdField_o_of_type_AndroidWidgetImageView.setImageDrawable(ruw.a(this.jdField_a_of_type_Ruw, a(paramVideoInfo.jdField_r_of_type_Boolean)));
      }
      VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_Rvs, this.jdField_a_of_type_Ruw);
      a(this.jdField_a_of_type_Rvs.jdField_d_of_type_AndroidWidgetImageView, paramVideoInfo);
      a(this.jdField_a_of_type_Rvs.jdField_d_of_type_AndroidWidgetImageView, paramVideoInfo, Boolean.valueOf(ruw.a(this.jdField_a_of_type_Ruw)));
      return;
      this.jdField_a_of_type_Rvs.h.setVisibility(0);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    if ((ruw.a(this.jdField_a_of_type_Ruw) == this.jdField_a_of_type_Rvs) && (ruw.a(this.jdField_a_of_type_Ruw).a()))
    {
      paramBoolean = true;
      c(paramVideoInfo, paramBoolean);
      this.jdField_a_of_type_Rvs.z.getPaint().setFakeBoldText(false);
      this.jdField_a_of_type_Rvs.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      if (!paramVideoInfo.b(ruw.a(this.jdField_a_of_type_Ruw))) {
        break label350;
      }
      this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(0);
      if (this.jdField_a_of_type_Rvs.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_Rvs.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      label112:
      m(false);
      if ((ruw.a(this.jdField_a_of_type_Ruw).a()) && (ruw.k(this.jdField_a_of_type_Ruw)))
      {
        ruw.h(this.jdField_a_of_type_Ruw, false);
        e(true);
      }
      if ((this.jdField_a_of_type_Rvs.jdField_c_of_type_Int != 0) || (paramVideoInfo.jdField_a_of_type_Int != 0)) {
        break label387;
      }
      if (this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) {
        this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = new VideoFeedsAioGuideView(ruw.a(this.jdField_a_of_type_Ruw), ruw.a(this.jdField_a_of_type_Ruw), ruw.a(this.jdField_a_of_type_Ruw));
      }
      this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a(this.jdField_a_of_type_Rvs);
      label230:
      if ((ruw.a(this.jdField_a_of_type_Ruw).getIntent() == null) || (TextUtils.isEmpty(ruw.a(this.jdField_a_of_type_Ruw).getIntent().getStringExtra("video_feeds_back_color")))) {
        break label418;
      }
      this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(Color.parseColor(ruw.a(this.jdField_a_of_type_Ruw).getIntent().getStringExtra("video_feeds_back_color"))));
      ruw.a(this.jdField_a_of_type_Ruw).getIntent().removeExtra("video_feeds_back_color");
    }
    for (;;)
    {
      a(paramVideoInfo, this.jdField_a_of_type_Rvs.jdField_a_of_type_AndroidWidgetTextView);
      ruw.a(this.jdField_a_of_type_Ruw).b(paramVideoInfo, this.jdField_a_of_type_Rvs);
      return;
      paramBoolean = false;
      break;
      label350:
      this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(8);
      if (this.jdField_a_of_type_Rvs.jdField_a_of_type_AndroidViewView == null) {
        break label112;
      }
      this.jdField_a_of_type_Rvs.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label112;
      label387:
      if (this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) {
        break label230;
      }
      this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.c();
      this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = null;
      break label230;
      label418:
      if (paramVideoInfo.b(ruw.a(this.jdField_a_of_type_Ruw)))
      {
        this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      }
      else if (paramVideoInfo.a() != null)
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        localObject = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setDecodeHandler(bfol.x);
        ((URLDrawable)localObject).setAlpha(35);
        this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    super.b(paramVideoInfo);
    e(paramVideoInfo);
    d(paramVideoInfo);
    rwv.a(paramVideoInfo, this.jdField_a_of_type_Rvs.z);
    rwv.a(paramVideoInfo, this.jdField_a_of_type_Rvs.y);
    ruw.a(this.jdField_a_of_type_Ruw, this.jdField_a_of_type_Rvs, paramVideoInfo);
    b(paramVideoInfo, true);
    a(paramVideoInfo, this.jdField_a_of_type_Rvs.jdField_a_of_type_AndroidWidgetTextView);
    if (this.jdField_a_of_type_Rvs.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 8)
    {
      a(this.jdField_a_of_type_Rvs.jdField_d_of_type_AndroidWidgetImageView, paramVideoInfo);
      a(this.jdField_a_of_type_Rvs.jdField_d_of_type_AndroidWidgetImageView, paramVideoInfo, Boolean.valueOf(ruw.a(this.jdField_a_of_type_Ruw)));
    }
    ruw.a(this.jdField_a_of_type_Ruw).a(paramVideoInfo, this.jdField_a_of_type_Rvs);
    if (qxs.a())
    {
      this.jdField_a_of_type_Rvs.jdField_g_of_type_AndroidWidgetImageView.setImageResource(a(paramVideoInfo));
      rwv.b(this.jdField_a_of_type_Rvs.k, paramVideoInfo.p, ruw.a(this.jdField_a_of_type_Ruw).getString(2131717721));
    }
  }
  
  protected void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Rvs.jdField_a_of_type_Rsm == null) {
      return;
    }
    boolean bool = paramVideoInfo.q;
    if ((TextUtils.isEmpty(paramVideoInfo.j)) || ("16888".equals(paramVideoInfo.j)) || (paramVideoInfo.c) || (paramVideoInfo.a(ruw.a(this.jdField_a_of_type_Ruw))))
    {
      this.jdField_a_of_type_Rvs.jdField_a_of_type_Rsm.a().setVisibility(8);
      rwv.a(this.jdField_a_of_type_Rvs.j, 8, 0);
      return;
    }
    this.jdField_a_of_type_Rvs.jdField_a_of_type_Rsm.a(paramVideoInfo, paramVideoInfo.q);
    if ((paramBoolean) && (this.jdField_a_of_type_Rvs == ruw.a(this.jdField_a_of_type_Ruw)) && (ruw.a(this.jdField_a_of_type_Ruw) != null) && (bool) && (this.jdField_a_of_type_Rvs.jdField_a_of_type_Rsm.a().getVisibility() == 0))
    {
      ruw.a(this.jdField_a_of_type_Ruw).sendEmptyMessageDelayed(7, this.jdField_a_of_type_Rvs.jdField_a_of_type_Rsm.a());
      rwv.b(this.jdField_a_of_type_Rvs.j, 0);
      return;
    }
    if (bool)
    {
      this.jdField_a_of_type_Rvs.jdField_a_of_type_Rsm.a().setVisibility(8);
      rwv.a(this.jdField_a_of_type_Rvs.j, 0, 0);
      return;
    }
    this.jdField_a_of_type_Rvs.jdField_a_of_type_Rsm.a().setVisibility(0);
    rwv.a(this.jdField_a_of_type_Rvs.j, 8, 0);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Rvs.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {}
    for (boolean bool = true;; bool = false)
    {
      i(bool);
      return;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rvs.jdField_c_of_type_ComTencentImageURLImageView.clearAnimation();
    c(this.jdField_a_of_type_Rvs.jdField_a_of_type_Ryo.a, paramBoolean);
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_Rvs.jdField_a_of_type_Ryo.a.b(ruw.a(this.jdField_a_of_type_Ruw))) {
        m(true);
      }
      if (this.jdField_a_of_type_Rvs.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        this.jdField_a_of_type_Rvs.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      this.jdField_a_of_type_Rvs.h.setVisibility(8);
      return;
    }
    if (!this.jdField_a_of_type_Rvs.jdField_a_of_type_Ryo.a.b(ruw.a(this.jdField_a_of_type_Ruw)))
    {
      m(false);
      this.jdField_a_of_type_Rvs.h.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Rvs.h.setVisibility(8);
  }
  
  public void f(boolean paramBoolean)
  {
    super.f(paramBoolean);
    VideoInfo localVideoInfo = this.jdField_a_of_type_Rvs.jdField_a_of_type_Ryo.a;
    boolean bool;
    if ((ruw.a(this.jdField_a_of_type_Ruw) == this.jdField_a_of_type_Rvs) && (ruw.a(this.jdField_a_of_type_Ruw).a()))
    {
      bool = true;
      c(localVideoInfo, bool);
      if (!paramBoolean) {
        break label138;
      }
      this.jdField_a_of_type_Rvs.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(ruw.b(this.jdField_a_of_type_Ruw));
      m(true);
      if (this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) {
        this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.b();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Rvs.jdField_a_of_type_Ryo != null) {
        a(this.jdField_a_of_type_Rvs.jdField_d_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Rvs.jdField_a_of_type_Ryo.a, Boolean.valueOf(paramBoolean));
      }
      return;
      bool = false;
      break;
      label138:
      this.jdField_a_of_type_Rvs.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      if (!ruw.a(this.jdField_a_of_type_Ruw).a()) {
        m(false);
      }
      if ((this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) && (this.jdField_a_of_type_Rvs.jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_Rvs.jdField_a_of_type_Ryo != null) && (this.jdField_a_of_type_Rvs.jdField_a_of_type_Ryo.a.jdField_a_of_type_Int == 0)) {
        this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a();
      }
    }
  }
  
  protected void i(boolean paramBoolean)
  {
    super.i(paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Rvs.r.getVisibility() == 0)
      {
        rwv.a(this.jdField_a_of_type_Rvs.r, 8, 200);
        this.jdField_a_of_type_Rvs.r.animate().translationY(20.0F).setDuration(200L).start();
        this.jdField_a_of_type_Rvs.jdField_g_of_type_AndroidViewViewGroup.animate().translationY(-20.0F).setDuration(200L).start();
      }
      if ((this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) && (!ruw.a(this.jdField_a_of_type_Ruw))) {
        this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a();
      }
    }
    do
    {
      return;
      if ((!ruw.a(this.jdField_a_of_type_Ruw)) && (this.jdField_a_of_type_Rvs.r.getVisibility() == 8))
      {
        rwv.a(this.jdField_a_of_type_Rvs.r, 0, 200);
        this.jdField_a_of_type_Rvs.r.animate().translationY(0.0F).setDuration(200L).start();
        this.jdField_a_of_type_Rvs.jdField_g_of_type_AndroidViewViewGroup.animate().translationY(0.0F).setDuration(200L).start();
      }
    } while (this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null);
    this.jdField_a_of_type_Rvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvr
 * JD-Core Version:    0.7.0.1
 */
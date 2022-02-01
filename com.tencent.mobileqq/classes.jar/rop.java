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

public class rop
  extends rom
{
  private roq jdField_a_of_type_Roq;
  
  public rop(rnu paramrnu, roq paramroq)
  {
    super(paramrnu, paramroq);
    this.jdField_a_of_type_Roq = paramroq;
    if ((paramroq.n != null) && (rpt.a(rnu.a(paramrnu))) && (Aladdin.getConfig(324).getIntegerFromString("videodetail_videogravity_style", 0) == 1)) {
      paramroq.jdField_d_of_type_Int = paramroq.n.getLayoutParams().height;
    }
  }
  
  private void a(ImageView paramImageView, VideoInfo paramVideoInfo)
  {
    if ((paramImageView == null) || (paramVideoInfo == null)) {
      return;
    }
    if ((!rpt.e()) || (TextUtils.isEmpty(paramVideoInfo.u)))
    {
      paramImageView.setVisibility(8);
      return;
    }
    Object localObject;
    if (paramVideoInfo.u.endsWith("zip"))
    {
      localObject = pcs.a(paramVideoInfo.u);
      ((pcs)localObject).setRepeatCount(0);
      paramImageView.setImageDrawable((Drawable)localObject);
      if ((paramImageView.getVisibility() == 8) && (rnu.a(this.jdField_a_of_type_Rnu).d()) && (rnu.a(this.jdField_a_of_type_Rnu).jdField_a_of_type_Rrm.a == paramVideoInfo)) {
        ((pcs)localObject).playAnimation();
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
      arrayOfInt = paramVideoInfo.a(rnu.a(this.jdField_a_of_type_Rnu), paramBoolean.booleanValue(), this.jdField_a_of_type_Roq.jdField_d_of_type_Int);
      if ((arrayOfInt[0] >= 0) && (arrayOfInt[1] >= 0)) {}
    }
    else
    {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramImageView.getLayoutParams();
    localLayoutParams.topMargin = arrayOfInt[0];
    localLayoutParams.rightMargin = arrayOfInt[1];
    if ((paramBoolean.booleanValue()) || (paramVideoInfo.b(rnu.a(this.jdField_a_of_type_Rnu)))) {
      localLayoutParams.width = agej.a(91.0F, rnu.a(this.jdField_a_of_type_Rnu).getResources());
    }
    for (localLayoutParams.height = agej.a(28.0F, rnu.a(this.jdField_a_of_type_Rnu).getResources());; localLayoutParams.height = agej.a(24.0F, rnu.a(this.jdField_a_of_type_Rnu).getResources()))
    {
      paramImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = agej.a(78.0F, rnu.a(this.jdField_a_of_type_Rnu).getResources());
    }
  }
  
  private void a(VideoInfo paramVideoInfo, TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    if ((paramVideoInfo.a != 0) && (paramVideoInfo.a != 5) && (paramVideoInfo.q > 0))
    {
      paramTextView.setText(rpt.a(paramVideoInfo.q));
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void c(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if ((paramBoolean) && (!paramVideoInfo.b(rnu.a(this.jdField_a_of_type_Rnu))))
    {
      this.jdField_a_of_type_Roq.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, rpt.c(rnu.a(this.jdField_a_of_type_Rnu)));
      this.jdField_a_of_type_Roq.i.setPadding(0, 0, 0, 0);
      return;
    }
    if ((this.jdField_a_of_type_Roq.jdField_d_of_type_Int > 0) && (paramVideoInfo.a(rnu.a(this.jdField_a_of_type_Rnu), this.jdField_a_of_type_Roq.jdField_d_of_type_Int) == 2))
    {
      this.jdField_a_of_type_Roq.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_Roq.i.setPadding(0, 0, 0, this.jdField_a_of_type_Roq.jdField_d_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Roq.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_Roq.i.setPadding(0, 0, 0, 0);
  }
  
  private void d(VideoInfo paramVideoInfo)
  {
    if (!TextUtils.isEmpty(paramVideoInfo.v))
    {
      this.jdField_a_of_type_Roq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_Roq.jdField_a_of_type_AndroidWidgetImageView.getHeight();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Roq.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.v, localURLDrawableOptions);
      this.jdField_a_of_type_Roq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramVideoInfo);
      return;
    }
    this.jdField_a_of_type_Roq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void e(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Roq.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImagePlaceHolder(rnu.a(this.jdField_a_of_type_Rnu));
    this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(paramVideoInfo.j);
    this.jdField_a_of_type_Roq.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(paramVideoInfo.j);
    VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramVideoInfo.k);
    VideoFeedsAccessibilityHelper.c(this.jdField_a_of_type_Roq.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, paramVideoInfo.k);
    if (rnu.l(this.jdField_a_of_type_Rnu)) {
      this.jdField_a_of_type_Roq.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(null);
    }
    this.jdField_a_of_type_Roq.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    if (!TextUtils.isEmpty(paramVideoInfo.j))
    {
      ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo.j), null);
      if ((localReadInJoyUserInfo != null) && (localReadInJoyUserInfo.isLiving()))
      {
        if ((this.jdField_a_of_type_Roq == rnu.a(this.jdField_a_of_type_Rnu)) && (this.jdField_a_of_type_Roq.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
          rnu.b(this.jdField_a_of_type_Rnu, paramVideoInfo);
        }
        this.jdField_a_of_type_Roq.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_Roq.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Roq.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void m(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Roq.g.getLayoutParams();
      localMarginLayoutParams.bottomMargin = agej.a(0.0F, rnu.a(this.jdField_a_of_type_Rnu).getResources());
      this.jdField_a_of_type_Roq.g.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Roq.g.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (agej.a(15.0F, rnu.a(this.jdField_a_of_type_Rnu).getResources()) - 20);
    this.jdField_a_of_type_Roq.g.setLayoutParams(localMarginLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (rnu.a(this.jdField_a_of_type_Rnu) != null) {
      rnu.a(this.jdField_a_of_type_Rnu).a(paramInt1, paramInt2);
    }
    if (paramBoolean) {
      d();
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    a(true);
    if (this.jdField_a_of_type_Roq.l.getVisibility() == 0)
    {
      e(paramVideoInfo);
      d(paramVideoInfo);
      b(paramVideoInfo, false);
      this.jdField_a_of_type_Roq.l.setTag(this.jdField_a_of_type_Roq);
      this.jdField_a_of_type_Roq.l.setOnClickListener(this.jdField_a_of_type_Rnu);
      this.jdField_a_of_type_Roq.jdField_a_of_type_Rlm.a().setTag(this.jdField_a_of_type_Roq);
      this.jdField_a_of_type_Roq.jdField_a_of_type_Rlm.a().setOnClickListener(this.jdField_a_of_type_Rnu);
    }
    l(true);
    if (this.jdField_a_of_type_Roq.n.getVisibility() == 0) {
      a(this.jdField_a_of_type_Roq, paramVideoInfo);
    }
    if (paramVideoInfo.b(rnu.a(this.jdField_a_of_type_Rnu))) {
      this.jdField_a_of_type_Roq.h.setVisibility(8);
    }
    for (;;)
    {
      if ((rnu.a(this.jdField_a_of_type_Rnu) == this.jdField_a_of_type_Roq) && (rnu.a(this.jdField_a_of_type_Rnu)))
      {
        a(false);
        l(false);
      }
      if (paramVideoInfo.a()) {
        this.jdField_a_of_type_Roq.o.setImageDrawable(rnu.a(this.jdField_a_of_type_Rnu, a(paramVideoInfo.o)));
      }
      VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_Roq, this.jdField_a_of_type_Rnu);
      a(this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidWidgetImageView, paramVideoInfo);
      a(this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidWidgetImageView, paramVideoInfo, Boolean.valueOf(rnu.a(this.jdField_a_of_type_Rnu)));
      return;
      this.jdField_a_of_type_Roq.h.setVisibility(0);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    if ((rnu.a(this.jdField_a_of_type_Rnu) == this.jdField_a_of_type_Roq) && (rnu.a(this.jdField_a_of_type_Rnu).a()))
    {
      paramBoolean = true;
      c(paramVideoInfo, paramBoolean);
      this.jdField_a_of_type_Roq.z.getPaint().setFakeBoldText(false);
      this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      if (!paramVideoInfo.b(rnu.a(this.jdField_a_of_type_Rnu))) {
        break label350;
      }
      this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(0);
      if (this.jdField_a_of_type_Roq.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_Roq.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      label112:
      m(false);
      if ((rnu.a(this.jdField_a_of_type_Rnu).a()) && (rnu.k(this.jdField_a_of_type_Rnu)))
      {
        rnu.h(this.jdField_a_of_type_Rnu, false);
        e(true);
      }
      if ((this.jdField_a_of_type_Roq.c != 0) || (paramVideoInfo.a != 0)) {
        break label387;
      }
      if (this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) {
        this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = new VideoFeedsAioGuideView(rnu.a(this.jdField_a_of_type_Rnu), rnu.a(this.jdField_a_of_type_Rnu), rnu.a(this.jdField_a_of_type_Rnu));
      }
      this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a(this.jdField_a_of_type_Roq);
      label230:
      if ((rnu.a(this.jdField_a_of_type_Rnu).getIntent() == null) || (TextUtils.isEmpty(rnu.a(this.jdField_a_of_type_Rnu).getIntent().getStringExtra("video_feeds_back_color")))) {
        break label418;
      }
      this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(Color.parseColor(rnu.a(this.jdField_a_of_type_Rnu).getIntent().getStringExtra("video_feeds_back_color"))));
      rnu.a(this.jdField_a_of_type_Rnu).getIntent().removeExtra("video_feeds_back_color");
    }
    for (;;)
    {
      a(paramVideoInfo, this.jdField_a_of_type_Roq.jdField_a_of_type_AndroidWidgetTextView);
      rnu.a(this.jdField_a_of_type_Rnu).b(paramVideoInfo, this.jdField_a_of_type_Roq);
      return;
      paramBoolean = false;
      break;
      label350:
      this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(8);
      if (this.jdField_a_of_type_Roq.jdField_a_of_type_AndroidViewView == null) {
        break label112;
      }
      this.jdField_a_of_type_Roq.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label112;
      label387:
      if (this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) {
        break label230;
      }
      this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.c();
      this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = null;
      break label230;
      label418:
      if (paramVideoInfo.b(rnu.a(this.jdField_a_of_type_Rnu)))
      {
        this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      }
      else if (paramVideoInfo.a() != null)
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        localObject = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setDecodeHandler(bhez.x);
        ((URLDrawable)localObject).setAlpha(35);
        this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    super.b(paramVideoInfo);
    e(paramVideoInfo);
    d(paramVideoInfo);
    rpt.a(paramVideoInfo, this.jdField_a_of_type_Roq.z);
    rpt.a(paramVideoInfo, this.jdField_a_of_type_Roq.y);
    rnu.a(this.jdField_a_of_type_Rnu, this.jdField_a_of_type_Roq, paramVideoInfo);
    b(paramVideoInfo, true);
    a(paramVideoInfo, this.jdField_a_of_type_Roq.jdField_a_of_type_AndroidWidgetTextView);
    if (this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 8)
    {
      a(this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidWidgetImageView, paramVideoInfo);
      a(this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidWidgetImageView, paramVideoInfo, Boolean.valueOf(rnu.a(this.jdField_a_of_type_Rnu)));
    }
    rnu.a(this.jdField_a_of_type_Rnu).a(paramVideoInfo, this.jdField_a_of_type_Roq);
  }
  
  protected void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Roq.jdField_a_of_type_Rlm == null) {
      return;
    }
    boolean bool = paramVideoInfo.n;
    if ((TextUtils.isEmpty(paramVideoInfo.j)) || ("16888".equals(paramVideoInfo.j)) || (paramVideoInfo.c) || (paramVideoInfo.a(rnu.a(this.jdField_a_of_type_Rnu))))
    {
      this.jdField_a_of_type_Roq.jdField_a_of_type_Rlm.a().setVisibility(8);
      rpt.a(this.jdField_a_of_type_Roq.j, 8, 0);
      return;
    }
    this.jdField_a_of_type_Roq.jdField_a_of_type_Rlm.a(paramVideoInfo, paramVideoInfo.n);
    if ((paramBoolean) && (this.jdField_a_of_type_Roq == rnu.a(this.jdField_a_of_type_Rnu)) && (rnu.a(this.jdField_a_of_type_Rnu) != null) && (bool) && (this.jdField_a_of_type_Roq.jdField_a_of_type_Rlm.a().getVisibility() == 0))
    {
      rnu.a(this.jdField_a_of_type_Rnu).sendEmptyMessageDelayed(7, this.jdField_a_of_type_Roq.jdField_a_of_type_Rlm.a());
      rpt.b(this.jdField_a_of_type_Roq.j, 0);
      return;
    }
    if (bool)
    {
      this.jdField_a_of_type_Roq.jdField_a_of_type_Rlm.a().setVisibility(8);
      rpt.a(this.jdField_a_of_type_Roq.j, 0, 0);
      return;
    }
    this.jdField_a_of_type_Roq.jdField_a_of_type_Rlm.a().setVisibility(0);
    rpt.a(this.jdField_a_of_type_Roq.j, 8, 0);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {}
    for (boolean bool = true;; bool = false)
    {
      i(bool);
      return;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Roq.jdField_b_of_type_ComTencentImageURLImageView.clearAnimation();
    c(this.jdField_a_of_type_Roq.jdField_a_of_type_Rrm.a, paramBoolean);
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_Roq.jdField_a_of_type_Rrm.a.b(rnu.a(this.jdField_a_of_type_Rnu))) {
        m(true);
      }
      if (this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      this.jdField_a_of_type_Roq.h.setVisibility(8);
      return;
    }
    if (!this.jdField_a_of_type_Roq.jdField_a_of_type_Rrm.a.b(rnu.a(this.jdField_a_of_type_Rnu)))
    {
      m(false);
      this.jdField_a_of_type_Roq.h.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Roq.h.setVisibility(8);
  }
  
  public void f(boolean paramBoolean)
  {
    super.f(paramBoolean);
    VideoInfo localVideoInfo = this.jdField_a_of_type_Roq.jdField_a_of_type_Rrm.a;
    boolean bool;
    if ((rnu.a(this.jdField_a_of_type_Rnu) == this.jdField_a_of_type_Roq) && (rnu.a(this.jdField_a_of_type_Rnu).a()))
    {
      bool = true;
      c(localVideoInfo, bool);
      if (!paramBoolean) {
        break label138;
      }
      this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(rnu.b(this.jdField_a_of_type_Rnu));
      m(true);
      if (this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) {
        this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.b();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Roq.jdField_a_of_type_Rrm != null) {
        a(this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Roq.jdField_a_of_type_Rrm.a, Boolean.valueOf(paramBoolean));
      }
      return;
      bool = false;
      break;
      label138:
      this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      if (!rnu.a(this.jdField_a_of_type_Rnu).a()) {
        m(false);
      }
      if ((this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) && (this.jdField_a_of_type_Roq.c == 0) && (this.jdField_a_of_type_Roq.jdField_a_of_type_Rrm != null) && (this.jdField_a_of_type_Roq.jdField_a_of_type_Rrm.a.a == 0)) {
        this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a();
      }
    }
  }
  
  protected void i(boolean paramBoolean)
  {
    super.i(paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Roq.q.getVisibility() == 0)
      {
        rpt.a(this.jdField_a_of_type_Roq.q, 8, 200);
        this.jdField_a_of_type_Roq.q.animate().translationY(20.0F).setDuration(200L).start();
        this.jdField_a_of_type_Roq.g.animate().translationY(-20.0F).setDuration(200L).start();
      }
      if ((this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) && (!rnu.a(this.jdField_a_of_type_Rnu))) {
        this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a();
      }
    }
    do
    {
      return;
      if ((!rnu.a(this.jdField_a_of_type_Rnu)) && (this.jdField_a_of_type_Roq.q.getVisibility() == 8))
      {
        rpt.a(this.jdField_a_of_type_Roq.q, 0, 200);
        this.jdField_a_of_type_Roq.q.animate().translationY(0.0F).setDuration(200L).start();
        this.jdField_a_of_type_Roq.g.animate().translationY(0.0F).setDuration(200L).start();
      }
    } while (this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null);
    this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rop
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAioGuideView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGradientMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTopicViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class rbr
  extends rbo
{
  private rbs a;
  
  public rbr(raw paramraw, rbs paramrbs)
  {
    super(paramraw, paramrbs);
    this.jdField_a_of_type_Rbs = paramrbs;
  }
  
  private void a(VideoInfo paramVideoInfo, TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramVideoInfo.e())
    {
      paramTextView.setText(rdm.c(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_Int) + alpo.a(2131716608));
      paramTextView.setVisibility(0);
      return;
    }
    if ((paramVideoInfo.jdField_a_of_type_Int != 0) && (paramVideoInfo.jdField_a_of_type_Int != 5) && (paramVideoInfo.jdField_p_of_type_Int > 0))
    {
      paramTextView.setText(rdm.a(paramVideoInfo.jdField_p_of_type_Int));
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Rbs.jdField_a_of_type_Qyu == null) {
      return;
    }
    if (paramVideoInfo.e()) {}
    for (boolean bool = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Boolean; (TextUtils.isEmpty(paramVideoInfo.j)) || ("16888".equals(paramVideoInfo.j)) || (paramVideoInfo.jdField_c_of_type_Boolean) || (paramVideoInfo.a(raw.a(this.jdField_a_of_type_Raw))); bool = paramVideoInfo.o)
    {
      this.jdField_a_of_type_Rbs.jdField_a_of_type_Qyu.a().setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Rbs.jdField_a_of_type_Qyu.a(paramVideoInfo, paramVideoInfo.o);
    if ((paramBoolean) && (this.jdField_a_of_type_Rbs == raw.a(this.jdField_a_of_type_Raw)) && (raw.a(this.jdField_a_of_type_Raw) != null) && (bool) && (this.jdField_a_of_type_Rbs.jdField_a_of_type_Qyu.a().getVisibility() == 0))
    {
      raw.a(this.jdField_a_of_type_Raw).sendEmptyMessageDelayed(7, this.jdField_a_of_type_Rbs.jdField_a_of_type_Qyu.a());
      return;
    }
    if (bool)
    {
      this.jdField_a_of_type_Rbs.jdField_a_of_type_Qyu.a().setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Rbs.jdField_a_of_type_Qyu.a().setVisibility(0);
  }
  
  private void e(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.e == 1))
    {
      if (this.jdField_a_of_type_Rbs.k == null)
      {
        ((ViewStub)this.jdField_a_of_type_Rbs.p.findViewById(2131379652)).inflate();
        this.jdField_a_of_type_Rbs.k = ((ViewGroup)this.jdField_a_of_type_Rbs.p.findViewById(2131379637));
        this.jdField_a_of_type_Rbs.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_Rbs.k.findViewById(2131379646));
        this.jdField_a_of_type_Rbs.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_Rbs.k.findViewById(2131379647));
        this.jdField_a_of_type_Rbs.jdField_d_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_Rbs.k.findViewById(2131379632));
      }
      this.jdField_a_of_type_Rbs.k.setOnClickListener(this.jdField_a_of_type_Raw);
      this.jdField_a_of_type_Rbs.k.setTag(this.jdField_a_of_type_Rbs);
      this.jdField_a_of_type_Rbs.k.setVisibility(0);
      this.jdField_a_of_type_Rbs.jdField_h_of_type_AndroidWidgetTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.b);
      this.jdField_a_of_type_Rbs.jdField_g_of_type_AndroidWidgetTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.i);
      if (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_JavaLangString))
      {
        paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_Rbs.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable(paramVideoInfo);
      }
    }
    while (this.jdField_a_of_type_Rbs.k == null)
    {
      return;
      this.jdField_a_of_type_Rbs.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      return;
    }
    this.jdField_a_of_type_Rbs.k.setVisibility(8);
  }
  
  private void f(VideoInfo paramVideoInfo)
  {
    if (!TextUtils.isEmpty(paramVideoInfo.t))
    {
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getHeight();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getWidth();
      paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.t, localURLDrawableOptions);
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(paramVideoInfo);
      return;
    }
    this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
  }
  
  private void g(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Rbs.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_Rbs.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    this.jdField_a_of_type_Rbs.e.setVisibility(0);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = raw.a(this.jdField_a_of_type_Raw);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = raw.a(this.jdField_a_of_type_Raw);
    try
    {
      localObject = URLDrawable.getDrawable(new URL(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(bcuq.b(bcwh.a(raw.a(this.jdField_a_of_type_Raw), 40.0F), bcwh.a(raw.a(this.jdField_a_of_type_Raw), 40.0F), bcwh.a(raw.a(this.jdField_a_of_type_Raw), 4.0F)));
      ((URLDrawable)localObject).setDecodeHandler(bcuq.i);
      this.jdField_a_of_type_Rbs.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.a());
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "initVideoItemContentUI() ERROR e = " + localMalformedURLException.getMessage());
        }
      }
    }
  }
  
  private void h(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.e())
    {
      g(paramVideoInfo);
      return;
    }
    this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.a(raw.a(this.jdField_a_of_type_Raw));
    if (!paramVideoInfo.b)
    {
      if (!TextUtils.isEmpty(paramVideoInfo.k))
      {
        this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.k);
        this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
        VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramVideoInfo.k);
        VideoFeedsAccessibilityHelper.c(this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, paramVideoInfo.k);
      }
      if (!TextUtils.isEmpty(paramVideoInfo.n)) {
        this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageSrc(paramVideoInfo.n);
      }
    }
    for (;;)
    {
      if (raw.m(this.jdField_a_of_type_Raw)) {
        this.jdField_a_of_type_Rbs.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(null);
      }
      this.jdField_a_of_type_Rbs.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_Rbs.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
      this.jdField_a_of_type_Rbs.e.setVisibility(8);
      return;
      if (!TextUtils.isEmpty(paramVideoInfo.j))
      {
        this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(Long.valueOf(paramVideoInfo.j).longValue(), false);
        continue;
        this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(paramVideoInfo.j);
        this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(paramVideoInfo.j);
      }
    }
  }
  
  private void k(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Rbs.jdField_g_of_type_AndroidViewViewGroup.getLayoutParams();
      localMarginLayoutParams.bottomMargin = aekt.a(0.0F, raw.a(this.jdField_a_of_type_Raw).getResources());
      this.jdField_a_of_type_Rbs.jdField_g_of_type_AndroidViewViewGroup.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Rbs.jdField_g_of_type_AndroidViewViewGroup.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (aekt.a(15.0F, raw.a(this.jdField_a_of_type_Raw).getResources()) - 20);
    this.jdField_a_of_type_Rbs.jdField_g_of_type_AndroidViewViewGroup.setLayoutParams(localMarginLayoutParams);
  }
  
  int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Rbs.jdField_a_of_type_Boolean)
    {
      if (paramBoolean) {
        return 2130842728;
      }
      return 2130842730;
    }
    return super.a(paramBoolean);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (raw.a(this.jdField_a_of_type_Raw) != null) {
      raw.a(this.jdField_a_of_type_Raw).a(paramInt1, paramInt2);
    }
    if (paramBoolean) {
      d();
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    b(true);
    if (this.jdField_a_of_type_Rbs.jdField_l_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      h(paramVideoInfo);
      f(paramVideoInfo);
      b(paramVideoInfo, false);
      this.jdField_a_of_type_Rbs.jdField_l_of_type_AndroidViewViewGroup.setTag(this.jdField_a_of_type_Rbs);
      this.jdField_a_of_type_Rbs.jdField_l_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_Raw);
      this.jdField_a_of_type_Rbs.jdField_a_of_type_Qyu.a().setTag(this.jdField_a_of_type_Rbs);
      this.jdField_a_of_type_Rbs.jdField_a_of_type_Qyu.a().setOnClickListener(this.jdField_a_of_type_Raw);
    }
    j(true);
    if (this.jdField_a_of_type_Rbs.m.getVisibility() == 0) {
      a(this.jdField_a_of_type_Rbs, paramVideoInfo);
    }
    if (paramVideoInfo.b(raw.a(this.jdField_a_of_type_Raw))) {
      this.jdField_a_of_type_Rbs.jdField_h_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    for (;;)
    {
      if ((raw.a(this.jdField_a_of_type_Raw) == this.jdField_a_of_type_Rbs) && (raw.a(this.jdField_a_of_type_Raw)))
      {
        b(false);
        j(false);
      }
      if (paramVideoInfo.a()) {
        this.jdField_a_of_type_Rbs.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable(raw.a(this.jdField_a_of_type_Raw, a(paramVideoInfo.jdField_p_of_type_Boolean)));
      }
      VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_Rbs, this.jdField_a_of_type_Raw);
      raw.a(this.jdField_a_of_type_Raw, this.jdField_a_of_type_Rbs.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoInfo);
      raw.a(this.jdField_a_of_type_Raw, this.jdField_a_of_type_Rbs.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoInfo, Boolean.valueOf(raw.a(this.jdField_a_of_type_Raw)));
      return;
      this.jdField_a_of_type_Rbs.jdField_h_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    this.jdField_a_of_type_Rbs.B.getPaint().setFakeBoldText(false);
    if (raw.a(this.jdField_a_of_type_Raw) != null) {
      raw.a(this.jdField_a_of_type_Raw).a(paramVideoInfo, this.jdField_a_of_type_Rbs, false);
    }
    if (paramVideoInfo.jdField_a_of_type_JavaUtilArrayList != null) {
      if ((this.jdField_a_of_type_Rbs.i != null) && (this.jdField_a_of_type_Rbs.i.getVisibility() != 8))
      {
        this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.post(new VideoFeedsAdapter.ShortVideoItemDelegate.1(this, paramVideoInfo));
        this.jdField_a_of_type_Rbs.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
        if (!paramVideoInfo.b(raw.a(this.jdField_a_of_type_Raw))) {
          break label397;
        }
        this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(0);
        if (this.jdField_a_of_type_Rbs.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_Rbs.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        label155:
        k(false);
        if ((raw.a(this.jdField_a_of_type_Raw).a()) && (raw.l(this.jdField_a_of_type_Raw)))
        {
          raw.h(this.jdField_a_of_type_Raw, false);
          d(true);
        }
        if ((this.jdField_a_of_type_Rbs.jdField_c_of_type_Int != 0) || (paramVideoInfo.jdField_a_of_type_Int != 0)) {
          break label434;
        }
        if (this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) {
          this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = new VideoFeedsAioGuideView(raw.a(this.jdField_a_of_type_Raw), raw.a(this.jdField_a_of_type_Raw), raw.a(this.jdField_a_of_type_Raw));
        }
        this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a(this.jdField_a_of_type_Rbs);
        label273:
        if (!paramVideoInfo.b(raw.a(this.jdField_a_of_type_Raw))) {
          break label465;
        }
        this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      }
    }
    for (;;)
    {
      a(paramVideoInfo, this.jdField_a_of_type_Rbs.jdField_b_of_type_AndroidWidgetTextView);
      e(paramVideoInfo);
      d(paramVideoInfo);
      return;
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setHorizontalMargin(0);
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(0);
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setArticleInfo(raw.a(this.jdField_a_of_type_Raw), this.jdField_a_of_type_Raw, paramVideoInfo, raw.c(this.jdField_a_of_type_Raw), raw.e(this.jdField_a_of_type_Raw));
      break;
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(8);
      break;
      label397:
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(8);
      if (this.jdField_a_of_type_Rbs.jdField_a_of_type_AndroidViewView == null) {
        break label155;
      }
      this.jdField_a_of_type_Rbs.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label155;
      label434:
      if (this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) {
        break label273;
      }
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.c();
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = null;
      break label273;
      label465:
      if (paramVideoInfo.a() != null)
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        localObject = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setDecodeHandler(bcuq.w);
        ((URLDrawable)localObject).setAlpha(35);
        this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    super.b(paramVideoInfo);
    h(paramVideoInfo);
    f(paramVideoInfo);
    this.jdField_a_of_type_Rbs.B.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_Rbs.A.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
    raw.a(this.jdField_a_of_type_Raw, this.jdField_a_of_type_Rbs, paramVideoInfo);
    b(paramVideoInfo, true);
    if ((paramVideoInfo.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.getVisibility() == 8))
    {
      if ((this.jdField_a_of_type_Rbs.i == null) || (this.jdField_a_of_type_Rbs.i.getVisibility() == 8)) {
        break label194;
      }
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.post(new VideoFeedsAdapter.ShortVideoItemDelegate.2(this, paramVideoInfo));
    }
    for (;;)
    {
      raw.a(this.jdField_a_of_type_Raw, paramVideoInfo);
      a(paramVideoInfo, this.jdField_a_of_type_Rbs.jdField_b_of_type_AndroidWidgetTextView);
      raw.a(this.jdField_a_of_type_Raw, this.jdField_a_of_type_Rbs.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoInfo);
      raw.a(this.jdField_a_of_type_Raw, this.jdField_a_of_type_Rbs.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoInfo, Boolean.valueOf(raw.a(this.jdField_a_of_type_Raw)));
      e(paramVideoInfo);
      return;
      label194:
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setHorizontalMargin(0);
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(0);
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setArticleInfo(raw.a(this.jdField_a_of_type_Raw), this.jdField_a_of_type_Raw, paramVideoInfo, raw.c(this.jdField_a_of_type_Raw), raw.e(this.jdField_a_of_type_Raw));
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Rbs.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {}
    for (boolean bool = true;; bool = false)
    {
      h(bool);
      return;
    }
  }
  
  void c(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_Rbs.jdField_a_of_type_Boolean)
    {
      rdm.b(this.jdField_a_of_type_Rbs.D, paramVideoInfo.e, "评论");
      this.jdField_a_of_type_Rbs.j.setImageResource(2130842727);
      return;
    }
    super.c(paramVideoInfo);
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.l) && (!TextUtils.isEmpty(paramVideoInfo.v)))
    {
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setVisibility(0);
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setText(paramVideoInfo.v);
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setTag(this.jdField_a_of_type_Rbs);
      this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setOnClickListener(this.jdField_a_of_type_Raw);
      return;
    }
    this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setVisibility(8);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rbs.jdField_b_of_type_ComTencentImageURLImageView.clearAnimation();
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_Rbs.jdField_a_of_type_Rfs.a.b(raw.a(this.jdField_a_of_type_Raw)))
      {
        this.jdField_a_of_type_Rbs.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, rdm.b(raw.a(this.jdField_a_of_type_Raw)));
        k(true);
      }
      if (this.jdField_a_of_type_Rbs.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        this.jdField_a_of_type_Rbs.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      this.jdField_a_of_type_Rbs.jdField_h_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
    }
    if (!this.jdField_a_of_type_Rbs.jdField_a_of_type_Rfs.a.b(raw.a(this.jdField_a_of_type_Raw)))
    {
      this.jdField_a_of_type_Rbs.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      k(false);
      this.jdField_a_of_type_Rbs.jdField_h_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Rbs.jdField_h_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Rbs.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_Rbs.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(raw.b(this.jdField_a_of_type_Raw));
      k(true);
      if (this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) {
        this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.b();
      }
    }
    label216:
    for (;;)
    {
      if (this.jdField_a_of_type_Rbs.jdField_a_of_type_Rfs != null) {
        raw.a(this.jdField_a_of_type_Raw, this.jdField_a_of_type_Rbs.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_Rbs.jdField_a_of_type_Rfs.a, Boolean.valueOf(paramBoolean));
      }
      return;
      this.jdField_a_of_type_Rbs.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      if (!raw.a(this.jdField_a_of_type_Raw).a()) {
        k(false);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) || (this.jdField_a_of_type_Rbs.jdField_c_of_type_Int != 0) || (this.jdField_a_of_type_Rbs.jdField_a_of_type_Rfs == null) || (this.jdField_a_of_type_Rbs.jdField_a_of_type_Rfs.a.jdField_a_of_type_Int != 0)) {
          break label216;
        }
        this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a();
        break;
        this.jdField_a_of_type_Rbs.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, rdm.b(raw.a(this.jdField_a_of_type_Raw)));
      }
    }
  }
  
  protected void h(boolean paramBoolean)
  {
    super.h(paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Rbs.p.getVisibility() == 0)
      {
        rdm.a(this.jdField_a_of_type_Rbs.p, 8, 200);
        this.jdField_a_of_type_Rbs.p.animate().translationY(20.0F).setDuration(200L).start();
        this.jdField_a_of_type_Rbs.jdField_g_of_type_AndroidViewViewGroup.animate().translationY(-20.0F).setDuration(200L).start();
      }
      if ((this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) && (!raw.a(this.jdField_a_of_type_Raw))) {
        this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a();
      }
    }
    do
    {
      return;
      if ((!raw.a(this.jdField_a_of_type_Raw)) && (this.jdField_a_of_type_Rbs.p.getVisibility() == 8))
      {
        rdm.a(this.jdField_a_of_type_Rbs.p, 0, 200);
        this.jdField_a_of_type_Rbs.p.animate().translationY(0.0F).setDuration(200L).start();
        this.jdField_a_of_type_Rbs.jdField_g_of_type_AndroidViewViewGroup.animate().translationY(0.0F).setDuration(200L).start();
      }
    } while (this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null);
    this.jdField_a_of_type_Rbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rbr
 * JD-Core Version:    0.7.0.1
 */
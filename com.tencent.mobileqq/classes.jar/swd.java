import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdGestureView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public class swd
  extends swn
{
  private swi jdField_a_of_type_Swi;
  private boolean jdField_a_of_type_Boolean;
  
  public swd(swi paramswi, slr paramslr, shl paramshl)
  {
    super(paramswi, paramslr, paramshl);
    this.jdField_a_of_type_Swi = paramswi;
    this.jdField_a_of_type_Boolean = bmhv.d();
    if ((paramswi.jdField_k_of_type_AndroidViewViewGroup != null) && (six.a(paramshl.jdField_a_of_type_AndroidAppActivity)))
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label60;
      }
      paramswi.jdField_d_of_type_Int = AIOUtils.dp2px(50.0F, paramswi.jdField_k_of_type_AndroidViewViewGroup.getResources());
    }
    label60:
    while (Aladdin.getConfig(324).getIntegerFromString("videodetail_videogravity_style", 0) != 1) {
      return;
    }
    paramswi.jdField_d_of_type_Int = AIOUtils.dp2px(41.5F, paramswi.jdField_k_of_type_AndroidViewViewGroup.getResources());
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.a != null) && (!paramVideoInfo.a.d) && (ukr.g(paramVideoInfo.a)) && (uks.a(paramVideoInfo.a));
  }
  
  private void m(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Swi.g.getLayoutParams();
      localMarginLayoutParams.bottomMargin = AIOUtils.dp2px(0.0F, this.jdField_a_of_type_Slr.a().getResources());
      this.jdField_a_of_type_Swi.g.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Swi.g.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (AIOUtils.dp2px(15.0F, this.jdField_a_of_type_Slr.a().getResources()) - 20);
    this.jdField_a_of_type_Swi.g.setLayoutParams(localMarginLayoutParams);
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843195;
    }
    return 2130843198;
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
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    this.jdField_a_of_type_Shl.jdField_b_of_type_Boolean = false;
    Object localObject;
    if (this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Swi);
      localObject = new GestureDetector(new swe(this));
      this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidViewView.setOnTouchListener(new swf(this, (GestureDetector)localObject));
    }
    this.jdField_a_of_type_Swi.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_Shl.a(false, this.jdField_a_of_type_Swi);
    uke.a(false, this.jdField_a_of_type_Swi, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Shl);
    if (paramVideoInfo.b(this.jdField_a_of_type_Slr.a())) {
      this.jdField_a_of_type_Swi.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    while (this.jdField_a_of_type_Boolean)
    {
      ukc.a(this.jdField_a_of_type_Swi.i);
      ukc.a(this.jdField_a_of_type_Swi.jdField_k_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Swi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(this.jdField_a_of_type_Slr.a().getLongAccountUin());
      ukc.b(this.jdField_a_of_type_Swi.jdField_a_of_type_Sfb.a());
      return;
      if (paramVideoInfo.a() != null)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject);
        paramVideoInfo.setDecodeHandler(bgxc.x);
        paramVideoInfo.setAlpha(80);
        this.jdField_a_of_type_Swi.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramVideoInfo);
      }
    }
    ukc.b(this.jdField_a_of_type_Swi.jdField_k_of_type_AndroidViewViewGroup);
    ukc.b(this.jdField_a_of_type_Swi.p);
  }
  
  public void a(swi paramswi, VideoInfo paramVideoInfo)
  {
    if (paramswi == null) {}
    for (;;)
    {
      return;
      if (a(paramVideoInfo))
      {
        paramswi = paramswi.jdField_k_of_type_AndroidViewViewGroup;
        if ((this.jdField_a_of_type_Shl.jdField_a_of_type_Int != 0) || (paramswi == null) || (paramswi.getLayoutParams() == null)) {}
      }
      for (this.jdField_a_of_type_Shl.jdField_a_of_type_Int = paramswi.getLayoutParams().height; (this.jdField_a_of_type_Shl.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_Slr.a() != null) && ((this.jdField_a_of_type_Slr.a() instanceof VideoFeedsPlayActivity)) && (((VideoFeedsPlayActivity)this.jdField_a_of_type_Slr.a()).a() != null); this.jdField_a_of_type_Shl.jdField_a_of_type_Int = paramswi.getLayoutParams().height)
      {
        label53:
        this.jdField_a_of_type_Shl.jdField_b_of_type_Int = ((VideoFeedsPlayActivity)this.jdField_a_of_type_Slr.a()).a().getMeasuredHeight();
        return;
        paramswi = paramswi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
        if ((this.jdField_a_of_type_Shl.jdField_a_of_type_Int != 0) || (paramswi == null) || (paramswi.getLayoutParams() == null)) {
          break label53;
        }
      }
    }
  }
  
  public void a_(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Shl.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Shl.e = false;
    ukc.a(this.jdField_a_of_type_Swi.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    a(this.jdField_a_of_type_Swi, paramVideoInfo);
    ukf.a.a(this.jdField_a_of_type_Slr.a(), this.jdField_a_of_type_Slr.a(), this.jdField_a_of_type_Shl.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramVideoInfo, this.jdField_a_of_type_Swi, this.jdField_a_of_type_Shl, this.jdField_a_of_type_Boolean);
    if ((this.jdField_a_of_type_Swi.jdField_a_of_type_Int != 4) && (paramVideoInfo.c))
    {
      ukf.a.a(this.jdField_a_of_type_Slr.a(), paramVideoInfo, this.jdField_a_of_type_Swi, new swg(this, paramVideoInfo));
      this.jdField_a_of_type_Shl.a(false, this.jdField_a_of_type_Swi);
      uke.a(false, this.jdField_a_of_type_Swi, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Shl);
      ukf.a.a(this.jdField_a_of_type_Slr.a(), paramVideoInfo, this.jdField_a_of_type_Swi, this.jdField_a_of_type_Shl, this.jdField_a_of_type_Boolean, new swh(this));
    }
    if ((this.jdField_a_of_type_Slr.a() == this.jdField_a_of_type_Swi) && (this.jdField_a_of_type_Swi.jdField_a_of_type_Int == 4) && (this.jdField_a_of_type_Slr.b()))
    {
      ukc.b(this.jdField_a_of_type_Swi.i);
      ukc.b(this.jdField_a_of_type_Swi.jdField_k_of_type_AndroidViewViewGroup);
    }
    ukc.b(this.jdField_a_of_type_Swi.jdField_h_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_Boolean) {
      a(this.jdField_a_of_type_Swi, paramVideoInfo);
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    super.b(paramVideoInfo);
  }
  
  public void c()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((this.jdField_a_of_type_Shl.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Shl.e))
    {
      if (this.jdField_a_of_type_Swi.jdField_l_of_type_AndroidViewView.getVisibility() == 0) {}
      for (;;)
      {
        this.jdField_a_of_type_Shl.d = bool1;
        i(bool1);
        return;
        bool1 = false;
      }
    }
    if (this.jdField_a_of_type_Swi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {}
    for (bool1 = bool2;; bool1 = false)
    {
      i(bool1);
      return;
    }
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    six.b(this.jdField_a_of_type_Swi.w, paramVideoInfo.e, "评论");
    this.jdField_a_of_type_Swi.jdField_k_of_type_AndroidWidgetImageView.setImageResource(2130843194);
    if ((this.jdField_a_of_type_Boolean) && (ukc.b()))
    {
      ukc.a(this.jdField_a_of_type_Swi.jdField_k_of_type_AndroidWidgetImageView);
      ukc.a(this.jdField_a_of_type_Swi.jdField_l_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_Swi.w.setTextColor(Color.parseColor("#C6C6C6"));
      this.jdField_a_of_type_Swi.y.setTextColor(Color.parseColor("#C6C6C6"));
    }
  }
  
  public void d(boolean paramBoolean)
  {
    i(false);
    if (((this.jdField_a_of_type_Swi.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Swi.jdField_a_of_type_Int == 7)) && (!paramBoolean))
    {
      this.jdField_a_of_type_Shl.a(false, this.jdField_a_of_type_Swi);
      uke.a(false, this.jdField_a_of_type_Swi, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Shl);
      if (this.jdField_a_of_type_Swi.jdField_b_of_type_AndroidWidgetSeekBar != null) {
        this.jdField_a_of_type_Swi.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
      if (this.jdField_a_of_type_Swi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView != null)
      {
        this.jdField_a_of_type_Swi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.setVisibility(4);
        this.jdField_a_of_type_Swi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.a(false);
        this.jdField_a_of_type_Swi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.b();
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Swi == null) || (this.jdField_a_of_type_Swi.jdField_a_of_type_Skq == null) || (this.jdField_a_of_type_Swi.jdField_a_of_type_Skq.a == null) || (TextUtils.isEmpty(ule.a(this.jdField_a_of_type_Swi.jdField_a_of_type_Skq.a.a)))) {
      return;
    }
    ukc.a(this.jdField_a_of_type_Slr.a(), this.jdField_a_of_type_Swi);
  }
  
  public void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Shl.c = true;
      this.jdField_a_of_type_Shl.jdField_b_of_type_Boolean = true;
      if (!paramBoolean) {
        break label152;
      }
      if (!this.jdField_a_of_type_Swi.jdField_a_of_type_Skq.a.b(this.jdField_a_of_type_Slr.a()))
      {
        this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, six.c(this.jdField_a_of_type_Slr.a()));
        m(true);
      }
      if (this.jdField_a_of_type_Swi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        this.jdField_a_of_type_Swi.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidViewView.setVisibility(8);
        ukc.b(this.jdField_a_of_type_Swi.jdField_b_of_type_AndroidWidgetSeekBar);
      }
    }
    label152:
    label251:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Shl.c = false;
        this.jdField_a_of_type_Shl.jdField_b_of_type_Boolean = false;
        break;
        if (this.jdField_a_of_type_Swi.jdField_a_of_type_Skq.a.b(this.jdField_a_of_type_Slr.a())) {
          break label251;
        }
        this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
        m(false);
      } while ((this.jdField_a_of_type_Swi.jdField_d_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Swi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) || (this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidViewView == null));
      this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ukc.a(this.jdField_a_of_type_Swi.jdField_b_of_type_AndroidWidgetSeekBar);
      return;
    } while ((this.jdField_a_of_type_Swi.jdField_d_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Swi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) || (this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidViewView == null));
    this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidViewView.setVisibility(0);
    ukc.a(this.jdField_a_of_type_Swi.jdField_b_of_type_AndroidWidgetSeekBar);
  }
  
  public void f(boolean paramBoolean) {}
  
  protected void i(boolean paramBoolean)
  {
    boolean bool;
    if (this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidViewView != null) {
      if (!paramBoolean) {
        if (!this.jdField_a_of_type_Shl.jdField_b_of_type_Boolean)
        {
          ukc.a(this.jdField_a_of_type_Swi.jdField_b_of_type_AndroidWidgetSeekBar);
          if (this.jdField_a_of_type_Boolean) {
            ukc.a(this.jdField_a_of_type_Swi.p);
          }
          if ((!this.jdField_a_of_type_Shl.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Shl.e)) {
            break label272;
          }
          if ((this.jdField_a_of_type_Swi.jdField_l_of_type_AndroidViewView.getVisibility() == 8) && (!this.jdField_a_of_type_Shl.c))
          {
            if (this.jdField_a_of_type_Swi.jdField_h_of_type_AndroidViewView != null)
            {
              this.jdField_a_of_type_Shl.a(this.jdField_a_of_type_Swi);
              this.jdField_a_of_type_Swi.jdField_h_of_type_AndroidViewView.setVisibility(0);
            }
            six.a(this.jdField_a_of_type_Swi.jdField_l_of_type_AndroidViewView, 0);
          }
          bool = paramBoolean;
          if (this.jdField_a_of_type_Shl.c)
          {
            if (this.jdField_a_of_type_Swi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) {
              break label240;
            }
            bool = true;
            this.jdField_a_of_type_Swi.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          }
          label179:
          super.i(bool);
          if (!this.jdField_a_of_type_Boolean)
          {
            if ((!bool) && (!this.jdField_a_of_type_Swi.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Shl.jdField_b_of_type_Boolean)) {
              break label492;
            }
            this.jdField_a_of_type_Swi.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
          }
        }
      }
    }
    label240:
    do
    {
      return;
      ukc.b(this.jdField_a_of_type_Swi.jdField_b_of_type_AndroidWidgetSeekBar);
      break;
      bool = paramBoolean;
      if (this.jdField_a_of_type_Swi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 0) {
        break label179;
      }
      this.jdField_a_of_type_Swi.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      bool = paramBoolean;
      break label179;
      if ((this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidViewView.getVisibility() == 8) && (!this.jdField_a_of_type_Shl.c)) {
        six.a(this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidViewView, 0);
      }
      bool = paramBoolean;
      if (this.jdField_a_of_type_Swi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 0) {
        break label179;
      }
      this.jdField_a_of_type_Swi.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      bool = paramBoolean;
      break label179;
      ukc.b(this.jdField_a_of_type_Swi.jdField_b_of_type_AndroidWidgetSeekBar);
      ukc.b(this.jdField_a_of_type_Swi.p);
      if ((this.jdField_a_of_type_Shl.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Shl.e))
      {
        bool = paramBoolean;
        if (this.jdField_a_of_type_Swi.jdField_l_of_type_AndroidViewView.getVisibility() != 0) {
          break label179;
        }
        if (this.jdField_a_of_type_Swi.jdField_h_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_Swi.jdField_h_of_type_AndroidViewView.setVisibility(8);
        }
        six.a(this.jdField_a_of_type_Swi.jdField_l_of_type_AndroidViewView, 8);
        bool = paramBoolean;
        break label179;
      }
      if (this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
        six.a(this.jdField_a_of_type_Swi.jdField_a_of_type_AndroidViewView, 8);
      }
      bool = paramBoolean;
      if (this.jdField_a_of_type_Swi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) {
        break label179;
      }
      this.jdField_a_of_type_Swi.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
      bool = paramBoolean;
      break label179;
      this.jdField_a_of_type_Swi.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      return;
      super.i(paramBoolean);
    } while (this.jdField_a_of_type_Boolean);
    label272:
    label492:
    if ((paramBoolean) || (this.jdField_a_of_type_Swi.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Shl.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_Swi.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_Swi.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swd
 * JD-Core Version:    0.7.0.1
 */
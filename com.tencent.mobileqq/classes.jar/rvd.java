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
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdGestureView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public class rvd
  extends rvo
{
  private rvi jdField_a_of_type_Rvi;
  
  public rvd(ruw paramruw, rvi paramrvi)
  {
    super(paramruw, paramrvi);
    this.jdField_a_of_type_Rvi = paramrvi;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.a != null) && (!paramVideoInfo.a.d) && (twq.g(paramVideoInfo.a)) && (twr.b(paramVideoInfo.a));
  }
  
  private void m(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Rvi.g.getLayoutParams();
      localMarginLayoutParams.bottomMargin = AIOUtils.dp2px(0.0F, ruw.a(this.jdField_a_of_type_Ruw).getResources());
      this.jdField_a_of_type_Rvi.g.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Rvi.g.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (AIOUtils.dp2px(15.0F, ruw.a(this.jdField_a_of_type_Ruw).getResources()) - 20);
    this.jdField_a_of_type_Rvi.g.setLayoutParams(localMarginLayoutParams);
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843159;
    }
    return 2130843162;
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
    ruw.g(this.jdField_a_of_type_Ruw, false);
    ruw.b(this.jdField_a_of_type_Ruw, false);
    twb.a(this.jdField_a_of_type_Rvi.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    a(this.jdField_a_of_type_Rvi, paramVideoInfo);
    twe.a.a(ruw.a(this.jdField_a_of_type_Ruw), ruw.a(this.jdField_a_of_type_Ruw), ruw.a(this.jdField_a_of_type_Ruw), paramVideoInfo, this.jdField_a_of_type_Rvi, this.jdField_a_of_type_Ruw, ruw.b(this.jdField_a_of_type_Ruw));
    if ((this.jdField_a_of_type_Rvi.jdField_a_of_type_Int != 4) && (paramVideoInfo.c))
    {
      twe.a.a(ruw.a(this.jdField_a_of_type_Ruw), paramVideoInfo, this.jdField_a_of_type_Rvi, new rvg(this, paramVideoInfo));
      ruw.a(this.jdField_a_of_type_Ruw, false, this.jdField_a_of_type_Rvi);
      twd.a(false, this.jdField_a_of_type_Rvi, ruw.b(this.jdField_a_of_type_Ruw), this.jdField_a_of_type_Ruw);
      twe.a.a(ruw.a(this.jdField_a_of_type_Ruw), paramVideoInfo, this.jdField_a_of_type_Rvi, this.jdField_a_of_type_Ruw, ruw.b(this.jdField_a_of_type_Ruw), new rvh(this));
    }
    if ((ruw.a(this.jdField_a_of_type_Ruw) == this.jdField_a_of_type_Rvi) && (this.jdField_a_of_type_Rvi.jdField_a_of_type_Int == 4) && (ruw.a(this.jdField_a_of_type_Ruw)))
    {
      twb.b(this.jdField_a_of_type_Rvi.jdField_m_of_type_AndroidViewViewGroup);
      twb.b(this.jdField_a_of_type_Rvi.o);
    }
    twb.b(this.jdField_a_of_type_Rvi.h);
    if (ruw.b(this.jdField_a_of_type_Ruw)) {
      a(this.jdField_a_of_type_Rvi, paramVideoInfo);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    ruw.g(this.jdField_a_of_type_Ruw, false);
    Object localObject;
    if (this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Rvi);
      localObject = new GestureDetector(new rve(this));
      this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidViewView.setOnTouchListener(new rvf(this, (GestureDetector)localObject));
    }
    this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_Rvi.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    ruw.a(this.jdField_a_of_type_Ruw, false, this.jdField_a_of_type_Rvi);
    twd.a(false, this.jdField_a_of_type_Rvi, ruw.b(this.jdField_a_of_type_Ruw), this.jdField_a_of_type_Ruw);
    if (paramVideoInfo.b(ruw.a(this.jdField_a_of_type_Ruw))) {
      this.jdField_a_of_type_Rvi.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    while (ruw.b(this.jdField_a_of_type_Ruw))
    {
      twb.a(this.jdField_a_of_type_Rvi.jdField_m_of_type_AndroidViewViewGroup);
      twb.a(this.jdField_a_of_type_Rvi.o);
      this.jdField_a_of_type_Rvi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(ruw.a(this.jdField_a_of_type_Ruw).getLongAccountUin());
      twb.b(this.jdField_a_of_type_Rvi.jdField_a_of_type_Rsm.a());
      return;
      if (paramVideoInfo.a() != null)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject);
        paramVideoInfo.setDecodeHandler(bfol.x);
        paramVideoInfo.setAlpha(80);
        this.jdField_a_of_type_Rvi.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramVideoInfo);
      }
    }
    twb.b(this.jdField_a_of_type_Rvi.o);
    twb.b(this.jdField_a_of_type_Rvi.s);
  }
  
  public void a(rvi paramrvi, VideoInfo paramVideoInfo)
  {
    if (paramrvi == null) {}
    for (;;)
    {
      return;
      if (a(paramVideoInfo))
      {
        paramrvi = paramrvi.o;
        if ((ruw.e(this.jdField_a_of_type_Ruw) == 0) && (paramrvi != null) && (paramrvi.getLayoutParams() != null)) {
          ruw.b(this.jdField_a_of_type_Ruw, paramrvi.getLayoutParams().height);
        }
      }
      while ((ruw.d(this.jdField_a_of_type_Ruw) == 0) && (ruw.a(this.jdField_a_of_type_Ruw) != null) && ((ruw.a(this.jdField_a_of_type_Ruw) instanceof VideoFeedsPlayActivity)) && (((VideoFeedsPlayActivity)ruw.a(this.jdField_a_of_type_Ruw)).a() != null))
      {
        ruw.c(this.jdField_a_of_type_Ruw, ((VideoFeedsPlayActivity)ruw.a(this.jdField_a_of_type_Ruw)).a().getMeasuredHeight());
        return;
        paramrvi = paramrvi.c;
        if ((ruw.e(this.jdField_a_of_type_Ruw) == 0) && (paramrvi != null) && (paramrvi.getLayoutParams() != null)) {
          ruw.b(this.jdField_a_of_type_Ruw, paramrvi.getLayoutParams().height);
        }
      }
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
    if ((ruw.i(this.jdField_a_of_type_Ruw)) && (!ruw.h(this.jdField_a_of_type_Ruw)))
    {
      if (this.jdField_a_of_type_Rvi.jdField_m_of_type_AndroidViewView.getVisibility() == 0) {}
      for (;;)
      {
        ruw.i(this.jdField_a_of_type_Ruw, bool1);
        i(bool1);
        return;
        bool1 = false;
      }
    }
    if (this.jdField_a_of_type_Rvi.d.getVisibility() == 8) {}
    for (bool1 = bool2;; bool1 = false)
    {
      i(bool1);
      return;
    }
  }
  
  void c(VideoInfo paramVideoInfo)
  {
    rwv.b(this.jdField_a_of_type_Rvi.A, paramVideoInfo.e, "评论");
    this.jdField_a_of_type_Rvi.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130843158);
    if ((ruw.b(this.jdField_a_of_type_Ruw)) && (twb.b()))
    {
      twb.a(this.jdField_a_of_type_Rvi.jdField_m_of_type_AndroidWidgetImageView);
      twb.a(this.jdField_a_of_type_Rvi.n);
      this.jdField_a_of_type_Rvi.A.setTextColor(Color.parseColor("#C6C6C6"));
      this.jdField_a_of_type_Rvi.C.setTextColor(Color.parseColor("#C6C6C6"));
    }
  }
  
  public void d(boolean paramBoolean)
  {
    i(false);
    if (((this.jdField_a_of_type_Rvi.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Rvi.jdField_a_of_type_Int == 7)) && (!paramBoolean))
    {
      ruw.a(this.jdField_a_of_type_Ruw, false, this.jdField_a_of_type_Rvi);
      twd.a(false, this.jdField_a_of_type_Rvi, ruw.b(this.jdField_a_of_type_Ruw), this.jdField_a_of_type_Ruw);
      if (this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetSeekBar != null) {
        this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
      if (this.jdField_a_of_type_Rvi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView != null)
      {
        this.jdField_a_of_type_Rvi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.setVisibility(4);
        this.jdField_a_of_type_Rvi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.a(false);
        this.jdField_a_of_type_Rvi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.b();
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Rvi == null) || (this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo == null) || (this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.a == null) || (TextUtils.isEmpty(txh.a(this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.a.a)))) {
      return;
    }
    twb.a(ruw.a(this.jdField_a_of_type_Ruw), this.jdField_a_of_type_Rvi);
  }
  
  public void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ruw.k(this.jdField_a_of_type_Ruw, true);
      ruw.g(this.jdField_a_of_type_Ruw, true);
      if (!paramBoolean) {
        break label156;
      }
      if (!this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.a.b(ruw.a(this.jdField_a_of_type_Ruw)))
      {
        this.jdField_a_of_type_Rvi.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, rwv.c(ruw.a(this.jdField_a_of_type_Ruw)));
        m(true);
      }
      if (this.jdField_a_of_type_Rvi.d.getVisibility() == 0) {
        this.jdField_a_of_type_Rvi.d.setVisibility(8);
      }
      if (this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidViewView.setVisibility(8);
        twb.b(this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetSeekBar);
      }
    }
    label156:
    label255:
    do
    {
      do
      {
        return;
        ruw.k(this.jdField_a_of_type_Ruw, false);
        ruw.g(this.jdField_a_of_type_Ruw, false);
        break;
        if (this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.a.b(ruw.a(this.jdField_a_of_type_Ruw))) {
          break label255;
        }
        this.jdField_a_of_type_Rvi.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
        m(false);
      } while ((this.jdField_a_of_type_Rvi.d == null) || (this.jdField_a_of_type_Rvi.d.getVisibility() != 8) || (this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidViewView == null));
      this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidViewView.setVisibility(0);
      twb.a(this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetSeekBar);
      return;
    } while ((this.jdField_a_of_type_Rvi.d == null) || (this.jdField_a_of_type_Rvi.d.getVisibility() != 8) || (this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidViewView == null));
    this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidViewView.setVisibility(0);
    twb.a(this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetSeekBar);
  }
  
  public void f(boolean paramBoolean) {}
  
  protected void i(boolean paramBoolean)
  {
    boolean bool;
    if (this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidViewView != null) {
      if (!paramBoolean) {
        if (!ruw.i(this.jdField_a_of_type_Ruw))
        {
          twb.a(this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetSeekBar);
          if (ruw.b(this.jdField_a_of_type_Ruw)) {
            twb.a(this.jdField_a_of_type_Rvi.s);
          }
          if ((!ruw.i(this.jdField_a_of_type_Ruw)) || (ruw.h(this.jdField_a_of_type_Ruw))) {
            break label278;
          }
          if ((this.jdField_a_of_type_Rvi.jdField_m_of_type_AndroidViewView.getVisibility() == 8) && (!ruw.c(this.jdField_a_of_type_Ruw)))
          {
            if (this.jdField_a_of_type_Rvi.i != null)
            {
              ruw.a(this.jdField_a_of_type_Ruw, this.jdField_a_of_type_Rvi);
              this.jdField_a_of_type_Rvi.i.setVisibility(0);
            }
            rwv.a(this.jdField_a_of_type_Rvi.jdField_m_of_type_AndroidViewView, 0);
          }
          bool = paramBoolean;
          if (ruw.c(this.jdField_a_of_type_Ruw))
          {
            if (this.jdField_a_of_type_Rvi.d.getVisibility() != 8) {
              break label246;
            }
            bool = true;
            this.jdField_a_of_type_Rvi.d.setVisibility(0);
          }
          label182:
          super.i(bool);
          if (!ruw.b(this.jdField_a_of_type_Ruw))
          {
            if ((!bool) && (!this.jdField_a_of_type_Rvi.jdField_a_of_type_Boolean) && (!ruw.i(this.jdField_a_of_type_Ruw))) {
              break label498;
            }
            this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
          }
        }
      }
    }
    label246:
    do
    {
      return;
      twb.b(this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetSeekBar);
      break;
      bool = paramBoolean;
      if (this.jdField_a_of_type_Rvi.d.getVisibility() != 0) {
        break label182;
      }
      this.jdField_a_of_type_Rvi.d.setVisibility(8);
      bool = paramBoolean;
      break label182;
      if ((this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidViewView.getVisibility() == 8) && (!ruw.c(this.jdField_a_of_type_Ruw))) {
        rwv.a(this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidViewView, 0);
      }
      bool = paramBoolean;
      if (this.jdField_a_of_type_Rvi.d.getVisibility() != 0) {
        break label182;
      }
      this.jdField_a_of_type_Rvi.d.setVisibility(8);
      bool = paramBoolean;
      break label182;
      twb.b(this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetSeekBar);
      twb.b(this.jdField_a_of_type_Rvi.s);
      if ((ruw.i(this.jdField_a_of_type_Ruw)) && (!ruw.h(this.jdField_a_of_type_Ruw)))
      {
        bool = paramBoolean;
        if (this.jdField_a_of_type_Rvi.jdField_m_of_type_AndroidViewView.getVisibility() != 0) {
          break label182;
        }
        if (this.jdField_a_of_type_Rvi.i != null) {
          this.jdField_a_of_type_Rvi.i.setVisibility(8);
        }
        rwv.a(this.jdField_a_of_type_Rvi.jdField_m_of_type_AndroidViewView, 8);
        bool = paramBoolean;
        break label182;
      }
      if (this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
        rwv.a(this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidViewView, 8);
      }
      bool = paramBoolean;
      if (this.jdField_a_of_type_Rvi.d.getVisibility() != 8) {
        break label182;
      }
      this.jdField_a_of_type_Rvi.d.setVisibility(0);
      bool = paramBoolean;
      break label182;
      this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      return;
      super.i(paramBoolean);
    } while (ruw.b(this.jdField_a_of_type_Ruw));
    label278:
    label498:
    if ((paramBoolean) || (this.jdField_a_of_type_Rvi.jdField_a_of_type_Boolean) || (ruw.i(this.jdField_a_of_type_Ruw)))
    {
      this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_Rvi.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvd
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdGestureView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;

public class rxg
  extends rxr
{
  private rxl jdField_a_of_type_Rxl;
  
  public rxg(rwy paramrwy, rxl paramrxl)
  {
    super(paramrwy, paramrxl);
    this.jdField_a_of_type_Rxl = paramrxl;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.a != null) && (!paramVideoInfo.a.d) && (oqi.g(paramVideoInfo.a)) && (oqj.b(paramVideoInfo.a));
  }
  
  private void m(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Rxl.g.getLayoutParams();
      localMarginLayoutParams.bottomMargin = afur.a(0.0F, rwy.a(this.jdField_a_of_type_Rwy).getResources());
      this.jdField_a_of_type_Rxl.g.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Rxl.g.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (afur.a(15.0F, rwy.a(this.jdField_a_of_type_Rwy).getResources()) - 20);
    this.jdField_a_of_type_Rxl.g.setLayoutParams(localMarginLayoutParams);
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843083;
    }
    return 2130843085;
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
    rwy.g(this.jdField_a_of_type_Rwy, false);
    rwy.b(this.jdField_a_of_type_Rwy, false);
    opr.a(this.jdField_a_of_type_Rxl.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    a(this.jdField_a_of_type_Rxl, paramVideoInfo);
    opt.a.a(rwy.a(this.jdField_a_of_type_Rwy), rwy.a(this.jdField_a_of_type_Rwy), rwy.a(this.jdField_a_of_type_Rwy), paramVideoInfo, this.jdField_a_of_type_Rxl, this.jdField_a_of_type_Rwy, rwy.c(this.jdField_a_of_type_Rwy));
    if ((this.jdField_a_of_type_Rxl.jdField_a_of_type_Int != 4) && (paramVideoInfo.c))
    {
      opt.a.a(rwy.a(this.jdField_a_of_type_Rwy), paramVideoInfo, this.jdField_a_of_type_Rxl, new rxj(this, paramVideoInfo));
      rwy.a(this.jdField_a_of_type_Rwy, false, this.jdField_a_of_type_Rxl);
      opt.a.a(rwy.a(this.jdField_a_of_type_Rwy), paramVideoInfo, this.jdField_a_of_type_Rxl, this.jdField_a_of_type_Rwy, rwy.c(this.jdField_a_of_type_Rwy), new rxk(this));
    }
    if ((rwy.a(this.jdField_a_of_type_Rwy) == this.jdField_a_of_type_Rxl) && (this.jdField_a_of_type_Rxl.jdField_a_of_type_Int == 4) && (rwy.a(this.jdField_a_of_type_Rwy)))
    {
      opr.b(this.jdField_a_of_type_Rxl.jdField_m_of_type_AndroidViewViewGroup);
      opr.b(this.jdField_a_of_type_Rxl.o);
    }
    opr.b(this.jdField_a_of_type_Rxl.h);
    if (rwy.c(this.jdField_a_of_type_Rwy)) {
      a(this.jdField_a_of_type_Rxl, paramVideoInfo);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    rwy.g(this.jdField_a_of_type_Rwy, false);
    Object localObject;
    if (this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Rxl);
      localObject = new GestureDetector(new rxh(this));
      this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidViewView.setOnTouchListener(new rxi(this, (GestureDetector)localObject));
    }
    this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_Rxl.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    rwy.a(this.jdField_a_of_type_Rwy, false, this.jdField_a_of_type_Rxl);
    if (paramVideoInfo.b(rwy.a(this.jdField_a_of_type_Rwy))) {
      this.jdField_a_of_type_Rxl.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    while (rwy.c(this.jdField_a_of_type_Rwy))
    {
      opr.a(this.jdField_a_of_type_Rxl.jdField_m_of_type_AndroidViewViewGroup);
      opr.a(this.jdField_a_of_type_Rxl.o);
      this.jdField_a_of_type_Rxl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(rwy.a(this.jdField_a_of_type_Rwy).getLongAccountUin());
      opr.b(this.jdField_a_of_type_Rxl.jdField_a_of_type_Ruq.a());
      return;
      if (paramVideoInfo.a() != null)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject);
        paramVideoInfo.setDecodeHandler(bgey.x);
        paramVideoInfo.setAlpha(80);
        this.jdField_a_of_type_Rxl.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramVideoInfo);
      }
    }
    opr.b(this.jdField_a_of_type_Rxl.o);
    opr.b(this.jdField_a_of_type_Rxl.s);
  }
  
  public void a(rxl paramrxl, VideoInfo paramVideoInfo)
  {
    if (paramrxl == null) {}
    for (;;)
    {
      return;
      if (a(paramVideoInfo))
      {
        paramrxl = paramrxl.o;
        if ((rwy.e(this.jdField_a_of_type_Rwy) == 0) && (paramrxl != null) && (paramrxl.getLayoutParams() != null)) {
          rwy.b(this.jdField_a_of_type_Rwy, paramrxl.getLayoutParams().height);
        }
      }
      while ((rwy.d(this.jdField_a_of_type_Rwy) == 0) && (rwy.a(this.jdField_a_of_type_Rwy) != null) && ((rwy.a(this.jdField_a_of_type_Rwy) instanceof VideoFeedsPlayActivity)) && (((VideoFeedsPlayActivity)rwy.a(this.jdField_a_of_type_Rwy)).a() != null))
      {
        rwy.c(this.jdField_a_of_type_Rwy, ((VideoFeedsPlayActivity)rwy.a(this.jdField_a_of_type_Rwy)).a().getMeasuredHeight());
        return;
        paramrxl = paramrxl.c;
        if ((rwy.e(this.jdField_a_of_type_Rwy) == 0) && (paramrxl != null) && (paramrxl.getLayoutParams() != null)) {
          rwy.b(this.jdField_a_of_type_Rwy, paramrxl.getLayoutParams().height);
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
    if ((rwy.i(this.jdField_a_of_type_Rwy)) && (!rwy.h(this.jdField_a_of_type_Rwy)))
    {
      if (this.jdField_a_of_type_Rxl.jdField_m_of_type_AndroidViewView.getVisibility() == 0) {}
      for (;;)
      {
        rwy.i(this.jdField_a_of_type_Rwy, bool1);
        i(bool1);
        return;
        bool1 = false;
      }
    }
    if (this.jdField_a_of_type_Rxl.d.getVisibility() == 8) {}
    for (bool1 = bool2;; bool1 = false)
    {
      i(bool1);
      return;
    }
  }
  
  void c(VideoInfo paramVideoInfo)
  {
    ryx.b(this.jdField_a_of_type_Rxl.A, paramVideoInfo.e, "评论");
    this.jdField_a_of_type_Rxl.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130843082);
    if ((rwy.c(this.jdField_a_of_type_Rwy)) && (opr.b()))
    {
      opr.a(this.jdField_a_of_type_Rxl.jdField_m_of_type_AndroidWidgetImageView);
      opr.a(this.jdField_a_of_type_Rxl.n);
      this.jdField_a_of_type_Rxl.A.setTextColor(Color.parseColor("#C6C6C6"));
      this.jdField_a_of_type_Rxl.C.setTextColor(Color.parseColor("#C6C6C6"));
    }
  }
  
  public void d(boolean paramBoolean)
  {
    i(false);
    if (((this.jdField_a_of_type_Rxl.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Rxl.jdField_a_of_type_Int == 7)) && (!paramBoolean))
    {
      rwy.a(this.jdField_a_of_type_Rwy, false, this.jdField_a_of_type_Rxl);
      if (this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetSeekBar != null) {
        this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
      if (this.jdField_a_of_type_Rxl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null)
      {
        this.jdField_a_of_type_Rxl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(4);
        this.jdField_a_of_type_Rxl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.a(false);
        this.jdField_a_of_type_Rxl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.b();
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Rxl == null) || (this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar == null) || (this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.a == null) || (TextUtils.isEmpty(orb.a(this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.a.a)))) {
      return;
    }
    opr.a(rwy.a(this.jdField_a_of_type_Rwy), this.jdField_a_of_type_Rxl);
  }
  
  public void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      rwy.k(this.jdField_a_of_type_Rwy, true);
      rwy.g(this.jdField_a_of_type_Rwy, true);
      if (!paramBoolean) {
        break label156;
      }
      if (!this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.a.b(rwy.a(this.jdField_a_of_type_Rwy)))
      {
        this.jdField_a_of_type_Rxl.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, ryx.c(rwy.a(this.jdField_a_of_type_Rwy)));
        m(true);
      }
      if (this.jdField_a_of_type_Rxl.d.getVisibility() == 0) {
        this.jdField_a_of_type_Rxl.d.setVisibility(8);
      }
      if (this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidViewView.setVisibility(8);
        opr.b(this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetSeekBar);
      }
    }
    label156:
    label255:
    do
    {
      do
      {
        return;
        rwy.k(this.jdField_a_of_type_Rwy, false);
        rwy.g(this.jdField_a_of_type_Rwy, false);
        break;
        if (this.jdField_a_of_type_Rxl.jdField_a_of_type_Sar.a.b(rwy.a(this.jdField_a_of_type_Rwy))) {
          break label255;
        }
        this.jdField_a_of_type_Rxl.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
        m(false);
      } while ((this.jdField_a_of_type_Rxl.d == null) || (this.jdField_a_of_type_Rxl.d.getVisibility() != 8) || (this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidViewView == null));
      this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidViewView.setVisibility(0);
      opr.a(this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetSeekBar);
      return;
    } while ((this.jdField_a_of_type_Rxl.d == null) || (this.jdField_a_of_type_Rxl.d.getVisibility() != 8) || (this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidViewView == null));
    this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidViewView.setVisibility(0);
    opr.a(this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetSeekBar);
  }
  
  public void f(boolean paramBoolean) {}
  
  protected void i(boolean paramBoolean)
  {
    boolean bool;
    if (this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidViewView != null) {
      if (!paramBoolean) {
        if (!rwy.i(this.jdField_a_of_type_Rwy))
        {
          opr.a(this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetSeekBar);
          if (rwy.c(this.jdField_a_of_type_Rwy)) {
            opr.a(this.jdField_a_of_type_Rxl.s);
          }
          if ((!rwy.i(this.jdField_a_of_type_Rwy)) || (rwy.h(this.jdField_a_of_type_Rwy))) {
            break label278;
          }
          if ((this.jdField_a_of_type_Rxl.jdField_m_of_type_AndroidViewView.getVisibility() == 8) && (!rwy.b(this.jdField_a_of_type_Rwy)))
          {
            if (this.jdField_a_of_type_Rxl.i != null)
            {
              rwy.a(this.jdField_a_of_type_Rwy, this.jdField_a_of_type_Rxl);
              this.jdField_a_of_type_Rxl.i.setVisibility(0);
            }
            ryx.a(this.jdField_a_of_type_Rxl.jdField_m_of_type_AndroidViewView, 0);
          }
          bool = paramBoolean;
          if (rwy.b(this.jdField_a_of_type_Rwy))
          {
            if (this.jdField_a_of_type_Rxl.d.getVisibility() != 8) {
              break label246;
            }
            bool = true;
            this.jdField_a_of_type_Rxl.d.setVisibility(0);
          }
          label182:
          super.i(bool);
          if (!rwy.c(this.jdField_a_of_type_Rwy))
          {
            if ((!bool) && (!this.jdField_a_of_type_Rxl.jdField_a_of_type_Boolean) && (!rwy.i(this.jdField_a_of_type_Rwy))) {
              break label498;
            }
            this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
          }
        }
      }
    }
    label246:
    do
    {
      return;
      opr.b(this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetSeekBar);
      break;
      bool = paramBoolean;
      if (this.jdField_a_of_type_Rxl.d.getVisibility() != 0) {
        break label182;
      }
      this.jdField_a_of_type_Rxl.d.setVisibility(8);
      bool = paramBoolean;
      break label182;
      if ((this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidViewView.getVisibility() == 8) && (!rwy.b(this.jdField_a_of_type_Rwy))) {
        ryx.a(this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidViewView, 0);
      }
      bool = paramBoolean;
      if (this.jdField_a_of_type_Rxl.d.getVisibility() != 0) {
        break label182;
      }
      this.jdField_a_of_type_Rxl.d.setVisibility(8);
      bool = paramBoolean;
      break label182;
      opr.b(this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetSeekBar);
      opr.b(this.jdField_a_of_type_Rxl.s);
      if ((rwy.i(this.jdField_a_of_type_Rwy)) && (!rwy.h(this.jdField_a_of_type_Rwy)))
      {
        bool = paramBoolean;
        if (this.jdField_a_of_type_Rxl.jdField_m_of_type_AndroidViewView.getVisibility() != 0) {
          break label182;
        }
        if (this.jdField_a_of_type_Rxl.i != null) {
          this.jdField_a_of_type_Rxl.i.setVisibility(8);
        }
        ryx.a(this.jdField_a_of_type_Rxl.jdField_m_of_type_AndroidViewView, 8);
        bool = paramBoolean;
        break label182;
      }
      if (this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
        ryx.a(this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidViewView, 8);
      }
      bool = paramBoolean;
      if (this.jdField_a_of_type_Rxl.d.getVisibility() != 8) {
        break label182;
      }
      this.jdField_a_of_type_Rxl.d.setVisibility(0);
      bool = paramBoolean;
      break label182;
      this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      return;
      super.i(paramBoolean);
    } while (rwy.c(this.jdField_a_of_type_Rwy));
    label278:
    label498:
    if ((paramBoolean) || (this.jdField_a_of_type_Rxl.jdField_a_of_type_Boolean) || (rwy.i(this.jdField_a_of_type_Rwy)))
    {
      this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_Rxl.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxg
 * JD-Core Version:    0.7.0.1
 */
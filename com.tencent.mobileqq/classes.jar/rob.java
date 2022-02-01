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
import com.tencent.mobileqq.app.QQAppInterface;

public class rob
  extends rom
{
  private rog jdField_a_of_type_Rog;
  
  public rob(rnu paramrnu, rog paramrog)
  {
    super(paramrnu, paramrog);
    this.jdField_a_of_type_Rog = paramrog;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.a != null) && (!paramVideoInfo.a.d) && (tpz.g(paramVideoInfo.a)) && (tqa.b(paramVideoInfo.a));
  }
  
  private void m(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Rog.g.getLayoutParams();
      localMarginLayoutParams.bottomMargin = agej.a(0.0F, rnu.a(this.jdField_a_of_type_Rnu).getResources());
      this.jdField_a_of_type_Rog.g.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Rog.g.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (agej.a(15.0F, rnu.a(this.jdField_a_of_type_Rnu).getResources()) - 20);
    this.jdField_a_of_type_Rog.g.setLayoutParams(localMarginLayoutParams);
  }
  
  int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843103;
    }
    return 2130843105;
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
    rnu.g(this.jdField_a_of_type_Rnu, false);
    rnu.b(this.jdField_a_of_type_Rnu, false);
    tph.a(this.jdField_a_of_type_Rog.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    a(this.jdField_a_of_type_Rog, paramVideoInfo);
    tpj.a.a(rnu.a(this.jdField_a_of_type_Rnu), rnu.a(this.jdField_a_of_type_Rnu), rnu.a(this.jdField_a_of_type_Rnu), paramVideoInfo, this.jdField_a_of_type_Rog, this.jdField_a_of_type_Rnu, rnu.c(this.jdField_a_of_type_Rnu));
    if ((this.jdField_a_of_type_Rog.jdField_a_of_type_Int != 4) && (paramVideoInfo.c))
    {
      tpj.a.a(rnu.a(this.jdField_a_of_type_Rnu), paramVideoInfo, this.jdField_a_of_type_Rog, new roe(this, paramVideoInfo));
      rnu.a(this.jdField_a_of_type_Rnu, false, this.jdField_a_of_type_Rog);
      tpj.a.a(rnu.a(this.jdField_a_of_type_Rnu), paramVideoInfo, this.jdField_a_of_type_Rog, this.jdField_a_of_type_Rnu, rnu.c(this.jdField_a_of_type_Rnu), new rof(this));
    }
    if ((rnu.a(this.jdField_a_of_type_Rnu) == this.jdField_a_of_type_Rog) && (this.jdField_a_of_type_Rog.jdField_a_of_type_Int == 4) && (rnu.a(this.jdField_a_of_type_Rnu)))
    {
      tph.b(this.jdField_a_of_type_Rog.l);
      tph.b(this.jdField_a_of_type_Rog.jdField_n_of_type_AndroidViewViewGroup);
    }
    tph.b(this.jdField_a_of_type_Rog.h);
    if (rnu.c(this.jdField_a_of_type_Rnu)) {
      a(this.jdField_a_of_type_Rog, paramVideoInfo);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    rnu.g(this.jdField_a_of_type_Rnu, false);
    Object localObject;
    if (this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Rog);
      localObject = new GestureDetector(new roc(this));
      this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidViewView.setOnTouchListener(new rod(this, (GestureDetector)localObject));
    }
    this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_Rog.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    rnu.a(this.jdField_a_of_type_Rnu, false, this.jdField_a_of_type_Rog);
    if (paramVideoInfo.b(rnu.a(this.jdField_a_of_type_Rnu))) {
      this.jdField_a_of_type_Rog.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    while (rnu.c(this.jdField_a_of_type_Rnu))
    {
      tph.a(this.jdField_a_of_type_Rog.l);
      tph.a(this.jdField_a_of_type_Rog.jdField_n_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Rog.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(rnu.a(this.jdField_a_of_type_Rnu).getLongAccountUin());
      tph.b(this.jdField_a_of_type_Rog.jdField_a_of_type_Rlm.a());
      return;
      if (paramVideoInfo.a() != null)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject);
        paramVideoInfo.setDecodeHandler(bhez.x);
        paramVideoInfo.setAlpha(80);
        this.jdField_a_of_type_Rog.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramVideoInfo);
      }
    }
    tph.b(this.jdField_a_of_type_Rog.jdField_n_of_type_AndroidViewViewGroup);
    tph.b(this.jdField_a_of_type_Rog.s);
  }
  
  public void a(rog paramrog, VideoInfo paramVideoInfo)
  {
    if (paramrog == null) {}
    for (;;)
    {
      return;
      if (a(paramVideoInfo))
      {
        paramrog = paramrog.jdField_n_of_type_AndroidViewViewGroup;
        if ((rnu.e(this.jdField_a_of_type_Rnu) == 0) && (paramrog != null) && (paramrog.getLayoutParams() != null)) {
          rnu.b(this.jdField_a_of_type_Rnu, paramrog.getLayoutParams().height);
        }
      }
      while ((rnu.d(this.jdField_a_of_type_Rnu) == 0) && (rnu.a(this.jdField_a_of_type_Rnu) != null) && ((rnu.a(this.jdField_a_of_type_Rnu) instanceof VideoFeedsPlayActivity)) && (((VideoFeedsPlayActivity)rnu.a(this.jdField_a_of_type_Rnu)).a() != null))
      {
        rnu.c(this.jdField_a_of_type_Rnu, ((VideoFeedsPlayActivity)rnu.a(this.jdField_a_of_type_Rnu)).a().getMeasuredHeight());
        return;
        paramrog = paramrog.c;
        if ((rnu.e(this.jdField_a_of_type_Rnu) == 0) && (paramrog != null) && (paramrog.getLayoutParams() != null)) {
          rnu.b(this.jdField_a_of_type_Rnu, paramrog.getLayoutParams().height);
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
    if ((rnu.i(this.jdField_a_of_type_Rnu)) && (!rnu.h(this.jdField_a_of_type_Rnu)))
    {
      if (this.jdField_a_of_type_Rog.jdField_m_of_type_AndroidViewView.getVisibility() == 0) {}
      for (;;)
      {
        rnu.i(this.jdField_a_of_type_Rnu, bool1);
        i(bool1);
        return;
        bool1 = false;
      }
    }
    if (this.jdField_a_of_type_Rog.d.getVisibility() == 8) {}
    for (bool1 = bool2;; bool1 = false)
    {
      i(bool1);
      return;
    }
  }
  
  void c(VideoInfo paramVideoInfo)
  {
    rpt.b(this.jdField_a_of_type_Rog.A, paramVideoInfo.e, "评论");
    this.jdField_a_of_type_Rog.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130843102);
    if ((rnu.c(this.jdField_a_of_type_Rnu)) && (tph.b()))
    {
      tph.a(this.jdField_a_of_type_Rog.jdField_m_of_type_AndroidWidgetImageView);
      tph.a(this.jdField_a_of_type_Rog.jdField_n_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_Rog.A.setTextColor(Color.parseColor("#C6C6C6"));
      this.jdField_a_of_type_Rog.C.setTextColor(Color.parseColor("#C6C6C6"));
    }
  }
  
  public void d(boolean paramBoolean)
  {
    i(false);
    if (((this.jdField_a_of_type_Rog.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Rog.jdField_a_of_type_Int == 7)) && (!paramBoolean))
    {
      rnu.a(this.jdField_a_of_type_Rnu, false, this.jdField_a_of_type_Rog);
      if (this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetSeekBar != null) {
        this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
      if (this.jdField_a_of_type_Rog.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView != null)
      {
        this.jdField_a_of_type_Rog.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.setVisibility(4);
        this.jdField_a_of_type_Rog.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.a(false);
        this.jdField_a_of_type_Rog.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdGestureView.b();
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Rog == null) || (this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm == null) || (this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.a == null) || (TextUtils.isEmpty(tqt.a(this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.a.a)))) {
      return;
    }
    tph.a(rnu.a(this.jdField_a_of_type_Rnu), this.jdField_a_of_type_Rog);
  }
  
  public void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      rnu.k(this.jdField_a_of_type_Rnu, true);
      rnu.g(this.jdField_a_of_type_Rnu, true);
      if (!paramBoolean) {
        break label156;
      }
      if (!this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.a.b(rnu.a(this.jdField_a_of_type_Rnu)))
      {
        this.jdField_a_of_type_Rog.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, rpt.c(rnu.a(this.jdField_a_of_type_Rnu)));
        m(true);
      }
      if (this.jdField_a_of_type_Rog.d.getVisibility() == 0) {
        this.jdField_a_of_type_Rog.d.setVisibility(8);
      }
      if (this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidViewView.setVisibility(8);
        tph.b(this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetSeekBar);
      }
    }
    label156:
    label255:
    do
    {
      do
      {
        return;
        rnu.k(this.jdField_a_of_type_Rnu, false);
        rnu.g(this.jdField_a_of_type_Rnu, false);
        break;
        if (this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.a.b(rnu.a(this.jdField_a_of_type_Rnu))) {
          break label255;
        }
        this.jdField_a_of_type_Rog.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
        m(false);
      } while ((this.jdField_a_of_type_Rog.d == null) || (this.jdField_a_of_type_Rog.d.getVisibility() != 8) || (this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidViewView == null));
      this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidViewView.setVisibility(0);
      tph.a(this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetSeekBar);
      return;
    } while ((this.jdField_a_of_type_Rog.d == null) || (this.jdField_a_of_type_Rog.d.getVisibility() != 8) || (this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidViewView == null));
    this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidViewView.setVisibility(0);
    tph.a(this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetSeekBar);
  }
  
  public void f(boolean paramBoolean) {}
  
  protected void i(boolean paramBoolean)
  {
    boolean bool;
    if (this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidViewView != null) {
      if (!paramBoolean) {
        if (!rnu.i(this.jdField_a_of_type_Rnu))
        {
          tph.a(this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetSeekBar);
          if (rnu.c(this.jdField_a_of_type_Rnu)) {
            tph.a(this.jdField_a_of_type_Rog.s);
          }
          if ((!rnu.i(this.jdField_a_of_type_Rnu)) || (rnu.h(this.jdField_a_of_type_Rnu))) {
            break label278;
          }
          if ((this.jdField_a_of_type_Rog.jdField_m_of_type_AndroidViewView.getVisibility() == 8) && (!rnu.b(this.jdField_a_of_type_Rnu)))
          {
            if (this.jdField_a_of_type_Rog.i != null)
            {
              rnu.a(this.jdField_a_of_type_Rnu, this.jdField_a_of_type_Rog);
              this.jdField_a_of_type_Rog.i.setVisibility(0);
            }
            rpt.a(this.jdField_a_of_type_Rog.jdField_m_of_type_AndroidViewView, 0);
          }
          bool = paramBoolean;
          if (rnu.b(this.jdField_a_of_type_Rnu))
          {
            if (this.jdField_a_of_type_Rog.d.getVisibility() != 8) {
              break label246;
            }
            bool = true;
            this.jdField_a_of_type_Rog.d.setVisibility(0);
          }
          label182:
          super.i(bool);
          if (!rnu.c(this.jdField_a_of_type_Rnu))
          {
            if ((!bool) && (!this.jdField_a_of_type_Rog.jdField_a_of_type_Boolean) && (!rnu.i(this.jdField_a_of_type_Rnu))) {
              break label498;
            }
            this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
          }
        }
      }
    }
    label246:
    do
    {
      return;
      tph.b(this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetSeekBar);
      break;
      bool = paramBoolean;
      if (this.jdField_a_of_type_Rog.d.getVisibility() != 0) {
        break label182;
      }
      this.jdField_a_of_type_Rog.d.setVisibility(8);
      bool = paramBoolean;
      break label182;
      if ((this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidViewView.getVisibility() == 8) && (!rnu.b(this.jdField_a_of_type_Rnu))) {
        rpt.a(this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidViewView, 0);
      }
      bool = paramBoolean;
      if (this.jdField_a_of_type_Rog.d.getVisibility() != 0) {
        break label182;
      }
      this.jdField_a_of_type_Rog.d.setVisibility(8);
      bool = paramBoolean;
      break label182;
      tph.b(this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetSeekBar);
      tph.b(this.jdField_a_of_type_Rog.s);
      if ((rnu.i(this.jdField_a_of_type_Rnu)) && (!rnu.h(this.jdField_a_of_type_Rnu)))
      {
        bool = paramBoolean;
        if (this.jdField_a_of_type_Rog.jdField_m_of_type_AndroidViewView.getVisibility() != 0) {
          break label182;
        }
        if (this.jdField_a_of_type_Rog.i != null) {
          this.jdField_a_of_type_Rog.i.setVisibility(8);
        }
        rpt.a(this.jdField_a_of_type_Rog.jdField_m_of_type_AndroidViewView, 8);
        bool = paramBoolean;
        break label182;
      }
      if (this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
        rpt.a(this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidViewView, 8);
      }
      bool = paramBoolean;
      if (this.jdField_a_of_type_Rog.d.getVisibility() != 8) {
        break label182;
      }
      this.jdField_a_of_type_Rog.d.setVisibility(0);
      bool = paramBoolean;
      break label182;
      this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      return;
      super.i(paramBoolean);
    } while (rnu.c(this.jdField_a_of_type_Rnu));
    label278:
    label498:
    if ((paramBoolean) || (this.jdField_a_of_type_Rog.jdField_a_of_type_Boolean) || (rnu.i(this.jdField_a_of_type_Rnu)))
    {
      this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_Rog.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rob
 * JD-Core Version:    0.7.0.1
 */
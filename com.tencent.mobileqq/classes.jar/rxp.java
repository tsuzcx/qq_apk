import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public abstract class rxp
  implements rur
{
  private rxq a;
  
  public rxp(rwy paramrwy, rxq paramrxq)
  {
    this.a = paramrxq;
  }
  
  private boolean a(ImageView paramImageView, URL paramURL)
  {
    boolean bool = true;
    Object localObject = rwy.a(this.b).getIntent();
    int j = ((Intent)localObject).getIntExtra("item_width", 0);
    int i = ((Intent)localObject).getIntExtra("item_height", 0);
    j = ((Intent)localObject).getIntExtra("item_image_width", j);
    i = ((Intent)localObject).getIntExtra("item_image_height", i);
    if ((j == 0) || (i == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "tryLoadExtraCoverCache: width or height = 0");
      }
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        localObject = new tdw();
        ((tdw)localObject).jdField_a_of_type_JavaNetURL = pha.a(paramURL.toString());
        ((tdw)localObject).jdField_a_of_type_Int = j;
        ((tdw)localObject).jdField_b_of_type_Int = i;
        localObject = tdv.a().a((tdw)localObject);
        if ((localObject == null) || (((tds)localObject).a() == null)) {
          break;
        }
        paramImageView.setImageDrawable(new tee(((tds)localObject).a()));
      } while (!QLog.isDevelopLevel());
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "tryLoadExtraCoverCache: ImageManager hitCache");
      return true;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = j;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
      paramURL = URLDrawable.getDrawable(paramURL, (URLDrawable.URLDrawableOptions)localObject);
      if ((paramURL == null) || (paramURL.getStatus() != 1)) {
        break;
      }
      paramImageView.setImageDrawable(paramURL);
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "tryLoadExtraCoverCache: urlDrawable hitCache");
    return true;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "tryLoadExtraCoverCache: missCache");
    }
    return false;
  }
  
  private boolean a(rxq paramrxq)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (rwy.a(this.b) != null)
    {
      bool1 = bool2;
      if (bgnt.b(rwy.a(this.b)))
      {
        bool1 = bool2;
        if (paramrxq != null)
        {
          bool1 = bool2;
          if (paramrxq.jdField_a_of_type_Sar != null)
          {
            bool1 = bool2;
            if (paramrxq.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
            {
              bool1 = bool2;
              if (paramrxq.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long >= 0L)
              {
                bool1 = bool2;
                if ((paramrxq instanceof rxy))
                {
                  bool1 = bool2;
                  if (!rwy.a(this.b, (rxy)paramrxq)) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = this.a.itemView.getLayoutParams();
    int i = paramVideoInfo.a(rwy.a(this.b));
    int j = ryx.b(rwy.a(this.b))[0];
    if (paramBoolean)
    {
      localLayoutParams.height = -1;
      localLayoutParams.width = -1;
      this.a.itemView.setLayoutParams(localLayoutParams);
      return;
    }
    if (paramVideoInfo.a(rwy.a(this.b))) {}
    for (localLayoutParams.height = i;; localLayoutParams.height = i)
    {
      localLayoutParams.width = -1;
      break;
    }
  }
  
  private void c(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    int i = paramVideoInfo.b(rwy.a(this.b));
    ViewGroup.LayoutParams localLayoutParams = this.a.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.height = -1;
      localLayoutParams.width = -1;
    }
    for (;;)
    {
      this.a.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = -1;
      if (paramVideoInfo.a(rwy.a(this.b), this.a.jdField_d_of_type_Int) != 2) {
        break;
      }
      localLayoutParams.height = -1;
    }
    if (i > 0) {}
    for (;;)
    {
      localLayoutParams.height = i;
      break;
      i = -1;
    }
  }
  
  public void a()
  {
    b(this.a.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, rwy.a(this.b));
    c(this.a.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, rwy.a(this.b));
  }
  
  public void a(float paramFloat)
  {
    this.a.jdField_a_of_type_Sek.a(false);
    if (this.a.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(100.0F * paramFloat));
      this.a.s.setVisibility(8);
      this.a.u.setVisibility(8);
      this.a.j.setVisibility(0);
      if (paramFloat == 0.0F) {
        this.a.j.setEnabled(false);
      }
    }
    for (;;)
    {
      rwy.a(this.b).removeMessages(0);
      rwy.a(this.b).sendEmptyMessageDelayed(0, 1500L);
      return;
      this.a.j.setEnabled(true);
      continue;
      this.a.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.a.jdField_b_of_type_AndroidWidgetSeekBar.setProgress((int)(100.0F * paramFloat));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      i(true);
    }
    while (paramInt != 2) {
      return;
    }
    i(false);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    this.a.h.setTag(this.a);
    this.a.h.setOnClickListener(this.b);
    int i = ryx.b(rwy.a(this.b))[0];
    int j = paramVideoInfo.b(rwy.a(this.b));
    b(paramVideoInfo, rwy.a(this.b));
    this.a.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.b);
    this.a.jdField_a_of_type_AndroidViewViewGroup.setTag(this.a);
    if ((paramVideoInfo.jdField_b_of_type_Int > 0) && (paramVideoInfo.jdField_c_of_type_Int > 0) && (paramVideoInfo.jdField_c_of_type_Int < 10000) && (paramVideoInfo.jdField_b_of_type_Int < 10000) && (this.a.jdField_a_of_type_Sar != null) && (this.a.jdField_a_of_type_Sar.jdField_a_of_type_Sfb != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "refreshContentUI: setFixedSize width=" + paramVideoInfo.jdField_b_of_type_Int + ", height=" + paramVideoInfo.jdField_c_of_type_Int);
      }
      this.a.jdField_a_of_type_Sar.jdField_a_of_type_Sfb.b(paramVideoInfo.a(rwy.a(this.b), this.a.jdField_d_of_type_Int));
      if (this.a.jdField_a_of_type_Sar.jdField_a_of_type_Sfb.a() != null) {
        this.a.jdField_a_of_type_Sar.jdField_a_of_type_Sfb.a().a(paramVideoInfo.jdField_b_of_type_Int, paramVideoInfo.jdField_c_of_type_Int);
      }
    }
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setTag(this.a);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this.b);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(rwy.a(this.b));
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(rwy.a(this.b));
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(409409L);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(rwy.a(this.b));
    this.a.i.setBackgroundDrawable(null);
    this.a.i.setTag(this.a);
    this.a.i.setOnClickListener(this.b);
    URL localURL = paramVideoInfo.a();
    URLImageView localURLImageView = this.a.jdField_b_of_type_ComTencentImageURLImageView;
    c(paramVideoInfo, rwy.a(this.b));
    if (localURL != null)
    {
      if ((this.a.jdField_c_of_type_Int != 0) || (this.a.jdField_b_of_type_Int != 0) || (!a(localURLImageView, localURL)))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mLoadingDrawable = rwy.a(this.b);
        localURLDrawableOptions.mFailedDrawable = rwy.a(this.b);
        localURLImageView.setImageDrawable(URLDrawable.getDrawable(localURL, localURLDrawableOptions));
      }
      localURLImageView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      ryx.a(this.a.s, 0L);
      ryx.a(this.a.u, paramVideoInfo.a() * 1000);
      if ((rwy.d(this.b)) || (this.a.jdField_c_of_type_Int != 0)) {
        break label798;
      }
      this.a.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      label604:
      this.a.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      this.a.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.a.f.setTag(this.a);
      this.a.f.setOnClickListener(this.b);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(1.0F);
      this.a.w.setVisibility(8);
      this.a.i.setVisibility(0);
      this.a.v.setVisibility(8);
      this.a.x.setVisibility(8);
      this.a.q.setVisibility(8);
      if (this.a.l != null)
      {
        this.a.l.setOnClickListener(this.b);
        this.a.l.setTag(this.a);
        if (!siy.a.a()) {
          break label813;
        }
        this.a.l.setVisibility(0);
      }
    }
    for (;;)
    {
      i(false);
      return;
      localURLImageView.setImageDrawable(null);
      break;
      label798:
      this.a.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      break label604;
      label813:
      this.a.l.setVisibility(8);
    }
  }
  
  protected void a(rxq paramrxq, boolean paramBoolean)
  {
    Object localObject = paramrxq.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    if (paramBoolean) {}
    for (localObject = anni.a(2131714892);; localObject = ryx.c(((VideoInfo)localObject).jdField_b_of_type_Long))
    {
      paramrxq.i.setVisibility(8);
      Drawable localDrawable = rwy.a(this.b).getResources().getDrawable(2130843112);
      paramrxq.v.setText((CharSequence)localObject);
      paramrxq.v.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      paramrxq.v.setCompoundDrawablePadding(afur.a(6.0F, rwy.a(this.b).getResources()));
      paramrxq.v.setVisibility(0);
      paramrxq.v.setOnClickListener(this.b);
      paramrxq.v.setTag(paramrxq);
      if ((!paramBoolean) && (!TextUtils.isEmpty(bhhb.a("kandian"))))
      {
        paramrxq.x.setVisibility(0);
        ryx.a(rwy.a(this.b), paramrxq.x);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a(this.a)) {
      a(this.a, rwy.j(this.b));
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(0.0F);
      if ((this.a.jdField_c_of_type_Int != 0) || (this.a.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0)) {
        break;
      }
      i(true);
      return;
      this.a.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    i(false);
  }
  
  public void b()
  {
    if (rwy.a(this.b).jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      j(bool);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    if (this.a.l != null) {
      this.a.l.setImageResource(paramInt);
    }
  }
  
  public void c()
  {
    boolean bool = false;
    if (this.a.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
      this.a.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      if (this.a.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        bool = true;
      }
      i(bool);
      return;
      if (!rwy.a(this.b)) {
        this.a.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.a.jdField_c_of_type_Int == 0) && (this.a.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)) {
      i(true);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (a(this.a)) {
          a(this.a, rwy.j(this.b));
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(0.0F);
      }
      return;
      i(false);
      if (this.a.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        ryx.a(this.a.jdField_c_of_type_AndroidViewViewGroup, 8);
      }
    }
  }
  
  public void e(boolean paramBoolean) {}
  
  public void f(boolean paramBoolean)
  {
    b(this.a.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramBoolean);
    c(this.a.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramBoolean);
    if (paramBoolean)
    {
      this.a.e.setVisibility(0);
      this.a.k.setBackgroundDrawable(rwy.a(this.b, 2130841754));
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setVisibility(8);
    }
    for (;;)
    {
      if ((rwy.a(this.b) != null) && (rwy.a(this.b).isShowing())) {
        rwy.a(this.b).dismiss();
      }
      if (rwy.a(this.b) != null) {
        rwy.a(this.b).a();
      }
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(paramBoolean);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
      i(false);
      if (bqcd.b())
      {
        if (!paramBoolean) {
          break;
        }
        this.a.jdField_d_of_type_AndroidViewViewGroup.setPadding(bqcd.b(rwy.a(this.b)), 0, bqcd.b(rwy.a(this.b)), 0);
      }
      return;
      this.a.e.setVisibility(8);
      this.a.k.setBackgroundDrawable(rwy.a(this.b, 2130841755));
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setVisibility(0);
    }
    this.a.jdField_d_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
  }
  
  public void g(boolean paramBoolean)
  {
    i(paramBoolean);
  }
  
  public void h(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.a.i != null)
      {
        this.a.i.setVisibility(0);
        this.a.v.setVisibility(8);
        if ((!rwy.j(this.b)) && (!TextUtils.isEmpty(bhhb.a("kandian")))) {
          this.a.x.setVisibility(8);
        }
      }
    }
    while (!a(this.a)) {
      return;
    }
    a(this.a, rwy.j(this.b));
  }
  
  protected void i(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        ryx.a(this.a.jdField_d_of_type_AndroidViewViewGroup, 0);
      }
      if (this.a.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        ryx.a(this.a.jdField_c_of_type_AndroidViewViewGroup, 0);
      }
    }
    for (;;)
    {
      j(paramBoolean);
      return;
      if (this.a.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        ryx.a(this.a.jdField_d_of_type_AndroidViewViewGroup, 8);
      }
      if ((rwy.a(this.b).d()) && (this.a.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
        ryx.a(this.a.jdField_c_of_type_AndroidViewViewGroup, 8);
      }
      if (rwy.a(this.b)) {
        this.a.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      } else {
        this.a.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
    }
  }
  
  protected void j(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
      this.a.s.setVisibility(0);
      this.a.u.setVisibility(0);
      this.a.j.setVisibility(8);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Sek.a(true);
      this.a.jdField_a_of_type_Sek.a();
      return;
      this.a.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxp
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.net.URL;

public abstract class rvm
  implements rsn
{
  private rvn a;
  
  public rvm(ruw paramruw, rvn paramrvn)
  {
    this.a = paramrvn;
  }
  
  private boolean a(ImageView paramImageView, URL paramURL)
  {
    boolean bool = true;
    Object localObject = ruw.a(this.b).getIntent();
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
        localObject = new syo();
        ((syo)localObject).jdField_a_of_type_JavaNetURL = pay.a(paramURL.toString());
        ((syo)localObject).jdField_a_of_type_Int = j;
        ((syo)localObject).jdField_b_of_type_Int = i;
        localObject = syn.a().a((syo)localObject);
        if ((localObject == null) || (((syk)localObject).a() == null)) {
          break;
        }
        paramImageView.setImageDrawable(new syw(((syk)localObject).a()));
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
  
  private boolean a(rvn paramrvn)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (ruw.a(this.b) != null)
    {
      bool1 = bool2;
      if (NetworkUtil.isMobileNetWork(ruw.a(this.b)))
      {
        bool1 = bool2;
        if (paramrvn != null)
        {
          bool1 = bool2;
          if (paramrvn.jdField_a_of_type_Ryo != null)
          {
            bool1 = bool2;
            if (paramrvn.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
            {
              bool1 = bool2;
              if (paramrvn.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long >= 0L)
              {
                bool1 = bool2;
                if ((paramrvn instanceof rvv))
                {
                  bool1 = bool2;
                  if (!ruw.a(this.b, (rvv)paramrvn)) {
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
    int i = paramVideoInfo.a(ruw.a(this.b));
    int j = rwv.b(ruw.a(this.b))[0];
    if (paramBoolean)
    {
      localLayoutParams.height = -1;
      localLayoutParams.width = -1;
      this.a.itemView.setLayoutParams(localLayoutParams);
      return;
    }
    if (paramVideoInfo.a(ruw.a(this.b))) {}
    for (localLayoutParams.height = i;; localLayoutParams.height = i)
    {
      localLayoutParams.width = -1;
      break;
    }
  }
  
  private void c(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    int i = paramVideoInfo.b(ruw.a(this.b));
    ViewGroup.LayoutParams localLayoutParams = this.a.jdField_c_of_type_ComTencentImageURLImageView.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.height = -1;
      localLayoutParams.width = -1;
    }
    for (;;)
    {
      this.a.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = -1;
      if (paramVideoInfo.a(ruw.a(this.b), this.a.jdField_d_of_type_Int) != 2) {
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
    b(this.a.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, ruw.a(this.b));
    c(this.a.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, ruw.a(this.b));
  }
  
  public void a(float paramFloat)
  {
    this.a.jdField_a_of_type_Scs.a(false);
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
      ruw.a(this.b).removeMessages(0);
      ruw.a(this.b).sendEmptyMessageDelayed(0, 1500L);
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
    int i = rwv.b(ruw.a(this.b))[0];
    int j = paramVideoInfo.b(ruw.a(this.b));
    b(paramVideoInfo, ruw.a(this.b));
    this.a.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.b);
    this.a.jdField_a_of_type_AndroidViewViewGroup.setTag(this.a);
    if ((paramVideoInfo.jdField_b_of_type_Int > 0) && (paramVideoInfo.jdField_c_of_type_Int > 0) && (paramVideoInfo.jdField_c_of_type_Int < 10000) && (paramVideoInfo.jdField_b_of_type_Int < 10000) && (this.a.jdField_a_of_type_Ryo != null) && (this.a.jdField_a_of_type_Ryo.jdField_a_of_type_Sdj != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "refreshContentUI: setFixedSize width=" + paramVideoInfo.jdField_b_of_type_Int + ", height=" + paramVideoInfo.jdField_c_of_type_Int);
      }
      this.a.jdField_a_of_type_Ryo.jdField_a_of_type_Sdj.b(paramVideoInfo.a(ruw.a(this.b), this.a.jdField_d_of_type_Int));
      if (this.a.jdField_a_of_type_Ryo.jdField_a_of_type_Sdj.a() != null) {
        this.a.jdField_a_of_type_Ryo.jdField_a_of_type_Sdj.a().a(paramVideoInfo.jdField_b_of_type_Int, paramVideoInfo.jdField_c_of_type_Int);
      }
    }
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setTag(this.a);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this.b);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(ruw.a(this.b));
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(ruw.a(this.b));
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(409409L);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(ruw.a(this.b));
    this.a.i.setBackgroundDrawable(null);
    this.a.i.setTag(this.a);
    this.a.i.setOnClickListener(this.b);
    URL localURL = paramVideoInfo.a();
    URLImageView localURLImageView = this.a.jdField_c_of_type_ComTencentImageURLImageView;
    c(paramVideoInfo, ruw.a(this.b));
    if (localURL != null)
    {
      if ((this.a.jdField_c_of_type_Int != 0) || (this.a.jdField_b_of_type_Int != 0) || (!a(localURLImageView, localURL)))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mLoadingDrawable = ruw.a(this.b);
        localURLDrawableOptions.mFailedDrawable = ruw.a(this.b);
        localURLImageView.setImageDrawable(URLDrawable.getDrawable(localURL, localURLDrawableOptions));
      }
      localURLImageView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      rwv.a(this.a.s, 0L);
      rwv.a(this.a.u, paramVideoInfo.a() * 1000);
      if ((ruw.d(this.b)) || (this.a.jdField_c_of_type_Int != 0)) {
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
        if (!shg.a.a()) {
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
  
  protected void a(rvn paramrvn, boolean paramBoolean)
  {
    Object localObject = paramrvn.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    if (paramBoolean) {}
    for (localObject = amtj.a(2131715235);; localObject = rwv.c(((VideoInfo)localObject).jdField_b_of_type_Long))
    {
      paramrvn.i.setVisibility(8);
      Drawable localDrawable = ruw.a(this.b).getResources().getDrawable(2130843190);
      paramrvn.v.setText((CharSequence)localObject);
      paramrvn.v.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      paramrvn.v.setCompoundDrawablePadding(AIOUtils.dp2px(6.0F, ruw.a(this.b).getResources()));
      paramrvn.v.setVisibility(0);
      paramrvn.v.setOnClickListener(this.b);
      paramrvn.v.setTag(paramrvn);
      if ((!paramBoolean) && (!TextUtils.isEmpty(bgoa.a("kandian"))))
      {
        paramrvn.x.setVisibility(0);
        rwv.a(ruw.a(this.b), paramrvn.x);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a(this.a)) {
      a(this.a, ruw.j(this.b));
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(0.0F);
      if ((this.a.jdField_c_of_type_Int != 0) || (this.a.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0)) {
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
    if (ruw.a(this.b).jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {}
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
      if (!ruw.a(this.b)) {
        this.a.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.a.jdField_c_of_type_Int == 0) && (this.a.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)) {
      i(true);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (a(this.a)) {
          a(this.a, ruw.j(this.b));
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(0.0F);
      }
      ruw.a(this.b).jdField_a_of_type_Shp.a();
      return;
      i(false);
      if (this.a.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        rwv.a(this.a.jdField_c_of_type_AndroidViewViewGroup, 8);
      }
    }
  }
  
  public void e(boolean paramBoolean) {}
  
  public void f(boolean paramBoolean)
  {
    b(this.a.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramBoolean);
    c(this.a.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramBoolean);
    if (paramBoolean)
    {
      this.a.e.setVisibility(0);
      this.a.k.setBackgroundDrawable(ruw.a(this.b, 2130841806));
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setVisibility(8);
    }
    for (;;)
    {
      if ((ruw.a(this.b) != null) && (ruw.a(this.b).isShowing())) {
        ruw.a(this.b).dismiss();
      }
      if (ruw.a(this.b) != null) {
        ruw.a(this.b).a();
      }
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(paramBoolean);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
      i(false);
      if (LiuHaiUtils.b())
      {
        if (!paramBoolean) {
          break;
        }
        this.a.jdField_d_of_type_AndroidViewViewGroup.setPadding(LiuHaiUtils.b(ruw.a(this.b)), 0, LiuHaiUtils.b(ruw.a(this.b)), 0);
      }
      return;
      this.a.e.setVisibility(8);
      this.a.k.setBackgroundDrawable(ruw.a(this.b, 2130841807));
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
    if (paramBoolean)
    {
      if (this.a.i != null)
      {
        this.a.i.setVisibility(0);
        this.a.v.setVisibility(8);
        if ((!ruw.j(this.b)) && (!TextUtils.isEmpty(bgoa.a("kandian")))) {
          this.a.x.setVisibility(8);
        }
      }
      return;
    }
    if (rwv.b())
    {
      if (ruw.j(this.b)) {}
      for (String str1 = amtj.a(2131715235);; str1 = rwv.c(this.a.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long))
      {
        String str2 = amtj.a(2131715191);
        this.a.jdField_a_of_type_Shp.a(0, str2, str1, 2130843258);
        return;
      }
    }
    this.a.jdField_a_of_type_Scs.a(this.a.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
  }
  
  protected void i(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        rwv.a(this.a.jdField_d_of_type_AndroidViewViewGroup, 0);
      }
      if (this.a.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        rwv.a(this.a.jdField_c_of_type_AndroidViewViewGroup, 0);
      }
    }
    for (;;)
    {
      j(paramBoolean);
      return;
      if (this.a.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        rwv.a(this.a.jdField_d_of_type_AndroidViewViewGroup, 8);
      }
      if ((ruw.a(this.b).f()) && (this.a.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
        rwv.a(this.a.jdField_c_of_type_AndroidViewViewGroup, 8);
      }
      if (ruw.a(this.b)) {
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
      this.a.jdField_a_of_type_Scs.a(true);
      this.a.jdField_a_of_type_Scs.a();
      return;
      this.a.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvm
 * JD-Core Version:    0.7.0.1
 */
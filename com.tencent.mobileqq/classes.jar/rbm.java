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
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.net.URL;

public abstract class rbm
  implements qyv
{
  private rbn a;
  
  public rbm(raw paramraw, rbn paramrbn)
  {
    this.a = paramrbn;
  }
  
  private boolean a(ImageView paramImageView, URL paramURL)
  {
    boolean bool = true;
    Object localObject = raw.a(this.b).getIntent();
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
        localObject = new sfg();
        ((sfg)localObject).jdField_a_of_type_JavaNetURL = ors.a(paramURL.toString());
        ((sfg)localObject).jdField_a_of_type_Int = j;
        ((sfg)localObject).jdField_b_of_type_Int = i;
        localObject = sff.a().a((sfg)localObject);
        if ((localObject == null) || (((sfc)localObject).a() == null)) {
          break;
        }
        paramImageView.setImageDrawable(new sfn(((sfc)localObject).a()));
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
  
  private boolean a(rbn paramrbn)
  {
    return (raw.a(this.b) != null) && (bdee.b(raw.a(this.b))) && (paramrbn != null) && (paramrbn.jdField_a_of_type_Rfs != null) && (paramrbn.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrbn.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long >= 0L) && ((paramrbn instanceof rbt)) && (!raw.a(this.b, (rbt)paramrbn));
  }
  
  private void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = this.a.itemView.getLayoutParams();
    int i = paramVideoInfo.a(raw.a(this.b));
    int j = rdm.b(raw.a(this.b))[0];
    if (paramBoolean)
    {
      localLayoutParams.height = -1;
      localLayoutParams.width = -1;
    }
    for (;;)
    {
      this.a.itemView.setLayoutParams(localLayoutParams);
      return;
      if (paramVideoInfo.a(raw.a(this.b))) {}
      for (localLayoutParams.height = i;; localLayoutParams.height = i)
      {
        if (!this.a.jdField_b_of_type_Boolean) {
          break label115;
        }
        localLayoutParams.width = -1;
        break;
      }
      label115:
      localLayoutParams.width = (j - 2);
    }
  }
  
  private void c(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    int i = paramVideoInfo.b(raw.a(this.b));
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
      if (paramVideoInfo.c(raw.a(this.b)) != 2) {
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
    b(this.a.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, raw.a(this.b));
    c(this.a.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, raw.a(this.b));
  }
  
  public void a(float paramFloat)
  {
    this.a.jdField_a_of_type_Riw.a(false);
    if (this.a.d.getVisibility() == 0)
    {
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(100.0F * paramFloat));
      this.a.u.setVisibility(8);
      this.a.w.setVisibility(8);
      this.a.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramFloat == 0.0F) {
        this.a.jdField_h_of_type_AndroidWidgetImageView.setEnabled(false);
      }
    }
    for (;;)
    {
      raw.a(this.b).removeMessages(0);
      raw.a(this.b).sendEmptyMessageDelayed(0, 1500L);
      return;
      this.a.jdField_h_of_type_AndroidWidgetImageView.setEnabled(true);
      continue;
      this.a.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.a.jdField_b_of_type_AndroidWidgetSeekBar.setProgress((int)(100.0F * paramFloat));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      h(true);
    }
    while (paramInt != 2) {
      return;
    }
    h(false);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    this.a.jdField_h_of_type_AndroidViewViewGroup.setTag(this.a);
    this.a.jdField_h_of_type_AndroidViewViewGroup.setOnClickListener(this.b);
    paramVideoInfo.a(raw.a(this.b));
    int i = rdm.b(raw.a(this.b))[0];
    int j = paramVideoInfo.b(raw.a(this.b));
    b(paramVideoInfo, raw.a(this.b));
    this.a.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.b);
    this.a.jdField_a_of_type_AndroidViewViewGroup.setTag(this.a);
    if ((paramVideoInfo.jdField_b_of_type_Int > 0) && (paramVideoInfo.jdField_c_of_type_Int > 0) && (paramVideoInfo.jdField_c_of_type_Int < 10000) && (paramVideoInfo.jdField_b_of_type_Int < 10000) && (this.a.jdField_a_of_type_Rfs != null) && ((this.a.jdField_a_of_type_Rfs.jdField_a_of_type_AndroidViewView instanceof IVideoViewBase)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "refreshContentUI: setFixedSize width=" + paramVideoInfo.jdField_b_of_type_Int + ", height=" + paramVideoInfo.jdField_c_of_type_Int);
      }
      ((IVideoViewBase)this.a.jdField_a_of_type_Rfs.jdField_a_of_type_AndroidViewView).setXYaxis(paramVideoInfo.c(raw.a(this.b)));
      ((IVideoViewBase)this.a.jdField_a_of_type_Rfs.jdField_a_of_type_AndroidViewView).setFixedSize(paramVideoInfo.jdField_b_of_type_Int, paramVideoInfo.jdField_c_of_type_Int);
    }
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setTag(this.a);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this.b);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(raw.a(this.b));
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(raw.a(this.b));
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(409409L);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(raw.a(this.b));
    this.a.g.setBackgroundDrawable(null);
    this.a.g.setTag(this.a);
    this.a.g.setOnClickListener(this.b);
    URL localURL = paramVideoInfo.a();
    URLImageView localURLImageView = this.a.jdField_b_of_type_ComTencentImageURLImageView;
    c(paramVideoInfo, raw.a(this.b));
    if (localURL != null)
    {
      if ((this.a.jdField_c_of_type_Int != 0) || (this.a.jdField_b_of_type_Int != 0) || (!a(localURLImageView, localURL)))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mLoadingDrawable = raw.a(this.b);
        localURLDrawableOptions.mFailedDrawable = raw.a(this.b);
        localURLImageView.setImageDrawable(URLDrawable.getDrawable(localURL, localURLDrawableOptions));
      }
      localURLImageView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      rdm.a(this.a.u, 0L);
      rdm.a(this.a.w, paramVideoInfo.a() * 1000);
      if ((raw.c(this.b)) || (this.a.jdField_c_of_type_Int != 0)) {
        break label737;
      }
      this.a.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    for (;;)
    {
      this.a.d.setVisibility(8);
      this.a.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.a.f.setTag(this.a);
      this.a.f.setOnClickListener(this.b);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(1.0F);
      this.a.y.setVisibility(8);
      this.a.g.setVisibility(0);
      this.a.x.setVisibility(8);
      this.a.z.setVisibility(8);
      this.a.s.setVisibility(8);
      h(false);
      return;
      localURLImageView.setImageDrawable(null);
      break;
      label737:
      this.a.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    }
  }
  
  protected void a(rbn paramrbn, boolean paramBoolean)
  {
    Object localObject = paramrbn.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    if (paramBoolean) {}
    for (localObject = alpo.a(2131716603);; localObject = rdm.c(((VideoInfo)localObject).jdField_b_of_type_Long))
    {
      paramrbn.g.setVisibility(8);
      Drawable localDrawable = raw.a(this.b).getResources().getDrawable(2130842757);
      paramrbn.x.setText((CharSequence)localObject);
      paramrbn.x.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      paramrbn.x.setCompoundDrawablePadding(aekt.a(6.0F, raw.a(this.b).getResources()));
      paramrbn.x.setVisibility(0);
      paramrbn.x.setOnClickListener(this.b);
      paramrbn.x.setTag(paramrbn);
      if ((!paramBoolean) && (!TextUtils.isEmpty(bdvr.a("kandian"))))
      {
        paramrbn.z.setVisibility(0);
        rdm.a(raw.a(this.b), paramrbn.z);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a(this.a)) {
      a(this.a, raw.k(this.b));
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(0.0F);
      if ((this.a.jdField_c_of_type_Int != 0) || (this.a.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0)) {
        break;
      }
      h(true);
      return;
      this.a.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    h(false);
  }
  
  public void b()
  {
    if (raw.a(this.b).d.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      i(bool);
      return;
    }
  }
  
  public void c()
  {
    boolean bool = false;
    if (this.a.d.getVisibility() == 8) {
      this.a.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      if (this.a.d.getVisibility() == 8) {
        bool = true;
      }
      h(bool);
      return;
      if (!raw.a(this.b)) {
        this.a.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.a.jdField_c_of_type_Int == 0) && (this.a.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)) {
      h(true);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (a(this.a)) {
          a(this.a, raw.k(this.b));
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(0.0F);
      }
      return;
      h(false);
      if (this.a.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        rdm.a(this.a.jdField_c_of_type_AndroidViewViewGroup, 8);
      }
    }
  }
  
  public void d(boolean paramBoolean) {}
  
  public void e(boolean paramBoolean)
  {
    b(this.a.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramBoolean);
    c(this.a.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramBoolean);
    if (paramBoolean)
    {
      this.a.e.setVisibility(0);
      this.a.i.setBackgroundDrawable(raw.a(this.b, 2130841444));
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setVisibility(8);
    }
    for (;;)
    {
      if ((raw.a(this.b) != null) && (raw.a(this.b).isShowing())) {
        raw.a(this.b).dismiss();
      }
      if (raw.a(this.b) != null) {
        raw.a(this.b).a();
      }
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(paramBoolean);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
      h(false);
      if (bngs.b())
      {
        if (!paramBoolean) {
          break;
        }
        this.a.d.setPadding(bngs.b(raw.a(this.b)), 0, bngs.b(raw.a(this.b)), 0);
      }
      return;
      this.a.e.setVisibility(8);
      this.a.i.setBackgroundDrawable(raw.a(this.b, 2130841445));
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setVisibility(0);
    }
    this.a.d.setPadding(0, 0, 0, 0);
  }
  
  public void f(boolean paramBoolean)
  {
    h(paramBoolean);
  }
  
  public void g(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.a.g != null)
      {
        this.a.g.setVisibility(0);
        this.a.x.setVisibility(8);
        if ((!raw.k(this.b)) && (!TextUtils.isEmpty(bdvr.a("kandian")))) {
          this.a.z.setVisibility(8);
        }
      }
    }
    while (!a(this.a)) {
      return;
    }
    a(this.a, raw.k(this.b));
  }
  
  protected void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.d.getVisibility() == 8) {
        rdm.a(this.a.d, 0);
      }
      if (this.a.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        rdm.a(this.a.jdField_c_of_type_AndroidViewViewGroup, 0);
      }
    }
    for (;;)
    {
      i(paramBoolean);
      return;
      if (this.a.d.getVisibility() == 0) {
        rdm.a(this.a.d, 8);
      }
      if ((raw.a(this.b).d()) && (this.a.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
        rdm.a(this.a.jdField_c_of_type_AndroidViewViewGroup, 8);
      }
      if (raw.a(this.b)) {
        this.a.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      } else {
        this.a.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
    }
  }
  
  protected void i(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
      this.a.u.setVisibility(0);
      this.a.w.setVisibility(0);
      this.a.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Riw.a(true);
      this.a.jdField_a_of_type_Riw.a();
      return;
      this.a.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rbm
 * JD-Core Version:    0.7.0.1
 */
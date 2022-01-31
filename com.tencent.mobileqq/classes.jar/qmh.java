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

public abstract class qmh
  implements qjr
{
  private qmi a;
  
  public qmh(qls paramqls, qmi paramqmi)
  {
    this.a = paramqmi;
  }
  
  private boolean a(ImageView paramImageView, URL paramURL)
  {
    boolean bool = true;
    Object localObject = qls.a(this.b).getIntent();
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
        localObject = new rpk();
        ((rpk)localObject).jdField_a_of_type_JavaNetURL = onk.a(paramURL.toString());
        ((rpk)localObject).jdField_a_of_type_Int = j;
        ((rpk)localObject).jdField_b_of_type_Int = i;
        localObject = rpj.a().a((rpk)localObject);
        if ((localObject == null) || (((rpg)localObject).a() == null)) {
          break;
        }
        paramImageView.setImageDrawable(new rpr(((rpg)localObject).a()));
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
  
  private boolean a(qmi paramqmi)
  {
    return (qls.a(this.b) != null) && (bbev.b(qls.a(this.b))) && (paramqmi != null) && (paramqmi.jdField_a_of_type_Qqo != null) && (paramqmi.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqmi.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long >= 0L) && ((paramqmi instanceof qms)) && (!qls.a(this.b, (qms)paramqmi));
  }
  
  private void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = this.a.itemView.getLayoutParams();
    int i = paramVideoInfo.a(qls.a(this.b));
    int j = qol.b(qls.a(this.b))[0];
    if (paramBoolean)
    {
      localLayoutParams.height = -1;
      localLayoutParams.width = -1;
    }
    for (;;)
    {
      this.a.itemView.setLayoutParams(localLayoutParams);
      return;
      if (paramVideoInfo.a(qls.a(this.b))) {}
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
    int i = paramVideoInfo.b(qls.a(this.b));
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
      if (paramVideoInfo.c(qls.a(this.b)) != 2) {
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
    b(this.a.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, qls.a(this.b));
    c(this.a.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, qls.a(this.b));
  }
  
  public void a(float paramFloat)
  {
    this.a.jdField_a_of_type_Qtk.a(false);
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
      qls.a(this.b).removeMessages(0);
      qls.a(this.b).sendEmptyMessageDelayed(0, 1500L);
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
    paramVideoInfo.a(qls.a(this.b));
    int i = qol.b(qls.a(this.b))[0];
    int j = paramVideoInfo.b(qls.a(this.b));
    b(paramVideoInfo, qls.a(this.b));
    this.a.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.b);
    this.a.jdField_a_of_type_AndroidViewViewGroup.setTag(this.a);
    if ((paramVideoInfo.jdField_b_of_type_Int > 0) && (paramVideoInfo.jdField_c_of_type_Int > 0) && (paramVideoInfo.jdField_c_of_type_Int < 10000) && (paramVideoInfo.jdField_b_of_type_Int < 10000) && (this.a.jdField_a_of_type_Qqo != null) && ((this.a.jdField_a_of_type_Qqo.jdField_a_of_type_AndroidViewView instanceof IVideoViewBase)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "refreshContentUI: setFixedSize width=" + paramVideoInfo.jdField_b_of_type_Int + ", height=" + paramVideoInfo.jdField_c_of_type_Int);
      }
      ((IVideoViewBase)this.a.jdField_a_of_type_Qqo.jdField_a_of_type_AndroidViewView).setXYaxis(paramVideoInfo.c(qls.a(this.b)));
      ((IVideoViewBase)this.a.jdField_a_of_type_Qqo.jdField_a_of_type_AndroidViewView).setFixedSize(paramVideoInfo.jdField_b_of_type_Int, paramVideoInfo.jdField_c_of_type_Int);
    }
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setTag(this.a);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this.b);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(qls.a(this.b));
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(qls.a(this.b));
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(409409L);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(qls.a(this.b));
    this.a.g.setBackgroundDrawable(null);
    this.a.g.setTag(this.a);
    this.a.g.setOnClickListener(this.b);
    URL localURL = paramVideoInfo.a();
    URLImageView localURLImageView = this.a.jdField_b_of_type_ComTencentImageURLImageView;
    c(paramVideoInfo, qls.a(this.b));
    if (localURL != null)
    {
      if ((this.a.jdField_c_of_type_Int != 0) || (this.a.jdField_b_of_type_Int != 0) || (!a(localURLImageView, localURL)))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mLoadingDrawable = qls.a(this.b);
        localURLDrawableOptions.mFailedDrawable = qls.a(this.b);
        localURLImageView.setImageDrawable(URLDrawable.getDrawable(localURL, localURLDrawableOptions));
      }
      localURLImageView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      qol.a(this.a.u, 0L);
      qol.a(this.a.w, paramVideoInfo.a() * 1000);
      if ((qls.c(this.b)) || (this.a.jdField_c_of_type_Int != 0)) {
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
  
  protected void a(qmi paramqmi, boolean paramBoolean)
  {
    Object localObject = paramqmi.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    if (paramBoolean) {}
    for (localObject = ajyc.a(2131716220);; localObject = qol.c(((VideoInfo)localObject).jdField_b_of_type_Long))
    {
      paramqmi.g.setVisibility(8);
      Drawable localDrawable = qls.a(this.b).getResources().getDrawable(2130842576);
      paramqmi.x.setText((CharSequence)localObject);
      paramqmi.x.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      paramqmi.x.setCompoundDrawablePadding(actn.a(6.0F, qls.a(this.b).getResources()));
      paramqmi.x.setVisibility(0);
      paramqmi.x.setOnClickListener(this.b);
      paramqmi.x.setTag(paramqmi);
      if ((!paramBoolean) && (!TextUtils.isEmpty(bbwc.a("kandian"))))
      {
        paramqmi.z.setVisibility(0);
        qol.a(qls.a(this.b), paramqmi.z);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a(this.a)) {
      a(this.a, qls.j(this.b));
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(0.0F);
      if ((this.a.jdField_c_of_type_Int != 0) || (this.a.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0)) {
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
    if (qls.a(this.b).d.getVisibility() == 0) {}
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
      if (!qls.a(this.b)) {
        this.a.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.a.jdField_c_of_type_Int == 0) && (this.a.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)) {
      h(true);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (a(this.a)) {
          a(this.a, qls.j(this.b));
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(0.0F);
      }
      return;
      h(false);
      if (this.a.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        qol.a(this.a.jdField_c_of_type_AndroidViewViewGroup, 8);
      }
    }
  }
  
  public void d(boolean paramBoolean) {}
  
  public void e(boolean paramBoolean)
  {
    b(this.a.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramBoolean);
    c(this.a.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramBoolean);
    if (paramBoolean)
    {
      this.a.e.setVisibility(0);
      this.a.i.setBackgroundDrawable(qls.a(this.b, 2130841326));
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setVisibility(8);
    }
    for (;;)
    {
      if ((qls.a(this.b) != null) && (qls.a(this.b).isShowing())) {
        qls.a(this.b).dismiss();
      }
      if (qls.a(this.b) != null) {
        qls.a(this.b).a();
      }
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(paramBoolean);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
      h(false);
      if (bkur.b())
      {
        if (!paramBoolean) {
          break;
        }
        this.a.d.setPadding(bkur.b(qls.a(this.b)), 0, bkur.b(qls.a(this.b)), 0);
      }
      return;
      this.a.e.setVisibility(8);
      this.a.i.setBackgroundDrawable(qls.a(this.b, 2130841327));
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
        if ((!qls.j(this.b)) && (!TextUtils.isEmpty(bbwc.a("kandian")))) {
          this.a.z.setVisibility(8);
        }
      }
    }
    while (!a(this.a)) {
      return;
    }
    a(this.a, qls.j(this.b));
  }
  
  protected void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.d.getVisibility() == 8) {
        qol.a(this.a.d, 0);
      }
      if (this.a.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        qol.a(this.a.jdField_c_of_type_AndroidViewViewGroup, 0);
      }
    }
    for (;;)
    {
      i(paramBoolean);
      return;
      if (this.a.d.getVisibility() == 0) {
        qol.a(this.a.d, 8);
      }
      if ((qls.a(this.b).d()) && (this.a.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
        qol.a(this.a.jdField_c_of_type_AndroidViewViewGroup, 8);
      }
      if (qls.a(this.b)) {
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
      this.a.jdField_a_of_type_Qtk.a(true);
      this.a.jdField_a_of_type_Qtk.a();
      return;
      this.a.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmh
 * JD-Core Version:    0.7.0.1
 */
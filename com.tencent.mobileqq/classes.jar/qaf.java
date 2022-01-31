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

public abstract class qaf
  implements pxs
{
  private qag a;
  
  public qaf(pzs parampzs, qag paramqag)
  {
    this.a = paramqag;
  }
  
  private boolean a(ImageView paramImageView, URL paramURL)
  {
    boolean bool = true;
    Object localObject = pzs.a(this.b).getIntent();
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
        localObject = new rcw();
        ((rcw)localObject).jdField_a_of_type_JavaNetURL = obz.a(paramURL.toString());
        ((rcw)localObject).jdField_a_of_type_Int = j;
        ((rcw)localObject).jdField_b_of_type_Int = i;
        localObject = rcv.a().a((rcw)localObject);
        if ((localObject == null) || (((rcs)localObject).a() == null)) {
          break;
        }
        paramImageView.setImageDrawable(new rdd(((rcs)localObject).a()));
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
  
  private boolean a(qag paramqag)
  {
    return (pzs.a(this.b) != null) && (badq.b(pzs.a(this.b))) && (paramqag != null) && (paramqag.jdField_a_of_type_Qeq != null) && (paramqag.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqag.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long >= 0L) && ((paramqag instanceof qaq)) && (!pzs.a(this.b, (qaq)paramqag));
  }
  
  private void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = this.a.itemView.getLayoutParams();
    int i = paramVideoInfo.a(pzs.a(this.b));
    int j = qcn.b(pzs.a(this.b))[0];
    if (paramBoolean)
    {
      localLayoutParams.height = -1;
      localLayoutParams.width = -1;
    }
    for (;;)
    {
      this.a.itemView.setLayoutParams(localLayoutParams);
      return;
      if (paramVideoInfo.a(pzs.a(this.b))) {}
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
    int i = paramVideoInfo.b(pzs.a(this.b));
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
      if (paramVideoInfo.c(pzs.a(this.b)) != 2) {
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
    b(this.a.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, pzs.a(this.b));
    c(this.a.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, pzs.a(this.b));
  }
  
  public void a(float paramFloat)
  {
    this.a.jdField_a_of_type_Qhf.a(false);
    if (this.a.d.getVisibility() == 0)
    {
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(100.0F * paramFloat));
      this.a.o.setVisibility(8);
      this.a.q.setVisibility(8);
      this.a.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramFloat == 0.0F) {
        this.a.jdField_f_of_type_AndroidWidgetImageView.setEnabled(false);
      }
    }
    for (;;)
    {
      pzs.a(this.b).removeMessages(0);
      pzs.a(this.b).sendEmptyMessageDelayed(0, 1500L);
      return;
      this.a.jdField_f_of_type_AndroidWidgetImageView.setEnabled(true);
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
    this.a.h.setTag(this.a);
    this.a.h.setOnClickListener(this.b);
    paramVideoInfo.a(pzs.a(this.b));
    int i = qcn.b(pzs.a(this.b))[0];
    int j = paramVideoInfo.b(pzs.a(this.b));
    b(paramVideoInfo, pzs.a(this.b));
    this.a.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.b);
    this.a.jdField_a_of_type_AndroidViewViewGroup.setTag(this.a);
    if ((paramVideoInfo.jdField_b_of_type_Int > 0) && (paramVideoInfo.jdField_c_of_type_Int > 0) && (paramVideoInfo.jdField_c_of_type_Int < 10000) && (paramVideoInfo.jdField_b_of_type_Int < 10000) && (this.a.jdField_a_of_type_Qeq != null) && ((this.a.jdField_a_of_type_Qeq.jdField_a_of_type_AndroidViewView instanceof IVideoViewBase)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "refreshContentUI: setFixedSize width=" + paramVideoInfo.jdField_b_of_type_Int + ", height=" + paramVideoInfo.jdField_c_of_type_Int);
      }
      ((IVideoViewBase)this.a.jdField_a_of_type_Qeq.jdField_a_of_type_AndroidViewView).setXYaxis(paramVideoInfo.c(pzs.a(this.b)));
      ((IVideoViewBase)this.a.jdField_a_of_type_Qeq.jdField_a_of_type_AndroidViewView).setFixedSize(paramVideoInfo.jdField_b_of_type_Int, paramVideoInfo.jdField_c_of_type_Int);
    }
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setTag(this.a);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this.b);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(pzs.a(this.b));
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(pzs.a(this.b));
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(409409L);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(pzs.a(this.b));
    this.a.jdField_e_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.a.jdField_e_of_type_AndroidWidgetImageView.setTag(this.a);
    this.a.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this.b);
    URL localURL = paramVideoInfo.a();
    URLImageView localURLImageView = this.a.jdField_b_of_type_ComTencentImageURLImageView;
    c(paramVideoInfo, pzs.a(this.b));
    if (localURL != null)
    {
      if ((this.a.jdField_c_of_type_Int != 0) || (this.a.jdField_b_of_type_Int != 0) || (!a(localURLImageView, localURL)))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mLoadingDrawable = pzs.a(this.b);
        localURLDrawableOptions.mFailedDrawable = pzs.a(this.b);
        localURLImageView.setImageDrawable(URLDrawable.getDrawable(localURL, localURLDrawableOptions));
      }
      localURLImageView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      qcn.a(this.a.o, 0L);
      qcn.a(this.a.q, paramVideoInfo.a() * 1000);
      if ((pzs.c(this.b)) || (this.a.jdField_c_of_type_Int != 0)) {
        break label737;
      }
      this.a.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    for (;;)
    {
      this.a.d.setVisibility(8);
      this.a.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.a.jdField_f_of_type_AndroidViewViewGroup.setTag(this.a);
      this.a.jdField_f_of_type_AndroidViewViewGroup.setOnClickListener(this.b);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(1.0F);
      this.a.t.setVisibility(8);
      this.a.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.a.jdField_s_of_type_AndroidWidgetTextView.setVisibility(8);
      this.a.u.setVisibility(8);
      this.a.jdField_s_of_type_AndroidViewView.setVisibility(8);
      h(false);
      return;
      localURLImageView.setImageDrawable(null);
      break;
      label737:
      this.a.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    }
  }
  
  protected void a(qag paramqag, boolean paramBoolean)
  {
    Object localObject = paramqag.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    if (paramBoolean) {}
    for (localObject = ajjy.a(2131650429);; localObject = qcn.c(((VideoInfo)localObject).jdField_b_of_type_Long))
    {
      paramqag.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      Drawable localDrawable = pzs.a(this.b).getResources().getDrawable(2130842494);
      paramqag.jdField_s_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramqag.jdField_s_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      paramqag.jdField_s_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aciy.a(6.0F, pzs.a(this.b).getResources()));
      paramqag.jdField_s_of_type_AndroidWidgetTextView.setVisibility(0);
      paramqag.jdField_s_of_type_AndroidWidgetTextView.setOnClickListener(this.b);
      paramqag.jdField_s_of_type_AndroidWidgetTextView.setTag(paramqag);
      if ((!paramBoolean) && (!TextUtils.isEmpty(bati.a("kandian"))))
      {
        paramqag.u.setVisibility(0);
        qcn.a(pzs.a(this.b), paramqag.u);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a(this.a)) {
      a(this.a, pzs.j(this.b));
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(0.0F);
      if ((this.a.jdField_c_of_type_Int != 0) || (this.a.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0)) {
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
    if (pzs.a(this.b).d.getVisibility() == 0) {}
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
      if (!pzs.a(this.b)) {
        this.a.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.a.jdField_c_of_type_Int == 0) && (this.a.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)) {
      h(true);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (a(this.a)) {
          a(this.a, pzs.j(this.b));
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setAlpha(0.0F);
      }
      return;
      h(false);
      if (this.a.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        qcn.a(this.a.jdField_c_of_type_AndroidViewViewGroup, 8);
      }
    }
  }
  
  public void d(boolean paramBoolean) {}
  
  public void e(boolean paramBoolean)
  {
    b(this.a.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramBoolean);
    c(this.a.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramBoolean);
    if (paramBoolean)
    {
      this.a.jdField_e_of_type_AndroidViewViewGroup.setVisibility(0);
      this.a.g.setBackgroundDrawable(pzs.a(this.b, 2130841247));
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView.setVisibility(8);
    }
    for (;;)
    {
      if ((pzs.a(this.b) != null) && (pzs.a(this.b).isShowing())) {
        pzs.a(this.b).dismiss();
      }
      if (pzs.a(this.b) != null) {
        pzs.a(this.b).a();
      }
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(paramBoolean);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
      h(false);
      if (bjeh.b())
      {
        if (!paramBoolean) {
          break;
        }
        this.a.d.setPadding(bjeh.b(pzs.a(this.b)), 0, bjeh.b(pzs.a(this.b)), 0);
      }
      return;
      this.a.jdField_e_of_type_AndroidViewViewGroup.setVisibility(8);
      this.a.g.setBackgroundDrawable(pzs.a(this.b, 2130841248));
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
      if (this.a.jdField_e_of_type_AndroidWidgetImageView != null)
      {
        this.a.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
        this.a.jdField_s_of_type_AndroidWidgetTextView.setVisibility(8);
        if ((!pzs.j(this.b)) && (!TextUtils.isEmpty(bati.a("kandian")))) {
          this.a.u.setVisibility(8);
        }
      }
    }
    while (!a(this.a)) {
      return;
    }
    a(this.a, pzs.j(this.b));
  }
  
  protected void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.d.getVisibility() == 8) {
        qcn.a(this.a.d, 0);
      }
      if (this.a.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        qcn.a(this.a.jdField_c_of_type_AndroidViewViewGroup, 0);
      }
    }
    for (;;)
    {
      i(paramBoolean);
      return;
      if (this.a.d.getVisibility() == 0) {
        qcn.a(this.a.d, 8);
      }
      if ((pzs.a(this.b).c()) && (this.a.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
        qcn.a(this.a.jdField_c_of_type_AndroidViewViewGroup, 8);
      }
      this.a.r.setVisibility(8);
      if (pzs.a(this.b)) {
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
      this.a.o.setVisibility(0);
      this.a.q.setVisibility(0);
      this.a.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Qhf.a(true);
      this.a.jdField_a_of_type_Qhf.a();
      return;
      this.a.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qaf
 * JD-Core Version:    0.7.0.1
 */
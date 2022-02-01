import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate.3;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate.4;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate.7;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate.8;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sek
  implements SeekBar.OnSeekBarChangeListener, ruv
{
  private long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler;
  VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  public rxq a;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e = true;
  private boolean f;
  private boolean g;
  
  public sek(rxq paramrxq, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Rxq = paramrxq;
    this.jdField_a_of_type_Rxq.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
    this.b = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new sel(this, Looper.getMainLooper());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Rxq.jdField_b_of_type_ComTencentImageURLImageView == null) {
      return;
    }
    ryx.a(this.jdField_a_of_type_Rxq.jdField_b_of_type_ComTencentImageURLImageView, paramInt1, paramInt2);
  }
  
  public static void a(TextView paramTextView, VideoInfo paramVideoInfo, sfb paramsfb)
  {
    ryx.a(paramTextView, paramsfb, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.d, paramVideoInfo.jdField_a_of_type_Int);
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    String str;
    if (this.b) {
      str = anni.a(2131714916);
    }
    for (;;)
    {
      paramVideoInfo = this.jdField_a_of_type_Rxq.w;
      paramVideoInfo.setText(str);
      ryx.a(paramVideoInfo, 0);
      this.g = true;
      this.jdField_a_of_type_AndroidOsHandler.postAtTime(new VideoFeedsVideoUIDelegate.8(this, paramVideoInfo), Integer.valueOf(0), SystemClock.uptimeMillis() + 1000L);
      return;
      str = anni.a(2131714812) + ryx.b(paramVideoInfo.b);
      if (paramVideoInfo.b <= 0L) {
        str = anni.a(2131714919);
      }
    }
  }
  
  private void b()
  {
    rxv localrxv = null;
    if ((this.jdField_a_of_type_Rxq instanceof rxv)) {
      localrxv = (rxv)this.jdField_a_of_type_Rxq;
    }
    if ((localrxv != null) && (localrxv.f != null) && ((localrxv.f.getDrawable() instanceof pka))) {
      ((pka)localrxv.f.getDrawable()).playAnimation();
    }
  }
  
  private void b(int paramInt)
  {
    a(paramInt, 500);
  }
  
  private void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsVideoUIDelegate", 2, "innerChangePlayButton() what = " + paramInt);
    }
    this.c = false;
    this.jdField_a_of_type_Rxq.i.clearAnimation();
    this.jdField_a_of_type_Rxq.i.setVisibility(0);
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Rxq.i.setBackgroundDrawable(sby.a(this.jdField_a_of_type_Rxq.i.getContext(), 2130843176));
      this.jdField_a_of_type_Rxq.i.clearAnimation();
      paramString = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      paramString.setDuration(500L);
      paramString.setRepeatCount(-1);
      paramString.setRepeatMode(1);
      paramString.setStartTime(-1L);
      paramString.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_Rxq.i.startAnimation(paramString);
      this.jdField_a_of_type_Rxq.c.setVisibility(0);
      return;
      this.jdField_a_of_type_Rxq.i.clearAnimation();
      this.jdField_a_of_type_Rxq.i.setBackgroundDrawable(sby.a(this.jdField_a_of_type_Rxq.i.getContext(), 2130843178));
      this.jdField_a_of_type_Rxq.c.setVisibility(0);
      return;
      this.jdField_a_of_type_Rxq.i.clearAnimation();
      this.jdField_a_of_type_Rxq.i.setBackgroundDrawable(sby.a(this.jdField_a_of_type_Rxq.i.getContext(), 2130843178));
      this.jdField_a_of_type_Rxq.c.setVisibility(8);
      return;
      this.jdField_a_of_type_Rxq.i.clearAnimation();
      this.jdField_a_of_type_Rxq.i.setBackgroundDrawable(sby.a(this.jdField_a_of_type_Rxq.i.getContext(), 2130843178));
      this.jdField_a_of_type_Rxq.c.setVisibility(0);
      return;
      this.jdField_a_of_type_Rxq.i.clearAnimation();
      this.jdField_a_of_type_Rxq.i.setBackgroundDrawable(sby.a(this.jdField_a_of_type_Rxq.i.getContext(), 2130843177));
      this.jdField_a_of_type_Rxq.c.setVisibility(0);
      return;
      this.jdField_a_of_type_Rxq.i.clearAnimation();
      this.jdField_a_of_type_Rxq.i.setBackgroundDrawable(sby.a(this.jdField_a_of_type_Rxq.i.getContext(), 2130843177));
      this.jdField_a_of_type_Rxq.c.setVisibility(8);
    } while ((this.jdField_a_of_type_Rxq.v.getVisibility() != 0) || (!bgnt.b(BaseApplicationImpl.getContext())));
    this.jdField_a_of_type_Rxq.i.setVisibility(0);
    this.jdField_a_of_type_Rxq.v.setVisibility(8);
    this.jdField_a_of_type_Rxq.x.setVisibility(8);
  }
  
  private boolean b(sar paramsar)
  {
    if (!bgnt.b(BaseApplicationImpl.getContext())) {}
    while ((paramsar == null) || (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!this.jdField_a_of_type_Boolean) || (this.g)) {
      return false;
    }
    return true;
  }
  
  private void j(sar paramsar)
  {
    if (b(paramsar)) {
      a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    a(4);
    if (paramsar.jdField_a_of_type_AndroidViewView != null) {
      paramsar.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    a(this.jdField_a_of_type_Rxq.t, paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramsar.jdField_a_of_type_Sfb);
    b();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    int i = 100;
    int j;
    if (this.e)
    {
      long l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
      long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      j = (int)((float)l1 * 100.0F / (float)l2 + 0.5D);
      if (j + 1 < 100) {
        break label75;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Rxq.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
      this.jdField_a_of_type_Rxq.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
      return;
      label75:
      i = j + 1;
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.c = false;
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.7(this, paramInt, paramString));
  }
  
  public void a(sar paramsar)
  {
    a(0);
  }
  
  public void a(sar paramsar, int paramInt1, int paramInt2, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = anni.a(2131714887);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.2(this, str, paramsar));
  }
  
  public void a(sar paramsar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramInt <= 300) {
        break label113;
      }
      paramInt -= 300;
    }
    for (;;)
    {
      this.jdField_a_of_type_Rxq.q.setVisibility(0);
      paramsar = new AlphaAnimation(0.0F, 1.0F);
      paramsar.setDuration(300L);
      paramsar.setStartOffset(paramInt);
      this.jdField_a_of_type_Rxq.q.setAnimation(paramsar);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new sem(this));
      paramsar.setAnimationListener(new sen(this, localAlphaAnimation));
      paramsar.start();
      return;
      label113:
      paramInt = 0;
    }
  }
  
  public void a(sar paramsar, long paramLong1, long paramLong2)
  {
    int i = 100;
    if ((paramsar != null) && (this.jdField_a_of_type_Rxq.jdField_a_of_type_AndroidWidgetSeekBar != null) && (this.jdField_a_of_type_Rxq.s != null) && (this.jdField_a_of_type_Rxq.u != null))
    {
      if (paramLong2 != 0L) {
        break label114;
      }
      if (this.e)
      {
        this.jdField_a_of_type_Rxq.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
        this.jdField_a_of_type_Rxq.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
    }
    label114:
    while (paramLong1 == 0L)
    {
      if (paramLong2 > 0L) {
        ryx.a(this.jdField_a_of_type_Rxq.u, paramLong2);
      }
      ryx.a(this.jdField_a_of_type_Rxq.t, this.jdField_a_of_type_Rxq.jdField_a_of_type_Sar.jdField_a_of_type_Sfb);
      return;
    }
    int j = (int)((float)paramLong1 * 100.0F / (float)paramLong2 + 0.5D);
    if (j + 1 >= 100) {}
    for (;;)
    {
      if (this.e)
      {
        this.jdField_a_of_type_Rxq.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
        this.jdField_a_of_type_Rxq.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
      }
      ryx.a(this.jdField_a_of_type_Rxq.s, paramLong1);
      break;
      i = j + 1;
    }
  }
  
  public void a(sar paramsar, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-1);
    if ((!this.f) && (!paramsar.c)) {
      a(0, 0);
    }
    this.f = false;
    if (paramBoolean)
    {
      a(1);
      return;
    }
    this.c = true;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-1, 1200L);
  }
  
  public void a(sar paramsar, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      this.f = true;
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.3(this));
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.4(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a(sar paramsar)
  {
    return this.d;
  }
  
  public void b(sar paramsar) {}
  
  public void b(sar paramsar, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      j(paramsar);
      a(8, 0);
      return;
    }
    a(paramsar, false);
  }
  
  public void c(sar paramsar)
  {
    j(paramsar);
  }
  
  public void d(sar paramsar)
  {
    a(0);
  }
  
  public void e(sar paramsar)
  {
    b(8);
    if ((paramsar != null) && (this.jdField_a_of_type_Rxq.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void f(sar paramsar)
  {
    this.f = false;
  }
  
  public void g(sar paramsar)
  {
    a(1);
  }
  
  public void h(sar paramsar)
  {
    if ((paramsar != null) && (paramsar.jdField_a_of_type_Sfb != null) && (paramsar.jdField_a_of_type_Sfb.e()))
    {
      a(0);
      return;
    }
    if ((paramsar != null) && (this.jdField_a_of_type_Rxq.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void i(sar paramsar)
  {
    a(0, 0);
    a(0);
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    long l;
    do
    {
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    } while (l <= 0L);
    double d1 = paramInt / 100.0D;
    paramInt = (int)(l * d1);
    ryx.a(this.jdField_a_of_type_Rxq.s, paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.d = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.d = false;
    int i = paramSeekBar.getProgress();
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    if (l > 0L)
    {
      i = (int)(i / 100.0D * l);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(i);
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sek
 * JD-Core Version:    0.7.0.1
 */
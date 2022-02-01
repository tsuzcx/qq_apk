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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sow
  implements SeekBar.OnSeekBarChangeListener, sfg
{
  private long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler;
  VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  public swm a;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e = true;
  private boolean f;
  private boolean g;
  
  public sow(swm paramswm, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Swm = paramswm;
    this.jdField_a_of_type_Swm.a.setOnSeekBarChangeListener(this);
    this.b = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new sox(this, Looper.getMainLooper());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Swm.jdField_c_of_type_ComTencentImageURLImageView == null) {
      return;
    }
    six.a(this.jdField_a_of_type_Swm.jdField_c_of_type_ComTencentImageURLImageView, paramInt1, paramInt2);
  }
  
  public static void a(TextView paramTextView, VideoInfo paramVideoInfo, spn paramspn)
  {
    six.a(paramTextView, paramspn, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.d, paramVideoInfo.jdField_a_of_type_Int, null);
  }
  
  private void b()
  {
    swr localswr = null;
    if ((this.jdField_a_of_type_Swm instanceof swr)) {
      localswr = (swr)this.jdField_a_of_type_Swm;
    }
    if ((localswr != null) && (localswr.c != null) && ((localswr.c.getDrawable() instanceof pta))) {
      ((pta)localswr.c.getDrawable()).playAnimation();
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
    this.jdField_a_of_type_Swm.g.clearAnimation();
    this.jdField_a_of_type_Swm.g.setVisibility(0);
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Swm.g.setBackgroundDrawable(sma.a(this.jdField_a_of_type_Swm.g.getContext(), 2130843292));
      this.jdField_a_of_type_Swm.g.clearAnimation();
      paramString = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      paramString.setDuration(500L);
      paramString.setRepeatCount(-1);
      paramString.setRepeatMode(1);
      paramString.setStartTime(-1L);
      paramString.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_Swm.g.startAnimation(paramString);
      this.jdField_a_of_type_Swm.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
      this.jdField_a_of_type_Swm.g.clearAnimation();
      this.jdField_a_of_type_Swm.g.setBackgroundDrawable(sma.a(this.jdField_a_of_type_Swm.g.getContext(), 2130843294));
      this.jdField_a_of_type_Swm.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
      this.jdField_a_of_type_Swm.g.clearAnimation();
      this.jdField_a_of_type_Swm.g.setBackgroundDrawable(sma.a(this.jdField_a_of_type_Swm.g.getContext(), 2130843294));
      this.jdField_a_of_type_Swm.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
      this.jdField_a_of_type_Swm.g.clearAnimation();
      this.jdField_a_of_type_Swm.g.setBackgroundDrawable(sma.a(this.jdField_a_of_type_Swm.g.getContext(), 2130843294));
      this.jdField_a_of_type_Swm.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
      this.jdField_a_of_type_Swm.g.clearAnimation();
      this.jdField_a_of_type_Swm.g.setBackgroundDrawable(sma.a(this.jdField_a_of_type_Swm.g.getContext(), 2130843293));
      this.jdField_a_of_type_Swm.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
      this.jdField_a_of_type_Swm.g.clearAnimation();
      this.jdField_a_of_type_Swm.g.setBackgroundDrawable(sma.a(this.jdField_a_of_type_Swm.g.getContext(), 2130843293));
      this.jdField_a_of_type_Swm.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    } while ((this.jdField_a_of_type_Swm.r.getVisibility() != 0) || (!NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())));
    this.jdField_a_of_type_Swm.g.setVisibility(0);
    this.jdField_a_of_type_Swm.r.setVisibility(8);
    this.jdField_a_of_type_Swm.t.setVisibility(8);
  }
  
  private boolean b(skq paramskq)
  {
    if (!NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())) {}
    while ((paramskq == null) || (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!this.jdField_a_of_type_Boolean) || (this.g)) {
      return false;
    }
    return true;
  }
  
  private void j(skq paramskq)
  {
    if (b(paramskq)) {
      a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    a(4);
    if (paramskq.jdField_a_of_type_AndroidViewView != null) {
      paramskq.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
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
      long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      j = (int)((float)l1 * 100.0F / (float)l2 + 0.5D);
      if (j + 1 < 100) {
        break label75;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Swm.a.setProgress(i);
      this.jdField_a_of_type_Swm.b.setProgress(i);
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
  
  public void a(VideoInfo paramVideoInfo)
  {
    String str;
    if (this.b) {
      str = anvx.a(2131715607);
    }
    for (;;)
    {
      paramVideoInfo = this.jdField_a_of_type_Swm.s;
      paramVideoInfo.setText(str);
      six.a(paramVideoInfo, 0);
      this.g = true;
      this.jdField_a_of_type_AndroidOsHandler.postAtTime(new VideoFeedsVideoUIDelegate.8(this, paramVideoInfo), Integer.valueOf(0), SystemClock.uptimeMillis() + 1000L);
      return;
      str = anvx.a(2131715503) + six.b(paramVideoInfo.b);
      if (paramVideoInfo.b <= 0L) {
        str = anvx.a(2131715610);
      }
    }
  }
  
  public void a(skq paramskq)
  {
    a(0);
  }
  
  public void a(skq paramskq, int paramInt1, int paramInt2, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = anvx.a(2131715578);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.2(this, str, paramskq));
  }
  
  public void a(skq paramskq, int paramInt, boolean paramBoolean)
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
      this.jdField_a_of_type_Swm.jdField_o_of_type_AndroidViewView.setVisibility(0);
      paramskq = new AlphaAnimation(0.0F, 1.0F);
      paramskq.setDuration(300L);
      paramskq.setStartOffset(paramInt);
      this.jdField_a_of_type_Swm.jdField_o_of_type_AndroidViewView.setAnimation(paramskq);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new soy(this));
      paramskq.setAnimationListener(new soz(this, localAlphaAnimation));
      paramskq.start();
      return;
      label113:
      paramInt = 0;
    }
  }
  
  public void a(skq paramskq, long paramLong1, long paramLong2)
  {
    int i = 100;
    if ((paramskq != null) && (this.jdField_a_of_type_Swm.a != null) && (this.jdField_a_of_type_Swm.jdField_o_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Swm.q != null))
    {
      if (paramLong2 != 0L) {
        break label112;
      }
      if (this.e)
      {
        this.jdField_a_of_type_Swm.a.setProgress(0);
        this.jdField_a_of_type_Swm.b.setProgress(0);
      }
    }
    label112:
    while (paramLong1 == 0L)
    {
      if (paramLong2 > 0L) {
        six.a(this.jdField_a_of_type_Swm.q, paramLong2);
      }
      a(this.jdField_a_of_type_Swm.p, paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramskq.jdField_a_of_type_Spn);
      return;
    }
    int j = (int)((float)paramLong1 * 100.0F / (float)paramLong2 + 0.5D);
    if (j + 1 >= 100) {}
    for (;;)
    {
      if (this.e)
      {
        this.jdField_a_of_type_Swm.a.setProgress(i);
        this.jdField_a_of_type_Swm.b.setProgress(i);
      }
      six.a(this.jdField_a_of_type_Swm.jdField_o_of_type_AndroidWidgetTextView, paramLong1);
      break;
      i = j + 1;
    }
  }
  
  public void a(skq paramskq, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-1);
    if ((!this.f) && (!paramskq.c)) {
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
  
  public void a(skq paramskq, boolean paramBoolean1, boolean paramBoolean2)
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
  
  public boolean a(skq paramskq)
  {
    return this.d;
  }
  
  public void b(skq paramskq) {}
  
  public void b(skq paramskq, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      j(paramskq);
      a(8, 0);
      return;
    }
    a(paramskq, false);
  }
  
  public void c(skq paramskq)
  {
    j(paramskq);
  }
  
  public void d(skq paramskq)
  {
    a(0);
  }
  
  public void e(skq paramskq)
  {
    b(8);
    if ((paramskq != null) && (this.jdField_a_of_type_Swm.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void f(skq paramskq)
  {
    this.f = false;
  }
  
  public void g(skq paramskq)
  {
    a(1);
  }
  
  public void h(skq paramskq)
  {
    if ((paramskq != null) && (paramskq.jdField_a_of_type_Spn != null) && (paramskq.jdField_a_of_type_Spn.e()))
    {
      a(0);
      return;
    }
    if ((paramskq != null) && (this.jdField_a_of_type_Swm.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void i(skq paramskq)
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
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
    } while (l <= 0L);
    double d1 = paramInt / 100.0D;
    paramInt = (int)(l * d1);
    six.a(this.jdField_a_of_type_Swm.jdField_o_of_type_AndroidWidgetTextView, paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.d = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.d = false;
    int i = paramSeekBar.getProgress();
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
    if (l > 0L)
    {
      i = (int)(i / 100.0D * l);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(i);
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sow
 * JD-Core Version:    0.7.0.1
 */
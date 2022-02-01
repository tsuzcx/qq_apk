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

public class scs
  implements SeekBar.OnSeekBarChangeListener, rsr
{
  private long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler;
  VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  public rvn a;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e = true;
  private boolean f;
  private boolean g;
  
  public scs(rvn paramrvn, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Rvn = paramrvn;
    this.jdField_a_of_type_Rvn.a.setOnSeekBarChangeListener(this);
    this.b = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new sct(this, Looper.getMainLooper());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Rvn.jdField_c_of_type_ComTencentImageURLImageView == null) {
      return;
    }
    rwv.a(this.jdField_a_of_type_Rvn.jdField_c_of_type_ComTencentImageURLImageView, paramInt1, paramInt2);
  }
  
  public static void a(TextView paramTextView, VideoInfo paramVideoInfo, sdj paramsdj)
  {
    rwv.a(paramTextView, paramsdj, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.d, paramVideoInfo.jdField_a_of_type_Int, null);
  }
  
  private void b()
  {
    rvs localrvs = null;
    if ((this.jdField_a_of_type_Rvn instanceof rvs)) {
      localrvs = (rvs)this.jdField_a_of_type_Rvn;
    }
    if ((localrvs != null) && (localrvs.d != null) && ((localrvs.d.getDrawable() instanceof pid))) {
      ((pid)localrvs.d.getDrawable()).playAnimation();
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
    this.jdField_a_of_type_Rvn.i.clearAnimation();
    this.jdField_a_of_type_Rvn.i.setVisibility(0);
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Rvn.i.setBackgroundDrawable(rzv.a(this.jdField_a_of_type_Rvn.i.getContext(), 2130843256));
      this.jdField_a_of_type_Rvn.i.clearAnimation();
      paramString = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      paramString.setDuration(500L);
      paramString.setRepeatCount(-1);
      paramString.setRepeatMode(1);
      paramString.setStartTime(-1L);
      paramString.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_Rvn.i.startAnimation(paramString);
      this.jdField_a_of_type_Rvn.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
      this.jdField_a_of_type_Rvn.i.clearAnimation();
      this.jdField_a_of_type_Rvn.i.setBackgroundDrawable(rzv.a(this.jdField_a_of_type_Rvn.i.getContext(), 2130843258));
      this.jdField_a_of_type_Rvn.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
      this.jdField_a_of_type_Rvn.i.clearAnimation();
      this.jdField_a_of_type_Rvn.i.setBackgroundDrawable(rzv.a(this.jdField_a_of_type_Rvn.i.getContext(), 2130843258));
      this.jdField_a_of_type_Rvn.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
      this.jdField_a_of_type_Rvn.i.clearAnimation();
      this.jdField_a_of_type_Rvn.i.setBackgroundDrawable(rzv.a(this.jdField_a_of_type_Rvn.i.getContext(), 2130843258));
      this.jdField_a_of_type_Rvn.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
      this.jdField_a_of_type_Rvn.i.clearAnimation();
      this.jdField_a_of_type_Rvn.i.setBackgroundDrawable(rzv.a(this.jdField_a_of_type_Rvn.i.getContext(), 2130843257));
      this.jdField_a_of_type_Rvn.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
      this.jdField_a_of_type_Rvn.i.clearAnimation();
      this.jdField_a_of_type_Rvn.i.setBackgroundDrawable(rzv.a(this.jdField_a_of_type_Rvn.i.getContext(), 2130843257));
      this.jdField_a_of_type_Rvn.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    } while ((this.jdField_a_of_type_Rvn.v.getVisibility() != 0) || (!NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())));
    this.jdField_a_of_type_Rvn.i.setVisibility(0);
    this.jdField_a_of_type_Rvn.v.setVisibility(8);
    this.jdField_a_of_type_Rvn.x.setVisibility(8);
  }
  
  private boolean b(ryo paramryo)
  {
    if (!NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())) {}
    while ((paramryo == null) || (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!this.jdField_a_of_type_Boolean) || (this.g)) {
      return false;
    }
    return true;
  }
  
  private void j(ryo paramryo)
  {
    if (b(paramryo)) {
      a(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    a(4);
    if (paramryo.jdField_a_of_type_AndroidViewView != null) {
      paramryo.jdField_a_of_type_AndroidViewView.setVisibility(0);
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
      this.jdField_a_of_type_Rvn.a.setProgress(i);
      this.jdField_a_of_type_Rvn.b.setProgress(i);
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
      str = amtj.a(2131715259);
    }
    for (;;)
    {
      paramVideoInfo = this.jdField_a_of_type_Rvn.w;
      paramVideoInfo.setText(str);
      rwv.a(paramVideoInfo, 0);
      this.g = true;
      this.jdField_a_of_type_AndroidOsHandler.postAtTime(new VideoFeedsVideoUIDelegate.8(this, paramVideoInfo), Integer.valueOf(0), SystemClock.uptimeMillis() + 1000L);
      return;
      str = amtj.a(2131715155) + rwv.b(paramVideoInfo.b);
      if (paramVideoInfo.b <= 0L) {
        str = amtj.a(2131715262);
      }
    }
  }
  
  public void a(ryo paramryo)
  {
    a(0);
  }
  
  public void a(ryo paramryo, int paramInt1, int paramInt2, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = amtj.a(2131715230);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.2(this, str, paramryo));
  }
  
  public void a(ryo paramryo, int paramInt, boolean paramBoolean)
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
      this.jdField_a_of_type_Rvn.q.setVisibility(0);
      paramryo = new AlphaAnimation(0.0F, 1.0F);
      paramryo.setDuration(300L);
      paramryo.setStartOffset(paramInt);
      this.jdField_a_of_type_Rvn.q.setAnimation(paramryo);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new scu(this));
      paramryo.setAnimationListener(new scv(this, localAlphaAnimation));
      paramryo.start();
      return;
      label113:
      paramInt = 0;
    }
  }
  
  public void a(ryo paramryo, long paramLong1, long paramLong2)
  {
    int i = 100;
    if ((paramryo != null) && (this.jdField_a_of_type_Rvn.a != null) && (this.jdField_a_of_type_Rvn.s != null) && (this.jdField_a_of_type_Rvn.u != null))
    {
      if (paramLong2 != 0L) {
        break label112;
      }
      if (this.e)
      {
        this.jdField_a_of_type_Rvn.a.setProgress(0);
        this.jdField_a_of_type_Rvn.b.setProgress(0);
      }
    }
    label112:
    while (paramLong1 == 0L)
    {
      if (paramLong2 > 0L) {
        rwv.a(this.jdField_a_of_type_Rvn.u, paramLong2);
      }
      a(this.jdField_a_of_type_Rvn.t, paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramryo.jdField_a_of_type_Sdj);
      return;
    }
    int j = (int)((float)paramLong1 * 100.0F / (float)paramLong2 + 0.5D);
    if (j + 1 >= 100) {}
    for (;;)
    {
      if (this.e)
      {
        this.jdField_a_of_type_Rvn.a.setProgress(i);
        this.jdField_a_of_type_Rvn.b.setProgress(i);
      }
      rwv.a(this.jdField_a_of_type_Rvn.s, paramLong1);
      break;
      i = j + 1;
    }
  }
  
  public void a(ryo paramryo, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-1);
    if ((!this.f) && (!paramryo.c)) {
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
  
  public void a(ryo paramryo, boolean paramBoolean1, boolean paramBoolean2)
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
  
  public boolean a(ryo paramryo)
  {
    return this.d;
  }
  
  public void b(ryo paramryo) {}
  
  public void b(ryo paramryo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      j(paramryo);
      a(8, 0);
      return;
    }
    a(paramryo, false);
  }
  
  public void c(ryo paramryo)
  {
    j(paramryo);
  }
  
  public void d(ryo paramryo)
  {
    a(0);
  }
  
  public void e(ryo paramryo)
  {
    b(8);
    if ((paramryo != null) && (this.jdField_a_of_type_Rvn.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void f(ryo paramryo)
  {
    this.f = false;
  }
  
  public void g(ryo paramryo)
  {
    a(1);
  }
  
  public void h(ryo paramryo)
  {
    if ((paramryo != null) && (paramryo.jdField_a_of_type_Sdj != null) && (paramryo.jdField_a_of_type_Sdj.e()))
    {
      a(0);
      return;
    }
    if ((paramryo != null) && (this.jdField_a_of_type_Rvn.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void i(ryo paramryo)
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
    rwv.a(this.jdField_a_of_type_Rvn.s, paramInt);
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
 * Qualified Name:     scs
 * JD-Core Version:    0.7.0.1
 */
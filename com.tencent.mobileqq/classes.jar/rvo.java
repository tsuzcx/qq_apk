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

public class rvo
  implements SeekBar.OnSeekBarChangeListener, rlr
{
  private long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler;
  VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  public rol a;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e = true;
  private boolean f;
  private boolean g;
  
  public rvo(rol paramrol, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Rol = paramrol;
    this.jdField_a_of_type_Rol.a.setOnSeekBarChangeListener(this);
    this.b = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new rvp(this, Looper.getMainLooper());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Rol.jdField_b_of_type_ComTencentImageURLImageView == null) {
      return;
    }
    rpt.a(this.jdField_a_of_type_Rol.jdField_b_of_type_ComTencentImageURLImageView, paramInt1, paramInt2);
  }
  
  public static void a(TextView paramTextView, VideoInfo paramVideoInfo, rwf paramrwf)
  {
    rpt.a(paramTextView, paramrwf, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.d, paramVideoInfo.jdField_a_of_type_Int, null);
  }
  
  private void b()
  {
    roq localroq = null;
    if ((this.jdField_a_of_type_Rol instanceof roq)) {
      localroq = (roq)this.jdField_a_of_type_Rol;
    }
    if ((localroq != null) && (localroq.d != null) && ((localroq.d.getDrawable() instanceof pcs))) {
      ((pcs)localroq.d.getDrawable()).playAnimation();
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
    this.jdField_a_of_type_Rol.i.clearAnimation();
    this.jdField_a_of_type_Rol.i.setVisibility(0);
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Rol.i.setBackgroundDrawable(rsr.a(this.jdField_a_of_type_Rol.i.getContext(), 2130843194));
      this.jdField_a_of_type_Rol.i.clearAnimation();
      paramString = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      paramString.setDuration(500L);
      paramString.setRepeatCount(-1);
      paramString.setRepeatMode(1);
      paramString.setStartTime(-1L);
      paramString.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_Rol.i.startAnimation(paramString);
      this.jdField_a_of_type_Rol.c.setVisibility(0);
      return;
      this.jdField_a_of_type_Rol.i.clearAnimation();
      this.jdField_a_of_type_Rol.i.setBackgroundDrawable(rsr.a(this.jdField_a_of_type_Rol.i.getContext(), 2130843196));
      this.jdField_a_of_type_Rol.c.setVisibility(0);
      return;
      this.jdField_a_of_type_Rol.i.clearAnimation();
      this.jdField_a_of_type_Rol.i.setBackgroundDrawable(rsr.a(this.jdField_a_of_type_Rol.i.getContext(), 2130843196));
      this.jdField_a_of_type_Rol.c.setVisibility(8);
      return;
      this.jdField_a_of_type_Rol.i.clearAnimation();
      this.jdField_a_of_type_Rol.i.setBackgroundDrawable(rsr.a(this.jdField_a_of_type_Rol.i.getContext(), 2130843196));
      this.jdField_a_of_type_Rol.c.setVisibility(0);
      return;
      this.jdField_a_of_type_Rol.i.clearAnimation();
      this.jdField_a_of_type_Rol.i.setBackgroundDrawable(rsr.a(this.jdField_a_of_type_Rol.i.getContext(), 2130843195));
      this.jdField_a_of_type_Rol.c.setVisibility(0);
      return;
      this.jdField_a_of_type_Rol.i.clearAnimation();
      this.jdField_a_of_type_Rol.i.setBackgroundDrawable(rsr.a(this.jdField_a_of_type_Rol.i.getContext(), 2130843195));
      this.jdField_a_of_type_Rol.c.setVisibility(8);
    } while ((this.jdField_a_of_type_Rol.v.getVisibility() != 0) || (!bhnv.b(BaseApplicationImpl.getContext())));
    this.jdField_a_of_type_Rol.i.setVisibility(0);
    this.jdField_a_of_type_Rol.v.setVisibility(8);
    this.jdField_a_of_type_Rol.x.setVisibility(8);
  }
  
  private boolean b(rrm paramrrm)
  {
    if (!bhnv.b(BaseApplicationImpl.getContext())) {}
    while ((paramrrm == null) || (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!this.jdField_a_of_type_Boolean) || (this.g)) {
      return false;
    }
    return true;
  }
  
  private void j(rrm paramrrm)
  {
    if (b(paramrrm)) {
      a(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    a(4);
    if (paramrrm.jdField_a_of_type_AndroidViewView != null) {
      paramrrm.jdField_a_of_type_AndroidViewView.setVisibility(0);
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
      long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      j = (int)((float)l1 * 100.0F / (float)l2 + 0.5D);
      if (j + 1 < 100) {
        break label75;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Rol.a.setProgress(i);
      this.jdField_a_of_type_Rol.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
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
      str = anzj.a(2131715025);
    }
    for (;;)
    {
      paramVideoInfo = this.jdField_a_of_type_Rol.w;
      paramVideoInfo.setText(str);
      rpt.a(paramVideoInfo, 0);
      this.g = true;
      this.jdField_a_of_type_AndroidOsHandler.postAtTime(new VideoFeedsVideoUIDelegate.8(this, paramVideoInfo), Integer.valueOf(0), SystemClock.uptimeMillis() + 1000L);
      return;
      str = anzj.a(2131714921) + rpt.b(paramVideoInfo.b);
      if (paramVideoInfo.b <= 0L) {
        str = anzj.a(2131715028);
      }
    }
  }
  
  public void a(rrm paramrrm)
  {
    a(0);
  }
  
  public void a(rrm paramrrm, int paramInt1, int paramInt2, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = anzj.a(2131714996);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.2(this, str, paramrrm));
  }
  
  public void a(rrm paramrrm, int paramInt, boolean paramBoolean)
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
      this.jdField_a_of_type_Rol.q.setVisibility(0);
      paramrrm = new AlphaAnimation(0.0F, 1.0F);
      paramrrm.setDuration(300L);
      paramrrm.setStartOffset(paramInt);
      this.jdField_a_of_type_Rol.q.setAnimation(paramrrm);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new rvq(this));
      paramrrm.setAnimationListener(new rvr(this, localAlphaAnimation));
      paramrrm.start();
      return;
      label113:
      paramInt = 0;
    }
  }
  
  public void a(rrm paramrrm, long paramLong1, long paramLong2)
  {
    int i = 100;
    if ((paramrrm != null) && (this.jdField_a_of_type_Rol.a != null) && (this.jdField_a_of_type_Rol.s != null) && (this.jdField_a_of_type_Rol.u != null))
    {
      if (paramLong2 != 0L) {
        break label112;
      }
      if (this.e)
      {
        this.jdField_a_of_type_Rol.a.setProgress(0);
        this.jdField_a_of_type_Rol.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
    }
    label112:
    while (paramLong1 == 0L)
    {
      if (paramLong2 > 0L) {
        rpt.a(this.jdField_a_of_type_Rol.u, paramLong2);
      }
      a(this.jdField_a_of_type_Rol.t, paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramrrm.jdField_a_of_type_Rwf);
      return;
    }
    int j = (int)((float)paramLong1 * 100.0F / (float)paramLong2 + 0.5D);
    if (j + 1 >= 100) {}
    for (;;)
    {
      if (this.e)
      {
        this.jdField_a_of_type_Rol.a.setProgress(i);
        this.jdField_a_of_type_Rol.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
      }
      rpt.a(this.jdField_a_of_type_Rol.s, paramLong1);
      break;
      i = j + 1;
    }
  }
  
  public void a(rrm paramrrm, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-1);
    if ((!this.f) && (!paramrrm.c)) {
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
  
  public void a(rrm paramrrm, boolean paramBoolean1, boolean paramBoolean2)
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
  
  public boolean a(rrm paramrrm)
  {
    return this.d;
  }
  
  public void b(rrm paramrrm) {}
  
  public void b(rrm paramrrm, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      j(paramrrm);
      a(8, 0);
      return;
    }
    a(paramrrm, false);
  }
  
  public void c(rrm paramrrm)
  {
    j(paramrrm);
  }
  
  public void d(rrm paramrrm)
  {
    a(0);
  }
  
  public void e(rrm paramrrm)
  {
    b(8);
    if ((paramrrm != null) && (this.jdField_a_of_type_Rol.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void f(rrm paramrrm)
  {
    this.f = false;
  }
  
  public void g(rrm paramrrm)
  {
    a(1);
  }
  
  public void h(rrm paramrrm)
  {
    if ((paramrrm != null) && (paramrrm.jdField_a_of_type_Rwf != null) && (paramrrm.jdField_a_of_type_Rwf.e()))
    {
      a(0);
      return;
    }
    if ((paramrrm != null) && (this.jdField_a_of_type_Rol.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void i(rrm paramrrm)
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
    rpt.a(this.jdField_a_of_type_Rol.s, paramInt);
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
 * Qualified Name:     rvo
 * JD-Core Version:    0.7.0.1
 */
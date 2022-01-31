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
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate.5;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate.6;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class qhf
  implements SeekBar.OnSeekBarChangeListener, pxw
{
  private long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler;
  VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  public qag a;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e = true;
  private boolean f;
  private boolean g;
  
  public qhf(qag paramqag, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Qag = paramqag;
    this.jdField_a_of_type_Qag.a.setOnSeekBarChangeListener(this);
    this.b = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new qhg(this, Looper.getMainLooper());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qag.jdField_b_of_type_ComTencentImageURLImageView == null) {
      return;
    }
    qcn.b(this.jdField_a_of_type_Qag.jdField_b_of_type_ComTencentImageURLImageView, paramInt1, paramInt2);
  }
  
  private static void a(TextView paramTextView, VideoInfo paramVideoInfo, qhw paramqhw)
  {
    bgmq.i(obz.a());
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    String str;
    if (this.b) {
      str = ajjy.a(2131650453);
    }
    for (;;)
    {
      paramVideoInfo = this.jdField_a_of_type_Qag.t;
      paramVideoInfo.setText(str);
      qcn.a(paramVideoInfo, 0);
      this.g = true;
      this.jdField_a_of_type_AndroidOsHandler.postAtTime(new VideoFeedsVideoUIDelegate.6(this, paramVideoInfo), Integer.valueOf(0), SystemClock.uptimeMillis() + 1000L);
      return;
      str = ajjy.a(2131650349) + qcn.b(paramVideoInfo.b);
      if (paramVideoInfo.b <= 0L) {
        str = ajjy.a(2131650456);
      }
    }
  }
  
  private void b()
  {
    qap localqap = null;
    if ((this.jdField_a_of_type_Qag instanceof qap)) {
      localqap = (qap)this.jdField_a_of_type_Qag;
    }
    if ((localqap != null) && (localqap.b != null) && ((localqap.b.getDrawable() instanceof oet))) {
      ((oet)localqap.b.getDrawable()).playAnimation();
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
    switch (paramInt)
    {
    default: 
    case 1: 
    case 0: 
    case 6: 
    case 5: 
    case 3: 
    case 4: 
      do
      {
        return;
        this.jdField_a_of_type_Qag.e.setBackgroundDrawable(qft.a(this.jdField_a_of_type_Qag.e.getContext(), 2130842554));
        this.jdField_a_of_type_Qag.e.clearAnimation();
        paramString = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        paramString.setDuration(500L);
        paramString.setRepeatCount(-1);
        paramString.setRepeatMode(1);
        paramString.setStartTime(-1L);
        paramString.setInterpolator(new LinearInterpolator());
        this.jdField_a_of_type_Qag.e.startAnimation(paramString);
        this.jdField_a_of_type_Qag.c.setVisibility(0);
        this.jdField_a_of_type_Qag.r.setText("");
        return;
        this.jdField_a_of_type_Qag.e.clearAnimation();
        this.jdField_a_of_type_Qag.e.setBackgroundDrawable(qft.a(this.jdField_a_of_type_Qag.e.getContext(), 2130842556));
        this.jdField_a_of_type_Qag.c.setVisibility(0);
        this.jdField_a_of_type_Qag.r.setText("");
        return;
        this.jdField_a_of_type_Qag.e.clearAnimation();
        this.jdField_a_of_type_Qag.e.setBackgroundDrawable(qft.a(this.jdField_a_of_type_Qag.e.getContext(), 2130842556));
        this.jdField_a_of_type_Qag.c.setVisibility(8);
        this.jdField_a_of_type_Qag.r.setText("");
        return;
        this.jdField_a_of_type_Qag.e.clearAnimation();
        this.jdField_a_of_type_Qag.e.setBackgroundDrawable(qft.a(this.jdField_a_of_type_Qag.e.getContext(), 2130842556));
        this.jdField_a_of_type_Qag.c.setVisibility(0);
        this.jdField_a_of_type_Qag.r.setText("");
        return;
        this.jdField_a_of_type_Qag.e.clearAnimation();
        this.jdField_a_of_type_Qag.e.setBackgroundDrawable(qft.a(this.jdField_a_of_type_Qag.e.getContext(), 2130842555));
        this.jdField_a_of_type_Qag.c.setVisibility(0);
        this.jdField_a_of_type_Qag.r.setText("");
        return;
        this.jdField_a_of_type_Qag.e.clearAnimation();
        this.jdField_a_of_type_Qag.e.setBackgroundDrawable(qft.a(this.jdField_a_of_type_Qag.e.getContext(), 2130842555));
        this.jdField_a_of_type_Qag.c.setVisibility(8);
        this.jdField_a_of_type_Qag.r.setText("");
      } while ((this.jdField_a_of_type_Qag.jdField_s_of_type_AndroidWidgetTextView.getVisibility() != 0) || (!badq.b(BaseApplicationImpl.getContext())));
      this.jdField_a_of_type_Qag.e.setVisibility(0);
      this.jdField_a_of_type_Qag.jdField_s_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_Qag.u.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Qag.e.clearAnimation();
    this.jdField_a_of_type_Qag.e.setBackgroundDrawable(qft.a(this.jdField_a_of_type_Qag.e.getContext(), 2130847451));
    this.jdField_a_of_type_Qag.c.setVisibility(0);
    this.jdField_a_of_type_Qag.r.setVisibility(0);
    this.jdField_a_of_type_Qag.r.setText(paramString);
  }
  
  private boolean b(qeq paramqeq)
  {
    if (!badq.b(BaseApplicationImpl.getContext())) {}
    while ((paramqeq == null) || (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!this.jdField_a_of_type_Boolean) || (this.g)) {
      return false;
    }
    return true;
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
      this.jdField_a_of_type_Qag.a.setProgress(i);
      this.jdField_a_of_type_Qag.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
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
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.5(this, paramInt, paramString));
  }
  
  public void a(qeq paramqeq)
  {
    if (b(paramqeq)) {
      a(paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    a(4);
    b(8);
    paramqeq.jdField_a_of_type_AndroidViewView.setVisibility(0);
    a(this.jdField_a_of_type_Qag.p, paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramqeq.jdField_a_of_type_Qhw);
    b();
  }
  
  public void a(qeq paramqeq, int paramInt1, int paramInt2, String paramString)
  {
    paramqeq = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramqeq = ajjy.a(2131650424);
    }
    a(2, paramqeq);
  }
  
  public void a(qeq paramqeq, int paramInt, boolean paramBoolean)
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
      this.jdField_a_of_type_Qag.jdField_s_of_type_AndroidViewView.setVisibility(0);
      paramqeq = new AlphaAnimation(0.0F, 1.0F);
      paramqeq.setDuration(300L);
      paramqeq.setStartOffset(paramInt);
      this.jdField_a_of_type_Qag.jdField_s_of_type_AndroidViewView.setAnimation(paramqeq);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new qhh(this));
      paramqeq.setAnimationListener(new qhi(this, localAlphaAnimation));
      paramqeq.start();
      return;
      label113:
      paramInt = 0;
    }
  }
  
  public void a(qeq paramqeq, long paramLong1, long paramLong2)
  {
    int i = 100;
    if ((paramqeq != null) && (this.jdField_a_of_type_Qag.a != null) && (this.jdField_a_of_type_Qag.o != null) && (this.jdField_a_of_type_Qag.q != null))
    {
      if (paramLong2 != 0L) {
        break label94;
      }
      if (this.e)
      {
        this.jdField_a_of_type_Qag.a.setProgress(0);
        this.jdField_a_of_type_Qag.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
    }
    label94:
    while (paramLong1 == 0L)
    {
      if (paramLong2 > 0L) {
        qcn.a(this.jdField_a_of_type_Qag.q, paramLong2);
      }
      return;
    }
    int j = (int)((float)paramLong1 * 100.0F / (float)paramLong2 + 0.5D);
    if (j + 1 >= 100) {}
    for (;;)
    {
      if (this.e)
      {
        this.jdField_a_of_type_Qag.a.setProgress(i);
        this.jdField_a_of_type_Qag.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
      }
      qcn.a(this.jdField_a_of_type_Qag.o, paramLong1);
      break;
      i = j + 1;
    }
  }
  
  public void a(qeq paramqeq, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-1);
    if (!this.f) {
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
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a(qeq paramqeq)
  {
    return this.d;
  }
  
  public void b(qeq paramqeq)
  {
    b(8);
    if ((paramqeq != null) && (this.jdField_a_of_type_Qag.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void b(qeq paramqeq, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.2(this, paramqeq, paramBoolean));
  }
  
  public void c(qeq paramqeq)
  {
    this.f = false;
  }
  
  public void d(qeq paramqeq)
  {
    a(0);
  }
  
  public void e(qeq paramqeq)
  {
    a(0);
  }
  
  public void f(qeq paramqeq) {}
  
  public void g(qeq paramqeq) {}
  
  public void h(qeq paramqeq)
  {
    a(1);
  }
  
  public void i(qeq paramqeq)
  {
    if ((paramqeq != null) && (paramqeq.jdField_a_of_type_Qhw != null) && (paramqeq.jdField_a_of_type_Qhw.c()))
    {
      a(0);
      return;
    }
    if ((paramqeq != null) && (this.jdField_a_of_type_Qag.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void j(qeq paramqeq)
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
    qcn.a(this.jdField_a_of_type_Qag.o, paramInt);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhf
 * JD-Core Version:    0.7.0.1
 */
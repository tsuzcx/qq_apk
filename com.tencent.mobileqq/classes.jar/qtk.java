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
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate.6;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate.7;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class qtk
  implements SeekBar.OnSeekBarChangeListener, qjv
{
  private long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler;
  VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  public qmi a;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e = true;
  private boolean f;
  private boolean g;
  
  public qtk(qmi paramqmi, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Qmi = paramqmi;
    this.jdField_a_of_type_Qmi.a.setOnSeekBarChangeListener(this);
    this.b = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new qtl(this, Looper.getMainLooper());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qmi.jdField_b_of_type_ComTencentImageURLImageView == null) {
      return;
    }
    qol.a(this.jdField_a_of_type_Qmi.jdField_b_of_type_ComTencentImageURLImageView, paramInt1, paramInt2);
  }
  
  public static void a(TextView paramTextView, VideoInfo paramVideoInfo, qub paramqub)
  {
    bhvh.i(onk.a());
    if (paramTextView != null) {
      paramTextView.setVisibility(8);
    }
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    String str;
    if (this.b) {
      str = ajyc.a(2131716244);
    }
    for (;;)
    {
      paramVideoInfo = this.jdField_a_of_type_Qmi.y;
      paramVideoInfo.setText(str);
      qol.a(paramVideoInfo, 0);
      this.g = true;
      this.jdField_a_of_type_AndroidOsHandler.postAtTime(new VideoFeedsVideoUIDelegate.7(this, paramVideoInfo), Integer.valueOf(0), SystemClock.uptimeMillis() + 1000L);
      return;
      str = ajyc.a(2131716140) + qol.b(paramVideoInfo.b);
      if (paramVideoInfo.b <= 0L) {
        str = ajyc.a(2131716247);
      }
    }
  }
  
  private void b()
  {
    qmr localqmr = null;
    if ((this.jdField_a_of_type_Qmi instanceof qmr)) {
      localqmr = (qmr)this.jdField_a_of_type_Qmi;
    }
    if ((localqmr != null) && (localqmr.b != null) && ((localqmr.b.getDrawable() instanceof oqe))) {
      ((oqe)localqmr.b.getDrawable()).playAnimation();
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
    this.jdField_a_of_type_Qmi.g.clearAnimation();
    this.jdField_a_of_type_Qmi.g.setVisibility(0);
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Qmi.g.setBackgroundDrawable(qrr.a(this.jdField_a_of_type_Qmi.g.getContext(), 2130842637));
      this.jdField_a_of_type_Qmi.g.clearAnimation();
      paramString = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      paramString.setDuration(500L);
      paramString.setRepeatCount(-1);
      paramString.setRepeatMode(1);
      paramString.setStartTime(-1L);
      paramString.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_Qmi.g.startAnimation(paramString);
      this.jdField_a_of_type_Qmi.c.setVisibility(0);
      return;
      this.jdField_a_of_type_Qmi.g.clearAnimation();
      this.jdField_a_of_type_Qmi.g.setBackgroundDrawable(qrr.a(this.jdField_a_of_type_Qmi.g.getContext(), 2130842639));
      this.jdField_a_of_type_Qmi.c.setVisibility(0);
      return;
      this.jdField_a_of_type_Qmi.g.clearAnimation();
      this.jdField_a_of_type_Qmi.g.setBackgroundDrawable(qrr.a(this.jdField_a_of_type_Qmi.g.getContext(), 2130842639));
      this.jdField_a_of_type_Qmi.c.setVisibility(8);
      return;
      this.jdField_a_of_type_Qmi.g.clearAnimation();
      this.jdField_a_of_type_Qmi.g.setBackgroundDrawable(qrr.a(this.jdField_a_of_type_Qmi.g.getContext(), 2130842639));
      this.jdField_a_of_type_Qmi.c.setVisibility(0);
      return;
      this.jdField_a_of_type_Qmi.g.clearAnimation();
      this.jdField_a_of_type_Qmi.g.setBackgroundDrawable(qrr.a(this.jdField_a_of_type_Qmi.g.getContext(), 2130842638));
      this.jdField_a_of_type_Qmi.c.setVisibility(0);
      return;
      this.jdField_a_of_type_Qmi.g.clearAnimation();
      this.jdField_a_of_type_Qmi.g.setBackgroundDrawable(qrr.a(this.jdField_a_of_type_Qmi.g.getContext(), 2130842638));
      this.jdField_a_of_type_Qmi.c.setVisibility(8);
    } while ((this.jdField_a_of_type_Qmi.x.getVisibility() != 0) || (!bbev.b(BaseApplicationImpl.getContext())));
    this.jdField_a_of_type_Qmi.g.setVisibility(0);
    this.jdField_a_of_type_Qmi.x.setVisibility(8);
    this.jdField_a_of_type_Qmi.z.setVisibility(8);
  }
  
  private boolean b(qqo paramqqo)
  {
    if (!bbev.b(BaseApplicationImpl.getContext())) {}
    while ((paramqqo == null) || (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!this.jdField_a_of_type_Boolean) || (this.g)) {
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
      this.jdField_a_of_type_Qmi.a.setProgress(i);
      this.jdField_a_of_type_Qmi.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
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
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.6(this, paramInt, paramString));
  }
  
  public void a(qqo paramqqo)
  {
    if (b(paramqqo)) {
      a(paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    a(4);
    b(8);
    paramqqo.jdField_a_of_type_AndroidViewView.setVisibility(0);
    a(this.jdField_a_of_type_Qmi.v, paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramqqo.jdField_a_of_type_Qub);
    b();
  }
  
  public void a(qqo paramqqo, int paramInt1, int paramInt2, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = ajyc.a(2131716215);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.2(this, str, paramqqo));
  }
  
  public void a(qqo paramqqo, int paramInt, boolean paramBoolean)
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
      this.jdField_a_of_type_Qmi.s.setVisibility(0);
      paramqqo = new AlphaAnimation(0.0F, 1.0F);
      paramqqo.setDuration(300L);
      paramqqo.setStartOffset(paramInt);
      this.jdField_a_of_type_Qmi.s.setAnimation(paramqqo);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new qtm(this));
      paramqqo.setAnimationListener(new qtn(this, localAlphaAnimation));
      paramqqo.start();
      return;
      label113:
      paramInt = 0;
    }
  }
  
  public void a(qqo paramqqo, long paramLong1, long paramLong2)
  {
    int i = 100;
    if ((paramqqo != null) && (this.jdField_a_of_type_Qmi.a != null) && (this.jdField_a_of_type_Qmi.u != null) && (this.jdField_a_of_type_Qmi.w != null))
    {
      if (paramLong2 != 0L) {
        break label94;
      }
      if (this.e)
      {
        this.jdField_a_of_type_Qmi.a.setProgress(0);
        this.jdField_a_of_type_Qmi.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
    }
    label94:
    while (paramLong1 == 0L)
    {
      if (paramLong2 > 0L) {
        qol.a(this.jdField_a_of_type_Qmi.w, paramLong2);
      }
      return;
    }
    int j = (int)((float)paramLong1 * 100.0F / (float)paramLong2 + 0.5D);
    if (j + 1 >= 100) {}
    for (;;)
    {
      if (this.e)
      {
        this.jdField_a_of_type_Qmi.a.setProgress(i);
        this.jdField_a_of_type_Qmi.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
      }
      qol.a(this.jdField_a_of_type_Qmi.u, paramLong1);
      break;
      i = j + 1;
    }
  }
  
  public void a(qqo paramqqo, boolean paramBoolean)
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
  
  public boolean a(qqo paramqqo)
  {
    return this.d;
  }
  
  public void b(qqo paramqqo)
  {
    b(8);
    if ((paramqqo != null) && (this.jdField_a_of_type_Qmi.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void b(qqo paramqqo, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.3(this, paramqqo, paramBoolean));
  }
  
  public void c(qqo paramqqo)
  {
    this.f = false;
  }
  
  public void d(qqo paramqqo)
  {
    a(0);
  }
  
  public void e(qqo paramqqo)
  {
    a(0);
  }
  
  public void f(qqo paramqqo) {}
  
  public void g(qqo paramqqo) {}
  
  public void h(qqo paramqqo)
  {
    a(1);
  }
  
  public void i(qqo paramqqo)
  {
    if ((paramqqo != null) && (paramqqo.jdField_a_of_type_Qub != null) && (paramqqo.jdField_a_of_type_Qub.d()))
    {
      a(0);
      return;
    }
    if ((paramqqo != null) && (this.jdField_a_of_type_Qmi.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void j(qqo paramqqo)
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
    qol.a(this.jdField_a_of_type_Qmi.u, paramInt);
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
 * Qualified Name:     qtk
 * JD-Core Version:    0.7.0.1
 */
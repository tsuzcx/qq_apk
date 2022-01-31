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

public class riw
  implements SeekBar.OnSeekBarChangeListener, qyz
{
  private long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler;
  VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  public rbn a;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e = true;
  private boolean f;
  private boolean g;
  
  public riw(rbn paramrbn, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Rbn = paramrbn;
    this.jdField_a_of_type_Rbn.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
    this.b = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new rix(this, Looper.getMainLooper());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Rbn.jdField_b_of_type_ComTencentImageURLImageView == null) {
      return;
    }
    rdm.a(this.jdField_a_of_type_Rbn.jdField_b_of_type_ComTencentImageURLImageView, paramInt1, paramInt2);
  }
  
  public static void a(TextView paramTextView, VideoInfo paramVideoInfo, rjn paramrjn)
  {
    rdm.a(paramTextView, paramrjn, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.d, paramVideoInfo.jdField_a_of_type_Int);
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    String str;
    if (this.b) {
      str = alpo.a(2131716627);
    }
    for (;;)
    {
      paramVideoInfo = this.jdField_a_of_type_Rbn.y;
      paramVideoInfo.setText(str);
      rdm.a(paramVideoInfo, 0);
      this.g = true;
      this.jdField_a_of_type_AndroidOsHandler.postAtTime(new VideoFeedsVideoUIDelegate.7(this, paramVideoInfo), Integer.valueOf(0), SystemClock.uptimeMillis() + 1000L);
      return;
      str = alpo.a(2131716523) + rdm.b(paramVideoInfo.b);
      if (paramVideoInfo.b <= 0L) {
        str = alpo.a(2131716630);
      }
    }
  }
  
  private void b()
  {
    rbs localrbs = null;
    if ((this.jdField_a_of_type_Rbn instanceof rbs)) {
      localrbs = (rbs)this.jdField_a_of_type_Rbn;
    }
    if ((localrbs != null) && (localrbs.b != null) && ((localrbs.b.getDrawable() instanceof out))) {
      ((out)localrbs.b.getDrawable()).playAnimation();
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
    this.jdField_a_of_type_Rbn.g.clearAnimation();
    this.jdField_a_of_type_Rbn.g.setVisibility(0);
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Rbn.g.setBackgroundDrawable(rha.a(this.jdField_a_of_type_Rbn.g.getContext(), 2130842821));
      this.jdField_a_of_type_Rbn.g.clearAnimation();
      paramString = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      paramString.setDuration(500L);
      paramString.setRepeatCount(-1);
      paramString.setRepeatMode(1);
      paramString.setStartTime(-1L);
      paramString.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_Rbn.g.startAnimation(paramString);
      this.jdField_a_of_type_Rbn.c.setVisibility(0);
      return;
      this.jdField_a_of_type_Rbn.g.clearAnimation();
      this.jdField_a_of_type_Rbn.g.setBackgroundDrawable(rha.a(this.jdField_a_of_type_Rbn.g.getContext(), 2130842823));
      this.jdField_a_of_type_Rbn.c.setVisibility(0);
      return;
      this.jdField_a_of_type_Rbn.g.clearAnimation();
      this.jdField_a_of_type_Rbn.g.setBackgroundDrawable(rha.a(this.jdField_a_of_type_Rbn.g.getContext(), 2130842823));
      this.jdField_a_of_type_Rbn.c.setVisibility(8);
      return;
      this.jdField_a_of_type_Rbn.g.clearAnimation();
      this.jdField_a_of_type_Rbn.g.setBackgroundDrawable(rha.a(this.jdField_a_of_type_Rbn.g.getContext(), 2130842823));
      this.jdField_a_of_type_Rbn.c.setVisibility(0);
      return;
      this.jdField_a_of_type_Rbn.g.clearAnimation();
      this.jdField_a_of_type_Rbn.g.setBackgroundDrawable(rha.a(this.jdField_a_of_type_Rbn.g.getContext(), 2130842822));
      this.jdField_a_of_type_Rbn.c.setVisibility(0);
      return;
      this.jdField_a_of_type_Rbn.g.clearAnimation();
      this.jdField_a_of_type_Rbn.g.setBackgroundDrawable(rha.a(this.jdField_a_of_type_Rbn.g.getContext(), 2130842822));
      this.jdField_a_of_type_Rbn.c.setVisibility(8);
    } while ((this.jdField_a_of_type_Rbn.x.getVisibility() != 0) || (!bdee.b(BaseApplicationImpl.getContext())));
    this.jdField_a_of_type_Rbn.g.setVisibility(0);
    this.jdField_a_of_type_Rbn.x.setVisibility(8);
    this.jdField_a_of_type_Rbn.z.setVisibility(8);
  }
  
  private boolean b(rfs paramrfs)
  {
    if (!bdee.b(BaseApplicationImpl.getContext())) {}
    while ((paramrfs == null) || (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!this.jdField_a_of_type_Boolean) || (this.g)) {
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
      this.jdField_a_of_type_Rbn.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
      this.jdField_a_of_type_Rbn.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
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
  
  public void a(rfs paramrfs)
  {
    if (b(paramrfs)) {
      a(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    a(4);
    b(8);
    paramrfs.jdField_a_of_type_AndroidViewView.setVisibility(0);
    a(this.jdField_a_of_type_Rbn.v, paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramrfs.jdField_a_of_type_Rjn);
    b();
  }
  
  public void a(rfs paramrfs, int paramInt1, int paramInt2, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = alpo.a(2131716598);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.2(this, str, paramrfs));
  }
  
  public void a(rfs paramrfs, int paramInt, boolean paramBoolean)
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
      this.jdField_a_of_type_Rbn.s.setVisibility(0);
      paramrfs = new AlphaAnimation(0.0F, 1.0F);
      paramrfs.setDuration(300L);
      paramrfs.setStartOffset(paramInt);
      this.jdField_a_of_type_Rbn.s.setAnimation(paramrfs);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new riy(this));
      paramrfs.setAnimationListener(new riz(this, localAlphaAnimation));
      paramrfs.start();
      return;
      label113:
      paramInt = 0;
    }
  }
  
  public void a(rfs paramrfs, long paramLong1, long paramLong2)
  {
    int i = 100;
    if ((paramrfs != null) && (this.jdField_a_of_type_Rbn.jdField_a_of_type_AndroidWidgetSeekBar != null) && (this.jdField_a_of_type_Rbn.u != null) && (this.jdField_a_of_type_Rbn.w != null))
    {
      if (paramLong2 != 0L) {
        break label114;
      }
      if (this.e)
      {
        this.jdField_a_of_type_Rbn.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
        this.jdField_a_of_type_Rbn.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
    }
    label114:
    while (paramLong1 == 0L)
    {
      if (paramLong2 > 0L) {
        rdm.a(this.jdField_a_of_type_Rbn.w, paramLong2);
      }
      rdm.a(this.jdField_a_of_type_Rbn.v, this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn);
      return;
    }
    int j = (int)((float)paramLong1 * 100.0F / (float)paramLong2 + 0.5D);
    if (j + 1 >= 100) {}
    for (;;)
    {
      if (this.e)
      {
        this.jdField_a_of_type_Rbn.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
        this.jdField_a_of_type_Rbn.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
      }
      rdm.a(this.jdField_a_of_type_Rbn.u, paramLong1);
      break;
      i = j + 1;
    }
  }
  
  public void a(rfs paramrfs, boolean paramBoolean)
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
  
  public boolean a(rfs paramrfs)
  {
    return this.d;
  }
  
  public void b(rfs paramrfs)
  {
    b(8);
    if ((paramrfs != null) && (this.jdField_a_of_type_Rbn.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void b(rfs paramrfs, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.3(this, paramrfs, paramBoolean));
  }
  
  public void c(rfs paramrfs)
  {
    this.f = false;
  }
  
  public void d(rfs paramrfs)
  {
    a(0);
  }
  
  public void e(rfs paramrfs)
  {
    a(0);
  }
  
  public void f(rfs paramrfs) {}
  
  public void g(rfs paramrfs) {}
  
  public void h(rfs paramrfs)
  {
    a(1);
  }
  
  public void i(rfs paramrfs)
  {
    if ((paramrfs != null) && (paramrfs.jdField_a_of_type_Rjn != null) && (paramrfs.jdField_a_of_type_Rjn.d()))
    {
      a(0);
      return;
    }
    if ((paramrfs != null) && (this.jdField_a_of_type_Rbn.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void j(rfs paramrfs)
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
    rdm.a(this.jdField_a_of_type_Rbn.u, paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     riw
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoViewUIDelegate.4;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoViewUIDelegate.5;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class qyg
  implements SeekBar.OnSeekBarChangeListener, qjs
{
  private static HashMap<Integer, Drawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private long jdField_a_of_type_Long;
  protected Handler a;
  protected VideoFeedsPlayManager a;
  protected qyk a;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e = true;
  private boolean f;
  private boolean g;
  
  public qyg(qyk paramqyk, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Qyk = paramqyk;
    this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
    this.b = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new qyh(this, Looper.getMainLooper());
  }
  
  private static Drawable a(Context paramContext, int paramInt)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {}
    do
    {
      return null;
      if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        return (Drawable)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
      try
      {
        paramContext = paramContext.getResources().getDrawable(paramInt);
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramContext);
        return paramContext;
      }
      catch (OutOfMemoryError paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("VideoFeedsVideoUIDelegate", 2, "innerGetDrawableFromCache() OutOfMemoryError e=" + paramContext.getMessage());
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qyk.jdField_a_of_type_ComTencentImageURLImageView == null) {
      return;
    }
    qoi.a(this.jdField_a_of_type_Qyk.jdField_a_of_type_ComTencentImageURLImageView, paramInt1, paramInt2);
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    String str;
    if (this.b) {
      str = "正在使用免流量播放";
    }
    for (;;)
    {
      paramVideoInfo = this.jdField_a_of_type_Qyk.c;
      paramVideoInfo.setText(str);
      qoi.a(paramVideoInfo, 0);
      this.g = true;
      this.jdField_a_of_type_AndroidOsHandler.postAtTime(new MultiVideoViewUIDelegate.5(this, paramVideoInfo), Integer.valueOf(0), SystemClock.uptimeMillis() + 1000L);
      return;
      str = "正在使用流量播放，约" + qoi.b(paramVideoInfo.b);
      if (paramVideoInfo.b <= 0L) {
        str = "正在使用流量播放";
      }
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
        this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(a(this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.getContext(), 2130842638));
        this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        paramString = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        paramString.setDuration(500L);
        paramString.setRepeatCount(-1);
        paramString.setRepeatMode(1);
        paramString.setStartTime(-1L);
        paramString.setInterpolator(new LinearInterpolator());
        this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.startAnimation(paramString);
        this.jdField_a_of_type_Qyk.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_Qyk.d.setText("");
        return;
        this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(a(this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.getContext(), 2130842640));
        this.jdField_a_of_type_Qyk.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_Qyk.d.setText("");
        return;
        this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(a(this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.getContext(), 2130842640));
        this.jdField_a_of_type_Qyk.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        this.jdField_a_of_type_Qyk.d.setText("");
        return;
        this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(a(this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.getContext(), 2130842640));
        this.jdField_a_of_type_Qyk.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_Qyk.d.setText("");
        return;
        this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(a(this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.getContext(), 2130842639));
        this.jdField_a_of_type_Qyk.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_Qyk.d.setText("");
        return;
        this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(a(this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.getContext(), 2130842639));
        this.jdField_a_of_type_Qyk.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        this.jdField_a_of_type_Qyk.d.setText("");
      } while ((this.jdField_a_of_type_Qyk.e.getVisibility() != 0) || (!bbfj.b(BaseApplicationImpl.getContext())));
      this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_Qyk.e.setVisibility(8);
      this.jdField_a_of_type_Qyk.f.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(a(this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetImageView.getContext(), 2130847683));
    this.jdField_a_of_type_Qyk.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_Qyk.d.setVisibility(0);
    this.jdField_a_of_type_Qyk.d.setText(paramString);
  }
  
  private boolean b(qql paramqql)
  {
    if (!bbfj.b(BaseApplicationImpl.getContext())) {}
    while ((paramqql == null) || (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!this.jdField_a_of_type_Boolean) || (this.g)) {
      return false;
    }
    return true;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public VideoFeedsPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
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
      this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
      this.jdField_a_of_type_Qyk.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
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
    this.jdField_a_of_type_AndroidOsHandler.post(new MultiVideoViewUIDelegate.4(this, paramInt, paramString));
  }
  
  public void a(qql paramqql)
  {
    if (b(paramqql)) {
      a(paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    a(4);
    b(8);
    paramqql.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidViewView.clearAnimation();
      this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void a(qql paramqql, int paramInt1, int paramInt2, String paramString)
  {
    paramqql = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramqql = "视频加载失败，请点击重试";
    }
    a(2, paramqql);
  }
  
  public void a(qql paramqql, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidViewView != null))
    {
      if (paramInt <= 300) {
        break label123;
      }
      paramInt -= 300;
    }
    for (;;)
    {
      this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramqql = new AlphaAnimation(0.0F, 1.0F);
      paramqql.setDuration(300L);
      paramqql.setStartOffset(paramInt);
      this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidViewView.setAnimation(paramqql);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new qyi(this));
      paramqql.setAnimationListener(new qyj(this, localAlphaAnimation));
      paramqql.start();
      return;
      label123:
      paramInt = 0;
    }
  }
  
  public void a(qql paramqql, long paramLong1, long paramLong2)
  {
    int i = 100;
    if ((paramqql != null) && (this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetSeekBar != null) && (this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Qyk.jdField_b_of_type_AndroidWidgetTextView != null))
    {
      if (paramLong2 != 0L) {
        break label94;
      }
      if (this.e)
      {
        this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
        this.jdField_a_of_type_Qyk.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
    }
    label94:
    while (paramLong1 == 0L)
    {
      if (paramLong2 > 0L) {
        qoi.a(this.jdField_a_of_type_Qyk.jdField_b_of_type_AndroidWidgetTextView, paramLong2);
      }
      return;
    }
    int j = (int)((float)paramLong1 * 100.0F / (float)paramLong2 + 0.5D);
    if (j + 1 >= 100) {}
    for (;;)
    {
      if (this.e)
      {
        this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
        this.jdField_a_of_type_Qyk.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i);
      }
      qoi.a(this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetTextView, paramLong1);
      break;
      i = j + 1;
    }
  }
  
  public void a(qql paramqql, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-1);
    this.jdField_a_of_type_Qyk.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
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
  
  public boolean a(qql paramqql)
  {
    return this.d;
  }
  
  public void b(qql paramqql)
  {
    b(8);
    if ((paramqql != null) && (this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void b(qql paramqql, boolean paramBoolean) {}
  
  public void c(qql paramqql)
  {
    this.f = false;
    a(0);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-1);
    this.jdField_a_of_type_Qyk.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    if (this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidViewView.clearAnimation();
      this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void d(qql paramqql)
  {
    a(0);
  }
  
  public void e(qql paramqql)
  {
    a(0);
  }
  
  public void f(qql paramqql)
  {
    a(0, 0);
  }
  
  public void g(qql paramqql) {}
  
  public void h(qql paramqql)
  {
    a(1);
  }
  
  public void i(qql paramqql)
  {
    if ((paramqql != null) && (paramqql.jdField_a_of_type_Qty != null) && (paramqql.jdField_a_of_type_Qty.d()))
    {
      a(0);
      return;
    }
    if ((paramqql != null) && (this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void j(qql paramqql)
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
    qoi.a(this.jdField_a_of_type_Qyk.jdField_a_of_type_AndroidWidgetTextView, paramInt);
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
 * Qualified Name:     qyg
 * JD-Core Version:    0.7.0.1
 */
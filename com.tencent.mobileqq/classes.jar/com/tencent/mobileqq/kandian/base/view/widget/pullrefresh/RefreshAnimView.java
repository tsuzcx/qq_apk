package com.tencent.mobileqq.kandian.base.view.widget.pullrefresh;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;

public class RefreshAnimView
  extends RelativeLayout
{
  private ImageView a;
  private TextView b;
  private RefreshEyeView c;
  private LottieComposition d;
  private Handler e = new Handler(Looper.getMainLooper());
  private long f = 100L;
  
  public RefreshAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate(paramContext, 2131629140, this);
    this.a = ((ImageView)findViewById(2131437752));
    this.b = ((TextView)findViewById(2131444564));
    this.c = ((RefreshEyeView)findViewById(2131444558));
    this.c.b();
    ThreadManager.excute(new RefreshAnimView.1(this, paramContext), 64, null, true);
  }
  
  public void a()
  {
    this.c.b();
    this.c.clearAnimation();
    this.c.setScaleX(1.0F);
    this.c.setScaleY(1.0F);
    this.a.setImageDrawable(null);
    this.b.clearAnimation();
    this.b.setText("");
    this.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.e.removeCallbacksAndMessages(null);
  }
  
  public void a(double paramDouble)
  {
    if (this.c.getVisibility() != 0) {
      this.c.setVisibility(0);
    }
    this.c.setWaveHeightPercent(paramDouble);
  }
  
  public void a(long paramLong)
  {
    this.e.postDelayed(new RefreshAnimView.2(this), paramLong);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setAnimationListener(new RefreshAnimView.3(this, paramString, paramBoolean));
    this.c.startAnimation(localScaleAnimation);
  }
  
  public void b()
  {
    this.c.a();
    if (this.c.getVisibility() != 0) {
      this.c.setVisibility(0);
    }
  }
  
  public void setRefreshBarStayTimeMS(long paramLong)
  {
    this.f = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.RefreshAnimView
 * JD-Core Version:    0.7.0.1
 */
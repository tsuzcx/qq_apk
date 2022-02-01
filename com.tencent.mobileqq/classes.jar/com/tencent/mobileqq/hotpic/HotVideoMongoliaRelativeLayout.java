package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class HotVideoMongoliaRelativeLayout
  extends RelativeLayout
  implements View.OnTouchListener
{
  public static final String a = HardCodeUtil.a(2131903594);
  public static final String b = HardCodeUtil.a(2131903590);
  public static final String c = HardCodeUtil.a(2131903592);
  public static final String d = HardCodeUtil.a(2131903593);
  final float e = 1.777778F;
  public HotVideoMongoliaRelativeLayout.VideoInfo f;
  public View g;
  public CircleProgressView h;
  ProgressBar i;
  public int j = 0;
  HotVideoMongoliaRelativeLayout.PresenceInterface k;
  public Size l = null;
  boolean m = false;
  HotVideoMongoliaRelativeLayout.InnerOnClickListener n;
  private View o;
  private TextView p;
  private RelativeLayout q;
  private RelativeLayout r;
  private ImageView s;
  private HotVideoData t = null;
  private HotVideoMongoliaRelativeLayout.OnVidoeControlListener u;
  private HotVideoMongoliaRelativeLayout.OnVideoControlStateListener v;
  private boolean w = true;
  private VelocityTracker x = null;
  
  public HotVideoMongoliaRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HotVideoMongoliaRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HotVideoMongoliaRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 != -11)
    {
      if (paramInt2 != 2)
      {
        if (paramInt2 != 3)
        {
          if (paramInt2 != 4)
          {
            if (paramInt2 != 5)
            {
              if (paramInt2 == 6)
              {
                this.o.setVisibility(8);
                this.q.setVisibility(0);
                this.r.setVisibility(8);
                this.h.setVisibility(0);
                this.i.setVisibility(0);
              }
            }
            else
            {
              this.o.setVisibility(8);
              this.q.setVisibility(0);
              this.r.setVisibility(0);
              this.h.setVisibility(8);
              this.i.setVisibility(0);
            }
          }
          else
          {
            this.o.setVisibility(0);
            this.q.setVisibility(0);
            this.r.setVisibility(8);
            this.h.setVisibility(8);
            this.i.setVisibility(0);
          }
        }
        else
        {
          this.o.setVisibility(8);
          this.q.setVisibility(0);
          this.r.setVisibility(0);
          this.h.setVisibility(8);
          this.i.setVisibility(0);
        }
      }
      else
      {
        this.o.setVisibility(0);
        this.q.setVisibility(8);
        this.r.setVisibility(8);
        this.h.setVisibility(8);
        this.i.setVisibility(8);
      }
    }
    else
    {
      this.o.setVisibility(8);
      this.q.setVisibility(8);
      this.r.setVisibility(8);
      this.h.setVisibility(8);
      this.i.setVisibility(8);
    }
    HotVideoMongoliaRelativeLayout.OnVideoControlStateListener localOnVideoControlStateListener = this.v;
    if (localOnVideoControlStateListener != null) {
      localOnVideoControlStateListener.c(paramInt2);
    }
  }
  
  private void b(HotVideoMongoliaRelativeLayout.PresenceInterface paramPresenceInterface, HotVideoMongoliaRelativeLayout.VideoInfo paramVideoInfo)
  {
    this.k = paramPresenceInterface;
    this.f = paramVideoInfo;
    this.k.a(this);
  }
  
  private void g()
  {
    if (this.g == null)
    {
      this.g = VideoBaseItem.a(getContext());
      if (this.g == null)
      {
        b(-11);
        return;
      }
      if (Build.VERSION.SDK_INT >= 16) {
        this.g.setBackgroundColor(0);
      } else {
        this.g.setBackgroundDrawable(new ColorDrawable(0));
      }
      FrameLayout localFrameLayout = (FrameLayout)findViewById(2131446192);
      localFrameLayout.removeAllViews();
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.f.e, -1);
      localFrameLayout.addView(this.g, localLayoutParams);
    }
    this.g.setVisibility(8);
  }
  
  private void h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mVideoTitle is");
    localStringBuilder.append(this.f.a);
    QLog.d("HotVideoRelativeLayout", 2, localStringBuilder.toString());
    this.q = ((RelativeLayout)findViewById(2131445572));
    this.p = ((TextView)findViewById(2131445571));
    this.o = findViewById(2131449617);
    this.h = ((CircleProgressView)findViewById(2131432094));
    this.i = ((ProgressBar)findViewById(2131440663));
    this.i.setMax(10000);
    this.r = ((RelativeLayout)findViewById(2131449491));
    this.s = ((ImageView)findViewById(2131449490));
    g();
    b(2);
    setOnTouchListener(this);
    setOnClickListener(new HotVideoMongoliaRelativeLayout.1(this));
    this.q.setOnClickListener(new HotVideoMongoliaRelativeLayout.2(this));
    this.r.setOnClickListener(new HotVideoMongoliaRelativeLayout.3(this));
  }
  
  public void a()
  {
    HotVideoMongoliaRelativeLayout.PresenceInterface localPresenceInterface = this.k;
    if (localPresenceInterface == null) {
      return;
    }
    int i1 = this.j;
    if (i1 == 6)
    {
      localPresenceInterface.a(7, this);
      return;
    }
    if (i1 == 3) {
      localPresenceInterface.a(8, this);
    }
  }
  
  public void a(int paramInt)
  {
    ProgressBar localProgressBar = this.i;
    if (localProgressBar != null) {
      localProgressBar.setProgress(paramInt);
    }
  }
  
  public void a(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F;
    if (this.o.getVisibility() == 0) {
      this.o.setAlpha(f1);
    }
  }
  
  public void a(String paramString)
  {
    HotVideoMongoliaRelativeLayout.OnVideoControlStateListener localOnVideoControlStateListener = this.v;
    if (localOnVideoControlStateListener != null) {
      localOnVideoControlStateListener.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.s != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 2130838046;
      } else {
        i1 = 2130838047;
      }
      this.s.setImageDrawable(getContext().getResources().getDrawable(i1));
      localObject = this.s;
      if (paramBoolean) {
        i1 = 2131903595;
      } else {
        i1 = 2131903596;
      }
      ((ImageView)localObject).setContentDescription(HardCodeUtil.a(i1));
    }
    Object localObject = this.k;
    if (localObject != null) {
      ((HotVideoMongoliaRelativeLayout.PresenceInterface)localObject).a(paramBoolean);
    }
  }
  
  public boolean a(HotVideoMongoliaRelativeLayout.PresenceInterface paramPresenceInterface, HotVideoMongoliaRelativeLayout.VideoInfo paramVideoInfo)
  {
    b(paramPresenceInterface, paramVideoInfo);
    h();
    return true;
  }
  
  public void b()
  {
    HotVideoMongoliaRelativeLayout.PresenceInterface localPresenceInterface = this.k;
    if (localPresenceInterface == null) {
      return;
    }
    if (this.j == 5) {
      localPresenceInterface.a(9, this);
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt == this.j) {
      return;
    }
    if (!f())
    {
      ThreadManager.getUIHandler().post(new HotVideoMongoliaRelativeLayout.4(this, paramInt));
      return;
    }
    a(this.j, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updatePlayStatus currentStatus is ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" laterStatus is ");
    localStringBuilder.append(paramInt);
    QLog.d("HotVideoRelativeLayout", 2, localStringBuilder.toString());
    this.j = paramInt;
  }
  
  public void c()
  {
    if (this.j == 2)
    {
      HotVideoMongoliaRelativeLayout.PresenceInterface localPresenceInterface = this.k;
      if (localPresenceInterface != null)
      {
        localPresenceInterface.a(0, this);
        a(HotPicPageView.o);
      }
    }
  }
  
  public void d()
  {
    HotVideoMongoliaRelativeLayout.PresenceInterface localPresenceInterface = this.k;
    if (localPresenceInterface != null) {
      localPresenceInterface.b();
    }
  }
  
  public void e()
  {
    HotVideoMongoliaRelativeLayout.OnVidoeControlListener localOnVidoeControlListener = this.u;
    if (localOnVidoeControlListener != null) {
      localOnVidoeControlListener.a(this.t);
    }
  }
  
  public boolean f()
  {
    return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.k;
    if (localObject != null) {
      ((HotVideoMongoliaRelativeLayout.PresenceInterface)localObject).a();
    }
    this.k = null;
    localObject = this.x;
    if (localObject != null)
    {
      ((VelocityTracker)localObject).recycle();
      this.x = null;
    }
    this.u = null;
    localObject = this.v;
    if ((localObject != null) && (this.j != 0))
    {
      this.j = 0;
      ((HotVideoMongoliaRelativeLayout.OnVideoControlStateListener)localObject).c(0);
      if (QLog.isColorLevel()) {
        QLog.i("HotVideoRelativeLayout", 2, "HotVideoCtl onDetachedFromWindow OnStateChanged(PLAY_STATE_PREVIEW)");
      }
      this.v = null;
      return;
    }
    b(-11);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    HotPicPageView.z = true;
    if (paramMotionEvent.getAction() == 0)
    {
      paramView = this.x;
      if (paramView == null) {
        this.x = VelocityTracker.obtain();
      } else {
        paramView.clear();
      }
      this.m = false;
      this.x.addMovement(paramMotionEvent);
      QLog.d("HotVideoRelativeLayout", 2, "onTouch event down");
      return true;
    }
    if (paramMotionEvent.getAction() == 2)
    {
      this.x.addMovement(paramMotionEvent);
      this.x.computeCurrentVelocity(1000);
      if (Math.abs(this.x.getYVelocity()) > 300.0F) {
        this.m = true;
      }
      paramView = new StringBuilder();
      paramView.append("onTouch event down");
      paramView.append(this.x.getYVelocity());
      QLog.d("HotVideoRelativeLayout", 2, paramView.toString());
      return false;
    }
    if (paramMotionEvent.getAction() == 1)
    {
      paramMotionEvent = this.n;
      if ((paramMotionEvent != null) && (!this.m))
      {
        paramMotionEvent.onClick(paramView);
        return false;
      }
    }
    else if (paramMotionEvent.getAction() == 3)
    {
      QLog.d("HotVideoRelativeLayout", 2, "event have been intercepted");
    }
    return false;
  }
  
  public void setControlStateListener(HotVideoMongoliaRelativeLayout.OnVideoControlStateListener paramOnVideoControlStateListener)
  {
    this.v = paramOnVideoControlStateListener;
  }
  
  public void setHotVideoData(HotVideoData paramHotVideoData)
  {
    this.t = paramHotVideoData;
  }
  
  public void setOnClickListener(HotVideoMongoliaRelativeLayout.InnerOnClickListener paramInnerOnClickListener)
  {
    this.n = paramInnerOnClickListener;
  }
  
  public void setVidoeControlListener(HotVideoMongoliaRelativeLayout.OnVidoeControlListener paramOnVidoeControlListener)
  {
    this.u = paramOnVidoeControlListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout
 * JD-Core Version:    0.7.0.1
 */
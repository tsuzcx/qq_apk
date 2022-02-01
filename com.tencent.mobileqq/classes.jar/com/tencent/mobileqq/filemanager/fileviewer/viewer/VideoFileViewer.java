package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.DragContainerLayout;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.DragView.OnGestureChangeListener;

public class VideoFileViewer
  extends FileBrowserViewBase
  implements View.OnTouchListener
{
  private boolean A = false;
  private boolean B = false;
  private boolean C = false;
  private boolean D = false;
  private VideoPlayParam E = null;
  private DragView.OnGestureChangeListener F = new VideoFileViewer.5(this);
  private float G = 0.0F;
  private float H = 0.0F;
  private Button l;
  private TextView m;
  private SeekBar n;
  private LinearLayout o;
  private TextView p;
  private TextView q;
  private TextView r;
  private TextView s;
  private DragContainerLayout t;
  private RelativeLayout u;
  private BaseVideoView v;
  private RelativeLayout w;
  private RelativeLayout x;
  private ImageView y;
  private ValueAnimator z;
  
  public VideoFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private String c(long paramLong)
  {
    long l1 = paramLong / 1000L;
    paramLong = l1 / 86400L;
    long l2 = l1 % 86400L;
    l1 = l2 / 3600L;
    long l3 = l2 % 3600L;
    l2 = l3 / 60L;
    l3 %= 60L;
    StringBuilder localStringBuilder;
    if (paramLong > 0L)
    {
      str = String.format("%02d:%02d:%02d:%02d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTick 161 [");
        localStringBuilder.append(str);
        localStringBuilder.append("]");
        QLog.d("#@#@", 1, localStringBuilder.toString());
      }
      return str;
    }
    if (l1 > 0L)
    {
      str = String.format("%02d:%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTick 167 [");
        localStringBuilder.append(str);
        localStringBuilder.append("]");
        QLog.d("#@#@", 1, localStringBuilder.toString());
      }
      return str;
    }
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTick 174 [");
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      QLog.d("#@#@", 1, localStringBuilder.toString());
    }
    return str;
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: VideoFileViewer initFileView");
    if (this.b == null)
    {
      this.b = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131627100, this.a, false);
      this.p = ((TextView)this.b.findViewById(2131440573));
      this.q = ((TextView)this.b.findViewById(2131428284));
      this.o = ((LinearLayout)this.b.findViewById(2131449448));
      this.x = ((RelativeLayout)this.b.findViewById(2131440732));
      this.s = ((TextView)this.b.findViewById(2131444737));
      this.s.setText(HardCodeUtil.a(2131913462));
      this.y = ((ImageView)this.b.findViewById(2131440731));
      this.x.setVisibility(8);
      this.n = ((SeekBar)this.b.findViewById(2131440424));
      this.l = ((Button)this.b.findViewById(2131440370));
      this.m = ((TextView)this.b.findViewById(2131438098));
      this.u = ((RelativeLayout)this.b.findViewById(2131447593));
      this.r = ((TextView)this.b.findViewById(2131429213));
      this.w = ((RelativeLayout)this.b.findViewById(2131433122));
    }
  }
  
  public void a(long paramLong)
  {
    this.q.setText(c(paramLong));
  }
  
  public void a(long paramLong, View.OnLongClickListener paramOnLongClickListener)
  {
    if (this.v == null)
    {
      this.v = ((BaseVideoView)QQVideoViewFactory.createBaseVideoView(this.c, paramLong, null, null));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13, -1);
      this.v.setLayoutParams(localLayoutParams);
      this.t = new DragContainerLayout(this.c);
      this.t.setContainerLongClickListener(paramOnLongClickListener);
      this.t.addView(this.v);
      int i = this.c.getResources().getDisplayMetrics().widthPixels;
      this.t.setGestureChangeListener(this.F);
      paramOnLongClickListener = new RelativeLayout.LayoutParams(-1, -1);
      this.w.addView(this.t, 0, paramOnLongClickListener);
      paramOnLongClickListener = this.E;
      if (paramOnLongClickListener != null) {
        this.v.setVideoParam(paramOnLongClickListener);
      }
    }
  }
  
  @TargetApi(16)
  public void a(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT > 16)
    {
      this.v.setBackground(paramDrawable);
      return;
    }
    this.v.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    if (paramOnSeekBarChangeListener != null) {
      this.n.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((ViewGroup)this.b).removeView(this.v);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.c);
    localRelativeLayout.setBackgroundColor(Color.parseColor("#D8DAE0"));
    TextView localTextView = new TextView(this.c);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130845695, 0, 0);
    localTextView.setText(paramString2);
    localTextView.setTextSize(12.0F);
    localTextView.setTextColor(Color.parseColor("#83889A"));
    localTextView.setPadding(0, 15, 0, 0);
    localRelativeLayout.addView(localTextView, -2, -2);
    ((RelativeLayout.LayoutParams)localTextView.getLayoutParams()).addRule(13);
    if (FileUtil.b(paramString1))
    {
      paramString2 = new TextView(this.c);
      paramString2.setText("用QQ浏览器打开");
      paramString2.setContentDescription("用qq浏览器打开");
      paramString2.setTextSize(12.0F);
      paramString2.setTextColor(Color.parseColor("#12B7F5"));
      paramString2.setOnClickListener(new VideoFileViewer.2(this, paramString1));
      localRelativeLayout.addView(paramString2, -2, -2);
      paramString1 = (RelativeLayout.LayoutParams)paramString2.getLayoutParams();
      paramString1.addRule(13);
      paramString1.addRule(12);
      paramString1.setMargins(0, 0, 0, 40);
      paramString2.setLayoutParams(paramString1);
    }
    double d = ((WindowManager)this.c.getSystemService("window")).getDefaultDisplay().getWidth();
    Double.isNaN(d);
    int i = (int)(d * 0.75D);
    ((ViewGroup)this.b).addView(localRelativeLayout, -1, i);
    ((RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams()).addRule(13);
    b(false);
    this.l.setVisibility(4);
    this.p.setVisibility(4);
    this.n.setVisibility(4);
    this.q.setVisibility(4);
    this.o.setBackgroundDrawable(null);
    this.b.setOnClickListener(new VideoFileViewer.3(this));
  }
  
  public View b()
  {
    return this.b;
  }
  
  public void b(long paramLong)
  {
    this.p.setText(c(paramLong));
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      this.o.setOnClickListener(paramOnClickListener);
      this.l.setOnClickListener(paramOnClickListener);
      this.m.setOnClickListener(paramOnClickListener);
      this.r.setOnClickListener(paramOnClickListener);
      this.s.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool;
    if ((paramBoolean) && (!this.D)) {
      bool = true;
    } else {
      bool = false;
    }
    super.b(bool);
    this.C = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    this.n.setProgress(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    TextView localTextView = this.s;
    if (localTextView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localTextView.setVisibility(i);
    }
  }
  
  public void d(int paramInt)
  {
    this.n.setMax(paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.l.setBackgroundResource(2130847363);
      this.l.setContentDescription(this.c.getString(2131888085));
      return;
    }
    this.l.setBackgroundResource(2130847361);
    this.l.setContentDescription(this.c.getString(2131888088));
  }
  
  public BaseVideoView e()
  {
    return this.v;
  }
  
  public void e(boolean paramBoolean)
  {
    TextView localTextView = this.m;
    if (localTextView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 4;
      }
      localTextView.setVisibility(i);
    }
  }
  
  public void f()
  {
    RelativeLayout localRelativeLayout = this.w;
    if (localRelativeLayout != null) {
      localRelativeLayout.removeAllViews();
    }
  }
  
  public void f(boolean paramBoolean)
  {
    int j = 0;
    int i;
    if ((paramBoolean) && (!this.D)) {
      i = 1;
    } else {
      i = 0;
    }
    LinearLayout localLinearLayout = this.o;
    if (i != 0) {
      i = j;
    } else {
      i = 8;
    }
    localLinearLayout.setVisibility(i);
    this.A = paramBoolean;
  }
  
  @TargetApi(11)
  public void g()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.z = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F });
      this.z.setDuration(2500L);
      this.z.addUpdateListener(new VideoFileViewer.4(this));
    }
  }
  
  public void g(boolean paramBoolean)
  {
    int j = 0;
    int i;
    if ((paramBoolean) && (!this.D)) {
      i = 1;
    } else {
      i = 0;
    }
    RelativeLayout localRelativeLayout = this.u;
    if (i != 0) {
      i = j;
    } else {
      i = 8;
    }
    localRelativeLayout.setVisibility(i);
    this.B = paramBoolean;
  }
  
  public void h()
  {
    if ((this.o.getVisibility() == 0) && (Build.VERSION.SDK_INT >= 11))
    {
      this.z.cancel();
      this.z.start();
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.x.setVisibility(0);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(500L);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setRepeatMode(1);
      localRotateAnimation.setStartTime(-1L);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      this.y.startAnimation(localRotateAnimation);
      return;
    }
    this.c.runOnUiThread(new VideoFileViewer.1(this));
  }
  
  public void i()
  {
    this.o.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.o.setAlpha(1.0F);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 2)
      {
        float f3 = Math.abs(f1 - this.G);
        float f4 = Math.abs(f2 - this.H);
        paramView = new StringBuilder();
        paramView.append("absX[");
        paramView.append(f3);
        paramView.append("] --- absY[");
        paramView.append(f4);
        paramView.append("]，mPressDownY[");
        paramView.append(this.H);
        paramView.append("]，currTouchY【");
        paramView.append(f2);
        paramView.append("】");
        QLog.i("FileBrowserViewBase", 1, paramView.toString());
        if (f3 > f4)
        {
          f2 = this.G;
          if (f1 - f2 > 20.0F)
          {
            QLog.i("FileBrowserViewBase", 1, "<--  左滑");
            return true;
          }
          if (f1 - f2 < -20.0F)
          {
            QLog.i("FileBrowserViewBase", 1, "-->  右滑");
            return true;
          }
        }
      }
    }
    else
    {
      this.G = f1;
      this.H = f2;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqfloatingwindow.FloatingBaseProxyWrapper;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenReporter;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenUtils;
import com.tencent.mobileqq.qqfloatingwindow.listener.IContainerBackPressListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenViewClickListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IWindowClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;

public class FloatingVideoWrapper
  extends FloatingBaseProxyWrapper
  implements SeekBar.OnSeekBarChangeListener, IContainerBackPressListener, IVideoOuterStatusListener
{
  public static final String CLASS_NAME = "com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper";
  public static final String TAG = "FloatingVideoWrapper";
  private StringBuilder A;
  private Formatter B;
  private int C = 0;
  private int D = 0;
  private int E = 0;
  private int F = 0;
  private IVideoInnerStatusListener a;
  private IFullScreenEnterListener b;
  private FrameLayout c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private TextView g;
  private TextView h;
  private LinearLayout i;
  private ImageView j;
  private SeekBar k;
  private TextView l;
  private ImageView m;
  public IFullScreenViewClickListener mFullScreenViewClickListener;
  private TextView n;
  private TextView o;
  private int p = 0;
  private int q = 0;
  private TextView r;
  private TextView s;
  private List<View> t;
  private int u = -1;
  private int v = -1;
  private int w = -1;
  private int x = 0;
  private ObjectAnimator y;
  private Runnable z = new FloatingVideoWrapper.12(this);
  
  public FloatingVideoWrapper(Context paramContext)
  {
    super(paramContext);
  }
  
  private void B()
  {
    if (this.q == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FloatingVideoWrapper", 2, "showFinishTime() mAllTime == 0");
      }
      a(false, new View[] { this.o });
      return;
    }
    a(true, new View[] { this.o });
    TextView localTextView = this.o;
    if (localTextView != null) {
      localTextView.setText(a(this.q));
    }
  }
  
  private void C()
  {
    i(400);
    b(true, new View[] { this.g, this.h, this.k });
    this.u = 3;
  }
  
  private void D()
  {
    i(401);
    b(false, new View[] { this.g, this.h, this.k });
    this.u = 2;
  }
  
  private static boolean E()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void F()
  {
    if (!n())
    {
      if (!w()) {
        return;
      }
      if (o())
      {
        if ((x()) || (!d(q(), r())))
        {
          IFullScreenEnterListener localIFullScreenEnterListener = this.b;
          if (localIFullScreenEnterListener != null) {
            localIFullScreenEnterListener.onEnter(q(), r());
          } else {
            G();
          }
        }
        FloatingScreenReporter.e();
        return;
      }
      if (p()) {
        K();
      }
    }
  }
  
  private void G()
  {
    if (!n())
    {
      if (!o()) {
        return;
      }
      a(true, this.v, this.w, true);
      y();
      h(true);
      g(true);
      a(false, new View[] { this.n });
      b(false);
    }
    I();
    i(false);
    J();
  }
  
  private void H()
  {
    if (!n())
    {
      if (!p()) {
        return;
      }
      a(false, this.v, this.w, false);
      z();
      h(false);
      g(false);
      b(true);
    }
    IFullScreenViewClickListener localIFullScreenViewClickListener = this.mFullScreenViewClickListener;
    if (localIFullScreenViewClickListener != null) {
      localIFullScreenViewClickListener.a();
    }
    this.y = null;
    i(true);
    J();
    if (this.u == 4) {
      B();
    }
  }
  
  private void I()
  {
    A();
    b(1.0F);
    this.x = 0;
  }
  
  private void J()
  {
    if (n()) {
      return;
    }
    Context localContext = m();
    if (localContext == null) {
      return;
    }
    if (o())
    {
      i1 = this.u;
      if ((i1 != 1) && (i1 != 4))
      {
        b(localContext.getResources().getString(2131897819));
        return;
      }
      b(localContext.getResources().getString(2131897831));
      return;
    }
    int i1 = this.x;
    if (i1 == 0)
    {
      b(localContext.getResources().getString(2131897840));
      return;
    }
    if (i1 == 1) {
      b(localContext.getResources().getString(2131897820));
    }
  }
  
  private void K()
  {
    int i1 = this.x;
    if (i1 != 0)
    {
      if (i1 != 1) {
        return;
      }
      k(0);
      return;
    }
    i1 = this.u;
    if ((i1 == 0) || (i1 == 1) || (i1 == 4)) {
      k(1);
    }
  }
  
  private void L()
  {
    onVideoStart(this.q);
    IVideoInnerStatusListener localIVideoInnerStatusListener = this.a;
    if (localIVideoInnerStatusListener != null) {
      localIVideoInnerStatusListener.notifyVideoStart();
    }
  }
  
  private void M()
  {
    onVideoStop();
    IVideoInnerStatusListener localIVideoInnerStatusListener = this.a;
    if (localIVideoInnerStatusListener != null) {
      localIVideoInnerStatusListener.notifyVideoStop();
    }
  }
  
  private String a(long paramLong)
  {
    if (this.B == null)
    {
      this.A = new StringBuilder();
      this.B = new Formatter(this.A, Locale.getDefault());
    }
    this.C = ((int)(paramLong / 1000L));
    int i1 = this.C;
    this.D = (i1 % 60);
    this.E = (i1 / 60 % 60);
    this.F = (i1 / 3600);
    this.A.setLength(0);
    i1 = this.F;
    if (i1 > 0) {
      return this.B.format("%d:%02d:%02d", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.E), Integer.valueOf(this.D) }).toString();
    }
    return this.B.format("%02d:%02d", new Object[] { Integer.valueOf(this.E), Integer.valueOf(this.D) }).toString();
  }
  
  private void a(Bitmap paramBitmap)
  {
    ImageView localImageView = this.d;
    if ((localImageView != null) && (paramBitmap != null))
    {
      localImageView.setImageBitmap(paramBitmap);
      this.d.setVisibility(0);
    }
  }
  
  private void b(Drawable paramDrawable)
  {
    ImageView localImageView = this.d;
    if ((localImageView != null) && (paramDrawable != null))
    {
      localImageView.setImageDrawable(paramDrawable);
      this.d.setVisibility(0);
    }
  }
  
  private void d()
  {
    Object localObject = m();
    if ((localObject != null) && (this.i != null) && (FloatingScreenUtils.b((Context)localObject)))
    {
      int i1 = FloatingScreenUtils.c((Context)localObject);
      int i2 = FloatingScreenUtils.d((Context)localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("screenRealHeight = ");
        localStringBuilder.append(i1);
        localStringBuilder.append(" screenPureHeight = ");
        localStringBuilder.append(i2);
        QLog.d("FloatingVideoWrapper", 2, localStringBuilder.toString());
      }
      if (i1 > 0)
      {
        if (i2 <= 0) {
          return;
        }
        i1 = Math.min(Math.max(i1 - i2, 0), 100);
        i2 = FloatingScreenUtils.a(16.0F, ((Context)localObject).getResources());
        localObject = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = (i2 + i1);
        this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void e()
  {
    a(true, new View[] { this.g, this.j });
    a(false, new View[] { this.h, this.l, this.m });
    b(true, new View[] { this.g, this.h, this.k });
    this.u = 1;
    J();
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.v = paramInt1;
    }
    if (paramInt2 > 0) {
      this.w = paramInt2;
    }
    if (w()) {
      a(o() ^ true, this.v, this.w, false);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    a(true, new View[] { this.g, this.j });
    a(false, new View[] { this.h, this.l, this.m });
    a(paramBoolean, new View[] { this.d });
    b(true, new View[] { this.g, this.h });
    b(false, new View[] { this.k });
    this.r.setText(a(this.q));
    this.k.setProgress(100);
    this.u = 4;
    J();
    if (o()) {
      B();
    }
  }
  
  private void g(int paramInt)
  {
    a(false, new View[] { this.g, this.j, this.l, this.m, this.o });
    a(true, new View[] { this.h });
    b(true, new View[] { this.g, this.h, this.k });
    v();
    this.u = 0;
    J();
    if (paramInt > 0)
    {
      if (this.q == paramInt) {
        return;
      }
      this.q = paramInt;
      TextView localTextView = this.s;
      if (localTextView != null) {
        localTextView.setText(a(this.q));
      }
    }
  }
  
  private void g(boolean paramBoolean)
  {
    Object localObject1 = m();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((Context)localObject1).getResources();
    Object localObject2 = this.j;
    int i3 = -2;
    if (localObject2 != null)
    {
      localObject2 = ((ImageView)localObject2).getLayoutParams();
      if (paramBoolean)
      {
        ((ViewGroup.LayoutParams)localObject2).width = -2;
        ((ViewGroup.LayoutParams)localObject2).height = -2;
        this.j.setImageResource(2130838024);
      }
      else
      {
        ((ViewGroup.LayoutParams)localObject2).width = -1;
        ((ViewGroup.LayoutParams)localObject2).height = -1;
        this.j.setImageResource(2130847946);
      }
      this.j.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    localObject2 = this.m;
    if (localObject2 != null)
    {
      localObject2 = (LinearLayout.LayoutParams)((ImageView)localObject2).getLayoutParams();
      int i2;
      if (paramBoolean)
      {
        i1 = 32;
        i2 = i3;
        if (localObject1 != null)
        {
          i1 = FloatingScreenUtils.a(16.0F, (Resources)localObject1);
          i2 = i3;
        }
      }
      else
      {
        i2 = 40;
        i1 = 16;
        if (localObject1 != null)
        {
          i2 = FloatingScreenUtils.a(20.0F, (Resources)localObject1);
          i1 = FloatingScreenUtils.a(8.0F, (Resources)localObject1);
        }
      }
      ((LinearLayout.LayoutParams)localObject2).width = i2;
      ((LinearLayout.LayoutParams)localObject2).height = i2;
      ((LinearLayout.LayoutParams)localObject2).setMargins(0, 0, 0, i1);
      this.m.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    localObject2 = this.l;
    if (localObject2 != null) {
      if (paramBoolean) {
        ((TextView)localObject2).setTextSize(17.0F);
      } else {
        ((TextView)localObject2).setTextSize(12.0F);
      }
    }
    int i1 = this.u;
    if ((i1 != 2) && (i1 != 3))
    {
      if ((Build.VERSION.SDK_INT >= 23) && (paramBoolean))
      {
        f(2130847947);
        return;
      }
      if (localObject1 != null) {
        e(((Resources)localObject1).getColor(2131168376));
      }
    }
    else if (localObject1 != null)
    {
      e(((Resources)localObject1).getColor(2131167939));
    }
  }
  
  private void h(int paramInt)
  {
    int i1;
    if (paramInt < 0)
    {
      i1 = 0;
    }
    else
    {
      int i2 = this.q;
      i1 = paramInt;
      if (paramInt > i2) {
        i1 = i2;
      }
    }
    double d1 = i1;
    Double.isNaN(d1);
    double d2 = this.q;
    Double.isNaN(d2);
    this.p = ((int)(d1 * 100.0D / d2));
    this.k.setProgress(this.p);
    this.r.setText(a(i1));
  }
  
  private void h(boolean paramBoolean)
  {
    Iterator localIterator = this.t.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (localView != null) {
        if (paramBoolean) {
          localView.setVisibility(0);
        } else {
          localView.setVisibility(4);
        }
      }
    }
  }
  
  private void i(int paramInt)
  {
    I();
    if (!n()) {
      h(p());
    }
    a(false, new View[] { this.j });
    a(true, new View[] { this.l });
    if (paramInt != 400)
    {
      localObject = m();
      if (localObject != null) {
        e(((Context)localObject).getResources().getColor(2131167939));
      }
    }
    if (this.m != null) {
      if (j(paramInt))
      {
        this.m.setImageResource(2130847945);
        this.m.setVisibility(0);
      }
      else
      {
        this.m.setVisibility(8);
      }
    }
    Object localObject = this.l;
    if (localObject != null)
    {
      if (paramInt == 400)
      {
        ((TextView)localObject).setText(2131897835);
        return;
      }
      if (paramInt == 401)
      {
        ((TextView)localObject).setText(2131897836);
        return;
      }
      if (paramInt == 402)
      {
        ((TextView)localObject).setText(2131897838);
        return;
      }
      if (paramInt == 403)
      {
        ((TextView)localObject).setText(2131897837);
        return;
      }
      ((TextView)localObject).setText(2131897836);
    }
  }
  
  private void i(boolean paramBoolean)
  {
    d(paramBoolean);
    e(paramBoolean);
    Context localContext = m();
    if (localContext != null)
    {
      if (localContext.getResources() == null) {
        return;
      }
      if (paramBoolean)
      {
        a(localContext.getResources().getDrawable(2130847941));
        return;
      }
      a(localContext.getResources().getDrawable(2130847940));
    }
  }
  
  private boolean j(int paramInt)
  {
    return (paramInt == 401) || (paramInt == 402) || (paramInt == 403);
  }
  
  private void k(int paramInt)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if (paramInt == 0)
    {
      f1 = 0.0F;
      f2 = 1.0F;
    }
    else if (paramInt != 1)
    {
      return;
    }
    View localView = l();
    if (localView != null)
    {
      this.y = ObjectAnimator.ofPropertyValuesHolder(localView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("alpha", new float[] { f1, f2 }) });
      this.y.addUpdateListener(new FloatingVideoWrapper.13(this, f1, f2, localView));
      this.y.addListener(new FloatingVideoWrapper.14(this, paramInt, localView));
      this.y.setDuration(300L).start();
    }
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    int i1 = super.a(paramFloatingScreenParams, paramView);
    paramView = this.a;
    if (paramView != null)
    {
      paramView.notifyVideoClose(6);
      this.a = null;
    }
    else
    {
      FloatingScreenReporter.a();
      if ((i1 == 0) && (paramFloatingScreenParams != null) && (paramFloatingScreenParams.getCanZoom())) {
        b();
      }
    }
    this.b = null;
    this.q = 0;
    return i1;
  }
  
  public IVideoOuterStatusListener a(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    this.a = paramIVideoInnerStatusListener;
    return this;
  }
  
  public void a(int paramInt)
  {
    if ((!n()) && (o())) {
      ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).saveFloatingCenter(q(), r());
    }
    IVideoInnerStatusListener localIVideoInnerStatusListener = this.a;
    if (localIVideoInnerStatusListener != null)
    {
      localIVideoInnerStatusListener.notifyVideoClose(paramInt);
      this.a = null;
    }
    this.b = null;
    ThreadManager.getUIHandler().removeCallbacks(this.z);
    super.a(paramInt);
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
    a(this);
    this.c = new FrameLayout(paramContext);
    this.c.setId(2131442582);
    this.d = new ImageView(paramContext);
    this.d.setId(2131442566);
    this.d.setScaleType(ImageView.ScaleType.FIT_XY);
    this.e = ((ImageView)d(2131442571));
    this.e.setContentDescription(paramContext.getResources().getString(2131897818));
    this.f = ((ImageView)d(2131442569));
    this.f.setContentDescription(paramContext.getResources().getString(2131897817));
    this.g = ((TextView)d(2131442578));
    this.g.setContentDescription(paramContext.getResources().getString(2131897832));
    this.h = ((TextView)d(2131442577));
    this.h.setContentDescription(paramContext.getResources().getString(2131897822));
    this.i = ((LinearLayout)d(2131442575));
    this.j = ((ImageView)d(2131442573));
    this.j.setContentDescription(paramContext.getResources().getString(2131897831));
    this.l = ((TextView)d(2131442579));
    this.m = ((ImageView)d(2131442574));
    this.r = ((TextView)d(2131442581));
    this.s = ((TextView)d(2131442580));
    this.n = ((TextView)d(2131442570));
    this.n.setShadowLayer(3.0F, 1.0F, 1.0F, -16777216);
    this.o = ((TextView)d(2131442572));
    a(this, new View[] { this.e, this.f, this.g, this.h, this.j });
    this.k = ((SeekBar)d(2131442584));
    this.k.setOnSeekBarChangeListener(this);
    this.k.setThumb(paramContext.getResources().getDrawable(2130851863));
    this.k.setProgressDrawable(paramContext.getResources().getDrawable(2130847691));
    if (this.t == null) {
      this.t = new ArrayList(4);
    }
    this.t.clear();
    this.t.add(this.i);
    this.t.add(this.e);
    this.t.add(this.f);
    if (LiuHaiUtils.b())
    {
      RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
      localLayoutParams1.addRule(10, -1);
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
      localLayoutParams2.addRule(10, -1);
      int i1 = LiuHaiUtils.d - FloatingScreenUtils.a(12.0F, paramContext.getResources());
      localLayoutParams1.topMargin = i1;
      localLayoutParams2.topMargin = i1;
    }
    d();
  }
  
  public void a(View paramView)
  {
    this.c.removeAllViews();
    b(paramView);
    paramView.setId(2131442585);
    this.c.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    b(this.d);
    this.c.addView(this.d, new FrameLayout.LayoutParams(-1, -1));
    u();
    b(this.c);
    a(this.c, new FrameLayout.LayoutParams(-1, -1));
    t();
    a(new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void a(IFullScreenEnterListener paramIFullScreenEnterListener)
  {
    this.b = paramIFullScreenEnterListener;
  }
  
  public void a(IFullScreenViewClickListener paramIFullScreenViewClickListener)
  {
    this.mFullScreenViewClickListener = paramIFullScreenViewClickListener;
  }
  
  public void a(IWindowClickListener paramIWindowClickListener)
  {
    super.a(paramIWindowClickListener);
  }
  
  public void b()
  {
    Context localContext = m();
    if (localContext == null) {
      return;
    }
    if (!((Boolean)BaseSharedPreUtil.a(localContext, "", "key_float_video_has_show_tips", Boolean.valueOf(false))).booleanValue())
    {
      a(true, new View[] { this.n });
      BaseSharedPreUtil.a(localContext, "", true, "key_float_video_has_show_tips", Boolean.valueOf(true));
      ThreadManager.getUIHandler().postDelayed(new FloatingVideoWrapper.2(this), 3000L);
    }
  }
  
  public void c()
  {
    a(3);
    FloatingScreenReporter.g();
  }
  
  public void dz_()
  {
    a(true, new View[] { this.h });
    a(true);
    b(true);
    a(false, new View[] { this.g, this.l, this.m, this.j, this.d });
    b(true, new View[] { this.g, this.h, this.k });
    I();
    g(false);
    h(false);
    J();
  }
  
  public void j()
  {
    a(0, new FloatingVideoWrapper.1(this));
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131442568)
    {
      a(1);
      FloatingScreenReporter.d();
    }
    else if (i1 == 2131442569)
    {
      a(2);
      FloatingScreenReporter.k();
    }
    else if (i1 == 2131442571)
    {
      H();
      FloatingScreenReporter.f();
    }
    else if (i1 == 2131442578)
    {
      L();
      FloatingScreenReporter.h();
    }
    else if (i1 == 2131442577)
    {
      M();
      FloatingScreenReporter.h();
    }
    else if (i1 == 2131442573)
    {
      L();
    }
    else if (i1 == 2131442576)
    {
      F();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onOrientationChange(boolean paramBoolean)
  {
    c(paramBoolean);
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    this.p = paramInt;
    paramSeekBar = this.a;
    if ((paramSeekBar != null) && (paramBoolean))
    {
      paramSeekBar.notifyVideoSeek(this.p);
      double d1 = this.p;
      double d2 = this.q;
      Double.isNaN(d1);
      Double.isNaN(d2);
      onVideoProgressUpdate((int)(d1 * d2 / 100.0D));
    }
  }
  
  public void onSetVideoCover(Bitmap paramBitmap)
  {
    if (E())
    {
      a(paramBitmap);
      return;
    }
    ThreadManager.getUIHandler().post(new FloatingVideoWrapper.11(this, paramBitmap));
  }
  
  public void onSetVideoCover(Drawable paramDrawable)
  {
    if (E())
    {
      b(paramDrawable);
      return;
    }
    ThreadManager.getUIHandler().post(new FloatingVideoWrapper.10(this, paramDrawable));
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onVideoBuffering()
  {
    if (E())
    {
      C();
      return;
    }
    ThreadManager.getUIHandler().post(new FloatingVideoWrapper.7(this));
  }
  
  public void onVideoComplete(boolean paramBoolean)
  {
    if (o()) {
      FloatingScreenReporter.i();
    } else {
      FloatingScreenReporter.j();
    }
    if (E())
    {
      f(paramBoolean);
      return;
    }
    ThreadManager.getUIHandler().post(new FloatingVideoWrapper.5(this, paramBoolean));
  }
  
  public void onVideoError(int paramInt)
  {
    if (E())
    {
      D();
      return;
    }
    ThreadManager.getUIHandler().post(new FloatingVideoWrapper.8(this));
  }
  
  public void onVideoProgressUpdate(int paramInt)
  {
    if (this.q == 0) {
      return;
    }
    if (E())
    {
      h(paramInt);
      return;
    }
    ThreadManager.getUIHandler().post(new FloatingVideoWrapper.6(this, paramInt));
  }
  
  public void onVideoSize(int paramInt1, int paramInt2)
  {
    if (E())
    {
      e(paramInt1, paramInt2);
      return;
    }
    ThreadManager.getUIHandler().post(new FloatingVideoWrapper.9(this, paramInt1, paramInt2));
  }
  
  public void onVideoStart(int paramInt)
  {
    if (this.q != paramInt) {
      FloatingScreenReporter.d(paramInt);
    }
    if (E()) {
      g(paramInt);
    } else {
      ThreadManager.getUIHandler().post(new FloatingVideoWrapper.3(this, paramInt));
    }
    ThreadManager.getUIHandler().postDelayed(this.z, 300L);
  }
  
  public void onVideoStop()
  {
    if (E())
    {
      e();
      return;
    }
    ThreadManager.getUIHandler().post(new FloatingVideoWrapper.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.glue.viola;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Scroller;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.dom.style.CornerViewOutlineProvider;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONObject;

public class CommonSuspensionGestureLayout
  extends FrameLayout
  implements View.OnTouchListener
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  public static int e = 4;
  public static int f = 5;
  public static int g = 500;
  public static int h = 300;
  private LinearLayout A;
  private FrameLayout B;
  private View C;
  private View D;
  private ViewGroup E;
  private View F;
  private View G;
  private boolean H = true;
  private TranslateAnimation I;
  private TranslateAnimation J;
  private ObjectAnimator K;
  private AnimationSet L;
  private boolean M = true;
  private boolean N = false;
  private int O = 120;
  private int P = 10;
  private boolean Q = true;
  private boolean R = true;
  private boolean S = false;
  private boolean T = false;
  private int U = -1;
  private boolean V = false;
  private boolean W = false;
  private int Z = 0;
  private int aa = 0;
  private boolean ab = false;
  private boolean ac = false;
  private Activity ad;
  private Bundle ae;
  private int af = 0;
  private int ag = -1;
  private int ah = -1;
  private int ai = -1;
  private boolean aj = false;
  private int ak = 0;
  private int al = -ViewUtils.dpToPx(this.O);
  private boolean am = true;
  float i;
  float j;
  float k;
  float l;
  Scroller m;
  private int n = 0;
  private CommonSuspensionGestureLayout.SuspensionGestureListener o;
  private CommonSuspensionGestureLayout.ContentScrollListener p;
  private Context q;
  private VelocityTracker r = null;
  private Boolean s = Boolean.valueOf(false);
  private long t;
  private float u;
  private View.OnLayoutChangeListener v;
  private View w;
  private ViewGroup x;
  private View y;
  private View z;
  
  public CommonSuspensionGestureLayout(Context paramContext, Bundle paramBundle)
  {
    super(paramContext, null, 0);
    this.ae = paramBundle;
    paramBundle = this.ae;
    if ((paramBundle != null) && (paramBundle.containsKey("float_layer_back_view"))) {
      this.S = this.ae.getBoolean("float_layer_back_view", false);
    }
    paramBundle = this.ae;
    if ((paramBundle != null) && (paramBundle.containsKey("margin_top"))) {
      this.O = this.ae.getInt("margin_top", 120);
    }
    paramBundle = this.ae;
    if ((paramBundle != null) && (paramBundle.containsKey("scroll_to_top"))) {
      this.M = this.ae.getBoolean("scroll_to_top", true);
    }
    setOnTouchListener(this);
    this.q = paramContext;
    q();
    r();
    s();
    setOnClickListener(new CommonSuspensionGestureLayout.1(this));
    this.v = new CommonSuspensionGestureLayout.2(this);
    addOnLayoutChangeListener(this.v);
  }
  
  private void A()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if ((this.ae != null) && (this.ae.containsKey("floating_window_business"))) {
        localJSONObject.put("Float_type", this.ae.get("floating_window_business"));
      }
      if ((this.ae != null) && (this.ae.containsKey("floating_window_scene"))) {
        localJSONObject.put("source", this.ae.get("floating_window_scene"));
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    PublicAccountReportUtils.a(null, null, "0X800A9B6", "0X800A9B6", 0, 0, "", "", "", localJSONObject.toString(), false);
  }
  
  private void B()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if ((this.ae != null) && (this.ae.containsKey("floating_window_business"))) {
        localJSONObject.put("Float_type", this.ae.get("floating_window_business"));
      }
      if ((this.ae != null) && (this.ae.containsKey("floating_window_scene"))) {
        localJSONObject.put("source", this.ae.get("floating_window_scene"));
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    PublicAccountReportUtils.a(null, null, "0X800A9B7", "0X800A9B7", 0, 0, "", "", "", localJSONObject.toString(), false);
  }
  
  public static int a(Activity paramActivity)
  {
    int i1 = 0;
    StringBuilder localStringBuilder;
    try
    {
      int i2;
      if (ScreenUtil.checkDeviceHasNavigationBar(paramActivity.getApplicationContext()))
      {
        i2 = ScreenUtil.getNavigationBarHeight(paramActivity.getApplicationContext());
        i1 = i2;
      }
      else
      {
        i1 = 0;
      }
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNavigationBarHeight ");
        localStringBuilder.append(i1);
        localStringBuilder.append(",isNavShow:");
        localStringBuilder.append(c(paramActivity));
        localStringBuilder.append(",build name:");
        localStringBuilder.append(Build.MANUFACTURER);
        localStringBuilder.append("，build module:");
        localStringBuilder.append(Build.MODEL);
        localStringBuilder.append(",getContentHeight:");
        localStringBuilder.append(b(paramActivity));
        localStringBuilder.append(",screenHeight:");
        localStringBuilder.append(DisplayUtil.getScreenHeight(paramActivity));
        QLog.d("CommonSuspensionGestureLayout", 1, localStringBuilder.toString());
        if (i1 != 0)
        {
          if (!c(paramActivity)) {
            return 0;
          }
          if ((Build.MANUFACTURER.contains("OnePlus")) && (Build.MODEL.contains("HD1900")) && (b(paramActivity) >= DisplayUtil.getScreenHeight(paramActivity)))
          {
            i2 = b(paramActivity);
            int i3 = DisplayUtil.getScreenHeight(paramActivity);
            return i2 - i3;
          }
        }
        return i1;
      }
      catch (Exception paramActivity) {}
      localStringBuilder = new StringBuilder();
    }
    catch (Exception paramActivity) {}
    localStringBuilder.append("getNavigationBarHeight error:");
    localStringBuilder.append(paramActivity.getMessage());
    QLog.e("CommonSuspensionGestureLayout", 1, localStringBuilder.toString());
    return i1;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (this.m == null) {
      this.m = new Scroller(this.q);
    }
    Object localObject = this.w;
    if (localObject == null) {
      return;
    }
    if (this.n == f) {
      return;
    }
    int i1 = ((View)localObject).getScrollX();
    int i2 = this.w.getScrollY();
    localObject = this.p;
    if ((localObject != null) && (!((CommonSuspensionGestureLayout.ContentScrollListener)localObject).a()) && ((i2 > 0) || (i2 >= h)))
    {
      this.n = f;
      this.w.scrollTo(0, 0);
      postInvalidate();
      return;
    }
    if ((i2 < 0) && (i2 > -g)) {
      this.n = b;
    } else if (i2 <= -g) {
      this.n = c;
    } else if ((i2 > 0) && (i2 < h)) {
      this.n = d;
    } else if (i2 >= h) {
      this.n = e;
    }
    if ((p()) && (this.u > 0.0F))
    {
      localObject = this.p;
      if ((localObject != null) && (((CommonSuspensionGestureLayout.ContentScrollListener)localObject).a()) && (!paramBoolean))
      {
        this.n = f;
        this.w.scrollTo(0, -ViewUtils.dpToPx(this.O));
        z();
        postInvalidate();
        break label298;
      }
    }
    this.m.startScroll(i1, i2, paramInt1 - i1, paramInt2 - i2, paramInt3);
    invalidate();
    label298:
    this.o.a(this.n);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() != 0) && (paramMotionEvent.getAction() != 2))
    {
      this.r.computeCurrentVelocity(1000);
      float f1 = this.r.getYVelocity(0);
      if ((this.w.getScrollY() != -ViewUtils.dpToPx(this.O)) && (f1 < 0.0F)) {
        a(0, -ViewUtils.dpToPx(this.O), 200, false);
      }
    }
  }
  
  private void a(FrameLayout paramFrameLayout)
  {
    if (this.Q)
    {
      this.B = new FrameLayout(getContext());
      Object localObject = new FrameLayout.LayoutParams(-1, ViewUtils.dpToPx(20.0F));
      if (this.W) {
        ((FrameLayout.LayoutParams)localObject).topMargin = (-ViewUtils.dpToPx(20.0F));
      }
      this.B.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.B.setBackgroundColor(this.U);
      localObject = new View(getContext());
      int i1 = Color.parseColor("#FFB0B3BF");
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(60.0F), ViewUtils.dpToPx(4.0F));
      localLayoutParams.gravity = 17;
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(66.0F);
      localGradientDrawable.setColor(i1);
      ((View)localObject).setBackgroundDrawable(localGradientDrawable);
      ((View)localObject).setLayoutParams(localLayoutParams);
      this.B.addView((View)localObject);
      c(this.B);
      paramFrameLayout.addView(this.B);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.V) {
      return;
    }
    this.E = ((ViewGroup)this.C.getParent());
    this.E.removeView(this.C);
    if (this.M)
    {
      addView(this.C);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.C.getLayoutParams();
      if (this.ab)
      {
        localLayoutParams.height = (this.aa + ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
        localLayoutParams.topMargin = 0;
        this.C.setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()), 0, 0);
        this.C.setLayoutParams(localLayoutParams);
      }
      else
      {
        localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
        this.C.setLayoutParams(localLayoutParams);
      }
      if (paramBoolean) {
        this.w.setPadding(0, this.aa, 0, 0);
      }
      this.C.setVisibility(8);
    }
  }
  
  private void a(boolean paramBoolean, View paramView)
  {
    paramView.setVisibility(0);
    paramView.setLayerType(2, null);
    if (paramBoolean) {
      this.K = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 0.0F, 1.0F });
    } else {
      this.K = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 1.0F, 0.0F });
    }
    this.K.addListener(new CommonSuspensionGestureLayout.9(this, paramView));
    this.K.setDuration(250L);
    this.K.setInterpolator(new LinearInterpolator());
    this.K.start();
  }
  
  private boolean a(int paramInt, float paramFloat)
  {
    return ((paramInt < -g) && (paramFloat > -100.0F)) || ((paramInt < -50) && (paramFloat >= 2800.0F));
  }
  
  public static int b(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getDecorView() != null))
    {
      Rect localRect = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      return localRect.height();
    }
    return 0;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    a(true, this.z);
    t();
    if (paramInt1 != -1) {
      a(paramInt1);
    }
    if (paramInt2 != -1) {
      b(paramInt2);
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    float f2 = this.j;
    float f1 = 0.0F;
    if (f2 != 0.0F) {
      f1 = paramMotionEvent.getRawY() - this.j;
    }
    this.i = f1;
    if (this.i < -3.0F)
    {
      m();
      n();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.C == null) {
      w();
    }
    this.N = true;
    c(paramBoolean);
    x();
    B();
  }
  
  private boolean b(int paramInt, float paramFloat)
  {
    return ((paramInt > h) || (paramFloat < -6500.0F)) && (this.s.booleanValue()) && (paramFloat < 100.0F) && (System.currentTimeMillis() - this.t >= 200L) && (this.u < 0.0F) && (this.p.a());
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    float f1;
    if (this.j != 0.0F) {
      f1 = paramMotionEvent.getRawY() - this.j;
    } else {
      f1 = 0.0F;
    }
    this.i = f1;
    if ((this.w.getScrollY() < 0) && (this.i > 0.0F))
    {
      this.ac = true;
      a(false, this.C);
    }
  }
  
  private void c(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      int i1 = this.P;
      if (i1 != 0)
      {
        paramView.setOutlineProvider(new CornerViewOutlineProvider(ViewUtils.dpToPx(i1), FlexConvertUtils.getScreenHeight(getContext()) - ViewUtils.dpToPx(this.O), 1));
        paramView.setClipToOutline(true);
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.C;
    if ((localObject != null) && ((((View)localObject).getAlpha() != 1.0F) || (this.C.getVisibility() != 0) || (paramBoolean)))
    {
      this.ac = false;
      localObject = this.K;
      if ((localObject != null) && ((!((ObjectAnimator)localObject).isRunning()) || (paramBoolean))) {
        a(true, this.C);
      }
    }
  }
  
  private boolean c(int paramInt, float paramFloat)
  {
    return ((paramInt < -g) && (paramFloat > -100.0F)) || ((paramInt < -50) && (paramFloat >= 2800.0F));
  }
  
  public static boolean c(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    if (localViewGroup != null)
    {
      int i1 = 0;
      while (i1 < localViewGroup.getChildCount())
      {
        localViewGroup.getChildAt(i1).getContext().getPackageName();
        if ((localViewGroup.getChildAt(i1).getId() != -1) && ("navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(localViewGroup.getChildAt(i1).getId()))) && (localViewGroup.getChildAt(i1).getHeight() != 0)) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  private void d(int paramInt)
  {
    int i1 = this.ak;
    if ((i1 < 0) && (i1 > -ViewUtils.dpToPx(this.O)))
    {
      if (this.ak <= -ViewUtils.dpToPx(this.O))
      {
        a(0, -ViewUtils.dpToPx(this.O), 200, false);
        z();
      }
    }
    else if ((this.ak == 0) && (paramInt < -ViewUtils.dpToPx(this.O)))
    {
      a(0, -ViewUtils.dpToPx(this.O), 200, false);
      z();
    }
  }
  
  private boolean d(int paramInt, float paramFloat)
  {
    return ((paramInt > h) || (paramFloat < -6500.0F)) && (this.s.booleanValue()) && (paramFloat < 100.0F) && (System.currentTimeMillis() - this.t >= 200L) && (this.u < 0.0F) && (this.p.a());
  }
  
  private boolean d(MotionEvent paramMotionEvent)
  {
    if ((this.M) && (paramMotionEvent.getAction() != 0)) {
      if (this.ak < 0)
      {
        if (paramMotionEvent.getAction() == 2)
        {
          if (e(paramMotionEvent)) {
            return true;
          }
          b(paramMotionEvent);
        }
        else
        {
          l();
        }
      }
      else if ((this.N) && (!this.ac) && (this.C != null)) {
        c(paramMotionEvent);
      }
    }
    return false;
  }
  
  private void e(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if ((this.ae != null) && (this.ae.containsKey("floating_window_business"))) {
        localJSONObject.put("Float_type", this.ae.get("floating_window_business"));
      }
      if ((this.ae != null) && (this.ae.containsKey("floating_window_scene"))) {
        localJSONObject.put("source", this.ae.get("floating_window_scene"));
      }
      localJSONObject.put("type", paramInt);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    PublicAccountReportUtils.a(null, null, "0X800A9B8", "0X800A9B8", 0, 0, "", "", "", localJSONObject.toString(), false);
  }
  
  private boolean e(MotionEvent paramMotionEvent)
  {
    return (this.w.getScrollY() < 0) && (paramMotionEvent.getRawY() <= Math.abs(this.w.getScrollY()));
  }
  
  public static boolean h()
  {
    return (Build.MANUFACTURER.contains("Xiaomi")) && ((Build.MODEL.contains("MIX 2S")) || (Build.MODEL.contains("MI 8")) || (Build.MODEL.contains("MI 9")) || (Build.MODEL.contains("MIX 2")) || (Build.MODEL.contains("MIX 3")));
  }
  
  private void l()
  {
    this.r.computeCurrentVelocity(1000);
    float f1 = this.r.getYVelocity(0);
    if (Math.abs(this.w.getScrollY()) <= this.aa)
    {
      c();
      return;
    }
    if ((f1 < 0.0F) && (Math.abs(f1) >= 3500.0F) && (this.n != f)) {
      c();
    }
  }
  
  private void m()
  {
    int i1 = (int)(this.w.getScrollY() - this.i);
    if (i1 < 0)
    {
      a(0, i1, 0, true);
      return;
    }
    a(0, 0, 0, true);
  }
  
  private void n()
  {
    View localView = this.C;
    if ((localView != null) && (localView.getVisibility() != 0) && (Math.abs(this.w.getScrollY()) <= this.aa)) {
      y();
    }
  }
  
  private void o()
  {
    Object localObject = this.w;
    if (localObject == null) {
      return;
    }
    if (this.n == f)
    {
      this.n = a;
      return;
    }
    int i1 = ((View)localObject).getScrollY();
    float f1 = this.r.getYVelocity(0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("closeOrSpringBack judge deltaY:");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(",velocityY:");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(",mCanCloseFromBottom:");
      ((StringBuilder)localObject).append(this.s);
      ((StringBuilder)localObject).append(" , mStateBottomTime ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - this.t);
      ((StringBuilder)localObject).append(", mInterceptDeltaY ");
      ((StringBuilder)localObject).append(this.u);
      QLog.d("CommonSuspensionGestureLayout", 2, ((StringBuilder)localObject).toString());
    }
    if (this.M)
    {
      if (a(i1, f1))
      {
        if (this.N)
        {
          a(0, -ViewUtils.dpToPx(this.O), 200, false);
          z();
          return;
        }
        a(i1, 1);
        return;
      }
      if (b(i1, f1))
      {
        c(i1);
        return;
      }
      if (this.p.a()) {
        d(i1);
      } else {
        a(0, -ViewUtils.dpToPx(this.O), 200, true);
      }
      this.n = a;
      this.o.a(this.n);
      return;
    }
    if (c(i1, f1))
    {
      a(i1, 1);
      return;
    }
    if (d(i1, f1))
    {
      c(i1);
      return;
    }
    a(0, -ViewUtils.dpToPx(this.O), 200, true);
    this.n = a;
    this.o.a(this.n);
  }
  
  private boolean p()
  {
    int i1 = this.n;
    return (i1 == e) || (i1 == d);
  }
  
  private void q()
  {
    this.z = new View(getContext());
    this.z.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.z.setBackgroundColor(Color.parseColor("#66000000"));
    addView(this.z);
  }
  
  private void r()
  {
    if ((this.S) && (this.A == null))
    {
      this.A = new LinearLayout(getContext());
      Object localObject1 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject1).setMargins(0, ViewUtils.dpToPx(40.0F), 0, 0);
      this.A.setOrientation(0);
      this.A.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.A.setBackgroundResource(2130851509);
      localObject1 = new TextView(getContext());
      Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).setMargins(ViewUtils.dpToPx(12.0F), 0, 0, 0);
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((TextView)localObject1).setTextSize(2, 14.0F);
      ((TextView)localObject1).setText("返回");
      localObject2 = new ImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(ViewUtils.dpToPx(6.0F), 0, 0, 0);
      localLayoutParams.gravity = 16;
      ((ImageView)localObject2).setLayoutParams(localLayoutParams);
      ((ImageView)localObject2).setBackgroundResource(2130851508);
      this.A.addView((View)localObject1);
      this.A.addView((View)localObject2);
      addView(this.A);
      this.A.setOnClickListener(new CommonSuspensionGestureLayout.10(this));
    }
  }
  
  private void s()
  {
    if (this.L == null)
    {
      this.L = ((AnimationSet)AnimationUtils.loadAnimation(getContext(), 2130772157));
      this.L.setDuration(200L);
      this.L.setInterpolator(new AccelerateDecelerateInterpolator());
      this.L.setAnimationListener(new CommonSuspensionGestureLayout.11(this));
    }
  }
  
  private void t()
  {
    this.x.addView(this, this.Z);
  }
  
  private void u()
  {
    this.w.startAnimation(this.L);
  }
  
  private void v()
  {
    b(false);
  }
  
  private void w()
  {
    FrameLayout localFrameLayout = this.B;
    if ((localFrameLayout != null) && (localFrameLayout.getVisibility() != 8)) {
      this.B.setVisibility(8);
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.y.setOutlineProvider(null);
      this.y.setClipToOutline(false);
    }
  }
  
  private void x()
  {
    View localView = this.F;
    if (localView != null) {
      localView.scrollTo(0, 0);
    }
    localView = this.G;
    if (localView != null) {
      localView.scrollTo(0, 0);
    }
  }
  
  private void y()
  {
    Object localObject = this.C;
    if ((localObject != null) && ((((View)localObject).getAlpha() != 1.0F) || (this.C.getVisibility() != 0)))
    {
      this.ac = false;
      localObject = this.K;
      if ((localObject != null) && (!((ObjectAnimator)localObject).isRunning()))
      {
        a();
        a(true, this.C);
      }
    }
  }
  
  private void z()
  {
    Object localObject = this.B;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() != 0)) {
      this.B.setVisibility(0);
    }
    if (!this.W) {
      c(this.y);
    }
    this.N = false;
    this.ac = false;
    localObject = this.C;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8)) {
      this.C.setVisibility(8);
    }
    if (this.F != null)
    {
      int i1 = (FlexConvertUtils.getScreenHeight(getContext()) - ViewUtils.dpToPx(this.O) - this.F.getHeight()) / 2;
      this.F.scrollTo(0, -i1);
    }
    localObject = this.G;
    if (localObject != null) {
      ((View)localObject).scrollTo(0, ViewUtils.dpToPx(this.O));
    }
  }
  
  public void a()
  {
    if (this.V) {
      return;
    }
    if (this.M)
    {
      Object localObject = this.C;
      if ((localObject != null) && (this.ab) && ((((View)localObject).getLayoutParams() instanceof FrameLayout.LayoutParams)))
      {
        localObject = (FrameLayout.LayoutParams)this.C.getLayoutParams();
        if (((FrameLayout.LayoutParams)localObject).height != this.aa + ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()))
        {
          ((FrameLayout.LayoutParams)localObject).height = (this.aa + ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
          ((FrameLayout.LayoutParams)localObject).topMargin = 0;
          this.C.setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()), 0, 0);
          this.C.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.C = this.y.findViewById(paramInt);
    a(this.C);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!this.H)
    {
      this.o.a(true, paramInt1);
      return;
    }
    if (this.I == null) {
      this.I = ((TranslateAnimation)AnimationUtils.loadAnimation(getContext(), 2130772018));
    }
    this.I.setAnimationListener(new CommonSuspensionGestureLayout.7(this, paramInt1, paramInt2));
    this.I.setDuration(200L);
    this.I.setInterpolator(new AccelerateInterpolator());
    this.w.startAnimation(this.I);
    a(false, this.z);
  }
  
  public void a(View paramView)
  {
    a(paramView, 0.0F);
  }
  
  public void a(View paramView, float paramFloat)
  {
    this.C = paramView;
    View localView = this.C;
    if ((localView != null) && ((localView.getParent() instanceof ViewGroup)) && (this.ag != paramView.hashCode()))
    {
      this.ag = paramView.hashCode();
      this.C.setVisibility(4);
      if (this.aa != 0)
      {
        a(false);
        return;
      }
      this.aa = ((int)paramFloat);
      if (this.aa == 0)
      {
        this.C.post(new CommonSuspensionGestureLayout.3(this));
        return;
      }
      a(true);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, int paramInt1, int paramInt2)
  {
    a(paramQBaseActivity, paramInt1, paramInt2, false);
  }
  
  public void a(QBaseActivity paramQBaseActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.ad = paramQBaseActivity;
    this.w = ((ViewGroup)paramQBaseActivity.getWindow().getDecorView()).getChildAt(0);
    if ((this.w.getParent() instanceof ViewGroup))
    {
      this.x = ((ViewGroup)this.w.getParent());
      this.Z = this.x.indexOfChild(this.w);
      paramQBaseActivity = new FrameLayout(getContext());
      this.x.removeView(this.w);
      paramQBaseActivity.addView(this.w);
      paramQBaseActivity.setBackgroundColor(0);
      this.y = this.w;
      this.w = paramQBaseActivity;
      a(paramQBaseActivity);
      addView(paramQBaseActivity);
      this.w.scrollTo(0, -ViewUtils.dpToPx(this.O));
      this.ak = (-ViewUtils.dpToPx(this.O));
      this.y.setBackgroundColor(this.U);
    }
    if (!this.W) {
      c(this.y);
    }
    if (this.M)
    {
      int i1 = this.aa;
      if (i1 != 0) {
        this.w.setPadding(0, i1, 0, 0);
      }
    }
    if (this.R)
    {
      if (paramBoolean)
      {
        ViolaSDKManager.getInstance().postOnUiThreadDelay(new CommonSuspensionGestureLayout.5(this, paramInt1, paramInt2), 150L);
        return;
      }
      b(paramInt1, paramInt2);
      u();
      return;
    }
    b(paramInt1, paramInt2);
    paramQBaseActivity = this.o;
    if (paramQBaseActivity != null) {
      paramQBaseActivity.a();
    }
    A();
  }
  
  public boolean a(float paramFloat, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      if (this.p != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("test isAllowedInterceptTouchEvent,positionState:");
        localStringBuilder.append(this.p.getPositionState());
        localStringBuilder.append(",deltaY:");
        localStringBuilder.append(paramFloat);
        localStringBuilder.append(",event:");
        localStringBuilder.append(paramMotionEvent.getAction());
        QLog.d("CommonSuspensionGestureLayout", 2, localStringBuilder.toString());
      }
      else
      {
        QLog.d("CommonSuspensionGestureLayout", 2, "mContentScrollListener is null");
      }
    }
    if ((this.p != null) && (paramMotionEvent.getAction() != 0))
    {
      int i1 = this.p.getPositionState();
      this.o.b(i1);
      if ((i1 == 1) && (paramFloat > 5.0F))
      {
        this.t = 0L;
        return true;
      }
      if ((i1 == 2) && (paramFloat < 0.0F) && (this.s.booleanValue()))
      {
        if (this.t == 0L) {
          this.t = System.currentTimeMillis();
        }
        return true;
      }
      paramMotionEvent = this.p;
      if ((paramMotionEvent != null) && (!paramMotionEvent.a()) && (paramFloat < -10.0F))
      {
        this.t = 0L;
        return true;
      }
      this.t = 0L;
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    b(this.y.findViewById(paramInt));
  }
  
  public void b(View paramView)
  {
    this.D = paramView;
    paramView = this.D;
    if ((paramView != null) && ((paramView.getParent() instanceof ViewGroup))) {
      this.D.post(new CommonSuspensionGestureLayout.4(this));
    }
  }
  
  public void b(View paramView, float paramFloat)
  {
    this.F = paramView;
    if ((this.F != null) && (this.ah != paramView.hashCode()))
    {
      this.ah = paramView.hashCode();
      int i1 = (int)(FlexConvertUtils.getScreenHeight(getContext()) - ViewUtils.dpToPx(this.O) - paramFloat) / 2;
      this.F.scrollTo(0, -i1);
    }
  }
  
  public boolean b()
  {
    return this.w.getScrollY() >= 0;
  }
  
  public void c()
  {
    a(0, 0, 100, true);
    v();
    y();
  }
  
  public void c(int paramInt)
  {
    if (!this.H)
    {
      this.o.a(false, paramInt);
      return;
    }
    if (this.J == null) {
      this.J = ((TranslateAnimation)AnimationUtils.loadAnimation(getContext(), 2130772257));
    }
    this.J.setAnimationListener(new CommonSuspensionGestureLayout.8(this, paramInt));
    this.J.setDuration(200L);
    this.J.setInterpolator(new AccelerateInterpolator());
    this.w.startAnimation(this.J);
    a(false, this.z);
  }
  
  public void c(View paramView, float paramFloat)
  {
    this.G = paramView;
    if ((this.G != null) && (this.ai != paramView.hashCode()))
    {
      this.ai = paramView.hashCode();
      this.G.scrollTo(0, ViewUtils.dpToPx(this.O));
    }
  }
  
  public void computeScroll()
  {
    if (this.m == null) {
      this.m = new Scroller(this.q);
    }
    if (this.w == null) {
      return;
    }
    if (this.m.computeScrollOffset())
    {
      if (!this.M)
      {
        if (Math.abs(this.m.getCurrY()) >= ViewUtils.dpToPx(this.O)) {
          this.w.scrollTo(this.m.getCurrX(), this.m.getCurrY());
        }
      }
      else if ((this.w.getScrollY() <= 0) && (this.m.getCurrY() > 0))
      {
        this.w.scrollTo(this.m.getCurrX(), 0);
        v();
        y();
      }
      else
      {
        this.w.scrollTo(this.m.getCurrX(), this.m.getCurrY());
      }
      postInvalidate();
      return;
    }
    if ((this.w.getScrollY() == 0) && (this.n != a)) {
      ViolaSDKManager.getInstance().postOnUiThreadDelay(new CommonSuspensionGestureLayout.6(this), 32L);
    }
  }
  
  public boolean d()
  {
    return this.S;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.ak = this.w.getScrollY();
    }
    if (this.aj) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (this.r == null) {
      this.r = VelocityTracker.obtain();
    }
    this.r.addMovement(paramMotionEvent);
    CommonSuspensionGestureLayout.ContentScrollListener localContentScrollListener = this.p;
    if ((localContentScrollListener != null) && (!localContentScrollListener.a()))
    {
      a(paramMotionEvent);
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (d(paramMotionEvent)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    this.j = paramMotionEvent.getRawY();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    if (this.y != null)
    {
      Object localObject = this.D;
      if (localObject != null)
      {
        int i1;
        if (((View)localObject).getVisibility() == 8) {
          i1 = 0;
        } else {
          i1 = this.D.getHeight();
        }
        int i2 = i1;
        if (!this.M)
        {
          int i3 = this.O;
          i2 = i1;
          if (i3 > 0) {
            i2 = i1 + ViewUtils.dpToPx(i3);
          }
        }
        this.y.setPadding(0, 0, 0, i2);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("heightPadding ");
        ((StringBuilder)localObject).append(i2);
        QLog.d("CommonSuspensionGestureLayout", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void f()
  {
    e(4);
  }
  
  public void g()
  {
    View.OnLayoutChangeListener localOnLayoutChangeListener = this.v;
    if (localOnLayoutChangeListener != null) {
      removeOnLayoutChangeListener(localOnLayoutChangeListener);
    }
  }
  
  public int getOriginTitleBarHeight()
  {
    return this.aa;
  }
  
  public void i()
  {
    this.aj = true;
    this.am = this.M;
    this.M = true;
    c();
  }
  
  public void j()
  {
    this.aj = false;
    this.M = this.am;
    if (!this.M)
    {
      a(0, -ViewUtils.dpToPx(this.O), 200, false);
      z();
    }
  }
  
  public boolean k()
  {
    return this.M;
  }
  
  protected void onDetachedFromWindow()
  {
    VelocityTracker localVelocityTracker = this.r;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.r = null;
    }
    g();
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.w != null) && (!this.aj))
    {
      float f2 = this.l;
      float f1 = 0.0F;
      if (f2 != 0.0F) {
        f1 = paramMotionEvent.getRawY() - this.l;
      }
      this.u = f1;
      this.k = paramMotionEvent.getRawX();
      this.l = paramMotionEvent.getRawY();
      return a(this.u, paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.w != null) && (paramMotionEvent.getAction() != 0))
    {
      if (this.p == null) {
        return false;
      }
      if ((this.w.getScrollY() < 0) && (paramMotionEvent.getRawY() <= Math.abs(this.w.getScrollY())) && (this.w.getScrollY() >= -ViewUtils.dpToPx(this.O))) {
        return false;
      }
      if (this.r == null) {
        this.r = VelocityTracker.obtain();
      }
      this.r.addMovement(paramMotionEvent);
      float f1;
      if (this.l != 0.0F) {
        f1 = paramMotionEvent.getRawY() - this.l;
      } else {
        f1 = 0.0F;
      }
      this.k = paramMotionEvent.getRawX();
      this.l = paramMotionEvent.getRawY();
      if (paramMotionEvent.getAction() != 2)
      {
        this.r.computeCurrentVelocity(1000);
        f1 = this.r.getYVelocity(0);
        paramView = this.p;
        if ((paramView != null) && (!paramView.a()) && (this.w.getScrollY() != -ViewUtils.dpToPx(this.O)) && (f1 < 0.0F))
        {
          a(0, -ViewUtils.dpToPx(this.O), 200, false);
          return true;
        }
        if (this.M)
        {
          if (paramMotionEvent.getRawY() >= Math.abs(this.w.getScrollY()) + Math.abs(this.w.getPaddingTop()))
          {
            o();
            return true;
          }
          if (this.w.getScrollY() != 0)
          {
            a(0, 2);
            return true;
          }
        }
        else
        {
          o();
        }
        return true;
      }
      int i1 = (int)(this.w.getScrollY() - f1);
      if (this.p.a())
      {
        a(0, i1, 0, false);
        return true;
      }
      if (i1 <= this.ak) {
        a(0, i1, 0, false);
      }
      return true;
    }
    return false;
  }
  
  public void setBorderRadius(int paramInt)
  {
    this.P = paramInt;
  }
  
  public void setCanCloseFromBottom(boolean paramBoolean)
  {
    this.s = Boolean.valueOf(paramBoolean);
  }
  
  public void setContainerColor(int paramInt)
  {
    this.U = paramInt;
  }
  
  public void setContentMarginTop(int paramInt)
  {
    this.O = paramInt;
  }
  
  public void setContentScrollListener(CommonSuspensionGestureLayout.ContentScrollListener paramContentScrollListener)
  {
    this.p = paramContentScrollListener;
  }
  
  public void setIsAutoSuctionTop(boolean paramBoolean)
  {
    this.M = paramBoolean;
  }
  
  public void setIsNeedChangeTitleAlpha(boolean paramBoolean)
  {
    this.V = paramBoolean;
  }
  
  public void setIsNeedGrayBarFloat(boolean paramBoolean)
  {
    this.W = paramBoolean;
  }
  
  public void setIsNeedInterruptBack(boolean paramBoolean)
  {
    this.T = paramBoolean;
  }
  
  public void setIsNeedPopAnim(boolean paramBoolean)
  {
    this.R = paramBoolean;
  }
  
  public void setIsNeedShowBackView(boolean paramBoolean)
  {
    this.S = paramBoolean;
    if (!this.S)
    {
      LinearLayout localLinearLayout = this.A;
      if (localLinearLayout != null) {
        localLinearLayout.setVisibility(8);
      }
    }
    else
    {
      r();
    }
  }
  
  public void setIsShowGrayBar(boolean paramBoolean)
  {
    this.Q = paramBoolean;
  }
  
  public void setIsStatusImmersive(boolean paramBoolean)
  {
    this.ab = paramBoolean;
  }
  
  public void setIsUseDefaultAnim(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  public void setMaskBackGroundDrawable(Drawable paramDrawable)
  {
    Activity localActivity = this.ad;
    if ((localActivity != null) && (localActivity.getWindow() != null)) {
      this.ad.getWindow().setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setTitleBarHeight(int paramInt)
  {
    this.aa = ViewUtils.dpToPx(paramInt);
  }
  
  public void setViolaGestureListener(CommonSuspensionGestureLayout.SuspensionGestureListener paramSuspensionGestureListener)
  {
    this.o = paramSuspensionGestureListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout
 * JD-Core Version:    0.7.0.1
 */
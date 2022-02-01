package com.tencent.mobileqq.colornote.smallscreen;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.anim.FloatingWindowDrawable;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;
import com.tencent.mobileqq.colornote.anim.MusicDanceImageView;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.list.DefaultItemBuilder;
import com.tencent.mobileqq.dinifly.Cancellable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ColorNoteSmallScreenRelativeLayout
  extends RelativeLayout
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, IFloatingView
{
  private static boolean W = false;
  private static int[] ac = { 0, 9, 5, 3 };
  private static float[] ad = { 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 3.0F, 2.0F, 2.5F, 2.0F };
  private Point A = new Point(0, 0);
  private int B = 0;
  private int C = 0;
  private int D = 0;
  private ColorNoteSmallScreenRelativeLayout.SmallScreenOrientationEventListener E = null;
  private Point F = new Point();
  private ColorNoteSmallScreenRelativeLayout.CheckForLongPress G = new ColorNoteSmallScreenRelativeLayout.CheckForLongPress(this, null);
  private MqqHandler H = new MqqHandler(Looper.getMainLooper());
  private LinearLayout I;
  private int J = -1;
  private int K = -1;
  private MusicDanceImageView L;
  private MusicDanceImageView M;
  private RelativeLayout N;
  private LinearLayout O;
  private List<ColorNote> P;
  private FloatingWindowDrawable Q;
  private FloatingWindowDrawable R;
  private boolean S = false;
  private boolean T;
  private int U = -1;
  private boolean V = false;
  private IUpcomingController Z;
  private ColorNoteSmallScreenRelativeLayout.FloatListener a;
  private boolean aa = false;
  private boolean ab = false;
  private int ae = 1;
  private LottieDrawable af;
  private Cancellable ag;
  private ValueAnimator b;
  private ValueAnimator c;
  private ValueAnimator d;
  private Display e;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private long i = 0L;
  private boolean j = false;
  private boolean k = true;
  private final int l;
  private final int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t = -1;
  private int u = -1;
  private int v = -1;
  private int w = -1;
  private int x = -1;
  private int y = -1;
  private int z = -1;
  
  public ColorNoteSmallScreenRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ColorNoteSmallScreenRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ColorNoteSmallScreenRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "SmallScreenRelativeLayout");
    }
    this.m = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.n = getResources().getDimensionPixelSize(2131297033);
    this.o = getResources().getDimensionPixelSize(2131297032);
    paramInt = this.n;
    this.p = paramInt;
    double d1 = paramInt;
    Double.isNaN(d1);
    this.q = ((int)(d1 * 1.5D));
    this.r = (paramInt * 2);
    this.s = this.q;
    this.l = getResources().getDimensionPixelSize(2131298647);
    this.b = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.b.setDuration(200L);
    this.b.addListener(this);
    this.b.addUpdateListener(this);
    this.d = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.d.setDuration(300L);
    this.d.addListener(this);
    this.d.addUpdateListener(this);
    this.c = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.c.setDuration(400L);
    this.c.addListener(this);
    this.e = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.B = getSysRotation();
    if (Build.VERSION.SDK_INT != 23) {
      this.E = new ColorNoteSmallScreenRelativeLayout.SmallScreenOrientationEventListener(this, getContext(), 2);
    }
    this.D = ViewUtils.getScreenHeight();
    this.C = ViewUtils.getScreenWidth();
    this.z = Utils.a(8.0F, getResources());
    this.I = ((LinearLayout)findViewById(2131446099));
    this.N = ((RelativeLayout)findViewById(2131432148));
    this.O = ((LinearLayout)findViewById(2131446098));
    this.L = ((MusicDanceImageView)findViewById(2131436465));
    this.M = ((MusicDanceImageView)findViewById(2131436466));
  }
  
  private int a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 4)) {
      return DisplayUtil.a(getContext(), ac[paramInt]);
    }
    return DisplayUtil.a(getContext(), 4.0F);
  }
  
  private SmallColorNoteItem a(ColorNote paramColorNote, ViewGroup paramViewGroup)
  {
    paramViewGroup = new SmallColorNoteItem(getContext(), g(), paramViewGroup);
    paramViewGroup.setAttachLeft(g());
    View localView = paramViewGroup.getRoot().findViewById(2131439409);
    ImageView localImageView = (ImageView)paramViewGroup.getRoot().findViewById(2131439410);
    new DefaultItemBuilder().a(paramColorNote, localView, localImageView, g());
    paramColorNote = localView.findViewById(2131439420);
    localView = localView.findViewById(2131439418);
    ViewCompat.setImportantForAccessibility(paramViewGroup, 2);
    ViewCompat.setImportantForAccessibility(paramColorNote, 2);
    ViewCompat.setImportantForAccessibility(localView, 2);
    paramColorNote = (RelativeLayout.LayoutParams)findViewById(2131433501).getLayoutParams();
    if (g())
    {
      paramColorNote.addRule(9, 0);
      paramColorNote.addRule(11);
      return paramViewGroup;
    }
    paramColorNote.addRule(11, 0);
    paramColorNote.addRule(9);
    return paramViewGroup;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i5 = this.t + paramInt1 - this.v;
    int i4 = this.u + paramInt2 - this.w;
    int i6 = getRealWidth();
    this.n = i6;
    int i7 = this.o;
    int i1 = getMaxLeft();
    int i3 = this.D - i7;
    int i2 = getMinLeft();
    paramInt1 = i5;
    if (i5 < i2) {
      paramInt1 = i2;
    }
    if (paramInt1 > i1) {
      paramInt2 = i1;
    } else {
      paramInt2 = paramInt1;
    }
    paramInt1 = i4;
    if (i4 < 0) {
      paramInt1 = 0;
    }
    if (paramInt1 > i3) {
      paramInt1 = i3;
    }
    if (((paramInt2 > i2) && (paramInt2 < i1)) || (this.V))
    {
      this.K = this.J;
      this.J = 2;
      i1 = getRealWidth();
      this.n = i1;
      i2 = this.o;
      a(this, paramInt2, paramInt1, paramInt2 + i1, paramInt1 + i2);
      i3 = this.K;
      i4 = this.J;
      if (i3 != i4) {
        a(i4, i3, paramInt2, paramInt1, i1, i2, false);
      }
      if (QQTheme.isNowThemeIsNight())
      {
        setBackgroundResource(2130839424);
        return;
      }
      setBackgroundResource(2130839427);
      return;
    }
    if (paramInt2 == i2)
    {
      this.K = this.J;
      this.J = 0;
      i1 = this.K;
      i2 = this.J;
      if (i1 != i2) {
        a(i2, i1, paramInt2, paramInt1, i6, i7);
      }
      a(this, paramInt2, paramInt1, paramInt2 + i6, paramInt1 + i7);
      if (QQTheme.isNowThemeIsNight())
      {
        setBackgroundResource(2130839423);
        return;
      }
      setBackgroundResource(2130839426);
      return;
    }
    if (paramInt2 == i1)
    {
      this.K = this.J;
      this.J = 1;
      this.ab = false;
      i1 = this.K;
      i2 = this.J;
      if (i1 != i2) {
        a(i2, i1, paramInt2, paramInt1, i6, i7);
      }
      a(this, paramInt2, paramInt1, paramInt2 + i6, paramInt1 + i7);
      if (QQTheme.isNowThemeIsNight())
      {
        setBackgroundResource(2130839425);
        return;
      }
      setBackgroundResource(2130839428);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, true);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Point localPoint = this.F;
      localPoint.x = paramInt3;
      localPoint.y = paramInt4;
      if (localPoint.x < 0) {
        paramInt2 = 0;
      } else {
        paramInt2 = 1;
      }
      this.J = paramInt2;
    }
    if (paramInt1 == 0)
    {
      if (h()) {
        m();
      } else {
        l();
      }
      q();
      return;
    }
    if (paramInt1 == 1)
    {
      if (h()) {
        n();
      } else {
        l();
      }
      q();
      return;
    }
    if (paramInt1 == 2) {
      p();
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.af != null)
    {
      if (!paramBoolean) {
        t();
      }
      return;
    }
    ThreadManagerV2.excute(new ColorNoteSmallScreenRelativeLayout.6(this, paramString1, paramContext, paramString2, paramBoolean), 16, null, true);
  }
  
  private void a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ColorNoteSmallScreenRelativeLayout.FloatListener localFloatListener = this.a;
    if (localFloatListener != null)
    {
      localFloatListener.a(paramColorNoteSmallScreenRelativeLayout, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    MusicDanceDrawable localMusicDanceDrawable;
    if (paramInt == 1) {
      localMusicDanceDrawable = new MusicDanceDrawable();
    } else {
      localMusicDanceDrawable = null;
    }
    if (localMusicDanceDrawable == null) {
      return;
    }
    if (paramBoolean)
    {
      this.Q = localMusicDanceDrawable;
      localMusicDanceDrawable.a(getContext(), DisplayUtil.a(getContext(), 15.0F), DisplayUtil.a(getContext(), 9.5F), getContext().getResources().getColor(2131165828));
      this.M.setImageDrawable((Drawable)localMusicDanceDrawable);
      return;
    }
    this.R = localMusicDanceDrawable;
    localMusicDanceDrawable.a(getContext(), DisplayUtil.a(getContext(), 15.0F), DisplayUtil.a(getContext(), 9.5F), getContext().getResources().getColor(2131165828));
    this.L.setImageDrawable((Drawable)localMusicDanceDrawable);
  }
  
  private float b(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 9)) {}
    for (paramInt = DisplayUtil.a(getContext(), ad[paramInt]);; paramInt = getResources().getDimensionPixelSize(2131299714)) {
      return paramInt;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.ae = paramInt2;
    if (paramInt1 == 1)
    {
      l();
      return;
    }
    if ((paramInt1 == 3) || (paramInt1 == 2) || (paramInt1 == 4))
    {
      if (g())
      {
        m();
        return;
      }
      this.ab = true;
      n();
    }
  }
  
  public static boolean getCustomNightMode()
  {
    return W;
  }
  
  private int getState()
  {
    return this.J;
  }
  
  private int getSysRotation()
  {
    try
    {
      int i1 = this.e.getRotation();
      return i1;
    }
    catch (Exception localException)
    {
      QLog.e("ColorNoteSmallScreenRelativeLayout", 1, new Object[] { "[getSysRotation]", localException.getMessage() });
    }
    return 0;
  }
  
  private void k()
  {
    int i2 = getRealLeft();
    int i1 = getRealWidth() + i2 - this.z;
    if (getState() == 0) {
      i1 = getVisibleWidth() - this.z;
    } else if (getState() == 1) {
      i1 = getRealWidth() + i2;
    }
    int i3 = this.F.y;
    int i4 = i3 + this.o;
    ColorNoteSmallScreenRelativeLayout.FloatListener localFloatListener = this.a;
    if (localFloatListener != null)
    {
      localFloatListener.a(this, i2, i3, i1, i4);
      return;
    }
    layout(i2, i3, i1, i4);
  }
  
  private void l()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.O.getLayoutParams();
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131446099);
    this.n = this.p;
    this.L.setVisibility(8);
    this.M.setVisibility(8);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    if (g()) {
      i1 = getResources().getDimensionPixelSize(2131299719);
    } else {
      i1 = getResources().getDimensionPixelSize(2131299717);
    }
    localLayoutParams1.width = i1;
    boolean bool = g();
    int i1 = 0;
    if (bool)
    {
      localLayoutParams1.rightMargin = DisplayUtil.a(localLinearLayout.getContext(), 10.0F);
      localLayoutParams1.leftMargin = 0;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
    }
    else
    {
      localLayoutParams1.leftMargin = DisplayUtil.a(localLinearLayout.getContext(), 10.0F);
      localLayoutParams1.rightMargin = 0;
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(9);
    }
    localLinearLayout.setLayoutParams(localLayoutParams1);
    localLinearLayout.setVisibility(0);
    this.L.getViewTreeObserver().addOnGlobalLayoutListener(new ColorNoteSmallScreenRelativeLayout.2(this));
    this.F.x = getRealLeft();
    if (this.F.x >= 0) {
      i1 = 1;
    }
    this.J = i1;
    if (this.ae != 2) {
      k();
    }
  }
  
  private void m()
  {
    if (!h()) {
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)this.O.getLayoutParams();
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131446099);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.M.getLayoutParams();
    this.M.setVisibility(0);
    this.M.setScaleX(1.0F);
    this.M.setScaleY(1.0F);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    if (ColorNoteUtils.b(this.P))
    {
      a(getContext(), "colornote/data.json", "colornote/images", false);
    }
    else
    {
      a(true, 1);
      if (this.Q == null)
      {
        this.Q = new MusicDanceDrawable();
        this.Q.a(getContext(), DisplayUtil.a(getContext(), 15.0F), DisplayUtil.a(getContext(), 9.5F), getContext().getResources().getColor(2131165828));
      }
      this.M.setImageDrawable((Drawable)this.Q);
      this.Q.a(300);
      FloatingWindowDrawable localFloatingWindowDrawable = this.R;
      if (localFloatingWindowDrawable != null) {
        localFloatingWindowDrawable.stop();
      }
    }
    this.L.setVisibility(8);
    localLayoutParams.rightMargin = DisplayUtil.a(getContext(), 13.5F);
    if ((this.P.size() == 1) && (this.S))
    {
      localLinearLayout.setVisibility(8);
      this.n = this.p;
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      localLayoutParams.rightMargin = DisplayUtil.a(getContext(), 17.5F);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
      this.n = this.q;
      localLinearLayout.setVisibility(0);
      localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      localLinearLayout.setGravity(16);
      ((LinearLayout.LayoutParams)localObject).width = getResources().getDimensionPixelSize(2131299719);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      if (g())
      {
        ((LinearLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(getContext(), 13.5F);
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
      }
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      f();
    }
    k();
  }
  
  private void n()
  {
    if (!h()) {
      return;
    }
    Object localObject1 = (RelativeLayout.LayoutParams)this.O.getLayoutParams();
    int i1;
    if ((this.ab) && (this.P.size() > 1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131446099);
    this.M.setVisibility(8);
    Object localObject2 = this.Q;
    if (localObject2 != null) {
      ((FloatingWindowDrawable)localObject2).stop();
    }
    this.L.setScaleX(1.0F);
    this.L.setScaleY(1.0F);
    localObject2 = (LinearLayout.LayoutParams)this.L.getLayoutParams();
    if (i1 == 0)
    {
      this.L.setVisibility(0);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = DisplayUtil.a(getContext(), 13.5F);
    }
    int i2;
    if (ColorNoteUtils.b(this.P))
    {
      a(getContext(), "colornote/data.json", "colornote/images", false);
      i2 = 0;
    }
    else
    {
      a(false, 1);
      i2 = 1;
    }
    if (i2 != 0)
    {
      if (this.R == null)
      {
        this.R = new MusicDanceDrawable();
        this.R.a(getContext(), DisplayUtil.a(getContext(), 15.0F), DisplayUtil.a(getContext(), 9.5F), getContext().getResources().getColor(2131165828));
      }
      this.L.setImageDrawable((Drawable)this.R);
      this.R.a(300);
    }
    if ((this.P.size() == 1) && (this.S))
    {
      localLinearLayout.setVisibility(8);
      this.n = this.p;
      ((RelativeLayout.LayoutParams)localObject1).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(9);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11, 0);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = DisplayUtil.a(getContext(), 17.5F);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject1).addRule(11, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(9);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13, 0);
      this.n = this.q;
      localLinearLayout.setVisibility(0);
      localObject1 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).gravity = 16;
      if (i1 == 0)
      {
        ((LinearLayout.LayoutParams)localObject1).width = getResources().getDimensionPixelSize(2131299717);
        if (!g())
        {
          ((LinearLayout.LayoutParams)localObject1).leftMargin = DisplayUtil.a(getContext(), 14.5F);
          ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
        }
        localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    if (i1 == 0) {
      this.L.getViewTreeObserver().addOnPreDrawListener(new ColorNoteSmallScreenRelativeLayout.3(this));
    }
    if (i1 != 0)
    {
      o();
      return;
    }
    k();
  }
  
  private void o()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(100L);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.I.getLayoutParams();
    int i1 = localLayoutParams.leftMargin;
    Point localPoint = this.F;
    localPoint.x = (this.C - this.p + this.z);
    localValueAnimator.addUpdateListener(new ColorNoteSmallScreenRelativeLayout.4(this, this, localPoint, localLayoutParams, i1));
    localValueAnimator.addListener(new ColorNoteSmallScreenRelativeLayout.5(this));
    localValueAnimator.start();
  }
  
  private void p()
  {
    this.O.setVisibility(8);
    this.N.setVisibility(0);
    this.n = this.p;
  }
  
  private void q()
  {
    this.O.setVisibility(0);
    this.N.setVisibility(8);
  }
  
  private boolean r()
  {
    return this.J == 2;
  }
  
  private void s()
  {
    if ((!QQTheme.isNowThemeIsNight()) && (!W))
    {
      if (this.F.x <= 0)
      {
        setBackgroundResource(2130839426);
        return;
      }
      setBackgroundResource(2130839428);
      return;
    }
    if (this.F.x <= 0)
    {
      setBackgroundResource(2130839423);
      return;
    }
    setBackgroundResource(2130839425);
  }
  
  private void t()
  {
    if (this.af == null)
    {
      QLog.e("ColorNoteSmallScreenRelativeLayout", 1, "lottie loaded but still null");
      return;
    }
    QLog.d("ColorNoteSmallScreenRelativeLayout", 4, "play animation");
    float f1 = getContext().getResources().getDisplayMetrics().density / 2.0F;
    this.af.setScale(f1, f1);
    if (g())
    {
      this.M.setScaleX(f1);
      this.M.setScaleY(f1);
      this.M.setImageDrawable(this.af);
    }
    else
    {
      this.L.setScaleX(f1);
      this.L.setScaleY(f1);
      this.L.setImageDrawable(this.af);
    }
    this.af.setRepeatCount(-1);
    this.af.playAnimation();
  }
  
  public void a()
  {
    int i4 = getSysRotation();
    boolean bool = ColorNoteSmallScreenUtil.a();
    int i2;
    if (i4 % 2 == 1)
    {
      i1 = ViewUtils.getScreenWidth();
      i2 = ViewUtils.getScreenHeight();
    }
    else
    {
      i2 = ViewUtils.getScreenWidth();
      i1 = ViewUtils.getScreenHeight();
    }
    int i3 = i1;
    if (bool) {
      i3 = i1 - this.l;
    }
    int i1 = this.B;
    if ((i1 != i4) || (i2 != this.C) || ((i4 == 0) && (this.D < i3)) || ((i4 != 0) && (this.D != i3)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onOrientationChangedInner, mPosition[");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append("], mRotation[");
        ((StringBuilder)localObject).append(this.B);
        ((StringBuilder)localObject).append("->");
        ((StringBuilder)localObject).append(i4);
        ((StringBuilder)localObject).append("], mScreenWidth[");
        ((StringBuilder)localObject).append(this.C);
        ((StringBuilder)localObject).append("->");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append("], mScreenHeight[");
        ((StringBuilder)localObject).append(this.D);
        ((StringBuilder)localObject).append("->");
        ((StringBuilder)localObject).append(i3);
        ((StringBuilder)localObject).append("], mIsInit[");
        ((StringBuilder)localObject).append(this.k);
        ((StringBuilder)localObject).append("]");
        QLog.w("ColorNoteSmallScreenRelativeLayout", 1, ((StringBuilder)localObject).toString());
      }
      if ((this.k) && (i4 != 0)) {
        this.k = false;
      }
      this.b.cancel();
      this.B = i4;
      this.C = i2;
      this.D = i3;
      this.F = new Point(getRealLeft(), i3 / 2);
      setCurPosition(this.F);
      Object localObject = this.a;
      if (localObject != null)
      {
        i1 = ((ColorNoteSmallScreenRelativeLayout.FloatListener)localObject).a(this);
        this.x = i1;
        this.t = i1;
        i1 = this.a.b(this);
        this.y = i1;
        this.u = i1;
        this.a.a(this.F, this.B);
      }
      else
      {
        i1 = getLeft();
        this.x = i1;
        this.t = i1;
        i1 = getTop();
        this.y = i1;
        this.u = i1;
      }
      if (!this.k) {
        this.b.start();
      }
    }
  }
  
  public void a(List<ColorNote> paramList)
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131446099);
    boolean bool = ColorNoteUtils.a(this.P, paramList);
    if ((localLinearLayout != null) && (paramList.size() > 0))
    {
      Object localObject = this.P;
      int i4 = 0;
      int i2;
      if (localObject == null) {
        i2 = 0;
      } else {
        i2 = ((List)localObject).size();
      }
      if ((!this.T) && ((bool ^ true)))
      {
        localObject = paramList.iterator();
        int i1 = 0;
        int i3 = 0;
        while (((Iterator)localObject).hasNext())
        {
          ColorNote localColorNote = (ColorNote)((Iterator)localObject).next();
          if (localColorNote.getServiceType() == 16973824) {
            if (localColorNote.animate)
            {
              localColorNote.animate = false;
              i1 = 1;
              i3 = 1;
            }
            else
            {
              i1 = 1;
            }
          }
        }
        int i5 = 0;
        while (i4 < i2)
        {
          if (((ColorNote)this.P.get(i4)).getServiceType() == 16973824) {
            i5 = 1;
          }
          i4 += 1;
        }
        this.P = paramList;
        if (((i3 != 0) || ((i1 == 0) && (i5 != 0))) && (Math.abs(paramList.size() - i2) == 1))
        {
          f();
          return;
        }
        this.T = true;
        paramList = localLinearLayout.animate();
        if (g()) {
          i1 = -localLinearLayout.getMeasuredWidth();
        } else {
          i1 = localLinearLayout.getMeasuredWidth();
        }
        paramList.translationX(i1).setDuration(200L).setListener(new ColorNoteSmallScreenRelativeLayout.1(this, localLinearLayout)).start();
        return;
      }
      this.P = paramList;
      f();
      return;
    }
    this.P = paramList;
    f();
  }
  
  public void b()
  {
    this.F.x = getRealLeft();
  }
  
  public void c()
  {
    if ((this.C != 0) && (this.D != 0))
    {
      Point localPoint = this.F;
      int i1 = getRealWidth();
      this.n = i1;
      int i2 = this.o;
      ColorNoteSmallScreenRelativeLayout.FloatListener localFloatListener = this.a;
      if ((localFloatListener != null) && (!this.j))
      {
        localFloatListener.a(this, localPoint.x, localPoint.y, localPoint.x + i1, localPoint.y + i2);
        return;
      }
      layout(localPoint.x, localPoint.y, localPoint.x + i1, localPoint.y + i2);
    }
  }
  
  public void d()
  {
    if (!this.j) {
      e();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getRawX();
    int i2 = (int)paramMotionEvent.getRawY();
    int i3 = this.t;
    i3 = this.v;
    i3 = this.u;
    i3 = this.w;
    if (this.j) {
      return true;
    }
    i3 = paramMotionEvent.getAction();
    boolean bool3 = false;
    boolean bool2 = false;
    if (i3 != 0)
    {
      if (i3 != 1)
      {
        if (i3 != 2)
        {
          if (i3 != 3) {
            return true;
          }
          this.V = false;
          this.h = false;
          if (this.g)
          {
            a(i1, i2);
            this.H.removeCallbacks(this.G);
          }
          paramMotionEvent = this.a;
          if (paramMotionEvent != null)
          {
            this.x = paramMotionEvent.a(this);
            this.y = this.a.b(this);
          }
          else
          {
            this.x = getLeft();
            this.y = getTop();
          }
          this.b.start();
          return true;
        }
        if (this.g)
        {
          a(i1, i2);
          this.H.removeCallbacks(this.G);
          return true;
        }
        if ((Math.abs(i1 - this.v) > this.m) || (Math.abs(i2 - this.w) > this.m))
        {
          this.V = true;
          this.g = true;
          return true;
        }
      }
      else
      {
        this.V = false;
        this.H.removeCallbacks(this.G);
        boolean bool1;
        if (this.g)
        {
          a(i1, i2);
          bool1 = bool3;
        }
        else
        {
          long l1 = System.currentTimeMillis();
          paramMotionEvent = this.a;
          bool1 = bool3;
          if (paramMotionEvent != null)
          {
            bool1 = bool3;
            if (!this.h)
            {
              bool1 = bool3;
              if (l1 - this.i > 600L)
              {
                Point localPoint = this.F;
                bool1 = bool2;
                if (this.B == 0) {
                  bool1 = true;
                }
                bool1 = paramMotionEvent.a(localPoint, bool1);
                this.i = l1;
              }
            }
          }
        }
        paramMotionEvent = this.a;
        if (paramMotionEvent != null)
        {
          this.x = paramMotionEvent.a(this);
          this.y = this.a.b(this);
        }
        else
        {
          this.x = getLeft();
          this.y = getTop();
        }
        if (!bool1)
        {
          this.b.start();
          return true;
        }
      }
    }
    else
    {
      this.h = false;
      this.H.postDelayed(this.G, ViewConfiguration.getLongPressTimeout());
      this.b.cancel();
      this.v = i1;
      this.w = i2;
      paramMotionEvent = this.a;
      if (paramMotionEvent != null)
      {
        this.t = paramMotionEvent.a(this);
        this.u = this.a.b(this);
      }
      else
      {
        this.t = getLeft();
        this.u = getTop();
      }
      this.g = false;
    }
    return true;
  }
  
  public void e()
  {
    Object localObject = this.P;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      if ((this.P.size() != 1) && (h())) {
        this.n = this.q;
      } else {
        this.n = this.p;
      }
      if (this.O != null)
      {
        localObject = (LinearLayout.LayoutParams)this.I.getLayoutParams();
        int i1;
        if (g()) {
          i1 = getResources().getDimensionPixelSize(2131299719);
        } else {
          i1 = getResources().getDimensionPixelSize(2131299717);
        }
        ((LinearLayout.LayoutParams)localObject).width = i1;
        if (h())
        {
          if (g())
          {
            ((LinearLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(getContext(), 13.5F);
            ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
          }
          else
          {
            ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(getContext(), 14.5F);
            ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
          }
        }
        else if (g())
        {
          ((LinearLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(getContext(), 10.0F);
          ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        }
        else
        {
          ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(getContext(), 10.0F);
          ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
        }
      }
      this.h = false;
      k();
    }
  }
  
  public void f()
  {
    Object localObject1 = this.P;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      if (this.a == null) {
        return;
      }
      int i3 = 0;
      this.S = false;
      int i1 = 0;
      while (i1 < this.P.size())
      {
        if (((ColorNote)this.P.get(i1)).mServiceType == 16973824)
        {
          this.S = true;
          break;
        }
        i1 += 1;
      }
      int i7 = this.U;
      if (h())
      {
        if (ColorNoteUtils.b(this.P)) {
          this.U = 4;
        } else if ((this.S) && (this.P.size() > 1)) {
          this.U = 2;
        } else {
          this.U = 3;
        }
      }
      else {
        this.U = 1;
      }
      localObject1 = (LinearLayout)findViewById(2131446099);
      ((LinearLayout)localObject1).removeAllViews();
      if (this.S) {
        i1 = this.P.size() - 1;
      } else {
        i1 = this.P.size();
      }
      int i6 = getResources().getDimensionPixelSize(2131299713);
      int i2 = getResources().getDimensionPixelSize(2131299712);
      int i4 = a(i1);
      if (i1 == 0) {
        i2 = i6;
      } else {
        i2 = (int)((i2 - i4 * 2) * 1.0F / i1 - b(i1));
      }
      while (i3 < this.P.size())
      {
        Object localObject2 = (ColorNote)this.P.get(i3);
        if (((ColorNote)localObject2).mServiceType != 16973824)
        {
          SmallColorNoteItem localSmallColorNoteItem = a((ColorNote)localObject2, (ViewGroup)localObject1);
          localSmallColorNoteItem.setAttachLeft(g());
          if (this.S) {
            i4 = this.P.size() - 1;
          } else {
            i4 = this.P.size();
          }
          if (i4 > 3)
          {
            localSmallColorNoteItem.c();
          }
          else
          {
            localSmallColorNoteItem.d();
            localSmallColorNoteItem.setTitle(((ColorNote)localObject2).mMainTitle);
            localSmallColorNoteItem.setSubTitle(((ColorNote)localObject2).mSubTitle);
          }
          if (this.S) {
            i4 = this.P.size() - 1;
          } else {
            i4 = this.P.size();
          }
          if (i4 > 4) {
            localSmallColorNoteItem.a();
          } else {
            localSmallColorNoteItem.b();
          }
          localSmallColorNoteItem.a(i2, i6);
          localObject2 = new LinearLayout.LayoutParams(-1, i2);
          i4 = (int)(b(i1) / 2.0F);
          if (i4 == 0) {
            i5 = 1;
          } else {
            i5 = i4;
          }
          ((LinearLayout.LayoutParams)localObject2).topMargin = i5;
          int i5 = i4;
          if (i4 == 0) {
            i5 = 1;
          }
          ((LinearLayout.LayoutParams)localObject2).bottomMargin = i5;
          ((LinearLayout)localObject1).addView(localSmallColorNoteItem.getRoot(), -1, (ViewGroup.LayoutParams)localObject2);
        }
        i3 += 1;
      }
      i1 = this.U;
      if (i7 != i1) {
        b(i1, i7);
      }
    }
  }
  
  public boolean g()
  {
    if (this.J == -1)
    {
      ColorNoteSmallScreenRelativeLayout.FloatListener localFloatListener = this.a;
      if (localFloatListener != null)
      {
        this.F.x = localFloatListener.a(this);
        this.F.y = this.a.b(this);
        int i1;
        if (this.F.x < 0) {
          i1 = 0;
        } else {
          i1 = 1;
        }
        this.J = i1;
      }
    }
    if ((this.J == 0) && (this.F.x > 0) && (QLog.isColorLevel())) {
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "state is STATE_LEFT, but mPoint.x grater than 0");
    }
    return this.J == 0;
  }
  
  public Point getCurPosition()
  {
    return this.F;
  }
  
  public int getDisplayState()
  {
    return this.U;
  }
  
  public boolean getIsShow()
  {
    return this.f;
  }
  
  public int getMaxLeft()
  {
    return this.C - getVisibleWidth() + this.z;
  }
  
  public int getMinLeft()
  {
    return -this.z;
  }
  
  public int getRealLeft()
  {
    if (g()) {
      return -this.z;
    }
    QLog.d("ColorNoteSmallScreenRelativeLayout", 4, new Object[] { Integer.valueOf(getVisibleWidth()) });
    return this.C - getVisibleWidth() + this.z;
  }
  
  public int getRealWidth()
  {
    if (r()) {
      return this.p;
    }
    if (i())
    {
      if (g()) {
        return this.q;
      }
      return this.r;
    }
    if (g()) {
      return this.p;
    }
    return this.r;
  }
  
  public int getScreenHeight()
  {
    return this.D;
  }
  
  public int getScreenWidth()
  {
    return this.C;
  }
  
  public int getToastHeight()
  {
    return this.o;
  }
  
  public int getToastWidth()
  {
    return this.n;
  }
  
  public int getVisibleWidth()
  {
    if ((!r()) && (!this.V))
    {
      QLog.d("ColorNoteSmallScreenRelativeLayout", 4, new Object[] { Boolean.valueOf(i()) });
      if ((i()) && (!this.aa))
      {
        QLog.d("ColorNoteSmallScreenRelativeLayout", 4, new Object[] { Integer.valueOf(this.q) });
        return this.q;
      }
      return this.p;
    }
    return this.p;
  }
  
  public boolean h()
  {
    return (this.S) || (ColorNoteUtils.b(this.P));
  }
  
  public boolean i()
  {
    boolean bool2 = h();
    boolean bool1 = true;
    if ((!bool2) || (this.P.size() == 1))
    {
      if (ColorNoteUtils.b(this.P)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public void j()
  {
    boolean bool = g();
    IUpcomingController localIUpcomingController = this.Z;
    if ((localIUpcomingController != null) && (localIUpcomingController.i() == 2)) {
      return;
    }
    if (bool)
    {
      m();
      return;
    }
    n();
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    Object localObject = this.b;
    int i1 = 1;
    int i2;
    int i3;
    if (paramAnimator == localObject)
    {
      paramAnimator = this.A;
      i2 = getRealWidth();
      this.n = i2;
      i3 = this.o;
      this.F = paramAnimator;
      int i4;
      int i5;
      int i6;
      if ((paramAnimator.x > 0) && (getState() != 0))
      {
        this.K = this.J;
        this.J = 1;
        this.F.x = getRealLeft();
        if (this.F.x < 0) {
          i1 = 0;
        } else {
          i1 = 1;
        }
        this.J = i1;
        i1 = getRealLeft();
        i4 = getRealWidth();
        i5 = this.K;
        i6 = this.J;
        if (i5 != i6) {
          a(i6, i5, this.F.x, this.F.y, i2, i3);
        }
        this.ab = true;
        a(this, this.F.x, this.F.y, i1 + i4, this.F.y + i3);
        if (QQTheme.isNowThemeIsNight()) {
          setBackgroundResource(2130839425);
        } else {
          setBackgroundResource(2130839428);
        }
      }
      else
      {
        this.K = this.J;
        this.J = 0;
        this.F.x = getRealLeft();
        if (this.F.x < 0) {
          i1 = 0;
        }
        this.J = i1;
        i1 = getRealLeft();
        i4 = getRealWidth();
        i5 = this.K;
        i6 = this.J;
        if (i5 != i6) {
          a(i6, i5, i1, this.F.y, i2, i3);
        }
        a(this, i1, this.F.y, i1 + i4, this.F.y + i3);
        if (QQTheme.isNowThemeIsNight()) {
          setBackgroundResource(2130839423);
        } else {
          setBackgroundResource(2130839426);
        }
      }
      paramAnimator = this.a;
      if (paramAnimator != null) {
        paramAnimator.a(this.F, this.B);
      }
      this.k = false;
      if (this.F.y > this.D / 2) {
        ReportController.b(null, "dc00898", "", "", "0X800A6CC", "0X800A6CC", 2, 0, "", "", "", "");
      } else {
        ReportController.b(null, "dc00898", "", "", "0X800A6CC", "0X800A6CC", 1, 0, "", "", "", "");
      }
    }
    else if (paramAnimator == this.c)
    {
      if (!this.f)
      {
        setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "onAnimationEnd setVisibility(GONE)");
        }
        paramAnimator = this.a;
        if (paramAnimator != null) {
          paramAnimator.c(this);
        }
      }
    }
    else if (paramAnimator == this.d)
    {
      if (this.h) {
        this.n = this.p;
      }
      i1 = this.n / 2;
      paramAnimator = this.F;
      if (((this.S) && (this.P.size() != 1)) || (ColorNoteUtils.b(this.P))) {
        i1 = 0;
      }
      paramAnimator.x = getRealLeft();
      i2 = getRealWidth();
      this.n = i2;
      i3 = this.o;
      if (paramAnimator.x <= 0)
      {
        localObject = this.a;
        if (localObject != null) {
          ((ColorNoteSmallScreenRelativeLayout.FloatListener)localObject).a(this, paramAnimator.x, paramAnimator.y, paramAnimator.x + i2 + i1, paramAnimator.y + i3, i1, true);
        }
      }
      else
      {
        localObject = this.a;
        if (localObject != null) {
          ((ColorNoteSmallScreenRelativeLayout.FloatListener)localObject).a(this, paramAnimator.x - i1, paramAnimator.y, paramAnimator.x + i2 - i1, paramAnimator.y + i3, -i1, true);
        }
      }
    }
    f();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (paramAnimator == this.b)
    {
      if (this.x + getRealWidth() / 2 < this.C / 2) {
        this.A.x = (-this.z);
      } else {
        this.A.x = getMaxLeft();
      }
      this.A.y = this.y;
      this.ab = false;
      return;
    }
    if ((paramAnimator == this.c) && (this.f))
    {
      setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "onAnimationStart setVisibility(VISIBLE)");
      }
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i1;
    int i2;
    int i3;
    if (paramValueAnimator == this.b)
    {
      paramValueAnimator = this.A;
      i1 = (int)(this.x + (paramValueAnimator.x - this.x) * f1);
      i2 = (int)(this.y + (paramValueAnimator.y - this.y) * f1);
      i3 = getRealWidth();
      this.n = i3;
      int i4 = this.o;
      paramValueAnimator = this.a;
      if (paramValueAnimator != null)
      {
        paramValueAnimator.a(this, i1, i2, i1 + i3, i2 + i4);
        return;
      }
      layout(i1, i2, i3 + i1, i4 + i2);
      return;
    }
    if (paramValueAnimator == this.c)
    {
      boolean bool = this.f;
      return;
    }
    if (paramValueAnimator == this.d)
    {
      if (this.h) {
        this.n = this.p;
      }
      if (((this.S) && (this.P.size() != 1)) || (ColorNoteUtils.b(this.P))) {
        return;
      }
      i1 = (int)(this.n / 2 * f1);
      this.F.x = getRealLeft();
      paramValueAnimator = this.F;
      i2 = getRealWidth();
      this.n = i2;
      i3 = this.o;
      ColorNoteSmallScreenRelativeLayout.FloatListener localFloatListener;
      if (paramValueAnimator.x <= 0)
      {
        localFloatListener = this.a;
        if (localFloatListener != null) {
          localFloatListener.a(this, paramValueAnimator.x, paramValueAnimator.y, paramValueAnimator.x + i2 + i1, paramValueAnimator.y + i3, i1, false);
        }
      }
      else
      {
        localFloatListener = this.a;
        if (localFloatListener != null) {
          localFloatListener.a(this, paramValueAnimator.x - i1, paramValueAnimator.y, paramValueAnimator.x + i2 - i1, paramValueAnimator.y + i3, -i1, false);
        }
      }
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    a();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.O = ((LinearLayout)findViewById(2131446098));
    this.I = ((LinearLayout)findViewById(2131446099));
    this.L = ((MusicDanceImageView)findViewById(2131436465));
    this.M = ((MusicDanceImageView)findViewById(2131436466));
    this.N = ((RelativeLayout)findViewById(2131432148));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.C == 0) || (this.D == 0))
    {
      this.C = ViewUtils.getScreenWidth();
      this.D = ViewUtils.getScreenHeight();
      setCurPosition(this.F);
    }
  }
  
  public void setCurPosition(Point paramPoint)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurPosition position = ");
      ((StringBuilder)localObject).append(paramPoint);
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurPosition mScreenWidth = ");
      ((StringBuilder)localObject).append(this.C);
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurPosition mScreenHeight = ");
      ((StringBuilder)localObject).append(this.D);
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, ((StringBuilder)localObject).toString());
    }
    this.F = paramPoint;
    int i1;
    if (this.F.x < 0) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    this.J = i1;
    if ((this.C != 0) && (this.D != 0))
    {
      i1 = this.n;
      int i2 = this.o;
      if ((paramPoint.x == 0) && (paramPoint.y == 0))
      {
        paramPoint.y = (this.D / 2);
        paramPoint.x = (this.C - i1);
      }
      localObject = this.a;
      if (localObject != null)
      {
        ((ColorNoteSmallScreenRelativeLayout.FloatListener)localObject).a(this, paramPoint.x, paramPoint.y, paramPoint.x + i1, paramPoint.y + i2);
        return;
      }
      layout(paramPoint.x, paramPoint.y, paramPoint.x + i1, paramPoint.y + i2);
    }
  }
  
  public void setCustomNightMode(boolean paramBoolean)
  {
    W = paramBoolean;
    s();
  }
  
  public void setFloatListener(ColorNoteSmallScreenRelativeLayout.FloatListener paramFloatListener)
  {
    this.a = paramFloatListener;
  }
  
  public void setShouldMaxRootView(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setUpcomingController(IUpcomingController paramIUpcomingController)
  {
    this.Z = paramIUpcomingController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout
 * JD-Core Version:    0.7.0.1
 */
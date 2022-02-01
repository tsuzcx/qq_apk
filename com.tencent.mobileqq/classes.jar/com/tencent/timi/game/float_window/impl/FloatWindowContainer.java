package com.tencent.timi.game.float_window.impl;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.float_window.FloatingConfigParams;
import com.tencent.timi.game.float_window.impl.drag.DragHelper;
import com.tencent.timi.game.float_window.impl.drag.DragHelper.Companion;
import com.tencent.timi.game.float_window.impl.drag.IDragListener;
import com.tencent.timi.game.float_window.impl.drag.IDraggableView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/impl/FloatWindowContainer;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/float_window/impl/drag/IDraggableView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "floatShowing", "", "getFloatShowing", "()Z", "setFloatShowing", "(Z)V", "isHorizontal", "setHorizontal", "mContext", "mDragEndAnimator", "Landroid/animation/ValueAnimator;", "mExtraPadding", "mFloatParams", "Lcom/tencent/timi/game/float_window/FloatingConfigParams;", "mFloatWindowLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "mInitialMotionX", "", "mInitialMotionY", "mIsBeingDragged", "mNewFloatParams", "mOnDragListener", "Lcom/tencent/timi/game/float_window/impl/drag/IDragListener;", "mScreenHeight", "mScreenWidth", "mTouchSlop", "mWindowManager", "Landroid/view/WindowManager;", "mWindowType", "addToWindowManager", "", "floatParams", "bringToTop", "changeOrientation", "clearCutoutMode", "createParams", "curCenterPoint", "Lkotlin/Pair;", "curExtraPadding", "enterWindowFloat", "floatingWidgetWrapper", "Landroid/view/View;", "customView", "getFloatingCenterX", "getFloatingCenterY", "getOuterHeight", "getOuterWidth", "getView", "moveToPosSmooth", "newLeft", "newTop", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDragEndAnimation", "onDragStart", "x", "y", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "quitWindowFloat", "recoverPos", "removeFromWindowManager", "setLiveViewRoundCorners", "view", "roundCorners", "setOnDragListener", "onDragListener", "setRoundCorner", "roundCorner", "showOuterCorner", "needShow", "stopAnimation", "updateParams", "isNeedUpdateWidthHeight", "updateSize", "w", "h", "updateWindowLayout", "layoutParams", "FloatingVideoOutlineProvider", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class FloatWindowContainer
  extends FrameLayout
  implements IDraggableView
{
  private int a = 20;
  private WindowManager b;
  private int c;
  private int d;
  private int e;
  private boolean f;
  private FloatingConfigParams g;
  private FloatingConfigParams h;
  private float i;
  private float j;
  private final Context k;
  private ValueAnimator l;
  private IDragListener m;
  private int n;
  private boolean o;
  private WindowManager.LayoutParams p;
  private boolean q;
  
  @JvmOverloads
  public FloatWindowContainer(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public FloatWindowContainer(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public FloatWindowContainer(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.k = paramContext;
    paramAttributeSet = paramContext.getSystemService("window");
    if (paramAttributeSet != null)
    {
      this.b = ((WindowManager)paramAttributeSet);
      paramAttributeSet = this.b;
      if (paramAttributeSet != null)
      {
        Display localDisplay = paramAttributeSet.getDefaultDisplay();
        Intrinsics.checkExpressionValueIsNotNull(localDisplay, "it.defaultDisplay");
        this.d = localDisplay.getHeight();
        paramAttributeSet = paramAttributeSet.getDefaultDisplay();
        Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "it.defaultDisplay");
        this.c = paramAttributeSet.getWidth();
      }
      if (Build.VERSION.SDK_INT >= 26) {
        this.e = 2038;
      } else {
        this.e = 2002;
      }
      paramContext = ViewConfiguration.get(paramContext);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "ViewConfiguration.get(context)");
      this.a = paramContext.getScaledTouchSlop();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
  }
  
  private final void a(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setOutlineProvider((ViewOutlineProvider)new FloatWindowContainer.FloatingVideoOutlineProvider(paramInt));
      paramView.setClipToOutline(true);
    }
  }
  
  private final void c(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.g;
    if ((localObject1 != null) && (((FloatingConfigParams)localObject1).a() == true))
    {
      localObject1 = this.h;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      Object localObject2 = this.g;
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((FloatingConfigParams)localObject1).b(((FloatingConfigParams)localObject2).b() + paramInt1);
      localObject1 = this.h;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = this.g;
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((FloatingConfigParams)localObject1).c(((FloatingConfigParams)localObject2).c() + paramInt2);
      localObject1 = this.m;
      if (localObject1 != null)
      {
        localObject2 = (IDraggableView)this;
        FloatingConfigParams localFloatingConfigParams = this.h;
        if (localFloatingConfigParams == null) {
          Intrinsics.throwNpe();
        }
        paramInt1 = localFloatingConfigParams.b();
        localFloatingConfigParams = this.h;
        if (localFloatingConfigParams == null) {
          Intrinsics.throwNpe();
        }
        ((IDragListener)localObject1).a((IDraggableView)localObject2, paramInt1, localFloatingConfigParams.c());
      }
      localObject1 = this.h;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      a(a((FloatingConfigParams)localObject1, false));
    }
  }
  
  private final void f()
  {
    Object localObject1 = this.h;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    this.g = ((FloatingConfigParams)localObject1).f();
    DragHelper localDragHelper = DragHelper.a.a();
    localObject1 = (IDraggableView)this;
    this.n = localDragHelper.b((IDraggableView)localObject1);
    try
    {
      if ((this.k != null) && (this.k.getResources() != null))
      {
        i1 = this.k.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (i1 > 0) {
          this.k.getResources().getDimensionPixelSize(i1);
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    boolean bool;
    if ((!QBaseActivity.mAppForground) && (this.o)) {
      bool = true;
    } else {
      bool = false;
    }
    int i1 = this.c / 2;
    Object localObject2 = this.g;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    int i2 = ((FloatingConfigParams)localObject2).c(bool);
    localObject2 = this.g;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    int i3 = i1 - i2 - ((FloatingConfigParams)localObject2).d() / 2;
    i1 = this.d / 2;
    localObject2 = this.g;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    i2 = ((FloatingConfigParams)localObject2).b(bool);
    localObject2 = this.g;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    i2 = i1 - i2 - ((FloatingConfigParams)localObject2).e() / 2;
    i1 = this.d / 2;
    localObject2 = this.g;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    int i4 = ((FloatingConfigParams)localObject2).a(bool);
    localObject2 = this.g;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    int i5 = -(i1 - i4 - ((FloatingConfigParams)localObject2).e() / 2);
    i1 = -this.c;
    localObject2 = this.g;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    int i6 = ((FloatingConfigParams)localObject2).c();
    localObject2 = getLayoutParams();
    if (localObject2 != null)
    {
      localObject2 = (WindowManager.LayoutParams)localObject2;
      int i7 = ((WindowManager.LayoutParams)localObject2).x;
      i4 = -i3;
      if (i7 < i4) {
        i1 = i4;
      }
      if (((WindowManager.LayoutParams)localObject2).x > i3) {
        i1 = i3;
      }
      if (((WindowManager.LayoutParams)localObject2).y <= i2) {
        i2 = i6;
      }
      if (((WindowManager.LayoutParams)localObject2).y >= i5) {
        i5 = i2;
      }
      i2 = i1;
      if (((WindowManager.LayoutParams)localObject2).x >= i4)
      {
        i2 = i1;
        if (((WindowManager.LayoutParams)localObject2).x <= i3) {
          if (((WindowManager.LayoutParams)localObject2).x < 0) {
            i2 = i4;
          } else {
            i2 = i3;
          }
        }
      }
      a(i2, i5);
      localObject2 = this.m;
      if ((localObject2 != null) && (localObject2 != null)) {
        ((IDragListener)localObject2).c((IDraggableView)localObject1);
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
  }
  
  private final void g()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 28)
      {
        Object localObject = getLayoutParams();
        if (localObject != null)
        {
          this.p = ((WindowManager.LayoutParams)localObject);
          localObject = this.p;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          ((WindowManager.LayoutParams)localObject).layoutInDisplayCutoutMode = 2;
          if (this.b != null)
          {
            localObject = this.b;
            if (localObject == null) {
              Intrinsics.throwNpe();
            }
            ((WindowManager)localObject).updateViewLayout((View)this, (ViewGroup.LayoutParams)this.p);
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  @Nullable
  public final WindowManager.LayoutParams a(@NotNull FloatingConfigParams paramFloatingConfigParams, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramFloatingConfigParams, "floatParams");
    int i1 = (this.c - paramFloatingConfigParams.d()) / 2;
    int i2 = (this.d - paramFloatingConfigParams.e()) / 2;
    if (Math.abs(paramFloatingConfigParams.b()) > i1)
    {
      if (paramFloatingConfigParams.b() <= 0) {
        i1 = -i1;
      }
      paramFloatingConfigParams.b(i1);
    }
    if (Math.abs(paramFloatingConfigParams.c()) > i2)
    {
      if (paramFloatingConfigParams.c() > 0) {
        i1 = i2;
      } else {
        i1 = -i2;
      }
      paramFloatingConfigParams.c(i1);
    }
    if (this.p == null)
    {
      localObject = getLayoutParams();
      if (localObject != null) {
        this.p = ((WindowManager.LayoutParams)localObject);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
      }
    }
    Object localObject = this.p;
    if (localObject != null)
    {
      if (paramBoolean)
      {
        ((WindowManager.LayoutParams)localObject).width = paramFloatingConfigParams.d();
        ((WindowManager.LayoutParams)localObject).height = paramFloatingConfigParams.e();
      }
      ((WindowManager.LayoutParams)localObject).x = paramFloatingConfigParams.b();
      ((WindowManager.LayoutParams)localObject).y = paramFloatingConfigParams.c();
    }
    return this.p;
  }
  
  @NotNull
  public Pair<Integer, Integer> a()
  {
    if (this.g != null)
    {
      FloatingConfigParams localFloatingConfigParams = this.h;
      if (localFloatingConfigParams == null) {
        Intrinsics.throwNpe();
      }
      int i1 = localFloatingConfigParams.b();
      localFloatingConfigParams = this.h;
      if (localFloatingConfigParams == null) {
        Intrinsics.throwNpe();
      }
      return new Pair(Integer.valueOf(i1), Integer.valueOf(localFloatingConfigParams.c()));
    }
    return new Pair(Integer.valueOf(0), Integer.valueOf(0));
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    Object localObject2 = getLayoutParams();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof WindowManager.LayoutParams)) {
      localObject1 = null;
    }
    localObject1 = (WindowManager.LayoutParams)localObject1;
    if ((localObject1 == null) || (paramInt1 != ((WindowManager.LayoutParams)localObject1).x) || (paramInt2 != ((WindowManager.LayoutParams)localObject1).y))
    {
      localObject2 = this.l;
      if (localObject2 != null)
      {
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        if (((ValueAnimator)localObject2).isRunning())
        {
          localObject2 = this.l;
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          ((ValueAnimator)localObject2).cancel();
        }
        this.l = ((ValueAnimator)null);
      }
      if (localObject1 != null)
      {
        ((WindowManager.LayoutParams)localObject1).gravity = 17;
        this.l = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        localObject2 = this.l;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((ValueAnimator)localObject2).setTarget(this);
        localObject2 = this.l;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((ValueAnimator)localObject2).setDuration(200L);
        int i1 = ((WindowManager.LayoutParams)localObject1).x;
        int i2 = ((WindowManager.LayoutParams)localObject1).y;
        localObject2 = this.l;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new FloatWindowContainer.moveToPosSmooth..inlined.let.lambda.1((WindowManager.LayoutParams)localObject1, i1, paramInt1, i2, paramInt2, this, paramInt1, paramInt2));
        localObject1 = this.l;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)new FloatWindowContainer.moveToPosSmooth..inlined.let.lambda.2(this, paramInt1, paramInt2));
        localObject1 = this.l;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((ValueAnimator)localObject1).start();
      }
    }
  }
  
  public final void a(@Nullable View paramView1, @Nullable View paramView2, @NotNull FloatingConfigParams paramFloatingConfigParams)
  {
    Intrinsics.checkParameterIsNotNull(paramFloatingConfigParams, "floatParams");
    this.g = paramFloatingConfigParams;
    this.h = paramFloatingConfigParams.f();
    paramView2 = new FrameLayout.LayoutParams(-1, -1);
    paramView2.gravity = 17;
    removeAllViews();
    addView(paramView1, (ViewGroup.LayoutParams)paramView2);
    a(paramFloatingConfigParams);
    f();
    this.q = true;
  }
  
  public final void a(@Nullable WindowManager.LayoutParams paramLayoutParams)
  {
    try
    {
      if (this.b != null)
      {
        WindowManager localWindowManager = this.b;
        if (localWindowManager == null) {
          Intrinsics.throwNpe();
        }
        localWindowManager.updateViewLayout((View)this, (ViewGroup.LayoutParams)paramLayoutParams);
        return;
      }
    }
    catch (Exception paramLayoutParams)
    {
      paramLayoutParams.printStackTrace();
    }
  }
  
  public final void a(@NotNull FloatingConfigParams paramFloatingConfigParams)
  {
    Intrinsics.checkParameterIsNotNull(paramFloatingConfigParams, "floatParams");
    try
    {
      if (this.b != null)
      {
        paramFloatingConfigParams = b(paramFloatingConfigParams);
        WindowManager localWindowManager = this.b;
        if (localWindowManager == null) {
          Intrinsics.throwNpe();
        }
        localWindowManager.addView((View)this, (ViewGroup.LayoutParams)paramFloatingConfigParams);
        return;
      }
    }
    catch (Exception paramFloatingConfigParams)
    {
      paramFloatingConfigParams.printStackTrace();
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
    FloatingConfigParams localFloatingConfigParams = this.g;
    if (localFloatingConfigParams != null)
    {
      int i1;
      if (paramBoolean)
      {
        i1 = Math.max(this.d, this.c);
        this.d = Math.min(this.d, this.c);
        this.c = i1;
      }
      else
      {
        i1 = Math.max(this.d, this.c);
        int i2 = Math.min(this.d, this.c);
        this.d = i1;
        this.c = i2;
      }
      if (localFloatingConfigParams == null) {
        Intrinsics.throwNpe();
      }
      localFloatingConfigParams.d(paramBoolean);
      f();
    }
  }
  
  @Nullable
  public final WindowManager.LayoutParams b(@NotNull FloatingConfigParams paramFloatingConfigParams)
  {
    Intrinsics.checkParameterIsNotNull(paramFloatingConfigParams, "floatParams");
    int i1 = (this.c - paramFloatingConfigParams.d()) / 2;
    i1 = (this.d - paramFloatingConfigParams.e()) / 2;
    boolean bool;
    if ((!QBaseActivity.mAppForground) && (this.o)) {
      bool = true;
    } else {
      bool = false;
    }
    i1 = this.c / 2;
    Object localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    int i2 = ((FloatingConfigParams)localObject).c(bool);
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    i1 = i1 - i2 - ((FloatingConfigParams)localObject).d() / 2;
    i2 = this.d / 2;
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    int i3 = ((FloatingConfigParams)localObject).b(bool);
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    i2 = i2 - i3 - ((FloatingConfigParams)localObject).e() / 2;
    i3 = this.d / 2;
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((FloatingConfigParams)localObject).a(bool);
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    i3 = ((FloatingConfigParams)localObject).e() / 2;
    paramFloatingConfigParams.b(i1);
    paramFloatingConfigParams.c(i2);
    localObject = this.h;
    if (localObject != null) {
      ((FloatingConfigParams)localObject).b(i1);
    }
    localObject = this.h;
    if (localObject != null) {
      ((FloatingConfigParams)localObject).c(i2);
    }
    if (this.p == null) {
      this.p = new WindowManager.LayoutParams();
    }
    localObject = this.p;
    if (localObject != null)
    {
      ((WindowManager.LayoutParams)localObject).type = this.e;
      ((WindowManager.LayoutParams)localObject).format = 1;
      ((WindowManager.LayoutParams)localObject).flags = 16777256;
      ((WindowManager.LayoutParams)localObject).width = paramFloatingConfigParams.d();
      ((WindowManager.LayoutParams)localObject).height = paramFloatingConfigParams.e();
      ((WindowManager.LayoutParams)localObject).x = paramFloatingConfigParams.b();
      ((WindowManager.LayoutParams)localObject).y = paramFloatingConfigParams.c();
      if (Build.VERSION.SDK_INT >= 28) {
        ((WindowManager.LayoutParams)localObject).layoutInDisplayCutoutMode = 2;
      }
      if (!FloatingScreenUtils.a(this.k)) {
        ((WindowManager.LayoutParams)localObject).systemUiVisibility = 5892;
      }
    }
    return this.p;
  }
  
  public void b()
  {
    if (DragHelper.a.a().b((IDraggableView)this) != this.n) {
      f();
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    FloatingConfigParams localFloatingConfigParams = this.g;
    if ((localFloatingConfigParams != null) && (paramInt1 == localFloatingConfigParams.d()))
    {
      localFloatingConfigParams = this.g;
      if ((localFloatingConfigParams != null) && (paramInt2 == localFloatingConfigParams.e())) {}
    }
    else
    {
      localFloatingConfigParams = this.h;
      if (localFloatingConfigParams != null) {
        localFloatingConfigParams.d(paramInt1);
      }
      localFloatingConfigParams = this.h;
      if (localFloatingConfigParams != null) {
        localFloatingConfigParams.e(paramInt2);
      }
      localFloatingConfigParams = this.g;
      if (localFloatingConfigParams != null) {
        localFloatingConfigParams.d(paramInt1);
      }
      localFloatingConfigParams = this.g;
      if (localFloatingConfigParams != null) {
        localFloatingConfigParams.e(paramInt2);
      }
      localFloatingConfigParams = this.g;
      if (localFloatingConfigParams == null) {
        Intrinsics.throwNpe();
      }
      a(a(localFloatingConfigParams, true));
      f();
    }
  }
  
  public final boolean c()
  {
    if (this.q)
    {
      this.q = false;
      setVisibility(8);
      g();
      d();
      this.p = ((WindowManager.LayoutParams)null);
      e();
      removeAllViews();
      this.h = ((FloatingConfigParams)null);
      return true;
    }
    return false;
  }
  
  public final void d()
  {
    try
    {
      if (this.b != null)
      {
        WindowManager localWindowManager = this.b;
        if (localWindowManager == null) {
          Intrinsics.throwNpe();
        }
        localWindowManager.removeView((View)this);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public final void e()
  {
    ValueAnimator localValueAnimator = this.l;
    if (localValueAnimator != null)
    {
      if (localValueAnimator == null) {
        Intrinsics.throwNpe();
      }
      if (localValueAnimator.isRunning())
      {
        localValueAnimator = this.l;
        if (localValueAnimator == null) {
          Intrinsics.throwNpe();
        }
        localValueAnimator.cancel();
      }
    }
  }
  
  public final boolean getFloatShowing()
  {
    return this.q;
  }
  
  public final int getFloatingCenterX()
  {
    FloatingConfigParams localFloatingConfigParams = this.g;
    if (localFloatingConfigParams != null) {
      return localFloatingConfigParams.b();
    }
    return 0;
  }
  
  public final int getFloatingCenterY()
  {
    FloatingConfigParams localFloatingConfigParams = this.g;
    if (localFloatingConfigParams != null) {
      return localFloatingConfigParams.c();
    }
    return 0;
  }
  
  public int getOuterHeight()
  {
    FloatingConfigParams localFloatingConfigParams = this.g;
    if (localFloatingConfigParams != null) {
      return localFloatingConfigParams.e();
    }
    return 0;
  }
  
  public int getOuterWidth()
  {
    FloatingConfigParams localFloatingConfigParams = this.g;
    if (localFloatingConfigParams != null) {
      return localFloatingConfigParams.d();
    }
    return 0;
  }
  
  @NotNull
  public View getView()
  {
    return (View)this;
  }
  
  protected void onConfigurationChanged(@Nullable Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration != null)
    {
      if (paramConfiguration.orientation == 2)
      {
        a(true);
        return;
      }
      a(false);
    }
  }
  
  public boolean onInterceptTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "ev");
    int i1 = paramMotionEvent.getPointerCount();
    boolean bool2 = true;
    if (i1 >= 2) {
      return true;
    }
    i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label177;
          }
        }
        else
        {
          float f1 = paramMotionEvent.getY();
          float f2 = paramMotionEvent.getX();
          boolean bool1 = bool2;
          if (Math.abs(this.i - f1) <= this.a) {
            if (Math.abs(this.j - f2) > this.a) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
          }
          this.f = bool1;
          if (!this.f) {
            break label177;
          }
          this.i = paramMotionEvent.getRawY();
          this.j = paramMotionEvent.getRawX();
          break label177;
        }
      }
      this.f = false;
    }
    else
    {
      this.i = paramMotionEvent.getY();
      this.j = paramMotionEvent.getX();
      this.f = false;
    }
    label177:
    return this.f;
  }
  
  public boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    int i1 = paramMotionEvent.getPointerCount();
    int i2 = paramMotionEvent.getAction();
    if (i2 != 0)
    {
      boolean bool = false;
      if (i2 != 1) {
        if (i2 != 2)
        {
          if (i2 != 3) {
            break label228;
          }
        }
        else
        {
          if (i1 != 1) {
            break label228;
          }
          if (!this.f)
          {
            f1 = paramMotionEvent.getY();
            float f2 = paramMotionEvent.getX();
            if ((Math.abs(this.i - f1) > this.a) || (Math.abs(this.j - f2) > this.a)) {
              bool = true;
            }
            this.f = bool;
            if (!this.f) {
              break label228;
            }
            IDragListener localIDragListener = this.m;
            if (localIDragListener != null) {
              localIDragListener.a((IDraggableView)this);
            }
            this.i = paramMotionEvent.getRawY();
            this.j = paramMotionEvent.getRawX();
            break label228;
          }
          float f1 = paramMotionEvent.getRawY();
          c((int)(paramMotionEvent.getRawX() - this.j), (int)(f1 - this.i));
          break label228;
        }
      }
      if (this.f)
      {
        this.f = false;
        paramMotionEvent = this.m;
        if (paramMotionEvent != null) {
          paramMotionEvent.b((IDraggableView)this);
        }
        f();
      }
    }
    label228:
    return this.f;
  }
  
  public final void setFloatShowing(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public final void setHorizontal(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setOnDragListener(@Nullable IDragListener paramIDragListener)
  {
    this.m = paramIDragListener;
  }
  
  public final void setRoundCorner(@Nullable View paramView1, @Nullable View paramView2, int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramView1 != null) {
        a(paramView1, paramInt);
      }
      if (paramView2 != null) {
        a(paramView2, paramInt);
      }
      a((View)this, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.FloatWindowContainer
 * JD-Core Version:    0.7.0.1
 */
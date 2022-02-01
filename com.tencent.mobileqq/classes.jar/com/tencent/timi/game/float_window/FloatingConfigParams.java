package com.tencent.timi.game.float_window;

import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/FloatingConfigParams;", "", "()V", "DEFAULT_BOTTOM_PADDING_DP", "", "getDEFAULT_BOTTOM_PADDING_DP", "()I", "DEFAULT_LEFT_PADDING_DP", "getDEFAULT_LEFT_PADDING_DP", "DEFAULT_TOP_PADDING_DP", "getDEFAULT_TOP_PADDING_DP", "bottomPadding", "isLandscape", "", "leftPadding", "mCanMove", "mFloatingCenterX", "mFloatingCenterY", "mHeight", "mRoundCorner", "mWidth", "rightPadding", "shadowOffset", "getShadowOffset", "setShadowOffset", "(I)V", "topPadding", "visibleWhenBackground", "clone", "getBottomPadding", "landscape", "getCanMove", "getFloatingCenterX", "getFloatingCenterY", "getLeftPadding", "getOuterHeight", "getOuterWidth", "getRightPadding", "getRoundCorner", "getTopPadding", "initPadding", "", "initParam", "setFloatingCenterX", "floatingCenterX", "setFloatingCenterY", "floatingCenterY", "setHeight", "h", "setWidth", "w", "FloatingBuilder", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class FloatingConfigParams
  implements Cloneable
{
  private int a = 6;
  private final int b;
  private final int c;
  private final int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private boolean j;
  private boolean k;
  private boolean l;
  private int m;
  private int n;
  private int o;
  private int p;
  
  public FloatingConfigParams()
  {
    int i1 = this.a;
    this.b = (74 - i1);
    this.c = (70 - i1);
    this.d = (14 - i1);
    this.e = 128;
    this.f = 128;
    this.h = 1;
    this.i = 200;
    this.j = true;
    this.m = ViewUtils.dpToPx(this.b);
    this.n = ViewUtils.dpToPx(this.c);
    this.o = ViewUtils.dpToPx(this.d);
    this.p = ViewUtils.dpToPx(this.d);
  }
  
  private final void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.m = ViewUtils.dpToPx(this.d);
      this.n = ViewUtils.dpToPx(this.d);
      this.o = ViewUtils.dpToPx(this.b);
      this.p = ViewUtils.dpToPx(this.c);
      return;
    }
    this.m = ViewUtils.dpToPx(this.b);
    this.n = ViewUtils.dpToPx(this.c);
    this.o = ViewUtils.dpToPx(this.d);
    this.p = ViewUtils.dpToPx(this.d);
  }
  
  private final void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("YseFloatParams", 2, new Object[] { ", width:", Integer.valueOf(this.e), ", height:", Integer.valueOf(this.f) });
    }
    e(this.k);
  }
  
  public final int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return this.m;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final boolean a()
  {
    return this.j;
  }
  
  public final int b()
  {
    return this.h;
  }
  
  public final int b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return this.n;
  }
  
  public final void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final int c()
  {
    return this.i;
  }
  
  public final int c(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return this.o;
  }
  
  public final void c(int paramInt)
  {
    this.i = paramInt;
  }
  
  public final int d()
  {
    return this.e;
  }
  
  public final void d(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void d(boolean paramBoolean)
  {
    this.k = paramBoolean;
    e(paramBoolean);
  }
  
  public final int e()
  {
    return this.f;
  }
  
  public final void e(int paramInt)
  {
    this.f = paramInt;
  }
  
  @NotNull
  public FloatingConfigParams f()
  {
    FloatingConfigParams localFloatingConfigParams1 = null;
    FloatingConfigParams localFloatingConfigParams2 = (FloatingConfigParams)null;
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = super.clone();
        if ((localObject2 instanceof FloatingConfigParams)) {
          break label51;
        }
        localFloatingConfigParams1 = (FloatingConfigParams)localFloatingConfigParams1;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        localCloneNotSupportedException.printStackTrace();
        localObject1 = localFloatingConfigParams2;
      }
      if (localObject1 != null) {
        return localObject1;
      }
      return new FloatingConfigParams();
      label51:
      Object localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.FloatingConfigParams
 * JD-Core Version:    0.7.0.1
 */
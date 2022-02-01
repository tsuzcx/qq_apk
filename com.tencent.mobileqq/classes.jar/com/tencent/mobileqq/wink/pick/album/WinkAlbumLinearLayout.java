package com.tencent.mobileqq.wink.pick.album;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.tencent.aelight.camera.log.AEQLog;

public class WinkAlbumLinearLayout
  extends LinearLayout
  implements NestedScrollingParent
{
  private View a;
  private View b;
  private int c;
  private int d;
  private int e;
  private ValueAnimator f;
  private Interpolator g;
  private boolean h;
  private int i;
  private int j;
  private WinkAlbumLinearLayout.ScrollListener k;
  
  public WinkAlbumLinearLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WinkAlbumLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  /* Error */
  public WinkAlbumLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 37	android/widget/LinearLayout:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 39	com/tencent/mobileqq/wink/pick/album/WinkAlbumLinearLayout:i	I
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 41	com/tencent/mobileqq/wink/pick/album/WinkAlbumLinearLayout:j	I
    //   17: aload_1
    //   18: aload_2
    //   19: getstatic 46	com/tencent/mobileqq/wink/R$styleable:a	[I
    //   22: invokevirtual 52	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   25: astore_1
    //   26: aload_0
    //   27: aload_1
    //   28: getstatic 54	com/tencent/mobileqq/wink/R$styleable:b	I
    //   31: iconst_0
    //   32: invokevirtual 60	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   35: putfield 62	com/tencent/mobileqq/wink/pick/album/WinkAlbumLinearLayout:c	I
    //   38: aload_1
    //   39: invokevirtual 66	android/content/res/TypedArray:recycle	()V
    //   42: goto +19 -> 61
    //   45: astore_2
    //   46: goto +32 -> 78
    //   49: astore_2
    //   50: ldc 68
    //   52: ldc 70
    //   54: aload_2
    //   55: invokestatic 75	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   58: goto -20 -> 38
    //   61: aload_0
    //   62: iconst_1
    //   63: invokevirtual 79	com/tencent/mobileqq/wink/pick/album/WinkAlbumLinearLayout:setOrientation	(I)V
    //   66: aload_0
    //   67: new 81	android/view/animation/AccelerateDecelerateInterpolator
    //   70: dup
    //   71: invokespecial 83	android/view/animation/AccelerateDecelerateInterpolator:<init>	()V
    //   74: putfield 85	com/tencent/mobileqq/wink/pick/album/WinkAlbumLinearLayout:g	Landroid/view/animation/Interpolator;
    //   77: return
    //   78: aload_1
    //   79: invokevirtual 66	android/content/res/TypedArray:recycle	()V
    //   82: goto +5 -> 87
    //   85: aload_2
    //   86: athrow
    //   87: goto -2 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	WinkAlbumLinearLayout
    //   0	90	1	paramContext	Context
    //   0	90	2	paramAttributeSet	AttributeSet
    //   0	90	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   26	38	45	finally
    //   50	58	45	finally
    //   26	38	49	java/lang/Exception
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt == 1) {
      return d();
    }
    if (paramInt == 2) {
      return c();
    }
    return false;
  }
  
  private void e()
  {
    int m = this.e / 2;
    if ((getScrollY() > 0) && (getScrollY() < m))
    {
      b();
      return;
    }
    if ((m <= getScrollY()) && (getScrollY() < this.e)) {
      a();
    }
  }
  
  private void f()
  {
    ValueAnimator localValueAnimator = this.f;
    if (localValueAnimator == null)
    {
      this.f = new ValueAnimator();
      this.f.setInterpolator(this.g);
      this.f.addUpdateListener(new WinkAlbumLinearLayout.1(this));
      this.f.addListener(new WinkAlbumLinearLayout.2(this));
      return;
    }
    localValueAnimator.cancel();
  }
  
  private float g()
  {
    return getScrollY() * 1.0F / this.e;
  }
  
  public void a()
  {
    AEQLog.a("WinkAlbumLinearLayout", "[collapsePreviewContainer]");
    int m = getScrollY();
    int n = this.e;
    if (m >= n)
    {
      AEQLog.a("WinkAlbumLinearLayout", "[collapsePreviewContainer], already collapsed");
      return;
    }
    this.j = 1;
    m = n - getScrollY();
    n = (int)(m * 1.0F / this.e * 275.0F);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[collapsePreviewContainer], dy=");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append(", duration=");
    ((StringBuilder)localObject).append(n);
    AEQLog.a("WinkAlbumLinearLayout", ((StringBuilder)localObject).toString());
    f();
    this.f.setIntValues(new int[] { getScrollY(), this.e });
    this.f.setDuration(n);
    this.f.start();
    localObject = this.k;
    if (localObject != null) {
      ((WinkAlbumLinearLayout.ScrollListener)localObject).a(false);
    }
  }
  
  public void b()
  {
    AEQLog.a("WinkAlbumLinearLayout", "[expandPreviewContainer]");
    if (getScrollY() <= 0)
    {
      AEQLog.a("WinkAlbumLinearLayout", "[expandPreviewContainer], already expanded");
      return;
    }
    this.j = 2;
    int m = -getScrollY();
    int n = (int)(getScrollY() * 1.0F / this.e * 275.0F);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[expandPreviewContainer], dy=");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append(", duration=");
    ((StringBuilder)localObject).append(n);
    AEQLog.a("WinkAlbumLinearLayout", ((StringBuilder)localObject).toString());
    f();
    this.f.setIntValues(new int[] { getScrollY(), 0 });
    this.f.setDuration(n);
    this.f.start();
    localObject = this.k;
    if (localObject != null) {
      ((WinkAlbumLinearLayout.ScrollListener)localObject).a(true);
    }
  }
  
  public boolean c()
  {
    return getScrollY() == 0;
  }
  
  public boolean d()
  {
    return getScrollY() == this.e;
  }
  
  public int getNestedScrollAxes()
  {
    AEQLog.a("WinkAlbumLinearLayout", "[getNestedScrollAxes]");
    return 2;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = getChildAt(0);
    this.b = getChildAt(1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.d = this.a.getMeasuredHeight();
    paramInt1 = this.d;
    paramInt2 = this.c;
    if ((paramInt1 < paramInt2) || (paramInt2 == 0)) {
      this.c = (this.d / 3);
    }
    this.e = (this.d - this.c);
    this.b.getLayoutParams().height = (getMeasuredHeight() - this.c);
    setMeasuredDimension(getMeasuredWidth(), this.a.getMeasuredHeight() + this.b.getMeasuredHeight());
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onNestedFling], velocityX=");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(", velocityY=");
    localStringBuilder.append(paramFloat2);
    localStringBuilder.append(", consumed=");
    localStringBuilder.append(paramBoolean);
    AEQLog.a("WinkAlbumLinearLayout", localStringBuilder.toString());
    return super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    paramView = new StringBuilder();
    paramView.append("[onNestedPreFling], velocityX=");
    paramView.append(paramFloat1);
    paramView.append(", velocityY=");
    paramView.append(paramFloat2);
    AEQLog.a("WinkAlbumLinearLayout", paramView.toString());
    if ((paramFloat2 > 0.0F) && (getScrollY() < this.e))
    {
      a();
      this.h = true;
    }
    return this.h;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onNestedPreScroll], dy=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", scrollY=");
    localStringBuilder.append(getScrollY());
    AEQLog.a("WinkAlbumLinearLayout", localStringBuilder.toString());
    int n = 1;
    if ((paramInt2 > 0) && (getScrollY() < this.e)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    int m;
    if ((paramInt2 < 0) && (getScrollY() > 0) && (!ViewCompat.canScrollVertically(paramView, -1))) {
      m = 1;
    } else {
      m = 0;
    }
    if ((paramInt1 != 0) || (m != 0))
    {
      if (paramInt1 != 0) {
        paramInt2 = Math.min(paramInt2, this.e - getScrollY());
      } else {
        paramInt2 = Math.max(paramInt2, -getScrollY());
      }
      scrollBy(0, paramInt2);
      paramArrayOfInt[1] = paramInt2;
      if (paramInt1 != 0) {
        paramInt1 = n;
      } else {
        paramInt1 = 2;
      }
      this.i = paramInt1;
      paramView = this.k;
      if (paramView != null)
      {
        paramView.a(this.i);
        this.k.b(g());
      }
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onNestedScroll], dxConsumed=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", dyConsumed=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", dxUnconsumed=");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", dyUnconsumed=");
    localStringBuilder.append(paramInt4);
    AEQLog.a("WinkAlbumLinearLayout", localStringBuilder.toString());
    super.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    paramView = this.k;
    if (paramView != null) {
      paramView.b(g());
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onNestedScrollAccepted], axes=");
    localStringBuilder.append(paramInt);
    AEQLog.a("WinkAlbumLinearLayout", localStringBuilder.toString());
    super.onNestedScrollAccepted(paramView1, paramView2, paramInt);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    paramView1 = new StringBuilder();
    paramView1.append("[onStartNestedScroll], nestedScrollAxes=");
    paramView1.append(paramInt);
    AEQLog.a("WinkAlbumLinearLayout", paramView1.toString());
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onStopNestedScroll], scrollY=");
    localStringBuilder.append(getScrollY());
    AEQLog.a("WinkAlbumLinearLayout", localStringBuilder.toString());
    super.onStopNestedScroll(paramView);
    if (!this.h) {
      e();
    } else {
      this.h = false;
    }
    paramView = this.k;
    if (paramView != null)
    {
      int m = this.i;
      paramView.a(m, a(m));
    }
    this.i = 0;
  }
  
  public void setScrollListener(@Nullable WinkAlbumLinearLayout.ScrollListener paramScrollListener)
  {
    this.k = paramScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.album.WinkAlbumLinearLayout
 * JD-Core Version:    0.7.0.1
 */
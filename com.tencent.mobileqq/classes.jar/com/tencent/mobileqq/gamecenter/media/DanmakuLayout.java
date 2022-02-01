package com.tencent.mobileqq.gamecenter.media;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.core.util.Pools.Pool;
import androidx.core.util.Pools.SimplePool;
import java.util.LinkedList;
import java.util.List;

public class DanmakuLayout
  extends ViewGroup
  implements DanmakuHost
{
  private List<DanmakuHost.Item> a = new LinkedList();
  private DanmakuLayout.Track[] b;
  private float c = 50.0F;
  private int d = 9;
  private int e;
  private DanmakuHost.TimeSupplier f;
  private long g;
  private int h;
  private Pools.Pool<DanmakuLayout.DrawItem> i = new Pools.SimplePool(20);
  private Runnable j = new DanmakuLayout.1(this);
  
  public DanmakuLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public DanmakuLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DanmakuLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(long paramLong)
  {
    if (removeCallbacks(this.j)) {
      postDelayed(this.j, paramLong);
    }
  }
  
  private boolean c()
  {
    return this.b != null;
  }
  
  private void d()
  {
    b();
    this.h = (getWidth() - getPaddingLeft() - getPaddingRight());
    Object localObject = f();
    ((DanmakuLayout.DrawItem)localObject).a(new DanmakuHost.Item("", 0.0D));
    DanmakuLayout.DrawItem.a((DanmakuLayout.DrawItem)localObject);
    this.e = ((DanmakuLayout.DrawItem)localObject).i;
    ((DanmakuLayout.DrawItem)localObject).a();
    this.b = new DanmakuLayout.Track[(getHeight() - getPaddingTop() - getPaddingBottom()) / (this.e + this.d)];
    int m = getPaddingTop();
    int n = getPaddingLeft();
    int k = 0;
    for (;;)
    {
      localObject = this.b;
      if (k >= localObject.length) {
        break;
      }
      localObject[k] = new DanmakuLayout.Track(this);
      this.b[k].a(n, m, getWidth() - getPaddingRight(), this.e + m);
      m += this.e + this.d;
      k += 1;
    }
    invalidate();
    a(0L);
  }
  
  private boolean e()
  {
    long l = SystemClock.uptimeMillis();
    int k = 0;
    boolean bool2;
    for (boolean bool1 = false;; bool1 = bool2)
    {
      Object localObject = this.b;
      if (k >= localObject.length) {
        break;
      }
      localObject = localObject[k];
      bool2 = bool1;
      if (((DanmakuLayout.Track)localObject).a())
      {
        this.b[k].a(l);
        bool2 = bool1 | ((DanmakuLayout.Track)localObject).a();
      }
      k += 1;
    }
    return bool1;
  }
  
  private DanmakuLayout.DrawItem f()
  {
    DanmakuLayout.DrawItem localDrawItem = (DanmakuLayout.DrawItem)this.i.acquire();
    if (localDrawItem != null) {
      return localDrawItem;
    }
    return new DanmakuLayout.DrawItem(this, null);
  }
  
  public void a()
  {
    removeCallbacks(this.j);
    this.a.clear();
  }
  
  public void a(DanmakuHost.Item... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    int k = 0;
    while (k < paramVarArgs.length)
    {
      DanmakuHost.Item localItem = paramVarArgs[k];
      int m = 0;
      while ((m < this.a.size()) && (localItem.c >= ((DanmakuHost.Item)this.a.get(m)).c)) {
        m += 1;
      }
      this.a.add(m, localItem);
      k += 1;
    }
    a(this.g);
  }
  
  public void b()
  {
    if (c())
    {
      int k = 0;
      boolean bool = false;
      for (;;)
      {
        DanmakuLayout.Track[] arrayOfTrack = this.b;
        if (k >= arrayOfTrack.length) {
          break;
        }
        bool |= arrayOfTrack[k].b();
        k += 1;
      }
      if (bool) {
        invalidate();
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!c()) {
      return;
    }
    boolean bool = e();
    super.dispatchDraw(paramCanvas);
    if (bool) {
      invalidate();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.j);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    d();
  }
  
  public void setLineSpacing(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    int k;
    if (this.d != paramInt) {
      k = 1;
    } else {
      k = 0;
    }
    this.d = paramInt;
    if ((k != 0) && (c())) {
      d();
    }
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k;
    if ((paramInt2 == getPaddingTop()) && (paramInt4 == getPaddingBottom())) {
      k = 0;
    } else {
      k = 1;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((k != 0) && (c())) {
      d();
    }
  }
  
  public void setShown(boolean paramBoolean)
  {
    int k;
    if (paramBoolean) {
      k = 0;
    } else {
      k = 8;
    }
    setVisibility(k);
  }
  
  public void setTextSize(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return;
    }
    int k;
    if (this.c != paramFloat) {
      k = 1;
    } else {
      k = 0;
    }
    this.c = paramFloat;
    if ((k != 0) && (c())) {
      d();
    }
  }
  
  public void setTimeSupplier(DanmakuHost.TimeSupplier paramTimeSupplier, long paramLong)
  {
    if (paramTimeSupplier != null)
    {
      this.f = paramTimeSupplier;
      this.g = paramLong;
      return;
    }
    throw new NullPointerException("timeSupplier must not be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.DanmakuLayout
 * JD-Core Version:    0.7.0.1
 */
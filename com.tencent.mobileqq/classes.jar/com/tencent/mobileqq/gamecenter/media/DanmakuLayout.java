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
  private float jdField_a_of_type_Float = 50.0F;
  private int jdField_a_of_type_Int = 9;
  private long jdField_a_of_type_Long;
  private Pools.Pool<DanmakuLayout.DrawItem> jdField_a_of_type_AndroidxCoreUtilPools$Pool = new Pools.SimplePool(20);
  private DanmakuHost.TimeSupplier jdField_a_of_type_ComTencentMobileqqGamecenterMediaDanmakuHost$TimeSupplier;
  private Runnable jdField_a_of_type_JavaLangRunnable = new DanmakuLayout.1(this);
  private List<DanmakuHost.Item> jdField_a_of_type_JavaUtilList = new LinkedList();
  private DanmakuLayout.Track[] jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterMediaDanmakuLayout$Track;
  private int b;
  private int c;
  
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
  
  private DanmakuLayout.DrawItem a()
  {
    DanmakuLayout.DrawItem localDrawItem = (DanmakuLayout.DrawItem)this.jdField_a_of_type_AndroidxCoreUtilPools$Pool.acquire();
    if (localDrawItem != null) {
      return localDrawItem;
    }
    return new DanmakuLayout.DrawItem(this, null);
  }
  
  private void a(long paramLong)
  {
    if (removeCallbacks(this.jdField_a_of_type_JavaLangRunnable)) {
      postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterMediaDanmakuLayout$Track != null;
  }
  
  private boolean b()
  {
    long l = SystemClock.uptimeMillis();
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false;; bool1 = bool2)
    {
      Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterMediaDanmakuLayout$Track;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      bool2 = bool1;
      if (((DanmakuLayout.Track)localObject).a())
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterMediaDanmakuLayout$Track[i].a(l);
        bool2 = bool1 | ((DanmakuLayout.Track)localObject).a();
      }
      i += 1;
    }
    return bool1;
  }
  
  private void c()
  {
    b();
    this.c = (getWidth() - getPaddingLeft() - getPaddingRight());
    Object localObject = a();
    ((DanmakuLayout.DrawItem)localObject).a(new DanmakuHost.Item("", 0.0D));
    DanmakuLayout.DrawItem.a((DanmakuLayout.DrawItem)localObject);
    this.b = ((DanmakuLayout.DrawItem)localObject).c;
    ((DanmakuLayout.DrawItem)localObject).a();
    this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterMediaDanmakuLayout$Track = new DanmakuLayout.Track[(getHeight() - getPaddingTop() - getPaddingBottom()) / (this.b + this.jdField_a_of_type_Int)];
    int j = getPaddingTop();
    int k = getPaddingLeft();
    int i = 0;
    for (;;)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterMediaDanmakuLayout$Track;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = new DanmakuLayout.Track(this);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterMediaDanmakuLayout$Track[i].a(k, j, getWidth() - getPaddingRight(), this.b + j);
      j += this.b + this.jdField_a_of_type_Int;
      i += 1;
    }
    invalidate();
    a(0L);
  }
  
  public void a()
  {
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(DanmakuHost.Item... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    int i = 0;
    while (i < paramVarArgs.length)
    {
      DanmakuHost.Item localItem = paramVarArgs[i];
      int j = 0;
      while ((j < this.jdField_a_of_type_JavaUtilList.size()) && (localItem.jdField_a_of_type_Long >= ((DanmakuHost.Item)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_Long)) {
        j += 1;
      }
      this.jdField_a_of_type_JavaUtilList.add(j, localItem);
      i += 1;
    }
    a(this.jdField_a_of_type_Long);
  }
  
  public void b()
  {
    if (a())
    {
      int i = 0;
      boolean bool = false;
      for (;;)
      {
        DanmakuLayout.Track[] arrayOfTrack = this.jdField_a_of_type_ArrayOfComTencentMobileqqGamecenterMediaDanmakuLayout$Track;
        if (i >= arrayOfTrack.length) {
          break;
        }
        bool |= arrayOfTrack[i].b();
        i += 1;
      }
      if (bool) {
        invalidate();
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!a()) {
      return;
    }
    boolean bool = b();
    super.dispatchDraw(paramCanvas);
    if (bool) {
      invalidate();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c();
  }
  
  public void setLineSpacing(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    int i;
    if (this.jdField_a_of_type_Int != paramInt) {
      i = 1;
    } else {
      i = 0;
    }
    this.jdField_a_of_type_Int = paramInt;
    if ((i != 0) && (a())) {
      c();
    }
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    if ((paramInt2 == getPaddingTop()) && (paramInt4 == getPaddingBottom())) {
      i = 0;
    } else {
      i = 1;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((i != 0) && (a())) {
      c();
    }
  }
  
  public void setShown(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    setVisibility(i);
  }
  
  public void setTextSize(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return;
    }
    int i;
    if (this.jdField_a_of_type_Float != paramFloat) {
      i = 1;
    } else {
      i = 0;
    }
    this.jdField_a_of_type_Float = paramFloat;
    if ((i != 0) && (a())) {
      c();
    }
  }
  
  public void setTimeSupplier(DanmakuHost.TimeSupplier paramTimeSupplier, long paramLong)
  {
    if (paramTimeSupplier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaDanmakuHost$TimeSupplier = paramTimeSupplier;
      this.jdField_a_of_type_Long = paramLong;
      return;
    }
    throw new NullPointerException("timeSupplier must not be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.DanmakuLayout
 * JD-Core Version:    0.7.0.1
 */
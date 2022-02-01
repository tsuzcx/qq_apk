package com.tencent.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SpeedFlexibleRecyclerView
  extends RecyclerView
{
  private SpeedFlexibleRecyclerView.OnFlingListener mOnFlingListener;
  
  public SpeedFlexibleRecyclerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SpeedFlexibleRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SpeedFlexibleRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    if (getLayoutManager() == null) {
      return false;
    }
    boolean bool1 = getLayoutManager().canScrollHorizontally();
    boolean bool2 = getLayoutManager().canScrollVertically();
    int i;
    if (bool1)
    {
      i = paramInt1;
      if (Math.abs(paramInt1) >= getMinFlingVelocity()) {}
    }
    else
    {
      i = 0;
    }
    if (bool2)
    {
      paramInt1 = paramInt2;
      if (Math.abs(paramInt2) >= getMinFlingVelocity()) {}
    }
    else
    {
      paramInt1 = 0;
    }
    if ((i == 0) && (paramInt1 == 0)) {
      return false;
    }
    SpeedFlexibleRecyclerView.OnFlingListener localOnFlingListener = this.mOnFlingListener;
    if ((localOnFlingListener != null) && (localOnFlingListener.onFling(i, paramInt1))) {
      return true;
    }
    return super.fling(i, paramInt1);
  }
  
  @Nullable
  public SpeedFlexibleRecyclerView.OnFlingListener getOnFlingListener()
  {
    return this.mOnFlingListener;
  }
  
  public void setMaxFlingVelocityX()
  {
    try
    {
      Field localField = RecyclerView.class.getDeclaredField("mMaxFlingVelocity");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(getMaxFlingVelocity() / 15));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SpeedFlexibleRecyclerView", 2, localException.getMessage());
      }
    }
  }
  
  public void setOnFlingListener(@Nullable SpeedFlexibleRecyclerView.OnFlingListener paramOnFlingListener)
  {
    this.mOnFlingListener = paramOnFlingListener;
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject = RecyclerView.class.getDeclaredField("mViewFlinger");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this);
      Method localMethod = Class.forName("android.support.v7.widget.RecyclerView$ViewFlinger").getDeclaredMethod("smoothScrollBy", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(localObject, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SpeedFlexibleRecyclerView", 2, localInvocationTargetException.getMessage());
      }
      super.smoothScrollBy(paramInt1, paramInt2);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SpeedFlexibleRecyclerView", 2, localIllegalAccessException.getMessage());
      }
      super.smoothScrollBy(paramInt1, paramInt2);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SpeedFlexibleRecyclerView", 2, localNoSuchMethodException.getMessage());
      }
      super.smoothScrollBy(paramInt1, paramInt2);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SpeedFlexibleRecyclerView", 2, localClassNotFoundException.getMessage());
      }
      super.smoothScrollBy(paramInt1, paramInt2);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SpeedFlexibleRecyclerView", 2, localNoSuchFieldException.getMessage());
      }
      super.smoothScrollBy(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.SpeedFlexibleRecyclerView
 * JD-Core Version:    0.7.0.1
 */
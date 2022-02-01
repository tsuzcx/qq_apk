package com.tencent.mobileqq.multiaio.widget;

import android.content.Context;
import android.widget.OverScroller;
import com.tencent.qphone.base.util.QLog;

public class MultiAioOverScroller
  extends OverScroller
{
  private MultiAioOverScroller.OnSpringBack a;
  
  public MultiAioOverScroller(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(MultiAioOverScroller.OnSpringBack paramOnSpringBack)
  {
    this.a = paramOnSpringBack;
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fling() called with: startX = [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], startY = [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], velocityX = [");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], velocityY = [");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("], minX = [");
      localStringBuilder.append(paramInt5);
      localStringBuilder.append("], maxX = [");
      localStringBuilder.append(paramInt6);
      localStringBuilder.append("], minY = [");
      localStringBuilder.append(paramInt7);
      localStringBuilder.append("], maxY = [");
      localStringBuilder.append(paramInt8);
      localStringBuilder.append("], overX = [");
      localStringBuilder.append(paramInt9);
      localStringBuilder.append("], overY = [");
      localStringBuilder.append(paramInt10);
      localStringBuilder.append("]");
      QLog.d("MultiAioOverScroller", 2, localStringBuilder.toString());
    }
    super.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }
  
  public boolean springBack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("springBack() called with: startX = [");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], startY = [");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("], minX = [");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append("], maxX = [");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append("], minY = [");
      ((StringBuilder)localObject).append(paramInt5);
      ((StringBuilder)localObject).append("], maxY = [");
      ((StringBuilder)localObject).append(paramInt6);
      ((StringBuilder)localObject).append("]");
      QLog.d("MultiAioOverScroller", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((MultiAioOverScroller.OnSpringBack)localObject).a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
    return super.springBack(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAioOverScroller
 * JD-Core Version:    0.7.0.1
 */
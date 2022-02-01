package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

public abstract class BaseLayer
{
  protected Context a;
  protected Rect a;
  protected DoodleView a;
  
  public BaseLayer(DoodleView paramDoodleView)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    if (paramDoodleView != null)
    {
      this.jdField_a_of_type_AndroidContentContext = paramDoodleView.getContext();
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView = paramDoodleView;
      return;
    }
    throw new IllegalStateException("DoodleView can not be null.");
  }
  
  public void a()
  {
    DoodleView localDoodleView = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView;
    if (localDoodleView != null) {
      localDoodleView.invalidate();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return;
      }
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, paramInt1, paramInt2);
    }
  }
  
  public final void a(Canvas paramCanvas)
  {
    b(paramCanvas);
  }
  
  public boolean a()
  {
    return b();
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    a();
    return b(paramMotionEvent);
  }
  
  protected abstract void b(Canvas paramCanvas);
  
  public boolean b()
  {
    return true;
  }
  
  protected abstract boolean b(MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.BaseLayer
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import azav;
import azbj;
import azca;
import bkkz;
import bkla;
import bkmd;
import bkmq;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class HongBaoListView
  extends FPSSwipListView
{
  public int a;
  private long jdField_a_of_type_Long;
  public Bitmap a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  public azav a;
  public azbj a;
  public bkla a;
  bkmq jdField_a_of_type_Bkmq;
  public float[] a;
  public boolean[] a;
  public int b;
  Drawable b;
  public int c;
  public int d;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  public boolean m;
  
  public HongBaoListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[10];
    this.jdField_a_of_type_ArrayOfFloat = new float[10];
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new bkkz(this));
  }
  
  public HongBaoListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[10];
    this.jdField_a_of_type_ArrayOfFloat = new float[10];
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new bkkz(this));
  }
  
  public int a()
  {
    return computeVerticalScrollOffset();
  }
  
  public void a(int paramInt)
  {
    setHongBaoAlpha(255);
    setSelection(0);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 5, paramInt, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 150L);
  }
  
  public void a(long paramLong)
  {
    springBackOverScrollHeaderView();
  }
  
  public void d()
  {
    super.setOverScrollListener(this.jdField_a_of_type_Bkmq);
    e();
    setComboListener(null);
    super.setOverscrollHeader(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    super.setOverScrollHeader(this.jdField_a_of_type_AndroidViewView);
    super.setContentBackground(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    setOverscrollHeaderShadowEnable(true);
    this.f = false;
    i();
    f();
    this.mForHongBao = false;
    this.g = false;
    this.h = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i1 = 0;
    super.draw(paramCanvas);
    if ((this.f) && (this.k) && (!this.g))
    {
      int i2 = getListViewScrollY();
      int n = i2;
      if (i2 < 0) {
        n = 0;
      }
      this.jdField_a_of_type_Azbj.k = (-n);
      n = i1;
      if (this.jdField_a_of_type_Azbj.a(paramCanvas)) {
        n = 1;
      }
      if (n != 0) {
        invalidate();
      }
    }
  }
  
  public void e()
  {
    if (this.f == true)
    {
      if (this.m)
      {
        bkmr.jdField_a_of_type_Int = 300;
        return;
      }
      bkmr.jdField_a_of_type_Int = 600;
      return;
    }
    bkmr.jdField_a_of_type_Int = 400;
  }
  
  public void f()
  {
    if (this.g) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    setIsShowingPreguide(false);
  }
  
  public void g()
  {
    h();
    this.jdField_a_of_type_Azbj.a(false, this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_Azbj.c();
    invalidate();
  }
  
  public int getListViewScrollY()
  {
    View localView = getChildAt(0);
    if (localView == null) {
      return getScrollY();
    }
    int i2 = getFirstVisiblePosition();
    if (i2 >= this.mHeaderViewInfos.size())
    {
      Iterator localIterator = this.mHeaderViewInfos.iterator();
      for (n = 0; localIterator.hasNext(); n = ((bkmd)localIterator.next()).jdField_a_of_type_AndroidViewView.getHeight() + n) {}
      return -localView.getTop() + (i2 - this.mHeaderViewInfos.size()) * localView.getHeight() + n;
    }
    int n = 0;
    int i1 = 0;
    while (n < i2)
    {
      i1 += ((bkmd)this.mHeaderViewInfos.get(n)).jdField_a_of_type_AndroidViewView.getHeight();
      n += 1;
    }
    return -localView.getTop() + i1;
  }
  
  protected int getSpringbackOffset()
  {
    if ((!this.f) || (this.g)) {
      return super.getSpringbackOffset();
    }
    return this.c;
  }
  
  public void h()
  {
    this.jdField_a_of_type_Azbj.e();
    if (this.jdField_a_of_type_Azbj.a != null) {
      this.jdField_a_of_type_Azbj.a.c();
    }
  }
  
  public void i()
  {
    if (!this.k) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "hideHongBao ," + this.k);
    }
    h();
    this.k = false;
  }
  
  public boolean isOverscrollHeadVisiable()
  {
    if (this.f) {
      return getScrollY() < 0;
    }
    return super.isOverscrollHeadVisiable();
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "showHongBao ," + this.k);
    }
    h();
    this.k = true;
    this.jdField_a_of_type_Azbj.j = 255;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!this.f) || (this.g)) {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
    }
    while (!this.jdField_a_of_type_Azav.d) {
      return bool;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent.getY();
      this.jdField_a_of_type_ArrayOfBoolean[0] = true;
      if (this.jdField_a_of_type_Bkla != null) {
        this.jdField_a_of_type_Bkla.a(this);
      }
      if ((this.k) && (this.jdField_a_of_type_Azbj != null) && (this.jdField_a_of_type_Azbj.a(getScrollY()).contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
      {
        if (getScrollY() == 0) {
          this.j = true;
        }
        super.onInterceptTouchEvent(paramMotionEvent);
        return true;
      }
      this.j = false;
      f();
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      if (this.g) {
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      } while (this.jdField_a_of_type_Bkla == null);
      this.jdField_a_of_type_Bkla.a(paramInt1, paramInt2);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_Azbj != null) && (this.jdField_a_of_type_Azbj.a != null)) {
      this.jdField_a_of_type_Azbj.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!this.f) || (this.g)) {
      bool = super.onTouchEvent(paramMotionEvent);
    }
    while (!this.jdField_a_of_type_Azav.d) {
      return bool;
    }
    bool = super.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return bool;
      if (this.jdField_a_of_type_Bkla != null) {
        this.jdField_a_of_type_Bkla.b(this);
      }
      if (paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int) == -1) {}
      switch (this.mTouchMode)
      {
      case 4: 
      default: 
        break;
      case 3: 
      case 5: 
        if (this.jdField_a_of_type_Bkla != null)
        {
          int n = paramMotionEvent.getPointerCount();
          if (n > this.jdField_b_of_type_Int) {
            this.jdField_b_of_type_Int = n;
          }
          float f1 = 0.0F;
          n = 0;
          while (n < paramMotionEvent.getPointerCount())
          {
            float f3 = paramMotionEvent.getY(n) - this.jdField_a_of_type_ArrayOfFloat[n];
            float f2 = f1;
            if (this.jdField_a_of_type_ArrayOfBoolean[n] != 0)
            {
              f2 = f1;
              if (f3 > f1) {
                f2 = f3;
              }
            }
            n += 1;
            f1 = f2;
          }
          if (-getScrollY() >= this.d / 2)
          {
            if (f1 > this.d / 2)
            {
              setSpringbackOffset(-this.d);
              this.jdField_a_of_type_Bkla.c();
              n = 0;
              while (n < this.jdField_b_of_type_Int)
              {
                this.jdField_a_of_type_ArrayOfBoolean[n] = false;
                n += 1;
              }
            }
            this.jdField_a_of_type_Bkla.a();
            continue;
            if (this.j)
            {
              long l1 = System.currentTimeMillis();
              if ((this.jdField_a_of_type_Azbj != null) && (l1 - this.jdField_a_of_type_Long > 800L) && (getScrollY() == 0))
              {
                this.jdField_a_of_type_Long = l1;
                if (this.jdField_a_of_type_Azbj.a(getScrollY()).contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
                  this.jdField_a_of_type_Bkla.b();
                }
              }
            }
            this.j = false;
            if (this.jdField_a_of_type_Bkla != null) {
              this.jdField_a_of_type_Bkla.c(this);
            }
            this.jdField_a_of_type_Int = -1;
            continue;
            this.jdField_a_of_type_Int = -1;
            this.j = false;
            continue;
            n = paramMotionEvent.getActionIndex();
            this.jdField_a_of_type_ArrayOfFloat[n] = ((int)paramMotionEvent.getY(n));
            this.jdField_a_of_type_ArrayOfBoolean[n] = true;
            continue;
            n = paramMotionEvent.getActionIndex();
            this.jdField_a_of_type_ArrayOfBoolean[n] = false;
          }
        }
        break;
      }
    }
  }
  
  public void onTouchUpWithYVelocity(int paramInt1, int paramInt2) {}
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.l) {
      this.l = false;
    }
  }
  
  public void setComboListener(bkla parambkla)
  {
    this.jdField_a_of_type_Bkla = parambkla;
  }
  
  public void setContentBackground(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    }
    if (this.mForHongBao)
    {
      super.setContentBackground(paramDrawable, false);
      return;
    }
    super.setContentBackground(paramDrawable);
  }
  
  public void setHongBaoAlpha(int paramInt) {}
  
  public void setIsShowingPreguide(boolean paramBoolean)
  {
    this.m = paramBoolean;
    e();
  }
  
  public void setLogo(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Azbj != null) {
      this.jdField_a_of_type_Azbj.a(paramBoolean, paramBitmap);
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    invalidate();
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "setLogo ," + this.k + ", " + this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
  
  public void setOverScrollHeader(View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_AndroidViewView = paramView;
    }
    if (this.mForHongBao)
    {
      super.setOverScrollHeader(null);
      return;
    }
    super.setOverScrollHeader(paramView);
  }
  
  public void setOverScrollListener(bkmq parambkmq)
  {
    if (parambkmq != null) {
      this.jdField_a_of_type_Bkmq = parambkmq;
    }
    if (this.mForHongBao)
    {
      super.setOverScrollListener(null);
      return;
    }
    super.setOverScrollListener(parambkmq);
  }
  
  public void setOverscrollHeader(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    }
    if (this.mForHongBao)
    {
      super.setOverscrollHeader(null);
      return;
    }
    super.setOverscrollHeader(paramDrawable);
  }
  
  public void setOverscrollHeaderShadowEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mOverScrollHeaderShadow = getResources().getDrawable(2130840519);
      return;
    }
    this.mOverScrollHeaderShadow = null;
  }
  
  public void setSpringbackOffset(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.HongBaoListView
 * JD-Core Version:    0.7.0.1
 */
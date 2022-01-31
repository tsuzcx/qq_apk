package com.tencent.widget;

import ambx;
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
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.portal.ConversationHongBao;
import com.tencent.mobileqq.portal.HongBaoPendantHolder;
import com.tencent.mobileqq.portal.SaQianView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class HongBaoListView
  extends FPSSwipListView
{
  private long a;
  public Bitmap a;
  public Handler a;
  public ConversationHongBao a;
  public HongBaoPendantHolder a;
  public HongBaoListViewListener a;
  public float[] a;
  public boolean[] a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  OverScrollViewListener jdField_b_of_type_ComTencentWidgetOverScrollViewListener;
  public int c;
  Drawable c;
  public int d;
  Drawable d;
  public int e;
  public int f;
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
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[10];
    this.jdField_a_of_type_ArrayOfFloat = new float[10];
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new ambx(this));
  }
  
  public HongBaoListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[10];
    this.jdField_a_of_type_ArrayOfFloat = new float[10];
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new ambx(this));
  }
  
  public int a()
  {
    View localView = getChildAt(0);
    if (localView == null) {
      return getScrollY();
    }
    int i2 = getFirstVisiblePosition();
    if (i2 >= this.mHeaderViewInfos.size())
    {
      Iterator localIterator = this.mHeaderViewInfos.iterator();
      for (n = 0; localIterator.hasNext(); n = ((ListView.FixedViewInfo)localIterator.next()).a.getHeight() + n) {}
      return -localView.getTop() + (i2 - this.mHeaderViewInfos.size()) * localView.getHeight() + n;
    }
    int n = 0;
    int i1 = 0;
    while (n < i2)
    {
      i1 += ((ListView.FixedViewInfo)this.mHeaderViewInfos.get(n)).a.getHeight();
      n += 1;
    }
    return -localView.getTop() + i1;
  }
  
  public void a(long paramLong)
  {
    springBackOverScrollHeaderView();
  }
  
  public int b()
  {
    return computeVerticalScrollOffset();
  }
  
  public void b(int paramInt)
  {
    setHongBaoAlpha(255);
    setSelection(0);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 5, paramInt, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 150L);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i1 = 0;
    super.draw(paramCanvas);
    if ((this.g) && (this.k) && (!this.h))
    {
      int i2 = a();
      int n = i2;
      if (i2 < 0) {
        n = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.k = (-n);
      n = i1;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(paramCanvas)) {
        n = 1;
      }
      if (n != 0) {
        invalidate();
      }
    }
  }
  
  protected int getSpringbackOffset()
  {
    if (!this.g) {
      return super.getSpringbackOffset();
    }
    return this.jdField_d_of_type_Int;
  }
  
  public boolean isOverscrollHeadVisiable()
  {
    if (this.g) {
      return getScrollY() < 0;
    }
    return super.isOverscrollHeadVisiable();
  }
  
  public void k()
  {
    super.setOverScrollListener(this.jdField_b_of_type_ComTencentWidgetOverScrollViewListener);
    l();
    setComboListener(null);
    super.setOverscrollHeader(this.jdField_d_of_type_AndroidGraphicsDrawableDrawable);
    super.setOverScrollHeader(this.jdField_b_of_type_AndroidViewView);
    super.setContentBackground(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
    setOverscrollHeaderShadowEnable(true);
    this.g = false;
    r();
    o();
    this.mForHongBao = false;
    this.h = false;
    this.i = false;
  }
  
  public void l()
  {
    if (this.g == true)
    {
      if (this.m)
      {
        OverScroller.jdField_b_of_type_Int = 300;
        return;
      }
      OverScroller.jdField_b_of_type_Int = 600;
      return;
    }
    OverScroller.jdField_b_of_type_Int = 400;
  }
  
  public void m()
  {
    if (this.g) {
      return;
    }
    n();
    this.g = true;
    super.setOverScrollListener(null);
    super.setOverscrollHeader(null);
    super.setOverScrollHeader(null);
    setOverscrollHeaderShadowEnable(false);
    this.mForHongBao = true;
    this.h = false;
    this.i = true;
  }
  
  void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder = new HongBaoPendantHolder(this);
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(true, this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  public void o()
  {
    if (this.h) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    setIsShowingPreguide(false);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!this.g) || (this.h)) {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.d) {
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
      if (this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener != null) {
        this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.a(this);
      }
      if ((this.k) && (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(getScrollY()).contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
      {
        if (getScrollY() == 0) {
          this.j = true;
        }
        super.onInterceptTouchEvent(paramMotionEvent);
        return true;
      }
      this.j = false;
      o();
    }
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      if (this.h) {
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
      } while (this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener == null);
      this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.a(paramInt1, paramInt2);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!this.g) || (this.h)) {
      bool = super.onTouchEvent(paramMotionEvent);
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.d) {
      return bool;
    }
    bool = super.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return bool;
      if (this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener != null) {
        this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.b(this);
      }
      if (paramMotionEvent.findPointerIndex(this.jdField_b_of_type_Int) == -1) {}
      switch (this.mTouchMode)
      {
      case 4: 
      default: 
        break;
      case 3: 
      case 5: 
        if (this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener != null)
        {
          int n = paramMotionEvent.getPointerCount();
          if (n > this.jdField_c_of_type_Int) {
            this.jdField_c_of_type_Int = n;
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
          if (-getScrollY() >= this.f / 2)
          {
            if (f1 > this.f / 2)
            {
              setSpringbackOffset(-this.f);
              this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.c();
              n = 0;
              while (n < this.jdField_c_of_type_Int)
              {
                this.jdField_a_of_type_ArrayOfBoolean[n] = false;
                n += 1;
              }
            }
            this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.a();
            continue;
            if (this.j)
            {
              long l1 = System.currentTimeMillis();
              if ((this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) && (l1 - this.jdField_a_of_type_Long > 800L) && (getScrollY() == 0))
              {
                this.jdField_a_of_type_Long = l1;
                if (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(getScrollY()).contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
                  this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.b();
                }
              }
            }
            this.j = false;
            if (this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener != null) {
              this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.c(this);
            }
            this.jdField_b_of_type_Int = -1;
            continue;
            this.jdField_b_of_type_Int = -1;
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
  
  public void p()
  {
    q();
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(false, this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.d();
    invalidate();
  }
  
  public void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.c();
    if (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a.c();
    }
  }
  
  public void r()
  {
    if (!this.k) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "hideHongBao ," + this.k);
    }
    q();
    this.k = false;
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "showHongBao ," + this.k);
    }
    q();
    this.k = true;
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.j = 255;
  }
  
  public void setComboListener(HongBaoListViewListener paramHongBaoListViewListener)
  {
    this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener = paramHongBaoListViewListener;
  }
  
  public void setContentBackground(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
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
    l();
  }
  
  public void setLogo(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(paramBoolean, paramBitmap);
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
      this.jdField_b_of_type_AndroidViewView = paramView;
    }
    if (this.mForHongBao)
    {
      super.setOverScrollHeader(null);
      return;
    }
    super.setOverScrollHeader(paramView);
  }
  
  public void setOverScrollListener(OverScrollViewListener paramOverScrollViewListener)
  {
    if (paramOverScrollViewListener != null) {
      this.jdField_b_of_type_ComTencentWidgetOverScrollViewListener = paramOverScrollViewListener;
    }
    if (this.mForHongBao)
    {
      super.setOverScrollListener(null);
      return;
    }
    super.setOverScrollListener(paramOverScrollViewListener);
  }
  
  public void setOverscrollHeader(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
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
      this.mOverScrollHeaderShadow = getResources().getDrawable(2130839293);
      return;
    }
    this.mOverScrollHeaderShadow = null;
  }
  
  public void setSpringbackOffset(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.HongBaoListView
 * JD-Core Version:    0.7.0.1
 */
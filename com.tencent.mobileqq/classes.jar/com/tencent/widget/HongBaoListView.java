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
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.portal.ConversationHongBaoV2;
import com.tencent.mobileqq.portal.HongBaoPendantHolder;
import com.tencent.mobileqq.portal.SaQianView;
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
  public ConversationHongBaoV2 a;
  public HongBaoPendantHolder a;
  public HongBaoListViewListener a;
  OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener;
  public float[] a;
  public boolean[] a;
  public int b;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_b_of_type_AndroidViewView;
  public int c;
  public int d = 0;
  public int e = 0;
  public boolean g;
  public boolean h = false;
  public boolean i = false;
  public boolean j = false;
  public boolean k = false;
  public boolean l;
  public boolean m = false;
  public boolean n = false;
  
  public HongBaoListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[10];
    this.jdField_a_of_type_ArrayOfFloat = new float[10];
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new HongBaoListView.1(this));
  }
  
  public HongBaoListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[10];
    this.jdField_a_of_type_ArrayOfFloat = new float[10];
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new HongBaoListView.1(this));
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
  
  public void b(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateBrushHBActPendantLogo ,pendantLogoBitmap = ");
      ((StringBuilder)localObject).append(paramBitmap);
      ((StringBuilder)localObject).append(",mPendantHolder = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder);
      QLog.d("HongBaoListView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder;
    if (localObject != null) {
      ((HongBaoPendantHolder)localObject).a(paramBitmap);
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    invalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.g) && (this.l) && (!this.h))
    {
      int i2 = getListViewScrollY();
      int i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
      HongBaoPendantHolder localHongBaoPendantHolder = this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder;
      localHongBaoPendantHolder.g = (-i1);
      if (localHongBaoPendantHolder.a(paramCanvas)) {
        invalidate();
      }
    }
  }
  
  public int getListViewScrollY()
  {
    int i1 = 0;
    int i2 = 0;
    View localView = getChildAt(0);
    if (localView == null) {
      return getScrollY();
    }
    int i3 = getFirstVisiblePosition();
    if (i3 >= this.mHeaderViewInfos.size())
    {
      Iterator localIterator = this.mHeaderViewInfos.iterator();
      i1 = i2;
      while (localIterator.hasNext()) {
        i1 += ((ListView.FixedViewInfo)localIterator.next()).view.getHeight();
      }
      return i1 + (-localView.getTop() + (i3 - this.mHeaderViewInfos.size()) * localView.getHeight());
    }
    i2 = 0;
    while (i1 < i3)
    {
      i2 += ((ListView.FixedViewInfo)this.mHeaderViewInfos.get(i1)).view.getHeight();
      i1 += 1;
    }
    return -localView.getTop() + i2;
  }
  
  protected int getSpringbackOffset()
  {
    if ((this.g) && (!this.h)) {
      return this.c;
    }
    return super.getSpringbackOffset();
  }
  
  public void i()
  {
    super.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    j();
    setComboListener(null);
    super.setOverscrollHeader(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    super.setOverScrollHeader(this.jdField_a_of_type_AndroidViewView);
    super.setContentBackground(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    setOverscrollHeaderShadowEnable(true);
    this.g = false;
    q();
    n();
    this.mForHongBao = false;
    this.h = false;
    this.i = false;
  }
  
  public boolean isOverscrollHeadVisiable()
  {
    if (this.g) {
      return getScrollY() < 0;
    }
    return super.isOverscrollHeadVisiable();
  }
  
  public void j()
  {
    if (this.g == true)
    {
      if (this.n)
      {
        OverScroller.BOUNCE_DURANTION = 300;
        return;
      }
      OverScroller.BOUNCE_DURANTION = 600;
      return;
    }
    OverScroller.BOUNCE_DURANTION = 400;
  }
  
  public void k()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("modeHongbao mActive = ");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(",hongbaoModeListScrollHeaderView = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_AndroidViewView);
      QLog.d("HongBaoListView", 2, ((StringBuilder)localObject).toString());
    }
    l();
    this.g = true;
    super.setOverScrollListener(null);
    super.setOverscrollHeader(null);
    super.setOverScrollHeader(this.jdField_b_of_type_AndroidViewView);
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    setOverscrollHeaderShadowEnable(false);
    this.mForHongBao = true;
    this.h = false;
    this.i = true;
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder = new HongBaoPendantHolder(this);
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(true, this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HongBaoListView", 2, "clearPendant");
    }
    this.l = false;
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder = null;
  }
  
  public void n()
  {
    if (this.h) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    setIsShowingPreguide(false);
  }
  
  public void o()
  {
    p();
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(false, this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.d();
    invalidate();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.g) && (!this.h))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
      if ((localObject != null) && (!((ConversationHongBaoV2)localObject).c)) {
        return true;
      }
      if ((paramMotionEvent.getAction() & 0xFF) == 0)
      {
        this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent.getY();
        this.jdField_a_of_type_ArrayOfBoolean[0] = true;
        localObject = this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener;
        if (localObject != null) {
          ((HongBaoListViewListener)localObject).a(this);
        }
        if (this.l)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder;
          if ((localObject != null) && (((HongBaoPendantHolder)localObject).a(getScrollY()).contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
          {
            if (getScrollY() == 0) {
              this.k = true;
            }
            super.onInterceptTouchEvent(paramMotionEvent);
            if (QLog.isColorLevel())
            {
              paramMotionEvent = new StringBuilder();
              paramMotionEvent.append("2021_UI_ConversationHongBaoV2 HongBaoListView onInterceptTouchEvent return true, mComboListener = ");
              paramMotionEvent.append(this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener);
              QLog.d("HongBaoListView", 2, paramMotionEvent.toString());
            }
            return true;
          }
        }
        this.k = false;
        n();
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (this.h) {
      return;
    }
    HongBaoListViewListener localHongBaoListViewListener = this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener;
    if (localHongBaoListViewListener != null) {
      localHongBaoListViewListener.a(paramInt1, paramInt2);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    HongBaoPendantHolder localHongBaoPendantHolder = this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder;
    if ((localHongBaoPendantHolder != null) && (localHongBaoPendantHolder.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.g) && (!this.h))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
      boolean bool2 = true;
      if ((localObject != null) && (!((ConversationHongBaoV2)localObject).c)) {
        return true;
      }
      boolean bool3 = super.onTouchEvent(paramMotionEvent);
      int i1 = paramMotionEvent.getAction() & 0xFF;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              if (i1 != 5)
              {
                if (i1 != 6) {
                  return bool3;
                }
                i1 = paramMotionEvent.getActionIndex();
                this.jdField_a_of_type_ArrayOfBoolean[i1] = false;
                return bool3;
              }
              i1 = paramMotionEvent.getActionIndex();
              this.jdField_a_of_type_ArrayOfFloat[i1] = ((int)paramMotionEvent.getY(i1));
              this.jdField_a_of_type_ArrayOfBoolean[i1] = true;
              return bool3;
            }
            if (QLog.isColorLevel())
            {
              paramMotionEvent = new StringBuilder();
              paramMotionEvent.append("2021_UI_ConversationHongBaoV2 HongBaoListView ACTION_CANCEL mComboListener = ");
              paramMotionEvent.append(this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener);
              QLog.d("HongBaoListView", 2, paramMotionEvent.toString());
            }
            paramMotionEvent = this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener;
            if (paramMotionEvent != null) {
              paramMotionEvent.b(this);
            }
            this.jdField_a_of_type_Int = -1;
            this.k = false;
            return bool3;
          }
          localObject = this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener;
          if (localObject != null)
          {
            boolean bool1 = bool2;
            if (this.mTouchMode != 3) {
              if (this.mTouchMode == 5) {
                bool1 = bool2;
              } else {
                bool1 = false;
              }
            }
            ((HongBaoListViewListener)localObject).a(this, bool1);
          }
          paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int);
          i1 = this.mTouchMode;
          if ((i1 != 3) && (i1 != 5)) {
            return bool3;
          }
          if (this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener != null)
          {
            i1 = paramMotionEvent.getPointerCount();
            if (i1 > this.jdField_b_of_type_Int) {
              this.jdField_b_of_type_Int = i1;
            }
            i1 = 0;
            float f2;
            for (float f1 = 0.0F; i1 < paramMotionEvent.getPointerCount(); f1 = f2)
            {
              float f3 = paramMotionEvent.getY(i1) - this.jdField_a_of_type_ArrayOfFloat[i1];
              f2 = f1;
              if (this.jdField_a_of_type_ArrayOfBoolean[i1] != 0)
              {
                f2 = f1;
                if (f3 > f1) {
                  f2 = f3;
                }
              }
              i1 += 1;
            }
            i1 = -getScrollY();
            int i2 = this.e;
            if (i1 >= i2 / 2)
            {
              if (f1 > i2 / 2)
              {
                setSpringbackOffset(-i2);
                this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.d();
                i1 = 0;
                while (i1 < this.jdField_b_of_type_Int)
                {
                  this.jdField_a_of_type_ArrayOfBoolean[i1] = false;
                  i1 += 1;
                }
              }
              this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.a();
              return bool3;
            }
          }
        }
        else
        {
          if (this.k)
          {
            long l1 = System.currentTimeMillis();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("onTouchEvent debug click event x = ");
              ((StringBuilder)localObject).append(paramMotionEvent.getX());
              ((StringBuilder)localObject).append(", y = ");
              ((StringBuilder)localObject).append(paramMotionEvent.getY());
              ((StringBuilder)localObject).append(", getScrollY() = ");
              ((StringBuilder)localObject).append(getScrollY());
              QLog.d("HongBaoListView", 2, ((StringBuilder)localObject).toString());
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) && (l1 - this.jdField_a_of_type_Long > 800L) && (getScrollY() == 0))
            {
              this.jdField_a_of_type_Long = l1;
              if (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(getScrollY()).contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
              {
                localObject = this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.b(getScrollY());
                if ((localObject != null) && (((RectF)localObject).contains(paramMotionEvent.getX(), paramMotionEvent.getY()))) {
                  this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.c();
                } else {
                  this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.b();
                }
              }
            }
          }
          this.k = false;
          if (QLog.isColorLevel())
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("2021_UI_ConversationHongBaoV2 HongBaoListView ACTION_UP mComboListener = ");
            paramMotionEvent.append(this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener);
            QLog.d("HongBaoListView", 2, paramMotionEvent.toString());
          }
          paramMotionEvent = this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener;
          if (paramMotionEvent != null) {
            paramMotionEvent.b(this);
          }
          this.jdField_a_of_type_Int = -1;
          return bool3;
        }
      }
      else if (QLog.isColorLevel())
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("2021_UI_ConversationHongBaoV2 HongBaoListView ACTION_DOWN mComboListener = ");
        paramMotionEvent.append(this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener);
        QLog.d("HongBaoListView", 2, paramMotionEvent.toString());
      }
      return bool3;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onTouchUpWithYVelocity(int paramInt1, int paramInt2) {}
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.m) {
      this.m = false;
    }
  }
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.b();
    if (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a.c();
    }
  }
  
  public void q()
  {
    if (!this.l) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideHongBao ,");
      localStringBuilder.append(this.l);
      QLog.d("PortalManager", 2, localStringBuilder.toString());
    }
    p();
    this.l = false;
  }
  
  public void r()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showHongBao ,");
      localStringBuilder.append(this.l);
      QLog.d("PortalManager", 2, localStringBuilder.toString());
    }
    p();
    this.l = true;
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.n = 255;
  }
  
  public void setComboListener(HongBaoListViewListener paramHongBaoListViewListener)
  {
    this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener = paramHongBaoListViewListener;
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
  
  public void setHongBaoModeListScrollHeader(View paramView)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setHongBaoModeListScrollHeader view = ");
      localStringBuilder.append(paramView);
      QLog.d("HongBaoListView", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_AndroidViewView = paramView;
  }
  
  public void setIsShowingPreguide(boolean paramBoolean)
  {
    this.n = paramBoolean;
    j();
  }
  
  public void setLogo(Bitmap paramBitmap, boolean paramBoolean)
  {
    HongBaoPendantHolder localHongBaoPendantHolder = this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder;
    if (localHongBaoPendantHolder != null) {
      localHongBaoPendantHolder.a(paramBoolean, paramBitmap);
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    invalidate();
    if (QLog.isColorLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("setLogo ,");
      paramBitmap.append(this.l);
      paramBitmap.append(", ");
      paramBitmap.append(this.jdField_a_of_type_AndroidGraphicsBitmap);
      QLog.d("PortalManager", 2, paramBitmap.toString());
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
  
  public void setOverScrollListener(OverScrollViewListener paramOverScrollViewListener)
  {
    if (paramOverScrollViewListener != null) {
      this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = paramOverScrollViewListener;
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
      this.mOverScrollHeaderShadow = getResources().getDrawable(2130840609);
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
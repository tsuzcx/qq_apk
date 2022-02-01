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
    if (QLog.isColorLevel()) {
      QLog.d("HongBaoListView", 2, "updateBrushHBActPendantLogo ,pendantLogoBitmap = " + paramBitmap + ",mPendantHolder = " + this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(paramBitmap);
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    invalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i2 = 0;
    super.draw(paramCanvas);
    if ((this.g) && (this.l) && (!this.h))
    {
      int i3 = getListViewScrollY();
      int i1 = i3;
      if (i3 < 0) {
        i1 = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.g = (-i1);
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(paramCanvas)) {
        i1 = 1;
      }
      if (i1 != 0) {
        invalidate();
      }
    }
  }
  
  public int getListViewScrollY()
  {
    View localView = getChildAt(0);
    if (localView == null) {
      return getScrollY();
    }
    int i3 = getFirstVisiblePosition();
    if (i3 >= this.mHeaderViewInfos.size())
    {
      Iterator localIterator = this.mHeaderViewInfos.iterator();
      for (i1 = 0; localIterator.hasNext(); i1 = ((ListView.FixedViewInfo)localIterator.next()).view.getHeight() + i1) {}
      return -localView.getTop() + (i3 - this.mHeaderViewInfos.size()) * localView.getHeight() + i1;
    }
    int i1 = 0;
    int i2 = 0;
    while (i1 < i3)
    {
      i2 += ((ListView.FixedViewInfo)this.mHeaderViewInfos.get(i1)).view.getHeight();
      i1 += 1;
    }
    return -localView.getTop() + i2;
  }
  
  protected int getSpringbackOffset()
  {
    if ((!this.g) || (this.h)) {
      return super.getSpringbackOffset();
    }
    return this.c;
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
    if (QLog.isColorLevel()) {
      QLog.d("HongBaoListView", 2, "modeHongbao mActive = " + this.g + ",hongbaoModeListScrollHeaderView = " + this.jdField_b_of_type_AndroidViewView);
    }
    l();
    this.g = true;
    super.setOverScrollListener(null);
    super.setOverscrollHeader(null);
    super.setOverScrollHeader(this.jdField_b_of_type_AndroidViewView);
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
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
    boolean bool2 = true;
    boolean bool1;
    if ((!this.g) || (this.h)) {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    }
    do
    {
      return bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 == null) {
        break;
      }
      bool1 = bool2;
    } while (!this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.c);
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
      if ((this.l) && (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(getScrollY()).contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
      {
        if (getScrollY() == 0) {
          this.k = true;
        }
        super.onInterceptTouchEvent(paramMotionEvent);
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("HongBaoListView", 2, "2021_UI_ConversationHongBaoV2 HongBaoListView onInterceptTouchEvent return true, mComboListener = " + this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener);
        return true;
      }
      this.k = false;
      n();
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
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((!this.g) || (this.h)) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 != null) && (!this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.c)) {
      return bool1;
    }
    boolean bool3 = super.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return bool3;
      if (QLog.isColorLevel())
      {
        QLog.d("HongBaoListView", 2, "2021_UI_ConversationHongBaoV2 HongBaoListView ACTION_DOWN mComboListener = " + this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener);
        continue;
        Object localObject;
        if (this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener != null)
        {
          localObject = this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener;
          bool1 = bool2;
          if (this.mTouchMode != 3) {
            if (this.mTouchMode != 5) {
              break label332;
            }
          }
        }
        int i1;
        float f1;
        label332:
        for (bool1 = bool2;; bool1 = false)
        {
          ((HongBaoListViewListener)localObject).a(this, bool1);
          if (paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int) == -1) {}
          switch (this.mTouchMode)
          {
          case 4: 
          default: 
            break;
          case 3: 
          case 5: 
            if (this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener == null) {
              break;
            }
            i1 = paramMotionEvent.getPointerCount();
            if (i1 > this.jdField_b_of_type_Int) {
              this.jdField_b_of_type_Int = i1;
            }
            f1 = 0.0F;
            i1 = 0;
            while (i1 < paramMotionEvent.getPointerCount())
            {
              float f3 = paramMotionEvent.getY(i1) - this.jdField_a_of_type_ArrayOfFloat[i1];
              float f2 = f1;
              if (this.jdField_a_of_type_ArrayOfBoolean[i1] != 0)
              {
                f2 = f1;
                if (f3 > f1) {
                  f2 = f3;
                }
              }
              i1 += 1;
              f1 = f2;
            }
          }
        }
        if (-getScrollY() >= this.e / 2)
        {
          if (f1 > this.e / 2)
          {
            setSpringbackOffset(-this.e);
            this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.d();
            i1 = 0;
            while (i1 < this.jdField_b_of_type_Int)
            {
              this.jdField_a_of_type_ArrayOfBoolean[i1] = false;
              i1 += 1;
            }
          }
          this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.a();
          continue;
          if (this.k)
          {
            long l1 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("HongBaoListView", 2, "onTouchEvent debug click event x = " + paramMotionEvent.getX() + ", y = " + paramMotionEvent.getY() + ", getScrollY() = " + getScrollY());
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) && (l1 - this.jdField_a_of_type_Long > 800L) && (getScrollY() == 0))
            {
              this.jdField_a_of_type_Long = l1;
              if (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(getScrollY()).contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
              {
                localObject = this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.b(getScrollY());
                if ((localObject == null) || (!((RectF)localObject).contains(paramMotionEvent.getX(), paramMotionEvent.getY()))) {
                  break label663;
                }
                this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.c();
              }
            }
          }
          for (;;)
          {
            this.k = false;
            if (QLog.isColorLevel()) {
              QLog.d("HongBaoListView", 2, "2021_UI_ConversationHongBaoV2 HongBaoListView ACTION_UP mComboListener = " + this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener);
            }
            if (this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener != null) {
              this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.b(this);
            }
            this.jdField_a_of_type_Int = -1;
            break;
            label663:
            this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.b();
          }
          if (QLog.isColorLevel()) {
            QLog.d("HongBaoListView", 2, "2021_UI_ConversationHongBaoV2 HongBaoListView ACTION_CANCEL mComboListener = " + this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener);
          }
          if (this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener != null) {
            this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.b(this);
          }
          this.jdField_a_of_type_Int = -1;
          this.k = false;
          continue;
          i1 = paramMotionEvent.getActionIndex();
          this.jdField_a_of_type_ArrayOfFloat[i1] = ((int)paramMotionEvent.getY(i1));
          this.jdField_a_of_type_ArrayOfBoolean[i1] = true;
          continue;
          i1 = paramMotionEvent.getActionIndex();
          this.jdField_a_of_type_ArrayOfBoolean[i1] = false;
        }
      }
    }
  }
  
  public void onTouchUpWithYVelocity(int paramInt1, int paramInt2) {}
  
  public void onVisibilityChanged(View paramView, int paramInt)
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
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "hideHongBao ," + this.l);
    }
    p();
    this.l = false;
  }
  
  public void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "showHongBao ," + this.l);
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
    if (QLog.isColorLevel()) {
      QLog.d("HongBaoListView", 2, "setHongBaoModeListScrollHeader view = " + paramView);
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
    if (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(paramBoolean, paramBitmap);
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    invalidate();
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "setLogo ," + this.l + ", " + this.jdField_a_of_type_AndroidGraphicsBitmap);
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
      this.mOverScrollHeaderShadow = getResources().getDrawable(2130840734);
      return;
    }
    this.mOverScrollHeaderShadow = null;
  }
  
  public void setSpringbackOffset(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.HongBaoListView
 * JD-Core Version:    0.7.0.1
 */
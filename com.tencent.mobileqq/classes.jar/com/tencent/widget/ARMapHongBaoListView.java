package com.tencent.widget;

import aljw;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.armap.ARMapPendantHolder;
import com.tencent.mobileqq.armap.ConversationActivePendantHolderBase;
import com.tencent.mobileqq.armap.ConversationPullDownActiveBase;
import com.tencent.qphone.base.util.QLog;

public class ARMapHongBaoListView
  extends HongBaoListView
{
  public ConversationActivePendantHolderBase a;
  public ConversationPullDownActiveBase a;
  private ARMapHongBaoListView.ConversationActiveListViewListener jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener;
  private boolean jdField_a_of_type_Boolean = true;
  private Handler b;
  public boolean d;
  public boolean e = true;
  public boolean f;
  
  public ARMapHongBaoListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new aljw(this));
  }
  
  public ARMapHongBaoListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new aljw(this));
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.c(0);
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.a(paramInt);
    }
  }
  
  public void a(int paramInt)
  {
    setSelection(0);
    Message localMessage = Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 3, paramInt, 0);
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 150L);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = isShown();
    if (QLog.isColorLevel()) {
      QLog.d("SwipListView", 2, "showListViewPreGuide isShown:" + bool + ", mActive:" + this.g + ", mResume:" + this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.c + ", isListViewSpring:" + paramBoolean1 + ", isActivePendantShowing:" + this.jdField_d_of_type_Boolean + "  isPendantBounce:" + paramBoolean2);
    }
    if ((!bool) || (!this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.c) || (!this.g)) {
      return false;
    }
    setSelection(0);
    Message localMessage = Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 1);
    localMessage.getData().putBoolean("isFirstCall", true);
    localMessage.getData().putBoolean("isListViewSpring", paramBoolean1);
    localMessage.getData().putBoolean("isPendantBounce", paramBoolean2);
    if (paramBoolean2)
    {
      this.jdField_d_of_type_Boolean = true;
      localMessage.getData().putInt("pendantBountCnt", 2);
    }
    localMessage.sendToTarget();
    return true;
  }
  
  public void d()
  {
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
    setIsShowingPreguide(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int j = 0;
    super.draw(paramCanvas);
    if ((this.g) && (this.jdField_d_of_type_Boolean) && (this.h))
    {
      int k = a();
      int i = k;
      if (k < 0) {
        i = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.c = (-i);
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.a(paramCanvas)) {
        i = 1;
      }
      if (i != 0) {
        invalidate();
      }
    }
  }
  
  public void e()
  {
    if (!this.h) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SwipListView", 2, "showActivePendant");
    }
    h();
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwipListView", 2, "hideActivePendant");
    }
    h();
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void g()
  {
    h();
    if (QLog.isColorLevel()) {
      QLog.d("SwipListView", 2, "startActiveSanHua");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.b();
    }
    invalidate();
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwipListView", 2, "stopActiveSanHua");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.c();
    }
  }
  
  public void i()
  {
    this.mForHongBao = false;
    super.setOverScrollListener(this.jdField_b_of_type_ComTencentWidgetOverScrollViewListener);
    l();
    setActiveListViewListener(null);
    super.setOverscrollHeader(this.jdField_d_of_type_AndroidGraphicsDrawableDrawable);
    super.setOverScrollHeader(this.jdField_b_of_type_AndroidViewView);
    super.setContentBackground(this.c);
    super.setOverscrollHeaderShadowEnable(true);
    this.g = false;
    this.h = false;
    this.f = false;
    if (this.jdField_d_of_type_Boolean)
    {
      h();
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  public void j()
  {
    if (this.g) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase == null) || (!(this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase instanceof ARMapPendantHolder)))
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase = new ARMapPendantHolder(this);
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.a();
    }
    this.h = true;
    this.f = true;
    this.mForHongBao = true;
    this.g = true;
    super.setOverScrollListener(null);
    super.setOverscrollHeader(null);
    super.setOverScrollHeader(null);
    super.setOverscrollHeaderShadowEnable(false);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((!this.g) || (!this.h)) {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    }
    do
    {
      do
      {
        return bool1;
        if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase == null) {
          break;
        }
        bool1 = bool2;
      } while (!this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.c);
      bool1 = bool2;
    } while (!this.jdField_a_of_type_Boolean);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener != null) {
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener.a(this);
      }
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null))
      {
        int i = a();
        float f1 = paramMotionEvent.getY();
        float f2 = i;
        if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.a(i).contains(paramMotionEvent.getX(), f1 + f2))
        {
          if (getScrollY() == 0) {
            this.j = true;
          }
          super.onInterceptTouchEvent(paramMotionEvent);
          return true;
        }
      }
      else
      {
        this.j = false;
        d();
      }
    }
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (!this.h) {}
    while (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener.a(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    boolean bool1;
    if ((!this.g) || (!this.h)) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    do
    {
      do
      {
        return bool1;
        if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase == null) {
          break;
        }
        bool1 = bool3;
      } while (!this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.c);
      bool1 = bool3;
    } while (!this.jdField_a_of_type_Boolean);
    int i = paramMotionEvent.getAction();
    bool3 = super.onTouchEvent(paramMotionEvent);
    switch (i & 0xFF)
    {
    }
    for (;;)
    {
      return bool3;
      if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener != null)
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener;
        if (this.mTouchMode != 3)
        {
          bool1 = bool2;
          if (this.mTouchMode != 5) {}
        }
        else
        {
          bool1 = true;
        }
        paramMotionEvent.a(this, bool1);
        continue;
        if ((this.j) && (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener != null) && (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null) && (getScrollY() == 0))
        {
          i = a();
          float f1 = paramMotionEvent.getY();
          float f2 = i;
          if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.a(i).contains(paramMotionEvent.getX(), f1 + f2)) {
            this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener.a();
          }
        }
        this.j = false;
        if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener != null)
        {
          this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener.b(this);
          continue;
          this.j = false;
        }
      }
    }
  }
  
  public void setActiveListViewListener(ARMapHongBaoListView.ConversationActiveListViewListener paramConversationActiveListViewListener)
  {
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener = paramConversationActiveListViewListener;
  }
  
  public void setEnableTouch(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwipListView", 2, "setEnableTouch, enableTouch:" + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.widget.ARMapHongBaoListView
 * JD-Core Version:    0.7.0.1
 */
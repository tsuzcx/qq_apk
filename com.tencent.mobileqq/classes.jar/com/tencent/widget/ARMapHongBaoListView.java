package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import apsj;
import apsl;
import bkgv;
import bkgw;
import bkgx;
import bkgy;
import com.tencent.qphone.base.util.QLog;
import yqp;

public class ARMapHongBaoListView
  extends HongBaoListView
{
  public apsj a;
  public apsl a;
  private bkgw jdField_a_of_type_Bkgw;
  private bkgx jdField_a_of_type_Bkgx;
  private bkgy jdField_a_of_type_Bkgy;
  public boolean a;
  private Handler b;
  public volatile apsj b;
  public boolean b;
  boolean c = true;
  boolean d = true;
  private int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean;
  private boolean n = true;
  
  public ARMapHongBaoListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new bkgv(this));
  }
  
  public ARMapHongBaoListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new bkgv(this));
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Apsl != null) && (!this.jdField_a_of_type_Apsl.b()))
    {
      this.jdField_a_of_type_Apsl.a(0);
      this.jdField_a_of_type_Apsl.b(paramInt);
    }
  }
  
  public void a(apsj paramapsj)
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_b_of_type_Apsj = paramapsj;
    if (QLog.isColorLevel()) {
      QLog.i("ARMapHongBaoListView", 2, "showBreathLight:");
    }
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
    setIsShowingPreguide(false);
  }
  
  public void c()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_Apsj = null;
    if (QLog.isColorLevel()) {
      QLog.i("ARMapHongBaoListView", 2, "dismissBreathLight:");
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bkgx != null) {
      this.jdField_a_of_type_Bkgx.onFlingScrollHeader(this.jdField_e_of_type_Int, getScrollY());
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = 0;
    super.draw(paramCanvas);
    int j;
    if (((this.f) && (this.jdField_a_of_type_Boolean) && (this.g) && (this.c)) || (this.i))
    {
      j = getListViewScrollY();
      i = j;
      if (j < 0) {
        i = 0;
      }
      if (this.jdField_a_of_type_Apsj == null) {
        break label181;
      }
      this.jdField_a_of_type_Apsj.c = (-i);
      if (!this.jdField_a_of_type_Apsj.a(paramCanvas)) {
        break label181;
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        invalidate();
      }
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_Apsj != null) && (this.d))
      {
        j = getListViewScrollY();
        i = j;
        if (j < 0) {
          i = 0;
        }
        j = k;
        if (this.jdField_e_of_type_Boolean)
        {
          j = k;
          if (this.jdField_b_of_type_Apsj != null)
          {
            this.jdField_b_of_type_Apsj.c = (-i);
            j = k;
            if (this.jdField_b_of_type_Apsj.a(paramCanvas)) {
              j = 1;
            }
          }
        }
        if (j != 0) {
          invalidate();
        }
      }
      return;
    }
  }
  
  protected int getSpringbackOffset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "story getSpringbackOffset, scrollY:" + getScrollY());
    }
    if (this.jdField_a_of_type_Bkgx == null) {
      return super.getSpringbackOffset();
    }
    int i = getScrollY();
    if ((this.mEnableStory) && (this.mOverscrollHeaderViewContainer != null) && (i <= 0))
    {
      if (this.jdField_a_of_type_Bkgx.getMode() == 2)
      {
        yqp.b("ARMapHongBaoListView", "story node start refresh getSpringbackOffset.");
        this.mOverscrollHeadState = 2;
        super.getSpringbackOffset();
      }
      return this.jdField_a_of_type_Bkgx.getSpringbackOffset(this);
    }
    return super.getSpringbackOffset();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((!this.f) || (!this.g)) && (!this.i)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (((this.jdField_a_of_type_Apsl != null) && (!this.jdField_a_of_type_Apsl.jdField_a_of_type_Boolean)) || (!this.n)) {
      return true;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_Bkgw != null) {
      this.jdField_a_of_type_Bkgw.a(this);
    }
    int i;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Apsj != null))
    {
      i = getListViewScrollY();
      int j = getScrollY();
      if (j >= 0) {
        break label185;
      }
      i = j;
    }
    label185:
    for (;;)
    {
      float f = paramMotionEvent.getY();
      if (!this.jdField_a_of_type_Apsj.a(i).contains(paramMotionEvent.getX(), f)) {
        break;
      }
      this.j = true;
      super.onInterceptTouchEvent(paramMotionEvent);
      return true;
      this.j = false;
      b();
      break;
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (!this.g) {}
    while (this.jdField_a_of_type_Bkgw == null) {
      return;
    }
    this.jdField_a_of_type_Bkgw.a(paramInt1, paramInt2);
  }
  
  public boolean onRequestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "onRequestSendAccessibilityEvent() called with: child = [" + paramView + "], event = [" + paramAccessibilityEvent + "]");
    }
    boolean bool = super.onRequestSendAccessibilityEvent(paramView, paramAccessibilityEvent);
    if (paramAccessibilityEvent.getEventType() == 32768)
    {
      int i = paramView.getBottom() - (getHeight() - getListPaddingBottom());
      if (i > 0) {
        smoothScrollBy(i, 200);
      }
    }
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    boolean bool1;
    if ((this.mEnableStory) && (this.jdField_a_of_type_Bkgx != null))
    {
      bkgx localbkgx = this.jdField_a_of_type_Bkgx;
      if ((this.mTouchMode == 3) || (this.mTouchMode == 5))
      {
        bool1 = true;
        localbkgx.onTouchMoving(this, bool1, paramMotionEvent);
      }
    }
    else
    {
      if (((this.f) && (this.g)) || (this.i)) {
        break label93;
      }
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    label93:
    label114:
    do
    {
      do
      {
        return bool1;
        bool1 = false;
        break;
        if (this.jdField_a_of_type_Apsl == null) {
          break label114;
        }
        bool1 = bool3;
      } while (!this.jdField_a_of_type_Apsl.jdField_a_of_type_Boolean);
      bool1 = bool3;
    } while (!this.n);
    int i = paramMotionEvent.getAction();
    bool3 = super.onTouchEvent(paramMotionEvent);
    switch (i & 0xFF)
    {
    case 0: 
    default: 
    case 2: 
      for (;;)
      {
        return bool3;
        if (this.jdField_a_of_type_Bkgw != null)
        {
          paramMotionEvent = this.jdField_a_of_type_Bkgw;
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
        }
      }
    case 1: 
      if ((this.j) && ((this.jdField_a_of_type_Bkgw != null) || (this.jdField_a_of_type_Bkgy != null)) && (this.jdField_a_of_type_Apsj != null))
      {
        i = getListViewScrollY();
        int j = getScrollY();
        if (j >= 0) {
          break label370;
        }
        i = j;
      }
      break;
    }
    label370:
    for (;;)
    {
      float f = paramMotionEvent.getY();
      if ((this.jdField_a_of_type_Apsj.a(i).contains(paramMotionEvent.getX(), f)) && (this.c))
      {
        if (this.jdField_a_of_type_Bkgw != null) {
          this.jdField_a_of_type_Bkgw.a();
        }
        if (this.jdField_a_of_type_Bkgy != null) {
          this.jdField_a_of_type_Bkgy.a(paramMotionEvent.getX(), f);
        }
      }
      if (this.jdField_a_of_type_Bkgw != null) {
        this.jdField_a_of_type_Bkgw.b(this);
      }
      this.j = false;
      break;
      this.j = false;
      break;
    }
  }
  
  public void setActiveListViewListener(bkgw parambkgw)
  {
    this.jdField_a_of_type_Bkgw = parambkgw;
  }
  
  public void setEnableTouch(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "setEnableTouch, enableTouch:" + paramBoolean);
    }
    this.n = paramBoolean;
  }
  
  public void setOnPendentClickListener(bkgy parambkgy)
  {
    this.jdField_a_of_type_Bkgy = parambkgy;
  }
  
  public void setPendantHolder(apsj paramapsj)
  {
    boolean bool = true;
    this.jdField_a_of_type_Apsj = paramapsj;
    this.i = true;
    if (this.jdField_a_of_type_Apsj != null) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      invalidate();
      return;
      bool = false;
    }
  }
  
  public void setQQStoryListViewListener(bkgx parambkgx)
  {
    this.jdField_a_of_type_Bkgx = parambkgx;
  }
  
  public void setScrollState(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void setShowLightByUser(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.i("ARMapHongBaoListView", 2, "setShowLightByUser:" + this.d);
    }
  }
  
  public void springBackOverScrollHeaderView()
  {
    if ((this.mEnableStory) && (this.jdField_a_of_type_Bkgx != null))
    {
      this.mOverscrollHeadState = 0;
      super.springBackOverScrollHeaderView(this.jdField_a_of_type_Bkgx.onViewCompleteAfterRefresh(this));
      return;
    }
    super.springBackOverScrollHeaderView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ARMapHongBaoListView
 * JD-Core Version:    0.7.0.1
 */
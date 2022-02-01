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
import aqco;
import aqcq;
import bkza;
import bkzb;
import bkzc;
import bkzd;
import com.tencent.qphone.base.util.QLog;
import ykq;

public class ARMapHongBaoListView
  extends HongBaoListView
{
  public aqco a;
  public aqcq a;
  private bkzb jdField_a_of_type_Bkzb;
  private bkzc jdField_a_of_type_Bkzc;
  private bkzd jdField_a_of_type_Bkzd;
  public boolean a;
  private Handler b;
  public volatile aqco b;
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
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new bkza(this));
  }
  
  public ARMapHongBaoListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new bkza(this));
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Aqcq != null) && (!this.jdField_a_of_type_Aqcq.b()))
    {
      this.jdField_a_of_type_Aqcq.a(0);
      this.jdField_a_of_type_Aqcq.b(paramInt);
    }
  }
  
  public void a(aqco paramaqco)
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_b_of_type_Aqco = paramaqco;
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
    this.jdField_b_of_type_Aqco = null;
    if (QLog.isColorLevel()) {
      QLog.i("ARMapHongBaoListView", 2, "dismissBreathLight:");
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bkzc != null) {
      this.jdField_a_of_type_Bkzc.onFlingScrollHeader(this.jdField_e_of_type_Int, getScrollY());
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
      if (this.jdField_a_of_type_Aqco == null) {
        break label181;
      }
      this.jdField_a_of_type_Aqco.c = (-i);
      if (!this.jdField_a_of_type_Aqco.a(paramCanvas)) {
        break label181;
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        invalidate();
      }
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_Aqco != null) && (this.d))
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
          if (this.jdField_b_of_type_Aqco != null)
          {
            this.jdField_b_of_type_Aqco.c = (-i);
            j = k;
            if (this.jdField_b_of_type_Aqco.a(paramCanvas)) {
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
    if (this.jdField_a_of_type_Bkzc == null) {
      return super.getSpringbackOffset();
    }
    int i = getScrollY();
    if ((this.mEnableStory) && (this.mOverscrollHeaderViewContainer != null) && (i <= 0))
    {
      if (this.jdField_a_of_type_Bkzc.getMode() == 2)
      {
        ykq.b("ARMapHongBaoListView", "story node start refresh getSpringbackOffset.");
        this.mOverscrollHeadState = 2;
        super.getSpringbackOffset();
      }
      return this.jdField_a_of_type_Bkzc.getSpringbackOffset(this);
    }
    return super.getSpringbackOffset();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((!this.f) || (!this.g)) && (!this.i)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (((this.jdField_a_of_type_Aqcq != null) && (!this.jdField_a_of_type_Aqcq.jdField_a_of_type_Boolean)) || (!this.n)) {
      return true;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_Bkzb != null) {
      this.jdField_a_of_type_Bkzb.a(this);
    }
    int i;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aqco != null))
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
      if (!this.jdField_a_of_type_Aqco.a(i).contains(paramMotionEvent.getX(), f)) {
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
    while (this.jdField_a_of_type_Bkzb == null) {
      return;
    }
    this.jdField_a_of_type_Bkzb.a(paramInt1, paramInt2);
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
    if ((this.mEnableStory) && (this.jdField_a_of_type_Bkzc != null))
    {
      bkzc localbkzc = this.jdField_a_of_type_Bkzc;
      if ((this.mTouchMode == 3) || (this.mTouchMode == 5))
      {
        bool1 = true;
        localbkzc.onTouchMoving(this, bool1, paramMotionEvent);
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
        if (this.jdField_a_of_type_Aqcq == null) {
          break label114;
        }
        bool1 = bool3;
      } while (!this.jdField_a_of_type_Aqcq.jdField_a_of_type_Boolean);
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
        if (this.jdField_a_of_type_Bkzb != null)
        {
          paramMotionEvent = this.jdField_a_of_type_Bkzb;
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
      if ((this.j) && ((this.jdField_a_of_type_Bkzb != null) || (this.jdField_a_of_type_Bkzd != null)) && (this.jdField_a_of_type_Aqco != null))
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
      if ((this.jdField_a_of_type_Aqco.a(i).contains(paramMotionEvent.getX(), f)) && (this.c))
      {
        if (this.jdField_a_of_type_Bkzb != null) {
          this.jdField_a_of_type_Bkzb.a();
        }
        if (this.jdField_a_of_type_Bkzd != null) {
          this.jdField_a_of_type_Bkzd.a(paramMotionEvent.getX(), f);
        }
      }
      if (this.jdField_a_of_type_Bkzb != null) {
        this.jdField_a_of_type_Bkzb.b(this);
      }
      this.j = false;
      break;
      this.j = false;
      break;
    }
  }
  
  public void setActiveListViewListener(bkzb parambkzb)
  {
    this.jdField_a_of_type_Bkzb = parambkzb;
  }
  
  public void setEnableTouch(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "setEnableTouch, enableTouch:" + paramBoolean);
    }
    this.n = paramBoolean;
  }
  
  public void setOnPendentClickListener(bkzd parambkzd)
  {
    this.jdField_a_of_type_Bkzd = parambkzd;
  }
  
  public void setPendantHolder(aqco paramaqco)
  {
    boolean bool = true;
    this.jdField_a_of_type_Aqco = paramaqco;
    this.i = true;
    if (this.jdField_a_of_type_Aqco != null) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      invalidate();
      return;
      bool = false;
    }
  }
  
  public void setQQStoryListViewListener(bkzc parambkzc)
  {
    this.jdField_a_of_type_Bkzc = parambkzc;
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
    if ((this.mEnableStory) && (this.jdField_a_of_type_Bkzc != null))
    {
      this.mOverscrollHeadState = 0;
      super.springBackOverScrollHeaderView(this.jdField_a_of_type_Bkzc.onViewCompleteAfterRefresh(this));
      return;
    }
    super.springBackOverScrollHeaderView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.ARMapHongBaoListView
 * JD-Core Version:    0.7.0.1
 */
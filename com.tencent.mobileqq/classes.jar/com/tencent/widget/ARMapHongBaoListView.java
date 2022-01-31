package com.tencent.widget;

import ahhd;
import alwv;
import alwx;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import bfns;
import bfnt;
import bfnu;
import bfnv;
import com.tencent.qphone.base.util.QLog;
import veg;

public class ARMapHongBaoListView
  extends HongBaoListView
{
  public alwv a;
  public alwx a;
  private bfnt jdField_a_of_type_Bfnt;
  private bfnu jdField_a_of_type_Bfnu;
  private bfnv jdField_a_of_type_Bfnv;
  public boolean a;
  public volatile alwv b;
  private Handler b;
  public boolean b;
  boolean c = true;
  boolean d = true;
  boolean e;
  private int f;
  public boolean f;
  private boolean n = true;
  
  public ARMapHongBaoListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new bfns(this));
  }
  
  public ARMapHongBaoListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new bfns(this));
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_Alwx != null) && (!this.jdField_a_of_type_Alwx.a()))
    {
      this.jdField_a_of_type_Alwx.c(0);
      this.jdField_a_of_type_Alwx.d(paramInt);
    }
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_Alwv == null) || (!(this.jdField_a_of_type_Alwv instanceof ahhd)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapHongBaoListView", 2, "initPendantHolder");
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Alwv = new ahhd(this);
      this.jdField_a_of_type_Alwv.a();
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    this.jdField_a_of_type_Boolean = false;
    this.h = true;
    this.g = true;
    if (paramInt == 1) {}
    for (;;)
    {
      this.mForHongBao = bool;
      if (QLog.isColorLevel()) {
        QLog.d("ARMapHongBaoListView", 2, "modeSpringHb...mode:" + paramInt + ",mForHongBao:" + this.mForHongBao);
      }
      return;
      bool = false;
    }
  }
  
  public void a(alwv paramalwv)
  {
    this.e = true;
    this.jdField_b_of_type_Alwv = paramalwv;
    if (QLog.isColorLevel()) {
      QLog.i("ARMapHongBaoListView", 2, "showBreathLight:");
    }
  }
  
  public void a(bfnt parambfnt)
  {
    setActiveListViewListener(parambfnt);
    super.setOverScrollListener(null);
    super.setOverscrollHeader(null);
    super.setOverScrollHeader(null);
    super.setOverscrollHeaderShadowEnable(false);
  }
  
  public boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_Alwv != null) && ((this.jdField_a_of_type_Alwv instanceof ahhd))) {
      return ((ahhd)this.jdField_a_of_type_Alwv).a(paramInt);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
    setIsShowingPreguide(false);
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.i("ARMapHongBaoListView", 2, "showByUser:" + this.c);
    }
  }
  
  public void c()
  {
    if (!this.h) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "showActivePendant");
    }
    r();
    ((ahhd)this.jdField_a_of_type_Alwv).b();
    this.jdField_a_of_type_Boolean = true;
    invalidate();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "hideActivePendant");
    }
    e();
    this.jdField_a_of_type_Boolean = false;
    invalidate();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bfnu != null) {
      this.jdField_a_of_type_Bfnu.onFlingScrollHeader(this.jdField_f_of_type_Int, getScrollY());
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = 0;
    super.draw(paramCanvas);
    int j;
    if ((this.g) && (this.jdField_a_of_type_Boolean) && (this.h) && (this.c))
    {
      j = getListViewScrollY();
      i = j;
      if (j < 0) {
        i = 0;
      }
      if (this.jdField_a_of_type_Alwv == null) {
        break label174;
      }
      this.jdField_a_of_type_Alwv.c = (-i);
      if (!this.jdField_a_of_type_Alwv.a(paramCanvas)) {
        break label174;
      }
    }
    label174:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        invalidate();
      }
      if ((this.e) && (this.jdField_b_of_type_Alwv != null) && (this.d))
      {
        j = getListViewScrollY();
        i = j;
        if (j < 0) {
          i = 0;
        }
        j = k;
        if (this.e)
        {
          j = k;
          if (this.jdField_b_of_type_Alwv != null)
          {
            this.jdField_b_of_type_Alwv.c = (-i);
            j = k;
            if (this.jdField_b_of_type_Alwv.a(paramCanvas)) {
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
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "stopActiveSanHua");
    }
    if (this.jdField_a_of_type_Alwv != null)
    {
      this.jdField_a_of_type_Alwv.c();
      invalidate();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ARMapHongBaoListView", 2, "stopActiveSanHua, holder is null");
  }
  
  public void f()
  {
    this.e = false;
    this.jdField_b_of_type_Alwv = null;
    if (QLog.isColorLevel()) {
      QLog.i("ARMapHongBaoListView", 2, "dismissBreathLight:");
    }
  }
  
  public void g()
  {
    this.mForHongBao = false;
    super.setOverScrollListener(this.jdField_a_of_type_Bftk);
    l();
    setActiveListViewListener(null);
    super.setOverscrollHeader(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    super.setOverScrollHeader(this.jdField_a_of_type_AndroidViewView);
    super.setContentBackground(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    super.setOverscrollHeaderShadowEnable(true);
    this.g = false;
    this.h = false;
    this.jdField_f_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean)
    {
      e();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected int getSpringbackOffset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "story getSpringbackOffset, scrollY:" + getScrollY());
    }
    if (this.jdField_a_of_type_Bfnu == null) {
      return super.getSpringbackOffset();
    }
    int i = getScrollY();
    if ((this.mEnableStory) && (this.mOverscrollHeaderViewContainer != null) && (i <= 0))
    {
      if (this.jdField_a_of_type_Bfnu.getMode() == 2)
      {
        veg.b("ARMapHongBaoListView", "story node start refresh getSpringbackOffset.");
        this.mOverscrollHeadState = 2;
        super.getSpringbackOffset();
      }
      return this.jdField_a_of_type_Bfnu.getSpringbackOffset(this);
    }
    return super.getSpringbackOffset();
  }
  
  public void h()
  {
    this.mForHongBao = false;
    super.setOverScrollListener(this.jdField_a_of_type_Bftk);
    l();
    setActiveListViewListener(null);
    super.setOverscrollHeader(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    super.setOverScrollHeader(this.jdField_a_of_type_AndroidViewView);
    super.setContentBackground(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    super.setOverscrollHeaderShadowEnable(true);
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_Alwv != null) && ((this.jdField_a_of_type_Alwv instanceof ahhd))) {
      ((ahhd)this.jdField_a_of_type_Alwv).d();
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Alwv != null) && ((this.jdField_a_of_type_Alwv instanceof ahhd))) {
      ((ahhd)this.jdField_a_of_type_Alwv).e();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.g) || (!this.h)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (((this.jdField_a_of_type_Alwx != null) && (!this.jdField_a_of_type_Alwx.jdField_a_of_type_Boolean)) || (!this.n)) {
      return true;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_Bfnt != null) {
      this.jdField_a_of_type_Bfnt.a(this);
    }
    int i;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Alwv != null))
    {
      i = getListViewScrollY();
      int j = getScrollY();
      if (j >= 0) {
        break label177;
      }
      i = j;
    }
    label177:
    for (;;)
    {
      float f1 = paramMotionEvent.getY();
      if (!this.jdField_a_of_type_Alwv.a(i).contains(paramMotionEvent.getX(), f1)) {
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
    if (!this.h) {}
    while (this.jdField_a_of_type_Bfnt == null) {
      return;
    }
    this.jdField_a_of_type_Bfnt.a(paramInt1, paramInt2);
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
    if ((this.mEnableStory) && (this.jdField_a_of_type_Bfnu != null))
    {
      bfnu localbfnu = this.jdField_a_of_type_Bfnu;
      if ((this.mTouchMode == 3) || (this.mTouchMode == 5))
      {
        bool1 = true;
        localbfnu.onTouchMoving(this, bool1, paramMotionEvent);
      }
    }
    else
    {
      if ((this.g) && (this.h)) {
        break label86;
      }
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    label86:
    label107:
    do
    {
      do
      {
        return bool1;
        bool1 = false;
        break;
        if (this.jdField_a_of_type_Alwx == null) {
          break label107;
        }
        bool1 = bool3;
      } while (!this.jdField_a_of_type_Alwx.jdField_a_of_type_Boolean);
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
        if (this.jdField_a_of_type_Bfnt != null)
        {
          paramMotionEvent = this.jdField_a_of_type_Bfnt;
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
      if ((this.j) && ((this.jdField_a_of_type_Bfnt != null) || (this.jdField_a_of_type_Bfnv != null)) && (this.jdField_a_of_type_Alwv != null))
      {
        i = getListViewScrollY();
        int j = getScrollY();
        if (j >= 0) {
          break label357;
        }
        i = j;
      }
      break;
    }
    label357:
    for (;;)
    {
      float f1 = paramMotionEvent.getY();
      if ((this.jdField_a_of_type_Alwv.a(i).contains(paramMotionEvent.getX(), f1)) && (this.c))
      {
        if (this.jdField_a_of_type_Bfnt != null) {
          this.jdField_a_of_type_Bfnt.a();
        }
        if (this.jdField_a_of_type_Bfnv != null) {
          this.jdField_a_of_type_Bfnv.a();
        }
      }
      if (this.jdField_a_of_type_Bfnt != null) {
        this.jdField_a_of_type_Bfnt.b(this);
      }
      this.j = false;
      break;
      this.j = false;
      break;
    }
  }
  
  public void setActiveListViewListener(bfnt parambfnt)
  {
    this.jdField_a_of_type_Bfnt = parambfnt;
  }
  
  public void setEnableTouch(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "setEnableTouch, enableTouch:" + paramBoolean);
    }
    this.n = paramBoolean;
  }
  
  public void setOnPendentClickListener(bfnv parambfnv)
  {
    this.jdField_a_of_type_Bfnv = parambfnv;
  }
  
  public void setPendantIcon(Drawable paramDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "setPendantIcon");
    }
    r();
    if (this.jdField_a_of_type_Alwv != null)
    {
      this.jdField_a_of_type_Alwv.a_(paramDrawable);
      invalidate();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ARMapHongBaoListView", 2, "setPendantIcon, holder is null");
  }
  
  public void setQQStoryListViewListener(bfnu parambfnu)
  {
    this.jdField_a_of_type_Bfnu = parambfnu;
  }
  
  public void setScrollState(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
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
    if ((this.mEnableStory) && (this.jdField_a_of_type_Bfnu != null))
    {
      this.mOverscrollHeadState = 0;
      super.springBackOverScrollHeaderView(this.jdField_a_of_type_Bfnu.onViewCompleteAfterRefresh(this));
      return;
    }
    super.springBackOverScrollHeaderView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.ARMapHongBaoListView
 * JD-Core Version:    0.7.0.1
 */
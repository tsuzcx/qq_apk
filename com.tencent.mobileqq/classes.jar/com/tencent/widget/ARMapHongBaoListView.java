package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.springfestival.entry.ui.SpringNomalPendantHolder;
import com.tencent.mobileqq.armap.ConversationActivePendantHolderBase;
import com.tencent.mobileqq.armap.ConversationPullDownActiveBase;
import com.tencent.mobileqq.portal.SaQianView;
import com.tencent.qphone.base.util.QLog;

public class ARMapHongBaoListView
  extends HongBaoListView
{
  public ConversationActivePendantHolderBase a;
  public ConversationPullDownActiveBase a;
  private ARMapHongBaoListView.ConversationActiveListViewListener jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener;
  private ARMapHongBaoListView.QQStoryListViewListener jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$QQStoryListViewListener;
  private ARMapHongBaoListView.onPendentClickListener jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$onPendentClickListener;
  public boolean a;
  private Handler b;
  public volatile ConversationActivePendantHolderBase b;
  public boolean b;
  boolean c = true;
  boolean d = true;
  boolean e;
  private int f;
  public boolean f;
  private boolean o = true;
  
  public ARMapHongBaoListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new ARMapHongBaoListView.1(this));
    this.jdField_f_of_type_Boolean = false;
  }
  
  public ARMapHongBaoListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new ARMapHongBaoListView.1(this));
    this.jdField_f_of_type_Boolean = false;
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase != null) && (!this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.a(0);
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.b(paramInt);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "updateNormalActivityPendantLogo ,pendantLogoBitmap = " + paramBitmap + ",mActivePendantHolder = " + this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null) && ((this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase instanceof SpringNomalPendantHolder))) {
      ((SpringNomalPendantHolder)this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase).a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "showNormalActivityPendant mFromActiveExceptHongbao = " + this.h + ",logoBitmap = " + paramBitmap);
    }
    this.h = true;
    this.g = true;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase = new SpringNomalPendantHolder(this);
    ((SpringNomalPendantHolder)this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase).a(paramBitmap, paramBoolean);
    this.jdField_a_of_type_Boolean = true;
    invalidate();
  }
  
  public void a(ConversationActivePendantHolderBase paramConversationActivePendantHolderBase)
  {
    this.e = true;
    this.jdField_b_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase = paramConversationActivePendantHolderBase;
    if (QLog.isColorLevel()) {
      QLog.i("ARMapHongBaoListView", 2, "showBreathLight:");
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null) {
      return ((SpringNomalPendantHolder)this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase).a();
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
    setIsShowingPreguide(false);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "startNormalActivityPendantAnimation");
    }
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null)
    {
      ((SpringNomalPendantHolder)this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase).a();
      ((SpringNomalPendantHolder)this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase).a(true);
      invalidate();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "startActiveSanHua");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.f();
      invalidate();
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    if ((!this.mForHongBao) && (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$QQStoryListViewListener != null)) {
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$QQStoryListViewListener.onFlingScrollHeader(this.jdField_f_of_type_Int, getScrollY());
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = 0;
    super.draw(paramCanvas);
    int j;
    if (((this.g) && (this.jdField_a_of_type_Boolean) && (this.h) && (this.c)) || (this.j))
    {
      j = getListViewScrollY();
      i = j;
      if (j < 0) {
        i = 0;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase == null) {
        break label181;
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.g = (-i);
      if (!this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.a(paramCanvas)) {
        break label181;
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        invalidate();
      }
      if ((this.e) && (this.jdField_b_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null) && (this.d))
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
          if (this.jdField_b_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null)
          {
            this.jdField_b_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.g = (-i);
            j = k;
            if (this.jdField_b_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.a(paramCanvas)) {
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
      QLog.d("ARMapHongBaoListView", 2, "hideActivePendant");
    }
    f();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase = null;
    invalidate();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "stopActiveSanHua");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.b();
      invalidate();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ARMapHongBaoListView", 2, "stopActiveSanHua, holder is null");
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "stopNormalActivityPendantAnimation");
    }
    f();
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null)
    {
      ((SpringNomalPendantHolder)this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase).a.c();
      ((SpringNomalPendantHolder)this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase).a(false);
      invalidate();
    }
  }
  
  protected int getSpringbackOffset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "story getSpringbackOffset, scrollY:" + getScrollY());
    }
    if ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$QQStoryListViewListener == null) || (this.mForHongBao)) {
      return super.getSpringbackOffset();
    }
    int i = getScrollY();
    if ((this.mEnableStory) && (this.mOverscrollHeaderViewContainer != null) && (i <= 0))
    {
      if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$QQStoryListViewListener.getMode() == 2)
      {
        SLog.b("ARMapHongBaoListView", "story node start refresh getSpringbackOffset.");
        this.mOverscrollHeadState = 2;
        super.getSpringbackOffset();
      }
      return this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$QQStoryListViewListener.getSpringbackOffset(this);
    }
    return super.getSpringbackOffset();
  }
  
  public void h()
  {
    this.e = false;
    this.jdField_b_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase = null;
    if (QLog.isColorLevel()) {
      QLog.i("ARMapHongBaoListView", 2, "dismissBreathLight:");
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((!this.g) || (!this.h)) && (!this.j)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase != null) && (!this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.jdField_a_of_type_Boolean)) || (!this.o)) {
      return true;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener != null) {
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener.a(this);
    }
    int i;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null))
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
      float f1 = paramMotionEvent.getY();
      if (!this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.b(i).contains(paramMotionEvent.getX(), f1)) {
        break;
      }
      this.k = true;
      super.onInterceptTouchEvent(paramMotionEvent);
      return true;
      this.k = false;
      b();
      break;
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
    Object localObject;
    boolean bool1;
    if ((!this.mForHongBao) && (this.mEnableStory) && (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$QQStoryListViewListener != null))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$QQStoryListViewListener;
      if ((this.mTouchMode == 3) || (this.mTouchMode == 5))
      {
        bool1 = true;
        ((ARMapHongBaoListView.QQStoryListViewListener)localObject).onTouchMoving(this, bool1, paramMotionEvent);
      }
    }
    else
    {
      if (((this.g) && (this.h)) || (this.j)) {
        break label100;
      }
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    label100:
    label121:
    do
    {
      do
      {
        return bool1;
        bool1 = false;
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase == null) {
          break label121;
        }
        bool1 = bool3;
      } while (!this.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase.jdField_a_of_type_Boolean);
      bool1 = bool3;
    } while (!this.o);
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
        }
      }
    case 1: 
      if ((this.k) && ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener != null) || (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$onPendentClickListener != null)) && (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null))
      {
        i = getListViewScrollY();
        int j = getScrollY();
        if (j >= 0) {
          break label508;
        }
        i = j;
      }
      break;
    }
    label468:
    label508:
    for (;;)
    {
      float f1 = paramMotionEvent.getY();
      if (QLog.isColorLevel()) {
        QLog.d("ARMapHongBaoListView", 2, "onTouchEvent debug click event x = " + paramMotionEvent.getX() + ", y = " + f1 + ", listViewScrollY = " + i);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.b(i).contains(paramMotionEvent.getX(), f1)) && (this.c))
      {
        if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener != null) {
          this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener.a();
        }
        if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$onPendentClickListener != null)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.a(i);
          if ((localObject == null) || (!((RectF)localObject).contains(paramMotionEvent.getX(), f1))) {
            break label468;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ARMapHongBaoListView", 2, "onTouchEvent debug click event onPendentCloseBtnClick");
          }
          this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$onPendentClickListener.b(paramMotionEvent.getX(), f1);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener != null) {
          this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener.b(this);
        }
        this.k = false;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ARMapHongBaoListView", 2, "onTouchEvent debug click event onPendentClick");
        }
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$onPendentClickListener.a(paramMotionEvent.getX(), f1);
      }
      this.k = false;
      break;
    }
  }
  
  public void setActiveListViewListener(ARMapHongBaoListView.ConversationActiveListViewListener paramConversationActiveListViewListener)
  {
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener = paramConversationActiveListViewListener;
  }
  
  public void setEnableTouch(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "setEnableTouch, enableTouch:" + paramBoolean);
    }
    this.o = paramBoolean;
  }
  
  public void setOnPendentClickListener(ARMapHongBaoListView.onPendentClickListener paramonPendentClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$onPendentClickListener = paramonPendentClickListener;
  }
  
  public void setPendantHolder(ConversationActivePendantHolderBase paramConversationActivePendantHolderBase)
  {
    boolean bool = true;
    this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase = paramConversationActivePendantHolderBase;
    this.j = true;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      invalidate();
      return;
      bool = false;
    }
  }
  
  public void setQQStoryListViewListener(ARMapHongBaoListView.QQStoryListViewListener paramQQStoryListViewListener)
  {
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$QQStoryListViewListener = paramQQStoryListViewListener;
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
    if ((!this.mForHongBao) && (this.mEnableStory) && (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$QQStoryListViewListener != null))
    {
      this.mOverscrollHeadState = 0;
      super.springBackOverScrollHeaderView(this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$QQStoryListViewListener.onViewCompleteAfterRefresh(this));
      return;
    }
    super.springBackOverScrollHeaderView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.ARMapHongBaoListView
 * JD-Core Version:    0.7.0.1
 */
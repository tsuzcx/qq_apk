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
import com.tencent.mobileqq.portal.SaQianView;
import com.tencent.qphone.base.util.QLog;

public class ARMapHongBaoListView
  extends HongBaoListView
{
  public ConversationActivePendantHolderBase a;
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
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new ARMapHongBaoListView.1(this));
    this.jdField_f_of_type_Boolean = false;
  }
  
  public ARMapHongBaoListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new ARMapHongBaoListView.1(this));
    this.jdField_f_of_type_Boolean = false;
  }
  
  private void b(int paramInt) {}
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateNormalActivityPendantLogo ,pendantLogoBitmap = ");
      ((StringBuilder)localObject).append(paramBitmap);
      ((StringBuilder)localObject).append(",mActivePendantHolder = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase);
      QLog.d("ARMapHongBaoListView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase;
    if ((localObject != null) && ((localObject instanceof SpringNomalPendantHolder))) {
      ((SpringNomalPendantHolder)localObject).a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showNormalActivityPendant mFromActiveExceptHongbao = ");
      localStringBuilder.append(this.h);
      localStringBuilder.append(",logoBitmap = ");
      localStringBuilder.append(paramBitmap);
      QLog.d("ARMapHongBaoListView", 2, localStringBuilder.toString());
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
    ConversationActivePendantHolderBase localConversationActivePendantHolderBase = this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase;
    if (localConversationActivePendantHolderBase != null) {
      return ((SpringNomalPendantHolder)localConversationActivePendantHolderBase).a();
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
    ConversationActivePendantHolderBase localConversationActivePendantHolderBase = this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase;
    if (localConversationActivePendantHolderBase != null)
    {
      ((SpringNomalPendantHolder)localConversationActivePendantHolderBase).a();
      ((SpringNomalPendantHolder)this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase).a(true);
      invalidate();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "startActiveSanHua");
    }
    ConversationActivePendantHolderBase localConversationActivePendantHolderBase = this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase;
    if (localConversationActivePendantHolderBase != null)
    {
      localConversationActivePendantHolderBase.f();
      invalidate();
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!this.mForHongBao)
    {
      ARMapHongBaoListView.QQStoryListViewListener localQQStoryListViewListener = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$QQStoryListViewListener;
      if (localQQStoryListViewListener != null) {
        localQQStoryListViewListener.onFlingScrollHeader(this.jdField_f_of_type_Int, getScrollY());
      }
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    boolean bool = this.g;
    int j = 1;
    int k;
    int i;
    if (((bool) && (this.jdField_a_of_type_Boolean) && (this.h) && (this.c)) || (this.j))
    {
      k = getListViewScrollY();
      i = k;
      if (k < 0) {
        i = 0;
      }
      ConversationActivePendantHolderBase localConversationActivePendantHolderBase = this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase;
      if (localConversationActivePendantHolderBase != null)
      {
        localConversationActivePendantHolderBase.g = (-i);
        if (localConversationActivePendantHolderBase.a(paramCanvas))
        {
          i = 1;
          break label96;
        }
      }
      i = 0;
      label96:
      if (i != 0) {
        invalidate();
      }
    }
    if ((this.e) && (this.jdField_b_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null) && (this.d))
    {
      k = getListViewScrollY();
      i = k;
      if (k < 0) {
        i = 0;
      }
      if ((this.e) && (this.jdField_b_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null))
      {
        this.jdField_b_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.g = (-i);
        if (this.jdField_b_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.a(paramCanvas))
        {
          i = j;
          break label182;
        }
      }
      i = 0;
      label182:
      if (i != 0) {
        invalidate();
      }
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
    ConversationActivePendantHolderBase localConversationActivePendantHolderBase = this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase;
    if (localConversationActivePendantHolderBase != null)
    {
      localConversationActivePendantHolderBase.b();
      invalidate();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "stopActiveSanHua, holder is null");
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "stopNormalActivityPendantAnimation");
    }
    f();
    ConversationActivePendantHolderBase localConversationActivePendantHolderBase = this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase;
    if (localConversationActivePendantHolderBase != null)
    {
      ((SpringNomalPendantHolder)localConversationActivePendantHolderBase).a.c();
      ((SpringNomalPendantHolder)this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase).a(false);
      invalidate();
    }
  }
  
  protected int getSpringbackOffset()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("story getSpringbackOffset, scrollY:");
      localStringBuilder.append(getScrollY());
      QLog.d("ARMapHongBaoListView", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$QQStoryListViewListener != null) && (!this.mForHongBao))
    {
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
    if (!this.o) {
      return true;
    }
    if ((paramMotionEvent.getAction() & 0xFF) == 0)
    {
      ARMapHongBaoListView.ConversationActiveListViewListener localConversationActiveListViewListener = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener;
      if (localConversationActiveListViewListener != null) {
        localConversationActiveListViewListener.a(this);
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null))
      {
        int i = getListViewScrollY();
        int j = getScrollY();
        if (j < 0) {
          i = j;
        }
        float f1 = paramMotionEvent.getY();
        if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.b(i).contains(paramMotionEvent.getX(), f1))
        {
          this.k = true;
          super.onInterceptTouchEvent(paramMotionEvent);
          return true;
        }
      }
      else
      {
        this.k = false;
        b();
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (!this.h) {
      return;
    }
    ARMapHongBaoListView.ConversationActiveListViewListener localConversationActiveListViewListener = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener;
    if (localConversationActiveListViewListener != null) {
      localConversationActiveListViewListener.a(paramInt1, paramInt2);
    }
  }
  
  public boolean onRequestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRequestSendAccessibilityEvent() called with: child = [");
      localStringBuilder.append(paramView);
      localStringBuilder.append("], event = [");
      localStringBuilder.append(paramAccessibilityEvent);
      localStringBuilder.append("]");
      QLog.d("ARMapHongBaoListView", 2, localStringBuilder.toString());
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
    boolean bool1 = this.mForHongBao;
    boolean bool2 = false;
    Object localObject;
    if ((!bool1) && (this.mEnableStory))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$QQStoryListViewListener;
      if (localObject != null)
      {
        if ((this.mTouchMode != 3) && (this.mTouchMode != 5)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        ((ARMapHongBaoListView.QQStoryListViewListener)localObject).onTouchMoving(this, bool1, paramMotionEvent);
      }
    }
    if (((!this.g) || (!this.h)) && (!this.j)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (!this.o) {
      return true;
    }
    int i = paramMotionEvent.getAction() & 0xFF;
    boolean bool3 = super.onTouchEvent(paramMotionEvent);
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return bool3;
          }
          this.k = false;
          return bool3;
        }
        paramMotionEvent = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener;
        if (paramMotionEvent != null)
        {
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
          return bool3;
        }
      }
      else
      {
        if ((this.k) && ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener != null) || (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$onPendentClickListener != null)) && (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null))
        {
          i = getListViewScrollY();
          int j = getScrollY();
          if (j < 0) {
            i = j;
          }
          float f1 = paramMotionEvent.getY();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onTouchEvent debug click event x = ");
            ((StringBuilder)localObject).append(paramMotionEvent.getX());
            ((StringBuilder)localObject).append(", y = ");
            ((StringBuilder)localObject).append(f1);
            ((StringBuilder)localObject).append(", listViewScrollY = ");
            ((StringBuilder)localObject).append(i);
            QLog.d("ARMapHongBaoListView", 2, ((StringBuilder)localObject).toString());
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.b(i).contains(paramMotionEvent.getX(), f1)) && (this.c))
          {
            localObject = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener;
            if (localObject != null) {
              ((ARMapHongBaoListView.ConversationActiveListViewListener)localObject).a();
            }
            if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$onPendentClickListener != null)
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.a(i);
              if ((localObject != null) && (((RectF)localObject).contains(paramMotionEvent.getX(), f1)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ARMapHongBaoListView", 2, "onTouchEvent debug click event onPendentCloseBtnClick");
                }
                this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$onPendentClickListener.b(paramMotionEvent.getX(), f1);
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ARMapHongBaoListView", 2, "onTouchEvent debug click event onPendentClick");
                }
                this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$onPendentClickListener.a(paramMotionEvent.getX(), f1);
              }
            }
          }
        }
        paramMotionEvent = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.b(this);
        }
        this.k = false;
      }
    }
    return bool3;
  }
  
  public void setActiveListViewListener(ARMapHongBaoListView.ConversationActiveListViewListener paramConversationActiveListViewListener)
  {
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener = paramConversationActiveListViewListener;
  }
  
  public void setEnableTouch(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setEnableTouch, enableTouch:");
      localStringBuilder.append(paramBoolean);
      QLog.d("ARMapHongBaoListView", 2, localStringBuilder.toString());
    }
    this.o = paramBoolean;
  }
  
  public void setOnPendentClickListener(ARMapHongBaoListView.onPendentClickListener paramonPendentClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$onPendentClickListener = paramonPendentClickListener;
  }
  
  public void setPendantHolder(ConversationActivePendantHolderBase paramConversationActivePendantHolderBase)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase = paramConversationActivePendantHolderBase;
    boolean bool = true;
    this.j = true;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase == null) {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    invalidate();
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setShowLightByUser:");
      localStringBuilder.append(this.d);
      QLog.i("ARMapHongBaoListView", 2, localStringBuilder.toString());
    }
  }
  
  public void springBackOverScrollHeaderView()
  {
    if ((!this.mForHongBao) && (this.mEnableStory))
    {
      ARMapHongBaoListView.QQStoryListViewListener localQQStoryListViewListener = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$QQStoryListViewListener;
      if (localQQStoryListViewListener != null)
      {
        this.mOverscrollHeadState = 0;
        super.springBackOverScrollHeaderView(localQQStoryListViewListener.onViewCompleteAfterRefresh(this));
        return;
      }
    }
    super.springBackOverScrollHeaderView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ARMapHongBaoListView
 * JD-Core Version:    0.7.0.1
 */
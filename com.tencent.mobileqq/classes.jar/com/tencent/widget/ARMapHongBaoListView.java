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
  private boolean G = true;
  private Handler H = new Handler(Looper.getMainLooper(), new ARMapHongBaoListView.1(this));
  private ARMapHongBaoListView.ConversationActiveListViewListener I;
  private ARMapHongBaoListView.QQStoryListViewListener J;
  private ARMapHongBaoListView.onPendentClickListener K;
  private int L;
  public ConversationActivePendantHolderBase a;
  public boolean b;
  public boolean c = true;
  public volatile ConversationActivePendantHolderBase d;
  boolean e = true;
  boolean f = true;
  boolean g;
  public boolean h = false;
  
  public ARMapHongBaoListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ARMapHongBaoListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
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
      ((StringBuilder)localObject).append(this.a);
      QLog.d("ARMapHongBaoListView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
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
      localStringBuilder.append(this.o);
      localStringBuilder.append(",logoBitmap = ");
      localStringBuilder.append(paramBitmap);
      QLog.d("ARMapHongBaoListView", 2, localStringBuilder.toString());
    }
    this.o = true;
    this.n = true;
    this.b = true;
    this.a = new SpringNomalPendantHolder(this);
    ((SpringNomalPendantHolder)this.a).a(paramBitmap, paramBoolean);
    this.b = true;
    invalidate();
  }
  
  public void a(ConversationActivePendantHolderBase paramConversationActivePendantHolderBase)
  {
    this.g = true;
    this.d = paramConversationActivePendantHolderBase;
    if (QLog.isColorLevel()) {
      QLog.i("ARMapHongBaoListView", 2, "showBreathLight:");
    }
  }
  
  public void b()
  {
    this.H.removeMessages(1);
    this.H.removeMessages(2);
    setIsShowingPreguide(false);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "startNormalActivityPendantAnimation");
    }
    d();
    ConversationActivePendantHolderBase localConversationActivePendantHolderBase = this.a;
    if (localConversationActivePendantHolderBase != null)
    {
      ((SpringNomalPendantHolder)localConversationActivePendantHolderBase).b();
      ((SpringNomalPendantHolder)this.a).a(true);
      invalidate();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "startActiveSanHua");
    }
    ConversationActivePendantHolderBase localConversationActivePendantHolderBase = this.a;
    if (localConversationActivePendantHolderBase != null)
    {
      localConversationActivePendantHolderBase.g();
      invalidate();
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!this.mForHongBao)
    {
      ARMapHongBaoListView.QQStoryListViewListener localQQStoryListViewListener = this.J;
      if (localQQStoryListViewListener != null) {
        localQQStoryListViewListener.onFlingScrollHeader(this.L, getScrollY());
      }
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    boolean bool = this.n;
    int j = 1;
    int k;
    int i;
    if (((bool) && (this.b) && (this.o) && (this.e)) || (this.q))
    {
      k = getListViewScrollY();
      i = k;
      if (k < 0) {
        i = 0;
      }
      ConversationActivePendantHolderBase localConversationActivePendantHolderBase = this.a;
      if (localConversationActivePendantHolderBase != null)
      {
        localConversationActivePendantHolderBase.s = (-i);
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
    if ((this.g) && (this.d != null) && (this.f))
    {
      k = getListViewScrollY();
      i = k;
      if (k < 0) {
        i = 0;
      }
      if ((this.g) && (this.d != null))
      {
        this.d.s = (-i);
        if (this.d.a(paramCanvas))
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
  
  public boolean e()
  {
    ConversationActivePendantHolderBase localConversationActivePendantHolderBase = this.a;
    if (localConversationActivePendantHolderBase != null) {
      return ((SpringNomalPendantHolder)localConversationActivePendantHolderBase).a();
    }
    return false;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "hideActivePendant");
    }
    g();
    this.b = false;
    this.a = null;
    invalidate();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "stopActiveSanHua");
    }
    ConversationActivePendantHolderBase localConversationActivePendantHolderBase = this.a;
    if (localConversationActivePendantHolderBase != null)
    {
      localConversationActivePendantHolderBase.c();
      invalidate();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "stopActiveSanHua, holder is null");
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
    if ((this.J != null) && (!this.mForHongBao))
    {
      int i = getScrollY();
      if ((this.mEnableStory) && (this.mOverscrollHeaderViewContainer != null) && (i <= 0))
      {
        if (this.J.getMode() == 2)
        {
          SLog.b("ARMapHongBaoListView", "story node start refresh getSpringbackOffset.");
          this.mOverscrollHeadState = 2;
          super.getSpringbackOffset();
        }
        return this.J.getSpringbackOffset(this);
      }
      return super.getSpringbackOffset();
    }
    return super.getSpringbackOffset();
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapHongBaoListView", 2, "stopNormalActivityPendantAnimation");
    }
    g();
    ConversationActivePendantHolderBase localConversationActivePendantHolderBase = this.a;
    if (localConversationActivePendantHolderBase != null)
    {
      ((SpringNomalPendantHolder)localConversationActivePendantHolderBase).c.c();
      ((SpringNomalPendantHolder)this.a).a(false);
      invalidate();
    }
  }
  
  public void i()
  {
    this.g = false;
    this.d = null;
    if (QLog.isColorLevel()) {
      QLog.i("ARMapHongBaoListView", 2, "dismissBreathLight:");
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((!this.n) || (!this.o)) && (!this.q)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    if (!this.G) {
      return true;
    }
    if ((paramMotionEvent.getAction() & 0xFF) == 0)
    {
      ARMapHongBaoListView.ConversationActiveListViewListener localConversationActiveListViewListener = this.I;
      if (localConversationActiveListViewListener != null) {
        localConversationActiveListViewListener.a(this);
      }
      if ((this.b) && (this.a != null))
      {
        int i = getListViewScrollY();
        int j = getScrollY();
        if (j < 0) {
          i = j;
        }
        float f1 = paramMotionEvent.getY();
        if (this.a.c(i).contains(paramMotionEvent.getX(), f1))
        {
          this.x = true;
          super.onInterceptTouchEvent(paramMotionEvent);
          return true;
        }
      }
      else
      {
        this.x = false;
        b();
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (!this.o) {
      return;
    }
    ARMapHongBaoListView.ConversationActiveListViewListener localConversationActiveListViewListener = this.I;
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
      localObject = this.J;
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
    if (((!this.n) || (!this.o)) && (!this.q)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (!this.G) {
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
          this.x = false;
          return bool3;
        }
        paramMotionEvent = this.I;
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
        if ((this.x) && ((this.I != null) || (this.K != null)) && (this.a != null))
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
          if ((this.a.c(i).contains(paramMotionEvent.getX(), f1)) && (this.e))
          {
            localObject = this.I;
            if (localObject != null) {
              ((ARMapHongBaoListView.ConversationActiveListViewListener)localObject).a();
            }
            if (this.K != null)
            {
              localObject = this.a.a(i);
              if ((localObject != null) && (((RectF)localObject).contains(paramMotionEvent.getX(), f1)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ARMapHongBaoListView", 2, "onTouchEvent debug click event onPendentCloseBtnClick");
                }
                this.K.b(paramMotionEvent.getX(), f1);
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ARMapHongBaoListView", 2, "onTouchEvent debug click event onPendentClick");
                }
                this.K.a(paramMotionEvent.getX(), f1);
              }
            }
          }
        }
        paramMotionEvent = this.I;
        if (paramMotionEvent != null) {
          paramMotionEvent.b(this);
        }
        this.x = false;
      }
    }
    return bool3;
  }
  
  public void setActiveListViewListener(ARMapHongBaoListView.ConversationActiveListViewListener paramConversationActiveListViewListener)
  {
    this.I = paramConversationActiveListViewListener;
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
    this.G = paramBoolean;
  }
  
  public void setOnPendentClickListener(ARMapHongBaoListView.onPendentClickListener paramonPendentClickListener)
  {
    this.K = paramonPendentClickListener;
  }
  
  public void setPendantHolder(ConversationActivePendantHolderBase paramConversationActivePendantHolderBase)
  {
    this.a = paramConversationActivePendantHolderBase;
    boolean bool = true;
    this.q = true;
    if (this.a == null) {
      bool = false;
    }
    this.b = bool;
    invalidate();
  }
  
  public void setQQStoryListViewListener(ARMapHongBaoListView.QQStoryListViewListener paramQQStoryListViewListener)
  {
    this.J = paramQQStoryListViewListener;
  }
  
  public void setScrollState(int paramInt)
  {
    this.L = paramInt;
  }
  
  public void setShowLightByUser(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setShowLightByUser:");
      localStringBuilder.append(this.f);
      QLog.i("ARMapHongBaoListView", 2, localStringBuilder.toString());
    }
  }
  
  public void springBackOverScrollHeaderView()
  {
    if ((!this.mForHongBao) && (this.mEnableStory))
    {
      ARMapHongBaoListView.QQStoryListViewListener localQQStoryListViewListener = this.J;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ARMapHongBaoListView
 * JD-Core Version:    0.7.0.1
 */
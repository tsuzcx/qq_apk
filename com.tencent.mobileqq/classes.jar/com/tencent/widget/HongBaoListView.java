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
  public Bitmap A;
  public int B = 0;
  public int C = 0;
  public boolean D = false;
  public boolean E = false;
  public Handler F = new Handler(Looper.getMainLooper(), new HongBaoListView.1(this));
  private long a;
  private View b;
  OverScrollViewListener i;
  Drawable j;
  Drawable k;
  View l;
  public ConversationHongBaoV2 m = null;
  public boolean n;
  public boolean o = false;
  public boolean p = false;
  public boolean q = false;
  public int r = -1;
  public boolean[] s = new boolean[10];
  public float[] t = new float[10];
  public int u = 1;
  public HongBaoListViewListener v = null;
  public int w;
  public boolean x = false;
  public boolean y;
  public HongBaoPendantHolder z;
  
  public HongBaoListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HongBaoListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt)
  {
    setHongBaoAlpha(255);
    setSelection(0);
    this.F.removeMessages(5);
    this.F.removeMessages(6);
    this.F.removeMessages(7);
    Message localMessage = Message.obtain(this.F, 5, paramInt, 0);
    this.F.sendMessageDelayed(localMessage, 150L);
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
      ((StringBuilder)localObject).append(this.z);
      QLog.d("HongBaoListView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.z;
    if (localObject != null) {
      ((HongBaoPendantHolder)localObject).a(paramBitmap);
    }
    this.A = paramBitmap;
    invalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.n) && (this.y) && (!this.o))
    {
      int i2 = getListViewScrollY();
      int i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
      HongBaoPendantHolder localHongBaoPendantHolder = this.z;
      localHongBaoPendantHolder.t = (-i1);
      if (localHongBaoPendantHolder.a(paramCanvas)) {
        invalidate();
      }
    }
  }
  
  public int getComputeScrollOffset()
  {
    return computeVerticalScrollOffset();
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
    if ((this.n) && (!this.o)) {
      return this.w;
    }
    return super.getSpringbackOffset();
  }
  
  public boolean isOverscrollHeadVisiable()
  {
    if (this.n) {
      return getScrollY() < 0;
    }
    return super.isOverscrollHeadVisiable();
  }
  
  public void j()
  {
    super.setOverScrollListener(this.i);
    k();
    setComboListener(null);
    super.setOverscrollHeader(this.k);
    super.setOverScrollHeader(this.l);
    super.setContentBackground(this.j);
    setOverscrollHeaderShadowEnable(true);
    this.n = false;
    r();
    o();
    this.mForHongBao = false;
    this.o = false;
    this.p = false;
  }
  
  public void k()
  {
    if (this.n == true)
    {
      if (this.E)
      {
        OverScroller.BOUNCE_DURANTION = 300;
        return;
      }
      OverScroller.BOUNCE_DURANTION = 600;
      return;
    }
    OverScroller.BOUNCE_DURANTION = 400;
  }
  
  public void l()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("modeHongbao mActive = ");
      ((StringBuilder)localObject).append(this.n);
      ((StringBuilder)localObject).append(",hongbaoModeListScrollHeaderView = ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("HongBaoListView", 2, ((StringBuilder)localObject).toString());
    }
    m();
    this.n = true;
    super.setOverScrollListener(null);
    super.setOverscrollHeader(null);
    super.setOverScrollHeader(this.b);
    Object localObject = this.b;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    setOverscrollHeaderShadowEnable(false);
    this.mForHongBao = true;
    this.o = false;
    this.p = true;
  }
  
  public void m()
  {
    if (this.z != null) {
      return;
    }
    this.z = new HongBaoPendantHolder(this);
    this.z.a(true, this.A);
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HongBaoListView", 2, "clearPendant");
    }
    this.y = false;
    this.z = null;
  }
  
  public void o()
  {
    if (this.o) {
      return;
    }
    this.F.removeMessages(1);
    this.F.removeMessages(2);
    setIsShowingPreguide(false);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.n) && (!this.o))
    {
      Object localObject = this.m;
      if ((localObject != null) && (!((ConversationHongBaoV2)localObject).l)) {
        return true;
      }
      if ((paramMotionEvent.getAction() & 0xFF) == 0)
      {
        this.t[0] = paramMotionEvent.getY();
        this.s[0] = true;
        localObject = this.v;
        if (localObject != null) {
          ((HongBaoListViewListener)localObject).a(this);
        }
        if (this.y)
        {
          localObject = this.z;
          if ((localObject != null) && (((HongBaoPendantHolder)localObject).a(getScrollY()).contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
          {
            if (getScrollY() == 0) {
              this.x = true;
            }
            super.onInterceptTouchEvent(paramMotionEvent);
            if (QLog.isColorLevel())
            {
              paramMotionEvent = new StringBuilder();
              paramMotionEvent.append("2021_UI_ConversationHongBaoV2 HongBaoListView onInterceptTouchEvent return true, mComboListener = ");
              paramMotionEvent.append(this.v);
              QLog.d("HongBaoListView", 2, paramMotionEvent.toString());
            }
            return true;
          }
        }
        this.x = false;
        o();
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
    if (this.o) {
      return;
    }
    HongBaoListViewListener localHongBaoListViewListener = this.v;
    if (localHongBaoListViewListener != null) {
      localHongBaoListViewListener.a(paramInt1, paramInt2);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    HongBaoPendantHolder localHongBaoPendantHolder = this.z;
    if ((localHongBaoPendantHolder != null) && (localHongBaoPendantHolder.g != null)) {
      this.z.g.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.n) && (!this.o))
    {
      Object localObject = this.m;
      boolean bool2 = true;
      if ((localObject != null) && (!((ConversationHongBaoV2)localObject).l)) {
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
                this.s[i1] = false;
                return bool3;
              }
              i1 = paramMotionEvent.getActionIndex();
              this.t[i1] = ((int)paramMotionEvent.getY(i1));
              this.s[i1] = true;
              return bool3;
            }
            if (QLog.isColorLevel())
            {
              paramMotionEvent = new StringBuilder();
              paramMotionEvent.append("2021_UI_ConversationHongBaoV2 HongBaoListView ACTION_CANCEL mComboListener = ");
              paramMotionEvent.append(this.v);
              QLog.d("HongBaoListView", 2, paramMotionEvent.toString());
            }
            paramMotionEvent = this.v;
            if (paramMotionEvent != null) {
              paramMotionEvent.b(this);
            }
            this.r = -1;
            this.x = false;
            return bool3;
          }
          localObject = this.v;
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
          paramMotionEvent.findPointerIndex(this.r);
          i1 = this.mTouchMode;
          if ((i1 != 3) && (i1 != 5)) {
            return bool3;
          }
          if (this.v != null)
          {
            i1 = paramMotionEvent.getPointerCount();
            if (i1 > this.u) {
              this.u = i1;
            }
            i1 = 0;
            float f2;
            for (float f1 = 0.0F; i1 < paramMotionEvent.getPointerCount(); f1 = f2)
            {
              float f3 = paramMotionEvent.getY(i1) - this.t[i1];
              f2 = f1;
              if (this.s[i1] != 0)
              {
                f2 = f1;
                if (f3 > f1) {
                  f2 = f3;
                }
              }
              i1 += 1;
            }
            i1 = -getScrollY();
            int i2 = this.C;
            if (i1 >= i2 / 2)
            {
              if (f1 > i2 / 2)
              {
                setSpringbackOffset(-i2);
                this.v.d();
                i1 = 0;
                while (i1 < this.u)
                {
                  this.s[i1] = false;
                  i1 += 1;
                }
              }
              this.v.a();
              return bool3;
            }
          }
        }
        else
        {
          if (this.x)
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
            if ((this.z != null) && (l1 - this.a > 800L) && (getScrollY() == 0))
            {
              this.a = l1;
              if (this.z.a(getScrollY()).contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
              {
                localObject = this.z.b(getScrollY());
                if ((localObject != null) && (((RectF)localObject).contains(paramMotionEvent.getX(), paramMotionEvent.getY()))) {
                  this.v.c();
                } else {
                  this.v.b();
                }
              }
            }
          }
          this.x = false;
          if (QLog.isColorLevel())
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("2021_UI_ConversationHongBaoV2 HongBaoListView ACTION_UP mComboListener = ");
            paramMotionEvent.append(this.v);
            QLog.d("HongBaoListView", 2, paramMotionEvent.toString());
          }
          paramMotionEvent = this.v;
          if (paramMotionEvent != null) {
            paramMotionEvent.b(this);
          }
          this.r = -1;
          return bool3;
        }
      }
      else if (QLog.isColorLevel())
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("2021_UI_ConversationHongBaoV2 HongBaoListView ACTION_DOWN mComboListener = ");
        paramMotionEvent.append(this.v);
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
    if (this.D) {
      this.D = false;
    }
  }
  
  public void p()
  {
    q();
    this.z.a(false, this.A);
    this.z.d();
    invalidate();
  }
  
  public void q()
  {
    this.z.c();
    if (this.z.g != null) {
      this.z.g.c();
    }
  }
  
  public void r()
  {
    if (!this.y) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideHongBao ,");
      localStringBuilder.append(this.y);
      QLog.d("PortalManager", 2, localStringBuilder.toString());
    }
    q();
    this.y = false;
  }
  
  public void s()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showHongBao ,");
      localStringBuilder.append(this.y);
      QLog.d("PortalManager", 2, localStringBuilder.toString());
    }
    q();
    this.y = true;
    this.z.E = 255;
  }
  
  public void setComboListener(HongBaoListViewListener paramHongBaoListViewListener)
  {
    this.v = paramHongBaoListViewListener;
  }
  
  public void setContentBackground(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.j = paramDrawable;
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
    this.b = paramView;
  }
  
  public void setIsShowingPreguide(boolean paramBoolean)
  {
    this.E = paramBoolean;
    k();
  }
  
  public void setLogo(Bitmap paramBitmap, boolean paramBoolean)
  {
    HongBaoPendantHolder localHongBaoPendantHolder = this.z;
    if (localHongBaoPendantHolder != null) {
      localHongBaoPendantHolder.a(paramBoolean, paramBitmap);
    }
    this.A = paramBitmap;
    invalidate();
    if (QLog.isColorLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("setLogo ,");
      paramBitmap.append(this.y);
      paramBitmap.append(", ");
      paramBitmap.append(this.A);
      QLog.d("PortalManager", 2, paramBitmap.toString());
    }
  }
  
  public void setOverScrollHeader(View paramView)
  {
    if (paramView != null) {
      this.l = paramView;
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
      this.i = paramOverScrollViewListener;
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
      this.k = paramDrawable;
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
      this.mOverScrollHeaderShadow = getResources().getDrawable(2130841382);
      return;
    }
    this.mOverScrollHeaderShadow = null;
  }
  
  public void setSpringbackOffset(int paramInt)
  {
    this.w = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.HongBaoListView
 * JD-Core Version:    0.7.0.1
 */
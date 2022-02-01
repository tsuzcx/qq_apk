package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime.Status;

public class OnlineStatusListLayout
  extends ViewGroup
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i = -1;
  private OnlineStatusPanelParams j;
  
  public OnlineStatusListLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public OnlineStatusListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OnlineStatusListLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(int paramInt)
  {
    int k = 1;
    int n = paramInt + 1;
    int m = n / this.j.d;
    paramInt = k;
    if (n % this.j.d == 0) {
      paramInt = 0;
    }
    return m + paramInt;
  }
  
  public static boolean a(OnlineStatusItem paramOnlineStatusItem1, OnlineStatusItem paramOnlineStatusItem2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramOnlineStatusItem1 != null)
    {
      bool1 = bool2;
      if (paramOnlineStatusItem2 != null)
      {
        if (paramOnlineStatusItem1.g.getValue() != paramOnlineStatusItem2.g.getValue()) {
          return false;
        }
        bool1 = bool2;
        if (paramOnlineStatusItem1.b == paramOnlineStatusItem2.b) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private View getLastVisibleChildView()
  {
    int k = getChildCount() - 1;
    while (k >= 0)
    {
      View localView = getChildAt(k);
      if (localView.getVisibility() == 0) {
        return localView;
      }
      k -= 1;
    }
    return null;
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    int k = 0;
    while (k < paramInt)
    {
      OnlineStatusItemView localOnlineStatusItemView = new OnlineStatusItemView(getContext());
      localOnlineStatusItemView.a(this.j);
      localOnlineStatusItemView.setItemWidth(this.a);
      localOnlineStatusItemView.setOnClickListener(paramOnClickListener);
      localOnlineStatusItemView.setVisibility(4);
      int m = this.a;
      addView(localOnlineStatusItemView, new ViewGroup.LayoutParams(m, m));
      k += 1;
    }
  }
  
  public void a(OnlineStatusPanelParams paramOnlineStatusPanelParams)
  {
    this.j = paramOnlineStatusPanelParams;
    this.d = ViewUtils.dpToPx(paramOnlineStatusPanelParams.h);
    this.e = ViewUtils.dpToPx(paramOnlineStatusPanelParams.e);
    this.f = ViewUtils.dpToPx(paramOnlineStatusPanelParams.f);
    int k = this.d;
    setPadding(k, this.e, k, this.f);
    this.b = ViewUtils.dpToPx(paramOnlineStatusPanelParams.g);
    this.c = ViewUtils.dpToPx(paramOnlineStatusPanelParams.g);
  }
  
  public void a(List<OnlineStatusItem> paramList, ArrayList<OnlineStatusItem> paramArrayList)
  {
    int k = 0;
    Object localObject;
    while (k < getChildCount())
    {
      localObject = getChildAt(k);
      ((View)localObject).setVisibility(4);
      ((OnlineStatusItemView)localObject).a(false);
      k += 1;
    }
    int n = paramList.size();
    k = 0;
    while (k < n)
    {
      localObject = getChildAt(k);
      if (localObject == null) {
        break;
      }
      if (!(localObject instanceof OnlineStatusItemView)) {
        return;
      }
      localObject = (OnlineStatusItemView)localObject;
      ((OnlineStatusItemView)localObject).setVisibility(0);
      OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)paramList.get(k);
      ((OnlineStatusItemView)localObject).a(localOnlineStatusItem);
      ((OnlineStatusItemView)localObject).setTag(localOnlineStatusItem);
      int m = 0;
      while (m < paramArrayList.size())
      {
        if (a(localOnlineStatusItem, (OnlineStatusItem)paramArrayList.get(m)))
        {
          ((OnlineStatusItemView)localObject).a(true);
          break;
        }
        m += 1;
      }
      k += 1;
    }
  }
  
  public boolean a()
  {
    if (this.h != 0)
    {
      if (this.g == 0) {
        return false;
      }
      View localView = getLastVisibleChildView();
      if (localView == null) {
        return false;
      }
      int m = localView.getBottom();
      int n = localView.getRight();
      int i1 = localView.getTop();
      int i2 = this.c;
      int i3 = this.g;
      int i4 = this.h;
      int k;
      if (this.a + n >= getRight()) {
        k = 1;
      } else {
        k = 0;
      }
      if (i4 <= m) {
        return (i3 > n) && (k == 0) && (i4 > i1 - i2);
      }
      return true;
    }
    return false;
  }
  
  public int getPageIndex()
  {
    return this.i;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramInt3 = this.d + paramInt1 % this.j.d * (this.a + this.b);
      paramInt4 = this.e + (a(paramInt1) - 1) * (this.a + this.c);
      Object localObject = getChildAt(paramInt1);
      int k = this.a;
      ((View)localObject).layout(paramInt3, paramInt4, paramInt3 + k, k + paramInt4);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onLayout : startX -> ");
        ((StringBuilder)localObject).append(paramInt3);
        ((StringBuilder)localObject).append(", startY -> ");
        ((StringBuilder)localObject).append(paramInt4);
        ((StringBuilder)localObject).append(", getRowByChildIndex(i) -> ");
        ((StringBuilder)localObject).append(a(paramInt1));
        QLog.d("OnlineStatusListLayout", 2, ((StringBuilder)localObject).toString());
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = getChildCount();
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824)
    {
      k = View.MeasureSpec.getSize(paramInt2);
    }
    else
    {
      k = a(k - 1);
      int m = this.a;
      int n = this.c;
      k = k * (m + n) - n;
    }
    setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), paramInt1), k);
    measureChildren(paramInt1, View.MeasureSpec.makeMeasureSpec(k, View.MeasureSpec.getMode(paramInt2)));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.g = ((int)paramMotionEvent.getX());
      this.h = ((int)paramMotionEvent.getY());
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setItemWidth(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setPageIndex(int paramInt)
  {
    this.i = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusListLayout
 * JD-Core Version:    0.7.0.1
 */
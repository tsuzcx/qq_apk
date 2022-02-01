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
  private int jdField_a_of_type_Int;
  private OnlineStatusPanelParams jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i = -1;
  
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
    int j = 1;
    int m = paramInt + 1;
    int k = m / this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.c;
    paramInt = j;
    if (m % this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.c == 0) {
      paramInt = 0;
    }
    return k + paramInt;
  }
  
  private View a()
  {
    int j = getChildCount() - 1;
    while (j >= 0)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 0) {
        return localView;
      }
      j -= 1;
    }
    return null;
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
        if (paramOnlineStatusItem1.jdField_a_of_type_MqqAppAppRuntime$Status.getValue() != paramOnlineStatusItem2.jdField_a_of_type_MqqAppAppRuntime$Status.getValue()) {
          return false;
        }
        bool1 = bool2;
        if (paramOnlineStatusItem1.jdField_a_of_type_Long == paramOnlineStatusItem2.jdField_a_of_type_Long) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int a()
  {
    return this.i;
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    int j = 0;
    while (j < paramInt)
    {
      OnlineStatusItemView localOnlineStatusItemView = new OnlineStatusItemView(getContext());
      localOnlineStatusItemView.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams);
      localOnlineStatusItemView.setItemWidth(this.jdField_a_of_type_Int);
      localOnlineStatusItemView.setOnClickListener(paramOnClickListener);
      localOnlineStatusItemView.setVisibility(4);
      int k = this.jdField_a_of_type_Int;
      addView(localOnlineStatusItemView, new ViewGroup.LayoutParams(k, k));
      j += 1;
    }
  }
  
  public void a(OnlineStatusPanelParams paramOnlineStatusPanelParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams = paramOnlineStatusPanelParams;
    this.d = ViewUtils.b(paramOnlineStatusPanelParams.g);
    this.e = ViewUtils.b(paramOnlineStatusPanelParams.d);
    this.f = ViewUtils.b(paramOnlineStatusPanelParams.e);
    int j = this.d;
    setPadding(j, this.e, j, this.f);
    this.b = ViewUtils.b(paramOnlineStatusPanelParams.f);
    this.c = ViewUtils.b(paramOnlineStatusPanelParams.f);
  }
  
  public void a(List<OnlineStatusItem> paramList, ArrayList<OnlineStatusItem> paramArrayList)
  {
    int j = 0;
    Object localObject;
    while (j < getChildCount())
    {
      localObject = getChildAt(j);
      ((View)localObject).setVisibility(4);
      ((OnlineStatusItemView)localObject).a(false);
      j += 1;
    }
    int m = paramList.size();
    j = 0;
    while (j < m)
    {
      localObject = getChildAt(j);
      if (localObject == null) {
        break;
      }
      if (!(localObject instanceof OnlineStatusItemView)) {
        return;
      }
      localObject = (OnlineStatusItemView)localObject;
      ((OnlineStatusItemView)localObject).setVisibility(0);
      OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)paramList.get(j);
      ((OnlineStatusItemView)localObject).a(localOnlineStatusItem);
      ((OnlineStatusItemView)localObject).setTag(localOnlineStatusItem);
      int k = 0;
      while (k < paramArrayList.size())
      {
        if (a(localOnlineStatusItem, (OnlineStatusItem)paramArrayList.get(k)))
        {
          ((OnlineStatusItemView)localObject).a(true);
          break;
        }
        k += 1;
      }
      j += 1;
    }
  }
  
  public boolean a()
  {
    if (this.h != 0)
    {
      if (this.g == 0) {
        return false;
      }
      View localView = a();
      if (localView == null) {
        return false;
      }
      int k = localView.getBottom();
      int m = localView.getRight();
      int n = localView.getTop();
      int i1 = this.c;
      int i2 = this.g;
      int i3 = this.h;
      int j;
      if (this.jdField_a_of_type_Int + m >= getRight()) {
        j = 1;
      } else {
        j = 0;
      }
      if (i3 <= k) {
        return (i2 > m) && (j == 0) && (i3 > n - i1);
      }
      return true;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramInt3 = this.d + paramInt1 % this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.c * (this.jdField_a_of_type_Int + this.b);
      paramInt4 = this.e + (a(paramInt1) - 1) * (this.jdField_a_of_type_Int + this.c);
      Object localObject = getChildAt(paramInt1);
      int j = this.jdField_a_of_type_Int;
      ((View)localObject).layout(paramInt3, paramInt4, paramInt3 + j, j + paramInt4);
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
    int j = getChildCount();
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824)
    {
      j = View.MeasureSpec.getSize(paramInt2);
    }
    else
    {
      j = a(j - 1);
      int k = this.jdField_a_of_type_Int;
      int m = this.c;
      j = j * (k + m) - m;
    }
    setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), paramInt1), j);
    measureChildren(paramInt1, View.MeasureSpec.makeMeasureSpec(j, View.MeasureSpec.getMode(paramInt2)));
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
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setPageIndex(int paramInt)
  {
    this.i = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusListLayout
 * JD-Core Version:    0.7.0.1
 */
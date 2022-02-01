package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
    int j = (paramInt + 1) / this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.c;
    if ((paramInt + 1) % this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.c == 0) {}
    for (paramInt = 0;; paramInt = 1) {
      return paramInt + j;
    }
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
    if ((paramOnlineStatusItem1 == null) || (paramOnlineStatusItem2 == null) || (paramOnlineStatusItem1.jdField_a_of_type_MqqAppAppRuntime$Status.getValue() != paramOnlineStatusItem2.jdField_a_of_type_MqqAppAppRuntime$Status.getValue())) {}
    while (paramOnlineStatusItem1.jdField_a_of_type_Long != paramOnlineStatusItem2.jdField_a_of_type_Long) {
      return false;
    }
    return true;
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
      addView(localOnlineStatusItemView, new ViewGroup.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
      j += 1;
    }
  }
  
  public void a(OnlineStatusPanelParams paramOnlineStatusPanelParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams = paramOnlineStatusPanelParams;
    this.d = AIOUtils.a(paramOnlineStatusPanelParams.g, getResources());
    this.e = AIOUtils.a(paramOnlineStatusPanelParams.d, getResources());
    this.f = AIOUtils.a(paramOnlineStatusPanelParams.e, getResources());
    setPadding(this.d, this.e, this.d, this.f);
    this.b = AIOUtils.a(paramOnlineStatusPanelParams.f, getResources());
    this.c = AIOUtils.a(paramOnlineStatusPanelParams.f, getResources());
  }
  
  public void a(List<OnlineStatusItem> paramList, ArrayList<OnlineStatusItem> paramArrayList)
  {
    int j = 0;
    while (j < getChildCount())
    {
      localObject = getChildAt(j);
      ((View)localObject).setVisibility(4);
      ((OnlineStatusItemView)localObject).a(false);
      j += 1;
    }
    int m = paramList.size();
    j = 0;
    if (j < m)
    {
      localObject = getChildAt(j);
      if ((localObject != null) && ((localObject instanceof OnlineStatusItemView))) {}
    }
    else
    {
      return;
    }
    Object localObject = (OnlineStatusItemView)localObject;
    ((OnlineStatusItemView)localObject).setVisibility(0);
    OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)paramList.get(j);
    ((OnlineStatusItemView)localObject).a(localOnlineStatusItem);
    ((OnlineStatusItemView)localObject).setTag(localOnlineStatusItem);
    int k = 0;
    for (;;)
    {
      if (k < paramArrayList.size())
      {
        if (a(localOnlineStatusItem, (OnlineStatusItem)paramArrayList.get(k))) {
          ((OnlineStatusItemView)localObject).a(true);
        }
      }
      else
      {
        j += 1;
        break;
      }
      k += 1;
    }
  }
  
  public boolean a()
  {
    if ((this.h == 0) || (this.g == 0)) {}
    for (;;)
    {
      return false;
      View localView = a();
      if (localView != null)
      {
        int k = localView.getBottom();
        int m = localView.getRight();
        int n = localView.getTop();
        int i1 = this.c;
        int i2 = this.g;
        int i3 = this.h;
        if (this.jdField_a_of_type_Int + m >= getRight()) {}
        for (int j = 1; (i3 > k) || ((i2 > m) && (j == 0) && (i3 > n - i1)); j = 0) {
          return true;
        }
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = 0;
    paramInt2 = getChildCount();
    while (paramInt1 < paramInt2)
    {
      paramInt3 = this.d + paramInt1 % this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.c * (this.jdField_a_of_type_Int + this.b);
      paramInt4 = this.e + (a(paramInt1) - 1) * (this.jdField_a_of_type_Int + this.c);
      getChildAt(paramInt1).layout(paramInt3, paramInt4, this.jdField_a_of_type_Int + paramInt3, this.jdField_a_of_type_Int + paramInt4);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusListLayout", 2, "onLayout : startX -> " + paramInt3 + ", startY -> " + paramInt4 + ", getRowByChildIndex(i) -> " + a(paramInt1));
      }
      paramInt1 += 1;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (j = View.MeasureSpec.getSize(paramInt2);; j = a(j - 1) * (this.jdField_a_of_type_Int + this.c) - this.c)
    {
      setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), paramInt1), j);
      measureChildren(paramInt1, View.MeasureSpec.makeMeasureSpec(j, View.MeasureSpec.getMode(paramInt2)));
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusListLayout
 * JD-Core Version:    0.7.0.1
 */
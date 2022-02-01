package com.tencent.mobileqq.onlinestatus;

import afur;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import aypi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime.Status;

public class OnlineStatusListLayout
  extends ViewGroup
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public OnlineStatusListLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public OnlineStatusListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public OnlineStatusListLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(int paramInt)
  {
    int i = (paramInt + 1) / 4;
    if ((paramInt + 1) % 4 == 0) {}
    for (paramInt = 0;; paramInt = 1) {
      return paramInt + i;
    }
  }
  
  private View a()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  private void a()
  {
    this.d = afur.a(14.0F, getResources());
    this.e = afur.a(9.0F, getResources());
    this.f = afur.a(39.0F, getResources());
    setPadding(this.d, this.e, this.d, this.f);
    this.jdField_b_of_type_Int = afur.a(9.0F, getResources());
    this.jdField_c_of_type_Int = afur.a(9.0F, getResources());
  }
  
  public static boolean a(aypi paramaypi1, aypi paramaypi2)
  {
    if ((paramaypi1 == null) || (paramaypi2 == null) || (paramaypi1.jdField_a_of_type_MqqAppAppRuntime$Status.getValue() != paramaypi2.jdField_a_of_type_MqqAppAppRuntime$Status.getValue())) {}
    while (paramaypi1.jdField_a_of_type_Long != paramaypi2.jdField_a_of_type_Long) {
      return false;
    }
    return true;
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    int i = 0;
    while (i < paramInt)
    {
      OnlineStatusItemView localOnlineStatusItemView = new OnlineStatusItemView(getContext());
      localOnlineStatusItemView.setMultiMode(this.jdField_b_of_type_Boolean);
      localOnlineStatusItemView.setUseWhiteBg(this.jdField_a_of_type_Boolean);
      localOnlineStatusItemView.setUseLightNightBg(this.jdField_c_of_type_Boolean);
      localOnlineStatusItemView.a();
      localOnlineStatusItemView.setOnClickListener(paramOnClickListener);
      localOnlineStatusItemView.setVisibility(4);
      addView(localOnlineStatusItemView, new ViewGroup.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
      i += 1;
    }
  }
  
  public void a(List<aypi> paramList, ArrayList<aypi> paramArrayList)
  {
    int i = 0;
    while (i < getChildCount())
    {
      localObject = getChildAt(i);
      ((View)localObject).setVisibility(4);
      ((OnlineStatusItemView)localObject).a(false);
      i += 1;
    }
    int k = paramList.size();
    i = 0;
    if (i < k)
    {
      localObject = getChildAt(i);
      if ((localObject != null) && ((localObject instanceof OnlineStatusItemView))) {}
    }
    else
    {
      return;
    }
    Object localObject = (OnlineStatusItemView)localObject;
    ((OnlineStatusItemView)localObject).setVisibility(0);
    aypi localaypi = (aypi)paramList.get(i);
    ((OnlineStatusItemView)localObject).a(localaypi);
    ((OnlineStatusItemView)localObject).setTag(localaypi);
    int j = 0;
    for (;;)
    {
      if (j < paramArrayList.size())
      {
        if (a(localaypi, (aypi)paramArrayList.get(j))) {
          ((OnlineStatusItemView)localObject).a(true);
        }
      }
      else
      {
        i += 1;
        break;
      }
      j += 1;
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
        int j = localView.getBottom();
        int k = localView.getRight();
        int m = localView.getTop();
        int n = this.jdField_c_of_type_Int;
        int i1 = this.g;
        int i2 = this.h;
        if (this.jdField_a_of_type_Int + k >= getRight()) {}
        for (int i = 1; (i2 > j) || ((i1 > k) && (i == 0) && (i2 > m - n)); i = 0) {
          return true;
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = 0;
    paramInt2 = getChildCount();
    while (paramInt1 < paramInt2)
    {
      paramInt3 = this.d + paramInt1 % 4 * (this.jdField_a_of_type_Int + this.jdField_b_of_type_Int);
      paramInt4 = this.e + (a(paramInt1) - 1) * (this.jdField_a_of_type_Int + this.jdField_c_of_type_Int);
      getChildAt(paramInt1).layout(paramInt3, paramInt4, this.jdField_a_of_type_Int + paramInt3, this.jdField_a_of_type_Int + paramInt4);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusListLayout", 2, "onLayout : startX -> " + paramInt3 + ", startY -> " + paramInt4 + ", getRowByChildIndex(i) -> " + a(paramInt1));
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (i = View.MeasureSpec.getSize(paramInt2);; i = a(i - 1) * (this.jdField_a_of_type_Int + this.jdField_c_of_type_Int) - this.jdField_c_of_type_Int)
    {
      setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), paramInt1), i);
      measureChildren(paramInt1, View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.getMode(paramInt2)));
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
  
  public void setItemMargin(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setItemWidth(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setMultiMode(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setUseLightNightBg(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setUseWhiteBg(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusListLayout
 * JD-Core Version:    0.7.0.1
 */
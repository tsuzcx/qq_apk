package com.tencent.mobileqq.onlinestatus;

import aepi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import awev;
import com.tencent.qphone.base.util.QLog;
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
    int i = (paramInt + 1) / 3;
    if ((paramInt + 1) % 3 == 0) {}
    for (paramInt = 0;; paramInt = 1) {
      return paramInt + i;
    }
  }
  
  private void a()
  {
    this.e = aepi.a(12.0F, getResources());
    this.f = aepi.a(16.0F, getResources());
    setPadding(this.e, this.f, this.e, 0);
    this.c = aepi.a(16.0F, getResources());
    this.d = aepi.a(20.0F, getResources());
    this.b = aepi.a(32.0F, getResources());
  }
  
  private boolean a(awev paramawev1, awev paramawev2)
  {
    if ((paramawev1 == null) || (paramawev2 == null) || (paramawev1.jdField_a_of_type_MqqAppAppRuntime$Status.getValue() != paramawev2.jdField_a_of_type_MqqAppAppRuntime$Status.getValue())) {}
    while (paramawev1.jdField_a_of_type_Long != paramawev2.jdField_a_of_type_Long) {
      return false;
    }
    return true;
  }
  
  public void a(awev paramawev)
  {
    if (paramawev == null) {}
    for (;;)
    {
      return;
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = getChildAt(i);
        if ((localObject instanceof OnlineStatusItemView))
        {
          localObject = (OnlineStatusItemView)localObject;
          ((OnlineStatusItemView)localObject).a(a(((OnlineStatusItemView)localObject).a, paramawev));
        }
        i += 1;
      }
    }
  }
  
  public void a(List<awev> paramList, View.OnClickListener paramOnClickListener)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      awev localawev = (awev)paramList.get(i);
      OnlineStatusItemView localOnlineStatusItemView = new OnlineStatusItemView(getContext());
      localOnlineStatusItemView.a(localawev);
      localOnlineStatusItemView.setTag(localawev);
      localOnlineStatusItemView.setOnClickListener(paramOnClickListener);
      addView(localOnlineStatusItemView);
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getWidth() > 0) {}
    for (paramInt1 = getWidth();; paramInt1 = getResources().getDisplayMetrics().widthPixels)
    {
      this.a = ((paramInt1 - this.e * 2 - this.c * 2) / 3);
      paramInt1 = 0;
      paramInt2 = getChildCount();
      while (paramInt1 < paramInt2)
      {
        paramInt3 = this.e + paramInt1 % 3 * (this.a + this.c);
        paramInt4 = this.f + (a(paramInt1) - 1) * (this.b + this.d);
        getChildAt(paramInt1).layout(paramInt3, paramInt4, this.a + paramInt3, this.b + paramInt4);
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusListLayout", 2, "onLayout : startX -> " + paramInt3 + ", startY -> " + paramInt4 + ", getRowByChildIndex(i) -> " + a(paramInt1));
        }
        paramInt1 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (i = View.MeasureSpec.getSize(paramInt2);; i = a(i - 1) * (this.b + this.d) - this.d)
    {
      setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), paramInt1), i);
      measureChildren(paramInt1, View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.getMode(paramInt2)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusListLayout
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;

public class LabelContainer
  extends FrameLayout
{
  protected int a;
  protected SparseArray<ArrayList<View>> a;
  protected int b = 0;
  
  public LabelContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public LabelContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < j)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
      if (localArrayList != null)
      {
        int k = localArrayList.size();
        paramInt3 = 0;
        int i = 0;
        paramInt4 = 0;
        while (paramInt3 < k)
        {
          View localView = (View)localArrayList.get(paramInt3);
          i = localView.getMeasuredHeight();
          int m = localView.getMeasuredWidth();
          localView.layout(paramInt4, paramInt2, paramInt4 + m, paramInt2 + i);
          paramInt4 += m + this.jdField_a_of_type_Int;
          paramInt3 += 1;
        }
        paramInt2 += i + this.b;
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    int m = getMeasuredWidth();
    int n = getChildCount();
    int i = 0;
    paramInt1 = 0;
    paramInt2 = 0;
    int j = 0;
    while (i < n)
    {
      View localView = getChildAt(i);
      int k = localView.getMeasuredWidth() + this.jdField_a_of_type_Int;
      paramInt2 += k;
      if (paramInt2 > m)
      {
        j += 1;
        paramInt2 = k;
      }
      ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
      k = paramInt1;
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.jdField_a_of_type_AndroidUtilSparseArray.append(j, localArrayList1);
        k = paramInt1 + (localView.getMeasuredHeight() + this.b);
      }
      localArrayList1.add(localView);
      i += 1;
      paramInt1 = k;
    }
    i = this.b;
    paramInt2 = paramInt1;
    if (paramInt1 > i) {
      paramInt2 = paramInt1 - i;
    }
    setMeasuredDimension(m, paramInt2);
  }
  
  public void setSpace(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.LabelContainer
 * JD-Core Version:    0.7.0.1
 */
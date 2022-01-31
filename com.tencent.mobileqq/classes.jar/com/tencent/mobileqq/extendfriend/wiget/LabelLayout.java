package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import aqiu;
import bdoo;
import java.util.List;

public class LabelLayout
  extends LinearLayout
{
  public LabelLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LabelLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LabelLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setOrientation(0);
  }
  
  public void setLabels(List<aqiu> paramList)
  {
    if (paramList != null)
    {
      removeAllViews();
      int j = bdoo.a(4.0F);
      int k = bdoo.a(1.0F);
      int m = bdoo.a(6.0F);
      int n = bdoo.a(5.0F);
      int i1 = bdoo.a(25.0F);
      int i2 = paramList.size();
      int i = 0;
      while (i < i2)
      {
        Object localObject = (aqiu)paramList.get(i);
        LabelTextView localLabelTextView = new LabelTextView(getContext());
        localLabelTextView.setParam(((aqiu)localObject).jdField_a_of_type_Int, ((aqiu)localObject).b, j);
        localLabelTextView.setTextSize(12);
        localLabelTextView.setText(((aqiu)localObject).jdField_a_of_type_JavaLangString);
        localLabelTextView.setPadding(m, k, m, k);
        localLabelTextView.setMinWidthCheck(i1);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        if (i != 0) {
          ((LinearLayout.LayoutParams)localObject).leftMargin = n;
        }
        addView(localLabelTextView, (ViewGroup.LayoutParams)localObject);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.LabelLayout
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.leba.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class TestFrameLayout
  extends FrameLayout
{
  public TestFrameLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public TestFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TestFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramLayoutParams);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      Object localObject = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      int i = localView.getMeasuredWidth();
      int j = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
      int k = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
      localObject = "";
      if ((localView instanceof TextView)) {
        localObject = ((TextView)localView).getText();
      }
      QLog.e("feilongzou", 1, String.format("v:%s,mw:%d,mh:%d,内容是：%s,background:%s", new Object[] { String.valueOf(localView), Integer.valueOf(i + j + k), Integer.valueOf(localView.getMeasuredHeight()), String.valueOf(localObject), String.valueOf(localView.getBackground()) }));
      paramInt1 += 1;
    }
    QLog.e("feilongzou", 1, String.format("v:%s,mw:%d,mh:%d", new Object[] { String.valueOf(this), Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.TestFrameLayout
 * JD-Core Version:    0.7.0.1
 */
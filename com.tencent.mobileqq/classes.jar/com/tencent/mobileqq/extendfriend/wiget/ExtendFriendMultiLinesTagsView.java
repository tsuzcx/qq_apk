package com.tencent.mobileqq.extendfriend.wiget;

import aekt;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import aoev;
import aqdv;
import aqdw;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ExtendFriendMultiLinesTagsView
  extends ViewGroup
  implements View.OnClickListener
{
  public int a;
  public aqdv a;
  public int b = 30;
  
  public ExtendFriendMultiLinesTagsView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 30;
  }
  
  public ExtendFriendMultiLinesTagsView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 30;
  }
  
  public ExtendFriendMultiLinesTagsView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 30;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof aqdw))
    {
      paramView = (aqdw)paramView.getTag();
      if (this.jdField_a_of_type_Aqdv != null) {
        this.jdField_a_of_type_Aqdv.a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Int);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramInt3 - paramInt1;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendMultiLinesTagsView", 2, "onLayout changed:" + paramBoolean + " left:" + paramInt1 + " top:" + paramInt2 + " right:" + paramInt3 + " bottom:" + paramInt4 + " w:" + j + " h:" + (paramInt4 - paramInt2));
    }
    int k = getChildCount();
    paramInt1 = getPaddingLeft();
    paramInt3 = getPaddingTop();
    paramInt2 = 0;
    while (paramInt2 < k)
    {
      View localView = getChildAt(paramInt2);
      int m = localView.getMeasuredWidth();
      int n = localView.getMeasuredHeight();
      paramInt4 = paramInt3;
      int i = paramInt1;
      if (paramInt1 + m > j - getPaddingRight())
      {
        i = getPaddingLeft();
        paramInt4 = paramInt3 + (this.jdField_a_of_type_Int + n);
      }
      localView.layout(i, paramInt4, i + m, n + paramInt4);
      paramInt1 = this.jdField_a_of_type_Int;
      paramInt2 += 1;
      paramInt1 = paramInt1 + m + i;
      paramInt3 = paramInt4;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    int j = getPaddingTop();
    paramInt1 = getPaddingLeft();
    int i = getPaddingTop();
    int n = getChildCount();
    paramInt2 = 0;
    if (paramInt2 < n)
    {
      View localView = getChildAt(paramInt2);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      if (localLayoutParams.height > 0) {
        localView.measure(0, View.MeasureSpec.makeMeasureSpec(Math.max(0, localLayoutParams.height), 1073741824));
      }
      for (;;)
      {
        int i2 = localView.getMeasuredWidth();
        int i1 = localView.getMeasuredHeight();
        j = i;
        int k = paramInt1;
        if (paramInt1 + i2 > m - getPaddingRight())
        {
          k = getPaddingLeft();
          j = i + (this.jdField_a_of_type_Int + i1);
        }
        paramInt1 = this.jdField_a_of_type_Int;
        paramInt2 += 1;
        paramInt1 = paramInt1 + i2 + k;
        k = j + i1;
        i = j;
        j = k;
        break;
        localView.measure(0, 0);
      }
    }
    paramInt1 = getPaddingBottom() + j;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendMultiLinesTagsView", 2, "onMeasure  measuredWidth:" + m + "  measuredHeight:" + paramInt1);
    }
    setMeasuredDimension(m, paramInt1);
  }
  
  public void setOnItemClickListener(aqdv paramaqdv)
  {
    this.jdField_a_of_type_Aqdv = paramaqdv;
  }
  
  public void setSearchTags(ArrayList<String> paramArrayList)
  {
    if (getChildCount() > 0) {
      removeAllViews();
    }
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    int j = aekt.a(13.0F, getResources());
    int k = aekt.a(26.0F, getResources());
    int i = 0;
    while (i < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i);
      if (!TextUtils.isEmpty(str))
      {
        TextView localTextView = new TextView(getContext());
        localTextView.setText(aoev.a(str, 8.5F));
        localTextView.setTag(new aqdw(this, i, str));
        localTextView.setContentDescription(str);
        localTextView.setOnClickListener(this);
        localTextView.setTextSize(1, 14.0F);
        localTextView.setIncludeFontPadding(false);
        localTextView.setGravity(17);
        localTextView.setClickable(true);
        localTextView.setFocusable(true);
        localTextView.setPadding(j, 0, j, 0);
        localTextView.setBackgroundResource(2130844708);
        localTextView.setTextColor(getResources().getColorStateList(2131166268));
        localTextView.setEllipsize(TextUtils.TruncateAt.END);
        localTextView.setSingleLine();
        localTextView.setMaxLines(1);
        addView(localTextView, new ViewGroup.LayoutParams(-2, k));
      }
      i += 1;
    }
    requestLayout();
  }
  
  public void setViewMargin(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendMultiLinesTagsView
 * JD-Core Version:    0.7.0.1
 */
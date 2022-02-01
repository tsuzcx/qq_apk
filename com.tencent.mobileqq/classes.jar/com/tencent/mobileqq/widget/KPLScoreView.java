package com.tencent.mobileqq.widget;

import afur;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class KPLScoreView
  extends LinearLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  
  public KPLScoreView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public KPLScoreView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561214, this, true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371499));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379734));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378092));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131379737));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375940));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131379735));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376820));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131379736));
  }
  
  public void setKplValue(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i;
    int j;
    label30:
    int k;
    if (paramString1.length() > 0)
    {
      i = paramString1.length() - 1;
      if (paramString2.length() <= 0) {
        break label487;
      }
      j = paramString2.length() - 1;
      if (paramString3.length() <= 0) {
        break label493;
      }
      k = paramString3.length() - 1;
      label45:
      if (paramString4.length() <= 0) {
        break label499;
      }
    }
    label487:
    label493:
    label499:
    for (int m = paramString4.length() - 1;; m = 0)
    {
      paramString1 = new SpannableString(paramString1);
      paramString2 = new SpannableString(paramString2);
      paramString3 = new SpannableString(paramString3);
      paramString4 = new SpannableString(paramString4);
      AbsoluteSizeSpan localAbsoluteSizeSpan1 = new AbsoluteSizeSpan(27, true);
      AbsoluteSizeSpan localAbsoluteSizeSpan2 = new AbsoluteSizeSpan(14, true);
      StyleSpan localStyleSpan = new StyleSpan(1);
      paramString1.setSpan(localAbsoluteSizeSpan1, 0, i, 17);
      paramString1.setSpan(localAbsoluteSizeSpan2, i, i + 1, 17);
      paramString1.setSpan(localStyleSpan, 0, i, 17);
      paramString2.setSpan(localAbsoluteSizeSpan1, 0, j, 17);
      paramString2.setSpan(localAbsoluteSizeSpan2, j, j + 1, 17);
      paramString2.setSpan(localStyleSpan, 0, j, 17);
      paramString3.setSpan(localAbsoluteSizeSpan1, 0, k, 17);
      paramString3.setSpan(localAbsoluteSizeSpan2, k, k + 1, 17);
      paramString3.setSpan(localStyleSpan, 0, k, 17);
      paramString4.setSpan(localAbsoluteSizeSpan1, 0, m, 17);
      paramString4.setSpan(localAbsoluteSizeSpan2, m, m + 1, 17);
      paramString4.setSpan(localStyleSpan, 0, m, 17);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString3);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString4);
      this.jdField_a_of_type_AndroidWidgetTextView.measure(0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.measure(0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.measure(0, 0);
      this.jdField_d_of_type_AndroidWidgetTextView.measure(0, 0);
      i = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
      j = this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth();
      k = this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredWidth();
      m = this.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth();
      i = (((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay().getWidth() - (i + j + k + m) - afur.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 3;
      paramString1 = new LinearLayout.LayoutParams(-2, -2);
      paramString1.setMargins(i, 0, 0, 0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramString1);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramString1);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramString1);
      return;
      i = 0;
      break;
      j = 0;
      break label30;
      k = 0;
      break label45;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.KPLScoreView
 * JD-Core Version:    0.7.0.1
 */
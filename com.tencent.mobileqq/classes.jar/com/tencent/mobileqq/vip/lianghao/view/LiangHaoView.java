package com.tencent.mobileqq.vip.lianghao.view;

import aepi;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import becg;
import com.tencent.common.app.BaseApplicationImpl;

public class LiangHaoView
  extends LinearLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public becg a;
  
  public LiangHaoView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LiangHaoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LiangHaoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setOrientation(0);
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130846711);
    int i = aepi.a(12.0F, getResources());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.rightMargin = aepi.a(5.0F, getResources());
    localLayoutParams.gravity = 16;
    addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 21.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8947849);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (!paramBoolean) {}
    for (float f = 0.5F;; f = 1.0F)
    {
      setAlpha(f);
      return;
    }
  }
  
  public void setUin(becg parambecg)
  {
    int j = 0;
    if ((parambecg == null) || (TextUtils.isEmpty(parambecg.a))) {
      return;
    }
    this.jdField_a_of_type_Becg = parambecg;
    SpannableString localSpannableString = new SpannableString(parambecg.a);
    int i;
    if (TextUtils.isEmpty(parambecg.b)) {
      i = -1;
    }
    for (;;)
    {
      if (j != 0) {
        localSpannableString.setSpan(new ForegroundColorSpan(-31676), i, parambecg.b.length() + i, 18);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableString);
      setContentDescription(BaseApplicationImpl.getApplication().getString(2131693892) + " " + parambecg.a);
      return;
      i = parambecg.a.indexOf(parambecg.b);
      if (i >= 0) {
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.LiangHaoView
 * JD-Core Version:    0.7.0.1
 */
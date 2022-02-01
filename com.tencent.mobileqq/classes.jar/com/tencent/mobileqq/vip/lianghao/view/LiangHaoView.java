package com.tencent.mobileqq.vip.lianghao.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import biaq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class LiangHaoView
  extends LinearLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public biaq a;
  
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
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130847182);
    int i = AIOUtils.dp2px(12.0F, getResources());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.rightMargin = AIOUtils.dp2px(5.0F, getResources());
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
  
  public void setUin(biaq parambiaq)
  {
    int j = 0;
    if ((parambiaq == null) || (TextUtils.isEmpty(parambiaq.a))) {
      return;
    }
    this.jdField_a_of_type_Biaq = parambiaq;
    SpannableString localSpannableString = new SpannableString(parambiaq.a);
    int i;
    if (TextUtils.isEmpty(parambiaq.b)) {
      i = -1;
    }
    for (;;)
    {
      if (j != 0) {
        localSpannableString.setSpan(new ForegroundColorSpan(-31676), i, parambiaq.b.length() + i, 18);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableString);
      setContentDescription(BaseApplicationImpl.getApplication().getString(2131693502) + " " + parambiaq.a);
      return;
      i = parambiaq.a.indexOf(parambiaq.b);
      if (i >= 0) {
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.LiangHaoView
 * JD-Core Version:    0.7.0.1
 */
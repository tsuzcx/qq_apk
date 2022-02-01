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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vip.lianghao.data.LiangHaoUinData;

public class LiangHaoView
  extends LinearLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public LiangHaoUinData a;
  
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
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130847407);
    int i = Utils.a(12.0F, getResources());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
    localLayoutParams.rightMargin = Utils.a(5.0F, getResources());
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
    float f;
    if (!paramBoolean) {
      f = 0.5F;
    } else {
      f = 1.0F;
    }
    setAlpha(f);
  }
  
  public void setUin(LiangHaoUinData paramLiangHaoUinData)
  {
    if (paramLiangHaoUinData != null)
    {
      if (TextUtils.isEmpty(paramLiangHaoUinData.a)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoDataLiangHaoUinData = paramLiangHaoUinData;
      Object localObject = new SpannableString(paramLiangHaoUinData.a);
      int i = -1;
      boolean bool = TextUtils.isEmpty(paramLiangHaoUinData.b);
      int j = 0;
      if (!bool)
      {
        i = paramLiangHaoUinData.a.indexOf(paramLiangHaoUinData.b);
        if (i >= 0) {
          j = 1;
        }
      }
      if (j != 0) {
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-31676), i, paramLiangHaoUinData.b.length() + i, 18);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131693611));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramLiangHaoUinData.a);
      setContentDescription(((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.LiangHaoView
 * JD-Core Version:    0.7.0.1
 */
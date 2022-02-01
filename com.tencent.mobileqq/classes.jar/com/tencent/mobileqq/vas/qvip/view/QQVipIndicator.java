package com.tencent.mobileqq.vas.qvip.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup.LayoutParams;
import bhsl;
import bhsm;
import com.tencent.av.ui.MultiMembersAudioIndicator;

public class QQVipIndicator
  extends MultiMembersAudioIndicator
{
  private bhsm a;
  
  public QQVipIndicator(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQVipIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RadioButton a()
  {
    bhsl localbhsl = new bhsl(this, super.getContext());
    localbhsl.setButtonDrawable(2130846946);
    localbhsl.setGravity(17);
    Resources localResources = super.getContext().getResources();
    RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams((int)TypedValue.applyDimension(1, 6.0F, localResources.getDisplayMetrics()), (int)TypedValue.applyDimension(1, 6.0F, localResources.getDisplayMetrics()));
    localLayoutParams.gravity = 17;
    int i = (int)TypedValue.applyDimension(1, 2.0F, localResources.getDisplayMetrics());
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localbhsl.setLayoutParams(localLayoutParams);
    localbhsl.setClickable(false);
    localbhsl.setFocusable(false);
    return localbhsl;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_Bhsm != null) {
      this.jdField_a_of_type_Bhsm.a(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) {
      break label7;
    }
    label7:
    while ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter() == null) || (super.getChildCount() <= paramInt)) {
      return;
    }
    if (paramInt >= super.getChildCount()) {}
    for (int i = super.getChildCount() - 1;; i = paramInt)
    {
      RadioButton localRadioButton = (RadioButton)super.getChildAt(i);
      if (localRadioButton != null) {
        localRadioButton.setChecked(true);
      }
      if (this.jdField_a_of_type_Bhsm == null) {
        break;
      }
      this.jdField_a_of_type_Bhsm.a(paramInt);
      return;
    }
  }
  
  public void setCurrentIndex(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= super.getChildCount()) {
      i = super.getChildCount() - 1;
    }
    RadioButton localRadioButton = (RadioButton)super.getChildAt(i);
    if (localRadioButton != null) {
      localRadioButton.setChecked(true);
    }
  }
  
  public void setPageListener(bhsm parambhsm)
  {
    this.jdField_a_of_type_Bhsm = parambhsm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.QQVipIndicator
 * JD-Core Version:    0.7.0.1
 */
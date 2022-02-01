package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup.LayoutParams;
import avna;
import avnb;
import com.tencent.av.ui.MultiMembersAudioIndicator;

public class QQGameIndicator
  extends MultiMembersAudioIndicator
{
  private avnb a;
  
  public QQGameIndicator(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQGameIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RadioButton a()
  {
    avna localavna = new avna(this, super.getContext());
    localavna.setButtonDrawable(2130846250);
    localavna.setGravity(17);
    Resources localResources = super.getContext().getResources();
    RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams((int)TypedValue.applyDimension(1, 6.0F, localResources.getDisplayMetrics()), (int)TypedValue.applyDimension(1, 6.0F, localResources.getDisplayMetrics()));
    localLayoutParams.gravity = 17;
    int i = (int)TypedValue.applyDimension(1, 2.0F, localResources.getDisplayMetrics());
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localavna.setLayoutParams(localLayoutParams);
    localavna.setClickable(false);
    localavna.setFocusable(false);
    return localavna;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_Avnb != null) {
      this.jdField_a_of_type_Avnb.a(paramInt1, paramFloat, paramInt2);
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
      if (this.jdField_a_of_type_Avnb == null) {
        break;
      }
      this.jdField_a_of_type_Avnb.a(paramInt);
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
  
  public void setPageListener(avnb paramavnb)
  {
    this.jdField_a_of_type_Avnb = paramavnb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.QQGameIndicator
 * JD-Core Version:    0.7.0.1
 */
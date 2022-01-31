package com.tencent.mobileqq.leba.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class LebaFeedsViewImage1
  extends LebaFeedsImageViewBase
{
  public LebaFeedsViewImage1(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  protected void b()
  {
    int i = getResources().getDisplayMetrics().widthPixels - (int)(40.0F * getResources().getDisplayMetrics().density);
    int j = (int)(1.0F * i / 16.0F * 9.0F);
    this.jdField_a_of_type_Int = i;
    this.b = j;
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsGridLayout.setRowItemCount(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaFeedsViewImage1
 * JD-Core Version:    0.7.0.1
 */
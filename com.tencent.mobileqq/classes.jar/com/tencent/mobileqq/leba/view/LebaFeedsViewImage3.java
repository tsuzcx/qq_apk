package com.tencent.mobileqq.leba.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class LebaFeedsViewImage3
  extends LebaFeedsImageViewBase
{
  public LebaFeedsViewImage3(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 3;
  }
  
  protected void b()
  {
    int i = (int)((getResources().getDisplayMetrics().widthPixels - 44.0F * getResources().getDisplayMetrics().density) / 3.0F);
    this.jdField_a_of_type_Int = i;
    this.b = i;
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsGridLayout.setRowItemCount(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaFeedsViewImage3
 * JD-Core Version:    0.7.0.1
 */
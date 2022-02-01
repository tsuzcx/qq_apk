package com.tencent.mobileqq.troop.activity;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.open.base.ImageUtil;

class TroopCreateLogicActivity$5
  implements URLDrawable.URLDrawableListener
{
  TroopCreateLogicActivity$5(TroopCreateLogicActivity paramTroopCreateLogicActivity, URLDrawable paramURLDrawable, TroopCreateLogicActivity.OnGetBitmapCallback paramOnGetBitmapCallback) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateLogicActivity$OnGetBitmapCallback.a(null);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateLogicActivity$OnGetBitmapCallback.a(null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ImageUtil.a(this.jdField_a_of_type_ComTencentImageURLDrawable, 100, 100);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateLogicActivity$OnGetBitmapCallback.a(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity.5
 * JD-Core Version:    0.7.0.1
 */
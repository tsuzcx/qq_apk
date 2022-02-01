package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class FavEmosmViewPage$1
  implements QQPermissionCallback
{
  FavEmosmViewPage$1(FavEmosmViewPage paramFavEmosmViewPage) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQIphoneTitleBarActivity);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.h();
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavEmosmViewPage.1
 * JD-Core Version:    0.7.0.1
 */
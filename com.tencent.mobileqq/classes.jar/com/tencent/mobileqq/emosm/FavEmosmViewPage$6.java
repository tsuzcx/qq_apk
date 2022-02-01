package com.tencent.mobileqq.emosm;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.qphone.base.util.QLog;

class FavEmosmViewPage$6
  implements URLDrawableDownListener
{
  FavEmosmViewPage$6(FavEmosmViewPage paramFavEmosmViewPage, EmoticonInfo paramEmoticonInfo, FavEmosmViewPage.Holder paramHolder) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadFailed: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo.toString());
    FavEmosmViewPage.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage, this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$Holder.a, this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$Holder);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadFailed: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo.toString());
    FavEmosmViewPage.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage, this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$Holder.a, this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$Holder);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadInterrupted: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo.toString());
    FavEmosmViewPage.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage, this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$Holder.a, this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$Holder);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavEmosmViewPage", 2, "onLoadProgressed: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo.toString());
    }
    FavEmosmViewPage.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage, this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$Holder.a, this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$Holder);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavEmosmViewPage", 2, "onLoadSuccess: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo.toString());
    }
    FavEmosmViewPage.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage, this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$Holder.a, this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage$Holder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavEmosmViewPage.6
 * JD-Core Version:    0.7.0.1
 */
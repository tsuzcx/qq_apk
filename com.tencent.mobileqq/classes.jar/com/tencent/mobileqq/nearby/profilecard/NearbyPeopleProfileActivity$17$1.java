package com.tencent.mobileqq.nearby.profilecard;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class NearbyPeopleProfileActivity$17$1
  implements URLDrawable.URLDrawableListener
{
  NearbyPeopleProfileActivity$17$1(NearbyPeopleProfileActivity.17 param17, ImageView paramImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeopleProfileActivity", 2, "download vote onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeopleProfileActivity", 2, "download vote onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeopleProfileActivity", 2, "download vote onLoadProgressed");
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeopleProfileActivity", 2, "download vote headImage success");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$17.a.showVoteUpdateDialog(this.jdField_a_of_type_AndroidWidgetImageView, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.17.1
 * JD-Core Version:    0.7.0.1
 */
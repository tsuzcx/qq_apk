package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class FavroamingManager$2$1
  implements Runnable
{
  FavroamingManager$2$1(FavroamingManager.2 param2, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavEmoRoamingObserver", 2, "start upload and download fav");
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$2.a.b(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$2.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.2.1
 * JD-Core Version:    0.7.0.1
 */
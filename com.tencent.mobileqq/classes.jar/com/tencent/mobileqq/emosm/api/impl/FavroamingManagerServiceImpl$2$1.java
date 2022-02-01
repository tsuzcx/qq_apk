package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class FavroamingManagerServiceImpl$2$1
  implements Runnable
{
  FavroamingManagerServiceImpl$2$1(FavroamingManagerServiceImpl.2 param2, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavEmoRoamingObserver", 2, "start upload and download fav");
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplFavroamingManagerServiceImpl$2.a.syncUpload(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplFavroamingManagerServiceImpl$2.a.downLoadEmo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.2.1
 * JD-Core Version:    0.7.0.1
 */
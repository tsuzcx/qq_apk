package com.tencent.mobileqq.emosm.favroaming;

import arbb;
import arbd;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FavroamingManager$2$1
  implements Runnable
{
  public FavroamingManager$2$1(arbd paramarbd, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavEmoRoamingObserver", 2, "start upload and download fav");
    }
    this.jdField_a_of_type_Arbd.a.b(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Arbd.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.2.1
 * JD-Core Version:    0.7.0.1
 */
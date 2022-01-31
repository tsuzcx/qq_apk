package com.tencent.mobileqq.emoticonview;

import ansa;
import anyn;
import bcpw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.qphone.base.util.QLog;

public class EmoticonMainPanel$22$1
  implements Runnable
{
  public EmoticonMainPanel$22$1(anyn paramanyn, Object paramObject) {}
  
  public void run()
  {
    int i = ((Integer)this.jdField_a_of_type_JavaLangObject).intValue();
    switch (i)
    {
    default: 
      i = 0;
      if (i != 0) {
        bcpw.a(BaseApplicationImpl.sApplication, 1, i, 0).b(this.jdField_a_of_type_Anyn.a.g);
      }
      break;
    }
    do
    {
      return;
      i = 2131692011;
      break;
      i = 2131692013;
      break;
      i = 2131692015;
      break;
      i = 2131692014;
      break;
      i = 2131692010;
      break;
      i = 2131692012;
      break;
      QLog.e("FavEmoRoamingObserver", 1, new Object[] { "update panel, over limit flag:", Boolean.valueOf(CameraEmoAllSend.b), " ret:", Integer.valueOf(i), " isResumed:", Boolean.valueOf(EmoticonMainPanel.b(this.jdField_a_of_type_Anyn.a)) });
    } while ((CameraEmoAllSend.b) || (!EmoticonMainPanel.b(this.jdField_a_of_type_Anyn.a)));
    CameraEmoAllSend.b = true;
    if (i == 7) {}
    for (i = 1;; i = 2)
    {
      ansa.a(this.jdField_a_of_type_Anyn.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Anyn.a.jdField_a_of_type_AndroidContentContext, i);
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.22.1
 * JD-Core Version:    0.7.0.1
 */
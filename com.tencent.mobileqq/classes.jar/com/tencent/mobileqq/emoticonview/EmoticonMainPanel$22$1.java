package com.tencent.mobileqq.emoticonview;

import anbp;
import anie;
import bbmy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.qphone.base.util.QLog;

public class EmoticonMainPanel$22$1
  implements Runnable
{
  public EmoticonMainPanel$22$1(anie paramanie, Object paramObject) {}
  
  public void run()
  {
    int i = ((Integer)this.jdField_a_of_type_JavaLangObject).intValue();
    switch (i)
    {
    default: 
      i = 0;
      if (i != 0) {
        bbmy.a(BaseApplicationImpl.sApplication, 1, i, 0).b(this.jdField_a_of_type_Anie.a.g);
      }
      break;
    }
    do
    {
      return;
      i = 2131626425;
      break;
      i = 2131626427;
      break;
      i = 2131626429;
      break;
      i = 2131626428;
      break;
      i = 2131626424;
      break;
      i = 2131626426;
      break;
      QLog.e("FavEmoRoamingObserver", 1, new Object[] { "update panel, over limit flag:", Boolean.valueOf(CameraEmoAllSend.b), " ret:", Integer.valueOf(i), " isResumed:", Boolean.valueOf(EmoticonMainPanel.b(this.jdField_a_of_type_Anie.a)) });
    } while ((CameraEmoAllSend.b) || (!EmoticonMainPanel.b(this.jdField_a_of_type_Anie.a)));
    CameraEmoAllSend.b = true;
    if (i == 7) {}
    for (i = 1;; i = 2)
    {
      anbp.a(this.jdField_a_of_type_Anie.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Anie.a.jdField_a_of_type_AndroidContentContext, i);
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.22.1
 * JD-Core Version:    0.7.0.1
 */
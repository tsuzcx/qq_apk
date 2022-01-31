package com.tencent.mobileqq.emoticonview;

import apnw;
import apvd;
import apvf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class EmoticonPanelFavHelper$5$1
  implements Runnable
{
  public EmoticonPanelFavHelper$5$1(apvf paramapvf, Object paramObject) {}
  
  public void run()
  {
    int i = ((Integer)this.jdField_a_of_type_JavaLangObject).intValue();
    switch (i)
    {
    default: 
      i = 0;
      if (i != 0) {
        QQToast.a(BaseApplicationImpl.sApplication, 1, i, 0).b(this.jdField_a_of_type_Apvf.a.a.f);
      }
      break;
    }
    do
    {
      return;
      i = 2131692067;
      break;
      i = 2131692069;
      break;
      i = 2131692071;
      break;
      i = 2131692070;
      break;
      i = 2131692066;
      break;
      i = 2131692068;
      break;
      QLog.e("FavEmoRoamingObserver", 1, new Object[] { "update panel, over limit flag:", Boolean.valueOf(CameraEmoAllSend.b), " ret:", Integer.valueOf(i), " isResumed:", Boolean.valueOf(this.jdField_a_of_type_Apvf.a.a.j) });
    } while ((CameraEmoAllSend.b) || (!this.jdField_a_of_type_Apvf.a.a.j));
    CameraEmoAllSend.b = true;
    if (i == 7) {}
    for (i = 1;; i = 2)
    {
      apnw.a(this.jdField_a_of_type_Apvf.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apvf.a.a.jdField_a_of_type_AndroidContentContext, i);
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.5.1
 * JD-Core Version:    0.7.0.1
 */
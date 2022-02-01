package com.tencent.mobileqq.emoticonview;

import arqx;
import aryf;
import aryh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class EmoticonPanelFavHelper$5$1
  implements Runnable
{
  public EmoticonPanelFavHelper$5$1(aryh paramaryh, Object paramObject) {}
  
  public void run()
  {
    int i = ((Integer)this.jdField_a_of_type_JavaLangObject).intValue();
    switch (i)
    {
    default: 
      i = 0;
      if (i != 0) {
        QQToast.a(BaseApplicationImpl.sApplication, 1, i, 0).b(this.jdField_a_of_type_Aryh.a.a.f);
      }
      break;
    }
    do
    {
      return;
      i = 2131691719;
      break;
      i = 2131691721;
      break;
      i = 2131691723;
      break;
      i = 2131691722;
      break;
      i = 2131691718;
      break;
      i = 2131691720;
      break;
      QLog.e("FavEmoRoamingObserver", 1, new Object[] { "update panel, over limit flag:", Boolean.valueOf(CameraEmoAllSend.b), " ret:", Integer.valueOf(i), " isResumed:", Boolean.valueOf(this.jdField_a_of_type_Aryh.a.a.j) });
    } while ((CameraEmoAllSend.b) || (!this.jdField_a_of_type_Aryh.a.a.j));
    CameraEmoAllSend.b = true;
    if (i == 7) {}
    for (i = 1;; i = 2)
    {
      arqx.b(this.jdField_a_of_type_Aryh.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aryh.a.a.jdField_a_of_type_AndroidContentContext, i);
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.5.1
 * JD-Core Version:    0.7.0.1
 */
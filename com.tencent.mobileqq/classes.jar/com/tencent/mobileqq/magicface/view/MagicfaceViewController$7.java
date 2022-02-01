package com.tencent.mobileqq.magicface.view;

import android.os.Handler;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.MagicfaceActionListener;
import com.tencent.qphone.base.util.QLog;

class MagicfaceViewController$7
  implements MagicfaceActionManager.MagicfaceActionListener
{
  MagicfaceViewController$7(MagicfaceViewController paramMagicfaceViewController, long paramLong, int paramInt) {}
  
  public void a(ActionGlobalData paramActionGlobalData)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("【magicface】 cost =");
      localStringBuilder.append(l1 - l2);
      localStringBuilder.append("ms");
      QLog.d("MagicfaceViewController", 2, localStringBuilder.toString());
    }
    boolean bool;
    if (this.jdField_a_of_type_Int == 0)
    {
      bool = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c(bool);
    }
    else
    {
      bool = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c(bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_AndroidOsHandler.post(new MagicfaceViewController.7.1(this, paramActionGlobalData));
  }
  
  public void b(ActionGlobalData paramActionGlobalData)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_AndroidOsHandler.post(new MagicfaceViewController.7.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.7
 * JD-Core Version:    0.7.0.1
 */
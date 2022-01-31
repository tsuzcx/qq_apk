package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import apqz;
import aprc;
import apsm;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonPanelMallHelper$4$1
  implements Runnable
{
  public EmoticonPanelMallHelper$4$1(aprc paramaprc, EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Aprc.a.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter;
    if (localObject != null) {
      ((EmotionPanelViewPagerAdapter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.extraFlags & 0x2) > 0) && (this.jdField_a_of_type_Int == 0))
    {
      this.jdField_a_of_type_Aprc.a.a.a().i = false;
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.extraFlags &= 0xFFFFFFFD;
      this.jdField_a_of_type_Aprc.a.a.d(EmoticonPanelController.jdField_b_of_type_Int);
    }
    label98:
    do
    {
      do
      {
        break label98;
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 3) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 5));
        if (this.jdField_a_of_type_Int != 0) {
          break;
        }
        if (this.jdField_a_of_type_Aprc.a.a.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage))
        {
          this.jdField_a_of_type_Aprc.a.a.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
          return;
        }
        this.jdField_a_of_type_Aprc.a.a.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Aprc.a.a.a().i = false;
        this.jdField_a_of_type_Aprc.a.a.d = false;
      } while ((this.jdField_a_of_type_Aprc.a.a.a().getVisibility() != 0) || (this.jdField_a_of_type_Aprc.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelMallHelper", 2, "Emoticon pkg downloaded in panel, refresh");
      }
      localObject = this.jdField_a_of_type_Aprc.a.a.jdField_b_of_type_JavaUtilList;
    } while (localObject == null);
    int i = 0;
    label291:
    if (i < ((List)localObject).size())
    {
      EmoticonPackage localEmoticonPackage = ((apsm)((List)localObject).get(i)).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      if ((localEmoticonPackage == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(localEmoticonPackage.epId))) {}
    }
    for (;;)
    {
      int j = i;
      if (this.jdField_a_of_type_Aprc.a.a.i)
      {
        j = i;
        if (EmoticonPanelController.jdField_b_of_type_Int >= 0) {
          j = EmoticonPanelController.jdField_b_of_type_Int;
        }
      }
      this.jdField_a_of_type_Aprc.a.a.d(j);
      this.jdField_a_of_type_Aprc.a.a.c = false;
      return;
      i += 1;
      break label291;
      if (this.jdField_a_of_type_Int == 11000)
      {
        QQToast.a(this.jdField_a_of_type_Aprc.a.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aprc.a.a.jdField_a_of_type_AndroidContentContext.getString(2131689995), 1).b(this.jdField_a_of_type_Aprc.a.a.f);
        return;
      }
      if (this.jdField_a_of_type_Int != 11001) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_Aprc.a.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aprc.a.a.jdField_a_of_type_AndroidContentContext.getString(2131689996), 1).b(this.jdField_a_of_type_Aprc.a.a.f);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.4.1
 * JD-Core Version:    0.7.0.1
 */
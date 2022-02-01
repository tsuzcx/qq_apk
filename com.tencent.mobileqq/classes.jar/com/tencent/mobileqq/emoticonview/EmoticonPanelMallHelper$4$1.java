package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import aryo;
import aryr;
import asaf;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonPanelMallHelper$4$1
  implements Runnable
{
  public EmoticonPanelMallHelper$4$1(aryr paramaryr, EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Aryr.a.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter;
    if (localObject != null) {
      ((EmotionPanelViewPagerAdapter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.extraFlags & 0x2) > 0) && (this.jdField_a_of_type_Int == 0))
    {
      this.jdField_a_of_type_Aryr.a.a.a().i = false;
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.extraFlags &= 0xFFFFFFFD;
      this.jdField_a_of_type_Aryr.a.a.d(EmoticonPanelController.jdField_b_of_type_Int);
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
        if (this.jdField_a_of_type_Aryr.a.a.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage))
        {
          this.jdField_a_of_type_Aryr.a.a.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
          return;
        }
        this.jdField_a_of_type_Aryr.a.a.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Aryr.a.a.a().i = false;
        this.jdField_a_of_type_Aryr.a.a.d = false;
      } while ((this.jdField_a_of_type_Aryr.a.a.a().getVisibility() != 0) || (this.jdField_a_of_type_Aryr.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelMallHelper", 2, "Emoticon pkg downloaded in panel, refresh");
      }
      localObject = this.jdField_a_of_type_Aryr.a.a.jdField_b_of_type_JavaUtilList;
    } while (localObject == null);
    int j = 0;
    label291:
    if (j < ((List)localObject).size())
    {
      EmoticonPackage localEmoticonPackage = ((asaf)((List)localObject).get(j)).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      if ((localEmoticonPackage == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(localEmoticonPackage.epId))) {}
    }
    for (;;)
    {
      int i = j;
      if (this.jdField_a_of_type_Aryr.a.a.i)
      {
        i = j;
        if (EmoticonPanelController.jdField_b_of_type_Int >= 0) {
          i = EmoticonPanelController.jdField_b_of_type_Int;
        }
      }
      j = this.jdField_a_of_type_Aryr.a.a.a(12);
      if (EmoticonPanelController.jdField_b_of_type_Int == j) {
        i = j;
      }
      this.jdField_a_of_type_Aryr.a.a.d(i);
      this.jdField_a_of_type_Aryr.a.a.c = false;
      return;
      j += 1;
      break label291;
      if (this.jdField_a_of_type_Int == 11000)
      {
        QQToast.a(this.jdField_a_of_type_Aryr.a.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aryr.a.a.jdField_a_of_type_AndroidContentContext.getString(2131689889), 1).b(this.jdField_a_of_type_Aryr.a.a.f);
        return;
      }
      if (this.jdField_a_of_type_Int != 11001) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_Aryr.a.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aryr.a.a.jdField_a_of_type_AndroidContentContext.getString(2131689890), 1).b(this.jdField_a_of_type_Aryr.a.a.f);
      return;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.4.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import ania;
import ankb;
import bbmy;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonMainPanel$17$1
  implements Runnable
{
  public EmoticonMainPanel$17$1(ania paramania, EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Ania.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter;
    if (localObject != null) {
      ((EmotionPanelViewPagerAdapter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.extraFlags & 0x2) > 0) && (this.jdField_a_of_type_Int == 0))
    {
      this.jdField_a_of_type_Ania.a.k = false;
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.extraFlags &= 0xFFFFFFFD;
      this.jdField_a_of_type_Ania.a.d(EmoticonMainPanel.c);
    }
    label86:
    do
    {
      do
      {
        break label86;
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 3) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 5));
        if (this.jdField_a_of_type_Int != 0) {
          break;
        }
        if (this.jdField_a_of_type_Ania.a.b.contains(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage))
        {
          this.jdField_a_of_type_Ania.a.b.remove(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
          return;
        }
        this.jdField_a_of_type_Ania.a.h = false;
        this.jdField_a_of_type_Ania.a.k = false;
        this.jdField_a_of_type_Ania.a.j = false;
      } while ((this.jdField_a_of_type_Ania.a.getVisibility() != 0) || (this.jdField_a_of_type_Ania.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "Emoticon pkg downloaded in panel, refresh");
      }
      localObject = this.jdField_a_of_type_Ania.a.jdField_a_of_type_JavaUtilList;
    } while (localObject == null);
    int i = 0;
    label249:
    if (i < ((List)localObject).size())
    {
      EmoticonPackage localEmoticonPackage = ((ankb)((List)localObject).get(i)).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      if ((localEmoticonPackage == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(localEmoticonPackage.epId))) {}
    }
    for (;;)
    {
      int j = i;
      if (EmoticonMainPanel.a(this.jdField_a_of_type_Ania.a))
      {
        j = i;
        if (EmoticonMainPanel.c >= 0) {
          j = EmoticonMainPanel.c;
        }
      }
      this.jdField_a_of_type_Ania.a.d(j);
      this.jdField_a_of_type_Ania.a.i = false;
      return;
      i += 1;
      break label249;
      if (this.jdField_a_of_type_Int == 11000)
      {
        bbmy.a(this.jdField_a_of_type_Ania.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ania.a.jdField_a_of_type_AndroidContentContext.getString(2131624400), 1).b(this.jdField_a_of_type_Ania.a.g);
        return;
      }
      if (this.jdField_a_of_type_Int != 11001) {
        break;
      }
      bbmy.a(this.jdField_a_of_type_Ania.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ania.a.jdField_a_of_type_AndroidContentContext.getString(2131624401), 1).b(this.jdField_a_of_type_Ania.a.g);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.17.1
 * JD-Core Version:    0.7.0.1
 */
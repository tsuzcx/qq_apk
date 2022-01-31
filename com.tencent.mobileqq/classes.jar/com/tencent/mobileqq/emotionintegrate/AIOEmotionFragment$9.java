package com.tencent.mobileqq.emotionintegrate;

import aodt;
import aodu;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AIOEmotionFragment$9
  implements Runnable
{
  AIOEmotionFragment$9(AIOEmotionFragment paramAIOEmotionFragment, List paramList, aodt paramaodt) {}
  
  public void run()
  {
    boolean bool = false;
    this.this$0.jdField_a_of_type_Aodu.a(this.jdField_a_of_type_JavaUtilList);
    this.this$0.jdField_a_of_type_Aodu.notifyDataSetChanged();
    if (this.jdField_a_of_type_Aodt != null) {}
    for (int i = this.this$0.jdField_a_of_type_Aodu.a(this.jdField_a_of_type_Aodt);; i = 0)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSelection(i);
      if (QLog.isColorLevel())
      {
        if (this.jdField_a_of_type_Aodt == null) {
          bool = true;
        }
        QLog.d("AIOEmotionFragment", 2, new Object[] { "mGallery setSelection pos:", Integer.valueOf(i), " dataIsNull:", Boolean.valueOf(bool) });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.9
 * JD-Core Version:    0.7.0.1
 */
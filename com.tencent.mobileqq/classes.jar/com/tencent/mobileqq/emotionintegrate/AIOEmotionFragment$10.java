package com.tencent.mobileqq.emotionintegrate;

import apvv;
import apvw;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AIOEmotionFragment$10
  implements Runnable
{
  AIOEmotionFragment$10(AIOEmotionFragment paramAIOEmotionFragment, List paramList, apvv paramapvv) {}
  
  public void run()
  {
    boolean bool = false;
    this.this$0.jdField_a_of_type_Apvw.a(this.jdField_a_of_type_JavaUtilList);
    this.this$0.jdField_a_of_type_Apvw.notifyDataSetChanged();
    if (this.jdField_a_of_type_Apvv != null) {}
    for (int i = this.this$0.jdField_a_of_type_Apvw.a(this.jdField_a_of_type_Apvv);; i = 0)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSelection(i);
      if (QLog.isColorLevel())
      {
        if (this.jdField_a_of_type_Apvv == null) {
          bool = true;
        }
        QLog.d("AIOEmotionFragment", 2, new Object[] { "mGallery setSelection pos:", Integer.valueOf(i), " dataIsNull:", Boolean.valueOf(bool) });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.10
 * JD-Core Version:    0.7.0.1
 */
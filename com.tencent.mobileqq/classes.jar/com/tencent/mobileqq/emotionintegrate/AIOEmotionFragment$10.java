package com.tencent.mobileqq.emotionintegrate;

import argg;
import argh;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AIOEmotionFragment$10
  implements Runnable
{
  AIOEmotionFragment$10(AIOEmotionFragment paramAIOEmotionFragment, List paramList, argg paramargg) {}
  
  public void run()
  {
    boolean bool = false;
    this.this$0.jdField_a_of_type_Argh.a(this.jdField_a_of_type_JavaUtilList);
    this.this$0.jdField_a_of_type_Argh.notifyDataSetChanged();
    if (this.jdField_a_of_type_Argg != null) {}
    for (int i = this.this$0.jdField_a_of_type_Argh.a(this.jdField_a_of_type_Argg);; i = 0)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSelection(i);
      if (QLog.isColorLevel())
      {
        if (this.jdField_a_of_type_Argg == null) {
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
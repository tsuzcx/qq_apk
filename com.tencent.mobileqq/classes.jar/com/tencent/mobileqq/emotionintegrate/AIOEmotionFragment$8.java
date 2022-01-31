package com.tencent.mobileqq.emotionintegrate;

import annd;
import anne;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AIOEmotionFragment$8
  implements Runnable
{
  AIOEmotionFragment$8(AIOEmotionFragment paramAIOEmotionFragment, List paramList, annd paramannd) {}
  
  public void run()
  {
    boolean bool = false;
    this.this$0.jdField_a_of_type_Anne.a(this.jdField_a_of_type_JavaUtilList);
    this.this$0.jdField_a_of_type_Anne.notifyDataSetChanged();
    if (this.jdField_a_of_type_Annd != null) {}
    for (int i = this.this$0.jdField_a_of_type_Anne.a(this.jdField_a_of_type_Annd);; i = 0)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSelection(i);
      if (QLog.isColorLevel())
      {
        if (this.jdField_a_of_type_Annd == null) {
          bool = true;
        }
        QLog.d("AIOEmotionFragment", 2, new Object[] { "mGallery setSelection pos:", Integer.valueOf(i), " dataIsNull:", Boolean.valueOf(bool) });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.8
 * JD-Core Version:    0.7.0.1
 */
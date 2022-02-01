package com.tencent.mobileqq.emotionintegrate;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AIOEmotionFragment$11
  implements Runnable
{
  AIOEmotionFragment$11(AIOEmotionFragment paramAIOEmotionFragment, List paramList, EmoticonPreviewData paramEmoticonPreviewData) {}
  
  public void run()
  {
    boolean bool = false;
    this.this$0.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.this$0.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData != null) {}
    for (int i = this.this$0.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData);; i = 0)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSelection(i);
      if (QLog.isColorLevel())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData == null) {
          bool = true;
        }
        QLog.d("AIOEmotionFragment", 2, new Object[] { "mGallery setSelection pos:", Integer.valueOf(i), " dataIsNull:", Boolean.valueOf(bool) });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.11
 * JD-Core Version:    0.7.0.1
 */
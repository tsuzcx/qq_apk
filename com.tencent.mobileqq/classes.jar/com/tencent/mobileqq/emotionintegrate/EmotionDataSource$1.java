package com.tencent.mobileqq.emotionintegrate;

import java.util.List;

class EmotionDataSource$1
  implements Runnable
{
  EmotionDataSource$1(EmotionDataSource paramEmotionDataSource, boolean paramBoolean, EmotionDataSource.DataLoadListener paramDataLoadListener, EmoticonPreviewData paramEmoticonPreviewData) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource$DataLoadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource$DataLoadListener.a(localList, this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDataSource.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.search.fragment;

import akiz;
import com.tencent.qphone.base.util.QLog;

class HotWordsForSubBussFragment$1$1
  implements Runnable
{
  HotWordsForSubBussFragment$1$1(HotWordsForSubBussFragment.1 param1, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ArrayOfByte != null)
    {
      QLog.d(HotWordsForSubBussFragment.jdField_a_of_type_JavaLangString, 1, "use cache!");
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment$1.this$0.jdField_a_of_type_Akiz.a(null, 1000, this.jdField_a_of_type_ArrayOfByte);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment$1.a) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(HotWordsForSubBussFragment.jdField_a_of_type_JavaLangString, 2, "hot word list cache is null！");
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment$1.this$0.jdField_a_of_type_Akiz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.1.1
 * JD-Core Version:    0.7.0.1
 */
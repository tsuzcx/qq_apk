package com.tencent.mobileqq.search.fragment;

import akix;
import com.tencent.qphone.base.util.QLog;

class HotWordsForSubBussFragment$2$1
  implements Runnable
{
  HotWordsForSubBussFragment$2$1(HotWordsForSubBussFragment.2 param2, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ArrayOfByte != null)
    {
      QLog.d(HotWordsForSubBussFragment.jdField_a_of_type_JavaLangString, 1, "UnifySearchHandler use cache!");
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment$2.this$0.jdField_a_of_type_Akix.a(null, 1000, this.jdField_a_of_type_ArrayOfByte);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment$2.a) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(HotWordsForSubBussFragment.jdField_a_of_type_JavaLangString, 2, "UnifySearchHandler hot word list cache is null！");
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment$2.this$0.jdField_a_of_type_Akix.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.2.1
 * JD-Core Version:    0.7.0.1
 */
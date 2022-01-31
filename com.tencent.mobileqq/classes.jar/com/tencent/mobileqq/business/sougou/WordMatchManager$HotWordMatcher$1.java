package com.tencent.mobileqq.business.sougou;

import anyo;
import anyp;
import java.lang.ref.WeakReference;

class WordMatchManager$HotWordMatcher$1
  implements Runnable
{
  WordMatchManager$HotWordMatcher$1(WordMatchManager.HotWordMatcher paramHotWordMatcher, WordMatchManager.HotWordItem[] paramArrayOfHotWordItem) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.a != null) && (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.a.a != null))
    {
      anyo localanyo = (anyo)this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.a.a.get();
      if (localanyo != null) {
        localanyo.a(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.a.b, this.jdField_a_of_type_ArrayOfComTencentMobileqqBusinessSougouWordMatchManager$HotWordItem);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.dispatchNextTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordMatcher.1
 * JD-Core Version:    0.7.0.1
 */
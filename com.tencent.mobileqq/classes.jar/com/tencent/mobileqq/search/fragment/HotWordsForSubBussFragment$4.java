package com.tencent.mobileqq.search.fragment;

import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class HotWordsForSubBussFragment$4
  extends UniteSearchObserver
{
  HotWordsForSubBussFragment$4(HotWordsForSubBussFragment paramHotWordsForSubBussFragment) {}
  
  public void handleBusiHotWordError(int paramInt, String paramString)
  {
    super.handleBusiHotWordError(paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.w(HotWordsForSubBussFragment.jdField_a_of_type_JavaLangString, 2, "handleBusiHotWordError code=" + paramInt + " errorMsg;" + paramString);
    }
  }
  
  public void handleBusiHotWordResult(int paramInt, List<BusinessGroupWord> paramList)
  {
    HotWordsForSubBussFragment.jdField_a_of_type_Int = paramInt;
    HotWordsForSubBussFragment.a(this.a, paramList);
    if (QLog.isColorLevel()) {
      QLog.i(HotWordsForSubBussFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchResult expireTime;" + HotWordsForSubBussFragment.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.search.fragment;

import com.tencent.mobileqq.app.UnifySearchObserver;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class HotWordsForSubBussFragment$3
  extends UnifySearchObserver
{
  HotWordsForSubBussFragment$3(HotWordsForSubBussFragment paramHotWordsForSubBussFragment) {}
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.w(HotWordsForSubBussFragment.jdField_a_of_type_JavaLangString, 2, "unify handleBusiHotWordError code=" + paramInt + " errorMsg;" + paramString);
    }
  }
  
  public void a(int paramInt, List<BusinessGroupWord> paramList)
  {
    HotWordsForSubBussFragment.jdField_a_of_type_Int = paramInt;
    HotWordsForSubBussFragment.a(this.a, paramList);
    if (QLog.isColorLevel()) {
      QLog.i(HotWordsForSubBussFragment.jdField_a_of_type_JavaLangString, 2, "unify handleTabSearchResult expireTime;" + HotWordsForSubBussFragment.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.3
 * JD-Core Version:    0.7.0.1
 */
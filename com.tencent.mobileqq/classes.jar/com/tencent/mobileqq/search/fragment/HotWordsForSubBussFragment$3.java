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
    if (QLog.isColorLevel())
    {
      String str = HotWordsForSubBussFragment.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unify handleBusiHotWordError code=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" errorMsg;");
      localStringBuilder.append(paramString);
      QLog.w(str, 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt, List<BusinessGroupWord> paramList)
  {
    HotWordsForSubBussFragment.jdField_a_of_type_Int = paramInt;
    HotWordsForSubBussFragment.a(this.a, paramList);
    if (QLog.isColorLevel())
    {
      paramList = HotWordsForSubBussFragment.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unify handleTabSearchResult expireTime;");
      localStringBuilder.append(HotWordsForSubBussFragment.jdField_a_of_type_Int);
      QLog.i(paramList, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.3
 * JD-Core Version:    0.7.0.1
 */
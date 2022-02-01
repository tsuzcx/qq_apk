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
    if (QLog.isColorLevel())
    {
      String str = HotWordsForSubBussFragment.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleBusiHotWordError code=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" errorMsg;");
      localStringBuilder.append(paramString);
      QLog.w(str, 2, localStringBuilder.toString());
    }
  }
  
  public void handleBusiHotWordResult(int paramInt, List<BusinessGroupWord> paramList)
  {
    HotWordsForSubBussFragment.i = paramInt;
    HotWordsForSubBussFragment.a(this.a, paramList);
    if (QLog.isColorLevel())
    {
      paramList = HotWordsForSubBussFragment.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleTabSearchResult expireTime;");
      localStringBuilder.append(HotWordsForSubBussFragment.i);
      QLog.i(paramList, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.4
 * JD-Core Version:    0.7.0.1
 */
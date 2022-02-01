package com.tencent.mobileqq.search.util;

import aoha;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.qphone.base.util.QLog;

public final class SearchUtils$1
  implements Runnable
{
  public SearchUtils$1(String paramString1, int paramInt, String paramString2, String paramString3, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchUtils", 2, "saveSearchHistory, displayName:" + this.jdField_a_of_type_JavaLangString);
    }
    SearchHistory localSearchHistory = new SearchHistory();
    localSearchHistory.type = this.jdField_a_of_type_Int;
    localSearchHistory.uin = this.b;
    localSearchHistory.troopUin = this.c;
    localSearchHistory.displayName = this.jdField_a_of_type_JavaLangString;
    aoha localaoha = (aoha)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    if (localaoha == null) {
      return;
    }
    localaoha.a(localSearchHistory);
    com.tencent.mobileqq.search.activity.UniteSearchActivity.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchUtils.1
 * JD-Core Version:    0.7.0.1
 */
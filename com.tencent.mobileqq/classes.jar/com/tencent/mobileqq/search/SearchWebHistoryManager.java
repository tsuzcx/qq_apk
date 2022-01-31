package com.tencent.mobileqq.search;

import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class SearchWebHistoryManager
  implements Manager
{
  int jdField_a_of_type_Int = -1;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public SearchWebHistoryManager(QQAppInterface paramQQAppInterface) {}
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchWebHistoryManager
 * JD-Core Version:    0.7.0.1
 */
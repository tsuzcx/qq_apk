package com.tencent.mobileqq.search;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class SearchWebHistoryManager
  implements Manager
{
  public static final String a;
  public static final String b = HardCodeUtil.a(2131713596);
  public static final String c = HardCodeUtil.a(2131713595);
  public static final String d = HardCodeUtil.a(2131713598);
  int jdField_a_of_type_Int = -1;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713597);
  }
  
  public SearchWebHistoryManager(QQAppInterface paramQQAppInterface) {}
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchWebHistoryManager
 * JD-Core Version:    0.7.0.1
 */
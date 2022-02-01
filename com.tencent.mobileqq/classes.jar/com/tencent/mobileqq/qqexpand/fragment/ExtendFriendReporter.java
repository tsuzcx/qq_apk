package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;

public class ExtendFriendReporter
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final List<String> jdField_a_of_type_JavaUtilList = new ArrayList(20);
  
  public ExtendFriendReporter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      b();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    if (this.jdField_a_of_type_JavaUtilList.size() >= 20) {
      b();
    }
  }
  
  void b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (i != 0) {
        localStringBuffer.append("|");
      }
      localStringBuffer.append((String)this.jdField_a_of_type_JavaUtilList.get(i));
      i += 1;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009324", "0X8009324", 0, 0, "", "", localStringBuffer.toString(), "");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendReporter
 * JD-Core Version:    0.7.0.1
 */
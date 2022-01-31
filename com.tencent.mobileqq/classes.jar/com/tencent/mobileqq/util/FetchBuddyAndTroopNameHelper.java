package com.tencent.mobileqq.util;

import ajlw;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FetchBuddyAndTroopNameHelper
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FetchInfoListManager jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager;
  
  public FetchBuddyAndTroopNameHelper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private FetchInfoListManager a()
  {
    FetchInfoListManager localFetchInfoListManager = new FetchInfoListManager(new ajlw(this));
    if (QLog.isColorLevel()) {
      QLog.i("FetchInfoListManager", 2, "createFetchInfoListManager fm: " + localFetchInfoListManager);
    }
    return localFetchInfoListManager;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager.a();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager = a();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager.a(2, paramString, null, null, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager = a();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager.a(3, paramString1, paramString2, paramString3, paramBundle);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager = a();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager.a(1, paramString, null, null, null);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager = a();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager.a(4, paramString, null, null, null);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager = a();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager.a(5, paramString, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper
 * JD-Core Version:    0.7.0.1
 */
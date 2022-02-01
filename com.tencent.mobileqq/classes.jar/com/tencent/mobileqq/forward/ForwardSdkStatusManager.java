package com.tencent.mobileqq.forward;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.Manager;

public class ForwardSdkStatusManager
  implements Manager
{
  private ForwardD55Manager jdField_a_of_type_ComTencentMobileqqForwardForwardD55Manager;
  private Map<String, Map<String, Object>> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public ForwardSdkStatusManager()
  {
    QLog.d("SDK_SHARE.ForwardSdkStatusManager", 1, "--> init");
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardD55Manager = new ForwardD55Manager();
  }
  
  public ForwardD55Manager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqForwardForwardD55Manager;
  }
  
  public Map<String, Object> a(String paramString)
  {
    return (Map)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public void a(String paramString, Map<String, Object> paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramMap);
  }
  
  public void onDestroy()
  {
    QLog.d("SDK_SHARE.ForwardSdkStatusManager", 1, "--> onDestroy");
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardD55Manager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkStatusManager
 * JD-Core Version:    0.7.0.1
 */
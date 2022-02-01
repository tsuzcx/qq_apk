package com.tencent.mobileqq.forward;

import java.util.HashMap;
import java.util.Map;

public class ForwardImageDownUpMgr
{
  private static ForwardImageDownUpMgr jdField_a_of_type_ComTencentMobileqqForwardForwardImageDownUpMgr;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static ForwardImageDownUpMgr a()
  {
    if (jdField_a_of_type_ComTencentMobileqqForwardForwardImageDownUpMgr == null) {
      jdField_a_of_type_ComTencentMobileqqForwardForwardImageDownUpMgr = new ForwardImageDownUpMgr();
    }
    return jdField_a_of_type_ComTencentMobileqqForwardForwardImageDownUpMgr;
  }
  
  public static String a(String paramString)
  {
    ForwardImageDownUpMgr localForwardImageDownUpMgr = jdField_a_of_type_ComTencentMobileqqForwardForwardImageDownUpMgr;
    if (localForwardImageDownUpMgr == null) {
      return null;
    }
    paramString = (String)localForwardImageDownUpMgr.jdField_a_of_type_JavaUtilMap.remove(paramString);
    if (jdField_a_of_type_ComTencentMobileqqForwardForwardImageDownUpMgr.jdField_a_of_type_JavaUtilMap.isEmpty()) {
      jdField_a_of_type_ComTencentMobileqqForwardForwardImageDownUpMgr = null;
    }
    return paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardImageDownUpMgr
 * JD-Core Version:    0.7.0.1
 */
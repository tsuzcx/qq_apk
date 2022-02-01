package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class FaceDetectForThirdPartyManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<Integer, FaceDetectForThirdPartyManager.AppConf> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public FaceDetectForThirdPartyManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(1);
  }
  
  public void a(int paramInt, FaceDetectForThirdPartyManager.AppConf paramAppConf)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramAppConf);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager
 * JD-Core Version:    0.7.0.1
 */
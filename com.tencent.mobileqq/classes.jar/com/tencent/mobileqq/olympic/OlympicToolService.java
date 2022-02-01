package com.tencent.mobileqq.olympic;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.Cmd2HandlerMap;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Random;
import mqq.app.MSFServlet;

public class OlympicToolService
  extends MobileQQServiceBase
{
  OlympicToolAppInterface jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface;
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  
  OlympicToolService(OlympicToolAppInterface paramOlympicToolAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OlympicToolService", 2, "new OlympicToolService");
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface = paramOlympicToolAppInterface;
    seq = Math.abs(this.jdField_a_of_type_JavaUtilRandom.nextInt());
  }
  
  public AppInterface getAppInterface()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface;
  }
  
  public Map<String, String[]> getCompatibleCmd2HandlerMap()
  {
    return Cmd2HandlerMap.a();
  }
  
  public Class<? extends MSFServlet> getServlet()
  {
    return OlympicToolServlet.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicToolService
 * JD-Core Version:    0.7.0.1
 */
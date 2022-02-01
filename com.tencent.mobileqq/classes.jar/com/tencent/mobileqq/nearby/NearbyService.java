package com.tencent.mobileqq.nearby;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.Cmd2HandlerMap;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.lbs.NearbyProtocolCoder;
import java.util.Map;
import java.util.Random;
import mqq.app.MSFServlet;

public class NearbyService
  extends MobileQQServiceBase
{
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  
  NearbyService(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
    seq = Math.abs(this.jdField_a_of_type_JavaUtilRandom.nextInt());
  }
  
  public AppInterface getAppInterface()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  }
  
  public Map<String, String[]> getCompatibleCmd2HandlerMap()
  {
    return Cmd2HandlerMap.a();
  }
  
  public Class<? extends MSFServlet> getServlet()
  {
    return NearbyServlet.class;
  }
  
  public void initCoders()
  {
    try
    {
      super.addCoder(new NearbyProtocolCoder(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface));
      super.setCodersInit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyService
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.nearby;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.lbs.NearbyProtocolCoder;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Random;

public class NearbyService
  extends MobileQQServiceBase
{
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  
  NearbyService(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
    jdField_a_of_type_Int = Math.abs(this.jdField_a_of_type_JavaUtilRandom.nextInt());
  }
  
  public AppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  }
  
  protected void a()
  {
    try
    {
      super.a();
      super.a(new NearbyProtocolCoder(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface));
      super.d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    super.b(paramToServiceMsg, null, NearbyServlet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyService
 * JD-Core Version:    0.7.0.1
 */
package cooperation.weiyun.sdk.download.processor;

import amry;
import amrz;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.OldHttpEngine;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorFlowCount;

public class WeiyunNetEngine
{
  private static INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private static IHttpCommunicatorFlowCount jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount = new amry();
  private static INetEngine jdField_b_of_type_ComTencentMobileqqTransfileINetEngine;
  private static IHttpCommunicatorFlowCount jdField_b_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount = new amrz();
  
  public static INetEngine a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null)
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount, 128);
        localHttpCommunicator.a();
        jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = new OldHttpEngine(localHttpCommunicator, true);
      }
      return jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
    }
    finally {}
  }
  
  public static INetEngine b()
  {
    if (jdField_b_of_type_ComTencentMobileqqTransfileINetEngine == null) {}
    try
    {
      if (jdField_b_of_type_ComTencentMobileqqTransfileINetEngine == null)
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(jdField_b_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount, 128);
        localHttpCommunicator.a();
        jdField_b_of_type_ComTencentMobileqqTransfileINetEngine = new OldHttpEngine(localHttpCommunicator, true);
      }
      return jdField_b_of_type_ComTencentMobileqqTransfileINetEngine;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.sdk.download.processor.WeiyunNetEngine
 * JD-Core Version:    0.7.0.1
 */
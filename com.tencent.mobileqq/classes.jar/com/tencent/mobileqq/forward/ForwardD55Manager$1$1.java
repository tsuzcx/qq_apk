package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.activity.aio.ForwardUtils;
import tencent.im.oidb.oidb_0xd55.RspBody;

class ForwardD55Manager$1$1
  implements Runnable
{
  ForwardD55Manager$1$1(ForwardD55Manager.1 param1, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    AppInfo localAppInfo = new AppInfo();
    oidb_0xd55.RspBody localRspBody = ForwardUtils.a(this.jdField_a_of_type_ArrayOfByte);
    if (localRspBody != null) {
      AppInfo.a(localRspBody, this.jdField_a_of_type_ComTencentMobileqqForwardForwardD55Manager$1.jdField_a_of_type_JavaLangString, localAppInfo);
    }
    ForwardD55Manager.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardD55Manager$1.jdField_a_of_type_ComTencentMobileqqForwardForwardD55Manager, this.jdField_a_of_type_Int);
    ForwardD55Manager.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardD55Manager$1.jdField_a_of_type_ComTencentMobileqqForwardForwardD55Manager, localAppInfo);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardD55Manager$1.jdField_a_of_type_ComTencentMobileqqForwardForwardD55Manager.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardD55Manager$1.jdField_a_of_type_Long, localAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardD55Manager.1.1
 * JD-Core Version:    0.7.0.1
 */
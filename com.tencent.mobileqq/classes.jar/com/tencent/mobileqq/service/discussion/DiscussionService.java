package com.tencent.mobileqq.service.discussion;

import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class DiscussionService
  extends BaseProtocolCoder
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "QQServiceDiscussSvc" };
  private DiscussionReceiver jdField_a_of_type_ComTencentMobileqqServiceDiscussionDiscussionReceiver = new DiscussionReceiver();
  private DiscussionSender jdField_a_of_type_ComTencentMobileqqServiceDiscussionDiscussionSender = new DiscussionSender();
  
  public String[] cmdHeaderPrefix()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.jdField_a_of_type_ComTencentMobileqqServiceDiscussionDiscussionReceiver.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void decodeRespMsg(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.jdField_a_of_type_ComTencentMobileqqServiceDiscussionDiscussionSender.a(paramToServiceMsg, paramUniPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.discussion.DiscussionService
 * JD-Core Version:    0.7.0.1
 */
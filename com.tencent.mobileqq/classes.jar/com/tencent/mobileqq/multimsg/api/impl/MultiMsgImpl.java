package com.tencent.mobileqq.multimsg.api.impl;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.api.IMultiMsg;
import com.tencent.mobileqq.multimsg.api.MultiMsgBean;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import mqq.app.MobileQQ;

public class MultiMsgImpl
  implements IMultiMsg
{
  public MultiMsgBean getMultiMsgValue()
  {
    SessionInfo localSessionInfo = MultiMsgManager.a().a();
    MultiMsgBean localMultiMsgBean = new MultiMsgBean();
    localMultiMsgBean.jdField_a_of_type_Boolean = MessageRecordInfo.a(MultiMsgManager.a().b());
    if (localSessionInfo != null)
    {
      localMultiMsgBean.jdField_a_of_type_JavaLangObject = localSessionInfo;
      localMultiMsgBean.jdField_a_of_type_JavaLangString = localSessionInfo.jdField_a_of_type_JavaLangString;
      localMultiMsgBean.jdField_a_of_type_Int = localSessionInfo.jdField_a_of_type_Int;
    }
    return localMultiMsgBean;
  }
  
  public String getPicDefaultPath()
  {
    return MultiMsgManager.a((QQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime());
  }
  
  public long getPicDefaultSize()
  {
    return MultiMsgManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.api.impl.MultiMsgImpl
 * JD-Core Version:    0.7.0.1
 */
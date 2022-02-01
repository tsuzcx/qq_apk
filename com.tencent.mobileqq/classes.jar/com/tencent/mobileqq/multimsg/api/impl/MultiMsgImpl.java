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
    SessionInfo localSessionInfo = MultiMsgManager.a().d();
    MultiMsgBean localMultiMsgBean = new MultiMsgBean();
    localMultiMsgBean.a = MessageRecordInfo.b(MultiMsgManager.a().e());
    if (localSessionInfo != null)
    {
      localMultiMsgBean.d = localSessionInfo;
      localMultiMsgBean.c = localSessionInfo.b;
      localMultiMsgBean.b = localSessionInfo.a;
    }
    return localMultiMsgBean;
  }
  
  public String getPicDefaultPath()
  {
    return MultiMsgManager.b((QQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime());
  }
  
  public long getPicDefaultSize()
  {
    return MultiMsgManager.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.api.impl.MultiMsgImpl
 * JD-Core Version:    0.7.0.1
 */
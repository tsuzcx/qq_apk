package com.tencent.mobileqq.extendfriend.ipc;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.limitchat.LimitChatUtil;

class ExpandFlutterIPCServer$3
  implements BusinessObserver
{
  ExpandFlutterIPCServer$3(ExpandFlutterIPCServer paramExpandFlutterIPCServer, AppInterface paramAppInterface, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null)) {
      LimitChatUtil.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, 1044, true, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCServer.3
 * JD-Core Version:    0.7.0.1
 */
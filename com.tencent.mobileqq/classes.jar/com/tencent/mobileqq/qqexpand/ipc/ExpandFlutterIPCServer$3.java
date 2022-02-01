package com.tencent.mobileqq.qqexpand.ipc;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCServer.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.qqexpand.ipc;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;

class ExpandFlutterIPCServer$5
  implements BusinessObserver
{
  ExpandFlutterIPCServer$5(ExpandFlutterIPCServer paramExpandFlutterIPCServer, AppInterface paramAppInterface, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null)) {
      LimitChatUtil.a((QQAppInterface)this.a, this.b, 1044, true, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCServer.5
 * JD-Core Version:    0.7.0.1
 */
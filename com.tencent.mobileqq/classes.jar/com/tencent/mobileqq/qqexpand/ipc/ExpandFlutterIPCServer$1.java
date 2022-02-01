package com.tencent.mobileqq.qqexpand.ipc;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ExpandFlutterIPCServer$1
  extends ExpandObserver
{
  ExpandFlutterIPCServer$1(ExpandFlutterIPCServer paramExpandFlutterIPCServer) {}
  
  protected void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateRedPoint ");
      localStringBuilder.append(paramInt);
      QLog.e("expand.ipc.ExpandFlutterIPCServer", 2, localStringBuilder.toString());
    }
    ThreadManager.getSubThreadHandler().post(new ExpandFlutterIPCServer.1.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCServer.1
 * JD-Core Version:    0.7.0.1
 */
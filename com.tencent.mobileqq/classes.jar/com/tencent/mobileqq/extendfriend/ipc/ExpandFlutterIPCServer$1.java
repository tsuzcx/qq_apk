package com.tencent.mobileqq.extendfriend.ipc;

import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.qphone.base.util.QLog;

class ExpandFlutterIPCServer$1
  extends ExtendFriendObserver
{
  ExpandFlutterIPCServer$1(ExpandFlutterIPCServer paramExpandFlutterIPCServer) {}
  
  public void onUpdateRedPoint(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("expand.ipc.ExpandFlutterIPCServer", 2, "onUpdateRedPoint " + paramInt);
    }
    this.a.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCServer.1
 * JD-Core Version:    0.7.0.1
 */
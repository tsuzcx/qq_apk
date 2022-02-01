package com.tencent.mobileqq.qqexpand.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class ExpandFlutterIPCServer$25
  extends ExpandObserver
{
  ExpandFlutterIPCServer$25(ExpandFlutterIPCServer paramExpandFlutterIPCServer, QQAppInterface paramQQAppInterface, int paramInt) {}
  
  protected void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetUnLimitBaseInfo suc:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("expand.ipc.ExpandFlutterIPCServer", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("data", paramBoolean);
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.data = ((Bundle)localObject);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandIpcExpandFlutterIPCServer.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCServer.25
 * JD-Core Version:    0.7.0.1
 */
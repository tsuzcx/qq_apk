package com.tencent.mobileqq.qqexpand.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class ExpandFlutterIPCServer$3
  extends ExpandObserver
{
  ExpandFlutterIPCServer$3(ExpandFlutterIPCServer paramExpandFlutterIPCServer, int paramInt) {}
  
  protected void a(boolean paramBoolean, Object paramObject, int paramInt)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, new Object[] { "[getExpandUserInfo] onPreLoadDataForAvatarProfileCard. isSuccess = ", Boolean.valueOf(paramBoolean), " data = ", paramObject, " type = ", Integer.valueOf(paramInt) });
    }
    Bundle localBundle = new Bundle();
    if (paramObject != null) {
      localBundle.putString("data", paramObject.toString());
    }
    paramObject = new EIPCResult();
    paramObject.data = localBundle;
    if (paramBoolean) {
      paramInt = i;
    } else {
      paramInt = -102;
    }
    paramObject.code = paramInt;
    this.b.callbackResult(this.a, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCServer.3
 * JD-Core Version:    0.7.0.1
 */
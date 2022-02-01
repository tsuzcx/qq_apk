package com.tencent.mobileqq.mini.launch;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.qphone.base.util.QLog;

final class MiniSdkLauncher$3
  extends ResultReceiver
{
  MiniSdkLauncher$3(Handler paramHandler, IMiniCallback paramIMiniCallback)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    Object localObject = this.val$miniCallback;
    if (localObject != null)
    {
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((IMiniCallback)localObject).onCallbackResult(bool, paramBundle);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("resultCode=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" resultData=");
    ((StringBuilder)localObject).append(paramBundle);
    QLog.d("MiniSdkLauncher", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.MiniSdkLauncher.3
 * JD-Core Version:    0.7.0.1
 */
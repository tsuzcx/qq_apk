package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class ForwardSdkBaseOption$6
  extends Handler
{
  ForwardSdkBaseOption$6(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      QQToast.a(this.a.a, HardCodeUtil.a(2131704831), 0).a();
    }
    while (1 != paramMessage.what) {
      return;
    }
    this.a.a.setResult(-1);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.6
 * JD-Core Version:    0.7.0.1
 */
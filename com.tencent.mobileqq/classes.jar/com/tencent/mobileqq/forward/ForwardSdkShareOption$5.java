package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class ForwardSdkShareOption$5
  extends Handler
{
  ForwardSdkShareOption$5(ForwardSdkShareOption paramForwardSdkShareOption) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      QQToast.a(this.a.a, HardCodeUtil.a(2131704918), 0).a();
      return;
    }
    if (1 == paramMessage.what)
    {
      this.a.a.setResult(-1);
      this.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class ForwardSdkShareOption$6
  implements Runnable
{
  ForwardSdkShareOption$6(ForwardSdkShareOption paramForwardSdkShareOption) {}
  
  public void run()
  {
    if (this.this$0.s.isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--fetch openid timeout");
    }
    ForwardSdkShareOption localForwardSdkShareOption = this.this$0;
    localForwardSdkShareOption.ah = true;
    localForwardSdkShareOption.ae();
    if (ForwardSdkShareOption.b(this.this$0))
    {
      this.this$0.t.putString("uin", "-1010");
      this.this$0.t.putInt("uintype", -1);
      this.this$0.t.putInt("key_forward_ability_type", ForwardAbility.ForwardAbilityType.f.intValue());
      this.this$0.I();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.6
 * JD-Core Version:    0.7.0.1
 */
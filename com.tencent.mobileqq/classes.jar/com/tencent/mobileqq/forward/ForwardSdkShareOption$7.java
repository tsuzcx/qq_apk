package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;

class ForwardSdkShareOption$7
  extends ProtoUtils.TroopProtocolObserver
{
  ForwardSdkShareOption$7(ForwardSdkShareOption paramForwardSdkShareOption) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (!this.a.s.isFinishing())
    {
      if (this.a.ah) {
        return;
      }
      this.a.ae();
      if (this.a.ag != null) {
        this.a.ag.removeCallbacksAndMessages(null);
      }
      if (paramInt == 16)
      {
        this.a.aG();
        return;
      }
      if (ForwardSdkShareOption.b(this.a))
      {
        this.a.t.putString("uin", "-1010");
        this.a.t.putInt("uintype", -1);
        this.a.t.putInt("key_forward_ability_type", ForwardAbility.ForwardAbilityType.f.intValue());
        this.a.I();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.7
 * JD-Core Version:    0.7.0.1
 */
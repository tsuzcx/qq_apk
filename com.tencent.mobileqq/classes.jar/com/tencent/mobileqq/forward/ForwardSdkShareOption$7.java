package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;

class ForwardSdkShareOption$7
  extends ProtoUtils.TroopProtocolObserver
{
  ForwardSdkShareOption$7(ForwardSdkShareOption paramForwardSdkShareOption) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((this.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (this.a.k)) {}
    do
    {
      return;
      this.a.z();
      if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
        this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if (paramInt == 16)
      {
        this.a.N();
        return;
      }
    } while (!ForwardSdkShareOption.a(this.a));
    this.a.jdField_a_of_type_AndroidOsBundle.putString("uin", String.valueOf("-1010"));
    this.a.jdField_a_of_type_AndroidOsBundle.putInt("uintype", -1);
    this.a.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", ForwardAbility.ForwardAbilityType.e.intValue());
    this.a.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.7
 * JD-Core Version:    0.7.0.1
 */
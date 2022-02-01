package com.tencent.mobileqq.kandian.biz.atlas;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.qphone.base.util.QLog;

class ReadInJoySettingActivity$TroopProtocolObserver
  extends ProtoUtils.TroopProtocolObserver
{
  private boolean b;
  
  ReadInJoySettingActivity$TroopProtocolObserver(ReadInJoySettingActivity paramReadInJoySettingActivity, boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {
      ReadInJoyUserInfoModule.a(RIJQQAppInterfaceUtil.d(), this.b);
    } else {
      QLog.d("ReadInJoySettingActivity", 1, "troopProtocolObserver fail!");
    }
    ReadInJoySettingActivity.m(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.TroopProtocolObserver
 * JD-Core Version:    0.7.0.1
 */
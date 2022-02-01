package com.tencent.mobileqq.kandian.biz.atlas;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.qphone.base.util.QLog;

class ReadInJoySettingActivity$TroopProtocolObserver
  extends ProtoUtils.TroopProtocolObserver
{
  private boolean jdField_a_of_type_Boolean;
  
  ReadInJoySettingActivity$TroopProtocolObserver(ReadInJoySettingActivity paramReadInJoySettingActivity, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {
      ReadInJoyUserInfoModule.a(RIJQQAppInterfaceUtil.a(), this.jdField_a_of_type_Boolean);
    } else {
      QLog.d("ReadInJoySettingActivity", 1, "troopProtocolObserver fail!");
    }
    ReadInJoySettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoySettingActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity.TroopProtocolObserver
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.trooppiceffects;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopPicEffectsEditActivity$UploadPicCallback$1
  extends ProtoUtils.TroopProtocolObserver
{
  TroopPicEffectsEditActivity$UploadPicCallback$1(TroopPicEffectsEditActivity.UploadPicCallback paramUploadPicCallback, TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("payForPhoto. onResult. errorCode=");
      paramArrayOfByte.append(paramInt);
      QLog.d("TroopPicEffectsEditActivity", 2, paramArrayOfByte.toString());
    }
    if (paramInt == 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity, 2, HardCodeUtil.a(2131715480), 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity, 1, HardCodeUtil.a(2131715487), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity.UploadPicCallback.1
 * JD-Core Version:    0.7.0.1
 */
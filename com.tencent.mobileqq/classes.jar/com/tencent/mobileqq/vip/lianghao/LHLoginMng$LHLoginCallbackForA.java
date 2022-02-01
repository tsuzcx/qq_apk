package com.tencent.mobileqq.vip.lianghao;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import mqq.observer.AccountObserver;

class LHLoginMng$LHLoginCallbackForA
  extends AccountObserver
{
  final Intent jdField_a_of_type_AndroidContentIntent;
  final LHLoginMng.OnLockLHUinResult jdField_a_of_type_ComTencentMobileqqVipLianghaoLHLoginMng$OnLockLHUinResult;
  final String jdField_a_of_type_JavaLangString;
  
  LHLoginMng$LHLoginCallbackForA(Intent paramIntent, String paramString, LHLoginMng.OnLockLHUinResult paramOnLockLHUinResult)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoLHLoginMng$OnLockLHUinResult = paramOnLockLHUinResult;
  }
  
  public void onRegisterCommitPassRespWithLhSig(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentIntent);
    if (paramArrayOfByte2 != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte2 = new String(paramArrayOfByte2, "utf-8");
        if (QLog.isDevelopLevel()) {
          QLog.i("LHLoginMng", 4, String.format(Locale.getDefault(), "onRegisterCommitPassRespWithLhSig isSuccess: %s, code: %s, uin: %s, error: %s, contactSig: %s, lhsig: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString, paramArrayOfByte2, MD5.toMD5(paramArrayOfByte1), MD5.toMD5(paramArrayOfByte3) }));
        }
        if (paramInt != 0) {
          break label308;
        }
        paramBoolean = true;
        if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_JavaLangString))) {
          break label280;
        }
        paramBoolean = false;
        if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0)) {
          break label295;
        }
        paramBoolean = false;
        if (!TextUtils.isEmpty(paramArrayOfByte2)) {
          break label313;
        }
        paramString = HardCodeUtil.a(2131716956);
        localIntent.putExtra("key_register_prompt_info", paramString);
        if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0)) {
          localIntent.putExtra("key_register_lhsig", paramArrayOfByte3);
        }
        if (QLog.isDevelopLevel()) {
          RegisterLHAssistant.a("LHLoginMng -- onRegisterCommitPassRespWithLhSig", localIntent);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoLHLoginMng$OnLockLHUinResult != null) {
          this.jdField_a_of_type_ComTencentMobileqqVipLianghaoLHLoginMng$OnLockLHUinResult.a(localIntent, paramBoolean, this.jdField_a_of_type_JavaLangString, paramArrayOfByte3, paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.i("LHLoginMng", 2, String.format(Locale.getDefault(), "onRegisterCommitPassRespWithLhSig, lhUin: %s, isSuc: %s, error: %s, code: %s", new Object[] { this.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) }));
        }
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte2)
      {
        paramArrayOfByte2.printStackTrace();
      }
      paramArrayOfByte2 = null;
      continue;
      label280:
      localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      continue;
      label295:
      localIntent.putExtra("key_register_sign", paramArrayOfByte1);
      continue;
      label308:
      paramBoolean = false;
      continue;
      label313:
      paramString = paramArrayOfByte2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.LHLoginMng.LHLoginCallbackForA
 * JD-Core Version:    0.7.0.1
 */
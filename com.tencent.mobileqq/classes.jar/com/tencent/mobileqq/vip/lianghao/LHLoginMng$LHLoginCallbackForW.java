package com.tencent.mobileqq.vip.lianghao;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import mqq.observer.WtloginObserver;

class LHLoginMng$LHLoginCallbackForW
  extends WtloginObserver
{
  final Intent jdField_a_of_type_AndroidContentIntent;
  final LHLoginMng.OnLockLHUinResult jdField_a_of_type_ComTencentMobileqqVipLianghaoLHLoginMng$OnLockLHUinResult;
  final String jdField_a_of_type_JavaLangString;
  
  LHLoginMng$LHLoginCallbackForW(Intent paramIntent, String paramString, LHLoginMng.OnLockLHUinResult paramOnLockLHUinResult)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoLHLoginMng$OnLockLHUinResult = paramOnLockLHUinResult;
  }
  
  public void onRegGetSMSVerifyLoginAccountWithLhSig(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentIntent);
    if (paramArrayOfByte3 != null) {}
    label292:
    label307:
    label320:
    label326:
    for (;;)
    {
      try
      {
        paramArrayOfByte1 = new String(paramArrayOfByte3, "utf-8");
        if (QLog.isDevelopLevel()) {
          QLog.i("LHLoginMng", 4, String.format(Locale.getDefault(), "OnRegGetSMSVerifyLoginAccountWithLhSig ret: %s, uin: %s, error: %s, contactssig: %s, lhsig: %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), paramArrayOfByte1, MD5.toMD5(paramArrayOfByte2), MD5.toMD5(paramArrayOfByte4) }));
        }
        if (paramInt != 0) {
          break label320;
        }
        bool = true;
        paramArrayOfByte3 = String.valueOf(paramLong);
        if ((!TextUtils.isEmpty(paramArrayOfByte3)) && (paramArrayOfByte3.equals(this.jdField_a_of_type_JavaLangString))) {
          break label292;
        }
        bool = false;
        if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0)) {
          break label307;
        }
        bool = false;
        if (!TextUtils.isEmpty(paramArrayOfByte1)) {
          break label326;
        }
        paramArrayOfByte1 = HardCodeUtil.a(2131716956);
        localIntent.putExtra("key_register_prompt_info", paramArrayOfByte1);
        if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0)) {
          localIntent.putExtra("key_register_lhsig", paramArrayOfByte4);
        }
        if (QLog.isDevelopLevel()) {
          RegisterLHAssistant.a("LHLoginMng -- OnRegGetSMSVerifyLoginAccountWithLhSig", localIntent);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoLHLoginMng$OnLockLHUinResult != null) {
          this.jdField_a_of_type_ComTencentMobileqqVipLianghaoLHLoginMng$OnLockLHUinResult.a(localIntent, bool, this.jdField_a_of_type_JavaLangString, paramArrayOfByte4, paramArrayOfByte1);
        }
        if (QLog.isColorLevel()) {
          QLog.i("LHLoginMng", 2, String.format(Locale.getDefault(), "OnRegGetSMSVerifyLoginAccountWithLhSig, lhUin: %s, isSuc: %s, error: %s, ret: %s", new Object[] { this.jdField_a_of_type_JavaLangString, Boolean.valueOf(bool), paramArrayOfByte1, Integer.valueOf(paramInt) }));
        }
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte1)
      {
        paramArrayOfByte1.printStackTrace();
      }
      paramArrayOfByte1 = null;
      continue;
      localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      continue;
      localIntent.putExtra("key_register_sign", paramArrayOfByte2);
      continue;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.LHLoginMng.LHLoginCallbackForW
 * JD-Core Version:    0.7.0.1
 */
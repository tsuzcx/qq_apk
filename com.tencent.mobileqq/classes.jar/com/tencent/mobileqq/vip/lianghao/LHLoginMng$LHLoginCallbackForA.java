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
  final Intent a;
  final String b;
  final LHLoginMng.OnLockLHUinResult c;
  
  LHLoginMng$LHLoginCallbackForA(Intent paramIntent, String paramString, LHLoginMng.OnLockLHUinResult paramOnLockLHUinResult)
  {
    this.a = paramIntent;
    this.b = paramString;
    this.c = paramOnLockLHUinResult;
  }
  
  public void onRegisterCommitPassRespWithLhSig(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    Intent localIntent = new Intent(this.a);
    if (paramArrayOfByte2 != null) {
      try
      {
        paramArrayOfByte2 = new String(paramArrayOfByte2, "utf-8");
      }
      catch (UnsupportedEncodingException paramArrayOfByte2)
      {
        paramArrayOfByte2.printStackTrace();
      }
    } else {
      paramArrayOfByte2 = null;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LHLoginMng", 4, String.format(Locale.getDefault(), "onRegisterCommitPassRespWithLhSig isSuccess: %s, code: %s, uin: %s, error: %s, contactSig: %s, lhsig: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString, paramArrayOfByte2, MD5.toMD5(paramArrayOfByte1), MD5.toMD5(paramArrayOfByte3) }));
    }
    if (paramInt == 0)
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.b)))
      {
        localIntent.putExtra("uin", this.b);
        paramBoolean = true;
      }
      else
      {
        paramBoolean = false;
      }
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0))
      {
        localIntent.putExtra("key_register_sign", paramArrayOfByte1);
        break label181;
      }
    }
    paramBoolean = false;
    label181:
    if (TextUtils.isEmpty(paramArrayOfByte2)) {
      paramString = HardCodeUtil.a(2131914072);
    } else {
      paramString = paramArrayOfByte2;
    }
    localIntent.putExtra("key_register_prompt_info", paramString);
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0)) {
      localIntent.putExtra("key_register_lhsig", paramArrayOfByte3);
    }
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a("LHLoginMng -- onRegisterCommitPassRespWithLhSig", localIntent);
    }
    paramArrayOfByte1 = this.c;
    if (paramArrayOfByte1 != null) {
      paramArrayOfByte1.a(localIntent, paramBoolean, this.b, paramArrayOfByte3, paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.i("LHLoginMng", 2, String.format(Locale.getDefault(), "onRegisterCommitPassRespWithLhSig, lhUin: %s, isSuc: %s, error: %s, code: %s", new Object[] { this.b, Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.LHLoginMng.LHLoginCallbackForA
 * JD-Core Version:    0.7.0.1
 */
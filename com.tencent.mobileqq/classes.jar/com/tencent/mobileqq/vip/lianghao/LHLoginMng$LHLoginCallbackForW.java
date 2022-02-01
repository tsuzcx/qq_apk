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
  final Intent a;
  final String b;
  final LHLoginMng.OnLockLHUinResult c;
  
  LHLoginMng$LHLoginCallbackForW(Intent paramIntent, String paramString, LHLoginMng.OnLockLHUinResult paramOnLockLHUinResult)
  {
    this.a = paramIntent;
    this.b = paramString;
    this.c = paramOnLockLHUinResult;
  }
  
  public void onRegGetSMSVerifyLoginAccountWithLhSig(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    Intent localIntent = new Intent(this.a);
    if (paramArrayOfByte3 != null) {
      try
      {
        paramArrayOfByte1 = new String(paramArrayOfByte3, "utf-8");
      }
      catch (UnsupportedEncodingException paramArrayOfByte1)
      {
        paramArrayOfByte1.printStackTrace();
      }
    } else {
      paramArrayOfByte1 = null;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LHLoginMng", 4, String.format(Locale.getDefault(), "OnRegGetSMSVerifyLoginAccountWithLhSig ret: %s, uin: %s, error: %s, contactssig: %s, lhsig: %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), paramArrayOfByte1, MD5.toMD5(paramArrayOfByte2), MD5.toMD5(paramArrayOfByte4) }));
    }
    if (paramInt == 0)
    {
      paramArrayOfByte3 = String.valueOf(paramLong);
      if ((!TextUtils.isEmpty(paramArrayOfByte3)) && (paramArrayOfByte3.equals(this.b)))
      {
        localIntent.putExtra("uin", this.b);
        bool = true;
      }
      else
      {
        bool = false;
      }
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0))
      {
        localIntent.putExtra("key_register_sign", paramArrayOfByte2);
        break label187;
      }
    }
    boolean bool = false;
    label187:
    if (TextUtils.isEmpty(paramArrayOfByte1)) {
      paramArrayOfByte1 = HardCodeUtil.a(2131914072);
    }
    localIntent.putExtra("key_register_prompt_info", paramArrayOfByte1);
    if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0)) {
      localIntent.putExtra("key_register_lhsig", paramArrayOfByte4);
    }
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a("LHLoginMng -- OnRegGetSMSVerifyLoginAccountWithLhSig", localIntent);
    }
    paramArrayOfByte2 = this.c;
    if (paramArrayOfByte2 != null) {
      paramArrayOfByte2.a(localIntent, bool, this.b, paramArrayOfByte4, paramArrayOfByte1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("LHLoginMng", 2, String.format(Locale.getDefault(), "OnRegGetSMSVerifyLoginAccountWithLhSig, lhUin: %s, isSuc: %s, error: %s, ret: %s", new Object[] { this.b, Boolean.valueOf(bool), paramArrayOfByte1, Integer.valueOf(paramInt) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.LHLoginMng.LHLoginCallbackForW
 * JD-Core Version:    0.7.0.1
 */
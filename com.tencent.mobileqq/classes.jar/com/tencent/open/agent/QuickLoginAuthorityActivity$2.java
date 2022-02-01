package com.tencent.open.agent;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

class QuickLoginAuthorityActivity$2
  extends WtloginObserver
{
  QuickLoginAuthorityActivity$2(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void onException(String paramString, int paramInt)
  {
    super.onException(paramString, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mGetAppIdWTLoginObserver.OnException() e:");
    localStringBuilder.append(paramString);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, localStringBuilder.toString());
  }
  
  public void onVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList<String> paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    paramString = new StringBuilder();
    paramString.append("mGetAppIdWTLoginObserver.OnVerifyCode(): ret=");
    paramString.append(paramInt);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, paramString.toString());
    if (paramInt == 0)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
        paramInt = 0;
      }
      while (paramInt < paramArrayList.size())
      {
        try
        {
          paramString = HexUtil.hexStr2Bytes((String)paramArrayList.get(paramInt));
          int i = util.buf_to_int16(paramString, 0);
          int j = util.buf_to_int16(paramString, 2);
          if (i == 54)
          {
            paramArrayOfByte1 = new byte[j];
            System.arraycopy(paramString, 4, paramArrayOfByte1, 0, j);
            paramString = new String(paramArrayOfByte1);
            paramArrayOfByte1 = new StringBuilder();
            paramArrayOfByte1.append("mGetAppIdWTLoginObserver.OnVerifyCode(): getAppid sucess Json:");
            paramArrayOfByte1.append(paramString);
            QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, paramArrayOfByte1.toString());
            paramString = new JSONObject(paramString);
            paramLong = paramString.optLong("open_appid");
            paramString = paramString.optString("comefrom");
            this.a.a(paramLong, paramString);
            if (!TextUtils.isEmpty(paramString))
            {
              paramArrayOfByte1 = Message.obtain();
              paramArrayOfByte1.what = 1004;
              paramArrayOfByte1.obj = paramString;
              this.a.b.sendMessage(paramArrayOfByte1);
            }
          }
        }
        catch (Throwable paramString)
        {
          QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "mGetAppIdWTLoginObserver.OnVerifyCode(): Exeption:", paramString);
        }
        paramInt += 1;
        continue;
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "mGetAppIdWTLoginObserver.OnVerifyCode(): getAppid failed for data is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.IEnterAudioChannelCallback;
import com.tencent.mobileqq.qqguildsdk.data.IEnterChannleInfoResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class GProFuncTest$13
  implements IEnterAudioChannelCallback
{
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult, IEnterChannleInfoResult paramIEnterChannleInfoResult)
  {
    paramIGProSecurityResult = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errCode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", trtcSig:");
    localStringBuilder.append(paramIEnterChannleInfoResult.a());
    localStringBuilder.append(", pKey:");
    localStringBuilder.append(paramIEnterChannleInfoResult.b());
    QLog.d(paramIGProSecurityResult, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.13
 * JD-Core Version:    0.7.0.1
 */
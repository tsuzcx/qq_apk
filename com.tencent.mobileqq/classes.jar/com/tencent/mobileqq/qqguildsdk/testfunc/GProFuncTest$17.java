package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.IKickChannelMemberCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProResultInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GProFuncTest$17
  implements IKickChannelMemberCallback
{
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult, List<IGProResultInfo> paramList)
  {
    paramList = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errCode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", secActionCode:");
    if (paramIGProSecurityResult != null) {
      paramString = Long.valueOf(paramIGProSecurityResult.a());
    } else {
      paramString = "null";
    }
    localStringBuilder.append(paramString);
    QLog.d(paramList, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.17
 * JD-Core Version:    0.7.0.1
 */
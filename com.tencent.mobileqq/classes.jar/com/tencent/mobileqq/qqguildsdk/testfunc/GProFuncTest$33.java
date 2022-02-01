package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;

class GProFuncTest$33
  implements ISetChannelMsgNotifyTypeCallback
{
  public void a(int paramInt, IGProChannelInfo paramIGProChannelInfo, String paramString)
  {
    String str = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errCode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    QLog.d(str, 2, localStringBuilder.toString());
    GProFuncTest.a(this.a, paramIGProChannelInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.33
 * JD-Core Version:    0.7.0.1
 */